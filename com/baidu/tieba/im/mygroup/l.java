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
    private n bfX;
    private List<GroupInfoData> bfY = new ArrayList();

    public void aa(List<GroupInfoData> list) {
        this.bfY = list;
    }

    public l(n nVar) {
        this.bfX = nVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bfY.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gg */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.bfY.size()) {
            return null;
        }
        return this.bfY.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof m)) {
            view = com.baidu.adp.lib.g.b.ek().a(this.bfX.getActivity(), w.tab_my_group_item, viewGroup, false);
            m mVar2 = new m();
            mVar2.bfZ = (LinearLayout) view.findViewById(v.click_head);
            mVar2.bgb = (ImageView) view.findViewById(v.diver_top);
            mVar2.bgc = (ImageView) view.findViewById(v.diver_buttom_px);
            mVar2.bgd = (ImageView) view.findViewById(v.diver_top_px);
            mVar2.aWH = (GroupImageView) view.findViewById(v.item_head);
            mVar2.aWI = (TextView) view.findViewById(v.item_group_name);
            mVar2.aWK = (TextView) view.findViewById(v.item_group_num);
            mVar2.aWL = (TextView) view.findViewById(v.item_introduce);
            mVar2.bga = (TextView) view.findViewById(v.isCreator);
            mVar2.aWM = (ImageView) view.findViewById(v.item_grade1);
            mVar2.aWN = (ImageView) view.findViewById(v.item_grade2);
            mVar2.aWO = (ImageView) view.findViewById(v.item_grade3);
            mVar2.aWP = new ImageView[4];
            mVar2.aWP[1] = mVar2.aWM;
            mVar2.aWP[2] = mVar2.aWN;
            mVar2.aWP[3] = mVar2.aWO;
            view.setTag(mVar2);
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        GroupInfoData groupInfoData = this.bfY.get(i);
        mVar.aWH.setTag(null);
        mVar.aWH.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                mVar.aWH.c(portrait, 10, false);
            } else {
                mVar.aWH.c("", 10, false);
            }
            mVar.bfZ.setOnClickListener(this.bfX);
            mVar.bfZ.setTag(groupInfoData);
            mVar.bgb.setVisibility(8);
            mVar.bgd.setVisibility(8);
            mVar.bgc.setVisibility(0);
            mVar.aWI.setText(groupInfoData.getName());
            mVar.aWK.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            mVar.aWL.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                mVar.bga.setVisibility(0);
            } else {
                mVar.bga.setVisibility(8);
            }
            a(mVar.aWP, groupInfoData.getGrade());
        }
        ((BaseFragmentActivity) this.bfX.getActivity()).getLayoutMode().L(TbadkApplication.m251getInst().getSkinType() == 1);
        ((BaseFragmentActivity) this.bfX.getActivity()).getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            aw.b(mVar.aWI, com.baidu.tieba.s.im_group_vip_text, 1);
            aw.c(mVar.aWM, u.icon_vip_grade_big_small_s);
            aw.c(mVar.aWN, u.icon_vip_grade_big_small_s);
            aw.c(mVar.aWO, u.icon_vip_grade_big_small_s);
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
