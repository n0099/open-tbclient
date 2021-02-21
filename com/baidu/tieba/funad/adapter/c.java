package com.baidu.tieba.funad.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.data.n;
import com.fun.ad.sdk.FunNativeAd;
import java.util.List;
/* loaded from: classes5.dex */
public class c extends com.baidu.adp.widget.ListView.a<cb, FunAdCardHolder> implements l, p {
    private BaseFragmentActivity iKH;

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iKH = baseFragmentActivity;
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
    public View a(int i, View view, ViewGroup viewGroup, cb cbVar, FunAdCardHolder funAdCardHolder) {
        n nVar = cbVar.eUi;
        if (nVar == null) {
            return ((FunAdCardHolder) this.Wo).getView();
        }
        if (!nVar.dNr()) {
            nVar.yp(true);
            List<cb> Lr = com.baidu.tieba.h.a.cNq().Lr("6051001642-2027944992");
            if (Lr != null && Lr.size() > 0) {
                nVar.aR(Lr.get(0).eUi.dNp());
                cbVar.ns(com.baidu.tieba.horizonalList.a.a.cI(20, 100));
                com.baidu.tieba.h.a.cNq().y("6051001642-2027944992", Lr.get(0).eUi.dNp());
            } else {
                nVar.aR(null);
            }
            com.baidu.tieba.h.a.cNq().b(this.iKH, "6051001642-2027944992", "c14005", PageStayDurationConstants.PageName.FRS);
        }
        a(funAdCardHolder, cbVar);
        return funAdCardHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.p
    public void setIsFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onPause() {
        if (this.Wo != 0) {
            ((FunAdCardHolder) this.Wo).cNx();
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void onResume() {
        if (this.Wo != 0) {
            ((FunAdCardHolder) this.Wo).cNx();
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void onDestroy() {
        if (this.Wo != 0) {
            ((FunAdCardHolder) this.Wo).cNx();
            com.baidu.tieba.h.a.cNq().a(((FunAdCardHolder) this.Wo).jTL);
        }
    }

    private void a(final FunAdCardHolder funAdCardHolder, final cb cbVar) {
        if (cbVar != null && cbVar.eUi != null && cbVar.eUi.dNp() != null) {
            funAdCardHolder.jTu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    cbVar.eUi.aR(null);
                    c.this.notifyDataSetChanged();
                    TiebaStatic.log(new ar("c14044").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).ap("obj_locate", 0));
                }
            });
            funAdCardHolder.jTC.setAgreeAlone(true);
            funAdCardHolder.jTC.setData(cbVar.bpJ());
            funAdCardHolder.cNz();
            funAdCardHolder.cNy();
            final FunNativeAd funNativeAd = (FunNativeAd) cbVar.eUi.dNp();
            funAdCardHolder.rN(com.baidu.tieba.funad.c.b(funNativeAd));
            com.baidu.tieba.h.a.cNq().a(funAdCardHolder.a(cbVar.eUi), new a.e() { // from class: com.baidu.tieba.funad.adapter.c.2
                @Override // com.baidu.tieba.h.a.e
                public void onAdClicked(String str) {
                    TiebaStatic.log(new ar("c14053").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).ap("obj_locate", 0));
                    if (funAdCardHolder.jTt != null && com.baidu.tieba.funad.c.c(funNativeAd)) {
                        funAdCardHolder.jTt.setTextDelay(c.this.mContext.getString(R.string.fun_ad_downloading), 1000L);
                    }
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdShow(String str) {
                    TiebaStatic.log(new ar("c14006").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).ap("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdError(String str, int i, String str2) {
                    TiebaStatic.log(new ar("c14006").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.FRS).ap("obj_locate", 1));
                }
            });
            funAdCardHolder.jTB.setText(funAdCardHolder.jTc.getText());
            funAdCardHolder.itemView.setVisibility(0);
            funAdCardHolder.cNA();
            funAdCardHolder.jTK.setViewData(funNativeAd, this.iKH.getActivity(), funAdCardHolder.jTc.getText(), PageStayDurationConstants.PageName.FRS);
            funAdCardHolder.Bg(TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
