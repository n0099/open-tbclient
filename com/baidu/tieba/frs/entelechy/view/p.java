package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bm;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bm bmVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bmVar != null) {
            if (bmVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.bns()) {
                String rP = bmVar.rP();
                cardGroupDividerView.setTitleText(rP);
                cardGroupDividerView.A(rP, !bmVar.isFirstFloor);
            } else {
                cardGroupDividerView.Wo();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
