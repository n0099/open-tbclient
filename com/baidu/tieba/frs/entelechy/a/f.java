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
    private boolean iRp;
    private boolean iRq;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.iRp = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.iRq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bl */
    public a c(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.w wVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tieba.tbadkCore.w) aVar);
        if (wVar.dJv()) {
            String dJw = wVar.dJw();
            if (dJw != null) {
                aVar.iRs.setText(dJw);
            } else if (this.iGN != null && this.iGN.getForum() != null && this.iGN.getForum().getName() != null) {
                TextView textView = aVar.iRs;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.iGN == null ? "" : this.iGN.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.iRr.setTag(Integer.valueOf(i));
            aVar.iRr.setOnClickListener(this);
            aVar.iRr.setVisibility(0);
        } else {
            aVar.iRr.setVisibility(8);
            aVar.iRy.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dJx = wVar.dJx();
        if (dJx != null && dJx.dJo() && !TextUtils.isEmpty(dJx.dJp())) {
            aVar.iRu.setText(dJx.dJp());
            aVar.iRt.setTag(Integer.valueOf(i));
            aVar.iRt.setOnClickListener(this);
            aVar.iRt.setVisibility(0);
        } else {
            aVar.iRt.setVisibility(8);
            aVar.iRz.setVisibility(8);
        }
        if (this.iRq) {
            aVar.iRv.setVisibility(0);
        } else {
            aVar.iRv.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.iGN == null || this.iGN.getUserData() == null || !this.iGN.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.iRw.setVisibility(0);
            ap.setBackgroundResource(aVar.iRw, R.drawable.frs_top_item_bg);
            aVar.iRv.setVisibility(0);
            aVar.iRw.setOnClickListener(this);
            aVar.iRw.setTag(Integer.valueOf(i));
        } else {
            aVar.iRw.setVisibility(8);
            aVar.iRA.setVisibility(8);
        }
        if (!this.iRp && !wVar.dJv()) {
            if (z) {
                aVar.iRr.setVisibility(8);
                aVar.iRt.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.iRB;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iGO != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View x = x(this.imM.getListView(), intValue);
                this.iGO.a(id, intValue, view, x, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes22.dex */
    public static class a extends af.a {
        View iRA;
        List<View> iRB;
        View iRr;
        TextView iRs;
        View iRt;
        TextView iRu;
        View iRv;
        View iRw;
        TextView iRx;
        View iRy;
        View iRz;

        a(View view) {
            super(view);
            this.iRB = new ArrayList();
            this.iRs = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.iRr = view.findViewById(R.id.frs_fortune_bag_item);
            this.iRt = view.findViewById(R.id.frs_my_service_item);
            this.iRu = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.iRv = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.iRw = view.findViewById(R.id.frs_bawu_center);
            this.iRx = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.iRy = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.iRz = view.findViewById(R.id.official_account_text_divider_service_top);
            this.iRA = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.iRB.add(this.iRy);
            this.iRB.add(this.iRz);
            this.iRB.add(this.iRA);
        }
    }
}
