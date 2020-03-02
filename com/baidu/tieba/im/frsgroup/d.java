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
    private BdUniqueId dBk;
    private String forumId;
    private String forumName;
    private aj gkF;
    private GroupPermData hzs;
    private GroupPermData hzt;
    private GroupPermData hzu;
    private int rn;
    private List<GroupInfoData> hzv = new ArrayList();
    private List<GroupInfoData> hzw = new ArrayList();
    private List<GroupInfoData> hzx = new ArrayList();
    private int hzy = 0;
    private int hzz = 0;
    private int hzA = 0;
    private int hzB = 0;
    private int hzC = 0;
    private int hzD = 0;
    private boolean hzE = false;
    private boolean hzF = false;
    private boolean hzG = false;
    private boolean hzH = true;
    private boolean hzI = true;
    private boolean hzJ = true;
    private FrsGroupRequestMessage hzK = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage hzL = new FrsGroupReadCacheRequestMessage();
    private boolean dTi = true;
    private int cZB = 1;
    private Set<Long> hzM = new HashSet();
    private com.baidu.adp.framework.listener.c hzN = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hzK.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wp(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hzK.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                aq aqVar = new aq();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dTi, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                aqVar.gst = false;
                aqVar.isLocal = false;
                if (type == 3) {
                    aqVar.pn = d.this.hzA;
                    d.this.hzG = z;
                    d.this.hzu = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzJ = false;
                } else if (type == 1) {
                    aqVar.pn = d.this.hzy;
                    d.this.hzE = z;
                    d.this.hzs = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzH = false;
                } else {
                    aqVar.pn = d.this.hzz;
                    d.this.hzF = z;
                    d.this.hzt = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hzI = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gkF != null) {
                    d.this.gkF.a(4, type, aqVar, a);
                }
            }
        }
    };
    private CustomMessageListener gjZ = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.hzL.getType();
                aq aqVar = new aq();
                aqVar.errCode = customResponsedMessage.getError();
                aqVar.errMsg = customResponsedMessage.getErrorString();
                aqVar.forumId = d.this.forumId;
                aqVar.forumName = d.this.forumName;
                aqVar.isLocal = true;
                aqVar.hasMore = false;
                aqVar.pn = -1;
                if (type == 3) {
                    d.this.hzu = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzx = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.hzs = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzv = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.hzt = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hzw = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gkF != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gkF.a(4, type, aqVar, a);
                }
                d.this.cg(type, 0);
            }
        }
    };

    public void cg(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dBk != null) {
            frsGroupRequestMessage.setTag(this.dBk);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hzK = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void uT(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dBk != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dBk);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.hzL = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wp(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        aq aqVar = new aq();
        aqVar.forumId = this.forumId;
        aqVar.forumName = this.forumName;
        aqVar.gst = false;
        aqVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.hzs;
            list = this.hzv;
            aqVar.pn = this.hzy;
            aqVar.hasMore = this.hzE;
        } else if (i == 2) {
            groupPermData = this.hzt;
            list = this.hzw;
            aqVar.pn = this.hzz;
            aqVar.hasMore = this.hzF;
        } else if (i == 3) {
            groupPermData = this.hzu;
            list = this.hzx;
            aqVar.pn = this.hzA;
            aqVar.hasMore = this.hzG;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gkF != null) {
                this.gkF.a(4, i, aqVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.hzv = a(z, this.hzv, list);
            this.hzs = groupPermData;
            return a(this.hzs, this.hzv, i);
        } else if (i == 3) {
            this.hzu = groupPermData;
            this.hzx = a(z, this.hzx, list);
            return a(this.hzu, this.hzx, i);
        } else {
            this.hzt = groupPermData;
            this.hzw = a(z, this.hzw, list);
            return a(this.hzt, this.hzw, i);
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
        this.hzM.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hzM.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cZB + 3);
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
            return this.hzH;
        }
        if (i == 2) {
            return this.hzI;
        }
        if (i == 3) {
            return this.hzJ;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gkF != null) {
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
            aqVar.gst = false;
            aqVar.pn = -1;
            this.gkF.a(4, this.cZB, aqVar, arrayList);
        }
    }

    private boolean wr(int i) {
        if (i == 1) {
            return this.hzE;
        }
        if (i == 2) {
            return this.hzF;
        }
        if (i == 3) {
            return this.hzG;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, an anVar) {
        int i3;
        if (i == 4 && anVar != null) {
            this.forumId = anVar.forumId;
            this.forumName = anVar.forumName;
            this.cZB = i2;
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
                    i3 = this.hzy;
                } else if (i2 == 2) {
                    i3 = this.hzz;
                } else {
                    i3 = i2 == 3 ? this.hzA : 0;
                }
                int a = a(i2, this.rn, i3, anVar);
                if (a < 0) {
                    wp(i2);
                } else if (a == 0) {
                    this.dTi = true;
                    cg(i2, 0);
                } else if (wr(i2)) {
                    this.dTi = false;
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
                this.hzB = 0;
                this.hzy = 1;
                return 0;
            } else if (i == 2) {
                this.hzC = 0;
                this.hzz = 1;
                return 0;
            } else if (i == 3) {
                this.hzD = 0;
                this.hzA = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (anVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.hzB += i2;
                int i4 = this.hzB;
                this.hzy = anVar.pn;
                return i4;
            } else if (i == 2) {
                this.hzC += i2;
                int i5 = this.hzC;
                this.hzz = anVar.pn;
                return i5;
            } else if (i == 3) {
                this.hzD += i2;
                int i6 = this.hzD;
                this.hzA = anVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.gkF = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dBk != null) {
            this.hzN.setTag(this.dBk);
            this.hzN.setSelfListener(true);
            this.gjZ.setTag(this.dBk);
            this.gjZ.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hzN);
        MessageManager.getInstance().registerListener(this.gjZ);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBk = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void bgW() {
        MessageManager.getInstance().unRegisterListener(this.hzN);
        MessageManager.getInstance().unRegisterListener(this.gjZ);
    }
}
