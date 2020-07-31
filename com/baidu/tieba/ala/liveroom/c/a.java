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
/* loaded from: classes4.dex */
public class a extends com.baidu.tieba.ala.liveroom.a {
    private CustomMessageListener aIJ;
    private AlertDialog fZX;
    private View fZY;
    private ImageView fZZ;
    private View gaa;
    private View gab;
    private int gac;
    private com.baidu.live.l.a gad;
    private String gae;
    private int gaf;
    private a.InterfaceC0169a gag;
    private CustomMessageListener gah;
    private View.OnClickListener mOnClickListener;
    private DialogInterface.OnDismissListener mOnDismissListener;
    private View mRoot;
    private TbPageContext mTbPageContext;

    public a(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.gac = 1;
        this.gaf = 2;
        this.gag = new a.InterfaceC0169a() { // from class: com.baidu.tieba.ala.liveroom.c.a.1
            @Override // com.baidu.live.l.a.InterfaceC0169a
            public void onSuccess(int i) {
                if (i == 1) {
                    if (a.this.gac == 3) {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_firsttime_txt));
                    } else {
                        a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.ala_attention_guide_open_toast_normal_txt));
                    }
                } else if (i == 2) {
                    a.this.mTbPageContext.showToast(a.this.mTbPageContext.getPageActivity().getResources().getString(a.i.sdk_attention_success));
                }
            }

            @Override // com.baidu.live.l.a.InterfaceC0169a
            public void onFailed(String str) {
                a.this.mTbPageContext.showToast(str);
            }
        };
        this.mOnDismissListener = new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.2
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                a.this.rD(a.this.gaf);
                a.this.gaf = 2;
            }
        };
        this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == a.g.id_ala_liveroom_attention_guide_cancel_btn) {
                    a.this.gaf = 2;
                    a.this.bDC();
                } else if (view.getId() == a.g.id_ala_liveroom_attention_guide_open_btn) {
                    a.this.gaf = 1;
                    a.this.bDC();
                } else if (view.getId() == a.g.id_ala_attention_guide_selectbox_wrapper) {
                    a.this.fZZ.setSelected(a.this.fZZ.isSelected() ? false : true);
                }
            }
        };
        this.aIJ = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.liveroom.c.a.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                a.this.bDC();
            }
        };
        this.gah = new CustomMessageListener(2913092) { // from class: com.baidu.tieba.ala.liveroom.c.a.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                    a.this.gac = ((Integer) customResponsedMessage.getData()).intValue();
                }
                a.this.bDB();
            }
        };
        this.mTbPageContext = tbPageContext;
        initView();
        BE();
        MessageManager.getInstance().registerListener(this.aIJ);
        MessageManager.getInstance().registerListener(this.gah);
    }

    private void initView() {
        this.mRoot = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(a.h.ala_liveroom_attention_guide_layout, (ViewGroup) null);
        this.fZZ = (ImageView) this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_iv);
        this.fZY = this.mRoot.findViewById(a.g.id_ala_attention_guide_selectbox_wrapper);
        this.gaa = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_cancel_btn);
        this.gab = this.mRoot.findViewById(a.g.id_ala_liveroom_attention_guide_open_btn);
        this.gaa.setOnClickListener(this.mOnClickListener);
        this.gab.setOnClickListener(this.mOnClickListener);
        this.fZY.setOnClickListener(this.mOnClickListener);
    }

    private void BE() {
        this.gad = new com.baidu.live.l.a();
        this.gad.a(this.gag);
    }

    public void Ds(String str) {
        this.gae = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rD(int i) {
        int i2 = this.fZZ.isSelected() ? 1 : 2;
        if (this.gad != null) {
            this.gad.i(this.gae, i, i2);
        }
    }

    public void bDB() {
        if (this.fZX == null || !this.fZX.isShowing()) {
            this.fZZ.setSelected(true);
            if (this.fZX == null) {
                this.fZX = new AlertDialog.Builder(getPageContext().getPageActivity(), a.j.sdk_dialog_window).create();
                ShowUtil.showDialog(this.fZX, getPageContext().getPageActivity());
            }
            Window window = this.fZX.getWindow();
            if (window != null) {
                window.setGravity(17);
                window.setBackgroundDrawableResource(17170445);
                this.fZX.setContentView(this.mRoot);
            }
            this.fZX.setCanceledOnTouchOutside(false);
            this.fZX.setOnDismissListener(this.mOnDismissListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bDC() {
        if (this.fZX != null && this.fZX.isShowing()) {
            this.fZX.dismiss();
        }
    }

    @Override // com.baidu.tieba.ala.liveroom.a
    public void onDestroy() {
        super.onDestroy();
        bDC();
        if (this.gad != null) {
            this.gad.onDestroy();
        }
        if (this.aIJ != null) {
            MessageManager.getInstance().unRegisterListener(this.aIJ);
        }
        if (this.gah != null) {
            MessageManager.getInstance().unRegisterListener(this.gah);
        }
    }
}
