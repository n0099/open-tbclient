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
    private BdUniqueId cyA;
    private String forumId;
    private String forumName;
    private ai fsA;
    private GroupPermData gID;
    private GroupPermData gIE;
    private GroupPermData gIF;
    private int rn;
    private List<GroupInfoData> gIG = new ArrayList();
    private List<GroupInfoData> gIH = new ArrayList();
    private List<GroupInfoData> gII = new ArrayList();
    private int gIJ = 0;
    private int gIK = 0;
    private int gIL = 0;
    private int gIM = 0;
    private int gIN = 0;
    private int gIO = 0;
    private boolean gIP = false;
    private boolean gIQ = false;
    private boolean gIR = false;
    private boolean gIS = true;
    private boolean gIT = true;
    private boolean gIU = true;
    private FrsGroupRequestMessage gIV = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gIW = new FrsGroupReadCacheRequestMessage();
    private boolean cSw = true;
    private int bTb = 1;
    private Set<Long> gIX = new HashSet();
    private com.baidu.adp.framework.listener.c gIY = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gIV.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.vx(type);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gIV.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cSw, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fAn = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gIL;
                    d.this.gIR = z;
                    d.this.gIF = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gIU = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gIJ;
                    d.this.gIP = z;
                    d.this.gID = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gIS = false;
                } else {
                    apVar.pn = d.this.gIK;
                    d.this.gIQ = z;
                    d.this.gIE = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gIT = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.fsA != null) {
                    d.this.fsA.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener frV = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gIW.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gIF = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gII = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gID = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gIG = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gIE = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gIH = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.fsA != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.fsA.a(4, type, apVar, a);
                }
                d.this.bW(type, 0);
            }
        }
    };

    public void bW(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cyA != null) {
            frsGroupRequestMessage.setTag(this.cyA);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gIV = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void tI(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cyA != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cyA);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gIW = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void vx(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fAn = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gID;
            list = this.gIG;
            apVar.pn = this.gIJ;
            apVar.hasMore = this.gIP;
        } else if (i == 2) {
            groupPermData = this.gIE;
            list = this.gIH;
            apVar.pn = this.gIK;
            apVar.hasMore = this.gIQ;
        } else if (i == 3) {
            groupPermData = this.gIF;
            list = this.gII;
            apVar.pn = this.gIL;
            apVar.hasMore = this.gIR;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.fsA != null) {
                this.fsA.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gIG = a(z, this.gIG, list);
            this.gID = groupPermData;
            return a(this.gID, this.gIG, i);
        } else if (i == 3) {
            this.gIF = groupPermData;
            this.gII = a(z, this.gII, list);
            return a(this.gIF, this.gII, i);
        } else {
            this.gIE = groupPermData;
            this.gIH = a(z, this.gIH, list);
            return a(this.gIE, this.gIH, i);
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
        this.gIX.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gIX.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bTb + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bX((size * com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bX(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.ah(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        iVar.rs(i2);
        return iVar;
    }

    private boolean vy(int i) {
        if (i == 1) {
            return this.gIS;
        }
        if (i == 2) {
            return this.gIT;
        }
        if (i == 3) {
            return this.gIU;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.fsA != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.zD(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.zC(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.vA(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kc()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.zD(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.zC(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.zB(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.vA(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bX(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fAn = false;
            apVar.pn = -1;
            this.fsA.a(4, this.bTb, apVar, arrayList);
        }
    }

    private boolean vz(int i) {
        if (i == 1) {
            return this.gIP;
        }
        if (i == 2) {
            return this.gIQ;
        }
        if (i == 3) {
            return this.gIR;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bTb = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (vy(i2)) {
                tI(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gIJ;
                } else if (i2 == 2) {
                    i3 = this.gIK;
                } else {
                    i3 = i2 == 3 ? this.gIL : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    vx(i2);
                } else if (a == 0) {
                    this.cSw = true;
                    bW(i2, 0);
                } else if (vz(i2)) {
                    this.cSw = false;
                    bW(i2, a);
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
                this.gIM = 0;
                this.gIJ = 1;
                return 0;
            } else if (i == 2) {
                this.gIN = 0;
                this.gIK = 1;
                return 0;
            } else if (i == 3) {
                this.gIO = 0;
                this.gIL = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gIM += i2;
                int i4 = this.gIM;
                this.gIJ = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gIN += i2;
                int i5 = this.gIN;
                this.gIK = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gIO += i2;
                int i6 = this.gIO;
                this.gIL = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fsA = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cyA != null) {
            this.gIY.setTag(this.cyA);
            this.gIY.setSelfListener(true);
            this.frV.setTag(this.cyA);
            this.frV.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gIY);
        MessageManager.getInstance().registerListener(this.frV);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cyA = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aMd() {
        MessageManager.getInstance().unRegisterListener(this.gIY);
        MessageManager.getInstance().unRegisterListener(this.frV);
    }
}
