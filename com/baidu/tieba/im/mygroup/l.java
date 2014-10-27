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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class l extends BaseAdapter {
    private n bfJ;
    private List<GroupInfoData> bfK = new ArrayList();

    public void aa(List<GroupInfoData> list) {
        this.bfK = list;
    }

    public l(n nVar) {
        this.bfJ = nVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bfK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gg */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.bfK.size()) {
            return null;
        }
        return this.bfK.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof m)) {
            view = com.baidu.adp.lib.g.b.ek().a(this.bfJ.getActivity(), w.tab_my_group_item, viewGroup, false);
            m mVar2 = new m();
            mVar2.bfL = (LinearLayout) view.findViewById(v.click_head);
            mVar2.bfN = (ImageView) view.findViewById(v.diver_top);
            mVar2.bfO = (ImageView) view.findViewById(v.diver_buttom_px);
            mVar2.bfP = (ImageView) view.findViewById(v.diver_top_px);
            mVar2.aWt = (GroupImageView) view.findViewById(v.item_head);
            mVar2.aWu = (TextView) view.findViewById(v.item_group_name);
            mVar2.aWw = (TextView) view.findViewById(v.item_group_num);
            mVar2.aWx = (TextView) view.findViewById(v.item_introduce);
            mVar2.bfM = (TextView) view.findViewById(v.isCreator);
            mVar2.aWy = (ImageView) view.findViewById(v.item_grade1);
            mVar2.aWz = (ImageView) view.findViewById(v.item_grade2);
            mVar2.aWA = (ImageView) view.findViewById(v.item_grade3);
            mVar2.aWB = new ImageView[4];
            mVar2.aWB[1] = mVar2.aWy;
            mVar2.aWB[2] = mVar2.aWz;
            mVar2.aWB[3] = mVar2.aWA;
            view.setTag(mVar2);
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        GroupInfoData groupInfoData = this.bfK.get(i);
        mVar.aWt.setTag(null);
        mVar.aWt.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                mVar.aWt.c(portrait, 10, false);
            } else {
                mVar.aWt.c("", 10, false);
            }
            mVar.bfL.setOnClickListener(this.bfJ);
            mVar.bfL.setTag(groupInfoData);
            mVar.bfN.setVisibility(8);
            mVar.bfP.setVisibility(8);
            mVar.bfO.setVisibility(0);
            mVar.aWu.setText(groupInfoData.getName());
            mVar.aWw.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            mVar.aWx.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                mVar.bfM.setVisibility(0);
            } else {
                mVar.bfM.setVisibility(8);
            }
            a(mVar.aWB, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.bfJ.getActivity()).getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.bfJ.getActivity()).getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            aw.b(mVar.aWu, com.baidu.tieba.s.im_group_vip_text, 1);
            aw.c(mVar.aWy, u.icon_vip_grade_big_small_s);
            aw.c(mVar.aWz, u.icon_vip_grade_big_small_s);
            aw.c(mVar.aWA, u.icon_vip_grade_big_small_s);
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
