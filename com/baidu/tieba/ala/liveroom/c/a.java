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
import com.baidu.live.o.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aWM;
    private View heA;
    private ImageView heB;
    private View heC;
    private View heD;
    private int heE;
    private com.baidu.live.o.a heF;
    private String heG;
    private int heH;
    private a.InterfaceC0201a heI;
    private CustomMessageListener heJ;
    private AlertDialog hez;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.heE = 1;
        this.heH = 2;
        this.heI = new a.InterfaceC0201a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.o.a.InterfaceC0201a
            public void fk(int i) {
                if (i == 1) {
                    if (a.this.heE == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.o.a.InterfaceC0201a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.wx(a.this.heH);
                a.this.heH = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.heH = 2;
                    a.this.caj();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.heH = 1;
                    a.this.caj();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.heB.setSelected(a.this.heB.isSelected() ? false : true);
                }
            }
        };
        this.aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.caj();
            }
        };
        this.heJ = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.heE = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.cai();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        KR();
        MessageManager.getInstance().registerListener(this.aWM);
        MessageManager.getInstance().registerListener(this.heJ);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.heB = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.heA = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.heC = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.heD = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.heC.setOnClickListener(this.mOnClickListener);
        this.heD.setOnClickListener(this.mOnClickListener);
        this.heA.setOnClickListener(this.mOnClickListener);
    }

    private void KR() {
        this.heF = new com.baidu.live.o.a();
        this.heF.a(this.heI);
    }

    public void Ie(String str) {
        this.heG = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(int i) {
        int i2 = this.heB.isSelected() ? 1 : 2;
        if (this.heF != null) {
            this.heF.i(this.heG, i, i2);
        }
    }

    public void cai() {
        if (this.hez == null || !this.hez.isShowing()) {
            this.heB.setSelected(true);
            if (this.hez == null) {
                this.hez = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hez, getPageContext().getPageActivity());
            }
            Window window = this.hez.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hez.setContentView(this.mRoot);
            }
            this.hez.setCanceledOnTouchOutside(false);
            this.hez.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void caj() {
        if (this.hez != null && this.hez.isShowing()) {
            this.hez.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        caj();
        if (this.heF != null) {
            this.heF.onDestroy();
        }
        if (this.aWM != null) {
            MessageManager.getInstance().unRegisterListener(this.aWM);
        }
        if (this.heJ != null) {
            MessageManager.getInstance().unRegisterListener(this.heJ);
        }
    }
}
