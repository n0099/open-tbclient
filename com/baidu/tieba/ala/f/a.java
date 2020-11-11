package com.baidu.tieba.ala.f;

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
/* loaded from: classes4.dex */
public class a implements View.OnClickListener {
    public TextView gMH;
    public TextView gMI;
    public TextView gMJ;
    private Context mContext;
    private AlertDialog mDialog;
    Handler handler = new Handler();
    CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.f.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                a.this.dismiss();
            }
        }
    };
    private Runnable gMK = new Runnable() { // from class: com.baidu.tieba.ala.f.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    private View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(a.g.ala_level_up_dialog, (ViewGroup) null);
    public ImageView gMG = (ImageView) this.mRootView.findViewById(a.f.close_img);

    public a(Context context) {
        this.mContext = context;
        this.gMG.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.gMH = (TextView) this.mRootView.findViewById(a.f.tvLevelUpTipLevel);
        this.gMI = (TextView) this.mRootView.findViewById(a.f.tvLevelUpTipNum);
        this.gMJ = (TextView) this.mRootView.findViewById(a.f.tvLevelUpTipLebel);
    }

    private void bUx() {
        MessageManager.getInstance().registerListener(this.aVt);
    }

    public void y(String str, String str2, boolean z) {
        this.gMJ.setVisibility(z ? 0 : 8);
        this.gMH.setText(this.mContext.getResources().getString(a.h.ala_task_level_up_tip_level, str2));
        this.gMI.setText(this.mContext.getResources().getString(a.h.ala_task_level_up_tip_flower_num, str));
    }

    public void show() {
        this.mDialog = new AlertDialog.Builder(this.mContext, a.i.sdk_dialog_window).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.f.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageManager.getInstance().unRegisterListener(a.this.aVt);
            }
        });
        if (this.mContext instanceof Activity) {
            ShowUtil.showDialog(this.mDialog, (Activity) this.mContext);
            this.handler.postDelayed(this.gMK, 5000L);
        }
        Window window = this.mDialog.getWindow();
        if (window != null) {
            window.setGravity(17);
            window.setBackgroundDrawableResource(17170445);
            window.setContentView(this.mRootView);
        }
        bUx();
    }

    public void dismiss() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.gMK);
        }
        if (this.mDialog != null && (this.mContext instanceof Activity)) {
            ShowUtil.dismissDialog(this.mDialog, (Activity) this.mContext);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == a.f.close_img || view == this.mRootView) {
            dismiss();
        }
    }
}
