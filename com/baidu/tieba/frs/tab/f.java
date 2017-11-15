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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class f implements a {
    private e.b cPN;
    private BdListView cQj;
    private e cQk;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter cQl = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.aTP = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.cQg = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.cQh = view.findViewById(d.g.tab_menu_line_s);
                cVar.cQi = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            aj.j(view, d.C0080d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.aTP.setText(item.name);
                if (item.isSelected) {
                    aj.c(cVar2.aTP, d.C0080d.cp_link_tip_a, 1);
                    aj.c(cVar2.cQg, d.f.chx_tips_list_ok);
                    cVar2.cQg.setVisibility(0);
                } else {
                    aj.c(cVar2.aTP, d.C0080d.cp_cont_c, 1);
                    cVar2.cQg.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cQi.setVisibility(0);
                    cVar2.cQh.setVisibility(8);
                    aj.k(cVar2.cQi, d.C0080d.cp_bg_line_b);
                } else {
                    cVar2.cQh.setVisibility(0);
                    cVar2.cQi.setVisibility(8);
                    aj.k(cVar2.cQh, d.C0080d.cp_bg_line_b);
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
        /* renamed from: ku */
        public at getItem(int i) {
            if (f.this.mData != null) {
                return (at) f.this.mData.get(i);
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
            if (f.this.cQk != null) {
                f.this.cQk.aoy();
            }
            if (f.this.cQl != null && f.this.cPN != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.cQl.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.cPN.kt(atVar2.cAP);
                }
            }
        }
    };

    private void initView() {
        this.cQj = new BdListView(this.mContext);
        this.cQj.setAlwaysDrawnWithCacheEnabled(false);
        this.cQj.setDivider(null);
        this.cQj.setDividerHeight(0);
        this.cQj.setSelector(17170445);
        this.cQj.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cQj.setOnItemClickListener(this.mOnItemClickListener);
        this.cQj.setAdapter((ListAdapter) this.cQl);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cQk = eVar;
            this.cPN = eVar.aoz();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.cQl.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cQj;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        this.cQl.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aow() {
        return 0;
    }
}
