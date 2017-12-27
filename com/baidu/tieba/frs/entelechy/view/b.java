package com.baidu.tieba.frs.entelechy.view;

import com.baidu.tbadk.core.data.be;
import com.baidu.tieba.card.divider.CardGroupDividerView;
/* loaded from: classes2.dex */
public class b {
    public static void a(be beVar, CardGroupDividerView cardGroupDividerView) {
        if (cardGroupDividerView != null && beVar != null) {
            if (beVar.needTopMargin && com.baidu.tieba.tbadkCore.util.f.bDl()) {
                String zw = beVar.zw();
                cardGroupDividerView.setTitleText(zw);
                cardGroupDividerView.z(zw, !beVar.isFirstFloor);
            } else {
                cardGroupDividerView.akg();
            }
            cardGroupDividerView.getBotttomLine().setVisibility(8);
        }
    }
}
