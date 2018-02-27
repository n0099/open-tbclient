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
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements ak {
    private BdUniqueId bIv;
    private an dBk;
    private GroupPermData eCN;
    private GroupPermData eCO;
    private GroupPermData eCP;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eCQ = new ArrayList();
    private List<GroupInfoData> eCR = new ArrayList();
    private List<GroupInfoData> eCS = new ArrayList();
    private int eCT = 0;
    private int eCU = 0;
    private int eCV = 0;
    private int eCW = 0;
    private int eCX = 0;
    private int eCY = 0;
    private boolean eCZ = false;
    private boolean eDa = false;
    private boolean eDb = false;
    private boolean eDc = true;
    private boolean eDd = true;
    private boolean eDe = true;
    private FrsGroupRequestMessage eDf = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eDg = new FrsGroupReadCacheRequestMessage();
    private boolean bNH = true;
    private int aWg = 1;
    private Set<Integer> eDh = new HashSet();
    private com.baidu.adp.framework.listener.c eDi = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eDf.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pW(type);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eDf.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                at atVar = new at();
                ArrayList<com.baidu.adp.widget.ListView.i> a = d.this.a(d.this.bNH, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    atVar.hasMore = false;
                    z = false;
                } else {
                    atVar.hasMore = z;
                }
                atVar.errCode = frsGroupSocketResponseMessage.getError();
                atVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                atVar.forumId = d.this.forumId;
                atVar.forumName = d.this.forumName;
                atVar.dHx = false;
                atVar.isLocal = false;
                if (type == 3) {
                    atVar.pn = d.this.eCV;
                    d.this.eDb = z;
                    d.this.eCP = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDe = false;
                } else if (type == 1) {
                    atVar.pn = d.this.eCT;
                    d.this.eCZ = z;
                    d.this.eCN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDc = false;
                } else {
                    atVar.pn = d.this.eCU;
                    d.this.eDa = z;
                    d.this.eCO = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDd = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dBk != null) {
                    d.this.dBk.a(4, type, atVar, a);
                }
            }
        }
    };
    private CustomMessageListener dAH = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.i> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eDg.getType();
                at atVar = new at();
                atVar.errCode = customResponsedMessage.getError();
                atVar.errMsg = customResponsedMessage.getErrorString();
                atVar.forumId = d.this.forumId;
                atVar.forumName = d.this.forumName;
                atVar.isLocal = true;
                atVar.hasMore = false;
                atVar.pn = -1;
                if (type == 3) {
                    d.this.eCP = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eCS = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eCN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eCQ = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eCO = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eCR = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dBk != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dBk.a(4, type, atVar, a);
                }
                d.this.cb(type, 0);
            }
        }
    };

    public void cb(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bIv != null) {
            frsGroupRequestMessage.setTag(this.bIv);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eDf = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void or(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bIv != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bIv);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eDg = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pW(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        at atVar = new at();
        atVar.forumId = this.forumId;
        atVar.forumName = this.forumName;
        atVar.dHx = false;
        atVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eCN;
            list = this.eCQ;
            atVar.pn = this.eCT;
            atVar.hasMore = this.eCZ;
        } else if (i == 2) {
            groupPermData = this.eCO;
            list = this.eCR;
            atVar.pn = this.eCU;
            atVar.hasMore = this.eDa;
        } else if (i == 3) {
            groupPermData = this.eCP;
            list = this.eCS;
            atVar.pn = this.eCV;
            atVar.hasMore = this.eDb;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.i> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dBk != null) {
                this.dBk.a(4, i, atVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eCQ = a(z, this.eCQ, list);
            this.eCN = groupPermData;
            return a(this.eCN, this.eCQ, i);
        } else if (i == 3) {
            this.eCP = groupPermData;
            this.eCS = a(z, this.eCS, list);
            return a(this.eCP, this.eCS, i);
        } else {
            this.eCO = groupPermData;
            this.eCR = a(z, this.eCR, list);
            return a(this.eCO, this.eCR, i);
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
    public ArrayList<com.baidu.adp.widget.ListView.i> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        this.eDh.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eDh.add(Integer.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aWg + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cc((size * com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0141d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.h cc(int i, int i2) {
        com.baidu.tieba.frs.h hVar = new com.baidu.tieba.frs.h();
        hVar.setHeight(com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        hVar.mN(i2);
        return hVar;
    }

    private boolean pX(int i) {
        if (i == 1) {
            return this.eDc;
        }
        if (i == 2) {
            return this.eDd;
        }
        if (i == 3) {
            return this.eDe;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dBk != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.nv(TbadkCoreApplication.getInst().getResources().getString(d.j.login_see_more));
                hVar.nu(TbadkCoreApplication.getInst().getResources().getString(d.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.pZ(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.nv(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group));
                hVar.nu(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group_tip));
                hVar.nt(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.pZ(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cc(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            at atVar = new at();
            atVar.errCode = 0;
            atVar.forumId = this.forumId;
            atVar.forumName = this.forumName;
            atVar.hasMore = false;
            atVar.dHx = false;
            atVar.pn = -1;
            this.dBk.a(4, this.aWg, atVar, arrayList);
        }
    }

    private boolean pY(int i) {
        if (i == 1) {
            return this.eCZ;
        }
        if (i == 2) {
            return this.eDa;
        }
        if (i == 3) {
            return this.eDb;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        int i3;
        if (i == 4 && aqVar != null) {
            this.forumId = aqVar.forumId;
            this.forumName = aqVar.forumName;
            this.aWg = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (pX(i2)) {
                or(i2);
            } else {
                if (aqVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eCT;
                } else if (i2 == 2) {
                    i3 = this.eCU;
                } else {
                    i3 = i2 == 3 ? this.eCV : 0;
                }
                int a = a(i2, this.rn, i3, aqVar);
                if (a < 0) {
                    pW(i2);
                } else if (a == 0) {
                    this.bNH = true;
                    cb(i2, 0);
                } else if (pY(i2)) {
                    this.bNH = false;
                    cb(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, aq aqVar) {
        if (aqVar == null) {
            return -1;
        }
        if (aqVar.pn == -1) {
            if (i == 1) {
                this.eCW = 0;
                this.eCT = 1;
                return 0;
            } else if (i == 2) {
                this.eCX = 0;
                this.eCU = 1;
                return 0;
            } else if (i == 3) {
                this.eCY = 0;
                this.eCV = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aqVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eCW += i2;
                int i4 = this.eCW;
                this.eCT = aqVar.pn;
                return i4;
            } else if (i == 2) {
                this.eCX += i2;
                int i5 = this.eCX;
                this.eCU = aqVar.pn;
                return i5;
            } else if (i == 3) {
                this.eCY += i2;
                int i6 = this.eCY;
                this.eCV = aqVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dBk = anVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bIv != null) {
            this.eDi.setTag(this.bIv);
            this.eDi.setSelfListener(true);
            this.dAH.setTag(this.bIv);
            this.dAH.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eDi);
        MessageManager.getInstance().registerListener(this.dAH);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bIv = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void YZ() {
        MessageManager.getInstance().unRegisterListener(this.eDi);
        MessageManager.getInstance().unRegisterListener(this.dAH);
    }
}
