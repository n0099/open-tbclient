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
    private PersonalGroupFragment eXh;
    private List<GroupInfoData> eXi = new ArrayList();

    public void cM(List<GroupInfoData> list) {
        this.eXi = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eXh = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eXi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qq */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eXi.size()) {
            return null;
        }
        return this.eXi.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0251a c0251a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0251a)) {
            view = LayoutInflater.from(this.eXh.getActivity()).inflate(e.h.tab_my_group_item, viewGroup, false);
            c0251a = new C0251a();
            c0251a.eXj = (LinearLayout) view.findViewById(e.g.click_head);
            c0251a.eXl = (ImageView) view.findViewById(e.g.diver_top);
            c0251a.eXm = (ImageView) view.findViewById(e.g.diver_buttom_px);
            c0251a.eXn = (ImageView) view.findViewById(e.g.diver_top_px);
            c0251a.ePr = (GroupImageView) view.findViewById(e.g.item_head);
            c0251a.ePs = (TextView) view.findViewById(e.g.item_group_name);
            c0251a.ePu = (TextView) view.findViewById(e.g.item_group_num);
            c0251a.ePv = (TextView) view.findViewById(e.g.item_introduce);
            c0251a.eXk = (TextView) view.findViewById(e.g.isCreator);
            c0251a.ePw = (ImageView) view.findViewById(e.g.item_grade1);
            c0251a.ePx = (ImageView) view.findViewById(e.g.item_grade2);
            c0251a.ePy = (ImageView) view.findViewById(e.g.item_grade3);
            c0251a.ePz = new ImageView[4];
            c0251a.ePz[1] = c0251a.ePw;
            c0251a.ePz[2] = c0251a.ePx;
            c0251a.ePz[3] = c0251a.ePy;
            view.setTag(c0251a);
        } else {
            c0251a = (C0251a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eXi.get(i);
        c0251a.ePr.setTag(null);
        c0251a.ePr.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0251a.ePr.startLoad(portrait, 10, false);
            } else {
                c0251a.ePr.startLoad("", 10, false);
            }
            c0251a.eXj.setOnClickListener(this.eXh);
            c0251a.eXj.setTag(groupInfoData);
            c0251a.eXl.setVisibility(8);
            c0251a.eXn.setVisibility(8);
            c0251a.eXm.setVisibility(0);
            c0251a.ePs.setText(groupInfoData.getName());
            c0251a.ePu.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0251a.ePv.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0251a.eXk.setVisibility(0);
            } else {
                c0251a.eXk.setVisibility(8);
            }
            a(c0251a.ePz, groupInfoData.getGrade());
        }
        this.eXh.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eXh.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.c(c0251a.ePs, e.d.common_color_10009, 1);
            al.c(c0251a.ePw, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.ePx, e.f.icon_vip_grade_big_small_s);
            al.c(c0251a.ePy, e.f.icon_vip_grade_big_small_s);
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
        GroupImageView ePr;
        TextView ePs;
        TextView ePu;
        TextView ePv;
        ImageView ePw;
        ImageView ePx;
        ImageView ePy;
        ImageView[] ePz;
        LinearLayout eXj;
        TextView eXk;
        ImageView eXl;
        ImageView eXm;
        ImageView eXn;

        C0251a() {
        }
    }
}
