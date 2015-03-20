package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private m blw;
    private List<GroupInfoData> blx = new ArrayList();

    public void aH(List<GroupInfoData> list) {
        this.blx = list;
    }

    public k(m mVar) {
        this.blw = mVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.blx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gj */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.blx.size()) {
            return null;
        }
        return this.blx.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.hH().a(this.blw.getActivity(), w.tab_my_group_item, viewGroup, false);
            lVar = new l();
            lVar.bly = (LinearLayout) view.findViewById(v.click_head);
            lVar.blA = (ImageView) view.findViewById(v.diver_top);
            lVar.blB = (ImageView) view.findViewById(v.diver_buttom_px);
            lVar.blC = (ImageView) view.findViewById(v.diver_top_px);
            lVar.bdB = (GroupImageView) view.findViewById(v.item_head);
            lVar.nameText = (TextView) view.findViewById(v.item_group_name);
            lVar.bdD = (TextView) view.findViewById(v.item_group_num);
            lVar.bdE = (TextView) view.findViewById(v.item_introduce);
            lVar.blz = (TextView) view.findViewById(v.isCreator);
            lVar.bdF = (ImageView) view.findViewById(v.item_grade1);
            lVar.bdG = (ImageView) view.findViewById(v.item_grade2);
            lVar.bdH = (ImageView) view.findViewById(v.item_grade3);
            lVar.bdI = new ImageView[4];
            lVar.bdI[1] = lVar.bdF;
            lVar.bdI[2] = lVar.bdG;
            lVar.bdI[3] = lVar.bdH;
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        GroupInfoData groupInfoData = this.blx.get(i);
        lVar.bdB.setTag(null);
        lVar.bdB.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                lVar.bdB.c(portrait, 10, false);
            } else {
                lVar.bdB.c("", 10, false);
            }
            lVar.bly.setOnClickListener(this.blw);
            lVar.bly.setTag(groupInfoData);
            lVar.blA.setVisibility(8);
            lVar.blC.setVisibility(8);
            lVar.blB.setVisibility(0);
            lVar.nameText.setText(groupInfoData.getName());
            lVar.bdD.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            lVar.bdE.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                lVar.blz.setVisibility(0);
            } else {
                lVar.blz.setVisibility(8);
            }
            a(lVar.bdI, groupInfoData.getGrade());
        }
        this.blw.getBaseFragmentActivity().getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
        this.blw.getBaseFragmentActivity().getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ba.b(lVar.nameText, com.baidu.tieba.s.im_group_vip_text, 1);
            ba.c(lVar.bdF, u.icon_vip_grade_big_small_s);
            ba.c(lVar.bdG, u.icon_vip_grade_big_small_s);
            ba.c(lVar.bdH, u.icon_vip_grade_big_small_s);
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
