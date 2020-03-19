package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ah;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes10.dex */
public class e implements ah {
    private BdUniqueId dBK;
    private String forumId;
    private String forumName;
    private ak glA;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private u mUserInfo;
    private boolean mIsPrivateForum = false;
    private boolean mIsBawuShow = false;
    private boolean gij = true;
    private ar glC = new ar();
    private com.baidu.adp.framework.listener.a gkT = new com.baidu.adp.framework.listener.a(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB) { // from class: com.baidu.tieba.forumMember.member.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ForumMemberHttpResponseMessage) || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof ForumMemberHttpResponseMessage) {
                            ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                            e.this.mUserInfo = forumMemberHttpResponseMessage.getUserInfo();
                            e.this.mMemberGroupInfoList = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                            e.this.mMemberGodInfo = forumMemberHttpResponseMessage.getMemberGodInfo();
                            e.this.mManagerApplyInfo = forumMemberHttpResponseMessage.getManagerApplyInfo();
                            e.this.mIsBawuShow = forumMemberHttpResponseMessage.isBawuShow();
                            e.this.mIsPrivateForum = forumMemberHttpResponseMessage.isPrivateForum();
                            e.this.mPrivateMgrApplyInfo = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                        } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                            ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                            e.this.mUserInfo = forumMemberSocketResponseMessage.getUserInfo();
                            e.this.mMemberGroupInfoList = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                            e.this.mMemberGodInfo = forumMemberSocketResponseMessage.getMemberGodInfo();
                            e.this.mManagerApplyInfo = forumMemberSocketResponseMessage.getManagerApplyInfo();
                            e.this.mIsBawuShow = forumMemberSocketResponseMessage.isBawuShow();
                            e.this.mIsPrivateForum = forumMemberSocketResponseMessage.isPrivateForum();
                            e.this.mPrivateMgrApplyInfo = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                        }
                    }
                    e.this.gij = false;
                    e.this.glC.errCode = responsedMessage.getError();
                    e.this.glC.errMsg = responsedMessage.getErrorString();
                    e.this.glC.hasMore = false;
                    e.this.glC.gtk = false;
                    e.this.glC.gtj = false;
                    e.this.glC.forumId = e.this.forumId;
                    e.this.glC.forumName = e.this.forumName;
                    e.this.glC.pn = 1;
                    if (e.this.glA != null) {
                        e.this.glA.a(3, 0, e.this.glC, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener gkU = new CustomMessageListener(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.member.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    e.this.mUserInfo = forumMemberReadCacheResponseMessage.getUserInfo();
                    e.this.mMemberGroupInfoList = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    e.this.mMemberGodInfo = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    e.this.mManagerApplyInfo = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    e.this.mIsBawuShow = forumMemberReadCacheResponseMessage.isBawuShow();
                    e.this.mIsPrivateForum = forumMemberReadCacheResponseMessage.isPrivateForum();
                    e.this.mPrivateMgrApplyInfo = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                e.this.glC.errCode = customResponsedMessage.getError();
                e.this.glC.errMsg = customResponsedMessage.getErrorString();
                e.this.glC.hasMore = false;
                e.this.glC.gtk = false;
                e.this.glC.gtj = false;
                e.this.glC.forumId = e.this.forumId;
                e.this.glC.forumName = e.this.forumName;
                e.this.glC.pn = 1;
                if (e.this.glA != null) {
                    ArrayList<com.baidu.adp.widget.ListView.m> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.gij) {
                            e.this.glA.a(3, 0, e.this.glC, a);
                        }
                    } else {
                        e.this.glA.a(3, 0, e.this.glC, a);
                    }
                }
                if (e.this.gij) {
                    e.this.g(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener glD = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                e.this.glC.errCode = customResponsedMessage.getError();
                e.this.glC.errMsg = customResponsedMessage.getErrorString();
                e.this.glC.hasMore = false;
                e.this.glC.gtk = false;
                e.this.glC.gtj = false;
                e.this.glC.forumId = e.this.forumId;
                e.this.glC.forumName = e.this.forumName;
                e.this.glC.pn = 1;
                u uVar = (u) customResponsedMessage.getData();
                if (uVar != null && uVar.isLike() == 0 && e.this.mUserInfo != null) {
                    uVar.setCurScore(e.this.mUserInfo.getCurScore());
                    uVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = uVar;
                if (e.this.glA != null) {
                    e.this.glA.a(3, 0, e.this.glC, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener glE = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.g(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void AY(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.dBK != null) {
            forumMemberReadCacheRequestMessage.setTag(this.dBK);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void g(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.dBK != null) {
                forumMemberRequestMessage.setTag(this.dBK);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.glC.errCode = 0;
        this.glC.hasMore = false;
        this.glC.gtk = false;
        this.glC.gtj = false;
        this.glC.forumId = this.forumId;
        this.glC.forumName = this.forumName;
        this.glC.pn = 1;
        if (this.glA != null) {
            this.glA.a(3, 0, this.glC, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo, this.mIsBawuShow, this.mIsPrivateForum, this.mPrivateMgrApplyInfo));
        }
    }

    public void tj() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, 1001706, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE, f.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.m> a(u uVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        if (uVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.m> arrayList = new ArrayList<>();
        j jVar = new j();
        jVar.a(uVar);
        jVar.setForumId(this.forumId);
        jVar.setForumName(this.forumName);
        arrayList.add(jVar);
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && v.getCount(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.la(true);
                    } else {
                        mVar.la(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        if (this.mIsPrivateForum) {
            if (this.mIsBawuShow && priManagerApplyInfo != null) {
                s sVar = new s();
                if (sVar != null) {
                    sVar.sw(priManagerApplyInfo.assist_left_num.intValue());
                    sVar.Ba(priManagerApplyInfo.assist_apply_url);
                    sVar.sx(priManagerApplyInfo.assist_apply_status.intValue());
                }
                arrayList.add(sVar);
            }
        } else {
            p pVar = new p();
            if (managerApplyInfo != null) {
                pVar.su(managerApplyInfo.manager_left_num.intValue());
                pVar.AZ(managerApplyInfo.manager_apply_url);
                pVar.sw(managerApplyInfo.assist_left_num.intValue());
                pVar.Ba(managerApplyInfo.assist_apply_url);
                pVar.sv(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(pVar);
            b bVar = new b();
            bVar.glv = R.string.complaint_bar_lord;
            bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
            arrayList.add(bVar);
        }
        a(memberGodInfo, arrayList);
        com.baidu.adp.widget.ListView.m bCD = bCD();
        if (bCD != null) {
            arrayList.add(bCD);
        }
        return arrayList;
    }

    private void a(MemberGodInfo memberGodInfo, ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0 && arrayList != null) {
            List<User> list = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list.size() != 0) {
                com.baidu.tieba.forumMember.a.b bVar = new com.baidu.tieba.forumMember.a.b();
                bVar.a(memberGodInfo);
                arrayList.add(bVar);
                boolean z = false;
                for (int i = 0; i < list.size(); i++) {
                    User user = list.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        com.baidu.tieba.forumMember.a.e eVar = new com.baidu.tieba.forumMember.a.e();
                        eVar.a(user, i);
                        arrayList.add(eVar);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    arrayList.remove(bVar);
                }
            }
        }
    }

    private com.baidu.tieba.frs.k bCD() {
        int dimens;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.k kVar = new com.baidu.tieba.frs.k();
        int equipmentHeight = com.baidu.adp.lib.util.l.getEquipmentHeight(TbadkCoreApplication.getInst().getContext());
        int dimens2 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds100);
        int dimens3 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds90);
        int dimens4 = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds300);
        } else {
            dimens = com.baidu.adp.lib.util.l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.ds200);
        }
        kVar.setHeight(equipmentHeight - ((dimens + (dimens2 + dimens3)) + (dimens4 * size)));
        kVar.sD(R.drawable.transparent_bg);
        return kVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.dBK = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(int i, int i2, ao aoVar) {
        if (i == 3 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            if (this.gij) {
                AY(aoVar.forumName);
            } else if (aoVar.pn == -1) {
                g(com.baidu.adp.lib.f.b.toLong(aoVar.forumId, 0L), aoVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ah
    public void a(ak akVar) {
        this.glA = akVar;
    }

    @Override // com.baidu.tieba.frs.ah
    public void init() {
        tj();
        if (this.dBK != null) {
            this.gkU.setTag(this.dBK);
            this.gkT.setTag(this.dBK);
            this.gkU.setSelfListener(true);
            if (this.gkT.getHttpMessageListener() != null) {
                this.gkT.getHttpMessageListener().setSelfListener(true);
            }
            if (this.gkT.getSocketMessageListener() != null) {
                this.gkT.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.gkU);
        MessageManager.getInstance().registerListener(this.gkT);
        MessageManager.getInstance().registerListener(this.glD);
        MessageManager.getInstance().registerListener(this.glE);
    }

    @Override // com.baidu.tieba.frs.ah
    public void bhc() {
        MessageManager.getInstance().unRegisterListener(this.gkT);
        MessageManager.getInstance().unRegisterListener(this.gkU);
        MessageManager.getInstance().unRegisterListener(this.glD);
        MessageManager.getInstance().unRegisterListener(this.glE);
    }
}
