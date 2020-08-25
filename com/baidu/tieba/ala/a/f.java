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
    private SimpleDraweeView fOD;
    private View fOE;
    private g fOF;
    private Runnable fOG;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fOB = null;
    private h fOC = null;
    private boolean fOH = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fOF = null;
        this.fOF = gVar;
        eL(context);
    }

    private void eL(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fOD = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fOD.setController(com.facebook.drawee.a.a.c.dPn().Ux("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").xU(true).dQe());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fOE = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fOF.detach();
                if (f.this.fOC != null) {
                    f.this.fOF.a(f.this.fOC);
                }
                if (!f.this.fOH && f.this.fOG != null) {
                    f.this.fOG.run();
                }
                f.this.kS(f.this.fOH);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fOE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bHH();
            }
        });
        bHI();
    }

    protected void kS(boolean z) {
        Om();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bHH() {
    }

    public f p(Runnable runnable) {
        this.fOB = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.fOG = runnable;
        return this;
    }

    public f bHI() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fOF.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fOF.a(this);
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
        this.fOH = true;
        dismiss();
        if (this.fOB != null) {
            this.fOB.run();
        }
        if (this.fOC != null) {
            this.fOC.a(this.fOF);
        }
    }

    private void aLd() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fOC != null) {
            this.fOC.b(this.fOF);
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
        Animatable dPT;
        if (this.fOD != null && this.fOD.getController() != null && (dPT = this.fOD.getController().dPT()) != null && dPT.isRunning()) {
            dPT.stop();
        }
    }
}
