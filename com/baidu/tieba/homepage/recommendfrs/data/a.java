package com.baidu.tieba.homepage.recommendfrs.data;

import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.ag;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tieba.card.data.f;
import com.baidu.tieba.card.data.g;
import com.baidu.tieba.lego.card.model.ICardInfo;
import java.util.ArrayList;
import java.util.List;
import tbclient.ExcFrsPage.ExcellentThreadInfo;
import tbclient.Personalized.DataRes;
import tbclient.Personalized.TagInfo;
import tbclient.ThreadInfo;
/* loaded from: classes.dex */
public class a {
    private final TagInfo csT;
    private DataRes csU;
    private int csV;
    private String csZ;
    private com.baidu.tieba.card.data.b cta;
    private boolean hasMore;
    private int pn;
    private List<Object> aAw = new ArrayList();
    private boolean cgM = false;
    private boolean csW = false;
    private boolean csX = false;
    private int csY = 1;
    private long cpp = 0;

    public a(TagInfo tagInfo) {
        this.csT = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.csU = dataRes;
    }

    public void jF(int i) {
        this.csV = i;
    }

    public int ajx() {
        return this.csV;
    }

    public boolean ajy() {
        return this.csW;
    }

    public boolean ajz() {
        return this.csX;
    }

    public TagInfo ajA() {
        return this.csT;
    }

    public String ajB() {
        return this.csZ;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.csX = true;
        } else {
            this.csW = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cpp = ((com.baidu.tieba.homepage.mygod.data.d) cVar).aiP();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aAw.addAll(a);
            } else {
                this.aAw = a;
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
            this.csY = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.csZ = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.csY = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.ajD());
                    if (eVar.ajK() != 33) {
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
                this.cta = null;
            }
            this.csY = 2;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ThreadInfo) && (!z || !d((ThreadInfo) obj))) {
                    bg bgVar = new bg();
                    bgVar.a((ThreadInfo) obj);
                    f fVar = new f();
                    fVar.threadData = bgVar;
                    if (!TextUtils.isEmpty(bgVar.sy())) {
                        ag agVar = new ag();
                        agVar.cq(bgVar.sy());
                        this.cta = agVar;
                    } else if (bgVar.TL == 1) {
                        g gVar = new g();
                        gVar.bei = fVar;
                        a(gVar);
                        this.cta = gVar;
                    } else {
                        a(fVar);
                        this.cta = fVar;
                    }
                    list.add(this.cta);
                }
            }
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                com.baidu.tieba.homepage.mygod.data.d dVar = (com.baidu.tieba.homepage.mygod.data.d) cVar;
                if (this.pn == 1 && dVar.aiR() != null) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.aiR()));
                } else if (this.pn == 1 && dVar.aiQ() == 0) {
                    list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
                }
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.cta == null) {
                bVar.needTopMargin = false;
            } else if (this.cta.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.cta instanceof f) {
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
        int size = this.aAw.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aAw.get(i);
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
        int size = this.aAw.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aAw.get(i);
            if ((obj instanceof ThreadInfo) && threadInfo.id.equals(((ThreadInfo) obj).id)) {
                return true;
            }
        }
        return false;
    }

    public List<Object> ajC() {
        return this.aAw;
    }

    public void bu(List<Object> list) {
        this.aAw = list;
    }

    public void ff(boolean z) {
        this.cgM = z;
    }

    public int getDataType() {
        return this.csY;
    }

    public long aiP() {
        return this.cpp;
    }
}
