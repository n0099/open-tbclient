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
    private BdUniqueId cKf;
    private String forumId;
    private String forumName;
    private ai frN;
    private GroupPermData gGB;
    private GroupPermData gGC;
    private GroupPermData gGD;
    private int rn;
    private List<GroupInfoData> gGE = new ArrayList();
    private List<GroupInfoData> gGF = new ArrayList();
    private List<GroupInfoData> gGG = new ArrayList();
    private int gGH = 0;
    private int gGI = 0;
    private int gGJ = 0;
    private int gGK = 0;
    private int gGL = 0;
    private int gGM = 0;
    private boolean gGN = false;
    private boolean gGO = false;
    private boolean gGP = false;
    private boolean gGQ = true;
    private boolean gGR = true;
    private boolean gGS = true;
    private FrsGroupRequestMessage gGT = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gGU = new FrsGroupReadCacheRequestMessage();
    private boolean dbQ = true;
    private int cjv = 1;
    private Set<Long> gGV = new HashSet();
    private com.baidu.adp.framework.listener.c gGW = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gGT.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.ud(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gGT.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dbQ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fzB = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gGJ;
                    d.this.gGP = z;
                    d.this.gGD = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGS = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gGH;
                    d.this.gGN = z;
                    d.this.gGB = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGQ = false;
                } else {
                    apVar.pn = d.this.gGI;
                    d.this.gGO = z;
                    d.this.gGC = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGR = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.frN != null) {
                    d.this.frN.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener frg = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gGU.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gGD = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGG = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gGB = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGE = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gGC = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGF = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.frN != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.frN.a(4, type, apVar, a);
                }
                d.this.bP(type, 0);
            }
        }
    };

    public void bP(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cKf != null) {
            frsGroupRequestMessage.setTag(this.cKf);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gGT = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void sD(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cKf != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cKf);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gGU = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void ud(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fzB = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gGB;
            list = this.gGE;
            apVar.pn = this.gGH;
            apVar.hasMore = this.gGN;
        } else if (i == 2) {
            groupPermData = this.gGC;
            list = this.gGF;
            apVar.pn = this.gGI;
            apVar.hasMore = this.gGO;
        } else if (i == 3) {
            groupPermData = this.gGD;
            list = this.gGG;
            apVar.pn = this.gGJ;
            apVar.hasMore = this.gGP;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.frN != null) {
                this.frN.a(4, i, apVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gGE = a(z, this.gGE, list);
            this.gGB = groupPermData;
            return a(this.gGB, this.gGE, i);
        } else if (i == 3) {
            this.gGD = groupPermData;
            this.gGG = a(z, this.gGG, list);
            return a(this.gGD, this.gGG, i);
        } else {
            this.gGC = groupPermData;
            this.gGF = a(z, this.gGF, list);
            return a(this.gGC, this.gGF, i);
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
        this.gGV.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gGV.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cjv + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bQ((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bQ(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        iVar.ql(i2);
        return iVar;
    }

    private boolean ue(int i) {
        if (i == 1) {
            return this.gGQ;
        }
        if (i == 2) {
            return this.gGR;
        }
        if (i == 3) {
            return this.gGS;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.frN != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.xV(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.xU(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.ug(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.xV(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.xU(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.xT(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.ug(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bQ(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fzB = false;
            apVar.pn = -1;
            this.frN.a(4, this.cjv, apVar, arrayList);
        }
    }

    private boolean uf(int i) {
        if (i == 1) {
            return this.gGN;
        }
        if (i == 2) {
            return this.gGO;
        }
        if (i == 3) {
            return this.gGP;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.cjv = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (ue(i2)) {
                sD(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gGH;
                } else if (i2 == 2) {
                    i3 = this.gGI;
                } else {
                    i3 = i2 == 3 ? this.gGJ : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    ud(i2);
                } else if (a == 0) {
                    this.dbQ = true;
                    bP(i2, 0);
                } else if (uf(i2)) {
                    this.dbQ = false;
                    bP(i2, a);
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
                this.gGK = 0;
                this.gGH = 1;
                return 0;
            } else if (i == 2) {
                this.gGL = 0;
                this.gGI = 1;
                return 0;
            } else if (i == 3) {
                this.gGM = 0;
                this.gGJ = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gGK += i2;
                int i4 = this.gGK;
                this.gGH = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gGL += i2;
                int i5 = this.gGL;
                this.gGI = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gGM += i2;
                int i6 = this.gGM;
                this.gGJ = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.frN = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.cKf != null) {
            this.gGW.setTag(this.cKf);
            this.gGW.setSelfListener(true);
            this.frg.setTag(this.cKf);
            this.frg.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gGW);
        MessageManager.getInstance().registerListener(this.frg);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cKf = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aMM() {
        MessageManager.getInstance().unRegisterListener(this.gGW);
        MessageManager.getInstance().unRegisterListener(this.frg);
    }
}
