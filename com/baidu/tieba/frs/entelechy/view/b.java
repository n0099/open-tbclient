package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes2.dex */
public class b {
    public static void a(bd bdVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bdVar != null) {
            if (bdVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bxS()) {
                String zM = bdVar.zM();
                cardGroupDividerView.setTitleText(zM);
                cardGroupDividerView.w(zM, !bdVar.isFirstFloor);
            } else {
                cardGroupDividerView.alW();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
