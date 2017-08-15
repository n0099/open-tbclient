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
    private BdListView cyA;
    private e cyB;
    private e.b cye;
    private Context mContext;
    private List<as> mData;
    private final BaseAdapter cyC = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.j.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.f.ds80)));
                e.c cVar = new e.c();
                cVar.name = (TextView) view.findViewById(d.h.tab_menu_name);
                cVar.cyx = (ImageView) view.findViewById(d.h.tab_menu_check);
                cVar.cyy = view.findViewById(d.h.tab_menu_line_s);
                cVar.cyz = view.findViewById(d.h.tab_menu_line_f);
                view.setTag(cVar);
            }
            ai.j(view, d.e.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            as item = getItem(i);
            if (item != null) {
                cVar2.name.setText(item.name);
                if (item.isSelected) {
                    ai.c(cVar2.name, d.e.cp_link_tip_a, 1);
                    ai.c(cVar2.cyx, d.g.chx_tips_list_ok);
                    cVar2.cyx.setVisibility(0);
                } else {
                    ai.c(cVar2.name, d.e.cp_cont_c, 1);
                    cVar2.cyx.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cyz.setVisibility(0);
                    cVar2.cyy.setVisibility(8);
                    ai.k(cVar2.cyz, d.e.cp_bg_line_b);
                } else {
                    cVar2.cyy.setVisibility(0);
                    cVar2.cyz.setVisibility(8);
                    ai.k(cVar2.cyy, d.e.cp_bg_line_b);
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
        /* renamed from: jB */
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
            if (f.this.cyB != null) {
                f.this.cyB.ajK();
            }
            if (f.this.cyC != null && f.this.cye != null) {
                for (as asVar : f.this.mData) {
                    if (asVar != null) {
                        asVar.isSelected = false;
                    }
                }
                as asVar2 = (as) f.this.cyC.getItem(i);
                if (asVar2 != null) {
                    asVar2.isSelected = true;
                    f.this.cye.jA(asVar2.cmw);
                }
            }
        }
    };

    private void initView() {
        this.cyA = new BdListView(this.mContext);
        this.cyA.setAlwaysDrawnWithCacheEnabled(false);
        this.cyA.setDivider(null);
        this.cyA.setDividerHeight(0);
        this.cyA.setSelector(17170445);
        this.cyA.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cyA.setOnItemClickListener(this.mOnItemClickListener);
        this.cyA.setAdapter((ListAdapter) this.cyC);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cyB = eVar;
            this.cye = eVar.ajL();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        this.mData = list;
        this.cyC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cyA;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void xd() {
        this.cyC.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int ajI() {
        return 0;
    }
}
