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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.s, a> implements View.OnClickListener {
    private boolean fwS;
    private boolean fwT;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fwS = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fwT = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
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
        if (sVar.clP()) {
            String clQ = sVar.clQ();
            if (clQ != null) {
                aVar.fwV.setText(clQ);
            } else if (this.fot != null && this.fot.getForum() != null && this.fot.getForum().getName() != null) {
                TextView textView = aVar.fwV;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fot == null ? "" : this.fot.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fwU.setTag(Integer.valueOf(i));
            aVar.fwU.setOnClickListener(this);
            aVar.fwU.setVisibility(0);
        } else {
            aVar.fwU.setVisibility(8);
            aVar.fxb.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m clR = sVar.clR();
        if (clR != null && clR.clI() && !TextUtils.isEmpty(clR.clJ())) {
            aVar.fwX.setText(clR.clJ());
            aVar.fwW.setTag(Integer.valueOf(i));
            aVar.fwW.setOnClickListener(this);
            aVar.fwW.setVisibility(0);
        } else {
            aVar.fwW.setVisibility(8);
            aVar.fxc.setVisibility(8);
        }
        if (this.fwT) {
            aVar.fwY.setVisibility(0);
        } else {
            aVar.fwY.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fot == null || this.fot.getUserData() == null || !this.fot.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fwZ.setVisibility(0);
            al.k(aVar.fwZ, R.drawable.frs_top_item_bg);
            aVar.fwY.setVisibility(0);
            aVar.fwZ.setOnClickListener(this);
            aVar.fwZ.setTag(Integer.valueOf(i));
        } else {
            aVar.fwZ.setVisibility(8);
            aVar.fxd.setVisibility(8);
        }
        if (!this.fwS && !sVar.clP()) {
            if (z) {
                aVar.fwU.setVisibility(8);
                aVar.fwW.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fxe;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fou != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bg) {
                View s = s(this.eTY.getListView(), intValue);
                this.fou.a(id, intValue, view, s, (bg) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fwU;
        TextView fwV;
        View fwW;
        TextView fwX;
        View fwY;
        View fwZ;
        TextView fxa;
        View fxb;
        View fxc;
        View fxd;
        List<View> fxe;

        a(View view) {
            super(view);
            this.fxe = new ArrayList();
            this.fwV = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fwU = view.findViewById(R.id.frs_fortune_bag_item);
            this.fwW = view.findViewById(R.id.frs_my_service_item);
            this.fwX = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fwY = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fwZ = view.findViewById(R.id.frs_bawu_center);
            this.fxa = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fxb = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fxc = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fxd = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fxe.add(this.fxb);
            this.fxe.add(this.fxc);
            this.fxe.add(this.fxd);
        }
    }
}
