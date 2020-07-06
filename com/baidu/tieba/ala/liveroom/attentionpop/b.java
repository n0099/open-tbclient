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
import com.baidu.live.l.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aHo;
    private AlertDialog fUT;
    private View fUU;
    private ImageView fUV;
    private View fUW;
    private View fUX;
    private int fUY;
    private com.baidu.live.l.a fUZ;
    private String fVa;
    private int fVb;
    private a.InterfaceC0169a fVc;
    private CustomMessageListener fVd;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fUY = 1;
        this.fVb = 2;
        this.fVc = new a.InterfaceC0169a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.l.a.InterfaceC0169a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.fUY == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.l.a.InterfaceC0169a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.rn(b.this.fVb);
                b.this.fVb = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.fVb = 2;
                    b.this.bAr();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.fVb = 1;
                    b.this.bAr();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.fUV.setSelected(b.this.fUV.isSelected() ? false : true);
                }
            }
        };
        this.aHo = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bAr();
            }
        };
        this.fVd = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.fUY = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bAq();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        Bc();
        MessageManager.getInstance().registerListener(this.aHo);
        MessageManager.getInstance().registerListener(this.fVd);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fUV = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fUU = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.fUW = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.fUX = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.fUW.setOnClickListener(this.mOnClickListener);
        this.fUX.setOnClickListener(this.mOnClickListener);
        this.fUU.setOnClickListener(this.mOnClickListener);
    }

    private void Bc() {
        this.fUZ = new com.baidu.live.l.a();
        this.fUZ.a(this.fVc);
    }

    public void CG(String str) {
        this.fVa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rn(int i) {
        int i2 = this.fUV.isSelected() ? 1 : 2;
        if (this.fUZ != null) {
            this.fUZ.i(this.fVa, i, i2);
        }
    }

    public void bAq() {
        if (this.fUT == null || !this.fUT.isShowing()) {
            this.fUV.setSelected(true);
            if (this.fUT == null) {
                this.fUT = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fUT, getPageContext().getPageActivity());
            }
            Window window = this.fUT.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fUT.setContentView(this.mRoot);
            }
            this.fUT.setCanceledOnTouchOutside(false);
            this.fUT.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bAr() {
        if (this.fUT != null && this.fUT.isShowing()) {
            this.fUT.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bAr();
        if (this.fUZ != null) {
            this.fUZ.onDestroy();
        }
        if (this.aHo != null) {
            MessageManager.getInstance().unRegisterListener(this.aHo);
        }
        if (this.fVd != null) {
            MessageManager.getInstance().unRegisterListener(this.fVd);
        }
    }
}
