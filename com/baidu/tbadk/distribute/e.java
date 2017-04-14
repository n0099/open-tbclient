package com.baidu.tbadk.distribute;

import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e extends CustomMessageListener {
    final /* synthetic */ a aym;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(a aVar, int i) {
        super(i);
        this.aym = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        List<DownloadData> data;
        if ((customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && !data.isEmpty()) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < data.size()) {
                    DownloadData downloadData = data.get(i2);
                    if (downloadData.getType() == 12) {
                        switch (downloadData.getStatus()) {
                            case 0:
                            case 2:
                            case 4:
                                this.aym.v(downloadData.getId(), downloadData.getStatus());
                                continue;
                            case 1:
                                this.aym.a(downloadData.getId(), downloadData.getDownloadStaticsData());
                                continue;
                            case 5:
                                this.aym.a(downloadData.getDownloadStaticsData());
                                continue;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }
}
