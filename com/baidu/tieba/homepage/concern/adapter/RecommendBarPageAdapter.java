package com.baidu.tieba.homepage.concern.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte jLh;
    private TbPageContext<?> pageContext;
    private int aku = 3;
    private List<com.baidu.adp.widget.ListView.q> jLi = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jLj = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jLh = b;
        for (int i = 0; i < 6; i++) {
            this.jLj.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jLi);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.y.isEmpty(cVar.cNQ())) {
            this.jLi.clear();
            this.jLi.addAll(cVar.cNQ());
            for (int i = 0; i < this.jLi.size() && i < this.jLj.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jLj.get(i);
                bVar.rw(!cVar.cNR());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jLi, i));
            }
            notifyDataSetChanged();
            if (this.jLi.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.jLi.get(0);
                ar al = new ar("c14004").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLh).al("obj_param1", 0);
                if (!StringUtils.isNull(dVar.jLt)) {
                    al = al.dY("obj_name", dVar.jLt);
                }
                TiebaStatic.log(al);
                ar al2 = new ar("c13643").dY("uid", TbadkApplication.getCurrentAccount()).dY("fid", dVar.cNS()).al("obj_locate", this.jLh);
                TiebaStatic.log(StringUtils.isNull(dVar.jLt) ? al2 : al2.dY("obj_name", dVar.jLt));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jLj.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jLj == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jLj, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jLi, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.aku != i) {
            this.aku = i;
            if (this.jLj != null && this.jLj.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jLj) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q Cy(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jLi) || i >= this.jLi.size()) {
            return null;
        }
        return this.jLi.get(i);
    }

    public void l(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jLj)) {
            for (int i = 0; i < this.jLj.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jLj.get(i);
                com.baidu.tieba.homepage.concern.a.d cNZ = bVar.cNZ();
                if (cNZ != null) {
                    for (int i2 = 0; i2 < cNZ.jLv.length; i2++) {
                        if (cNZ.jLv[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
