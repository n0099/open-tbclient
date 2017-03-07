package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bj;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes.dex */
public class p {
    public static void a(bj bjVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bjVar != null) {
            if (bjVar.needTopMargin && com.baidu.tieba.tbadkCore.util.s.biB()) {
                String so = bjVar.so();
                cardGroupDividerView.setTitleText(so);
                cardGroupDividerView.B(so, !bjVar.isFirstFloor);
                return;
            }
            cardGroupDividerView.Ta();
        }
    }
}
