package com.baidu.tieba.funad.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.switchs.FunAdSdkSwitch;
import com.baidu.tieba.R;
import com.baidu.tieba.funad.view.FunAdAgreeView;
import com.baidu.tieba.funad.view.FunAdButton;
import com.baidu.tieba.funad.view.FunAdDownloadView;
import com.baidu.tieba.h.a;
import com.baidu.tieba.tbadkCore.data.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class FunAdCardHolder extends TypeAdapter.ViewHolder {
    public Context context;
    public ViewGroup jSJ;
    public List<View> jSK;
    public List<View> jSL;
    public ImageView jSM;
    public ImageView jSN;
    public TextView jSO;
    public TextView jSP;
    public FrameLayout jSQ;
    public FunAdButton jTf;
    public ImageView jTg;
    public CardView jTh;
    public TextView jTi;
    public View jTj;
    public View jTk;
    private FunAdButton jTl;
    public TextView jTm;
    public TextView jTn;
    public FunAdAgreeView jTo;
    public ImageView jTp;
    public TextView jTq;
    public ImageView jTr;
    public TextView jTs;
    public ViewGroup jTt;
    public ViewGroup jTu;
    private ViewGroup jTv;
    public FunAdDownloadView jTw;
    public a.C0742a jTx;
    private int mSkinType;

    public FunAdCardHolder(View view) {
        super(view);
        this.mSkinType = 3;
        am(view);
    }

    private void am(View view) {
        this.context = view.getContext();
        this.jSJ = (ViewGroup) view;
        this.jSO = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jSP = (TextView) view.findViewById(R.id.fun_card_title);
        this.jSQ = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jTg = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jTj = view.findViewById(R.id.divider_with_reply_title);
        this.jTi = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jTh = (CardView) view.findViewById(R.id.media_bg);
        this.jTk = view.findViewById(R.id.media_mask);
        this.jSM = (ImageView) view.findViewById(R.id.top_ad_logo);
        this.jTn = (TextView) view.findViewById(R.id.top_ad_name);
        this.jTm = (TextView) view.findViewById(R.id.top_ad_justnow);
        this.jTo = (FunAdAgreeView) view.findViewById(R.id.ad_agree_view);
        this.jTr = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jTs = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jTp = (ImageView) view.findViewById(R.id.share_num_img);
        this.jTq = (TextView) view.findViewById(R.id.share_num);
        this.jTt = (ViewGroup) view.findViewById(R.id.layout_card_top);
        this.jTu = (ViewGroup) view.findViewById(R.id.layout_card);
        this.jTv = (ViewGroup) view.findViewById(R.id.fun_ad_bottom);
        this.jTw = (FunAdDownloadView) view.findViewById(R.id.fun_ad_download_container);
        this.jTl = (FunAdButton) view.findViewById(R.id.fun_ad_button);
        this.jSK = new ArrayList();
        this.jSK.add(this.jTt);
        this.jSK.add(this.jSQ);
        this.jSK.add(this.jTw);
        this.jSK.add(this.jTu);
        this.jSK.add(this.jTv);
        this.jSL = new ArrayList(1);
        cNs();
    }

    public void rN(boolean z) {
        this.jSL.remove(this.jTf);
        this.jSK.remove(this.jTf);
        if (FunAdSdkSwitch.isOn() && z) {
            this.jTw.setVisibility(0);
            this.jTl.setVisibility(8);
            this.jTf = this.jTw.getDownloadButton();
        } else {
            this.jTw.setVisibility(8);
            this.jTl.setVisibility(0);
            this.jTf = this.jTl;
        }
        this.jSK.add(this.jTf);
        this.jSL.add(this.jTf);
    }

    public void cNq() {
        this.jTl.onDestroy();
        this.jTw.getDownloadButton().onDestroy();
    }

    public void cNr() {
        if (this.jSQ != null) {
            this.jSQ.removeAllViews();
        }
    }

    public a.C0742a a(n nVar) {
        if (nVar == null) {
            return null;
        }
        this.jTx = new a.C0742a();
        this.jTx.eUi = nVar;
        this.jTx.jSJ = this.jSJ;
        this.jTx.jSK = this.jSK;
        this.jTx.jSL = this.jSL;
        this.jTx.jSM = this.jSM;
        this.jTx.jSN = this.jSN;
        this.jTx.jSO = this.jSO;
        this.jTx.jSP = this.jSP;
        this.jTx.jSQ = this.jSQ;
        this.jTx.jSR = this.jTf;
        return this.jTx;
    }

    public void cNs() {
        a(0, -1, 0, 1.0f, true, true);
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        C(z, z2);
    }

    private void C(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jTo.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.jTo.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.getDimens(this.context, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.jTo.setLayoutParams(layoutParams);
        }
    }

    public void Bg(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            WebPManager.a(this.jTg, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            this.jTj.setVisibility(8);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jSP).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jSO).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTl).og(R.string.J_X01).nY(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTi).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jSJ).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTm).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTn).nY(R.color.CAM_X0105);
            this.jTp.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_share22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.jTr.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_comment22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.jTq.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
            this.jTs.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
            this.jTk.setVisibility(TbadkCoreApplication.getInst().getSkinType() != 0 ? 0 : 8);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTk).setBackGroundColor(R.color.CAM_X0607);
            this.jTw.Bg(i);
        }
    }

    public void cNt() {
        String string = TbadkCoreApplication.getInst().getString(R.string.fun_ad_label);
        if (this.jSO != null && string.equals(this.jSO.getText().toString())) {
            this.jSO.setText(TbadkCoreApplication.getInst().getString(R.string.fun_ad_title_promotion));
            if (this.jTn != null) {
                this.jTn.setText(TbadkCoreApplication.getInst().getString(R.string.fun_ad_title_promotion));
            }
        }
    }
}
