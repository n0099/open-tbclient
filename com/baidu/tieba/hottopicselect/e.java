package com.baidu.tieba.hottopicselect;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class e extends BaseExpandableListAdapter {
    private LayoutInflater kvQ;
    private ExpandableListView kvR;
    private final List<c> mList = new ArrayList();
    private TbPageContext<HotTopicSelectActivity> mPageContext;

    /* loaded from: classes8.dex */
    public static class a {
        int akW = 3;
        TextView krT = null;
        TextView kvS = null;
        View krW = null;
        View krX = null;
    }

    /* loaded from: classes8.dex */
    public static class b {
        int akW = 3;
        View dividerLine;
        View kvT;
        TextView titleTv;
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.kvQ = LayoutInflater.from(this.mPageContext.getPageActivity());
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
        if (this.kvR != null) {
            int groupCount = getGroupCount();
            for (int i2 = 0; i2 < groupCount; i2++) {
                if (i2 != i) {
                    this.kvR.collapseGroup(i);
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
    /* renamed from: DV */
    public c getGroup(int i) {
        return this.mList.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: cR */
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
            view = this.kvQ.inflate(R.layout.hot_group_item, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.titleTv = (TextView) view.findViewById(R.id.header_text);
            bVar2.dividerLine = view.findViewById(R.id.divider_line);
            bVar2.kvT = view.findViewById(R.id.group_divider);
            view.setTag(bVar2);
            view.setClickable(false);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        c group = getGroup(i);
        if (group != null) {
            bVar.titleTv.setText(at.cutStringWithSuffix(group.cVQ(), 15, null));
            if (i == 0) {
                bVar.dividerLine.setVisibility(0);
                bVar.kvT.setVisibility(8);
            } else {
                bVar.dividerLine.setVisibility(8);
                bVar.kvT.setVisibility(0);
            }
            a(bVar, view, TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    private void a(b bVar, View view, int i) {
        if (bVar != null && bVar.akW != i) {
            ao.setBackgroundColor(view, R.color.CAM_X0201);
            ao.setBackgroundColor(bVar.dividerLine, R.color.CAM_X0204);
            ao.setBackgroundColor(bVar.kvT, R.color.CAM_X0205);
            ao.setViewTextColor(bVar.titleTv, R.color.CAM_X0109, 1);
            bVar.akW = i;
        }
    }

    private void a(a aVar, View view, int i) {
        if (aVar != null && aVar.akW != i) {
            ao.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ao.setBackgroundResource(aVar.kvS, R.drawable.hot_select_tag_bg);
            ao.setBackgroundColor(aVar.krW, R.color.CAM_X0204);
            ao.setBackgroundColor(aVar.krX, R.color.CAM_X0204);
            ao.setViewTextColor(aVar.kvS, R.color.CAM_X0302, 1);
            ao.setViewTextColor(aVar.krT, R.color.CAM_X0105, 1);
            aVar.akW = i;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View inflate;
        a aVar;
        d child = getChild(i, i2);
        if (view == null || !(view.getTag() instanceof a)) {
            inflate = this.kvQ.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
            a aVar2 = new a();
            aVar2.krT = (TextView) inflate.findViewById(R.id.hot_topic_title);
            aVar2.kvS = (TextView) inflate.findViewById(R.id.hot_topic_tag);
            aVar2.krW = inflate.findViewById(R.id.divider_line_top);
            aVar2.krX = inflate.findViewById(R.id.divider_line_bottom);
            inflate.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
            inflate = view;
        }
        if (child == null) {
            return inflate;
        }
        aVar.krT.setText(com.baidu.tbadk.plugins.b.Ev(at.cutStringWithEllipsisNew(child.getTopicName(), 15)));
        g(aVar.kvS, child.cVR().intValue());
        a(aVar, inflate, TbadkCoreApplication.getInst().getSkinType());
        return inflate;
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
