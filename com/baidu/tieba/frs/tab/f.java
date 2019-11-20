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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {
    private BdListView fPa;
    private e fQH;
    private e.b fQm;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.bFm = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.fQE = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.fQF = view.findViewById(R.id.tab_menu_line_s);
                cVar.fQG = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.bFm.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.bFm, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.fQE, R.drawable.chx_tips_list_ok);
                    cVar2.fQE.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.bFm, R.color.cp_cont_c, 1);
                    cVar2.fQE.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.fQG.setVisibility(0);
                    cVar2.fQF.setVisibility(8);
                    am.setBackgroundColor(cVar2.fQG, R.color.cp_bg_line_c);
                } else {
                    cVar2.fQF.setVisibility(0);
                    cVar2.fQG.setVisibility(8);
                    am.setBackgroundColor(cVar2.fQF, R.color.cp_bg_line_c);
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
        /* renamed from: rM */
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
            if (f.this.fQH != null) {
                f.this.fQH.bpM();
            }
            if (f.this.mAdapter != null && f.this.fQm != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.mAdapter.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.fQm.rJ(arVar2.fyi);
                }
            }
        }
    };

    private void initView() {
        this.fPa = new BdListView(this.mContext);
        this.fPa.setAlwaysDrawnWithCacheEnabled(false);
        this.fPa.setDivider(null);
        this.fPa.setDividerHeight(0);
        this.fPa.setSelector(17170445);
        this.fPa.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.fPa.setOnItemClickListener(this.mOnItemClickListener);
        this.fPa.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.fQH = eVar;
            this.fQm = eVar.bpN();
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
        return this.fPa;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bpK() {
        return 0;
    }
}
