package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bg bgVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bgVar != null) {
            if (bgVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.bha()) {
                String sc = bgVar.sc();
                cardGroupDividerView.setTitleText(sc);
                cardGroupDividerView.y(sc, !bgVar.isFirstFloor);
                return;
            }
            cardGroupDividerView.Pn();
        }
    }
}
