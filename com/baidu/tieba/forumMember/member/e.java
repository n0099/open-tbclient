package com.baidu.tieba.forumMember.member;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.SignData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements ak {
    private BdUniqueId bII;
    private an dBw;
    private String forumId;
    private String forumName;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private r mUserInfo;
    private boolean dyG = true;
    private at dBy = new at();
    private com.baidu.adp.framework.listener.a dfD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                        } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                            ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                            e.this.mUserInfo = forumMemberSocketResponseMessage.getUserInfo();
                            e.this.mMemberGroupInfoList = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                            e.this.mMemberGodInfo = forumMemberSocketResponseMessage.getMemberGodInfo();
                            e.this.mManagerApplyInfo = forumMemberSocketResponseMessage.getManagerApplyInfo();
                        }
                    }
                    e.this.dyG = false;
                    e.this.dBy.errCode = responsedMessage.getError();
                    e.this.dBy.errMsg = responsedMessage.getErrorString();
                    e.this.dBy.hasMore = false;
                    e.this.dBy.dHJ = false;
                    e.this.dBy.dHI = false;
                    e.this.dBy.forumId = e.this.forumId;
                    e.this.dBy.forumName = e.this.forumName;
                    e.this.dBy.pn = 1;
                    if (e.this.dBw != null) {
                        e.this.dBw.a(3, 0, e.this.dBy, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener dAT = new CustomMessageListener(2003009) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                }
                e.this.dBy.errCode = customResponsedMessage.getError();
                e.this.dBy.errMsg = customResponsedMessage.getErrorString();
                e.this.dBy.hasMore = false;
                e.this.dBy.dHJ = false;
                e.this.dBy.dHI = false;
                e.this.dBy.forumId = e.this.forumId;
                e.this.dBy.forumName = e.this.forumName;
                e.this.dBy.pn = 1;
                if (e.this.dBw != null) {
                    ArrayList<com.baidu.adp.widget.ListView.i> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.dyG) {
                            e.this.dBw.a(3, 0, e.this.dBy, a);
                        }
                    } else {
                        e.this.dBw.a(3, 0, e.this.dBy, a);
                    }
                }
                if (e.this.dyG) {
                    e.this.c(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener dBz = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                e.this.dBy.errCode = customResponsedMessage.getError();
                e.this.dBy.errMsg = customResponsedMessage.getErrorString();
                e.this.dBy.hasMore = false;
                e.this.dBy.dHJ = false;
                e.this.dBy.dHI = false;
                e.this.dBy.forumId = e.this.forumId;
                e.this.dBy.forumName = e.this.forumName;
                e.this.dBy.pn = 1;
                r rVar = (r) customResponsedMessage.getData();
                if (rVar != null && rVar.isLike() == 0 && e.this.mUserInfo != null) {
                    rVar.setCurScore(e.this.mUserInfo.getCurScore());
                    rVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = rVar;
                if (e.this.dBw != null) {
                    e.this.dBw.a(3, 0, e.this.dBy, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener dBA = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.c(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void ly(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.bII != null) {
            forumMemberReadCacheRequestMessage.setTag(this.bII);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void c(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.bII != null) {
                forumMemberRequestMessage.setTag(this.bII);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.dBy.errCode = 0;
        this.dBy.hasMore = false;
        this.dBy.dHJ = false;
        this.dBy.dHI = false;
        this.dBy.forumId = this.forumId;
        this.dBy.forumName = this.forumName;
        this.dBy.pn = 1;
        if (this.dBw != null) {
            this.dBw.a(3, 0, this.dBy, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo));
        }
    }

    public void HQ() {
        com.baidu.tieba.tbadkCore.a.a.a(301004, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2003009, f.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.i> a(r rVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo) {
        if (rVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.i> arrayList = new ArrayList<>();
        j jVar = new j();
        jVar.a(rVar);
        jVar.setForumId(this.forumId);
        jVar.setForumName(this.forumName);
        arrayList.add(jVar);
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && v.D(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.fE(true);
                    } else {
                        mVar.fE(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        a(memberGodInfo, arrayList);
        p pVar = new p();
        if (managerApplyInfo != null) {
            pVar.mG(managerApplyInfo.manager_left_num.intValue());
            pVar.lz(managerApplyInfo.manager_apply_url);
            pVar.mI(managerApplyInfo.assist_left_num.intValue());
            pVar.lA(managerApplyInfo.assist_apply_url);
            pVar.mH(managerApplyInfo.manager_apply_status.intValue());
        }
        arrayList.add(pVar);
        b bVar = new b();
        bVar.dBr = d.j.complaint_bar_lord;
        bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
        arrayList.add(bVar);
        com.baidu.adp.widget.ListView.i atT = atT();
        if (atT != null) {
            arrayList.add(atT);
        }
        return arrayList;
    }

    private void a(MemberGodInfo memberGodInfo, ArrayList<com.baidu.adp.widget.ListView.i> arrayList) {
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

    private com.baidu.tieba.frs.h atT() {
        int t;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.h hVar = new com.baidu.tieba.frs.h();
        int aq = com.baidu.adp.lib.util.l.aq(TbadkCoreApplication.getInst().getContext());
        int t2 = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds100);
        int t3 = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds90);
        int t4 = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            t = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds300);
        } else {
            t = com.baidu.adp.lib.util.l.t(TbadkCoreApplication.getInst().getContext(), d.e.ds200);
        }
        hVar.setHeight(aq - ((t + (t2 + t3)) + (t4 * size)));
        hVar.mN(d.f.transparent_bg);
        return hVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bII = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(int i, int i2, aq aqVar) {
        if (i == 3 && aqVar != null) {
            this.forumId = aqVar.forumId;
            this.forumName = aqVar.forumName;
            if (this.dyG) {
                ly(aqVar.forumName);
            } else if (aqVar.pn == -1) {
                c(com.baidu.adp.lib.g.b.c(aqVar.forumId, 0L), aqVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(an anVar) {
        this.dBw = anVar;
    }

    @Override // com.baidu.tieba.frs.ak
    public void init() {
        HQ();
        if (this.bII != null) {
            this.dAT.setTag(this.bII);
            this.dfD.setTag(this.bII);
            this.dAT.setSelfListener(true);
            if (this.dfD.getHttpMessageListener() != null) {
                this.dfD.getHttpMessageListener().setSelfListener(true);
            }
            if (this.dfD.getSocketMessageListener() != null) {
                this.dfD.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.dAT);
        MessageManager.getInstance().registerListener(this.dfD);
        MessageManager.getInstance().registerListener(this.dBz);
        MessageManager.getInstance().registerListener(this.dBA);
    }

    @Override // com.baidu.tieba.frs.ak
    public void Za() {
        MessageManager.getInstance().unRegisterListener(this.dfD);
        MessageManager.getInstance().unRegisterListener(this.dAT);
        MessageManager.getInstance().unRegisterListener(this.dBz);
        MessageManager.getInstance().unRegisterListener(this.dBA);
    }
}
