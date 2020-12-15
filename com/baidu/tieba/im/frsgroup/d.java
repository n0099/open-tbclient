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
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.au;
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
public class d implements aq {
    private String forumId;
    private String forumName;
    private BdUniqueId fzO;
    private au iPa;
    private GroupPermData ksW;
    private GroupPermData ksX;
    private GroupPermData ksY;
    private int rn;
    private List<GroupInfoData> ksZ = new ArrayList();
    private List<GroupInfoData> kta = new ArrayList();
    private List<GroupInfoData> ktb = new ArrayList();
    private int ktc = 0;
    private int ktd = 0;
    private int kte = 0;
    private int ktf = 0;
    private int ktg = 0;
    private int kth = 0;
    private boolean kti = false;
    private boolean ktj = false;
    private boolean ktk = false;
    private boolean ktl = true;
    private boolean ktm = true;
    private boolean ktn = true;
    private FrsGroupRequestMessage kto = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage ktp = new FrsGroupReadCacheRequestMessage();
    private boolean fVi = true;
    private int eTc = 1;
    private Set<Long> ktq = new HashSet();
    private com.baidu.adp.framework.listener.c ktr = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.kto.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.Ee(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.kto.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a2 = d.this.a(d.this.fVi, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bdVar.iXU = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.kte;
                    d.this.ktk = z;
                    d.this.ksY = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ktn = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.ktc;
                    d.this.kti = z;
                    d.this.ksW = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ktl = false;
                } else {
                    bdVar.pn = d.this.ktd;
                    d.this.ktj = z;
                    d.this.ksX = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.ktm = false;
                }
                if (a2 == null || a2.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.iPa != null) {
                    d.this.iPa.a(4, type, bdVar, a2);
                }
            }
        }
    };
    private CustomMessageListener iOx = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a2;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.ktp.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.ksY = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ktb = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.ksW = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.ksZ = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.ksX = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.kta = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.iPa != null && (a2 = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a2.size() > 0) {
                    d.this.iPa.a(4, type, bdVar, a2);
                }
                d.this.cV(type, 0);
            }
        }
    };

    public void cV(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.fzO != null) {
            frsGroupRequestMessage.setTag(this.fzO);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.kto = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void Cv(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.fzO != null) {
            frsGroupReadCacheRequestMessage.setTag(this.fzO);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.ktp = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void Ee(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.iXU = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.ksW;
            list = this.ksZ;
            bdVar.pn = this.ktc;
            bdVar.hasMore = this.kti;
        } else if (i == 2) {
            groupPermData = this.ksX;
            list = this.kta;
            bdVar.pn = this.ktd;
            bdVar.hasMore = this.ktj;
        } else if (i == 3) {
            groupPermData = this.ksY;
            list = this.ktb;
            bdVar.pn = this.kte;
            bdVar.hasMore = this.ktk;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a2 = a(groupPermData, list, i);
        if (a2 != null && a2.size() > 0) {
            if (this.iPa != null) {
                this.iPa.a(4, i, bdVar, a2);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.ksZ = a(z, this.ksZ, list);
            this.ksW = groupPermData;
            return a(this.ksW, this.ksZ, i);
        } else if (i == 3) {
            this.ksY = groupPermData;
            this.ktb = a(z, this.ktb, list);
            return a(this.ksY, this.ktb, i);
        } else {
            this.ksX = groupPermData;
            this.kta = a(z, this.kta, list);
            return a(this.ksX, this.kta, i);
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
        this.ktq.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.ktq.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eTc + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cW((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.CAM_X0201));
        }
        return arrayList;
    }

    private n cW(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.zE(i2);
        return nVar;
    }

    private boolean Ef(int i) {
        if (i == 1) {
            return this.ktl;
        }
        if (i == 2) {
            return this.ktm;
        }
        if (i == 3) {
            return this.ktn;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.iPa != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Ny(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Nx(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.Eh(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.Ny(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Nx(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Nw(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.Eh(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cW(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.iXU = false;
            bdVar.pn = -1;
            this.iPa.a(4, this.eTc, bdVar, arrayList);
        }
    }

    private boolean Eg(int i) {
        if (i == 1) {
            return this.kti;
        }
        if (i == 2) {
            return this.ktj;
        }
        if (i == 3) {
            return this.ktk;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.eTc = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (Ef(i2)) {
                Cv(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.ktc;
                } else if (i2 == 2) {
                    i3 = this.ktd;
                } else {
                    i3 = i2 == 3 ? this.kte : 0;
                }
                int a2 = a(i2, this.rn, i3, baVar);
                if (a2 < 0) {
                    Ee(i2);
                } else if (a2 == 0) {
                    this.fVi = true;
                    cV(i2, 0);
                } else if (Eg(i2)) {
                    this.fVi = false;
                    cV(i2, a2);
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
                this.ktf = 0;
                this.ktc = 1;
                return 0;
            } else if (i == 2) {
                this.ktg = 0;
                this.ktd = 1;
                return 0;
            } else if (i == 3) {
                this.kth = 0;
                this.kte = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.ktf += i2;
                int i4 = this.ktf;
                this.ktc = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.ktg += i2;
                int i5 = this.ktg;
                this.ktd = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.kth += i2;
                int i6 = this.kth;
                this.kte = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void a(au auVar) {
        this.iPa = auVar;
    }

    @Override // com.baidu.tieba.frs.aq
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.fzO != null) {
            this.ktr.setTag(this.fzO);
            this.ktr.setSelfListener(true);
            this.iOx.setTag(this.fzO);
            this.iOx.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.ktr);
        MessageManager.getInstance().registerListener(this.iOx);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fzO = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.aq
    public void bYZ() {
        MessageManager.getInstance().unRegisterListener(this.ktr);
        MessageManager.getInstance().unRegisterListener(this.iOx);
    }
}
