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
    private BdListView cPP;
    private e cPQ;
    private e.b cPt;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter cPR = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.aTH = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.cPM = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.cPN = view.findViewById(d.g.tab_menu_line_s);
                cVar.cPO = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            aj.j(view, d.C0080d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.aTH.setText(item.name);
                if (item.isSelected) {
                    aj.c(cVar2.aTH, d.C0080d.cp_link_tip_a, 1);
                    aj.c(cVar2.cPM, d.f.chx_tips_list_ok);
                    cVar2.cPM.setVisibility(0);
                } else {
                    aj.c(cVar2.aTH, d.C0080d.cp_cont_c, 1);
                    cVar2.cPM.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cPO.setVisibility(0);
                    cVar2.cPN.setVisibility(8);
                    aj.k(cVar2.cPO, d.C0080d.cp_bg_line_b);
                } else {
                    cVar2.cPN.setVisibility(0);
                    cVar2.cPO.setVisibility(8);
                    aj.k(cVar2.cPN, d.C0080d.cp_bg_line_b);
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
            if (f.this.cPQ != null) {
                f.this.cPQ.aoj();
            }
            if (f.this.cPR != null && f.this.cPt != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.cPR.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.cPt.kt(atVar2.cAw);
                }
            }
        }
    };

    private void initView() {
        this.cPP = new BdListView(this.mContext);
        this.cPP.setAlwaysDrawnWithCacheEnabled(false);
        this.cPP.setDivider(null);
        this.cPP.setDividerHeight(0);
        this.cPP.setSelector(17170445);
        this.cPP.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cPP.setOnItemClickListener(this.mOnItemClickListener);
        this.cPP.setAdapter((ListAdapter) this.cPR);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cPQ = eVar;
            this.cPt = eVar.aok();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.cPR.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cPP;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        this.cPR.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aoh() {
        return 0;
    }
}
