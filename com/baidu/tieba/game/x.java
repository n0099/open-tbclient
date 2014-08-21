package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class x extends CustomMessageListener {
    final /* synthetic */ GameDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.a = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tbadk.game.b bVar;
        com.baidu.tbadk.game.b bVar2;
        com.baidu.tbadk.game.b bVar3;
        com.baidu.tbadk.game.b bVar4;
        aa aaVar;
        com.baidu.tbadk.game.b bVar5;
        com.baidu.tbadk.game.b bVar6;
        com.baidu.tbadk.game.b bVar7;
        if (customResponsedMessage instanceof DownloadMessage) {
            bVar = this.a.b;
            if (bVar != null) {
                bVar2 = this.a.b;
                if (!TextUtils.isEmpty(bVar2.a())) {
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < data.size()) {
                            DownloadData downloadData = data.get(i2);
                            bVar3 = this.a.b;
                            if (!bVar3.a().equals(downloadData.getId())) {
                                i = i2 + 1;
                            } else {
                                if (downloadData.getStatus() == 0) {
                                    bVar6 = this.a.b;
                                    bVar6.c(4);
                                    ae a = ae.a();
                                    bVar7 = this.a.b;
                                    a.i(bVar7);
                                } else if (downloadData.getStatus() == 2) {
                                    bVar4 = this.a.b;
                                    bVar4.c(3);
                                }
                                aaVar = this.a.a;
                                bVar5 = this.a.b;
                                aaVar.a(bVar5);
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        } else {
            this.a.showToast(this.a.getString(com.baidu.tieba.x.neterror));
        }
    }
}
