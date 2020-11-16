package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.o;
/* loaded from: classes20.dex */
public class a extends f {
    protected o fNh;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(o oVar, BdUniqueId bdUniqueId) {
        super(oVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.fNh = oVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a ty = ((com.baidu.tieba.InjectPlugin.a.b) this.fNh).ty(1);
            if (ty instanceof d) {
                return ((d) ty).getView(i, view, viewGroup, bVar.bGV());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public af.a a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a ty = ((com.baidu.tieba.InjectPlugin.a.b) this.fNh).ty(1);
            if (ty instanceof d) {
                return ((d) ty).a(viewGroup, ((b) obj).bGV());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, af.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a ty = ((com.baidu.tieba.InjectPlugin.a.b) this.fNh).ty(1);
            if (ty instanceof d) {
                ((d) ty).a(i, viewGroup, aVar, ((b) obj).bGV());
            }
        }
    }
}
