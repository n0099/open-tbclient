package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.n;
/* loaded from: classes3.dex */
public class a extends f {
    protected n daI;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(n nVar, BdUniqueId bdUniqueId) {
        super(nVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.daI = nVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a ln = ((com.baidu.tieba.InjectPlugin.a.b) this.daI).ln(1);
            if (ln instanceof d) {
                return ((d) ln).getView(i, view, viewGroup, bVar.aAV());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public v.a a(ViewGroup viewGroup, Object obj) {
        if (b.k(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a ln = ((com.baidu.tieba.InjectPlugin.a.b) this.daI).ln(1);
            if (ln instanceof d) {
                return ((d) ln).a(viewGroup, ((b) obj).aAV());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, v.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a ln = ((com.baidu.tieba.InjectPlugin.a.b) this.daI).ln(1);
            if (ln instanceof d) {
                ((d) ln).a(i, viewGroup, aVar, ((b) obj).aAV());
            }
        }
    }
}
