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
    private e.b iNL;
    private BdListView iOg;
    private e iOh;
    private Context mContext;
    private List<bf> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.dNo = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.iOd = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.iOe = view.findViewById(R.id.tab_menu_line_s);
                cVar.iOf = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            bf item = getItem(i);
            if (item != null) {
                cVar2.dNo.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.dNo, R.color.cp_link_tip_a, 1);
                    ap.setImageResource(cVar2.iOd, R.drawable.chx_tips_list_ok);
                    cVar2.iOd.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.dNo, R.color.cp_cont_c, 1);
                    cVar2.iOd.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.iOf.setVisibility(0);
                    cVar2.iOe.setVisibility(8);
                    ap.setBackgroundColor(cVar2.iOf, R.color.cp_bg_line_c);
                } else {
                    cVar2.iOe.setVisibility(0);
                    cVar2.iOf.setVisibility(8);
                    ap.setBackgroundColor(cVar2.iOe, R.color.cp_bg_line_c);
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
        /* renamed from: zJ */
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
            if (f.this.iOh != null) {
                f.this.iOh.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.iNL != null) {
                for (bf bfVar : f.this.mData) {
                    if (bfVar != null) {
                        bfVar.isSelected = false;
                    }
                }
                bf bfVar2 = (bf) f.this.mAdapter.getItem(i);
                if (bfVar2 != null) {
                    bfVar2.isSelected = true;
                    f.this.iNL.zG(bfVar2.itu);
                }
            }
        }
    };

    private void initView() {
        this.iOg = new BdListView(this.mContext);
        this.iOg.setAlwaysDrawnWithCacheEnabled(false);
        this.iOg.setDivider(null);
        this.iOg.setDividerHeight(0);
        this.iOg.setSelector(17170445);
        this.iOg.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.iOg.setOnItemClickListener(this.mOnItemClickListener);
        this.iOg.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.iOh = eVar;
            this.iNL = eVar.czm();
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
        return this.iOg;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int czk() {
        return 0;
    }
}
