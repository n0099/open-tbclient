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
    private PersonalGroupFragment gOT;
    private List<GroupInfoData> gOU = new ArrayList();

    public void dt(List<GroupInfoData> list) {
        this.gOU = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gOT = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gOU.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uE */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gOU.size()) {
            return null;
        }
        return this.gOU.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0441a c0441a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0441a)) {
            view = LayoutInflater.from(this.gOT.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0441a = new C0441a();
            c0441a.gOV = (LinearLayout) view.findViewById(R.id.click_head);
            c0441a.gOX = (ImageView) view.findViewById(R.id.diver_top);
            c0441a.gOY = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0441a.gOZ = (ImageView) view.findViewById(R.id.diver_top_px);
            c0441a.gGZ = (GroupImageView) view.findViewById(R.id.item_head);
            c0441a.gHa = (TextView) view.findViewById(R.id.item_group_name);
            c0441a.gHc = (TextView) view.findViewById(R.id.item_group_num);
            c0441a.gHd = (TextView) view.findViewById(R.id.item_introduce);
            c0441a.gOW = (TextView) view.findViewById(R.id.isCreator);
            c0441a.gHe = (ImageView) view.findViewById(R.id.item_grade1);
            c0441a.gHf = (ImageView) view.findViewById(R.id.item_grade2);
            c0441a.gHg = (ImageView) view.findViewById(R.id.item_grade3);
            c0441a.gHh = new ImageView[4];
            c0441a.gHh[1] = c0441a.gHe;
            c0441a.gHh[2] = c0441a.gHf;
            c0441a.gHh[3] = c0441a.gHg;
            view.setTag(c0441a);
        } else {
            c0441a = (C0441a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gOU.get(i);
        c0441a.gGZ.setTag(null);
        c0441a.gGZ.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0441a.gGZ.startLoad(portrait, 10, false);
            } else {
                c0441a.gGZ.startLoad("", 10, false);
            }
            c0441a.gOV.setOnClickListener(this.gOT);
            c0441a.gOV.setTag(groupInfoData);
            c0441a.gOX.setVisibility(8);
            c0441a.gOZ.setVisibility(8);
            c0441a.gOY.setVisibility(0);
            c0441a.gHa.setText(groupInfoData.getName());
            c0441a.gHc.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0441a.gHd.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0441a.gOW.setVisibility(0);
            } else {
                c0441a.gOW.setVisibility(8);
            }
            a(c0441a.gHh, groupInfoData.getGrade());
        }
        this.gOT.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gOT.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0441a.gHa, R.color.common_color_10009, 1);
            am.setImageResource(c0441a.gHe, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0441a.gHf, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0441a.gHg, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0441a {
        GroupImageView gGZ;
        TextView gHa;
        TextView gHc;
        TextView gHd;
        ImageView gHe;
        ImageView gHf;
        ImageView gHg;
        ImageView[] gHh;
        LinearLayout gOV;
        TextView gOW;
        ImageView gOX;
        ImageView gOY;
        ImageView gOZ;

        C0441a() {
        }
    }
}
