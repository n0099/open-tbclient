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
/* loaded from: classes23.dex */
public class d implements ar {
    private BdUniqueId fmX;
    private String forumId;
    private String forumName;
    private av ixv;
    private GroupPermData jYO;
    private GroupPermData jYP;
    private GroupPermData jYQ;
    private int rn;
    private List<GroupInfoData> jYR = new ArrayList();
    private List<GroupInfoData> jYS = new ArrayList();
    private List<GroupInfoData> jYT = new ArrayList();
    private int jYU = 0;
    private int jYV = 0;
    private int jYW = 0;
    private int jYX = 0;
    private int jYY = 0;
    private int jYZ = 0;
    private boolean jZa = false;
    private boolean jZb = false;
    private boolean jZc = false;
    private boolean jZd = true;
    private boolean jZe = true;
    private boolean jZf = true;
    private FrsGroupRequestMessage jZg = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jZh = new FrsGroupReadCacheRequestMessage();
    private boolean fIe = true;
    private int eHc = 1;
    private Set<Long> jZi = new HashSet();
    private com.baidu.adp.framework.listener.c jZj = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jZg.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.CE(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jZg.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a2 = d.this.a(d.this.fIe, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a2 == null || a2.size() <= 0) {
                    bdVar.hasMore = false;
                    z = false;
                } else {
                    bdVar.hasMore = z;
                }
                bdVar.errCode = frsGroupSocketResponseMessage.getError();
                bdVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.iGr = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.jYW;
                    d.this.jZc = z;
                    d.this.jYQ = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jZf = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.jYU;
                    d.this.jZa = z;
                    d.this.jYO = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jZd = false;
                } else {
                    bdVar.pn = d.this.jYV;
                    d.this.jZb = z;
                    d.this.jYP = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jZe = false;
                }
                if (a2 == null || a2.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.ixv != null) {
                    d.this.ixv.a(4, type, bdVar, a2);
                }
            }
        }
    };
    private CustomMessageListener iwR = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a2;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jZh.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.jYQ = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jYT = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.jYO = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jYR = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.jYP = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jYS = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.ixv != null && (a2 = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a2.size() > 0) {
                    d.this.ixv.a(4, type, bdVar, a2);
                }
                d.this.cO(type, 0);
            }
        }
    };

    public void cO(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.fmX != null) {
            frsGroupRequestMessage.setTag(this.fmX);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jZg = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void AV(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.fmX != null) {
            frsGroupReadCacheRequestMessage.setTag(this.fmX);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jZh = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void CE(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.iGr = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.jYO;
            list = this.jYR;
            bdVar.pn = this.jYU;
            bdVar.hasMore = this.jZa;
        } else if (i == 2) {
            groupPermData = this.jYP;
            list = this.jYS;
            bdVar.pn = this.jYV;
            bdVar.hasMore = this.jZb;
        } else if (i == 3) {
            groupPermData = this.jYQ;
            list = this.jYT;
            bdVar.pn = this.jYW;
            bdVar.hasMore = this.jZc;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a2 = a(groupPermData, list, i);
        if (a2 != null && a2.size() > 0) {
            if (this.ixv != null) {
                this.ixv.a(4, i, bdVar, a2);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.jYR = a(z, this.jYR, list);
            this.jYO = groupPermData;
            return a(this.jYO, this.jYR, i);
        } else if (i == 3) {
            this.jYQ = groupPermData;
            this.jYT = a(z, this.jYT, list);
            return a(this.jYQ, this.jYT, i);
        } else {
            this.jYP = groupPermData;
            this.jYS = a(z, this.jYS, list);
            return a(this.jYP, this.jYS, i);
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
        this.jZi.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jZi.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eHc + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cP((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private n cP(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.yo(i2);
        return nVar;
    }

    private boolean CF(int i) {
        if (i == 1) {
            return this.jZd;
        }
        if (i == 2) {
            return this.jZe;
        }
        if (i == 3) {
            return this.jZf;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.ixv != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.My(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Mx(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.CH(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.My(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Mx(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Mw(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.CH(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cP(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.iGr = false;
            bdVar.pn = -1;
            this.ixv.a(4, this.eHc, bdVar, arrayList);
        }
    }

    private boolean CG(int i) {
        if (i == 1) {
            return this.jZa;
        }
        if (i == 2) {
            return this.jZb;
        }
        if (i == 3) {
            return this.jZc;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.eHc = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (CF(i2)) {
                AV(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.jYU;
                } else if (i2 == 2) {
                    i3 = this.jYV;
                } else {
                    i3 = i2 == 3 ? this.jYW : 0;
                }
                int a2 = a(i2, this.rn, i3, baVar);
                if (a2 < 0) {
                    CE(i2);
                } else if (a2 == 0) {
                    this.fIe = true;
                    cO(i2, 0);
                } else if (CG(i2)) {
                    this.fIe = false;
                    cO(i2, a2);
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
                this.jYX = 0;
                this.jYU = 1;
                return 0;
            } else if (i == 2) {
                this.jYY = 0;
                this.jYV = 1;
                return 0;
            } else if (i == 3) {
                this.jYZ = 0;
                this.jYW = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.jYX += i2;
                int i4 = this.jYX;
                this.jYU = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.jYY += i2;
                int i5 = this.jYY;
                this.jYV = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.jYZ += i2;
                int i6 = this.jYZ;
                this.jYW = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.ixv = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.fmX != null) {
            this.jZj.setTag(this.fmX);
            this.jZj.setSelfListener(true);
            this.iwR.setTag(this.fmX);
            this.iwR.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jZj);
        MessageManager.getInstance().registerListener(this.iwR);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fmX = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTn() {
        MessageManager.getInstance().unRegisterListener(this.jZj);
        MessageManager.getInstance().unRegisterListener(this.iwR);
    }
}
