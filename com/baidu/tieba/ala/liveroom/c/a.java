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
    private CustomMessageListener aNW;
    private AlertDialog gme;
    private View gmf;
    private ImageView gmg;
    private View gmh;
    private View gmi;
    private int gmj;
    private com.baidu.live.l.a gmk;
    private String gml;
    private int gmm;
    private a.InterfaceC0177a gmn;
    private CustomMessageListener gmo;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gmj = 1;
        this.gmm = 2;
        this.gmn = new a.InterfaceC0177a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.l.a.InterfaceC0177a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gmj == 3) {
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
                a.this.tP(a.this.gmm);
                a.this.gmm = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gmm = 2;
                    a.this.bNe();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gmm = 1;
                    a.this.bNe();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gmg.setSelected(a.this.gmg.isSelected() ? false : true);
                }
            }
        };
        this.aNW = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bNe();
            }
        };
        this.gmo = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gmj = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bNd();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        Hh();
        MessageManager.getInstance().registerListener(this.aNW);
        MessageManager.getInstance().registerListener(this.gmo);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gmg = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.gmf = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gmh = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gmi = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gmh.setOnClickListener(this.mOnClickListener);
        this.gmi.setOnClickListener(this.mOnClickListener);
        this.gmf.setOnClickListener(this.mOnClickListener);
    }

    private void Hh() {
        this.gmk = new com.baidu.live.l.a();
        this.gmk.a(this.gmn);
    }

    public void FQ(String str) {
        this.gml = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tP(int i) {
        int i2 = this.gmg.isSelected() ? 1 : 2;
        if (this.gmk != null) {
            this.gmk.i(this.gml, i, i2);
        }
    }

    public void bNd() {
        if (this.gme == null || !this.gme.isShowing()) {
            this.gmg.setSelected(true);
            if (this.gme == null) {
                this.gme = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gme, getPageContext().getPageActivity());
            }
            Window window = this.gme.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gme.setContentView(this.mRoot);
            }
            this.gme.setCanceledOnTouchOutside(false);
            this.gme.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNe() {
        if (this.gme != null && this.gme.isShowing()) {
            this.gme.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bNe();
        if (this.gmk != null) {
            this.gmk.onDestroy();
        }
        if (this.aNW != null) {
            MessageManager.getInstance().unRegisterListener(this.aNW);
        }
        if (this.gmo != null) {
            MessageManager.getInstance().unRegisterListener(this.gmo);
        }
    }
}
