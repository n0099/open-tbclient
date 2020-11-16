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
    private CustomMessageListener aTI;
    private AlertDialog gVd;
    private View gVe;
    private ImageView gVf;
    private View gVg;
    private View gVh;
    private int gVi;
    private com.baidu.live.m.a gVj;
    private String gVk;
    private int gVl;
    private a.InterfaceC0188a gVm;
    private CustomMessageListener gVn;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gVi = 1;
        this.gVl = 2;
        this.gVm = new a.InterfaceC0188a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.m.a.InterfaceC0188a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gVi == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.h.sdk_attention_success));
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
                a.this.vS(a.this.gVl);
                a.this.gVl = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.f.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gVl = 2;
                    a.this.bWu();
                } else if (view.getId() == a.f.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gVl = 1;
                    a.this.bWu();
                } else if (view.getId() == a.f.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.gVf.setSelected(a.this.gVf.isSelected() ? false : true);
                }
            }
        };
        this.aTI = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bWu();
            }
        };
        this.gVn = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gVi = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bWt();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        IQ();
        MessageManager.getInstance().registerListener(this.aTI);
        MessageManager.getInstance().registerListener(this.gVn);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.g.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.gVf = (ImageView) this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_iv);
        this.gVe = this.mRoot.findViewById(a.f.id_ala_attention_guide_selectbox_wrapper);
        this.gVg = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_cancel_btn);
        this.gVh = this.mRoot.findViewById(a.f.id_ala_liveroom_attention_guide_open_btn);
        this.gVg.setOnClickListener(this.mOnClickListener);
        this.gVh.setOnClickListener(this.mOnClickListener);
        this.gVe.setOnClickListener(this.mOnClickListener);
    }

    private void IQ() {
        this.gVj = new com.baidu.live.m.a();
        this.gVj.a(this.gVm);
    }

    public void Hq(String str) {
        this.gVk = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vS(int i) {
        int i2 = this.gVf.isSelected() ? 1 : 2;
        if (this.gVj != null) {
            this.gVj.i(this.gVk, i, i2);
        }
    }

    public void bWt() {
        if (this.gVd == null || !this.gVd.isShowing()) {
            this.gVf.setSelected(true);
            if (this.gVd == null) {
                this.gVd = new AlertDialog.Builder(getPageContext().getPageActivity(), a.i.sdk_dialog_window).create();
                ShowUtil.showDialog(this.gVd, getPageContext().getPageActivity());
            }
            Window window = this.gVd.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.gVd.setContentView(this.mRoot);
            }
            this.gVd.setCanceledOnTouchOutside(false);
            this.gVd.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWu() {
        if (this.gVd != null && this.gVd.isShowing()) {
            this.gVd.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bWu();
        if (this.gVj != null) {
            this.gVj.onDestroy();
        }
        if (this.aTI != null) {
            MessageManager.getInstance().unRegisterListener(this.aTI);
        }
        if (this.gVn != null) {
            MessageManager.getInstance().unRegisterListener(this.gVn);
        }
    }
}
