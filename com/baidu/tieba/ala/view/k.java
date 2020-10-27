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
    PkRankInView hIv;
    public ArrayList<PropsInfoData> hIw;
    public ArrayList<PropsInfoData> hIx;
    Handler handler;

    public k(final PkRankInView pkRankInView) {
        this.hIv = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.m(false);
                        pkRankInView.cjH();
                        return;
                    case 2:
                        pkRankInView.oa(true);
                        return;
                    case 3:
                        pkRankInView.oa(false);
                        return;
                    case 10:
                        pkRankInView.cjL();
                        return;
                    case 20:
                        pkRankInView.ob(true);
                        return;
                    case 30:
                        pkRankInView.ob(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void f(PkInfoData pkInfoData) {
        this.hIw = pkInfoData.myPkData.propsInfos;
        this.hIx = pkInfoData.otherPkData.propsInfos;
        if (this.hIw != null && this.hIw.size() > 0) {
            Iterator<PropsInfoData> it = this.hIw.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(1))) {
                    m(true);
                    this.hIv.cjG();
                    x(1, next.endTime - next.nowTime);
                } else if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.hIv.gtC.isHost && next2.guT != this.hIv.gtC.aJv.aIA.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.hIv.cjI();
                        x(2, aVar.endTime - next.nowTime);
                    } else {
                        this.hIv.cjJ();
                    }
                    x(3, next.endTime - next.nowTime);
                }
            }
        }
        if (this.hIx != null && this.hIx.size() > 0) {
            Iterator<PropsInfoData> it3 = this.hIx.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(1))) {
                    this.hIv.cjK();
                    x(10, next3.endTime - next3.nowTime);
                } else if (next3.propsType.equals(String.valueOf(2))) {
                    this.hIv.cjM();
                    x(30, next3.endTime - next3.nowTime);
                }
            }
        }
    }

    private void x(int i, long j) {
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
        m(false);
        this.handler.removeCallbacksAndMessages(null);
    }

    public void m(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, bool));
    }
}
