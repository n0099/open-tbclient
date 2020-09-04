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
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.s;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes17.dex */
public class d implements ar {
    private BdUniqueId ePz;
    private String forumId;
    private String forumName;
    private av hOY;
    private GroupPermData joQ;
    private GroupPermData joR;
    private GroupPermData joS;
    private int rn;
    private List<GroupInfoData> joT = new ArrayList();
    private List<GroupInfoData> joU = new ArrayList();
    private List<GroupInfoData> joV = new ArrayList();
    private int joW = 0;
    private int joX = 0;
    private int joY = 0;
    private int joZ = 0;
    private int jpa = 0;
    private int jpb = 0;
    private boolean jpc = false;
    private boolean jpd = false;
    private boolean jpe = false;
    private boolean jpf = true;
    private boolean jpg = true;
    private boolean jph = true;
    private FrsGroupRequestMessage jpi = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jpj = new FrsGroupReadCacheRequestMessage();
    private boolean fkC = true;
    private int ekg = 1;
    private Set<Long> jpk = new HashSet();
    private com.baidu.adp.framework.listener.c jpl = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jpi.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.Be(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jpi.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a = d.this.a(d.this.fkC, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    bdVar.hasMore = false;
                    z = false;
                } else {
                    bdVar.hasMore = z;
                }
                bdVar.errCode = frsGroupSocketResponseMessage.getError();
                bdVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.hXU = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.joY;
                    d.this.jpe = z;
                    d.this.joS = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jph = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.joW;
                    d.this.jpc = z;
                    d.this.joQ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jpf = false;
                } else {
                    bdVar.pn = d.this.joX;
                    d.this.jpd = z;
                    d.this.joR = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jpg = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hOY != null) {
                    d.this.hOY.a(4, type, bdVar, a);
                }
            }
        }
    };
    private CustomMessageListener hOu = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jpj.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.joS = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joV = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.joQ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joT = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.joR = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joU = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hOY != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hOY.a(4, type, bdVar, a);
                }
                d.this.cJ(type, 0);
            }
        }
    };

    public void cJ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.ePz != null) {
            frsGroupRequestMessage.setTag(this.ePz);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jpi = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void zy(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.ePz != null) {
            frsGroupReadCacheRequestMessage.setTag(this.ePz);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jpj = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void Be(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.hXU = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.joQ;
            list = this.joT;
            bdVar.pn = this.joW;
            bdVar.hasMore = this.jpc;
        } else if (i == 2) {
            groupPermData = this.joR;
            list = this.joU;
            bdVar.pn = this.joX;
            bdVar.hasMore = this.jpd;
        } else if (i == 3) {
            groupPermData = this.joS;
            list = this.joV;
            bdVar.pn = this.joY;
            bdVar.hasMore = this.jpe;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hOY != null) {
                this.hOY.a(4, i, bdVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.joT = a(z, this.joT, list);
            this.joQ = groupPermData;
            return a(this.joQ, this.joT, i);
        } else if (i == 3) {
            this.joS = groupPermData;
            this.joV = a(z, this.joV, list);
            return a(this.joS, this.joV, i);
        } else {
            this.joR = groupPermData;
            this.joU = a(z, this.joU, list);
            return a(this.joR, this.joU, i);
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
        this.jpk.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jpk.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.ekg + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cK((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private n cK(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.wQ(i2);
        return nVar;
    }

    private boolean Bf(int i) {
        if (i == 1) {
            return this.jpf;
        }
        if (i == 2) {
            return this.jpg;
        }
        if (i == 3) {
            return this.jph;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hOY != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.KJ(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.KI(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.Bh(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.KJ(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.KI(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.KH(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.Bh(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cK(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.hXU = false;
            bdVar.pn = -1;
            this.hOY.a(4, this.ekg, bdVar, arrayList);
        }
    }

    private boolean Bg(int i) {
        if (i == 1) {
            return this.jpc;
        }
        if (i == 2) {
            return this.jpd;
        }
        if (i == 3) {
            return this.jpe;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.ekg = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (Bf(i2)) {
                zy(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.joW;
                } else if (i2 == 2) {
                    i3 = this.joX;
                } else {
                    i3 = i2 == 3 ? this.joY : 0;
                }
                int a = a(i2, this.rn, i3, baVar);
                if (a < 0) {
                    Be(i2);
                } else if (a == 0) {
                    this.fkC = true;
                    cJ(i2, 0);
                } else if (Bg(i2)) {
                    this.fkC = false;
                    cJ(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, ba baVar) {
        if (baVar == null) {
            return -1;
        }
        if (baVar.pn == -1) {
            if (i == 1) {
                this.joZ = 0;
                this.joW = 1;
                return 0;
            } else if (i == 2) {
                this.jpa = 0;
                this.joX = 1;
                return 0;
            } else if (i == 3) {
                this.jpb = 0;
                this.joY = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.joZ += i2;
                int i4 = this.joZ;
                this.joW = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.jpa += i2;
                int i5 = this.jpa;
                this.joX = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.jpb += i2;
                int i6 = this.jpb;
                this.joY = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.hOY = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.ePz != null) {
            this.jpl.setTag(this.ePz);
            this.jpl.setSelfListener(true);
            this.hOu.setTag(this.ePz);
            this.hOu.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jpl);
        MessageManager.getInstance().registerListener(this.hOu);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ePz = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bLP() {
        MessageManager.getInstance().unRegisterListener(this.jpl);
        MessageManager.getInstance().unRegisterListener(this.hOu);
    }
}
