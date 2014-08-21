package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class g extends CustomMessageListener {
    final /* synthetic */ GameCenterHomeActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(GameCenterHomeActivity gameCenterHomeActivity, int i) {
        super(i);
        this.a = gameCenterHomeActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        n nVar5;
        n nVar6;
        n nVar7;
        if (customResponsedMessage instanceof DownloadMessage) {
            nVar = this.a.a;
            List<com.baidu.tbadk.game.b> c = nVar.c();
            List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
            for (int i = 0; i < data.size(); i++) {
                DownloadData downloadData = data.get(i);
                int i2 = 0;
                while (true) {
                    if (i2 >= c.size()) {
                        i2 = -1;
                        break;
                    }
                    String a = c.get(i2).a();
                    if (!TextUtils.isEmpty(a) && a.equals(downloadData.getId())) {
                        break;
                    }
                    i2++;
                }
                if (i2 != -1) {
                    if (data.get(i).getStatus() == 0) {
                        nVar4 = this.a.a;
                        List<com.baidu.tbadk.game.b> d = nVar4.d();
                        nVar5 = this.a.a;
                        d.add(nVar5.c().get(i2));
                        ae a2 = ae.a();
                        nVar6 = this.a.a;
                        a2.i(nVar6.c().get(i2));
                        nVar7 = this.a.a;
                        nVar7.c().remove(i2);
                    } else if (data.get(i).getStatus() == 2) {
                        nVar3 = this.a.a;
                        nVar3.c().get(i2).c(3);
                    }
                }
            }
            nVar2 = this.a.a;
            nVar2.e();
            return;
        }
        this.a.showToast(this.a.getResources().getString(com.baidu.tieba.x.neterror));
    }
}
