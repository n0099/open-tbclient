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
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private e.b hKc;
    private BdListView hKx;
    private e hKy;
    private Context mContext;
    private List<ax> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.dez = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.hKu = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.hKv = view.findViewById(R.id.tab_menu_line_s);
                cVar.hKw = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ax item = getItem(i);
            if (item != null) {
                cVar2.dez.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.dez, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.hKu, R.drawable.chx_tips_list_ok);
                    cVar2.hKu.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.dez, R.color.cp_cont_c, 1);
                    cVar2.hKu.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.hKw.setVisibility(0);
                    cVar2.hKv.setVisibility(8);
                    am.setBackgroundColor(cVar2.hKw, R.color.cp_bg_line_c);
                } else {
                    cVar2.hKv.setVisibility(0);
                    cVar2.hKw.setVisibility(8);
                    am.setBackgroundColor(cVar2.hKv, R.color.cp_bg_line_c);
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
        /* renamed from: vo */
        public ax getItem(int i) {
            if (f.this.mData != null) {
                return (ax) f.this.mData.get(i);
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
            if (f.this.hKy != null) {
                f.this.hKy.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.hKc != null) {
                for (ax axVar : f.this.mData) {
                    if (axVar != null) {
                        axVar.isSelected = false;
                    }
                }
                ax axVar2 = (ax) f.this.mAdapter.getItem(i);
                if (axVar2 != null) {
                    axVar2.isSelected = true;
                    f.this.hKc.vl(axVar2.hre);
                }
            }
        }
    };

    private void initView() {
        this.hKx = new BdListView(this.mContext);
        this.hKx.setAlwaysDrawnWithCacheEnabled(false);
        this.hKx.setDivider(null);
        this.hKx.setDividerHeight(0);
        this.hKx.setSelector(17170445);
        this.hKx.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.hKx.setOnItemClickListener(this.mOnItemClickListener);
        this.hKx.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.hKy = eVar;
            this.hKc = eVar.cbd();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ax> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.hKx;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cbb() {
        return 0;
    }
}
