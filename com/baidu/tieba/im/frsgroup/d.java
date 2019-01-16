package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements ai {
    private BdUniqueId bes;
    private al dId;
    private GroupPermData eSx;
    private GroupPermData eSy;
    private GroupPermData eSz;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eSA = new ArrayList();
    private List<GroupInfoData> eSB = new ArrayList();
    private List<GroupInfoData> eSC = new ArrayList();
    private int eSD = 0;
    private int eSE = 0;
    private int eSF = 0;
    private int eSG = 0;
    private int eSH = 0;
    private int eSI = 0;
    private boolean eSJ = false;
    private boolean eSK = false;
    private boolean eSL = false;
    private boolean eSM = true;
    private boolean eSN = true;
    private boolean eSO = true;
    private FrsGroupRequestMessage eSP = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eSQ = new FrsGroupReadCacheRequestMessage();
    private boolean bwG = true;
    private int aBJ = 1;
    private Set<Long> eSR = new HashSet();
    private com.baidu.adp.framework.listener.c eSS = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eSP.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.qd(type);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eSP.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bwG, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    arVar.hasMore = false;
                    z = false;
                } else {
                    arVar.hasMore = z;
                }
                arVar.errCode = frsGroupSocketResponseMessage.getError();
                arVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.dPp = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.eSF;
                    d.this.eSL = z;
                    d.this.eSz = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eSO = false;
                } else if (type == 1) {
                    arVar.pn = d.this.eSD;
                    d.this.eSJ = z;
                    d.this.eSx = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eSM = false;
                } else {
                    arVar.pn = d.this.eSE;
                    d.this.eSK = z;
                    d.this.eSy = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eSN = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dId != null) {
                    d.this.dId.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dHy = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eSQ.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.eSz = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eSC = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eSx = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eSA = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eSy = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eSB = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dId != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dId.a(4, type, arVar, a);
                }
                d.this.bn(type, 0);
            }
        }
    };

    public void bn(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bes != null) {
            frsGroupRequestMessage.setTag(this.bes);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eSP = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void ox(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bes != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bes);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eSQ = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void qd(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dPp = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eSx;
            list = this.eSA;
            arVar.pn = this.eSD;
            arVar.hasMore = this.eSJ;
        } else if (i == 2) {
            groupPermData = this.eSy;
            list = this.eSB;
            arVar.pn = this.eSE;
            arVar.hasMore = this.eSK;
        } else if (i == 3) {
            groupPermData = this.eSz;
            list = this.eSC;
            arVar.pn = this.eSF;
            arVar.hasMore = this.eSL;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dId != null) {
                this.dId.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eSA = a(z, this.eSA, list);
            this.eSx = groupPermData;
            return a(this.eSx, this.eSA, i);
        } else if (i == 3) {
            this.eSz = groupPermData;
            this.eSC = a(z, this.eSC, list);
            return a(this.eSz, this.eSC, i);
        } else {
            this.eSy = groupPermData;
            this.eSB = a(z, this.eSB, list);
            return a(this.eSy, this.eSB, i);
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
        this.eSR.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eSR.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aBJ + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bo((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds120), e.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bo(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds90)) + i));
        iVar.mi(i2);
        return iVar;
    }

    private boolean qe(int i) {
        if (i == 1) {
            return this.eSM;
        }
        if (i == 2) {
            return this.eSN;
        }
        if (i == 3) {
            return this.eSO;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dId != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.qy(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.qx(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.qg(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kV()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.qy(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.qx(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.qw(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.qg(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bo(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dPp = false;
            arVar.pn = -1;
            this.dId.a(4, this.aBJ, arVar, arrayList);
        }
    }

    private boolean qf(int i) {
        if (i == 1) {
            return this.eSJ;
        }
        if (i == 2) {
            return this.eSK;
        }
        if (i == 3) {
            return this.eSL;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.aBJ = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (qe(i2)) {
                ox(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eSD;
                } else if (i2 == 2) {
                    i3 = this.eSE;
                } else {
                    i3 = i2 == 3 ? this.eSF : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    qd(i2);
                } else if (a == 0) {
                    this.bwG = true;
                    bn(i2, 0);
                } else if (qf(i2)) {
                    this.bwG = false;
                    bn(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, ao aoVar) {
        if (aoVar == null) {
            return -1;
        }
        if (aoVar.pn == -1) {
            if (i == 1) {
                this.eSG = 0;
                this.eSD = 1;
                return 0;
            } else if (i == 2) {
                this.eSH = 0;
                this.eSE = 1;
                return 0;
            } else if (i == 3) {
                this.eSI = 0;
                this.eSF = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eSG += i2;
                int i4 = this.eSG;
                this.eSD = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.eSH += i2;
                int i5 = this.eSH;
                this.eSE = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.eSI += i2;
                int i6 = this.eSI;
                this.eSF = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dId = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bes != null) {
            this.eSS.setTag(this.bes);
            this.eSS.setSelfListener(true);
            this.dHy.setTag(this.bes);
            this.dHy.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eSS);
        MessageManager.getInstance().registerListener(this.dHy);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bes = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void acK() {
        MessageManager.getInstance().unRegisterListener(this.eSS);
        MessageManager.getInstance().unRegisterListener(this.dHy);
    }
}
