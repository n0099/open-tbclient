package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bJm;
    private BdListView bJn;
    private com.baidu.tieba.enterForum.a.c bJo;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bJm = (TextView) this.mRootView.findViewById(r.g.frequently_forum_info_title);
        this.bJn = (BdListView) this.mRootView.findViewById(r.g.frequently_forum_info_listview);
        this.bJo = new com.baidu.tieba.enterForum.a.c();
        this.bJn.setAdapter((ListAdapter) this.bJo);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bJo.a(list, tbPageContext);
        this.bJo.c(this.bJn);
    }

    public void tx() {
        av.j((View) this.bJm, r.d.cp_cont_c);
        this.bJo.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
