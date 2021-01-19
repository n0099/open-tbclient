package com.baidu.tieba.funad.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.o;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes14.dex */
public class a extends com.baidu.adp.widget.ListView.a<by, FunAdCardHolder> implements k, o {
    private BaseFragmentActivity iEK;

    public a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iEK = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public FunAdCardHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fun_ad_card_holder, (ViewGroup) null);
        inflate.setId(R.id.fun_ad_card_split_templete);
        inflate.setVisibility(8);
        return new FunAdCardHolder(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, by byVar, FunAdCardHolder funAdCardHolder) {
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        funAdCardHolder.jLJ.setLayoutParams(marginLayoutParams);
        n nVar = byVar.eHK.eRU;
        if (nVar == null) {
            return ((FunAdCardHolder) this.Ws).getView();
        }
        if (!nVar.dKY()) {
            nVar.xW(true);
            List<bz> KD = com.baidu.tieba.h.a.cLv().KD("6051001535-87847998");
            if (KD != null && KD.size() > 0) {
                nVar.aR(KD.get(0).eRU.dKW());
                byVar.eHK.np(com.baidu.tieba.horizonalList.a.a.cK(20, 100));
                com.baidu.tieba.h.a.cLv().A("6051001535-87847998", KD.get(0).eRU.dKW());
            } else {
                nVar.aR(null);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921527));
        }
        a(funAdCardHolder, byVar.eHK);
        return funAdCardHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.o
    public void setIsFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onPause() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.k
    public void onDestroy() {
        if (this.Ws != 0) {
            com.baidu.tieba.h.a.cLv().a(((FunAdCardHolder) this.Ws).jMs);
        }
    }

    private void a(final FunAdCardHolder funAdCardHolder, final bz bzVar) {
        if (bzVar != null && bzVar.eRU != null && bzVar.eRU.dKW() != null) {
            funAdCardHolder.jMe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bzVar.eRU.aR(null);
                    a.this.notifyDataSetChanged();
                    TiebaStatic.log(new aq("c14044").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                }
            });
            funAdCardHolder.jMl.setAgreeAlone(true);
            funAdCardHolder.jMl.setData(bzVar.bpr());
            funAdCardHolder.cLD();
            funAdCardHolder.cLC();
            com.baidu.tieba.h.a.cLv().a(funAdCardHolder.a(bzVar.eRU), new a.e() { // from class: com.baidu.tieba.funad.adapter.a.2
                @Override // com.baidu.tieba.h.a.e
                public void onAdClicked(String str) {
                    TiebaStatic.log(new aq("c14053").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                    Object dKW = bzVar.eRU.dKW();
                    if (!(dKW instanceof FunNativeAd) || ((FunNativeAd) dKW).isDownloadAd()) {
                    }
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdShow(String str) {
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdError(String str, int i, String str2) {
                    funAdCardHolder.itemView.setVisibility(8);
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dW("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 1));
                }
            });
            funAdCardHolder.jMk.setText(funAdCardHolder.jLO.getText());
            funAdCardHolder.itemView.setVisibility(0);
            a(funAdCardHolder);
        }
    }

    public void a(FunAdCardHolder funAdCardHolder) {
        WebPManager.a(funAdCardHolder.jMe, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        funAdCardHolder.jMh.setVisibility(8);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jLP).nV(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jLO).nV(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jLR).od(R.string.J_X01).nV(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jMg).nV(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jLJ).od(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jMj).nV(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jMk).nV(R.color.CAM_X0105);
        funAdCardHolder.jMm.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_share22, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz), WebPManager.ResourceStateType.NORMAL_DISABLE));
        funAdCardHolder.jMo.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_comment22, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz), WebPManager.ResourceStateType.NORMAL_DISABLE));
        funAdCardHolder.jMn.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz));
        funAdCardHolder.jMp.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.eYz));
        funAdCardHolder.jMi.setVisibility(TbadkCoreApplication.getInst().getSkinType() != 0 ? 0 : 8);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jMi).setBackGroundColor(R.color.CAM_X0607);
    }
}
