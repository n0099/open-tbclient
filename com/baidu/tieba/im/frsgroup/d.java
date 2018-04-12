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
    private aj cTZ;
    private GroupPermData dXH;
    private GroupPermData dXI;
    private GroupPermData dXJ;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> dXK = new ArrayList();
    private List<GroupInfoData> dXL = new ArrayList();
    private List<GroupInfoData> dXM = new ArrayList();
    private int dXN = 0;
    private int dXO = 0;
    private int dXP = 0;
    private int dXQ = 0;
    private int dXR = 0;
    private int dXS = 0;
    private boolean dXT = false;
    private boolean dXU = false;
    private boolean dXV = false;
    private boolean dXW = true;
    private boolean dXX = true;
    private boolean dXY = true;
    private FrsGroupRequestMessage dXZ = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage dYa = new FrsGroupReadCacheRequestMessage();
    private boolean aXI = true;
    private int ahC = 1;
    private Set<Long> dYb = new HashSet();
    private com.baidu.adp.framework.listener.c dYc = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.dXZ.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.nv(type);
                    if (com.baidu.adp.lib.util.j.gP()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.dXZ.getRn();
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
                apVar.daw = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.dXP;
                    d.this.dXV = z;
                    d.this.dXJ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXY = false;
                } else if (type == 1) {
                    apVar.pn = d.this.dXN;
                    d.this.dXT = z;
                    d.this.dXH = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXW = false;
                } else {
                    apVar.pn = d.this.dXO;
                    d.this.dXU = z;
                    d.this.dXI = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.dXX = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.cTZ != null) {
                    d.this.cTZ.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener cTw = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.dYa.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.dXJ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXM = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.dXH = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXK = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.dXI = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.dXL = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.cTZ != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.cTZ.a(4, type, apVar, a);
                }
                d.this.bd(type, 0);
            }
        }
    };

    public void bd(int i, int i2) {
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
        this.dXZ = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void lS(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aTr != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aTr);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.dYa = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void nv(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.daw = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.dXH;
            list = this.dXK;
            apVar.pn = this.dXN;
            apVar.hasMore = this.dXT;
        } else if (i == 2) {
            groupPermData = this.dXI;
            list = this.dXL;
            apVar.pn = this.dXO;
            apVar.hasMore = this.dXU;
        } else if (i == 3) {
            groupPermData = this.dXJ;
            list = this.dXM;
            apVar.pn = this.dXP;
            apVar.hasMore = this.dXV;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.cTZ != null) {
                this.cTZ.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.dXK = a(z, this.dXK, list);
            this.dXH = groupPermData;
            return a(this.dXH, this.dXK, i);
        } else if (i == 3) {
            this.dXJ = groupPermData;
            this.dXM = a(z, this.dXM, list);
            return a(this.dXJ, this.dXM, i);
        } else {
            this.dXI = groupPermData;
            this.dXL = a(z, this.dXL, list);
            return a(this.dXI, this.dXL, i);
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
        this.dYb.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.dYb.add(Long.valueOf(groupInfoData.getGroupId()))) {
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
            arrayList.add(be((size * com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0126d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.g be(int i, int i2) {
        com.baidu.tieba.frs.g gVar = new com.baidu.tieba.frs.g();
        gVar.setHeight(com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        gVar.ka(i2);
        return gVar;
    }

    private boolean nw(int i) {
        if (i == 1) {
            return this.dXW;
        }
        if (i == 2) {
            return this.dXX;
        }
        if (i == 3) {
            return this.dXY;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.cTZ != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.nz(TbadkCoreApplication.getInst().getResources().getString(d.k.login_see_more));
                hVar.ny(TbadkCoreApplication.getInst().getResources().getString(d.k.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.ny(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.gP()) {
                arrayList.add(new com.baidu.tieba.frs.k());
            } else {
                hVar.nz(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group));
                hVar.ny(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group_tip));
                hVar.nx(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.ny(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(be(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.daw = false;
            apVar.pn = -1;
            this.cTZ.a(4, this.ahC, apVar, arrayList);
        }
    }

    private boolean nx(int i) {
        if (i == 1) {
            return this.dXT;
        }
        if (i == 2) {
            return this.dXU;
        }
        if (i == 3) {
            return this.dXV;
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
            } else if (nw(i2)) {
                lS(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.dXN;
                } else if (i2 == 2) {
                    i3 = this.dXO;
                } else {
                    i3 = i2 == 3 ? this.dXP : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    nv(i2);
                } else if (a == 0) {
                    this.aXI = true;
                    bd(i2, 0);
                } else if (nx(i2)) {
                    this.aXI = false;
                    bd(i2, a);
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
                this.dXQ = 0;
                this.dXN = 1;
                return 0;
            } else if (i == 2) {
                this.dXR = 0;
                this.dXO = 1;
                return 0;
            } else if (i == 3) {
                this.dXS = 0;
                this.dXP = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.dXQ += i2;
                int i4 = this.dXQ;
                this.dXN = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.dXR += i2;
                int i5 = this.dXR;
                this.dXO = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.dXS += i2;
                int i6 = this.dXS;
                this.dXP = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.cTZ = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aTr != null) {
            this.dYc.setTag(this.aTr);
            this.dYc.setSelfListener(true);
            this.cTw.setTag(this.aTr);
            this.cTw.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.dYc);
        MessageManager.getInstance().registerListener(this.cTw);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aTr = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void Ry() {
        MessageManager.getInstance().unRegisterListener(this.dYc);
        MessageManager.getInstance().unRegisterListener(this.cTw);
    }
}
