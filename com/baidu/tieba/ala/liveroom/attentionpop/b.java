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
    private CustomMessageListener azu;
    private AlertDialog fvG;
    private View fvH;
    private ImageView fvI;
    private View fvJ;
    private View fvK;
    private int fvL;
    private com.baidu.live.k.a fvM;
    private String fvN;
    private int fvO;
    private a.InterfaceC0116a fvP;
    private CustomMessageListener fvQ;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fvL = 1;
        this.fvO = 2;
        this.fvP = new a.InterfaceC0116a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0116a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.fvL == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0116a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.ql(b.this.fvO);
                b.this.fvO = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.fvO = 2;
                    b.this.brJ();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.fvO = 1;
                    b.this.brJ();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.fvI.setSelected(b.this.fvI.isSelected() ? false : true);
                }
            }
        };
        this.azu = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.brJ();
            }
        };
        this.fvQ = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.fvL = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.brI();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        zq();
        MessageManager.getInstance().registerListener(this.azu);
        MessageManager.getInstance().registerListener(this.fvQ);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fvI = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fvH = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.fvJ = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.fvK = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.fvJ.setOnClickListener(this.mOnClickListener);
        this.fvK.setOnClickListener(this.mOnClickListener);
        this.fvH.setOnClickListener(this.mOnClickListener);
    }

    private void zq() {
        this.fvM = new com.baidu.live.k.a();
        this.fvM.a(this.fvP);
    }

    public void Aw(String str) {
        this.fvN = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ql(int i) {
        int i2 = this.fvI.isSelected() ? 1 : 2;
        if (this.fvM != null) {
            this.fvM.i(this.fvN, i, i2);
        }
    }

    public void brI() {
        if (this.fvG == null || !this.fvG.isShowing()) {
            this.fvI.setSelected(true);
            if (this.fvG == null) {
                this.fvG = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fvG, getPageContext().getPageActivity());
            }
            Window window = this.fvG.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fvG.setContentView(this.mRoot);
            }
            this.fvG.setCanceledOnTouchOutside(false);
            this.fvG.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brJ() {
        if (this.fvG != null && this.fvG.isShowing()) {
            this.fvG.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        brJ();
        if (this.fvM != null) {
            this.fvM.onDestroy();
        }
        if (this.azu != null) {
            MessageManager.getInstance().unRegisterListener(this.azu);
        }
        if (this.fvQ != null) {
            MessageManager.getInstance().unRegisterListener(this.fvQ);
        }
    }
}
