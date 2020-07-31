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
    private PersonalGroupFragment jii;
    private List<GroupInfoData> jij = new ArrayList();

    public void dJ(List<GroupInfoData> list) {
        this.jij = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.jii = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.jij.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: zn */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.jij.size()) {
            return null;
        }
        return this.jij.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0668a c0668a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0668a)) {
            view = LayoutInflater.from(this.jii.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0668a = new C0668a();
            c0668a.jik = (LinearLayout) view.findViewById(R.id.click_head);
            c0668a.jim = (ImageView) view.findViewById(R.id.diver_top);
            c0668a.jin = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0668a.jio = (ImageView) view.findViewById(R.id.diver_top_px);
            c0668a.jag = (GroupImageView) view.findViewById(R.id.item_head);
            c0668a.jah = (TextView) view.findViewById(R.id.item_group_name);
            c0668a.jaj = (TextView) view.findViewById(R.id.item_group_num);
            c0668a.jak = (TextView) view.findViewById(R.id.item_introduce);
            c0668a.jil = (TextView) view.findViewById(R.id.isCreator);
            c0668a.jal = (ImageView) view.findViewById(R.id.item_grade1);
            c0668a.jam = (ImageView) view.findViewById(R.id.item_grade2);
            c0668a.jan = (ImageView) view.findViewById(R.id.item_grade3);
            c0668a.jao = new ImageView[4];
            c0668a.jao[1] = c0668a.jal;
            c0668a.jao[2] = c0668a.jam;
            c0668a.jao[3] = c0668a.jan;
            view.setTag(c0668a);
        } else {
            c0668a = (C0668a) view.getTag();
        }
        GroupInfoData groupInfoData = this.jij.get(i);
        c0668a.jag.setTag(null);
        c0668a.jag.setDrawBorder(true);
        c0668a.jag.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0668a.jag.startLoad(portrait, 10, false);
            } else {
                c0668a.jag.startLoad("", 10, false);
            }
            c0668a.jik.setOnClickListener(this.jii);
            c0668a.jik.setTag(groupInfoData);
            c0668a.jim.setVisibility(8);
            c0668a.jio.setVisibility(8);
            c0668a.jin.setVisibility(0);
            c0668a.jah.setText(groupInfoData.getName());
            c0668a.jaj.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0668a.jak.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0668a.jil.setVisibility(0);
            } else {
                c0668a.jil.setVisibility(8);
            }
            a(c0668a.jao, groupInfoData.getGrade());
        }
        this.jii.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.jii.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ao.setViewTextColor(c0668a.jah, R.color.common_color_10009, 1);
            ao.setImageResource(c0668a.jal, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0668a.jam, R.drawable.icon_vip_grade_big_small_s);
            ao.setImageResource(c0668a.jan, R.drawable.icon_vip_grade_big_small_s);
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
        GroupImageView jag;
        TextView jah;
        TextView jaj;
        TextView jak;
        ImageView jal;
        ImageView jam;
        ImageView jan;
        ImageView[] jao;
        LinearLayout jik;
        TextView jil;
        ImageView jim;
        ImageView jin;
        ImageView jio;

        C0668a() {
        }
    }
}
