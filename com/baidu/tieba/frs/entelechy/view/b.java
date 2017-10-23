package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bh bhVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bhVar != null) {
            if (bhVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bso()) {
                String rM = bhVar.rM();
                cardGroupDividerView.setTitleText(rM);
                cardGroupDividerView.y(rM, !bhVar.isFirstFloor);
            } else {
                cardGroupDividerView.Ym();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
