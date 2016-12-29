package com.baidu.tieba.enterForum.d;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bsj;
    private BdListView bsk;
    private com.baidu.tieba.enterForum.a.c bsl;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bsj = (TextView) this.mRootView.findViewById(r.g.frequently_forum_info_title);
        this.bsk = (BdListView) this.mRootView.findViewById(r.g.frequently_forum_info_listview);
        this.bsl = new com.baidu.tieba.enterForum.a.c();
        this.bsk.setAdapter((ListAdapter) this.bsl);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bsl.a(list, tbPageContext);
        this.bsl.c(this.bsk);
    }

    public void tm() {
        ar.j((View) this.bsj, r.d.cp_cont_c);
        this.bsl.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
