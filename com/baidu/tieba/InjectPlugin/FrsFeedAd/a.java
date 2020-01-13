package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes6.dex */
public class a extends f {
    protected n dOL;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.dOL = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a nB = ((com.baidu.tieba.InjectPlugin.a.b) this.dOL).nB(1);
            if (nB instanceof d) {
                return ((d) nB).getView(i, view, viewGroup, bVar.aTd());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public v.a a(ViewGroup viewGroup, Object obj) {
        if (b.l(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a nB = ((com.baidu.tieba.InjectPlugin.a.b) this.dOL).nB(1);
            if (nB instanceof d) {
                return ((d) nB).a(viewGroup, ((b) obj).aTd());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a nB = ((com.baidu.tieba.InjectPlugin.a.b) this.dOL).nB(1);
            if (nB instanceof d) {
                ((d) nB).a(i, viewGroup, aVar, ((b) obj).aTd());
            }
        }
    }
}
