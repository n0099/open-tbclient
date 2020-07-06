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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.frs.ay;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.tbadkCore.u;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes10.dex */
public class e implements ap {
    private BdUniqueId eyE;
    private String forumId;
    private String forumName;
    private at hvR;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private u mUserInfo;
    private boolean mIsPrivateForum = false;
    private boolean mIsBawuShow = false;
    private boolean hsC = true;
    private bb hvT = new bb();
    private com.baidu.adp.framework.listener.a hvm = new com.baidu.adp.framework.listener.a(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.hsC = false;
                    e.this.hvT.errCode = responsedMessage.getError();
                    e.this.hvT.errMsg = responsedMessage.getErrorString();
                    e.this.hvT.hasMore = false;
                    e.this.hvT.hEr = false;
                    e.this.hvT.hEq = false;
                    e.this.hvT.forumId = e.this.forumId;
                    e.this.hvT.forumName = e.this.forumName;
                    e.this.hvT.pn = 1;
                    if (e.this.hvR != null) {
                        e.this.hvR.a(3, 0, e.this.hvT, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener hvn = new CustomMessageListener(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.hvT.errCode = customResponsedMessage.getError();
                e.this.hvT.errMsg = customResponsedMessage.getErrorString();
                e.this.hvT.hasMore = false;
                e.this.hvT.hEr = false;
                e.this.hvT.hEq = false;
                e.this.hvT.forumId = e.this.forumId;
                e.this.hvT.forumName = e.this.forumName;
                e.this.hvT.pn = 1;
                if (e.this.hvR != null) {
                    ArrayList<com.baidu.adp.widget.ListView.q> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.hsC) {
                            e.this.hvR.a(3, 0, e.this.hvT, a);
                        }
                    } else {
                        e.this.hvR.a(3, 0, e.this.hvT, a);
                    }
                }
                if (e.this.hsC) {
                    e.this.h(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener hvU = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof u)) {
                e.this.hvT.errCode = customResponsedMessage.getError();
                e.this.hvT.errMsg = customResponsedMessage.getErrorString();
                e.this.hvT.hasMore = false;
                e.this.hvT.hEr = false;
                e.this.hvT.hEq = false;
                e.this.hvT.forumId = e.this.forumId;
                e.this.hvT.forumName = e.this.forumName;
                e.this.hvT.pn = 1;
                u uVar = (u) customResponsedMessage.getData();
                if (uVar != null && uVar.isLike() == 0 && e.this.mUserInfo != null) {
                    uVar.setCurScore(e.this.mUserInfo.getCurScore());
                    uVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = uVar;
                if (e.this.hvR != null) {
                    e.this.hvR.a(3, 0, e.this.hvT, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener hvV = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.h(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void EV(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.eyE != null) {
            forumMemberReadCacheRequestMessage.setTag(this.eyE);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void h(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.eyE != null) {
                forumMemberRequestMessage.setTag(this.eyE);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.hvT.errCode = 0;
        this.hvT.hasMore = false;
        this.hvT.hEr = false;
        this.hvT.hEq = false;
        this.hvT.forumId = this.forumId;
        this.hvT.forumName = this.forumName;
        this.hvT.pn = 1;
        if (this.hvR != null) {
            this.hvR.a(3, 0, this.hvT, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo, this.mIsBawuShow, this.mIsPrivateForum, this.mPrivateMgrApplyInfo));
        }
    }

    public void xp() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, 1001706, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE, f.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(u uVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        if (uVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>();
        if (uVar.isLike() == 1) {
            j jVar = new j();
            jVar.a(uVar);
            jVar.setForumId(this.forumId);
            jVar.setForumName(this.forumName);
            arrayList.add(jVar);
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && w.getCount(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.mL(true);
                    } else {
                        mVar.mL(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        if (this.mIsPrivateForum) {
            if (this.mIsBawuShow && priManagerApplyInfo != null) {
                s sVar = new s();
                if (sVar != null) {
                    sVar.ub(priManagerApplyInfo.assist_left_num.intValue());
                    sVar.EX(priManagerApplyInfo.assist_apply_url);
                    sVar.uc(priManagerApplyInfo.assist_apply_status.intValue());
                }
                arrayList.add(sVar);
            }
        } else {
            p pVar = new p();
            if (managerApplyInfo != null) {
                pVar.tZ(managerApplyInfo.manager_left_num.intValue());
                pVar.EW(managerApplyInfo.manager_apply_url);
                pVar.ub(managerApplyInfo.assist_left_num.intValue());
                pVar.EX(managerApplyInfo.assist_apply_url);
                pVar.ua(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(pVar);
            b bVar = new b();
            bVar.hvM = R.string.complaint_bar_lord;
            bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
            arrayList.add(bVar);
        }
        a(memberGodInfo, arrayList);
        com.baidu.adp.widget.ListView.q bWw = bWw();
        if (bWw != null) {
            arrayList.add(bWw);
        }
        return arrayList;
    }

    private void a(MemberGodInfo memberGodInfo, ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
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

    private com.baidu.tieba.frs.m bWw() {
        int dimens;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.m mVar = new com.baidu.tieba.frs.m();
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
        mVar.setHeight(equipmentHeight - ((dimens + (dimens2 + dimens3)) + (dimens4 * size)));
        mVar.uj(R.drawable.transparent_bg);
        return mVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.eyE = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(int i, int i2, ay ayVar) {
        if (i == 3 && ayVar != null) {
            this.forumId = ayVar.forumId;
            this.forumName = ayVar.forumName;
            if (this.hsC) {
                EV(ayVar.forumName);
            } else if (ayVar.pn == -1) {
                h(com.baidu.adp.lib.f.b.toLong(ayVar.forumId, 0L), ayVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ap
    public void a(at atVar) {
        this.hvR = atVar;
    }

    @Override // com.baidu.tieba.frs.ap
    public void init() {
        xp();
        if (this.eyE != null) {
            this.hvn.setTag(this.eyE);
            this.hvm.setTag(this.eyE);
            this.hvn.setSelfListener(true);
            if (this.hvm.getHttpMessageListener() != null) {
                this.hvm.getHttpMessageListener().setSelfListener(true);
            }
            if (this.hvm.getSocketMessageListener() != null) {
                this.hvm.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.hvn);
        MessageManager.getInstance().registerListener(this.hvm);
        MessageManager.getInstance().registerListener(this.hvU);
        MessageManager.getInstance().registerListener(this.hvV);
    }

    @Override // com.baidu.tieba.frs.ap
    public void bzg() {
        MessageManager.getInstance().unRegisterListener(this.hvm);
        MessageManager.getInstance().unRegisterListener(this.hvn);
        MessageManager.getInstance().unRegisterListener(this.hvU);
        MessageManager.getInstance().unRegisterListener(this.hvV);
    }
}
