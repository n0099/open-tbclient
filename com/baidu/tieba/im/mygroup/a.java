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
    private PersonalGroupFragment gQS;
    private List<GroupInfoData> gQT = new ArrayList();

    public void dg(List<GroupInfoData> list) {
        this.gQT = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gQS = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gQT.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vY */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gQT.size()) {
            return null;
        }
        return this.gQT.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0352a c0352a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0352a)) {
            view = LayoutInflater.from(this.gQS.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0352a = new C0352a();
            c0352a.gQU = (LinearLayout) view.findViewById(R.id.click_head);
            c0352a.gQW = (ImageView) view.findViewById(R.id.diver_top);
            c0352a.gQX = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0352a.gQY = (ImageView) view.findViewById(R.id.diver_top_px);
            c0352a.gJb = (GroupImageView) view.findViewById(R.id.item_head);
            c0352a.gJc = (TextView) view.findViewById(R.id.item_group_name);
            c0352a.gJe = (TextView) view.findViewById(R.id.item_group_num);
            c0352a.gJf = (TextView) view.findViewById(R.id.item_introduce);
            c0352a.gQV = (TextView) view.findViewById(R.id.isCreator);
            c0352a.gJg = (ImageView) view.findViewById(R.id.item_grade1);
            c0352a.gJh = (ImageView) view.findViewById(R.id.item_grade2);
            c0352a.gJi = (ImageView) view.findViewById(R.id.item_grade3);
            c0352a.gJj = new ImageView[4];
            c0352a.gJj[1] = c0352a.gJg;
            c0352a.gJj[2] = c0352a.gJh;
            c0352a.gJj[3] = c0352a.gJi;
            view.setTag(c0352a);
        } else {
            c0352a = (C0352a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gQT.get(i);
        c0352a.gJb.setTag(null);
        c0352a.gJb.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0352a.gJb.startLoad(portrait, 10, false);
            } else {
                c0352a.gJb.startLoad("", 10, false);
            }
            c0352a.gQU.setOnClickListener(this.gQS);
            c0352a.gQU.setTag(groupInfoData);
            c0352a.gQW.setVisibility(8);
            c0352a.gQY.setVisibility(8);
            c0352a.gQX.setVisibility(0);
            c0352a.gJc.setText(groupInfoData.getName());
            c0352a.gJe.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0352a.gJf.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0352a.gQV.setVisibility(0);
            } else {
                c0352a.gQV.setVisibility(8);
            }
            a(c0352a.gJj, groupInfoData.getGrade());
        }
        this.gQS.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gQS.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.f(c0352a.gJc, R.color.common_color_10009, 1);
            am.c(c0352a.gJg, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0352a.gJh, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0352a.gJi, (int) R.drawable.icon_vip_grade_big_small_s);
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
    static class C0352a {
        GroupImageView gJb;
        TextView gJc;
        TextView gJe;
        TextView gJf;
        ImageView gJg;
        ImageView gJh;
        ImageView gJi;
        ImageView[] gJj;
        LinearLayout gQU;
        TextView gQV;
        ImageView gQW;
        ImageView gQX;
        ImageView gQY;

        C0352a() {
        }
    }
}
