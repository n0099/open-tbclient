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
    private m bkI;
    private List<GroupInfoData> bkJ = new ArrayList();

    public void aA(List<GroupInfoData> list) {
        this.bkJ = list;
    }

    public k(m mVar) {
        this.bkI = mVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bkJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gy */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.bkJ.size()) {
            return null;
        }
        return this.bkJ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.ei().a(this.bkI.getActivity(), x.tab_my_group_item, viewGroup, false);
            lVar = new l();
            lVar.bkK = (LinearLayout) view.findViewById(w.click_head);
            lVar.bkM = (ImageView) view.findViewById(w.diver_top);
            lVar.bkN = (ImageView) view.findViewById(w.diver_buttom_px);
            lVar.bkO = (ImageView) view.findViewById(w.diver_top_px);
            lVar.bcs = (GroupImageView) view.findViewById(w.item_head);
            lVar.nameText = (TextView) view.findViewById(w.item_group_name);
            lVar.bcu = (TextView) view.findViewById(w.item_group_num);
            lVar.bcv = (TextView) view.findViewById(w.item_introduce);
            lVar.bkL = (TextView) view.findViewById(w.isCreator);
            lVar.bcw = (ImageView) view.findViewById(w.item_grade1);
            lVar.bcx = (ImageView) view.findViewById(w.item_grade2);
            lVar.bcy = (ImageView) view.findViewById(w.item_grade3);
            lVar.bcz = new ImageView[4];
            lVar.bcz[1] = lVar.bcw;
            lVar.bcz[2] = lVar.bcx;
            lVar.bcz[3] = lVar.bcy;
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        GroupInfoData groupInfoData = this.bkJ.get(i);
        lVar.bcs.setTag(null);
        lVar.bcs.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                lVar.bcs.d(portrait, 10, false);
            } else {
                lVar.bcs.d("", 10, false);
            }
            lVar.bkK.setOnClickListener(this.bkI);
            lVar.bkK.setTag(groupInfoData);
            lVar.bkM.setVisibility(8);
            lVar.bkO.setVisibility(8);
            lVar.bkN.setVisibility(0);
            lVar.nameText.setText(groupInfoData.getName());
            lVar.bcu.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            lVar.bcv.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                lVar.bkL.setVisibility(0);
            } else {
                lVar.bkL.setVisibility(8);
            }
            a(lVar.bcz, groupInfoData.getGrade());
        }
        this.bkI.getBaseFragmentActivity().getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
        this.bkI.getBaseFragmentActivity().getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            bc.b(lVar.nameText, t.im_group_vip_text, 1);
            bc.c(lVar.bcw, v.icon_vip_grade_big_small_s);
            bc.c(lVar.bcx, v.icon_vip_grade_big_small_s);
            bc.c(lVar.bcy, v.icon_vip_grade_big_small_s);
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
