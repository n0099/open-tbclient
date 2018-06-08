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
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private BdListView dzA;
    private e dzB;
    private e.b dzf;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter dzC = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.bui = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.dzx = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.dzy = view.findViewById(d.g.tab_menu_line_s);
                cVar.dzz = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            al.i(view, d.C0141d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.bui.setText(item.name);
                if (item.isSelected) {
                    al.c(cVar2.bui, d.C0141d.cp_link_tip_a, 1);
                    al.c(cVar2.dzx, d.f.chx_tips_list_ok);
                    cVar2.dzx.setVisibility(0);
                } else {
                    al.c(cVar2.bui, d.C0141d.cp_cont_c, 1);
                    cVar2.dzx.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dzz.setVisibility(0);
                    cVar2.dzy.setVisibility(8);
                    al.j(cVar2.dzz, d.C0141d.cp_bg_line_b);
                } else {
                    cVar2.dzy.setVisibility(0);
                    cVar2.dzz.setVisibility(8);
                    al.j(cVar2.dzy, d.C0141d.cp_bg_line_b);
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
        /* renamed from: lp */
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
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (f.this.dzB != null) {
                f.this.dzB.ayV();
            }
            if (f.this.dzC != null && f.this.dzf != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.dzC.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.dzf.lm(arVar2.dkv);
                }
            }
        }
    };

    private void initView() {
        this.dzA = new BdListView(this.mContext);
        this.dzA.setAlwaysDrawnWithCacheEnabled(false);
        this.dzA.setDivider(null);
        this.dzA.setDividerHeight(0);
        this.dzA.setSelector(17170445);
        this.dzA.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dzA.setOnItemClickListener(this.mOnItemClickListener);
        this.dzA.setAdapter((ListAdapter) this.dzC);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dzB = eVar;
            this.dzf = eVar.ayW();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        this.mData = list;
        this.dzC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dzA;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ayT() {
        return 0;
    }
}
