package com.baidu.tieba.hottopicselect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class b extends BaseAdapter {
    private String hxA;
    private LayoutInflater mInflater;
    private final List<d> mList = new ArrayList();

    public b(TbPageContext tbPageContext) {
        this.mInflater = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public void j(String str, List<d> list) {
        this.hxA = str;
        this.mList.clear();
        if (list != null) {
            this.mList.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<d> getList() {
        return this.mList;
    }

    public void clearList() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mList.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xU */
    public d getItem(int i) {
        return this.mList.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        d item = getItem(i);
        if (item != null) {
            if (view == null || !(view.getTag() instanceof a)) {
                view = this.mInflater.inflate(R.layout.hot_suggest_item, (ViewGroup) null);
                a aVar2 = new a();
                aVar2.djl = (TextView) view.findViewById(R.id.name);
                aVar2.iIH = view.findViewById(R.id.divider_line_top);
                aVar2.iII = view.findViewById(R.id.divider_line_bottom);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.iIH.setVisibility(i == 0 ? 0 : 8);
            aVar.djl.setText(ar.highLightText(com.baidu.tbadk.plugins.b.zc(ar.cutStringWithEllipsisNew(item.getTopicName(), 18)), this.hxA, R.color.cp_link_tip_a));
            a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a {
        int ahx;
        TextView djl;
        View iIH;
        View iII;

        private a() {
            this.ahx = 3;
        }
    }

    private void a(a aVar, View view, int i) {
        if (aVar != null && aVar.ahx != i) {
            an.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            an.setBackgroundColor(aVar.iII, R.color.cp_bg_line_c);
            an.setBackgroundColor(aVar.iIH, R.color.cp_bg_line_c);
            an.setViewTextColor(aVar.djl, R.color.cp_cont_b, 1);
            aVar.ahx = i;
        }
    }
}
