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
    private PersonalGroupFragment jxj;
    private List<GroupInfoData> jxk = new ArrayList();

    public void dQ(List<GroupInfoData> list) {
        this.jxk = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jxj = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jxk.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: BG */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jxk.size()) {
            return null;
        }
        return this.jxk.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0720a c0720a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0720a)) {
            view = LayoutInflater.from(this.jxj.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0720a = new C0720a();
            c0720a.jxl = (LinearLayout) view.findViewById(R.id.click_head);
            c0720a.jxn = (ImageView) view.findViewById(R.id.diver_top);
            c0720a.jxo = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0720a.jxp = (ImageView) view.findViewById(R.id.diver_top_px);
            c0720a.jpi = (GroupImageView) view.findViewById(R.id.item_head);
            c0720a.jpj = (TextView) view.findViewById(R.id.item_group_name);
            c0720a.jpl = (TextView) view.findViewById(R.id.item_group_num);
            c0720a.jpm = (TextView) view.findViewById(R.id.item_introduce);
            c0720a.jxm = (TextView) view.findViewById(R.id.isCreator);
            c0720a.jpn = (ImageView) view.findViewById(R.id.item_grade1);
            c0720a.jpo = (ImageView) view.findViewById(R.id.item_grade2);
            c0720a.jpp = (ImageView) view.findViewById(R.id.item_grade3);
            c0720a.jpq = new ImageView[4];
            c0720a.jpq[1] = c0720a.jpn;
            c0720a.jpq[2] = c0720a.jpo;
            c0720a.jpq[3] = c0720a.jpp;
            view.setTag(c0720a);
        } else {
            c0720a = (C0720a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jxk.get(i);
        c0720a.jpi.setTag(null);
        c0720a.jpi.setDrawBorder(true);
        c0720a.jpi.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0720a.jpi.startLoad(portrait, 10, false);
            } else {
                c0720a.jpi.startLoad("", 10, false);
            }
            c0720a.jxl.setOnClickListener(this.jxj);
            c0720a.jxl.setTag(groupInfoData);
            c0720a.jxn.setVisibility(8);
            c0720a.jxp.setVisibility(8);
            c0720a.jxo.setVisibility(0);
            c0720a.jpj.setText(groupInfoData.getName());
            c0720a.jpl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0720a.jpm.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0720a.jxm.setVisibility(0);
            } else {
                c0720a.jxm.setVisibility(8);
            }
            a(c0720a.jpq, groupInfoData.getGrade());
        }
        this.jxj.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jxj.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0720a.jpj, R.color.common_color_10009, 1);
            ap.setImageResource(c0720a.jpn, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0720a.jpo, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0720a.jpp, R.drawable.icon_vip_grade_big_small_s);
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
        GroupImageView jpi;
        TextView jpj;
        TextView jpl;
        TextView jpm;
        ImageView jpn;
        ImageView jpo;
        ImageView jpp;
        ImageView[] jpq;
        LinearLayout jxl;
        TextView jxm;
        ImageView jxn;
        ImageView jxo;
        ImageView jxp;

        C0720a() {
        }
    }
}
