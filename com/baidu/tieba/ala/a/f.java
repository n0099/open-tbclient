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
    private SimpleDraweeView fmR;
    private View fmS;
    private g fmT;
    private Runnable fmU;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fmP = null;
    private h fmQ = null;
    private boolean fmV = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fmT = null;
        this.fmT = gVar;
        ex(context);
    }

    private void ex(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fmR = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fmR.setController(com.facebook.drawee.a.a.c.dvt().PV("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").wc(true).dwk());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fmS = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fmT.detach();
                if (f.this.fmQ != null) {
                    f.this.fmT.a(f.this.fmQ);
                }
                if (!f.this.fmV && f.this.fmU != null) {
                    f.this.fmU.run();
                }
                f.this.jD(f.this.fmV);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fmS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bsz();
            }
        });
        bsA();
    }

    protected void jD(boolean z) {
        Ha();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bsz() {
    }

    public f t(Runnable runnable) {
        this.fmP = runnable;
        return this;
    }

    public f u(Runnable runnable) {
        this.fmU = runnable;
        return this;
    }

    public f bsA() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fmT.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fmT.a(this);
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
        Ha();
    }

    private void complete() {
        this.fmV = true;
        dismiss();
        if (this.fmP != null) {
            this.fmP.run();
        }
        if (this.fmQ != null) {
            this.fmQ.a(this.fmT);
        }
    }

    private void axD() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fmQ != null) {
            this.fmQ.b(this.fmT);
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
        axD();
    }

    public void Ha() {
        Animatable dvZ;
        if (this.fmR != null && this.fmR.getController() != null && (dvZ = this.fmR.getController().dvZ()) != null && dvZ.isRunning()) {
            dvZ.stop();
        }
    }
}
