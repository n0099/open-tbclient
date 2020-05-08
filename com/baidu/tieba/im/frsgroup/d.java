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
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.p;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements ak {
    private BdUniqueId ebA;
    private String forumId;
    private String forumName;
    private ao gUM;
    private GroupPermData ikY;
    private GroupPermData ikZ;
    private GroupPermData ila;
    private int rn;
    private List<GroupInfoData> ilb = new ArrayList();
    private List<GroupInfoData> ilc = new ArrayList();
    private List<GroupInfoData> ild = new ArrayList();
    private int ile = 0;
    private int ilf = 0;
    private int ilg = 0;
    private int ilh = 0;
    private int ili = 0;
    private int ilj = 0;
    private boolean ilk = false;
    private boolean ill = false;
    private boolean ilm = false;
    private boolean iln = true;
    private boolean ilo = true;
    private boolean ilp = true;
    private FrsGroupRequestMessage ilq = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ilr = new FrsGroupReadCacheRequestMessage();
    private boolean etP = true;
    private int dzh = 1;
    private Set<Long> ils = new HashSet();
    private com.baidu.adp.framework.listener.c ilt = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.ilq.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wV(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.ilq.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                av avVar = new av();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.etP, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    avVar.hasMore = false;
                    z = false;
                } else {
                    avVar.hasMore = z;
                }
                avVar.errCode = frsGroupSocketResponseMessage.getError();
                avVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.hcB = false;
                avVar.isLocal = false;
                if (type == 3) {
                    avVar.pn = d.this.ilg;
                    d.this.ilm = z;
                    d.this.ila = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ilp = false;
                } else if (type == 1) {
                    avVar.pn = d.this.ile;
                    d.this.ilk = z;
                    d.this.ikY = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.iln = false;
                } else {
                    avVar.pn = d.this.ilf;
                    d.this.ill = z;
                    d.this.ikZ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ilo = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gUM != null) {
                    d.this.gUM.a(4, type, avVar, a);
                }
            }
        }
    };
    private CustomMessageListener gUh = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ilr.getType();
                av avVar = new av();
                avVar.errCode = customResponsedMessage.getError();
                avVar.errMsg = customResponsedMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.isLocal = true;
                avVar.hasMore = false;
                avVar.pn = -1;
                if (type == 3) {
                    d.this.ila = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ild = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.ikY = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ilb = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.ikZ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ilc = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gUM != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gUM.a(4, type, avVar, a);
                }
                d.this.cn(type, 0);
            }
        }
    };

    public void cn(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.ebA != null) {
            frsGroupRequestMessage.setTag(this.ebA);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.ilq = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void vy(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.ebA != null) {
            frsGroupReadCacheRequestMessage.setTag(this.ebA);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ilr = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wV(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        av avVar = new av();
        avVar.forumId = this.forumId;
        avVar.forumName = this.forumName;
        avVar.hcB = false;
        avVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.ikY;
            list = this.ilb;
            avVar.pn = this.ile;
            avVar.hasMore = this.ilk;
        } else if (i == 2) {
            groupPermData = this.ikZ;
            list = this.ilc;
            avVar.pn = this.ilf;
            avVar.hasMore = this.ill;
        } else if (i == 3) {
            groupPermData = this.ila;
            list = this.ild;
            avVar.pn = this.ilg;
            avVar.hasMore = this.ilm;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gUM != null) {
                this.gUM.a(4, i, avVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.ilb = a(z, this.ilb, list);
            this.ikY = groupPermData;
            return a(this.ikY, this.ilb, i);
        } else if (i == 3) {
            this.ila = groupPermData;
            this.ild = a(z, this.ild, list);
            return a(this.ila, this.ild, i);
        } else {
            this.ikZ = groupPermData;
            this.ilc = a(z, this.ilc, list);
            return a(this.ikZ, this.ilc, i);
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
        this.ils.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.ils.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.dzh + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(co((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.k co(int i, int i2) {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        kVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        kVar.ta(i2);
        return kVar;
    }

    private boolean wW(int i) {
        if (i == 1) {
            return this.iln;
        }
        if (i == 2) {
            return this.ilo;
        }
        if (i == 3) {
            return this.ilp;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gUM != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.EQ(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.EP(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.wY(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new p());
            } else {
                hVar.EQ(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.EP(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.EO(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.wY(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(co(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            av avVar = new av();
            avVar.errCode = 0;
            avVar.forumId = this.forumId;
            avVar.forumName = this.forumName;
            avVar.hasMore = false;
            avVar.hcB = false;
            avVar.pn = -1;
            this.gUM.a(4, this.dzh, avVar, arrayList);
        }
    }

    private boolean wX(int i) {
        if (i == 1) {
            return this.ilk;
        }
        if (i == 2) {
            return this.ill;
        }
        if (i == 3) {
            return this.ilm;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        int i3;
        if (i == 4 && asVar != null) {
            this.forumId = asVar.forumId;
            this.forumName = asVar.forumName;
            this.dzh = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wW(i2)) {
                vy(i2);
            } else {
                if (asVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.ile;
                } else if (i2 == 2) {
                    i3 = this.ilf;
                } else {
                    i3 = i2 == 3 ? this.ilg : 0;
                }
                int a = a(i2, this.rn, i3, asVar);
                if (a < 0) {
                    wV(i2);
                } else if (a == 0) {
                    this.etP = true;
                    cn(i2, 0);
                } else if (wX(i2)) {
                    this.etP = false;
                    cn(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, as asVar) {
        if (asVar == null) {
            return -1;
        }
        if (asVar.pn == -1) {
            if (i == 1) {
                this.ilh = 0;
                this.ile = 1;
                return 0;
            } else if (i == 2) {
                this.ili = 0;
                this.ilf = 1;
                return 0;
            } else if (i == 3) {
                this.ilj = 0;
                this.ilg = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (asVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ilh += i2;
                int i4 = this.ilh;
                this.ile = asVar.pn;
                return i4;
            } else if (i == 2) {
                this.ili += i2;
                int i5 = this.ili;
                this.ilf = asVar.pn;
                return i5;
            } else if (i == 3) {
                this.ilj += i2;
                int i6 = this.ilj;
                this.ilg = asVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.gUM = aoVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.ebA != null) {
            this.ilt.setTag(this.ebA);
            this.ilt.setSelfListener(true);
            this.gUh.setTag(this.ebA);
            this.gUh.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ilt);
        MessageManager.getInstance().registerListener(this.gUh);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ebA = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void bqr() {
        MessageManager.getInstance().unRegisterListener(this.ilt);
        MessageManager.getInstance().unRegisterListener(this.gUh);
    }
}
