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
import com.baidu.live.j.a;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aeN;
    private View eMA;
    private View eMB;
    private int eMC;
    private com.baidu.live.j.a eMD;
    private String eME;
    private int eMF;
    private a.InterfaceC0082a eMG;
    private CustomMessageListener eMH;
    private AlertDialog eMx;
    private View eMy;
    private ImageView eMz;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eMC = 1;
        this.eMF = 2;
        this.eMG = new a.InterfaceC0082a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.j.a.InterfaceC0082a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.eMC == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.j.a.InterfaceC0082a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.pH(b.this.eMF);
                b.this.eMF = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eMF = 2;
                    b.this.bga();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eMF = 1;
                    b.this.bga();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eMz.setSelected(b.this.eMz.isSelected() ? false : true);
                }
            }
        };
        this.aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bga();
            }
        };
        this.eMH = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eMC = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bfZ();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dP();
        MessageManager.getInstance().registerListener(this.aeN);
        MessageManager.getInstance().registerListener(this.eMH);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eMz = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eMy = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eMA = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eMB = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eMA.setOnClickListener(this.mOnClickListener);
        this.eMB.setOnClickListener(this.mOnClickListener);
        this.eMy.setOnClickListener(this.mOnClickListener);
    }

    private void dP() {
        this.eMD = new com.baidu.live.j.a();
        this.eMD.a(this.eMG);
    }

    public void yr(String str) {
        this.eME = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pH(int i) {
        int i2 = this.eMz.isSelected() ? 1 : 2;
        if (this.eMD != null) {
            this.eMD.i(this.eME, i, i2);
        }
    }

    public void bfZ() {
        if (this.eMx == null || !this.eMx.isShowing()) {
            this.eMz.setSelected(true);
            if (this.eMx == null) {
                this.eMx = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eMx, getPageContext().getPageActivity());
            }
            Window window = this.eMx.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eMx.setContentView(this.mRoot);
            }
            this.eMx.setCanceledOnTouchOutside(false);
            this.eMx.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bga() {
        if (this.eMx != null && this.eMx.isShowing()) {
            this.eMx.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bga();
        if (this.eMD != null) {
            this.eMD.onDestroy();
        }
        if (this.aeN != null) {
            MessageManager.getInstance().unRegisterListener(this.aeN);
        }
        if (this.eMH != null) {
            MessageManager.getInstance().unRegisterListener(this.eMH);
        }
    }
}
