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
import com.baidu.live.m.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aVt;
    private View gVA;
    private int gVB;
    private com.baidu.live.m.a gVC;
    private String gVD;
    private int gVE;
    private a.InterfaceC0190a gVF;
    private CustomMessageListener gVG;
    private AlertDialog gVw;
    private View gVx;
    private ImageView gVy;
    private View gVz;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gVB = 1;
        this.gVE = 2;
        this.gVF = new a.InterfaceC0190a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.m.a.InterfaceC0190a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gVB == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.m.a.InterfaceC0190a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.vu(a.this.gVE);
                a.this.gVE = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gVE = 2;
                    a.this.bXb();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gVE = 1;
                    a.this.bXb();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gVy.setSelected(a.this.gVy.isSelected() ? false : true);
                }
            }
        };
        this.aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bXb();
            }
        };
        this.gVG = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gVB = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bXa();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        Jz();
        MessageManager.getInstance().registerListener(this.aVt);
        MessageManager.getInstance().registerListener(this.gVG);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gVy = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.gVx = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.gVz = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.gVA = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.gVz.setOnClickListener(this.mOnClickListener);
        this.gVA.setOnClickListener(this.mOnClickListener);
        this.gVx.setOnClickListener(this.mOnClickListener);
    }

    private void Jz() {
        this.gVC = new com.baidu.live.m.a();
        this.gVC.a(this.gVF);
    }

    public void HP(String str) {
        this.gVD = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vu(int i) {
        int i2 = this.gVy.isSelected() ? 1 : 2;
        if (this.gVC != null) {
            this.gVC.i(this.gVD, i, i2);
        }
    }

    public void bXa() {
        if (this.gVw == null || !this.gVw.isShowing()) {
            this.gVy.setSelected(true);
            if (this.gVw == null) {
                this.gVw = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gVw, getPageContext().getPageActivity());
            }
            Window window = this.gVw.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gVw.setContentView(this.mRoot);
            }
            this.gVw.setCanceledOnTouchOutside(false);
            this.gVw.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bXb() {
        if (this.gVw != null && this.gVw.isShowing()) {
            this.gVw.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bXb();
        if (this.gVC != null) {
            this.gVC.onDestroy();
        }
        if (this.aVt != null) {
            MessageManager.getInstance().unRegisterListener(this.aVt);
        }
        if (this.gVG != null) {
            MessageManager.getInstance().unRegisterListener(this.gVG);
        }
    }
}
