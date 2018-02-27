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
    private c eLd;
    private List<GroupInfoData> eLe = new ArrayList();

    public void cp(List<GroupInfoData> list) {
        this.eLe = list;
    }

    public b(c cVar) {
        this.eLd = cVar;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.eLe.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: qy */
    public GroupInfoData getItem(int i) {
        int itemId = (int) getItemId(i);
        if (itemId < 0 || itemId >= this.eLe.size()) {
            return null;
        }
        return this.eLe.get(itemId);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null || !(view.getTag() instanceof a)) {
            view = LayoutInflater.from(this.eLd.getActivity()).inflate(d.h.tab_my_group_item, viewGroup, false);
            aVar = new a();
            aVar.eLf = (LinearLayout) view.findViewById(d.g.click_head);
            aVar.eLh = (ImageView) view.findViewById(d.g.diver_top);
            aVar.eLi = (ImageView) view.findViewById(d.g.diver_buttom_px);
            aVar.eLj = (ImageView) view.findViewById(d.g.diver_top_px);
            aVar.eDl = (GroupImageView) view.findViewById(d.g.item_head);
            aVar.eDm = (TextView) view.findViewById(d.g.item_group_name);
            aVar.eDo = (TextView) view.findViewById(d.g.item_group_num);
            aVar.eDp = (TextView) view.findViewById(d.g.item_introduce);
            aVar.eLg = (TextView) view.findViewById(d.g.isCreator);
            aVar.eDq = (ImageView) view.findViewById(d.g.item_grade1);
            aVar.eDr = (ImageView) view.findViewById(d.g.item_grade2);
            aVar.eDs = (ImageView) view.findViewById(d.g.item_grade3);
            aVar.eDt = new ImageView[4];
            aVar.eDt[1] = aVar.eDq;
            aVar.eDt[2] = aVar.eDr;
            aVar.eDt[3] = aVar.eDs;
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        GroupInfoData groupInfoData = this.eLe.get(i);
        aVar.eDl.setTag(null);
        aVar.eDl.setDrawBorder(true);
        if (groupInfoData != null) {
            String portrait = groupInfoData.getPortrait();
            if (!TextUtils.isEmpty(portrait)) {
                aVar.eDl.startLoad(portrait, 10, false);
            } else {
                aVar.eDl.startLoad("", 10, false);
            }
            aVar.eLf.setOnClickListener(this.eLd);
            aVar.eLf.setTag(groupInfoData);
            aVar.eLh.setVisibility(8);
            aVar.eLj.setVisibility(8);
            aVar.eLi.setVisibility(0);
            aVar.eDm.setText(groupInfoData.getName());
            aVar.eDo.setText(groupInfoData.getMemberNum() + "/" + groupInfoData.getMaxMemberNum());
            aVar.eDp.setText(groupInfoData.getIntro());
            if (groupInfoData.getIsGroupManager() == 1) {
                aVar.eLg.setVisibility(0);
            } else {
                aVar.eLg.setVisibility(8);
            }
            a(aVar.eDt, groupInfoData.getGrade());
        }
        this.eLd.getBaseFragmentActivity().getLayoutMode().aQ(TbadkApplication.getInst().getSkinType() == 1);
        this.eLd.getBaseFragmentActivity().getLayoutMode().aM(view);
        if (groupInfoData != null && groupInfoData.isMemGroup()) {
            aj.e(aVar.eDm, d.C0141d.common_color_10009, 1);
            aj.c(aVar.eDq, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDr, d.f.icon_vip_grade_big_small_s);
            aj.c(aVar.eDs, d.f.icon_vip_grade_big_small_s);
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
        GroupImageView eDl;
        TextView eDm;
        TextView eDo;
        TextView eDp;
        ImageView eDq;
        ImageView eDr;
        ImageView eDs;
        ImageView[] eDt;
        LinearLayout eLf;
        TextView eLg;
        ImageView eLh;
        ImageView eLi;
        ImageView eLj;

        a() {
        }
    }
}
