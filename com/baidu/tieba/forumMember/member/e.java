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
import com.baidu.tieba.e;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.al;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements ai {
    private BdUniqueId bdH;
    private al dHu;
    private String forumId;
    private String forumName;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private r mUserInfo;
    private boolean dAB = true;
    private ar dHw = new ar();
    private com.baidu.adp.framework.listener.a dgf = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.dAB = false;
                    e.this.dHw.errCode = responsedMessage.getError();
                    e.this.dHw.errMsg = responsedMessage.getErrorString();
                    e.this.dHw.hasMore = false;
                    e.this.dHw.dOG = false;
                    e.this.dHw.dOF = false;
                    e.this.dHw.forumId = e.this.forumId;
                    e.this.dHw.forumName = e.this.forumName;
                    e.this.dHw.pn = 1;
                    if (e.this.dHu != null) {
                        e.this.dHu.a(3, 0, e.this.dHw, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener dGP = new CustomMessageListener(2003009) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.dHw.errCode = customResponsedMessage.getError();
                e.this.dHw.errMsg = customResponsedMessage.getErrorString();
                e.this.dHw.hasMore = false;
                e.this.dHw.dOG = false;
                e.this.dHw.dOF = false;
                e.this.dHw.forumId = e.this.forumId;
                e.this.dHw.forumName = e.this.forumName;
                e.this.dHw.pn = 1;
                if (e.this.dHu != null) {
                    ArrayList<com.baidu.adp.widget.ListView.h> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.dAB) {
                            e.this.dHu.a(3, 0, e.this.dHw, a);
                        }
                    } else {
                        e.this.dHu.a(3, 0, e.this.dHw, a);
                    }
                }
                if (e.this.dAB) {
                    e.this.f(com.baidu.adp.lib.g.b.d(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener dHx = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                e.this.dHw.errCode = customResponsedMessage.getError();
                e.this.dHw.errMsg = customResponsedMessage.getErrorString();
                e.this.dHw.hasMore = false;
                e.this.dHw.dOG = false;
                e.this.dHw.dOF = false;
                e.this.dHw.forumId = e.this.forumId;
                e.this.dHw.forumName = e.this.forumName;
                e.this.dHw.pn = 1;
                r rVar = (r) customResponsedMessage.getData();
                if (rVar != null && rVar.isLike() == 0 && e.this.mUserInfo != null) {
                    rVar.setCurScore(e.this.mUserInfo.getCurScore());
                    rVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = rVar;
                if (e.this.dHu != null) {
                    e.this.dHu.a(3, 0, e.this.dHw, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener dHy = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.f(com.baidu.adp.lib.g.b.d(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void nT(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.bdH != null) {
            forumMemberReadCacheRequestMessage.setTag(this.bdH);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void f(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.bdH != null) {
                forumMemberRequestMessage.setTag(this.bdH);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.dHw.errCode = 0;
        this.dHw.hasMore = false;
        this.dHw.dOG = false;
        this.dHw.dOF = false;
        this.dHw.forumId = this.forumId;
        this.dHw.forumName = this.forumName;
        this.dHw.pn = 1;
        if (this.dHu != null) {
            this.dHu.a(3, 0, this.dHw, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo));
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(301004, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(301004, CmdConfigHttp.FRS_MEMBER_TAB_CMD, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.b(2003009, f.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.h> a(r rVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo) {
        if (rVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.h> arrayList = new ArrayList<>();
        j jVar = new j();
        jVar.a(rVar);
        jVar.setForumId(this.forumId);
        jVar.setForumName(this.forumName);
        arrayList.add(jVar);
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && v.H(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.gm(true);
                    } else {
                        mVar.gm(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        a(memberGodInfo, arrayList);
        p pVar = new p();
        if (managerApplyInfo != null) {
            pVar.lZ(managerApplyInfo.manager_left_num.intValue());
            pVar.nU(managerApplyInfo.manager_apply_url);
            pVar.mb(managerApplyInfo.assist_left_num.intValue());
            pVar.nV(managerApplyInfo.assist_apply_url);
            pVar.ma(managerApplyInfo.manager_apply_status.intValue());
        }
        arrayList.add(pVar);
        b bVar = new b();
        bVar.dHp = e.j.complaint_bar_lord;
        bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
        arrayList.add(bVar);
        com.baidu.adp.widget.ListView.h aAh = aAh();
        if (aAh != null) {
            arrayList.add(aAh);
        }
        return arrayList;
    }

    private void a(MemberGodInfo memberGodInfo, ArrayList<com.baidu.adp.widget.ListView.h> arrayList) {
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

    private com.baidu.tieba.frs.i aAh() {
        int h;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext());
        int h2 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds100);
        int h3 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds90);
        int h4 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds300);
        } else {
            h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.ds200);
        }
        iVar.setHeight(aQ - ((h + (h2 + h3)) + (h4 * size)));
        iVar.mh(e.f.transparent_bg);
        return iVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bdH = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        if (i == 3 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            if (this.dAB) {
                nT(aoVar.forumName);
            } else if (aoVar.pn == -1) {
                f(com.baidu.adp.lib.g.b.d(aoVar.forumId, 0L), aoVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dHu = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        registerTask();
        if (this.bdH != null) {
            this.dGP.setTag(this.bdH);
            this.dgf.setTag(this.bdH);
            this.dGP.setSelfListener(true);
            if (this.dgf.getHttpMessageListener() != null) {
                this.dgf.getHttpMessageListener().setSelfListener(true);
            }
            if (this.dgf.getSocketMessageListener() != null) {
                this.dgf.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.dGP);
        MessageManager.getInstance().registerListener(this.dgf);
        MessageManager.getInstance().registerListener(this.dHx);
        MessageManager.getInstance().registerListener(this.dHy);
    }

    @Override // com.baidu.tieba.frs.ai
    public void acn() {
        MessageManager.getInstance().unRegisterListener(this.dgf);
        MessageManager.getInstance().unRegisterListener(this.dGP);
        MessageManager.getInstance().unRegisterListener(this.dHx);
        MessageManager.getInstance().unRegisterListener(this.dHy);
    }
}
