package com.baidu.tieba.game.view;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tbadk.game.GameInfoData;
import java.util.List;
/* loaded from: classes.dex */
class a extends CustomMessageListener {
    final /* synthetic */ GameDownloadView aKj;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(GameDownloadView gameDownloadView, int i) {
        super(i);
        this.aKj = gameDownloadView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
        if (r0.getGameId().equals(r1.getId()) != false) goto L17;
     */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        GameInfoData gameInfoData;
        DownloadData downloadData;
        d dVar;
        d dVar2;
        GameInfoData gameInfoData2;
        GameInfoData gameInfoData3;
        GameInfoData gameInfoData4;
        if (customResponsedMessage instanceof DownloadMessage) {
            gameInfoData = this.aKj.aKf;
            if (gameInfoData != null) {
                List<DownloadData> data = ((DownloadMessage) customResponsedMessage).getData();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= data.size()) {
                        break;
                    }
                    downloadData = data.get(i2);
                    gameInfoData3 = this.aKj.aKf;
                    if (!TextUtils.isEmpty(gameInfoData3.getGameId())) {
                        gameInfoData4 = this.aKj.aKf;
                    } else {
                        i = i2 + 1;
                    }
                }
                if (downloadData != null) {
                    if (downloadData.getStatus() == 1) {
                        this.aKj.v(((float) downloadData.getLength()) / ((float) downloadData.getSize()));
                    } else if (downloadData.getStatus() != 5) {
                        if (downloadData.getStatus() == 0) {
                            dVar = this.aKj.aKg;
                            if (dVar != null) {
                                dVar2 = this.aKj.aKg;
                                gameInfoData2 = this.aKj.aKf;
                                dVar2.a(gameInfoData2, downloadData);
                            }
                            this.aKj.Il();
                        } else if (downloadData.getStatus() == 2) {
                            this.aKj.t(((float) downloadData.getLength()) / ((float) downloadData.getSize()));
                        }
                    } else {
                        this.aKj.Io();
                    }
                }
            }
        }
    }
}
