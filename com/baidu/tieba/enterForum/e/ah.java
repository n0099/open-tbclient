package com.baidu.tieba.enterForum.e;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bJl;
    private BdListView bJm;
    private com.baidu.tieba.enterForum.a.c bJn;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bJl = (TextView) this.mRootView.findViewById(t.g.frequently_forum_info_title);
        this.bJm = (BdListView) this.mRootView.findViewById(t.g.frequently_forum_info_listview);
        this.bJn = new com.baidu.tieba.enterForum.a.c();
        this.bJm.setAdapter((ListAdapter) this.bJn);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bJn.a(list, tbPageContext);
        this.bJn.c(this.bJm);
    }

    public void ti() {
        av.j((View) this.bJl, t.d.cp_cont_c);
        this.bJn.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
