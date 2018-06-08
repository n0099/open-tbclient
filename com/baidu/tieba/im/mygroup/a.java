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
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment est;
    private List<GroupInfoData> esu = new ArrayList();

    public void cq(List<GroupInfoData> list) {
        this.esu = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.est = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.esu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: og */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.esu.size()) {
            return null;
        }
        return this.esu.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0177a c0177a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0177a)) {
            view = LayoutInflater.from(this.est.getActivity()).inflate(d.i.tab_my_group_item, viewGroup, false);
            c0177a = new C0177a();
            c0177a.esv = (LinearLayout) view.findViewById(d.g.click_head);
            c0177a.esx = (ImageView) view.findViewById(d.g.diver_top);
            c0177a.esy = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0177a.esz = (ImageView) view.findViewById(d.g.diver_top_px);
            c0177a.ekw = (GroupImageView) view.findViewById(d.g.item_head);
            c0177a.ekx = (TextView) view.findViewById(d.g.item_group_name);
            c0177a.ekz = (TextView) view.findViewById(d.g.item_group_num);
            c0177a.ekA = (TextView) view.findViewById(d.g.item_introduce);
            c0177a.esw = (TextView) view.findViewById(d.g.isCreator);
            c0177a.ekB = (ImageView) view.findViewById(d.g.item_grade1);
            c0177a.ekC = (ImageView) view.findViewById(d.g.item_grade2);
            c0177a.ekD = (ImageView) view.findViewById(d.g.item_grade3);
            c0177a.ekE = new ImageView[4];
            c0177a.ekE[1] = c0177a.ekB;
            c0177a.ekE[2] = c0177a.ekC;
            c0177a.ekE[3] = c0177a.ekD;
            view.setTag(c0177a);
        } else {
            c0177a = (C0177a) view.getTag();
        }
        GroupInfoData groupInfoData = this.esu.get(i);
        c0177a.ekw.setTag(null);
        c0177a.ekw.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0177a.ekw.startLoad(portrait, 10, false);
            } else {
                c0177a.ekw.startLoad("", 10, false);
            }
            c0177a.esv.setOnClickListener(this.est);
            c0177a.esv.setTag(groupInfoData);
            c0177a.esx.setVisibility(8);
            c0177a.esz.setVisibility(8);
            c0177a.esy.setVisibility(0);
            c0177a.ekx.setText(groupInfoData.getName());
            c0177a.ekz.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0177a.ekA.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0177a.esw.setVisibility(0);
            } else {
                c0177a.esw.setVisibility(8);
            }
            a(c0177a.ekE, groupInfoData.getGrade());
        }
        this.est.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.est.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0177a.ekx, d.C0141d.common_color_10009, 1);
            al.c(c0177a.ekB, d.f.icon_vip_grade_big_small_s);
            al.c(c0177a.ekC, d.f.icon_vip_grade_big_small_s);
            al.c(c0177a.ekD, d.f.icon_vip_grade_big_small_s);
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
    static class C0177a {
        TextView ekA;
        ImageView ekB;
        ImageView ekC;
        ImageView ekD;
        ImageView[] ekE;
        GroupImageView ekw;
        TextView ekx;
        TextView ekz;
        LinearLayout esv;
        TextView esw;
        ImageView esx;
        ImageView esy;
        ImageView esz;

        C0177a() {
        }
    }
}
