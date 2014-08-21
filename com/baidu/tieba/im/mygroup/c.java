package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c extends BaseAdapter {
    private MyGroupFragment a;
    private List<GroupInfoData> b = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.b = list;
    }

    public c(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.b.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.b.size()) {
            return null;
        }
        return this.b.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof d)) {
            view = com.baidu.adp.lib.e.b.a().a(this.a.getActivity(), com.baidu.tieba.v.im_group_list_item, viewGroup, false);
            d dVar2 = new d();
            dVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.click_head);
            dVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.u.list_item_content);
            dVar2.c = (GroupImageView) view.findViewById(com.baidu.tieba.u.item_head);
            dVar2.d = (TextView) view.findViewById(com.baidu.tieba.u.item_group_name);
            dVar2.e = (TextView) view.findViewById(com.baidu.tieba.u.item_group_num);
            dVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.item_introduce);
            dVar2.g = (TextView) view.findViewById(com.baidu.tieba.u.list_more_title);
            dVar2.h = (TextView) view.findViewById(com.baidu.tieba.u.isCreator);
            dVar2.i = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade1);
            dVar2.j = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade2);
            dVar2.k = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade3);
            dVar2.l = new ImageView[4];
            dVar2.l[1] = dVar2.i;
            dVar2.l[2] = dVar2.j;
            dVar2.l[3] = dVar2.k;
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        GroupInfoData groupInfoData = this.b.get(i);
        dVar.c.setTag(null);
        dVar.c.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                dVar.c.setTag(portrait);
                dVar.c.a(portrait, 10, false);
            }
            dVar.a.setOnClickListener(this.a);
            dVar.a.setTag(groupInfoData);
            dVar.d.setText(groupInfoData.getName());
            dVar.e.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            dVar.f.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                dVar.h.setVisibility(0);
            } else {
                dVar.h.setVisibility(8);
            }
            a(dVar.l, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.a.getActivity()).c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.a.getActivity()).c().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ay.a(dVar.d, com.baidu.tieba.r.im_group_vip_text, 1);
            ay.c(dVar.i, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(dVar.j, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(dVar.k, com.baidu.tieba.t.icon_vip_grade_big_small_s);
        }
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
