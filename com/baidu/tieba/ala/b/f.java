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
    private SimpleDraweeView gMt;
    private View gMu;
    private g gMv;
    private Runnable gMw;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitle;
    private Runnable gMr = null;
    private h gMs = null;
    private boolean gMx = false;
    private String mName = "直播";
    private DialogInterface.OnDismissListener mOnDismissListener = null;

    public static f a(Context context, @NonNull g gVar) {
        return new f(context, gVar);
    }

    public f(Context context, @NonNull g gVar) {
        this.gMv = null;
        this.gMv = gVar;
        fV(context);
    }

    private void fV(Context context) {
        this.mContext = context;
        this.mDialog = new Dialog(this.mContext, i.d.SoLoaderDialogStyle);
        this.mDialog.setContentView(i.b.dialog_soloader);
        this.gMt = (SimpleDraweeView) this.mDialog.findViewById(i.a.soloader_loading_anim);
        this.gMt.setController(com.facebook.drawee.a.a.c.etw().ZA("https://pic.rmb.bdstatic.com/qmpic_InRooc_1563447539.webp").Bm(true).eun());
        this.mTitle = (TextView) this.mDialog.findViewById(i.a.soloader_title);
        this.gMu = this.mDialog.findViewById(i.a.soloader_hide);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.f.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                f.this.gMv.detach();
                if (f.this.gMs != null) {
                    f.this.gMv.a(f.this.gMs);
                }
                if (!f.this.gMx && f.this.gMw != null) {
                    f.this.gMw.run();
                }
                f.this.mR(f.this.gMx);
                if (f.this.mOnDismissListener != null) {
                    f.this.mOnDismissListener.onDismiss(dialogInterface);
                }
            }
        });
        this.gMu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.b.f.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                f.this.dismiss();
                f.this.bTe();
            }
        });
        bTf();
    }

    protected void mR(boolean z) {
        Uf();
    }

    public f e(DialogInterface.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
        return this;
    }

    protected void bTe() {
    }

    public f m(Runnable runnable) {
        this.gMr = runnable;
        return this;
    }

    public f n(Runnable runnable) {
        this.gMw = runnable;
        return this;
    }

    public f bTf() {
        this.mTitle.setText(String.format("%s加载%s%%…", this.mName, Integer.valueOf((int) (this.gMv.getProgress() * 100.0f))));
        return this;
    }

    public void show() {
        if (this.mContext instanceof Activity) {
            Activity activity = (Activity) this.mContext;
            if (activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
        }
        this.gMv.a(this);
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
        this.gMx = true;
        dismiss();
        if (this.gMr != null) {
            this.gMr.run();
        }
        if (this.gMs != null) {
            this.gMs.a(this.gMv);
        }
    }

    private void aUb() {
        dismiss();
        Toast.makeText(this.mContext, i.c.soloader_failed, 0).show();
        if (this.gMs != null) {
            this.gMs.b(this.gMv);
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
        Animatable euc;
        if (this.gMt != null && this.gMt.getController() != null && (euc = this.gMt.getController().euc()) != null && euc.isRunning()) {
            euc.stop();
        }
    }
}
