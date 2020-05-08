package com.baidu.tieba.InjectPlugin.FrsFeedAd;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.InjectPlugin.a.f;
import com.baidu.tieba.recapp.m;
/* loaded from: classes8.dex */
public class a extends f {
    protected m etz;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(m mVar, BdUniqueId bdUniqueId) {
        super(mVar.getTbPageContext().getPageActivity(), bdUniqueId);
        this.etz = mVar;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.f, com.baidu.adp.widget.ListView.a
    public View getView(int i, View view, ViewGroup viewGroup, Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            com.baidu.tieba.InjectPlugin.a.a oh = ((com.baidu.tieba.InjectPlugin.a.b) this.etz).oh(1);
            if (oh instanceof d) {
                return ((d) oh).getView(i, view, viewGroup, bVar.bdJ());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public y.a a(ViewGroup viewGroup, Object obj) {
        if (b.l(getType()) != -1 && (obj instanceof b)) {
            com.baidu.tieba.InjectPlugin.a.a oh = ((com.baidu.tieba.InjectPlugin.a.b) this.etz).oh(1);
            if (oh instanceof d) {
                return ((d) oh).a(viewGroup, ((b) obj).bdJ());
            }
            return null;
        }
        return null;
    }

    @Override // com.baidu.adp.widget.ListView.a
    public void a(int i, ViewGroup viewGroup, y.a aVar, Object obj) {
        if (obj instanceof b) {
            com.baidu.tieba.InjectPlugin.a.a oh = ((com.baidu.tieba.InjectPlugin.a.b) this.etz).oh(1);
            if (oh instanceof d) {
                ((d) oh).a(i, viewGroup, aVar, ((b) obj).bdJ());
            }
        }
    }
}
