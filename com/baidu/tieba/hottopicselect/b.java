package com.baidu.tieba.hottopicselect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class b extends BaseAdapter {
    private String iFR;
    private LayoutInflater mInflater;
    private final List<d> mList = new ArrayList();

    public b(TbPageContext tbPageContext) {
        this.mInflater = LayoutInflater.from(tbPageContext.getPageActivity());
    }

    public void j(String str, List<d> list) {
        this.iFR = str;
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
    /* renamed from: CR */
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
                aVar2.dZV = (TextView) view.findViewById(R.id.name);
                aVar2.jUB = view.findViewById(R.id.divider_line_top);
                aVar2.jUC = view.findViewById(R.id.divider_line_bottom);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.jUB.setVisibility(i == 0 ? 0 : 8);
            aVar.dZV.setText(au.highLightText(com.baidu.tbadk.plugins.b.DO(au.cutStringWithEllipsisNew(item.getTopicName(), 18)), this.iFR, R.color.CAM_X0302));
            a(aVar, view, TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes20.dex */
    public class a {
        int ajv;
        TextView dZV;
        View jUB;
        View jUC;

        private a() {
            this.ajv = 3;
        }
    }

    private void a(a aVar, View view, int i) {
        if (aVar != null && aVar.ajv != i) {
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ap.setBackgroundColor(aVar.jUC, R.color.CAM_X0204);
            ap.setBackgroundColor(aVar.jUB, R.color.CAM_X0204);
            ap.setViewTextColor(aVar.dZV, R.color.CAM_X0105, 1);
            aVar.ajv = i;
        }
    }
}
