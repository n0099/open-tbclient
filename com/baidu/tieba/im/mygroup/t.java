package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import android.view.LayoutInflater;
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
public class t extends BaseAdapter {
    private v a;
    private List<GroupInfoData> b = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.b = list;
    }

    public t(v vVar) {
        this.a = vVar;
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
        u uVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof u)) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(com.baidu.tieba.v.tab_my_group_item, viewGroup, false);
            u uVar2 = new u();
            uVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.click_head);
            uVar2.g = (ImageView) view.findViewById(com.baidu.tieba.u.diver_top);
            uVar2.h = (ImageView) view.findViewById(com.baidu.tieba.u.diver_buttom_px);
            uVar2.i = (ImageView) view.findViewById(com.baidu.tieba.u.diver_top_px);
            uVar2.b = (GroupImageView) view.findViewById(com.baidu.tieba.u.item_head);
            uVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.item_group_name);
            uVar2.d = (TextView) view.findViewById(com.baidu.tieba.u.item_group_num);
            uVar2.e = (TextView) view.findViewById(com.baidu.tieba.u.item_introduce);
            uVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.isCreator);
            uVar2.j = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade1);
            uVar2.k = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade2);
            uVar2.l = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade3);
            uVar2.m = new ImageView[4];
            uVar2.m[1] = uVar2.j;
            uVar2.m[2] = uVar2.k;
            uVar2.m[3] = uVar2.l;
            view.setTag(uVar2);
            uVar = uVar2;
        } else {
            uVar = (u) view.getTag();
        }
        GroupInfoData groupInfoData = this.b.get(i);
        uVar.b.setTag(null);
        uVar.b.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                uVar.b.a(portrait, 10, false);
            } else {
                uVar.b.a("", 10, false);
            }
            uVar.a.setOnClickListener(this.a);
            uVar.a.setTag(groupInfoData);
            uVar.g.setVisibility(8);
            uVar.i.setVisibility(8);
            uVar.h.setVisibility(0);
            uVar.c.setText(groupInfoData.getName());
            uVar.d.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            uVar.e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                uVar.f.setVisibility(0);
            } else {
                uVar.f.setVisibility(8);
            }
            a(uVar.m, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.a.getActivity()).c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.a.getActivity()).c().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ay.a(uVar.c, com.baidu.tieba.r.im_group_vip_text, 1);
            ay.c(uVar.j, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(uVar.k, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(uVar.l, com.baidu.tieba.t.icon_vip_grade_big_small_s);
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
