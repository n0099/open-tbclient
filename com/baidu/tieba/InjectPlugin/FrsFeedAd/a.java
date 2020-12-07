package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.p;
/* loaded from: classes21.dex */
public class a extends f {
    protected p fUS;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(p pVar, BdUniqueId bdUniqueId) {
        super(pVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.fUS = pVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a ub = ((com.baidu.tieba.InjectPlugin.a.b) this.fUS).ub(1);
            if (ub instanceof d) {
                return ((d) ub).getView(i, view, viewGroup, bVar.bKv());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public af.a a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a ub = ((com.baidu.tieba.InjectPlugin.a.b) this.fUS).ub(1);
            if (ub instanceof d) {
                return ((d) ub).a(viewGroup, ((b) obj).bKv());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, af.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a ub = ((com.baidu.tieba.InjectPlugin.a.b) this.fUS).ub(1);
            if (ub instanceof d) {
                ((d) ub).a(i, viewGroup, aVar, ((b) obj).bKv());
            }
        }
    }
}
