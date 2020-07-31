package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes15.dex */
public class a extends f {
    protected n eYQ;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.eYQ = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a pE = ((com.baidu.tieba.InjectPlugin.a.b) this.eYQ).pE(1);
            if (pE instanceof d) {
                return ((d) pE).getView(i, view, viewGroup, bVar.bqq());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public ad.a a(ViewGroup viewGroup, Object obj) {
        if (b.o(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a pE = ((com.baidu.tieba.InjectPlugin.a.b) this.eYQ).pE(1);
            if (pE instanceof d) {
                return ((d) pE).a(viewGroup, ((b) obj).bqq());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, ad.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a pE = ((com.baidu.tieba.InjectPlugin.a.b) this.eYQ).pE(1);
            if (pE instanceof d) {
                ((d) pE).a(i, viewGroup, aVar, ((b) obj).bqq());
            }
        }
    }
}
