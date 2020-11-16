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
/* loaded from: classes22.dex */
public class d implements ar {
    private String forumId;
    private String forumName;
    private BdUniqueId fsa;
    private av iEg;
    private GroupPermData kfw;
    private GroupPermData kfx;
    private GroupPermData kfy;
    private int rn;
    private List<GroupInfoData> kfz = new ArrayList();
    private List<GroupInfoData> kfA = new ArrayList();
    private List<GroupInfoData> kfB = new ArrayList();
    private int kfC = 0;
    private int kfD = 0;
    private int kfE = 0;
    private int kfF = 0;
    private int kfG = 0;
    private int kfH = 0;
    private boolean kfI = false;
    private boolean kfJ = false;
    private boolean kfK = false;
    private boolean kfL = true;
    private boolean kfM = true;
    private boolean kfN = true;
    private FrsGroupRequestMessage kfO = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage kfP = new FrsGroupReadCacheRequestMessage();
    private boolean fNx = true;
    private int eLQ = 1;
    private Set<Long> kfQ = new HashSet();
    private com.baidu.adp.framework.listener.c kfR = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.kfO.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.Dp(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.kfO.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a2 = d.this.a(d.this.fNx, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bdVar.iNb = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.kfE;
                    d.this.kfK = z;
                    d.this.kfy = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfN = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.kfC;
                    d.this.kfI = z;
                    d.this.kfw = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfL = false;
                } else {
                    bdVar.pn = d.this.kfD;
                    d.this.kfJ = z;
                    d.this.kfx = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfM = false;
                }
                if (a2 == null || a2.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.iEg != null) {
                    d.this.iEg.a(4, type, bdVar, a2);
                }
            }
        }
    };
    private CustomMessageListener iDD = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a2;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.kfP.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.kfy = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.kfB = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.kfw = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.kfz = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.kfx = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.kfA = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.iEg != null && (a2 = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a2.size() > 0) {
                    d.this.iEg.a(4, type, bdVar, a2);
                }
                d.this.cQ(type, 0);
            }
        }
    };

    public void cQ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.fsa != null) {
            frsGroupRequestMessage.setTag(this.fsa);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.kfO = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void BG(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.fsa != null) {
            frsGroupReadCacheRequestMessage.setTag(this.fsa);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.kfP = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void Dp(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.iNb = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.kfw;
            list = this.kfz;
            bdVar.pn = this.kfC;
            bdVar.hasMore = this.kfI;
        } else if (i == 2) {
            groupPermData = this.kfx;
            list = this.kfA;
            bdVar.pn = this.kfD;
            bdVar.hasMore = this.kfJ;
        } else if (i == 3) {
            groupPermData = this.kfy;
            list = this.kfB;
            bdVar.pn = this.kfE;
            bdVar.hasMore = this.kfK;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a2 = a(groupPermData, list, i);
        if (a2 != null && a2.size() > 0) {
            if (this.iEg != null) {
                this.iEg.a(4, i, bdVar, a2);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.kfz = a(z, this.kfz, list);
            this.kfw = groupPermData;
            return a(this.kfw, this.kfz, i);
        } else if (i == 3) {
            this.kfy = groupPermData;
            this.kfB = a(z, this.kfB, list);
            return a(this.kfy, this.kfB, i);
        } else {
            this.kfx = groupPermData;
            this.kfA = a(z, this.kfA, list);
            return a(this.kfx, this.kfA, i);
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
        this.kfQ.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.kfQ.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eLQ + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cR((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.CAM_X0201));
        }
        return arrayList;
    }

    private n cR(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.yZ(i2);
        return nVar;
    }

    private boolean Dq(int i) {
        if (i == 1) {
            return this.kfL;
        }
        if (i == 2) {
            return this.kfM;
        }
        if (i == 3) {
            return this.kfN;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.iEg != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Mq(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Mp(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.Ds(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.Mq(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Mp(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Mo(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.Ds(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.iNb = false;
            bdVar.pn = -1;
            this.iEg.a(4, this.eLQ, bdVar, arrayList);
        }
    }

    private boolean Dr(int i) {
        if (i == 1) {
            return this.kfI;
        }
        if (i == 2) {
            return this.kfJ;
        }
        if (i == 3) {
            return this.kfK;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.eLQ = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (Dq(i2)) {
                BG(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.kfC;
                } else if (i2 == 2) {
                    i3 = this.kfD;
                } else {
                    i3 = i2 == 3 ? this.kfE : 0;
                }
                int a2 = a(i2, this.rn, i3, baVar);
                if (a2 < 0) {
                    Dp(i2);
                } else if (a2 == 0) {
                    this.fNx = true;
                    cQ(i2, 0);
                } else if (Dr(i2)) {
                    this.fNx = false;
                    cQ(i2, a2);
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
                this.kfF = 0;
                this.kfC = 1;
                return 0;
            } else if (i == 2) {
                this.kfG = 0;
                this.kfD = 1;
                return 0;
            } else if (i == 3) {
                this.kfH = 0;
                this.kfE = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.kfF += i2;
                int i4 = this.kfF;
                this.kfC = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.kfG += i2;
                int i5 = this.kfG;
                this.kfD = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.kfH += i2;
                int i6 = this.kfH;
                this.kfE = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.iEg = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.fsa != null) {
            this.kfR.setTag(this.fsa);
            this.kfR.setSelfListener(true);
            this.iDD.setTag(this.fsa);
            this.iDD.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.kfR);
        MessageManager.getInstance().registerListener(this.iDD);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fsa = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bVo() {
        MessageManager.getInstance().unRegisterListener(this.kfR);
        MessageManager.getInstance().unRegisterListener(this.iDD);
    }
}
