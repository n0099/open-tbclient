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
    private SimpleDraweeView fyf;
    private View fyg;
    private g fyh;
    private Runnable fyi;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fyd = null;
    private h fye = null;
    private boolean fyj = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fyh = null;
        this.fyh = gVar;
        ey(context);
    }

    private void ey(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fyf = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fyf.setController(com.facebook.drawee.a.a.c.dzW().QH("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").wy(true).dAN());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fyg = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fyh.detach();
                if (f.this.fye != null) {
                    f.this.fyh.a(f.this.fye);
                }
                if (!f.this.fyj && f.this.fyi != null) {
                    f.this.fyi.run();
                }
                f.this.jQ(f.this.fyj);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fyg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bvu();
            }
        });
        bvv();
    }

    protected void jQ(boolean z) {
        In();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bvu() {
    }

    public f t(Runnable runnable) {
        this.fyd = runnable;
        return this;
    }

    public f u(Runnable runnable) {
        this.fyi = runnable;
        return this;
    }

    public f bvv() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fyh.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fyh.a(this);
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
        In();
    }

    private void complete() {
        this.fyj = true;
        dismiss();
        if (this.fyd != null) {
            this.fyd.run();
        }
        if (this.fye != null) {
            this.fye.a(this.fyh);
        }
    }

    private void ayJ() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fye != null) {
            this.fye.b(this.fyh);
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
        ayJ();
    }

    public void In() {
        Animatable dAC;
        if (this.fyf != null && this.fyf.getController() != null && (dAC = this.fyf.getController().dAC()) != null && dAC.isRunning()) {
            dAC.stop();
        }
    }
}
