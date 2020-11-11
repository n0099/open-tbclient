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
    private PersonalGroupFragment knl;
    private List<GroupInfoData> knm = new ArrayList();

    public void es(List<GroupInfoData> list) {
        this.knm = list;
    }

    public a(PersonalGroupFragment personalGroupFragment) {
        this.knl = personalGroupFragment;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.knm.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Dt */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.knm.size()) {
            return null;
        }
        return this.knm.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0765a c0765a;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof C0765a)) {
            view = LayoutInflater.from(this.knl.getActivity()).inflate(R.layout.tab_my_group_item, viewGroup, false);
            c0765a = new C0765a();
            c0765a.knn = (LinearLayout) view.findViewById(R.id.click_head);
            c0765a.knp = (ImageView) view.findViewById(R.id.diver_top);
            c0765a.knq = (ImageView) view.findViewById(R.id.diver_buttom_px);
            c0765a.knr = (ImageView) view.findViewById(R.id.diver_top_px);
            c0765a.kfk = (GroupImageView) view.findViewById(R.id.item_head);
            c0765a.kfl = (TextView) view.findViewById(R.id.item_group_name);
            c0765a.kfn = (TextView) view.findViewById(R.id.item_group_num);
            c0765a.kfo = (TextView) view.findViewById(R.id.item_introduce);
            c0765a.kno = (TextView) view.findViewById(R.id.isCreator);
            c0765a.kfp = (ImageView) view.findViewById(R.id.item_grade1);
            c0765a.kfq = (ImageView) view.findViewById(R.id.item_grade2);
            c0765a.kfr = (ImageView) view.findViewById(R.id.item_grade3);
            c0765a.kfs = new ImageView[4];
            c0765a.kfs[1] = c0765a.kfp;
            c0765a.kfs[2] = c0765a.kfq;
            c0765a.kfs[3] = c0765a.kfr;
            view.setTag(c0765a);
        } else {
            c0765a = (C0765a) view.getTag();
        }
        GroupInfoData groupInfoData = this.knm.get(i);
        c0765a.kfk.setTag(null);
        c0765a.kfk.setDrawBorder(true);
        c0765a.kfk.setPlaceHolder(1);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                c0765a.kfk.startLoad(portrait, 10, false);
            } else {
                c0765a.kfk.startLoad("", 10, false);
            }
            c0765a.knn.setOnClickListener(this.knl);
            c0765a.knn.setTag(groupInfoData);
            c0765a.knp.setVisibility(8);
            c0765a.knr.setVisibility(8);
            c0765a.knq.setVisibility(0);
            c0765a.kfl.setText(groupInfoData.getName());
            c0765a.kfn.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            c0765a.kfo.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                c0765a.kno.setVisibility(0);
            } else {
                c0765a.kno.setVisibility(8);
            }
            a(c0765a.kfs, groupInfoData.getGrade());
        }
        this.knl.getBaseFragmentActivity().getLayoutMode().setNightMode(TbadkApplication.getInst().getSkinType() == 1);
        this.knl.getBaseFragmentActivity().getLayoutMode().onModeChanged(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            ap.setViewTextColor(c0765a.kfl, R.color.common_color_10009, 1);
            ap.setImageResource(c0765a.kfp, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0765a.kfq, R.drawable.icon_vip_grade_big_small_s);
            ap.setImageResource(c0765a.kfr, R.drawable.icon_vip_grade_big_small_s);
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
    static class C0765a {
        GroupImageView kfk;
        TextView kfl;
        TextView kfn;
        TextView kfo;
        ImageView kfp;
        ImageView kfq;
        ImageView kfr;
        ImageView[] kfs;
        LinearLayout knn;
        TextView kno;
        ImageView knp;
        ImageView knq;
        ImageView knr;

        C0765a() {
        }
    }
}
