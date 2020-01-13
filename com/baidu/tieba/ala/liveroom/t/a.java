package com.baidu.tieba.ala.liveroom.t;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.az;
import com.baidu.live.data.l;
import com.baidu.live.data.s;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.t.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.live.gift.c.a alR;
    private CustomMessageListener aqb;
    private CustomMessageListener eOE;
    private List<String> fgA;
    private InterfaceC0456a fgx;
    private b fgy;
    private String[] fgz;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;

    /* renamed from: com.baidu.tieba.ala.liveroom.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0456a {
        void bhG();

        void bhH();

        boolean uO();

        boolean vX();
    }

    public void a(InterfaceC0456a interfaceC0456a) {
        this.fgx = interfaceC0456a;
    }

    public void a(l lVar, String str) {
        this.mVid = "";
        if (lVar != null && lVar.mLiveInfo != null && lVar.mLiveInfo.feed_id != null) {
            this.mVid = lVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        boB();
        bkT();
    }

    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fgy = new b(this.mPageContext.getPageActivity());
        this.fgy.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.t.a.1
            @Override // com.baidu.tieba.ala.liveroom.t.b.a
            public boolean uO() {
                return a.this.fgx != null && a.this.fgx.uO();
            }

            @Override // com.baidu.tieba.ala.liveroom.t.b.a
            public void biO() {
                if (a.this.fgx != null) {
                    a.this.fgx.bhG();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.t.b.a
            public void onDismiss() {
                if (a.this.fgx != null) {
                    a.this.fgx.bhH();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.t.b.a
            public void a(int i, String str, az azVar) {
                if (a.this.fgx != null && a.this.fgx.uO()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (azVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = azVar.type;
                        imSendMsgData.barrageId = azVar.id;
                        imSendMsgData.price = azVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                a.this.dm(str);
                a.this.fgy.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(a.this.mVid, String.valueOf(i), str, a.this.mOtherParams);
            }

            @Override // com.baidu.tieba.ala.liveroom.t.b.a
            public boolean vX() {
                return a.this.fgx != null && a.this.fgx.vX();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fgy.D(boy());
            if (this.alR == null) {
                this.alR = new com.baidu.live.gift.c.a();
            }
            this.alR.tv();
        }
    }

    public void bN(int i) {
        if (this.fgy != null && this.fgy.isShowing()) {
            this.fgy.bN(i);
        }
    }

    public List<String> box() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.fgA == null) {
            this.fgA = new ArrayList();
        }
        this.fgA.clear();
        s sVar = com.baidu.live.s.a.wR().asq;
        if (sVar != null && (quickImInputData = sVar.YK) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.fgA.addAll(list);
        }
        if (this.fgA.isEmpty()) {
            Collections.addAll(this.fgA, boy());
        }
        return this.fgA;
    }

    public void dm(String str) {
        if (!TextUtils.isEmpty(str) && this.fgA != null && !this.fgA.isEmpty() && this.fgA.indexOf(str) > 1) {
            if (this.fgA.remove(str)) {
                this.fgA.add(1, str);
            }
            s sVar = com.baidu.live.s.a.wR().asq;
            if (sVar != null) {
                QuickImInputData quickImInputData = sVar.YK;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.fgA);
            }
        }
    }

    public void uk() {
        if (this.fgy != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.fgy.dismiss();
            }
            this.fgy = null;
            boC();
            bkU();
        }
    }

    public void release() {
        uk();
    }

    private String[] boy() {
        if (this.fgz == null || this.fgz.length == 0) {
            List<String> boz = boz();
            if (boz != null && !boz.isEmpty()) {
                this.fgz = (String[]) boz.toArray(new String[boz.size()]);
            } else {
                this.fgz = boA();
            }
        }
        return this.fgz;
    }

    private List<String> boz() {
        QuickImInputData quickImInputData;
        List<String> list;
        s sVar = com.baidu.live.s.a.wR().asq;
        if (sVar == null || (quickImInputData = sVar.YK) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] boA() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void boB() {
        if (this.eOE == null) {
            this.eOE = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.t.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.fgy != null && a.this.fgy.isShowing()) {
                        a.this.fgy.boD();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.eOE);
        }
    }

    private void bkT() {
        if (this.aqb == null) {
            this.aqb = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.t.a.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String)) {
                        String str = (String) customResponsedMessage.getData();
                        if (str == null) {
                            str = "";
                        }
                        a.this.mOtherParams = str;
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.aqb);
        }
    }

    private void boC() {
        if (this.eOE != null) {
            MessageManager.getInstance().unRegisterListener(this.eOE);
            this.eOE = null;
        }
    }

    private void bkU() {
        if (this.aqb != null) {
            MessageManager.getInstance().unRegisterListener(this.aqb);
        }
    }
}
