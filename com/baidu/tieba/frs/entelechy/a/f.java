package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean gxp;
    private boolean gxq;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.gxp = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gxq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aO */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.cKS()) {
            String cKT = vVar.cKT();
            if (cKT != null) {
                aVar.gxs.setText(cKT);
            } else if (this.goJ != null && this.goJ.getForum() != null && this.goJ.getForum().getName() != null) {
                TextView textView = aVar.gxs;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.goJ == null ? "" : this.goJ.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.gxr.setTag(Integer.valueOf(i));
            aVar.gxr.setOnClickListener(this);
            aVar.gxr.setVisibility(0);
        } else {
            aVar.gxr.setVisibility(8);
            aVar.gxy.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p cKU = vVar.cKU();
        if (cKU != null && cKU.cKL() && !TextUtils.isEmpty(cKU.cKM())) {
            aVar.gxu.setText(cKU.cKM());
            aVar.gxt.setTag(Integer.valueOf(i));
            aVar.gxt.setOnClickListener(this);
            aVar.gxt.setVisibility(0);
        } else {
            aVar.gxt.setVisibility(8);
            aVar.gxz.setVisibility(8);
        }
        if (this.gxq) {
            aVar.gxv.setVisibility(0);
        } else {
            aVar.gxv.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.goJ == null || this.goJ.getUserData() == null || !this.goJ.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gxw.setVisibility(0);
            am.setBackgroundResource(aVar.gxw, R.drawable.frs_top_item_bg);
            aVar.gxv.setVisibility(0);
            aVar.gxw.setOnClickListener(this);
            aVar.gxw.setTag(Integer.valueOf(i));
        } else {
            aVar.gxw.setVisibility(8);
            aVar.gxA.setVisibility(8);
        }
        if (!this.gxp && !vVar.cKS()) {
            if (z) {
                aVar.gxr.setVisibility(8);
                aVar.gxt.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.gxB;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.goK != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fXy.getListView(), intValue);
                this.goK.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends v.a {
        View gxA;
        List<View> gxB;
        View gxr;
        TextView gxs;
        View gxt;
        TextView gxu;
        View gxv;
        View gxw;
        TextView gxx;
        View gxy;
        View gxz;

        a(View view) {
            super(view);
            this.gxB = new ArrayList();
            this.gxs = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.gxr = view.findViewById(R.id.frs_fortune_bag_item);
            this.gxt = view.findViewById(R.id.frs_my_service_item);
            this.gxu = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.gxv = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gxw = view.findViewById(R.id.frs_bawu_center);
            this.gxx = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.gxy = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.gxz = view.findViewById(R.id.official_account_text_divider_service_top);
            this.gxA = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.gxB.add(this.gxy);
            this.gxB.add(this.gxz);
            this.gxB.add(this.gxA);
        }
    }
}
