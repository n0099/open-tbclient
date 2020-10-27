package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.w, a> implements View.OnClickListener {
    private boolean iLs;
    private boolean iLt;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iLs = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.iLt = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bj */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.w wVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tieba.tbadkCore.w) aVar);
        if (wVar.dGT()) {
            String dGU = wVar.dGU();
            if (dGU != null) {
                aVar.iLv.setText(dGU);
            } else if (this.iAQ != null && this.iAQ.getForum() != null && this.iAQ.getForum().getName() != null) {
                TextView textView = aVar.iLv;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iAQ == null ? "" : this.iAQ.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.iLu.setTag(Integer.valueOf(i));
            aVar.iLu.setOnClickListener(this);
            aVar.iLu.setVisibility(0);
        } else {
            aVar.iLu.setVisibility(8);
            aVar.iLB.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dGV = wVar.dGV();
        if (dGV != null && dGV.dGM() && !TextUtils.isEmpty(dGV.dGN())) {
            aVar.iLx.setText(dGV.dGN());
            aVar.iLw.setTag(Integer.valueOf(i));
            aVar.iLw.setOnClickListener(this);
            aVar.iLw.setVisibility(0);
        } else {
            aVar.iLw.setVisibility(8);
            aVar.iLC.setVisibility(8);
        }
        if (this.iLt) {
            aVar.iLy.setVisibility(0);
        } else {
            aVar.iLy.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iAQ == null || this.iAQ.getUserData() == null || !this.iAQ.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.iLz.setVisibility(0);
            ap.setBackgroundResource(aVar.iLz, R.drawable.frs_top_item_bg);
            aVar.iLy.setVisibility(0);
            aVar.iLz.setOnClickListener(this);
            aVar.iLz.setTag(Integer.valueOf(i));
        } else {
            aVar.iLz.setVisibility(8);
            aVar.iLD.setVisibility(8);
        }
        if (!this.iLs && !wVar.dGT()) {
            if (z) {
                aVar.iLu.setVisibility(8);
                aVar.iLw.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.iLE;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iAR != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View x = x(this.igO.getListView(), intValue);
                this.iAR.a(id, intValue, view, x, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        TextView iLA;
        View iLB;
        View iLC;
        View iLD;
        List<View> iLE;
        View iLu;
        TextView iLv;
        View iLw;
        TextView iLx;
        View iLy;
        View iLz;

        a(View view) {
            super(view);
            this.iLE = new ArrayList();
            this.iLv = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.iLu = view.findViewById(R.id.frs_fortune_bag_item);
            this.iLw = view.findViewById(R.id.frs_my_service_item);
            this.iLx = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.iLy = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.iLz = view.findViewById(R.id.frs_bawu_center);
            this.iLA = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.iLB = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.iLC = view.findViewById(R.id.official_account_text_divider_service_top);
            this.iLD = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.iLE.add(this.iLB);
            this.iLE.add(this.iLC);
            this.iLE.add(this.iLD);
        }
    }
}
