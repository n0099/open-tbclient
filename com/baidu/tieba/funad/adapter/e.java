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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.h.a;
import com.baidu.tieba.recapp.k;
import com.baidu.tieba.recapp.o;
/* loaded from: classes5.dex */
public class e extends com.baidu.adp.widget.ListView.a<cb, FunAdNativeHolder> implements k, o {
    private BaseFragmentActivity iKt;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iKt = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bO */
    public FunAdNativeHolder e(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fun_ad_single_image, (ViewGroup) null);
        inflate.setId(R.id.fun_ad_templete);
        inflate.setVisibility(8);
        FunAdNativeHolder funAdNativeHolder = new FunAdNativeHolder(inflate);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jTk).setBackGroundColor(R.color.CAM_X0607);
        return funAdNativeHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final cb cbVar, FunAdNativeHolder funAdNativeHolder) {
        if (cbVar != null && cbVar.eUi != null && cbVar.eUi.dNh() != null) {
            a(funAdNativeHolder);
            funAdNativeHolder.jTg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921523, cbVar.eUi));
                    TiebaStatic.log(new ar("c14044").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB));
                }
            });
            if (funAdNativeHolder.jTx == null || funAdNativeHolder.jTx.eUi == null) {
                funAdNativeHolder.b(cbVar.eUi);
            }
            com.baidu.tieba.h.a.cNj().a(funAdNativeHolder.jTx, new a.e() { // from class: com.baidu.tieba.funad.adapter.e.2
                @Override // com.baidu.tieba.h.a.e
                public void onAdClicked(String str) {
                    TiebaStatic.log(new ar("c14053").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).ap("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdShow(String str) {
                    cbVar.eUi.yr(true);
                    com.baidu.tieba.h.a.cNj().y("6051001641-1251655838", cbVar.eUi.dNh());
                    TiebaStatic.log(new ar("c14006").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).ap("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdError(String str, int i2, String str2) {
                    TiebaStatic.log(new ar("c14006").ap("obj_source", 6).dR("obj_type", PageStayDurationConstants.PageName.PB).ap("obj_locate", 1));
                }
            });
            funAdNativeHolder.itemView.setVisibility(0);
        }
        return funAdNativeHolder.getView();
    }

    public void a(FunAdNativeHolder funAdNativeHolder) {
        WebPManager.a(funAdNativeHolder.jTg, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        ap.setBackgroundColor(funAdNativeHolder.jTj, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jSP).nY(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jSO).nY(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jTi).nY(R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jTi).og(R.string.J_X04).setBackGroundColor(R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.br(funAdNativeHolder.jSR).og(R.string.J_X01).nY(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        funAdNativeHolder.jTk.setVisibility(TbadkCoreApplication.getInst().getSkinType() == 0 ? 8 : 0);
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
        if (this.Wo != 0 && ((FunAdNativeHolder) this.Wo).jTx != null && ((FunAdNativeHolder) this.Wo).jTx.eUi != null && ((FunAdNativeHolder) this.Wo).jTx.eUi.dNk()) {
            com.baidu.tieba.h.a.cNj().a(((FunAdNativeHolder) this.Wo).jTx);
        }
    }
}
