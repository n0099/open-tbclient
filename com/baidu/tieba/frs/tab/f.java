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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private e.b doO;
    private BdListView dpj;
    private e dpk;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter dpl = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.tab_item_menu_item_view, (ViewGroup) null);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.blN = (TextView) view2.findViewById(d.g.tab_menu_name);
                cVar.dpg = (ImageView) view2.findViewById(d.g.tab_menu_check);
                cVar.dph = view2.findViewById(d.g.tab_menu_line_s);
                cVar.dpi = view2.findViewById(d.g.tab_menu_line_f);
                view2.setTag(cVar);
            }
            ak.i(view2, d.C0126d.cp_bg_line_d);
            e.c cVar2 = (e.c) view2.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.blN.setText(item.name);
                if (item.isSelected) {
                    ak.c(cVar2.blN, d.C0126d.cp_link_tip_a, 1);
                    ak.c(cVar2.dpg, d.f.chx_tips_list_ok);
                    cVar2.dpg.setVisibility(0);
                } else {
                    ak.c(cVar2.blN, d.C0126d.cp_cont_c, 1);
                    cVar2.dpg.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dpi.setVisibility(0);
                    cVar2.dph.setVisibility(8);
                    ak.j(cVar2.dpi, d.C0126d.cp_bg_line_b);
                } else {
                    cVar2.dph.setVisibility(0);
                    cVar2.dpi.setVisibility(8);
                    ak.j(cVar2.dph, d.C0126d.cp_bg_line_b);
                }
            }
            return view2;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: lj */
        public ar getItem(int i) {
            if (f.this.mData != null) {
                return (ar) f.this.mData.get(i);
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (f.this.dpk != null) {
                f.this.dpk.auM();
            }
            if (f.this.dpl != null && f.this.doO != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.dpl.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.doO.lg(arVar2.cZZ);
                }
            }
        }
    };

    private void initView() {
        this.dpj = new BdListView(this.mContext);
        this.dpj.setAlwaysDrawnWithCacheEnabled(false);
        this.dpj.setDivider(null);
        this.dpj.setDividerHeight(0);
        this.dpj.setSelector(17170445);
        this.dpj.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dpj.setOnItemClickListener(this.mOnItemClickListener);
        this.dpj.setAdapter((ListAdapter) this.dpl);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dpk = eVar;
            this.doO = eVar.auN();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        this.mData = list;
        this.dpl.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dpj;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int auK() {
        return 0;
    }
}
