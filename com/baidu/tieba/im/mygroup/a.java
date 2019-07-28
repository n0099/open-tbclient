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
    private PersonalGroupFragment gOg;
    private List<GroupInfoData> gOh = new ArrayList();

    public void dh(List<GroupInfoData> list) {
        this.gOh = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.gOg = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.gOh.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: vS */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.gOh.size()) {
            return null;
        }
        return this.gOh.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0341a c0341a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0341a)) {
            view = LayoutInflater.from(this.gOg.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0341a = new C0341a();
            c0341a.gOi = (LinearLayout) view.findViewById(R.id.click_head);
            c0341a.gOk = (ImageView) view.findViewById(R.id.diver_top);
            c0341a.gOl = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0341a.gOm = (ImageView) view.findViewById(R.id.diver_top_px);
            c0341a.gGr = (GroupImageView) view.findViewById(R.id.item_head);
            c0341a.gGs = (TextView) view.findViewById(R.id.item_group_name);
            c0341a.gGu = (TextView) view.findViewById(R.id.item_group_num);
            c0341a.gGv = (TextView) view.findViewById(R.id.item_introduce);
            c0341a.gOj = (TextView) view.findViewById(R.id.isCreator);
            c0341a.gGw = (ImageView) view.findViewById(R.id.item_grade1);
            c0341a.gGx = (ImageView) view.findViewById(R.id.item_grade2);
            c0341a.gGy = (ImageView) view.findViewById(R.id.item_grade3);
            c0341a.gGz = new ImageView[4];
            c0341a.gGz[1] = c0341a.gGw;
            c0341a.gGz[2] = c0341a.gGx;
            c0341a.gGz[3] = c0341a.gGy;
            view.setTag(c0341a);
        } else {
            c0341a = (C0341a) view.getTag();
        }
        GroupInfoData groupInfoData = this.gOh.get(i);
        c0341a.gGr.setTag(null);
        c0341a.gGr.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0341a.gGr.startLoad(portrait, 10, false);
            } else {
                c0341a.gGr.startLoad("", 10, false);
            }
            c0341a.gOi.setOnClickListener(this.gOg);
            c0341a.gOi.setTag(groupInfoData);
            c0341a.gOk.setVisibility(8);
            c0341a.gOm.setVisibility(8);
            c0341a.gOl.setVisibility(0);
            c0341a.gGs.setText(groupInfoData.getName());
            c0341a.gGu.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0341a.gGv.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0341a.gOj.setVisibility(0);
            } else {
                c0341a.gOj.setVisibility(8);
            }
            a(c0341a.gGz, groupInfoData.getGrade());
        }
        this.gOg.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.gOg.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            am.f(c0341a.gGs, R.color.common_color_10009, 1);
            am.c(c0341a.gGw, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0341a.gGx, (int) R.drawable.icon_vip_grade_big_small_s);
            am.c(c0341a.gGy, (int) R.drawable.icon_vip_grade_big_small_s);
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
    static class C0341a {
        GroupImageView gGr;
        TextView gGs;
        TextView gGu;
        TextView gGv;
        ImageView gGw;
        ImageView gGx;
        ImageView gGy;
        ImageView[] gGz;
        LinearLayout gOi;
        TextView gOj;
        ImageView gOk;
        ImageView gOl;
        ImageView gOm;

        C0341a() {
        }
    }
}
