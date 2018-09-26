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
    private BdUniqueId aUU;
    private al doN;
    private GroupPermData ezb;
    private GroupPermData ezc;
    private GroupPermData ezd;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eze = new ArrayList();
    private List<GroupInfoData> ezf = new ArrayList();
    private List<GroupInfoData> ezg = new ArrayList();
    private int ezh = 0;
    private int ezi = 0;
    private int ezj = 0;
    private int ezk = 0;
    private int ezl = 0;
    private int ezm = 0;
    private boolean ezn = false;
    private boolean ezo = false;
    private boolean ezp = false;
    private boolean ezq = true;
    private boolean ezr = true;
    private boolean ezs = true;
    private FrsGroupRequestMessage ezt = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ezu = new FrsGroupReadCacheRequestMessage();
    private boolean bnC = true;
    private int asi = 1;
    private Set<Long> ezv = new HashSet();
    private com.baidu.adp.framework.listener.c ezw = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.ezt.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.oE(type);
                    if (com.baidu.adp.lib.util.j.kK()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.ezt.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bnC, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dwc = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.ezj;
                    d.this.ezp = z;
                    d.this.ezd = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ezs = false;
                } else if (type == 1) {
                    arVar.pn = d.this.ezh;
                    d.this.ezn = z;
                    d.this.ezb = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ezq = false;
                } else {
                    arVar.pn = d.this.ezi;
                    d.this.ezo = z;
                    d.this.ezc = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ezr = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.doN != null) {
                    d.this.doN.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener doi = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ezu.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.ezd = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ezg = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.ezb = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eze = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.ezc = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ezf = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.doN != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.doN.a(4, type, arVar, a);
                }
                d.this.bj(type, 0);
            }
        }
    };

    public void bj(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aUU != null) {
            frsGroupRequestMessage.setTag(this.aUU);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.ezt = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void mZ(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aUU != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aUU);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ezu = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void oE(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dwc = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.ezb;
            list = this.eze;
            arVar.pn = this.ezh;
            arVar.hasMore = this.ezn;
        } else if (i == 2) {
            groupPermData = this.ezc;
            list = this.ezf;
            arVar.pn = this.ezi;
            arVar.hasMore = this.ezo;
        } else if (i == 3) {
            groupPermData = this.ezd;
            list = this.ezg;
            arVar.pn = this.ezj;
            arVar.hasMore = this.ezp;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.doN != null) {
                this.doN.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eze = a(z, this.eze, list);
            this.ezb = groupPermData;
            return a(this.ezb, this.eze, i);
        } else if (i == 3) {
            this.ezd = groupPermData;
            this.ezg = a(z, this.ezg, list);
            return a(this.ezd, this.ezg, i);
        } else {
            this.ezc = groupPermData;
            this.ezf = a(z, this.ezf, list);
            return a(this.ezc, this.ezf, i);
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
        this.ezv.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.ezv.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.asi + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bk((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds120), e.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bk(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds90)) + i));
        iVar.kO(i2);
        return iVar;
    }

    private boolean oF(int i) {
        if (i == 1) {
            return this.ezq;
        }
        if (i == 2) {
            return this.ezr;
        }
        if (i == 3) {
            return this.ezs;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.doN != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.pa(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.oZ(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.oH(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kK()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.pa(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.oZ(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.oY(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.oH(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bk(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0141e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dwc = false;
            arVar.pn = -1;
            this.doN.a(4, this.asi, arVar, arrayList);
        }
    }

    private boolean oG(int i) {
        if (i == 1) {
            return this.ezn;
        }
        if (i == 2) {
            return this.ezo;
        }
        if (i == 3) {
            return this.ezp;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.asi = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (oF(i2)) {
                mZ(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.ezh;
                } else if (i2 == 2) {
                    i3 = this.ezi;
                } else {
                    i3 = i2 == 3 ? this.ezj : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    oE(i2);
                } else if (a == 0) {
                    this.bnC = true;
                    bj(i2, 0);
                } else if (oG(i2)) {
                    this.bnC = false;
                    bj(i2, a);
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
                this.ezk = 0;
                this.ezh = 1;
                return 0;
            } else if (i == 2) {
                this.ezl = 0;
                this.ezi = 1;
                return 0;
            } else if (i == 3) {
                this.ezm = 0;
                this.ezj = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ezk += i2;
                int i4 = this.ezk;
                this.ezh = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.ezl += i2;
                int i5 = this.ezl;
                this.ezi = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.ezm += i2;
                int i6 = this.ezm;
                this.ezj = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.doN = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aUU != null) {
            this.ezw.setTag(this.aUU);
            this.ezw.setSelfListener(true);
            this.doi.setTag(this.aUU);
            this.doi.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ezw);
        MessageManager.getInstance().registerListener(this.doi);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aUU = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Xn() {
        MessageManager.getInstance().unRegisterListener(this.ezw);
        MessageManager.getInstance().unRegisterListener(this.doi);
    }
}
