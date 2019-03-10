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
/* loaded from: classes4.dex */
public class f implements a {
    private BdListView fsM;
    private e.b ftD;
    private e ftY;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(d.h.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.dfo = (TextView) view.findViewById(d.g.tab_menu_name);
                cVar.ftV = (ImageView) view.findViewById(d.g.tab_menu_check);
                cVar.ftW = view.findViewById(d.g.tab_menu_line_s);
                cVar.ftX = view.findViewById(d.g.tab_menu_line_f);
                view.setTag(cVar);
            }
            al.k(view, d.C0236d.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.dfo.setText(item.name);
                if (item.isSelected) {
                    al.d(cVar2.dfo, d.C0236d.cp_link_tip_a, 1);
                    al.c(cVar2.ftV, d.f.chx_tips_list_ok);
                    cVar2.ftV.setVisibility(0);
                } else {
                    al.d(cVar2.dfo, d.C0236d.cp_cont_c, 1);
                    cVar2.ftV.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.ftX.setVisibility(0);
                    cVar2.ftW.setVisibility(8);
                    al.l(cVar2.ftX, d.C0236d.cp_bg_line_b);
                } else {
                    cVar2.ftW.setVisibility(0);
                    cVar2.ftX.setVisibility(8);
                    al.l(cVar2.ftW, d.C0236d.cp_bg_line_b);
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
        /* renamed from: rr */
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
            if (f.this.ftY != null) {
                f.this.ftY.bir();
            }
            if (f.this.mAdapter != null && f.this.ftD != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.mAdapter.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.ftD.ro(arVar2.fcB);
                }
            }
        }
    };

    private void initView() {
        this.fsM = new BdListView(this.mContext);
        this.fsM.setAlwaysDrawnWithCacheEnabled(false);
        this.fsM.setDivider(null);
        this.fsM.setDividerHeight(0);
        this.fsM.setSelector(17170445);
        this.fsM.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.fsM.setOnItemClickListener(this.mOnItemClickListener);
        this.fsM.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.ftY = eVar;
            this.ftD = eVar.bis();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.fsM;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bip() {
        return 0;
    }
}
