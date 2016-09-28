package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.af;
import com.baidu.tbadk.core.data.bi;
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
    private DataRes cIA;
    private int cIB;
    private String cIE;
    private com.baidu.tieba.card.data.b cIF;
    private final TagInfo cIz;
    private boolean hasMore;
    private int pn;
    private List<Object> aAk = new ArrayList();
    private boolean cwq = false;
    private boolean cIC = false;
    private boolean cID = false;
    private int dataType = 1;
    private long cEH = 0;

    public a(TagInfo tagInfo) {
        this.cIz = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.cIA = dataRes;
    }

    public void ko(int i) {
        this.cIB = i;
    }

    public int anc() {
        return this.cIB;
    }

    public boolean and() {
        return this.cIC;
    }

    public boolean ane() {
        return this.cID;
    }

    public TagInfo anf() {
        return this.cIz;
    }

    public String ang() {
        return this.cIE;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.cID = true;
        } else {
            this.cIC = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cEH = ((com.baidu.tieba.homepage.mygod.data.d) cVar).amu();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aAk.addAll(a);
            } else {
                this.aAk = a;
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
                this.cIE = ((ICardInfo) list.get(size - 1)).getFlipId();
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
                    eVar.setShowImage(cVar.Wz());
                    if (eVar.ano() != 33) {
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
                this.cIF = null;
            }
            this.dataType = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !d((ThreadInfo) obj))) {
                    bi biVar = new bi();
                    biVar.a((ThreadInfo) obj);
                    g gVar = new g();
                    gVar.threadData = biVar;
                    if (!TextUtils.isEmpty(biVar.sH())) {
                        af afVar = new af();
                        afVar.cn(biVar.sH());
                        this.cIF = afVar;
                    } else if (biVar.TQ == 1) {
                        h hVar = new h();
                        hVar.bbV = gVar;
                        a(hVar);
                        this.cIF = hVar;
                    } else {
                        a(gVar);
                        this.cIF = gVar;
                    }
                    list.add(this.cIF);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                com.baidu.tieba.homepage.mygod.data.d dVar = (com.baidu.tieba.homepage.mygod.data.d) cVar;
                if (this.pn == 1 && dVar.amw() != null) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.amw()));
                } else if (this.pn == 1 && dVar.amv() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cIF == null) {
                bVar.bbL = false;
            } else if (this.cIF.getType() == null) {
                bVar.bbL = false;
            } else if (this.cIF instanceof g) {
                if (bVar instanceof g) {
                    bVar.bbL = false;
                } else {
                    bVar.bbL = true;
                }
            } else {
                bVar.bbL = true;
            }
        }
    }

    private boolean a(ExcellentThreadInfo excellentThreadInfo) {
        if (excellentThreadInfo == null || excellentThreadInfo.excid == null) {
            return false;
        }
        int size = this.aAk.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aAk.get(i);
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
        int size = this.aAk.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aAk.get(i);
            if ((obj instanceof ThreadInfo) && threadInfo.id.equals(((ThreadInfo) obj).id)) {
                return true;
            }
        }
        return false;
    }

    public List<Object> anh() {
        return this.aAk;
    }

    public void bz(List<Object> list) {
        this.aAk = list;
    }

    public void ff(boolean z) {
        this.cwq = z;
    }

    public int getDataType() {
        return this.dataType;
    }

    public long amu() {
        return this.cEH;
    }
}
