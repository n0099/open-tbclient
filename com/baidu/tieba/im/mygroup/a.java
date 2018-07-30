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
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment eAd;
    private List<GroupInfoData> eAe = new ArrayList();

    public void cu(List<GroupInfoData> list) {
        this.eAe = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.eAd = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eAe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oB */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eAe.size()) {
            return null;
        }
        return this.eAe.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0178a c0178a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0178a)) {
            view = LayoutInflater.from(this.eAd.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            c0178a = new C0178a();
            c0178a.eAf = (LinearLayout) view.findViewById(d.g.click_head);
            c0178a.eAh = (ImageView) view.findViewById(d.g.diver_top);
            c0178a.eAi = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0178a.eAj = (ImageView) view.findViewById(d.g.diver_top_px);
            c0178a.esj = (GroupImageView) view.findViewById(d.g.item_head);
            c0178a.esk = (TextView) view.findViewById(d.g.item_group_name);
            c0178a.esm = (TextView) view.findViewById(d.g.item_group_num);
            c0178a.esn = (TextView) view.findViewById(d.g.item_introduce);
            c0178a.eAg = (TextView) view.findViewById(d.g.isCreator);
            c0178a.eso = (ImageView) view.findViewById(d.g.item_grade1);
            c0178a.esp = (ImageView) view.findViewById(d.g.item_grade2);
            c0178a.esq = (ImageView) view.findViewById(d.g.item_grade3);
            c0178a.esr = new ImageView[4];
            c0178a.esr[1] = c0178a.eso;
            c0178a.esr[2] = c0178a.esp;
            c0178a.esr[3] = c0178a.esq;
            view.setTag(c0178a);
        } else {
            c0178a = (C0178a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eAe.get(i);
        c0178a.esj.setTag(null);
        c0178a.esj.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0178a.esj.startLoad(portrait, 10, false);
            } else {
                c0178a.esj.startLoad("", 10, false);
            }
            c0178a.eAf.setOnClickListener(this.eAd);
            c0178a.eAf.setTag(groupInfoData);
            c0178a.eAh.setVisibility(8);
            c0178a.eAj.setVisibility(8);
            c0178a.eAi.setVisibility(0);
            c0178a.esk.setText(groupInfoData.getName());
            c0178a.esm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0178a.esn.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0178a.eAg.setVisibility(0);
            } else {
                c0178a.eAg.setVisibility(8);
            }
            a(c0178a.esr, groupInfoData.getGrade());
        }
        this.eAd.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.eAd.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.c(c0178a.esk, d.C0140d.common_color_10009, 1);
            am.c(c0178a.eso, d.f.icon_vip_grade_big_small_s);
            am.c(c0178a.esp, d.f.icon_vip_grade_big_small_s);
            am.c(c0178a.esq, d.f.icon_vip_grade_big_small_s);
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
    static class C0178a {
        LinearLayout eAf;
        TextView eAg;
        ImageView eAh;
        ImageView eAi;
        ImageView eAj;
        GroupImageView esj;
        TextView esk;
        TextView esm;
        TextView esn;
        ImageView eso;
        ImageView esp;
        ImageView esq;
        ImageView[] esr;

        C0178a() {
        }
    }
}
