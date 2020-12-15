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
    private byte jLj;
    private TbPageContext<?> pageContext;
    private int aku = 3;
    private List<com.baidu.adp.widget.ListView.q> jLk = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jLl = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jLj = b;
        for (int i = 0; i < 6; i++) {
            this.jLl.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jLk);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.y.isEmpty(cVar.cNR())) {
            this.jLk.clear();
            this.jLk.addAll(cVar.cNR());
            for (int i = 0; i < this.jLk.size() && i < this.jLl.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jLl.get(i);
                bVar.rw(!cVar.cNS());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jLk, i));
            }
            notifyDataSetChanged();
            if (this.jLk.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.jLk.get(0);
                ar al = new ar("c14004").dY("uid", TbadkApplication.getCurrentAccount()).al("obj_locate", this.jLj).al("obj_param1", 0);
                if (!StringUtils.isNull(dVar.jLv)) {
                    al = al.dY("obj_name", dVar.jLv);
                }
                TiebaStatic.log(al);
                ar al2 = new ar("c13643").dY("uid", TbadkApplication.getCurrentAccount()).dY("fid", dVar.cNT()).al("obj_locate", this.jLj);
                TiebaStatic.log(StringUtils.isNull(dVar.jLv) ? al2 : al2.dY("obj_name", dVar.jLv));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jLl.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jLl == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jLl, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jLk, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.aku != i) {
            this.aku = i;
            if (this.jLl != null && this.jLl.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jLl) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q Cy(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jLk) || i >= this.jLk.size()) {
            return null;
        }
        return this.jLk.get(i);
    }

    public void l(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jLl)) {
            for (int i = 0; i < this.jLl.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jLl.get(i);
                com.baidu.tieba.homepage.concern.a.d cOa = bVar.cOa();
                if (cOa != null) {
                    for (int i2 = 0; i2 < cOa.jLx.length; i2++) {
                        if (cOa.jLx[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
