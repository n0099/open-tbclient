package com.baidu.tieba.hottopic.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
import com.baidu.wallet.BaiduWalletServiceProviderMap;
import d.a.c.k.e.a;
import d.a.n0.d1.c.n;
/* loaded from: classes4.dex */
public class RelateCardForumAdapter extends a<n, CardGroupRelateForumHolder> {
    public HotTopicActivity m;
    public boolean n;
    public BdUniqueId o;

    /* loaded from: classes4.dex */
    public class CardGroupRelateForumHolder extends TypeAdapter.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        public int f16815a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.n0.d1.f.a f16816b;

        public CardGroupRelateForumHolder(RelateCardForumAdapter relateCardForumAdapter, d.a.n0.d1.f.a aVar) {
            super(aVar.m());
            this.f16815a = 3;
            this.f16816b = aVar;
        }

        public void b(int i2) {
            if (this.f16815a != i2) {
                d.a.n0.d1.f.a aVar = this.f16816b;
                if (aVar != null) {
                    aVar.o(aVar.k(), i2);
                }
                this.f16815a = i2;
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

    public BdUniqueId e0() {
        return this.o;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public CardGroupRelateForumHolder Q(ViewGroup viewGroup) {
        d.a.n0.d1.f.a aVar = new d.a.n0.d1.f.a(this.m.getPageContext());
        aVar.q(e0());
        aVar.setFrom(BaiduWalletServiceProviderMap.PLUGIN_WALLETHOME);
        this.n = true;
        return new CardGroupRelateForumHolder(this, aVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: h0 */
    public View X(int i2, View view, ViewGroup viewGroup, n nVar, CardGroupRelateForumHolder cardGroupRelateForumHolder) {
        d.a.n0.d1.f.a aVar;
        if (cardGroupRelateForumHolder == null || (aVar = cardGroupRelateForumHolder.f16816b) == null) {
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
