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
    private PersonalGroupFragment eHq;
    private List<GroupInfoData> eHr = new ArrayList();

    public void cv(List<GroupInfoData> list) {
        this.eHr = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eHq = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eHr.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pf */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eHr.size()) {
            return null;
        }
        return this.eHr.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0180a c0180a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0180a)) {
            view = LayoutInflater.from(this.eHq.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0180a = new C0180a();
            c0180a.eHs = (LinearLayout) view.findViewById(e.g.click_head);
            c0180a.eHu = (ImageView) view.findViewById(e.g.diver_top);
            c0180a.eHv = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0180a.eHw = (ImageView) view.findViewById(e.g.diver_top_px);
            c0180a.ezz = (GroupImageView) view.findViewById(e.g.item_head);
            c0180a.ezA = (TextView) view.findViewById(e.g.item_group_name);
            c0180a.ezC = (TextView) view.findViewById(e.g.item_group_num);
            c0180a.ezD = (TextView) view.findViewById(e.g.item_introduce);
            c0180a.eHt = (TextView) view.findViewById(e.g.isCreator);
            c0180a.ezE = (ImageView) view.findViewById(e.g.item_grade1);
            c0180a.ezF = (ImageView) view.findViewById(e.g.item_grade2);
            c0180a.ezG = (ImageView) view.findViewById(e.g.item_grade3);
            c0180a.ezH = new ImageView[4];
            c0180a.ezH[1] = c0180a.ezE;
            c0180a.ezH[2] = c0180a.ezF;
            c0180a.ezH[3] = c0180a.ezG;
            view.setTag(c0180a);
        } else {
            c0180a = (C0180a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eHr.get(i);
        c0180a.ezz.setTag(null);
        c0180a.ezz.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0180a.ezz.startLoad(portrait, 10, false);
            } else {
                c0180a.ezz.startLoad("", 10, false);
            }
            c0180a.eHs.setOnClickListener(this.eHq);
            c0180a.eHs.setTag(groupInfoData);
            c0180a.eHu.setVisibility(8);
            c0180a.eHw.setVisibility(8);
            c0180a.eHv.setVisibility(0);
            c0180a.ezA.setText(groupInfoData.getName());
            c0180a.ezC.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0180a.ezD.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0180a.eHt.setVisibility(0);
            } else {
                c0180a.eHt.setVisibility(8);
            }
            a(c0180a.ezH, groupInfoData.getGrade());
        }
        this.eHq.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eHq.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0180a.ezA, e.d.common_color_10009, 1);
            al.c(c0180a.ezE, e.f.icon_vip_grade_big_small_s);
            al.c(c0180a.ezF, e.f.icon_vip_grade_big_small_s);
            al.c(c0180a.ezG, e.f.icon_vip_grade_big_small_s);
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
    static class C0180a {
        LinearLayout eHs;
        TextView eHt;
        ImageView eHu;
        ImageView eHv;
        ImageView eHw;
        TextView ezA;
        TextView ezC;
        TextView ezD;
        ImageView ezE;
        ImageView ezF;
        ImageView ezG;
        ImageView[] ezH;
        GroupImageView ezz;

        C0180a() {
        }
    }
}
