package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class a extends f {
    protected n cPI;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.cPI = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a lX = ((com.baidu.tieba.InjectPlugin.a.b) this.cPI).lX(1);
            if (lX instanceof d) {
                return ((d) lX).getView(i, view, viewGroup, bVar.azj());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public v.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        if (b.j(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a lX = ((com.baidu.tieba.InjectPlugin.a.b) this.cPI).lX(1);
            if (lX instanceof d) {
                return ((d) lX).onCreateViewHolder(viewGroup, ((b) obj).azj());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void onFillViewHolder(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a lX = ((com.baidu.tieba.InjectPlugin.a.b) this.cPI).lX(1);
            if (lX instanceof d) {
                ((d) lX).onFillViewHolder(i, viewGroup, aVar, ((b) obj).azj());
            }
        }
    }
}
