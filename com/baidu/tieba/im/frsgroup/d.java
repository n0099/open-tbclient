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
    private BdUniqueId eSq;
    private String forumId;
    private String forumName;
    private av hVY;
    private GroupPermData jxt;
    private GroupPermData jxu;
    private GroupPermData jxv;
    private int rn;
    private List<GroupInfoData> jxw = new ArrayList();
    private List<GroupInfoData> jxx = new ArrayList();
    private List<GroupInfoData> jxy = new ArrayList();
    private int jxz = 0;
    private int jxA = 0;
    private int jxB = 0;
    private int jxC = 0;
    private int jxD = 0;
    private int jxE = 0;
    private boolean jxF = false;
    private boolean jxG = false;
    private boolean jxH = false;
    private boolean jxI = true;
    private boolean jxJ = true;
    private boolean jxK = true;
    private FrsGroupRequestMessage jxL = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage jxM = new FrsGroupReadCacheRequestMessage();
    private boolean fnv = true;
    private int emv = 1;
    private Set<Long> jxN = new HashSet();
    private com.baidu.adp.framework.listener.c jxO = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.jxL.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.BF(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.jxL.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                bd bdVar = new bd();
                ArrayList<q> a = d.this.a(d.this.fnv, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    bdVar.hasMore = false;
                    z = false;
                } else {
                    bdVar.hasMore = z;
                }
                bdVar.errCode = frsGroupSocketResponseMessage.getError();
                bdVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.ieY = false;
                bdVar.isLocal = false;
                if (type == 3) {
                    bdVar.pn = d.this.jxB;
                    d.this.jxH = z;
                    d.this.jxv = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jxK = false;
                } else if (type == 1) {
                    bdVar.pn = d.this.jxz;
                    d.this.jxF = z;
                    d.this.jxt = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jxI = false;
                } else {
                    bdVar.pn = d.this.jxA;
                    d.this.jxG = z;
                    d.this.jxu = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.jxJ = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hVY != null) {
                    d.this.hVY.a(4, type, bdVar, a);
                }
            }
        }
    };
    private CustomMessageListener hVu = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<q> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.jxM.getType();
                bd bdVar = new bd();
                bdVar.errCode = customResponsedMessage.getError();
                bdVar.errMsg = customResponsedMessage.getErrorString();
                bdVar.forumId = d.this.forumId;
                bdVar.forumName = d.this.forumName;
                bdVar.isLocal = true;
                bdVar.hasMore = false;
                bdVar.pn = -1;
                if (type == 3) {
                    d.this.jxv = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jxy = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.jxt = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jxw = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.jxu = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.jxx = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hVY != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hVY.a(4, type, bdVar, a);
                }
                d.this.cM(type, 0);
            }
        }
    };

    public void cM(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.eSq != null) {
            frsGroupRequestMessage.setTag(this.eSq);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.jxL = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void zW(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.eSq != null) {
            frsGroupReadCacheRequestMessage.setTag(this.eSq);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.jxM = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void BF(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        bd bdVar = new bd();
        bdVar.forumId = this.forumId;
        bdVar.forumName = this.forumName;
        bdVar.ieY = false;
        bdVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.jxt;
            list = this.jxw;
            bdVar.pn = this.jxz;
            bdVar.hasMore = this.jxF;
        } else if (i == 2) {
            groupPermData = this.jxu;
            list = this.jxx;
            bdVar.pn = this.jxA;
            bdVar.hasMore = this.jxG;
        } else if (i == 3) {
            groupPermData = this.jxv;
            list = this.jxy;
            bdVar.pn = this.jxB;
            bdVar.hasMore = this.jxH;
        } else {
            groupPermData = null;
        }
        ArrayList<q> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hVY != null) {
                this.hVY.a(4, i, bdVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<q> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.jxw = a(z, this.jxw, list);
            this.jxt = groupPermData;
            return a(this.jxt, this.jxw, i);
        } else if (i == 3) {
            this.jxv = groupPermData;
            this.jxy = a(z, this.jxy, list);
            return a(this.jxv, this.jxy, i);
        } else {
            this.jxu = groupPermData;
            this.jxx = a(z, this.jxx, list);
            return a(this.jxu, this.jxx, i);
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
        this.jxN.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.jxN.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.emv + 3);
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
        nVar.xp(i2);
        return nVar;
    }

    private boolean BG(int i) {
        if (i == 1) {
            return this.jxI;
        }
        if (i == 2) {
            return this.jxJ;
        }
        if (i == 3) {
            return this.jxK;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hVY != null) {
            ArrayList<q> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Ll(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Lk(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.BI(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new s());
            } else {
                hVar.Ll(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Lk(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Lj(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.BI(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(cN(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            bd bdVar = new bd();
            bdVar.errCode = 0;
            bdVar.forumId = this.forumId;
            bdVar.forumName = this.forumName;
            bdVar.hasMore = false;
            bdVar.ieY = false;
            bdVar.pn = -1;
            this.hVY.a(4, this.emv, bdVar, arrayList);
        }
    }

    private boolean BH(int i) {
        if (i == 1) {
            return this.jxF;
        }
        if (i == 2) {
            return this.jxG;
        }
        if (i == 3) {
            return this.jxH;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        int i3;
        if (i == 4 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            this.emv = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (BG(i2)) {
                zW(i2);
            } else {
                if (baVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.jxz;
                } else if (i2 == 2) {
                    i3 = this.jxA;
                } else {
                    i3 = i2 == 3 ? this.jxB : 0;
                }
                int a = a(i2, this.rn, i3, baVar);
                if (a < 0) {
                    BF(i2);
                } else if (a == 0) {
                    this.fnv = true;
                    cM(i2, 0);
                } else if (BH(i2)) {
                    this.fnv = false;
                    cM(i2, a);
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
                this.jxC = 0;
                this.jxz = 1;
                return 0;
            } else if (i == 2) {
                this.jxD = 0;
                this.jxA = 1;
                return 0;
            } else if (i == 3) {
                this.jxE = 0;
                this.jxB = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (baVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.jxC += i2;
                int i4 = this.jxC;
                this.jxz = baVar.pn;
                return i4;
            } else if (i == 2) {
                this.jxD += i2;
                int i5 = this.jxD;
                this.jxA = baVar.pn;
                return i5;
            } else if (i == 3) {
                this.jxE += i2;
                int i6 = this.jxE;
                this.jxB = baVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.hVY = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.eSq != null) {
            this.jxO.setTag(this.eSq);
            this.jxO.setSelfListener(true);
            this.hVu.setTag(this.eSq);
            this.hVu.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.jxO);
        MessageManager.getInstance().registerListener(this.hVu);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eSq = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void bMZ() {
        MessageManager.getInstance().unRegisterListener(this.jxO);
        MessageManager.getInstance().unRegisterListener(this.hVu);
    }
}
