package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.bk;
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
    private final TagInfo cNO;
    private DataRes cNP;
    private int cNQ;
    private String cNT;
    private com.baidu.tieba.card.data.b cNU;
    private boolean hasMore;
    private int pn;
    private List<Object> aBc = new ArrayList();
    private boolean cBz = false;
    private boolean cNR = false;
    private boolean cNS = false;
    private int dataType = 1;
    private long cJU = 0;

    public a(TagInfo tagInfo) {
        this.cNO = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cNP = dataRes;
    }

    public void kv(int i) {
        this.cNQ = i;
    }

    public int aoW() {
        return this.cNQ;
    }

    public boolean aoX() {
        return this.cNR;
    }

    public boolean aoY() {
        return this.cNS;
    }

    public TagInfo aoZ() {
        return this.cNO;
    }

    public String apa() {
        return this.cNT;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cNS = true;
        } else {
            this.cNR = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cJU = ((com.baidu.tieba.homepage.mygod.data.d) cVar).aop();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aBc.addAll(a);
            } else {
                this.aBc = a;
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
                this.cNT = ((ICardInfo) list.get(size - 1)).getFlipId();
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
                    eVar.setShowImage(cVar.XB());
                    if (eVar.api() != 33) {
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
                this.cNU = null;
            }
            this.dataType = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !d((ThreadInfo) obj))) {
                    bk bkVar = new bk();
                    bkVar.a((ThreadInfo) obj);
                    g gVar = new g();
                    gVar.threadData = bkVar;
                    if (!TextUtils.isEmpty(bkVar.sJ())) {
                        ah ahVar = new ah();
                        ahVar.cp(bkVar.sJ());
                        this.cNU = ahVar;
                    } else if (bkVar.Um == 1) {
                        h hVar = new h();
                        hVar.beT = gVar;
                        a(hVar);
                        this.cNU = hVar;
                    } else {
                        a(gVar);
                        this.cNU = gVar;
                    }
                    list.add(this.cNU);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                com.baidu.tieba.homepage.mygod.data.d dVar = (com.baidu.tieba.homepage.mygod.data.d) cVar;
                if (this.pn == 1 && dVar.aor() != null) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.aor()));
                } else if (this.pn == 1 && dVar.aoq() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cNU == null) {
                bVar.needTopMargin = false;
            } else if (this.cNU.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.cNU instanceof g) {
                if (bVar instanceof g) {
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
        int size = this.aBc.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aBc.get(i);
            if ((obj instanceof ExcellentThreadInfo) && excellentThreadInfo.excid.equals(((ExcellentThreadInfo) obj).excid)) {
                return true;
            }
        }
        return false;
    }

    private boolean d(ThreadInfo threadInfo) {
        if (threadInfo == null || threadInfo.id == null) {
            return false;
        }
        int size = this.aBc.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aBc.get(i);
            if ((obj instanceof ThreadInfo) && threadInfo.id.equals(((ThreadInfo) obj).id)) {
                return true;
            }
        }
        return false;
    }

    public List<Object> apb() {
        return this.aBc;
    }

    public void bC(List<Object> list) {
        this.aBc = list;
    }

    public void fu(boolean z) {
        this.cBz = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long aop() {
        return this.cJU;
    }
}
