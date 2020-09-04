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
/* loaded from: classes4.dex */
public class f implements h {
    private SimpleDraweeView fOH;
    private View fOI;
    private g fOJ;
    private Runnable fOK;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fOF = null;
    private h fOG = null;
    private boolean fOL = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fOJ = null;
        this.fOJ = gVar;
        eL(context);
    }

    private void eL(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fOH = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fOH.setController(com.facebook.drawee.a.a.c.dPw().Ux("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").xW(true).dQn());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fOI = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fOJ.detach();
                if (f.this.fOG != null) {
                    f.this.fOJ.a(f.this.fOG);
                }
                if (!f.this.fOL && f.this.fOK != null) {
                    f.this.fOK.run();
                }
                f.this.kU(f.this.fOL);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fOI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bHI();
            }
        });
        bHJ();
    }

    protected void kU(boolean z) {
        Om();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bHI() {
    }

    public f p(Runnable runnable) {
        this.fOF = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.fOK = runnable;
        return this;
    }

    public f bHJ() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fOJ.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fOJ.a(this);
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
        Om();
    }

    private void complete() {
        this.fOL = true;
        dismiss();
        if (this.fOF != null) {
            this.fOF.run();
        }
        if (this.fOG != null) {
            this.fOG.a(this.fOJ);
        }
    }

    private void aLd() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fOG != null) {
            this.fOG.b(this.fOJ);
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
        aLd();
    }

    public void Om() {
        Animatable dQc;
        if (this.fOH != null && this.fOH.getController() != null && (dQc = this.fOH.getController().dQc()) != null && dQc.isRunning()) {
            dQc.stop();
        }
    }
}
