package com.baidu.tieba.homepage.concern.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RecommendBarPageAdapter extends PagerAdapter {
    private byte kbt;
    private TbPageContext<?> pageContext;
    private int ajU = 3;
    private List<com.baidu.adp.widget.ListView.n> kbu = new ArrayList(6);
    private List<com.baidu.tieba.homepage.concern.b.b> kbv = new ArrayList(6);

    public RecommendBarPageAdapter(TbPageContext<?> tbPageContext, byte b2) {
        this.pageContext = tbPageContext;
        this.kbt = b2;
        for (int i = 0; i < 6; i++) {
            this.kbv.add(new com.baidu.tieba.homepage.concern.b.b(LayoutInflater.from(this.pageContext.getPageActivity()).inflate(R.layout.recommend_bar_item, (ViewGroup) null, false), this.pageContext, b2));
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return com.baidu.tbadk.core.util.y.getCount(this.kbu);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void a(com.baidu.tieba.homepage.concern.a.c cVar) {
        if (cVar != null && !com.baidu.tbadk.core.util.y.isEmpty(cVar.cPc())) {
            this.kbu.clear();
            this.kbu.addAll(cVar.cPc());
            for (int i = 0; i < this.kbu.size() && i < this.kbv.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.kbv.get(i);
                bVar.sb(!cVar.cPd());
                bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(this.kbu, i));
            }
            notifyDataSetChanged();
            if (this.kbu.get(0) instanceof com.baidu.tieba.homepage.concern.a.d) {
                com.baidu.tieba.homepage.concern.a.d dVar = (com.baidu.tieba.homepage.concern.a.d) this.kbu.get(0);
                ar ap = new ar("c14004").dR("uid", TbadkApplication.getCurrentAccount()).ap("obj_locate", this.kbt).ap("obj_param1", 0);
                if (!StringUtils.isNull(dVar.kbF)) {
                    ap = ap.dR("obj_name", dVar.kbF);
                }
                TiebaStatic.log(ap);
                ar ap2 = new ar("c13643").dR("uid", TbadkApplication.getCurrentAccount()).dR("fid", dVar.cPe()).ap("obj_locate", this.kbt);
                TiebaStatic.log(StringUtils.isNull(dVar.kbF) ? ap2 : ap2.dR("obj_name", dVar.kbF));
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView(this.kbv.get(i).getView());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.kbv == null) {
            return super.instantiateItem(viewGroup, i);
        }
        com.baidu.tieba.homepage.concern.b.b bVar = (com.baidu.tieba.homepage.concern.b.b) com.baidu.tbadk.core.util.y.getItem(this.kbv, i);
        if (bVar == null) {
            return super.instantiateItem(viewGroup, i);
        }
        if (bVar.getView().getParent() == null) {
            viewGroup.addView(bVar.getView(), new ViewGroup.LayoutParams(-2, -2));
        }
        bVar.getView().setTag(Integer.valueOf(i));
        bVar.a((com.baidu.adp.widget.ListView.n) com.baidu.tbadk.core.util.y.getItem(this.kbu, i));
        return bVar.getView();
    }

    public void onSkinTypeChanged(int i) {
        if (this.ajU != i) {
            this.ajU = i;
            if (this.kbv != null && this.kbv.size() > 0) {
                for (com.baidu.tieba.homepage.concern.b.b bVar : this.kbv) {
                    bVar.onSkinTypeChanged(i);
                }
            }
        }
    }

    public com.baidu.adp.widget.ListView.n Bv(int i) {
        if (com.baidu.tbadk.core.util.y.isEmpty(this.kbu) || i >= this.kbu.size()) {
            return null;
        }
        return this.kbu.get(i);
    }

    public void n(long j, boolean z) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(this.kbv)) {
            for (int i = 0; i < this.kbv.size(); i++) {
                com.baidu.tieba.homepage.concern.b.b bVar = this.kbv.get(i);
                com.baidu.tieba.homepage.concern.a.d cPl = bVar.cPl();
                if (cPl != null) {
                    for (int i2 = 0; i2 < cPl.kbH.length; i2++) {
                        if (cPl.kbH[i2].getForumId() == j) {
                            bVar.W(i2, z);
                        }
                    }
                }
            }
        }
    }
}
