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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes16.dex */
public class f implements a {
    private BdListView idL;
    private e idM;
    private e.b idn;
    private Context mContext;
    private List<bd> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.dpg = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.idI = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.idJ = view.findViewById(R.id.tab_menu_line_s);
                cVar.idK = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ao.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            bd item = getItem(i);
            if (item != null) {
                cVar2.dpg.setText(item.name);
                if (item.isSelected) {
                    ao.setViewTextColor(cVar2.dpg, R.color.cp_link_tip_a, 1);
                    ao.setImageResource(cVar2.idI, R.drawable.chx_tips_list_ok);
                    cVar2.idI.setVisibility(0);
                } else {
                    ao.setViewTextColor(cVar2.dpg, R.color.cp_cont_c, 1);
                    cVar2.idI.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.idK.setVisibility(0);
                    cVar2.idJ.setVisibility(8);
                    ao.setBackgroundColor(cVar2.idK, R.color.cp_bg_line_c);
                } else {
                    cVar2.idJ.setVisibility(0);
                    cVar2.idK.setVisibility(8);
                    ao.setBackgroundColor(cVar2.idJ, R.color.cp_bg_line_c);
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
        /* renamed from: wl */
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
            if (f.this.idM != null) {
                f.this.idM.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.idn != null) {
                for (bd bdVar : f.this.mData) {
                    if (bdVar != null) {
                        bdVar.isSelected = false;
                    }
                }
                bd bdVar2 = (bd) f.this.mAdapter.getItem(i);
                if (bdVar2 != null) {
                    bdVar2.isSelected = true;
                    f.this.idn.wi(bdVar2.hJP);
                }
            }
        }
    };

    private void initView() {
        this.idL = new BdListView(this.mContext);
        this.idL.setAlwaysDrawnWithCacheEnabled(false);
        this.idL.setDivider(null);
        this.idL.setDividerHeight(0);
        this.idL.setSelector(17170445);
        this.idL.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.idL.setOnItemClickListener(this.mOnItemClickListener);
        this.idL.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.idM = eVar;
            this.idn = eVar.chV();
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
        return this.idL;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int chT() {
        return 0;
    }
}
