package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tieba.ala.b.i;
import com.facebook.drawee.view.SimpleDraweeView;
@TargetApi(17)
/* loaded from: classes4.dex */
public class f implements h {
    private SimpleDraweeView fRS;
    private View fRT;
    private g fRU;
    private Runnable fRV;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fRQ = null;
    private h fRR = null;
    private boolean fRW = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fRU = null;
        this.fRU = gVar;
        eR(context);
    }

    private void eR(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fRS = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fRS.setController(com.facebook.drawee.a.a.c.dTu().UZ("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").yf(true).dUl());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fRT = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fRU.detach();
                if (f.this.fRR != null) {
                    f.this.fRU.a(f.this.fRR);
                }
                if (!f.this.fRW && f.this.fRV != null) {
                    f.this.fRV.run();
                }
                f.this.kW(f.this.fRW);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fRT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bIQ();
            }
        });
        bIR();
    }

    protected void kW(boolean z) {
        OP();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bIQ() {
    }

    public f p(Runnable runnable) {
        this.fRQ = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.fRV = runnable;
        return this;
    }

    public f bIR() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fRU.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fRU.a(this);
        this.mDialog.show();
    }

    private void setProgress(float f) {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dismiss() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.mDialog.dismiss();
        OP();
    }

    private void complete() {
        this.fRW = true;
        dismiss();
        if (this.fRQ != null) {
            this.fRQ.run();
        }
        if (this.fRR != null) {
            this.fRR.a(this.fRU);
        }
    }

    private void aLO() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fRR != null) {
            this.fRR.b(this.fRU);
        }
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar, float f) {
        setProgress(f);
    }

    @Override // com.baidu.tieba.ala.b.h
    public void a(g gVar) {
        complete();
    }

    @Override // com.baidu.tieba.ala.b.h
    public void b(g gVar) {
        aLO();
    }

    public void OP() {
        Animatable dUa;
        if (this.fRS != null && this.fRS.getController() != null && (dUa = this.fRS.getController().dUa()) != null && dUa.isRunning()) {
            dUa.stop();
        }
    }
}
