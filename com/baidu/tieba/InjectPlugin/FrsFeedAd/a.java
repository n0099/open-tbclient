package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes8.dex */
public class a extends f {
    protected n dSR;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.dSR = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a nS = ((com.baidu.tieba.InjectPlugin.a.b) this.dSR).nS(1);
            if (nS instanceof d) {
                return ((d) nS).getView(i, view, viewGroup, bVar.aVu());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public v.a a(ViewGroup viewGroup, Object obj) {
        if (b.l(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a nS = ((com.baidu.tieba.InjectPlugin.a.b) this.dSR).nS(1);
            if (nS instanceof d) {
                return ((d) nS).a(viewGroup, ((b) obj).aVu());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a nS = ((com.baidu.tieba.InjectPlugin.a.b) this.dSR).nS(1);
            if (nS instanceof d) {
                ((d) nS).a(i, viewGroup, aVar, ((b) obj).aVu());
            }
        }
    }
}
