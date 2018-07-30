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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private e dFA;
    private e.b dFe;
    private BdListView dFz;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter dFB = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.bwj = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.dFw = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.dFx = view.findViewById(d.g.tab_menu_line_s);
                cVar.dFy = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.i(view, d.C0140d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.bwj.setText(item.name);
                if (item.isSelected) {
                    am.c(cVar2.bwj, d.C0140d.cp_link_tip_a, 1);
                    am.c(cVar2.dFw, d.f.chx_tips_list_ok);
                    cVar2.dFw.setVisibility(0);
                } else {
                    am.c(cVar2.bwj, d.C0140d.cp_cont_c, 1);
                    cVar2.dFw.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dFy.setVisibility(0);
                    cVar2.dFx.setVisibility(8);
                    am.j(cVar2.dFy, d.C0140d.cp_bg_line_b);
                } else {
                    cVar2.dFx.setVisibility(0);
                    cVar2.dFy.setVisibility(8);
                    am.j(cVar2.dFx, d.C0140d.cp_bg_line_b);
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
            if (f.this.dFA != null) {
                f.this.dFA.aAi();
            }
            if (f.this.dFB != null && f.this.dFe != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.dFB.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.dFe.lE(atVar2.dpu);
                }
            }
        }
    };

    private void initView() {
        this.dFz = new BdListView(this.mContext);
        this.dFz.setAlwaysDrawnWithCacheEnabled(false);
        this.dFz.setDivider(null);
        this.dFz.setDividerHeight(0);
        this.dFz.setSelector(17170445);
        this.dFz.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dFz.setOnItemClickListener(this.mOnItemClickListener);
        this.dFz.setAdapter((ListAdapter) this.dFB);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dFA = eVar;
            this.dFe = eVar.aAj();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.dFB.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dFz;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aAg() {
        return 0;
    }
}
