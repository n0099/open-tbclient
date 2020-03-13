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
    private AlertDialog eQO;
    private View eQP;
    private ImageView eQQ;
    private View eQR;
    private View eQS;
    private int eQT;
    private com.baidu.live.k.a eQU;
    private String eQV;
    private int eQW;
    private a.InterfaceC0090a eQX;
    private CustomMessageListener eQY;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eQT = 1;
        this.eQW = 2;
        this.eQX = new a.InterfaceC0090a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.eQT == 3) {
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
                b.this.pP(b.this.eQW);
                b.this.eQW = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eQW = 2;
                    b.this.bim();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eQW = 1;
                    b.this.bim();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eQQ.setSelected(b.this.eQQ.isSelected() ? false : true);
                }
            }
        };
        this.agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bim();
            }
        };
        this.eQY = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eQT = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bil();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dQ();
        MessageManager.getInstance().registerListener(this.agU);
        MessageManager.getInstance().registerListener(this.eQY);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eQQ = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eQP = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eQR = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eQS = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eQR.setOnClickListener(this.mOnClickListener);
        this.eQS.setOnClickListener(this.mOnClickListener);
        this.eQP.setOnClickListener(this.mOnClickListener);
    }

    private void dQ() {
        this.eQU = new com.baidu.live.k.a();
        this.eQU.a(this.eQX);
    }

    public void yN(String str) {
        this.eQV = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pP(int i) {
        int i2 = this.eQQ.isSelected() ? 1 : 2;
        if (this.eQU != null) {
            this.eQU.i(this.eQV, i, i2);
        }
    }

    public void bil() {
        if (this.eQO == null || !this.eQO.isShowing()) {
            this.eQQ.setSelected(true);
            if (this.eQO == null) {
                this.eQO = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eQO, getPageContext().getPageActivity());
            }
            Window window = this.eQO.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eQO.setContentView(this.mRoot);
            }
            this.eQO.setCanceledOnTouchOutside(false);
            this.eQO.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bim() {
        if (this.eQO != null && this.eQO.isShowing()) {
            this.eQO.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bim();
        if (this.eQU != null) {
            this.eQU.onDestroy();
        }
        if (this.agU != null) {
            MessageManager.getInstance().unRegisterListener(this.agU);
        }
        if (this.eQY != null) {
            MessageManager.getInstance().unRegisterListener(this.eQY);
        }
    }
}
