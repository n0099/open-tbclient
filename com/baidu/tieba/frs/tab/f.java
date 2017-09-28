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
    private BdListView cGO;
    private e cGP;
    private e.b cGs;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter cGQ = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.f.ds80)));
                e.c cVar = new e.c();
                cVar.name = (TextView) view.findViewById(d.h.tab_menu_name);
                cVar.cGL = (ImageView) view.findViewById(d.h.tab_menu_check);
                cVar.cGM = view.findViewById(d.h.tab_menu_line_s);
                cVar.cGN = view.findViewById(d.h.tab_menu_line_f);
                view.setTag(cVar);
            }
            aj.j(view, d.e.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.name.setText(item.name);
                if (item.isSelected) {
                    aj.c(cVar2.name, d.e.cp_link_tip_a, 1);
                    aj.c(cVar2.cGL, d.g.chx_tips_list_ok);
                    cVar2.cGL.setVisibility(0);
                } else {
                    aj.c(cVar2.name, d.e.cp_cont_c, 1);
                    cVar2.cGL.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cGN.setVisibility(0);
                    cVar2.cGM.setVisibility(8);
                    aj.k(cVar2.cGN, d.e.cp_bg_line_b);
                } else {
                    cVar2.cGM.setVisibility(0);
                    cVar2.cGN.setVisibility(8);
                    aj.k(cVar2.cGM, d.e.cp_bg_line_b);
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
        /* renamed from: jZ */
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
            if (f.this.cGP != null) {
                f.this.cGP.alD();
            }
            if (f.this.cGQ != null && f.this.cGs != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.cGQ.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.cGs.jY(atVar2.ctl);
                }
            }
        }
    };

    private void initView() {
        this.cGO = new BdListView(this.mContext);
        this.cGO.setAlwaysDrawnWithCacheEnabled(false);
        this.cGO.setDivider(null);
        this.cGO.setDividerHeight(0);
        this.cGO.setSelector(17170445);
        this.cGO.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cGO.setOnItemClickListener(this.mOnItemClickListener);
        this.cGO.setAdapter((ListAdapter) this.cGQ);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cGP = eVar;
            this.cGs = eVar.alE();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.cGQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cGO;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wB() {
        this.cGQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int alB() {
        return 0;
    }
}
