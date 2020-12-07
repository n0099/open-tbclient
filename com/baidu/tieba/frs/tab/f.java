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
    private BdListView juN;
    private e juO;
    private e.b jus;
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
                cVar.juK = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.juL = view.findViewById(R.id.tab_menu_line_s);
                cVar.juM = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.CAM_X0201);
            e.c cVar2 = (e.c) view.getTag();
            bf item = getItem(i);
            if (item != null) {
                cVar2.egV.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.egV, R.color.CAM_X0302, 1);
                    ap.setImageResource(cVar2.juK, R.drawable.chx_tips_list_ok);
                    cVar2.juK.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.egV, R.color.CAM_X0108, 1);
                    cVar2.juK.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.juM.setVisibility(0);
                    cVar2.juL.setVisibility(8);
                    ap.setBackgroundColor(cVar2.juM, R.color.CAM_X0204);
                } else {
                    cVar2.juL.setVisibility(0);
                    cVar2.juM.setVisibility(8);
                    ap.setBackgroundColor(cVar2.juL, R.color.CAM_X0204);
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
            if (f.this.juO != null) {
                f.this.juO.dismissMenu();
            }
            if (f.this.mAdapter != null && f.this.jus != null) {
                for (bf bfVar : f.this.mData) {
                    if (bfVar != null) {
                        bfVar.isSelected = false;
                    }
                }
                bf bfVar2 = (bf) f.this.mAdapter.getItem(i);
                if (bfVar2 != null) {
                    bfVar2.isSelected = true;
                    f.this.jus.By(bfVar2.iXr);
                }
            }
        }
    };

    private void initView() {
        this.juN = new BdListView(this.mContext);
        this.juN.setAlwaysDrawnWithCacheEnabled(false);
        this.juN.setDivider(null);
        this.juN.setDividerHeight(0);
        this.juN.setSelector(17170445);
        this.juN.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.juN.setOnItemClickListener(this.mOnItemClickListener);
        this.juN.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.juO = eVar;
            this.jus = eVar.cJM();
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
        return this.juN;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cJK() {
        return 0;
    }
}
