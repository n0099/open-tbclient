package com.baidu.tieba.frs.entelechy.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.x, a> implements View.OnClickListener {
    private boolean jkN;
    private boolean jkO;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jkN = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jkO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a e(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.x xVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tieba.tbadkCore.x) aVar);
        if (xVar.dKF()) {
            String dKG = xVar.dKG();
            if (dKG != null) {
                aVar.jkQ.setText(dKG);
            } else if (this.jaa != null && this.jaa.getForum() != null && this.jaa.getForum().getName() != null) {
                TextView textView = aVar.jkQ;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.jaa == null ? "" : this.jaa.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.jkP.setTag(Integer.valueOf(i));
            aVar.jkP.setOnClickListener(this);
            aVar.jkP.setVisibility(0);
        } else {
            aVar.jkP.setVisibility(8);
            aVar.jkW.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dKH = xVar.dKH();
        if (dKH != null && dKH.dKy() && !TextUtils.isEmpty(dKH.dKz())) {
            aVar.jkS.setText(dKH.dKz());
            aVar.jkR.setTag(Integer.valueOf(i));
            aVar.jkR.setOnClickListener(this);
            aVar.jkR.setVisibility(0);
        } else {
            aVar.jkR.setVisibility(8);
            aVar.jkX.setVisibility(8);
        }
        if (this.jkO) {
            aVar.jkT.setVisibility(0);
        } else {
            aVar.jkT.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.jaa == null || this.jaa.getUserData() == null || !this.jaa.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jkU.setVisibility(0);
            ao.setBackgroundResource(aVar.jkU, R.drawable.frs_top_item_bg);
            aVar.jkT.setVisibility(0);
            aVar.jkU.setOnClickListener(this);
            aVar.jkU.setTag(Integer.valueOf(i));
        } else {
            aVar.jkU.setVisibility(8);
            aVar.jkY.setVisibility(8);
        }
        if (!this.jkN && !xVar.dKF()) {
            if (z) {
                aVar.jkP.setVisibility(8);
                aVar.jkR.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jkZ;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jab != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bz) {
                View B = B(this.iGb.getListView(), intValue);
                this.jab.a(id, intValue, view, B, (bz) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        View jkP;
        TextView jkQ;
        View jkR;
        TextView jkS;
        View jkT;
        View jkU;
        TextView jkV;
        View jkW;
        View jkX;
        View jkY;
        List<View> jkZ;

        a(View view) {
            super(view);
            this.jkZ = new ArrayList();
            this.jkQ = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jkP = view.findViewById(R.id.frs_fortune_bag_item);
            this.jkR = view.findViewById(R.id.frs_my_service_item);
            this.jkS = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jkT = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jkU = view.findViewById(R.id.frs_bawu_center);
            this.jkV = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jkW = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jkX = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jkY = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jkZ.add(this.jkW);
            this.jkZ.add(this.jkX);
            this.jkZ.add(this.jkY);
        }
    }
}
