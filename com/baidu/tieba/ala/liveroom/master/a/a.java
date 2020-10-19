package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.al;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int bUO;
    protected com.baidu.tieba.ala.liveroom.m.b gFj;
    private CustomMessageListener gGi = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.master.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (a.this.gFj != null) {
                    a.this.gFj.eo(bVar.url, bVar.aGJ);
                }
            }
        }
    };
    protected f gHQ;
    protected com.baidu.tieba.ala.liveroom.data.e gVf;
    protected AlaMasterLiveRoomOpearator gWA;
    protected b gWB;

    public abstract void bZT();

    public abstract void be(int i, String str);

    public a(f fVar) {
        this.gHQ = fVar;
        initListener();
        Hb();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gGi);
    }

    private void Hb() {
        this.gFj = new com.baidu.tieba.ala.liveroom.m.b(this.gHQ.pageContext.getPageActivity());
    }

    public void ak(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.gWA = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.bUO = s;
        switch (s) {
            case 2:
                if (this.gWA != null) {
                    this.gWA.bYH();
                    return;
                }
                return;
            case 3:
                if (this.gWA != null) {
                    this.gWA.bYI();
                    return;
                }
                return;
            case 4:
                if (this.gWA != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.gWA.d(eVar);
                    if (this.gWB != null) {
                        this.gWB.b(eVar);
                    }
                    if (eVar != null && eVar.gPg) {
                        this.gHQ.gPp.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.gWA != null) {
                    this.gWA.b(obj instanceof al ? (al) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.gWA != null) {
                    this.gWA.bYO();
                    return;
                }
                return;
            case 7:
                if (this.gWA != null) {
                    this.gWA.bYP();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.gWA != null) {
                    this.gWA.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gVf = eVar;
        bZT();
    }

    public void c(al alVar) {
        if (this.gHQ != null && this.gHQ.gPp != null) {
            this.gHQ.gPp.a((short) 5, alVar);
        }
    }

    public void bf(int i, String str) {
        if (this.gWA != null) {
            this.gWA.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.gHQ != null && this.gHQ.gPp != null) {
            this.gHQ.gPp.a((short) 8, Short.valueOf(s));
        }
    }

    public void bZU() {
        if (this.gWA != null) {
            this.gWA.bYS();
        }
    }

    public void bZV() {
        if (this.gWA != null) {
            this.gWA.bYT();
        }
    }

    public void onPause() {
        if (this.gWA != null) {
            this.gWA.onPause();
        }
    }

    public boolean bZW() {
        if (this.gWA != null) {
            return this.gWA.bYQ();
        }
        return false;
    }

    public void bZX() {
        if (this.gWA != null) {
            this.gWA.bYR();
        }
    }

    public void onDestroy() {
        if (this.gFj != null) {
            this.gFj.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gGi);
    }

    public boolean bZY() {
        return this.bUO == 5;
    }

    public void a(b bVar) {
        this.gWB = bVar;
    }
}
