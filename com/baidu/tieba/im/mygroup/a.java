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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kCc;
    private List<GroupInfoData> kCd = new ArrayList();

    public void eD(List<GroupInfoData> list) {
        this.kCd = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kCc = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kCd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: CS */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kCd.size()) {
            return null;
        }
        return this.kCd.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0759a c0759a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0759a)) {
            view = LayoutInflater.from(this.kCc.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0759a = new C0759a();
            c0759a.kCe = (LinearLayout) view.findViewById(R.id.click_head);
            c0759a.kCk = (ImageView) view.findViewById(R.id.diver_top);
            c0759a.kCl = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0759a.kCm = (ImageView) view.findViewById(R.id.diver_top_px);
            c0759a.kCf = (GroupImageView) view.findViewById(R.id.item_head);
            c0759a.kCg = (TextView) view.findViewById(R.id.item_group_name);
            c0759a.kCh = (TextView) view.findViewById(R.id.item_group_num);
            c0759a.kCi = (TextView) view.findViewById(R.id.item_introduce);
            c0759a.kCj = (TextView) view.findViewById(R.id.isCreator);
            c0759a.kCn = (ImageView) view.findViewById(R.id.item_grade1);
            c0759a.kCo = (ImageView) view.findViewById(R.id.item_grade2);
            c0759a.kCp = (ImageView) view.findViewById(R.id.item_grade3);
            c0759a.kCq = new ImageView[4];
            c0759a.kCq[1] = c0759a.kCn;
            c0759a.kCq[2] = c0759a.kCo;
            c0759a.kCq[3] = c0759a.kCp;
            view.setTag(c0759a);
        } else {
            c0759a = (C0759a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kCd.get(i);
        c0759a.kCf.setTag(null);
        c0759a.kCf.setDrawBorder(true);
        c0759a.kCf.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0759a.kCf.startLoad(portrait, 10, false);
            } else {
                c0759a.kCf.startLoad("", 10, false);
            }
            c0759a.kCe.setOnClickListener(this.kCc);
            c0759a.kCe.setTag(groupInfoData);
            c0759a.kCk.setVisibility(8);
            c0759a.kCm.setVisibility(8);
            c0759a.kCl.setVisibility(0);
            c0759a.kCg.setText(groupInfoData.getName());
            c0759a.kCh.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0759a.kCi.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0759a.kCj.setVisibility(0);
            } else {
                c0759a.kCj.setVisibility(8);
            }
            a(c0759a.kCq, groupInfoData.getGrade());
        }
        this.kCc.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kCc.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ao.setViewTextColor(c0759a.kCg, R.color.common_color_10009, 1);
            ao.setImageResource(c0759a.kCn, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0759a.kCo, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0759a.kCp, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes7.dex */
    static class C0759a {
        LinearLayout kCe;
        GroupImageView kCf;
        TextView kCg;
        TextView kCh;
        TextView kCi;
        TextView kCj;
        ImageView kCk;
        ImageView kCl;
        ImageView kCm;
        ImageView kCn;
        ImageView kCo;
        ImageView kCp;
        ImageView[] kCq;

        C0759a() {
        }
    }
}
