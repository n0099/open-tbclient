package com.baidu.tieba.ala.liveroom.b;

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
import com.baidu.live.o.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aYk;
    private AlertDialog hrQ;
    private View hrR;
    private ImageView hrS;
    private View hrT;
    private View hrU;
    private int hrV;
    private com.baidu.live.o.a hrW;
    private String hrX;
    private int hrY;
    private a.InterfaceC0197a hrZ;
    private CustomMessageListener hsa;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hrV = 1;
        this.hrY = 2;
        this.hrZ = new a.InterfaceC0197a() { // from class: com.baidu.tieba.ala.liveroom.b.a.1
            @Override // com.baidu.live.o.a.InterfaceC0197a
            public void dK(int i) {
                if (i == 1) {
                    if (a.this.hrV == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.o.a.InterfaceC0197a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.vp(a.this.hrY);
                a.this.hrY = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.hrY = 2;
                    a.this.cai();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.hrY = 1;
                    a.this.cai();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hrS.setSelected(a.this.hrS.isSelected() ? false : true);
                }
            }
        };
        this.aYk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cai();
            }
        };
        this.hsa = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.b.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.hrV = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.cah();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        initModel();
        MessageManager.getInstance().registerListener(this.aYk);
        MessageManager.getInstance().registerListener(this.hsa);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hrS = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hrR = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.hrT = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.hrU = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.hrT.setOnClickListener(this.mOnClickListener);
        this.hrU.setOnClickListener(this.mOnClickListener);
        this.hrR.setOnClickListener(this.mOnClickListener);
    }

    private void initModel() {
        this.hrW = new com.baidu.live.o.a();
        this.hrW.a(this.hrZ);
    }

    public void HG(String str) {
        this.hrX = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vp(int i) {
        int i2 = this.hrS.isSelected() ? 1 : 2;
        if (this.hrW != null) {
            this.hrW.i(this.hrX, i, i2);
        }
    }

    public void cah() {
        if (this.hrQ == null || !this.hrQ.isShowing()) {
            this.hrS.setSelected(true);
            if (this.hrQ == null) {
                this.hrQ = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hrQ, getPageContext().getPageActivity());
            }
            Window window = this.hrQ.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hrQ.setContentView(this.mRoot);
            }
            this.hrQ.setCanceledOnTouchOutside(false);
            this.hrQ.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cai() {
        if (this.hrQ != null && this.hrQ.isShowing()) {
            this.hrQ.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cai();
        if (this.hrW != null) {
            this.hrW.onDestroy();
        }
        if (this.aYk != null) {
            MessageManager.getInstance().unRegisterListener(this.aYk);
        }
        if (this.hsa != null) {
            MessageManager.getInstance().unRegisterListener(this.hsa);
        }
    }
}
