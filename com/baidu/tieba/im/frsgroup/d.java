package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes3.dex */
public class d implements ag {
    private BdUniqueId aQJ;
    private aj deo;
    private GroupPermData ejY;
    private GroupPermData ejZ;
    private GroupPermData eka;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> ekb = new ArrayList();
    private List<GroupInfoData> ekc = new ArrayList();
    private List<GroupInfoData> ekd = new ArrayList();
    private int eke = 0;
    private int ekf = 0;
    private int ekg = 0;
    private int ekh = 0;
    private int eki = 0;
    private int ekj = 0;
    private boolean ekk = false;
    private boolean ekl = false;
    private boolean ekm = false;
    private boolean ekn = true;
    private boolean eko = true;
    private boolean ekp = true;
    private FrsGroupRequestMessage ekq = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ekr = new FrsGroupReadCacheRequestMessage();
    private boolean bfQ = true;
    private int apJ = 1;
    private Set<Long> eks = new HashSet();
    private com.baidu.adp.framework.listener.c ekt = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.ekq.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.nF(type);
                    if (com.baidu.adp.lib.util.j.jD()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.ekq.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ap apVar = new ap();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bfQ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                apVar.dkR = false;
                apVar.isLocal = false;
                if (type == 3) {
                    apVar.pn = d.this.ekg;
                    d.this.ekm = z;
                    d.this.eka = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ekp = false;
                } else if (type == 1) {
                    apVar.pn = d.this.eke;
                    d.this.ekk = z;
                    d.this.ejY = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ekn = false;
                } else {
                    apVar.pn = d.this.ekf;
                    d.this.ekl = z;
                    d.this.ejZ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eko = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.deo != null) {
                    d.this.deo.a(4, type, apVar, a);
                }
            }
        }
    };
    private CustomMessageListener ddJ = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ekr.getType();
                ap apVar = new ap();
                apVar.errCode = customResponsedMessage.getError();
                apVar.errMsg = customResponsedMessage.getErrorString();
                apVar.forumId = d.this.forumId;
                apVar.forumName = d.this.forumName;
                apVar.isLocal = true;
                apVar.hasMore = false;
                apVar.pn = -1;
                if (type == 3) {
                    d.this.eka = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ekd = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.ejY = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ekb = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.ejZ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ekc = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.deo != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.deo.a(4, type, apVar, a);
                }
                d.this.be(type, 0);
            }
        }
    };

    public void be(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aQJ != null) {
            frsGroupRequestMessage.setTag(this.aQJ);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.ekq = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void mc(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aQJ != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aQJ);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ekr = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void nF(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ap apVar = new ap();
        apVar.forumId = this.forumId;
        apVar.forumName = this.forumName;
        apVar.dkR = false;
        apVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.ejY;
            list = this.ekb;
            apVar.pn = this.eke;
            apVar.hasMore = this.ekk;
        } else if (i == 2) {
            groupPermData = this.ejZ;
            list = this.ekc;
            apVar.pn = this.ekf;
            apVar.hasMore = this.ekl;
        } else if (i == 3) {
            groupPermData = this.eka;
            list = this.ekd;
            apVar.pn = this.ekg;
            apVar.hasMore = this.ekm;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.deo != null) {
                this.deo.a(4, i, apVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.ekb = a(z, this.ekb, list);
            this.ejY = groupPermData;
            return a(this.ejY, this.ekb, i);
        } else if (i == 3) {
            this.eka = groupPermData;
            this.ekd = a(z, this.ekd, list);
            return a(this.eka, this.ekd, i);
        } else {
            this.ejZ = groupPermData;
            this.ekc = a(z, this.ekc, list);
            return a(this.ejZ, this.ekc, i);
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
        this.eks.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eks.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.apJ + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(bf((size * com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0141d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.g bf(int i, int i2) {
        com.baidu.tieba.frs.g gVar = new com.baidu.tieba.frs.g();
        gVar.setHeight(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        gVar.kb(i2);
        return gVar;
    }

    private boolean nG(int i) {
        if (i == 1) {
            return this.ekn;
        }
        if (i == 2) {
            return this.eko;
        }
        if (i == 3) {
            return this.ekp;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.deo != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.oq(TbadkCoreApplication.getInst().getResources().getString(d.k.login_see_more));
                hVar.op(TbadkCoreApplication.getInst().getResources().getString(d.k.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.nI(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.jD()) {
                arrayList.add(new com.baidu.tieba.frs.k());
            } else {
                hVar.oq(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group));
                hVar.op(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group_tip));
                hVar.oo(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.nI(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(bf(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ap apVar = new ap();
            apVar.errCode = 0;
            apVar.forumId = this.forumId;
            apVar.forumName = this.forumName;
            apVar.hasMore = false;
            apVar.dkR = false;
            apVar.pn = -1;
            this.deo.a(4, this.apJ, apVar, arrayList);
        }
    }

    private boolean nH(int i) {
        if (i == 1) {
            return this.ekk;
        }
        if (i == 2) {
            return this.ekl;
        }
        if (i == 3) {
            return this.ekm;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        int i3;
        if (i == 4 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            this.apJ = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (nG(i2)) {
                mc(i2);
            } else {
                if (amVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.eke;
                } else if (i2 == 2) {
                    i3 = this.ekf;
                } else {
                    i3 = i2 == 3 ? this.ekg : 0;
                }
                int a = a(i2, this.rn, i3, amVar);
                if (a < 0) {
                    nF(i2);
                } else if (a == 0) {
                    this.bfQ = true;
                    be(i2, 0);
                } else if (nH(i2)) {
                    this.bfQ = false;
                    be(i2, a);
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
                this.ekh = 0;
                this.eke = 1;
                return 0;
            } else if (i == 2) {
                this.eki = 0;
                this.ekf = 1;
                return 0;
            } else if (i == 3) {
                this.ekj = 0;
                this.ekg = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (amVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ekh += i2;
                int i4 = this.ekh;
                this.eke = amVar.pn;
                return i4;
            } else if (i == 2) {
                this.eki += i2;
                int i5 = this.eki;
                this.ekf = amVar.pn;
                return i5;
            } else if (i == 3) {
                this.ekj += i2;
                int i6 = this.ekj;
                this.ekg = amVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.deo = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aQJ != null) {
            this.ekt.setTag(this.aQJ);
            this.ekt.setSelfListener(true);
            this.ddJ.setTag(this.aQJ);
            this.ddJ.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ekt);
        MessageManager.getInstance().registerListener(this.ddJ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aQJ = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void UT() {
        MessageManager.getInstance().unRegisterListener(this.ekt);
        MessageManager.getInstance().unRegisterListener(this.ddJ);
    }
}
