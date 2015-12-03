package com.baidu.tieba.homepage.listview.card.d;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.horizonalScrollListView.HorizonalScrollListView;
import com.baidu.tbadk.widget.horizonalScrollListView.f;
import com.baidu.tieba.homepage.listview.card.d.b;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.homepage.listview.c<b> {
    private HorizonalScrollListView bAh;
    private List<b.a> bAi;
    private final int bAj;
    private View.OnClickListener bAk;
    private TbPageContext<?> mPageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(tbPageContext, view);
        this.bAj = 10;
        this.bAk = new d(this);
        this.mPageContext = tbPageContext;
        this.bAh = (HorizonalScrollListView) view.findViewById(n.f.hot_forum_horizonal_view);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.c
    /* renamed from: a */
    public void c(b bVar) {
        super.D(bVar);
        if (StringUtils.isNull(bVar.byY)) {
            this.byH.setVisibility(8);
        } else {
            this.byH.setVisibility(0);
            this.byH.setText(bVar.byY);
            this.byH.setOnClickListener(this.bAk);
        }
        int k = y.k(bVar.bAg);
        if (k == 0) {
            this.bAh.setVisibility(8);
            this.byI.setVisibility(8);
            return;
        }
        this.bAh.setVisibility(0);
        this.byI.setVisibility(0);
        List<b.a> list = bVar.bAg;
        if (k > 10) {
            list = list.subList(0, 10);
        }
        if (this.bAi == null) {
            this.bAi = new ArrayList();
        } else {
            this.bAi.clear();
        }
        this.bAi.addAll(list);
        ArrayList<f> aO = aO(list);
        this.bAh.setLoadMoreClickListener(this.bAk);
        this.bAh.ao("c10543", null);
        this.bAh.a(aO, this.mPageContext);
    }

    private ArrayList<f> aO(List<b.a> list) {
        ArrayList<f> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                b.a aVar = list.get(i2);
                f fVar = new f();
                fVar.forumId = aVar.forumId;
                fVar.forumName = aVar.forumName;
                fVar.forumAvatar = aVar.forumAvatar;
                fVar.isLiked = aVar.isLiked;
                fVar.rank = i2 + 1;
                arrayList.add(fVar);
                i = i2 + 1;
            } else {
                return arrayList;
            }
        }
    }

    @Override // com.baidu.tieba.homepage.listview.c
    public void cZ(int i) {
        this.bAh.cZ(i);
        super.cZ(i);
    }
}
