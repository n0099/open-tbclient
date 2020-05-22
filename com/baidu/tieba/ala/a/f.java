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
    private SimpleDraweeView fmG;
    private View fmH;
    private g fmI;
    private Runnable fmJ;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable fmE = null;
    private h fmF = null;
    private boolean fmK = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.fmI = null;
        this.fmI = gVar;
        ex(context);
    }

    private void ex(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.fmG = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.fmG.setController(com.facebook.drawee.a.a.c.dvf().PU("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").wa(true).dvW());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.fmH = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.a.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.fmI.detach();
                if (f.this.fmF != null) {
                    f.this.fmI.a(f.this.fmF);
                }
                if (!f.this.fmK && f.this.fmJ != null) {
                    f.this.fmJ.run();
                }
                f.this.jD(f.this.fmK);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.fmH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.a.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bsx();
            }
        });
        bsy();
    }

    protected void jD(boolean z) {
        Ha();
    }

    public f d(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bsx() {
    }

    public f t(Runnable runnable) {
        this.fmE = runnable;
        return this;
    }

    public f u(Runnable runnable) {
        this.fmJ = runnable;
        return this;
    }

    public f bsy() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.fmI.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.fmI.a(this);
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
        Ha();
    }

    private void complete() {
        this.fmK = true;
        dismiss();
        if (this.fmE != null) {
            this.fmE.run();
        }
        if (this.fmF != null) {
            this.fmF.a(this.fmI);
        }
    }

    private void axD() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.fmF != null) {
            this.fmF.b(this.fmI);
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
        axD();
    }

    public void Ha() {
        Animatable dvL;
        if (this.fmG != null && this.fmG.getController() != null && (dvL = this.fmG.getController().dvL()) != null && dvL.isRunning()) {
            dvL.stop();
        }
    }
}
