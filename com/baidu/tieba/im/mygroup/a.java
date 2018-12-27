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
    private PersonalGroupFragment eZY;
    private List<GroupInfoData> eZZ = new ArrayList();

    public void cN(List<GroupInfoData> list) {
        this.eZZ = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eZY = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eZZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qD */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eZZ.size()) {
            return null;
        }
        return this.eZZ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0251a c0251a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0251a)) {
            view = LayoutInflater.from(this.eZY.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0251a = new C0251a();
            c0251a.faa = (LinearLayout) view.findViewById(e.g.click_head);
            c0251a.fac = (ImageView) view.findViewById(e.g.diver_top);
            c0251a.fad = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0251a.fae = (ImageView) view.findViewById(e.g.diver_top_px);
            c0251a.eSi = (GroupImageView) view.findViewById(e.g.item_head);
            c0251a.eSj = (TextView) view.findViewById(e.g.item_group_name);
            c0251a.eSl = (TextView) view.findViewById(e.g.item_group_num);
            c0251a.eSm = (TextView) view.findViewById(e.g.item_introduce);
            c0251a.fab = (TextView) view.findViewById(e.g.isCreator);
            c0251a.eSn = (ImageView) view.findViewById(e.g.item_grade1);
            c0251a.eSo = (ImageView) view.findViewById(e.g.item_grade2);
            c0251a.eSp = (ImageView) view.findViewById(e.g.item_grade3);
            c0251a.eSq = new ImageView[4];
            c0251a.eSq[1] = c0251a.eSn;
            c0251a.eSq[2] = c0251a.eSo;
            c0251a.eSq[3] = c0251a.eSp;
            view.setTag(c0251a);
        } else {
            c0251a = (C0251a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eZZ.get(i);
        c0251a.eSi.setTag(null);
        c0251a.eSi.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0251a.eSi.startLoad(portrait, 10, false);
            } else {
                c0251a.eSi.startLoad("", 10, false);
            }
            c0251a.faa.setOnClickListener(this.eZY);
            c0251a.faa.setTag(groupInfoData);
            c0251a.fac.setVisibility(8);
            c0251a.fae.setVisibility(8);
            c0251a.fad.setVisibility(0);
            c0251a.eSj.setText(groupInfoData.getName());
            c0251a.eSl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0251a.eSm.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0251a.fab.setVisibility(0);
            } else {
                c0251a.fab.setVisibility(8);
            }
            a(c0251a.eSq, groupInfoData.getGrade());
        }
        this.eZY.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eZY.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0251a.eSj, e.d.common_color_10009, 1);
            al.c(c0251a.eSn, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eSo, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.eSp, e.f.icon_vip_grade_big_small_s);
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
        GroupImageView eSi;
        TextView eSj;
        TextView eSl;
        TextView eSm;
        ImageView eSn;
        ImageView eSo;
        ImageView eSp;
        ImageView[] eSq;
        LinearLayout faa;
        TextView fab;
        ImageView fac;
        ImageView fad;
        ImageView fae;

        C0251a() {
        }
    }
}
