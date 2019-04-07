package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class d implements af {
    private BdUniqueId cnZ;
    private ai eVd;
    private String forumId;
    private String forumName;
    private GroupPermData gis;
    private GroupPermData git;
    private GroupPermData giu;
    private int rn;
    private List<GroupInfoData> giv = new ArrayList();
    private List<GroupInfoData> giw = new ArrayList();
    private List<GroupInfoData> gix = new ArrayList();
    private int giy = 0;
    private int giz = 0;
    private int giA = 0;
    private int giB = 0;
    private int giC = 0;
    private int giD = 0;
    private boolean giE = false;
    private boolean giF = false;
    private boolean giG = false;
    private boolean giH = true;
    private boolean giI = true;
    private boolean giJ = true;
    private FrsGroupRequestMessage giK = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage giL = new FrsGroupReadCacheRequestMessage();
    private boolean cHP = true;
    private int bJI = 1;
    private Set<Long> giM = new HashSet();
    private com.baidu.adp.framework.listener.c giN = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.giK.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.tJ(type);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.giK.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cHP, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    apVar.hasMore = false;
                    z = false;
                } else {
                    apVar.hasMore = z;
                }
                apVar.errCode = frsGroupSocketResponseMessage.getError();
                apVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.fcQ = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.giA;
                    d.this.giG = z;
                    d.this.giu = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giJ = false;
                } else if (type == 1) {
                    apVar.pn = d.this.giy;
                    d.this.giE = z;
                    d.this.gis = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giH = false;
                } else {
                    apVar.pn = d.this.giz;
                    d.this.giF = z;
                    d.this.git = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giI = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.eVd != null) {
                    d.this.eVd.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener eUy = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.giL.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.giu = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gix = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gis = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.giv = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.git = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.giw = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.eVd != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.eVd.a(4, type, apVar, a);
                }
                d.this.bJ(type, 0);
            }
        }
    };

    public void bJ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cnZ != null) {
            frsGroupRequestMessage.setTag(this.cnZ);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.giK = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void sc(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cnZ != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cnZ);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.giL = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void tJ(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fcQ = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gis;
            list = this.giv;
            apVar.pn = this.giy;
            apVar.hasMore = this.giE;
        } else if (i == 2) {
            groupPermData = this.git;
            list = this.giw;
            apVar.pn = this.giz;
            apVar.hasMore = this.giF;
        } else if (i == 3) {
            groupPermData = this.giu;
            list = this.gix;
            apVar.pn = this.giA;
            apVar.hasMore = this.giG;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.eVd != null) {
                this.eVd.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.giv = a(z, this.giv, list);
            this.gis = groupPermData;
            return a(this.gis, this.giv, i);
        } else if (i == 3) {
            this.giu = groupPermData;
            this.gix = a(z, this.gix, list);
            return a(this.giu, this.gix, i);
        } else {
            this.git = groupPermData;
            this.giw = a(z, this.giw, list);
            return a(this.git, this.giw, i);
        }
    }

    private List<GroupInfoData> a(boolean z, List<GroupInfoData> list, List<GroupInfoData> list2) {
        if (list == null) {
            list = new ArrayList<>();
        }
        if (z) {
            list.clear();
        }
        if (list2 != null) {
            list.addAll(list2);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        this.giM.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.giM.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bJI + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bK((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0277d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bK(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        iVar.pP(i2);
        return iVar;
    }

    private boolean tK(int i) {
        if (i == 1) {
            return this.giH;
        }
        if (i == 2) {
            return this.giI;
        }
        if (i == 3) {
            return this.giJ;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.eVd != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.xb(TbadkCoreApplication.getInst().getResources().getString(d.j.login_see_more));
                hVar.xa(TbadkCoreApplication.getInst().getResources().getString(d.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.tM(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kY()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.xb(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group));
                hVar.xa(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group_tip));
                hVar.wZ(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.tM(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bK(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fcQ = false;
            apVar.pn = -1;
            this.eVd.a(4, this.bJI, apVar, arrayList);
        }
    }

    private boolean tL(int i) {
        if (i == 1) {
            return this.giE;
        }
        if (i == 2) {
            return this.giF;
        }
        if (i == 3) {
            return this.giG;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bJI = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (tK(i2)) {
                sc(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.giy;
                } else if (i2 == 2) {
                    i3 = this.giz;
                } else {
                    i3 = i2 == 3 ? this.giA : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    tJ(i2);
                } else if (a == 0) {
                    this.cHP = true;
                    bJ(i2, 0);
                } else if (tL(i2)) {
                    this.cHP = false;
                    bJ(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, am amVar) {
        if (amVar == null) {
            return -1;
        }
        if (amVar.pn == -1) {
            if (i == 1) {
                this.giB = 0;
                this.giy = 1;
                return 0;
            } else if (i == 2) {
                this.giC = 0;
                this.giz = 1;
                return 0;
            } else if (i == 3) {
                this.giD = 0;
                this.giA = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.giB += i2;
                int i4 = this.giB;
                this.giy = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.giC += i2;
                int i5 = this.giC;
                this.giz = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.giD += i2;
                int i6 = this.giD;
                this.giA = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.eVd = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cnZ != null) {
            this.giN.setTag(this.cnZ);
            this.giN.setSelfListener(true);
            this.eUy.setTag(this.cnZ);
            this.eUy.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.giN);
        MessageManager.getInstance().registerListener(this.eUy);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cnZ = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aDC() {
        MessageManager.getInstance().unRegisterListener(this.giN);
        MessageManager.getInstance().unRegisterListener(this.eUy);
    }
}
