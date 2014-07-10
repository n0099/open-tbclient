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
public class b extends BaseAdapter {
    private MyGroupFragment a;
    private com.baidu.tbadk.editortool.aa b;
    private List<GroupInfoData> c = new ArrayList();

    public void a(List<GroupInfoData> list) {
        this.c = list;
    }

    public com.baidu.tbadk.editortool.aa a() {
        return this.b;
    }

    public b(MyGroupFragment myGroupFragment) {
        this.a = myGroupFragment;
        this.b = new com.baidu.tbadk.editortool.aa(myGroupFragment.getActivity());
        this.b.b(true);
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
        c cVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof c)) {
            view = LayoutInflater.from(this.a.getActivity()).inflate(com.baidu.tieba.w.im_group_list_item, viewGroup, false);
            c cVar2 = new c();
            cVar2.a = (LinearLayout) view.findViewById(com.baidu.tieba.v.click_head);
            cVar2.b = (LinearLayout) view.findViewById(com.baidu.tieba.v.list_item_content);
            cVar2.c = (HeadImageView) view.findViewById(com.baidu.tieba.v.item_head);
            cVar2.d = (TextView) view.findViewById(com.baidu.tieba.v.item_group_name);
            cVar2.e = (TextView) view.findViewById(com.baidu.tieba.v.item_group_num);
            cVar2.f = (TextView) view.findViewById(com.baidu.tieba.v.item_introduce);
            cVar2.g = (TextView) view.findViewById(com.baidu.tieba.v.list_more_title);
            cVar2.h = (TextView) view.findViewById(com.baidu.tieba.v.isCreator);
            cVar2.i = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade1);
            cVar2.j = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade2);
            cVar2.k = (ImageView) view.findViewById(com.baidu.tieba.v.item_grade3);
            cVar2.l = new ImageView[4];
            cVar2.l[1] = cVar2.i;
            cVar2.l[2] = cVar2.j;
            cVar2.l[3] = cVar2.k;
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        GroupInfoData groupInfoData = this.c.get(i);
        cVar.c.setTag(null);
        cVar.c.setDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140);
        cVar.c.setNightDefaultResource(com.baidu.tieba.u.avatar_poto_defaul140_1);
        cVar.c.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                cVar.c.setTag(portrait);
            }
            cVar.a.setOnClickListener(this.a);
            cVar.a.setTag(groupInfoData);
            cVar.d.setText(groupInfoData.getName());
            cVar.e.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            cVar.f.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                cVar.h.setVisibility(0);
            } else {
                cVar.h.setVisibility(8);
            }
            a(cVar.l, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.a.getActivity()).c().a(TbadkApplication.m252getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.a.getActivity()).c().a(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            bk.a(cVar.d, com.baidu.tieba.s.im_group_vip_text, 1);
            bk.c(cVar.i, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            bk.c(cVar.j, com.baidu.tieba.u.icon_vip_grade_big_small_s);
            bk.c(cVar.k, com.baidu.tieba.u.icon_vip_grade_big_small_s);
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
