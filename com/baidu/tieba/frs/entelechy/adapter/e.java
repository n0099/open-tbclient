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
    private boolean jpu;
    private boolean jpv;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jpu = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jpv = z;
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
        if (xVar.dOw()) {
            String dOx = xVar.dOx();
            if (dOx != null) {
                aVar.jpx.setText(dOx);
            } else if (this.jeH != null && this.jeH.getForum() != null && this.jeH.getForum().getName() != null) {
                TextView textView = aVar.jpx;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.jeH == null ? "" : this.jeH.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.jpw.setTag(Integer.valueOf(i));
            aVar.jpw.setOnClickListener(this);
            aVar.jpw.setVisibility(0);
        } else {
            aVar.jpw.setVisibility(8);
            aVar.jpD.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dOy = xVar.dOy();
        if (dOy != null && dOy.dOp() && !TextUtils.isEmpty(dOy.dOq())) {
            aVar.jpz.setText(dOy.dOq());
            aVar.jpy.setTag(Integer.valueOf(i));
            aVar.jpy.setOnClickListener(this);
            aVar.jpy.setVisibility(0);
        } else {
            aVar.jpy.setVisibility(8);
            aVar.jpE.setVisibility(8);
        }
        if (this.jpv) {
            aVar.jpA.setVisibility(0);
        } else {
            aVar.jpA.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.jeH == null || this.jeH.getUserData() == null || !this.jeH.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jpB.setVisibility(0);
            ao.setBackgroundResource(aVar.jpB, R.drawable.frs_top_item_bg);
            aVar.jpA.setVisibility(0);
            aVar.jpB.setOnClickListener(this);
            aVar.jpB.setTag(Integer.valueOf(i));
        } else {
            aVar.jpB.setVisibility(8);
            aVar.jpF.setVisibility(8);
        }
        if (!this.jpu && !xVar.dOw()) {
            if (z) {
                aVar.jpw.setVisibility(8);
                aVar.jpy.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jpG;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jeI != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bz) {
                View B = B(this.iKI.getListView(), intValue);
                this.jeI.a(id, intValue, view, B, (bz) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        View jpA;
        View jpB;
        TextView jpC;
        View jpD;
        View jpE;
        View jpF;
        List<View> jpG;
        View jpw;
        TextView jpx;
        View jpy;
        TextView jpz;

        a(View view) {
            super(view);
            this.jpG = new ArrayList();
            this.jpx = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jpw = view.findViewById(R.id.frs_fortune_bag_item);
            this.jpy = view.findViewById(R.id.frs_my_service_item);
            this.jpz = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jpA = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jpB = view.findViewById(R.id.frs_bawu_center);
            this.jpC = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jpD = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jpE = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jpF = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jpG.add(this.jpD);
            this.jpG.add(this.jpE);
            this.jpG.add(this.jpF);
        }
    }
}
