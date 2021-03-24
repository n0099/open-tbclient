package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import d.b.b.j.e.a;
import d.b.i0.b1.c.n;
/* loaded from: classes4.dex */
public class RelateCardForumAdapter extends a<n, CardGroupRelateForumHolder> {
    public HotTopicActivity m;
    public boolean n;
    public BdUniqueId o;

    /* loaded from: classes4.dex */
    public class CardGroupRelateForumHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f17535a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.i0.b1.f.a f17536b;

        public CardGroupRelateForumHolder(RelateCardForumAdapter relateCardForumAdapter, d.b.i0.b1.f.a aVar) {
            super(aVar.m());
            this.f17535a = 3;
            this.f17536b = aVar;
        }

        public void b(int i) {
            if (this.f17535a != i) {
                d.b.i0.b1.f.a aVar = this.f17536b;
                if (aVar != null) {
                    aVar.o(aVar.l(), i);
                }
                this.f17535a = i;
            }
        }
    }

    public RelateCardForumAdapter(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.n = true;
        this.o = null;
        this.m = hotTopicActivity;
        hotTopicActivity.getPageContext();
    }

    public BdUniqueId h0() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: i0 */
    public CardGroupRelateForumHolder R(ViewGroup viewGroup) {
        d.b.i0.b1.f.a aVar = new d.b.i0.b1.f.a(this.m.getPageContext());
        aVar.r(h0());
        aVar.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
        this.n = true;
        return new CardGroupRelateForumHolder(this, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.b.j.e.a
    /* renamed from: j0 */
    public View X(int i, View view, ViewGroup viewGroup, n nVar, CardGroupRelateForumHolder cardGroupRelateForumHolder) {
        d.b.i0.b1.f.a aVar;
        if (cardGroupRelateForumHolder == null || (aVar = cardGroupRelateForumHolder.f17536b) == null) {
            return null;
        }
        if (this.n) {
            aVar.n(nVar);
            this.n = false;
        }
        cardGroupRelateForumHolder.b(TbadkCoreApplication.getInst().getSkinType());
        return cardGroupRelateForumHolder.a();
    }
}
