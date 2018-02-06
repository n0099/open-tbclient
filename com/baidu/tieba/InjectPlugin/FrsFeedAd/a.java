package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class a extends f {
    protected n bNC;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.akO().getPageActivity(), bdUniqueId);
        this.bNC = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a jc = ((com.baidu.tieba.InjectPlugin.a.b) this.bNC).jc(1);
            if (jc instanceof d) {
                return ((d) jc).getView(i, view, viewGroup, bVar.Sn());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public r.a onCreateViewHolder(ViewGroup viewGroup, Object obj) {
        if (b.i(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a jc = ((com.baidu.tieba.InjectPlugin.a.b) this.bNC).jc(1);
            if (jc instanceof d) {
                return ((d) jc).onCreateViewHolder(viewGroup, ((b) obj).Sn());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void onFillViewHolder(int i, ViewGroup viewGroup, r.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a jc = ((com.baidu.tieba.InjectPlugin.a.b) this.bNC).jc(1);
            if (jc instanceof d) {
                ((d) jc).onFillViewHolder(i, viewGroup, aVar, ((b) obj).Sn());
            }
        }
    }
}
