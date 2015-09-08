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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.MorePopupWindow;
import com.baidu.tieba.i;
import java.util.List;
/* loaded from: classes.dex */
public class i {
    private LinearLayout aPg;
    private a bbj;
    private BdListView bbt;
    private View bbu;
    private List<h> mData;
    private MorePopupWindow mPopWindow;
    private AdapterView.OnItemClickListener Hw = new j(this);
    private final BaseAdapter bbv = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fM(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aPv;
        public View bbA;
        public ImageView bby;
        public View bbz;
    }

    public i(Context context, a aVar) {
        at(context);
        this.bbj = aVar;
    }

    private void at(Context context) {
        this.aPg = new LinearLayout(context);
        this.bbt = new BdListView(context);
        this.bbt.setAlwaysDrawnWithCacheEnabled(false);
        this.bbt.setDivider(null);
        this.bbt.setDividerHeight(0);
        this.bbt.setSelector(17170445);
        this.bbt.setCacheColorHint(context.getResources().getColor(17170445));
        this.aPg.setOrientation(1);
        this.aPg.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aPg.addView(this.bbt);
        this.bbu = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.h(this.bbu, i.c.black_alpha40);
        this.bbu.setOnClickListener(new l(this));
        this.aPg.addView(this.bbu, layoutParams);
        this.bbt.setOnItemClickListener(this.Hw);
        this.bbt.setAdapter((ListAdapter) this.bbv);
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aPg, view, al.getDrawable(i.e.transparent_bg), new m(this));
            this.mPopWindow.setOnDismissListener(new n(this, tabItemView));
        }
    }

    public void a(Activity activity, View view, TabItemView tabItemView, List<h> list) {
        this.mData = list;
        this.bbv.notifyDataSetChanged();
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void vI() {
        this.bbv.notifyDataSetChanged();
        if (this.bbu != null) {
            al.h(this.bbu, i.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(al.getDrawable(i.e.transparent_bg));
        }
    }
}
