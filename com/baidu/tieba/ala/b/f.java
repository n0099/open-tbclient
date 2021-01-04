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
    private SimpleDraweeView gOf;
    private View gOg;
    private g gOh;
    private Runnable gOi;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gOd = null;
    private h gOe = null;
    private boolean gOj = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gOh = null;
        this.gOh = gVar;
        fY(context);
    }

    private void fY(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gOf = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gOf.setController(com.facebook.drawee.a.a.c.euI().Zv("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").AX(true).evz());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gOg = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gOh.detach();
                if (f.this.gOe != null) {
                    f.this.gOh.a(f.this.gOe);
                }
                if (!f.this.gOj && f.this.gOi != null) {
                    f.this.gOi.run();
                }
                f.this.mR(f.this.gOj);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gOg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bWl();
            }
        });
        bWm();
    }

    protected void mR(boolean z) {
        Wq();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bWl() {
    }

    public f o(Runnable runnable) {
        this.gOd = runnable;
        return this;
    }

    public f p(Runnable runnable) {
        this.gOi = runnable;
        return this;
    }

    public f bWm() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gOh.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gOh.a(this);
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
        Wq();
    }

    private void complete() {
        this.gOj = true;
        dismiss();
        if (this.gOd != null) {
            this.gOd.run();
        }
        if (this.gOe != null) {
            this.gOe.a(this.gOh);
        }
    }

    private void aXI() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gOe != null) {
            this.gOe.b(this.gOh);
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
        aXI();
    }

    public void Wq() {
        Animatable evo;
        if (this.gOf != null && this.gOf.getController() != null && (evo = this.gOf.getController().evo()) != null && evo.isRunning()) {
            evo.stop();
        }
    }
}
