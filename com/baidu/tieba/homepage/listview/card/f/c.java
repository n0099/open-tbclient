package com.baidu.tieba.homepage.listview.card.f;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.f.b;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class c extends x.a implements com.baidu.tieba.homepage.listview.g<b.a> {
    public TbImageView aEB;
    public TextView aNy;
    public ViewGroup bAJ;
    public View bAK;
    public TextView bAL;
    public TextView bAM;
    public TextView bAN;
    private int mSkinType;
    private TbPageContext<?> pageContext;

    public c(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mSkinType = 3;
        this.bAJ = null;
        this.bAK = null;
        this.aEB = null;
        this.aNy = null;
        this.bAL = null;
        this.bAM = null;
        this.bAN = null;
        this.pageContext = tbPageContext;
        this.bAJ = (ViewGroup) view.findViewById(n.f.hot_thread_item_root);
        this.bAK = view.findViewById(n.f.top_divider_line);
        this.aEB = (TbImageView) view.findViewById(n.f.hot_thread_pic);
        this.aEB.setDrawBorder(true);
        this.aEB.setBorderColor(as.getColor(n.c.black_alpha15));
        this.aEB.setBorderWidth(TbadkCoreApplication.m411getInst().getResources().getDimensionPixelSize(n.d.ds1));
        this.aNy = (TextView) view.findViewById(n.f.hot_thread_title);
        this.bAL = (TextView) view.findViewById(n.f.hot_thread_line_tag);
        this.bAM = (TextView) view.findViewById(n.f.hot_thread_line_praise);
        this.bAN = (TextView) view.findViewById(n.f.hot_thread_line_comment);
        TX();
    }

    private void TX() {
        as.j(this.bAJ, n.c.cp_bg_line_d);
        as.i(this.bAK, n.c.cp_bg_line_c);
        as.b(this.aNy, n.c.cp_cont_b, 1);
        as.i(this.bAJ, n.e.topic_name_selector);
        as.b(this.bAL, n.c.cp_cont_n, 1);
        as.i((View) this.bAL, n.e.label_bg_tie);
        this.bAM.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_hand_normal), (Drawable) null, (Drawable) null, (Drawable) null);
        as.b(this.bAM, n.c.cp_cont_e, 1);
        this.bAN.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_comment_n), (Drawable) null, (Drawable) null, (Drawable) null);
        as.b(this.bAN, n.c.cp_cont_e, 1);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.a aVar) {
        if (aVar != null) {
            this.aEB.d(aVar.picUrl, 10, false);
            this.aNy.setText(aVar.title);
            this.bAL.setText(ax.d(String.valueOf(aVar.forumName) + this.pageContext.getResources().getString(n.i.bar), 7, this.pageContext.getResources().getString(n.i.forum_suffix)));
            this.bAM.setText(ax.v(aVar.bAH));
            this.bAN.setText(ax.v(aVar.bAI));
            this.bAJ.setOnClickListener(new d(this, aVar));
            this.bAL.setOnClickListener(new e(this, aVar));
        }
    }

    public void cZ(int i) {
        if (this.mSkinType != i) {
            TX();
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }
}
