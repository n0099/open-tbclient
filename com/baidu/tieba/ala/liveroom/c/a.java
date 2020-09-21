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
    private CustomMessageListener aPU;
    private AlertDialog gpl;
    private View gpm;
    private ImageView gpn;
    private View gpo;
    private View gpp;
    private int gpq;
    private com.baidu.live.l.a gpr;
    private String gps;
    private int gpt;
    private a.InterfaceC0179a gpu;
    private CustomMessageListener gpv;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gpq = 1;
        this.gpt = 2;
        this.gpu = new a.InterfaceC0179a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.l.a.InterfaceC0179a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gpq == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.l.a.InterfaceC0179a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.ui(a.this.gpt);
                a.this.gpt = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gpt = 2;
                    a.this.bOn();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gpt = 1;
                    a.this.bOn();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gpn.setSelected(a.this.gpn.isSelected() ? false : true);
                }
            }
        };
        this.aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bOn();
            }
        };
        this.gpv = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gpq = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bOm();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        HI();
        MessageManager.getInstance().registerListener(this.aPU);
        MessageManager.getInstance().registerListener(this.gpv);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gpn = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.gpm = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gpo = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gpp = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gpo.setOnClickListener(this.mOnClickListener);
        this.gpp.setOnClickListener(this.mOnClickListener);
        this.gpm.setOnClickListener(this.mOnClickListener);
    }

    private void HI() {
        this.gpr = new com.baidu.live.l.a();
        this.gpr.a(this.gpu);
    }

    public void Gn(String str) {
        this.gps = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui(int i) {
        int i2 = this.gpn.isSelected() ? 1 : 2;
        if (this.gpr != null) {
            this.gpr.i(this.gps, i, i2);
        }
    }

    public void bOm() {
        if (this.gpl == null || !this.gpl.isShowing()) {
            this.gpn.setSelected(true);
            if (this.gpl == null) {
                this.gpl = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gpl, getPageContext().getPageActivity());
            }
            Window window = this.gpl.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gpl.setContentView(this.mRoot);
            }
            this.gpl.setCanceledOnTouchOutside(false);
            this.gpl.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOn() {
        if (this.gpl != null && this.gpl.isShowing()) {
            this.gpl.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bOn();
        if (this.gpr != null) {
            this.gpr.onDestroy();
        }
        if (this.aPU != null) {
            MessageManager.getInstance().unRegisterListener(this.aPU);
        }
        if (this.gpv != null) {
            MessageManager.getInstance().unRegisterListener(this.gpv);
        }
    }
}
