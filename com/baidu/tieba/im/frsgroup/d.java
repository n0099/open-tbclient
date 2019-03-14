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
import com.baidu.tieba.frs.af;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes5.dex */
public class d implements af {
    private BdUniqueId cnX;
    private ai eVr;
    private String forumId;
    private String forumName;
    private GroupPermData giF;
    private GroupPermData giG;
    private GroupPermData giH;
    private int rn;
    private List<GroupInfoData> giI = new ArrayList();
    private List<GroupInfoData> giJ = new ArrayList();
    private List<GroupInfoData> giK = new ArrayList();
    private int giL = 0;
    private int giM = 0;
    private int giN = 0;
    private int giO = 0;
    private int giP = 0;
    private int giQ = 0;
    private boolean giR = false;
    private boolean giS = false;
    private boolean giT = false;
    private boolean giU = true;
    private boolean giV = true;
    private boolean giW = true;
    private FrsGroupRequestMessage giX = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage giY = new FrsGroupReadCacheRequestMessage();
    private boolean cHN = true;
    private int bJG = 1;
    private Set<Long> giZ = new HashSet();
    private com.baidu.adp.framework.listener.c gja = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.giX.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.tN(type);
                    if (com.baidu.adp.lib.util.j.kY()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.giX.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cHN, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    apVar.hasMore = false;
                    z = false;
                } else {
                    apVar.hasMore = z;
                }
                apVar.errCode = frsGroupSocketResponseMessage.getError();
                apVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.fdd = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.giN;
                    d.this.giT = z;
                    d.this.giH = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giW = false;
                } else if (type == 1) {
                    apVar.pn = d.this.giL;
                    d.this.giR = z;
                    d.this.giF = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giU = false;
                } else {
                    apVar.pn = d.this.giM;
                    d.this.giS = z;
                    d.this.giG = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.giV = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.eVr != null) {
                    d.this.eVr.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener eUM = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.giY.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.giH = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.giK = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.giF = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.giI = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.giG = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.giJ = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.eVr != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.eVr.a(4, type, apVar, a);
                }
                d.this.bJ(type, 0);
            }
        }
    };

    public void bJ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cnX != null) {
            frsGroupRequestMessage.setTag(this.cnX);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.giX = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void sg(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cnX != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cnX);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.giY = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void tN(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fdd = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.giF;
            list = this.giI;
            apVar.pn = this.giL;
            apVar.hasMore = this.giR;
        } else if (i == 2) {
            groupPermData = this.giG;
            list = this.giJ;
            apVar.pn = this.giM;
            apVar.hasMore = this.giS;
        } else if (i == 3) {
            groupPermData = this.giH;
            list = this.giK;
            apVar.pn = this.giN;
            apVar.hasMore = this.giT;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.eVr != null) {
                this.eVr.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.giI = a(z, this.giI, list);
            this.giF = groupPermData;
            return a(this.giF, this.giI, i);
        } else if (i == 3) {
            this.giH = groupPermData;
            this.giK = a(z, this.giK, list);
            return a(this.giH, this.giK, i);
        } else {
            this.giG = groupPermData;
            this.giJ = a(z, this.giJ, list);
            return a(this.giG, this.giJ, i);
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
    public ArrayList<com.baidu.adp.widget.ListView.m> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        this.giZ.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.giZ.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bJG + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bK((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0277d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bK(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        iVar.pT(i2);
        return iVar;
    }

    private boolean tO(int i) {
        if (i == 1) {
            return this.giU;
        }
        if (i == 2) {
            return this.giV;
        }
        if (i == 3) {
            return this.giW;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.eVr != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.xc(TbadkCoreApplication.getInst().getResources().getString(d.j.login_see_more));
                hVar.xb(TbadkCoreApplication.getInst().getResources().getString(d.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.tQ(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kY()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.xc(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group));
                hVar.xb(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_hot_create_group_tip));
                hVar.xa(TbadkCoreApplication.getInst().getResources().getString(d.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.tQ(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bK(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fdd = false;
            apVar.pn = -1;
            this.eVr.a(4, this.bJG, apVar, arrayList);
        }
    }

    private boolean tP(int i) {
        if (i == 1) {
            return this.giR;
        }
        if (i == 2) {
            return this.giS;
        }
        if (i == 3) {
            return this.giT;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bJG = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (tO(i2)) {
                sg(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.giL;
                } else if (i2 == 2) {
                    i3 = this.giM;
                } else {
                    i3 = i2 == 3 ? this.giN : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    tN(i2);
                } else if (a == 0) {
                    this.cHN = true;
                    bJ(i2, 0);
                } else if (tP(i2)) {
                    this.cHN = false;
                    bJ(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, am amVar) {
        if (amVar == null) {
            return -1;
        }
        if (amVar.pn == -1) {
            if (i == 1) {
                this.giO = 0;
                this.giL = 1;
                return 0;
            } else if (i == 2) {
                this.giP = 0;
                this.giM = 1;
                return 0;
            } else if (i == 3) {
                this.giQ = 0;
                this.giN = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.giO += i2;
                int i4 = this.giO;
                this.giL = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.giP += i2;
                int i5 = this.giP;
                this.giM = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.giQ += i2;
                int i6 = this.giQ;
                this.giN = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.eVr = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cnX != null) {
            this.gja.setTag(this.cnX);
            this.gja.setSelfListener(true);
            this.eUM.setTag(this.cnX);
            this.eUM.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gja);
        MessageManager.getInstance().registerListener(this.eUM);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cnX = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aDF() {
        MessageManager.getInstance().unRegisterListener(this.gja);
        MessageManager.getInstance().unRegisterListener(this.eUM);
    }
}
