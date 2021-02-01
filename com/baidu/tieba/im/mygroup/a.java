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
/* loaded from: classes8.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment kKh;
    private List<GroupInfoData> kKi = new ArrayList();

    public void eB(List<GroupInfoData> list) {
        this.kKi = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kKh = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kKi.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dk */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kKi.size()) {
            return null;
        }
        return this.kKi.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0761a c0761a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0761a)) {
            view = LayoutInflater.from(this.kKh.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0761a = new C0761a();
            c0761a.kKj = (LinearLayout) view.findViewById(R.id.click_head);
            c0761a.kKp = (ImageView) view.findViewById(R.id.diver_top);
            c0761a.kKq = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0761a.kKr = (ImageView) view.findViewById(R.id.diver_top_px);
            c0761a.kKk = (GroupImageView) view.findViewById(R.id.item_head);
            c0761a.kKl = (TextView) view.findViewById(R.id.item_group_name);
            c0761a.kKm = (TextView) view.findViewById(R.id.item_group_num);
            c0761a.kKn = (TextView) view.findViewById(R.id.item_introduce);
            c0761a.kKo = (TextView) view.findViewById(R.id.isCreator);
            c0761a.kKs = (ImageView) view.findViewById(R.id.item_grade1);
            c0761a.kKt = (ImageView) view.findViewById(R.id.item_grade2);
            c0761a.kKu = (ImageView) view.findViewById(R.id.item_grade3);
            c0761a.kKv = new ImageView[4];
            c0761a.kKv[1] = c0761a.kKs;
            c0761a.kKv[2] = c0761a.kKt;
            c0761a.kKv[3] = c0761a.kKu;
            view.setTag(c0761a);
        } else {
            c0761a = (C0761a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kKi.get(i);
        c0761a.kKk.setTag(null);
        c0761a.kKk.setDrawBorder(true);
        c0761a.kKk.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0761a.kKk.startLoad(portrait, 10, false);
            } else {
                c0761a.kKk.startLoad("", 10, false);
            }
            c0761a.kKj.setOnClickListener(this.kKh);
            c0761a.kKj.setTag(groupInfoData);
            c0761a.kKp.setVisibility(8);
            c0761a.kKr.setVisibility(8);
            c0761a.kKq.setVisibility(0);
            c0761a.kKl.setText(groupInfoData.getName());
            c0761a.kKm.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0761a.kKn.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0761a.kKo.setVisibility(0);
            } else {
                c0761a.kKo.setVisibility(8);
            }
            a(c0761a.kKv, groupInfoData.getGrade());
        }
        this.kKh.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kKh.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0761a.kKl, R.color.common_color_10009, 1);
            ap.setImageResource(c0761a.kKs, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0761a.kKt, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0761a.kKu, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes8.dex */
    static class C0761a {
        LinearLayout kKj;
        GroupImageView kKk;
        TextView kKl;
        TextView kKm;
        TextView kKn;
        TextView kKo;
        ImageView kKp;
        ImageView kKq;
        ImageView kKr;
        ImageView kKs;
        ImageView kKt;
        ImageView kKu;
        ImageView[] kKv;

        C0761a() {
        }
    }
}
