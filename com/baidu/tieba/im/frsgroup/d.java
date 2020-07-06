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
/* loaded from: classes10.dex */
public class d implements ap {
    private BdUniqueId eyE;
    private String forumId;
    private String forumName;
    private at hvR;
    private GroupPermData iRA;
    private GroupPermData iRy;
    private GroupPermData iRz;
    private int rn;
    private List<GroupInfoData> iRB = new ArrayList();
    private List<GroupInfoData> iRC = new ArrayList();
    private List<GroupInfoData> iRD = new ArrayList();
    private int iRE = 0;
    private int iRF = 0;
    private int iRG = 0;
    private int iRH = 0;
    private int iRI = 0;
    private int iRJ = 0;
    private boolean iRK = false;
    private boolean iRL = false;
    private boolean iRM = false;
    private boolean iRN = true;
    private boolean iRO = true;
    private boolean iRP = true;
    private FrsGroupRequestMessage iRQ = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage iRR = new FrsGroupReadCacheRequestMessage();
    private boolean eSL = true;
    private int dUb = 1;
    private Set<Long> iRS = new HashSet();
    private com.baidu.adp.framework.listener.c iRT = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.iRQ.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.yn(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.iRQ.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bb bbVar = new bb();
                ArrayList<q> a = d.this.a(d.this.eSL, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bbVar.hEr = false;
                bbVar.isLocal = false;
                if (type == 3) {
                    bbVar.pn = d.this.iRG;
                    d.this.iRM = z;
                    d.this.iRA = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iRP = false;
                } else if (type == 1) {
                    bbVar.pn = d.this.iRE;
                    d.this.iRK = z;
                    d.this.iRy = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iRN = false;
                } else {
                    bbVar.pn = d.this.iRF;
                    d.this.iRL = z;
                    d.this.iRz = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iRO = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hvR != null) {
                    d.this.hvR.a(4, type, bbVar, a);
                }
            }
        }
    };
    private CustomMessageListener hvn = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.iRR.getType();
                bb bbVar = new bb();
                bbVar.errCode = customResponsedMessage.getError();
                bbVar.errMsg = customResponsedMessage.getErrorString();
                bbVar.forumId = d.this.forumId;
                bbVar.forumName = d.this.forumName;
                bbVar.isLocal = true;
                bbVar.hasMore = false;
                bbVar.pn = -1;
                if (type == 3) {
                    d.this.iRA = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iRD = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.iRy = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iRB = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.iRz = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.iRC = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hvR != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hvR.a(4, type, bbVar, a);
                }
                d.this.cy(type, 0);
            }
        }
    };

    public void cy(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.eyE != null) {
            frsGroupRequestMessage.setTag(this.eyE);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.iRQ = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void wM(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.eyE != null) {
            frsGroupReadCacheRequestMessage.setTag(this.eyE);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.iRR = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void yn(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bb bbVar = new bb();
        bbVar.forumId = this.forumId;
        bbVar.forumName = this.forumName;
        bbVar.hEr = false;
        bbVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.iRy;
            list = this.iRB;
            bbVar.pn = this.iRE;
            bbVar.hasMore = this.iRK;
        } else if (i == 2) {
            groupPermData = this.iRz;
            list = this.iRC;
            bbVar.pn = this.iRF;
            bbVar.hasMore = this.iRL;
        } else if (i == 3) {
            groupPermData = this.iRA;
            list = this.iRD;
            bbVar.pn = this.iRG;
            bbVar.hasMore = this.iRM;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hvR != null) {
                this.hvR.a(4, i, bbVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.iRB = a(z, this.iRB, list);
            this.iRy = groupPermData;
            return a(this.iRy, this.iRB, i);
        } else if (i == 3) {
            this.iRA = groupPermData;
            this.iRD = a(z, this.iRD, list);
            return a(this.iRA, this.iRD, i);
        } else {
            this.iRz = groupPermData;
            this.iRC = a(z, this.iRC, list);
            return a(this.iRz, this.iRC, i);
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
        this.iRS.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.iRS.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.dUb + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cz((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.m cz(int i, int i2) {
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
        mVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        mVar.uj(i2);
        return mVar;
    }

    private boolean yo(int i) {
        if (i == 1) {
            return this.iRN;
        }
        if (i == 2) {
            return this.iRO;
        }
        if (i == 3) {
            return this.iRP;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hvR != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Hb(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Ha(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.yq(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new r());
            } else {
                hVar.Hb(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Ha(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.GZ(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.yq(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cz(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bb bbVar = new bb();
            bbVar.errCode = 0;
            bbVar.forumId = this.forumId;
            bbVar.forumName = this.forumName;
            bbVar.hasMore = false;
            bbVar.hEr = false;
            bbVar.pn = -1;
            this.hvR.a(4, this.dUb, bbVar, arrayList);
        }
    }

    private boolean yp(int i) {
        if (i == 1) {
            return this.iRK;
        }
        if (i == 2) {
            return this.iRL;
        }
        if (i == 3) {
            return this.iRM;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        int i3;
        if (i == 4 && ayVar != null) {
            this.forumId = ayVar.forumId;
            this.forumName = ayVar.forumName;
            this.dUb = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (yo(i2)) {
                wM(i2);
            } else {
                if (ayVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.iRE;
                } else if (i2 == 2) {
                    i3 = this.iRF;
                } else {
                    i3 = i2 == 3 ? this.iRG : 0;
                }
                int a = a(i2, this.rn, i3, ayVar);
                if (a < 0) {
                    yn(i2);
                } else if (a == 0) {
                    this.eSL = true;
                    cy(i2, 0);
                } else if (yp(i2)) {
                    this.eSL = false;
                    cy(i2, a);
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
                this.iRH = 0;
                this.iRE = 1;
                return 0;
            } else if (i == 2) {
                this.iRI = 0;
                this.iRF = 1;
                return 0;
            } else if (i == 3) {
                this.iRJ = 0;
                this.iRG = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (ayVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.iRH += i2;
                int i4 = this.iRH;
                this.iRE = ayVar.pn;
                return i4;
            } else if (i == 2) {
                this.iRI += i2;
                int i5 = this.iRI;
                this.iRF = ayVar.pn;
                return i5;
            } else if (i == 3) {
                this.iRJ += i2;
                int i6 = this.iRJ;
                this.iRG = ayVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.hvR = atVar;
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.eyE != null) {
            this.iRT.setTag(this.eyE);
            this.iRT.setSelfListener(true);
            this.hvn.setTag(this.eyE);
            this.hvn.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iRT);
        MessageManager.getInstance().registerListener(this.hvn);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyE = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void bzg() {
        MessageManager.getInstance().unRegisterListener(this.iRT);
        MessageManager.getInstance().unRegisterListener(this.hvn);
    }
}
