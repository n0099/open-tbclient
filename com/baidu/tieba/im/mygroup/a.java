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
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment gHW;
    private List<GroupInfoData> gHX = new ArrayList();

    public void df(List<GroupInfoData> list) {
        this.gHX = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gHW = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gHX.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vr */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gHX.size()) {
            return null;
        }
        return this.gHX.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0336a c0336a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0336a)) {
            view = LayoutInflater.from(this.gHW.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0336a = new C0336a();
            c0336a.gHY = (LinearLayout) view.findViewById(R.id.click_head);
            c0336a.gIa = (ImageView) view.findViewById(R.id.diver_top);
            c0336a.gIb = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0336a.gIc = (ImageView) view.findViewById(R.id.diver_top_px);
            c0336a.gAh = (GroupImageView) view.findViewById(R.id.item_head);
            c0336a.gAi = (TextView) view.findViewById(R.id.item_group_name);
            c0336a.gAk = (TextView) view.findViewById(R.id.item_group_num);
            c0336a.gAl = (TextView) view.findViewById(R.id.item_introduce);
            c0336a.gHZ = (TextView) view.findViewById(R.id.isCreator);
            c0336a.gAm = (ImageView) view.findViewById(R.id.item_grade1);
            c0336a.gAn = (ImageView) view.findViewById(R.id.item_grade2);
            c0336a.gAo = (ImageView) view.findViewById(R.id.item_grade3);
            c0336a.gAp = new ImageView[4];
            c0336a.gAp[1] = c0336a.gAm;
            c0336a.gAp[2] = c0336a.gAn;
            c0336a.gAp[3] = c0336a.gAo;
            view.setTag(c0336a);
        } else {
            c0336a = (C0336a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gHX.get(i);
        c0336a.gAh.setTag(null);
        c0336a.gAh.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0336a.gAh.startLoad(portrait, 10, false);
            } else {
                c0336a.gAh.startLoad("", 10, false);
            }
            c0336a.gHY.setOnClickListener(this.gHW);
            c0336a.gHY.setTag(groupInfoData);
            c0336a.gIa.setVisibility(8);
            c0336a.gIc.setVisibility(8);
            c0336a.gIb.setVisibility(0);
            c0336a.gAi.setText(groupInfoData.getName());
            c0336a.gAk.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0336a.gAl.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0336a.gHZ.setVisibility(0);
            } else {
                c0336a.gHZ.setVisibility(8);
            }
            a(c0336a.gAp, groupInfoData.getGrade());
        }
        this.gHW.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gHW.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.f(c0336a.gAi, R.color.common_color_10009, 1);
            al.c(c0336a.gAm, (int) R.drawable.icon_vip_grade_big_small_s);
            al.c(c0336a.gAn, (int) R.drawable.icon_vip_grade_big_small_s);
            al.c(c0336a.gAo, (int) R.drawable.icon_vip_grade_big_small_s);
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
    static class C0336a {
        GroupImageView gAh;
        TextView gAi;
        TextView gAk;
        TextView gAl;
        ImageView gAm;
        ImageView gAn;
        ImageView gAo;
        ImageView[] gAp;
        LinearLayout gHY;
        TextView gHZ;
        ImageView gIa;
        ImageView gIb;
        ImageView gIc;

        C0336a() {
        }
    }
}
