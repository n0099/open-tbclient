package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bh;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class b {
    public static void a(bh bhVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bhVar != null) {
            if (bhVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bsw()) {
                String rT = bhVar.rT();
                cardGroupDividerView.setTitleText(rT);
                cardGroupDividerView.y(rT, !bhVar.isFirstFloor);
            } else {
                cardGroupDividerView.Yq();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
