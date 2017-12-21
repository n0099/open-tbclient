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
import com.baidu.tieba.frs.au;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes.dex */
public class f implements a {
    private BdListView cZO;
    private e cZP;
    private e.b cZs;
    private Context mContext;
    private List<au> mData;
    private final BaseAdapter cZQ = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.aWW = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.cZL = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.cZM = view.findViewById(d.g.tab_menu_line_s);
                cVar.cZN = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            aj.j(view, d.C0095d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            au item = getItem(i);
            if (item != null) {
                cVar2.aWW.setText(item.name);
                if (item.isSelected) {
                    aj.c(cVar2.aWW, d.C0095d.cp_link_tip_a, 1);
                    aj.c(cVar2.cZL, d.f.chx_tips_list_ok);
                    cVar2.cZL.setVisibility(0);
                } else {
                    aj.c(cVar2.aWW, d.C0095d.cp_cont_c, 1);
                    cVar2.cZL.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.cZN.setVisibility(0);
                    cVar2.cZM.setVisibility(8);
                    aj.k(cVar2.cZN, d.C0095d.cp_bg_line_b);
                } else {
                    cVar2.cZM.setVisibility(0);
                    cVar2.cZN.setVisibility(8);
                    aj.k(cVar2.cZM, d.C0095d.cp_bg_line_b);
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
        /* renamed from: kU */
        public au getItem(int i) {
            if (f.this.mData != null) {
                return (au) f.this.mData.get(i);
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
            if (f.this.cZP != null) {
                f.this.cZP.aqB();
            }
            if (f.this.cZQ != null && f.this.cZs != null) {
                for (au auVar : f.this.mData) {
                    if (auVar != null) {
                        auVar.isSelected = false;
                    }
                }
                au auVar2 = (au) f.this.cZQ.getItem(i);
                if (auVar2 != null) {
                    auVar2.isSelected = true;
                    f.this.cZs.kT(auVar2.cKh);
                }
            }
        }
    };

    private void initView() {
        this.cZO = new BdListView(this.mContext);
        this.cZO.setAlwaysDrawnWithCacheEnabled(false);
        this.cZO.setDivider(null);
        this.cZO.setDividerHeight(0);
        this.cZO.setSelector(17170445);
        this.cZO.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.cZO.setOnItemClickListener(this.mOnItemClickListener);
        this.cZO.setAdapter((ListAdapter) this.cZQ);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.cZP = eVar;
            this.cZs = eVar.aqC();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<au> list) {
        this.mData = list;
        this.cZQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.cZO;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void wC() {
        this.cZQ.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int aqz() {
        return 0;
    }
}
