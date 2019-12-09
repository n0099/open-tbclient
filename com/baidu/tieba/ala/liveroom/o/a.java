package com.baidu.tieba.ala.liveroom.o;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.ao;
import com.baidu.live.data.i;
import com.baidu.live.data.o;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.o.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private com.baidu.live.gift.c.a adg;
    private String ahX;
    private CustomMessageListener ahl;
    private CustomMessageListener dXu;
    private InterfaceC0362a emS;
    private b emT;
    private String[] emU;
    private List<String> emV;
    private String mOtherParams;
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0362a {
        void aPx();

        void aPy();

        boolean sG();
    }

    public void a(InterfaceC0362a interfaceC0362a) {
        this.emS = interfaceC0362a;
    }

    public void a(i iVar, String str) {
        this.ahX = "";
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.feed_id != null) {
            this.ahX = iVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        aVI();
        aSk();
    }

    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.emT = new b(this.mPageContext.getPageActivity());
        this.emT.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean sG() {
                return a.this.emS != null && a.this.emS.sG();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void aav() {
                if (a.this.emS != null) {
                    a.this.emS.aPx();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onDismiss() {
                if (a.this.emS != null) {
                    a.this.emS.aPy();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void a(int i, String str, ao aoVar) {
                if (a.this.emS != null && a.this.emS.sG()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (aoVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageId = aoVar.id;
                        imSendMsgData.price = aoVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                a.this.cs(str);
                a.this.emT.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(a.this.ahX, String.valueOf(i), str, a.this.mOtherParams);
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.emT.u(aVF());
            if (this.adg == null) {
                this.adg = new com.baidu.live.gift.c.a();
            }
            this.adg.rp();
        }
    }

    public void bw(int i) {
        if (this.emT != null && this.emT.isShowing()) {
            this.emT.bw(i);
        }
    }

    public List<String> aVE() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.emV == null) {
            this.emV = new ArrayList();
        }
        this.emV.clear();
        o oVar = com.baidu.live.l.a.uB().ajF;
        if (oVar != null && (quickImInputData = oVar.RJ) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.emV.addAll(list);
        }
        if (this.emV.isEmpty()) {
            Collections.addAll(this.emV, aVF());
        }
        return this.emV;
    }

    public void cs(String str) {
        if (!TextUtils.isEmpty(str) && this.emV != null && !this.emV.isEmpty() && this.emV.indexOf(str) > 1) {
            if (this.emV.remove(str)) {
                this.emV.add(1, str);
            }
            o oVar = com.baidu.live.l.a.uB().ajF;
            if (oVar != null) {
                QuickImInputData quickImInputData = oVar.RJ;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.emV);
            }
        }
    }

    public void aRV() {
        if (this.emT != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.emT.dismiss();
            }
            this.emT = null;
            aVJ();
            aSl();
        }
    }

    public void release() {
        aRV();
    }

    private String[] aVF() {
        if (this.emU == null || this.emU.length == 0) {
            List<String> aVG = aVG();
            if (aVG != null && !aVG.isEmpty()) {
                this.emU = (String[]) aVG.toArray(new String[aVG.size()]);
            } else {
                this.emU = aVH();
            }
        }
        return this.emU;
    }

    private List<String> aVG() {
        QuickImInputData quickImInputData;
        List<String> list;
        o oVar = com.baidu.live.l.a.uB().ajF;
        if (oVar == null || (quickImInputData = oVar.RJ) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] aVH() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void aVI() {
        if (this.dXu == null) {
            this.dXu = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.emT != null && a.this.emT.isShowing()) {
                        a.this.emT.aVK();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.dXu);
        }
    }

    private void aSk() {
        if (this.ahl == null) {
            this.ahl = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
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
            MessageManager.getInstance().registerListener(this.ahl);
        }
    }

    private void aVJ() {
        if (this.dXu != null) {
            MessageManager.getInstance().unRegisterListener(this.dXu);
            this.dXu = null;
        }
    }

    private void aSl() {
        if (this.ahl != null) {
            MessageManager.getInstance().unRegisterListener(this.ahl);
        }
    }
}
