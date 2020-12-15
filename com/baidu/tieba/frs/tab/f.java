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
    private BdListView juP;
    private e juQ;
    private e.b juu;
    private Context mContext;
    private List<bf> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.egV = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.juM = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.juN = view.findViewById(R.id.tab_menu_line_s);
                cVar.juO = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.CAM_X0201);
            e.c cVar2 = (e.c) view.getTag();
            bf item = getItem(i);
            if (item != null) {
                cVar2.egV.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.egV, R.color.CAM_X0302, 1);
                    ap.setImageResource(cVar2.juM, R.drawable.chx_tips_list_ok);
                    cVar2.juM.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.egV, R.color.CAM_X0108, 1);
                    cVar2.juM.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.juO.setVisibility(0);
                    cVar2.juN.setVisibility(8);
                    ap.setBackgroundColor(cVar2.juO, R.color.CAM_X0204);
                } else {
                    cVar2.juN.setVisibility(0);
                    cVar2.juO.setVisibility(8);
                    ap.setBackgroundColor(cVar2.juN, R.color.CAM_X0204);
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
        /* renamed from: BB */
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
            if (f.this.juQ != null) {
                f.this.juQ.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.juu != null) {
                for (bf bfVar : f.this.mData) {
                    if (bfVar != null) {
                        bfVar.isSelected = false;
                    }
                }
                bf bfVar2 = (bf) f.this.mAdapter.getItem(i);
                if (bfVar2 != null) {
                    bfVar2.isSelected = true;
                    f.this.juu.By(bfVar2.iXt);
                }
            }
        }
    };

    private void initView() {
        this.juP = new BdListView(this.mContext);
        this.juP.setAlwaysDrawnWithCacheEnabled(false);
        this.juP.setDivider(null);
        this.juP.setDividerHeight(0);
        this.juP.setSelector(17170445);
        this.juP.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.juP.setOnItemClickListener(this.mOnItemClickListener);
        this.juP.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.juQ = eVar;
            this.juu = eVar.cJN();
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
        return this.juP;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cJL() {
        return 0;
    }
}
