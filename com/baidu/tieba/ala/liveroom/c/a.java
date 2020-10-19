package com.baidu.tieba.ala.liveroom.c;

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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aTf;
    private AlertDialog gDE;
    private View gDF;
    private ImageView gDG;
    private View gDH;
    private View gDI;
    private int gDJ;
    private com.baidu.live.l.a gDK;
    private String gDL;
    private int gDM;
    private a.InterfaceC0187a gDN;
    private CustomMessageListener gDO;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gDJ = 1;
        this.gDM = 2;
        this.gDN = new a.InterfaceC0187a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.l.a.InterfaceC0187a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gDJ == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.l.a.InterfaceC0187a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.uN(a.this.gDM);
                a.this.gDM = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gDM = 2;
                    a.this.bRE();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gDM = 1;
                    a.this.bRE();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gDG.setSelected(a.this.gDG.isSelected() ? false : true);
                }
            }
        };
        this.aTf = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bRE();
            }
        };
        this.gDO = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gDJ = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bRD();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        IF();
        MessageManager.getInstance().registerListener(this.aTf);
        MessageManager.getInstance().registerListener(this.gDO);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gDG = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.gDF = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gDH = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gDI = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gDH.setOnClickListener(this.mOnClickListener);
        this.gDI.setOnClickListener(this.mOnClickListener);
        this.gDF.setOnClickListener(this.mOnClickListener);
    }

    private void IF() {
        this.gDK = new com.baidu.live.l.a();
        this.gDK.a(this.gDN);
    }

    public void GZ(String str) {
        this.gDL = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uN(int i) {
        int i2 = this.gDG.isSelected() ? 1 : 2;
        if (this.gDK != null) {
            this.gDK.i(this.gDL, i, i2);
        }
    }

    public void bRD() {
        if (this.gDE == null || !this.gDE.isShowing()) {
            this.gDG.setSelected(true);
            if (this.gDE == null) {
                this.gDE = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gDE, getPageContext().getPageActivity());
            }
            Window window = this.gDE.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gDE.setContentView(this.mRoot);
            }
            this.gDE.setCanceledOnTouchOutside(false);
            this.gDE.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRE() {
        if (this.gDE != null && this.gDE.isShowing()) {
            this.gDE.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bRE();
        if (this.gDK != null) {
            this.gDK.onDestroy();
        }
        if (this.aTf != null) {
            MessageManager.getInstance().unRegisterListener(this.aTf);
        }
        if (this.gDO != null) {
            MessageManager.getInstance().unRegisterListener(this.gDO);
        }
    }
}
