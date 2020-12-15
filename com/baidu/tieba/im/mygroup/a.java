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
    private PersonalGroupFragment kBt;
    private List<GroupInfoData> kBu = new ArrayList();

    public void eD(List<GroupInfoData> list) {
        this.kBu = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kBt = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kBu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EG */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kBu.size()) {
            return null;
        }
        return this.kBu.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0783a c0783a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0783a)) {
            view = LayoutInflater.from(this.kBt.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0783a = new C0783a();
            c0783a.kBv = (LinearLayout) view.findViewById(R.id.click_head);
            c0783a.kBx = (ImageView) view.findViewById(R.id.diver_top);
            c0783a.kBy = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0783a.kBz = (ImageView) view.findViewById(R.id.diver_top_px);
            c0783a.ktu = (GroupImageView) view.findViewById(R.id.item_head);
            c0783a.ktv = (TextView) view.findViewById(R.id.item_group_name);
            c0783a.ktx = (TextView) view.findViewById(R.id.item_group_num);
            c0783a.kty = (TextView) view.findViewById(R.id.item_introduce);
            c0783a.kBw = (TextView) view.findViewById(R.id.isCreator);
            c0783a.ktz = (ImageView) view.findViewById(R.id.item_grade1);
            c0783a.ktA = (ImageView) view.findViewById(R.id.item_grade2);
            c0783a.ktB = (ImageView) view.findViewById(R.id.item_grade3);
            c0783a.ktC = new ImageView[4];
            c0783a.ktC[1] = c0783a.ktz;
            c0783a.ktC[2] = c0783a.ktA;
            c0783a.ktC[3] = c0783a.ktB;
            view.setTag(c0783a);
        } else {
            c0783a = (C0783a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kBu.get(i);
        c0783a.ktu.setTag(null);
        c0783a.ktu.setDrawBorder(true);
        c0783a.ktu.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0783a.ktu.startLoad(portrait, 10, false);
            } else {
                c0783a.ktu.startLoad("", 10, false);
            }
            c0783a.kBv.setOnClickListener(this.kBt);
            c0783a.kBv.setTag(groupInfoData);
            c0783a.kBx.setVisibility(8);
            c0783a.kBz.setVisibility(8);
            c0783a.kBy.setVisibility(0);
            c0783a.ktv.setText(groupInfoData.getName());
            c0783a.ktx.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0783a.kty.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0783a.kBw.setVisibility(0);
            } else {
                c0783a.kBw.setVisibility(8);
            }
            a(c0783a.ktC, groupInfoData.getGrade());
        }
        this.kBt.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kBt.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0783a.ktv, R.color.common_color_10009, 1);
            ap.setImageResource(c0783a.ktz, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0783a.ktA, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0783a.ktB, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0783a {
        LinearLayout kBv;
        TextView kBw;
        ImageView kBx;
        ImageView kBy;
        ImageView kBz;
        ImageView ktA;
        ImageView ktB;
        ImageView[] ktC;
        GroupImageView ktu;
        TextView ktv;
        TextView ktx;
        TextView kty;
        ImageView ktz;

        C0783a() {
        }
    }
}
