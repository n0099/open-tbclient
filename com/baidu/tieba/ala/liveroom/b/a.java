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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aWK;
    private AlertDialog hpT;
    private View hpU;
    private ImageView hpV;
    private View hpW;
    private View hpX;
    private int hpY;
    private com.baidu.live.o.a hpZ;
    private String hqa;
    private int hqb;
    private a.InterfaceC0191a hqc;
    private CustomMessageListener hqd;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hpY = 1;
        this.hqb = 2;
        this.hqc = new a.InterfaceC0191a() { // from class: com.baidu.tieba.ala.liveroom.b.a.1
            @Override // com.baidu.live.o.a.InterfaceC0191a
            public void dJ(int i) {
                if (i == 1) {
                    if (a.this.hpY == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.o.a.InterfaceC0191a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.b.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.vn(a.this.hqb);
                a.this.hqb = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.hqb = 2;
                    a.this.bZV();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.hqb = 1;
                    a.this.bZV();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hpV.setSelected(a.this.hpV.isSelected() ? false : true);
                }
            }
        };
        this.aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bZV();
            }
        };
        this.hqd = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.b.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.hpY = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bZU();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        initModel();
        MessageManager.getInstance().registerListener(this.aWK);
        MessageManager.getInstance().registerListener(this.hqd);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hpV = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hpU = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.hpW = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.hpX = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.hpW.setOnClickListener(this.mOnClickListener);
        this.hpX.setOnClickListener(this.mOnClickListener);
        this.hpU.setOnClickListener(this.mOnClickListener);
    }

    private void initModel() {
        this.hpZ = new com.baidu.live.o.a();
        this.hpZ.a(this.hqc);
    }

    public void Hw(String str) {
        this.hqa = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        int i2 = this.hpV.isSelected() ? 1 : 2;
        if (this.hpZ != null) {
            this.hpZ.i(this.hqa, i, i2);
        }
    }

    public void bZU() {
        if (this.hpT == null || !this.hpT.isShowing()) {
            this.hpV.setSelected(true);
            if (this.hpT == null) {
                this.hpT = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hpT, getPageContext().getPageActivity());
            }
            Window window = this.hpT.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hpT.setContentView(this.mRoot);
            }
            this.hpT.setCanceledOnTouchOutside(false);
            this.hpT.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bZV() {
        if (this.hpT != null && this.hpT.isShowing()) {
            this.hpT.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bZV();
        if (this.hpZ != null) {
            this.hpZ.onDestroy();
        }
        if (this.aWK != null) {
            MessageManager.getInstance().unRegisterListener(this.aWK);
        }
        if (this.hqd != null) {
            MessageManager.getInstance().unRegisterListener(this.hqd);
        }
    }
}
