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
    private PersonalGroupFragment ehd;
    private List<GroupInfoData> ehe = new ArrayList();

    public void cl(List<GroupInfoData> list) {
        this.ehe = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.ehd = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ehe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: nU */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.ehe.size()) {
            return null;
        }
        return this.ehe.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        C0161a c0161a;
        if (view2 == null || view2.getTag() == null || !(view2.getTag() instanceof C0161a)) {
            view2 = LayoutInflater.from(this.ehd.getActivity()).inflate(d.i.tab_my_group_item, viewGroup, false);
            c0161a = new C0161a();
            c0161a.ehf = (LinearLayout) view2.findViewById(d.g.click_head);
            c0161a.ehh = (ImageView) view2.findViewById(d.g.diver_top);
            c0161a.ehi = (ImageView) view2.findViewById(d.g.diver_buttom_px);
            c0161a.ehj = (ImageView) view2.findViewById(d.g.diver_top_px);
            c0161a.dZj = (GroupImageView) view2.findViewById(d.g.item_head);
            c0161a.dZk = (TextView) view2.findViewById(d.g.item_group_name);
            c0161a.dZm = (TextView) view2.findViewById(d.g.item_group_num);
            c0161a.dZn = (TextView) view2.findViewById(d.g.item_introduce);
            c0161a.ehg = (TextView) view2.findViewById(d.g.isCreator);
            c0161a.dZo = (ImageView) view2.findViewById(d.g.item_grade1);
            c0161a.dZp = (ImageView) view2.findViewById(d.g.item_grade2);
            c0161a.dZq = (ImageView) view2.findViewById(d.g.item_grade3);
            c0161a.dZr = new ImageView[4];
            c0161a.dZr[1] = c0161a.dZo;
            c0161a.dZr[2] = c0161a.dZp;
            c0161a.dZr[3] = c0161a.dZq;
            view2.setTag(c0161a);
        } else {
            c0161a = (C0161a) view2.getTag();
        }
        GroupInfoData groupInfoData = this.ehe.get(i);
        c0161a.dZj.setTag(null);
        c0161a.dZj.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0161a.dZj.startLoad(portrait, 10, false);
            } else {
                c0161a.dZj.startLoad("", 10, false);
            }
            c0161a.ehf.setOnClickListener(this.ehd);
            c0161a.ehf.setTag(groupInfoData);
            c0161a.ehh.setVisibility(8);
            c0161a.ehj.setVisibility(8);
            c0161a.ehi.setVisibility(0);
            c0161a.dZk.setText(groupInfoData.getName());
            c0161a.dZm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0161a.dZn.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0161a.ehg.setVisibility(0);
            } else {
                c0161a.ehg.setVisibility(8);
            }
            a(c0161a.dZr, groupInfoData.getGrade());
        }
        this.ehd.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ehd.getBaseFragmentActivity().getLayoutMode().u(view2);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ak.c(c0161a.dZk, d.C0126d.common_color_10009, 1);
            ak.c(c0161a.dZo, d.f.icon_vip_grade_big_small_s);
            ak.c(c0161a.dZp, d.f.icon_vip_grade_big_small_s);
            ak.c(c0161a.dZq, d.f.icon_vip_grade_big_small_s);
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
        GroupImageView dZj;
        TextView dZk;
        TextView dZm;
        TextView dZn;
        ImageView dZo;
        ImageView dZp;
        ImageView dZq;
        ImageView[] dZr;
        LinearLayout ehf;
        TextView ehg;
        ImageView ehh;
        ImageView ehi;
        ImageView ehj;

        C0161a() {
        }
    }
}
