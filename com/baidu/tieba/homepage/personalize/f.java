package com.baidu.tieba.homepage.personalize;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
class f extends CustomMessageListener {
    final /* synthetic */ b cuC;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(b bVar, int i) {
        super(i);
        this.cuC = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List<DownloadData> data;
        if (customResponsedMessage.getCmd() == 2001118 && (customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && data.size() != 0) {
            boolean z = false;
            for (DownloadData downloadData : data) {
                if (downloadData.getStatus() == 0) {
                    z = true;
                }
            }
            if (z) {
                com.baidu.adp.lib.g.h.fS().postDelayed(new g(this), TimeUnit.SECONDS.toMillis(2L));
            }
        }
    }
}
