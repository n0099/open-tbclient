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
import com.baidu.tbadk.core.util.bk;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class u extends BaseAdapter {
    private w a;
    private List<GroupInfoData> b = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.b = list;
    }

    public u(w wVar) {
        this.a = wVar;
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
        v vVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof v)) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(com.baidu.tieba.w.tab_my_group_item, viewGroup, false);
            v vVar2 = new v();
            vVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.v.click_head);
            vVar2.g = (ImageView) view.findViewById(com.baidu.tieba.v.diver_top);
            vVar2.h = (ImageView) view.findViewById(com.baidu.tieba.v.diver_buttom_px);
            vVar2.i = (ImageView) view.findViewById(com.baidu.tieba.v.diver_top_px);
            vVar2.b = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            vVar2.c = (TextView) view.findViewById(com.baidu.tieba.v.item_group_name);
            vVar2.d = (TextView) view.findViewById(com.baidu.tieba.v.item_group_num);
            vVar2.e = (TextView) view.findViewById(com.baidu.tieba.v.item_introduce);
            vVar2.f = (TextView) view.findViewById(com.baidu.tieba.v.isCreator);
            vVar2.j = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade1);
            vVar2.k = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade2);
            vVar2.l = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade3);
            vVar2.m = new ImageView[4];
            vVar2.m[1] = vVar2.j;
            vVar2.m[2] = vVar2.k;
            vVar2.m[3] = vVar2.l;
            view.setTag(vVar2);
            vVar = vVar2;
        } else {
            vVar = (v) view.getTag();
        }
        GroupInfoData groupInfoData = this.b.get(i);
        vVar.b.setTag(null);
        vVar.b.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
        vVar.b.setNightDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140_1);
        vVar.b.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                vVar.b.a(portrait, 10, false);
            } else {
                vVar.b.a("", 10, false);
            }
            vVar.a.setOnClickListener(this.a);
            vVar.a.setTag(groupInfoData);
            vVar.g.setVisibility(8);
            vVar.i.setVisibility(8);
            vVar.h.setVisibility(0);
            vVar.c.setText(groupInfoData.getName());
            vVar.d.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            vVar.e.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                vVar.f.setVisibility(0);
            } else {
                vVar.f.setVisibility(8);
            }
            a(vVar.m, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.a.getActivity()).c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.a.getActivity()).c().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            bk.a(vVar.c, com.baidu.tieba.s.im_group_vip_text, 1);
            bk.c(vVar.j, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            bk.c(vVar.k, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            bk.c(vVar.l, com.baidu.tieba.u.icon_vip_grade_big_small_s);
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
