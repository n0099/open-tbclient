package com.baidu.tieba.frs;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
/* loaded from: classes.dex */
public class cp extends bm<com.baidu.tieba.data.af> implements View.OnClickListener {
    /* JADX INFO: Access modifiers changed from: protected */
    public cp(FrsActivity frsActivity, BdUniqueId bdUniqueId) {
        super(frsActivity, bdUniqueId);
    }

    @Override // com.baidu.adp.widget.ListView.a
    protected View a(ViewGroup viewGroup) {
        cq cqVar = new cq(null);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, com.baidu.tieba.w.frs_official_account_item, null);
        cqVar.aDG = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_fortune_bag_content);
        cqVar.aDF = inflate.findViewById(com.baidu.tieba.v.frs_fortune_bag_item);
        cqVar.aDH = inflate.findViewById(com.baidu.tieba.v.frs_my_service_item);
        cqVar.aDI = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_my_service_content);
        inflate.setTag(cqVar);
        return inflate;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.bm, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View b(int i, View view, ViewGroup viewGroup, com.baidu.tieba.data.af afVar) {
        super.b(i, view, viewGroup, afVar);
        cq cqVar = (cq) view.getTag();
        if (afVar.zF()) {
            String zG = afVar.zG();
            if (zG != null) {
                cqVar.aDG.setText(zG);
            } else if (this.aBV.zJ() != null && this.aBV.zJ().getName() != null) {
                cqVar.aDG.setText(this.mContext.getString(com.baidu.tieba.y.get_fortune_hint_format, this.aBV.zJ().getName()));
            }
            cqVar.aDF.setTag(Integer.valueOf(i));
            cqVar.aDF.setOnClickListener(this);
            cqVar.aDF.setVisibility(0);
        } else {
            cqVar.aDF.setVisibility(8);
        }
        com.baidu.tieba.data.u zH = afVar.zH();
        if (zH != null && zH.zo() && !TextUtils.isEmpty(zH.zp())) {
            cqVar.aDI.setText(zH.zp());
            cqVar.aDH.setTag(Integer.valueOf(i));
            cqVar.aDH.setOnClickListener(this);
            cqVar.aDH.setVisibility(0);
        } else {
            cqVar.aDH.setVisibility(8);
        }
        this.aBp.getLayoutMode().L(this.mSkinType == 1);
        this.aBp.getLayoutMode().h(view);
        return view;
    }

    public int FO() {
        return com.baidu.tieba.v.frs_fortune_bag_item;
    }

    public int FP() {
        return com.baidu.tieba.v.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aBW != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.ayV.getChildAt(intValue - (this.ayV.getFirstVisiblePosition() - this.ayV.getHeaderViewsCount()));
            this.aBW.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.q) ai(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cq);
    }
}
