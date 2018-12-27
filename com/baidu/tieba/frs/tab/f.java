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
    private BdListView edP;
    private e.b eeF;
    private e efa;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(e.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(e.C0210e.ds80)));
                e.c cVar = new e.c();
                cVar.bPk = (TextView) view.findViewById(e.g.tab_menu_name);
                cVar.eeX = (ImageView) view.findViewById(e.g.tab_menu_check);
                cVar.eeY = view.findViewById(e.g.tab_menu_line_s);
                cVar.eeZ = view.findViewById(e.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            al.i(view, e.d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.bPk.setText(item.name);
                if (item.isSelected) {
                    al.c(cVar2.bPk, e.d.cp_link_tip_a, 1);
                    al.c(cVar2.eeX, e.f.chx_tips_list_ok);
                    cVar2.eeX.setVisibility(0);
                } else {
                    al.c(cVar2.bPk, e.d.cp_cont_c, 1);
                    cVar2.eeX.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.eeZ.setVisibility(0);
                    cVar2.eeY.setVisibility(8);
                    al.j(cVar2.eeZ, e.d.cp_bg_line_b);
                } else {
                    cVar2.eeY.setVisibility(0);
                    cVar2.eeZ.setVisibility(8);
                    al.j(cVar2.eeY, e.d.cp_bg_line_b);
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
        /* renamed from: nC */
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
            if (f.this.efa != null) {
                f.this.efa.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.eeF != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.mAdapter.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.eeF.nz(atVar2.dOd);
                }
            }
        }
    };

    private void initView() {
        this.edP = new BdListView(this.mContext);
        this.edP.setAlwaysDrawnWithCacheEnabled(false);
        this.edP.setDivider(null);
        this.edP.setDividerHeight(0);
        this.edP.setSelector(17170445);
        this.edP.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.edP.setOnItemClickListener(this.mOnItemClickListener);
        this.edP.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.efa = eVar;
            this.eeF = eVar.aHE();
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
        return this.edP;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aHC() {
        return 0;
    }
}
