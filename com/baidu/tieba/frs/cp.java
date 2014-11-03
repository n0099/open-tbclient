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
        cqVar.aDQ = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_fortune_bag_content);
        cqVar.aDP = inflate.findViewById(com.baidu.tieba.v.frs_fortune_bag_item);
        cqVar.aDR = inflate.findViewById(com.baidu.tieba.v.frs_my_service_item);
        cqVar.aDS = (TextView) inflate.findViewById(com.baidu.tieba.v.frs_my_service_content);
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
        if (afVar.zH()) {
            String zI = afVar.zI();
            if (zI != null) {
                cqVar.aDQ.setText(zI);
            } else if (this.aCf.zL() != null && this.aCf.zL().getName() != null) {
                cqVar.aDQ.setText(this.mContext.getString(com.baidu.tieba.y.get_fortune_hint_format, this.aCf.zL().getName()));
            }
            cqVar.aDP.setTag(Integer.valueOf(i));
            cqVar.aDP.setOnClickListener(this);
            cqVar.aDP.setVisibility(0);
        } else {
            cqVar.aDP.setVisibility(8);
        }
        com.baidu.tieba.data.u zJ = afVar.zJ();
        if (zJ != null && zJ.zq() && !TextUtils.isEmpty(zJ.zr())) {
            cqVar.aDS.setText(zJ.zr());
            cqVar.aDR.setTag(Integer.valueOf(i));
            cqVar.aDR.setOnClickListener(this);
            cqVar.aDR.setVisibility(0);
        } else {
            cqVar.aDR.setVisibility(8);
        }
        this.aBz.getLayoutMode().L(this.mSkinType == 1);
        this.aBz.getLayoutMode().h(view);
        return view;
    }

    public int FQ() {
        return com.baidu.tieba.v.frs_fortune_bag_item;
    }

    public int FR() {
        return com.baidu.tieba.v.frs_my_service_item;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.aCg != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            View childAt = this.aze.getChildAt(intValue - (this.aze.getFirstVisiblePosition() - this.aze.getHeaderViewsCount()));
            this.aCg.a(id, intValue, view, childAt, (com.baidu.tbadk.core.data.q) ai(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public boolean d(View view) {
        return super.d(view) || !(view.getTag() instanceof cq);
    }
}
