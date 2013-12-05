package com.baidu.tieba.im.mygroup;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tieba.BaseFragmentActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.view.HeadImageView;
import com.slidingmenu.lib.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class a extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private MyGroupFragment f1833a;
    private com.baidu.tieba.util.i b;
    private List<GroupInfoData> c = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.c = list;
    }

    public com.baidu.tieba.util.i a() {
        return this.b;
    }

    public a(MyGroupFragment myGroupFragment) {
        this.f1833a = myGroupFragment;
        this.b = new com.baidu.tieba.util.i(myGroupFragment.i());
        this.b.d(true);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GroupInfoData getItem(int i) {
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
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.f1833a.i()).inflate(R.layout.im_group_list_item, viewGroup, false);
            bVar = new b();
            bVar.f1834a = (LinearLayout) view.findViewById(R.id.click_head);
            bVar.b = (LinearLayout) view.findViewById(R.id.list_item_content);
            bVar.c = (HeadImageView) view.findViewById(R.id.item_head);
            bVar.d = (TextView) view.findViewById(R.id.item_group_name);
            bVar.e = (TextView) view.findViewById(R.id.item_group_num);
            bVar.f = (TextView) view.findViewById(R.id.item_introduce);
            bVar.g = (TextView) view.findViewById(R.id.list_more_title);
            bVar.h = (TextView) view.findViewById(R.id.isCreator);
            bVar.i = (ImageView) view.findViewById(R.id.item_grade1);
            bVar.j = (ImageView) view.findViewById(R.id.item_grade2);
            bVar.k = (ImageView) view.findViewById(R.id.item_grade3);
            bVar.l = new ImageView[4];
            bVar.l[1] = bVar.i;
            bVar.l[2] = bVar.j;
            bVar.l[3] = bVar.k;
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        GroupInfoData groupInfoData = this.c.get(i);
        bVar.c.setTag(null);
        bVar.c.setDefaultResource(R.drawable.avatar_poto_defaul140);
        bVar.c.setNightDefaultResource(R.drawable.avatar_poto_defaul140_1);
        bVar.c.setDrawBorder(true);
        bVar.c.setRadius(com.baidu.adp.lib.h.g.a((Context) this.f1833a.i(), 5.0f));
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                bVar.c.setTag(portrait);
            }
            bVar.f1834a.setOnClickListener(this.f1833a);
            bVar.f1834a.setTag(groupInfoData);
            bVar.d.setText(groupInfoData.getName());
            bVar.e.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            bVar.f.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                bVar.h.setVisibility(0);
            } else {
                bVar.h.setVisibility(8);
            }
            a(bVar.l, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.f1833a.i()).a().a(TiebaApplication.h().an() == 1);
        ((BaseFragmentActivity) this.f1833a.i()).a().a(view);
        return view;
    }

    private void a(ImageView[] imageViewArr, int i) {
        int i2 = i < 0 ? 0 : i;
        if (i2 > 3) {
            i2 = 3;
        }
        for (int i3 = 1; i3 <= 3; i3++) {
            if (i3 <= i2) {
                imageViewArr[i3].setVisibility(0);
            } else {
                imageViewArr[i3].setVisibility(8);
            }
        }
    }
}
