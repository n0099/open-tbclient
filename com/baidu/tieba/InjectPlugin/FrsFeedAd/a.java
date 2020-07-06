package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.m;
/* loaded from: classes8.dex */
public class a extends f {
    protected m eSv;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(m mVar, BdUniqueId bdUniqueId) {
        super(mVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.eSv = mVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a pm = ((com.baidu.tieba.InjectPlugin.a.b) this.eSv).pm(1);
            if (pm instanceof d) {
                return ((d) pm).getView(i, view, viewGroup, bVar.bmw());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public ad.a a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a pm = ((com.baidu.tieba.InjectPlugin.a.b) this.eSv).pm(1);
            if (pm instanceof d) {
                return ((d) pm).a(viewGroup, ((b) obj).bmw());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, ad.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a pm = ((com.baidu.tieba.InjectPlugin.a.b) this.eSv).pm(1);
            if (pm instanceof d) {
                ((d) pm).a(i, viewGroup, aVar, ((b) obj).bmw());
            }
        }
    }
}
