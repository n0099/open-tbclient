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
import com.baidu.tieba.f;
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
    private BdUniqueId aRC;
    private al diU;
    private String forumId;
    private String forumName;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private r mUserInfo;
    private boolean dcl = true;
    private ar diW = new ar();
    private com.baidu.adp.framework.listener.a cHp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.FRS_MEMBER_TAB_CMD, 301004) { // from class: com.baidu.tieba.forumMember.member.e.1
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
                    e.this.dcl = false;
                    e.this.diW.errCode = responsedMessage.getError();
                    e.this.diW.errMsg = responsedMessage.getErrorString();
                    e.this.diW.hasMore = false;
                    e.this.diW.dpO = false;
                    e.this.diW.dpN = false;
                    e.this.diW.forumId = e.this.forumId;
                    e.this.diW.forumName = e.this.forumName;
                    e.this.diW.pn = 1;
                    if (e.this.diU != null) {
                        e.this.diU.a(3, 0, e.this.diW, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001352, e.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener dip = new CustomMessageListener(2003009) { // from class: com.baidu.tieba.forumMember.member.e.2
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
                e.this.diW.errCode = customResponsedMessage.getError();
                e.this.diW.errMsg = customResponsedMessage.getErrorString();
                e.this.diW.hasMore = false;
                e.this.diW.dpO = false;
                e.this.diW.dpN = false;
                e.this.diW.forumId = e.this.forumId;
                e.this.diW.forumName = e.this.forumName;
                e.this.diW.pn = 1;
                if (e.this.diU != null) {
                    ArrayList<com.baidu.adp.widget.ListView.h> a = e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo);
                    if (a == null || a.size() <= 0) {
                        if (!e.this.dcl) {
                            e.this.diU.a(3, 0, e.this.diW, a);
                        }
                    } else {
                        e.this.diU.a(3, 0, e.this.diW, a);
                    }
                }
                if (e.this.dcl) {
                    e.this.c(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener diX = new CustomMessageListener(2001266) { // from class: com.baidu.tieba.forumMember.member.e.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof r)) {
                e.this.diW.errCode = customResponsedMessage.getError();
                e.this.diW.errMsg = customResponsedMessage.getErrorString();
                e.this.diW.hasMore = false;
                e.this.diW.dpO = false;
                e.this.diW.dpN = false;
                e.this.diW.forumId = e.this.forumId;
                e.this.diW.forumName = e.this.forumName;
                e.this.diW.pn = 1;
                r rVar = (r) customResponsedMessage.getData();
                if (rVar != null && rVar.isLike() == 0 && e.this.mUserInfo != null) {
                    rVar.setCurScore(e.this.mUserInfo.getCurScore());
                    rVar.setLevelupScore(e.this.mUserInfo.getLevelupScore());
                }
                e.this.mUserInfo = rVar;
                if (e.this.diU != null) {
                    e.this.diU.a(3, 0, e.this.diW, e.this.a(e.this.mUserInfo, e.this.mMemberGroupInfoList, e.this.mMemberGodInfo, e.this.mManagerApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener diY = new CustomMessageListener(2001222) { // from class: com.baidu.tieba.forumMember.member.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                e.this.c(com.baidu.adp.lib.g.b.c(e.this.forumId, 0L), e.this.forumName);
            }
        }
    };

    public void mm(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.aRC != null) {
            forumMemberReadCacheRequestMessage.setTag(this.aRC);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void c(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.aRC != null) {
                forumMemberRequestMessage.setTag(this.aRC);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.diW.errCode = 0;
        this.diW.hasMore = false;
        this.diW.dpO = false;
        this.diW.dpN = false;
        this.diW.forumId = this.forumId;
        this.diW.forumName = this.forumName;
        this.diW.pn = 1;
        if (this.diU != null) {
            this.diU.a(3, 0, this.diW, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo));
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
                        mVar.fq(true);
                    } else {
                        mVar.fq(false);
                    }
                    arrayList.add(mVar);
                }
            }
        }
        a(memberGodInfo, arrayList);
        p pVar = new p();
        if (managerApplyInfo != null) {
            pVar.kh(managerApplyInfo.manager_left_num.intValue());
            pVar.mn(managerApplyInfo.manager_apply_url);
            pVar.kj(managerApplyInfo.assist_left_num.intValue());
            pVar.mo(managerApplyInfo.assist_apply_url);
            pVar.ki(managerApplyInfo.manager_apply_status.intValue());
        }
        arrayList.add(pVar);
        b bVar = new b();
        bVar.diP = f.j.complaint_bar_lord;
        bVar.mUrl = "https://tieba.baidu.com/n/interact/complainManager/" + this.forumId;
        arrayList.add(bVar);
        com.baidu.adp.widget.ListView.h ata = ata();
        if (ata != null) {
            arrayList.add(ata);
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

    private com.baidu.tieba.frs.i ata() {
        int f;
        if (this.mMemberGroupInfoList == null || this.mMemberGroupInfoList.size() <= 0) {
            return null;
        }
        com.baidu.tieba.frs.i iVar = new com.baidu.tieba.frs.i();
        int aj = com.baidu.adp.lib.util.l.aj(TbadkCoreApplication.getInst().getContext());
        int f2 = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds100);
        int f3 = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds90);
        int f4 = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds320);
        int size = this.mMemberGroupInfoList.size();
        if (TbadkCoreApplication.isLogin()) {
            f = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds300);
        } else {
            f = com.baidu.adp.lib.util.l.f(TbadkCoreApplication.getInst().getContext(), f.e.ds200);
        }
        iVar.setHeight(aj - ((f + (f2 + f3)) + (f4 * size)));
        iVar.kp(f.C0146f.transparent_bg);
        return iVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.aRC = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(int i, int i2, ao aoVar) {
        if (i == 3 && aoVar != null) {
            this.forumId = aoVar.forumId;
            this.forumName = aoVar.forumName;
            if (this.dcl) {
                mm(aoVar.forumName);
            } else if (aoVar.pn == -1) {
                c(com.baidu.adp.lib.g.b.c(aoVar.forumId, 0L), aoVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public void a(al alVar) {
        this.diU = alVar;
    }

    @Override // com.baidu.tieba.frs.ai
    public void init() {
        registerTask();
        if (this.aRC != null) {
            this.dip.setTag(this.aRC);
            this.cHp.setTag(this.aRC);
            this.dip.setSelfListener(true);
            if (this.cHp.getHttpMessageListener() != null) {
                this.cHp.getHttpMessageListener().setSelfListener(true);
            }
            if (this.cHp.getSocketMessageListener() != null) {
                this.cHp.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.dip);
        MessageManager.getInstance().registerListener(this.cHp);
        MessageManager.getInstance().registerListener(this.diX);
        MessageManager.getInstance().registerListener(this.diY);
    }

    @Override // com.baidu.tieba.frs.ai
    public void VA() {
        MessageManager.getInstance().unRegisterListener(this.cHp);
        MessageManager.getInstance().unRegisterListener(this.dip);
        MessageManager.getInstance().unRegisterListener(this.diX);
        MessageManager.getInstance().unRegisterListener(this.diY);
    }
}
