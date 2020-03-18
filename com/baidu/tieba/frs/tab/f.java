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
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private BdListView gJU;
    private e gLA;
    private e.b gLf;
    private Context mContext;
    private List<at> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.cuv = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.gLx = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.gLy = view.findViewById(R.id.tab_menu_line_s);
                cVar.gLz = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            at item = getItem(i);
            if (item != null) {
                cVar2.cuv.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.cuv, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.gLx, R.drawable.chx_tips_list_ok);
                    cVar2.gLx.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.cuv, R.color.cp_cont_c, 1);
                    cVar2.gLx.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.gLz.setVisibility(0);
                    cVar2.gLy.setVisibility(8);
                    am.setBackgroundColor(cVar2.gLz, R.color.cp_bg_line_c);
                } else {
                    cVar2.gLy.setVisibility(0);
                    cVar2.gLz.setVisibility(8);
                    am.setBackgroundColor(cVar2.gLy, R.color.cp_bg_line_c);
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
        /* renamed from: uj */
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
            if (f.this.gLA != null) {
                f.this.gLA.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.gLf != null) {
                for (at atVar : f.this.mData) {
                    if (atVar != null) {
                        atVar.isSelected = false;
                    }
                }
                at atVar2 = (at) f.this.mAdapter.getItem(i);
                if (atVar2 != null) {
                    atVar2.isSelected = true;
                    f.this.gLf.ug(atVar2.gsO);
                }
            }
        }
    };

    private void initView() {
        this.gJU = new BdListView(this.mContext);
        this.gJU.setAlwaysDrawnWithCacheEnabled(false);
        this.gJU.setDivider(null);
        this.gJU.setDividerHeight(0);
        this.gJU.setSelector(17170445);
        this.gJU.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.gJU.setOnItemClickListener(this.mOnItemClickListener);
        this.gJU.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.gLA = eVar;
            this.gLf = eVar.bKc();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<at> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.gJU;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bKa() {
        return 0;
    }
}
