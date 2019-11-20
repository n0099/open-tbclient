package com.baidu.tieba.ala.b;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes6.dex */
public class a implements View.OnClickListener {
    public TextView dPF;
    public TextView dPG;
    public TextView dPH;
    private Context mContext;
    private AlertDialog mDialog;
    Handler handler = new Handler();
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.b.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (a.this.mDialog != null && a.this.mDialog.isShowing()) {
                a.this.dismiss();
            }
        }
    };
    private Runnable dPI = new Runnable() { // from class: com.baidu.tieba.ala.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            a.this.dismiss();
        }
    };
    private View mRootView = LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(a.h.ala_level_up_dialog, (ViewGroup) null);
    public ImageView dPE = (ImageView) this.mRootView.findViewById(a.g.close_img);

    public a(Context context) {
        this.mContext = context;
        this.dPE.setOnClickListener(this);
        this.mRootView.setOnClickListener(this);
        this.dPF = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLevel);
        this.dPG = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipNum);
        this.dPH = (TextView) this.mRootView.findViewById(a.g.tvLevelUpTipLebel);
    }

    private void aMj() {
        MessageManager.getInstance().registerListener(this.afT);
    }

    public void w(String str, String str2, boolean z) {
        this.dPH.setVisibility(z ? 0 : 8);
        this.dPF.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_level, str2));
        this.dPG.setText(this.mContext.getResources().getString(a.i.ala_task_level_up_tip_flower_num, str));
    }

    public void show() {
        this.mDialog = new AlertDialog.Builder(this.mContext).create();
        this.mDialog.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                MessageManager.getInstance().unRegisterListener(a.this.afT);
            }
        });
        if (this.mContext instanceof Activity) {
            ShowUtil.showDialog(this.mDialog, (Activity) this.mContext);
            this.handler.postDelayed(this.dPI, 5000L);
        }
        Window window = this.mDialog.getWindow();
        window.setWindowAnimations(a.j.sdk_dialog_ani_b2t);
        window.setGravity(17);
        window.setDimAmount(0.0f);
        window.setBackgroundDrawable(new ColorDrawable(this.mContext.getResources().getColor(a.d.sdk_black_alpha35)));
        window.setLayout(-1, -1);
        window.setContentView(this.mRootView);
        aMj();
    }

    public void dismiss() {
        if (this.handler != null) {
            this.handler.removeCallbacks(this.dPI);
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
