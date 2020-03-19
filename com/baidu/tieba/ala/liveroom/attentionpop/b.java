package com.baidu.tieba.ala.liveroom.attentionpop;

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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener ahe;
    private AlertDialog eRm;
    private View eRn;
    private ImageView eRo;
    private View eRp;
    private View eRq;
    private int eRr;
    private com.baidu.live.k.a eRs;
    private String eRt;
    private int eRu;
    private a.InterfaceC0090a eRv;
    private CustomMessageListener eRw;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eRr = 1;
        this.eRu = 2;
        this.eRv = new a.InterfaceC0090a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.eRr == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0090a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.pR(b.this.eRu);
                b.this.eRu = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eRu = 2;
                    b.this.bir();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eRu = 1;
                    b.this.bir();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eRo.setSelected(b.this.eRo.isSelected() ? false : true);
                }
            }
        };
        this.ahe = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bir();
            }
        };
        this.eRw = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eRr = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.biq();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dQ();
        MessageManager.getInstance().registerListener(this.ahe);
        MessageManager.getInstance().registerListener(this.eRw);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eRo = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eRn = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eRp = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eRq = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eRp.setOnClickListener(this.mOnClickListener);
        this.eRq.setOnClickListener(this.mOnClickListener);
        this.eRn.setOnClickListener(this.mOnClickListener);
    }

    private void dQ() {
        this.eRs = new com.baidu.live.k.a();
        this.eRs.a(this.eRv);
    }

    public void yO(String str) {
        this.eRt = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR(int i) {
        int i2 = this.eRo.isSelected() ? 1 : 2;
        if (this.eRs != null) {
            this.eRs.i(this.eRt, i, i2);
        }
    }

    public void biq() {
        if (this.eRm == null || !this.eRm.isShowing()) {
            this.eRo.setSelected(true);
            if (this.eRm == null) {
                this.eRm = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eRm, getPageContext().getPageActivity());
            }
            Window window = this.eRm.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eRm.setContentView(this.mRoot);
            }
            this.eRm.setCanceledOnTouchOutside(false);
            this.eRm.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bir() {
        if (this.eRm != null && this.eRm.isShowing()) {
            this.eRm.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bir();
        if (this.eRs != null) {
            this.eRs.onDestroy();
        }
        if (this.ahe != null) {
            MessageManager.getInstance().unRegisterListener(this.ahe);
        }
        if (this.eRw != null) {
            MessageManager.getInstance().unRegisterListener(this.eRw);
        }
    }
}
