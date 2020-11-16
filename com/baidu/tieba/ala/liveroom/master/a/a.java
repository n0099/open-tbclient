package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ap;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int chm;
    protected com.baidu.tieba.ala.liveroom.m.b gWJ;
    private CustomMessageListener gXK = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.master.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (a.this.gWJ != null) {
                    a.this.gWJ.ev(bVar.url, bVar.aFW);
                }
            }
        }
    };
    protected com.baidu.tieba.ala.liveroom.data.e gZr;
    protected com.baidu.tieba.ala.liveroom.data.d hmx;
    protected AlaMasterLiveRoomOpearator hnO;
    protected b hnP;

    public abstract void bi(int i, String str);

    public abstract void ceR();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gZr = eVar;
        initListener();
        Hp();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gXK);
    }

    private void Hp() {
        this.gWJ = new com.baidu.tieba.ala.liveroom.m.b(this.gZr.pageContext.getPageActivity());
    }

    public void ak(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hnO = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.chm = s;
        switch (s) {
            case 2:
                if (this.hnO != null) {
                    this.hnO.cdC();
                    return;
                }
                return;
            case 3:
                if (this.hnO != null) {
                    this.hnO.cdD();
                    return;
                }
                return;
            case 4:
                if (this.hnO != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hnO.d(dVar);
                    if (this.hnP != null) {
                        this.hnP.b(dVar);
                    }
                    if (dVar != null && dVar.hgv) {
                        this.gZr.hgF.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hnO != null) {
                    this.hnO.b(obj instanceof ap ? (ap) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hnO != null) {
                    this.hnO.cdL();
                    return;
                }
                return;
            case 7:
                if (this.hnO != null) {
                    this.hnO.cdM();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hnO != null) {
                    this.hnO.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hmx = dVar;
        ceR();
    }

    public void c(ap apVar) {
        if (this.gZr != null && this.gZr.hgF != null) {
            this.gZr.hgF.a((short) 5, apVar);
        }
    }

    public void bj(int i, String str) {
        if (this.hnO != null) {
            this.hnO.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.gZr != null && this.gZr.hgF != null) {
            this.gZr.hgF.a((short) 8, Short.valueOf(s));
        }
    }

    public void ceS() {
        if (this.hnO != null) {
            this.hnO.cdP();
        }
    }

    public void ceT() {
        if (this.hnO != null) {
            this.hnO.cdQ();
        }
    }

    public void onPause() {
        if (this.hnO != null) {
            this.hnO.onPause();
        }
    }

    public boolean ceU() {
        if (this.hnO != null) {
            return this.hnO.cdN();
        }
        return false;
    }

    public void ceV() {
        if (this.hnO != null) {
            this.hnO.cdO();
        }
    }

    public void onDestroy() {
        if (this.gWJ != null) {
            this.gWJ.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gXK);
    }

    public boolean ceW() {
        return this.chm == 5;
    }

    public void a(b bVar) {
        this.hnP = bVar;
    }
}
