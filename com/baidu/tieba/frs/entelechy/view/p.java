package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bi;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bi biVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && biVar != null) {
            if (biVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.bjm()) {
                String sM = biVar.sM();
                cardGroupDividerView.setTitleText(sM);
                cardGroupDividerView.B(sM, !biVar.isFirstFloor);
                return;
            }
            cardGroupDividerView.Ty();
        }
    }
}
