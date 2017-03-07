package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.homepage.alalivelist.view.h;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private com.baidu.tieba.card.data.b cBA;
    private final TagInfo cBt;
    private DataRes cBu;
    private int cBv;
    private String cBz;
    private boolean hasMore;
    private int pn;
    private List<Object> aEI = new ArrayList();
    private boolean coD = false;
    private boolean cBw = false;
    private boolean cBx = false;
    private int cBy = 1;
    private long cxP = 0;

    public a(TagInfo tagInfo) {
        this.cBt = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cBu = dataRes;
    }

    public void jW(int i) {
        this.cBv = i;
    }

    public int ajQ() {
        return this.cBv;
    }

    public boolean ajR() {
        return this.cBw;
    }

    public boolean ajS() {
        return this.cBx;
    }

    public TagInfo ajT() {
        return this.cBt;
    }

    public String ajU() {
        return this.cBz;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cBx = true;
        } else {
            this.cBw = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cxP = ((com.baidu.tieba.homepage.mygod.data.d) cVar).aji();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aEI.addAll(a);
            } else {
                this.aEI = a;
            }
        }
    }

    private List<Object> a(boolean z, c cVar) {
        ArrayList arrayList = new ArrayList();
        if (cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            if (cVar.getThreadList().get(0) instanceof ExcellentThreadInfo) {
                b(arrayList, cVar, z);
            } else if (cVar.getThreadList().get(0) instanceof ThreadInfo) {
                c(arrayList, cVar, z);
            } else if (cVar.getThreadList().get(0) instanceof ICardInfo) {
                a(arrayList, cVar, z);
            }
        }
        return arrayList;
    }

    private void a(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.cBy = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.cBz = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.cBy = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.ajW());
                    if (eVar.akd() != 33) {
                        list.add(eVar);
                    } else if (TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    private void c(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            if (!z) {
                this.cBA = null;
            }
            this.cBy = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    bj bjVar = new bj();
                    bjVar.a((ThreadInfo) obj);
                    bjVar.bU(1);
                    f fVar = new f();
                    fVar.threadData = bjVar;
                    if (bjVar.getThreadType() == 49 || bjVar.getThreadType() == 50) {
                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                            break;
                        }
                        F(bjVar);
                    } else if (!TextUtils.isEmpty(bjVar.sL())) {
                        ai aiVar = new ai();
                        aiVar.ch(bjVar.sL());
                        this.cBA = aiVar;
                    } else if (bjVar.Yj == 1) {
                        g gVar = new g();
                        gVar.buY = fVar;
                        a(gVar);
                        this.cBA = gVar;
                    } else {
                        a(fVar);
                        this.cBA = fVar;
                    }
                    list.add(this.cBA);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                a(cVar, list);
            }
            if (cVar instanceof com.baidu.tieba.homepage.alalivelist.data.c) {
                b(cVar, list);
            }
        }
    }

    private void a(c cVar, List<Object> list) {
        com.baidu.tieba.homepage.mygod.data.d dVar = (com.baidu.tieba.homepage.mygod.data.d) cVar;
        if (this.pn == 1 && dVar.ajk() != null) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.ajk()));
        } else if (this.pn == 1 && dVar.ajj() == 0) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
        }
    }

    private void F(bj bjVar) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            if (bjVar.getThreadType() == 49) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = new com.baidu.tieba.homepage.alalivelist.view.d();
                dVar.bbv = bjVar;
                a(dVar);
                this.cBA = dVar;
            } else if (bjVar.getThreadType() == 50) {
                h hVar = new h();
                hVar.bbv = bjVar;
                a(hVar);
                this.cBA = hVar;
            }
        }
    }

    private void b(c cVar, List<Object> list) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            com.baidu.tieba.homepage.alalivelist.data.c cVar2 = (com.baidu.tieba.homepage.alalivelist.data.c) cVar;
            if (cVar2.cuV != null && cVar2.cuV.type.intValue() != com.baidu.tieba.homepage.alalivelist.data.c.cuU && this.pn == 1) {
                list.add(0, new com.baidu.tieba.homepage.alalivelist.a.c(cVar2.cuV));
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cBA == null) {
                bVar.needTopMargin = false;
            } else if (this.cBA.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.cBA instanceof f) {
                if (bVar instanceof f) {
                    bVar.needTopMargin = false;
                } else {
                    bVar.needTopMargin = true;
                }
            } else {
                bVar.needTopMargin = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        if (excellentThreadInfo == null || excellentThreadInfo.excid == null) {
            return false;
        }
        int size = this.aEI.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aEI.get(i);
            if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid.equals(((ExcellentThreadInfo) obj).excid)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.id == null) {
            return false;
        }
        int size = this.aEI.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aEI.get(i);
            if (obj instanceof ThreadInfo) {
                if (threadInfo.id.equals(((ThreadInfo) obj).id)) {
                    return true;
                }
            } else if (obj instanceof com.baidu.tieba.homepage.alalivelist.view.d) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = (com.baidu.tieba.homepage.alalivelist.view.d) obj;
                if (dVar.bbv == null) {
                    return false;
                }
                if (String.valueOf(threadInfo.id).equals(dVar.bbv.getId())) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public List<Object> ajV() {
        return this.aEI;
    }

    public void bh(List<Object> list) {
        this.aEI = list;
    }

    public void fa(boolean z) {
        this.coD = z;
    }

    public int getDataType() {
        return this.cBy;
    }

    public long aji() {
        return this.cxP;
    }
}
