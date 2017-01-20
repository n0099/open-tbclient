package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bh;
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
    private String cAd;
    private com.baidu.tieba.card.data.b cAe;
    private final TagInfo czX;
    private DataRes czY;
    private int czZ;
    private boolean hasMore;
    private int pn;
    private List<Object> azp = new ArrayList();
    private boolean cne = false;
    private boolean cAa = false;
    private boolean cAb = false;
    private int cAc = 1;
    private long cwq = 0;

    public a(TagInfo tagInfo) {
        this.czX = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.czY = dataRes;
    }

    public void ks(int i) {
        this.czZ = i;
    }

    public int akE() {
        return this.czZ;
    }

    public boolean akF() {
        return this.cAa;
    }

    public boolean akG() {
        return this.cAb;
    }

    public TagInfo akH() {
        return this.czX;
    }

    public String akI() {
        return this.cAd;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cAb = true;
        } else {
            this.cAa = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cwq = ((com.baidu.tieba.homepage.mygod.data.d) cVar).ajW();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.azp.addAll(a);
            } else {
                this.azp = a;
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
            this.cAc = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.cAd = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.cAc = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.akK());
                    if (eVar.akR() != 33) {
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
                this.cAe = null;
            }
            this.cAc = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    bh bhVar = new bh();
                    bhVar.a((ThreadInfo) obj);
                    bhVar.aW(1);
                    f fVar = new f();
                    fVar.threadData = bhVar;
                    if (bhVar.getThreadType() == 49 || bhVar.getThreadType() == 50) {
                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                            break;
                        }
                        E(bhVar);
                    } else if (!TextUtils.isEmpty(bhVar.sq())) {
                        ah ahVar = new ah();
                        ahVar.co(bhVar.sq());
                        this.cAe = ahVar;
                    } else if (bhVar.SX == 1) {
                        g gVar = new g();
                        gVar.bod = fVar;
                        a(gVar);
                        this.cAe = gVar;
                    } else {
                        a(fVar);
                        this.cAe = fVar;
                    }
                    list.add(this.cAe);
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
        if (this.pn == 1 && dVar.ajY() != null) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.ajY()));
        } else if (this.pn == 1 && dVar.ajX() == 0) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
        }
    }

    private void E(bh bhVar) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            if (bhVar.getThreadType() == 49) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = new com.baidu.tieba.homepage.alalivelist.view.d();
                dVar.aVi = bhVar;
                a(dVar);
                this.cAe = dVar;
            } else if (bhVar.getThreadType() == 50) {
                h hVar = new h();
                hVar.aVi = bhVar;
                a(hVar);
                this.cAe = hVar;
            }
        }
    }

    private void b(c cVar, List<Object> list) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            com.baidu.tieba.homepage.alalivelist.data.c cVar2 = (com.baidu.tieba.homepage.alalivelist.data.c) cVar;
            if (cVar2.ctw != null && cVar2.ctw.type.intValue() != com.baidu.tieba.homepage.alalivelist.data.c.ctv && this.pn == 1) {
                list.add(0, new com.baidu.tieba.homepage.alalivelist.a.c(cVar2.ctw));
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cAe == null) {
                bVar.needTopMargin = false;
            } else if (this.cAe.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.cAe instanceof f) {
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
        int size = this.azp.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.azp.get(i);
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
        int size = this.azp.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.azp.get(i);
            if (obj instanceof ThreadInfo) {
                if (threadInfo.id.equals(((ThreadInfo) obj).id)) {
                    return true;
                }
            } else if (obj instanceof com.baidu.tieba.homepage.alalivelist.view.d) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = (com.baidu.tieba.homepage.alalivelist.view.d) obj;
                if (dVar.aVi == null) {
                    return false;
                }
                if (String.valueOf(threadInfo.id).equals(dVar.aVi.getId())) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public List<Object> akJ() {
        return this.azp;
    }

    public void bA(List<Object> list) {
        this.azp = list;
    }

    public void fj(boolean z) {
        this.cne = z;
    }

    public int getDataType() {
        return this.cAc;
    }

    public long ajW() {
        return this.cwq;
    }
}
