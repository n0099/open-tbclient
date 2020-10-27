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
import com.baidu.live.m.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aUb;
    private int gPA;
    private a.InterfaceC0188a gPB;
    private CustomMessageListener gPC;
    private AlertDialog gPs;
    private View gPt;
    private ImageView gPu;
    private View gPv;
    private View gPw;
    private int gPx;
    private com.baidu.live.m.a gPy;
    private String gPz;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gPx = 1;
        this.gPA = 2;
        this.gPB = new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.m.a.InterfaceC0188a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gPx == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.m.a.InterfaceC0188a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.vh(a.this.gPA);
                a.this.gPA = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gPA = 2;
                    a.this.bUB();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gPA = 1;
                    a.this.bUB();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gPu.setSelected(a.this.gPu.isSelected() ? false : true);
                }
            }
        };
        this.aUb = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bUB();
            }
        };
        this.gPC = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gPx = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bUA();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        IY();
        MessageManager.getInstance().registerListener(this.aUb);
        MessageManager.getInstance().registerListener(this.gPC);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gPu = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.gPt = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gPv = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gPw = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gPv.setOnClickListener(this.mOnClickListener);
        this.gPw.setOnClickListener(this.mOnClickListener);
        this.gPt.setOnClickListener(this.mOnClickListener);
    }

    private void IY() {
        this.gPy = new com.baidu.live.m.a();
        this.gPy.a(this.gPB);
    }

    public void Hx(String str) {
        this.gPz = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vh(int i) {
        int i2 = this.gPu.isSelected() ? 1 : 2;
        if (this.gPy != null) {
            this.gPy.i(this.gPz, i, i2);
        }
    }

    public void bUA() {
        if (this.gPs == null || !this.gPs.isShowing()) {
            this.gPu.setSelected(true);
            if (this.gPs == null) {
                this.gPs = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gPs, getPageContext().getPageActivity());
            }
            Window window = this.gPs.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gPs.setContentView(this.mRoot);
            }
            this.gPs.setCanceledOnTouchOutside(false);
            this.gPs.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUB() {
        if (this.gPs != null && this.gPs.isShowing()) {
            this.gPs.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bUB();
        if (this.gPy != null) {
            this.gPy.onDestroy();
        }
        if (this.aUb != null) {
            MessageManager.getInstance().unRegisterListener(this.aUb);
        }
        if (this.gPC != null) {
            MessageManager.getInstance().unRegisterListener(this.gPC);
        }
    }
}
