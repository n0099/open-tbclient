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
/* loaded from: classes20.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment jik;
    private List<GroupInfoData> jil = new ArrayList();

    public void dJ(List<GroupInfoData> list) {
        this.jil = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jik = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jil.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zn */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jil.size()) {
            return null;
        }
        return this.jil.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0668a c0668a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0668a)) {
            view = LayoutInflater.from(this.jik.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0668a = new C0668a();
            c0668a.jim = (LinearLayout) view.findViewById(R.id.click_head);
            c0668a.jio = (ImageView) view.findViewById(R.id.diver_top);
            c0668a.jip = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0668a.jiq = (ImageView) view.findViewById(R.id.diver_top_px);
            c0668a.jai = (GroupImageView) view.findViewById(R.id.item_head);
            c0668a.jaj = (TextView) view.findViewById(R.id.item_group_name);
            c0668a.jal = (TextView) view.findViewById(R.id.item_group_num);
            c0668a.jam = (TextView) view.findViewById(R.id.item_introduce);
            c0668a.jin = (TextView) view.findViewById(R.id.isCreator);
            c0668a.jan = (ImageView) view.findViewById(R.id.item_grade1);
            c0668a.jao = (ImageView) view.findViewById(R.id.item_grade2);
            c0668a.jap = (ImageView) view.findViewById(R.id.item_grade3);
            c0668a.jaq = new ImageView[4];
            c0668a.jaq[1] = c0668a.jan;
            c0668a.jaq[2] = c0668a.jao;
            c0668a.jaq[3] = c0668a.jap;
            view.setTag(c0668a);
        } else {
            c0668a = (C0668a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jil.get(i);
        c0668a.jai.setTag(null);
        c0668a.jai.setDrawBorder(true);
        c0668a.jai.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0668a.jai.startLoad(portrait, 10, false);
            } else {
                c0668a.jai.startLoad("", 10, false);
            }
            c0668a.jim.setOnClickListener(this.jik);
            c0668a.jim.setTag(groupInfoData);
            c0668a.jio.setVisibility(8);
            c0668a.jiq.setVisibility(8);
            c0668a.jip.setVisibility(0);
            c0668a.jaj.setText(groupInfoData.getName());
            c0668a.jal.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0668a.jam.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0668a.jin.setVisibility(0);
            } else {
                c0668a.jin.setVisibility(8);
            }
            a(c0668a.jaq, groupInfoData.getGrade());
        }
        this.jik.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jik.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ao.setViewTextColor(c0668a.jaj, R.color.common_color_10009, 1);
            ao.setImageResource(c0668a.jan, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0668a.jao, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0668a.jap, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0668a {
        GroupImageView jai;
        TextView jaj;
        TextView jal;
        TextView jam;
        ImageView jan;
        ImageView jao;
        ImageView jap;
        ImageView[] jaq;
        LinearLayout jim;
        TextView jin;
        ImageView jio;
        ImageView jip;
        ImageView jiq;

        C0668a() {
        }
    }
}
