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
    private m blM;
    private List<GroupInfoData> blN = new ArrayList();

    public void aJ(List<GroupInfoData> list) {
        this.blN = list;
    }

    public k(m mVar) {
        this.blM = mVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.blN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gl */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.blN.size()) {
            return null;
        }
        return this.blN.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.hH().a(this.blM.getActivity(), w.tab_my_group_item, viewGroup, false);
            lVar = new l();
            lVar.blO = (LinearLayout) view.findViewById(v.click_head);
            lVar.blQ = (ImageView) view.findViewById(v.diver_top);
            lVar.blR = (ImageView) view.findViewById(v.diver_buttom_px);
            lVar.blS = (ImageView) view.findViewById(v.diver_top_px);
            lVar.bdR = (GroupImageView) view.findViewById(v.item_head);
            lVar.nameText = (TextView) view.findViewById(v.item_group_name);
            lVar.bdT = (TextView) view.findViewById(v.item_group_num);
            lVar.bdU = (TextView) view.findViewById(v.item_introduce);
            lVar.blP = (TextView) view.findViewById(v.isCreator);
            lVar.bdV = (ImageView) view.findViewById(v.item_grade1);
            lVar.bdW = (ImageView) view.findViewById(v.item_grade2);
            lVar.bdX = (ImageView) view.findViewById(v.item_grade3);
            lVar.bdY = new ImageView[4];
            lVar.bdY[1] = lVar.bdV;
            lVar.bdY[2] = lVar.bdW;
            lVar.bdY[3] = lVar.bdX;
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        GroupInfoData groupInfoData = this.blN.get(i);
        lVar.bdR.setTag(null);
        lVar.bdR.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                lVar.bdR.c(portrait, 10, false);
            } else {
                lVar.bdR.c("", 10, false);
            }
            lVar.blO.setOnClickListener(this.blM);
            lVar.blO.setTag(groupInfoData);
            lVar.blQ.setVisibility(8);
            lVar.blS.setVisibility(8);
            lVar.blR.setVisibility(0);
            lVar.nameText.setText(groupInfoData.getName());
            lVar.bdT.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            lVar.bdU.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                lVar.blP.setVisibility(0);
            } else {
                lVar.blP.setVisibility(8);
            }
            a(lVar.bdY, groupInfoData.getGrade());
        }
        this.blM.getBaseFragmentActivity().getLayoutMode().X(TbadkApplication.getInst().getSkinType() == 1);
        this.blM.getBaseFragmentActivity().getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ba.b(lVar.nameText, com.baidu.tieba.s.im_group_vip_text, 1);
            ba.c(lVar.bdV, u.icon_vip_grade_big_small_s);
            ba.c(lVar.bdW, u.icon_vip_grade_big_small_s);
            ba.c(lVar.bdX, u.icon_vip_grade_big_small_s);
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
