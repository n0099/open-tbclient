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
    private SimpleDraweeView gub;
    private View guc;
    private g gud;
    private Runnable gue;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gtZ = null;
    private h gua = null;
    private boolean guf = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gud = null;
        this.gud = gVar;
        eZ(context);
    }

    private void eZ(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gub = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gub.setController(com.facebook.drawee.a.a.c.ekS().Ye("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").Af(true).elJ());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.guc = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gud.detach();
                if (f.this.gua != null) {
                    f.this.gud.a(f.this.gua);
                }
                if (!f.this.guf && f.this.gue != null) {
                    f.this.gue.run();
                }
                f.this.lV(f.this.guf);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.guc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bQC();
            }
        });
        bQD();
    }

    protected void lV(boolean z) {
        Tx();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bQC() {
    }

    public f p(Runnable runnable) {
        this.gtZ = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gue = runnable;
        return this;
    }

    public f bQD() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gud.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gud.a(this);
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
        Tx();
    }

    private void complete() {
        this.guf = true;
        dismiss();
        if (this.gtZ != null) {
            this.gtZ.run();
        }
        if (this.gua != null) {
            this.gua.a(this.gud);
        }
    }

    private void aSR() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gua != null) {
            this.gua.b(this.gud);
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
        aSR();
    }

    public void Tx() {
        Animatable ely;
        if (this.gub != null && this.gub.getController() != null && (ely = this.gub.getController().ely()) != null && ely.isRunning()) {
            ely.stop();
        }
    }
}
