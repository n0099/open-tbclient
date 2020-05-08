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
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes9.dex */
public class f implements a {
    private e.b huC;
    private BdListView huX;
    private e huY;
    private Context mContext;
    private List<ax> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.cTw = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.huU = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.huV = view.findViewById(R.id.tab_menu_line_s);
                cVar.huW = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ax item = getItem(i);
            if (item != null) {
                cVar2.cTw.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.cTw, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.huU, R.drawable.chx_tips_list_ok);
                    cVar2.huU.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.cTw, R.color.cp_cont_c, 1);
                    cVar2.huU.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.huW.setVisibility(0);
                    cVar2.huV.setVisibility(8);
                    am.setBackgroundColor(cVar2.huW, R.color.cp_bg_line_c);
                } else {
                    cVar2.huV.setVisibility(0);
                    cVar2.huW.setVisibility(8);
                    am.setBackgroundColor(cVar2.huV, R.color.cp_bg_line_c);
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
        /* renamed from: uG */
        public ax getItem(int i) {
            if (f.this.mData != null) {
                return (ax) f.this.mData.get(i);
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
            if (f.this.huY != null) {
                f.this.huY.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.huC != null) {
                for (ax axVar : f.this.mData) {
                    if (axVar != null) {
                        axVar.isSelected = false;
                    }
                }
                ax axVar2 = (ax) f.this.mAdapter.getItem(i);
                if (axVar2 != null) {
                    axVar2.isSelected = true;
                    f.this.huC.uD(axVar2.hcf);
                }
            }
        }
    };

    private void initView() {
        this.huX = new BdListView(this.mContext);
        this.huX.setAlwaysDrawnWithCacheEnabled(false);
        this.huX.setDivider(null);
        this.huX.setDividerHeight(0);
        this.huX.setSelector(17170445);
        this.huX.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.huX.setOnItemClickListener(this.mOnItemClickListener);
        this.huX.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.huY = eVar;
            this.huC = eVar.bUx();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ax> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.huX;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bUv() {
        return 0;
    }
}
