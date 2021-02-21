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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kKv;
    private List<GroupInfoData> kKw = new ArrayList();

    public void eB(List<GroupInfoData> list) {
        this.kKw = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kKv = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kKw.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dk */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kKw.size()) {
            return null;
        }
        return this.kKw.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0762a c0762a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0762a)) {
            view = LayoutInflater.from(this.kKv.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0762a = new C0762a();
            c0762a.kKx = (LinearLayout) view.findViewById(R.id.click_head);
            c0762a.kKD = (ImageView) view.findViewById(R.id.diver_top);
            c0762a.kKE = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0762a.kKF = (ImageView) view.findViewById(R.id.diver_top_px);
            c0762a.kKy = (GroupImageView) view.findViewById(R.id.item_head);
            c0762a.kKz = (TextView) view.findViewById(R.id.item_group_name);
            c0762a.kKA = (TextView) view.findViewById(R.id.item_group_num);
            c0762a.kKB = (TextView) view.findViewById(R.id.item_introduce);
            c0762a.kKC = (TextView) view.findViewById(R.id.isCreator);
            c0762a.kKG = (ImageView) view.findViewById(R.id.item_grade1);
            c0762a.kKH = (ImageView) view.findViewById(R.id.item_grade2);
            c0762a.kKI = (ImageView) view.findViewById(R.id.item_grade3);
            c0762a.kKJ = new ImageView[4];
            c0762a.kKJ[1] = c0762a.kKG;
            c0762a.kKJ[2] = c0762a.kKH;
            c0762a.kKJ[3] = c0762a.kKI;
            view.setTag(c0762a);
        } else {
            c0762a = (C0762a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kKw.get(i);
        c0762a.kKy.setTag(null);
        c0762a.kKy.setDrawBorder(true);
        c0762a.kKy.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0762a.kKy.startLoad(portrait, 10, false);
            } else {
                c0762a.kKy.startLoad("", 10, false);
            }
            c0762a.kKx.setOnClickListener(this.kKv);
            c0762a.kKx.setTag(groupInfoData);
            c0762a.kKD.setVisibility(8);
            c0762a.kKF.setVisibility(8);
            c0762a.kKE.setVisibility(0);
            c0762a.kKz.setText(groupInfoData.getName());
            c0762a.kKA.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0762a.kKB.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0762a.kKC.setVisibility(0);
            } else {
                c0762a.kKC.setVisibility(8);
            }
            a(c0762a.kKJ, groupInfoData.getGrade());
        }
        this.kKv.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kKv.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0762a.kKz, R.color.common_color_10009, 1);
            ap.setImageResource(c0762a.kKG, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0762a.kKH, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0762a.kKI, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0762a {
        TextView kKA;
        TextView kKB;
        TextView kKC;
        ImageView kKD;
        ImageView kKE;
        ImageView kKF;
        ImageView kKG;
        ImageView kKH;
        ImageView kKI;
        ImageView[] kKJ;
        LinearLayout kKx;
        GroupImageView kKy;
        TextView kKz;

        C0762a() {
        }
    }
}
