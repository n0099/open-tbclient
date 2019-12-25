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
/* loaded from: classes10.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment hCg;
    private List<GroupInfoData> hCh = new ArrayList();

    public void di(List<GroupInfoData> list) {
        this.hCh = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.hCg = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.hCh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: wF */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.hCh.size()) {
            return null;
        }
        return this.hCh.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0522a c0522a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0522a)) {
            view = LayoutInflater.from(this.hCg.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0522a = new C0522a();
            c0522a.hCi = (LinearLayout) view.findViewById(R.id.click_head);
            c0522a.hCk = (ImageView) view.findViewById(R.id.diver_top);
            c0522a.hCl = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0522a.hCm = (ImageView) view.findViewById(R.id.diver_top_px);
            c0522a.hum = (GroupImageView) view.findViewById(R.id.item_head);
            c0522a.hun = (TextView) view.findViewById(R.id.item_group_name);
            c0522a.hup = (TextView) view.findViewById(R.id.item_group_num);
            c0522a.huq = (TextView) view.findViewById(R.id.item_introduce);
            c0522a.hCj = (TextView) view.findViewById(R.id.isCreator);
            c0522a.hur = (ImageView) view.findViewById(R.id.item_grade1);
            c0522a.hus = (ImageView) view.findViewById(R.id.item_grade2);
            c0522a.hut = (ImageView) view.findViewById(R.id.item_grade3);
            c0522a.huu = new ImageView[4];
            c0522a.huu[1] = c0522a.hur;
            c0522a.huu[2] = c0522a.hus;
            c0522a.huu[3] = c0522a.hut;
            view.setTag(c0522a);
        } else {
            c0522a = (C0522a) view.getTag();
        }
        GroupInfoData groupInfoData = this.hCh.get(i);
        c0522a.hum.setTag(null);
        c0522a.hum.setDrawBorder(true);
        c0522a.hum.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0522a.hum.startLoad(portrait, 10, false);
            } else {
                c0522a.hum.startLoad("", 10, false);
            }
            c0522a.hCi.setOnClickListener(this.hCg);
            c0522a.hCi.setTag(groupInfoData);
            c0522a.hCk.setVisibility(8);
            c0522a.hCm.setVisibility(8);
            c0522a.hCl.setVisibility(0);
            c0522a.hun.setText(groupInfoData.getName());
            c0522a.hup.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0522a.huq.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0522a.hCj.setVisibility(0);
            } else {
                c0522a.hCj.setVisibility(8);
            }
            a(c0522a.huu, groupInfoData.getGrade());
        }
        this.hCg.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.hCg.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0522a.hun, R.color.common_color_10009, 1);
            am.setImageResource(c0522a.hur, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0522a.hus, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0522a.hut, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes10.dex */
    static class C0522a {
        LinearLayout hCi;
        TextView hCj;
        ImageView hCk;
        ImageView hCl;
        ImageView hCm;
        GroupImageView hum;
        TextView hun;
        TextView hup;
        TextView huq;
        ImageView hur;
        ImageView hus;
        ImageView hut;
        ImageView[] huu;

        C0522a() {
        }
    }
}
