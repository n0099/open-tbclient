package com.baidu.tieba.homepage.listview.card.discover;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.homepage.listview.card.discover.h;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends x.a implements com.baidu.tieba.homepage.listview.g<h.a> {
    private View MF;
    private ViewGroup bzp;
    private List<i> bzq;
    private h.a bzr;
    private int mSkinType;
    private TbPageContext<?> pageContext;

    public k(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.pageContext = tbPageContext;
        this.bzp = (ViewGroup) view.findViewById(n.f.discover_item_root);
        this.bzq = new ArrayList();
        this.MF = view.findViewById(n.f.discover_item_bottom_line);
        TX();
    }

    private void TX() {
        as.j(this.MF, n.c.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(h.a aVar) {
        if (aVar == null) {
            getView().setVisibility(8);
            return;
        }
        this.bzr = aVar;
        if (aVar.bzd) {
            this.MF.setVisibility(8);
        } else {
            this.MF.setVisibility(0);
        }
        if (y.k(aVar.awS) == 0) {
            getView().setVisibility(8);
            return;
        }
        getView().setVisibility(0);
        com.baidu.tieba.homepage.fragment.a.b.a(this.pageContext.getPageActivity(), this.bzp, aVar.awS, h.b.class, this.bzq, i.class);
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
            int k = y.k(this.bzq);
            for (int i2 = 0; i2 < k; i2++) {
                i iVar = (i) y.b(this.bzq, i2);
                if (iVar != null) {
                    iVar.cZ(i);
                }
            }
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }
}
