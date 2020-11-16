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
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes21.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.w, a> implements View.OnClickListener {
    private boolean iSc;
    private boolean iSd;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iSc = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.iSd = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.w wVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tieba.tbadkCore.w) aVar);
        if (wVar.dJm()) {
            String dJn = wVar.dJn();
            if (dJn != null) {
                aVar.iSf.setText(dJn);
            } else if (this.iHB != null && this.iHB.getForum() != null && this.iHB.getForum().getName() != null) {
                TextView textView = aVar.iSf;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iHB == null ? "" : this.iHB.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.iSe.setTag(Integer.valueOf(i));
            aVar.iSe.setOnClickListener(this);
            aVar.iSe.setVisibility(0);
        } else {
            aVar.iSe.setVisibility(8);
            aVar.iSl.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dJo = wVar.dJo();
        if (dJo != null && dJo.dJf() && !TextUtils.isEmpty(dJo.dJg())) {
            aVar.iSh.setText(dJo.dJg());
            aVar.iSg.setTag(Integer.valueOf(i));
            aVar.iSg.setOnClickListener(this);
            aVar.iSg.setVisibility(0);
        } else {
            aVar.iSg.setVisibility(8);
            aVar.iSm.setVisibility(8);
        }
        if (this.iSd) {
            aVar.iSi.setVisibility(0);
        } else {
            aVar.iSi.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iHB == null || this.iHB.getUserData() == null || !this.iHB.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.iSj.setVisibility(0);
            ap.setBackgroundResource(aVar.iSj, R.drawable.frs_top_item_bg);
            aVar.iSi.setVisibility(0);
            aVar.iSj.setOnClickListener(this);
            aVar.iSj.setTag(Integer.valueOf(i));
        } else {
            aVar.iSj.setVisibility(8);
            aVar.iSn.setVisibility(8);
        }
        if (!this.iSc && !wVar.dJm()) {
            if (z) {
                aVar.iSe.setVisibility(8);
                aVar.iSg.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.iSo;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iHC != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bx) {
                View x = x(this.inB.getListView(), intValue);
                this.iHC.a(id, intValue, view, x, (bx) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class a extends af.a {
        View iSe;
        TextView iSf;
        View iSg;
        TextView iSh;
        View iSi;
        View iSj;
        TextView iSk;
        View iSl;
        View iSm;
        View iSn;
        List<View> iSo;

        a(View view) {
            super(view);
            this.iSo = new ArrayList();
            this.iSf = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.iSe = view.findViewById(R.id.frs_fortune_bag_item);
            this.iSg = view.findViewById(R.id.frs_my_service_item);
            this.iSh = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.iSi = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.iSj = view.findViewById(R.id.frs_bawu_center);
            this.iSk = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.iSl = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.iSm = view.findViewById(R.id.official_account_text_divider_service_top);
            this.iSn = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.iSo.add(this.iSl);
            this.iSo.add(this.iSm);
            this.iSo.add(this.iSn);
        }
    }
}
