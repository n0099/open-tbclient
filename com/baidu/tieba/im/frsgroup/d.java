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
    private BdUniqueId cJo;
    private String forumId;
    private String forumName;
    private ai fqV;
    private GroupPermData gFK;
    private GroupPermData gFL;
    private GroupPermData gFM;
    private int rn;
    private List<GroupInfoData> gFN = new ArrayList();
    private List<GroupInfoData> gFO = new ArrayList();
    private List<GroupInfoData> gFP = new ArrayList();
    private int gFQ = 0;
    private int gFR = 0;
    private int gFS = 0;
    private int gFT = 0;
    private int gFU = 0;
    private int gFV = 0;
    private boolean gFW = false;
    private boolean gFX = false;
    private boolean gFY = false;
    private boolean gFZ = true;
    private boolean gGa = true;
    private boolean gGb = true;
    private FrsGroupRequestMessage gGc = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gGd = new FrsGroupReadCacheRequestMessage();
    private boolean daZ = true;
    private int ciE = 1;
    private Set<Long> gGe = new HashSet();
    private com.baidu.adp.framework.listener.c gGf = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gGc.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.uc(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gGc.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.daZ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fyK = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gFS;
                    d.this.gFY = z;
                    d.this.gFM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGb = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gFQ;
                    d.this.gFW = z;
                    d.this.gFK = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gFZ = false;
                } else {
                    apVar.pn = d.this.gFR;
                    d.this.gFX = z;
                    d.this.gFL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGa = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.fqV != null) {
                    d.this.fqV.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener fqp = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gGd.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gFM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFP = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gFK = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFN = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gFL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFO = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.fqV != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.fqV.a(4, type, apVar, a);
                }
                d.this.bN(type, 0);
            }
        }
    };

    public void bN(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cJo != null) {
            frsGroupRequestMessage.setTag(this.cJo);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gGc = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void sC(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cJo != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cJo);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gGd = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void uc(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fyK = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gFK;
            list = this.gFN;
            apVar.pn = this.gFQ;
            apVar.hasMore = this.gFW;
        } else if (i == 2) {
            groupPermData = this.gFL;
            list = this.gFO;
            apVar.pn = this.gFR;
            apVar.hasMore = this.gFX;
        } else if (i == 3) {
            groupPermData = this.gFM;
            list = this.gFP;
            apVar.pn = this.gFS;
            apVar.hasMore = this.gFY;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.fqV != null) {
                this.fqV.a(4, i, apVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gFN = a(z, this.gFN, list);
            this.gFK = groupPermData;
            return a(this.gFK, this.gFN, i);
        } else if (i == 3) {
            this.gFM = groupPermData;
            this.gFP = a(z, this.gFP, list);
            return a(this.gFM, this.gFP, i);
        } else {
            this.gFL = groupPermData;
            this.gFO = a(z, this.gFO, list);
            return a(this.gFL, this.gFO, i);
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
        this.gGe.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gGe.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.ciE + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bO((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bO(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        iVar.qk(i2);
        return iVar;
    }

    private boolean ud(int i) {
        if (i == 1) {
            return this.gFZ;
        }
        if (i == 2) {
            return this.gGa;
        }
        if (i == 3) {
            return this.gGb;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.fqV != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.xV(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.xU(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.uf(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.xV(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.xU(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.xT(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.uf(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bO(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fyK = false;
            apVar.pn = -1;
            this.fqV.a(4, this.ciE, apVar, arrayList);
        }
    }

    private boolean ue(int i) {
        if (i == 1) {
            return this.gFW;
        }
        if (i == 2) {
            return this.gFX;
        }
        if (i == 3) {
            return this.gFY;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.ciE = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (ud(i2)) {
                sC(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gFQ;
                } else if (i2 == 2) {
                    i3 = this.gFR;
                } else {
                    i3 = i2 == 3 ? this.gFS : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    uc(i2);
                } else if (a == 0) {
                    this.daZ = true;
                    bN(i2, 0);
                } else if (ue(i2)) {
                    this.daZ = false;
                    bN(i2, a);
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
                this.gFT = 0;
                this.gFQ = 1;
                return 0;
            } else if (i == 2) {
                this.gFU = 0;
                this.gFR = 1;
                return 0;
            } else if (i == 3) {
                this.gFV = 0;
                this.gFS = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gFT += i2;
                int i4 = this.gFT;
                this.gFQ = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gFU += i2;
                int i5 = this.gFU;
                this.gFR = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gFV += i2;
                int i6 = this.gFV;
                this.gFS = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fqV = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.cJo != null) {
            this.gGf.setTag(this.cJo);
            this.gGf.setSelfListener(true);
            this.fqp.setTag(this.cJo);
            this.fqp.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gGf);
        MessageManager.getInstance().registerListener(this.fqp);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cJo = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aMK() {
        MessageManager.getInstance().unRegisterListener(this.gGf);
        MessageManager.getInstance().unRegisterListener(this.fqp);
    }
}
