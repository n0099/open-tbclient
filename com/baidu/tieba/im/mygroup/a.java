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
    private PersonalGroupFragment ewk;
    private List<GroupInfoData> ewl = new ArrayList();

    public void cu(List<GroupInfoData> list) {
        this.ewl = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.ewk = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.ewl.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: on */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.ewl.size()) {
            return null;
        }
        return this.ewl.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0179a c0179a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0179a)) {
            view = LayoutInflater.from(this.ewk.getActivity()).inflate(d.i.tab_my_group_item, viewGroup, false);
            c0179a = new C0179a();
            c0179a.ewm = (LinearLayout) view.findViewById(d.g.click_head);
            c0179a.ewo = (ImageView) view.findViewById(d.g.diver_top);
            c0179a.ewp = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0179a.ewq = (ImageView) view.findViewById(d.g.diver_top_px);
            c0179a.eor = (GroupImageView) view.findViewById(d.g.item_head);
            c0179a.eos = (TextView) view.findViewById(d.g.item_group_name);
            c0179a.eou = (TextView) view.findViewById(d.g.item_group_num);
            c0179a.eov = (TextView) view.findViewById(d.g.item_introduce);
            c0179a.ewn = (TextView) view.findViewById(d.g.isCreator);
            c0179a.eow = (ImageView) view.findViewById(d.g.item_grade1);
            c0179a.eox = (ImageView) view.findViewById(d.g.item_grade2);
            c0179a.eoy = (ImageView) view.findViewById(d.g.item_grade3);
            c0179a.eoz = new ImageView[4];
            c0179a.eoz[1] = c0179a.eow;
            c0179a.eoz[2] = c0179a.eox;
            c0179a.eoz[3] = c0179a.eoy;
            view.setTag(c0179a);
        } else {
            c0179a = (C0179a) view.getTag();
        }
        GroupInfoData groupInfoData = this.ewl.get(i);
        c0179a.eor.setTag(null);
        c0179a.eor.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0179a.eor.startLoad(portrait, 10, false);
            } else {
                c0179a.eor.startLoad("", 10, false);
            }
            c0179a.ewm.setOnClickListener(this.ewk);
            c0179a.ewm.setTag(groupInfoData);
            c0179a.ewo.setVisibility(8);
            c0179a.ewq.setVisibility(8);
            c0179a.ewp.setVisibility(0);
            c0179a.eos.setText(groupInfoData.getName());
            c0179a.eou.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0179a.eov.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0179a.ewn.setVisibility(0);
            } else {
                c0179a.ewn.setVisibility(8);
            }
            a(c0179a.eoz, groupInfoData.getGrade());
        }
        this.ewk.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.ewk.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.c(c0179a.eos, d.C0142d.common_color_10009, 1);
            am.c(c0179a.eow, d.f.icon_vip_grade_big_small_s);
            am.c(c0179a.eox, d.f.icon_vip_grade_big_small_s);
            am.c(c0179a.eoy, d.f.icon_vip_grade_big_small_s);
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
    static class C0179a {
        GroupImageView eor;
        TextView eos;
        TextView eou;
        TextView eov;
        ImageView eow;
        ImageView eox;
        ImageView eoy;
        ImageView[] eoz;
        LinearLayout ewm;
        TextView ewn;
        ImageView ewo;
        ImageView ewp;
        ImageView ewq;

        C0179a() {
        }
    }
}
