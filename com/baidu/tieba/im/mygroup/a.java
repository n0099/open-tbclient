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
    private PersonalGroupFragment hHI;
    private List<GroupInfoData> hHJ = new ArrayList();

    public void de(List<GroupInfoData> list) {
        this.hHJ = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hHI = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hHJ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wQ */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hHJ.size()) {
            return null;
        }
        return this.hHJ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0534a c0534a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0534a)) {
            view = LayoutInflater.from(this.hHI.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0534a = new C0534a();
            c0534a.hHK = (LinearLayout) view.findViewById(R.id.click_head);
            c0534a.hHM = (ImageView) view.findViewById(R.id.diver_top);
            c0534a.hHN = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0534a.hHO = (ImageView) view.findViewById(R.id.diver_top_px);
            c0534a.hzO = (GroupImageView) view.findViewById(R.id.item_head);
            c0534a.hzP = (TextView) view.findViewById(R.id.item_group_name);
            c0534a.hzR = (TextView) view.findViewById(R.id.item_group_num);
            c0534a.hzS = (TextView) view.findViewById(R.id.item_introduce);
            c0534a.hHL = (TextView) view.findViewById(R.id.isCreator);
            c0534a.hzT = (ImageView) view.findViewById(R.id.item_grade1);
            c0534a.hzU = (ImageView) view.findViewById(R.id.item_grade2);
            c0534a.hzV = (ImageView) view.findViewById(R.id.item_grade3);
            c0534a.hzW = new ImageView[4];
            c0534a.hzW[1] = c0534a.hzT;
            c0534a.hzW[2] = c0534a.hzU;
            c0534a.hzW[3] = c0534a.hzV;
            view.setTag(c0534a);
        } else {
            c0534a = (C0534a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hHJ.get(i);
        c0534a.hzO.setTag(null);
        c0534a.hzO.setDrawBorder(true);
        c0534a.hzO.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0534a.hzO.startLoad(portrait, 10, false);
            } else {
                c0534a.hzO.startLoad("", 10, false);
            }
            c0534a.hHK.setOnClickListener(this.hHI);
            c0534a.hHK.setTag(groupInfoData);
            c0534a.hHM.setVisibility(8);
            c0534a.hHO.setVisibility(8);
            c0534a.hHN.setVisibility(0);
            c0534a.hzP.setText(groupInfoData.getName());
            c0534a.hzR.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0534a.hzS.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0534a.hHL.setVisibility(0);
            } else {
                c0534a.hHL.setVisibility(8);
            }
            a(c0534a.hzW, groupInfoData.getGrade());
        }
        this.hHI.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hHI.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0534a.hzP, R.color.common_color_10009, 1);
            am.setImageResource(c0534a.hzT, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hzU, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hzV, R.drawable.icon_vip_grade_big_small_s);
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
        LinearLayout hHK;
        TextView hHL;
        ImageView hHM;
        ImageView hHN;
        ImageView hHO;
        GroupImageView hzO;
        TextView hzP;
        TextView hzR;
        TextView hzS;
        ImageView hzT;
        ImageView hzU;
        ImageView hzV;
        ImageView[] hzW;

        C0534a() {
        }
    }
}
