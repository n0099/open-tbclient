package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.q;
/* loaded from: classes7.dex */
public class a extends f {
    protected q gdN;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(q qVar, BdUniqueId bdUniqueId) {
        super(qVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.gdN = qVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a sO = ((com.baidu.tieba.InjectPlugin.a.b) this.gdN).sO(1);
            if (sO instanceof d) {
                return ((d) sO).getView(i, view, viewGroup, bVar.bJz());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public TypeAdapter.ViewHolder a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a sO = ((com.baidu.tieba.InjectPlugin.a.b) this.gdN).sO(1);
            if (sO instanceof d) {
                return ((d) sO).a(viewGroup, ((b) obj).bJz());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a sO = ((com.baidu.tieba.InjectPlugin.a.b) this.gdN).sO(1);
            if (sO instanceof d) {
                ((d) sO).a(i, viewGroup, viewHolder, ((b) obj).bJz());
            }
        }
    }
}
