package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements ai {
    private BdUniqueId bag;
    private al dyh;
    private GroupPermData eIe;
    private GroupPermData eIf;
    private GroupPermData eIg;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> eIh = new ArrayList();
    private List<GroupInfoData> eIi = new ArrayList();
    private List<GroupInfoData> eIj = new ArrayList();
    private int eIk = 0;
    private int eIl = 0;
    private int eIm = 0;
    private int eIn = 0;
    private int eIo = 0;
    private int eIp = 0;
    private boolean eIq = false;
    private boolean eIr = false;
    private boolean eIs = false;
    private boolean eIt = true;
    private boolean eIu = true;
    private boolean eIv = true;
    private FrsGroupRequestMessage eIw = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eIx = new FrsGroupReadCacheRequestMessage();
    private boolean bsq = true;
    private int axH = 1;
    private Set<Long> eIy = new HashSet();
    private com.baidu.adp.framework.listener.c eIz = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eIw.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.pv(type);
                    if (com.baidu.adp.lib.util.j.kV()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eIw.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bsq, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    arVar.hasMore = false;
                    z = false;
                } else {
                    arVar.hasMore = z;
                }
                arVar.errCode = frsGroupSocketResponseMessage.getError();
                arVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.dFt = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.eIm;
                    d.this.eIs = z;
                    d.this.eIg = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eIv = false;
                } else if (type == 1) {
                    arVar.pn = d.this.eIk;
                    d.this.eIq = z;
                    d.this.eIe = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eIt = false;
                } else {
                    arVar.pn = d.this.eIl;
                    d.this.eIr = z;
                    d.this.eIf = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eIu = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dyh != null) {
                    d.this.dyh.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dxC = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eIx.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.eIg = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eIj = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.eIe = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eIh = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.eIf = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.eIi = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dyh != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dyh.a(4, type, arVar, a);
                }
                d.this.bo(type, 0);
            }
        }
    };

    public void bo(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.bag != null) {
            frsGroupRequestMessage.setTag(this.bag);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eIw = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void nP(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.bag != null) {
            frsGroupReadCacheRequestMessage.setTag(this.bag);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eIx = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void pv(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dFt = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.eIe;
            list = this.eIh;
            arVar.pn = this.eIk;
            arVar.hasMore = this.eIq;
        } else if (i == 2) {
            groupPermData = this.eIf;
            list = this.eIi;
            arVar.pn = this.eIl;
            arVar.hasMore = this.eIr;
        } else if (i == 3) {
            groupPermData = this.eIg;
            list = this.eIj;
            arVar.pn = this.eIm;
            arVar.hasMore = this.eIs;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dyh != null) {
                this.dyh.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.eIh = a(z, this.eIh, list);
            this.eIe = groupPermData;
            return a(this.eIe, this.eIh, i);
        } else if (i == 3) {
            this.eIg = groupPermData;
            this.eIj = a(z, this.eIj, list);
            return a(this.eIg, this.eIj, i);
        } else {
            this.eIf = groupPermData;
            this.eIi = a(z, this.eIi, list);
            return a(this.eIf, this.eIi, i);
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
    public ArrayList<com.baidu.adp.widget.ListView.h> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        this.eIy.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eIy.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.axH + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bp((size * com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds160)) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds120), e.d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i bp(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds100) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds90)) + i));
        iVar.lE(i2);
        return iVar;
    }

    private boolean pw(int i) {
        if (i == 1) {
            return this.eIt;
        }
        if (i == 2) {
            return this.eIu;
        }
        if (i == 3) {
            return this.eIv;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dyh != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.pD(TbadkCoreApplication.getInst().getResources().getString(e.j.login_see_more));
                hVar.pC(TbadkCoreApplication.getInst().getResources().getString(e.j.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.py(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.kV()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.pD(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group));
                hVar.pC(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_hot_create_group_tip));
                hVar.pB(TbadkCoreApplication.getInst().getResources().getString(e.j.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.py(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bp(com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds600) + com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds80), e.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dFt = false;
            arVar.pn = -1;
            this.dyh.a(4, this.axH, arVar, arrayList);
        }
    }

    private boolean px(int i) {
        if (i == 1) {
            return this.eIq;
        }
        if (i == 2) {
            return this.eIr;
        }
        if (i == 3) {
            return this.eIs;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.axH = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (pw(i2)) {
                nP(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eIk;
                } else if (i2 == 2) {
                    i3 = this.eIl;
                } else {
                    i3 = i2 == 3 ? this.eIm : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    pv(i2);
                } else if (a == 0) {
                    this.bsq = true;
                    bo(i2, 0);
                } else if (px(i2)) {
                    this.bsq = false;
                    bo(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, ao aoVar) {
        if (aoVar == null) {
            return -1;
        }
        if (aoVar.pn == -1) {
            if (i == 1) {
                this.eIn = 0;
                this.eIk = 1;
                return 0;
            } else if (i == 2) {
                this.eIo = 0;
                this.eIl = 1;
                return 0;
            } else if (i == 3) {
                this.eIp = 0;
                this.eIm = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eIn += i2;
                int i4 = this.eIn;
                this.eIk = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.eIo += i2;
                int i5 = this.eIo;
                this.eIl = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.eIp += i2;
                int i6 = this.eIp;
                this.eIm = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dyh = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.bag != null) {
            this.eIz.setTag(this.bag);
            this.eIz.setSelfListener(true);
            this.dxC.setTag(this.bag);
            this.dxC.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eIz);
        MessageManager.getInstance().registerListener(this.dxC);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bag = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void abf() {
        MessageManager.getInstance().unRegisterListener(this.eIz);
        MessageManager.getInstance().unRegisterListener(this.dxC);
    }
}
