package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bl;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bl blVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && blVar != null) {
            if (blVar.needTopMargin && com.baidu.tieba.tbadkCore.util.g.btX()) {
                String se = blVar.se();
                cardGroupDividerView.setTitleText(se);
                cardGroupDividerView.A(se, !blVar.isFirstFloor);
            } else {
                cardGroupDividerView.Xu();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
