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
public class y extends BaseAdapter {
    private aa a;
    private List<GroupInfoData> b = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.b = list;
    }

    public y(aa aaVar) {
        this.a = aaVar;
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
        z zVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof z)) {
            view = com.baidu.adp.lib.e.b.a().a(this.a.getActivity(), com.baidu.tieba.v.tab_my_group_item, viewGroup, false);
            z zVar2 = new z();
            zVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.u.click_head);
            zVar2.g = (ImageView) view.findViewById(com.baidu.tieba.u.diver_top);
            zVar2.h = (ImageView) view.findViewById(com.baidu.tieba.u.diver_buttom_px);
            zVar2.i = (ImageView) view.findViewById(com.baidu.tieba.u.diver_top_px);
            zVar2.b = (GroupImageView) view.findViewById(com.baidu.tieba.u.item_head);
            zVar2.c = (TextView) view.findViewById(com.baidu.tieba.u.item_group_name);
            zVar2.d = (TextView) view.findViewById(com.baidu.tieba.u.item_group_num);
            zVar2.e = (TextView) view.findViewById(com.baidu.tieba.u.item_introduce);
            zVar2.f = (TextView) view.findViewById(com.baidu.tieba.u.isCreator);
            zVar2.j = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade1);
            zVar2.k = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade2);
            zVar2.l = (ImageView) view.findViewById(com.baidu.tieba.u.item_grade3);
            zVar2.m = new ImageView[4];
            zVar2.m[1] = zVar2.j;
            zVar2.m[2] = zVar2.k;
            zVar2.m[3] = zVar2.l;
            view.setTag(zVar2);
            zVar = zVar2;
        } else {
            zVar = (z) view.getTag();
        }
        GroupInfoData groupInfoData = this.b.get(i);
        zVar.b.setTag(null);
        zVar.b.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                zVar.b.a(portrait, 10, false);
            } else {
                zVar.b.a("", 10, false);
            }
            zVar.a.setOnClickListener(this.a);
            zVar.a.setTag(groupInfoData);
            zVar.g.setVisibility(8);
            zVar.i.setVisibility(8);
            zVar.h.setVisibility(0);
            zVar.c.setText(groupInfoData.getName());
            zVar.d.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            zVar.e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                zVar.f.setVisibility(0);
            } else {
                zVar.f.setVisibility(8);
            }
            a(zVar.m, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.a.getActivity()).c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.a.getActivity()).c().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ay.a(zVar.c, com.baidu.tieba.r.im_group_vip_text, 1);
            ay.c(zVar.j, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(zVar.k, com.baidu.tieba.t.icon_vip_grade_big_small_s);
            ay.c(zVar.l, com.baidu.tieba.t.icon_vip_grade_big_small_s);
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
