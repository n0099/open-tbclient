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
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class e extends BaseExpandableListAdapter {
    private LayoutInflater jOs;
    private ExpandableListView jOt;
    private final List<c> mList = new ArrayList();
    private TbPageContext<HotTopicSelectActivity> mPageContext;

    /* loaded from: classes21.dex */
    public static class a {
        int ajq = 3;
        TextView jKt = null;
        TextView jOu = null;
        View jKw = null;
        View jKx = null;
    }

    /* loaded from: classes21.dex */
    public static class b {
        int ajq = 3;
        View dividerLine;
        View jOv;
        TextView titleTv;
    }

    public e(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.jOs = LayoutInflater.from(this.mPageContext.getPageActivity());
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
        if (this.jOt != null) {
            int groupCount = getGroupCount();
            for (int i2 = 0; i2 < groupCount; i2++) {
                if (i2 != i) {
                    this.jOt.collapseGroup(i);
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
    /* renamed from: Ch */
    public c getGroup(int i) {
        return this.mList.get(i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ExpandableListAdapter
    /* renamed from: cM */
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
            view = this.jOs.inflate(R.layout.hot_group_item, (ViewGroup) null);
            b bVar2 = new b();
            bVar2.titleTv = (TextView) view.findViewById(R.id.header_text);
            bVar2.dividerLine = view.findViewById(R.id.divider_line);
            bVar2.jOv = view.findViewById(R.id.group_divider);
            view.setTag(bVar2);
            view.setClickable(false);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        c group = getGroup(i);
        if (group != null) {
            bVar.titleTv.setText(at.cutStringWithSuffix(group.cLn(), 15, null));
            if (i == 0) {
                bVar.dividerLine.setVisibility(0);
                bVar.jOv.setVisibility(8);
            } else {
                bVar.dividerLine.setVisibility(8);
                bVar.jOv.setVisibility(0);
            }
            a(bVar, view, TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    private void a(b bVar, View view, int i) {
        if (bVar != null && bVar.ajq != i) {
            ap.setBackgroundColor(view, R.color.cp_bg_line_d);
            ap.setBackgroundColor(bVar.dividerLine, R.color.cp_bg_line_c);
            ap.setBackgroundColor(bVar.jOv, R.color.cp_bg_line_e);
            ap.setViewTextColor(bVar.titleTv, R.color.cp_cont_d, 1);
            bVar.ajq = i;
        }
    }

    private void a(a aVar, View view, int i) {
        if (aVar != null && aVar.ajq != i) {
            ap.setBackgroundResource(view, R.drawable.addresslist_item_bg);
            ap.setBackgroundResource(aVar.jOu, R.drawable.hot_select_tag_bg);
            ap.setBackgroundColor(aVar.jKw, R.color.cp_bg_line_c);
            ap.setBackgroundColor(aVar.jKx, R.color.cp_bg_line_c);
            ap.setViewTextColor(aVar.jOu, R.color.cp_link_tip_a, 1);
            ap.setViewTextColor(aVar.jKt, R.color.cp_cont_b, 1);
            aVar.ajq = i;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        a aVar;
        View view2;
        d child = getChild(i, i2);
        if (view == null || !(view.getTag() instanceof a)) {
            View inflate = this.jOs.inflate(R.layout.hot_child_bang_item, (ViewGroup) null);
            aVar = new a();
            aVar.jKt = (TextView) inflate.findViewById(R.id.hot_topic_title);
            aVar.jOu = (TextView) inflate.findViewById(R.id.hot_topic_tag);
            aVar.jKw = inflate.findViewById(R.id.divider_line_top);
            aVar.jKx = inflate.findViewById(R.id.divider_line_bottom);
            inflate.setTag(aVar);
            view2 = inflate;
        } else {
            aVar = (a) view.getTag();
            view2 = view;
        }
        if (child != null) {
            aVar.jKt.setText(com.baidu.tbadk.plugins.b.Eb(at.cutStringWithEllipsisNew(child.getTopicName(), 15)));
            h(aVar.jOu, child.cLo().intValue());
            a(aVar, view2, TbadkCoreApplication.getInst().getSkinType());
        }
        return view2;
    }

    private void h(TextView textView, int i) {
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
