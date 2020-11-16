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
/* loaded from: classes25.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment knV;
    private List<GroupInfoData> knW = new ArrayList();

    public void es(List<GroupInfoData> list) {
        this.knW = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.knV = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.knW.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: DR */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.knW.size()) {
            return null;
        }
        return this.knW.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0767a c0767a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0767a)) {
            view = LayoutInflater.from(this.knV.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0767a = new C0767a();
            c0767a.knX = (LinearLayout) view.findViewById(R.id.click_head);
            c0767a.knZ = (ImageView) view.findViewById(R.id.diver_top);
            c0767a.koa = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0767a.kob = (ImageView) view.findViewById(R.id.diver_top_px);
            c0767a.kfU = (GroupImageView) view.findViewById(R.id.item_head);
            c0767a.kfV = (TextView) view.findViewById(R.id.item_group_name);
            c0767a.kfX = (TextView) view.findViewById(R.id.item_group_num);
            c0767a.kfY = (TextView) view.findViewById(R.id.item_introduce);
            c0767a.knY = (TextView) view.findViewById(R.id.isCreator);
            c0767a.kfZ = (ImageView) view.findViewById(R.id.item_grade1);
            c0767a.kga = (ImageView) view.findViewById(R.id.item_grade2);
            c0767a.kgb = (ImageView) view.findViewById(R.id.item_grade3);
            c0767a.kgc = new ImageView[4];
            c0767a.kgc[1] = c0767a.kfZ;
            c0767a.kgc[2] = c0767a.kga;
            c0767a.kgc[3] = c0767a.kgb;
            view.setTag(c0767a);
        } else {
            c0767a = (C0767a) view.getTag();
        }
        GroupInfoData groupInfoData = this.knW.get(i);
        c0767a.kfU.setTag(null);
        c0767a.kfU.setDrawBorder(true);
        c0767a.kfU.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0767a.kfU.startLoad(portrait, 10, false);
            } else {
                c0767a.kfU.startLoad("", 10, false);
            }
            c0767a.knX.setOnClickListener(this.knV);
            c0767a.knX.setTag(groupInfoData);
            c0767a.knZ.setVisibility(8);
            c0767a.kob.setVisibility(8);
            c0767a.koa.setVisibility(0);
            c0767a.kfV.setText(groupInfoData.getName());
            c0767a.kfX.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0767a.kfY.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0767a.knY.setVisibility(0);
            } else {
                c0767a.knY.setVisibility(8);
            }
            a(c0767a.kgc, groupInfoData.getGrade());
        }
        this.knV.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.knV.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0767a.kfV, R.color.common_color_10009, 1);
            ap.setImageResource(c0767a.kfZ, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0767a.kga, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0767a.kgb, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes25.dex */
    static class C0767a {
        GroupImageView kfU;
        TextView kfV;
        TextView kfX;
        TextView kfY;
        ImageView kfZ;
        ImageView kga;
        ImageView kgb;
        ImageView[] kgc;
        LinearLayout knX;
        TextView knY;
        ImageView knZ;
        ImageView koa;
        ImageView kob;

        C0767a() {
        }
    }
}
