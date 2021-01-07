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
    PkRankInView ilu;
    public ArrayList<PropsInfoData> ilv;
    public ArrayList<PropsInfoData> ilw;

    public k(final PkRankInView pkRankInView) {
        this.ilu = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.n(false);
                        pkRankInView.csM();
                        return;
                    case 2:
                        pkRankInView.pf(true);
                        return;
                    case 3:
                        pkRankInView.pf(false);
                        return;
                    case 10:
                        pkRankInView.csQ();
                        return;
                    case 20:
                        pkRankInView.pg(true);
                        return;
                    case 30:
                        pkRankInView.pg(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void f(PkInfoData pkInfoData) {
        this.ilv = pkInfoData.myPkData.propsInfos;
        this.ilw = pkInfoData.otherPkData.propsInfos;
        if (this.ilv != null && this.ilv.size() > 0) {
            Iterator<PropsInfoData> it = this.ilv.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(1))) {
                    n(true);
                    this.ilu.csL();
                    w(1, next.endTime - next.nowTime);
                } else if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.ilu.gTH.isHost && next2.gVa != this.ilu.gTH.aMh.aKQ.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.ilu.csN();
                        w(2, aVar.endTime - next.nowTime);
                    } else {
                        this.ilu.csO();
                    }
                    w(3, next.endTime - next.nowTime);
                }
            }
        }
        if (this.ilw != null && this.ilw.size() > 0) {
            Iterator<PropsInfoData> it3 = this.ilw.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(1))) {
                    this.ilu.csP();
                    w(10, next3.endTime - next3.nowTime);
                } else if (next3.propsType.equals(String.valueOf(2))) {
                    this.ilu.csR();
                    w(30, next3.endTime - next3.nowTime);
                }
            }
        }
    }

    private void w(int i, long j) {
        Message obtain = Message.obtain();
        obtain.what = i;
        if (j == 1 || j == 0) {
            this.handler.sendMessage(obtain);
            return;
        }
        this.handler.removeMessages(i);
        this.handler.sendMessageDelayed(obtain, 1000 * j);
    }

    public void onDestroy() {
        n(false);
        this.handler.removeCallbacksAndMessages(null);
    }

    public void n(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, bool));
    }
}
