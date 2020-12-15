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
    private SimpleDraweeView gCt;
    private View gCu;
    private g gCv;
    private Runnable gCw;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gCr = null;
    private h gCs = null;
    private boolean gCx = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gCv = null;
        this.gCv = gVar;
        fF(context);
    }

    private void fF(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gCt = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gCt.setController(com.facebook.drawee.a.a.c.eqG().Zk("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").AP(true).erx());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gCu = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gCv.detach();
                if (f.this.gCs != null) {
                    f.this.gCv.a(f.this.gCs);
                }
                if (!f.this.gCx && f.this.gCw != null) {
                    f.this.gCw.run();
                }
                f.this.mr(f.this.gCx);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gCu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bTG();
            }
        });
        bTH();
    }

    protected void mr(boolean z) {
        Vo();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bTG() {
    }

    public f p(Runnable runnable) {
        this.gCr = runnable;
        return this;
    }

    public f q(Runnable runnable) {
        this.gCw = runnable;
        return this;
    }

    public f bTH() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gCv.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gCv.a(this);
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
        this.gCx = true;
        dismiss();
        if (this.gCr != null) {
            this.gCr.run();
        }
        if (this.gCs != null) {
            this.gCs.a(this.gCv);
        }
    }

    private void aVo() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gCs != null) {
            this.gCs.b(this.gCv);
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
        Animatable erm;
        if (this.gCt != null && this.gCt.getController() != null && (erm = this.gCt.getController().erm()) != null && erm.isRunning()) {
            erm.stop();
        }
    }
}
