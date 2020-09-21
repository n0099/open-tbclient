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
/* loaded from: classes21.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.w, a> implements View.OnClickListener {
    private boolean ijZ;
    private boolean ika;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.ijZ = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.ika = z;
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
        if (wVar.dzZ()) {
            String dAa = wVar.dAa();
            if (dAa != null) {
                aVar.ikc.setText(dAa);
            } else if (this.hZt != null && this.hZt.getForum() != null && this.hZt.getForum().getName() != null) {
                TextView textView = aVar.ikc;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hZt == null ? "" : this.hZt.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.ikb.setTag(Integer.valueOf(i));
            aVar.ikb.setOnClickListener(this);
            aVar.ikb.setVisibility(0);
        } else {
            aVar.ikb.setVisibility(8);
            aVar.iki.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dAb = wVar.dAb();
        if (dAb != null && dAb.dzS() && !TextUtils.isEmpty(dAb.dzT())) {
            aVar.ike.setText(dAb.dzT());
            aVar.ikd.setTag(Integer.valueOf(i));
            aVar.ikd.setOnClickListener(this);
            aVar.ikd.setVisibility(0);
        } else {
            aVar.ikd.setVisibility(8);
            aVar.ikj.setVisibility(8);
        }
        if (this.ika) {
            aVar.ikf.setVisibility(0);
        } else {
            aVar.ikf.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hZt == null || this.hZt.getUserData() == null || !this.hZt.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.ikg.setVisibility(0);
            ap.setBackgroundResource(aVar.ikg, R.drawable.frs_top_item_bg);
            aVar.ikf.setVisibility(0);
            aVar.ikg.setOnClickListener(this);
            aVar.ikg.setTag(Integer.valueOf(i));
        } else {
            aVar.ikg.setVisibility(8);
            aVar.ikk.setVisibility(8);
        }
        if (!this.ijZ && !wVar.dzZ()) {
            if (z) {
                aVar.ikb.setVisibility(8);
                aVar.ikd.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.ikl;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hZu != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View v = v(this.hFt.getListView(), intValue);
                this.hZu.a(id, intValue, view, v, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes21.dex */
    public static class a extends af.a {
        View ikb;
        TextView ikc;
        View ikd;
        TextView ike;
        View ikf;
        View ikg;
        TextView ikh;
        View iki;
        View ikj;
        View ikk;
        List<View> ikl;

        a(View view) {
            super(view);
            this.ikl = new ArrayList();
            this.ikc = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.ikb = view.findViewById(R.id.frs_fortune_bag_item);
            this.ikd = view.findViewById(R.id.frs_my_service_item);
            this.ike = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.ikf = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.ikg = view.findViewById(R.id.frs_bawu_center);
            this.ikh = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.iki = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.ikj = view.findViewById(R.id.official_account_text_divider_service_top);
            this.ikk = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.ikl.add(this.iki);
            this.ikl.add(this.ikj);
            this.ikl.add(this.ikk);
        }
    }
}
