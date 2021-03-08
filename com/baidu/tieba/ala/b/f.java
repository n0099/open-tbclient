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
/* loaded from: classes9.dex */
public class f implements h {
    private SimpleDraweeView gOc;
    private View gOd;
    private g gOe;
    private Runnable gOf;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gOa = null;
    private h gOb = null;
    private boolean gOg = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gOe = null;
        this.gOe = gVar;
        fU(context);
    }

    private void fU(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gOc = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gOc.setController(com.facebook.drawee.a.a.c.etF().ZG("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").Bk(true).euw());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gOd = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gOe.detach();
                if (f.this.gOb != null) {
                    f.this.gOe.a(f.this.gOb);
                }
                if (!f.this.gOg && f.this.gOf != null) {
                    f.this.gOf.run();
                }
                f.this.mR(f.this.gOg);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gOd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bTk();
            }
        });
        bTl();
    }

    protected void mR(boolean z) {
        Ui();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bTk() {
    }

    public f l(Runnable runnable) {
        this.gOa = runnable;
        return this;
    }

    public f m(Runnable runnable) {
        this.gOf = runnable;
        return this;
    }

    public f bTl() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gOe.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gOe.a(this);
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
        Ui();
    }

    private void complete() {
        this.gOg = true;
        dismiss();
        if (this.gOa != null) {
            this.gOa.run();
        }
        if (this.gOb != null) {
            this.gOb.a(this.gOe);
        }
    }

    private void aUe() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gOb != null) {
            this.gOb.b(this.gOe);
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
        aUe();
    }

    public void Ui() {
        Animatable eul;
        if (this.gOc != null && this.gOc.getController() != null && (eul = this.gOc.getController().eul()) != null && eul.isRunning()) {
            eul.stop();
        }
    }
}
