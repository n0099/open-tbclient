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
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements ag {
    private BdUniqueId aTs;
    private aj cVd;
    private GroupPermData dYL;
    private GroupPermData dYM;
    private GroupPermData dYN;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> dYO = new ArrayList();
    private List<GroupInfoData> dYP = new ArrayList();
    private List<GroupInfoData> dYQ = new ArrayList();
    private int dYR = 0;
    private int dYS = 0;
    private int dYT = 0;
    private int dYU = 0;
    private int dYV = 0;
    private int dYW = 0;
    private boolean dYX = false;
    private boolean dYY = false;
    private boolean dYZ = false;
    private boolean dZa = true;
    private boolean dZb = true;
    private boolean dZc = true;
    private FrsGroupRequestMessage dZd = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage dZe = new FrsGroupReadCacheRequestMessage();
    private boolean aXJ = true;
    private int ahC = 1;
    private Set<Long> dZf = new HashSet();
    private com.baidu.adp.framework.listener.c dZg = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.dZd.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.nt(type);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.dZd.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.aXJ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.dbB = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.dYT;
                    d.this.dYZ = z;
                    d.this.dYN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dZc = false;
                } else if (type == 1) {
                    apVar.pn = d.this.dYR;
                    d.this.dYX = z;
                    d.this.dYL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dZa = false;
                } else {
                    apVar.pn = d.this.dYS;
                    d.this.dYY = z;
                    d.this.dYM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dZb = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.cVd != null) {
                    d.this.cVd.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener cUA = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.dZe.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.dYN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dYQ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.dYL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dYO = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.dYM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dYP = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.cVd != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.cVd.a(4, type, apVar, a);
                }
                d.this.bc(type, 0);
            }
        }
    };

    public void bc(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aTs != null) {
            frsGroupRequestMessage.setTag(this.aTs);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.dZd = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void lQ(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aTs != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aTs);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.dZe = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void nt(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.dbB = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.dYL;
            list = this.dYO;
            apVar.pn = this.dYR;
            apVar.hasMore = this.dYX;
        } else if (i == 2) {
            groupPermData = this.dYM;
            list = this.dYP;
            apVar.pn = this.dYS;
            apVar.hasMore = this.dYY;
        } else if (i == 3) {
            groupPermData = this.dYN;
            list = this.dYQ;
            apVar.pn = this.dYT;
            apVar.hasMore = this.dYZ;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.cVd != null) {
                this.cVd.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.dYO = a(z, this.dYO, list);
            this.dYL = groupPermData;
            return a(this.dYL, this.dYO, i);
        } else if (i == 3) {
            this.dYN = groupPermData;
            this.dYQ = a(z, this.dYQ, list);
            return a(this.dYN, this.dYQ, i);
        } else {
            this.dYM = groupPermData;
            this.dYP = a(z, this.dYP, list);
            return a(this.dYM, this.dYP, i);
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
    public ArrayList<com.baidu.adp.widget.ListView.h> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        this.dZf.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.dZf.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.ahC + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bd((size * com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0126d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.g bd(int i, int i2) {
        com.baidu.tieba.frs.g gVar = new com.baidu.tieba.frs.g();
        gVar.setHeight(com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        gVar.jY(i2);
        return gVar;
    }

    private boolean nu(int i) {
        if (i == 1) {
            return this.dZa;
        }
        if (i == 2) {
            return this.dZb;
        }
        if (i == 3) {
            return this.dZc;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.cVd != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.nC(TbadkCoreApplication.getInst().getResources().getString(d.k.login_see_more));
                hVar.nB(TbadkCoreApplication.getInst().getResources().getString(d.k.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.nw(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.gP()) {
                arrayList.add(new com.baidu.tieba.frs.k());
            } else {
                hVar.nC(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group));
                hVar.nB(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group_tip));
                hVar.nA(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.nw(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bd(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.dbB = false;
            apVar.pn = -1;
            this.cVd.a(4, this.ahC, apVar, arrayList);
        }
    }

    private boolean nv(int i) {
        if (i == 1) {
            return this.dYX;
        }
        if (i == 2) {
            return this.dYY;
        }
        if (i == 3) {
            return this.dYZ;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.ahC = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (nu(i2)) {
                lQ(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.dYR;
                } else if (i2 == 2) {
                    i3 = this.dYS;
                } else {
                    i3 = i2 == 3 ? this.dYT : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    nt(i2);
                } else if (a == 0) {
                    this.aXJ = true;
                    bc(i2, 0);
                } else if (nv(i2)) {
                    this.aXJ = false;
                    bc(i2, a);
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
                this.dYU = 0;
                this.dYR = 1;
                return 0;
            } else if (i == 2) {
                this.dYV = 0;
                this.dYS = 1;
                return 0;
            } else if (i == 3) {
                this.dYW = 0;
                this.dYT = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.dYU += i2;
                int i4 = this.dYU;
                this.dYR = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.dYV += i2;
                int i5 = this.dYV;
                this.dYS = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.dYW += i2;
                int i6 = this.dYW;
                this.dYT = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.cVd = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aTs != null) {
            this.dZg.setTag(this.aTs);
            this.dZg.setSelfListener(true);
            this.cUA.setTag(this.aTs);
            this.cUA.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.dZg);
        MessageManager.getInstance().registerListener(this.cUA);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTs = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void Rv() {
        MessageManager.getInstance().unRegisterListener(this.dZg);
        MessageManager.getInstance().unRegisterListener(this.cUA);
    }
}
