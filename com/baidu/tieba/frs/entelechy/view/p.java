package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bk;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bk bkVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bkVar != null) {
            if (bkVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.bhK()) {
                String rW = bkVar.rW();
                cardGroupDividerView.setTitleText(rW);
                cardGroupDividerView.B(rW, !bkVar.isFirstFloor);
            } else {
                cardGroupDividerView.TT();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
