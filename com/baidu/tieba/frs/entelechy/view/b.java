package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bd bdVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bdVar != null) {
            if (bdVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bxV()) {
                String rU = bdVar.rU();
                cardGroupDividerView.setTitleText(rU);
                cardGroupDividerView.z(rU, !bdVar.isFirstFloor);
            } else {
                cardGroupDividerView.acA();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
