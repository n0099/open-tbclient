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
    private PersonalGroupFragment eQs;
    private List<GroupInfoData> eQt = new ArrayList();

    public void cI(List<GroupInfoData> list) {
        this.eQt = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eQs = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eQt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: pW */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eQt.size()) {
            return null;
        }
        return this.eQt.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0240a c0240a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0240a)) {
            view = LayoutInflater.from(this.eQs.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0240a = new C0240a();
            c0240a.eQu = (LinearLayout) view.findViewById(e.g.click_head);
            c0240a.eQw = (ImageView) view.findViewById(e.g.diver_top);
            c0240a.eQx = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0240a.eQy = (ImageView) view.findViewById(e.g.diver_top_px);
            c0240a.eIC = (GroupImageView) view.findViewById(e.g.item_head);
            c0240a.eID = (TextView) view.findViewById(e.g.item_group_name);
            c0240a.eIF = (TextView) view.findViewById(e.g.item_group_num);
            c0240a.eIG = (TextView) view.findViewById(e.g.item_introduce);
            c0240a.eQv = (TextView) view.findViewById(e.g.isCreator);
            c0240a.eIH = (ImageView) view.findViewById(e.g.item_grade1);
            c0240a.eII = (ImageView) view.findViewById(e.g.item_grade2);
            c0240a.eIJ = (ImageView) view.findViewById(e.g.item_grade3);
            c0240a.eIK = new ImageView[4];
            c0240a.eIK[1] = c0240a.eIH;
            c0240a.eIK[2] = c0240a.eII;
            c0240a.eIK[3] = c0240a.eIJ;
            view.setTag(c0240a);
        } else {
            c0240a = (C0240a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eQt.get(i);
        c0240a.eIC.setTag(null);
        c0240a.eIC.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0240a.eIC.startLoad(portrait, 10, false);
            } else {
                c0240a.eIC.startLoad("", 10, false);
            }
            c0240a.eQu.setOnClickListener(this.eQs);
            c0240a.eQu.setTag(groupInfoData);
            c0240a.eQw.setVisibility(8);
            c0240a.eQy.setVisibility(8);
            c0240a.eQx.setVisibility(0);
            c0240a.eID.setText(groupInfoData.getName());
            c0240a.eIF.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0240a.eIG.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0240a.eQv.setVisibility(0);
            } else {
                c0240a.eQv.setVisibility(8);
            }
            a(c0240a.eIK, groupInfoData.getGrade());
        }
        this.eQs.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eQs.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0240a.eID, e.d.common_color_10009, 1);
            al.c(c0240a.eIH, e.f.icon_vip_grade_big_small_s);
            al.c(c0240a.eII, e.f.icon_vip_grade_big_small_s);
            al.c(c0240a.eIJ, e.f.icon_vip_grade_big_small_s);
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
    static class C0240a {
        GroupImageView eIC;
        TextView eID;
        TextView eIF;
        TextView eIG;
        ImageView eIH;
        ImageView eII;
        ImageView eIJ;
        ImageView[] eIK;
        LinearLayout eQu;
        TextView eQv;
        ImageView eQw;
        ImageView eQx;
        ImageView eQy;

        C0240a() {
        }
    }
}
