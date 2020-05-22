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
    private CustomMessageListener aES;
    private AlertDialog fJI;
    private View fJJ;
    private ImageView fJK;
    private View fJL;
    private View fJM;
    private int fJN;
    private com.baidu.live.k.a fJO;
    private String fJP;
    private int fJQ;
    private a.InterfaceC0167a fJR;
    private CustomMessageListener fJS;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public b(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.fJN = 1;
        this.fJQ = 2;
        this.fJR = new a.InterfaceC0167a() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.1
            @Override // com.baidu.live.k.a.InterfaceC0167a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (b.this.fJN == 3) {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    b.this.mTbPageContext.showToast(b.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.k.a.InterfaceC0167a
            public void onFailed(String str) {
                b.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                b.this.qM(b.this.fJQ);
                b.this.fJQ = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    b.this.fJQ = 2;
                    b.this.bxB();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    b.this.fJQ = 1;
                    b.this.bxB();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    b.this.fJK.setSelected(b.this.fJK.isSelected() ? false : true);
                }
            }
        };
        this.aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                b.this.bxB();
            }
        };
        this.fJS = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.attentionpop.b.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    b.this.fJN = ((Integer) customResponsedMessage.getData()).intValue();
                }
                b.this.bxA();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        AC();
        MessageManager.getInstance().registerListener(this.aES);
        MessageManager.getInstance().registerListener(this.fJS);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fJK = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fJJ = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.fJL = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.fJM = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.fJL.setOnClickListener(this.mOnClickListener);
        this.fJM.setOnClickListener(this.mOnClickListener);
        this.fJJ.setOnClickListener(this.mOnClickListener);
    }

    private void AC() {
        this.fJO = new com.baidu.live.k.a();
        this.fJO.a(this.fJR);
    }

    public void Ch(String str) {
        this.fJP = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qM(int i) {
        int i2 = this.fJK.isSelected() ? 1 : 2;
        if (this.fJO != null) {
            this.fJO.i(this.fJP, i, i2);
        }
    }

    public void bxA() {
        if (this.fJI == null || !this.fJI.isShowing()) {
            this.fJK.setSelected(true);
            if (this.fJI == null) {
                this.fJI = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fJI, getPageContext().getPageActivity());
            }
            Window window = this.fJI.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fJI.setContentView(this.mRoot);
            }
            this.fJI.setCanceledOnTouchOutside(false);
            this.fJI.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxB() {
        if (this.fJI != null && this.fJI.isShowing()) {
            this.fJI.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bxB();
        if (this.fJO != null) {
            this.fJO.onDestroy();
        }
        if (this.aES != null) {
            MessageManager.getInstance().unRegisterListener(this.aES);
        }
        if (this.fJS != null) {
            MessageManager.getInstance().unRegisterListener(this.fJS);
        }
    }
}
