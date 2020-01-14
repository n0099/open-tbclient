package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.u, a> implements View.OnClickListener {
    private boolean guq;
    private boolean gur;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.guq = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gur = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.u uVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tieba.tbadkCore.u) aVar);
        if (uVar.cIR()) {
            String cIS = uVar.cIS();
            if (cIS != null) {
                aVar.gut.setText(cIS);
            } else if (this.glJ != null && this.glJ.getForum() != null && this.glJ.getForum().getName() != null) {
                TextView textView = aVar.gut;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.glJ == null ? "" : this.glJ.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.gus.setTag(Integer.valueOf(i));
            aVar.gus.setOnClickListener(this);
            aVar.gus.setVisibility(0);
        } else {
            aVar.gus.setVisibility(8);
            aVar.guz.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cIT = uVar.cIT();
        if (cIT != null && cIT.cIK() && !TextUtils.isEmpty(cIT.cIL())) {
            aVar.guv.setText(cIT.cIL());
            aVar.guu.setTag(Integer.valueOf(i));
            aVar.guu.setOnClickListener(this);
            aVar.guu.setVisibility(0);
        } else {
            aVar.guu.setVisibility(8);
            aVar.guA.setVisibility(8);
        }
        if (this.gur) {
            aVar.guw.setVisibility(0);
        } else {
            aVar.guw.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.glJ == null || this.glJ.getUserData() == null || !this.glJ.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gux.setVisibility(0);
            am.setBackgroundResource(aVar.gux, R.drawable.frs_top_item_bg);
            aVar.guw.setVisibility(0);
            aVar.gux.setOnClickListener(this);
            aVar.gux.setTag(Integer.valueOf(i));
        } else {
            aVar.gux.setVisibility(8);
            aVar.guB.setVisibility(8);
        }
        if (!this.guq && !uVar.cIR()) {
            if (z) {
                aVar.gus.setVisibility(8);
                aVar.guu.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.guC;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.glK != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fUA.getListView(), intValue);
                this.glK.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a extends v.a {
        View guA;
        View guB;
        List<View> guC;
        View gus;
        TextView gut;
        View guu;
        TextView guv;
        View guw;
        View gux;
        TextView guy;
        View guz;

        a(View view) {
            super(view);
            this.guC = new ArrayList();
            this.gut = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.gus = view.findViewById(R.id.frs_fortune_bag_item);
            this.guu = view.findViewById(R.id.frs_my_service_item);
            this.guv = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.guw = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gux = view.findViewById(R.id.frs_bawu_center);
            this.guy = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.guz = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.guA = view.findViewById(R.id.official_account_text_divider_service_top);
            this.guB = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.guC.add(this.guz);
            this.guC.add(this.guA);
            this.guC.add(this.guB);
        }
    }
}
