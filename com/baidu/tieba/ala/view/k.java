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
/* loaded from: classes4.dex */
public class k {
    Handler handler;
    PkRankInView hhc;
    public ArrayList<PropsInfoData> hhd;
    public ArrayList<PropsInfoData> hhe;

    public k(final PkRankInView pkRankInView) {
        this.hhc = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.l(false);
                        pkRankInView.cde();
                        return;
                    case 2:
                        pkRankInView.nd(true);
                        return;
                    case 3:
                        pkRankInView.nd(false);
                        return;
                    case 10:
                        pkRankInView.cdi();
                        return;
                    case 20:
                        pkRankInView.ne(true);
                        return;
                    case 30:
                        pkRankInView.ne(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void f(PkInfoData pkInfoData) {
        this.hhd = pkInfoData.myPkData.propsInfos;
        this.hhe = pkInfoData.otherPkData.propsInfos;
        if (this.hhd != null && this.hhd.size() > 0) {
            Iterator<PropsInfoData> it = this.hhd.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(1))) {
                    l(true);
                    this.hhc.cdd();
                    w(1, next.endTime - next.nowTime);
                } else if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.hhc.fXi.isHost && next2.fYu != this.hhc.fXi.aFP.aFb.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.hhc.cdf();
                        w(2, aVar.endTime - next.nowTime);
                    } else {
                        this.hhc.cdg();
                    }
                    w(3, next.endTime - next.nowTime);
                }
            }
        }
        if (this.hhe != null && this.hhe.size() > 0) {
            Iterator<PropsInfoData> it3 = this.hhe.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(1))) {
                    this.hhc.cdh();
                    w(10, next3.endTime - next3.nowTime);
                } else if (next3.propsType.equals(String.valueOf(2))) {
                    this.hhc.cdj();
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
        l(false);
        this.handler.removeCallbacksAndMessages(null);
    }

    public void l(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, bool));
    }
}
