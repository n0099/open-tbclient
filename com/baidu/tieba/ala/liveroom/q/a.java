package com.baidu.tieba.ala.liveroom.q;

import android.text.TextUtils;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.QuickImInputData;
import com.baidu.live.data.av;
import com.baidu.live.data.k;
import com.baidu.live.data.q;
import com.baidu.live.im.data.ImSendMsgData;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.liveroom.q.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private com.baidu.live.gift.c.a ald;
    private CustomMessageListener apo;
    private CustomMessageListener eNm;
    private InterfaceC0452a fdr;
    private b fds;
    private String[] fdt;
    private List<String> fdu;
    private String mOtherParams;
    private TbPageContext mPageContext;
    private String mVid;

    /* renamed from: com.baidu.tieba.ala.liveroom.q.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0452a {
        void bgZ();

        void bha();

        boolean ux();

        boolean vG();
    }

    public void a(InterfaceC0452a interfaceC0452a) {
        this.fdr = interfaceC0452a;
    }

    public void a(k kVar, String str) {
        this.mVid = "";
        if (kVar != null && kVar.mLiveInfo != null && kVar.mLiveInfo.feed_id != null) {
            this.mVid = kVar.mLiveInfo.feed_id;
        }
        if (str == null) {
            str = "";
        }
        this.mOtherParams = str;
        bnB();
        bjX();
    }

    public void d(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        this.fds = new b(this.mPageContext.getPageActivity());
        this.fds.a(new b.a() { // from class: com.baidu.tieba.ala.liveroom.q.a.1
            @Override // com.baidu.tieba.ala.liveroom.q.b.a
            public boolean ux() {
                return a.this.fdr != null && a.this.fdr.ux();
            }

            @Override // com.baidu.tieba.ala.liveroom.q.b.a
            public void bid() {
                if (a.this.fdr != null) {
                    a.this.fdr.bgZ();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.q.b.a
            public void onDismiss() {
                if (a.this.fdr != null) {
                    a.this.fdr.bha();
                }
            }

            @Override // com.baidu.tieba.ala.liveroom.q.b.a
            public void a(int i, String str, av avVar) {
                if (a.this.fdr != null && a.this.fdr.ux()) {
                    ImSendMsgData imSendMsgData = new ImSendMsgData(str);
                    if (avVar != null) {
                        imSendMsgData.msgType = (short) 126;
                        imSendMsgData.barrageType = avVar.type;
                        imSendMsgData.barrageId = avVar.id;
                        imSendMsgData.price = avVar.price;
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2913100, imSendMsgData));
                }
                a.this.dk(str);
                a.this.fds.dismiss();
                LogManager.getCommonLogger().doClickQuickImListLog(a.this.mVid, String.valueOf(i), str, a.this.mOtherParams);
            }

            @Override // com.baidu.tieba.ala.liveroom.q.b.a
            public boolean vG() {
                return a.this.fdr != null && a.this.fdr.vG();
            }
        });
        if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
            this.fds.D(bny());
            if (this.ald == null) {
                this.ald = new com.baidu.live.gift.c.a();
            }
            this.ald.td();
        }
    }

    public void bN(int i) {
        if (this.fds != null && this.fds.isShowing()) {
            this.fds.bN(i);
        }
    }

    public List<String> bnx() {
        QuickImInputData quickImInputData;
        List<String> list;
        if (this.fdu == null) {
            this.fdu = new ArrayList();
        }
        this.fdu.clear();
        q qVar = com.baidu.live.r.a.wA().arE;
        if (qVar != null && (quickImInputData = qVar.Yy) != null && (list = quickImInputData.sortedTexts) != null && !list.isEmpty()) {
            this.fdu.addAll(list);
        }
        if (this.fdu.isEmpty()) {
            Collections.addAll(this.fdu, bny());
        }
        return this.fdu;
    }

    public void dk(String str) {
        if (!TextUtils.isEmpty(str) && this.fdu != null && !this.fdu.isEmpty() && this.fdu.indexOf(str) > 1) {
            if (this.fdu.remove(str)) {
                this.fdu.add(1, str);
            }
            q qVar = com.baidu.live.r.a.wA().arE;
            if (qVar != null) {
                QuickImInputData quickImInputData = qVar.Yy;
                if (quickImInputData == null) {
                    quickImInputData = new QuickImInputData();
                }
                if (quickImInputData.sortedTexts == null) {
                    quickImInputData.sortedTexts = new ArrayList();
                }
                quickImInputData.sortedTexts.clear();
                quickImInputData.sortedTexts.addAll(this.fdu);
            }
        }
    }

    public void tT() {
        if (this.fds != null) {
            if (this.mPageContext != null && !this.mPageContext.getPageActivity().isFinishing()) {
                this.fds.dismiss();
            }
            this.fds = null;
            bnC();
            bjY();
        }
    }

    public void release() {
        tT();
    }

    private String[] bny() {
        if (this.fdt == null || this.fdt.length == 0) {
            List<String> bnz = bnz();
            if (bnz != null && !bnz.isEmpty()) {
                this.fdt = (String[]) bnz.toArray(new String[bnz.size()]);
            } else {
                this.fdt = bnA();
            }
        }
        return this.fdt;
    }

    private List<String> bnz() {
        QuickImInputData quickImInputData;
        List<String> list;
        q qVar = com.baidu.live.r.a.wA().arE;
        if (qVar == null || (quickImInputData = qVar.Yy) == null || (list = quickImInputData.originTexts) == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    private String[] bnA() {
        return new String[]{"66666", "牛批牛批", "赤道以北，主播最美", "全民女神", "哈哈哈哈哈哈", "扎心了", "老铁，走一个", "请开始你的表演"};
    }

    private void bnB() {
        if (this.eNm == null) {
            this.eNm = new CustomMessageListener(2913122) { // from class: com.baidu.tieba.ala.liveroom.q.a.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.live.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (a.this.fds != null && a.this.fds.isShowing()) {
                        a.this.fds.bnD();
                    }
                }
            };
            MessageManager.getInstance().registerListener(this.eNm);
        }
    }

    private void bjX() {
        if (this.apo == null) {
            this.apo = new CustomMessageListener(2913095) { // from class: com.baidu.tieba.ala.liveroom.q.a.3
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
            MessageManager.getInstance().registerListener(this.apo);
        }
    }

    private void bnC() {
        if (this.eNm != null) {
            MessageManager.getInstance().unRegisterListener(this.eNm);
            this.eNm = null;
        }
    }

    private void bjY() {
        if (this.apo != null) {
            MessageManager.getInstance().unRegisterListener(this.apo);
        }
    }
}
