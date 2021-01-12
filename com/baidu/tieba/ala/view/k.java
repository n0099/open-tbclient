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
    PkRankInView igN;
    public ArrayList<PropsInfoData> igO;
    public ArrayList<PropsInfoData> igP;

    public k(final PkRankInView pkRankInView) {
        this.igN = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.n(false);
                        pkRankInView.coU();
                        return;
                    case 2:
                        pkRankInView.pb(true);
                        return;
                    case 3:
                        pkRankInView.pb(false);
                        return;
                    case 10:
                        pkRankInView.coY();
                        return;
                    case 20:
                        pkRankInView.pc(true);
                        return;
                    case 30:
                        pkRankInView.pc(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void f(PkInfoData pkInfoData) {
        this.igO = pkInfoData.myPkData.propsInfos;
        this.igP = pkInfoData.otherPkData.propsInfos;
        if (this.igO != null && this.igO.size() > 0) {
            Iterator<PropsInfoData> it = this.igO.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(1))) {
                    n(true);
                    this.igN.coT();
                    w(1, next.endTime - next.nowTime);
                } else if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.igN.gPb.isHost && next2.gQu != this.igN.gPb.aHu.aGd.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.igN.coV();
                        w(2, aVar.endTime - next.nowTime);
                    } else {
                        this.igN.coW();
                    }
                    w(3, next.endTime - next.nowTime);
                }
            }
        }
        if (this.igP != null && this.igP.size() > 0) {
            Iterator<PropsInfoData> it3 = this.igP.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(1))) {
                    this.igN.coX();
                    w(10, next3.endTime - next3.nowTime);
                } else if (next3.propsType.equals(String.valueOf(2))) {
                    this.igN.coZ();
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
