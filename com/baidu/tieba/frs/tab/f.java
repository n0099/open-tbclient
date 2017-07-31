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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class f implements a {
    private e cwA;
    private e.b cwb;
    private BdListView cwz;
    private Context mContext;
    private List<as> mData;
    private final BaseAdapter cwB = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.f.ds80)));
                e.c cVar = new e.c();
                cVar.name = (TextView) view.findViewById(d.h.tab_menu_name);
                cVar.cww = (ImageView) view.findViewById(d.h.tab_menu_check);
                cVar.cwx = view.findViewById(d.h.tab_menu_line_s);
                cVar.cwy = view.findViewById(d.h.tab_menu_line_f);
                view.setTag(cVar);
            }
            ai.j(view, d.e.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            as item = getItem(i);
            if (item != null) {
                cVar2.name.setText(item.name);
                if (item.isSelected) {
                    ai.c(cVar2.name, d.e.cp_link_tip_a, 1);
                    ai.c(cVar2.cww, d.g.chx_tips_list_ok);
                    cVar2.cww.setVisibility(0);
                } else {
                    ai.c(cVar2.name, d.e.cp_cont_c, 1);
                    cVar2.cww.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cwy.setVisibility(0);
                    cVar2.cwx.setVisibility(8);
                    ai.k(cVar2.cwy, d.e.cp_bg_line_b);
                } else {
                    cVar2.cwx.setVisibility(0);
                    cVar2.cwy.setVisibility(8);
                    ai.k(cVar2.cwx, d.e.cp_bg_line_b);
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
        /* renamed from: jr */
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
            if (f.this.cwA != null) {
                f.this.cwA.ajd();
            }
            if (f.this.cwB != null && f.this.cwb != null) {
                for (as asVar : f.this.mData) {
                    if (asVar != null) {
                        asVar.isSelected = false;
                    }
                }
                as asVar2 = (as) f.this.cwB.getItem(i);
                if (asVar2 != null) {
                    asVar2.isSelected = true;
                    f.this.cwb.jq(asVar2.clK);
                }
            }
        }
    };

    private void initView() {
        this.cwz = new BdListView(this.mContext);
        this.cwz.setAlwaysDrawnWithCacheEnabled(false);
        this.cwz.setDivider(null);
        this.cwz.setDividerHeight(0);
        this.cwz.setSelector(17170445);
        this.cwz.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cwz.setOnItemClickListener(this.mOnItemClickListener);
        this.cwz.setAdapter((ListAdapter) this.cwB);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cwA = eVar;
            this.cwb = eVar.aje();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        this.mData = list;
        this.cwB.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cwz;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void xd() {
        this.cwB.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ajb() {
        return 0;
    }
}
