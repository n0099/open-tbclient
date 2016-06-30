package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.data.z;
import com.baidu.tieba.card.a.g;
import com.baidu.tieba.card.a.h;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final TagInfo ctn;
    private DataRes cto;
    private int ctp;
    private String cts;
    private com.baidu.tieba.card.a.b ctt;
    private boolean hasMore;
    private int pn;
    private List<Object> awM = new ArrayList();
    private boolean civ = false;
    private boolean ctq = false;
    private boolean ctr = false;
    private int dataType = 1;
    private long cqk = 0;

    public a(TagInfo tagInfo) {
        this.ctn = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cto = dataRes;
    }

    public void jz(int i) {
        this.ctp = i;
    }

    public int ahq() {
        return this.ctp;
    }

    public boolean ahr() {
        return this.ctq;
    }

    public boolean ahs() {
        return this.ctr;
    }

    public TagInfo aht() {
        return this.ctn;
    }

    public String ahu() {
        return this.cts;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.ctr = true;
        } else {
            this.ctq = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.c) {
                this.cqk = ((com.baidu.tieba.homepage.mygod.data.c) cVar).agM();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.awM.addAll(a);
            } else {
                this.awM = a;
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
            this.dataType = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.cts = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.dataType = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.QL());
                    if (eVar.ahC() != 33) {
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
                this.ctt = null;
            }
            this.dataType = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !c((ThreadInfo) obj))) {
                    az azVar = new az();
                    azVar.a((ThreadInfo) obj);
                    g gVar = new g();
                    gVar.threadData = azVar;
                    if (!TextUtils.isEmpty(azVar.rr())) {
                        z zVar = new z();
                        zVar.cm(azVar.rr());
                        this.ctt = zVar;
                    } else if (azVar.Qz == 1) {
                        h hVar = new h();
                        hVar.aVd = gVar;
                        a(hVar);
                        this.ctt = hVar;
                    } else {
                        a(gVar);
                        this.ctt = gVar;
                    }
                    list.add(this.ctt);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.c) {
                com.baidu.tieba.homepage.mygod.data.c cVar2 = (com.baidu.tieba.homepage.mygod.data.c) cVar;
                if (this.pn == 1 && cVar2.agN() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.a.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.ctt == null) {
                bVar.aUT = false;
            } else if (this.ctt.getType() == null) {
                bVar.aUT = false;
            } else if (this.ctt instanceof g) {
                if (bVar instanceof g) {
                    bVar.aUT = false;
                } else {
                    bVar.aUT = true;
                }
            } else {
                bVar.aUT = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.awM.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.awM.get(i);
                if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid == ((ExcellentThreadInfo) obj).excid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean c(ThreadInfo threadInfo) {
        int size;
        if (threadInfo != null && (size = this.awM.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.awM.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> ahv() {
        return this.awM;
    }

    public void bt(List<Object> list) {
        this.awM = list;
    }

    public void eH(boolean z) {
        this.civ = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long agM() {
        return this.cqk;
    }
}
