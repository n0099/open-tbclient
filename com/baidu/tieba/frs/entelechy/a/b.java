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
    private boolean fwR;
    private boolean fwS;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fwR = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fwS = z;
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
        if (sVar.clM()) {
            String clN = sVar.clN();
            if (clN != null) {
                aVar.fwU.setText(clN);
            } else if (this.fos != null && this.fos.getForum() != null && this.fos.getForum().getName() != null) {
                TextView textView = aVar.fwU;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fos == null ? "" : this.fos.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fwT.setTag(Integer.valueOf(i));
            aVar.fwT.setOnClickListener(this);
            aVar.fwT.setVisibility(0);
        } else {
            aVar.fwT.setVisibility(8);
            aVar.fxa.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m clO = sVar.clO();
        if (clO != null && clO.clF() && !TextUtils.isEmpty(clO.clG())) {
            aVar.fwW.setText(clO.clG());
            aVar.fwV.setTag(Integer.valueOf(i));
            aVar.fwV.setOnClickListener(this);
            aVar.fwV.setVisibility(0);
        } else {
            aVar.fwV.setVisibility(8);
            aVar.fxb.setVisibility(8);
        }
        if (this.fwS) {
            aVar.fwX.setVisibility(0);
        } else {
            aVar.fwX.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fos == null || this.fos.getUserData() == null || !this.fos.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fwY.setVisibility(0);
            al.k(aVar.fwY, R.drawable.frs_top_item_bg);
            aVar.fwX.setVisibility(0);
            aVar.fwY.setOnClickListener(this);
            aVar.fwY.setTag(Integer.valueOf(i));
        } else {
            aVar.fwY.setVisibility(8);
            aVar.fxc.setVisibility(8);
        }
        if (!this.fwR && !sVar.clM()) {
            if (z) {
                aVar.fwT.setVisibility(8);
                aVar.fwV.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fxd;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fot != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bg) {
                View s = s(this.eTX.getListView(), intValue);
                this.fot.a(id, intValue, view, s, (bg) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fwT;
        TextView fwU;
        View fwV;
        TextView fwW;
        View fwX;
        View fwY;
        TextView fwZ;
        View fxa;
        View fxb;
        View fxc;
        List<View> fxd;

        a(View view) {
            super(view);
            this.fxd = new ArrayList();
            this.fwU = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fwT = view.findViewById(R.id.frs_fortune_bag_item);
            this.fwV = view.findViewById(R.id.frs_my_service_item);
            this.fwW = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fwX = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fwY = view.findViewById(R.id.frs_bawu_center);
            this.fwZ = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fxa = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fxb = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fxc = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fxd.add(this.fxa);
            this.fxd.add(this.fxb);
            this.fxd.add(this.fxc);
        }
    }
}
