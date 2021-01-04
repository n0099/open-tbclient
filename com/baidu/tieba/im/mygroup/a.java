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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kGH;
    private List<GroupInfoData> kGI = new ArrayList();

    public void eD(List<GroupInfoData> list) {
        this.kGI = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kGH = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kGI.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ez */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kGI.size()) {
            return null;
        }
        return this.kGI.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0767a c0767a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0767a)) {
            view = LayoutInflater.from(this.kGH.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0767a = new C0767a();
            c0767a.kGJ = (LinearLayout) view.findViewById(R.id.click_head);
            c0767a.kGP = (ImageView) view.findViewById(R.id.diver_top);
            c0767a.kGQ = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0767a.kGR = (ImageView) view.findViewById(R.id.diver_top_px);
            c0767a.kGK = (GroupImageView) view.findViewById(R.id.item_head);
            c0767a.kGL = (TextView) view.findViewById(R.id.item_group_name);
            c0767a.kGM = (TextView) view.findViewById(R.id.item_group_num);
            c0767a.kGN = (TextView) view.findViewById(R.id.item_introduce);
            c0767a.kGO = (TextView) view.findViewById(R.id.isCreator);
            c0767a.kGS = (ImageView) view.findViewById(R.id.item_grade1);
            c0767a.kGT = (ImageView) view.findViewById(R.id.item_grade2);
            c0767a.kGU = (ImageView) view.findViewById(R.id.item_grade3);
            c0767a.kGV = new ImageView[4];
            c0767a.kGV[1] = c0767a.kGS;
            c0767a.kGV[2] = c0767a.kGT;
            c0767a.kGV[3] = c0767a.kGU;
            view.setTag(c0767a);
        } else {
            c0767a = (C0767a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kGI.get(i);
        c0767a.kGK.setTag(null);
        c0767a.kGK.setDrawBorder(true);
        c0767a.kGK.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0767a.kGK.startLoad(portrait, 10, false);
            } else {
                c0767a.kGK.startLoad("", 10, false);
            }
            c0767a.kGJ.setOnClickListener(this.kGH);
            c0767a.kGJ.setTag(groupInfoData);
            c0767a.kGP.setVisibility(8);
            c0767a.kGR.setVisibility(8);
            c0767a.kGQ.setVisibility(0);
            c0767a.kGL.setText(groupInfoData.getName());
            c0767a.kGM.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0767a.kGN.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0767a.kGO.setVisibility(0);
            } else {
                c0767a.kGO.setVisibility(8);
            }
            a(c0767a.kGV, groupInfoData.getGrade());
        }
        this.kGH.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kGH.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ao.setViewTextColor(c0767a.kGL, R.color.common_color_10009, 1);
            ao.setImageResource(c0767a.kGS, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0767a.kGT, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0767a.kGU, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes8.dex */
    static class C0767a {
        LinearLayout kGJ;
        GroupImageView kGK;
        TextView kGL;
        TextView kGM;
        TextView kGN;
        TextView kGO;
        ImageView kGP;
        ImageView kGQ;
        ImageView kGR;
        ImageView kGS;
        ImageView kGT;
        ImageView kGU;
        ImageView[] kGV;

        C0767a() {
        }
    }
}
