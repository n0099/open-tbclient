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
    private BdUniqueId aRF;
    private al dgg;
    private GroupPermData enS;
    private GroupPermData enT;
    private GroupPermData enU;
    private String forumId;
    private String forumName;
    private int rn;
    private List<GroupInfoData> enV = new ArrayList();
    private List<GroupInfoData> enW = new ArrayList();
    private List<GroupInfoData> enX = new ArrayList();
    private int enY = 0;
    private int enZ = 0;
    private int eoa = 0;
    private int eob = 0;
    private int eoc = 0;
    private int eod = 0;
    private boolean eoe = false;
    private boolean eog = false;
    private boolean eoh = false;
    private boolean eoi = true;
    private boolean eoj = true;
    private boolean eok = true;
    private FrsGroupRequestMessage eol = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage eom = new FrsGroupReadCacheRequestMessage();
    private boolean bhe = true;
    private int aqi = 1;
    private Set<Long> eon = new HashSet();
    private com.baidu.adp.framework.listener.c eoo = new com.baidu.adp.framework.listener.c(103002) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.eol.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.nM(type);
                    if (com.baidu.adp.lib.util.j.jD()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.eol.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.h> a = d.this.a(d.this.bhe, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                arVar.dmY = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.eoa;
                    d.this.eoh = z;
                    d.this.enU = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eok = false;
                } else if (type == 1) {
                    arVar.pn = d.this.enY;
                    d.this.eoe = z;
                    d.this.enS = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eoi = false;
                } else {
                    arVar.pn = d.this.enZ;
                    d.this.eog = z;
                    d.this.enT = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.eoj = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.b(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.dgg != null) {
                    d.this.dgg.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener dfB = new CustomMessageListener(2001204) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.h> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.eom.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.enU = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.enX = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.enS = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.enV = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.enT = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.enW = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.dgg != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.dgg.a(4, type, arVar, a);
                }
                d.this.bd(type, 0);
            }
        }
    };

    public void bd(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.aRF != null) {
            frsGroupRequestMessage.setTag(this.aRF);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.eol = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void mj(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.aRF != null) {
            frsGroupReadCacheRequestMessage.setTag(this.aRF);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.eom = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void nM(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.dmY = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.enS;
            list = this.enV;
            arVar.pn = this.enY;
            arVar.hasMore = this.eoe;
        } else if (i == 2) {
            groupPermData = this.enT;
            list = this.enW;
            arVar.pn = this.enZ;
            arVar.hasMore = this.eog;
        } else if (i == 3) {
            groupPermData = this.enU;
            list = this.enX;
            arVar.pn = this.eoa;
            arVar.hasMore = this.eoh;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.dgg != null) {
                this.dgg.a(4, i, arVar, a);
                return;
            }
            return;
        }
        b(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.h> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.enV = a(z, this.enV, list);
            this.enS = groupPermData;
            return a(this.enS, this.enV, i);
        } else if (i == 3) {
            this.enU = groupPermData;
            this.enX = a(z, this.enX, list);
            return a(this.enU, this.enX, i);
        } else {
            this.enT = groupPermData;
            this.enW = a(z, this.enW, list);
            return a(this.enT, this.enW, i);
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
        this.eon.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.eon.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.aqi + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(be((size * com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds160)) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds120), d.C0142d.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.i be(int i, int i2) {
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        iVar.setHeight(com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds100) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds90)) + i));
        iVar.kf(i2);
        return iVar;
    }

    private boolean nN(int i) {
        if (i == 1) {
            return this.eoi;
        }
        if (i == 2) {
            return this.eoj;
        }
        if (i == 3) {
            return this.eok;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z, Object obj) {
        if (this.dgg != null) {
            ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.or(TbadkCoreApplication.getInst().getResources().getString(d.k.login_see_more));
                hVar.oq(TbadkCoreApplication.getInst().getResources().getString(d.k.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.nP(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.jD()) {
                arrayList.add(new com.baidu.tieba.frs.m());
            } else {
                hVar.or(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group));
                hVar.oq(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_hot_create_group_tip));
                hVar.op(TbadkCoreApplication.getInst().getResources().getString(d.k.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.nP(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(be(com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds600) + com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds80), d.f.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.dmY = false;
            arVar.pn = -1;
            this.dgg.a(4, this.aqi, arVar, arrayList);
        }
    }

    private boolean nO(int i) {
        if (i == 1) {
            return this.eoe;
        }
        if (i == 2) {
            return this.eog;
        }
        if (i == 3) {
            return this.eoh;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.aqi = i2;
            if (!TbadkCoreApplication.isLogin()) {
                b(false, (Object) null);
            } else if (nN(i2)) {
                mj(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.enY;
                } else if (i2 == 2) {
                    i3 = this.enZ;
                } else {
                    i3 = i2 == 3 ? this.eoa : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    nM(i2);
                } else if (a == 0) {
                    this.bhe = true;
                    bd(i2, 0);
                } else if (nO(i2)) {
                    this.bhe = false;
                    bd(i2, a);
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
                this.eob = 0;
                this.enY = 1;
                return 0;
            } else if (i == 2) {
                this.eoc = 0;
                this.enZ = 1;
                return 0;
            } else if (i == 3) {
                this.eod = 0;
                this.eoa = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.eob += i2;
                int i4 = this.eob;
                this.enY = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.eoc += i2;
                int i5 = this.eoc;
                this.enZ = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.eod += i2;
                int i6 = this.eod;
                this.eoa = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dgg = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(103002, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2001204, j.class);
        if (this.aRF != null) {
            this.eoo.setTag(this.aRF);
            this.eoo.setSelfListener(true);
            this.dfB.setTag(this.aRF);
            this.dfB.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.eoo);
        MessageManager.getInstance().registerListener(this.dfB);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aRF = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void Vo() {
        MessageManager.getInstance().unRegisterListener(this.eoo);
        MessageManager.getInstance().unRegisterListener(this.dfB);
    }
}
