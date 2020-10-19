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
    private BdUniqueId fey;
    private String forumId;
    private String forumName;
    private av ikX;
    private GroupPermData jMq;
    private GroupPermData jMr;
    private GroupPermData jMs;
    private int rn;
    private List<GroupInfoData> jMt = new ArrayList();
    private List<GroupInfoData> jMu = new ArrayList();
    private List<GroupInfoData> jMv = new ArrayList();
    private int jMw = 0;
    private int jMx = 0;
    private int jMy = 0;
    private int jMz = 0;
    private int jMA = 0;
    private int jMB = 0;
    private boolean jMC = false;
    private boolean jMD = false;
    private boolean jME = false;
    private boolean jMF = true;
    private boolean jMG = true;
    private boolean jMH = true;
    private FrsGroupRequestMessage jMI = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jMJ = new FrsGroupReadCacheRequestMessage();
    private boolean fzJ = true;
    private int eyG = 1;
    private Set<Long> jMK = new HashSet();
    private com.baidu.adp.framework.listener.c jML = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jMI.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.Cl(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jMI.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a2 = d.this.a(d.this.fzJ, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bdVar.itV = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.jMy;
                    d.this.jME = z;
                    d.this.jMs = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jMH = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.jMw;
                    d.this.jMC = z;
                    d.this.jMq = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jMF = false;
                } else {
                    bdVar.pn = d.this.jMx;
                    d.this.jMD = z;
                    d.this.jMr = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jMG = false;
                }
                if (a2 == null || a2.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.ikX != null) {
                    d.this.ikX.a(4, type, bdVar, a2);
                }
            }
        }
    };
    private CustomMessageListener ikt = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a2;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jMJ.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.jMs = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jMv = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.jMq = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jMt = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.jMr = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jMu = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.ikX != null && (a2 = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a2.size() > 0) {
                    d.this.ikX.a(4, type, bdVar, a2);
                }
                d.this.cM(type, 0);
            }
        }
    };

    public void cM(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.fey != null) {
            frsGroupRequestMessage.setTag(this.fey);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jMI = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void AC(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.fey != null) {
            frsGroupReadCacheRequestMessage.setTag(this.fey);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jMJ = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void Cl(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.itV = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.jMq;
            list = this.jMt;
            bdVar.pn = this.jMw;
            bdVar.hasMore = this.jMC;
        } else if (i == 2) {
            groupPermData = this.jMr;
            list = this.jMu;
            bdVar.pn = this.jMx;
            bdVar.hasMore = this.jMD;
        } else if (i == 3) {
            groupPermData = this.jMs;
            list = this.jMv;
            bdVar.pn = this.jMy;
            bdVar.hasMore = this.jME;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a2 = a(groupPermData, list, i);
        if (a2 != null && a2.size() > 0) {
            if (this.ikX != null) {
                this.ikX.a(4, i, bdVar, a2);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.jMt = a(z, this.jMt, list);
            this.jMq = groupPermData;
            return a(this.jMq, this.jMt, i);
        } else if (i == 3) {
            this.jMs = groupPermData;
            this.jMv = a(z, this.jMv, list);
            return a(this.jMs, this.jMv, i);
        } else {
            this.jMr = groupPermData;
            this.jMu = a(z, this.jMu, list);
            return a(this.jMr, this.jMu, i);
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
        this.jMK.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jMK.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eyG + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cN((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private n cN(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.xV(i2);
        return nVar;
    }

    private boolean Cm(int i) {
        if (i == 1) {
            return this.jMF;
        }
        if (i == 2) {
            return this.jMG;
        }
        if (i == 3) {
            return this.jMH;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.ikX != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Ma(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.LZ(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.Co(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.Ma(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.LZ(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.LY(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.Co(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cN(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.itV = false;
            bdVar.pn = -1;
            this.ikX.a(4, this.eyG, bdVar, arrayList);
        }
    }

    private boolean Cn(int i) {
        if (i == 1) {
            return this.jMC;
        }
        if (i == 2) {
            return this.jMD;
        }
        if (i == 3) {
            return this.jME;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.eyG = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (Cm(i2)) {
                AC(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.jMw;
                } else if (i2 == 2) {
                    i3 = this.jMx;
                } else {
                    i3 = i2 == 3 ? this.jMy : 0;
                }
                int a2 = a(i2, this.rn, i3, baVar);
                if (a2 < 0) {
                    Cl(i2);
                } else if (a2 == 0) {
                    this.fzJ = true;
                    cM(i2, 0);
                } else if (Cn(i2)) {
                    this.fzJ = false;
                    cM(i2, a2);
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
                this.jMz = 0;
                this.jMw = 1;
                return 0;
            } else if (i == 2) {
                this.jMA = 0;
                this.jMx = 1;
                return 0;
            } else if (i == 3) {
                this.jMB = 0;
                this.jMy = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.jMz += i2;
                int i4 = this.jMz;
                this.jMw = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.jMA += i2;
                int i5 = this.jMA;
                this.jMx = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.jMB += i2;
                int i6 = this.jMB;
                this.jMy = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.ikX = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.fey != null) {
            this.jML.setTag(this.fey);
            this.jML.setSelfListener(true);
            this.ikt.setTag(this.fey);
            this.ikt.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jML);
        MessageManager.getInstance().registerListener(this.ikt);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fey = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bQq() {
        MessageManager.getInstance().unRegisterListener(this.jML);
        MessageManager.getInstance().unRegisterListener(this.ikt);
    }
}
