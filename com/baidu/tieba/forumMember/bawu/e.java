package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tieba.forumMember.member.l;
import java.util.ArrayList;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes7.dex */
public class e {
    private a iVZ = null;
    private com.baidu.adp.framework.listener.a iWa = new com.baidu.adp.framework.listener.a(1001705, CmdConfigSocket.CMD_BAWU_TEAM_INFO) { // from class: com.baidu.tieba.forumMember.bawu.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BawuTeamHttpResponseMessage) || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                    if (responsedMessage instanceof BawuTeamHttpResponseMessage) {
                        BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                        e.this.mBawuTeamInfo = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                        e.this.mIsPrivateForum = bawuTeamHttpResponseMessage.isPrivateForum() != 0;
                        e.this.mManagerApplyInfo = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                    } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                        BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                        e.this.mBawuTeamInfo = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                        e.this.mIsPrivateForum = bawuTeamSocketResponseMessage.isPrivateForum() != 0;
                        e.this.mManagerApplyInfo = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                    }
                    l lVar = new l();
                    if (e.this.mManagerApplyInfo != null) {
                        lVar.yb(e.this.mManagerApplyInfo.manager_left_num.intValue());
                        lVar.Jm(e.this.mManagerApplyInfo.manager_apply_url);
                        lVar.yd(e.this.mManagerApplyInfo.assist_left_num.intValue());
                        lVar.Jn(e.this.mManagerApplyInfo.assist_apply_url);
                    }
                    if (e.this.iVZ != null) {
                        e.this.iVZ.a(e.this.a(e.this.mBawuTeamInfo), lVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private CustomMessageListener iWb = new CustomMessageListener(CmdConfigCustom.CMD_BAWU_TEAM_INFO_CACHE) { // from class: com.baidu.tieba.forumMember.bawu.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                e.this.mBawuTeamInfo = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                e.this.mIsPrivateForum = bawuTeamReadCacheResponseMessage.isPrivateForum() != 0;
                e.this.mManagerApplyInfo = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                l lVar = new l();
                if (e.this.mManagerApplyInfo != null) {
                    lVar.yb(e.this.mManagerApplyInfo.manager_left_num.intValue());
                    lVar.Jm(e.this.mManagerApplyInfo.manager_apply_url);
                    lVar.yd(e.this.mManagerApplyInfo.assist_left_num.intValue());
                    lVar.Jn(e.this.mManagerApplyInfo.assist_apply_url);
                }
                if (e.this.iVZ != null) {
                    e.this.iVZ.a(e.this.a(e.this.mBawuTeamInfo), lVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    };
    private BawuTeam mBawuTeamInfo;
    private boolean mIsPrivateForum;
    private ManagerApplyInfo mManagerApplyInfo;

    /* loaded from: classes7.dex */
    public interface a {
        void a(ArrayList<i> arrayList, l lVar, boolean z, int i, String str);
    }

    public e() {
        MessageManager.getInstance().registerListener(this.iWb);
        MessageManager.getInstance().registerListener(this.iWa);
    }

    public void gj(long j) {
        BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
        bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
        MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
    }

    public void gk(long j) {
        BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
        bawuTeamRequestMessage.setForumId(j);
        MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.iWa);
        MessageManager.getInstance().unRegisterListener(this.iWb);
    }

    public void a(a aVar) {
        this.iVZ = aVar;
    }

    public ArrayList<i> a(BawuTeam bawuTeam) {
        ArrayList<i> arrayList = new ArrayList<>();
        if (bawuTeam == null || bawuTeam.bawu_team_list == null) {
            return null;
        }
        int size = bawuTeam.bawu_team_list.size();
        for (int i = 0; i < size; i++) {
            BawuRoleDes bawuRoleDes = bawuTeam.bawu_team_list.get(i);
            if (bawuRoleDes != null && !StringUtils.isNull(bawuRoleDes.role_name) && bawuRoleDes.role_info != null && bawuRoleDes.role_info.size() > 0) {
                c cVar = new c();
                cVar.setTitle(bawuRoleDes.role_name + "(" + bawuRoleDes.role_info.size() + ")");
                arrayList.add(cVar);
                int size2 = bawuRoleDes.role_info.size();
                int i2 = 0;
                while (i2 < size2) {
                    b bVar = new b();
                    bVar.Ji(bawuRoleDes.role_name);
                    ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                    arrayList2.add(bawuRoleDes.role_info.get(i2));
                    if (i2 + 1 < size2) {
                        arrayList2.add(bawuRoleDes.role_info.get(i2 + 1));
                    }
                    i2 += 2;
                    if (i2 >= size2) {
                        if (this.mIsPrivateForum) {
                            bVar.qc(false);
                        } else {
                            bVar.qc(true);
                        }
                        bVar.qb(true);
                    } else {
                        bVar.qb(false);
                    }
                    bVar.as(arrayList2);
                    arrayList.add(bVar);
                }
                if (i <= size - 2) {
                    arrayList.add(new com.baidu.tieba.forumMember.bawu.a());
                }
            }
        }
        return arrayList;
    }
}
