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
    private BdUniqueId aZt;
    private al dwP;
    private GroupPermData eGL;
    private GroupPermData eGM;
    private GroupPermData eGN;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eGO = new ArrayList();
    private List<GroupInfoData> eGP = new ArrayList();
    private List<GroupInfoData> eGQ = new ArrayList();
    private int eGR = 0;
    private int eGS = 0;
    private int eGT = 0;
    private int eGU = 0;
    private int eGV = 0;
    private int eGW = 0;
    private boolean eGX = false;
    private boolean eGY = false;
    private boolean eGZ = false;
    private boolean eHa = true;
    private boolean eHb = true;
    private boolean eHc = true;
    private FrsGroupRequestMessage eHd = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eHe = new FrsGroupReadCacheRequestMessage();
    private boolean brE = true;
    private int awU = 1;
    private Set<Long> eHf = new HashSet();
    private com.baidu.adp.framework.listener.c eHg = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eHd.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pc(type);
                    if (com.baidu.adp.lib.util.j.kX()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eHd.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.brE, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dEd = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.eGT;
                    d.this.eGZ = z;
                    d.this.eGN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eHc = false;
                } else if (type == 1) {
                    arVar.pn = d.this.eGR;
                    d.this.eGX = z;
                    d.this.eGL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eHa = false;
                } else {
                    arVar.pn = d.this.eGS;
                    d.this.eGY = z;
                    d.this.eGM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eHb = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dwP != null) {
                    d.this.dwP.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dwk = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eHe.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.eGN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eGQ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eGL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eGO = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eGM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eGP = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dwP != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dwP.a(4, type, arVar, a);
                }
                d.this.bm(type, 0);
            }
        }
    };

    public void bm(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aZt != null) {
            frsGroupRequestMessage.setTag(this.aZt);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eHd = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void nx(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aZt != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aZt);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eHe = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pc(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dEd = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eGL;
            list = this.eGO;
            arVar.pn = this.eGR;
            arVar.hasMore = this.eGX;
        } else if (i == 2) {
            groupPermData = this.eGM;
            list = this.eGP;
            arVar.pn = this.eGS;
            arVar.hasMore = this.eGY;
        } else if (i == 3) {
            groupPermData = this.eGN;
            list = this.eGQ;
            arVar.pn = this.eGT;
            arVar.hasMore = this.eGZ;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dwP != null) {
                this.dwP.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eGO = a(z, this.eGO, list);
            this.eGL = groupPermData;
            return a(this.eGL, this.eGO, i);
        } else if (i == 3) {
            this.eGN = groupPermData;
            this.eGQ = a(z, this.eGQ, list);
            return a(this.eGN, this.eGQ, i);
        } else {
            this.eGM = groupPermData;
            this.eGP = a(z, this.eGP, list);
            return a(this.eGM, this.eGP, i);
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
        this.eHf.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eHf.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.awU + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bn((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds120), e.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bn(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds90)) + i));
        iVar.lm(i2);
        return iVar;
    }

    private boolean pd(int i) {
        if (i == 1) {
            return this.eHa;
        }
        if (i == 2) {
            return this.eHb;
        }
        if (i == 3) {
            return this.eHc;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dwP != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.pC(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.pB(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.pf(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kX()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.pC(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.pB(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.pA(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.pf(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bn(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0175e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dEd = false;
            arVar.pn = -1;
            this.dwP.a(4, this.awU, arVar, arrayList);
        }
    }

    private boolean pe(int i) {
        if (i == 1) {
            return this.eGX;
        }
        if (i == 2) {
            return this.eGY;
        }
        if (i == 3) {
            return this.eGZ;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.awU = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (pd(i2)) {
                nx(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eGR;
                } else if (i2 == 2) {
                    i3 = this.eGS;
                } else {
                    i3 = i2 == 3 ? this.eGT : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    pc(i2);
                } else if (a == 0) {
                    this.brE = true;
                    bm(i2, 0);
                } else if (pe(i2)) {
                    this.brE = false;
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
                this.eGU = 0;
                this.eGR = 1;
                return 0;
            } else if (i == 2) {
                this.eGV = 0;
                this.eGS = 1;
                return 0;
            } else if (i == 3) {
                this.eGW = 0;
                this.eGT = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eGU += i2;
                int i4 = this.eGU;
                this.eGR = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.eGV += i2;
                int i5 = this.eGV;
                this.eGS = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.eGW += i2;
                int i6 = this.eGW;
                this.eGT = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dwP = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aZt != null) {
            this.eHg.setTag(this.aZt);
            this.eHg.setSelfListener(true);
            this.dwk.setTag(this.aZt);
            this.dwk.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eHg);
        MessageManager.getInstance().registerListener(this.dwk);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aZt = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void aaU() {
        MessageManager.getInstance().unRegisterListener(this.eHg);
        MessageManager.getInstance().unRegisterListener(this.dwk);
    }
}
