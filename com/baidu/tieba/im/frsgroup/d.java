package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements ag {
    private BdUniqueId dBx;
    private String forumId;
    private String forumName;
    private aj gkS;
    private GroupPermData hzE;
    private GroupPermData hzF;
    private GroupPermData hzG;
    private int rn;
    private List<GroupInfoData> hzH = new ArrayList();
    private List<GroupInfoData> hzI = new ArrayList();
    private List<GroupInfoData> hzJ = new ArrayList();
    private int hzK = 0;
    private int hzL = 0;
    private int hzM = 0;
    private int hzN = 0;
    private int hzO = 0;
    private int hzP = 0;
    private boolean hzQ = false;
    private boolean hzR = false;
    private boolean hzS = false;
    private boolean hzT = true;
    private boolean hzU = true;
    private boolean hzV = true;
    private FrsGroupRequestMessage hzW = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage hzX = new FrsGroupReadCacheRequestMessage();
    private boolean dTv = true;
    private int cZC = 1;
    private Set<Long> hzY = new HashSet();
    private com.baidu.adp.framework.listener.c hzZ = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hzW.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wp(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hzW.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                aq aqVar = new aq();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dTv, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    aqVar.hasMore = false;
                    z = false;
                } else {
                    aqVar.hasMore = z;
                }
                aqVar.errCode = frsGroupSocketResponseMessage.getError();
                aqVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.gsG = false;
                aqVar.isLocal = false;
                if (type == 3) {
                    aqVar.pn = d.this.hzM;
                    d.this.hzS = z;
                    d.this.hzG = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzV = false;
                } else if (type == 1) {
                    aqVar.pn = d.this.hzK;
                    d.this.hzQ = z;
                    d.this.hzE = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzT = false;
                } else {
                    aqVar.pn = d.this.hzL;
                    d.this.hzR = z;
                    d.this.hzF = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzU = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gkS != null) {
                    d.this.gkS.a(4, type, aqVar, a);
                }
            }
        }
    };
    private CustomMessageListener gkm = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.hzX.getType();
                aq aqVar = new aq();
                aqVar.errCode = customResponsedMessage.getError();
                aqVar.errMsg = customResponsedMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.isLocal = true;
                aqVar.hasMore = false;
                aqVar.pn = -1;
                if (type == 3) {
                    d.this.hzG = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzJ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.hzE = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzH = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.hzF = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzI = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gkS != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gkS.a(4, type, aqVar, a);
                }
                d.this.cg(type, 0);
            }
        }
    };

    public void cg(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dBx != null) {
            frsGroupRequestMessage.setTag(this.dBx);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hzW = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void uT(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dBx != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dBx);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.hzX = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wp(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        aq aqVar = new aq();
        aqVar.forumId = this.forumId;
        aqVar.forumName = this.forumName;
        aqVar.gsG = false;
        aqVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.hzE;
            list = this.hzH;
            aqVar.pn = this.hzK;
            aqVar.hasMore = this.hzQ;
        } else if (i == 2) {
            groupPermData = this.hzF;
            list = this.hzI;
            aqVar.pn = this.hzL;
            aqVar.hasMore = this.hzR;
        } else if (i == 3) {
            groupPermData = this.hzG;
            list = this.hzJ;
            aqVar.pn = this.hzM;
            aqVar.hasMore = this.hzS;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gkS != null) {
                this.gkS.a(4, i, aqVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.hzH = a(z, this.hzH, list);
            this.hzE = groupPermData;
            return a(this.hzE, this.hzH, i);
        } else if (i == 3) {
            this.hzG = groupPermData;
            this.hzJ = a(z, this.hzJ, list);
            return a(this.hzG, this.hzJ, i);
        } else {
            this.hzF = groupPermData;
            this.hzI = a(z, this.hzI, list);
            return a(this.hzF, this.hzI, i);
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
        this.hzY.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hzY.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cZC + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(ch((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.j ch(int i, int i2) {
        com.baidu.tieba.frs.j jVar = new com.baidu.tieba.frs.j();
        jVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        jVar.sB(i2);
        return jVar;
    }

    private boolean wq(int i) {
        if (i == 1) {
            return this.hzT;
        }
        if (i == 2) {
            return this.hzU;
        }
        if (i == 3) {
            return this.hzV;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gkS != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Df(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.ws(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new n());
            } else {
                hVar.Df(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Dd(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.ws(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ch(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            aq aqVar = new aq();
            aqVar.errCode = 0;
            aqVar.forumId = this.forumId;
            aqVar.forumName = this.forumName;
            aqVar.hasMore = false;
            aqVar.gsG = false;
            aqVar.pn = -1;
            this.gkS.a(4, this.cZC, aqVar, arrayList);
        }
    }

    private boolean wr(int i) {
        if (i == 1) {
            return this.hzQ;
        }
        if (i == 2) {
            return this.hzR;
        }
        if (i == 3) {
            return this.hzS;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        int i3;
        if (i == 4 && anVar != null) {
            this.forumId = anVar.forumId;
            this.forumName = anVar.forumName;
            this.cZC = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wq(i2)) {
                uT(i2);
            } else {
                if (anVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.hzK;
                } else if (i2 == 2) {
                    i3 = this.hzL;
                } else {
                    i3 = i2 == 3 ? this.hzM : 0;
                }
                int a = a(i2, this.rn, i3, anVar);
                if (a < 0) {
                    wp(i2);
                } else if (a == 0) {
                    this.dTv = true;
                    cg(i2, 0);
                } else if (wr(i2)) {
                    this.dTv = false;
                    cg(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, an anVar) {
        if (anVar == null) {
            return -1;
        }
        if (anVar.pn == -1) {
            if (i == 1) {
                this.hzN = 0;
                this.hzK = 1;
                return 0;
            } else if (i == 2) {
                this.hzO = 0;
                this.hzL = 1;
                return 0;
            } else if (i == 3) {
                this.hzP = 0;
                this.hzM = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (anVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.hzN += i2;
                int i4 = this.hzN;
                this.hzK = anVar.pn;
                return i4;
            } else if (i == 2) {
                this.hzO += i2;
                int i5 = this.hzO;
                this.hzL = anVar.pn;
                return i5;
            } else if (i == 3) {
                this.hzP += i2;
                int i6 = this.hzP;
                this.hzM = anVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gkS = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dBx != null) {
            this.hzZ.setTag(this.dBx);
            this.hzZ.setSelfListener(true);
            this.gkm.setTag(this.dBx);
            this.gkm.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hzZ);
        MessageManager.getInstance().registerListener(this.gkm);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBx = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgX() {
        MessageManager.getInstance().unRegisterListener(this.hzZ);
        MessageManager.getInstance().unRegisterListener(this.gkm);
    }
}
