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
    private LinearLayout aOT;
    private a baP;
    private BdListView baZ;
    private View bba;
    private List<h> mData;
    private MorePopupWindow mPopWindow;
    private AdapterView.OnItemClickListener Hw = new j(this);
    private final BaseAdapter bbb = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fD(int i);
    }

    /* loaded from: classes.dex */
    public static class b {
        public TextView aPi;
        public ImageView bbe;
        public View bbf;
        public View bbg;
    }

    public i(Context context, a aVar) {
        au(context);
        this.baP = aVar;
    }

    private void au(Context context) {
        this.aOT = new LinearLayout(context);
        this.baZ = new BdListView(context);
        this.baZ.setAlwaysDrawnWithCacheEnabled(false);
        this.baZ.setDivider(null);
        this.baZ.setDividerHeight(0);
        this.baZ.setSelector(17170445);
        this.baZ.setCacheColorHint(context.getResources().getColor(17170445));
        this.aOT.setOrientation(1);
        this.aOT.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.aOT.addView(this.baZ);
        this.bba = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        al.i(this.bba, i.c.black_alpha40);
        this.bba.setOnClickListener(new l(this));
        this.aOT.addView(this.bba, layoutParams);
        this.baZ.setOnItemClickListener(this.Hw);
        this.baZ.setAdapter((ListAdapter) this.bbb);
    }

    private void a(Activity activity, View view, TabItemView tabItemView) {
        if (this.mPopWindow == null) {
            this.mPopWindow = new MorePopupWindow(activity, this.aOT, view, al.getDrawable(i.e.transparent_bg), new m(this));
            this.mPopWindow.setOnDismissListener(new n(this, tabItemView));
        }
    }

    public void a(Activity activity, View view, TabItemView tabItemView, List<h> list) {
        this.mData = list;
        this.bbb.notifyDataSetChanged();
        a(activity, view, tabItemView);
        if (this.mPopWindow != null) {
            this.mPopWindow.refresh();
            this.mPopWindow.setWidthAsWidthOfDeviceScreen(activity);
            this.mPopWindow.setHeight(-1);
            this.mPopWindow.showWindowInCustomPosition(0, 0);
        }
    }

    public void vD() {
        this.bbb.notifyDataSetChanged();
        if (this.bba != null) {
            al.i(this.bba, i.c.black_alpha40);
        }
        if (this.mPopWindow != null) {
            this.mPopWindow.setBackgroundDrawable(al.getDrawable(i.e.transparent_bg));
        }
    }
}
