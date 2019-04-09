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
    private PersonalGroupFragment gqG;
    private List<GroupInfoData> gqH = new ArrayList();

    public void cX(List<GroupInfoData> list) {
        this.gqH = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gqG = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gqH.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uk */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gqH.size()) {
            return null;
        }
        return this.gqH.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0319a c0319a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0319a)) {
            view = LayoutInflater.from(this.gqG.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            c0319a = new C0319a();
            c0319a.gqI = (LinearLayout) view.findViewById(d.g.click_head);
            c0319a.gqK = (ImageView) view.findViewById(d.g.diver_top);
            c0319a.gqL = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0319a.gqM = (ImageView) view.findViewById(d.g.diver_top_px);
            c0319a.giR = (GroupImageView) view.findViewById(d.g.item_head);
            c0319a.giS = (TextView) view.findViewById(d.g.item_group_name);
            c0319a.giU = (TextView) view.findViewById(d.g.item_group_num);
            c0319a.giV = (TextView) view.findViewById(d.g.item_introduce);
            c0319a.gqJ = (TextView) view.findViewById(d.g.isCreator);
            c0319a.giW = (ImageView) view.findViewById(d.g.item_grade1);
            c0319a.giX = (ImageView) view.findViewById(d.g.item_grade2);
            c0319a.giY = (ImageView) view.findViewById(d.g.item_grade3);
            c0319a.giZ = new ImageView[4];
            c0319a.giZ[1] = c0319a.giW;
            c0319a.giZ[2] = c0319a.giX;
            c0319a.giZ[3] = c0319a.giY;
            view.setTag(c0319a);
        } else {
            c0319a = (C0319a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gqH.get(i);
        c0319a.giR.setTag(null);
        c0319a.giR.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0319a.giR.startLoad(portrait, 10, false);
            } else {
                c0319a.giR.startLoad("", 10, false);
            }
            c0319a.gqI.setOnClickListener(this.gqG);
            c0319a.gqI.setTag(groupInfoData);
            c0319a.gqK.setVisibility(8);
            c0319a.gqM.setVisibility(8);
            c0319a.gqL.setVisibility(0);
            c0319a.giS.setText(groupInfoData.getName());
            c0319a.giU.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0319a.giV.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0319a.gqJ.setVisibility(0);
            } else {
                c0319a.gqJ.setVisibility(8);
            }
            a(c0319a.giZ, groupInfoData.getGrade());
        }
        this.gqG.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gqG.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.d(c0319a.giS, d.C0277d.common_color_10009, 1);
            al.c(c0319a.giW, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.giX, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.giY, d.f.icon_vip_grade_big_small_s);
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
    static class C0319a {
        GroupImageView giR;
        TextView giS;
        TextView giU;
        TextView giV;
        ImageView giW;
        ImageView giX;
        ImageView giY;
        ImageView[] giZ;
        LinearLayout gqI;
        TextView gqJ;
        ImageView gqK;
        ImageView gqL;
        ImageView gqM;

        C0319a() {
        }
    }
}
