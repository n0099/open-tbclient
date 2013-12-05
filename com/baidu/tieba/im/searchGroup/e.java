package com.baidu.tieba.im.searchGroup;

import android.app.Activity;
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
public class e extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private Activity f1876a;
    private com.baidu.tieba.util.i b;
    private List<BaseGroupData> c = new ArrayList();

    public com.baidu.tieba.util.i a() {
        return this.b;
    }

    public void a(List<BaseGroupData> list) {
        this.c = list;
        notifyDataSetChanged();
    }

    public e(Activity activity) {
        this.f1876a = activity;
        this.b = new com.baidu.tieba.util.i(activity);
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
            view = LayoutInflater.from(this.f1876a).inflate(R.layout.im_search_group_list_item, viewGroup, false);
            fVar = new f();
            fVar.f1877a = (HeadImageView) view.findViewById(R.id.item_head);
            fVar.b = (TextView) view.findViewById(R.id.item_name);
            fVar.c = (TextView) view.findViewById(R.id.item_count);
            view.setTag(fVar);
        } else {
            fVar = (f) view.getTag();
        }
        BaseGroupData baseGroupData = this.c.get(i);
        fVar.f1877a.setTag(null);
        fVar.f1877a.setDefaultResource(R.drawable.avatar_poto_defaul50);
        fVar.f1877a.setDefaultScaleType(ImageView.ScaleType.FIT_XY);
        if (baseGroupData != null) {
            fVar.f1877a.setTag(baseGroupData.getPortrait());
            fVar.b.setText(baseGroupData.getName());
            fVar.c.setText(this.f1876a.getResources().getString(R.string.mem_count, String.valueOf(baseGroupData.getMemberNum())));
        }
        return view;
    }
}
