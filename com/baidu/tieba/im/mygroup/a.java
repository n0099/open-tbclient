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
    private PersonalGroupFragment hHW;
    private List<GroupInfoData> hHX = new ArrayList();

    public void de(List<GroupInfoData> list) {
        this.hHX = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hHW = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hHX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wQ */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hHX.size()) {
            return null;
        }
        return this.hHX.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0534a c0534a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0534a)) {
            view = LayoutInflater.from(this.hHW.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0534a = new C0534a();
            c0534a.hHY = (LinearLayout) view.findViewById(R.id.click_head);
            c0534a.hIa = (ImageView) view.findViewById(R.id.diver_top);
            c0534a.hIb = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0534a.hIc = (ImageView) view.findViewById(R.id.diver_top_px);
            c0534a.hAc = (GroupImageView) view.findViewById(R.id.item_head);
            c0534a.hAd = (TextView) view.findViewById(R.id.item_group_name);
            c0534a.hAf = (TextView) view.findViewById(R.id.item_group_num);
            c0534a.hAg = (TextView) view.findViewById(R.id.item_introduce);
            c0534a.hHZ = (TextView) view.findViewById(R.id.isCreator);
            c0534a.hAh = (ImageView) view.findViewById(R.id.item_grade1);
            c0534a.hAi = (ImageView) view.findViewById(R.id.item_grade2);
            c0534a.hAj = (ImageView) view.findViewById(R.id.item_grade3);
            c0534a.hAk = new ImageView[4];
            c0534a.hAk[1] = c0534a.hAh;
            c0534a.hAk[2] = c0534a.hAi;
            c0534a.hAk[3] = c0534a.hAj;
            view.setTag(c0534a);
        } else {
            c0534a = (C0534a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hHX.get(i);
        c0534a.hAc.setTag(null);
        c0534a.hAc.setDrawBorder(true);
        c0534a.hAc.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0534a.hAc.startLoad(portrait, 10, false);
            } else {
                c0534a.hAc.startLoad("", 10, false);
            }
            c0534a.hHY.setOnClickListener(this.hHW);
            c0534a.hHY.setTag(groupInfoData);
            c0534a.hIa.setVisibility(8);
            c0534a.hIc.setVisibility(8);
            c0534a.hIb.setVisibility(0);
            c0534a.hAd.setText(groupInfoData.getName());
            c0534a.hAf.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0534a.hAg.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0534a.hHZ.setVisibility(0);
            } else {
                c0534a.hHZ.setVisibility(8);
            }
            a(c0534a.hAk, groupInfoData.getGrade());
        }
        this.hHW.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hHW.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0534a.hAd, R.color.common_color_10009, 1);
            am.setImageResource(c0534a.hAh, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hAi, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0534a.hAj, R.drawable.icon_vip_grade_big_small_s);
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
        GroupImageView hAc;
        TextView hAd;
        TextView hAf;
        TextView hAg;
        ImageView hAh;
        ImageView hAi;
        ImageView hAj;
        ImageView[] hAk;
        LinearLayout hHY;
        TextView hHZ;
        ImageView hIa;
        ImageView hIb;
        ImageView hIc;

        C0534a() {
        }
    }
}
