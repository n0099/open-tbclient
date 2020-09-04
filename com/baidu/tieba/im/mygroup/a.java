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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment jxp;
    private List<GroupInfoData> jxq = new ArrayList();

    public void dQ(List<GroupInfoData> list) {
        this.jxq = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jxp = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jxq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BG */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jxq.size()) {
            return null;
        }
        return this.jxq.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0720a c0720a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0720a)) {
            view = LayoutInflater.from(this.jxp.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0720a = new C0720a();
            c0720a.jxr = (LinearLayout) view.findViewById(R.id.click_head);
            c0720a.jxt = (ImageView) view.findViewById(R.id.diver_top);
            c0720a.jxu = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0720a.jxv = (ImageView) view.findViewById(R.id.diver_top_px);
            c0720a.jpo = (GroupImageView) view.findViewById(R.id.item_head);
            c0720a.jpp = (TextView) view.findViewById(R.id.item_group_name);
            c0720a.jpr = (TextView) view.findViewById(R.id.item_group_num);
            c0720a.jps = (TextView) view.findViewById(R.id.item_introduce);
            c0720a.jxs = (TextView) view.findViewById(R.id.isCreator);
            c0720a.jpt = (ImageView) view.findViewById(R.id.item_grade1);
            c0720a.jpu = (ImageView) view.findViewById(R.id.item_grade2);
            c0720a.jpv = (ImageView) view.findViewById(R.id.item_grade3);
            c0720a.jpw = new ImageView[4];
            c0720a.jpw[1] = c0720a.jpt;
            c0720a.jpw[2] = c0720a.jpu;
            c0720a.jpw[3] = c0720a.jpv;
            view.setTag(c0720a);
        } else {
            c0720a = (C0720a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jxq.get(i);
        c0720a.jpo.setTag(null);
        c0720a.jpo.setDrawBorder(true);
        c0720a.jpo.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0720a.jpo.startLoad(portrait, 10, false);
            } else {
                c0720a.jpo.startLoad("", 10, false);
            }
            c0720a.jxr.setOnClickListener(this.jxp);
            c0720a.jxr.setTag(groupInfoData);
            c0720a.jxt.setVisibility(8);
            c0720a.jxv.setVisibility(8);
            c0720a.jxu.setVisibility(0);
            c0720a.jpp.setText(groupInfoData.getName());
            c0720a.jpr.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0720a.jps.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0720a.jxs.setVisibility(0);
            } else {
                c0720a.jxs.setVisibility(8);
            }
            a(c0720a.jpw, groupInfoData.getGrade());
        }
        this.jxp.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jxp.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0720a.jpp, R.color.common_color_10009, 1);
            ap.setImageResource(c0720a.jpt, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0720a.jpu, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0720a.jpv, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes20.dex */
    static class C0720a {
        GroupImageView jpo;
        TextView jpp;
        TextView jpr;
        TextView jps;
        ImageView jpt;
        ImageView jpu;
        ImageView jpv;
        ImageView[] jpw;
        LinearLayout jxr;
        TextView jxs;
        ImageView jxt;
        ImageView jxu;
        ImageView jxv;

        C0720a() {
        }
    }
}
