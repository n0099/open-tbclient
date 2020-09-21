package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.al;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int bOf;
    protected com.baidu.tieba.ala.liveroom.data.e gGG;
    protected AlaMasterLiveRoomOpearator gIa;
    protected b gIb;
    protected com.baidu.tieba.ala.liveroom.m.b gqQ;
    private CustomMessageListener grN = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.master.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (a.this.gqQ != null) {
                    a.this.gqQ.eh(bVar.url, bVar.aDF);
                }
            }
        }
    };
    protected f gtv;

    public abstract void aU(int i, String str);

    public abstract void bWy();

    public a(f fVar) {
        this.gtv = fVar;
        initListener();
        Gf();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.grN);
    }

    private void Gf() {
        this.gqQ = new com.baidu.tieba.ala.liveroom.m.b(this.gtv.pageContext.getPageActivity());
    }

    public void ah(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.gIa = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.bOf = s;
        switch (s) {
            case 2:
                if (this.gIa != null) {
                    this.gIa.bVn();
                    return;
                }
                return;
            case 3:
                if (this.gIa != null) {
                    this.gIa.bVo();
                    return;
                }
                return;
            case 4:
                if (this.gIa != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.gIa.d(eVar);
                    if (this.gIb != null) {
                        this.gIb.b(eVar);
                    }
                    if (eVar != null && eVar.gAN) {
                        this.gtv.gAW.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.gIa != null) {
                    this.gIa.b(obj instanceof al ? (al) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.gIa != null) {
                    this.gIa.bVt();
                    return;
                }
                return;
            case 7:
                if (this.gIa != null) {
                    this.gIa.bVu();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.gIa != null) {
                    this.gIa.g(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gGG = eVar;
        bWy();
    }

    public void c(al alVar) {
        if (this.gtv != null && this.gtv.gAW != null) {
            this.gtv.gAW.a((short) 5, alVar);
        }
    }

    public void aV(int i, String str) {
        if (this.gIa != null) {
            this.gIa.onError(i, str);
        }
    }

    public void i(short s) {
        if (this.gtv != null && this.gtv.gAW != null) {
            this.gtv.gAW.a((short) 8, Short.valueOf(s));
        }
    }

    public void bWz() {
        if (this.gIa != null) {
            this.gIa.bVx();
        }
    }

    public void bWA() {
        if (this.gIa != null) {
            this.gIa.bVy();
        }
    }

    public void onPause() {
        if (this.gIa != null) {
            this.gIa.onPause();
        }
    }

    public boolean bWB() {
        if (this.gIa != null) {
            return this.gIa.bVv();
        }
        return false;
    }

    public void bWC() {
        if (this.gIa != null) {
            this.gIa.bVw();
        }
    }

    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.grN);
    }

    public boolean bWD() {
        return this.bOf == 5;
    }

    public void a(b bVar) {
        this.gIb = bVar;
    }
}
