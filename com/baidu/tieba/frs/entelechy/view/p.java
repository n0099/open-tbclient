package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bl blVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && blVar != null) {
            if (blVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.bje()) {
                String rS = blVar.rS();
                cardGroupDividerView.setTitleText(rS);
                cardGroupDividerView.y(rS, !blVar.isFirstFloor);
            } else {
                cardGroupDividerView.UX();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
