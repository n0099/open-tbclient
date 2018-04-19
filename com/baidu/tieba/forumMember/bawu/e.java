package com.baidu.tieba.forumMember.bawu;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.forumMember.member.p;
import java.util.ArrayList;
import tbclient.BawuRoleDes;
import tbclient.BawuRoleInfoPub;
import tbclient.BawuTeam;
import tbclient.GetBawuInfo.ManagerApplyInfo;
/* loaded from: classes3.dex */
public class e {
    private BawuTeam mBawuTeamInfo;
    private ManagerApplyInfo mManagerApplyInfo;
    private a cTv = null;
    private com.baidu.adp.framework.listener.a cxj = new com.baidu.adp.framework.listener.a(CmdConfigHttp.BAWU_TEAM_INFO_CMD, 301007) { // from class: com.baidu.tieba.forumMember.bawu.e.1
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null) {
                if ((responsedMessage instanceof BawuTeamHttpResponseMessage) || (responsedMessage instanceof BawuTeamSocketResponseMessage)) {
                    if (responsedMessage instanceof BawuTeamHttpResponseMessage) {
                        BawuTeamHttpResponseMessage bawuTeamHttpResponseMessage = (BawuTeamHttpResponseMessage) responsedMessage;
                        e.this.mBawuTeamInfo = bawuTeamHttpResponseMessage.getBawuTeamInfo();
                        e.this.mManagerApplyInfo = bawuTeamHttpResponseMessage.getManagerApplyInfo();
                    } else if (responsedMessage instanceof BawuTeamSocketResponseMessage) {
                        BawuTeamSocketResponseMessage bawuTeamSocketResponseMessage = (BawuTeamSocketResponseMessage) responsedMessage;
                        e.this.mBawuTeamInfo = bawuTeamSocketResponseMessage.getBawuTeamInfo();
                        e.this.mManagerApplyInfo = bawuTeamSocketResponseMessage.getManagerApplyInfo();
                    }
                    p pVar = new p();
                    if (e.this.mManagerApplyInfo != null) {
                        pVar.jS(e.this.mManagerApplyInfo.manager_left_num.intValue());
                        pVar.lC(e.this.mManagerApplyInfo.manager_apply_url);
                        pVar.jU(e.this.mManagerApplyInfo.assist_left_num.intValue());
                        pVar.lD(e.this.mManagerApplyInfo.assist_apply_url);
                    }
                    if (e.this.cTv != null) {
                        e.this.cTv.a(e.this.a(e.this.mBawuTeamInfo), pVar, true, responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                }
            }
        }
    };
    private CustomMessageListener cTw = new CustomMessageListener(2003005) { // from class: com.baidu.tieba.forumMember.bawu.e.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof BawuTeamReadCacheResponseMessage)) {
                BawuTeamReadCacheResponseMessage bawuTeamReadCacheResponseMessage = (BawuTeamReadCacheResponseMessage) customResponsedMessage;
                e.this.mBawuTeamInfo = bawuTeamReadCacheResponseMessage.getBawuTeamInfo();
                e.this.mManagerApplyInfo = bawuTeamReadCacheResponseMessage.getManagerApplyInfo();
                p pVar = new p();
                if (e.this.mManagerApplyInfo != null) {
                    pVar.jS(e.this.mManagerApplyInfo.manager_left_num.intValue());
                    pVar.lC(e.this.mManagerApplyInfo.manager_apply_url);
                    pVar.jU(e.this.mManagerApplyInfo.assist_left_num.intValue());
                    pVar.lD(e.this.mManagerApplyInfo.assist_apply_url);
                }
                if (e.this.cTv != null) {
                    e.this.cTv.a(e.this.a(e.this.mBawuTeamInfo), pVar, false, customResponsedMessage.getError(), customResponsedMessage.getErrorString());
                }
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface a {
        void a(ArrayList<i> arrayList, p pVar, boolean z, int i, String str);
    }

    public e() {
        MessageManager.getInstance().registerListener(this.cTw);
        MessageManager.getInstance().registerListener(this.cxj);
    }

    public void bA(long j) {
        BawuTeamInfoReadCacheRequestMessage bawuTeamInfoReadCacheRequestMessage = new BawuTeamInfoReadCacheRequestMessage();
        bawuTeamInfoReadCacheRequestMessage.setCacheKey("" + j);
        MessageManager.getInstance().sendMessage(bawuTeamInfoReadCacheRequestMessage);
    }

    public void bB(long j) {
        BawuTeamRequestMessage bawuTeamRequestMessage = new BawuTeamRequestMessage();
        bawuTeamRequestMessage.setForumId(j);
        MessageManager.getInstance().sendMessage(bawuTeamRequestMessage);
    }

    public void destroy() {
        MessageManager.getInstance().unRegisterListener(this.cxj);
        MessageManager.getInstance().unRegisterListener(this.cTw);
    }

    public void a(a aVar) {
        this.cTv = aVar;
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
                    bVar.ly(bawuRoleDes.role_name);
                    ArrayList<BawuRoleInfoPub> arrayList2 = new ArrayList<>();
                    arrayList2.add(bawuRoleDes.role_info.get(i2));
                    if (i2 + 1 < size2) {
                        arrayList2.add(bawuRoleDes.role_info.get(i2 + 1));
                    }
                    i2 += 2;
                    if (i2 >= size2) {
                        bVar.fj(true);
                    } else {
                        bVar.fj(false);
                    }
                    bVar.H(arrayList2);
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
