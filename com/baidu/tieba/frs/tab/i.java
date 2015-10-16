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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private LinearLayout aOn;
    private a bbn;
    private BdListView bby;
    private View bbz;
    private List<h> mData;
    private MorePopupWindow mPopWindow;
    private AdapterView.OnItemClickListener Hx = new j(this);
    private final BaseAdapter bbA = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fR(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aDl;
        public ImageView bbD;
        public View bbE;
        public View bbF;
    }

    public i(Context context, a aVar) {
        as(context);
        this.bbn = aVar;
    }

    private void as(Context context) {
        this.aOn = new LinearLayout(context);
        this.bby = new BdListView(context);
        this.bby.setAlwaysDrawnWithCacheEnabled(false);
        this.bby.setDivider(null);
        this.bby.setDividerHeight(0);
        this.bby.setSelector(17170445);
        this.bby.setCacheColorHint(context.getResources().getColor(17170445));
        this.aOn.setOrientation(1);
        this.aOn.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aOn.addView(this.bby);
        this.bbz = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        an.i(this.bbz, i.c.black_alpha40);
        this.bbz.setOnClickListener(new l(this));
        this.aOn.addView(this.bbz, layoutParams);
        this.bby.setOnItemClickListener(this.Hx);
        this.bby.setAdapter((ListAdapter) this.bbA);
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aOn, view, an.getDrawable(i.e.transparent_bg), new m(this));
            this.mPopWindow.setOnDismissListener(new n(this, tabItemView));
        }
    }

    public void a(Activity activity, View view, TabItemView tabItemView, List<h> list) {
        this.mData = list;
        this.bbA.notifyDataSetChanged();
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
        this.bbA.notifyDataSetChanged();
        if (this.bbz != null) {
            an.i(this.bbz, i.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(an.getDrawable(i.e.transparent_bg));
        }
    }
}
