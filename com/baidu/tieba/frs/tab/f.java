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
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private BdListView gIB;
    private e.b gJM;
    private e gKh;
    private Context mContext;
    private List<as> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.cug = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.gKe = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.gKf = view.findViewById(R.id.tab_menu_line_s);
                cVar.gKg = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            as item = getItem(i);
            if (item != null) {
                cVar2.cug.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.cug, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.gKe, R.drawable.chx_tips_list_ok);
                    cVar2.gKe.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.cug, R.color.cp_cont_c, 1);
                    cVar2.gKe.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.gKg.setVisibility(0);
                    cVar2.gKf.setVisibility(8);
                    am.setBackgroundColor(cVar2.gKg, R.color.cp_bg_line_c);
                } else {
                    cVar2.gKf.setVisibility(0);
                    cVar2.gKg.setVisibility(8);
                    am.setBackgroundColor(cVar2.gKf, R.color.cp_bg_line_c);
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
        /* renamed from: ud */
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
            if (f.this.gKh != null) {
                f.this.gKh.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.gJM != null) {
                for (as asVar : f.this.mData) {
                    if (asVar != null) {
                        asVar.isSelected = false;
                    }
                }
                as asVar2 = (as) f.this.mAdapter.getItem(i);
                if (asVar2 != null) {
                    asVar2.isSelected = true;
                    f.this.gJM.ua(asVar2.grP);
                }
            }
        }
    };

    private void initView() {
        this.gIB = new BdListView(this.mContext);
        this.gIB.setAlwaysDrawnWithCacheEnabled(false);
        this.gIB.setDivider(null);
        this.gIB.setDividerHeight(0);
        this.gIB.setSelector(17170445);
        this.gIB.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.gIB.setOnItemClickListener(this.mOnItemClickListener);
        this.gIB.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gKh = eVar;
            this.gJM = eVar.bJM();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<as> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.gIB;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bJK() {
        return 0;
    }
}
