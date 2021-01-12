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
/* loaded from: classes7.dex */
public class d implements an {
    private BdUniqueId fEN;
    private String forumId;
    private String forumName;
    private ar iWF;
    private ManagerApplyInfo mManagerApplyInfo;
    private MemberGodInfo mMemberGodInfo;
    private List<MemberGroupInfo> mMemberGroupInfoList;
    private PriManagerApplyInfo mPrivateMgrApplyInfo;
    private w mUserInfo;
    private boolean mIsPrivateForum = false;
    private boolean mIsBawuShow = false;
    private boolean iTr = true;
    private ba iWH = new ba();
    private com.baidu.adp.framework.listener.a iWa = new com.baidu.adp.framework.listener.a(1001706, CmdConfigSocket.CMD_FRS_MEMBER_TAB) { // from class: com.baidu.tieba.forumMember.member.d.1
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
                    d.this.iTr = false;
                    d.this.iWH.errCode = responsedMessage.getError();
                    d.this.iWH.errMsg = responsedMessage.getErrorString();
                    d.this.iWH.hasMore = false;
                    d.this.iWH.jfA = false;
                    d.this.iWH.jfz = false;
                    d.this.iWH.forumId = d.this.forumId;
                    d.this.iWH.forumName = d.this.forumName;
                    d.this.iWH.pn = 1;
                    if (d.this.iWF != null) {
                        d.this.iWF.a(3, 0, d.this.iWH, d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo));
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPERIENCE_TIP, d.this.mUserInfo));
                }
            }
        }
    };
    private CustomMessageListener iWb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_MEMBER_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.member.d.2
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
                d.this.iWH.errCode = customResponsedMessage.getError();
                d.this.iWH.errMsg = customResponsedMessage.getErrorString();
                d.this.iWH.hasMore = false;
                d.this.iWH.jfA = false;
                d.this.iWH.jfz = false;
                d.this.iWH.forumId = d.this.forumId;
                d.this.iWH.forumName = d.this.forumName;
                d.this.iWH.pn = 1;
                if (d.this.iWF != null) {
                    ArrayList<com.baidu.adp.widget.ListView.n> a2 = d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo);
                    if (a2 == null || a2.size() <= 0) {
                        if (!d.this.iTr) {
                            d.this.iWF.a(3, 0, d.this.iWH, a2);
                        }
                    } else {
                        d.this.iWF.a(3, 0, d.this.iWH, a2);
                    }
                }
                if (d.this.iTr) {
                    d.this.l(com.baidu.adp.lib.f.b.toLong(d.this.forumId, 0L), d.this.forumName);
                }
            }
        }
    };
    private CustomMessageListener iWI = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_FRS_LIKE_STATUS) { // from class: com.baidu.tieba.forumMember.member.d.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof w)) {
                d.this.iWH.errCode = customResponsedMessage.getError();
                d.this.iWH.errMsg = customResponsedMessage.getErrorString();
                d.this.iWH.hasMore = false;
                d.this.iWH.jfA = false;
                d.this.iWH.jfz = false;
                d.this.iWH.forumId = d.this.forumId;
                d.this.iWH.forumName = d.this.forumName;
                d.this.iWH.pn = 1;
                w wVar = (w) customResponsedMessage.getData();
                if (wVar != null && wVar.isLike() == 0 && d.this.mUserInfo != null) {
                    wVar.setCurScore(d.this.mUserInfo.getCurScore());
                    wVar.setLevelupScore(d.this.mUserInfo.getLevelupScore());
                }
                d.this.mUserInfo = wVar;
                if (d.this.iWF != null) {
                    d.this.iWF.a(3, 0, d.this.iWH, d.this.a(d.this.mUserInfo, d.this.mMemberGroupInfoList, d.this.mMemberGodInfo, d.this.mManagerApplyInfo, d.this.mIsBawuShow, d.this.mIsPrivateForum, d.this.mPrivateMgrApplyInfo));
                }
            }
        }
    };
    private CustomMessageListener iWJ = new CustomMessageListener(CmdConfigCustom.CMD_SIGN_REFRESH_SIGN_STATE) { // from class: com.baidu.tieba.forumMember.member.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof SignData)) {
                d.this.l(com.baidu.adp.lib.f.b.toLong(d.this.forumId, 0L), d.this.forumName);
            }
        }
    };

    public void Jl(String str) {
        ForumMemberReadCacheRequestMessage forumMemberReadCacheRequestMessage = new ForumMemberReadCacheRequestMessage();
        if (this.fEN != null) {
            forumMemberReadCacheRequestMessage.setTag(this.fEN);
        }
        forumMemberReadCacheRequestMessage.setForumName(str);
        MessageManager.getInstance().sendMessage(forumMemberReadCacheRequestMessage);
    }

    public void l(long j, String str) {
        if (j > 0 && !StringUtils.isNull(str)) {
            ForumMemberRequestMessage forumMemberRequestMessage = new ForumMemberRequestMessage();
            if (this.fEN != null) {
                forumMemberRequestMessage.setTag(this.fEN);
            }
            forumMemberRequestMessage.setForumId(j);
            forumMemberRequestMessage.setForumName(str);
            MessageManager.getInstance().sendMessage(forumMemberRequestMessage);
        }
    }

    private void refreshData() {
        this.iWH.errCode = 0;
        this.iWH.hasMore = false;
        this.iWH.jfA = false;
        this.iWH.jfz = false;
        this.iWH.forumId = this.forumId;
        this.iWH.forumName = this.forumName;
        this.iWH.pn = 1;
        if (this.iWF != null) {
            this.iWF.a(3, 0, this.iWH, a(this.mUserInfo, this.mMemberGroupInfoList, this.mMemberGodInfo, this.mManagerApplyInfo, this.mIsBawuShow, this.mIsPrivateForum, this.mPrivateMgrApplyInfo));
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
                        jVar.qb(true);
                    } else {
                        jVar.qb(false);
                    }
                    arrayList.add(jVar);
                }
            }
        }
        if (this.mIsPrivateForum) {
            if (this.mIsBawuShow && priManagerApplyInfo != null) {
                n nVar = new n();
                if (nVar != null) {
                    nVar.yd(priManagerApplyInfo.assist_left_num.intValue());
                    nVar.Jn(priManagerApplyInfo.assist_apply_url);
                    nVar.ye(priManagerApplyInfo.assist_apply_status.intValue());
                }
                arrayList.add(nVar);
            }
        } else {
            l lVar = new l();
            if (managerApplyInfo != null) {
                lVar.yb(managerApplyInfo.manager_left_num.intValue());
                lVar.Jm(managerApplyInfo.manager_apply_url);
                lVar.yd(managerApplyInfo.assist_left_num.intValue());
                lVar.Jn(managerApplyInfo.assist_apply_url);
                lVar.yc(managerApplyInfo.manager_apply_status.intValue());
            }
            arrayList.add(lVar);
            b bVar = new b();
            bVar.iWA = R.string.complaint_bar_lord;
            bVar.mUrl = "https://tieba.baidu.com/tb/cms/redpacket/page/complain.html?id=" + this.forumId;
            arrayList.add(bVar);
        }
        a(memberGodInfo, arrayList);
        com.baidu.adp.widget.ListView.n czA = czA();
        if (czA != null) {
            arrayList.add(czA);
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

    private com.baidu.tieba.frs.n czA() {
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
        nVar.yl(R.drawable.transparent_bg);
        return nVar;
    }

    public void setTag(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            this.fEN = bdUniqueId;
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(int i, int i2, ax axVar) {
        if (i == 3 && axVar != null) {
            this.forumId = axVar.forumId;
            this.forumName = axVar.forumName;
            if (this.iTr) {
                Jl(axVar.forumName);
            } else if (axVar.pn == -1) {
                l(com.baidu.adp.lib.f.b.toLong(axVar.forumId, 0L), axVar.forumName);
            } else {
                refreshData();
            }
        }
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ar arVar) {
        this.iWF = arVar;
    }

    @Override // com.baidu.tieba.frs.an
    public void init() {
        registerTask();
        if (this.fEN != null) {
            this.iWb.setTag(this.fEN);
            this.iWa.setTag(this.fEN);
            this.iWb.setSelfListener(true);
            if (this.iWa.getHttpMessageListener() != null) {
                this.iWa.getHttpMessageListener().setSelfListener(true);
            }
            if (this.iWa.getSocketMessageListener() != null) {
                this.iWa.getSocketMessageListener().setSelfListener(true);
            }
        }
        MessageManager.getInstance().registerListener(this.iWb);
        MessageManager.getInstance().registerListener(this.iWa);
        MessageManager.getInstance().registerListener(this.iWI);
        MessageManager.getInstance().registerListener(this.iWJ);
    }

    @Override // com.baidu.tieba.frs.an
    public void bXP() {
        MessageManager.getInstance().unRegisterListener(this.iWa);
        MessageManager.getInstance().unRegisterListener(this.iWb);
        MessageManager.getInstance().unRegisterListener(this.iWI);
        MessageManager.getInstance().unRegisterListener(this.iWJ);
    }
}
