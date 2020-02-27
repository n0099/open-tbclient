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
    private AlertDialog eQA;
    private View eQB;
    private ImageView eQC;
    private View eQD;
    private View eQE;
    private int eQF;
    private com.baidu.live.k.a eQG;
    private String eQH;
    private int eQI;
    private a.InterfaceC0090a eQJ;
    private CustomMessageListener eQK;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eQF = 1;
        this.eQI = 2;
        this.eQJ = new a.InterfaceC0090a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.eQF == 3) {
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
                b.this.pP(b.this.eQI);
                b.this.eQI = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eQI = 2;
                    b.this.bij();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eQI = 1;
                    b.this.bij();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eQC.setSelected(b.this.eQC.isSelected() ? false : true);
                }
            }
        };
        this.agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bij();
            }
        };
        this.eQK = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eQF = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bii();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dQ();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.eQK);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eQC = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eQB = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eQD = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eQE = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eQD.setOnClickListener(this.mOnClickListener);
        this.eQE.setOnClickListener(this.mOnClickListener);
        this.eQB.setOnClickListener(this.mOnClickListener);
    }

    private void dQ() {
        this.eQG = new com.baidu.live.k.a();
        this.eQG.a(this.eQJ);
    }

    public void yM(String str) {
        this.eQH = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(int i) {
        int i2 = this.eQC.isSelected() ? 1 : 2;
        if (this.eQG != null) {
            this.eQG.i(this.eQH, i, i2);
        }
    }

    public void bii() {
        if (this.eQA == null || !this.eQA.isShowing()) {
            this.eQC.setSelected(true);
            if (this.eQA == null) {
                this.eQA = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eQA, getPageContext().getPageActivity());
            }
            Window window = this.eQA.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eQA.setContentView(this.mRoot);
            }
            this.eQA.setCanceledOnTouchOutside(false);
            this.eQA.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bij() {
        if (this.eQA != null && this.eQA.isShowing()) {
            this.eQA.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bij();
        if (this.eQG != null) {
            this.eQG.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.eQK != null) {
            MessageManager.getInstance().unRegisterListener(this.eQK);
        }
    }
}
