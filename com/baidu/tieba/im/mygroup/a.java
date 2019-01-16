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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.e;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment faL;
    private List<GroupInfoData> faM = new ArrayList();

    public void cO(List<GroupInfoData> list) {
        this.faM = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.faL = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.faM.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qE */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.faM.size()) {
            return null;
        }
        return this.faM.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0251a c0251a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0251a)) {
            view = LayoutInflater.from(this.faL.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0251a = new C0251a();
            c0251a.faN = (LinearLayout) view.findViewById(e.g.click_head);
            c0251a.faP = (ImageView) view.findViewById(e.g.diver_top);
            c0251a.faQ = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0251a.faR = (ImageView) view.findViewById(e.g.diver_top_px);
            c0251a.eSV = (GroupImageView) view.findViewById(e.g.item_head);
            c0251a.eSW = (TextView) view.findViewById(e.g.item_group_name);
            c0251a.eSY = (TextView) view.findViewById(e.g.item_group_num);
            c0251a.eSZ = (TextView) view.findViewById(e.g.item_introduce);
            c0251a.faO = (TextView) view.findViewById(e.g.isCreator);
            c0251a.eTa = (ImageView) view.findViewById(e.g.item_grade1);
            c0251a.eTb = (ImageView) view.findViewById(e.g.item_grade2);
            c0251a.eTc = (ImageView) view.findViewById(e.g.item_grade3);
            c0251a.eTd = new ImageView[4];
            c0251a.eTd[1] = c0251a.eTa;
            c0251a.eTd[2] = c0251a.eTb;
            c0251a.eTd[3] = c0251a.eTc;
            view.setTag(c0251a);
        } else {
            c0251a = (C0251a) view.getTag();
        }
        GroupInfoData groupInfoData = this.faM.get(i);
        c0251a.eSV.setTag(null);
        c0251a.eSV.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0251a.eSV.startLoad(portrait, 10, false);
            } else {
                c0251a.eSV.startLoad("", 10, false);
            }
            c0251a.faN.setOnClickListener(this.faL);
            c0251a.faN.setTag(groupInfoData);
            c0251a.faP.setVisibility(8);
            c0251a.faR.setVisibility(8);
            c0251a.faQ.setVisibility(0);
            c0251a.eSW.setText(groupInfoData.getName());
            c0251a.eSY.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0251a.eSZ.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0251a.faO.setVisibility(0);
            } else {
                c0251a.faO.setVisibility(8);
            }
            a(c0251a.eTd, groupInfoData.getGrade());
        }
        this.faL.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.faL.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0251a.eSW, e.d.common_color_10009, 1);
            al.c(c0251a.eTa, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eTb, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eTc, e.f.icon_vip_grade_big_small_s);
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
    /* loaded from: classes3.dex */
    static class C0251a {
        GroupImageView eSV;
        TextView eSW;
        TextView eSY;
        TextView eSZ;
        ImageView eTa;
        ImageView eTb;
        ImageView eTc;
        ImageView[] eTd;
        LinearLayout faN;
        TextView faO;
        ImageView faP;
        ImageView faQ;
        ImageView faR;

        C0251a() {
        }
    }
}
