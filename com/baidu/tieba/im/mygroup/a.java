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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment hHK;
    private List<GroupInfoData> hHL = new ArrayList();

    public void de(List<GroupInfoData> list) {
        this.hHL = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hHK = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hHL.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wQ */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hHL.size()) {
            return null;
        }
        return this.hHL.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0534a c0534a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0534a)) {
            view = LayoutInflater.from(this.hHK.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0534a = new C0534a();
            c0534a.hHM = (LinearLayout) view.findViewById(R.id.click_head);
            c0534a.hHO = (ImageView) view.findViewById(R.id.diver_top);
            c0534a.hHP = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0534a.hHQ = (ImageView) view.findViewById(R.id.diver_top_px);
            c0534a.hzQ = (GroupImageView) view.findViewById(R.id.item_head);
            c0534a.hzR = (TextView) view.findViewById(R.id.item_group_name);
            c0534a.hzT = (TextView) view.findViewById(R.id.item_group_num);
            c0534a.hzU = (TextView) view.findViewById(R.id.item_introduce);
            c0534a.hHN = (TextView) view.findViewById(R.id.isCreator);
            c0534a.hzV = (ImageView) view.findViewById(R.id.item_grade1);
            c0534a.hzW = (ImageView) view.findViewById(R.id.item_grade2);
            c0534a.hzX = (ImageView) view.findViewById(R.id.item_grade3);
            c0534a.hzY = new ImageView[4];
            c0534a.hzY[1] = c0534a.hzV;
            c0534a.hzY[2] = c0534a.hzW;
            c0534a.hzY[3] = c0534a.hzX;
            view.setTag(c0534a);
        } else {
            c0534a = (C0534a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hHL.get(i);
        c0534a.hzQ.setTag(null);
        c0534a.hzQ.setDrawBorder(true);
        c0534a.hzQ.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0534a.hzQ.startLoad(portrait, 10, false);
            } else {
                c0534a.hzQ.startLoad("", 10, false);
            }
            c0534a.hHM.setOnClickListener(this.hHK);
            c0534a.hHM.setTag(groupInfoData);
            c0534a.hHO.setVisibility(8);
            c0534a.hHQ.setVisibility(8);
            c0534a.hHP.setVisibility(0);
            c0534a.hzR.setText(groupInfoData.getName());
            c0534a.hzT.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0534a.hzU.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0534a.hHN.setVisibility(0);
            } else {
                c0534a.hHN.setVisibility(8);
            }
            a(c0534a.hzY, groupInfoData.getGrade());
        }
        this.hHK.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hHK.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0534a.hzR, R.color.common_color_10009, 1);
            am.setImageResource(c0534a.hzV, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hzW, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hzX, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes13.dex */
    static class C0534a {
        LinearLayout hHM;
        TextView hHN;
        ImageView hHO;
        ImageView hHP;
        ImageView hHQ;
        GroupImageView hzQ;
        TextView hzR;
        TextView hzT;
        TextView hzU;
        ImageView hzV;
        ImageView hzW;
        ImageView hzX;
        ImageView[] hzY;

        C0534a() {
        }
    }
}
