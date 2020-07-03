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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private BdListView hXJ;
    private e hXK;
    private e.b hXo;
    private Context mContext;
    private List<bd> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.djl = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.hXG = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.hXH = view.findViewById(R.id.tab_menu_line_s);
                cVar.hXI = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            an.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            bd item = getItem(i);
            if (item != null) {
                cVar2.djl.setText(item.name);
                if (item.isSelected) {
                    an.setViewTextColor(cVar2.djl, R.color.cp_link_tip_a, 1);
                    an.setImageResource(cVar2.hXG, R.drawable.chx_tips_list_ok);
                    cVar2.hXG.setVisibility(0);
                } else {
                    an.setViewTextColor(cVar2.djl, R.color.cp_cont_c, 1);
                    cVar2.hXG.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.hXI.setVisibility(0);
                    cVar2.hXH.setVisibility(8);
                    an.setBackgroundColor(cVar2.hXI, R.color.cp_bg_line_c);
                } else {
                    cVar2.hXH.setVisibility(0);
                    cVar2.hXI.setVisibility(8);
                    an.setBackgroundColor(cVar2.hXH, R.color.cp_bg_line_c);
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
        /* renamed from: vT */
        public bd getItem(int i) {
            if (f.this.mData != null) {
                return (bd) f.this.mData.get(i);
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
            if (f.this.hXK != null) {
                f.this.hXK.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.hXo != null) {
                for (bd bdVar : f.this.mData) {
                    if (bdVar != null) {
                        bdVar.isSelected = false;
                    }
                }
                bd bdVar2 = (bd) f.this.mAdapter.getItem(i);
                if (bdVar2 != null) {
                    bdVar2.isSelected = true;
                    f.this.hXo.vQ(bdVar2.hDR);
                }
            }
        }
    };

    private void initView() {
        this.hXJ = new BdListView(this.mContext);
        this.hXJ.setAlwaysDrawnWithCacheEnabled(false);
        this.hXJ.setDivider(null);
        this.hXJ.setDividerHeight(0);
        this.hXJ.setSelector(17170445);
        this.hXJ.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.hXJ.setOnItemClickListener(this.mOnItemClickListener);
        this.hXJ.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.hXK = eVar;
            this.hXo = eVar.cev();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bd> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.hXJ;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cet() {
        return 0;
    }
}
