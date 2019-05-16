package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
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
    private BdUniqueId cwh;
    private ai flo;
    private String forumId;
    private String forumName;
    private GroupPermData gzG;
    private GroupPermData gzH;
    private GroupPermData gzI;
    private int rn;
    private List<GroupInfoData> gzJ = new ArrayList();
    private List<GroupInfoData> gzK = new ArrayList();
    private List<GroupInfoData> gzL = new ArrayList();
    private int gzM = 0;
    private int gzN = 0;
    private int gzO = 0;
    private int gzP = 0;
    private int gzQ = 0;
    private int gzR = 0;
    private boolean gzS = false;
    private boolean gzT = false;
    private boolean gzU = false;
    private boolean gzV = true;
    private boolean gzW = true;
    private boolean gzX = true;
    private FrsGroupRequestMessage gzY = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gzZ = new FrsGroupReadCacheRequestMessage();
    private boolean cPZ = true;
    private int bRt = 1;
    private Set<Long> gAa = new HashSet();
    private com.baidu.adp.framework.listener.c gAb = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gzY.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.uQ(type);
                    if (com.baidu.adp.lib.util.j.jS()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gzY.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cPZ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fte = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gzO;
                    d.this.gzU = z;
                    d.this.gzI = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gzX = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gzM;
                    d.this.gzS = z;
                    d.this.gzG = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gzV = false;
                } else {
                    apVar.pn = d.this.gzN;
                    d.this.gzT = z;
                    d.this.gzH = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gzW = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.flo != null) {
                    d.this.flo.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener fkJ = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gzZ.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gzI = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gzL = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gzG = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gzJ = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gzH = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gzK = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.flo != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.flo.a(4, type, apVar, a);
                }
                d.this.bQ(type, 0);
            }
        }
    };

    public void bQ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cwh != null) {
            frsGroupRequestMessage.setTag(this.cwh);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gzY = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void tk(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cwh != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cwh);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gzZ = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void uQ(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fte = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gzG;
            list = this.gzJ;
            apVar.pn = this.gzM;
            apVar.hasMore = this.gzS;
        } else if (i == 2) {
            groupPermData = this.gzH;
            list = this.gzK;
            apVar.pn = this.gzN;
            apVar.hasMore = this.gzT;
        } else if (i == 3) {
            groupPermData = this.gzI;
            list = this.gzL;
            apVar.pn = this.gzO;
            apVar.hasMore = this.gzU;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.flo != null) {
                this.flo.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gzJ = a(z, this.gzJ, list);
            this.gzG = groupPermData;
            return a(this.gzG, this.gzJ, i);
        } else if (i == 3) {
            this.gzI = groupPermData;
            this.gzL = a(z, this.gzL, list);
            return a(this.gzI, this.gzL, i);
        } else {
            this.gzH = groupPermData;
            this.gzK = a(z, this.gzK, list);
            return a(this.gzH, this.gzK, i);
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
        this.gAa.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gAa.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bRt + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bR((size * com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bR(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        iVar.qV(i2);
        return iVar;
    }

    private boolean uR(int i) {
        if (i == 1) {
            return this.gzV;
        }
        if (i == 2) {
            return this.gzW;
        }
        if (i == 3) {
            return this.gzX;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.flo != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.yq(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.yp(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.uT(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.jS()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.yq(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.yp(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.yo(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.uT(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bR(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fte = false;
            apVar.pn = -1;
            this.flo.a(4, this.bRt, apVar, arrayList);
        }
    }

    private boolean uS(int i) {
        if (i == 1) {
            return this.gzS;
        }
        if (i == 2) {
            return this.gzT;
        }
        if (i == 3) {
            return this.gzU;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bRt = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (uR(i2)) {
                tk(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gzM;
                } else if (i2 == 2) {
                    i3 = this.gzN;
                } else {
                    i3 = i2 == 3 ? this.gzO : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    uQ(i2);
                } else if (a == 0) {
                    this.cPZ = true;
                    bQ(i2, 0);
                } else if (uS(i2)) {
                    this.cPZ = false;
                    bQ(i2, a);
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
                this.gzP = 0;
                this.gzM = 1;
                return 0;
            } else if (i == 2) {
                this.gzQ = 0;
                this.gzN = 1;
                return 0;
            } else if (i == 3) {
                this.gzR = 0;
                this.gzO = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gzP += i2;
                int i4 = this.gzP;
                this.gzM = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gzQ += i2;
                int i5 = this.gzQ;
                this.gzN = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gzR += i2;
                int i6 = this.gzR;
                this.gzO = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.flo = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cwh != null) {
            this.gAb.setTag(this.cwh);
            this.gAb.setSelfListener(true);
            this.fkJ.setTag(this.cwh);
            this.fkJ.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gAb);
        MessageManager.getInstance().registerListener(this.fkJ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cwh = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aJP() {
        MessageManager.getInstance().unRegisterListener(this.gAb);
        MessageManager.getInstance().unRegisterListener(this.fkJ);
    }
}
