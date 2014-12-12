package com.baidu.tieba.im.mygroup;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ax;
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
    private m bjl;
    private List<GroupInfoData> bjm = new ArrayList();

    public void ax(List<GroupInfoData> list) {
        this.bjm = list;
    }

    public k(m mVar) {
        this.bjl = mVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.bjm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: gp */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.bjm.size()) {
            return null;
        }
        return this.bjm.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        l lVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof l)) {
            view = com.baidu.adp.lib.g.b.ek().a(this.bjl.getActivity(), x.tab_my_group_item, viewGroup, false);
            lVar = new l();
            lVar.bjn = (LinearLayout) view.findViewById(w.click_head);
            lVar.bjp = (ImageView) view.findViewById(w.diver_top);
            lVar.bjq = (ImageView) view.findViewById(w.diver_buttom_px);
            lVar.bjr = (ImageView) view.findViewById(w.diver_top_px);
            lVar.baX = (GroupImageView) view.findViewById(w.item_head);
            lVar.nameText = (TextView) view.findViewById(w.item_group_name);
            lVar.baZ = (TextView) view.findViewById(w.item_group_num);
            lVar.bba = (TextView) view.findViewById(w.item_introduce);
            lVar.bjo = (TextView) view.findViewById(w.isCreator);
            lVar.bbb = (ImageView) view.findViewById(w.item_grade1);
            lVar.bbc = (ImageView) view.findViewById(w.item_grade2);
            lVar.bbd = (ImageView) view.findViewById(w.item_grade3);
            lVar.bbe = new ImageView[4];
            lVar.bbe[1] = lVar.bbb;
            lVar.bbe[2] = lVar.bbc;
            lVar.bbe[3] = lVar.bbd;
            view.setTag(lVar);
        } else {
            lVar = (l) view.getTag();
        }
        GroupInfoData groupInfoData = this.bjm.get(i);
        lVar.baX.setTag(null);
        lVar.baX.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                lVar.baX.d(portrait, 10, false);
            } else {
                lVar.baX.d("", 10, false);
            }
            lVar.bjn.setOnClickListener(this.bjl);
            lVar.bjn.setTag(groupInfoData);
            lVar.bjp.setVisibility(8);
            lVar.bjr.setVisibility(8);
            lVar.bjq.setVisibility(0);
            lVar.nameText.setText(groupInfoData.getName());
            lVar.baZ.setText(String.valueOf(groupInfoData.getMemberNum()) + "/" + groupInfoData.getMaxMemberNum());
            lVar.bba.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                lVar.bjo.setVisibility(0);
            } else {
                lVar.bjo.setVisibility(8);
            }
            a(lVar.bbe, groupInfoData.getGrade());
        }
        this.bjl.getBaseFragmentActivity().getLayoutMode().ab(TbadkApplication.getInst().getSkinType() == 1);
        this.bjl.getBaseFragmentActivity().getLayoutMode().h(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ax.b(lVar.nameText, t.im_group_vip_text, 1);
            ax.c(lVar.bbb, v.icon_vip_grade_big_small_s);
            ax.c(lVar.bbc, v.icon_vip_grade_big_small_s);
            ax.c(lVar.bbd, v.icon_vip_grade_big_small_s);
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
