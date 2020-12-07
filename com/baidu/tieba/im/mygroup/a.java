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
    private PersonalGroupFragment kBr;
    private List<GroupInfoData> kBs = new ArrayList();

    public void eD(List<GroupInfoData> list) {
        this.kBs = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.kBr = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.kBs.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: EG */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.kBs.size()) {
            return null;
        }
        return this.kBs.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0783a c0783a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0783a)) {
            view = LayoutInflater.from(this.kBr.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0783a = new C0783a();
            c0783a.kBt = (LinearLayout) view.findViewById(R.id.click_head);
            c0783a.kBv = (ImageView) view.findViewById(R.id.diver_top);
            c0783a.kBw = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0783a.kBx = (ImageView) view.findViewById(R.id.diver_top_px);
            c0783a.kts = (GroupImageView) view.findViewById(R.id.item_head);
            c0783a.ktt = (TextView) view.findViewById(R.id.item_group_name);
            c0783a.ktv = (TextView) view.findViewById(R.id.item_group_num);
            c0783a.ktw = (TextView) view.findViewById(R.id.item_introduce);
            c0783a.kBu = (TextView) view.findViewById(R.id.isCreator);
            c0783a.ktx = (ImageView) view.findViewById(R.id.item_grade1);
            c0783a.kty = (ImageView) view.findViewById(R.id.item_grade2);
            c0783a.ktz = (ImageView) view.findViewById(R.id.item_grade3);
            c0783a.ktA = new ImageView[4];
            c0783a.ktA[1] = c0783a.ktx;
            c0783a.ktA[2] = c0783a.kty;
            c0783a.ktA[3] = c0783a.ktz;
            view.setTag(c0783a);
        } else {
            c0783a = (C0783a) view.getTag();
        }
        GroupInfoData groupInfoData = this.kBs.get(i);
        c0783a.kts.setTag(null);
        c0783a.kts.setDrawBorder(true);
        c0783a.kts.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0783a.kts.startLoad(portrait, 10, false);
            } else {
                c0783a.kts.startLoad("", 10, false);
            }
            c0783a.kBt.setOnClickListener(this.kBr);
            c0783a.kBt.setTag(groupInfoData);
            c0783a.kBv.setVisibility(8);
            c0783a.kBx.setVisibility(8);
            c0783a.kBw.setVisibility(0);
            c0783a.ktt.setText(groupInfoData.getName());
            c0783a.ktv.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0783a.ktw.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0783a.kBu.setVisibility(0);
            } else {
                c0783a.kBu.setVisibility(8);
            }
            a(c0783a.ktA, groupInfoData.getGrade());
        }
        this.kBr.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.kBr.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0783a.ktt, R.color.common_color_10009, 1);
            ap.setImageResource(c0783a.ktx, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0783a.kty, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0783a.ktz, R.drawable.icon_vip_grade_big_small_s);
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
        LinearLayout kBt;
        TextView kBu;
        ImageView kBv;
        ImageView kBw;
        ImageView kBx;
        ImageView[] ktA;
        GroupImageView kts;
        TextView ktt;
        TextView ktv;
        TextView ktw;
        ImageView ktx;
        ImageView kty;
        ImageView ktz;

        C0783a() {
        }
    }
}
