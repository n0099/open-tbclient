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
    private BdUniqueId bdE;
    private al dEG;
    private GroupPermData eOT;
    private GroupPermData eOU;
    private GroupPermData eOV;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eOW = new ArrayList();
    private List<GroupInfoData> eOX = new ArrayList();
    private List<GroupInfoData> eOY = new ArrayList();
    private int eOZ = 0;
    private int ePa = 0;
    private int ePb = 0;
    private int ePc = 0;
    private int ePd = 0;
    private int ePe = 0;
    private boolean ePf = false;
    private boolean ePg = false;
    private boolean ePh = false;
    private boolean ePi = true;
    private boolean ePj = true;
    private boolean ePk = true;
    private FrsGroupRequestMessage ePl = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ePm = new FrsGroupReadCacheRequestMessage();
    private boolean bvP = true;
    private int aBh = 1;
    private Set<Long> ePn = new HashSet();
    private com.baidu.adp.framework.listener.c ePo = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.ePl.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pP(type);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.ePl.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bvP, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dLS = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.ePb;
                    d.this.ePh = z;
                    d.this.eOV = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ePk = false;
                } else if (type == 1) {
                    arVar.pn = d.this.eOZ;
                    d.this.ePf = z;
                    d.this.eOT = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ePi = false;
                } else {
                    arVar.pn = d.this.ePa;
                    d.this.ePg = z;
                    d.this.eOU = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ePj = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dEG != null) {
                    d.this.dEG.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dEb = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ePm.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.eOV = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eOY = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eOT = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eOW = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eOU = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eOX = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dEG != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dEG.a(4, type, arVar, a);
                }
                d.this.bm(type, 0);
            }
        }
    };

    public void bm(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bdE != null) {
            frsGroupRequestMessage.setTag(this.bdE);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.ePl = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void oj(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bdE != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bdE);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ePm = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pP(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dLS = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eOT;
            list = this.eOW;
            arVar.pn = this.eOZ;
            arVar.hasMore = this.ePf;
        } else if (i == 2) {
            groupPermData = this.eOU;
            list = this.eOX;
            arVar.pn = this.ePa;
            arVar.hasMore = this.ePg;
        } else if (i == 3) {
            groupPermData = this.eOV;
            list = this.eOY;
            arVar.pn = this.ePb;
            arVar.hasMore = this.ePh;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dEG != null) {
                this.dEG.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eOW = a(z, this.eOW, list);
            this.eOT = groupPermData;
            return a(this.eOT, this.eOW, i);
        } else if (i == 3) {
            this.eOV = groupPermData;
            this.eOY = a(z, this.eOY, list);
            return a(this.eOV, this.eOY, i);
        } else {
            this.eOU = groupPermData;
            this.eOX = a(z, this.eOX, list);
            return a(this.eOU, this.eOX, i);
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
        this.ePn.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.ePn.add(Long.valueOf(groupInfoData.getGroupId()))) {
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
            arrayList.add(bn((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds120), e.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bn(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds90)) + i));
        iVar.lU(i2);
        return iVar;
    }

    private boolean pQ(int i) {
        if (i == 1) {
            return this.ePi;
        }
        if (i == 2) {
            return this.ePj;
        }
        if (i == 3) {
            return this.ePk;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dEG != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.qf(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.qe(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.pS(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kV()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.qf(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.qe(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.qd(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.pS(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bn(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dLS = false;
            arVar.pn = -1;
            this.dEG.a(4, this.aBh, arVar, arrayList);
        }
    }

    private boolean pR(int i) {
        if (i == 1) {
            return this.ePf;
        }
        if (i == 2) {
            return this.ePg;
        }
        if (i == 3) {
            return this.ePh;
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
            } else if (pQ(i2)) {
                oj(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eOZ;
                } else if (i2 == 2) {
                    i3 = this.ePa;
                } else {
                    i3 = i2 == 3 ? this.ePb : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    pP(i2);
                } else if (a == 0) {
                    this.bvP = true;
                    bm(i2, 0);
                } else if (pR(i2)) {
                    this.bvP = false;
                    bm(i2, a);
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
                this.ePc = 0;
                this.eOZ = 1;
                return 0;
            } else if (i == 2) {
                this.ePd = 0;
                this.ePa = 1;
                return 0;
            } else if (i == 3) {
                this.ePe = 0;
                this.ePb = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ePc += i2;
                int i4 = this.ePc;
                this.eOZ = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.ePd += i2;
                int i5 = this.ePd;
                this.ePa = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.ePe += i2;
                int i6 = this.ePe;
                this.ePb = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dEG = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bdE != null) {
            this.ePo.setTag(this.bdE);
            this.ePo.setSelfListener(true);
            this.dEb.setTag(this.bdE);
            this.dEb.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ePo);
        MessageManager.getInstance().registerListener(this.dEb);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdE = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void acl() {
        MessageManager.getInstance().unRegisterListener(this.ePo);
        MessageManager.getInstance().unRegisterListener(this.dEb);
    }
}
