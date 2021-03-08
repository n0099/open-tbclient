package com.baidu.tieba.funad.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ca;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.funad.view.FunAdNativeFrsView;
import com.baidu.tieba.funad.view.FunAdNativePbView;
import com.baidu.tieba.recapp.l;
import com.baidu.tieba.recapp.p;
import com.baidu.tieba.tbadkCore.data.n;
/* loaded from: classes5.dex */
public class b extends com.baidu.adp.widget.ListView.a<com.baidu.tbadk.core.data.a, FunAdNativeViewHolder> implements l, p {
    private final BaseFragmentActivity iMq;

    public b(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        super(baseFragmentActivity, bdUniqueId);
        this.iMq = baseFragmentActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bN */
    public FunAdNativeViewHolder e(ViewGroup viewGroup) {
        return new FunAdNativeViewHolder(this.XG == AdvertAppInfo.eMN ? new FunAdNativeFrsView(this.iMq) : new FunAdNativePbView(this.iMq), this.iMq, this.XG);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tbadk.core.data.a aVar, final FunAdNativeViewHolder funAdNativeViewHolder) {
        final n nVar;
        if (aVar instanceof ca) {
            nVar = ((ca) aVar).eLr.eVH;
        } else if (aVar instanceof cb) {
            nVar = ((cb) aVar).eVH;
        } else {
            nVar = null;
        }
        if (nVar == null) {
            return funAdNativeViewHolder.getView();
        }
        if (this.XG == AdvertAppInfo.eMN) {
            if (!com.baidu.tieba.h.a.cNx().aq(this.iMq)) {
                funAdNativeViewHolder.cNE().Bi(8);
                return funAdNativeViewHolder.getView();
            }
            funAdNativeViewHolder.cNE().Bi(0);
        }
        funAdNativeViewHolder.E(new View.OnClickListener() { // from class: com.baidu.tieba.funad.adapter.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                nVar.yp(true);
                b.this.notifyDataSetChanged();
                TiebaStatic.log(new ar("c14044").aq("obj_source", 6).dR("obj_type", funAdNativeViewHolder.cNE().getPageType()).aq("obj_locate", 0));
            }
        });
        funAdNativeViewHolder.cNE().cNF();
        funAdNativeViewHolder.a(nVar);
        return funAdNativeViewHolder.getView();
    }

    @Override // com.baidu.tieba.recapp.p
    public void setIsFromCDN(boolean z) {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onPause() {
        if (this.XI != 0 && ((FunAdNativeViewHolder) this.XI).cNE() != null) {
            ((FunAdNativeViewHolder) this.XI).cNE().cNG();
        }
    }

    @Override // com.baidu.tieba.recapp.l
    public void onResume() {
    }

    @Override // com.baidu.tieba.recapp.l
    public void onDestroy() {
        if (this.XI != 0 && ((FunAdNativeViewHolder) this.XI).eVH != null) {
            if (((FunAdNativeViewHolder) this.XI).cNE() != null) {
                ((FunAdNativeViewHolder) this.XI).cNE().cNG();
            }
            com.baidu.tieba.h.a.cNx().Lz(this.XG == AdvertAppInfo.eMN ? "6051001773-1862514716" : "6051001775-457565154");
        }
    }
}
