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
    private boolean iyW;
    private boolean iyX;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iyW = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.iyX = z;
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
        if (wVar.dDL()) {
            String dDM = wVar.dDM();
            if (dDM != null) {
                aVar.iyZ.setText(dDM);
            } else if (this.iou != null && this.iou.getForum() != null && this.iou.getForum().getName() != null) {
                TextView textView = aVar.iyZ;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iou == null ? "" : this.iou.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.iyY.setTag(Integer.valueOf(i));
            aVar.iyY.setOnClickListener(this);
            aVar.iyY.setVisibility(0);
        } else {
            aVar.iyY.setVisibility(8);
            aVar.izf.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dDN = wVar.dDN();
        if (dDN != null && dDN.dDE() && !TextUtils.isEmpty(dDN.dDF())) {
            aVar.izb.setText(dDN.dDF());
            aVar.iza.setTag(Integer.valueOf(i));
            aVar.iza.setOnClickListener(this);
            aVar.iza.setVisibility(0);
        } else {
            aVar.iza.setVisibility(8);
            aVar.izg.setVisibility(8);
        }
        if (this.iyX) {
            aVar.izc.setVisibility(0);
        } else {
            aVar.izc.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iou == null || this.iou.getUserData() == null || !this.iou.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.izd.setVisibility(0);
            ap.setBackgroundResource(aVar.izd, R.drawable.frs_top_item_bg);
            aVar.izc.setVisibility(0);
            aVar.izd.setOnClickListener(this);
            aVar.izd.setTag(Integer.valueOf(i));
        } else {
            aVar.izd.setVisibility(8);
            aVar.izh.setVisibility(8);
        }
        if (!this.iyW && !wVar.dDL()) {
            if (z) {
                aVar.iyY.setVisibility(8);
                aVar.iza.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.izi;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iov != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View x = x(this.hUo.getListView(), intValue);
                this.iov.a(id, intValue, view, x, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        View iyY;
        TextView iyZ;
        View iza;
        TextView izb;
        View izc;
        View izd;
        TextView ize;
        View izf;
        View izg;
        View izh;
        List<View> izi;

        a(View view) {
            super(view);
            this.izi = new ArrayList();
            this.iyZ = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.iyY = view.findViewById(R.id.frs_fortune_bag_item);
            this.iza = view.findViewById(R.id.frs_my_service_item);
            this.izb = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.izc = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.izd = view.findViewById(R.id.frs_bawu_center);
            this.ize = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.izf = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.izg = view.findViewById(R.id.official_account_text_divider_service_top);
            this.izh = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.izi.add(this.izf);
            this.izi.add(this.izg);
            this.izi.add(this.izh);
        }
    }
}
