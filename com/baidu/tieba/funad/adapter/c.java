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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
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
/* loaded from: classes15.dex */
public class c extends com.baidu.adp.widget.ListView.a<bz, FunAdCardHolder> implements k, o {
    private BaseFragmentActivity iJr;

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iJr = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bM */
    public FunAdCardHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fun_ad_card_holder, (ViewGroup) null);
        inflate.setId(R.id.fun_ad_card_templete);
        inflate.setVisibility(8);
        return new FunAdCardHolder(inflate);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, bz bzVar, FunAdCardHolder funAdCardHolder) {
        n nVar = bzVar.eWF;
        if (nVar == null) {
            return ((FunAdCardHolder) this.Wu).getView();
        }
        if (!nVar.dOQ()) {
            nVar.ya(true);
            List<bz> LM = com.baidu.tieba.h.a.cPn().LM("6051001001-2043781376");
            if (LM != null && LM.size() > 0) {
                nVar.aR(LM.get(0).eWF.dOO());
                bzVar.oV(com.baidu.tieba.horizonalList.a.a.cK(20, 100));
                com.baidu.tieba.h.a.cPn().A("6051001001-2043781376", LM.get(0).eWF.dOO());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921527));
            } else {
                nVar.aR(null);
            }
        }
        a(funAdCardHolder, bzVar);
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
        if (this.Wu != 0) {
            com.baidu.tieba.h.a.cPn().a(((FunAdCardHolder) this.Wu).jQX);
        }
    }

    private void a(final FunAdCardHolder funAdCardHolder, final bz bzVar) {
        if (bzVar != null && bzVar.eWF != null && bzVar.eWF.dOO() != null) {
            funAdCardHolder.jQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    bzVar.eWF.aR(null);
                    c.this.notifyDataSetChanged();
                    TiebaStatic.log(new aq("c14044").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                }
            });
            funAdCardHolder.jQQ.setAgreeAlone(true);
            funAdCardHolder.jQQ.setData(bzVar.btl());
            funAdCardHolder.cPv();
            funAdCardHolder.cPu();
            com.baidu.tieba.h.a.cPn().a(funAdCardHolder.a(bzVar.eWF), new a.e() { // from class: com.baidu.tieba.funad.adapter.c.2
                @Override // com.baidu.tieba.h.a.e
                public void onAdClicked(String str) {
                    TiebaStatic.log(new aq("c14053").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                    Object dOO = bzVar.eWF.dOO();
                    if (!(dOO instanceof FunNativeAd) || ((FunNativeAd) dOO).isDownloadAd()) {
                    }
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdShow(String str) {
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdError(String str, int i, String str2) {
                    funAdCardHolder.itemView.setVisibility(8);
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.FRS).an("obj_locate", 1));
                }
            });
            funAdCardHolder.jQP.setText(funAdCardHolder.jQu.getText());
            funAdCardHolder.itemView.setVisibility(0);
            a(funAdCardHolder);
        }
    }

    public void a(FunAdCardHolder funAdCardHolder) {
        WebPManager.a(funAdCardHolder.jQJ, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        funAdCardHolder.jQM.setVisibility(8);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQv).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQu).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQx).pK(R.string.J_X01).pC(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQL).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQp).pK(R.string.J_X06).aM(R.color.CAM_X0205, R.color.CAM_X0206);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQO).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQP).pC(R.color.CAM_X0105);
        funAdCardHolder.jQR.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_share22, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi), WebPManager.ResourceStateType.NORMAL_DISABLE));
        funAdCardHolder.jQT.setImageDrawable(WebPManager.a(R.drawable.icon_pure_card_comment22, com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi), WebPManager.ResourceStateType.NORMAL_DISABLE));
        funAdCardHolder.jQS.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi));
        funAdCardHolder.jQU.setTextColor(com.baidu.tieba.tbadkCore.c.m(ao.getColor(R.color.CAM_X0107), ao.fdi));
        funAdCardHolder.jQN.setVisibility(TbadkCoreApplication.getInst().getSkinType() != 0 ? 0 : 8);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdCardHolder.jQN).setBackGroundColor(R.color.CAM_X0607);
    }
}
