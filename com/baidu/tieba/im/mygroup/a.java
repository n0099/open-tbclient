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
/* loaded from: classes13.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment itm;
    private List<GroupInfoData> itn = new ArrayList();

    public void dp(List<GroupInfoData> list) {
        this.itn = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.itm = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.itn.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: xw */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.itn.size()) {
            return null;
        }
        return this.itn.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0572a c0572a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0572a)) {
            view = LayoutInflater.from(this.itm.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0572a = new C0572a();
            c0572a.ito = (LinearLayout) view.findViewById(R.id.click_head);
            c0572a.itq = (ImageView) view.findViewById(R.id.diver_top);
            c0572a.itr = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0572a.its = (ImageView) view.findViewById(R.id.diver_top_px);
            c0572a.ilq = (GroupImageView) view.findViewById(R.id.item_head);
            c0572a.ilr = (TextView) view.findViewById(R.id.item_group_name);
            c0572a.ilt = (TextView) view.findViewById(R.id.item_group_num);
            c0572a.ilu = (TextView) view.findViewById(R.id.item_introduce);
            c0572a.itp = (TextView) view.findViewById(R.id.isCreator);
            c0572a.ilv = (ImageView) view.findViewById(R.id.item_grade1);
            c0572a.ilw = (ImageView) view.findViewById(R.id.item_grade2);
            c0572a.ilx = (ImageView) view.findViewById(R.id.item_grade3);
            c0572a.ily = new ImageView[4];
            c0572a.ily[1] = c0572a.ilv;
            c0572a.ily[2] = c0572a.ilw;
            c0572a.ily[3] = c0572a.ilx;
            view.setTag(c0572a);
        } else {
            c0572a = (C0572a) view.getTag();
        }
        GroupInfoData groupInfoData = this.itn.get(i);
        c0572a.ilq.setTag(null);
        c0572a.ilq.setDrawBorder(true);
        c0572a.ilq.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0572a.ilq.startLoad(portrait, 10, false);
            } else {
                c0572a.ilq.startLoad("", 10, false);
            }
            c0572a.ito.setOnClickListener(this.itm);
            c0572a.ito.setTag(groupInfoData);
            c0572a.itq.setVisibility(8);
            c0572a.its.setVisibility(8);
            c0572a.itr.setVisibility(0);
            c0572a.ilr.setText(groupInfoData.getName());
            c0572a.ilt.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0572a.ilu.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0572a.itp.setVisibility(0);
            } else {
                c0572a.itp.setVisibility(8);
            }
            a(c0572a.ily, groupInfoData.getGrade());
        }
        this.itm.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.itm.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0572a.ilr, R.color.common_color_10009, 1);
            am.setImageResource(c0572a.ilv, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0572a.ilw, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0572a.ilx, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes13.dex */
    static class C0572a {
        GroupImageView ilq;
        TextView ilr;
        TextView ilt;
        TextView ilu;
        ImageView ilv;
        ImageView ilw;
        ImageView ilx;
        ImageView[] ily;
        LinearLayout ito;
        TextView itp;
        ImageView itq;
        ImageView itr;
        ImageView its;

        C0572a() {
        }
    }
}
