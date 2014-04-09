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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class a extends BaseAdapter {
    private MyGroupFragment a;
    private ab b;
    private List<GroupInfoData> c = new ArrayList();

    public final void a(List<GroupInfoData> list) {
        this.c = list;
    }

    public final ab a() {
        return this.b;
    }

    public a(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
        this.b = new ab(myGroupFragment.getActivity());
        this.b.a(true);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.c.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public final GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.c.size()) {
            return null;
        }
        return this.c.get(itemId);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(com.baidu.tieba.im.i.im_group_list_item, viewGroup, false);
            b bVar2 = new b();
            bVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.im.h.click_head);
            bVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.im.h.list_item_content);
            bVar2.c = (HeadImageView) view.findViewById(com.baidu.tieba.im.h.item_head);
            bVar2.d = (TextView) view.findViewById(com.baidu.tieba.im.h.item_group_name);
            bVar2.e = (TextView) view.findViewById(com.baidu.tieba.im.h.item_group_num);
            bVar2.f = (TextView) view.findViewById(com.baidu.tieba.im.h.item_introduce);
            bVar2.g = (TextView) view.findViewById(com.baidu.tieba.im.h.list_more_title);
            bVar2.h = (TextView) view.findViewById(com.baidu.tieba.im.h.isCreator);
            bVar2.i = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade1);
            bVar2.j = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade2);
            bVar2.k = (ImageView) view.findViewById(com.baidu.tieba.im.h.item_grade3);
            bVar2.l = new ImageView[4];
            bVar2.l[1] = bVar2.i;
            bVar2.l[2] = bVar2.j;
            bVar2.l[3] = bVar2.k;
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        GroupInfoData groupInfoData = this.c.get(i);
        bVar.c.setTag(null);
        bVar.c.setDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140);
        bVar.c.setNightDefaultResource(com.baidu.tieba.im.g.avatar_poto_defaul140_1);
        bVar.c.setDrawBorder(true);
        bVar.c.setRadius(com.baidu.adp.lib.util.i.a((Context) this.a.getActivity(), 3.0f));
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                bVar.c.setTag(portrait);
            }
            bVar.a.setOnClickListener(this.a);
            bVar.a.setTag(groupInfoData);
            bVar.d.setText(groupInfoData.getName());
            bVar.e.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            bVar.f.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                bVar.h.setVisibility(0);
            } else {
                bVar.h.setVisibility(8);
            }
            a(bVar.l, groupInfoData.getGrade());
        }
        ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(TbadkApplication.j().l() == 1);
        ((com.baidu.tbadk.core.e) this.a.getActivity()).b().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ba.a(bVar.d, com.baidu.tieba.im.e.im_group_vip_text, 1);
            ba.c(bVar.i, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
            ba.c(bVar.j, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
            ba.c(bVar.k, com.baidu.tieba.im.g.icon_vip_grade_big_small_s);
        }
        return view;
    }

    private static void a(ImageView[] imageViewArr, int i) {
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
