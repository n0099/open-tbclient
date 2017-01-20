package com.baidu.tieba.enterForum.c;

import android.content.Context;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.r;
import java.util.List;
/* loaded from: classes.dex */
public class ah {
    private TextView bzU;
    private BdListView bzV;
    private com.baidu.tieba.enterForum.a.c bzW;
    private Context mContext;
    private View mRootView;

    public ah(Context context, View view) {
        this.mContext = context;
        this.mRootView = view;
        init();
    }

    private void init() {
        this.bzU = (TextView) this.mRootView.findViewById(r.h.frequently_forum_info_title);
        this.bzV = (BdListView) this.mRootView.findViewById(r.h.frequently_forum_info_listview);
        this.bzW = new com.baidu.tieba.enterForum.a.c();
        this.bzV.setAdapter((ListAdapter) this.bzW);
    }

    public void d(List<com.baidu.tbadk.data.e> list, TbPageContext<?> tbPageContext) {
        this.bzW.a(list, tbPageContext);
        this.bzW.c(this.bzV);
    }

    public void tg() {
        ap.i((View) this.bzU, r.e.cp_cont_c);
        this.bzW.notifyDataSetChanged();
    }

    public void setVisibility(int i) {
        this.mRootView.setVisibility(i);
    }
}
