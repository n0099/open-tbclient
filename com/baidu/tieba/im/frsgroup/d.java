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
/* loaded from: classes7.dex */
public class d implements ag {
    private BdUniqueId dwY;
    private String forumId;
    private String forumName;
    private aj gfs;
    private GroupPermData htO;
    private GroupPermData htP;
    private GroupPermData htQ;
    private int rn;
    private List<GroupInfoData> htR = new ArrayList();
    private List<GroupInfoData> htS = new ArrayList();
    private List<GroupInfoData> htT = new ArrayList();
    private int htU = 0;
    private int htV = 0;
    private int htW = 0;
    private int htX = 0;
    private int htY = 0;
    private int htZ = 0;
    private boolean hua = false;
    private boolean hub = false;
    private boolean huc = false;
    private boolean hud = true;
    private boolean hue = true;
    private boolean huf = true;
    private FrsGroupRequestMessage hug = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage huh = new FrsGroupReadCacheRequestMessage();
    private boolean dOT = true;
    private int cVo = 1;
    private Set<Long> hui = new HashSet();
    private com.baidu.adp.framework.listener.c huj = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hug.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.we(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hug.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                aq aqVar = new aq();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dOT, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                aqVar.gnh = false;
                aqVar.isLocal = false;
                if (type == 3) {
                    aqVar.pn = d.this.htW;
                    d.this.huc = z;
                    d.this.htQ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.huf = false;
                } else if (type == 1) {
                    aqVar.pn = d.this.htU;
                    d.this.hua = z;
                    d.this.htO = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hud = false;
                } else {
                    aqVar.pn = d.this.htV;
                    d.this.hub = z;
                    d.this.htP = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hue = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gfs != null) {
                    d.this.gfs.a(4, type, aqVar, a);
                }
            }
        }
    };
    private CustomMessageListener geM = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.huh.getType();
                aq aqVar = new aq();
                aqVar.errCode = customResponsedMessage.getError();
                aqVar.errMsg = customResponsedMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.isLocal = true;
                aqVar.hasMore = false;
                aqVar.pn = -1;
                if (type == 3) {
                    d.this.htQ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.htT = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.htO = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.htR = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.htP = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.htS = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gfs != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gfs.a(4, type, aqVar, a);
                }
                d.this.cg(type, 0);
            }
        }
    };

    public void cg(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dwY != null) {
            frsGroupRequestMessage.setTag(this.dwY);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hug = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void uI(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dwY != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dwY);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.huh = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void we(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        aq aqVar = new aq();
        aqVar.forumId = this.forumId;
        aqVar.forumName = this.forumName;
        aqVar.gnh = false;
        aqVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.htO;
            list = this.htR;
            aqVar.pn = this.htU;
            aqVar.hasMore = this.hua;
        } else if (i == 2) {
            groupPermData = this.htP;
            list = this.htS;
            aqVar.pn = this.htV;
            aqVar.hasMore = this.hub;
        } else if (i == 3) {
            groupPermData = this.htQ;
            list = this.htT;
            aqVar.pn = this.htW;
            aqVar.hasMore = this.huc;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gfs != null) {
                this.gfs.a(4, i, aqVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.htR = a(z, this.htR, list);
            this.htO = groupPermData;
            return a(this.htO, this.htR, i);
        } else if (i == 3) {
            this.htQ = groupPermData;
            this.htT = a(z, this.htT, list);
            return a(this.htQ, this.htT, i);
        } else {
            this.htP = groupPermData;
            this.htS = a(z, this.htS, list);
            return a(this.htP, this.htS, i);
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
        this.hui.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hui.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cVo + 3);
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
        jVar.sq(i2);
        return jVar;
    }

    private boolean wf(int i) {
        if (i == 1) {
            return this.hud;
        }
        if (i == 2) {
            return this.hue;
        }
        if (i == 3) {
            return this.huf;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gfs != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.CE(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.CD(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.wh(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new n());
            } else {
                hVar.CE(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.CD(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.CC(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.wh(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ch(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            aq aqVar = new aq();
            aqVar.errCode = 0;
            aqVar.forumId = this.forumId;
            aqVar.forumName = this.forumName;
            aqVar.hasMore = false;
            aqVar.gnh = false;
            aqVar.pn = -1;
            this.gfs.a(4, this.cVo, aqVar, arrayList);
        }
    }

    private boolean wg(int i) {
        if (i == 1) {
            return this.hua;
        }
        if (i == 2) {
            return this.hub;
        }
        if (i == 3) {
            return this.huc;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        int i3;
        if (i == 4 && anVar != null) {
            this.forumId = anVar.forumId;
            this.forumName = anVar.forumName;
            this.cVo = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wf(i2)) {
                uI(i2);
            } else {
                if (anVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.htU;
                } else if (i2 == 2) {
                    i3 = this.htV;
                } else {
                    i3 = i2 == 3 ? this.htW : 0;
                }
                int a = a(i2, this.rn, i3, anVar);
                if (a < 0) {
                    we(i2);
                } else if (a == 0) {
                    this.dOT = true;
                    cg(i2, 0);
                } else if (wg(i2)) {
                    this.dOT = false;
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
                this.htX = 0;
                this.htU = 1;
                return 0;
            } else if (i == 2) {
                this.htY = 0;
                this.htV = 1;
                return 0;
            } else if (i == 3) {
                this.htZ = 0;
                this.htW = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (anVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.htX += i2;
                int i4 = this.htX;
                this.htU = anVar.pn;
                return i4;
            } else if (i == 2) {
                this.htY += i2;
                int i5 = this.htY;
                this.htV = anVar.pn;
                return i5;
            } else if (i == 3) {
                this.htZ += i2;
                int i6 = this.htZ;
                this.htW = anVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gfs = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dwY != null) {
            this.huj.setTag(this.dwY);
            this.huj.setSelfListener(true);
            this.geM.setTag(this.dwY);
            this.geM.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.huj);
        MessageManager.getInstance().registerListener(this.geM);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dwY = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bep() {
        MessageManager.getInstance().unRegisterListener(this.huj);
        MessageManager.getInstance().unRegisterListener(this.geM);
    }
}
