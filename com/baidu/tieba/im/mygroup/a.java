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
import com.baidu.tieba.f;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private List<GroupInfoData> eAa = new ArrayList();
    private PersonalGroupFragment ezZ;

    public void cu(List<GroupInfoData> list) {
        this.eAa = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.ezZ = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eAa.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: oB */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eAa.size()) {
            return null;
        }
        return this.eAa.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0178a c0178a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0178a)) {
            view = LayoutInflater.from(this.ezZ.getActivity()).inflate(f.h.tab_my_group_item, viewGroup, false);
            c0178a = new C0178a();
            c0178a.eAb = (LinearLayout) view.findViewById(f.g.click_head);
            c0178a.eAd = (ImageView) view.findViewById(f.g.diver_top);
            c0178a.eAe = (ImageView) view.findViewById(f.g.diver_buttom_px);
            c0178a.eAf = (ImageView) view.findViewById(f.g.diver_top_px);
            c0178a.esf = (GroupImageView) view.findViewById(f.g.item_head);
            c0178a.esg = (TextView) view.findViewById(f.g.item_group_name);
            c0178a.esi = (TextView) view.findViewById(f.g.item_group_num);
            c0178a.esj = (TextView) view.findViewById(f.g.item_introduce);
            c0178a.eAc = (TextView) view.findViewById(f.g.isCreator);
            c0178a.esk = (ImageView) view.findViewById(f.g.item_grade1);
            c0178a.esl = (ImageView) view.findViewById(f.g.item_grade2);
            c0178a.esm = (ImageView) view.findViewById(f.g.item_grade3);
            c0178a.esn = new ImageView[4];
            c0178a.esn[1] = c0178a.esk;
            c0178a.esn[2] = c0178a.esl;
            c0178a.esn[3] = c0178a.esm;
            view.setTag(c0178a);
        } else {
            c0178a = (C0178a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eAa.get(i);
        c0178a.esf.setTag(null);
        c0178a.esf.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0178a.esf.startLoad(portrait, 10, false);
            } else {
                c0178a.esf.startLoad("", 10, false);
            }
            c0178a.eAb.setOnClickListener(this.ezZ);
            c0178a.eAb.setTag(groupInfoData);
            c0178a.eAd.setVisibility(8);
            c0178a.eAf.setVisibility(8);
            c0178a.eAe.setVisibility(0);
            c0178a.esg.setText(groupInfoData.getName());
            c0178a.esi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0178a.esj.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0178a.eAc.setVisibility(0);
            } else {
                c0178a.eAc.setVisibility(8);
            }
            a(c0178a.esn, groupInfoData.getGrade());
        }
        this.ezZ.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ezZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.c(c0178a.esg, f.d.common_color_10009, 1);
            am.c(c0178a.esk, f.C0146f.icon_vip_grade_big_small_s);
            am.c(c0178a.esl, f.C0146f.icon_vip_grade_big_small_s);
            am.c(c0178a.esm, f.C0146f.icon_vip_grade_big_small_s);
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
        LinearLayout eAb;
        TextView eAc;
        ImageView eAd;
        ImageView eAe;
        ImageView eAf;
        GroupImageView esf;
        TextView esg;
        TextView esi;
        TextView esj;
        ImageView esk;
        ImageView esl;
        ImageView esm;
        ImageView[] esn;

        C0178a() {
        }
    }
}
