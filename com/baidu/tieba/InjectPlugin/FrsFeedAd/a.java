package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes21.dex */
public class a extends f {
    protected n fHO;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.fHO = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a sQ = ((com.baidu.tieba.InjectPlugin.a.b) this.fHO).sQ(1);
            if (sQ instanceof d) {
                return ((d) sQ).getView(i, view, viewGroup, bVar.bFd());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public af.a a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a sQ = ((com.baidu.tieba.InjectPlugin.a.b) this.fHO).sQ(1);
            if (sQ instanceof d) {
                return ((d) sQ).a(viewGroup, ((b) obj).bFd());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, af.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a sQ = ((com.baidu.tieba.InjectPlugin.a.b) this.fHO).sQ(1);
            if (sQ instanceof d) {
                ((d) sQ).a(i, viewGroup, aVar, ((b) obj).bFd());
            }
        }
    }
}
