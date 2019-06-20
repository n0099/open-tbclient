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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {
    private BdListView fIW;
    private e fKC;
    private e.b fKh;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.bmf = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.fKz = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.fKA = view.findViewById(R.id.tab_menu_line_s);
                cVar.fKB = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            al.k(view, R.color.cp_bg_line_d);
            e.c cVar2 = (e.c) view.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.bmf.setText(item.name);
                if (item.isSelected) {
                    al.f(cVar2.bmf, R.color.cp_link_tip_a, 1);
                    al.c(cVar2.fKz, (int) R.drawable.chx_tips_list_ok);
                    cVar2.fKz.setVisibility(0);
                } else {
                    al.f(cVar2.bmf, R.color.cp_cont_c, 1);
                    cVar2.fKz.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.fKB.setVisibility(0);
                    cVar2.fKA.setVisibility(8);
                    al.l(cVar2.fKB, R.color.cp_bg_line_b);
                } else {
                    cVar2.fKA.setVisibility(0);
                    cVar2.fKB.setVisibility(8);
                    al.l(cVar2.fKA, R.color.cp_bg_line_b);
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
        /* renamed from: sv */
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
            if (f.this.fKC != null) {
                f.this.fKC.bpJ();
            }
            if (f.this.mAdapter != null && f.this.fKh != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.mAdapter.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.fKh.ss(arVar2.fsC);
                }
            }
        }
    };

    private void initView() {
        this.fIW = new BdListView(this.mContext);
        this.fIW.setAlwaysDrawnWithCacheEnabled(false);
        this.fIW.setDivider(null);
        this.fIW.setDividerHeight(0);
        this.fIW.setSelector(17170445);
        this.fIW.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.fIW.setOnItemClickListener(this.mOnItemClickListener);
        this.fIW.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.fKC = eVar;
            this.fKh = eVar.bpK();
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
        return this.fIW;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int bpH() {
        return 0;
    }
}
