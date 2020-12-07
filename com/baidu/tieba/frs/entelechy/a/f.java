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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.x, a> implements View.OnClickListener {
    private boolean jcW;
    private boolean jcX;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jcW = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jcX = z;
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
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.x xVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tieba.tbadkCore.x) aVar);
        if (xVar.dOD()) {
            String dOE = xVar.dOE();
            if (dOE != null) {
                aVar.jcZ.setText(dOE);
            } else if (this.iSt != null && this.iSt.getForum() != null && this.iSt.getForum().getName() != null) {
                TextView textView = aVar.jcZ;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iSt == null ? "" : this.iSt.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.jcY.setTag(Integer.valueOf(i));
            aVar.jcY.setOnClickListener(this);
            aVar.jcY.setVisibility(0);
        } else {
            aVar.jcY.setVisibility(8);
            aVar.jdf.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dOF = xVar.dOF();
        if (dOF != null && dOF.dOw() && !TextUtils.isEmpty(dOF.dOx())) {
            aVar.jdb.setText(dOF.dOx());
            aVar.jda.setTag(Integer.valueOf(i));
            aVar.jda.setOnClickListener(this);
            aVar.jda.setVisibility(0);
        } else {
            aVar.jda.setVisibility(8);
            aVar.jdg.setVisibility(8);
        }
        if (this.jcX) {
            aVar.jdc.setVisibility(0);
        } else {
            aVar.jdc.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iSt == null || this.iSt.getUserData() == null || !this.iSt.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jdd.setVisibility(0);
            ap.setBackgroundResource(aVar.jdd, R.drawable.frs_top_item_bg);
            aVar.jdc.setVisibility(0);
            aVar.jdd.setOnClickListener(this);
            aVar.jdd.setTag(Integer.valueOf(i));
        } else {
            aVar.jdd.setVisibility(8);
            aVar.jdh.setVisibility(8);
        }
        if (!this.jcW && !xVar.dOD()) {
            if (z) {
                aVar.jcY.setVisibility(8);
                aVar.jda.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jdi;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iSu != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof by) {
                View x = x(this.iyt.getListView(), intValue);
                this.iSu.a(id, intValue, view, x, (by) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        View jcY;
        TextView jcZ;
        View jda;
        TextView jdb;
        View jdc;
        View jdd;
        TextView jde;
        View jdf;
        View jdg;
        View jdh;
        List<View> jdi;

        a(View view) {
            super(view);
            this.jdi = new ArrayList();
            this.jcZ = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jcY = view.findViewById(R.id.frs_fortune_bag_item);
            this.jda = view.findViewById(R.id.frs_my_service_item);
            this.jdb = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jdc = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jdd = view.findViewById(R.id.frs_bawu_center);
            this.jde = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jdf = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jdg = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jdh = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jdi.add(this.jdf);
            this.jdi.add(this.jdg);
            this.jdi.add(this.jdh);
        }
    }
}
