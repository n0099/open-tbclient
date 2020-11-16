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
    PkRankInView hNZ;
    public ArrayList<PropsInfoData> hOa;
    public ArrayList<PropsInfoData> hOb;
    Handler handler;

    public k(final PkRankInView pkRankInView) {
        this.hNZ = pkRankInView;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.ala.view.k.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        k.this.m(false);
                        pkRankInView.clC();
                        return;
                    case 2:
                        pkRankInView.ok(true);
                        return;
                    case 3:
                        pkRankInView.ok(false);
                        return;
                    case 10:
                        pkRankInView.clG();
                        return;
                    case 20:
                        pkRankInView.ol(true);
                        return;
                    case 30:
                        pkRankInView.ol(false);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void f(PkInfoData pkInfoData) {
        this.hOa = pkInfoData.myPkData.propsInfos;
        this.hOb = pkInfoData.otherPkData.propsInfos;
        if (this.hOa != null && this.hOa.size() > 0) {
            Iterator<PropsInfoData> it = this.hOa.iterator();
            while (it.hasNext()) {
                PropsInfoData next = it.next();
                if (next.propsType.equals(String.valueOf(1))) {
                    m(true);
                    this.hNZ.clB();
                    w(1, next.endTime - next.nowTime);
                } else if (next.propsType.equals(String.valueOf(2))) {
                    PropsInfoData.a aVar = null;
                    Iterator<PropsInfoData.a> it2 = next.propsUserDataList.iterator();
                    while (it2.hasNext()) {
                        PropsInfoData.a next2 = it2.next();
                        if (!this.hNZ.gyX.isHost && next2.gAo != this.hNZ.gyX.aIK.aHG.userId) {
                            next2 = aVar;
                        }
                        aVar = next2;
                    }
                    if (aVar != null) {
                        this.hNZ.clD();
                        w(2, aVar.endTime - next.nowTime);
                    } else {
                        this.hNZ.clE();
                    }
                    w(3, next.endTime - next.nowTime);
                }
            }
        }
        if (this.hOb != null && this.hOb.size() > 0) {
            Iterator<PropsInfoData> it3 = this.hOb.iterator();
            while (it3.hasNext()) {
                PropsInfoData next3 = it3.next();
                if (next3.propsType.equals(String.valueOf(1))) {
                    this.hNZ.clF();
                    w(10, next3.endTime - next3.nowTime);
                } else if (next3.propsType.equals(String.valueOf(2))) {
                    this.hNZ.clH();
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
        m(false);
        this.handler.removeCallbacksAndMessages(null);
    }

    public void m(Boolean bool) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913238, bool));
    }
}
