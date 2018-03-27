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
    private BdUniqueId bIy;
    private an dBn;
    private GroupPermData eDd;
    private GroupPermData eDe;
    private GroupPermData eDf;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eDg = new ArrayList();
    private List<GroupInfoData> eDh = new ArrayList();
    private List<GroupInfoData> eDi = new ArrayList();
    private int eDj = 0;
    private int eDk = 0;
    private int eDl = 0;
    private int eDm = 0;
    private int eDn = 0;
    private int eDo = 0;
    private boolean eDp = false;
    private boolean eDq = false;
    private boolean eDr = false;
    private boolean eDs = true;
    private boolean eDt = true;
    private boolean eDu = true;
    private FrsGroupRequestMessage eDv = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eDw = new FrsGroupReadCacheRequestMessage();
    private boolean bNK = true;
    private int aWi = 1;
    private Set<Integer> eDx = new HashSet();
    private com.baidu.adp.framework.listener.c eDy = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eDv.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pX(type);
                    if (com.baidu.adp.lib.util.j.oJ()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eDv.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                at atVar = new at();
                ArrayList<com.baidu.adp.widget.ListView.i> a = d.this.a(d.this.bNK, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                atVar.dHC = false;
                atVar.isLocal = false;
                if (type == 3) {
                    atVar.pn = d.this.eDl;
                    d.this.eDr = z;
                    d.this.eDf = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDu = false;
                } else if (type == 1) {
                    atVar.pn = d.this.eDj;
                    d.this.eDp = z;
                    d.this.eDd = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDs = false;
                } else {
                    atVar.pn = d.this.eDk;
                    d.this.eDq = z;
                    d.this.eDe = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eDt = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dBn != null) {
                    d.this.dBn.a(4, type, atVar, a);
                }
            }
        }
    };
    private CustomMessageListener dAK = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.i> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eDw.getType();
                at atVar = new at();
                atVar.errCode = customResponsedMessage.getError();
                atVar.errMsg = customResponsedMessage.getErrorString();
                atVar.forumId = d.this.forumId;
                atVar.forumName = d.this.forumName;
                atVar.isLocal = true;
                atVar.hasMore = false;
                atVar.pn = -1;
                if (type == 3) {
                    d.this.eDf = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDi = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eDd = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDg = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eDe = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eDh = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dBn != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dBn.a(4, type, atVar, a);
                }
                d.this.cb(type, 0);
            }
        }
    };

    public void cb(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bIy != null) {
            frsGroupRequestMessage.setTag(this.bIy);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eDv = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void os(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bIy != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bIy);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eDw = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pX(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        at atVar = new at();
        atVar.forumId = this.forumId;
        atVar.forumName = this.forumName;
        atVar.dHC = false;
        atVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eDd;
            list = this.eDg;
            atVar.pn = this.eDj;
            atVar.hasMore = this.eDp;
        } else if (i == 2) {
            groupPermData = this.eDe;
            list = this.eDh;
            atVar.pn = this.eDk;
            atVar.hasMore = this.eDq;
        } else if (i == 3) {
            groupPermData = this.eDf;
            list = this.eDi;
            atVar.pn = this.eDl;
            atVar.hasMore = this.eDr;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.i> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dBn != null) {
                this.dBn.a(4, i, atVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.i> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eDg = a(z, this.eDg, list);
            this.eDd = groupPermData;
            return a(this.eDd, this.eDg, i);
        } else if (i == 3) {
            this.eDf = groupPermData;
            this.eDi = a(z, this.eDi, list);
            return a(this.eDf, this.eDi, i);
        } else {
            this.eDe = groupPermData;
            this.eDh = a(z, this.eDh, list);
            return a(this.eDe, this.eDh, i);
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
        this.eDx.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eDx.add(Integer.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aWi + 3);
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

    private boolean pY(int i) {
        if (i == 1) {
            return this.eDs;
        }
        if (i == 2) {
            return this.eDt;
        }
        if (i == 3) {
            return this.eDu;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dBn != null) {
            ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.nv(TbadkCoreApplication.getInst().getResources().getString(d.j.login_see_more));
                hVar.nu(TbadkCoreApplication.getInst().getResources().getString(d.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.qa(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.oJ()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.nv(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group));
                hVar.nu(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group_tip));
                hVar.nt(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.qa(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cc(com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            at atVar = new at();
            atVar.errCode = 0;
            atVar.forumId = this.forumId;
            atVar.forumName = this.forumName;
            atVar.hasMore = false;
            atVar.dHC = false;
            atVar.pn = -1;
            this.dBn.a(4, this.aWi, atVar, arrayList);
        }
    }

    private boolean pZ(int i) {
        if (i == 1) {
            return this.eDp;
        }
        if (i == 2) {
            return this.eDq;
        }
        if (i == 3) {
            return this.eDr;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        int i3;
        if (i == 4 && aqVar != null) {
            this.forumId = aqVar.forumId;
            this.forumName = aqVar.forumName;
            this.aWi = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (pY(i2)) {
                os(i2);
            } else {
                if (aqVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eDj;
                } else if (i2 == 2) {
                    i3 = this.eDk;
                } else {
                    i3 = i2 == 3 ? this.eDl : 0;
                }
                int a = a(i2, this.rn, i3, aqVar);
                if (a < 0) {
                    pX(i2);
                } else if (a == 0) {
                    this.bNK = true;
                    cb(i2, 0);
                } else if (pZ(i2)) {
                    this.bNK = false;
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
                this.eDm = 0;
                this.eDj = 1;
                return 0;
            } else if (i == 2) {
                this.eDn = 0;
                this.eDk = 1;
                return 0;
            } else if (i == 3) {
                this.eDo = 0;
                this.eDl = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aqVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eDm += i2;
                int i4 = this.eDm;
                this.eDj = aqVar.pn;
                return i4;
            } else if (i == 2) {
                this.eDn += i2;
                int i5 = this.eDn;
                this.eDk = aqVar.pn;
                return i5;
            } else if (i == 3) {
                this.eDo += i2;
                int i6 = this.eDo;
                this.eDl = aqVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dBn = anVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bIy != null) {
            this.eDy.setTag(this.bIy);
            this.eDy.setSelfListener(true);
            this.dAK.setTag(this.bIy);
            this.dAK.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eDy);
        MessageManager.getInstance().registerListener(this.dAK);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bIy = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void Za() {
        MessageManager.getInstance().unRegisterListener(this.eDy);
        MessageManager.getInstance().unRegisterListener(this.dAK);
    }
}
