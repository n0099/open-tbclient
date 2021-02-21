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
    public ViewGroup jSX;
    public List<View> jSY;
    public List<View> jSZ;
    public TextView jTA;
    public TextView jTB;
    public FunAdAgreeView jTC;
    public ImageView jTD;
    public TextView jTE;
    public ImageView jTF;
    public TextView jTG;
    public ViewGroup jTH;
    public ViewGroup jTI;
    private ViewGroup jTJ;
    public FunAdDownloadView jTK;
    public a.C0743a jTL;
    public ImageView jTa;
    public ImageView jTb;
    public TextView jTc;
    public TextView jTd;
    public FrameLayout jTe;
    public FunAdButton jTt;
    public ImageView jTu;
    public CardView jTv;
    public TextView jTw;
    public View jTx;
    public View jTy;
    private FunAdButton jTz;
    private int mSkinType;

    public FunAdCardHolder(View view) {
        super(view);
        this.mSkinType = 3;
        am(view);
    }

    private void am(View view) {
        this.context = view.getContext();
        this.jSX = (ViewGroup) view;
        this.jTc = (TextView) view.findViewById(R.id.fun_ad_name);
        this.jTd = (TextView) view.findViewById(R.id.fun_card_title);
        this.jTe = (FrameLayout) view.findViewById(R.id.fun_card_content);
        this.jTu = (ImageView) view.findViewById(R.id.fun_ad_feedback);
        this.jTx = view.findViewById(R.id.divider_with_reply_title);
        this.jTw = (TextView) view.findViewById(R.id.fun_ad_lable);
        this.jTv = (CardView) view.findViewById(R.id.media_bg);
        this.jTy = view.findViewById(R.id.media_mask);
        this.jTa = (ImageView) view.findViewById(R.id.top_ad_logo);
        this.jTB = (TextView) view.findViewById(R.id.top_ad_name);
        this.jTA = (TextView) view.findViewById(R.id.top_ad_justnow);
        this.jTC = (FunAdAgreeView) view.findViewById(R.id.ad_agree_view);
        this.jTF = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.jTG = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.jTD = (ImageView) view.findViewById(R.id.share_num_img);
        this.jTE = (TextView) view.findViewById(R.id.share_num);
        this.jTH = (ViewGroup) view.findViewById(R.id.layout_card_top);
        this.jTI = (ViewGroup) view.findViewById(R.id.layout_card);
        this.jTJ = (ViewGroup) view.findViewById(R.id.fun_ad_bottom);
        this.jTK = (FunAdDownloadView) view.findViewById(R.id.fun_ad_download_container);
        this.jTz = (FunAdButton) view.findViewById(R.id.fun_ad_button);
        this.jSY = new ArrayList();
        this.jSY.add(this.jTH);
        this.jSY.add(this.jTe);
        this.jSY.add(this.jTK);
        this.jSY.add(this.jTI);
        this.jSY.add(this.jTJ);
        this.jSZ = new ArrayList(1);
        cNz();
    }

    public void rN(boolean z) {
        this.jSZ.remove(this.jTt);
        this.jSY.remove(this.jTt);
        if (FunAdSdkSwitch.isOn() && z) {
            this.jTK.setVisibility(0);
            this.jTz.setVisibility(8);
            this.jTt = this.jTK.getDownloadButton();
        } else {
            this.jTK.setVisibility(8);
            this.jTz.setVisibility(0);
            this.jTt = this.jTz;
        }
        this.jSY.add(this.jTt);
        this.jSZ.add(this.jTt);
    }

    public void cNx() {
        this.jTz.onDestroy();
        this.jTK.getDownloadButton().onDestroy();
    }

    public void cNy() {
        if (this.jTe != null) {
            this.jTe.removeAllViews();
        }
    }

    public a.C0743a a(n nVar) {
        if (nVar == null) {
            return null;
        }
        this.jTL = new a.C0743a();
        this.jTL.eUi = nVar;
        this.jTL.jSX = this.jSX;
        this.jTL.jSY = this.jSY;
        this.jTL.jSZ = this.jSZ;
        this.jTL.jTa = this.jTa;
        this.jTL.jTb = this.jTb;
        this.jTL.jTc = this.jTc;
        this.jTL.jTd = this.jTd;
        this.jTL.jTe = this.jTe;
        this.jTL.jTf = this.jTt;
        return this.jTL;
    }

    public void cNz() {
        a(0, -1, 0, 1.0f, true, true);
    }

    private void a(int i, int i2, int i3, float f, boolean z, boolean z2) {
        C(z, z2);
    }

    private void C(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jTC.getLayoutParams();
        int i = layoutParams.width;
        float f = layoutParams.weight;
        if (z) {
            float f2 = z2 ? 1.0f : 2.0f;
            if (f != f2 || i != 0) {
                layoutParams.width = 0;
                layoutParams.weight = f2;
                layoutParams.leftMargin = 0;
                layoutParams.rightMargin = 0;
                this.jTC.setLayoutParams(layoutParams);
            }
        } else if (f != 0.0f || i != -2) {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
            layoutParams.leftMargin = l.getDimens(this.context, R.dimen.tbds50);
            layoutParams.rightMargin = 0;
            this.jTC.setLayoutParams(layoutParams);
        }
    }

    public void Bg(int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            WebPManager.a(this.jTu, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
            this.jTx.setVisibility(8);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTd).nY(R.color.CAM_X0105);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTc).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTz).og(R.string.J_X01).nY(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTw).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jSX).og(R.string.J_X06).aJ(R.color.CAM_X0205, R.color.CAM_X0206);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTA).nY(R.color.CAM_X0109);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTB).nY(R.color.CAM_X0105);
            this.jTD.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_share22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.jTF.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_comment22, com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO), WebPManager.ResourceStateType.NORMAL_DISABLE));
            this.jTE.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
            this.jTG.setTextColor(com.baidu.tieba.tbadkCore.c.l(ap.getColor(R.color.CAM_X0107), ap.faO));
            this.jTy.setVisibility(TbadkCoreApplication.getInst().getSkinType() != 0 ? 0 : 8);
            com.baidu.tbadk.core.elementsMaven.c.br(this.jTy).setBackGroundColor(R.color.CAM_X0607);
            this.jTK.Bg(i);
        }
    }

    public void cNA() {
        String string = TbadkCoreApplication.getInst().getString(R.string.fun_ad_label);
        if (this.jTc != null && string.equals(this.jTc.getText().toString())) {
            this.jTc.setText(TbadkCoreApplication.getInst().getString(R.string.fun_ad_title_promotion));
            if (this.jTB != null) {
                this.jTB.setText(TbadkCoreApplication.getInst().getString(R.string.fun_ad_title_promotion));
            }
        }
    }
}
