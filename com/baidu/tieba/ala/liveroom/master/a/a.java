package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ap;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int ciY;
    protected com.baidu.tieba.ala.liveroom.m.b gXc;
    private CustomMessageListener gYd = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.master.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (a.this.gXc != null) {
                    a.this.gXc.ev(bVar.url, bVar.aHH);
                }
            }
        }
    };
    protected com.baidu.tieba.ala.liveroom.data.e gZK;
    protected com.baidu.tieba.ala.liveroom.data.d hmQ;
    protected AlaMasterLiveRoomOpearator hoh;
    protected b hoi;

    public abstract void bk(int i, String str);

    public abstract void cfy();

    public a(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.gZK = eVar;
        initListener();
        HY();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gYd);
    }

    private void HY() {
        this.gXc = new com.baidu.tieba.ala.liveroom.m.b(this.gZK.pageContext.getPageActivity());
    }

    public void ak(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hoh = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.ciY = s;
        switch (s) {
            case 2:
                if (this.hoh != null) {
                    this.hoh.cej();
                    return;
                }
                return;
            case 3:
                if (this.hoh != null) {
                    this.hoh.cek();
                    return;
                }
                return;
            case 4:
                if (this.hoh != null) {
                    com.baidu.tieba.ala.liveroom.data.d dVar = obj instanceof com.baidu.tieba.ala.liveroom.data.d ? (com.baidu.tieba.ala.liveroom.data.d) obj : null;
                    this.hoh.d(dVar);
                    if (this.hoi != null) {
                        this.hoi.b(dVar);
                    }
                    if (dVar != null && dVar.hgO) {
                        this.gZK.hgY.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hoh != null) {
                    this.hoh.b(obj instanceof ap ? (ap) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hoh != null) {
                    this.hoh.ces();
                    return;
                }
                return;
            case 7:
                if (this.hoh != null) {
                    this.hoh.cet();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hoh != null) {
                    this.hoh.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.d dVar) {
        this.hmQ = dVar;
        cfy();
    }

    public void c(ap apVar) {
        if (this.gZK != null && this.gZK.hgY != null) {
            this.gZK.hgY.a((short) 5, apVar);
        }
    }

    public void bl(int i, String str) {
        if (this.hoh != null) {
            this.hoh.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.gZK != null && this.gZK.hgY != null) {
            this.gZK.hgY.a((short) 8, Short.valueOf(s));
        }
    }

    public void cfz() {
        if (this.hoh != null) {
            this.hoh.cew();
        }
    }

    public void cfA() {
        if (this.hoh != null) {
            this.hoh.cex();
        }
    }

    public void onPause() {
        if (this.hoh != null) {
            this.hoh.onPause();
        }
    }

    public boolean cfB() {
        if (this.hoh != null) {
            return this.hoh.ceu();
        }
        return false;
    }

    public void cfC() {
        if (this.hoh != null) {
            this.hoh.cev();
        }
    }

    public void onDestroy() {
        if (this.gXc != null) {
            this.gXc.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gYd);
    }

    public boolean cfD() {
        return this.ciY == 5;
    }

    public void a(b bVar) {
        this.hoi = bVar;
    }
}
