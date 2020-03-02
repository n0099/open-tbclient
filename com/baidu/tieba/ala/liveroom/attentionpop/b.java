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
    private CustomMessageListener agU;
    private AlertDialog eQB;
    private View eQC;
    private ImageView eQD;
    private View eQE;
    private View eQF;
    private int eQG;
    private com.baidu.live.k.a eQH;
    private String eQI;
    private int eQJ;
    private a.InterfaceC0090a eQK;
    private CustomMessageListener eQL;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eQG = 1;
        this.eQJ = 2;
        this.eQK = new a.InterfaceC0090a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.eQG == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.pP(b.this.eQJ);
                b.this.eQJ = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eQJ = 2;
                    b.this.bil();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eQJ = 1;
                    b.this.bil();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eQD.setSelected(b.this.eQD.isSelected() ? false : true);
                }
            }
        };
        this.agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bil();
            }
        };
        this.eQL = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eQG = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bik();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dQ();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.eQL);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eQD = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eQC = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eQE = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eQF = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eQE.setOnClickListener(this.mOnClickListener);
        this.eQF.setOnClickListener(this.mOnClickListener);
        this.eQC.setOnClickListener(this.mOnClickListener);
    }

    private void dQ() {
        this.eQH = new com.baidu.live.k.a();
        this.eQH.a(this.eQK);
    }

    public void yM(String str) {
        this.eQI = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(int i) {
        int i2 = this.eQD.isSelected() ? 1 : 2;
        if (this.eQH != null) {
            this.eQH.i(this.eQI, i, i2);
        }
    }

    public void bik() {
        if (this.eQB == null || !this.eQB.isShowing()) {
            this.eQD.setSelected(true);
            if (this.eQB == null) {
                this.eQB = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eQB, getPageContext().getPageActivity());
            }
            Window window = this.eQB.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eQB.setContentView(this.mRoot);
            }
            this.eQB.setCanceledOnTouchOutside(false);
            this.eQB.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bil() {
        if (this.eQB != null && this.eQB.isShowing()) {
            this.eQB.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bil();
        if (this.eQH != null) {
            this.eQH.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.eQL != null) {
            MessageManager.getInstance().unRegisterListener(this.eQL);
        }
    }
}
