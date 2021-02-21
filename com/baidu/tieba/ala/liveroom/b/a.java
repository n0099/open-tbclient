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
    private AlertDialog hqh;
    private View hqi;
    private ImageView hqj;
    private View hqk;
    private View hql;
    private int hqm;
    private com.baidu.live.o.a hqn;
    private String hqo;
    private int hqp;
    private a.InterfaceC0191a hqq;
    private CustomMessageListener hqr;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.hqm = 1;
        this.hqp = 2;
        this.hqq = new a.InterfaceC0191a() { // from class: com.baidu.tieba.ala.liveroom.b.a.1
            @Override // com.baidu.live.o.a.InterfaceC0191a
            public void dJ(int i) {
                if (i == 1) {
                    if (a.this.hqm == 3) {
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
                a.this.vn(a.this.hqp);
                a.this.hqp = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.b.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.hqp = 2;
                    a.this.cac();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.hqp = 1;
                    a.this.cac();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hqj.setSelected(a.this.hqj.isSelected() ? false : true);
                }
            }
        };
        this.aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.b.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cac();
            }
        };
        this.hqr = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.b.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.hqm = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.cab();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        initModel();
        MessageManager.getInstance().registerListener(this.aWK);
        MessageManager.getInstance().registerListener(this.hqr);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hqj = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hqi = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.hqk = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.hql = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.hqk.setOnClickListener(this.mOnClickListener);
        this.hql.setOnClickListener(this.mOnClickListener);
        this.hqi.setOnClickListener(this.mOnClickListener);
    }

    private void initModel() {
        this.hqn = new com.baidu.live.o.a();
        this.hqn.a(this.hqq);
    }

    public void Hx(String str) {
        this.hqo = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vn(int i) {
        int i2 = this.hqj.isSelected() ? 1 : 2;
        if (this.hqn != null) {
            this.hqn.i(this.hqo, i, i2);
        }
    }

    public void cab() {
        if (this.hqh == null || !this.hqh.isShowing()) {
            this.hqj.setSelected(true);
            if (this.hqh == null) {
                this.hqh = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hqh, getPageContext().getPageActivity());
            }
            Window window = this.hqh.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hqh.setContentView(this.mRoot);
            }
            this.hqh.setCanceledOnTouchOutside(false);
            this.hqh.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cac() {
        if (this.hqh != null && this.hqh.isShowing()) {
            this.hqh.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cac();
        if (this.hqn != null) {
            this.hqn.onDestroy();
        }
        if (this.aWK != null) {
            MessageManager.getInstance().unRegisterListener(this.aWK);
        }
        if (this.hqr != null) {
            MessageManager.getInstance().unRegisterListener(this.hqr);
        }
    }
}
