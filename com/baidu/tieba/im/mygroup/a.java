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
    private PersonalGroupFragment gqF;
    private List<GroupInfoData> gqG = new ArrayList();

    public void cX(List<GroupInfoData> list) {
        this.gqG = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gqF = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gqG.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uk */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gqG.size()) {
            return null;
        }
        return this.gqG.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0319a c0319a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0319a)) {
            view = LayoutInflater.from(this.gqF.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            c0319a = new C0319a();
            c0319a.gqH = (LinearLayout) view.findViewById(d.g.click_head);
            c0319a.gqJ = (ImageView) view.findViewById(d.g.diver_top);
            c0319a.gqK = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0319a.gqL = (ImageView) view.findViewById(d.g.diver_top_px);
            c0319a.giQ = (GroupImageView) view.findViewById(d.g.item_head);
            c0319a.giR = (TextView) view.findViewById(d.g.item_group_name);
            c0319a.giT = (TextView) view.findViewById(d.g.item_group_num);
            c0319a.giU = (TextView) view.findViewById(d.g.item_introduce);
            c0319a.gqI = (TextView) view.findViewById(d.g.isCreator);
            c0319a.giV = (ImageView) view.findViewById(d.g.item_grade1);
            c0319a.giW = (ImageView) view.findViewById(d.g.item_grade2);
            c0319a.giX = (ImageView) view.findViewById(d.g.item_grade3);
            c0319a.giY = new ImageView[4];
            c0319a.giY[1] = c0319a.giV;
            c0319a.giY[2] = c0319a.giW;
            c0319a.giY[3] = c0319a.giX;
            view.setTag(c0319a);
        } else {
            c0319a = (C0319a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gqG.get(i);
        c0319a.giQ.setTag(null);
        c0319a.giQ.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0319a.giQ.startLoad(portrait, 10, false);
            } else {
                c0319a.giQ.startLoad("", 10, false);
            }
            c0319a.gqH.setOnClickListener(this.gqF);
            c0319a.gqH.setTag(groupInfoData);
            c0319a.gqJ.setVisibility(8);
            c0319a.gqL.setVisibility(8);
            c0319a.gqK.setVisibility(0);
            c0319a.giR.setText(groupInfoData.getName());
            c0319a.giT.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0319a.giU.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0319a.gqI.setVisibility(0);
            } else {
                c0319a.gqI.setVisibility(8);
            }
            a(c0319a.giY, groupInfoData.getGrade());
        }
        this.gqF.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gqF.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.d(c0319a.giR, d.C0277d.common_color_10009, 1);
            al.c(c0319a.giV, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.giW, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.giX, d.f.icon_vip_grade_big_small_s);
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
        GroupImageView giQ;
        TextView giR;
        TextView giT;
        TextView giU;
        ImageView giV;
        ImageView giW;
        ImageView giX;
        ImageView[] giY;
        LinearLayout gqH;
        TextView gqI;
        ImageView gqJ;
        ImageView gqK;
        ImageView gqL;

        C0319a() {
        }
    }
}
