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
import com.baidu.tieba.frs.bc;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private e.b jIb;
    private BdListView jIw;
    private e jIx;
    private Context mContext;
    private List<bc> mData;
    private final BaseAdapter mAdapter = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tab_item_menu_item_view, (ViewGroup) null);
                view.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(R.dimen.ds80)));
                e.c cVar = new e.c();
                cVar.enq = (TextView) view.findViewById(R.id.tab_menu_name);
                cVar.jIt = (ImageView) view.findViewById(R.id.tab_menu_check);
                cVar.jIu = view.findViewById(R.id.tab_menu_line_s);
                cVar.jIv = view.findViewById(R.id.tab_menu_line_f);
                view.setTag(cVar);
            }
            ap.setBackgroundResource(view, R.color.CAM_X0201);
            e.c cVar2 = (e.c) view.getTag();
            bc item = getItem(i);
            if (item != null) {
                cVar2.enq.setText(item.name);
                if (item.isSelected) {
                    ap.setViewTextColor(cVar2.enq, R.color.CAM_X0302, 1);
                    ap.setImageResource(cVar2.jIt, R.drawable.chx_tips_list_ok);
                    cVar2.jIt.setVisibility(0);
                } else {
                    ap.setViewTextColor(cVar2.enq, R.color.CAM_X0108, 1);
                    cVar2.jIt.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.jIv.setVisibility(0);
                    cVar2.jIu.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jIv, R.color.CAM_X0204);
                } else {
                    cVar2.jIu.setVisibility(0);
                    cVar2.jIv.setVisibility(8);
                    ap.setBackgroundColor(cVar2.jIu, R.color.CAM_X0204);
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
        /* renamed from: Ar */
        public bc getItem(int i) {
            if (f.this.mData != null) {
                return (bc) f.this.mData.get(i);
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
            if (f.this.jIx != null) {
                f.this.jIx.cKq();
            }
            if (f.this.mAdapter != null && f.this.jIb != null) {
                for (bc bcVar : f.this.mData) {
                    if (bcVar != null) {
                        bcVar.isSelected = false;
                    }
                }
                bc bcVar2 = (bc) f.this.mAdapter.getItem(i);
                if (bcVar2 != null) {
                    bcVar2.isSelected = true;
                    f.this.jIb.Ao(bcVar2.jkT);
                }
            }
        }
    };

    private void initView() {
        this.jIw = new BdListView(this.mContext);
        this.jIw.setAlwaysDrawnWithCacheEnabled(false);
        this.jIw.setDivider(null);
        this.jIw.setDividerHeight(0);
        this.jIw.setSelector(17170445);
        this.jIw.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.jIw.setOnItemClickListener(this.mOnItemClickListener);
        this.jIw.setAdapter((ListAdapter) this.mAdapter);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.jIx = eVar;
            this.jIb = eVar.cKr();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<bc> list) {
        this.mData = list;
        this.mAdapter.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.jIw;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int cKo() {
        return 0;
    }
}
