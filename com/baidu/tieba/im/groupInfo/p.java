package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.aw;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.model.br;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.framework.c.g {
    final /* synthetic */ GroupInfoActivity a;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.im.model.l lVar;
        com.baidu.adp.framework.message.d<?> h;
        com.baidu.tieba.im.model.l lVar2;
        String[] split;
        com.baidu.tieba.im.model.l lVar3;
        com.baidu.tieba.im.model.l lVar4;
        r rVar;
        com.baidu.tieba.im.model.l lVar5;
        r rVar2;
        com.baidu.tieba.im.model.l lVar6;
        r rVar3;
        com.baidu.tieba.im.model.l lVar7;
        r rVar4;
        com.baidu.tieba.im.model.l lVar8;
        r rVar5;
        int i;
        com.baidu.tieba.im.model.l lVar9;
        br brVar;
        com.baidu.tieba.im.model.l lVar10;
        br brVar2;
        com.baidu.tieba.im.model.l lVar11;
        br brVar3;
        com.baidu.tieba.im.model.l lVar12;
        com.baidu.tieba.im.model.l lVar13;
        com.baidu.tieba.im.model.l lVar14;
        r rVar6;
        com.baidu.tieba.im.model.l lVar15;
        r rVar7;
        com.baidu.tieba.im.model.l lVar16;
        com.baidu.tieba.im.model.l lVar17;
        r rVar8;
        com.baidu.tieba.im.model.l lVar18;
        com.baidu.tieba.im.model.l lVar19;
        r rVar9;
        com.baidu.tieba.im.model.l lVar20;
        com.baidu.tieba.im.model.l lVar21;
        r rVar10;
        com.baidu.tieba.im.model.l lVar22;
        com.baidu.adp.framework.message.d<?> h2;
        com.baidu.tieba.im.model.l lVar23;
        r rVar11;
        com.baidu.tieba.im.model.l lVar24;
        r rVar12;
        com.baidu.tieba.im.model.l lVar25;
        com.baidu.tieba.im.model.l lVar26;
        r rVar13;
        com.baidu.tieba.im.model.l lVar27;
        r rVar14;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null) {
            rVar14 = this.a.f;
            rVar14.r();
            this.a.showToast(com.baidu.tieba.im.j.neterror);
        } else if (socketResponsedMessage2.g() == 103004) {
            rVar12 = this.a.f;
            rVar12.r();
            if (!(socketResponsedMessage2 instanceof ResponseGroupInfoMessage)) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            }
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) socketResponsedMessage2;
            lVar25 = this.a.g;
            if (lVar25.k() == responseGroupInfoMessage.h()) {
                if (responseGroupInfoMessage.e() == 2230101) {
                    this.a.showToast(responseGroupInfoMessage.f(), false);
                    this.a.finish();
                } else if (responseGroupInfoMessage.d() == null || responseGroupInfoMessage.e() != 0) {
                    this.a.showToast(com.baidu.tieba.im.j.neterror);
                } else {
                    GroupInfoActivity.c(this.a);
                    lVar26 = this.a.g;
                    lVar26.a(responseGroupInfoMessage.d());
                    if (responseGroupInfoMessage == null || responseGroupInfoMessage.d().g()) {
                        rVar13 = this.a.f;
                        rVar13.a(responseGroupInfoMessage.d(), false);
                        return;
                    }
                    aa a = aa.a();
                    String E = TbadkApplication.E();
                    lVar27 = this.a.g;
                    a.a(E, String.valueOf(lVar27.d()), 60000L, new q(this, responseGroupInfoMessage));
                }
            }
        } else if (socketResponsedMessage2.g() == 103110) {
            if (socketResponsedMessage2 instanceof ResponseJoinGroupMessage) {
                ResponseJoinGroupMessage responseJoinGroupMessage = (ResponseJoinGroupMessage) socketResponsedMessage2;
                if (responseJoinGroupMessage.e() == 0 && (h2 = responseJoinGroupMessage.h()) != null && (h2 instanceof am)) {
                    lVar23 = this.a.g;
                    if (((am) h2).i() == lVar23.d()) {
                        rVar11 = this.a.f;
                        rVar11.y();
                        lVar24 = this.a.g;
                        lVar24.a(true);
                        this.a.c();
                    }
                }
            }
        } else if (socketResponsedMessage2.g() == 103102) {
            rVar5 = this.a.f;
            rVar5.r();
            if (!(socketResponsedMessage2 instanceof ResponseUpdateGroupMessage)) {
                this.a.showToast(com.baidu.tieba.im.j.neterror);
                return;
            }
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) socketResponsedMessage2;
            if (responseUpdateGroupMessage.e() != 0) {
                this.a.showToast(responseUpdateGroupMessage.f());
            } else if (responseUpdateGroupMessage.h() instanceof bg) {
                int i2 = ((bg) responseUpdateGroupMessage.h()).i();
                i = this.a.e;
                switch (i) {
                    case 1:
                        if (i2 == 3) {
                            lVar21 = this.a.g;
                            lVar21.i();
                            rVar10 = this.a.f;
                            lVar22 = this.a.g;
                            rVar10.b(lVar22.f());
                            return;
                        }
                        return;
                    case 2:
                        if (i2 == 3) {
                            lVar19 = this.a.g;
                            lVar19.h();
                            rVar9 = this.a.f;
                            lVar20 = this.a.g;
                            rVar9.b(lVar20.f());
                            return;
                        }
                        return;
                    case 3:
                        if (i2 == 4) {
                            lVar17 = this.a.g;
                            lVar17.j();
                            rVar8 = this.a.f;
                            lVar18 = this.a.g;
                            rVar8.b(lVar18.f());
                            return;
                        }
                        return;
                    case 4:
                        lVar9 = this.a.g;
                        GroupData b = lVar9.f().b();
                        brVar = this.a.h;
                        b.setFlag(brVar.c());
                        lVar10 = this.a.g;
                        GroupData b2 = lVar10.f().b();
                        brVar2 = this.a.h;
                        b2.setPosition(brVar2.a());
                        lVar11 = this.a.g;
                        GroupData b3 = lVar11.f().b();
                        brVar3 = this.a.h;
                        b3.setBusiness(brVar3.b());
                        lVar12 = this.a.g;
                        if ((lVar12.f().b().getFlag() & 1) == 1) {
                            rVar7 = this.a.f;
                            lVar16 = this.a.g;
                            rVar7.a(lVar16.f().h());
                        } else {
                            lVar13 = this.a.g;
                            String position = lVar13.f().b().getPosition();
                            lVar14 = this.a.g;
                            String business = lVar14.f().b().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            rVar6 = this.a.f;
                            lVar15 = this.a.g;
                            rVar6.a(lVar15.f().h(), stringBuffer.toString());
                        }
                        this.a.showToast(com.baidu.tieba.im.j.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (socketResponsedMessage2.g() != 103112) {
            if (socketResponsedMessage2.g() == 103104) {
                if (socketResponsedMessage2 instanceof ResponseDismissGroupMessage) {
                    ResponseDismissGroupMessage responseDismissGroupMessage = (ResponseDismissGroupMessage) socketResponsedMessage2;
                    if (responseDismissGroupMessage.e() == 0) {
                        lVar = this.a.g;
                        if (lVar.d() == responseDismissGroupMessage.d()) {
                            this.a.finish();
                        }
                    }
                }
            } else if (socketResponsedMessage2.g() == 103105) {
                if (socketResponsedMessage2 instanceof ResponseUpgradeMemberGroupMessage) {
                    ResponseUpgradeMemberGroupMessage responseUpgradeMemberGroupMessage = (ResponseUpgradeMemberGroupMessage) socketResponsedMessage2;
                    if (responseUpgradeMemberGroupMessage.e() == 0 || responseUpgradeMemberGroupMessage.e() == 2230110) {
                        this.a.b();
                    }
                }
            } else if (socketResponsedMessage2.g() == 103120) {
                if (socketResponsedMessage2 instanceof ResponseCreateGroupActivityMessage) {
                    this.a.b();
                }
            } else if (socketResponsedMessage2.g() == 103121 && (socketResponsedMessage2 instanceof ResponseDelGroupActivityMessage)) {
                this.a.b();
            }
        } else if (socketResponsedMessage2 instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) socketResponsedMessage2;
            if (responseRemoveMembersMessage.e() == 0 && (h = responseRemoveMembersMessage.h()) != null && (h instanceof aw)) {
                aw awVar = (aw) h;
                long i3 = awVar.i();
                lVar2 = this.a.g;
                if (i3 == lVar2.d()) {
                    String j = awVar.j();
                    if (TextUtils.isEmpty(j) || (split = j.split(",")) == null || split.length == 0) {
                        return;
                    }
                    String id = TbadkApplication.N().getID();
                    if (TextUtils.isEmpty(id)) {
                        return;
                    }
                    for (String str : split) {
                        if (id.equals(str)) {
                            lVar3 = this.a.g;
                            lVar3.f().a(false);
                            lVar4 = this.a.g;
                            lVar4.a(false);
                            rVar = this.a.f;
                            lVar5 = this.a.g;
                            rVar.a(lVar5.f(), true);
                            rVar2 = this.a.f;
                            rVar2.c(str);
                            this.a.c();
                            return;
                        }
                        lVar6 = this.a.g;
                        if (lVar6.a(str)) {
                            rVar3 = this.a.f;
                            rVar3.c(str);
                            lVar7 = this.a.g;
                            GroupData b4 = lVar7.f().b();
                            if (b4 != null && b4.getMemberNum() > 1) {
                                b4.setMemberNum(b4.getMemberNum() - 1);
                            }
                            rVar4 = this.a.f;
                            lVar8 = this.a.g;
                            rVar4.a(lVar8.f());
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(GroupInfoActivity groupInfoActivity) {
        super(0);
        this.a = groupInfoActivity;
    }
}
