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
    private BdUniqueId bdH;
    private al dHu;
    private GroupPermData eRK;
    private GroupPermData eRL;
    private GroupPermData eRM;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eRN = new ArrayList();
    private List<GroupInfoData> eRO = new ArrayList();
    private List<GroupInfoData> eRP = new ArrayList();
    private int eRQ = 0;
    private int eRR = 0;
    private int eRS = 0;
    private int eRT = 0;
    private int eRU = 0;
    private int eRV = 0;
    private boolean eRW = false;
    private boolean eRX = false;
    private boolean eRY = false;
    private boolean eRZ = true;
    private boolean eSa = true;
    private boolean eSb = true;
    private FrsGroupRequestMessage eSc = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eSd = new FrsGroupReadCacheRequestMessage();
    private boolean bvS = true;
    private int aBh = 1;
    private Set<Long> eSe = new HashSet();
    private com.baidu.adp.framework.listener.c eSf = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eSc.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.qc(type);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eSc.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bvS, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dOG = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.eRS;
                    d.this.eRY = z;
                    d.this.eRM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eSb = false;
                } else if (type == 1) {
                    arVar.pn = d.this.eRQ;
                    d.this.eRW = z;
                    d.this.eRK = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eRZ = false;
                } else {
                    arVar.pn = d.this.eRR;
                    d.this.eRX = z;
                    d.this.eRL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eSa = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dHu != null) {
                    d.this.dHu.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dGP = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eSd.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.eRM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eRP = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eRK = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eRN = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eRL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eRO = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dHu != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dHu.a(4, type, arVar, a);
                }
                d.this.bn(type, 0);
            }
        }
    };

    public void bn(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bdH != null) {
            frsGroupRequestMessage.setTag(this.bdH);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eSc = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void ow(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bdH != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bdH);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eSd = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void qc(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dOG = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eRK;
            list = this.eRN;
            arVar.pn = this.eRQ;
            arVar.hasMore = this.eRW;
        } else if (i == 2) {
            groupPermData = this.eRL;
            list = this.eRO;
            arVar.pn = this.eRR;
            arVar.hasMore = this.eRX;
        } else if (i == 3) {
            groupPermData = this.eRM;
            list = this.eRP;
            arVar.pn = this.eRS;
            arVar.hasMore = this.eRY;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dHu != null) {
                this.dHu.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eRN = a(z, this.eRN, list);
            this.eRK = groupPermData;
            return a(this.eRK, this.eRN, i);
        } else if (i == 3) {
            this.eRM = groupPermData;
            this.eRP = a(z, this.eRP, list);
            return a(this.eRM, this.eRP, i);
        } else {
            this.eRL = groupPermData;
            this.eRO = a(z, this.eRO, list);
            return a(this.eRL, this.eRO, i);
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
        this.eSe.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eSe.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aBh + 3);
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
        iVar.mh(i2);
        return iVar;
    }

    private boolean qd(int i) {
        if (i == 1) {
            return this.eRZ;
        }
        if (i == 2) {
            return this.eSa;
        }
        if (i == 3) {
            return this.eSb;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dHu != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.qi(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.qh(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.qf(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kV()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.qi(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.qh(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.qg(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.qf(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bo(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dOG = false;
            arVar.pn = -1;
            this.dHu.a(4, this.aBh, arVar, arrayList);
        }
    }

    private boolean qe(int i) {
        if (i == 1) {
            return this.eRW;
        }
        if (i == 2) {
            return this.eRX;
        }
        if (i == 3) {
            return this.eRY;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.aBh = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (qd(i2)) {
                ow(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eRQ;
                } else if (i2 == 2) {
                    i3 = this.eRR;
                } else {
                    i3 = i2 == 3 ? this.eRS : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    qc(i2);
                } else if (a == 0) {
                    this.bvS = true;
                    bn(i2, 0);
                } else if (qe(i2)) {
                    this.bvS = false;
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
                this.eRT = 0;
                this.eRQ = 1;
                return 0;
            } else if (i == 2) {
                this.eRU = 0;
                this.eRR = 1;
                return 0;
            } else if (i == 3) {
                this.eRV = 0;
                this.eRS = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eRT += i2;
                int i4 = this.eRT;
                this.eRQ = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.eRU += i2;
                int i5 = this.eRU;
                this.eRR = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.eRV += i2;
                int i6 = this.eRV;
                this.eRS = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dHu = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bdH != null) {
            this.eSf.setTag(this.bdH);
            this.eSf.setSelfListener(true);
            this.dGP.setTag(this.bdH);
            this.dGP.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eSf);
        MessageManager.getInstance().registerListener(this.dGP);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdH = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void acn() {
        MessageManager.getInstance().unRegisterListener(this.eSf);
        MessageManager.getInstance().unRegisterListener(this.dGP);
    }
}
