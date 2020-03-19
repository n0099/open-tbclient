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
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes10.dex */
public class d implements ah {
    private BdUniqueId dBK;
    private String forumId;
    private String forumName;
    private ak glA;
    private GroupPermData hBe;
    private GroupPermData hBf;
    private GroupPermData hBg;
    private int rn;
    private List<GroupInfoData> hBh = new ArrayList();
    private List<GroupInfoData> hBi = new ArrayList();
    private List<GroupInfoData> hBj = new ArrayList();
    private int hBk = 0;
    private int hBl = 0;
    private int hBm = 0;
    private int hBn = 0;
    private int hBo = 0;
    private int hBp = 0;
    private boolean hBq = false;
    private boolean hBr = false;
    private boolean hBs = false;
    private boolean hBt = true;
    private boolean hBu = true;
    private boolean hBv = true;
    private FrsGroupRequestMessage hBw = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage hBx = new FrsGroupReadCacheRequestMessage();
    private boolean dTL = true;
    private int cZP = 1;
    private Set<Long> hBy = new HashSet();
    private com.baidu.adp.framework.listener.c hBz = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.hBw.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.wx(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.hBw.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                ar arVar = new ar();
                ArrayList<com.baidu.adp.widget.ListView.m> a = d.this.a(d.this.dTL, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
                if (a == null || a.size() <= 0) {
                    arVar.hasMore = false;
                    z = false;
                } else {
                    arVar.hasMore = z;
                }
                arVar.errCode = frsGroupSocketResponseMessage.getError();
                arVar.errMsg = frsGroupSocketResponseMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.gtk = false;
                arVar.isLocal = false;
                if (type == 3) {
                    arVar.pn = d.this.hBm;
                    d.this.hBs = z;
                    d.this.hBg = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hBv = false;
                } else if (type == 1) {
                    arVar.pn = d.this.hBk;
                    d.this.hBq = z;
                    d.this.hBe = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hBt = false;
                } else {
                    arVar.pn = d.this.hBl;
                    d.this.hBr = z;
                    d.this.hBf = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.hBu = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.glA != null) {
                    d.this.glA.a(4, type, arVar, a);
                }
            }
        }
    };
    private CustomMessageListener gkU = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<com.baidu.adp.widget.ListView.m> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.hBx.getType();
                ar arVar = new ar();
                arVar.errCode = customResponsedMessage.getError();
                arVar.errMsg = customResponsedMessage.getErrorString();
                arVar.forumId = d.this.forumId;
                arVar.forumName = d.this.forumName;
                arVar.isLocal = true;
                arVar.hasMore = false;
                arVar.pn = -1;
                if (type == 3) {
                    d.this.hBg = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hBj = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.hBe = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hBh = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.hBf = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.hBi = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.glA != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.glA.a(4, type, arVar, a);
                }
                d.this.ch(type, 0);
            }
        }
    };

    public void ch(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.dBK != null) {
            frsGroupRequestMessage.setTag(this.dBK);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.hBw = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void va(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.dBK != null) {
            frsGroupReadCacheRequestMessage.setTag(this.dBK);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.hBx = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void wx(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        ar arVar = new ar();
        arVar.forumId = this.forumId;
        arVar.forumName = this.forumName;
        arVar.gtk = false;
        arVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.hBe;
            list = this.hBh;
            arVar.pn = this.hBk;
            arVar.hasMore = this.hBq;
        } else if (i == 2) {
            groupPermData = this.hBf;
            list = this.hBi;
            arVar.pn = this.hBl;
            arVar.hasMore = this.hBr;
        } else if (i == 3) {
            groupPermData = this.hBg;
            list = this.hBj;
            arVar.pn = this.hBm;
            arVar.hasMore = this.hBs;
        } else {
            groupPermData = null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.glA != null) {
                this.glA.a(4, i, arVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<com.baidu.adp.widget.ListView.m> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.hBh = a(z, this.hBh, list);
            this.hBe = groupPermData;
            return a(this.hBe, this.hBh, i);
        } else if (i == 3) {
            this.hBg = groupPermData;
            this.hBj = a(z, this.hBj, list);
            return a(this.hBg, this.hBj, i);
        } else {
            this.hBf = groupPermData;
            this.hBi = a(z, this.hBi, list);
            return a(this.hBf, this.hBi, i);
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
        this.hBy.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.hBy.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.cZP + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(ci((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.k ci(int i, int i2) {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        kVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        kVar.sD(i2);
        return kVar;
    }

    private boolean wy(int i) {
        if (i == 1) {
            return this.hBt;
        }
        if (i == 2) {
            return this.hBu;
        }
        if (i == 3) {
            return this.hBv;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.glA != null) {
            ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Df(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.wA(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new o());
            } else {
                hVar.Df(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.De(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Dd(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.wA(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ci(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            ar arVar = new ar();
            arVar.errCode = 0;
            arVar.forumId = this.forumId;
            arVar.forumName = this.forumName;
            arVar.hasMore = false;
            arVar.gtk = false;
            arVar.pn = -1;
            this.glA.a(4, this.cZP, arVar, arrayList);
        }
    }

    private boolean wz(int i) {
        if (i == 1) {
            return this.hBq;
        }
        if (i == 2) {
            return this.hBr;
        }
        if (i == 3) {
            return this.hBs;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(int i, int i2, ao aoVar) {
        int i3;
        if (i == 4 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            this.cZP = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (wy(i2)) {
                va(i2);
            } else {
                if (aoVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.hBk;
                } else if (i2 == 2) {
                    i3 = this.hBl;
                } else {
                    i3 = i2 == 3 ? this.hBm : 0;
                }
                int a = a(i2, this.rn, i3, aoVar);
                if (a < 0) {
                    wx(i2);
                } else if (a == 0) {
                    this.dTL = true;
                    ch(i2, 0);
                } else if (wz(i2)) {
                    this.dTL = false;
                    ch(i2, a);
                }
            }
        }
    }

    private int a(int i, int i2, int i3, ao aoVar) {
        if (aoVar == null) {
            return -1;
        }
        if (aoVar.pn == -1) {
            if (i == 1) {
                this.hBn = 0;
                this.hBk = 1;
                return 0;
            } else if (i == 2) {
                this.hBo = 0;
                this.hBl = 1;
                return 0;
            } else if (i == 3) {
                this.hBp = 0;
                this.hBm = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (aoVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.hBn += i2;
                int i4 = this.hBn;
                this.hBk = aoVar.pn;
                return i4;
            } else if (i == 2) {
                this.hBo += i2;
                int i5 = this.hBo;
                this.hBl = aoVar.pn;
                return i5;
            } else if (i == 3) {
                this.hBp += i2;
                int i6 = this.hBp;
                this.hBm = aoVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(ak akVar) {
        this.glA = akVar;
    }

    @Override // com.baidu.tieba.frs.ah
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.dBK != null) {
            this.hBz.setTag(this.dBK);
            this.hBz.setSelfListener(true);
            this.gkU.setTag(this.dBK);
            this.gkU.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.hBz);
        MessageManager.getInstance().registerListener(this.gkU);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBK = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void bhc() {
        MessageManager.getInstance().unRegisterListener(this.hBz);
        MessageManager.getInstance().unRegisterListener(this.gkU);
    }
}
