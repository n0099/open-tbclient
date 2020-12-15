package com.baidu.tieba.hottopicselect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends BaseExpandableListAdapter {
    private LayoutInflater kiG;
    private ExpandableListView kiH;
    private final List<c> mList = new ArrayList();
    private TbPageContext<HotTopicSelectActivity> mPageContext;

    /* loaded from: classes21.dex */
    public static class a {
        int aku = 3;
        TextView keH = null;
        TextView kiI = null;
        View keK = null;
        View keL = null;
    }

    /* loaded from: classes21.dex */
    public static class b {
        int aku = 3;
        View dividerLine;
        View kiJ;
        TextView titleTv;
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kiG = LayoutInflater.from(this.mPageContext.getPageActivity());
    }

    public List<c> getList() {
        return this.mList;
    }

    public void b(c cVar) {
        this.mList.add(cVar);
    }

    public void clearList() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
        if (this.kiH != null) {
            int groupCount = getGroupCount();
            for (int i2 = 0; i2 < groupCount; i2++) {
                if (i2 != i) {
                    this.kiH.collapseGroup(i);
                }
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.mList.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        if (getGroup(i) == null || getGroup(i).getList() == null) {
            return 0;
        }
        return getGroup(i).getList().size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: DH */
    public c getGroup(int i) {
        return this.mList.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: cT */
    public d getChild(int i, int i2) {
        if (getGroup(i) == null || getGroup(i).getList() == null) {
            return null;
        }
        return getGroup(i).getList().get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || !(view.getTag() instanceof b)) {
            view = this.kiG.inflate(R.layout.hot_group_item, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.titleTv = (TextView) view.findViewById(R.id.header_text);
            bVar2.dividerLine = view.findViewById(R.id.divider_line);
            bVar2.kiJ = view.findViewById(R.id.group_divider);
            view.setTag(bVar2);
            view.setClickable(false);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        c group = getGroup(i);
        if (group != null) {
            bVar.titleTv.setText(au.cutStringWithSuffix(group.cSJ(), 15, null));
            if (i == 0) {
                bVar.dividerLine.setVisibility(0);
                bVar.kiJ.setVisibility(8);
            } else {
                bVar.dividerLine.setVisibility(8);
                bVar.kiJ.setVisibility(0);
            }
            a(bVar, view, TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    private void a(b bVar, View view, int i) {
        if (bVar != null && bVar.aku != i) {
            ap.setBackgroundColor(view, R.color.CAM_X0201);
            ap.setBackgroundColor(bVar.dividerLine, R.color.CAM_X0204);
            ap.setBackgroundColor(bVar.kiJ, R.color.CAM_X0205);
            ap.setViewTextColor(bVar.titleTv, R.color.CAM_X0109, 1);
            bVar.aku = i;
        }
    }

    private void a(a aVar, View view, int i) {
        if (aVar != null && aVar.aku != i) {
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(aVar.kiI, R.drawable.hot_select_tag_bg);
            ap.setBackgroundColor(aVar.keK, R.color.CAM_X0204);
            ap.setBackgroundColor(aVar.keL, R.color.CAM_X0204);
            ap.setViewTextColor(aVar.kiI, R.color.CAM_X0302, 1);
            ap.setViewTextColor(aVar.keH, R.color.CAM_X0105, 1);
            aVar.aku = i;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        d child = getChild(i, i2);
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate = this.kiG.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
            aVar = new a();
            aVar.keH = (TextView) inflate.findViewById(R.id.hot_topic_title);
            aVar.kiI = (TextView) inflate.findViewById(R.id.hot_topic_tag);
            aVar.keK = inflate.findViewById(R.id.divider_line_top);
            aVar.keL = inflate.findViewById(R.id.divider_line_bottom);
            inflate.setTag(aVar);
            view2 = inflate;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        if (child != null) {
            aVar.keH.setText(com.baidu.tbadk.plugins.b.Ez(au.cutStringWithEllipsisNew(child.getTopicName(), 15)));
            g(aVar.kiI, child.cSK().intValue());
            a(aVar, view2, TbadkCoreApplication.getInst().getSkinType());
        }
        return view2;
    }

    private void g(TextView textView, int i) {
        if (textView != null) {
            if (i == 10) {
                textView.setVisibility(0);
                textView.setText(this.mPageContext.getString(R.string.topic_tag_offical));
            } else if (i == 11) {
                textView.setVisibility(0);
                textView.setText(this.mPageContext.getString(R.string.topic_tag_bar));
            } else {
                textView.setVisibility(8);
            }
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        return getChildTypeCount() == 2 ? (i != 0 && i == 1) ? 2 : 1 : (getChildTypeCount() == 1 && getGroup(i).getType() != 0 && getGroup(i).getType() == 1) ? 2 : 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return this.mList.size();
    }
}
