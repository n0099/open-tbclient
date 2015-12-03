package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.gift.send.b;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
/* loaded from: classes.dex */
class v implements b.a {
    final /* synthetic */ GiftTabActivity bvt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(GiftTabActivity giftTabActivity) {
        this.bvt = giftTabActivity;
    }

    @Override // com.baidu.tieba.gift.send.b.a
    public void Tg() {
        ad adVar;
        adVar = this.bvt.bvf;
        adVar.Tm();
        this.bvt.showToast(n.i.gift_send_data_illegal);
    }

    @Override // com.baidu.tieba.gift.send.b.a
    public void c(int i, String str, int i2) {
        ad adVar;
        com.baidu.tbadk.core.data.l lVar;
        adVar = this.bvt.bvf;
        adVar.Tm();
        if (i != 0) {
            new com.baidu.tbadk.core.view.g(this.bvt.getPageContext()).e(this.bvt.getResources().getString(n.i.send_gift_fail));
            return;
        }
        new com.baidu.tbadk.core.view.g(this.bvt.getPageContext()).d(this.bvt.getResources().getString(n.i.send_gift_succeed));
        lVar = this.bvt.bvj;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, lVar));
        Intent intent = new Intent();
        intent.putExtra(ImagesInvalidReceiver.SUCCESS, true);
        this.bvt.setResult(-1, intent);
        this.bvt.finish();
    }

    @Override // com.baidu.tieba.gift.send.b.a
    public void a(int i, String str, com.baidu.tieba.gift.send.a aVar) {
        ad adVar;
        adVar = this.bvt.bvf;
        adVar.Tm();
        if (i != 0) {
            if (StringUtils.isNull(str)) {
                this.bvt.showToast(n.i.neterror);
            } else {
                this.bvt.showToast(str);
            }
        } else if (aVar != null) {
            this.bvt.bvk = aVar;
            PaymentConfirmRequestData Ty = aVar.Ty();
            Ty.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
            this.bvt.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PaymentConfirmActivityConfig(this.bvt.getPageContext().getPageActivity(), Ty)));
        }
    }
}
