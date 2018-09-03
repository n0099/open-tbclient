package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.f;
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
    private BdUniqueId aRC;
    private al diU;
    private GroupPermData erH;
    private GroupPermData erI;
    private GroupPermData erJ;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> erK = new ArrayList();
    private List<GroupInfoData> erL = new ArrayList();
    private List<GroupInfoData> erM = new ArrayList();
    private int erN = 0;
    private int erO = 0;
    private int erP = 0;
    private int erQ = 0;
    private int erR = 0;
    private int erS = 0;
    private boolean erT = false;
    private boolean erU = false;
    private boolean erV = false;
    private boolean erW = true;
    private boolean erX = true;
    private boolean erY = true;
    private FrsGroupRequestMessage erZ = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage esa = new FrsGroupReadCacheRequestMessage();
    private boolean bhK = true;
    private int apK = 1;
    private Set<Long> esb = new HashSet();
    private com.baidu.adp.framework.listener.c esc = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.erZ.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.oa(type);
                    if (com.baidu.adp.lib.util.j.jE()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.erZ.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bhK, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dpO = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.erP;
                    d.this.erV = z;
                    d.this.erJ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.erY = false;
                } else if (type == 1) {
                    arVar.pn = d.this.erN;
                    d.this.erT = z;
                    d.this.erH = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.erW = false;
                } else {
                    arVar.pn = d.this.erO;
                    d.this.erU = z;
                    d.this.erI = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.erX = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.diU != null) {
                    d.this.diU.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dip = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.esa.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.erJ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erM = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.erH = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erK = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.erI = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.erL = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.diU != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.diU.a(4, type, arVar, a);
                }
                d.this.bf(type, 0);
            }
        }
    };

    public void bf(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aRC != null) {
            frsGroupRequestMessage.setTag(this.aRC);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.erZ = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void mv(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aRC != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aRC);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.esa = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void oa(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dpO = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.erH;
            list = this.erK;
            arVar.pn = this.erN;
            arVar.hasMore = this.erT;
        } else if (i == 2) {
            groupPermData = this.erI;
            list = this.erL;
            arVar.pn = this.erO;
            arVar.hasMore = this.erU;
        } else if (i == 3) {
            groupPermData = this.erJ;
            list = this.erM;
            arVar.pn = this.erP;
            arVar.hasMore = this.erV;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.diU != null) {
                this.diU.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.erK = a(z, this.erK, list);
            this.erH = groupPermData;
            return a(this.erH, this.erK, i);
        } else if (i == 3) {
            this.erJ = groupPermData;
            this.erM = a(z, this.erM, list);
            return a(this.erJ, this.erM, i);
        } else {
            this.erI = groupPermData;
            this.erL = a(z, this.erL, list);
            return a(this.erI, this.erL, i);
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
        this.esb.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.esb.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.apK + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bg((size * com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds160)) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds120), f.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bg(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds100) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds90)) + i));
        iVar.kp(i2);
        return iVar;
    }

    private boolean ob(int i) {
        if (i == 1) {
            return this.erW;
        }
        if (i == 2) {
            return this.erX;
        }
        if (i == 3) {
            return this.erY;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.diU != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.ov(TbadkCoreApplication.getInst().getResources().getString(f.j.login_see_more));
                hVar.ou(TbadkCoreApplication.getInst().getResources().getString(f.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.od(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.jE()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.ov(TbadkCoreApplication.getInst().getResources().getString(f.j.frsgroup_hot_create_group));
                hVar.ou(TbadkCoreApplication.getInst().getResources().getString(f.j.frsgroup_hot_create_group_tip));
                hVar.ot(TbadkCoreApplication.getInst().getResources().getString(f.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.od(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bg(com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds600) + com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds80), f.C0146f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dpO = false;
            arVar.pn = -1;
            this.diU.a(4, this.apK, arVar, arrayList);
        }
    }

    private boolean oc(int i) {
        if (i == 1) {
            return this.erT;
        }
        if (i == 2) {
            return this.erU;
        }
        if (i == 3) {
            return this.erV;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.apK = i2;
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
                    i3 = this.erN;
                } else if (i2 == 2) {
                    i3 = this.erO;
                } else {
                    i3 = i2 == 3 ? this.erP : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    oa(i2);
                } else if (a == 0) {
                    this.bhK = true;
                    bf(i2, 0);
                } else if (oc(i2)) {
                    this.bhK = false;
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
                this.erQ = 0;
                this.erN = 1;
                return 0;
            } else if (i == 2) {
                this.erR = 0;
                this.erO = 1;
                return 0;
            } else if (i == 3) {
                this.erS = 0;
                this.erP = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.erQ += i2;
                int i4 = this.erQ;
                this.erN = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.erR += i2;
                int i5 = this.erR;
                this.erO = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.erS += i2;
                int i6 = this.erS;
                this.erP = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.diU = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aRC != null) {
            this.esc.setTag(this.aRC);
            this.esc.setSelfListener(true);
            this.dip.setTag(this.aRC);
            this.dip.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.esc);
        MessageManager.getInstance().registerListener(this.dip);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aRC = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void VA() {
        MessageManager.getInstance().unRegisterListener(this.esc);
        MessageManager.getInstance().unRegisterListener(this.dip);
    }
}
