package com.baidu.tieba.ala.liveroom.attentionpop;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aES;
    private AlertDialog fJT;
    private View fJU;
    private ImageView fJV;
    private View fJW;
    private View fJX;
    private int fJY;
    private com.baidu.live.k.a fJZ;
    private String fKa;
    private int fKb;
    private a.InterfaceC0167a fKc;
    private CustomMessageListener fKd;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJY = 1;
        this.fKb = 2;
        this.fKc = new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0167a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.fJY == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0167a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.qO(b.this.fKb);
                b.this.fKb = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.fKb = 2;
                    b.this.bxD();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.fKb = 1;
                    b.this.bxD();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.fJV.setSelected(b.this.fJV.isSelected() ? false : true);
                }
            }
        };
        this.aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bxD();
            }
        };
        this.fKd = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.fJY = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bxC();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        AC();
        MessageManager.getInstance().registerListener(this.aES);
        MessageManager.getInstance().registerListener(this.fKd);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fJV = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fJU = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.fJW = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.fJX = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.fJW.setOnClickListener(this.mOnClickListener);
        this.fJX.setOnClickListener(this.mOnClickListener);
        this.fJU.setOnClickListener(this.mOnClickListener);
    }

    private void AC() {
        this.fJZ = new com.baidu.live.k.a();
        this.fJZ.a(this.fKc);
    }

    public void Ch(String str) {
        this.fKa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO(int i) {
        int i2 = this.fJV.isSelected() ? 1 : 2;
        if (this.fJZ != null) {
            this.fJZ.i(this.fKa, i, i2);
        }
    }

    public void bxC() {
        if (this.fJT == null || !this.fJT.isShowing()) {
            this.fJV.setSelected(true);
            if (this.fJT == null) {
                this.fJT = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fJT, getPageContext().getPageActivity());
            }
            Window window = this.fJT.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fJT.setContentView(this.mRoot);
            }
            this.fJT.setCanceledOnTouchOutside(false);
            this.fJT.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxD() {
        if (this.fJT != null && this.fJT.isShowing()) {
            this.fJT.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bxD();
        if (this.fJZ != null) {
            this.fJZ.onDestroy();
        }
        if (this.aES != null) {
            MessageManager.getInstance().unRegisterListener(this.aES);
        }
        if (this.fKd != null) {
            MessageManager.getInstance().unRegisterListener(this.fKd);
        }
    }
}
