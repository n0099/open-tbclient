package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class a extends f {
    protected n bhs;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.aiB().getPageActivity(), bdUniqueId);
        this.bhs = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a gh = ((com.baidu.tieba.InjectPlugin.a.b) this.bhs).gh(1);
            if (gh instanceof d) {
                return ((d) gh).getView(i, view, viewGroup, bVar.OG());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public q.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        if (b.i(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a gh = ((com.baidu.tieba.InjectPlugin.a.b) this.bhs).gh(1);
            if (gh instanceof d) {
                return ((d) gh).onCreateViewHolder(viewGroup, ((b) obj).OG());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void onFillViewHolder(int i, ViewGroup viewGroup, q.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a gh = ((com.baidu.tieba.InjectPlugin.a.b) this.bhs).gh(1);
            if (gh instanceof d) {
                ((d) gh).onFillViewHolder(i, viewGroup, aVar, ((b) obj).OG());
            }
        }
    }
}
