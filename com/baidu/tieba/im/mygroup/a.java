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
    private PersonalGroupFragment gqS;
    private List<GroupInfoData> gqT = new ArrayList();

    public void da(List<GroupInfoData> list) {
        this.gqT = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gqS = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gqT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uo */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gqT.size()) {
            return null;
        }
        return this.gqT.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0319a c0319a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0319a)) {
            view = LayoutInflater.from(this.gqS.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            c0319a = new C0319a();
            c0319a.gqU = (LinearLayout) view.findViewById(d.g.click_head);
            c0319a.gqW = (ImageView) view.findViewById(d.g.diver_top);
            c0319a.gqX = (ImageView) view.findViewById(d.g.diver_buttom_px);
            c0319a.gqY = (ImageView) view.findViewById(d.g.diver_top_px);
            c0319a.gjd = (GroupImageView) view.findViewById(d.g.item_head);
            c0319a.gje = (TextView) view.findViewById(d.g.item_group_name);
            c0319a.gjg = (TextView) view.findViewById(d.g.item_group_num);
            c0319a.gjh = (TextView) view.findViewById(d.g.item_introduce);
            c0319a.gqV = (TextView) view.findViewById(d.g.isCreator);
            c0319a.gji = (ImageView) view.findViewById(d.g.item_grade1);
            c0319a.gjj = (ImageView) view.findViewById(d.g.item_grade2);
            c0319a.gjk = (ImageView) view.findViewById(d.g.item_grade3);
            c0319a.gjl = new ImageView[4];
            c0319a.gjl[1] = c0319a.gji;
            c0319a.gjl[2] = c0319a.gjj;
            c0319a.gjl[3] = c0319a.gjk;
            view.setTag(c0319a);
        } else {
            c0319a = (C0319a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gqT.get(i);
        c0319a.gjd.setTag(null);
        c0319a.gjd.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0319a.gjd.startLoad(portrait, 10, false);
            } else {
                c0319a.gjd.startLoad("", 10, false);
            }
            c0319a.gqU.setOnClickListener(this.gqS);
            c0319a.gqU.setTag(groupInfoData);
            c0319a.gqW.setVisibility(8);
            c0319a.gqY.setVisibility(8);
            c0319a.gqX.setVisibility(0);
            c0319a.gje.setText(groupInfoData.getName());
            c0319a.gjg.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0319a.gjh.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0319a.gqV.setVisibility(0);
            } else {
                c0319a.gqV.setVisibility(8);
            }
            a(c0319a.gjl, groupInfoData.getGrade());
        }
        this.gqS.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gqS.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            al.d(c0319a.gje, d.C0277d.common_color_10009, 1);
            al.c(c0319a.gji, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.gjj, d.f.icon_vip_grade_big_small_s);
            al.c(c0319a.gjk, d.f.icon_vip_grade_big_small_s);
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
        GroupImageView gjd;
        TextView gje;
        TextView gjg;
        TextView gjh;
        ImageView gji;
        ImageView gjj;
        ImageView gjk;
        ImageView[] gjl;
        LinearLayout gqU;
        TextView gqV;
        ImageView gqW;
        ImageView gqX;
        ImageView gqY;

        C0319a() {
        }
    }
}
