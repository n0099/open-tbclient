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
/* loaded from: classes3.dex */
public class a extends BaseAdapter {
    private PersonalGroupFragment gOc;
    private List<GroupInfoData> gOd = new ArrayList();

    public void dt(List<GroupInfoData> list) {
        this.gOd = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gOc = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gOd.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: uD */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gOd.size()) {
            return null;
        }
        return this.gOd.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0436a c0436a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0436a)) {
            view = LayoutInflater.from(this.gOc.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0436a = new C0436a();
            c0436a.gOe = (LinearLayout) view.findViewById(R.id.click_head);
            c0436a.gOg = (ImageView) view.findViewById(R.id.diver_top);
            c0436a.gOh = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0436a.gOi = (ImageView) view.findViewById(R.id.diver_top_px);
            c0436a.gGi = (GroupImageView) view.findViewById(R.id.item_head);
            c0436a.gGj = (TextView) view.findViewById(R.id.item_group_name);
            c0436a.gGl = (TextView) view.findViewById(R.id.item_group_num);
            c0436a.gGm = (TextView) view.findViewById(R.id.item_introduce);
            c0436a.gOf = (TextView) view.findViewById(R.id.isCreator);
            c0436a.gGn = (ImageView) view.findViewById(R.id.item_grade1);
            c0436a.gGo = (ImageView) view.findViewById(R.id.item_grade2);
            c0436a.gGp = (ImageView) view.findViewById(R.id.item_grade3);
            c0436a.gGq = new ImageView[4];
            c0436a.gGq[1] = c0436a.gGn;
            c0436a.gGq[2] = c0436a.gGo;
            c0436a.gGq[3] = c0436a.gGp;
            view.setTag(c0436a);
        } else {
            c0436a = (C0436a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gOd.get(i);
        c0436a.gGi.setTag(null);
        c0436a.gGi.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0436a.gGi.startLoad(portrait, 10, false);
            } else {
                c0436a.gGi.startLoad("", 10, false);
            }
            c0436a.gOe.setOnClickListener(this.gOc);
            c0436a.gOe.setTag(groupInfoData);
            c0436a.gOg.setVisibility(8);
            c0436a.gOi.setVisibility(8);
            c0436a.gOh.setVisibility(0);
            c0436a.gGj.setText(groupInfoData.getName());
            c0436a.gGl.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0436a.gGm.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0436a.gOf.setVisibility(0);
            } else {
                c0436a.gOf.setVisibility(8);
            }
            a(c0436a.gGq, groupInfoData.getGrade());
        }
        this.gOc.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gOc.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.setViewTextColor(c0436a.gGj, R.color.common_color_10009, 1);
            am.setImageResource(c0436a.gGn, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0436a.gGo, R.drawable.icon_vip_grade_big_small_s);
            am.setImageResource(c0436a.gGp, R.drawable.icon_vip_grade_big_small_s);
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
    /* loaded from: classes3.dex */
    static class C0436a {
        GroupImageView gGi;
        TextView gGj;
        TextView gGl;
        TextView gGm;
        ImageView gGn;
        ImageView gGo;
        ImageView gGp;
        ImageView[] gGq;
        LinearLayout gOe;
        TextView gOf;
        ImageView gOg;
        ImageView gOh;
        ImageView gOi;

        C0436a() {
        }
    }
}
