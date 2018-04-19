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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment efZ;
    private List<GroupInfoData> ega = new ArrayList();

    public void ci(List<GroupInfoData> list) {
        this.ega = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.efZ = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ega.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nV */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.ega.size()) {
            return null;
        }
        return this.ega.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0161a c0161a;
        if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof C0161a)) {
            view2 = LayoutInflater.from(this.efZ.getActivity()).inflate(d.i.tab_my_group_item, viewGroup, false);
            c0161a = new C0161a();
            c0161a.egb = (LinearLayout) view2.findViewById(d.g.click_head);
            c0161a.egd = (ImageView) view2.findViewById(d.g.diver_top);
            c0161a.ege = (ImageView) view2.findViewById(d.g.diver_buttom_px);
            c0161a.egf = (ImageView) view2.findViewById(d.g.diver_top_px);
            c0161a.dYf = (GroupImageView) view2.findViewById(d.g.item_head);
            c0161a.dYg = (TextView) view2.findViewById(d.g.item_group_name);
            c0161a.dYi = (TextView) view2.findViewById(d.g.item_group_num);
            c0161a.dYj = (TextView) view2.findViewById(d.g.item_introduce);
            c0161a.egc = (TextView) view2.findViewById(d.g.isCreator);
            c0161a.dYk = (ImageView) view2.findViewById(d.g.item_grade1);
            c0161a.dYl = (ImageView) view2.findViewById(d.g.item_grade2);
            c0161a.dYm = (ImageView) view2.findViewById(d.g.item_grade3);
            c0161a.dYn = new ImageView[4];
            c0161a.dYn[1] = c0161a.dYk;
            c0161a.dYn[2] = c0161a.dYl;
            c0161a.dYn[3] = c0161a.dYm;
            view2.setTag(c0161a);
        } else {
            c0161a = (C0161a) view2.getTag();
        }
        GroupInfoData groupInfoData = this.ega.get(i);
        c0161a.dYf.setTag(null);
        c0161a.dYf.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0161a.dYf.startLoad(portrait, 10, false);
            } else {
                c0161a.dYf.startLoad("", 10, false);
            }
            c0161a.egb.setOnClickListener(this.efZ);
            c0161a.egb.setTag(groupInfoData);
            c0161a.egd.setVisibility(8);
            c0161a.egf.setVisibility(8);
            c0161a.ege.setVisibility(0);
            c0161a.dYg.setText(groupInfoData.getName());
            c0161a.dYi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0161a.dYj.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0161a.egc.setVisibility(0);
            } else {
                c0161a.egc.setVisibility(8);
            }
            a(c0161a.dYn, groupInfoData.getGrade());
        }
        this.efZ.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.efZ.getBaseFragmentActivity().getLayoutMode().u(view2);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ak.c(c0161a.dYg, d.C0126d.common_color_10009, 1);
            ak.c(c0161a.dYk, d.f.icon_vip_grade_big_small_s);
            ak.c(c0161a.dYl, d.f.icon_vip_grade_big_small_s);
            ak.c(c0161a.dYm, d.f.icon_vip_grade_big_small_s);
        }
        return view2;
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

    /* renamed from: com.baidu.tieba.im.mygroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0161a {
        GroupImageView dYf;
        TextView dYg;
        TextView dYi;
        TextView dYj;
        ImageView dYk;
        ImageView dYl;
        ImageView dYm;
        ImageView[] dYn;
        LinearLayout egb;
        TextView egc;
        ImageView egd;
        ImageView ege;
        ImageView egf;

        C0161a() {
        }
    }
}
