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
    private BdUniqueId aRF;
    private al diW;
    private GroupPermData erL;
    private GroupPermData erM;
    private GroupPermData erN;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> erO = new ArrayList();
    private List<GroupInfoData> erP = new ArrayList();
    private List<GroupInfoData> erQ = new ArrayList();
    private int erR = 0;
    private int erS = 0;
    private int erT = 0;
    private int erU = 0;
    private int erV = 0;
    private int erW = 0;
    private boolean erX = false;
    private boolean erY = false;
    private boolean erZ = false;
    private boolean esa = true;
    private boolean esb = true;
    private boolean esc = true;
    private FrsGroupRequestMessage esd = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ese = new FrsGroupReadCacheRequestMessage();
    private boolean bhJ = true;
    private int apJ = 1;
    private Set<Long> esf = new HashSet();
    private com.baidu.adp.framework.listener.c esg = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.esd.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.oa(type);
                    if (com.baidu.adp.lib.util.j.jE()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.esd.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bhJ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dpQ = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.erT;
                    d.this.erZ = z;
                    d.this.erN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.esc = false;
                } else if (type == 1) {
                    arVar.pn = d.this.erR;
                    d.this.erX = z;
                    d.this.erL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.esa = false;
                } else {
                    arVar.pn = d.this.erS;
                    d.this.erY = z;
                    d.this.erM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.esb = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.diW != null) {
                    d.this.diW.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dir = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ese.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.erN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erQ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.erL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erO = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.erM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erP = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.diW != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.diW.a(4, type, arVar, a);
                }
                d.this.bf(type, 0);
            }
        }
    };

    public void bf(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aRF != null) {
            frsGroupRequestMessage.setTag(this.aRF);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.esd = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void mv(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aRF != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aRF);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ese = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void oa(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dpQ = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.erL;
            list = this.erO;
            arVar.pn = this.erR;
            arVar.hasMore = this.erX;
        } else if (i == 2) {
            groupPermData = this.erM;
            list = this.erP;
            arVar.pn = this.erS;
            arVar.hasMore = this.erY;
        } else if (i == 3) {
            groupPermData = this.erN;
            list = this.erQ;
            arVar.pn = this.erT;
            arVar.hasMore = this.erZ;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.diW != null) {
                this.diW.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.erO = a(z, this.erO, list);
            this.erL = groupPermData;
            return a(this.erL, this.erO, i);
        } else if (i == 3) {
            this.erN = groupPermData;
            this.erQ = a(z, this.erQ, list);
            return a(this.erN, this.erQ, i);
        } else {
            this.erM = groupPermData;
            this.erP = a(z, this.erP, list);
            return a(this.erM, this.erP, i);
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
        this.esf.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.esf.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.apJ + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bg((size * com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0140d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bg(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        iVar.kq(i2);
        return iVar;
    }

    private boolean ob(int i) {
        if (i == 1) {
            return this.esa;
        }
        if (i == 2) {
            return this.esb;
        }
        if (i == 3) {
            return this.esc;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.diW != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.ot(TbadkCoreApplication.getInst().getResources().getString(d.j.login_see_more));
                hVar.os(TbadkCoreApplication.getInst().getResources().getString(d.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.od(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.jE()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.ot(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group));
                hVar.os(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group_tip));
                hVar.or(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.od(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bg(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dpQ = false;
            arVar.pn = -1;
            this.diW.a(4, this.apJ, arVar, arrayList);
        }
    }

    private boolean oc(int i) {
        if (i == 1) {
            return this.erX;
        }
        if (i == 2) {
            return this.erY;
        }
        if (i == 3) {
            return this.erZ;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.apJ = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (ob(i2)) {
                mv(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.erR;
                } else if (i2 == 2) {
                    i3 = this.erS;
                } else {
                    i3 = i2 == 3 ? this.erT : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    oa(i2);
                } else if (a == 0) {
                    this.bhJ = true;
                    bf(i2, 0);
                } else if (oc(i2)) {
                    this.bhJ = false;
                    bf(i2, a);
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
                this.erU = 0;
                this.erR = 1;
                return 0;
            } else if (i == 2) {
                this.erV = 0;
                this.erS = 1;
                return 0;
            } else if (i == 3) {
                this.erW = 0;
                this.erT = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.erU += i2;
                int i4 = this.erU;
                this.erR = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.erV += i2;
                int i5 = this.erV;
                this.erS = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.erW += i2;
                int i6 = this.erW;
                this.erT = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.diW = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aRF != null) {
            this.esg.setTag(this.aRF);
            this.esg.setSelfListener(true);
            this.dir.setTag(this.aRF);
            this.dir.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.esg);
        MessageManager.getInstance().registerListener(this.dir);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aRF = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Vx() {
        MessageManager.getInstance().unRegisterListener(this.esg);
        MessageManager.getInstance().unRegisterListener(this.dir);
    }
}
