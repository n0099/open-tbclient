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
    private SimpleDraweeView gtI;
    private View gtJ;
    private g gtK;
    private Runnable gtL;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gtG = null;
    private h gtH = null;
    private boolean gtM = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gtK = null;
        this.gtK = gVar;
        eZ(context);
    }

    private void eZ(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gtI = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gtI.setController(com.facebook.drawee.a.a.c.ekQ().XP("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").Am(true).elH());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gtJ = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gtK.detach();
                if (f.this.gtH != null) {
                    f.this.gtK.a(f.this.gtH);
                }
                if (!f.this.gtM && f.this.gtL != null) {
                    f.this.gtL.run();
                }
                f.this.lW(f.this.gtM);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gtJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bPV();
            }
        });
        bPW();
    }

    protected void lW(boolean z) {
        SO();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bPV() {
    }

    public f p(Runnable runnable) {
        this.gtG = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gtL = runnable;
        return this;
    }

    public f bPW() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gtK.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gtK.a(this);
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
        SO();
    }

    private void complete() {
        this.gtM = true;
        dismiss();
        if (this.gtG != null) {
            this.gtG.run();
        }
        if (this.gtH != null) {
            this.gtH.a(this.gtK);
        }
    }

    private void aSj() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gtH != null) {
            this.gtH.b(this.gtK);
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
        aSj();
    }

    public void SO() {
        Animatable elw;
        if (this.gtI != null && this.gtI.getController() != null && (elw = this.gtI.getController().elw()) != null && elw.isRunning()) {
            elw.stop();
        }
    }
}
