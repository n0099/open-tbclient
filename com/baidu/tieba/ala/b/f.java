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
    private SimpleDraweeView gek;
    private View gel;
    private g gem;
    private Runnable gen;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gei = null;
    private h gej = null;
    private boolean gep = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gem = null;
        this.gem = gVar;
        eY(context);
    }

    private void eY(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gek = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gek.setController(com.facebook.drawee.a.a.c.dXf().VN("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").yM(true).dXW());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gel = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gem.detach();
                if (f.this.gej != null) {
                    f.this.gem.a(f.this.gej);
                }
                if (!f.this.gep && f.this.gen != null) {
                    f.this.gen.run();
                }
                f.this.lu(f.this.gep);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gel.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bLA();
            }
        });
        bLB();
    }

    protected void lu(boolean z) {
        PU();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bLA() {
    }

    public f p(Runnable runnable) {
        this.gei = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gen = runnable;
        return this;
    }

    public f bLB() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gem.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gem.a(this);
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
        PU();
    }

    private void complete() {
        this.gep = true;
        dismiss();
        if (this.gei != null) {
            this.gei.run();
        }
        if (this.gej != null) {
            this.gej.a(this.gem);
        }
    }

    private void aOx() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gej != null) {
            this.gej.b(this.gem);
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
        aOx();
    }

    public void PU() {
        Animatable dXL;
        if (this.gek != null && this.gek.getController() != null && (dXL = this.gek.getController().dXL()) != null && dXL.isRunning()) {
            dXL.stop();
        }
    }
}
