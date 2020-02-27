package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements ag {
    private BdUniqueId dBj;
    private String forumId;
    private String forumName;
    private aj gkD;
    private GroupPermData hzq;
    private GroupPermData hzr;
    private GroupPermData hzs;
    private int rn;
    private List<GroupInfoData> hzt = new ArrayList();
    private List<GroupInfoData> hzu = new ArrayList();
    private List<GroupInfoData> hzv = new ArrayList();
    private int hzw = 0;
    private int hzx = 0;
    private int hzy = 0;
    private int hzz = 0;
    private int hzA = 0;
    private int hzB = 0;
    private boolean hzC = false;
    private boolean hzD = false;
    private boolean hzE = false;
    private boolean hzF = true;
    private boolean hzG = true;
    private boolean hzH = true;
    private FrsGroupRequestMessage hzI = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage hzJ = new FrsGroupReadCacheRequestMessage();
    private boolean dTh = true;
    private int cZA = 1;
    private Set<Long> hzK = new HashSet();
    private com.baidu.adp.framework.listener.c hzL = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hzI.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wp(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hzI.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                aq aqVar = new aq();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dTh, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    aqVar.hasMore = false;
                    z = false;
                } else {
                    aqVar.hasMore = z;
                }
                aqVar.errCode = frsGroupSocketResponseMessage.getError();
                aqVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.gsr = false;
                aqVar.isLocal = false;
                if (type == 3) {
                    aqVar.pn = d.this.hzy;
                    d.this.hzE = z;
                    d.this.hzs = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzH = false;
                } else if (type == 1) {
                    aqVar.pn = d.this.hzw;
                    d.this.hzC = z;
                    d.this.hzq = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzF = false;
                } else {
                    aqVar.pn = d.this.hzx;
                    d.this.hzD = z;
                    d.this.hzr = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzG = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gkD != null) {
                    d.this.gkD.a(4, type, aqVar, a);
                }
            }
        }
    };
    private CustomMessageListener gjX = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.hzJ.getType();
                aq aqVar = new aq();
                aqVar.errCode = customResponsedMessage.getError();
                aqVar.errMsg = customResponsedMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.isLocal = true;
                aqVar.hasMore = false;
                aqVar.pn = -1;
                if (type == 3) {
                    d.this.hzs = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzv = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.hzq = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzt = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.hzr = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzu = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gkD != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gkD.a(4, type, aqVar, a);
                }
                d.this.cg(type, 0);
            }
        }
    };

    public void cg(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dBj != null) {
            frsGroupRequestMessage.setTag(this.dBj);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hzI = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void uT(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dBj != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dBj);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.hzJ = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wp(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        aq aqVar = new aq();
        aqVar.forumId = this.forumId;
        aqVar.forumName = this.forumName;
        aqVar.gsr = false;
        aqVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.hzq;
            list = this.hzt;
            aqVar.pn = this.hzw;
            aqVar.hasMore = this.hzC;
        } else if (i == 2) {
            groupPermData = this.hzr;
            list = this.hzu;
            aqVar.pn = this.hzx;
            aqVar.hasMore = this.hzD;
        } else if (i == 3) {
            groupPermData = this.hzs;
            list = this.hzv;
            aqVar.pn = this.hzy;
            aqVar.hasMore = this.hzE;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gkD != null) {
                this.gkD.a(4, i, aqVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.hzt = a(z, this.hzt, list);
            this.hzq = groupPermData;
            return a(this.hzq, this.hzt, i);
        } else if (i == 3) {
            this.hzs = groupPermData;
            this.hzv = a(z, this.hzv, list);
            return a(this.hzs, this.hzv, i);
        } else {
            this.hzr = groupPermData;
            this.hzu = a(z, this.hzu, list);
            return a(this.hzr, this.hzu, i);
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
        this.hzK.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hzK.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cZA + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(ch((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.j ch(int i, int i2) {
        com.baidu.tieba.frs.j jVar = new com.baidu.tieba.frs.j();
        jVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        jVar.sB(i2);
        return jVar;
    }

    private boolean wq(int i) {
        if (i == 1) {
            return this.hzF;
        }
        if (i == 2) {
            return this.hzG;
        }
        if (i == 3) {
            return this.hzH;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gkD != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Dd(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.ws(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new n());
            } else {
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Dd(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Dc(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.ws(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ch(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            aq aqVar = new aq();
            aqVar.errCode = 0;
            aqVar.forumId = this.forumId;
            aqVar.forumName = this.forumName;
            aqVar.hasMore = false;
            aqVar.gsr = false;
            aqVar.pn = -1;
            this.gkD.a(4, this.cZA, aqVar, arrayList);
        }
    }

    private boolean wr(int i) {
        if (i == 1) {
            return this.hzC;
        }
        if (i == 2) {
            return this.hzD;
        }
        if (i == 3) {
            return this.hzE;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        int i3;
        if (i == 4 && anVar != null) {
            this.forumId = anVar.forumId;
            this.forumName = anVar.forumName;
            this.cZA = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wq(i2)) {
                uT(i2);
            } else {
                if (anVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.hzw;
                } else if (i2 == 2) {
                    i3 = this.hzx;
                } else {
                    i3 = i2 == 3 ? this.hzy : 0;
                }
                int a = a(i2, this.rn, i3, anVar);
                if (a < 0) {
                    wp(i2);
                } else if (a == 0) {
                    this.dTh = true;
                    cg(i2, 0);
                } else if (wr(i2)) {
                    this.dTh = false;
                    cg(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, an anVar) {
        if (anVar == null) {
            return -1;
        }
        if (anVar.pn == -1) {
            if (i == 1) {
                this.hzz = 0;
                this.hzw = 1;
                return 0;
            } else if (i == 2) {
                this.hzA = 0;
                this.hzx = 1;
                return 0;
            } else if (i == 3) {
                this.hzB = 0;
                this.hzy = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (anVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.hzz += i2;
                int i4 = this.hzz;
                this.hzw = anVar.pn;
                return i4;
            } else if (i == 2) {
                this.hzA += i2;
                int i5 = this.hzA;
                this.hzx = anVar.pn;
                return i5;
            } else if (i == 3) {
                this.hzB += i2;
                int i6 = this.hzB;
                this.hzy = anVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gkD = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dBj != null) {
            this.hzL.setTag(this.dBj);
            this.hzL.setSelfListener(true);
            this.gjX.setTag(this.dBj);
            this.gjX.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hzL);
        MessageManager.getInstance().registerListener(this.gjX);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBj = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgU() {
        MessageManager.getInstance().unRegisterListener(this.hzL);
        MessageManager.getInstance().unRegisterListener(this.gjX);
    }
}
