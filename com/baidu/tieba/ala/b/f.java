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
    private View gJA;
    private g gJB;
    private Runnable gJC;
    private SimpleDraweeView gJz;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gJx = null;
    private h gJy = null;
    private boolean gJD = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gJB = null;
        this.gJB = gVar;
        fW(context);
    }

    private void fW(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gJz = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gJz.setController(com.facebook.drawee.a.a.c.eqV().Ym("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").AT(true).erN());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gJA = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gJB.detach();
                if (f.this.gJy != null) {
                    f.this.gJB.a(f.this.gJy);
                }
                if (!f.this.gJD && f.this.gJC != null) {
                    f.this.gJC.run();
                }
                f.this.mN(f.this.gJD);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gJA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bSu();
            }
        });
        bSv();
    }

    protected void mN(boolean z) {
        Sy();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bSu() {
    }

    public f o(Runnable runnable) {
        this.gJx = runnable;
        return this;
    }

    public f p(Runnable runnable) {
        this.gJC = runnable;
        return this;
    }

    public f bSv() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gJB.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gJB.a(this);
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
        Sy();
    }

    private void complete() {
        this.gJD = true;
        dismiss();
        if (this.gJx != null) {
            this.gJx.run();
        }
        if (this.gJy != null) {
            this.gJy.a(this.gJB);
        }
    }

    private void aTP() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gJy != null) {
            this.gJy.b(this.gJB);
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
        aTP();
    }

    public void Sy() {
        Animatable erC;
        if (this.gJz != null && this.gJz.getController() != null && (erC = this.gJz.getController().erC()) != null && erC.isRunning()) {
            erC.stop();
        }
    }
}
