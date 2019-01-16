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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes6.dex */
public class f implements a {
    private BdListView eev;
    private e efG;
    private e.b efl;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(e.C0210e.ds80)));
                e.c cVar = new e.c();
                cVar.bPV = (TextView) view.findViewById(e.g.tab_menu_name);
                cVar.efD = (ImageView) view.findViewById(e.g.tab_menu_check);
                cVar.efE = view.findViewById(e.g.tab_menu_line_s);
                cVar.efF = view.findViewById(e.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            al.i(view, e.d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.bPV.setText(item.name);
                if (item.isSelected) {
                    al.c(cVar2.bPV, e.d.cp_link_tip_a, 1);
                    al.c(cVar2.efD, e.f.chx_tips_list_ok);
                    cVar2.efD.setVisibility(0);
                } else {
                    al.c(cVar2.bPV, e.d.cp_cont_c, 1);
                    cVar2.efD.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.efF.setVisibility(0);
                    cVar2.efE.setVisibility(8);
                    al.j(cVar2.efF, e.d.cp_bg_line_b);
                } else {
                    cVar2.efE.setVisibility(0);
                    cVar2.efF.setVisibility(8);
                    al.j(cVar2.efE, e.d.cp_bg_line_b);
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
        /* renamed from: nD */
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
            if (f.this.efG != null) {
                f.this.efG.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.efl != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.mAdapter.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.efl.nA(atVar2.dOM);
                }
            }
        }
    };

    private void initView() {
        this.eev = new BdListView(this.mContext);
        this.eev.setAlwaysDrawnWithCacheEnabled(false);
        this.eev.setDivider(null);
        this.eev.setDividerHeight(0);
        this.eev.setSelector(17170445);
        this.eev.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.eev.setOnItemClickListener(this.mOnItemClickListener);
        this.eev.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.efG = eVar;
            this.efl = eVar.aIb();
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
        return this.eev;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aHZ() {
        return 0;
    }
}
