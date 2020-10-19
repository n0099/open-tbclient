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
/* loaded from: classes26.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment jUO;
    private List<GroupInfoData> jUP = new ArrayList();

    public void eb(List<GroupInfoData> list) {
        this.jUP = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jUO = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jUP.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CN */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jUP.size()) {
            return null;
        }
        return this.jUP.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0735a c0735a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0735a)) {
            view = LayoutInflater.from(this.jUO.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0735a = new C0735a();
            c0735a.jUQ = (LinearLayout) view.findViewById(R.id.click_head);
            c0735a.jUS = (ImageView) view.findViewById(R.id.diver_top);
            c0735a.jUT = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0735a.jUU = (ImageView) view.findViewById(R.id.diver_top_px);
            c0735a.jMO = (GroupImageView) view.findViewById(R.id.item_head);
            c0735a.jMP = (TextView) view.findViewById(R.id.item_group_name);
            c0735a.jMR = (TextView) view.findViewById(R.id.item_group_num);
            c0735a.jMS = (TextView) view.findViewById(R.id.item_introduce);
            c0735a.jUR = (TextView) view.findViewById(R.id.isCreator);
            c0735a.jMT = (ImageView) view.findViewById(R.id.item_grade1);
            c0735a.jMU = (ImageView) view.findViewById(R.id.item_grade2);
            c0735a.jMV = (ImageView) view.findViewById(R.id.item_grade3);
            c0735a.jMW = new ImageView[4];
            c0735a.jMW[1] = c0735a.jMT;
            c0735a.jMW[2] = c0735a.jMU;
            c0735a.jMW[3] = c0735a.jMV;
            view.setTag(c0735a);
        } else {
            c0735a = (C0735a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jUP.get(i);
        c0735a.jMO.setTag(null);
        c0735a.jMO.setDrawBorder(true);
        c0735a.jMO.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0735a.jMO.startLoad(portrait, 10, false);
            } else {
                c0735a.jMO.startLoad("", 10, false);
            }
            c0735a.jUQ.setOnClickListener(this.jUO);
            c0735a.jUQ.setTag(groupInfoData);
            c0735a.jUS.setVisibility(8);
            c0735a.jUU.setVisibility(8);
            c0735a.jUT.setVisibility(0);
            c0735a.jMP.setText(groupInfoData.getName());
            c0735a.jMR.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0735a.jMS.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0735a.jUR.setVisibility(0);
            } else {
                c0735a.jUR.setVisibility(8);
            }
            a(c0735a.jMW, groupInfoData.getGrade());
        }
        this.jUO.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jUO.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0735a.jMP, R.color.common_color_10009, 1);
            ap.setImageResource(c0735a.jMT, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0735a.jMU, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0735a.jMV, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes26.dex */
    static class C0735a {
        GroupImageView jMO;
        TextView jMP;
        TextView jMR;
        TextView jMS;
        ImageView jMT;
        ImageView jMU;
        ImageView jMV;
        ImageView[] jMW;
        LinearLayout jUQ;
        TextView jUR;
        ImageView jUS;
        ImageView jUT;
        ImageView jUU;

        C0735a() {
        }
    }
}
