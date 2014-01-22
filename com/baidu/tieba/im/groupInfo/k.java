package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.ba;
import com.baidu.tieba.im.message.bn;
import com.baidu.tieba.im.message.br;
import com.baidu.tieba.im.message.cg;
import com.baidu.tieba.im.message.cn;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.model.ao;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupInfoActivity a;

    private k(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(GroupInfoActivity groupInfoActivity, i iVar) {
        this(groupInfoActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public void a(com.baidu.tieba.im.message.q qVar) {
        com.baidu.tieba.im.model.e eVar;
        com.baidu.tieba.im.message.q n;
        com.baidu.tieba.im.model.e eVar2;
        String[] split;
        com.baidu.tieba.im.model.e eVar3;
        com.baidu.tieba.im.model.e eVar4;
        m mVar;
        com.baidu.tieba.im.model.e eVar5;
        m mVar2;
        com.baidu.tieba.im.model.e eVar6;
        m mVar3;
        com.baidu.tieba.im.model.e eVar7;
        m mVar4;
        com.baidu.tieba.im.model.e eVar8;
        m mVar5;
        int i;
        com.baidu.tieba.im.model.e eVar9;
        ao aoVar;
        com.baidu.tieba.im.model.e eVar10;
        ao aoVar2;
        com.baidu.tieba.im.model.e eVar11;
        ao aoVar3;
        com.baidu.tieba.im.model.e eVar12;
        com.baidu.tieba.im.model.e eVar13;
        com.baidu.tieba.im.model.e eVar14;
        m mVar6;
        com.baidu.tieba.im.model.e eVar15;
        m mVar7;
        com.baidu.tieba.im.model.e eVar16;
        com.baidu.tieba.im.model.e eVar17;
        m mVar8;
        com.baidu.tieba.im.model.e eVar18;
        com.baidu.tieba.im.model.e eVar19;
        m mVar9;
        com.baidu.tieba.im.model.e eVar20;
        com.baidu.tieba.im.model.e eVar21;
        m mVar10;
        com.baidu.tieba.im.model.e eVar22;
        com.baidu.tieba.im.message.q n2;
        com.baidu.tieba.im.model.e eVar23;
        m mVar11;
        com.baidu.tieba.im.model.e eVar24;
        m mVar12;
        com.baidu.tieba.im.model.e eVar25;
        com.baidu.tieba.im.model.e eVar26;
        m mVar13;
        com.baidu.tieba.im.model.e eVar27;
        com.baidu.tieba.im.model.e eVar28;
        com.baidu.tieba.im.model.e eVar29;
        m mVar14;
        com.baidu.tieba.im.model.e eVar30;
        com.baidu.tieba.im.model.e eVar31;
        com.baidu.tieba.im.model.e eVar32;
        com.baidu.tieba.im.model.e eVar33;
        com.baidu.tieba.im.model.e eVar34;
        com.baidu.tieba.im.model.e eVar35;
        com.baidu.tieba.im.model.e eVar36;
        com.baidu.tieba.im.model.e eVar37;
        com.baidu.tieba.im.model.e eVar38;
        m mVar15;
        if (qVar == null) {
            mVar15 = this.a.f;
            mVar15.q();
            this.a.showToast(R.string.neterror);
        } else if (qVar.w() == -102) {
            if (!(qVar instanceof br)) {
                eVar36 = this.a.g;
                eVar37 = this.a.g;
                long d = eVar37.d();
                eVar38 = this.a.g;
                eVar36.a(d, eVar38.e());
                return;
            }
            br brVar = (br) qVar;
            eVar28 = this.a.g;
            if (eVar28.l() == brVar.n()) {
                if (brVar.k()) {
                    eVar33 = this.a.g;
                    eVar34 = this.a.g;
                    long d2 = eVar34.d();
                    eVar35 = this.a.g;
                    eVar33.a(d2, eVar35.e());
                    return;
                }
                this.a.d();
                eVar29 = this.a.g;
                eVar29.a(brVar);
                mVar14 = this.a.f;
                mVar14.a(brVar);
                eVar30 = this.a.g;
                eVar31 = this.a.g;
                long d3 = eVar31.d();
                eVar32 = this.a.g;
                eVar30.a(d3, eVar32.e());
            }
        } else if (qVar.w() == 103004) {
            mVar12 = this.a.f;
            mVar12.q();
            if (!(qVar instanceof br)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            br brVar2 = (br) qVar;
            eVar25 = this.a.g;
            if (eVar25.m() == brVar2.n()) {
                if (brVar2.l() == 2230101) {
                    this.a.showToast(brVar2.m(), false);
                    this.a.finish();
                } else if (!brVar2.k()) {
                    this.a.d();
                    eVar26 = this.a.g;
                    eVar26.a(brVar2);
                    if (brVar2 == null || brVar2.f()) {
                        mVar13 = this.a.f;
                        mVar13.a(brVar2, false);
                        return;
                    }
                    String A = TiebaApplication.A();
                    eVar27 = this.a.g;
                    u.a(A, String.valueOf(eVar27.d()), 60000L, new l(this, brVar2));
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        } else if (qVar.w() == 103110) {
            if (qVar instanceof aj) {
                aj ajVar = (aj) qVar;
                if (!ajVar.k() && (n2 = ajVar.n()) != null && (n2 instanceof ag)) {
                    eVar23 = this.a.g;
                    if (((ag) n2).d() == eVar23.d()) {
                        mVar11 = this.a.f;
                        mVar11.x();
                        eVar24 = this.a.g;
                        eVar24.a(true);
                        this.a.e();
                    }
                }
            }
        } else if (qVar.w() == 103102) {
            mVar5 = this.a.f;
            mVar5.q();
            if (!(qVar instanceof cn)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            cn cnVar = (cn) qVar;
            if (cnVar.l() != 0) {
                this.a.showToast(cnVar.m());
            } else if (cnVar.n() instanceof ba) {
                int e = ((ba) cnVar.n()).e();
                i = this.a.e;
                switch (i) {
                    case 1:
                        if (e == 3) {
                            eVar21 = this.a.g;
                            eVar21.j();
                            mVar10 = this.a.f;
                            eVar22 = this.a.g;
                            mVar10.b(eVar22.g());
                            return;
                        }
                        return;
                    case 2:
                        if (e == 3) {
                            eVar19 = this.a.g;
                            eVar19.i();
                            mVar9 = this.a.f;
                            eVar20 = this.a.g;
                            mVar9.b(eVar20.g());
                            return;
                        }
                        return;
                    case 3:
                        if (e == 4) {
                            eVar17 = this.a.g;
                            eVar17.k();
                            mVar8 = this.a.f;
                            eVar18 = this.a.g;
                            mVar8.b(eVar18.g());
                            return;
                        }
                        return;
                    case 4:
                        eVar9 = this.a.g;
                        GroupData a = eVar9.g().a();
                        aoVar = this.a.h;
                        a.setFlag(aoVar.h());
                        eVar10 = this.a.g;
                        GroupData a2 = eVar10.g().a();
                        aoVar2 = this.a.h;
                        a2.setPosition(aoVar2.e());
                        eVar11 = this.a.g;
                        GroupData a3 = eVar11.g().a();
                        aoVar3 = this.a.h;
                        a3.setBusiness(aoVar3.f());
                        eVar12 = this.a.g;
                        if ((eVar12.g().a().getFlag() & 1) == 1) {
                            mVar7 = this.a.f;
                            eVar16 = this.a.g;
                            mVar7.a(eVar16.g().g());
                        } else {
                            eVar13 = this.a.g;
                            String position = eVar13.g().a().getPosition();
                            eVar14 = this.a.g;
                            String business = eVar14.g().a().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            mVar6 = this.a.f;
                            eVar15 = this.a.g;
                            mVar6.a(eVar15.g().g(), stringBuffer.toString());
                        }
                        this.a.showToast(R.string.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (qVar.w() == 103112) {
            if (qVar instanceof cg) {
                cg cgVar = (cg) qVar;
                if (!cgVar.k() && (n = cgVar.n()) != null && (n instanceof at)) {
                    at atVar = (at) n;
                    long b = atVar.b();
                    eVar2 = this.a.g;
                    if (b == eVar2.d()) {
                        String c = atVar.c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.E().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        eVar3 = this.a.g;
                                        eVar3.g().a(false);
                                        eVar4 = this.a.g;
                                        eVar4.a(false);
                                        mVar = this.a.f;
                                        eVar5 = this.a.g;
                                        mVar.a(eVar5.g(), true);
                                        mVar2 = this.a.f;
                                        mVar2.c(str);
                                        this.a.e();
                                        return;
                                    }
                                    eVar6 = this.a.g;
                                    if (eVar6.a(str)) {
                                        mVar3 = this.a.f;
                                        mVar3.c(str);
                                        eVar7 = this.a.g;
                                        GroupData a4 = eVar7.g().a();
                                        if (a4 != null && a4.getMemberNum() > 1) {
                                            a4.setMemberNum(a4.getMemberNum() - 1);
                                        }
                                        mVar4 = this.a.f;
                                        eVar8 = this.a.g;
                                        mVar4.a(eVar8.g());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (qVar.w() == 103104) {
            if (qVar instanceof bn) {
                bn bnVar = (bn) qVar;
                if (!bnVar.k()) {
                    eVar = this.a.g;
                    if (eVar.d() == bnVar.a()) {
                        this.a.finish();
                    }
                }
            }
        } else if (qVar.w() == 103105 && (qVar instanceof cp)) {
            cp cpVar = (cp) qVar;
            if (!cpVar.k() || cpVar.l() == 2230110) {
                this.a.c();
            }
        }
    }
}
