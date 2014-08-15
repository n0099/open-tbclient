package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* loaded from: classes.dex */
class w extends CustomMessageListener {
    final /* synthetic */ GameDetailActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(GameDetailActivity gameDetailActivity, int i) {
        super(i);
        this.a = gameDetailActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ab abVar;
        ab abVar2;
        ab abVar3;
        ab abVar4;
        z zVar;
        ab abVar5;
        ab abVar6;
        ab abVar7;
        if (customResponsedMessage instanceof DownloadMessage) {
            abVar = this.a.b;
            if (abVar != null) {
                abVar2 = this.a.b;
                if (!TextUtils.isEmpty(abVar2.a())) {
                    List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 < data.size()) {
                            DownloadData downloadData = data.get(i2);
                            abVar3 = this.a.b;
                            if (!abVar3.a().equals(downloadData.getId())) {
                                i = i2 + 1;
                            } else {
                                if (downloadData.getStatus() == 0) {
                                    abVar6 = this.a.b;
                                    abVar6.c(4);
                                    ac a = ac.a();
                                    abVar7 = this.a.b;
                                    a.i(abVar7);
                                } else if (downloadData.getStatus() == 2) {
                                    abVar4 = this.a.b;
                                    abVar4.c(3);
                                }
                                zVar = this.a.a;
                                abVar5 = this.a.b;
                                zVar.a(abVar5);
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
