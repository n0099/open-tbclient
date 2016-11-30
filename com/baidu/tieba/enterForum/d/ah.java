package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bMf;
    private BdListView bMg;
    private com.baidu.tieba.enterForum.a.c bMh;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bMf = (TextView) this.mRootView.findViewById(r.g.frequently_forum_info_title);
        this.bMg = (BdListView) this.mRootView.findViewById(r.g.frequently_forum_info_listview);
        this.bMh = new com.baidu.tieba.enterForum.a.c();
        this.bMg.setAdapter((ListAdapter) this.bMh);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bMh.a(list, tbPageContext);
        this.bMh.c(this.bMg);
    }

    public void tB() {
        at.j((View) this.bMf, r.d.cp_cont_c);
        this.bMh.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
