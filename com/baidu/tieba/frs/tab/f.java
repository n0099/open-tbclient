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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bf;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes22.dex */
public class f implements a {
    private BdListView jaC;
    private e jaD;
    private e.b jah;
    private Context mContext;
    private List<bf> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.dVL = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.jaz = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.jaA = view.findViewById(R.id.tab_menu_line_s);
                cVar.jaB = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            bf item = getItem(i);
            if (item != null) {
                cVar2.dVL.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.dVL, R.color.cp_link_tip_a, 1);
                    ap.setImageResource(cVar2.jaz, R.drawable.chx_tips_list_ok);
                    cVar2.jaz.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.dVL, R.color.cp_cont_c, 1);
                    cVar2.jaz.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.jaB.setVisibility(0);
                    cVar2.jaA.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jaB, R.color.cp_bg_line_c);
                } else {
                    cVar2.jaA.setVisibility(0);
                    cVar2.jaB.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jaA, R.color.cp_bg_line_c);
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
        /* renamed from: Ac */
        public bf getItem(int i) {
            if (f.this.mData != null) {
                return (bf) f.this.mData.get(i);
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
            if (f.this.jaD != null) {
                f.this.jaD.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.jah != null) {
                for (bf bfVar : f.this.mData) {
                    if (bfVar != null) {
                        bfVar.isSelected = false;
                    }
                }
                bf bfVar2 = (bf) f.this.mAdapter.getItem(i);
                if (bfVar2 != null) {
                    bfVar2.isSelected = true;
                    f.this.jah.zZ(bfVar2.iFQ);
                }
            }
        }
    };

    private void initView() {
        this.jaC = new BdListView(this.mContext);
        this.jaC.setAlwaysDrawnWithCacheEnabled(false);
        this.jaC.setDivider(null);
        this.jaC.setDividerHeight(0);
        this.jaC.setSelector(17170445);
        this.jaC.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.jaC.setOnItemClickListener(this.mOnItemClickListener);
        this.jaC.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jaD = eVar;
            this.jah = eVar.cCt();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bf> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.jaC;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cCr() {
        return 0;
    }
}
