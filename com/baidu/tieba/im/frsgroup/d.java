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
    private BdUniqueId ebv;
    private String forumId;
    private String forumName;
    private ao gUG;
    private GroupPermData ikS;
    private GroupPermData ikT;
    private GroupPermData ikU;
    private int rn;
    private List<GroupInfoData> ikV = new ArrayList();
    private List<GroupInfoData> ikW = new ArrayList();
    private List<GroupInfoData> ikX = new ArrayList();
    private int ikY = 0;
    private int ikZ = 0;
    private int ila = 0;
    private int ilb = 0;
    private int ilc = 0;
    private int ild = 0;
    private boolean ile = false;
    private boolean ilf = false;
    private boolean ilg = false;
    private boolean ilh = true;
    private boolean ili = true;
    private boolean ilj = true;
    private FrsGroupRequestMessage ilk = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ill = new FrsGroupReadCacheRequestMessage();
    private boolean etK = true;
    private int dzd = 1;
    private Set<Long> ilm = new HashSet();
    private com.baidu.adp.framework.listener.c iln = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.ilk.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wV(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.ilk.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                av avVar = new av();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.etK, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                avVar.hcv = false;
                avVar.isLocal = false;
                if (type == 3) {
                    avVar.pn = d.this.ila;
                    d.this.ilg = z;
                    d.this.ikU = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ilj = false;
                } else if (type == 1) {
                    avVar.pn = d.this.ikY;
                    d.this.ile = z;
                    d.this.ikS = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ilh = false;
                } else {
                    avVar.pn = d.this.ikZ;
                    d.this.ilf = z;
                    d.this.ikT = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ili = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.gUG != null) {
                    d.this.gUG.a(4, type, avVar, a);
                }
            }
        }
    };
    private CustomMessageListener gUb = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ill.getType();
                av avVar = new av();
                avVar.errCode = customResponsedMessage.getError();
                avVar.errMsg = customResponsedMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.isLocal = true;
                avVar.hasMore = false;
                avVar.pn = -1;
                if (type == 3) {
                    d.this.ikU = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ikX = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.ikS = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ikV = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.ikT = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ikW = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.gUG != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.gUG.a(4, type, avVar, a);
                }
                d.this.cn(type, 0);
            }
        }
    };

    public void cn(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.ebv != null) {
            frsGroupRequestMessage.setTag(this.ebv);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.ilk = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void vy(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.ebv != null) {
            frsGroupReadCacheRequestMessage.setTag(this.ebv);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ill = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wV(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        av avVar = new av();
        avVar.forumId = this.forumId;
        avVar.forumName = this.forumName;
        avVar.hcv = false;
        avVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.ikS;
            list = this.ikV;
            avVar.pn = this.ikY;
            avVar.hasMore = this.ile;
        } else if (i == 2) {
            groupPermData = this.ikT;
            list = this.ikW;
            avVar.pn = this.ikZ;
            avVar.hasMore = this.ilf;
        } else if (i == 3) {
            groupPermData = this.ikU;
            list = this.ikX;
            avVar.pn = this.ila;
            avVar.hasMore = this.ilg;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.gUG != null) {
                this.gUG.a(4, i, avVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.ikV = a(z, this.ikV, list);
            this.ikS = groupPermData;
            return a(this.ikS, this.ikV, i);
        } else if (i == 3) {
            this.ikU = groupPermData;
            this.ikX = a(z, this.ikX, list);
            return a(this.ikU, this.ikX, i);
        } else {
            this.ikT = groupPermData;
            this.ikW = a(z, this.ikW, list);
            return a(this.ikT, this.ikW, i);
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
        this.ilm.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.ilm.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.dzd + 3);
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
            return this.ilh;
        }
        if (i == 2) {
            return this.ili;
        }
        if (i == 3) {
            return this.ilj;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.gUG != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.EN(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.EM(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.wY(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new p());
            } else {
                hVar.EN(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.EM(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.EL(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
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
            avVar.hcv = false;
            avVar.pn = -1;
            this.gUG.a(4, this.dzd, avVar, arrayList);
        }
    }

    private boolean wX(int i) {
        if (i == 1) {
            return this.ile;
        }
        if (i == 2) {
            return this.ilf;
        }
        if (i == 3) {
            return this.ilg;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        int i3;
        if (i == 4 && asVar != null) {
            this.forumId = asVar.forumId;
            this.forumName = asVar.forumName;
            this.dzd = i2;
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
                    i3 = this.ikY;
                } else if (i2 == 2) {
                    i3 = this.ikZ;
                } else {
                    i3 = i2 == 3 ? this.ila : 0;
                }
                int a = a(i2, this.rn, i3, asVar);
                if (a < 0) {
                    wV(i2);
                } else if (a == 0) {
                    this.etK = true;
                    cn(i2, 0);
                } else if (wX(i2)) {
                    this.etK = false;
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
                this.ilb = 0;
                this.ikY = 1;
                return 0;
            } else if (i == 2) {
                this.ilc = 0;
                this.ikZ = 1;
                return 0;
            } else if (i == 3) {
                this.ild = 0;
                this.ila = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (asVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ilb += i2;
                int i4 = this.ilb;
                this.ikY = asVar.pn;
                return i4;
            } else if (i == 2) {
                this.ilc += i2;
                int i5 = this.ilc;
                this.ikZ = asVar.pn;
                return i5;
            } else if (i == 3) {
                this.ild += i2;
                int i6 = this.ild;
                this.ila = asVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.gUG = aoVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.ebv != null) {
            this.iln.setTag(this.ebv);
            this.iln.setSelfListener(true);
            this.gUb.setTag(this.ebv);
            this.gUb.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iln);
        MessageManager.getInstance().registerListener(this.gUb);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.ebv = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void bqt() {
        MessageManager.getInstance().unRegisterListener(this.iln);
        MessageManager.getInstance().unRegisterListener(this.gUb);
    }
}
