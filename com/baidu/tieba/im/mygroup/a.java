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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment gOY;
    private List<GroupInfoData> gOZ = new ArrayList();

    public void dg(List<GroupInfoData> list) {
        this.gOZ = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gOY = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gOZ.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vU */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gOZ.size()) {
            return null;
        }
        return this.gOZ.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0341a c0341a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0341a)) {
            view = LayoutInflater.from(this.gOY.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0341a = new C0341a();
            c0341a.gPa = (LinearLayout) view.findViewById(R.id.click_head);
            c0341a.gPc = (ImageView) view.findViewById(R.id.diver_top);
            c0341a.gPd = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0341a.gPe = (ImageView) view.findViewById(R.id.diver_top_px);
            c0341a.gHj = (GroupImageView) view.findViewById(R.id.item_head);
            c0341a.gHk = (TextView) view.findViewById(R.id.item_group_name);
            c0341a.gHm = (TextView) view.findViewById(R.id.item_group_num);
            c0341a.gHn = (TextView) view.findViewById(R.id.item_introduce);
            c0341a.gPb = (TextView) view.findViewById(R.id.isCreator);
            c0341a.gHo = (ImageView) view.findViewById(R.id.item_grade1);
            c0341a.gHp = (ImageView) view.findViewById(R.id.item_grade2);
            c0341a.gHq = (ImageView) view.findViewById(R.id.item_grade3);
            c0341a.gHr = new ImageView[4];
            c0341a.gHr[1] = c0341a.gHo;
            c0341a.gHr[2] = c0341a.gHp;
            c0341a.gHr[3] = c0341a.gHq;
            view.setTag(c0341a);
        } else {
            c0341a = (C0341a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gOZ.get(i);
        c0341a.gHj.setTag(null);
        c0341a.gHj.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0341a.gHj.startLoad(portrait, 10, false);
            } else {
                c0341a.gHj.startLoad("", 10, false);
            }
            c0341a.gPa.setOnClickListener(this.gOY);
            c0341a.gPa.setTag(groupInfoData);
            c0341a.gPc.setVisibility(8);
            c0341a.gPe.setVisibility(8);
            c0341a.gPd.setVisibility(0);
            c0341a.gHk.setText(groupInfoData.getName());
            c0341a.gHm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0341a.gHn.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0341a.gPb.setVisibility(0);
            } else {
                c0341a.gPb.setVisibility(8);
            }
            a(c0341a.gHr, groupInfoData.getGrade());
        }
        this.gOY.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gOY.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.f(c0341a.gHk, R.color.common_color_10009, 1);
            am.c(c0341a.gHo, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0341a.gHp, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0341a.gHq, (int) R.drawable.icon_vip_grade_big_small_s);
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
    static class C0341a {
        GroupImageView gHj;
        TextView gHk;
        TextView gHm;
        TextView gHn;
        ImageView gHo;
        ImageView gHp;
        ImageView gHq;
        ImageView[] gHr;
        LinearLayout gPa;
        TextView gPb;
        ImageView gPc;
        ImageView gPd;
        ImageView gPe;

        C0341a() {
        }
    }
}
