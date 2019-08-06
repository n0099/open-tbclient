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
    private BdUniqueId cxE;
    private String forumId;
    private String forumName;
    private ai fqM;
    private GroupPermData gGL;
    private GroupPermData gGM;
    private GroupPermData gGN;
    private int rn;
    private List<GroupInfoData> gGO = new ArrayList();
    private List<GroupInfoData> gGP = new ArrayList();
    private List<GroupInfoData> gGQ = new ArrayList();
    private int gGR = 0;
    private int gGS = 0;
    private int gGT = 0;
    private int gGU = 0;
    private int gGV = 0;
    private int gGW = 0;
    private boolean gGX = false;
    private boolean gGY = false;
    private boolean gGZ = false;
    private boolean gHa = true;
    private boolean gHb = true;
    private boolean gHc = true;
    private FrsGroupRequestMessage gHd = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gHe = new FrsGroupReadCacheRequestMessage();
    private boolean cRD = true;
    private int bSA = 1;
    private Set<Long> gHf = new HashSet();
    private com.baidu.adp.framework.listener.c gHg = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gHd.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.vt(type);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gHd.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cRD, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fyA = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gGT;
                    d.this.gGZ = z;
                    d.this.gGN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gHc = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gGR;
                    d.this.gGX = z;
                    d.this.gGL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gHa = false;
                } else {
                    apVar.pn = d.this.gGS;
                    d.this.gGY = z;
                    d.this.gGM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gHb = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.fqM != null) {
                    d.this.fqM.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener fqh = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gHe.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gGN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGQ = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gGL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGO = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gGM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gGP = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.fqM != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.fqM.a(4, type, apVar, a);
                }
                d.this.bW(type, 0);
            }
        }
    };

    public void bW(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cxE != null) {
            frsGroupRequestMessage.setTag(this.cxE);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gHd = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void tE(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cxE != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cxE);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gHe = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void vt(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fyA = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gGL;
            list = this.gGO;
            apVar.pn = this.gGR;
            apVar.hasMore = this.gGX;
        } else if (i == 2) {
            groupPermData = this.gGM;
            list = this.gGP;
            apVar.pn = this.gGS;
            apVar.hasMore = this.gGY;
        } else if (i == 3) {
            groupPermData = this.gGN;
            list = this.gGQ;
            apVar.pn = this.gGT;
            apVar.hasMore = this.gGZ;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.fqM != null) {
                this.fqM.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gGO = a(z, this.gGO, list);
            this.gGL = groupPermData;
            return a(this.gGL, this.gGO, i);
        } else if (i == 3) {
            this.gGN = groupPermData;
            this.gGQ = a(z, this.gGQ, list);
            return a(this.gGN, this.gGQ, i);
        } else {
            this.gGM = groupPermData;
            this.gGP = a(z, this.gGP, list);
            return a(this.gGM, this.gGP, i);
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
        this.gHf.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gHf.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bSA + 3);
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
        iVar.rp(i2);
        return iVar;
    }

    private boolean vu(int i) {
        if (i == 1) {
            return this.gHa;
        }
        if (i == 2) {
            return this.gHb;
        }
        if (i == 3) {
            return this.gHc;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.fqM != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.ze(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.zd(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.vw(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kc()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.ze(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.zd(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.zc(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.vw(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bX(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fyA = false;
            apVar.pn = -1;
            this.fqM.a(4, this.bSA, apVar, arrayList);
        }
    }

    private boolean vv(int i) {
        if (i == 1) {
            return this.gGX;
        }
        if (i == 2) {
            return this.gGY;
        }
        if (i == 3) {
            return this.gGZ;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bSA = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (vu(i2)) {
                tE(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gGR;
                } else if (i2 == 2) {
                    i3 = this.gGS;
                } else {
                    i3 = i2 == 3 ? this.gGT : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    vt(i2);
                } else if (a == 0) {
                    this.cRD = true;
                    bW(i2, 0);
                } else if (vv(i2)) {
                    this.cRD = false;
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
                this.gGU = 0;
                this.gGR = 1;
                return 0;
            } else if (i == 2) {
                this.gGV = 0;
                this.gGS = 1;
                return 0;
            } else if (i == 3) {
                this.gGW = 0;
                this.gGT = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gGU += i2;
                int i4 = this.gGU;
                this.gGR = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gGV += i2;
                int i5 = this.gGV;
                this.gGS = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gGW += i2;
                int i6 = this.gGW;
                this.gGT = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fqM = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cxE != null) {
            this.gHg.setTag(this.cxE);
            this.gHg.setSelfListener(true);
            this.fqh.setTag(this.cxE);
            this.fqh.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gHg);
        MessageManager.getInstance().registerListener(this.fqh);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cxE = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aLz() {
        MessageManager.getInstance().unRegisterListener(this.gHg);
        MessageManager.getInstance().unRegisterListener(this.fqh);
    }
}
