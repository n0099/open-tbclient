package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.o;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements ak {
    private BdUniqueId epM;
    private String forumId;
    private String forumName;
    private ao hjJ;
    private GroupPermData iAt;
    private GroupPermData iAu;
    private GroupPermData iAv;
    private int rn;
    private List<GroupInfoData> iAw = new ArrayList();
    private List<GroupInfoData> iAx = new ArrayList();
    private List<GroupInfoData> iAy = new ArrayList();
    private int iAz = 0;
    private int iAA = 0;
    private int iAB = 0;
    private int iAC = 0;
    private int iAD = 0;
    private int iAE = 0;
    private boolean iAF = false;
    private boolean iAG = false;
    private boolean iAH = false;
    private boolean iAI = true;
    private boolean iAJ = true;
    private boolean iAK = true;
    private FrsGroupRequestMessage iAL = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage iAM = new FrsGroupReadCacheRequestMessage();
    private boolean eIz = true;
    private int dNl = 1;
    private Set<Long> iAN = new HashSet();
    private com.baidu.adp.framework.listener.c iAO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.iAL.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.xD(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.iAL.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                av avVar = new av();
                ArrayList<o> a = d.this.a(d.this.eIz, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    avVar.hasMore = false;
                    z = false;
                } else {
                    avVar.hasMore = z;
                }
                avVar.errCode = frsGroupSocketResponseMessage.getError();
                avVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.hrA = false;
                avVar.isLocal = false;
                if (type == 3) {
                    avVar.pn = d.this.iAB;
                    d.this.iAH = z;
                    d.this.iAv = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iAK = false;
                } else if (type == 1) {
                    avVar.pn = d.this.iAz;
                    d.this.iAF = z;
                    d.this.iAt = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iAI = false;
                } else {
                    avVar.pn = d.this.iAA;
                    d.this.iAG = z;
                    d.this.iAu = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iAJ = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hjJ != null) {
                    d.this.hjJ.a(4, type, avVar, a);
                }
            }
        }
    };
    private CustomMessageListener hje = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<o> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.iAM.getType();
                av avVar = new av();
                avVar.errCode = customResponsedMessage.getError();
                avVar.errMsg = customResponsedMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.isLocal = true;
                avVar.hasMore = false;
                avVar.pn = -1;
                if (type == 3) {
                    d.this.iAv = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iAy = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.iAt = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iAw = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.iAu = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iAx = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hjJ != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hjJ.a(4, type, avVar, a);
                }
                d.this.cs(type, 0);
            }
        }
    };

    public void cs(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.epM != null) {
            frsGroupRequestMessage.setTag(this.epM);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.iAL = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void wg(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.epM != null) {
            frsGroupReadCacheRequestMessage.setTag(this.epM);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.iAM = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void xD(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        av avVar = new av();
        avVar.forumId = this.forumId;
        avVar.forumName = this.forumName;
        avVar.hrA = false;
        avVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.iAt;
            list = this.iAw;
            avVar.pn = this.iAz;
            avVar.hasMore = this.iAF;
        } else if (i == 2) {
            groupPermData = this.iAu;
            list = this.iAx;
            avVar.pn = this.iAA;
            avVar.hasMore = this.iAG;
        } else if (i == 3) {
            groupPermData = this.iAv;
            list = this.iAy;
            avVar.pn = this.iAB;
            avVar.hasMore = this.iAH;
        } else {
            groupPermData = null;
        }
        ArrayList<o> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hjJ != null) {
                this.hjJ.a(4, i, avVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<o> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.iAw = a(z, this.iAw, list);
            this.iAt = groupPermData;
            return a(this.iAt, this.iAw, i);
        } else if (i == 3) {
            this.iAv = groupPermData;
            this.iAy = a(z, this.iAy, list);
            return a(this.iAv, this.iAy, i);
        } else {
            this.iAu = groupPermData;
            this.iAx = a(z, this.iAx, list);
            return a(this.iAu, this.iAx, i);
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
    public ArrayList<o> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<o> arrayList = new ArrayList<>();
        this.iAN.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.iAN.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.dNl + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(ct((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.k ct(int i, int i2) {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        kVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        kVar.tH(i2);
        return kVar;
    }

    private boolean xE(int i) {
        if (i == 1) {
            return this.iAI;
        }
        if (i == 2) {
            return this.iAJ;
        }
        if (i == 3) {
            return this.iAK;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hjJ != null) {
            ArrayList<o> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Gz(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Gy(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.xG(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new p());
            } else {
                hVar.Gz(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Gy(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Gx(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.xG(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ct(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            av avVar = new av();
            avVar.errCode = 0;
            avVar.forumId = this.forumId;
            avVar.forumName = this.forumName;
            avVar.hasMore = false;
            avVar.hrA = false;
            avVar.pn = -1;
            this.hjJ.a(4, this.dNl, avVar, arrayList);
        }
    }

    private boolean xF(int i) {
        if (i == 1) {
            return this.iAF;
        }
        if (i == 2) {
            return this.iAG;
        }
        if (i == 3) {
            return this.iAH;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        int i3;
        if (i == 4 && asVar != null) {
            this.forumId = asVar.forumId;
            this.forumName = asVar.forumName;
            this.dNl = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (xE(i2)) {
                wg(i2);
            } else {
                if (asVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.iAz;
                } else if (i2 == 2) {
                    i3 = this.iAA;
                } else {
                    i3 = i2 == 3 ? this.iAB : 0;
                }
                int a = a(i2, this.rn, i3, asVar);
                if (a < 0) {
                    xD(i2);
                } else if (a == 0) {
                    this.eIz = true;
                    cs(i2, 0);
                } else if (xF(i2)) {
                    this.eIz = false;
                    cs(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, as asVar) {
        if (asVar == null) {
            return -1;
        }
        if (asVar.pn == -1) {
            if (i == 1) {
                this.iAC = 0;
                this.iAz = 1;
                return 0;
            } else if (i == 2) {
                this.iAD = 0;
                this.iAA = 1;
                return 0;
            } else if (i == 3) {
                this.iAE = 0;
                this.iAB = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (asVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.iAC += i2;
                int i4 = this.iAC;
                this.iAz = asVar.pn;
                return i4;
            } else if (i == 2) {
                this.iAD += i2;
                int i5 = this.iAD;
                this.iAA = asVar.pn;
                return i5;
            } else if (i == 3) {
                this.iAE += i2;
                int i6 = this.iAE;
                this.iAB = asVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hjJ = aoVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.epM != null) {
            this.iAO.setTag(this.epM);
            this.iAO.setSelfListener(true);
            this.hje.setTag(this.epM);
            this.hje.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iAO);
        MessageManager.getInstance().registerListener(this.hje);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.epM = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void bwk() {
        MessageManager.getInstance().unRegisterListener(this.iAO);
        MessageManager.getInstance().unRegisterListener(this.hje);
    }
}
