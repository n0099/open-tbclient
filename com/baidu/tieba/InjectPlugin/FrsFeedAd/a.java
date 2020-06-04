package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.m;
/* loaded from: classes8.dex */
public class a extends f {
    protected m eIj;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(m mVar, BdUniqueId bdUniqueId) {
        super(mVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.eIj = mVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a oO = ((com.baidu.tieba.InjectPlugin.a.b) this.eIj).oO(1);
            if (oO instanceof d) {
                return ((d) oO).getView(i, view, viewGroup, bVar.bjW());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public aa.a a(ViewGroup viewGroup, Object obj) {
        if (b.n(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a oO = ((com.baidu.tieba.InjectPlugin.a.b) this.eIj).oO(1);
            if (oO instanceof d) {
                return ((d) oO).a(viewGroup, ((b) obj).bjW());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, aa.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a oO = ((com.baidu.tieba.InjectPlugin.a.b) this.eIj).oO(1);
            if (oO instanceof d) {
                ((d) oO).a(i, viewGroup, aVar, ((b) obj).bjW());
            }
        }
    }
}
