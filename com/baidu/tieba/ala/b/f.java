package com.baidu.tieba.ala.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Animatable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.baidu.tieba.ala.b.i;
import com.facebook.drawee.view.SimpleDraweeView;
@TargetApi(17)
/* loaded from: classes10.dex */
public class f implements h {
    private SimpleDraweeView gMf;
    private View gMg;
    private g gMh;
    private Runnable gMi;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gMd = null;
    private h gMe = null;
    private boolean gMj = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gMh = null;
        this.gMh = gVar;
        fV(context);
    }

    private void fV(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gMf = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gMf.setController(com.facebook.drawee.a.a.c.eto().Zo("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").Bm(true).euf());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gMg = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gMh.detach();
                if (f.this.gMe != null) {
                    f.this.gMh.a(f.this.gMe);
                }
                if (!f.this.gMj && f.this.gMi != null) {
                    f.this.gMi.run();
                }
                f.this.mR(f.this.gMj);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gMg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bSX();
            }
        });
        bSY();
    }

    protected void mR(boolean z) {
        Uf();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bSX() {
    }

    public f m(Runnable runnable) {
        this.gMd = runnable;
        return this;
    }

    public f n(Runnable runnable) {
        this.gMi = runnable;
        return this;
    }

    public f bSY() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gMh.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gMh.a(this);
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
        Uf();
    }

    private void complete() {
        this.gMj = true;
        dismiss();
        if (this.gMd != null) {
            this.gMd.run();
        }
        if (this.gMe != null) {
            this.gMe.a(this.gMh);
        }
    }

    private void aUb() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gMe != null) {
            this.gMe.b(this.gMh);
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
        aUb();
    }

    public void Uf() {
        Animatable etU;
        if (this.gMf != null && this.gMf.getController() != null && (etU = this.gMf.getController().etU()) != null && etU.isRunning()) {
            etU.stop();
        }
    }
}
