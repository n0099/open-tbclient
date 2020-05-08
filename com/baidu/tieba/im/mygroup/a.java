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
    private PersonalGroupFragment its;
    private List<GroupInfoData> itt = new ArrayList();

    public void dp(List<GroupInfoData> list) {
        this.itt = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.its = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.itt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xw */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.itt.size()) {
            return null;
        }
        return this.itt.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0593a c0593a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0593a)) {
            view = LayoutInflater.from(this.its.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0593a = new C0593a();
            c0593a.itu = (LinearLayout) view.findViewById(R.id.click_head);
            c0593a.itw = (ImageView) view.findViewById(R.id.diver_top);
            c0593a.itx = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0593a.ity = (ImageView) view.findViewById(R.id.diver_top_px);
            c0593a.ilw = (GroupImageView) view.findViewById(R.id.item_head);
            c0593a.ilx = (TextView) view.findViewById(R.id.item_group_name);
            c0593a.ilz = (TextView) view.findViewById(R.id.item_group_num);
            c0593a.ilA = (TextView) view.findViewById(R.id.item_introduce);
            c0593a.itv = (TextView) view.findViewById(R.id.isCreator);
            c0593a.ilB = (ImageView) view.findViewById(R.id.item_grade1);
            c0593a.ilC = (ImageView) view.findViewById(R.id.item_grade2);
            c0593a.ilD = (ImageView) view.findViewById(R.id.item_grade3);
            c0593a.ilE = new ImageView[4];
            c0593a.ilE[1] = c0593a.ilB;
            c0593a.ilE[2] = c0593a.ilC;
            c0593a.ilE[3] = c0593a.ilD;
            view.setTag(c0593a);
        } else {
            c0593a = (C0593a) view.getTag();
        }
        GroupInfoData groupInfoData = this.itt.get(i);
        c0593a.ilw.setTag(null);
        c0593a.ilw.setDrawBorder(true);
        c0593a.ilw.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0593a.ilw.startLoad(portrait, 10, false);
            } else {
                c0593a.ilw.startLoad("", 10, false);
            }
            c0593a.itu.setOnClickListener(this.its);
            c0593a.itu.setTag(groupInfoData);
            c0593a.itw.setVisibility(8);
            c0593a.ity.setVisibility(8);
            c0593a.itx.setVisibility(0);
            c0593a.ilx.setText(groupInfoData.getName());
            c0593a.ilz.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0593a.ilA.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0593a.itv.setVisibility(0);
            } else {
                c0593a.itv.setVisibility(8);
            }
            a(c0593a.ilE, groupInfoData.getGrade());
        }
        this.its.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.its.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0593a.ilx, R.color.common_color_10009, 1);
            am.setImageResource(c0593a.ilB, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0593a.ilC, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0593a.ilD, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0593a {
        TextView ilA;
        ImageView ilB;
        ImageView ilC;
        ImageView ilD;
        ImageView[] ilE;
        GroupImageView ilw;
        TextView ilx;
        TextView ilz;
        LinearLayout itu;
        TextView itv;
        ImageView itw;
        ImageView itx;
        ImageView ity;

        C0593a() {
        }
    }
}
