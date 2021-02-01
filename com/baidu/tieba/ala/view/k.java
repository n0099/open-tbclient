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
/* loaded from: classes11.dex */
public class k {
    Handler handler;
    PkRankInView imh;
    public ArrayList<PropsInfoData> imi;
    public ArrayList<PropsInfoData> imj;

    public k(final PkRankInView pkRankInView) {
        this.imh = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.ID("1");
                        pkRankInView.cpZ();
                        return;
                    case 2:
                        pkRankInView.pl(true);
                        return;
                    case 3:
                        pkRankInView.pl(false);
                        return;
                    case 10:
                        pkRankInView.cqc();
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
        this.imi = pkInfoData.myPkData.propsInfos;
        this.imj = pkInfoData.otherPkData.propsInfos;
        if (!pkInfoData.myPkData.buffMultiple.equals("1")) {
            ID(pkInfoData.myPkData.buffMultiple);
            this.imh.IB(pkInfoData.myPkData.buffMultiple);
            x(1, pkInfoData.myPkData.buffMultipleEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        if (this.imi != null && this.imi.size() > 0) {
            Iterator<PropsInfoData> it = this.imi.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.imh.gRJ.isHost && next2.gTe != this.imh.gRJ.aJZ.aIz.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.imh.cqa();
                        x(2, aVar.endTime - next.nowTime);
                    } else {
                        this.imh.cqb();
                    }
                    x(3, next.endTime - next.nowTime);
                }
            }
        }
        if (!pkInfoData.otherPkData.buffMultiple.equals("1")) {
            this.imh.IC(pkInfoData.otherPkData.buffMultiple);
            x(10, pkInfoData.otherPkData.buffMultipleEndTime - pkInfoData.pkStatusInfoData.nowTime);
        }
        if (this.imj != null && this.imj.size() > 0) {
            Iterator<PropsInfoData> it3 = this.imj.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(2))) {
                    this.imh.cqd();
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
        ID("1");
        this.handler.removeCallbacksAndMessages(null);
    }

    public void ID(String str) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, str));
    }
}
