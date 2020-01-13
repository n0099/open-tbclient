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
/* loaded from: classes11.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment hFJ;
    private List<GroupInfoData> hFK = new ArrayList();

    public void di(List<GroupInfoData> list) {
        this.hFK = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hFJ = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hFK.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wK */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hFK.size()) {
            return null;
        }
        return this.hFK.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0527a c0527a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0527a)) {
            view = LayoutInflater.from(this.hFJ.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0527a = new C0527a();
            c0527a.hFL = (LinearLayout) view.findViewById(R.id.click_head);
            c0527a.hFN = (ImageView) view.findViewById(R.id.diver_top);
            c0527a.hFO = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0527a.hFP = (ImageView) view.findViewById(R.id.diver_top_px);
            c0527a.hxP = (GroupImageView) view.findViewById(R.id.item_head);
            c0527a.hxQ = (TextView) view.findViewById(R.id.item_group_name);
            c0527a.hxS = (TextView) view.findViewById(R.id.item_group_num);
            c0527a.hxT = (TextView) view.findViewById(R.id.item_introduce);
            c0527a.hFM = (TextView) view.findViewById(R.id.isCreator);
            c0527a.hxU = (ImageView) view.findViewById(R.id.item_grade1);
            c0527a.hxV = (ImageView) view.findViewById(R.id.item_grade2);
            c0527a.hxW = (ImageView) view.findViewById(R.id.item_grade3);
            c0527a.hxX = new ImageView[4];
            c0527a.hxX[1] = c0527a.hxU;
            c0527a.hxX[2] = c0527a.hxV;
            c0527a.hxX[3] = c0527a.hxW;
            view.setTag(c0527a);
        } else {
            c0527a = (C0527a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hFK.get(i);
        c0527a.hxP.setTag(null);
        c0527a.hxP.setDrawBorder(true);
        c0527a.hxP.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0527a.hxP.startLoad(portrait, 10, false);
            } else {
                c0527a.hxP.startLoad("", 10, false);
            }
            c0527a.hFL.setOnClickListener(this.hFJ);
            c0527a.hFL.setTag(groupInfoData);
            c0527a.hFN.setVisibility(8);
            c0527a.hFP.setVisibility(8);
            c0527a.hFO.setVisibility(0);
            c0527a.hxQ.setText(groupInfoData.getName());
            c0527a.hxS.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0527a.hxT.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0527a.hFM.setVisibility(0);
            } else {
                c0527a.hFM.setVisibility(8);
            }
            a(c0527a.hxX, groupInfoData.getGrade());
        }
        this.hFJ.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hFJ.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0527a.hxQ, R.color.common_color_10009, 1);
            am.setImageResource(c0527a.hxU, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0527a.hxV, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0527a.hxW, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes11.dex */
    static class C0527a {
        LinearLayout hFL;
        TextView hFM;
        ImageView hFN;
        ImageView hFO;
        ImageView hFP;
        GroupImageView hxP;
        TextView hxQ;
        TextView hxS;
        TextView hxT;
        ImageView hxU;
        ImageView hxV;
        ImageView hxW;
        ImageView[] hxX;

        C0527a() {
        }
    }
}
