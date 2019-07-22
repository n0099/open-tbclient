package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.s, a> implements View.OnClickListener {
    private boolean fBO;
    private boolean fBP;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fBO = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fBP = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.coH()) {
            String coI = sVar.coI();
            if (coI != null) {
                aVar.fBR.setText(coI);
            } else if (this.fts != null && this.fts.getForum() != null && this.fts.getForum().getName() != null) {
                TextView textView = aVar.fBR;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fts == null ? "" : this.fts.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fBQ.setTag(Integer.valueOf(i));
            aVar.fBQ.setOnClickListener(this);
            aVar.fBQ.setVisibility(0);
        } else {
            aVar.fBQ.setVisibility(8);
            aVar.fBX.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m coJ = sVar.coJ();
        if (coJ != null && coJ.coA() && !TextUtils.isEmpty(coJ.coB())) {
            aVar.fBT.setText(coJ.coB());
            aVar.fBS.setTag(Integer.valueOf(i));
            aVar.fBS.setOnClickListener(this);
            aVar.fBS.setVisibility(0);
        } else {
            aVar.fBS.setVisibility(8);
            aVar.fBY.setVisibility(8);
        }
        if (this.fBP) {
            aVar.fBU.setVisibility(0);
        } else {
            aVar.fBU.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fts == null || this.fts.getUserData() == null || !this.fts.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fBV.setVisibility(0);
            am.k(aVar.fBV, R.drawable.frs_top_item_bg);
            aVar.fBU.setVisibility(0);
            aVar.fBV.setOnClickListener(this);
            aVar.fBV.setTag(Integer.valueOf(i));
        } else {
            aVar.fBV.setVisibility(8);
            aVar.fBZ.setVisibility(8);
        }
        if (!this.fBO && !sVar.coH()) {
            if (z) {
                aVar.fBQ.setVisibility(8);
                aVar.fBS.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fCa;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ftt != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bg) {
                View s = s(this.eYZ.getListView(), intValue);
                this.ftt.a(id, intValue, view, s, (bg) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fBQ;
        TextView fBR;
        View fBS;
        TextView fBT;
        View fBU;
        View fBV;
        TextView fBW;
        View fBX;
        View fBY;
        View fBZ;
        List<View> fCa;

        a(View view) {
            super(view);
            this.fCa = new ArrayList();
            this.fBR = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fBQ = view.findViewById(R.id.frs_fortune_bag_item);
            this.fBS = view.findViewById(R.id.frs_my_service_item);
            this.fBT = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fBU = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fBV = view.findViewById(R.id.frs_bawu_center);
            this.fBW = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fBX = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fBY = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fBZ = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fCa.add(this.fBX);
            this.fCa.add(this.fBY);
            this.fCa.add(this.fBZ);
        }
    }
}
