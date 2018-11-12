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
    private BdUniqueId bag;
    private al dyh;
    private String forumId;
    private String forumName;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private r mUserInfo;
    private boolean dro = true;
    private ar dyj = new ar();
    private com.baidu.adp.framework.listener.a cWD = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.dro = false;
                    e.this.dyj.errCode = responsedMessage.getError();
                    e.this.dyj.errMsg = responsedMessage.getErrorString();
                    e.this.dyj.hasMore = false;
                    e.this.dyj.dFt = false;
                    e.this.dyj.dFs = false;
                    e.this.dyj.forumId = e.this.forumId;
                    e.this.dyj.forumName = e.this.forumName;
                    e.this.dyj.pn = 1;
                    if (e.this.dyh != null) {
                        e.this.dyh.a(3, 0, e.this.dyj, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener dxC = new CustomMessageListener(2003009) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.dyj.errCode = customResponsedMessage.getError();
                e.this.dyj.errMsg = customResponsedMessage.getErrorString();
                e.this.dyj.hasMore = false;
                e.this.dyj.dFt = false;
                e.this.dyj.dFs = false;
                e.this.dyj.forumId = e.this.forumId;
                e.this.dyj.forumName = e.this.forumName;
                e.this.dyj.pn = 1;
                if (e.this.dyh != null) {
                    ArrayList<com.baidu.adp.widget.ListView.h> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.dro) {
                            e.this.dyh.a(3, 0, e.this.dyj, a);
                        }
                    } else {
                        e.this.dyh.a(3, 0, e.this.dyj, a);
                    }
                }
                if (e.this.dro) {
                    e.this.f(com.baidu.adp.lib.g.b.d(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener dyk = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                e.this.dyj.errCode = customResponsedMessage.getError();
                e.this.dyj.errMsg = customResponsedMessage.getErrorString();
                e.this.dyj.hasMore = false;
                e.this.dyj.dFt = false;
                e.this.dyj.dFs = false;
                e.this.dyj.forumId = e.this.forumId;
                e.this.dyj.forumName = e.this.forumName;
                e.this.dyj.pn = 1;
                r rVar = (r) customResponsedMessage.getData();
                if (rVar != null && rVar.isLike() == 0 && e.this.mUserInfo != null) {
                    rVar.setCurScore(e.this.mUserInfo.getCurScore());
                    rVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = rVar;
                if (e.this.dyh != null) {
                    e.this.dyh.a(3, 0, e.this.dyj, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener dyl = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.f(com.baidu.adp.lib.g.b.d(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void nr(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.bag != null) {
            forumMemberReadCacheRequestMessage.setTag(this.bag);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void f(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.bag != null) {
                forumMemberRequestMessage.setTag(this.bag);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.dyj.errCode = 0;
        this.dyj.hasMore = false;
        this.dyj.dFt = false;
        this.dyj.dFs = false;
        this.dyj.forumId = this.forumId;
        this.dyj.forumName = this.forumName;
        this.dyj.pn = 1;
        if (this.dyh != null) {
            this.dyh.a(3, 0, this.dyj, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo));
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
                        mVar.gj(true);
                    } else {
                        mVar.gj(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        a(memberGodInfo, arrayList);
        p pVar = new p();
        if (managerApplyInfo != null) {
            pVar.lw(managerApplyInfo.manager_left_num.intValue());
            pVar.ns(managerApplyInfo.manager_apply_url);
            pVar.ly(managerApplyInfo.assist_left_num.intValue());
            pVar.nt(managerApplyInfo.assist_apply_url);
            pVar.lx(managerApplyInfo.manager_apply_status.intValue());
        }
        arrayList.add(pVar);
        b bVar = new b();
        bVar.dyc = e.j.complaint_bar_lord;
        bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
        arrayList.add(bVar);
        com.baidu.adp.widget.ListView.h axI = axI();
        if (axI != null) {
            arrayList.add(axI);
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

    private com.baidu.tieba.frs.i axI() {
        int h;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        int aQ = com.baidu.adp.lib.util.l.aQ(TbadkCoreApplication.getInst().getContext());
        int h2 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds100);
        int h3 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds90);
        int h4 = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds300);
        } else {
            h = com.baidu.adp.lib.util.l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.ds200);
        }
        iVar.setHeight(aQ - ((h + (h2 + h3)) + (h4 * size)));
        iVar.lE(e.f.transparent_bg);
        return iVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.bag = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        if (i == 3 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            if (this.dro) {
                nr(aoVar.forumName);
            } else if (aoVar.pn == -1) {
                f(com.baidu.adp.lib.g.b.d(aoVar.forumId, 0L), aoVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.dyh = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        registerTask();
        if (this.bag != null) {
            this.dxC.setTag(this.bag);
            this.cWD.setTag(this.bag);
            this.dxC.setSelfListener(true);
            if (this.cWD.getHttpMessageListener() != null) {
                this.cWD.getHttpMessageListener().setSelfListener(true);
            }
            if (this.cWD.getSocketMessageListener() != null) {
                this.cWD.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.dxC);
        MessageManager.getInstance().registerListener(this.cWD);
        MessageManager.getInstance().registerListener(this.dyk);
        MessageManager.getInstance().registerListener(this.dyl);
    }

    @Override // com.baidu.tieba.frs.ai
    public void abf() {
        MessageManager.getInstance().unRegisterListener(this.cWD);
        MessageManager.getInstance().unRegisterListener(this.dxC);
        MessageManager.getInstance().unRegisterListener(this.dyk);
        MessageManager.getInstance().unRegisterListener(this.dyl);
    }
}
