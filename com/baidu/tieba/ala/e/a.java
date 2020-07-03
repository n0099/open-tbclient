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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes3.dex */
public class a implements View.OnClickListener {
    public TextView fOn;
    public TextView fOo;
    public TextView fOp;
    private Context mContext;
    private AlertDialog mDialog;
    Handler handler = new Handler();
    CustomMessageListener aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.e.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                a.this.dismiss();
            }
        }
    };
    private Runnable fOq = new Runnable() { // from class: com.baidu.tieba.ala.e.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    private View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(a.h.ala_level_up_dialog, (ViewGroup) null);
    public ImageView fOm = (ImageView) this.mRootView.findViewById(a.g.close_img);

    public a(Context context) {
        this.mContext = context;
        this.fOm.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.fOn = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLevel);
        this.fOo = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipNum);
        this.fOp = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLebel);
    }

    private void byx() {
        MessageManager.getInstance().registerListener(this.aHo);
    }

    public void y(String str, String str2, boolean z) {
        this.fOp.setVisibility(z ? 0 : 8);
        this.fOn.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_level, str2));
        this.fOo.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_flower_num, str));
    }

    public void show() {
        this.mDialog = new AlertDialog.Builder(this.mContext, a.j.sdk_dialog_window).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.e.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageManager.getInstance().unRegisterListener(a.this.aHo);
            }
        });
        if (this.mContext instanceof Activity) {
            ShowUtil.showDialog(this.mDialog, (Activity) this.mContext);
            this.handler.postDelayed(this.fOq, 5000L);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.setContentView(this.mRootView);
        }
        byx();
    }

    public void dismiss() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.fOq);
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
