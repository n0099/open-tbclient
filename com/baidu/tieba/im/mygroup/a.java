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
    private PersonalGroupFragment gHU;
    private List<GroupInfoData> gHV = new ArrayList();

    public void df(List<GroupInfoData> list) {
        this.gHV = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gHU = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gHV.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vr */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gHV.size()) {
            return null;
        }
        return this.gHV.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0336a c0336a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0336a)) {
            view = LayoutInflater.from(this.gHU.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0336a = new C0336a();
            c0336a.gHW = (LinearLayout) view.findViewById(R.id.click_head);
            c0336a.gHY = (ImageView) view.findViewById(R.id.diver_top);
            c0336a.gHZ = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0336a.gIa = (ImageView) view.findViewById(R.id.diver_top_px);
            c0336a.gAf = (GroupImageView) view.findViewById(R.id.item_head);
            c0336a.gAg = (TextView) view.findViewById(R.id.item_group_name);
            c0336a.gAi = (TextView) view.findViewById(R.id.item_group_num);
            c0336a.gAj = (TextView) view.findViewById(R.id.item_introduce);
            c0336a.gHX = (TextView) view.findViewById(R.id.isCreator);
            c0336a.gAk = (ImageView) view.findViewById(R.id.item_grade1);
            c0336a.gAl = (ImageView) view.findViewById(R.id.item_grade2);
            c0336a.gAm = (ImageView) view.findViewById(R.id.item_grade3);
            c0336a.gAn = new ImageView[4];
            c0336a.gAn[1] = c0336a.gAk;
            c0336a.gAn[2] = c0336a.gAl;
            c0336a.gAn[3] = c0336a.gAm;
            view.setTag(c0336a);
        } else {
            c0336a = (C0336a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gHV.get(i);
        c0336a.gAf.setTag(null);
        c0336a.gAf.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0336a.gAf.startLoad(portrait, 10, false);
            } else {
                c0336a.gAf.startLoad("", 10, false);
            }
            c0336a.gHW.setOnClickListener(this.gHU);
            c0336a.gHW.setTag(groupInfoData);
            c0336a.gHY.setVisibility(8);
            c0336a.gIa.setVisibility(8);
            c0336a.gHZ.setVisibility(0);
            c0336a.gAg.setText(groupInfoData.getName());
            c0336a.gAi.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0336a.gAj.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0336a.gHX.setVisibility(0);
            } else {
                c0336a.gHX.setVisibility(8);
            }
            a(c0336a.gAn, groupInfoData.getGrade());
        }
        this.gHU.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gHU.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.f(c0336a.gAg, R.color.common_color_10009, 1);
            al.c(c0336a.gAk, (int) R.drawable.icon_vip_grade_big_small_s);
            al.c(c0336a.gAl, (int) R.drawable.icon_vip_grade_big_small_s);
            al.c(c0336a.gAm, (int) R.drawable.icon_vip_grade_big_small_s);
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
        GroupImageView gAf;
        TextView gAg;
        TextView gAi;
        TextView gAj;
        ImageView gAk;
        ImageView gAl;
        ImageView gAm;
        ImageView[] gAn;
        LinearLayout gHW;
        TextView gHX;
        ImageView gHY;
        ImageView gHZ;
        ImageView gIa;

        C0336a() {
        }
    }
}
