package com.baidu.tieba.homepage.listview.card.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.homepage.listview.card.g.b;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a implements com.baidu.tieba.homepage.listview.g<b.C0064b> {
    public TextView bBf;
    public View bBg;
    public TextView bBh;
    public View bBi;
    public View bBj;
    public ViewGroup bBk;
    public ViewGroup bBl;
    private b.C0064b bBm;
    private int mSkinType;
    private TbPageContext<?> pageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bBf = null;
        this.bBg = null;
        this.bBh = null;
        this.bBi = null;
        this.bBj = null;
        this.pageContext = tbPageContext;
        this.bBk = (ViewGroup) view.findViewById(n.f.topic_left_area);
        this.bBf = (TextView) view.findViewById(n.f.hot_topic_left_text);
        this.bBg = view.findViewById(n.f.divider_line_middle);
        this.bBl = (ViewGroup) view.findViewById(n.f.topic_right_area);
        this.bBh = (TextView) view.findViewById(n.f.hot_topic_right_text);
        this.bBi = view.findViewById(n.f.bottom_view);
        this.bBj = view.findViewById(n.f.divider_line_bottom);
        TX();
    }

    private void TX() {
        as.b(this.bBf, n.c.cp_cont_b, 1);
        as.b(this.bBh, n.c.cp_cont_b, 1);
        as.i((View) this.bBf, n.e.topic_name_selector);
        as.i((View) this.bBh, n.e.topic_name_selector);
        as.j(this.bBg, n.c.cp_bg_line_c);
        as.j(this.bBi, n.c.cp_bg_line_d);
        as.j(this.bBj, n.c.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.C0064b c0064b) {
        if (c0064b != null && c0064b.bBd != null && c0064b.bBe != null) {
            this.bBm = c0064b;
            this.bBf.setText(c0064b.bBd.bBb);
            this.bBk.setOnClickListener(new d(this, c0064b));
            this.bBh.setText(c0064b.bBe.bBb);
            this.bBl.setOnClickListener(new e(this, c0064b));
            if (c0064b.bzd) {
                this.bBj.setVisibility(0);
                this.bBi.setVisibility(8);
                return;
            }
            this.bBj.setVisibility(8);
            this.bBi.setVisibility(0);
        }
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }
}
