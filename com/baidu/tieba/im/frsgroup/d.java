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
/* loaded from: classes8.dex */
public class d implements ag {
    private BdUniqueId dxg;
    private String forumId;
    private String forumName;
    private aj giC;
    private GroupPermData hxr;
    private GroupPermData hxs;
    private GroupPermData hxt;
    private int rn;
    private List<GroupInfoData> hxu = new ArrayList();
    private List<GroupInfoData> hxv = new ArrayList();
    private List<GroupInfoData> hxw = new ArrayList();
    private int hxx = 0;
    private int hxy = 0;
    private int hxz = 0;
    private int hxA = 0;
    private int hxB = 0;
    private int hxC = 0;
    private boolean hxD = false;
    private boolean hxE = false;
    private boolean hxF = false;
    private boolean hxG = true;
    private boolean hxH = true;
    private boolean hxI = true;
    private FrsGroupRequestMessage hxJ = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage hxK = new FrsGroupReadCacheRequestMessage();
    private boolean dPb = true;
    private int cVy = 1;
    private Set<Long> hxL = new HashSet();
    private com.baidu.adp.framework.listener.c hxM = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hxJ.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wj(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hxJ.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                aq aqVar = new aq();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dPb, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                aqVar.gqq = false;
                aqVar.isLocal = false;
                if (type == 3) {
                    aqVar.pn = d.this.hxz;
                    d.this.hxF = z;
                    d.this.hxt = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hxI = false;
                } else if (type == 1) {
                    aqVar.pn = d.this.hxx;
                    d.this.hxD = z;
                    d.this.hxr = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hxG = false;
                } else {
                    aqVar.pn = d.this.hxy;
                    d.this.hxE = z;
                    d.this.hxs = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hxH = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.giC != null) {
                    d.this.giC.a(4, type, aqVar, a);
                }
            }
        }
    };
    private CustomMessageListener ghV = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.hxK.getType();
                aq aqVar = new aq();
                aqVar.errCode = customResponsedMessage.getError();
                aqVar.errMsg = customResponsedMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.isLocal = true;
                aqVar.hasMore = false;
                aqVar.pn = -1;
                if (type == 3) {
                    d.this.hxt = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hxw = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.hxr = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hxu = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.hxs = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hxv = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.giC != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.giC.a(4, type, aqVar, a);
                }
                d.this.cf(type, 0);
            }
        }
    };

    public void cf(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dxg != null) {
            frsGroupRequestMessage.setTag(this.dxg);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hxJ = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void uN(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dxg != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dxg);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.hxK = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wj(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        aq aqVar = new aq();
        aqVar.forumId = this.forumId;
        aqVar.forumName = this.forumName;
        aqVar.gqq = false;
        aqVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.hxr;
            list = this.hxu;
            aqVar.pn = this.hxx;
            aqVar.hasMore = this.hxD;
        } else if (i == 2) {
            groupPermData = this.hxs;
            list = this.hxv;
            aqVar.pn = this.hxy;
            aqVar.hasMore = this.hxE;
        } else if (i == 3) {
            groupPermData = this.hxt;
            list = this.hxw;
            aqVar.pn = this.hxz;
            aqVar.hasMore = this.hxF;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.giC != null) {
                this.giC.a(4, i, aqVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.hxu = a(z, this.hxu, list);
            this.hxr = groupPermData;
            return a(this.hxr, this.hxu, i);
        } else if (i == 3) {
            this.hxt = groupPermData;
            this.hxw = a(z, this.hxw, list);
            return a(this.hxt, this.hxw, i);
        } else {
            this.hxs = groupPermData;
            this.hxv = a(z, this.hxv, list);
            return a(this.hxs, this.hxv, i);
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
        this.hxL.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hxL.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cVy + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cg((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.j cg(int i, int i2) {
        com.baidu.tieba.frs.j jVar = new com.baidu.tieba.frs.j();
        jVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        jVar.sv(i2);
        return jVar;
    }

    private boolean wk(int i) {
        if (i == 1) {
            return this.hxG;
        }
        if (i == 2) {
            return this.hxH;
        }
        if (i == 3) {
            return this.hxI;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.giC != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.CO(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.CN(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.wm(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new n());
            } else {
                hVar.CO(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.CN(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.CM(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.wm(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cg(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            aq aqVar = new aq();
            aqVar.errCode = 0;
            aqVar.forumId = this.forumId;
            aqVar.forumName = this.forumName;
            aqVar.hasMore = false;
            aqVar.gqq = false;
            aqVar.pn = -1;
            this.giC.a(4, this.cVy, aqVar, arrayList);
        }
    }

    private boolean wl(int i) {
        if (i == 1) {
            return this.hxD;
        }
        if (i == 2) {
            return this.hxE;
        }
        if (i == 3) {
            return this.hxF;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        int i3;
        if (i == 4 && anVar != null) {
            this.forumId = anVar.forumId;
            this.forumName = anVar.forumName;
            this.cVy = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wk(i2)) {
                uN(i2);
            } else {
                if (anVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.hxx;
                } else if (i2 == 2) {
                    i3 = this.hxy;
                } else {
                    i3 = i2 == 3 ? this.hxz : 0;
                }
                int a = a(i2, this.rn, i3, anVar);
                if (a < 0) {
                    wj(i2);
                } else if (a == 0) {
                    this.dPb = true;
                    cf(i2, 0);
                } else if (wl(i2)) {
                    this.dPb = false;
                    cf(i2, a);
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
                this.hxA = 0;
                this.hxx = 1;
                return 0;
            } else if (i == 2) {
                this.hxB = 0;
                this.hxy = 1;
                return 0;
            } else if (i == 3) {
                this.hxC = 0;
                this.hxz = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (anVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.hxA += i2;
                int i4 = this.hxA;
                this.hxx = anVar.pn;
                return i4;
            } else if (i == 2) {
                this.hxB += i2;
                int i5 = this.hxB;
                this.hxy = anVar.pn;
                return i5;
            } else if (i == 3) {
                this.hxC += i2;
                int i6 = this.hxC;
                this.hxz = anVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.giC = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dxg != null) {
            this.hxM.setTag(this.dxg);
            this.hxM.setSelfListener(true);
            this.ghV.setTag(this.dxg);
            this.ghV.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hxM);
        MessageManager.getInstance().registerListener(this.ghV);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dxg = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void beK() {
        MessageManager.getInstance().unRegisterListener(this.hxM);
        MessageManager.getInstance().unRegisterListener(this.ghV);
    }
}
