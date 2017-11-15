package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bh bhVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bhVar != null) {
            if (bhVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bvE()) {
                String rS = bhVar.rS();
                cardGroupDividerView.setTitleText(rS);
                cardGroupDividerView.w(rS, !bhVar.isFirstFloor);
            } else {
                cardGroupDividerView.aaI();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
