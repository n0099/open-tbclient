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
    private TextView bGT;
    private BdListView bGU;
    private com.baidu.tieba.enterForum.a.c bGV;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bGT = (TextView) this.mRootView.findViewById(w.h.frequently_forum_info_title);
        this.bGU = (BdListView) this.mRootView.findViewById(w.h.frequently_forum_info_listview);
        this.bGV = new com.baidu.tieba.enterForum.a.c();
        this.bGU.setAdapter((ListAdapter) this.bGV);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bGV.a(list, tbPageContext);
        this.bGV.c(this.bGU);
    }

    public void onChangeSkinType() {
        aq.i(this.bGT, w.e.cp_cont_c);
        this.bGV.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
