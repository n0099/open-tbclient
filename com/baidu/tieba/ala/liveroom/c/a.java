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
/* loaded from: classes7.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aNU;
    private AlertDialog gma;
    private View gmb;
    private ImageView gmc;
    private View gmd;
    private View gme;
    private int gmf;
    private com.baidu.live.l.a gmg;
    private String gmh;
    private int gmi;
    private a.InterfaceC0177a gmj;
    private CustomMessageListener gmk;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gmf = 1;
        this.gmi = 2;
        this.gmj = new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.l.a.InterfaceC0177a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gmf == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.l.a.InterfaceC0177a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.tP(a.this.gmi);
                a.this.gmi = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gmi = 2;
                    a.this.bNd();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gmi = 1;
                    a.this.bNd();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gmc.setSelected(a.this.gmc.isSelected() ? false : true);
                }
            }
        };
        this.aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bNd();
            }
        };
        this.gmk = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gmf = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bNc();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        Hh();
        MessageManager.getInstance().registerListener(this.aNU);
        MessageManager.getInstance().registerListener(this.gmk);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gmc = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.gmb = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gmd = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gme = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gmd.setOnClickListener(this.mOnClickListener);
        this.gme.setOnClickListener(this.mOnClickListener);
        this.gmb.setOnClickListener(this.mOnClickListener);
    }

    private void Hh() {
        this.gmg = new com.baidu.live.l.a();
        this.gmg.a(this.gmj);
    }

    public void FP(String str) {
        this.gmh = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        int i2 = this.gmc.isSelected() ? 1 : 2;
        if (this.gmg != null) {
            this.gmg.i(this.gmh, i, i2);
        }
    }

    public void bNc() {
        if (this.gma == null || !this.gma.isShowing()) {
            this.gmc.setSelected(true);
            if (this.gma == null) {
                this.gma = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gma, getPageContext().getPageActivity());
            }
            Window window = this.gma.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gma.setContentView(this.mRoot);
            }
            this.gma.setCanceledOnTouchOutside(false);
            this.gma.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNd() {
        if (this.gma != null && this.gma.isShowing()) {
            this.gma.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bNd();
        if (this.gmg != null) {
            this.gmg.onDestroy();
        }
        if (this.aNU != null) {
            MessageManager.getInstance().unRegisterListener(this.aNU);
        }
        if (this.gmk != null) {
            MessageManager.getInstance().unRegisterListener(this.gmk);
        }
    }
}
