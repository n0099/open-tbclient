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
    private View heB;
    private int heC;
    private com.baidu.live.o.a heD;
    private String heE;
    private int heF;
    private a.InterfaceC0201a heG;
    private CustomMessageListener heH;
    private AlertDialog hex;
    private View hey;
    private ImageView hez;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.heC = 1;
        this.heF = 2;
        this.heG = new a.InterfaceC0201a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.o.a.InterfaceC0201a
            public void fk(int i) {
                if (i == 1) {
                    if (a.this.heC == 3) {
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
                a.this.wx(a.this.heF);
                a.this.heF = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.heF = 2;
                    a.this.cai();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.heF = 1;
                    a.this.cai();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.hez.setSelected(a.this.hez.isSelected() ? false : true);
                }
            }
        };
        this.aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.cai();
            }
        };
        this.heH = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.heC = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.cah();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        KR();
        MessageManager.getInstance().registerListener(this.aWM);
        MessageManager.getInstance().registerListener(this.heH);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.hez = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.hey = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.heA = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.heB = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.heA.setOnClickListener(this.mOnClickListener);
        this.heB.setOnClickListener(this.mOnClickListener);
        this.hey.setOnClickListener(this.mOnClickListener);
    }

    private void KR() {
        this.heD = new com.baidu.live.o.a();
        this.heD.a(this.heG);
    }

    public void Ie(String str) {
        this.heE = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx(int i) {
        int i2 = this.hez.isSelected() ? 1 : 2;
        if (this.heD != null) {
            this.heD.i(this.heE, i, i2);
        }
    }

    public void cah() {
        if (this.hex == null || !this.hex.isShowing()) {
            this.hez.setSelected(true);
            if (this.hex == null) {
                this.hex = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.hex, getPageContext().getPageActivity());
            }
            Window window = this.hex.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.hex.setContentView(this.mRoot);
            }
            this.hex.setCanceledOnTouchOutside(false);
            this.hex.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cai() {
        if (this.hex != null && this.hex.isShowing()) {
            this.hex.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        cai();
        if (this.heD != null) {
            this.heD.onDestroy();
        }
        if (this.aWM != null) {
            MessageManager.getInstance().unRegisterListener(this.aWM);
        }
        if (this.heH != null) {
            MessageManager.getInstance().unRegisterListener(this.heH);
        }
    }
}
