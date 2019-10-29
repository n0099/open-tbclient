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
    private com.baidu.live.gift.c.a ady;
    private CustomMessageListener ahD;
    private String aiq;
    private CustomMessageListener dYl;
    private InterfaceC0367a enL;
    private b enM;
    private String[] enN;
    private List<String> enO;
    private String mOtherParams;
    private TbPageContext mPageContext;

    /* renamed from: com.baidu.tieba.ala.liveroom.o.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC0367a {
        void aPA();

        void aPz();

        boolean sF();
    }

    public void a(InterfaceC0367a interfaceC0367a) {
        this.enL = interfaceC0367a;
    }

    public void a(i iVar, String str) {
        this.aiq = "";
        if (iVar != null && iVar.mLiveInfo != null && iVar.mLiveInfo.feed_id != null) {
            this.aiq = iVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        aVK();
        aSm();
    }

    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.enM = new b(this.mPageContext.getPageActivity());
        this.enM.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.o.a.1
            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public boolean sF() {
                return a.this.enL != null && a.this.enL.sF();
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void aax() {
                if (a.this.enL != null) {
                    a.this.enL.aPz();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void onDismiss() {
                if (a.this.enL != null) {
                    a.this.enL.aPA();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.o.b.a
            public void a(int i, String str, ao aoVar) {
                if (a.this.enL != null && a.this.enL.sF()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (aoVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageId = aoVar.id;
                        imSendMsgData.price = aoVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                a.this.cs(str);
                a.this.enM.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(a.this.aiq, String.valueOf(i), str, a.this.mOtherParams);
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.enM.u(aVH());
            if (this.ady == null) {
                this.ady = new com.baidu.live.gift.c.a();
            }
            this.ady.ro();
        }
    }

    public void bw(int i) {
        if (this.enM != null && this.enM.isShowing()) {
            this.enM.bw(i);
        }
    }

    public List<String> aVG() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.enO == null) {
            this.enO = new ArrayList();
        }
        this.enO.clear();
        o oVar = com.baidu.live.l.a.uA().ajX;
        if (oVar != null && (quickImInputData = oVar.Sm) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.enO.addAll(list);
        }
        if (this.enO.isEmpty()) {
            Collections.addAll(this.enO, aVH());
        }
        return this.enO;
    }

    public void cs(String str) {
        if (!TextUtils.isEmpty(str) && this.enO != null && !this.enO.isEmpty() && this.enO.indexOf(str) > 1) {
            if (this.enO.remove(str)) {
                this.enO.add(1, str);
            }
            o oVar = com.baidu.live.l.a.uA().ajX;
            if (oVar != null) {
                QuickImInputData quickImInputData = oVar.Sm;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.enO);
            }
        }
    }

    public void aRX() {
        if (this.enM != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.enM.dismiss();
            }
            this.enM = null;
            aVL();
            aSn();
        }
    }

    public void release() {
        aRX();
    }

    private String[] aVH() {
        if (this.enN == null || this.enN.length == 0) {
            List<String> aVI = aVI();
            if (aVI != null && !aVI.isEmpty()) {
                this.enN = (String[]) aVI.toArray(new String[aVI.size()]);
            } else {
                this.enN = aVJ();
            }
        }
        return this.enN;
    }

    private List<String> aVI() {
        QuickImInputData quickImInputData;
        List<String> list;
        o oVar = com.baidu.live.l.a.uA().ajX;
        if (oVar == null || (quickImInputData = oVar.Sm) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] aVJ() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void aVK() {
        if (this.dYl == null) {
            this.dYl = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.o.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.enM != null && a.this.enM.isShowing()) {
                        a.this.enM.aVM();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.dYl);
        }
    }

    private void aSm() {
        if (this.ahD == null) {
            this.ahD = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.o.a.3
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
            MessageManager.getInstance().registerListener(this.ahD);
        }
    }

    private void aVL() {
        if (this.dYl != null) {
            MessageManager.getInstance().unRegisterListener(this.dYl);
            this.dYl = null;
        }
    }

    private void aSn() {
        if (this.ahD != null) {
            MessageManager.getInstance().unRegisterListener(this.ahD);
        }
    }
}
