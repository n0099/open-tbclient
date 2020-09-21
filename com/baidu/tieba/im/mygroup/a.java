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
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment jFR;
    private List<GroupInfoData> jFS = new ArrayList();

    public void dY(List<GroupInfoData> list) {
        this.jFS = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jFR = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jFS.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Ch */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jFS.size()) {
            return null;
        }
        return this.jFS.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0717a c0717a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0717a)) {
            view = LayoutInflater.from(this.jFR.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0717a = new C0717a();
            c0717a.jFT = (LinearLayout) view.findViewById(R.id.click_head);
            c0717a.jFV = (ImageView) view.findViewById(R.id.diver_top);
            c0717a.jFW = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0717a.jFX = (ImageView) view.findViewById(R.id.diver_top_px);
            c0717a.jxR = (GroupImageView) view.findViewById(R.id.item_head);
            c0717a.jxS = (TextView) view.findViewById(R.id.item_group_name);
            c0717a.jxU = (TextView) view.findViewById(R.id.item_group_num);
            c0717a.jxV = (TextView) view.findViewById(R.id.item_introduce);
            c0717a.jFU = (TextView) view.findViewById(R.id.isCreator);
            c0717a.jxW = (ImageView) view.findViewById(R.id.item_grade1);
            c0717a.jxX = (ImageView) view.findViewById(R.id.item_grade2);
            c0717a.jxY = (ImageView) view.findViewById(R.id.item_grade3);
            c0717a.jxZ = new ImageView[4];
            c0717a.jxZ[1] = c0717a.jxW;
            c0717a.jxZ[2] = c0717a.jxX;
            c0717a.jxZ[3] = c0717a.jxY;
            view.setTag(c0717a);
        } else {
            c0717a = (C0717a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jFS.get(i);
        c0717a.jxR.setTag(null);
        c0717a.jxR.setDrawBorder(true);
        c0717a.jxR.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0717a.jxR.startLoad(portrait, 10, false);
            } else {
                c0717a.jxR.startLoad("", 10, false);
            }
            c0717a.jFT.setOnClickListener(this.jFR);
            c0717a.jFT.setTag(groupInfoData);
            c0717a.jFV.setVisibility(8);
            c0717a.jFX.setVisibility(8);
            c0717a.jFW.setVisibility(0);
            c0717a.jxS.setText(groupInfoData.getName());
            c0717a.jxU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0717a.jxV.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0717a.jFU.setVisibility(0);
            } else {
                c0717a.jFU.setVisibility(8);
            }
            a(c0717a.jxZ, groupInfoData.getGrade());
        }
        this.jFR.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jFR.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0717a.jxS, R.color.common_color_10009, 1);
            ap.setImageResource(c0717a.jxW, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0717a.jxX, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0717a.jxY, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes25.dex */
    static class C0717a {
        LinearLayout jFT;
        TextView jFU;
        ImageView jFV;
        ImageView jFW;
        ImageView jFX;
        GroupImageView jxR;
        TextView jxS;
        TextView jxU;
        TextView jxV;
        ImageView jxW;
        ImageView jxX;
        ImageView jxY;
        ImageView[] jxZ;

        C0717a() {
        }
    }
}
