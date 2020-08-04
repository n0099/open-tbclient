package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.frs.j<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean hOK;
    private boolean hOL;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hOK = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hOL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.dkE()) {
            String dkF = vVar.dkF();
            if (dkF != null) {
                aVar.hON.setText(dkF);
            } else if (this.hEX != null && this.hEX.getForum() != null && this.hEX.getForum().getName() != null) {
                TextView textView = aVar.hON;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.hEX == null ? "" : this.hEX.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.hOM.setTag(Integer.valueOf(i));
            aVar.hOM.setOnClickListener(this);
            aVar.hOM.setVisibility(0);
        } else {
            aVar.hOM.setVisibility(8);
            aVar.hOT.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p dkG = vVar.dkG();
        if (dkG != null && dkG.dkx() && !TextUtils.isEmpty(dkG.dky())) {
            aVar.hOP.setText(dkG.dky());
            aVar.hOO.setTag(Integer.valueOf(i));
            aVar.hOO.setOnClickListener(this);
            aVar.hOO.setVisibility(0);
        } else {
            aVar.hOO.setVisibility(8);
            aVar.hOU.setVisibility(8);
        }
        if (this.hOL) {
            aVar.hOQ.setVisibility(0);
        } else {
            aVar.hOQ.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hEX == null || this.hEX.getUserData() == null || !this.hEX.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hOR.setVisibility(0);
            ao.setBackgroundResource(aVar.hOR, R.drawable.frs_top_item_bg);
            aVar.hOQ.setVisibility(0);
            aVar.hOR.setOnClickListener(this);
            aVar.hOR.setTag(Integer.valueOf(i));
        } else {
            aVar.hOR.setVisibility(8);
            aVar.hOV.setVisibility(8);
        }
        if (!this.hOK && !vVar.dkE()) {
            if (z) {
                aVar.hOM.setVisibility(8);
                aVar.hOO.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hOW;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hEY != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bv) {
                View t = t(this.hlu.getListView(), intValue);
                this.hEY.a(id, intValue, view, t, (bv) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        View hOM;
        TextView hON;
        View hOO;
        TextView hOP;
        View hOQ;
        View hOR;
        TextView hOS;
        View hOT;
        View hOU;
        View hOV;
        List<View> hOW;

        a(View view) {
            super(view);
            this.hOW = new ArrayList();
            this.hON = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hOM = view.findViewById(R.id.frs_fortune_bag_item);
            this.hOO = view.findViewById(R.id.frs_my_service_item);
            this.hOP = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hOQ = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hOR = view.findViewById(R.id.frs_bawu_center);
            this.hOS = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hOT = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hOU = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hOV = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hOW.add(this.hOT);
            this.hOW.add(this.hOU);
            this.hOW.add(this.hOV);
        }
    }
}
