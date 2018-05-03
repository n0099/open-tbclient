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
    private BdUniqueId aTr;
    private aj cTW;
    private GroupPermData dXE;
    private GroupPermData dXF;
    private GroupPermData dXG;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> dXH = new ArrayList();
    private List<GroupInfoData> dXI = new ArrayList();
    private List<GroupInfoData> dXJ = new ArrayList();
    private int dXK = 0;
    private int dXL = 0;
    private int dXM = 0;
    private int dXN = 0;
    private int dXO = 0;
    private int dXP = 0;
    private boolean dXQ = false;
    private boolean dXR = false;
    private boolean dXS = false;
    private boolean dXT = true;
    private boolean dXU = true;
    private boolean dXV = true;
    private FrsGroupRequestMessage dXW = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage dXX = new FrsGroupReadCacheRequestMessage();
    private boolean aXI = true;
    private int ahC = 1;
    private Set<Long> dXY = new HashSet();
    private com.baidu.adp.framework.listener.c dXZ = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.dXW.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.nu(type);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.dXW.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.aXI, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.das = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.dXM;
                    d.this.dXS = z;
                    d.this.dXG = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXV = false;
                } else if (type == 1) {
                    apVar.pn = d.this.dXK;
                    d.this.dXQ = z;
                    d.this.dXE = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXT = false;
                } else {
                    apVar.pn = d.this.dXL;
                    d.this.dXR = z;
                    d.this.dXF = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXU = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.cTW != null) {
                    d.this.cTW.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener cTt = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.dXX.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.dXG = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXJ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.dXE = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXH = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.dXF = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXI = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.cTW != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.cTW.a(4, type, apVar, a);
                }
                d.this.bc(type, 0);
            }
        }
    };

    public void bc(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aTr != null) {
            frsGroupRequestMessage.setTag(this.aTr);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.dXW = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void lR(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aTr != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aTr);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.dXX = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void nu(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.das = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.dXE;
            list = this.dXH;
            apVar.pn = this.dXK;
            apVar.hasMore = this.dXQ;
        } else if (i == 2) {
            groupPermData = this.dXF;
            list = this.dXI;
            apVar.pn = this.dXL;
            apVar.hasMore = this.dXR;
        } else if (i == 3) {
            groupPermData = this.dXG;
            list = this.dXJ;
            apVar.pn = this.dXM;
            apVar.hasMore = this.dXS;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.cTW != null) {
                this.cTW.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.dXH = a(z, this.dXH, list);
            this.dXE = groupPermData;
            return a(this.dXE, this.dXH, i);
        } else if (i == 3) {
            this.dXG = groupPermData;
            this.dXJ = a(z, this.dXJ, list);
            return a(this.dXG, this.dXJ, i);
        } else {
            this.dXF = groupPermData;
            this.dXI = a(z, this.dXI, list);
            return a(this.dXF, this.dXI, i);
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
        this.dXY.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.dXY.add(Long.valueOf(groupInfoData.getGroupId()))) {
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
        gVar.jZ(i2);
        return gVar;
    }

    private boolean nv(int i) {
        if (i == 1) {
            return this.dXT;
        }
        if (i == 2) {
            return this.dXU;
        }
        if (i == 3) {
            return this.dXV;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.cTW != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.nz(TbadkCoreApplication.getInst().getResources().getString(d.k.login_see_more));
                hVar.ny(TbadkCoreApplication.getInst().getResources().getString(d.k.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.nx(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.gP()) {
                arrayList.add(new com.baidu.tieba.frs.k());
            } else {
                hVar.nz(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group));
                hVar.ny(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group_tip));
                hVar.nx(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.nx(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bd(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.das = false;
            apVar.pn = -1;
            this.cTW.a(4, this.ahC, apVar, arrayList);
        }
    }

    private boolean nw(int i) {
        if (i == 1) {
            return this.dXQ;
        }
        if (i == 2) {
            return this.dXR;
        }
        if (i == 3) {
            return this.dXS;
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
            } else if (nv(i2)) {
                lR(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.dXK;
                } else if (i2 == 2) {
                    i3 = this.dXL;
                } else {
                    i3 = i2 == 3 ? this.dXM : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    nu(i2);
                } else if (a == 0) {
                    this.aXI = true;
                    bc(i2, 0);
                } else if (nw(i2)) {
                    this.aXI = false;
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
                this.dXN = 0;
                this.dXK = 1;
                return 0;
            } else if (i == 2) {
                this.dXO = 0;
                this.dXL = 1;
                return 0;
            } else if (i == 3) {
                this.dXP = 0;
                this.dXM = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.dXN += i2;
                int i4 = this.dXN;
                this.dXK = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.dXO += i2;
                int i5 = this.dXO;
                this.dXL = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.dXP += i2;
                int i6 = this.dXP;
                this.dXM = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.cTW = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aTr != null) {
            this.dXZ.setTag(this.aTr);
            this.dXZ.setSelfListener(true);
            this.cTt.setTag(this.aTr);
            this.cTt.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.dXZ);
        MessageManager.getInstance().registerListener(this.cTt);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTr = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void Ry() {
        MessageManager.getInstance().unRegisterListener(this.dXZ);
        MessageManager.getInstance().unRegisterListener(this.cTt);
    }
}
