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
    private SimpleDraweeView goo;
    private View gop;
    private g goq;
    private Runnable gor;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gom = null;
    private h gon = null;
    private boolean gos = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.goq = null;
        this.goq = gVar;
        eZ(context);
    }

    private void eZ(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.goo = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.goo.setController(com.facebook.drawee.a.a.c.ehd().XA("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").zU(true).ehU());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gop = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.goq.detach();
                if (f.this.gon != null) {
                    f.this.goq.a(f.this.gon);
                }
                if (!f.this.gos && f.this.gor != null) {
                    f.this.gor.run();
                }
                f.this.lM(f.this.gos);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gop.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bOc();
            }
        });
        bOd();
    }

    protected void lM(boolean z) {
        QP();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bOc() {
    }

    public f p(Runnable runnable) {
        this.gom = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gor = runnable;
        return this;
    }

    public f bOd() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.goq.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.goq.a(this);
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
        QP();
    }

    private void complete() {
        this.gos = true;
        dismiss();
        if (this.gom != null) {
            this.gom.run();
        }
        if (this.gon != null) {
            this.gon.a(this.goq);
        }
    }

    private void aQr() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gon != null) {
            this.gon.b(this.goq);
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
        aQr();
    }

    public void QP() {
        Animatable ehJ;
        if (this.goo != null && this.goo.getController() != null && (ehJ = this.goo.getController().ehJ()) != null && ehJ.isRunning()) {
            ehJ.stop();
        }
    }
}
