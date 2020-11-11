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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes22.dex */
public class f implements a {
    private e jgA;
    private e.b jge;
    private BdListView jgz;
    private Context mContext;
    private List<bf> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.ebD = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.jgw = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.jgx = view.findViewById(R.id.tab_menu_line_s);
                cVar.jgy = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            bf item = getItem(i);
            if (item != null) {
                cVar2.ebD.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.ebD, R.color.cp_link_tip_a, 1);
                    ap.setImageResource(cVar2.jgw, R.drawable.chx_tips_list_ok);
                    cVar2.jgw.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.ebD, R.color.cp_cont_c, 1);
                    cVar2.jgw.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.jgy.setVisibility(0);
                    cVar2.jgx.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jgy, R.color.cp_bg_line_c);
                } else {
                    cVar2.jgx.setVisibility(0);
                    cVar2.jgy.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jgx, R.color.cp_bg_line_c);
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
        /* renamed from: Ap */
        public bf getItem(int i) {
            if (f.this.mData != null) {
                return (bf) f.this.mData.get(i);
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
            if (f.this.jgA != null) {
                f.this.jgA.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.jge != null) {
                for (bf bfVar : f.this.mData) {
                    if (bfVar != null) {
                        bfVar.isSelected = false;
                    }
                }
                bf bfVar2 = (bf) f.this.mAdapter.getItem(i);
                if (bfVar2 != null) {
                    bfVar2.isSelected = true;
                    f.this.jge.Am(bfVar2.iLN);
                }
            }
        }
    };

    private void initView() {
        this.jgz = new BdListView(this.mContext);
        this.jgz.setAlwaysDrawnWithCacheEnabled(false);
        this.jgz.setDivider(null);
        this.jgz.setDividerHeight(0);
        this.jgz.setSelector(17170445);
        this.jgz.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.jgz.setOnItemClickListener(this.mOnItemClickListener);
        this.jgz.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jgA = eVar;
            this.jge = eVar.cEU();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bf> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.jgz;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cES() {
        return 0;
    }
}
