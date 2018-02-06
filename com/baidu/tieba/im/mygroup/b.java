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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.GroupImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.im.data.GroupInfoData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class b extends BaseAdapter {
    private c eLp;
    private List<GroupInfoData> eLq = new ArrayList();

    public void cp(List<GroupInfoData> list) {
        this.eLq = list;
    }

    public b(c cVar) {
        this.eLp = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eLq.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qy */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eLq.size()) {
            return null;
        }
        return this.eLq.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.eLp.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            aVar = new a();
            aVar.eLr = (LinearLayout) view.findViewById(d.g.click_head);
            aVar.eLt = (ImageView) view.findViewById(d.g.diver_top);
            aVar.eLu = (ImageView) view.findViewById(d.g.diver_buttom_px);
            aVar.eLv = (ImageView) view.findViewById(d.g.diver_top_px);
            aVar.eDx = (GroupImageView) view.findViewById(d.g.item_head);
            aVar.eDy = (TextView) view.findViewById(d.g.item_group_name);
            aVar.eDA = (TextView) view.findViewById(d.g.item_group_num);
            aVar.eDB = (TextView) view.findViewById(d.g.item_introduce);
            aVar.eLs = (TextView) view.findViewById(d.g.isCreator);
            aVar.eDC = (ImageView) view.findViewById(d.g.item_grade1);
            aVar.eDD = (ImageView) view.findViewById(d.g.item_grade2);
            aVar.eDE = (ImageView) view.findViewById(d.g.item_grade3);
            aVar.eDF = new ImageView[4];
            aVar.eDF[1] = aVar.eDC;
            aVar.eDF[2] = aVar.eDD;
            aVar.eDF[3] = aVar.eDE;
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eLq.get(i);
        aVar.eDx.setTag(null);
        aVar.eDx.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                aVar.eDx.startLoad(portrait, 10, false);
            } else {
                aVar.eDx.startLoad("", 10, false);
            }
            aVar.eLr.setOnClickListener(this.eLp);
            aVar.eLr.setTag(groupInfoData);
            aVar.eLt.setVisibility(8);
            aVar.eLv.setVisibility(8);
            aVar.eLu.setVisibility(0);
            aVar.eDy.setText(groupInfoData.getName());
            aVar.eDA.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            aVar.eDB.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                aVar.eLs.setVisibility(0);
            } else {
                aVar.eLs.setVisibility(8);
            }
            a(aVar.eDF, groupInfoData.getGrade());
        }
        this.eLp.getBaseFragmentActivity().getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eLp.getBaseFragmentActivity().getLayoutMode().aM(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            aj.e(aVar.eDy, d.C0140d.common_color_10009, 1);
            aj.c(aVar.eDC, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDD, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDE, d.f.icon_vip_grade_big_small_s);
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

    /* loaded from: classes3.dex */
    static class a {
        TextView eDA;
        TextView eDB;
        ImageView eDC;
        ImageView eDD;
        ImageView eDE;
        ImageView[] eDF;
        GroupImageView eDx;
        TextView eDy;
        LinearLayout eLr;
        TextView eLs;
        ImageView eLt;
        ImageView eLu;
        ImageView eLv;

        a() {
        }
    }
}
