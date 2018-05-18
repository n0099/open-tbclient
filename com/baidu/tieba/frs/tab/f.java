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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.tab.e;
import java.util.List;
/* loaded from: classes2.dex */
public class f implements a {
    private e.b dpT;
    private BdListView dqo;
    private e dqp;
    private Context mContext;
    private List<ar> mData;
    private final BaseAdapter dqq = new BaseAdapter() { // from class: com.baidu.tieba.frs.tab.f.1
        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            if (view2 == null) {
                view2 = LayoutInflater.from(viewGroup.getContext()).inflate(d.i.tab_item_menu_item_view, (ViewGroup) null);
                view2.setLayoutParams(new AbsListView.LayoutParams(-1, viewGroup.getContext().getResources().getDimensionPixelSize(d.e.ds80)));
                e.c cVar = new e.c();
                cVar.bmc = (TextView) view2.findViewById(d.g.tab_menu_name);
                cVar.dql = (ImageView) view2.findViewById(d.g.tab_menu_check);
                cVar.dqm = view2.findViewById(d.g.tab_menu_line_s);
                cVar.dqn = view2.findViewById(d.g.tab_menu_line_f);
                view2.setTag(cVar);
            }
            ak.i(view2, d.C0126d.cp_bg_line_d);
            e.c cVar2 = (e.c) view2.getTag();
            ar item = getItem(i);
            if (item != null) {
                cVar2.bmc.setText(item.name);
                if (item.isSelected) {
                    ak.c(cVar2.bmc, d.C0126d.cp_link_tip_a, 1);
                    ak.c(cVar2.dql, d.f.chx_tips_list_ok);
                    cVar2.dql.setVisibility(0);
                } else {
                    ak.c(cVar2.bmc, d.C0126d.cp_cont_c, 1);
                    cVar2.dql.setVisibility(8);
                }
                if (i >= 0 && i == getCount() - 1) {
                    cVar2.dqn.setVisibility(0);
                    cVar2.dqm.setVisibility(8);
                    ak.j(cVar2.dqn, d.C0126d.cp_bg_line_b);
                } else {
                    cVar2.dqm.setVisibility(0);
                    cVar2.dqn.setVisibility(8);
                    ak.j(cVar2.dqm, d.C0126d.cp_bg_line_b);
                }
            }
            return view2;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // android.widget.Adapter
        /* renamed from: li */
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
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            if (f.this.dqp != null) {
                f.this.dqp.auL();
            }
            if (f.this.dqq != null && f.this.dpT != null) {
                for (ar arVar : f.this.mData) {
                    if (arVar != null) {
                        arVar.isSelected = false;
                    }
                }
                ar arVar2 = (ar) f.this.dqq.getItem(i);
                if (arVar2 != null) {
                    arVar2.isSelected = true;
                    f.this.dpT.lf(arVar2.dbf);
                }
            }
        }
    };

    private void initView() {
        this.dqo = new BdListView(this.mContext);
        this.dqo.setAlwaysDrawnWithCacheEnabled(false);
        this.dqo.setDivider(null);
        this.dqo.setDividerHeight(0);
        this.dqo.setSelector(17170445);
        this.dqo.setCacheColorHint(this.mContext.getResources().getColor(17170445));
        this.dqo.setOnItemClickListener(this.mOnItemClickListener);
        this.dqo.setAdapter((ListAdapter) this.dqq);
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void a(Context context, e eVar) {
        if (context != null && eVar != null) {
            this.mContext = context;
            this.dqp = eVar;
            this.dpT = eVar.auM();
            initView();
        }
    }

    @Override // com.baidu.tieba.frs.tab.a
    public void setData(List<ar> list) {
        this.mData = list;
        this.dqq.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.tab.a
    public View getView() {
        return this.dqo;
    }

    @Override // com.baidu.tieba.frs.tab.a
    public int auJ() {
        return 0;
    }
}
