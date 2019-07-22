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
    private BdUniqueId cxx;
    private String forumId;
    private String forumName;
    private ai fqn;
    private GroupPermData gFT;
    private GroupPermData gFU;
    private GroupPermData gFV;
    private int rn;
    private List<GroupInfoData> gFW = new ArrayList();
    private List<GroupInfoData> gFX = new ArrayList();
    private List<GroupInfoData> gFY = new ArrayList();
    private int gFZ = 0;
    private int gGa = 0;
    private int gGb = 0;
    private int gGc = 0;
    private int gGd = 0;
    private int gGe = 0;
    private boolean gGf = false;
    private boolean gGg = false;
    private boolean gGh = false;
    private boolean gGi = true;
    private boolean gGj = true;
    private boolean gGk = true;
    private FrsGroupRequestMessage gGl = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage gGm = new FrsGroupReadCacheRequestMessage();
    private boolean cRw = true;
    private int bSu = 1;
    private Set<Long> gGn = new HashSet();
    private com.baidu.adp.framework.listener.c gGo = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.gGl.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.vr(type);
                    if (com.baidu.adp.lib.util.j.kc()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.gGl.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.cRw, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.fyb = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.gGb;
                    d.this.gGh = z;
                    d.this.gFV = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGk = false;
                } else if (type == 1) {
                    apVar.pn = d.this.gFZ;
                    d.this.gGf = z;
                    d.this.gFT = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGi = false;
                } else {
                    apVar.pn = d.this.gGa;
                    d.this.gGg = z;
                    d.this.gFU = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.gGj = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.fqn != null) {
                    d.this.fqn.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener fpI = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.gGm.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.gFV = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFY = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.gFT = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFW = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.gFU = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.gFX = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.fqn != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.fqn.a(4, type, apVar, a);
                }
                d.this.bW(type, 0);
            }
        }
    };

    public void bW(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.cxx != null) {
            frsGroupRequestMessage.setTag(this.cxx);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.gGl = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void tC(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.cxx != null) {
            frsGroupReadCacheRequestMessage.setTag(this.cxx);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.gGm = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void vr(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.fyb = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.gFT;
            list = this.gFW;
            apVar.pn = this.gFZ;
            apVar.hasMore = this.gGf;
        } else if (i == 2) {
            groupPermData = this.gFU;
            list = this.gFX;
            apVar.pn = this.gGa;
            apVar.hasMore = this.gGg;
        } else if (i == 3) {
            groupPermData = this.gFV;
            list = this.gFY;
            apVar.pn = this.gGb;
            apVar.hasMore = this.gGh;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.fqn != null) {
                this.fqn.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.gFW = a(z, this.gFW, list);
            this.gFT = groupPermData;
            return a(this.gFT, this.gFW, i);
        } else if (i == 3) {
            this.gFV = groupPermData;
            this.gFY = a(z, this.gFY, list);
            return a(this.gFV, this.gFY, i);
        } else {
            this.gFU = groupPermData;
            this.gFX = a(z, this.gFX, list);
            return a(this.gFU, this.gFX, i);
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
        this.gGn.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.gGn.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.bSu + 3);
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
        iVar.rn(i2);
        return iVar;
    }

    private boolean vs(int i) {
        if (i == 1) {
            return this.gGi;
        }
        if (i == 2) {
            return this.gGj;
        }
        if (i == 3) {
            return this.gGk;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.fqn != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.zd(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.zc(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.vu(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kc()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.zd(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.zc(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.zb(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.vu(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bX(com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.fyb = false;
            apVar.pn = -1;
            this.fqn.a(4, this.bSu, apVar, arrayList);
        }
    }

    private boolean vt(int i) {
        if (i == 1) {
            return this.gGf;
        }
        if (i == 2) {
            return this.gGg;
        }
        if (i == 3) {
            return this.gGh;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.af
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.bSu = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (vs(i2)) {
                tC(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.gFZ;
                } else if (i2 == 2) {
                    i3 = this.gGa;
                } else {
                    i3 = i2 == 3 ? this.gGb : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    vr(i2);
                } else if (a == 0) {
                    this.cRw = true;
                    bW(i2, 0);
                } else if (vt(i2)) {
                    this.cRw = false;
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
                this.gGc = 0;
                this.gFZ = 1;
                return 0;
            } else if (i == 2) {
                this.gGd = 0;
                this.gGa = 1;
                return 0;
            } else if (i == 3) {
                this.gGe = 0;
                this.gGb = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.gGc += i2;
                int i4 = this.gGc;
                this.gFZ = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.gGd += i2;
                int i5 = this.gGd;
                this.gGa = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.gGe += i2;
                int i6 = this.gGe;
                this.gGb = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void a(ai aiVar) {
        this.fqn = aiVar;
    }

    @Override // com.baidu.tieba.frs.af
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.cxx != null) {
            this.gGo.setTag(this.cxx);
            this.gGo.setSelfListener(true);
            this.fpI.setTag(this.cxx);
            this.fpI.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.gGo);
        MessageManager.getInstance().registerListener(this.fpI);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.cxx = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.af
    public void aLx() {
        MessageManager.getInstance().unRegisterListener(this.gGo);
        MessageManager.getInstance().unRegisterListener(this.fpI);
    }
}
