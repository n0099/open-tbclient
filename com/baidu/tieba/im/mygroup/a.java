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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kMx;
    private List<GroupInfoData> kMy = new ArrayList();

    public void eB(List<GroupInfoData> list) {
        this.kMy = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kMx = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kMy.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dn */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kMy.size()) {
            return null;
        }
        return this.kMy.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0768a c0768a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0768a)) {
            view = LayoutInflater.from(this.kMx.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0768a = new C0768a();
            c0768a.kMz = (LinearLayout) view.findViewById(R.id.click_head);
            c0768a.kMF = (ImageView) view.findViewById(R.id.diver_top);
            c0768a.kMG = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0768a.kMH = (ImageView) view.findViewById(R.id.diver_top_px);
            c0768a.kMA = (GroupImageView) view.findViewById(R.id.item_head);
            c0768a.kMB = (TextView) view.findViewById(R.id.item_group_name);
            c0768a.kMC = (TextView) view.findViewById(R.id.item_group_num);
            c0768a.kMD = (TextView) view.findViewById(R.id.item_introduce);
            c0768a.kME = (TextView) view.findViewById(R.id.isCreator);
            c0768a.kMI = (ImageView) view.findViewById(R.id.item_grade1);
            c0768a.kMJ = (ImageView) view.findViewById(R.id.item_grade2);
            c0768a.kMK = (ImageView) view.findViewById(R.id.item_grade3);
            c0768a.kML = new ImageView[4];
            c0768a.kML[1] = c0768a.kMI;
            c0768a.kML[2] = c0768a.kMJ;
            c0768a.kML[3] = c0768a.kMK;
            view.setTag(c0768a);
        } else {
            c0768a = (C0768a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kMy.get(i);
        c0768a.kMA.setTag(null);
        c0768a.kMA.setDrawBorder(true);
        c0768a.kMA.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0768a.kMA.startLoad(portrait, 10, false);
            } else {
                c0768a.kMA.startLoad("", 10, false);
            }
            c0768a.kMz.setOnClickListener(this.kMx);
            c0768a.kMz.setTag(groupInfoData);
            c0768a.kMF.setVisibility(8);
            c0768a.kMH.setVisibility(8);
            c0768a.kMG.setVisibility(0);
            c0768a.kMB.setText(groupInfoData.getName());
            c0768a.kMC.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0768a.kMD.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0768a.kME.setVisibility(0);
            } else {
                c0768a.kME.setVisibility(8);
            }
            a(c0768a.kML, groupInfoData.getGrade());
        }
        this.kMx.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kMx.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0768a.kMB, R.color.common_color_10009, 1);
            ap.setImageResource(c0768a.kMI, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0768a.kMJ, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0768a.kMK, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes7.dex */
    static class C0768a {
        GroupImageView kMA;
        TextView kMB;
        TextView kMC;
        TextView kMD;
        TextView kME;
        ImageView kMF;
        ImageView kMG;
        ImageView kMH;
        ImageView kMI;
        ImageView kMJ;
        ImageView kMK;
        ImageView[] kML;
        LinearLayout kMz;

        C0768a() {
        }
    }
}
