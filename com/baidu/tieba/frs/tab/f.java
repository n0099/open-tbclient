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
    private e.b doL;
    private BdListView dpg;
    private e dph;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter dpi = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.tab_item_menu_item_view, (ViewGroup) null);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.blN = (TextView) view2.findViewById(d.g.tab_menu_name);
                cVar.dpd = (ImageView) view2.findViewById(d.g.tab_menu_check);
                cVar.dpe = view2.findViewById(d.g.tab_menu_line_s);
                cVar.dpf = view2.findViewById(d.g.tab_menu_line_f);
                view2.setTag(cVar);
            }
            ak.i(view2, d.C0126d.cp_bg_line_d);
            e.c cVar2 = (e.c) view2.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.blN.setText(item.name);
                if (item.isSelected) {
                    ak.c(cVar2.blN, d.C0126d.cp_link_tip_a, 1);
                    ak.c(cVar2.dpd, d.f.chx_tips_list_ok);
                    cVar2.dpd.setVisibility(0);
                } else {
                    ak.c(cVar2.blN, d.C0126d.cp_cont_c, 1);
                    cVar2.dpd.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dpf.setVisibility(0);
                    cVar2.dpe.setVisibility(8);
                    ak.j(cVar2.dpf, d.C0126d.cp_bg_line_b);
                } else {
                    cVar2.dpe.setVisibility(0);
                    cVar2.dpf.setVisibility(8);
                    ak.j(cVar2.dpe, d.C0126d.cp_bg_line_b);
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
            if (f.this.dph != null) {
                f.this.dph.auM();
            }
            if (f.this.dpi != null && f.this.doL != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.dpi.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.doL.lg(arVar2.cZW);
                }
            }
        }
    };

    private void initView() {
        this.dpg = new BdListView(this.mContext);
        this.dpg.setAlwaysDrawnWithCacheEnabled(false);
        this.dpg.setDivider(null);
        this.dpg.setDividerHeight(0);
        this.dpg.setSelector(17170445);
        this.dpg.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dpg.setOnItemClickListener(this.mOnItemClickListener);
        this.dpg.setAdapter((ListAdapter) this.dpi);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dph = eVar;
            this.doL = eVar.auN();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        this.mData = list;
        this.dpi.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dpg;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int auK() {
        return 0;
    }
}
