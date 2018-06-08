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
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.aj;
import com.baidu.tieba.frs.am;
import com.baidu.tieba.frs.ap;
import com.baidu.tieba.tbadkCore.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.User;
/* loaded from: classes3.dex */
public class e implements ag {
    private BdUniqueId aQJ;
    private aj deo;
    private String forumId;
    private String forumName;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private r mUserInfo;
    private boolean dbv = true;
    private ap deq = new ap();
    private com.baidu.adp.framework.listener.a cGS = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.dbv = false;
                    e.this.deq.errCode = responsedMessage.getError();
                    e.this.deq.errMsg = responsedMessage.getErrorString();
                    e.this.deq.hasMore = false;
                    e.this.deq.dkR = false;
                    e.this.deq.dkQ = false;
                    e.this.deq.forumId = e.this.forumId;
                    e.this.deq.forumName = e.this.forumName;
                    e.this.deq.pn = 1;
                    if (e.this.deo != null) {
                        e.this.deo.a(3, 0, e.this.deq, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener ddJ = new CustomMessageListener(2003009) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.deq.errCode = customResponsedMessage.getError();
                e.this.deq.errMsg = customResponsedMessage.getErrorString();
                e.this.deq.hasMore = false;
                e.this.deq.dkR = false;
                e.this.deq.dkQ = false;
                e.this.deq.forumId = e.this.forumId;
                e.this.deq.forumName = e.this.forumName;
                e.this.deq.pn = 1;
                if (e.this.deo != null) {
                    ArrayList<com.baidu.adp.widget.ListView.h> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.dbv) {
                            e.this.deo.a(3, 0, e.this.deq, a);
                        }
                    } else {
                        e.this.deo.a(3, 0, e.this.deq, a);
                    }
                }
                if (e.this.dbv) {
                    e.this.d(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener der = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                e.this.deq.errCode = customResponsedMessage.getError();
                e.this.deq.errMsg = customResponsedMessage.getErrorString();
                e.this.deq.hasMore = false;
                e.this.deq.dkR = false;
                e.this.deq.dkQ = false;
                e.this.deq.forumId = e.this.forumId;
                e.this.deq.forumName = e.this.forumName;
                e.this.deq.pn = 1;
                r rVar = (r) customResponsedMessage.getData();
                if (rVar != null && rVar.isLike() == 0 && e.this.mUserInfo != null) {
                    rVar.setCurScore(e.this.mUserInfo.getCurScore());
                    rVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = rVar;
                if (e.this.deo != null) {
                    e.this.deo.a(3, 0, e.this.deq, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener det = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.d(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void ml(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.aQJ != null) {
            forumMemberReadCacheRequestMessage.setTag(this.aQJ);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void d(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.aQJ != null) {
                forumMemberRequestMessage.setTag(this.aQJ);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.deq.errCode = 0;
        this.deq.hasMore = false;
        this.deq.dkR = false;
        this.deq.dkQ = false;
        this.deq.forumId = this.forumId;
        this.deq.forumName = this.forumName;
        this.deq.pn = 1;
        if (this.deo != null) {
            this.deo.a(3, 0, this.deq, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo));
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
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && w.y(list.get(i).member_group_list) > 0) {
                    m mVar = new m();
                    mVar.setForumId(this.forumId);
                    mVar.setForumName(this.forumName);
                    mVar.a(list.get(i));
                    if (i == size - 1) {
                        mVar.fo(true);
                    } else {
                        mVar.fo(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        a(memberGodInfo, arrayList);
        p pVar = new p();
        if (managerApplyInfo != null) {
            pVar.jU(managerApplyInfo.manager_left_num.intValue());
            pVar.mm(managerApplyInfo.manager_apply_url);
            pVar.jW(managerApplyInfo.assist_left_num.intValue());
            pVar.mn(managerApplyInfo.assist_apply_url);
            pVar.jV(managerApplyInfo.manager_apply_status.intValue());
        }
        arrayList.add(pVar);
        b bVar = new b();
        bVar.dej = d.k.complaint_bar_lord;
        bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
        arrayList.add(bVar);
        com.baidu.adp.widget.ListView.h asm = asm();
        if (asm != null) {
            arrayList.add(asm);
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

    private com.baidu.tieba.frs.g asm() {
        int e;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.g gVar = new com.baidu.tieba.frs.g();
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext());
        int e2 = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds100);
        int e3 = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds90);
        int e4 = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds300);
        } else {
            e = com.baidu.adp.lib.util.l.e(TbadkCoreApplication.getInst().getContext(), d.e.ds200);
        }
        gVar.setHeight(aj - ((e + (e2 + e3)) + (e4 * size)));
        gVar.kb(d.f.transparent_bg);
        return gVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aQJ = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(int i, int i2, am amVar) {
        if (i == 3 && amVar != null) {
            this.forumId = amVar.forumId;
            this.forumName = amVar.forumName;
            if (this.dbv) {
                ml(amVar.forumName);
            } else if (amVar.pn == -1) {
                d(com.baidu.adp.lib.g.b.c(amVar.forumId, 0L), amVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void a(aj ajVar) {
        this.deo = ajVar;
    }

    @Override // com.baidu.tieba.frs.ag
    public void init() {
        registerTask();
        if (this.aQJ != null) {
            this.ddJ.setTag(this.aQJ);
            this.cGS.setTag(this.aQJ);
            this.ddJ.setSelfListener(true);
            if (this.cGS.getHttpMessageListener() != null) {
                this.cGS.getHttpMessageListener().setSelfListener(true);
            }
            if (this.cGS.getSocketMessageListener() != null) {
                this.cGS.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.ddJ);
        MessageManager.getInstance().registerListener(this.cGS);
        MessageManager.getInstance().registerListener(this.der);
        MessageManager.getInstance().registerListener(this.det);
    }

    @Override // com.baidu.tieba.frs.ag
    public void UT() {
        MessageManager.getInstance().unRegisterListener(this.cGS);
        MessageManager.getInstance().unRegisterListener(this.ddJ);
        MessageManager.getInstance().unRegisterListener(this.der);
        MessageManager.getInstance().unRegisterListener(this.det);
    }
}
