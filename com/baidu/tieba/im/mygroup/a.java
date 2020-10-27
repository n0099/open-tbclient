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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes26.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kho;
    private List<GroupInfoData> khp = new ArrayList();

    public void ek(List<GroupInfoData> list) {
        this.khp = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kho = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.khp.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dg */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.khp.size()) {
            return null;
        }
        return this.khp.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0751a c0751a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0751a)) {
            view = LayoutInflater.from(this.kho.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0751a = new C0751a();
            c0751a.khq = (LinearLayout) view.findViewById(R.id.click_head);
            c0751a.khs = (ImageView) view.findViewById(R.id.diver_top);
            c0751a.kht = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0751a.khu = (ImageView) view.findViewById(R.id.diver_top_px);
            c0751a.jZm = (GroupImageView) view.findViewById(R.id.item_head);
            c0751a.jZn = (TextView) view.findViewById(R.id.item_group_name);
            c0751a.jZp = (TextView) view.findViewById(R.id.item_group_num);
            c0751a.jZq = (TextView) view.findViewById(R.id.item_introduce);
            c0751a.khr = (TextView) view.findViewById(R.id.isCreator);
            c0751a.jZr = (ImageView) view.findViewById(R.id.item_grade1);
            c0751a.jZs = (ImageView) view.findViewById(R.id.item_grade2);
            c0751a.jZt = (ImageView) view.findViewById(R.id.item_grade3);
            c0751a.jZu = new ImageView[4];
            c0751a.jZu[1] = c0751a.jZr;
            c0751a.jZu[2] = c0751a.jZs;
            c0751a.jZu[3] = c0751a.jZt;
            view.setTag(c0751a);
        } else {
            c0751a = (C0751a) view.getTag();
        }
        GroupInfoData groupInfoData = this.khp.get(i);
        c0751a.jZm.setTag(null);
        c0751a.jZm.setDrawBorder(true);
        c0751a.jZm.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0751a.jZm.startLoad(portrait, 10, false);
            } else {
                c0751a.jZm.startLoad("", 10, false);
            }
            c0751a.khq.setOnClickListener(this.kho);
            c0751a.khq.setTag(groupInfoData);
            c0751a.khs.setVisibility(8);
            c0751a.khu.setVisibility(8);
            c0751a.kht.setVisibility(0);
            c0751a.jZn.setText(groupInfoData.getName());
            c0751a.jZp.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0751a.jZq.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0751a.khr.setVisibility(0);
            } else {
                c0751a.khr.setVisibility(8);
            }
            a(c0751a.jZu, groupInfoData.getGrade());
        }
        this.kho.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kho.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0751a.jZn, R.color.common_color_10009, 1);
            ap.setImageResource(c0751a.jZr, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0751a.jZs, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0751a.jZt, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes26.dex */
    static class C0751a {
        GroupImageView jZm;
        TextView jZn;
        TextView jZp;
        TextView jZq;
        ImageView jZr;
        ImageView jZs;
        ImageView jZt;
        ImageView[] jZu;
        LinearLayout khq;
        TextView khr;
        ImageView khs;
        ImageView kht;
        ImageView khu;

        C0751a() {
        }
    }
}
