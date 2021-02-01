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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.x, a> implements View.OnClickListener {
    private boolean jqu;
    private boolean jqv;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jqu = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jqv = z;
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
        if (xVar.dMQ()) {
            String dMR = xVar.dMR();
            if (dMR != null) {
                aVar.jqx.setText(dMR);
            } else if (this.jfG != null && this.jfG.getForum() != null && this.jfG.getForum().getName() != null) {
                TextView textView = aVar.jqx;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.jfG == null ? "" : this.jfG.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.jqw.setTag(Integer.valueOf(i));
            aVar.jqw.setOnClickListener(this);
            aVar.jqw.setVisibility(0);
        } else {
            aVar.jqw.setVisibility(8);
            aVar.jqD.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dMS = xVar.dMS();
        if (dMS != null && dMS.dMJ() && !TextUtils.isEmpty(dMS.dMK())) {
            aVar.jqz.setText(dMS.dMK());
            aVar.jqy.setTag(Integer.valueOf(i));
            aVar.jqy.setOnClickListener(this);
            aVar.jqy.setVisibility(0);
        } else {
            aVar.jqy.setVisibility(8);
            aVar.jqE.setVisibility(8);
        }
        if (this.jqv) {
            aVar.jqA.setVisibility(0);
        } else {
            aVar.jqA.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.jfG == null || this.jfG.getUserData() == null || !this.jfG.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jqB.setVisibility(0);
            ap.setBackgroundResource(aVar.jqB, R.drawable.frs_top_item_bg);
            aVar.jqA.setVisibility(0);
            aVar.jqB.setOnClickListener(this);
            aVar.jqB.setTag(Integer.valueOf(i));
        } else {
            aVar.jqB.setVisibility(8);
            aVar.jqF.setVisibility(8);
        }
        if (!this.jqu && !xVar.dMQ()) {
            if (z) {
                aVar.jqw.setVisibility(8);
                aVar.jqy.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jqG;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jfH != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof cb) {
                View C = C(this.iLK.getListView(), intValue);
                this.jfH.a(id, intValue, view, C, (cb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        View jqA;
        View jqB;
        TextView jqC;
        View jqD;
        View jqE;
        View jqF;
        List<View> jqG;
        View jqw;
        TextView jqx;
        View jqy;
        TextView jqz;

        a(View view) {
            super(view);
            this.jqG = new ArrayList();
            this.jqx = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jqw = view.findViewById(R.id.frs_fortune_bag_item);
            this.jqy = view.findViewById(R.id.frs_my_service_item);
            this.jqz = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jqA = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jqB = view.findViewById(R.id.frs_bawu_center);
            this.jqC = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jqD = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jqE = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jqF = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jqG.add(this.jqD);
            this.jqG.add(this.jqE);
            this.jqG.add(this.jqF);
        }
    }
}
