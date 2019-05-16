package com.baidu.tieba.aiapps.apps.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.res.widget.a.a;
import com.baidu.swan.apps.res.widget.a.b;
import com.baidu.tieba.R;
import java.util.List;
/* loaded from: classes4.dex */
public class BdContextMenuView extends FrameLayout implements a.b {
    private static final boolean DEBUG = b.DEBUG;
    private a dgr;
    public boolean dgs;
    private Context mContext;
    private ListView mListView;
    private boolean mMenuLoaded;

    @SuppressLint({"NewApi"})
    public BdContextMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public BdContextMenuView(Context context) {
        super(context);
        this.mMenuLoaded = false;
        this.mContext = context;
        init();
    }

    public void layoutMenu(List<com.baidu.swan.apps.res.widget.a.b> list) {
        if (DEBUG) {
            Log.d("BdContextMenuView", "layout menu view");
        }
        if (!this.mMenuLoaded) {
            if (this.dgr == null) {
                this.dgr = new a(this.mContext, list);
                this.mListView.setAdapter((ListAdapter) this.dgr);
            } else {
                this.dgr.setData(list);
            }
            this.mMenuLoaded = true;
        }
    }

    private void init() {
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        setBackground(this.mContext.getResources().getDrawable(R.drawable.aiapps_context_menu_bg));
        this.mListView = new ListView(this.mContext);
        this.mListView.setCacheColorHint(0);
        this.mListView.setDivider(getResources().getDrawable(R.color.aiapps_context_menu_divider_color));
        this.mListView.setDividerHeight(1);
        this.mListView.setSelector(new ColorDrawable(0));
        addView(this.mListView, new FrameLayout.LayoutParams(-1, -1));
        this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.aiapps.apps.widget.BdContextMenuView.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                BdContextMenuView.this.dgr.mL(i);
            }
        });
    }

    public void setLayoutInCenter(boolean z) {
        this.dgs = z;
    }

    /* loaded from: classes4.dex */
    private class a extends BaseAdapter {
        private Context mContext;
        private List<com.baidu.swan.apps.res.widget.a.b> mDataList;

        /* renamed from: com.baidu.tieba.aiapps.apps.widget.BdContextMenuView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0289a {
            public ImageView dgu;
            public TextView dgv;

            public C0289a() {
            }
        }

        public a(Context context, List<com.baidu.swan.apps.res.widget.a.b> list) {
            this.mDataList = list;
            this.mContext = context;
        }

        public void setData(List<com.baidu.swan.apps.res.widget.a.b> list) {
            this.mDataList = list;
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.mDataList.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return this.mDataList.get(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        @SuppressLint({"InflateParams"})
        public View getView(int i, View view, ViewGroup viewGroup) {
            C0289a c0289a;
            View view2;
            if (view == null) {
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.aiapps_menu_item_view, (ViewGroup) null);
                C0289a c0289a2 = new C0289a();
                c0289a2.dgu = (ImageView) view2.findViewById(R.id.item_icon);
                c0289a2.dgv = (TextView) view2.findViewById(R.id.item_title);
                c0289a2.dgv.setTextColor(this.mContext.getResources().getColor(R.color.aiapps_context_menu_item_title_color));
                t(view2, i);
                view2.setTag(c0289a2);
                c0289a = c0289a2;
            } else {
                c0289a = (C0289a) view.getTag();
                view2 = view;
            }
            com.baidu.swan.apps.res.widget.a.b bVar = this.mDataList.get(i);
            c0289a.dgv.setText(bVar.getTitle());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0289a.dgv.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0289a.dgu.getLayoutParams();
            if (bVar.getIcon() != null) {
                c0289a.dgu.setVisibility(0);
                c0289a.dgu.setImageDrawable(bVar.getIcon());
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.aiapps_context_menu_item_title_left_margin));
                c0289a.dgv.setLayoutParams(layoutParams);
            } else {
                c0289a.dgu.setVisibility(8);
                layoutParams.setMarginStart(this.mContext.getResources().getDimensionPixelSize(R.dimen.aiapps_context_menu_item_icon_left_margin));
                c0289a.dgv.setLayoutParams(layoutParams);
            }
            if (BdContextMenuView.this.dgs) {
                ((LinearLayout) view2).setGravity(17);
                layoutParams.width = -2;
                if (bVar.getIcon() != null) {
                    layoutParams2.setMarginStart(0);
                    c0289a.dgu.setLayoutParams(layoutParams2);
                } else {
                    layoutParams.setMarginStart(0);
                    c0289a.dgv.setLayoutParams(layoutParams);
                }
            }
            return view2;
        }

        public void mL(int i) {
            com.baidu.swan.apps.res.widget.a.b bVar = this.mDataList.get(i);
            b.a KV = bVar.KV();
            if (KV != null) {
                KV.c(bVar);
            }
        }

        private void t(View view, int i) {
            if (getCount() == 1) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.aiapps_context_menu_round_corner_selector));
            } else if (i == 0) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.aiapps_context_menu_top_corner_selector));
            } else if (i == getCount() - 1) {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.aiapps_context_menu_bottom_corner_selector));
            } else {
                view.setBackground(this.mContext.getResources().getDrawable(R.drawable.aiapps_context_menu_no_corner_selector));
            }
        }
    }
}
