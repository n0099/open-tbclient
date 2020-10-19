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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte jet;
    private TbPageContext<?> pageContext;
    private int ajp = 3;
    private List<com.baidu.adp.widget.ListView.q> jeu = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> jev = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b) {
        this.pageContext = tbPageContext;
        this.jet = b;
        for (int i = 0; i < 6; i++) {
            this.jev.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b));
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.jeu);
    }

    @Override // android.support.v4.view.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.d dVar) {
        if (dVar != null && !com.baidu.tbadk.core.util.y.isEmpty(dVar.cDo())) {
            this.jeu.clear();
            this.jeu.addAll(dVar.cDo());
            for (int i = 0; i < this.jeu.size() && i < this.jev.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jev.get(i);
                bVar.qr(!dVar.cDp());
                bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jeu, i));
            }
            notifyDataSetChanged();
            if (this.jeu.get(0) instanceof com.baidu.tieba.homepage.concern.a.e) {
                com.baidu.tieba.homepage.concern.a.e eVar = (com.baidu.tieba.homepage.concern.a.e) this.jeu.get(0);
                aq aj = new aq("c14004").dK("uid", TbadkApplication.getCurrentAccount()).aj("obj_locate", this.jet).aj("obj_param1", 0);
                if (!StringUtils.isNull(eVar.jeF)) {
                    aj = aj.dK("obj_name", eVar.jeF);
                }
                TiebaStatic.log(aj);
                aq aj2 = new aq("c13643").dK("uid", TbadkApplication.getCurrentAccount()).dK("fid", eVar.cDq()).aj("obj_locate", this.jet);
                TiebaStatic.log(StringUtils.isNull(eVar.jeF) ? aj2 : aj2.dK("obj_name", eVar.jeF));
            }
        }
    }

    @Override // android.support.v4.view.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.jev.get(i).getView());
    }

    @Override // android.support.v4.view.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.jev == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.jev, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.q) com.baidu.tbadk.core.util.y.getItem(this.jeu, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.ajp != i) {
            this.ajp = i;
            if (this.jev != null && this.jev.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.jev) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.q AF(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.jeu) || i >= this.jeu.size()) {
            return null;
        }
        return this.jeu.get(i);
    }

    public void k(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.jev)) {
            for (int i = 0; i < this.jev.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.jev.get(i);
                com.baidu.tieba.homepage.concern.a.e cDx = bVar.cDx();
                if (cDx != null) {
                    for (int i2 = 0; i2 < cDx.jeH.length; i2++) {
                        if (cDx.jeH[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
