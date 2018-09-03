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
import com.baidu.tieba.f;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private e.b dFb;
    private BdListView dFw;
    private e dFx;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(f.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(f.e.ds80)));
                e.c cVar = new e.c();
                cVar.bwl = (TextView) view.findViewById(f.g.tab_menu_name);
                cVar.dFt = (ImageView) view.findViewById(f.g.tab_menu_check);
                cVar.dFu = view.findViewById(f.g.tab_menu_line_s);
                cVar.dFv = view.findViewById(f.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.i(view, f.d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.bwl.setText(item.name);
                if (item.isSelected) {
                    am.c(cVar2.bwl, f.d.cp_link_tip_a, 1);
                    am.c(cVar2.dFt, f.C0146f.chx_tips_list_ok);
                    cVar2.dFt.setVisibility(0);
                } else {
                    am.c(cVar2.bwl, f.d.cp_cont_c, 1);
                    cVar2.dFt.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dFv.setVisibility(0);
                    cVar2.dFu.setVisibility(8);
                    am.j(cVar2.dFv, f.d.cp_bg_line_b);
                } else {
                    cVar2.dFu.setVisibility(0);
                    cVar2.dFv.setVisibility(8);
                    am.j(cVar2.dFu, f.d.cp_bg_line_b);
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
        /* renamed from: lH */
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
            if (f.this.dFx != null) {
                f.this.dFx.aAf();
            }
            if (f.this.mAdapter != null && f.this.dFb != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.mAdapter.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.dFb.lE(atVar2.dps);
                }
            }
        }
    };

    private void initView() {
        this.dFw = new BdListView(this.mContext);
        this.dFw.setAlwaysDrawnWithCacheEnabled(false);
        this.dFw.setDivider(null);
        this.dFw.setDividerHeight(0);
        this.dFw.setSelector(17170445);
        this.dFw.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dFw.setOnItemClickListener(this.mOnItemClickListener);
        this.dFw.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dFx = eVar;
            this.dFb = eVar.aAg();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dFw;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aAd() {
        return 0;
    }
}
