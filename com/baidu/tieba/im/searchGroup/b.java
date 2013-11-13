package com.baidu.tieba.im.searchGroup;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.im.data.BaseGroupData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private SearchGroupActivity f1786a;
    private com.baidu.tieba.util.i b;
    private List<BaseGroupData> c = new ArrayList();

    public com.baidu.tieba.util.i a() {
        return this.b;
    }

    public void a(List<BaseGroupData> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    public b(SearchGroupActivity searchGroupActivity) {
        this.f1786a = searchGroupActivity;
        this.b = new com.baidu.tieba.util.i(searchGroupActivity);
        this.b.d(true);
    }

    public boolean a(int i) {
        return this.c != null && i >= 0 && i < this.c.size();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: b */
    public BaseGroupData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.c.size()) {
            return null;
        }
        return this.c.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.f1786a).inflate(R.layout.im_search_group_list_item, viewGroup, false);
            cVar = new c();
            cVar.f1787a = (HeadImageView) view.findViewById(R.id.item_head);
            cVar.b = (TextView) view.findViewById(R.id.item_name);
            cVar.c = (TextView) view.findViewById(R.id.item_count);
            view.setTag(cVar);
        } else {
            cVar = (c) view.getTag();
        }
        BaseGroupData baseGroupData = this.c.get(i);
        cVar.f1787a.setTag(null);
        cVar.f1787a.setDefaultResource(R.drawable.avatar_poto_defaul50);
        cVar.f1787a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        if (baseGroupData != null) {
            cVar.f1787a.setTag(baseGroupData.getPortrait());
            cVar.b.setText(baseGroupData.getName());
            cVar.c.setText(this.f1786a.getResources().getString(R.string.mem_count, String.valueOf(baseGroupData.getMemberNum())));
        }
        return view;
    }
}
