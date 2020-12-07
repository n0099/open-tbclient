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
    private SimpleDraweeView gCr;
    private View gCs;
    private g gCt;
    private Runnable gCu;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gCp = null;
    private h gCq = null;
    private boolean gCv = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gCt = null;
        this.gCt = gVar;
        fF(context);
    }

    private void fF(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gCr = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gCr.setController(com.facebook.drawee.a.a.c.eqF().Zk("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").AP(true).erw());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gCs = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gCt.detach();
                if (f.this.gCq != null) {
                    f.this.gCt.a(f.this.gCq);
                }
                if (!f.this.gCv && f.this.gCu != null) {
                    f.this.gCu.run();
                }
                f.this.mr(f.this.gCv);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gCs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bTF();
            }
        });
        bTG();
    }

    protected void mr(boolean z) {
        Vo();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bTF() {
    }

    public f p(Runnable runnable) {
        this.gCp = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gCu = runnable;
        return this;
    }

    public f bTG() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gCt.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gCt.a(this);
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
        Vo();
    }

    private void complete() {
        this.gCv = true;
        dismiss();
        if (this.gCp != null) {
            this.gCp.run();
        }
        if (this.gCq != null) {
            this.gCq.a(this.gCt);
        }
    }

    private void aVo() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gCq != null) {
            this.gCq.b(this.gCt);
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
        aVo();
    }

    public void Vo() {
        Animatable erl;
        if (this.gCr != null && this.gCr.getController() != null && (erl = this.gCr.getController().erl()) != null && erl.isRunning()) {
            erl.stop();
        }
    }
}
