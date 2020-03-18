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
    private PersonalGroupFragment hJw;
    private List<GroupInfoData> hJx = new ArrayList();

    public void de(List<GroupInfoData> list) {
        this.hJx = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hJw = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hJx.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wY */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hJx.size()) {
            return null;
        }
        return this.hJx.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0535a c0535a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0535a)) {
            view = LayoutInflater.from(this.hJw.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0535a = new C0535a();
            c0535a.hJy = (LinearLayout) view.findViewById(R.id.click_head);
            c0535a.hJA = (ImageView) view.findViewById(R.id.diver_top);
            c0535a.hJB = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0535a.hJC = (ImageView) view.findViewById(R.id.diver_top_px);
            c0535a.hBC = (GroupImageView) view.findViewById(R.id.item_head);
            c0535a.hBD = (TextView) view.findViewById(R.id.item_group_name);
            c0535a.hBF = (TextView) view.findViewById(R.id.item_group_num);
            c0535a.hBG = (TextView) view.findViewById(R.id.item_introduce);
            c0535a.hJz = (TextView) view.findViewById(R.id.isCreator);
            c0535a.hBH = (ImageView) view.findViewById(R.id.item_grade1);
            c0535a.hBI = (ImageView) view.findViewById(R.id.item_grade2);
            c0535a.hBJ = (ImageView) view.findViewById(R.id.item_grade3);
            c0535a.hBK = new ImageView[4];
            c0535a.hBK[1] = c0535a.hBH;
            c0535a.hBK[2] = c0535a.hBI;
            c0535a.hBK[3] = c0535a.hBJ;
            view.setTag(c0535a);
        } else {
            c0535a = (C0535a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hJx.get(i);
        c0535a.hBC.setTag(null);
        c0535a.hBC.setDrawBorder(true);
        c0535a.hBC.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0535a.hBC.startLoad(portrait, 10, false);
            } else {
                c0535a.hBC.startLoad("", 10, false);
            }
            c0535a.hJy.setOnClickListener(this.hJw);
            c0535a.hJy.setTag(groupInfoData);
            c0535a.hJA.setVisibility(8);
            c0535a.hJC.setVisibility(8);
            c0535a.hJB.setVisibility(0);
            c0535a.hBD.setText(groupInfoData.getName());
            c0535a.hBF.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0535a.hBG.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0535a.hJz.setVisibility(0);
            } else {
                c0535a.hJz.setVisibility(8);
            }
            a(c0535a.hBK, groupInfoData.getGrade());
        }
        this.hJw.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hJw.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0535a.hBD, R.color.common_color_10009, 1);
            am.setImageResource(c0535a.hBH, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0535a.hBI, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0535a.hBJ, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0535a {
        GroupImageView hBC;
        TextView hBD;
        TextView hBF;
        TextView hBG;
        ImageView hBH;
        ImageView hBI;
        ImageView hBJ;
        ImageView[] hBK;
        ImageView hJA;
        ImageView hJB;
        ImageView hJC;
        LinearLayout hJy;
        TextView hJz;

        C0535a() {
        }
    }
}
