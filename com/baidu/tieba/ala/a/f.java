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
    private SimpleDraweeView fDm;
    private View fDn;
    private g fDo;
    private Runnable fDp;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fDk = null;
    private h fDl = null;
    private boolean fDq = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fDo = null;
        this.fDo = gVar;
        eD(context);
    }

    private void eD(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fDm = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fDm.setController(com.facebook.drawee.a.a.c.dDm().Rt("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").xd(true).dEd());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fDn = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fDo.detach();
                if (f.this.fDl != null) {
                    f.this.fDo.a(f.this.fDl);
                }
                if (!f.this.fDq && f.this.fDp != null) {
                    f.this.fDp.run();
                }
                f.this.ku(f.this.fDq);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fDn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.byE();
            }
        });
        byF();
    }

    protected void ku(boolean z) {
        It();
    }

    public f c(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void byE() {
    }

    public f s(Runnable runnable) {
        this.fDk = runnable;
        return this;
    }

    public f t(Runnable runnable) {
        this.fDp = runnable;
        return this;
    }

    public f byF() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fDo.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fDo.a(this);
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
        It();
    }

    private void complete() {
        this.fDq = true;
        dismiss();
        if (this.fDk != null) {
            this.fDk.run();
        }
        if (this.fDl != null) {
            this.fDl.a(this.fDo);
        }
    }

    private void aCo() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fDl != null) {
            this.fDl.b(this.fDo);
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
        aCo();
    }

    public void It() {
        Animatable dDS;
        if (this.fDm != null && this.fDm.getController() != null && (dDS = this.fDm.getController().dDS()) != null && dDS.isRunning()) {
            dDS.stop();
        }
    }
}
