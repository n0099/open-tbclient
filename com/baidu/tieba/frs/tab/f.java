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
    private BdListView fPR;
    private e.b fRd;
    private e fRy;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.bGd = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.fRv = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.fRw = view.findViewById(R.id.tab_menu_line_s);
                cVar.fRx = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            am.setBackgroundResource(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.bGd.setText(item.name);
                if (item.isSelected) {
                    am.setViewTextColor(cVar2.bGd, R.color.cp_link_tip_a, 1);
                    am.setImageResource(cVar2.fRv, R.drawable.chx_tips_list_ok);
                    cVar2.fRv.setVisibility(0);
                } else {
                    am.setViewTextColor(cVar2.bGd, R.color.cp_cont_c, 1);
                    cVar2.fRv.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.fRx.setVisibility(0);
                    cVar2.fRw.setVisibility(8);
                    am.setBackgroundColor(cVar2.fRx, R.color.cp_bg_line_c);
                } else {
                    cVar2.fRw.setVisibility(0);
                    cVar2.fRx.setVisibility(8);
                    am.setBackgroundColor(cVar2.fRw, R.color.cp_bg_line_c);
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
        /* renamed from: rN */
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
            if (f.this.fRy != null) {
                f.this.fRy.bpO();
            }
            if (f.this.mAdapter != null && f.this.fRd != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.mAdapter.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.fRd.rK(arVar2.fyZ);
                }
            }
        }
    };

    private void initView() {
        this.fPR = new BdListView(this.mContext);
        this.fPR.setAlwaysDrawnWithCacheEnabled(false);
        this.fPR.setDivider(null);
        this.fPR.setDividerHeight(0);
        this.fPR.setSelector(17170445);
        this.fPR.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.fPR.setOnItemClickListener(this.mOnItemClickListener);
        this.fPR.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.fRy = eVar;
            this.fRd = eVar.bpP();
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
        return this.fPR;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bpM() {
        return 0;
    }
}
