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
    private boolean jcY;
    private boolean jcZ;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jcY = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jcZ = z;
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
        if (xVar.dOE()) {
            String dOF = xVar.dOF();
            if (dOF != null) {
                aVar.jdb.setText(dOF);
            } else if (this.iSv != null && this.iSv.getForum() != null && this.iSv.getForum().getName() != null) {
                TextView textView = aVar.jdb;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iSv == null ? "" : this.iSv.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.jda.setTag(Integer.valueOf(i));
            aVar.jda.setOnClickListener(this);
            aVar.jda.setVisibility(0);
        } else {
            aVar.jda.setVisibility(8);
            aVar.jdh.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dOG = xVar.dOG();
        if (dOG != null && dOG.dOx() && !TextUtils.isEmpty(dOG.dOy())) {
            aVar.jdd.setText(dOG.dOy());
            aVar.jdc.setTag(Integer.valueOf(i));
            aVar.jdc.setOnClickListener(this);
            aVar.jdc.setVisibility(0);
        } else {
            aVar.jdc.setVisibility(8);
            aVar.jdi.setVisibility(8);
        }
        if (this.jcZ) {
            aVar.jde.setVisibility(0);
        } else {
            aVar.jde.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iSv == null || this.iSv.getUserData() == null || !this.iSv.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jdf.setVisibility(0);
            ap.setBackgroundResource(aVar.jdf, R.drawable.frs_top_item_bg);
            aVar.jde.setVisibility(0);
            aVar.jdf.setOnClickListener(this);
            aVar.jdf.setTag(Integer.valueOf(i));
        } else {
            aVar.jdf.setVisibility(8);
            aVar.jdj.setVisibility(8);
        }
        if (!this.jcY && !xVar.dOE()) {
            if (z) {
                aVar.jda.setVisibility(8);
                aVar.jdc.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jdk;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iSw != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof by) {
                View x = x(this.iyv.getListView(), intValue);
                this.iSw.a(id, intValue, view, x, (by) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        View jda;
        TextView jdb;
        View jdc;
        TextView jdd;
        View jde;
        View jdf;
        TextView jdg;
        View jdh;
        View jdi;
        View jdj;
        List<View> jdk;

        a(View view) {
            super(view);
            this.jdk = new ArrayList();
            this.jdb = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jda = view.findViewById(R.id.frs_fortune_bag_item);
            this.jdc = view.findViewById(R.id.frs_my_service_item);
            this.jdd = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jde = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jdf = view.findViewById(R.id.frs_bawu_center);
            this.jdg = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jdh = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jdi = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jdj = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jdk.add(this.jdh);
            this.jdk.add(this.jdi);
            this.jdk.add(this.jdj);
        }
    }
}
