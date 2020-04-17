package com.baidu.tieba.ala.e;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public TextView fpa;
    public TextView fpb;
    public TextView fpc;
    private Context mContext;
    private AlertDialog mDialog;
    Handler handler = new Handler();
    CustomMessageListener azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.e.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                a.this.dismiss();
            }
        }
    };
    private Runnable fpd = new Runnable() { // from class: com.baidu.tieba.ala.e.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    private View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(a.h.ala_level_up_dialog, (ViewGroup) null);
    public ImageView foZ = (ImageView) this.mRootView.findViewById(a.g.close_img);

    public a(Context context) {
        this.mContext = context;
        this.foZ.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fpa = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLevel);
        this.fpb = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipNum);
        this.fpc = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLebel);
    }

    private void bpL() {
        MessageManager.getInstance().registerListener(this.azu);
    }

    public void w(String str, String str2, boolean z) {
        this.fpc.setVisibility(z ? 0 : 8);
        this.fpa.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_level, str2));
        this.fpb.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_flower_num, str));
    }

    public void show() {
        this.mDialog = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.e.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageManager.getInstance().unRegisterListener(a.this.azu);
            }
        });
        if (this.mContext instanceof Activity) {
            ShowUtil.showDialog(this.mDialog, (Activity) this.mContext);
            this.handler.postDelayed(this.fpd, 5000L);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.setContentView(this.mRootView);
        }
        bpL();
    }

    public void dismiss() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.fpd);
        }
        if (this.mDialog != null && (this.mContext instanceof Activity)) {
            ShowUtil.dismissDialog(this.mDialog, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.g.close_img || view == this.mRootView) {
            dismiss();
        }
    }
}
