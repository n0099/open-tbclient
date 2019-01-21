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
    private PersonalGroupFragment faM;
    private List<GroupInfoData> faN = new ArrayList();

    public void cO(List<GroupInfoData> list) {
        this.faN = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.faM = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.faN.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qE */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.faN.size()) {
            return null;
        }
        return this.faN.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0251a c0251a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0251a)) {
            view = LayoutInflater.from(this.faM.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0251a = new C0251a();
            c0251a.faO = (LinearLayout) view.findViewById(e.g.click_head);
            c0251a.faQ = (ImageView) view.findViewById(e.g.diver_top);
            c0251a.faR = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0251a.faS = (ImageView) view.findViewById(e.g.diver_top_px);
            c0251a.eSW = (GroupImageView) view.findViewById(e.g.item_head);
            c0251a.eSX = (TextView) view.findViewById(e.g.item_group_name);
            c0251a.eSZ = (TextView) view.findViewById(e.g.item_group_num);
            c0251a.eTa = (TextView) view.findViewById(e.g.item_introduce);
            c0251a.faP = (TextView) view.findViewById(e.g.isCreator);
            c0251a.eTb = (ImageView) view.findViewById(e.g.item_grade1);
            c0251a.eTc = (ImageView) view.findViewById(e.g.item_grade2);
            c0251a.eTd = (ImageView) view.findViewById(e.g.item_grade3);
            c0251a.eTe = new ImageView[4];
            c0251a.eTe[1] = c0251a.eTb;
            c0251a.eTe[2] = c0251a.eTc;
            c0251a.eTe[3] = c0251a.eTd;
            view.setTag(c0251a);
        } else {
            c0251a = (C0251a) view.getTag();
        }
        GroupInfoData groupInfoData = this.faN.get(i);
        c0251a.eSW.setTag(null);
        c0251a.eSW.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0251a.eSW.startLoad(portrait, 10, false);
            } else {
                c0251a.eSW.startLoad("", 10, false);
            }
            c0251a.faO.setOnClickListener(this.faM);
            c0251a.faO.setTag(groupInfoData);
            c0251a.faQ.setVisibility(8);
            c0251a.faS.setVisibility(8);
            c0251a.faR.setVisibility(0);
            c0251a.eSX.setText(groupInfoData.getName());
            c0251a.eSZ.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0251a.eTa.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0251a.faP.setVisibility(0);
            } else {
                c0251a.faP.setVisibility(8);
            }
            a(c0251a.eTe, groupInfoData.getGrade());
        }
        this.faM.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.faM.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0251a.eSX, e.d.common_color_10009, 1);
            al.c(c0251a.eTb, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eTc, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eTd, e.f.icon_vip_grade_big_small_s);
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
        GroupImageView eSW;
        TextView eSX;
        TextView eSZ;
        TextView eTa;
        ImageView eTb;
        ImageView eTc;
        ImageView eTd;
        ImageView[] eTe;
        LinearLayout faO;
        TextView faP;
        ImageView faQ;
        ImageView faR;
        ImageView faS;

        C0251a() {
        }
    }
}
