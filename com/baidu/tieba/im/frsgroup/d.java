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
    private String forumId;
    private String forumName;
    private BdUniqueId fsQ;
    private av iDs;
    private GroupPermData keM;
    private GroupPermData keN;
    private GroupPermData keO;
    private int rn;
    private List<GroupInfoData> keP = new ArrayList();
    private List<GroupInfoData> keQ = new ArrayList();
    private List<GroupInfoData> keR = new ArrayList();
    private int keS = 0;
    private int keT = 0;
    private int keU = 0;
    private int keV = 0;
    private int keW = 0;
    private int keX = 0;
    private boolean keY = false;
    private boolean keZ = false;
    private boolean kfa = false;
    private boolean kfb = true;
    private boolean kfc = true;
    private boolean kfd = true;
    private FrsGroupRequestMessage kfe = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage kff = new FrsGroupReadCacheRequestMessage();
    private boolean fNU = true;
    private int eMR = 1;
    private Set<Long> kfg = new HashSet();
    private com.baidu.adp.framework.listener.c kfh = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.kfe.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.CR(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.kfe.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a2 = d.this.a(d.this.fNU, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                bdVar.iMo = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.keU;
                    d.this.kfa = z;
                    d.this.keO = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfd = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.keS;
                    d.this.keY = z;
                    d.this.keM = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfb = false;
                } else {
                    bdVar.pn = d.this.keT;
                    d.this.keZ = z;
                    d.this.keN = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.kfc = false;
                }
                if (a2 == null || a2.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.iDs != null) {
                    d.this.iDs.a(4, type, bdVar, a2);
                }
            }
        }
    };
    private CustomMessageListener iCO = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a2;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.kff.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.keO = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.keR = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.keM = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.keP = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.keN = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.keQ = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.iDs != null && (a2 = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a2.size() > 0) {
                    d.this.iDs.a(4, type, bdVar, a2);
                }
                d.this.cQ(type, 0);
            }
        }
    };

    public void cQ(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.fsQ != null) {
            frsGroupRequestMessage.setTag(this.fsQ);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.kfe = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void Bi(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.fsQ != null) {
            frsGroupReadCacheRequestMessage.setTag(this.fsQ);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.kff = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void CR(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.iMo = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.keM;
            list = this.keP;
            bdVar.pn = this.keS;
            bdVar.hasMore = this.keY;
        } else if (i == 2) {
            groupPermData = this.keN;
            list = this.keQ;
            bdVar.pn = this.keT;
            bdVar.hasMore = this.keZ;
        } else if (i == 3) {
            groupPermData = this.keO;
            list = this.keR;
            bdVar.pn = this.keU;
            bdVar.hasMore = this.kfa;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a2 = a(groupPermData, list, i);
        if (a2 != null && a2.size() > 0) {
            if (this.iDs != null) {
                this.iDs.a(4, i, bdVar, a2);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.keP = a(z, this.keP, list);
            this.keM = groupPermData;
            return a(this.keM, this.keP, i);
        } else if (i == 3) {
            this.keO = groupPermData;
            this.keR = a(z, this.keR, list);
            return a(this.keO, this.keR, i);
        } else {
            this.keN = groupPermData;
            this.keQ = a(z, this.keQ, list);
            return a(this.keN, this.keQ, i);
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
        this.kfg.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.kfg.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.eMR + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(cR((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private n cR(int i, int i2) {
        n nVar = new n();
        nVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        nVar.yB(i2);
        return nVar;
    }

    private boolean CS(int i) {
        if (i == 1) {
            return this.kfb;
        }
        if (i == 2) {
            return this.kfc;
        }
        if (i == 3) {
            return this.kfd;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.iDs != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.MP(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.MO(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.CU(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.MP(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.MO(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.MN(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.CU(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cR(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.iMo = false;
            bdVar.pn = -1;
            this.iDs.a(4, this.eMR, bdVar, arrayList);
        }
    }

    private boolean CT(int i) {
        if (i == 1) {
            return this.keY;
        }
        if (i == 2) {
            return this.keZ;
        }
        if (i == 3) {
            return this.kfa;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.eMR = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (CS(i2)) {
                Bi(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.keS;
                } else if (i2 == 2) {
                    i3 = this.keT;
                } else {
                    i3 = i2 == 3 ? this.keU : 0;
                }
                int a2 = a(i2, this.rn, i3, baVar);
                if (a2 < 0) {
                    CR(i2);
                } else if (a2 == 0) {
                    this.fNU = true;
                    cQ(i2, 0);
                } else if (CT(i2)) {
                    this.fNU = false;
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
                this.keV = 0;
                this.keS = 1;
                return 0;
            } else if (i == 2) {
                this.keW = 0;
                this.keT = 1;
                return 0;
            } else if (i == 3) {
                this.keX = 0;
                this.keU = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.keV += i2;
                int i4 = this.keV;
                this.keS = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.keW += i2;
                int i5 = this.keW;
                this.keT = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.keX += i2;
                int i6 = this.keX;
                this.keU = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.iDs = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.fsQ != null) {
            this.kfh.setTag(this.fsQ);
            this.kfh.setSelfListener(true);
            this.iCO.setTag(this.fsQ);
            this.iCO.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.kfh);
        MessageManager.getInstance().registerListener(this.iCO);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fsQ = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bVV() {
        MessageManager.getInstance().unRegisterListener(this.kfh);
        MessageManager.getInstance().unRegisterListener(this.iCO);
    }
}
