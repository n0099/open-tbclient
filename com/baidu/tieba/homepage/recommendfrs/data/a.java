package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ad;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.card.data.h;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final TagInfo cHH;
    private DataRes cHI;
    private int cHJ;
    private String cHM;
    private com.baidu.tieba.card.data.b cHN;
    private boolean hasMore;
    private int pn;
    private List<Object> aAH = new ArrayList();
    private boolean cvT = false;
    private boolean cHK = false;
    private boolean cHL = false;
    private int dataType = 1;
    private long cEd = 0;

    public a(TagInfo tagInfo) {
        this.cHH = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cHI = dataRes;
    }

    public void ki(int i) {
        this.cHJ = i;
    }

    public int amO() {
        return this.cHJ;
    }

    public boolean amP() {
        return this.cHK;
    }

    public boolean amQ() {
        return this.cHL;
    }

    public TagInfo amR() {
        return this.cHH;
    }

    public String amS() {
        return this.cHM;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cHL = true;
        } else {
            this.cHK = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cEd = ((com.baidu.tieba.homepage.mygod.data.d) cVar).amg();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aAH.addAll(a);
            } else {
                this.aAH = a;
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
                this.cHM = ((ICardInfo) list.get(size - 1)).getFlipId();
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
                    eVar.setShowImage(cVar.Wg());
                    if (eVar.ana() != 33) {
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
                this.cHN = null;
            }
            this.dataType = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !c((ThreadInfo) obj))) {
                    bg bgVar = new bg();
                    bgVar.a((ThreadInfo) obj);
                    g gVar = new g();
                    gVar.threadData = bgVar;
                    if (!TextUtils.isEmpty(bgVar.sv())) {
                        ad adVar = new ad();
                        adVar.cn(bgVar.sv());
                        this.cHN = adVar;
                    } else if (bgVar.TH == 1) {
                        h hVar = new h();
                        hVar.bbD = gVar;
                        a(hVar);
                        this.cHN = hVar;
                    } else {
                        a(gVar);
                        this.cHN = gVar;
                    }
                    list.add(this.cHN);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                com.baidu.tieba.homepage.mygod.data.d dVar = (com.baidu.tieba.homepage.mygod.data.d) cVar;
                if (this.pn == 1 && dVar.ami() != null) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.ami()));
                } else if (this.pn == 1 && dVar.amh() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cHN == null) {
                bVar.bbt = false;
            } else if (this.cHN.getType() == null) {
                bVar.bbt = false;
            } else if (this.cHN instanceof g) {
                if (bVar instanceof g) {
                    bVar.bbt = false;
                } else {
                    bVar.bbt = true;
                }
            } else {
                bVar.bbt = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        int size;
        if (excellentThreadInfo != null && (size = this.aAH.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.aAH.get(i);
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
        if (threadInfo != null && (size = this.aAH.size()) > 0) {
            for (int i = 0; i < size; i++) {
                Object obj = this.aAH.get(i);
                if ((obj instanceof ThreadInfo) && threadInfo.id == ((ThreadInfo) obj).id) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public List<Object> amT() {
        return this.aAH;
    }

    public void bz(List<Object> list) {
        this.aAH = list;
    }

    public void fe(boolean z) {
        this.cvT = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long amg() {
        return this.cEd;
    }
}
