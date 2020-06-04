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
    private PersonalGroupFragment iIL;
    private List<GroupInfoData> iIM = new ArrayList();

    /* renamed from: do  reason: not valid java name */
    public void m34do(List<GroupInfoData> list) {
        this.iIM = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.iIL = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.iIM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: ye */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.iIM.size()) {
            return null;
        }
        return this.iIM.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0643a c0643a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0643a)) {
            view = LayoutInflater.from(this.iIL.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0643a = new C0643a();
            c0643a.iIN = (LinearLayout) view.findViewById(R.id.click_head);
            c0643a.iIP = (ImageView) view.findViewById(R.id.diver_top);
            c0643a.iIQ = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0643a.iIR = (ImageView) view.findViewById(R.id.diver_top_px);
            c0643a.iAR = (GroupImageView) view.findViewById(R.id.item_head);
            c0643a.iAS = (TextView) view.findViewById(R.id.item_group_name);
            c0643a.iAU = (TextView) view.findViewById(R.id.item_group_num);
            c0643a.iAV = (TextView) view.findViewById(R.id.item_introduce);
            c0643a.iIO = (TextView) view.findViewById(R.id.isCreator);
            c0643a.iAW = (ImageView) view.findViewById(R.id.item_grade1);
            c0643a.iAX = (ImageView) view.findViewById(R.id.item_grade2);
            c0643a.iAY = (ImageView) view.findViewById(R.id.item_grade3);
            c0643a.iAZ = new ImageView[4];
            c0643a.iAZ[1] = c0643a.iAW;
            c0643a.iAZ[2] = c0643a.iAX;
            c0643a.iAZ[3] = c0643a.iAY;
            view.setTag(c0643a);
        } else {
            c0643a = (C0643a) view.getTag();
        }
        GroupInfoData groupInfoData = this.iIM.get(i);
        c0643a.iAR.setTag(null);
        c0643a.iAR.setDrawBorder(true);
        c0643a.iAR.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0643a.iAR.startLoad(portrait, 10, false);
            } else {
                c0643a.iAR.startLoad("", 10, false);
            }
            c0643a.iIN.setOnClickListener(this.iIL);
            c0643a.iIN.setTag(groupInfoData);
            c0643a.iIP.setVisibility(8);
            c0643a.iIR.setVisibility(8);
            c0643a.iIQ.setVisibility(0);
            c0643a.iAS.setText(groupInfoData.getName());
            c0643a.iAU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0643a.iAV.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0643a.iIO.setVisibility(0);
            } else {
                c0643a.iIO.setVisibility(8);
            }
            a(c0643a.iAZ, groupInfoData.getGrade());
        }
        this.iIL.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iIL.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0643a.iAS, R.color.common_color_10009, 1);
            am.setImageResource(c0643a.iAW, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0643a.iAX, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0643a.iAY, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0643a {
        GroupImageView iAR;
        TextView iAS;
        TextView iAU;
        TextView iAV;
        ImageView iAW;
        ImageView iAX;
        ImageView iAY;
        ImageView[] iAZ;
        LinearLayout iIN;
        TextView iIO;
        ImageView iIP;
        ImageView iIQ;
        ImageView iIR;

        C0643a() {
        }
    }
}
