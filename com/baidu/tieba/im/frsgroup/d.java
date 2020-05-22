package com.baidu.tieba.im.frsgroup;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.o;
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
    private BdUniqueId epM;
    private String forumId;
    private String forumName;
    private ao hjy;
    private GroupPermData izG;
    private GroupPermData izH;
    private GroupPermData izI;
    private int rn;
    private List<GroupInfoData> izJ = new ArrayList();
    private List<GroupInfoData> izK = new ArrayList();
    private List<GroupInfoData> izL = new ArrayList();
    private int izM = 0;
    private int izN = 0;
    private int izO = 0;
    private int izP = 0;
    private int izQ = 0;
    private int izR = 0;
    private boolean izS = false;
    private boolean izT = false;
    private boolean izU = false;
    private boolean izV = true;
    private boolean izW = true;
    private boolean izX = true;
    private FrsGroupRequestMessage izY = new FrsGroupRequestMessage();
    private FrsGroupReadCacheRequestMessage izZ = new FrsGroupReadCacheRequestMessage();
    private boolean eIo = true;
    private int dNl = 1;
    private Set<Long> iAa = new HashSet();
    private com.baidu.adp.framework.listener.c iAb = new com.baidu.adp.framework.listener.c(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID) { // from class: com.baidu.tieba.im.frsgroup.d.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            if (socketResponsedMessage instanceof FrsGroupSocketResponseMessage) {
                FrsGroupSocketResponseMessage frsGroupSocketResponseMessage = (FrsGroupSocketResponseMessage) socketResponsedMessage;
                int type = d.this.izY.getType();
                if (socketResponsedMessage.getError() != 0) {
                    d.this.xB(type);
                    if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                        com.baidu.adp.lib.util.l.showToast(BdBaseApplication.getInst().getApp(), socketResponsedMessage.getErrorString());
                        return;
                    }
                    return;
                }
                boolean z = frsGroupSocketResponseMessage.getGroups() != null && frsGroupSocketResponseMessage.getGroups().size() >= d.this.izY.getRn();
                GroupPermData groupPerm = frsGroupSocketResponseMessage.getGroupPerm();
                if (groupPerm != null && groupPerm.getForumId() == null) {
                    groupPerm.setForumId(d.this.forumId);
                }
                av avVar = new av();
                ArrayList<o> a = d.this.a(d.this.eIo, type, frsGroupSocketResponseMessage.getGroupPerm(), frsGroupSocketResponseMessage.getGroups());
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
                avVar.hrp = false;
                avVar.isLocal = false;
                if (type == 3) {
                    avVar.pn = d.this.izO;
                    d.this.izU = z;
                    d.this.izI = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.izX = false;
                } else if (type == 1) {
                    avVar.pn = d.this.izM;
                    d.this.izS = z;
                    d.this.izG = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.izV = false;
                } else {
                    avVar.pn = d.this.izN;
                    d.this.izT = z;
                    d.this.izH = frsGroupSocketResponseMessage.getGroupPerm();
                    d.this.izW = false;
                }
                if (a == null || a.size() <= 0) {
                    d.this.c(TbadkCoreApplication.isLogin(), frsGroupSocketResponseMessage.getGroupPerm());
                } else if (d.this.hjy != null) {
                    d.this.hjy.a(4, type, avVar, a);
                }
            }
        }
    };
    private CustomMessageListener hiT = new CustomMessageListener(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID) { // from class: com.baidu.tieba.im.frsgroup.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ArrayList<o> a;
            if (customResponsedMessage instanceof FrsGroupReadCacheResponseMessage) {
                FrsGroupReadCacheResponseMessage frsGroupReadCacheResponseMessage = (FrsGroupReadCacheResponseMessage) customResponsedMessage;
                int type = d.this.izZ.getType();
                av avVar = new av();
                avVar.errCode = customResponsedMessage.getError();
                avVar.errMsg = customResponsedMessage.getErrorString();
                avVar.forumId = d.this.forumId;
                avVar.forumName = d.this.forumName;
                avVar.isLocal = true;
                avVar.hasMore = false;
                avVar.pn = -1;
                if (type == 3) {
                    d.this.izI = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.izL = frsGroupReadCacheResponseMessage.getGroups();
                } else if (type == 1) {
                    d.this.izG = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.izJ = frsGroupReadCacheResponseMessage.getGroups();
                } else {
                    d.this.izH = frsGroupReadCacheResponseMessage.getGroupPerm();
                    d.this.izK = frsGroupReadCacheResponseMessage.getGroups();
                }
                if (d.this.hjy != null && (a = d.this.a(frsGroupReadCacheResponseMessage.getGroupPerm(), frsGroupReadCacheResponseMessage.getGroups(), type)) != null && a.size() > 0) {
                    d.this.hjy.a(4, type, avVar, a);
                }
                d.this.cs(type, 0);
            }
        }
    };

    public void cs(int i, int i2) {
        FrsGroupRequestMessage frsGroupRequestMessage = new FrsGroupRequestMessage();
        if (this.epM != null) {
            frsGroupRequestMessage.setTag(this.epM);
        }
        if (i2 == 0) {
            frsGroupRequestMessage.setForumName(this.forumName);
            frsGroupRequestMessage.setNeedCache(true);
        }
        frsGroupRequestMessage.setForumId(this.forumId);
        frsGroupRequestMessage.setType(i);
        frsGroupRequestMessage.setOffset(i2);
        this.izY = frsGroupRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupRequestMessage);
    }

    public void we(int i) {
        FrsGroupReadCacheRequestMessage frsGroupReadCacheRequestMessage = new FrsGroupReadCacheRequestMessage();
        if (this.epM != null) {
            frsGroupReadCacheRequestMessage.setTag(this.epM);
        }
        frsGroupReadCacheRequestMessage.setType(i);
        frsGroupReadCacheRequestMessage.setForumName(this.forumName);
        this.izZ = frsGroupReadCacheRequestMessage;
        MessageManager.getInstance().sendMessage(frsGroupReadCacheRequestMessage);
    }

    public void xB(int i) {
        GroupPermData groupPermData;
        List<GroupInfoData> list = null;
        av avVar = new av();
        avVar.forumId = this.forumId;
        avVar.forumName = this.forumName;
        avVar.hrp = false;
        avVar.errCode = 0;
        if (i == 1) {
            groupPermData = this.izG;
            list = this.izJ;
            avVar.pn = this.izM;
            avVar.hasMore = this.izS;
        } else if (i == 2) {
            groupPermData = this.izH;
            list = this.izK;
            avVar.pn = this.izN;
            avVar.hasMore = this.izT;
        } else if (i == 3) {
            groupPermData = this.izI;
            list = this.izL;
            avVar.pn = this.izO;
            avVar.hasMore = this.izU;
        } else {
            groupPermData = null;
        }
        ArrayList<o> a = a(groupPermData, list, i);
        if (a != null && a.size() > 0) {
            if (this.hjy != null) {
                this.hjy.a(4, i, avVar, a);
                return;
            }
            return;
        }
        c(TbadkCoreApplication.isLogin(), groupPermData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<o> a(boolean z, int i, GroupPermData groupPermData, List<GroupInfoData> list) {
        if (i == 1) {
            this.izJ = a(z, this.izJ, list);
            this.izG = groupPermData;
            return a(this.izG, this.izJ, i);
        } else if (i == 3) {
            this.izI = groupPermData;
            this.izL = a(z, this.izL, list);
            return a(this.izI, this.izL, i);
        } else {
            this.izH = groupPermData;
            this.izK = a(z, this.izK, list);
            return a(this.izH, this.izK, i);
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
    public ArrayList<o> a(GroupPermData groupPermData, List<GroupInfoData> list, int i) {
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<o> arrayList = new ArrayList<>();
        this.iAa.clear();
        for (GroupInfoData groupInfoData : list) {
            if (groupInfoData != null && this.iAa.add(Long.valueOf(groupInfoData.getGroupId()))) {
                if (i == 3) {
                    groupInfoData.setGrade(0);
                }
                groupInfoData.setFrom(this.dNl + 3);
                arrayList.add(groupInfoData);
            }
        }
        int size = arrayList.size();
        if (groupPermData != null) {
            groupPermData.setForumId(this.forumId);
            arrayList.add(0, groupPermData);
        }
        if (arrayList.size() > 0) {
            arrayList.add(ct((size * com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds160)) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds120), R.color.cp_bg_line_d));
        }
        return arrayList;
    }

    private com.baidu.tieba.frs.k ct(int i, int i2) {
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        kVar.setHeight(com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext()) - ((com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90)) + i));
        kVar.tF(i2);
        return kVar;
    }

    private boolean xC(int i) {
        if (i == 1) {
            return this.izV;
        }
        if (i == 2) {
            return this.izW;
        }
        if (i == 3) {
            return this.izX;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, Object obj) {
        if (this.hjy != null) {
            ArrayList<o> arrayList = new ArrayList<>();
            h hVar = new h();
            if (!z) {
                hVar.Gz(TbadkCoreApplication.getInst().getResources().getString(R.string.login_see_more));
                hVar.Gy(TbadkCoreApplication.getInst().getResources().getString(R.string.not_login));
                hVar.c(NoDataViewFactory.ImgType.NODATA);
                hVar.xE(1);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            } else if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                arrayList.add(new p());
            } else {
                hVar.Gz(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group));
                hVar.Gy(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_hot_create_group_tip));
                hVar.Gx(TbadkCoreApplication.getInst().getResources().getString(R.string.frsgroup_no_hot_tip));
                hVar.c(NoDataViewFactory.ImgType.CREATE);
                hVar.xE(0);
                hVar.setExtraData(obj);
                arrayList.add(hVar);
            }
            arrayList.add(ct(com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds600) + com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds80), R.drawable.transparent_bg));
            av avVar = new av();
            avVar.errCode = 0;
            avVar.forumId = this.forumId;
            avVar.forumName = this.forumName;
            avVar.hasMore = false;
            avVar.hrp = false;
            avVar.pn = -1;
            this.hjy.a(4, this.dNl, avVar, arrayList);
        }
    }

    private boolean xD(int i) {
        if (i == 1) {
            return this.izS;
        }
        if (i == 2) {
            return this.izT;
        }
        if (i == 3) {
            return this.izU;
        }
        return false;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, as asVar) {
        int i3;
        if (i == 4 && asVar != null) {
            this.forumId = asVar.forumId;
            this.forumName = asVar.forumName;
            this.dNl = i2;
            if (!TbadkCoreApplication.isLogin()) {
                c(false, (Object) null);
            } else if (xC(i2)) {
                we(i2);
            } else {
                if (asVar.pn == -1) {
                    this.rn = 50;
                } else {
                    this.rn = 20;
                }
                if (i2 == 1) {
                    i3 = this.izM;
                } else if (i2 == 2) {
                    i3 = this.izN;
                } else {
                    i3 = i2 == 3 ? this.izO : 0;
                }
                int a = a(i2, this.rn, i3, asVar);
                if (a < 0) {
                    xB(i2);
                } else if (a == 0) {
                    this.eIo = true;
                    cs(i2, 0);
                } else if (xD(i2)) {
                    this.eIo = false;
                    cs(i2, a);
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
                this.izP = 0;
                this.izM = 1;
                return 0;
            } else if (i == 2) {
                this.izQ = 0;
                this.izN = 1;
                return 0;
            } else if (i == 3) {
                this.izR = 0;
                this.izO = 1;
                return 0;
            } else {
                return 0;
            }
        } else if (asVar.pn <= i3) {
            return -1;
        } else {
            if (i == 1) {
                this.izP += i2;
                int i4 = this.izP;
                this.izM = asVar.pn;
                return i4;
            } else if (i == 2) {
                this.izQ += i2;
                int i5 = this.izQ;
                this.izN = asVar.pn;
                return i5;
            } else if (i == 3) {
                this.izR += i2;
                int i6 = this.izR;
                this.izO = asVar.pn;
                return i6;
            } else {
                return 0;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ao aoVar) {
        this.hjy = aoVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_REQUEST_GROUPS_BYFID, FrsGroupSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_CACHE_GROUPS_BY_FID, j.class);
        if (this.epM != null) {
            this.iAb.setTag(this.epM);
            this.iAb.setSelfListener(true);
            this.hiT.setTag(this.epM);
            this.hiT.setSelfListener(true);
        }
        MessageManager.getInstance().registerListener(this.iAb);
        MessageManager.getInstance().registerListener(this.hiT);
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.epM = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void bwi() {
        MessageManager.getInstance().unRegisterListener(this.iAb);
        MessageManager.getInstance().unRegisterListener(this.hiT);
    }
}
