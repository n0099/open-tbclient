package com.baidu.tieba.ala.a;

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
import com.baidu.tieba.ala.a.i;
import com.facebook.drawee.view.SimpleDraweeView;
@TargetApi(17)
/* loaded from: classes3.dex */
public class f implements h {
    private SimpleDraweeView eZR;
    private View eZS;
    private g eZT;
    private Runnable eZU;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable eZP = null;
    private h eZQ = null;
    private boolean eZV = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.eZT = null;
        this.eZT = gVar;
        eu(context);
    }

    private void eu(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.eZR = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.eZR.setController(com.facebook.drawee.a.a.c.dnP().Od("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").vC(true).doG());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.eZS = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.eZT.detach();
                if (f.this.eZQ != null) {
                    f.this.eZT.a(f.this.eZQ);
                }
                if (!f.this.eZV && f.this.eZU != null) {
                    f.this.eZU.run();
                }
                f.this.jk(f.this.eZV);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.eZS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bnb();
            }
        });
        bnc();
    }

    protected void jk(boolean z) {
        Fk();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bnb() {
    }

    public f r(Runnable runnable) {
        this.eZP = runnable;
        return this;
    }

    public f s(Runnable runnable) {
        this.eZU = runnable;
        return this;
    }

    public f bnc() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.eZT.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.eZT.a(this);
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
        Fk();
    }

    private void complete() {
        this.eZV = true;
        dismiss();
        if (this.eZP != null) {
            this.eZP.run();
        }
        if (this.eZQ != null) {
            this.eZQ.a(this.eZT);
        }
    }

    private void atQ() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.eZQ != null) {
            this.eZQ.b(this.eZT);
        }
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar, float f) {
        setProgress(f);
    }

    @Override // com.baidu.tieba.ala.a.h
    public void a(g gVar) {
        complete();
    }

    @Override // com.baidu.tieba.ala.a.h
    public void b(g gVar) {
        atQ();
    }

    public void Fk() {
        Animatable dov;
        if (this.eZR != null && this.eZR.getController() != null && (dov = this.eZR.getController().dov()) != null && dov.isRunning()) {
            dov.stop();
        }
    }
}
