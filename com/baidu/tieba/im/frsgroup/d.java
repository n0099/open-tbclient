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
    private BdUniqueId bII;
    private an dBw;
    private GroupPermData eCZ;
    private GroupPermData eDa;
    private GroupPermData eDb;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eDc = new ArrayList();
    private List<GroupInfoData> eDd = new ArrayList();
    private List<GroupInfoData> eDe = new ArrayList();
    private int eDf = 0;
    private int eDg = 0;
    private int eDh = 0;
    private int eDi = 0;
    private int eDj = 0;
    private int eDk = 0;
    private boolean eDl = false;
    private boolean eDm = false;
    private boolean eDn = false;
    private boolean eDo = true;
    private boolean eDp = true;
    private boolean eDq = true;
    private FrsGroupRequestMessage eDr = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eDs = new FrsGroupReadCacheRequestMessage();
    private boolean bNU = true;
    private int aWs = 1;
    private Set<Integer> eDt = new HashSet();
    private com.baidu.adp.framework.listener.c eDu = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eDr.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pW(type);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eDr.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                at atVar = new at();
                ArrayList<com.baidu.adp.widget.ListView.i> a = d.this.a(d.this.bNU, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                atVar.dHJ = false;
                atVar.isLocal = false;
                if (type == 3) {
                    atVar.pn = d.this.eDh;
                    d.this.eDn = z;
                    d.this.eDb = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDq = false;
                } else if (type == 1) {
                    atVar.pn = d.this.eDf;
                    d.this.eDl = z;
                    d.this.eCZ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDo = false;
                } else {
                    atVar.pn = d.this.eDg;
                    d.this.eDm = z;
                    d.this.eDa = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDp = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dBw != null) {
                    d.this.dBw.a(4, type, atVar, a);
                }
            }
        }
    };
    private CustomMessageListener dAT = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.i> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eDs.getType();
                at atVar = new at();
                atVar.errCode = customResponsedMessage.getError();
                atVar.errMsg = customResponsedMessage.getErrorString();
                atVar.forumId = d.this.forumId;
                atVar.forumName = d.this.forumName;
                atVar.isLocal = true;
                atVar.hasMore = false;
                atVar.pn = -1;
                if (type == 3) {
                    d.this.eDb = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDe = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eCZ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDc = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eDa = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDd = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dBw != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dBw.a(4, type, atVar, a);
                }
                d.this.cb(type, 0);
            }
        }
    };

    public void cb(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bII != null) {
            frsGroupRequestMessage.setTag(this.bII);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eDr = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void or(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bII != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bII);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eDs = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pW(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        at atVar = new at();
        atVar.forumId = this.forumId;
        atVar.forumName = this.forumName;
        atVar.dHJ = false;
        atVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eCZ;
            list = this.eDc;
            atVar.pn = this.eDf;
            atVar.hasMore = this.eDl;
        } else if (i == 2) {
            groupPermData = this.eDa;
            list = this.eDd;
            atVar.pn = this.eDg;
            atVar.hasMore = this.eDm;
        } else if (i == 3) {
            groupPermData = this.eDb;
            list = this.eDe;
            atVar.pn = this.eDh;
            atVar.hasMore = this.eDn;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.i> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dBw != null) {
                this.dBw.a(4, i, atVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eDc = a(z, this.eDc, list);
            this.eCZ = groupPermData;
            return a(this.eCZ, this.eDc, i);
        } else if (i == 3) {
            this.eDb = groupPermData;
            this.eDe = a(z, this.eDe, list);
            return a(this.eDb, this.eDe, i);
        } else {
            this.eDa = groupPermData;
            this.eDd = a(z, this.eDd, list);
            return a(this.eDa, this.eDd, i);
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
        this.eDt.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eDt.add(Integer.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aWs + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cc((size * com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0140d.cp_bg_line_d));
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
            return this.eDo;
        }
        if (i == 2) {
            return this.eDp;
        }
        if (i == 3) {
            return this.eDq;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dBw != null) {
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
            atVar.dHJ = false;
            atVar.pn = -1;
            this.dBw.a(4, this.aWs, atVar, arrayList);
        }
    }

    private boolean pY(int i) {
        if (i == 1) {
            return this.eDl;
        }
        if (i == 2) {
            return this.eDm;
        }
        if (i == 3) {
            return this.eDn;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        int i3;
        if (i == 4 && aqVar != null) {
            this.forumId = aqVar.forumId;
            this.forumName = aqVar.forumName;
            this.aWs = i2;
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
                    i3 = this.eDf;
                } else if (i2 == 2) {
                    i3 = this.eDg;
                } else {
                    i3 = i2 == 3 ? this.eDh : 0;
                }
                int a = a(i2, this.rn, i3, aqVar);
                if (a < 0) {
                    pW(i2);
                } else if (a == 0) {
                    this.bNU = true;
                    cb(i2, 0);
                } else if (pY(i2)) {
                    this.bNU = false;
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
                this.eDi = 0;
                this.eDf = 1;
                return 0;
            } else if (i == 2) {
                this.eDj = 0;
                this.eDg = 1;
                return 0;
            } else if (i == 3) {
                this.eDk = 0;
                this.eDh = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aqVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eDi += i2;
                int i4 = this.eDi;
                this.eDf = aqVar.pn;
                return i4;
            } else if (i == 2) {
                this.eDj += i2;
                int i5 = this.eDj;
                this.eDg = aqVar.pn;
                return i5;
            } else if (i == 3) {
                this.eDk += i2;
                int i6 = this.eDk;
                this.eDh = aqVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dBw = anVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bII != null) {
            this.eDu.setTag(this.bII);
            this.eDu.setSelfListener(true);
            this.dAT.setTag(this.bII);
            this.dAT.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eDu);
        MessageManager.getInstance().registerListener(this.dAT);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bII = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void Za() {
        MessageManager.getInstance().unRegisterListener(this.eDu);
        MessageManager.getInstance().unRegisterListener(this.dAT);
    }
}
