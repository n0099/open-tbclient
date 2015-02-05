package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class k extends BaseAdapter {
    private m bkH;
    private List<GroupInfoData> bkI = new ArrayList();

    public void aA(List<GroupInfoData> list) {
        this.bkI = list;
    }

    public k(m mVar) {
        this.bkH = mVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bkI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gy */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.bkI.size()) {
            return null;
        }
        return this.bkI.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.ei().a(this.bkH.getActivity(), x.tab_my_group_item, viewGroup, false);
            lVar = new l();
            lVar.bkJ = (LinearLayout) view.findViewById(w.click_head);
            lVar.bkL = (ImageView) view.findViewById(w.diver_top);
            lVar.bkM = (ImageView) view.findViewById(w.diver_buttom_px);
            lVar.bkN = (ImageView) view.findViewById(w.diver_top_px);
            lVar.bcr = (GroupImageView) view.findViewById(w.item_head);
            lVar.nameText = (TextView) view.findViewById(w.item_group_name);
            lVar.bct = (TextView) view.findViewById(w.item_group_num);
            lVar.bcu = (TextView) view.findViewById(w.item_introduce);
            lVar.bkK = (TextView) view.findViewById(w.isCreator);
            lVar.bcv = (ImageView) view.findViewById(w.item_grade1);
            lVar.bcw = (ImageView) view.findViewById(w.item_grade2);
            lVar.bcx = (ImageView) view.findViewById(w.item_grade3);
            lVar.bcy = new ImageView[4];
            lVar.bcy[1] = lVar.bcv;
            lVar.bcy[2] = lVar.bcw;
            lVar.bcy[3] = lVar.bcx;
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        GroupInfoData groupInfoData = this.bkI.get(i);
        lVar.bcr.setTag(null);
        lVar.bcr.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                lVar.bcr.d(portrait, 10, false);
            } else {
                lVar.bcr.d("", 10, false);
            }
            lVar.bkJ.setOnClickListener(this.bkH);
            lVar.bkJ.setTag(groupInfoData);
            lVar.bkL.setVisibility(8);
            lVar.bkN.setVisibility(8);
            lVar.bkM.setVisibility(0);
            lVar.nameText.setText(groupInfoData.getName());
            lVar.bct.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            lVar.bcu.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                lVar.bkK.setVisibility(0);
            } else {
                lVar.bkK.setVisibility(8);
            }
            a(lVar.bcy, groupInfoData.getGrade());
        }
        this.bkH.getBaseFragmentActivity().getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
        this.bkH.getBaseFragmentActivity().getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            bc.b(lVar.nameText, t.im_group_vip_text, 1);
            bc.c(lVar.bcv, v.icon_vip_grade_big_small_s);
            bc.c(lVar.bcw, v.icon_vip_grade_big_small_s);
            bc.c(lVar.bcx, v.icon_vip_grade_big_small_s);
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
