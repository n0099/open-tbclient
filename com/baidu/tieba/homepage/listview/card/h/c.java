package com.baidu.tieba.homepage.listview.card.h;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.h.b;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a implements g<b.C0065b> {
    public TbImageView aEB;
    public ViewGroup bAJ;
    public TextView bBA;
    public TextView bBB;
    public View bBC;
    public View bBD;
    public TextView bBE;
    private b.C0065b bBF;
    private int mSkinType;
    private TbPageContext<?> pageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.aEB = null;
        this.bBA = null;
        this.bBB = null;
        this.bBC = null;
        this.bBD = null;
        this.pageContext = null;
        this.bBE = null;
        this.bAJ = null;
        this.pageContext = tbPageContext;
        this.bAJ = (ViewGroup) view.findViewById(n.f.card_hot_live_thread_root);
        this.aEB = (TbImageView) view.findViewById(n.f.hot_live_thread_pic);
        this.aEB.setDrawBorder(true);
        this.aEB.setBorderColor(as.getColor(n.c.black_alpha15));
        this.aEB.setBorderWidth(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1));
        this.bBA = (TextView) view.findViewById(n.f.hot_live_title);
        this.bBB = (TextView) view.findViewById(n.f.hot_live_content_text);
        this.bBE = (TextView) view.findViewById(n.f.hot_live_icon);
        this.bBC = view.findViewById(n.f.top_blank_view);
        this.bBD = view.findViewById(n.f.bottom_blank_view);
        TX();
    }

    private void TX() {
        as.b(this.bBA, n.c.cp_cont_b, 1);
        as.b(this.bBB, n.c.cp_cont_d, 1);
        as.i((View) this.bBE, n.e.icon_zhibo);
        as.i(this.bAJ, n.e.topic_name_selector);
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.C0065b c0065b) {
        if (c0065b != null) {
            this.bBF = c0065b;
            this.aEB.d(c0065b.picUrl, 10, false);
            this.bBA.setText(c0065b.title);
            this.bBB.setText(ax.d(c0065b.bBy, 25, "..."));
            this.bAJ.setOnClickListener(new d(this, c0065b));
            if (c0065b.bBz) {
                this.bBC.setVisibility(0);
                this.bBD.setVisibility(8);
                return;
            }
            this.bBC.setVisibility(0);
            this.bBD.setVisibility(0);
        }
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }
}
