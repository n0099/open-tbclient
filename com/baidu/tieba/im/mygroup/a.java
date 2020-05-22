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
    private PersonalGroupFragment iHY;
    private List<GroupInfoData> iHZ = new ArrayList();

    public void dn(List<GroupInfoData> list) {
        this.iHZ = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.iHY = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.iHZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: yc */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.iHZ.size()) {
            return null;
        }
        return this.iHZ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0643a c0643a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0643a)) {
            view = LayoutInflater.from(this.iHY.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0643a = new C0643a();
            c0643a.iIa = (LinearLayout) view.findViewById(R.id.click_head);
            c0643a.iIc = (ImageView) view.findViewById(R.id.diver_top);
            c0643a.iId = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0643a.iIe = (ImageView) view.findViewById(R.id.diver_top_px);
            c0643a.iAe = (GroupImageView) view.findViewById(R.id.item_head);
            c0643a.iAf = (TextView) view.findViewById(R.id.item_group_name);
            c0643a.iAh = (TextView) view.findViewById(R.id.item_group_num);
            c0643a.iAi = (TextView) view.findViewById(R.id.item_introduce);
            c0643a.iIb = (TextView) view.findViewById(R.id.isCreator);
            c0643a.iAj = (ImageView) view.findViewById(R.id.item_grade1);
            c0643a.iAk = (ImageView) view.findViewById(R.id.item_grade2);
            c0643a.iAl = (ImageView) view.findViewById(R.id.item_grade3);
            c0643a.iAm = new ImageView[4];
            c0643a.iAm[1] = c0643a.iAj;
            c0643a.iAm[2] = c0643a.iAk;
            c0643a.iAm[3] = c0643a.iAl;
            view.setTag(c0643a);
        } else {
            c0643a = (C0643a) view.getTag();
        }
        GroupInfoData groupInfoData = this.iHZ.get(i);
        c0643a.iAe.setTag(null);
        c0643a.iAe.setDrawBorder(true);
        c0643a.iAe.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0643a.iAe.startLoad(portrait, 10, false);
            } else {
                c0643a.iAe.startLoad("", 10, false);
            }
            c0643a.iIa.setOnClickListener(this.iHY);
            c0643a.iIa.setTag(groupInfoData);
            c0643a.iIc.setVisibility(8);
            c0643a.iIe.setVisibility(8);
            c0643a.iId.setVisibility(0);
            c0643a.iAf.setText(groupInfoData.getName());
            c0643a.iAh.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0643a.iAi.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0643a.iIb.setVisibility(0);
            } else {
                c0643a.iIb.setVisibility(8);
            }
            a(c0643a.iAm, groupInfoData.getGrade());
        }
        this.iHY.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.iHY.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0643a.iAf, R.color.common_color_10009, 1);
            am.setImageResource(c0643a.iAj, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0643a.iAk, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0643a.iAl, R.drawable.icon_vip_grade_big_small_s);
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
        GroupImageView iAe;
        TextView iAf;
        TextView iAh;
        TextView iAi;
        ImageView iAj;
        ImageView iAk;
        ImageView iAl;
        ImageView[] iAm;
        LinearLayout iIa;
        TextView iIb;
        ImageView iIc;
        ImageView iId;
        ImageView iIe;

        C0643a() {
        }
    }
}
