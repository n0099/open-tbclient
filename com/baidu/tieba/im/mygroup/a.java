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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment eOZ;
    private List<GroupInfoData> ePa = new ArrayList();

    public void cK(List<GroupInfoData> list) {
        this.ePa = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eOZ = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ePa.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pD */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.ePa.size()) {
            return null;
        }
        return this.ePa.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0214a c0214a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0214a)) {
            view = LayoutInflater.from(this.eOZ.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0214a = new C0214a();
            c0214a.ePb = (LinearLayout) view.findViewById(e.g.click_head);
            c0214a.ePd = (ImageView) view.findViewById(e.g.diver_top);
            c0214a.ePe = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0214a.ePf = (ImageView) view.findViewById(e.g.diver_top_px);
            c0214a.eHj = (GroupImageView) view.findViewById(e.g.item_head);
            c0214a.eHk = (TextView) view.findViewById(e.g.item_group_name);
            c0214a.eHm = (TextView) view.findViewById(e.g.item_group_num);
            c0214a.eHn = (TextView) view.findViewById(e.g.item_introduce);
            c0214a.ePc = (TextView) view.findViewById(e.g.isCreator);
            c0214a.eHo = (ImageView) view.findViewById(e.g.item_grade1);
            c0214a.eHp = (ImageView) view.findViewById(e.g.item_grade2);
            c0214a.eHq = (ImageView) view.findViewById(e.g.item_grade3);
            c0214a.eHr = new ImageView[4];
            c0214a.eHr[1] = c0214a.eHo;
            c0214a.eHr[2] = c0214a.eHp;
            c0214a.eHr[3] = c0214a.eHq;
            view.setTag(c0214a);
        } else {
            c0214a = (C0214a) view.getTag();
        }
        GroupInfoData groupInfoData = this.ePa.get(i);
        c0214a.eHj.setTag(null);
        c0214a.eHj.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0214a.eHj.startLoad(portrait, 10, false);
            } else {
                c0214a.eHj.startLoad("", 10, false);
            }
            c0214a.ePb.setOnClickListener(this.eOZ);
            c0214a.ePb.setTag(groupInfoData);
            c0214a.ePd.setVisibility(8);
            c0214a.ePf.setVisibility(8);
            c0214a.ePe.setVisibility(0);
            c0214a.eHk.setText(groupInfoData.getName());
            c0214a.eHm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0214a.eHn.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0214a.ePc.setVisibility(0);
            } else {
                c0214a.ePc.setVisibility(8);
            }
            a(c0214a.eHr, groupInfoData.getGrade());
        }
        this.eOZ.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eOZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0214a.eHk, e.d.common_color_10009, 1);
            al.c(c0214a.eHo, e.f.icon_vip_grade_big_small_s);
            al.c(c0214a.eHp, e.f.icon_vip_grade_big_small_s);
            al.c(c0214a.eHq, e.f.icon_vip_grade_big_small_s);
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

    /* renamed from: com.baidu.tieba.im.mygroup.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static class C0214a {
        GroupImageView eHj;
        TextView eHk;
        TextView eHm;
        TextView eHn;
        ImageView eHo;
        ImageView eHp;
        ImageView eHq;
        ImageView[] eHr;
        LinearLayout ePb;
        TextView ePc;
        ImageView ePd;
        ImageView ePe;
        ImageView ePf;

        C0214a() {
        }
    }
}
