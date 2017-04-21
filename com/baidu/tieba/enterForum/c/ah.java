package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.w;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bJk;
    private BdListView bJl;
    private com.baidu.tieba.enterForum.a.c bJm;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bJk = (TextView) this.mRootView.findViewById(w.h.frequently_forum_info_title);
        this.bJl = (BdListView) this.mRootView.findViewById(w.h.frequently_forum_info_listview);
        this.bJm = new com.baidu.tieba.enterForum.a.c();
        this.bJl.setAdapter((ListAdapter) this.bJm);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bJm.a(list, tbPageContext);
        this.bJm.c(this.bJl);
    }

    public void onChangeSkinType() {
        aq.i(this.bJk, w.e.cp_cont_c);
        this.bJm.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
