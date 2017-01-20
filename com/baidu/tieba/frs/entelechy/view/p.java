package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bh bhVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bhVar != null) {
            if (bhVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.biL()) {
                String rU = bhVar.rU();
                cardGroupDividerView.setTitleText(rU);
                cardGroupDividerView.A(rU, !bhVar.isFirstFloor);
                return;
            }
            cardGroupDividerView.Sc();
        }
    }
}
