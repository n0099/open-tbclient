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
    private c eLt;
    private List<GroupInfoData> eLu = new ArrayList();

    public void cp(List<GroupInfoData> list) {
        this.eLu = list;
    }

    public b(c cVar) {
        this.eLt = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eLu.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qz */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eLu.size()) {
            return null;
        }
        return this.eLu.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.eLt.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            aVar = new a();
            aVar.eLv = (LinearLayout) view.findViewById(d.g.click_head);
            aVar.eLx = (ImageView) view.findViewById(d.g.diver_top);
            aVar.eLy = (ImageView) view.findViewById(d.g.diver_buttom_px);
            aVar.eLz = (ImageView) view.findViewById(d.g.diver_top_px);
            aVar.eDB = (GroupImageView) view.findViewById(d.g.item_head);
            aVar.eDC = (TextView) view.findViewById(d.g.item_group_name);
            aVar.eDE = (TextView) view.findViewById(d.g.item_group_num);
            aVar.eDF = (TextView) view.findViewById(d.g.item_introduce);
            aVar.eLw = (TextView) view.findViewById(d.g.isCreator);
            aVar.eDG = (ImageView) view.findViewById(d.g.item_grade1);
            aVar.eDH = (ImageView) view.findViewById(d.g.item_grade2);
            aVar.eDI = (ImageView) view.findViewById(d.g.item_grade3);
            aVar.eDJ = new ImageView[4];
            aVar.eDJ[1] = aVar.eDG;
            aVar.eDJ[2] = aVar.eDH;
            aVar.eDJ[3] = aVar.eDI;
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eLu.get(i);
        aVar.eDB.setTag(null);
        aVar.eDB.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                aVar.eDB.startLoad(portrait, 10, false);
            } else {
                aVar.eDB.startLoad("", 10, false);
            }
            aVar.eLv.setOnClickListener(this.eLt);
            aVar.eLv.setTag(groupInfoData);
            aVar.eLx.setVisibility(8);
            aVar.eLz.setVisibility(8);
            aVar.eLy.setVisibility(0);
            aVar.eDC.setText(groupInfoData.getName());
            aVar.eDE.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            aVar.eDF.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                aVar.eLw.setVisibility(0);
            } else {
                aVar.eLw.setVisibility(8);
            }
            a(aVar.eDJ, groupInfoData.getGrade());
        }
        this.eLt.getBaseFragmentActivity().getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eLt.getBaseFragmentActivity().getLayoutMode().aM(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            aj.e(aVar.eDC, d.C0141d.common_color_10009, 1);
            aj.c(aVar.eDG, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDH, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDI, d.f.icon_vip_grade_big_small_s);
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
        GroupImageView eDB;
        TextView eDC;
        TextView eDE;
        TextView eDF;
        ImageView eDG;
        ImageView eDH;
        ImageView eDI;
        ImageView[] eDJ;
        LinearLayout eLv;
        TextView eLw;
        ImageView eLx;
        ImageView eLy;
        ImageView eLz;

        a() {
        }
    }
}
