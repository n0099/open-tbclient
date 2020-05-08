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
    private CustomMessageListener azA;
    private AlertDialog fvL;
    private View fvM;
    private ImageView fvN;
    private View fvO;
    private View fvP;
    private int fvQ;
    private com.baidu.live.k.a fvR;
    private String fvS;
    private int fvT;
    private a.InterfaceC0137a fvU;
    private CustomMessageListener fvV;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fvQ = 1;
        this.fvT = 2;
        this.fvU = new a.InterfaceC0137a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0137a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.fvQ == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0137a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.ql(b.this.fvT);
                b.this.fvT = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.fvT = 2;
                    b.this.brH();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.fvT = 1;
                    b.this.brH();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.fvN.setSelected(b.this.fvN.isSelected() ? false : true);
                }
            }
        };
        this.azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.brH();
            }
        };
        this.fvV = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.fvQ = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.brG();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        zp();
        MessageManager.getInstance().registerListener(this.azA);
        MessageManager.getInstance().registerListener(this.fvV);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fvN = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fvM = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.fvO = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.fvP = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.fvO.setOnClickListener(this.mOnClickListener);
        this.fvP.setOnClickListener(this.mOnClickListener);
        this.fvM.setOnClickListener(this.mOnClickListener);
    }

    private void zp() {
        this.fvR = new com.baidu.live.k.a();
        this.fvR.a(this.fvU);
    }

    public void Az(String str) {
        this.fvS = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql(int i) {
        int i2 = this.fvN.isSelected() ? 1 : 2;
        if (this.fvR != null) {
            this.fvR.i(this.fvS, i, i2);
        }
    }

    public void brG() {
        if (this.fvL == null || !this.fvL.isShowing()) {
            this.fvN.setSelected(true);
            if (this.fvL == null) {
                this.fvL = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fvL, getPageContext().getPageActivity());
            }
            Window window = this.fvL.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fvL.setContentView(this.mRoot);
            }
            this.fvL.setCanceledOnTouchOutside(false);
            this.fvL.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brH() {
        if (this.fvL != null && this.fvL.isShowing()) {
            this.fvL.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        brH();
        if (this.fvR != null) {
            this.fvR.onDestroy();
        }
        if (this.azA != null) {
            MessageManager.getInstance().unRegisterListener(this.azA);
        }
        if (this.fvV != null) {
            MessageManager.getInstance().unRegisterListener(this.fvV);
        }
    }
}
