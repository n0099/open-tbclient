package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bj bjVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bjVar != null) {
            if (bjVar.needTopMargin && com.baidu.tieba.tbadkCore.util.g.btm()) {
                String rZ = bjVar.rZ();
                cardGroupDividerView.setTitleText(rZ);
                cardGroupDividerView.B(rZ, !bjVar.isFirstFloor);
            } else {
                cardGroupDividerView.Yx();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
