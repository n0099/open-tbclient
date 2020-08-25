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
    private BdUniqueId ePv;
    private String forumId;
    private String forumName;
    private av hOS;
    private GroupPermData joK;
    private GroupPermData joL;
    private GroupPermData joM;
    private int rn;
    private List<GroupInfoData> joN = new ArrayList();
    private List<GroupInfoData> joO = new ArrayList();
    private List<GroupInfoData> joP = new ArrayList();
    private int joQ = 0;
    private int joR = 0;
    private int joS = 0;
    private int joT = 0;
    private int joU = 0;
    private int joV = 0;
    private boolean joW = false;
    private boolean joX = false;
    private boolean joY = false;
    private boolean joZ = true;
    private boolean jpa = true;
    private boolean jpb = true;
    private FrsGroupRequestMessage jpc = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jpd = new FrsGroupReadCacheRequestMessage();
    private boolean fky = true;
    private int ekc = 1;
    private Set<Long> jpe = new HashSet();
    private com.baidu.adp.framework.listener.c jpf = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jpc.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.Be(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jpc.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a = d.this.a(d.this.fky, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bdVar.hXO = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.joS;
                    d.this.joY = z;
                    d.this.joM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jpb = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.joQ;
                    d.this.joW = z;
                    d.this.joK = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.joZ = false;
                } else {
                    bdVar.pn = d.this.joR;
                    d.this.joX = z;
                    d.this.joL = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jpa = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hOS != null) {
                    d.this.hOS.a(4, type, bdVar, a);
                }
            }
        }
    };
    private CustomMessageListener hOo = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jpd.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.joM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joP = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.joK = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joN = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.joL = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.joO = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hOS != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hOS.a(4, type, bdVar, a);
                }
                d.this.cJ(type, 0);
            }
        }
    };

    public void cJ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.ePv != null) {
            frsGroupRequestMessage.setTag(this.ePv);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jpc = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void zy(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.ePv != null) {
            frsGroupReadCacheRequestMessage.setTag(this.ePv);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jpd = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void Be(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.hXO = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.joK;
            list = this.joN;
            bdVar.pn = this.joQ;
            bdVar.hasMore = this.joW;
        } else if (i == 2) {
            groupPermData = this.joL;
            list = this.joO;
            bdVar.pn = this.joR;
            bdVar.hasMore = this.joX;
        } else if (i == 3) {
            groupPermData = this.joM;
            list = this.joP;
            bdVar.pn = this.joS;
            bdVar.hasMore = this.joY;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hOS != null) {
                this.hOS.a(4, i, bdVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.joN = a(z, this.joN, list);
            this.joK = groupPermData;
            return a(this.joK, this.joN, i);
        } else if (i == 3) {
            this.joM = groupPermData;
            this.joP = a(z, this.joP, list);
            return a(this.joM, this.joP, i);
        } else {
            this.joL = groupPermData;
            this.joO = a(z, this.joO, list);
            return a(this.joL, this.joO, i);
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
        this.jpe.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jpe.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.ekc + 3);
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
            return this.joZ;
        }
        if (i == 2) {
            return this.jpa;
        }
        if (i == 3) {
            return this.jpb;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hOS != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.KI(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.KH(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.Bh(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.KI(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.KH(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.KG(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
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
            bdVar.hXO = false;
            bdVar.pn = -1;
            this.hOS.a(4, this.ekc, bdVar, arrayList);
        }
    }

    private boolean Bg(int i) {
        if (i == 1) {
            return this.joW;
        }
        if (i == 2) {
            return this.joX;
        }
        if (i == 3) {
            return this.joY;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.ekc = i2;
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
                    i3 = this.joQ;
                } else if (i2 == 2) {
                    i3 = this.joR;
                } else {
                    i3 = i2 == 3 ? this.joS : 0;
                }
                int a = a(i2, this.rn, i3, baVar);
                if (a < 0) {
                    Be(i2);
                } else if (a == 0) {
                    this.fky = true;
                    cJ(i2, 0);
                } else if (Bg(i2)) {
                    this.fky = false;
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
                this.joT = 0;
                this.joQ = 1;
                return 0;
            } else if (i == 2) {
                this.joU = 0;
                this.joR = 1;
                return 0;
            } else if (i == 3) {
                this.joV = 0;
                this.joS = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.joT += i2;
                int i4 = this.joT;
                this.joQ = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.joU += i2;
                int i5 = this.joU;
                this.joR = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.joV += i2;
                int i6 = this.joV;
                this.joS = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.hOS = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.ePv != null) {
            this.jpf.setTag(this.ePv);
            this.jpf.setSelfListener(true);
            this.hOo.setTag(this.ePv);
            this.hOo.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jpf);
        MessageManager.getInstance().registerListener(this.hOo);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ePv = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bLO() {
        MessageManager.getInstance().unRegisterListener(this.jpf);
        MessageManager.getInstance().unRegisterListener(this.hOo);
    }
}
