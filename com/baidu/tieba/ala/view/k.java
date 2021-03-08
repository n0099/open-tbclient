package com.baidu.tieba.ala.view;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.ala.data.PkInfoData;
import com.baidu.tieba.ala.data.PropsInfoData;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class k {
    Handler handler;
    PkRankInView iof;
    public ArrayList<PropsInfoData> iog;
    public ArrayList<PropsInfoData> ioh;

    public k(final PkRankInView pkRankInView) {
        this.iof = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.IN("1");
                        pkRankInView.cqm();
                        return;
                    case 2:
                        pkRankInView.pl(true);
                        return;
                    case 3:
                        pkRankInView.pl(false);
                        return;
                    case 10:
                        pkRankInView.cqp();
                        return;
                    case 20:
                        pkRankInView.pm(true);
                        return;
                    case 30:
                        pkRankInView.pm(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void g(PkInfoData pkInfoData) {
        this.iog = pkInfoData.myPkData.propsInfos;
        this.ioh = pkInfoData.otherPkData.propsInfos;
        if (!pkInfoData.myPkData.buffMultiple.equals("1")) {
            IN(pkInfoData.myPkData.buffMultiple);
            this.iof.IL(pkInfoData.myPkData.buffMultiple);
            x(1, pkInfoData.myPkData.buffMultipleEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        if (this.iog != null && this.iog.size() > 0) {
            Iterator<PropsInfoData> it = this.iog.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.iof.gTG.isHost && next2.gVb != this.iof.gTG.aLz.aJZ.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.iof.cqn();
                        x(2, aVar.endTime - next.nowTime);
                    } else {
                        this.iof.cqo();
                    }
                    x(3, next.endTime - next.nowTime);
                }
            }
        }
        if (!pkInfoData.otherPkData.buffMultiple.equals("1")) {
            this.iof.IM(pkInfoData.otherPkData.buffMultiple);
            x(10, pkInfoData.otherPkData.buffMultipleEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        if (this.ioh != null && this.ioh.size() > 0) {
            Iterator<PropsInfoData> it3 = this.ioh.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(2))) {
                    this.iof.cqq();
                    x(30, next3.endTime - next3.nowTime);
                }
            }
        }
    }

    private void x(final int i, final long j) {
        final Message obtain = Message.obtain();
        obtain.what = i;
        if (j < 1) {
            this.handler.sendMessage(obtain);
        } else {
            this.handler.post(new Runnable() { // from class: com.baidu.tieba.ala.view.k.2
                @Override // java.lang.Runnable
                public void run() {
                    k.this.handler.removeMessages(i);
                    k.this.handler.sendMessageDelayed(obtain, j * 1000);
                }
            });
        }
    }

    public void onDestroy() {
        IN("1");
        this.handler.removeCallbacksAndMessages(null);
    }

    public void IN(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, str));
    }
}
