package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.bd;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes2.dex */
public class b {
    public static void a(bd bdVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && bdVar != null) {
            if (bdVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bwI()) {
                String zr = bdVar.zr();
                cardGroupDividerView.setTitleText(zr);
                cardGroupDividerView.z(zr, !bdVar.isFirstFloor);
            } else {
                cardGroupDividerView.alj();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
