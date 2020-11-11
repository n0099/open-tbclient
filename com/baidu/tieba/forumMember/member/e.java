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
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.av;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.frs.bd;
import com.baidu.tieba.tbadkCore.v;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes23.dex */
public class e implements ar {
    private String forumId;
    private String forumName;
    private BdUniqueId fsQ;
    private av iDs;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private v mUserInfo;
    private boolean mIsPrivateForum = false;
    private boolean mIsBawuShow = false;
    private boolean iAe = true;
    private bd iDu = new bd();
    private com.baidu.adp.framework.listener.a iCN = new com.baidu.adp.framework.listener.a(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.iAe = false;
                    e.this.iDu.errCode = responsedMessage.getError();
                    e.this.iDu.errMsg = responsedMessage.getErrorString();
                    e.this.iDu.hasMore = false;
                    e.this.iDu.iMo = false;
                    e.this.iDu.asR = false;
                    e.this.iDu.forumId = e.this.forumId;
                    e.this.iDu.forumName = e.this.forumName;
                    e.this.iDu.pn = 1;
                    if (e.this.iDs != null) {
                        e.this.iDs.a(3, 0, e.this.iDu, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener iCO = new CustomMessageListener(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.iDu.errCode = customResponsedMessage.getError();
                e.this.iDu.errMsg = customResponsedMessage.getErrorString();
                e.this.iDu.hasMore = false;
                e.this.iDu.iMo = false;
                e.this.iDu.asR = false;
                e.this.iDu.forumId = e.this.forumId;
                e.this.iDu.forumName = e.this.forumName;
                e.this.iDu.pn = 1;
                if (e.this.iDs != null) {
                    ArrayList<com.baidu.adp.widget.ListView.q> a2 = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo);
                    if (a2 == null || a2.size() <= 0) {
                        if (!e.this.iAe) {
                            e.this.iDs.a(3, 0, e.this.iDu, a2);
                        }
                    } else {
                        e.this.iDs.a(3, 0, e.this.iDu, a2);
                    }
                }
                if (e.this.iAe) {
                    e.this.k(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener iDv = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof v)) {
                e.this.iDu.errCode = customResponsedMessage.getError();
                e.this.iDu.errMsg = customResponsedMessage.getErrorString();
                e.this.iDu.hasMore = false;
                e.this.iDu.iMo = false;
                e.this.iDu.asR = false;
                e.this.iDu.forumId = e.this.forumId;
                e.this.iDu.forumName = e.this.forumName;
                e.this.iDu.pn = 1;
                v vVar = (v) customResponsedMessage.getData();
                if (vVar != null && vVar.isLike() == 0 && e.this.mUserInfo != null) {
                    vVar.setCurScore(e.this.mUserInfo.getCurScore());
                    vVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = vVar;
                if (e.this.iDs != null) {
                    e.this.iDs.a(3, 0, e.this.iDu, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo, e.this.mIsBawuShow, e.this.mIsPrivateForum, e.this.mPrivateMgrApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener iDw = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.k(com.baidu.adp.lib.f.b.toLong(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void Ki(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.fsQ != null) {
            forumMemberReadCacheRequestMessage.setTag(this.fsQ);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void k(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.fsQ != null) {
                forumMemberRequestMessage.setTag(this.fsQ);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.iDu.errCode = 0;
        this.iDu.hasMore = false;
        this.iDu.iMo = false;
        this.iDu.asR = false;
        this.iDu.forumId = this.forumId;
        this.iDu.forumName = this.forumName;
        this.iDu.pn = 1;
        if (this.iDs != null) {
            this.iDs.a(3, 0, this.iDu, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo, this.mIsBawuShow, this.mIsPrivateForum, this.mPrivateMgrApplyInfo));
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, 1001706, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE, f.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.q> a(v vVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        if (vVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.q> arrayList = new ArrayList<>();
        if (vVar.isLike() == 1) {
            j jVar = new j();
            jVar.a(vVar);
            jVar.setForumId(this.forumId);
            jVar.setForumName(this.forumName);
            arrayList.add(jVar);
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && y.getCount(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.pi(true);
                    } else {
                        mVar.pi(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        if (this.mIsPrivateForum) {
            if (this.mIsBawuShow && priManagerApplyInfo != null) {
                s sVar = new s();
                if (sVar != null) {
                    sVar.yt(priManagerApplyInfo.assist_left_num.intValue());
                    sVar.Kk(priManagerApplyInfo.assist_apply_url);
                    sVar.yu(priManagerApplyInfo.assist_apply_status.intValue());
                }
                arrayList.add(sVar);
            }
        } else {
            p pVar = new p();
            if (managerApplyInfo != null) {
                pVar.yr(managerApplyInfo.manager_left_num.intValue());
                pVar.Kj(managerApplyInfo.manager_apply_url);
                pVar.yt(managerApplyInfo.assist_left_num.intValue());
                pVar.Kk(managerApplyInfo.assist_apply_url);
                pVar.ys(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(pVar);
            b bVar = new b();
            bVar.iDn = R.string.complaint_bar_lord;
            bVar.mUrl = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.forumId;
            arrayList.add(bVar);
        }
        a(memberGodInfo, arrayList);
        com.baidu.adp.widget.ListView.q cwF = cwF();
        if (cwF != null) {
            arrayList.add(cwF);
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

    private com.baidu.tieba.frs.n cwF() {
        int dimens;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.n nVar = new com.baidu.tieba.frs.n();
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
        nVar.setHeight(equipmentHeight - ((dimens + (dimens2 + dimens3)) + (dimens4 * size)));
        nVar.yB(R.drawable.transparent_bg);
        return nVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fsQ = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(int i, int i2, ba baVar) {
        if (i == 3 && baVar != null) {
            this.forumId = baVar.forumId;
            this.forumName = baVar.forumName;
            if (this.iAe) {
                Ki(baVar.forumName);
            } else if (baVar.pn == -1) {
                k(com.baidu.adp.lib.f.b.toLong(baVar.forumId, 0L), baVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ar
    public void a(av avVar) {
        this.iDs = avVar;
    }

    @Override // com.baidu.tieba.frs.ar
    public void init() {
        registerTask();
        if (this.fsQ != null) {
            this.iCO.setTag(this.fsQ);
            this.iCN.setTag(this.fsQ);
            this.iCO.setSelfListener(true);
            if (this.iCN.getHttpMessageListener() != null) {
                this.iCN.getHttpMessageListener().setSelfListener(true);
            }
            if (this.iCN.getSocketMessageListener() != null) {
                this.iCN.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.iCO);
        MessageManager.getInstance().registerListener(this.iCN);
        MessageManager.getInstance().registerListener(this.iDv);
        MessageManager.getInstance().registerListener(this.iDw);
    }

    @Override // com.baidu.tieba.frs.ar
    public void bVV() {
        MessageManager.getInstance().unRegisterListener(this.iCN);
        MessageManager.getInstance().unRegisterListener(this.iCO);
        MessageManager.getInstance().unRegisterListener(this.iDv);
        MessageManager.getInstance().unRegisterListener(this.iDw);
    }
}
