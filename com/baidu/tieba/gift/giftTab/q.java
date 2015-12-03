package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.bf;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements a.b {
    final /* synthetic */ GiftTabActivity bvt;
    private final /* synthetic */ com.baidu.tbadk.core.dialog.a bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(GiftTabActivity giftTabActivity, com.baidu.tbadk.core.dialog.a aVar) {
        this.bvt = giftTabActivity;
        this.bvu = aVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        String str;
        String str2;
        this.bvu.dismiss();
        str = this.bvt.addFreeUrl;
        if (!StringUtils.isNull(str)) {
            this.bvt.bvl = true;
            bf vD = bf.vD();
            TbPageContext<?> pageContext = this.bvt.getPageContext();
            str2 = this.bvt.addFreeUrl;
            vD.b(pageContext, new String[]{str2});
        }
    }
}
