package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.s;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class e extends BaseAdapter {
    private Activity a;
    private ab b;
    private List<BaseGroupData> c = new ArrayList();

    public ab a() {
        return this.b;
    }

    public void a(List<BaseGroupData> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    public e(Activity activity) {
        this.a = activity;
        this.b = new ab(activity);
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
        f fVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.a).inflate(s.im_search_group_list_item, viewGroup, false);
            fVar = new f();
            fVar.a = (HeadImageView) view.findViewById(r.item_head);
            fVar.b = (TextView) view.findViewById(r.item_name);
            fVar.c = (TextView) view.findViewById(r.item_count);
            view.setTag(fVar);
        } else {
            fVar = (f) view.getTag();
        }
        BaseGroupData baseGroupData = this.c.get(i);
        fVar.a.setTag(null);
        fVar.a.setDefaultResource(q.avatar_poto_defaul50);
        fVar.a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        if (baseGroupData != null) {
            fVar.a.setTag(baseGroupData.getPortrait());
            fVar.b.setText(baseGroupData.getName());
            fVar.c.setText(this.a.getResources().getString(u.mem_count, String.valueOf(baseGroupData.getMemberNum())));
        }
        return view;
    }
}
