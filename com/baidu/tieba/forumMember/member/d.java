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
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.an;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.ax;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMemberInfo.ManagerApplyInfo;
import tbclient.GetMemberInfo.MemberGodInfo;
import tbclient.MemberGroupInfo;
import tbclient.PriManagerApplyInfo;
import tbclient.User;
/* loaded from: classes8.dex */
public class d implements an {
    private BdUniqueId fJu;
    private String forumId;
    private String forumName;
    private ar jbm;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private w mUserInfo;
    private boolean mIsPrivateForum = false;
    private boolean mIsBawuShow = false;
    private boolean iXY = true;
    private ba jbo = new ba();
    private com.baidu.adp.framework.listener.a jaH = new com.baidu.adp.framework.listener.a(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB) { // from class: com.baidu.tieba.forumMember.member.d.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof ForumMemberHttpResponseMessage) || (responsedMessage instanceof ForumMemberSocketResponseMessage)) {
                    if (responsedMessage.getError() == 0) {
                        if (responsedMessage instanceof ForumMemberHttpResponseMessage) {
                            ForumMemberHttpResponseMessage forumMemberHttpResponseMessage = (ForumMemberHttpResponseMessage) responsedMessage;
                            d.this.mUserInfo = forumMemberHttpResponseMessage.getUserInfo();
                            d.this.mMemberGroupInfoList = forumMemberHttpResponseMessage.getMemberGroupInfoList();
                            d.this.mMemberGodInfo = forumMemberHttpResponseMessage.getMemberGodInfo();
                            d.this.mManagerApplyInfo = forumMemberHttpResponseMessage.getManagerApplyInfo();
                            d.this.mIsBawuShow = forumMemberHttpResponseMessage.isBawuShow();
                            d.this.mIsPrivateForum = forumMemberHttpResponseMessage.isPrivateForum();
                            d.this.mPrivateMgrApplyInfo = forumMemberHttpResponseMessage.getPrivateMgrApplyInfo();
                        } else if (responsedMessage instanceof ForumMemberSocketResponseMessage) {
                            ForumMemberSocketResponseMessage forumMemberSocketResponseMessage = (ForumMemberSocketResponseMessage) responsedMessage;
                            d.this.mUserInfo = forumMemberSocketResponseMessage.getUserInfo();
                            d.this.mMemberGroupInfoList = forumMemberSocketResponseMessage.getMemberGroupInfoList();
                            d.this.mMemberGodInfo = forumMemberSocketResponseMessage.getMemberGodInfo();
                            d.this.mManagerApplyInfo = forumMemberSocketResponseMessage.getManagerApplyInfo();
                            d.this.mIsBawuShow = forumMemberSocketResponseMessage.isBawuShow();
                            d.this.mIsPrivateForum = forumMemberSocketResponseMessage.isPrivateForum();
                            d.this.mPrivateMgrApplyInfo = forumMemberSocketResponseMessage.getPrivateMgrApplyInfo();
                        }
                    }
                    d.this.iXY = false;
                    d.this.jbo.errCode = responsedMessage.getError();
                    d.this.jbo.errMsg = responsedMessage.getErrorString();
                    d.this.jbo.hasMore = false;
                    d.this.jbo.jkh = false;
                    d.this.jbo.aur = false;
                    d.this.jbo.forumId = d.this.forumId;
                    d.this.jbo.forumName = d.this.forumName;
                    d.this.jbo.pn = 1;
                    if (d.this.jbm != null) {
                        d.this.jbm.a(3, 0, d.this.jbo, d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP, d.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener jaI = new CustomMessageListener(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.member.d.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof ForumMemberReadCacheResponseMessage) {
                ForumMemberReadCacheResponseMessage forumMemberReadCacheResponseMessage = (ForumMemberReadCacheResponseMessage) customResponsedMessage;
                if (customResponsedMessage.getError() == 0) {
                    d.this.mUserInfo = forumMemberReadCacheResponseMessage.getUserInfo();
                    d.this.mMemberGroupInfoList = forumMemberReadCacheResponseMessage.getMemberGroupInfoList();
                    d.this.mMemberGodInfo = forumMemberReadCacheResponseMessage.getMemberGodInfo();
                    d.this.mManagerApplyInfo = forumMemberReadCacheResponseMessage.getManagerApplyInfo();
                    d.this.mIsBawuShow = forumMemberReadCacheResponseMessage.isBawuShow();
                    d.this.mIsPrivateForum = forumMemberReadCacheResponseMessage.isPrivateForum();
                    d.this.mPrivateMgrApplyInfo = forumMemberReadCacheResponseMessage.getPrivateMgrApplyInfo();
                }
                d.this.jbo.errCode = customResponsedMessage.getError();
                d.this.jbo.errMsg = customResponsedMessage.getErrorString();
                d.this.jbo.hasMore = false;
                d.this.jbo.jkh = false;
                d.this.jbo.aur = false;
                d.this.jbo.forumId = d.this.forumId;
                d.this.jbo.forumName = d.this.forumName;
                d.this.jbo.pn = 1;
                if (d.this.jbm != null) {
                    ArrayList<com.baidu.adp.widget.ListView.n> a2 = d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo);
                    if (a2 == null || a2.size() <= 0) {
                        if (!d.this.iXY) {
                            d.this.jbm.a(3, 0, d.this.jbo, a2);
                        }
                    } else {
                        d.this.jbm.a(3, 0, d.this.jbo, a2);
                    }
                }
                if (d.this.iXY) {
                    d.this.l(com.baidu.adp.lib.f.b.toLong(d.this.forumId, 0L), d.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener jbp = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.forumMember.member.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                d.this.jbo.errCode = customResponsedMessage.getError();
                d.this.jbo.errMsg = customResponsedMessage.getErrorString();
                d.this.jbo.hasMore = false;
                d.this.jbo.jkh = false;
                d.this.jbo.aur = false;
                d.this.jbo.forumId = d.this.forumId;
                d.this.jbo.forumName = d.this.forumName;
                d.this.jbo.pn = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.isLike() == 0 && d.this.mUserInfo != null) {
                    wVar.setCurScore(d.this.mUserInfo.getCurScore());
                    wVar.setLevelupScore(d.this.mUserInfo.getLevelupScore());
                }
                d.this.mUserInfo = wVar;
                if (d.this.jbm != null) {
                    d.this.jbm.a(3, 0, d.this.jbo, d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener jbq = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.forumMember.member.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d.this.l(com.baidu.adp.lib.f.b.toLong(d.this.forumId, 0L), d.this.forumName);
            }
        }
    };

    public void Kw(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.fJu != null) {
            forumMemberReadCacheRequestMessage.setTag(this.fJu);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void l(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.fJu != null) {
                forumMemberRequestMessage.setTag(this.fJu);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.jbo.errCode = 0;
        this.jbo.hasMore = false;
        this.jbo.jkh = false;
        this.jbo.aur = false;
        this.jbo.forumId = this.forumId;
        this.jbo.forumName = this.forumName;
        this.jbo.pn = 1;
        if (this.jbm != null) {
            this.jbm.a(3, 0, this.jbo, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo, this.mIsBawuShow, this.mIsPrivateForum, this.mPrivateMgrApplyInfo));
        }
    }

    public void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, ForumMemberSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_FRS_MEMBER_TAB, 1001706, TbConfig.GET_MEMBER_INFO, ForumMemberHttpResponseMessage.class, false, false, false, false);
        com.baidu.tieba.tbadkCore.a.a.e(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE, e.class);
    }

    public ArrayList<com.baidu.adp.widget.ListView.n> a(w wVar, List<MemberGroupInfo> list, MemberGodInfo memberGodInfo, ManagerApplyInfo managerApplyInfo, boolean z, boolean z2, PriManagerApplyInfo priManagerApplyInfo) {
        if (wVar == null) {
            return null;
        }
        ArrayList<com.baidu.adp.widget.ListView.n> arrayList = new ArrayList<>();
        if (wVar.isLike() == 1) {
            h hVar = new h();
            hVar.a(wVar);
            hVar.setForumId(this.forumId);
            hVar.setForumName(this.forumName);
            arrayList.add(hVar);
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (list.get(i) != null && list.get(i).member_group_num != null && list.get(i).member_group_num.intValue() > 0 && x.getCount(list.get(i).member_group_list) > 0) {
                    j jVar = new j();
                    jVar.setForumId(this.forumId);
                    jVar.setForumName(this.forumName);
                    jVar.a(list.get(i));
                    if (i == size - 1) {
                        jVar.qf(true);
                    } else {
                        jVar.qf(false);
                    }
                    arrayList.add(jVar);
                }
            }
        }
        if (this.mIsPrivateForum) {
            if (this.mIsBawuShow && priManagerApplyInfo != null) {
                n nVar = new n();
                if (nVar != null) {
                    nVar.zJ(priManagerApplyInfo.assist_left_num.intValue());
                    nVar.Ky(priManagerApplyInfo.assist_apply_url);
                    nVar.zK(priManagerApplyInfo.assist_apply_status.intValue());
                }
                arrayList.add(nVar);
            }
        } else {
            l lVar = new l();
            if (managerApplyInfo != null) {
                lVar.zH(managerApplyInfo.manager_left_num.intValue());
                lVar.Kx(managerApplyInfo.manager_apply_url);
                lVar.zJ(managerApplyInfo.assist_left_num.intValue());
                lVar.Ky(managerApplyInfo.assist_apply_url);
                lVar.zI(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(lVar);
            b bVar = new b();
            bVar.jbh = R.string.complaint_bar_lord;
            bVar.mUrl = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.forumId;
            arrayList.add(bVar);
        }
        a(memberGodInfo, arrayList);
        com.baidu.adp.widget.ListView.n cDs = cDs();
        if (cDs != null) {
            arrayList.add(cDs);
        }
        return arrayList;
    }

    private void a(MemberGodInfo memberGodInfo, ArrayList<com.baidu.adp.widget.ListView.n> arrayList) {
        if (memberGodInfo != null && memberGodInfo.forum_god_list != null && memberGodInfo.forum_god_list.size() > 0 && arrayList != null) {
            List<User> list = memberGodInfo.forum_god_list;
            if (memberGodInfo.forum_god_num.intValue() != 0 && list.size() != 0) {
                com.baidu.tieba.forumMember.manito.b bVar = new com.baidu.tieba.forumMember.manito.b();
                bVar.a(memberGodInfo);
                arrayList.add(bVar);
                boolean z = false;
                for (int i = 0; i < list.size(); i++) {
                    User user = list.get(i);
                    if (user != null && user.god_data.type.intValue() == 2) {
                        com.baidu.tieba.forumMember.manito.d dVar = new com.baidu.tieba.forumMember.manito.d();
                        dVar.a(user, i);
                        arrayList.add(dVar);
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

    private com.baidu.tieba.frs.n cDs() {
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
        nVar.zR(R.drawable.transparent_bg);
        return nVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fJu = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        if (i == 3 && axVar != null) {
            this.forumId = axVar.forumId;
            this.forumName = axVar.forumName;
            if (this.iXY) {
                Kw(axVar.forumName);
            } else if (axVar.pn == -1) {
                l(com.baidu.adp.lib.f.b.toLong(axVar.forumId, 0L), axVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.jbm = arVar;
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        registerTask();
        if (this.fJu != null) {
            this.jaI.setTag(this.fJu);
            this.jaH.setTag(this.fJu);
            this.jaI.setSelfListener(true);
            if (this.jaH.getHttpMessageListener() != null) {
                this.jaH.getHttpMessageListener().setSelfListener(true);
            }
            if (this.jaH.getSocketMessageListener() != null) {
                this.jaH.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.jaI);
        MessageManager.getInstance().registerListener(this.jaH);
        MessageManager.getInstance().registerListener(this.jbp);
        MessageManager.getInstance().registerListener(this.jbq);
    }

    @Override // com.baidu.tieba.frs.an
    public void cbH() {
        MessageManager.getInstance().unRegisterListener(this.jaH);
        MessageManager.getInstance().unRegisterListener(this.jaI);
        MessageManager.getInstance().unRegisterListener(this.jbp);
        MessageManager.getInstance().unRegisterListener(this.jbq);
    }
}
