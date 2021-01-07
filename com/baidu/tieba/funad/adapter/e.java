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
/* loaded from: classes15.dex */
public class e extends com.baidu.adp.widget.ListView.a<bz, FunAdNativeHolder> implements k, o {
    private BaseFragmentActivity iJr;

    public e(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iJr = baseFragmentActivity;
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
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQN).setBackGroundColor(R.color.CAM_X0607);
        return funAdNativeHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, final bz bzVar, final FunAdNativeHolder funAdNativeHolder) {
        if (bzVar != null && bzVar.eWF != null && bzVar.eWF.dOO() != null) {
            a(funAdNativeHolder);
            funAdNativeHolder.jQJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921523, bzVar.eWF));
                    TiebaStatic.log(new aq("c14044").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB));
                }
            });
            if (funAdNativeHolder.jQX == null || funAdNativeHolder.jQX.eWF == null) {
                funAdNativeHolder.b(bzVar.eWF);
            }
            com.baidu.tieba.h.a.cPn().a(funAdNativeHolder.jQX, new a.e() { // from class: com.baidu.tieba.funad.adapter.e.2
                @Override // com.baidu.tieba.h.a.e
                public void onAdClicked(String str) {
                    TiebaStatic.log(new aq("c14053").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdShow(String str) {
                    bzVar.eWF.yc(true);
                    com.baidu.tieba.h.a.cPn().A("6051001308-627527144", bzVar.eWF.dOO());
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 0));
                }

                @Override // com.baidu.tieba.h.a.e
                public void onAdError(String str, int i2, String str2) {
                    funAdNativeHolder.itemView.setVisibility(8);
                    TiebaStatic.log(new aq("c14006").an("obj_source", 6).dX("obj_type", PageStayDurationConstants.PageName.PB).an("obj_locate", 1));
                }
            });
            funAdNativeHolder.itemView.setVisibility(0);
        }
        return funAdNativeHolder.getView();
    }

    public void a(FunAdNativeHolder funAdNativeHolder) {
        WebPManager.a(funAdNativeHolder.jQJ, R.drawable.icon_pure_card_close22, R.color.CAM_X0111, null);
        ao.setBackgroundColor(funAdNativeHolder.jQM, R.color.CAM_X0204);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQv).pC(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQu).pC(R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQL).pC(R.color.CAM_X0101);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQL).pK(R.string.J_X04).setBackGroundColor(R.color.CAM_X0605);
        com.baidu.tbadk.core.elementsMaven.c.bv(funAdNativeHolder.jQx).pK(R.string.J_X01).pC(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0905);
        funAdNativeHolder.jQN.setVisibility(TbadkCoreApplication.getInst().getSkinType() == 0 ? 8 : 0);
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
        if (this.Wu != 0 && ((FunAdNativeHolder) this.Wu).jQX != null && ((FunAdNativeHolder) this.Wu).jQX.eWF != null && ((FunAdNativeHolder) this.Wu).jQX.eWF.dOR()) {
            com.baidu.tieba.h.a.cPn().a(((FunAdNativeHolder) this.Wu).jQX);
        }
    }
}
