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
import com.baidu.live.i.a;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener anV;
    private AlertDialog eLk;
    private View eLl;
    private ImageView eLm;
    private View eLn;
    private View eLo;
    private int eLp;
    private com.baidu.live.i.a eLq;
    private String eLr;
    private int eLs;
    private a.InterfaceC0081a eLt;
    private CustomMessageListener eLu;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.eLp = 1;
        this.eLs = 2;
        this.eLt = new a.InterfaceC0081a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.i.a.InterfaceC0081a
            public void bR(int i) {
                if (i == 1) {
                    if (b.this.eLp == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.i.a.InterfaceC0081a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.pG(b.this.eLs);
                b.this.eLs = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.eLs = 2;
                    b.this.bfA();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.eLs = 1;
                    b.this.bfA();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.eLm.setSelected(b.this.eLm.isSelected() ? false : true);
                }
            }
        };
        this.anV = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bfA();
            }
        };
        this.eLu = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.eLp = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bfz();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        dP();
        MessageManager.getInstance().registerListener(this.anV);
        MessageManager.getInstance().registerListener(this.eLu);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.eLm = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.eLl = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.eLn = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.eLo = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.eLn.setOnClickListener(this.mOnClickListener);
        this.eLo.setOnClickListener(this.mOnClickListener);
        this.eLl.setOnClickListener(this.mOnClickListener);
    }

    private void dP() {
        this.eLq = new com.baidu.live.i.a();
        this.eLq.a(this.eLt);
    }

    public void ym(String str) {
        this.eLr = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pG(int i) {
        int i2 = this.eLm.isSelected() ? 1 : 2;
        if (this.eLq != null) {
            this.eLq.i(this.eLr, i, i2);
        }
    }

    public void bfz() {
        if (this.eLk == null || !this.eLk.isShowing()) {
            this.eLm.setSelected(true);
            if (this.eLk == null) {
                this.eLk = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.eLk, getPageContext().getPageActivity());
            }
            Window window = this.eLk.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.eLk.setContentView(this.mRoot);
            }
            this.eLk.setCanceledOnTouchOutside(false);
            this.eLk.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bfA() {
        if (this.eLk != null && this.eLk.isShowing()) {
            this.eLk.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bfA();
        if (this.eLq != null) {
            this.eLq.onDestroy();
        }
        if (this.anV != null) {
            MessageManager.getInstance().unRegisterListener(this.anV);
        }
        if (this.eLu != null) {
            MessageManager.getInstance().unRegisterListener(this.eLu);
        }
    }
}
