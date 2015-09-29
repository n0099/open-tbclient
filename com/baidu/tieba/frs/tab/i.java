package com.baidu.tieba.frs.tab;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private LinearLayout aOc;
    private a bbc;
    private BdListView bbn;
    private View bbo;
    private List<h> mData;
    private MorePopupWindow mPopWindow;
    private AdapterView.OnItemClickListener Hw = new j(this);
    private final BaseAdapter bbp = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fR(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aDa;
        public ImageView bbs;
        public View bbt;
        public View bbu;
    }

    public i(Context context, a aVar) {
        as(context);
        this.bbc = aVar;
    }

    private void as(Context context) {
        this.aOc = new LinearLayout(context);
        this.bbn = new BdListView(context);
        this.bbn.setAlwaysDrawnWithCacheEnabled(false);
        this.bbn.setDivider(null);
        this.bbn.setDividerHeight(0);
        this.bbn.setSelector(17170445);
        this.bbn.setCacheColorHint(context.getResources().getColor(17170445));
        this.aOc.setOrientation(1);
        this.aOc.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aOc.addView(this.bbn);
        this.bbo = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        am.i(this.bbo, i.c.black_alpha40);
        this.bbo.setOnClickListener(new l(this));
        this.aOc.addView(this.bbo, layoutParams);
        this.bbn.setOnItemClickListener(this.Hw);
        this.bbn.setAdapter((ListAdapter) this.bbp);
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aOc, view, am.getDrawable(i.e.transparent_bg), new m(this));
            this.mPopWindow.setOnDismissListener(new n(this, tabItemView));
        }
    }

    public void a(Activity activity, View view, TabItemView tabItemView, List<h> list) {
        this.mData = list;
        this.bbp.notifyDataSetChanged();
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void Nm() {
        if (this.mPopWindow != null) {
            com.baidu.adp.lib.g.j.a(this.mPopWindow);
        }
    }

    public void vA() {
        this.bbp.notifyDataSetChanged();
        if (this.bbo != null) {
            am.i(this.bbo, i.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(am.getDrawable(i.e.transparent_bg));
        }
    }
}
