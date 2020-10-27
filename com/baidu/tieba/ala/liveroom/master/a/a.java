package com.baidu.tieba.ala.liveroom.master.a;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.ao;
import com.baidu.tieba.ala.liveroom.data.f;
import com.baidu.tieba.ala.liveroom.master.AlaMasterLiveRoomOpearator;
/* loaded from: classes4.dex */
public abstract class a {
    protected int cdn;
    protected com.baidu.tieba.ala.liveroom.m.b gQY;
    private CustomMessageListener gRY = new CustomMessageListener(2913227) { // from class: com.baidu.tieba.ala.liveroom.master.a.a.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() instanceof com.baidu.live.data.b) {
                com.baidu.live.data.b bVar = (com.baidu.live.data.b) customResponsedMessage.getData();
                if (a.this.gQY != null) {
                    a.this.gQY.ev(bVar.url, bVar.aGR);
                }
            }
        }
    };
    protected f gTF;
    protected com.baidu.tieba.ala.liveroom.data.e hgT;
    protected AlaMasterLiveRoomOpearator hiq;
    protected b hir;

    public abstract void bg(int i, String str);

    public abstract void ccX();

    public a(f fVar) {
        this.gTF = fVar;
        initListener();
        Hx();
    }

    private void initListener() {
        MessageManager.getInstance().registerListener(this.gRY);
    }

    private void Hx() {
        this.gQY = new com.baidu.tieba.ala.liveroom.m.b(this.gTF.pageContext.getPageActivity());
    }

    public void ak(AlaMasterLiveRoomOpearator alaMasterLiveRoomOpearator) {
        this.hiq = alaMasterLiveRoomOpearator;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(short s, Object obj) {
        this.cdn = s;
        switch (s) {
            case 2:
                if (this.hiq != null) {
                    this.hiq.cbJ();
                    return;
                }
                return;
            case 3:
                if (this.hiq != null) {
                    this.hiq.cbK();
                    return;
                }
                return;
            case 4:
                if (this.hiq != null) {
                    com.baidu.tieba.ala.liveroom.data.e eVar = obj instanceof com.baidu.tieba.ala.liveroom.data.e ? (com.baidu.tieba.ala.liveroom.data.e) obj : null;
                    this.hiq.d(eVar);
                    if (this.hir != null) {
                        this.hir.b(eVar);
                    }
                    if (eVar != null && eVar.haU) {
                        this.gTF.hbd.a((short) 5, null);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.hiq != null) {
                    this.hiq.b(obj instanceof ao ? (ao) obj : null);
                    return;
                }
                return;
            case 6:
                if (this.hiq != null) {
                    this.hiq.cbR();
                    return;
                }
                return;
            case 7:
                if (this.hiq != null) {
                    this.hiq.cbS();
                    return;
                }
                return;
            case 8:
                short s2 = 0;
                if (obj instanceof Short) {
                    s2 = ((Short) obj).shortValue();
                }
                if (this.hiq != null) {
                    this.hiq.h(s2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void c(com.baidu.tieba.ala.liveroom.data.e eVar) {
        this.hgT = eVar;
        ccX();
    }

    public void c(ao aoVar) {
        if (this.gTF != null && this.gTF.hbd != null) {
            this.gTF.hbd.a((short) 5, aoVar);
        }
    }

    public void bh(int i, String str) {
        if (this.hiq != null) {
            this.hiq.onError(i, str);
        }
    }

    public void j(short s) {
        if (this.gTF != null && this.gTF.hbd != null) {
            this.gTF.hbd.a((short) 8, Short.valueOf(s));
        }
    }

    public void ccY() {
        if (this.hiq != null) {
            this.hiq.cbV();
        }
    }

    public void ccZ() {
        if (this.hiq != null) {
            this.hiq.cbW();
        }
    }

    public void onPause() {
        if (this.hiq != null) {
            this.hiq.onPause();
        }
    }

    public boolean cda() {
        if (this.hiq != null) {
            return this.hiq.cbT();
        }
        return false;
    }

    public void cdb() {
        if (this.hiq != null) {
            this.hiq.cbU();
        }
    }

    public void onDestroy() {
        if (this.gQY != null) {
            this.gQY.release();
        }
        MessageManager.getInstance().unRegisterListener(this.gRY);
    }

    public boolean cdc() {
        return this.cdn == 5;
    }

    public void a(b bVar) {
        this.hir = bVar;
    }
}
