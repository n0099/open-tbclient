package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bj bjVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bjVar != null) {
            if (bjVar.needTopMargin && com.baidu.tieba.tbadkCore.util.g.btx()) {
                String rZ = bjVar.rZ();
                cardGroupDividerView.setTitleText(rZ);
                cardGroupDividerView.B(rZ, !bjVar.isFirstFloor);
            } else {
                cardGroupDividerView.YI();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
