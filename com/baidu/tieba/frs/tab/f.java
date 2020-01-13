package com.baidu.tieba.frs.tab;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes7.dex */
public class f implements a {
    private BdListView gGC;
    private e.b gHN;
    private e gIi;
    private Context mContext;
    private List<as> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.cqf = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.gIf = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.gIg = view.findViewById(R.id.tab_menu_line_s);
                cVar.gIh = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            as item = getItem(i);
            if (item != null) {
                cVar2.cqf.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.cqf, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.gIf, R.drawable.chx_tips_list_ok);
                    cVar2.gIf.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.cqf, R.color.cp_cont_c, 1);
                    cVar2.gIf.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.gIh.setVisibility(0);
                    cVar2.gIg.setVisibility(8);
                    am.setBackgroundColor(cVar2.gIh, R.color.cp_bg_line_c);
                } else {
                    cVar2.gIg.setVisibility(0);
                    cVar2.gIh.setVisibility(8);
                    am.setBackgroundColor(cVar2.gIg, R.color.cp_bg_line_c);
                }
            }
            return view;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: tX */
        public as getItem(int i) {
            if (f.this.mData != null) {
                return (as) f.this.mData.get(i);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (f.this.mData != null) {
                return f.this.mData.size();
            }
            return 0;
        }
    };
    private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.frs.tab.f.2
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (f.this.gIi != null) {
                f.this.gIi.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.gHN != null) {
                for (as asVar : f.this.mData) {
                    if (asVar != null) {
                        asVar.isSelected = false;
                    }
                }
                as asVar2 = (as) f.this.mAdapter.getItem(i);
                if (asVar2 != null) {
                    asVar2.isSelected = true;
                    f.this.gHN.tU(asVar2.gpO);
                }
            }
        }
    };

    private void initView() {
        this.gGC = new BdListView(this.mContext);
        this.gGC.setAlwaysDrawnWithCacheEnabled(false);
        this.gGC.setDivider(null);
        this.gGC.setDividerHeight(0);
        this.gGC.setSelector(17170445);
        this.gGC.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.gGC.setOnItemClickListener(this.mOnItemClickListener);
        this.gGC.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gIi = eVar;
            this.gHN = eVar.bIk();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.gGC;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bIi() {
        return 0;
    }
}
