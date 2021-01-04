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
/* loaded from: classes11.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aYs;
    private AlertDialog hqm;
    private View hqn;
    private ImageView hqo;
    private View hqp;
    private View hqq;
    private int hqr;
    private com.baidu.live.p.a hqs;
    private String hqt;
    private int hqu;
    private a.InterfaceC0199a hqv;
    private CustomMessageListener hqw;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqr = 1;
        this.hqu = 2;
        this.hqv = new a.InterfaceC0199a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.p.a.InterfaceC0199a
            public void fj(int i) {
                if (i == 1) {
                    if (a.this.hqr == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.p.a.InterfaceC0199a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.wI(a.this.hqu);
                a.this.hqu = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.hqu = 2;
                    a.this.ccQ();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.hqu = 1;
                    a.this.ccQ();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hqo.setSelected(a.this.hqo.isSelected() ? false : true);
                }
            }
        };
        this.aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.ccQ();
            }
        };
        this.hqw = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.hqr = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.ccP();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        initModel();
        MessageManager.getInstance().registerListener(this.aYs);
        MessageManager.getInstance().registerListener(this.hqw);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hqo = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hqn = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.hqp = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.hqq = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.hqp.setOnClickListener(this.mOnClickListener);
        this.hqq.setOnClickListener(this.mOnClickListener);
        this.hqn.setOnClickListener(this.mOnClickListener);
    }

    private void initModel() {
        this.hqs = new com.baidu.live.p.a();
        this.hqs.a(this.hqv);
    }

    public void Ie(String str) {
        this.hqt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wI(int i) {
        int i2 = this.hqo.isSelected() ? 1 : 2;
        if (this.hqs != null) {
            this.hqs.i(this.hqt, i, i2);
        }
    }

    public void ccP() {
        if (this.hqm == null || !this.hqm.isShowing()) {
            this.hqo.setSelected(true);
            if (this.hqm == null) {
                this.hqm = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hqm, getPageContext().getPageActivity());
            }
            Window window = this.hqm.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hqm.setContentView(this.mRoot);
            }
            this.hqm.setCanceledOnTouchOutside(false);
            this.hqm.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ccQ() {
        if (this.hqm != null && this.hqm.isShowing()) {
            this.hqm.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        ccQ();
        if (this.hqs != null) {
            this.hqs.onDestroy();
        }
        if (this.aYs != null) {
            MessageManager.getInstance().unRegisterListener(this.aYs);
        }
        if (this.hqw != null) {
            MessageManager.getInstance().unRegisterListener(this.hqw);
        }
    }
}
