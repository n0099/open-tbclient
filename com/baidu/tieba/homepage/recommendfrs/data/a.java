package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bi;
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
    private final TagInfo cCj;
    private DataRes cCk;
    private int cCl;
    private String cCp;
    private com.baidu.tieba.card.data.b cCq;
    private boolean hasMore;
    private int pn;
    private List<Object> aFa = new ArrayList();
    private boolean cpu = false;
    private boolean cCm = false;
    private boolean cCn = false;
    private int cCo = 1;
    private long cyG = 0;

    public a(TagInfo tagInfo) {
        this.cCj = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cCk = dataRes;
    }

    public void kd(int i) {
        this.cCl = i;
    }

    public int akL() {
        return this.cCl;
    }

    public boolean akM() {
        return this.cCm;
    }

    public boolean akN() {
        return this.cCn;
    }

    public TagInfo akO() {
        return this.cCj;
    }

    public String akP() {
        return this.cCp;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cCn = true;
        } else {
            this.cCm = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cyG = ((com.baidu.tieba.homepage.mygod.data.d) cVar).akd();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aFa.addAll(a);
            } else {
                this.aFa = a;
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
            this.cCo = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.cCp = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.cCo = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.akR());
                    if (eVar.akY() != 33) {
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
                this.cCq = null;
            }
            this.cCo = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !b((ThreadInfo) obj))) {
                    bi biVar = new bi();
                    biVar.a((ThreadInfo) obj);
                    biVar.bX(1);
                    f fVar = new f();
                    fVar.threadData = biVar;
                    if (biVar.getThreadType() == 49 || biVar.getThreadType() == 50) {
                        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) == null) {
                            break;
                        }
                        C(biVar);
                    } else if (!TextUtils.isEmpty(biVar.tj())) {
                        ah ahVar = new ah();
                        ahVar.co(biVar.tj());
                        this.cCq = ahVar;
                    } else if (biVar.YA == 1) {
                        g gVar = new g();
                        gVar.bxi = fVar;
                        a(gVar);
                        this.cCq = gVar;
                    } else {
                        a(fVar);
                        this.cCq = fVar;
                    }
                    list.add(this.cCq);
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
        if (this.pn == 1 && dVar.akf() != null) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.akf()));
        } else if (this.pn == 1 && dVar.ake() == 0) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
        }
    }

    private void C(bi biVar) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            if (biVar.getThreadType() == 49) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = new com.baidu.tieba.homepage.alalivelist.view.d();
                dVar.bck = biVar;
                a(dVar);
                this.cCq = dVar;
            } else if (biVar.getThreadType() == 50) {
                h hVar = new h();
                hVar.bck = biVar;
                a(hVar);
                this.cCq = hVar;
            }
        }
    }

    private void b(c cVar, List<Object> list) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            com.baidu.tieba.homepage.alalivelist.data.c cVar2 = (com.baidu.tieba.homepage.alalivelist.data.c) cVar;
            if (cVar2.cvM != null && cVar2.cvM.type.intValue() != com.baidu.tieba.homepage.alalivelist.data.c.cvL && this.pn == 1) {
                list.add(0, new com.baidu.tieba.homepage.alalivelist.a.c(cVar2.cvM));
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cCq == null) {
                bVar.needTopMargin = false;
            } else if (this.cCq.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.cCq instanceof f) {
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
        int size = this.aFa.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aFa.get(i);
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
        int size = this.aFa.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aFa.get(i);
            if (obj instanceof ThreadInfo) {
                if (threadInfo.id.equals(((ThreadInfo) obj).id)) {
                    return true;
                }
            } else if (obj instanceof com.baidu.tieba.homepage.alalivelist.view.d) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = (com.baidu.tieba.homepage.alalivelist.view.d) obj;
                if (dVar.bck == null) {
                    return false;
                }
                if (String.valueOf(threadInfo.id).equals(dVar.bck.getId())) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public List<Object> akQ() {
        return this.aFa;
    }

    public void bh(List<Object> list) {
        this.aFa = list;
    }

    public void fk(boolean z) {
        this.cpu = z;
    }

    public int getDataType() {
        return this.cCo;
    }

    public long akd() {
        return this.cyG;
    }
}
