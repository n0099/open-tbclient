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
    private final TagInfo czS;
    private DataRes czT;
    private int czU;
    private String czY;
    private com.baidu.tieba.card.data.b czZ;
    private boolean hasMore;
    private int pn;
    private List<Object> aEY = new ArrayList();
    private boolean cnc = false;
    private boolean czV = false;
    private boolean czW = false;
    private int czX = 1;
    private long cwp = 0;

    public a(TagInfo tagInfo) {
        this.czS = tagInfo;
    }

    public int getPn() {
        return this.pn;
    }

    public void c(DataRes dataRes) {
        this.czT = dataRes;
    }

    public void jX(int i) {
        this.czU = i;
    }

    public int ajK() {
        return this.czU;
    }

    public boolean ajL() {
        return this.czV;
    }

    public boolean ajM() {
        return this.czW;
    }

    public TagInfo ajN() {
        return this.czS;
    }

    public String ajO() {
        return this.czY;
    }

    public boolean hasMore() {
        return this.hasMore;
    }

    public void a(boolean z, c cVar, boolean z2) {
        if (z) {
            this.czW = true;
        } else {
            this.czV = true;
        }
        if (cVar != null) {
            this.pn = cVar.getPn();
            this.hasMore = cVar.getHasMore();
            if (cVar instanceof com.baidu.tieba.homepage.mygod.data.d) {
                this.cwp = ((com.baidu.tieba.homepage.mygod.data.d) cVar).ajc();
            }
            List<Object> a = a(z2, cVar);
            if (z2) {
                this.aEY.addAll(a);
            } else {
                this.aEY = a;
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
            this.czX = 3;
            for (Object obj : cVar.getThreadList()) {
                if (obj instanceof ICardInfo) {
                    list.add(obj);
                }
            }
            int size = list.size();
            if (size > 0) {
                this.czY = ((ICardInfo) list.get(size - 1)).getFlipId();
            }
        }
    }

    private void b(List<Object> list, c cVar, boolean z) {
        if (list != null && cVar != null && cVar.getThreadList() != null && cVar.getThreadList().size() != 0) {
            this.czX = 1;
            for (Object obj : cVar.getThreadList()) {
                if ((obj instanceof ExcellentThreadInfo) && (!z || !a((ExcellentThreadInfo) obj))) {
                    e eVar = new e();
                    eVar.b((ExcellentThreadInfo) obj);
                    eVar.setShowImage(cVar.ajQ());
                    if (eVar.ajX() != 33) {
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
                this.czZ = null;
            }
            this.czX = 2;
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
                        this.czZ = ahVar;
                    } else if (biVar.Yz == 1) {
                        g gVar = new g();
                        gVar.buR = fVar;
                        a(gVar);
                        this.czZ = gVar;
                    } else {
                        a(fVar);
                        this.czZ = fVar;
                    }
                    list.add(this.czZ);
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
        if (this.pn == 1 && dVar.aje() != null) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.a(dVar.aje()));
        } else if (this.pn == 1 && dVar.ajd() == 0) {
            list.add(0, new com.baidu.tieba.homepage.mygod.data.b());
        }
    }

    private void C(bi biVar) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            if (biVar.getThreadType() == 49) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = new com.baidu.tieba.homepage.alalivelist.view.d();
                dVar.bbo = biVar;
                a(dVar);
                this.czZ = dVar;
            } else if (biVar.getThreadType() == 50) {
                h hVar = new h();
                hVar.bbo = biVar;
                a(hVar);
                this.czZ = hVar;
            }
        }
    }

    private void b(c cVar, List<Object> list) {
        if (MessageManager.getInstance().findTask(CmdConfigCustom.CMD_ALA_LIVE_ROOM_START) != null) {
            com.baidu.tieba.homepage.alalivelist.data.c cVar2 = (com.baidu.tieba.homepage.alalivelist.data.c) cVar;
            if (cVar2.ctv != null && cVar2.ctv.type.intValue() != com.baidu.tieba.homepage.alalivelist.data.c.ctu && this.pn == 1) {
                list.add(0, new com.baidu.tieba.homepage.alalivelist.a.c(cVar2.ctv));
            }
        }
    }

    private void a(com.baidu.tieba.card.data.b bVar) {
        if (bVar != null && bVar.getType() != null) {
            if (this.czZ == null) {
                bVar.needTopMargin = false;
            } else if (this.czZ.getType() == null) {
                bVar.needTopMargin = false;
            } else if (this.czZ instanceof f) {
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
        int size = this.aEY.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aEY.get(i);
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
        int size = this.aEY.size();
        if (size <= 0) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            Object obj = this.aEY.get(i);
            if (obj instanceof ThreadInfo) {
                if (threadInfo.id.equals(((ThreadInfo) obj).id)) {
                    return true;
                }
            } else if (obj instanceof com.baidu.tieba.homepage.alalivelist.view.d) {
                com.baidu.tieba.homepage.alalivelist.view.d dVar = (com.baidu.tieba.homepage.alalivelist.view.d) obj;
                if (dVar.bbo == null) {
                    return false;
                }
                if (String.valueOf(threadInfo.id).equals(dVar.bbo.getId())) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    public List<Object> ajP() {
        return this.aEY;
    }

    public void bg(List<Object> list) {
        this.aEY = list;
    }

    public void fa(boolean z) {
        this.cnc = z;
    }

    public int getDataType() {
        return this.czX;
    }

    public long ajc() {
        return this.cwp;
    }
}
