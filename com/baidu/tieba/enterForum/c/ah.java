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
    private TextView bHa;
    private BdListView bHb;
    private com.baidu.tieba.enterForum.a.c bHc;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bHa = (TextView) this.mRootView.findViewById(w.h.frequently_forum_info_title);
        this.bHb = (BdListView) this.mRootView.findViewById(w.h.frequently_forum_info_listview);
        this.bHc = new com.baidu.tieba.enterForum.a.c();
        this.bHb.setAdapter((ListAdapter) this.bHc);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bHc.a(list, tbPageContext);
        this.bHc.c(this.bHb);
    }

    public void tD() {
        aq.i((View) this.bHa, w.e.cp_cont_c);
        this.bHc.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
