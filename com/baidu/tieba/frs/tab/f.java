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
    private e.b cuJ;
    private BdListView cvh;
    private e cvi;
    private Context mContext;
    private List<as> mData;
    private final BaseAdapter cvj = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.f.ds80)));
                e.c cVar = new e.c();
                cVar.name = (TextView) view.findViewById(d.h.tab_menu_name);
                cVar.cve = (ImageView) view.findViewById(d.h.tab_menu_check);
                cVar.cvf = view.findViewById(d.h.tab_menu_line_s);
                cVar.cvg = view.findViewById(d.h.tab_menu_line_f);
                view.setTag(cVar);
            }
            ai.j(view, d.e.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            as item = getItem(i);
            if (item != null) {
                cVar2.name.setText(item.name);
                if (item.isSelected) {
                    ai.c(cVar2.name, d.e.cp_link_tip_a, 1);
                    ai.c(cVar2.cve, d.g.chx_tips_list_ok);
                    cVar2.cve.setVisibility(0);
                } else {
                    ai.c(cVar2.name, d.e.cp_cont_c, 1);
                    cVar2.cve.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cvg.setVisibility(0);
                    cVar2.cvf.setVisibility(8);
                    ai.k(cVar2.cvg, d.e.cp_bg_line_b);
                } else {
                    cVar2.cvf.setVisibility(0);
                    cVar2.cvg.setVisibility(8);
                    ai.k(cVar2.cvf, d.e.cp_bg_line_b);
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
            if (f.this.cvi != null) {
                f.this.cvi.aiR();
            }
            if (f.this.cvj != null && f.this.cuJ != null) {
                for (as asVar : f.this.mData) {
                    if (asVar != null) {
                        asVar.isSelected = false;
                    }
                }
                as asVar2 = (as) f.this.cvj.getItem(i);
                if (asVar2 != null) {
                    asVar2.isSelected = true;
                    f.this.cuJ.jq(asVar2.ckC);
                }
            }
        }
    };

    private void initView() {
        this.cvh = new BdListView(this.mContext);
        this.cvh.setAlwaysDrawnWithCacheEnabled(false);
        this.cvh.setDivider(null);
        this.cvh.setDividerHeight(0);
        this.cvh.setSelector(17170445);
        this.cvh.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cvh.setOnItemClickListener(this.mOnItemClickListener);
        this.cvh.setAdapter((ListAdapter) this.cvj);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cvi = eVar;
            this.cuJ = eVar.aiS();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        this.mData = list;
        this.cvj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cvh;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wV() {
        this.cvj.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aiP() {
        return 0;
    }
}
