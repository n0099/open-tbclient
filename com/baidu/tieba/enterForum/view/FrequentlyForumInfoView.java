package com.baidu.tieba.enterForum.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.u;
import java.util.List;
/* loaded from: classes.dex */
public class FrequentlyForumInfoView extends LinearLayout {
    private TbPageContext DQ;
    private TextView bxW;
    private BdListView bxX;
    private com.baidu.tieba.enterForum.a.c bxY;

    public FrequentlyForumInfoView(Context context) {
        super(context);
        init(context);
    }

    public FrequentlyForumInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public FrequentlyForumInfoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(u.h.frequently_forum_info_view, this);
        this.bxW = (TextView) findViewById(u.g.frequently_forum_info_title);
        this.bxX = (BdListView) findViewById(u.g.frequently_forum_info_listview);
        this.bxY = new com.baidu.tieba.enterForum.a.c();
        this.bxX.setAdapter((ListAdapter) this.bxY);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.DQ = tbPageContext;
        this.bxY.a(list, tbPageContext);
        this.bxY.c(this.bxX);
    }

    public void n(TbPageContext<?> tbPageContext) {
        com.baidu.tbadk.j.a.a(tbPageContext, this);
        this.bxY.notifyDataSetChanged();
    }
}
