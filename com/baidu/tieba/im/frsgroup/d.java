package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes17.dex */
public class d implements ap {
    private BdUniqueId eEU;
    private String forumId;
    private String forumName;
    private at hBD;
    private GroupPermData iZI;
    private GroupPermData iZJ;
    private GroupPermData iZK;
    private int rn;
    private List<GroupInfoData> iZL = new ArrayList();
    private List<GroupInfoData> iZM = new ArrayList();
    private List<GroupInfoData> iZN = new ArrayList();
    private int iZO = 0;
    private int iZP = 0;
    private int iZQ = 0;
    private int iZR = 0;
    private int iZS = 0;
    private int iZT = 0;
    private boolean iZU = false;
    private boolean iZV = false;
    private boolean iZW = false;
    private boolean iZX = true;
    private boolean iZY = true;
    private boolean iZZ = true;
    private FrsGroupRequestMessage jaa = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jab = new FrsGroupReadCacheRequestMessage();
    private boolean eZg = true;
    private int eau = 1;
    private Set<Long> jac = new HashSet();
    private com.baidu.adp.framework.listener.c jad = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jaa.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.yL(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jaa.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bb bbVar = new bb();
                ArrayList<q> a = d.this.a(d.this.eZg, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    bbVar.hasMore = false;
                    z = false;
                } else {
                    bbVar.hasMore = z;
                }
                bbVar.errCode = frsGroupSocketResponseMessage.getError();
                bbVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                bbVar.forumId = d.this.forumId;
                bbVar.forumName = d.this.forumName;
                bbVar.hKp = false;
                bbVar.isLocal = false;
                if (type == 3) {
                    bbVar.pn = d.this.iZQ;
                    d.this.iZW = z;
                    d.this.iZK = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iZZ = false;
                } else if (type == 1) {
                    bbVar.pn = d.this.iZO;
                    d.this.iZU = z;
                    d.this.iZI = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iZX = false;
                } else {
                    bbVar.pn = d.this.iZP;
                    d.this.iZV = z;
                    d.this.iZJ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iZY = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hBD != null) {
                    d.this.hBD.a(4, type, bbVar, a);
                }
            }
        }
    };
    private CustomMessageListener hAZ = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jab.getType();
                bb bbVar = new bb();
                bbVar.errCode = customResponsedMessage.getError();
                bbVar.errMsg = customResponsedMessage.getErrorString();
                bbVar.forumId = d.this.forumId;
                bbVar.forumName = d.this.forumName;
                bbVar.isLocal = true;
                bbVar.hasMore = false;
                bbVar.pn = -1;
                if (type == 3) {
                    d.this.iZK = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iZN = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.iZI = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iZL = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.iZJ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iZM = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hBD != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hBD.a(4, type, bbVar, a);
                }
                d.this.cB(type, 0);
            }
        }
    };

    public void cB(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.eEU != null) {
            frsGroupRequestMessage.setTag(this.eEU);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jaa = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void xe(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.eEU != null) {
            frsGroupReadCacheRequestMessage.setTag(this.eEU);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jab = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void yL(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bb bbVar = new bb();
        bbVar.forumId = this.forumId;
        bbVar.forumName = this.forumName;
        bbVar.hKp = false;
        bbVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.iZI;
            list = this.iZL;
            bbVar.pn = this.iZO;
            bbVar.hasMore = this.iZU;
        } else if (i == 2) {
            groupPermData = this.iZJ;
            list = this.iZM;
            bbVar.pn = this.iZP;
            bbVar.hasMore = this.iZV;
        } else if (i == 3) {
            groupPermData = this.iZK;
            list = this.iZN;
            bbVar.pn = this.iZQ;
            bbVar.hasMore = this.iZW;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hBD != null) {
                this.hBD.a(4, i, bbVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.iZL = a(z, this.iZL, list);
            this.iZI = groupPermData;
            return a(this.iZI, this.iZL, i);
        } else if (i == 3) {
            this.iZK = groupPermData;
            this.iZN = a(z, this.iZN, list);
            return a(this.iZK, this.iZN, i);
        } else {
            this.iZJ = groupPermData;
            this.iZM = a(z, this.iZM, list);
            return a(this.iZJ, this.iZM, i);
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
    public ArrayList<q> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<q> arrayList = new ArrayList<>();
        this.jac.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jac.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eau + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cC((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.m cC(int i, int i2) {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        mVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        mVar.uB(i2);
        return mVar;
    }

    private boolean yM(int i) {
        if (i == 1) {
            return this.iZX;
        }
        if (i == 2) {
            return this.iZY;
        }
        if (i == 3) {
            return this.iZZ;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hBD != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.HQ(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.HP(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.yO(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new r());
            } else {
                hVar.HQ(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.HP(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.HO(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.yO(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cC(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bb bbVar = new bb();
            bbVar.errCode = 0;
            bbVar.forumId = this.forumId;
            bbVar.forumName = this.forumName;
            bbVar.hasMore = false;
            bbVar.hKp = false;
            bbVar.pn = -1;
            this.hBD.a(4, this.eau, bbVar, arrayList);
        }
    }

    private boolean yN(int i) {
        if (i == 1) {
            return this.iZU;
        }
        if (i == 2) {
            return this.iZV;
        }
        if (i == 3) {
            return this.iZW;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        int i3;
        if (i == 4 && ayVar != null) {
            this.forumId = ayVar.forumId;
            this.forumName = ayVar.forumName;
            this.eau = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (yM(i2)) {
                xe(i2);
            } else {
                if (ayVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.iZO;
                } else if (i2 == 2) {
                    i3 = this.iZP;
                } else {
                    i3 = i2 == 3 ? this.iZQ : 0;
                }
                int a = a(i2, this.rn, i3, ayVar);
                if (a < 0) {
                    yL(i2);
                } else if (a == 0) {
                    this.eZg = true;
                    cB(i2, 0);
                } else if (yN(i2)) {
                    this.eZg = false;
                    cB(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, ay ayVar) {
        if (ayVar == null) {
            return -1;
        }
        if (ayVar.pn == -1) {
            if (i == 1) {
                this.iZR = 0;
                this.iZO = 1;
                return 0;
            } else if (i == 2) {
                this.iZS = 0;
                this.iZP = 1;
                return 0;
            } else if (i == 3) {
                this.iZT = 0;
                this.iZQ = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (ayVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.iZR += i2;
                int i4 = this.iZR;
                this.iZO = ayVar.pn;
                return i4;
            } else if (i == 2) {
                this.iZS += i2;
                int i5 = this.iZS;
                this.iZP = ayVar.pn;
                return i5;
            } else if (i == 3) {
                this.iZT += i2;
                int i6 = this.iZT;
                this.iZQ = ayVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.hBD = atVar;
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.eEU != null) {
            this.jad.setTag(this.eEU);
            this.jad.setSelfListener(true);
            this.hAZ.setTag(this.eEU);
            this.hAZ.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jad);
        MessageManager.getInstance().registerListener(this.hAZ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eEU = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bCu() {
        MessageManager.getInstance().unRegisterListener(this.jad);
        MessageManager.getInstance().unRegisterListener(this.hAZ);
    }
}
