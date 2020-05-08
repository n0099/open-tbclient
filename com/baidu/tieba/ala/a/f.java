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
    private SimpleDraweeView eZW;
    private View eZX;
    private g eZY;
    private Runnable eZZ;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable eZU = null;
    private h eZV = null;
    private boolean faa = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.eZY = null;
        this.eZY = gVar;
        ei(context);
    }

    private void ei(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.eZW = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.eZW.setController(com.facebook.drawee.a.a.c.dnM().Og("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").vC(true).doD());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.eZX = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.eZY.detach();
                if (f.this.eZV != null) {
                    f.this.eZY.a(f.this.eZV);
                }
                if (!f.this.faa && f.this.eZZ != null) {
                    f.this.eZZ.run();
                }
                f.this.jk(f.this.faa);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.eZX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bmZ();
            }
        });
        bna();
    }

    protected void jk(boolean z) {
        Fj();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bmZ() {
    }

    public f r(Runnable runnable) {
        this.eZU = runnable;
        return this;
    }

    public f s(Runnable runnable) {
        this.eZZ = runnable;
        return this;
    }

    public f bna() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.eZY.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.eZY.a(this);
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
        Fj();
    }

    private void complete() {
        this.faa = true;
        dismiss();
        if (this.eZU != null) {
            this.eZU.run();
        }
        if (this.eZV != null) {
            this.eZV.a(this.eZY);
        }
    }

    private void atQ() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.eZV != null) {
            this.eZV.b(this.eZY);
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
        atQ();
    }

    public void Fj() {
        Animatable dos;
        if (this.eZW != null && this.eZW.getController() != null && (dos = this.eZW.getController().dos()) != null && dos.isRunning()) {
            dos.stop();
        }
    }
}
