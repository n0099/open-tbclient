package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ac;
import com.baidu.tbadk.core.data.be;
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
    private final TagInfo cwc;
    private DataRes cwd;
    private int cwe;
    private String cwh;
    private com.baidu.tieba.card.a.b cwi;
    private boolean hasMore;
    private int pn;
    private List<Object> axA = new ArrayList();
    private boolean ckI = false;
    private boolean cwf = false;
    private boolean cwg = false;
    private int dataType = 1;
    private long csP = 0;

    public a(TagInfo tagInfo) {
        this.cwc = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cwd = dataRes;
    }

    public void jF(int i) {
        this.cwe = i;
    }

    public int aia() {
        return this.cwe;
    }

    public boolean aib() {
        return this.cwf;
    }

    public boolean aic() {
        return this.cwg;
    }

    public TagInfo aid() {
        return this.cwc;
    }

    public String aie() {
        return this.cwh;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cwg = true;
        } else {
            this.cwf = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.c) {
                this.csP = ((com.baidu.tieba.homepage.mygod.data.c) cVar).ahs();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.axA.addAll(a);
            } else {
                this.axA = a;
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
                this.cwh = ((ICardInfo) list.get(size - 1)).getFlipId();
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
                    eVar.setShowImage(cVar.Ru());
                    if (eVar.aim() != 33) {
                        list.add(eVar);
                    } else if (TbadkCoreApplication.m10getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class)) {
                        list.add(eVar);
                    }
                }
            }
        }
    }

    private void c(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            if (!z) {
                this.cwi = null;
            }
            this.dataType = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !d((ThreadInfo) obj))) {
                    be beVar = new be();
                    beVar.a((ThreadInfo) obj);
                    g gVar = new g();
                    gVar.threadData = beVar;
                    if (!TextUtils.isEmpty(beVar.rq())) {
                        ac acVar = new ac();
                        acVar.cm(beVar.rq());
                        this.cwi = acVar;
                    } else if (beVar.QZ == 1) {
                        h hVar = new h();
                        hVar.aWb = gVar;
                        a(hVar);
                        this.cwi = hVar;
                    } else {
                        a(gVar);
                        this.cwi = gVar;
                    }
                    list.add(this.cwi);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.c) {
                com.baidu.tieba.homepage.mygod.data.c cVar2 = (com.baidu.tieba.homepage.mygod.data.c) cVar;
                if (this.pn == 1 && cVar2.aht() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.a.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cwi == null) {
                bVar.aVQ = false;
            } else if (this.cwi.getType() == null) {
                bVar.aVQ = false;
            } else if (this.cwi instanceof g) {
                if (bVar instanceof g) {
                    bVar.aVQ = false;
                } else {
                    bVar.aVQ = true;
                }
            } else {
                bVar.aVQ = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.axA.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.axA.get(i);
                if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid == ((ExcellentThreadInfo) obj).excid) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean d(ThreadInfo threadInfo) {
        int size;
        if (threadInfo != null && (size = this.axA.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.axA.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> aif() {
        return this.axA;
    }

    public void bx(List<Object> list) {
        this.axA = list;
    }

    public void eI(boolean z) {
        this.ckI = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long ahs() {
        return this.csP;
    }
}
