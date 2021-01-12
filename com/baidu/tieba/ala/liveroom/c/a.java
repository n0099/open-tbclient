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
import com.baidu.live.p.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aTF;
    private AlertDialog hlF;
    private View hlG;
    private ImageView hlH;
    private View hlI;
    private View hlJ;
    private int hlK;
    private com.baidu.live.p.a hlL;
    private String hlM;
    private int hlN;
    private a.InterfaceC0190a hlO;
    private CustomMessageListener hlP;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hlK = 1;
        this.hlN = 2;
        this.hlO = new a.InterfaceC0190a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.p.a.InterfaceC0190a
            public void dD(int i) {
                if (i == 1) {
                    if (a.this.hlK == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.p.a.InterfaceC0190a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.vc(a.this.hlN);
                a.this.hlN = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.hlN = 2;
                    a.this.bYZ();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.hlN = 1;
                    a.this.bYZ();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hlH.setSelected(a.this.hlH.isSelected() ? false : true);
                }
            }
        };
        this.aTF = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bYZ();
            }
        };
        this.hlP = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.hlK = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bYY();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        initModel();
        MessageManager.getInstance().registerListener(this.aTF);
        MessageManager.getInstance().registerListener(this.hlP);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hlH = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hlG = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.hlI = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.hlJ = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.hlI.setOnClickListener(this.mOnClickListener);
        this.hlJ.setOnClickListener(this.mOnClickListener);
        this.hlG.setOnClickListener(this.mOnClickListener);
    }

    private void initModel() {
        this.hlL = new com.baidu.live.p.a();
        this.hlL.a(this.hlO);
    }

    public void GS(String str) {
        this.hlM = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vc(int i) {
        int i2 = this.hlH.isSelected() ? 1 : 2;
        if (this.hlL != null) {
            this.hlL.i(this.hlM, i, i2);
        }
    }

    public void bYY() {
        if (this.hlF == null || !this.hlF.isShowing()) {
            this.hlH.setSelected(true);
            if (this.hlF == null) {
                this.hlF = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hlF, getPageContext().getPageActivity());
            }
            Window window = this.hlF.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hlF.setContentView(this.mRoot);
            }
            this.hlF.setCanceledOnTouchOutside(false);
            this.hlF.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYZ() {
        if (this.hlF != null && this.hlF.isShowing()) {
            this.hlF.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bYZ();
        if (this.hlL != null) {
            this.hlL.onDestroy();
        }
        if (this.aTF != null) {
            MessageManager.getInstance().unRegisterListener(this.aTF);
        }
        if (this.hlP != null) {
            MessageManager.getInstance().unRegisterListener(this.hlP);
        }
    }
}
