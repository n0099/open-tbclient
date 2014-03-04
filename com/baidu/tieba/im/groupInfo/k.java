package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.az;
import com.baidu.tieba.im.message.bg;
import com.baidu.tieba.im.message.bt;
import com.baidu.tieba.im.message.bu;
import com.baidu.tieba.im.message.bv;
import com.baidu.tieba.im.message.ca;
import com.baidu.tieba.im.message.cp;
import com.baidu.tieba.im.message.cw;
import com.baidu.tieba.im.message.cy;
import com.baidu.tieba.im.model.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
final class k implements com.baidu.tieba.im.messageCenter.g {
    final /* synthetic */ GroupInfoActivity a;

    private k(GroupInfoActivity groupInfoActivity) {
        this.a = groupInfoActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ k(GroupInfoActivity groupInfoActivity, byte b) {
        this(groupInfoActivity);
    }

    @Override // com.baidu.tieba.im.messageCenter.g
    public final void a(com.baidu.tieba.im.message.s sVar) {
        com.baidu.tieba.im.model.e eVar;
        com.baidu.tieba.im.message.s o;
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
        com.baidu.tieba.im.message.s o2;
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
        if (sVar == null) {
            mVar15 = this.a.f;
            mVar15.r();
            this.a.showToast(R.string.neterror);
        } else if (sVar.v() == -102) {
            if (!(sVar instanceof ca)) {
                eVar36 = this.a.g;
                eVar37 = this.a.g;
                long d = eVar37.d();
                eVar38 = this.a.g;
                eVar36.a(d, eVar38.e());
                return;
            }
            ca caVar = (ca) sVar;
            eVar28 = this.a.g;
            if (eVar28.l() == caVar.o()) {
                if (caVar.l()) {
                    eVar33 = this.a.g;
                    eVar34 = this.a.g;
                    long d2 = eVar34.d();
                    eVar35 = this.a.g;
                    eVar33.a(d2, eVar35.e());
                    return;
                }
                GroupInfoActivity.c(this.a);
                eVar29 = this.a.g;
                eVar29.a(caVar);
                mVar14 = this.a.f;
                mVar14.a(caVar);
                eVar30 = this.a.g;
                eVar31 = this.a.g;
                long d3 = eVar31.d();
                eVar32 = this.a.g;
                eVar30.a(d3, eVar32.e());
            }
        } else if (sVar.v() == 103004) {
            mVar12 = this.a.f;
            mVar12.r();
            if (!(sVar instanceof ca)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            ca caVar2 = (ca) sVar;
            eVar25 = this.a.g;
            if (eVar25.m() == caVar2.o()) {
                if (caVar2.m() == 2230101) {
                    this.a.showToast(caVar2.n(), false);
                    this.a.finish();
                } else if (caVar2.l()) {
                    this.a.showToast(R.string.neterror);
                } else {
                    GroupInfoActivity.c(this.a);
                    eVar26 = this.a.g;
                    eVar26.a(caVar2);
                    if (caVar2 == null || caVar2.g()) {
                        mVar13 = this.a.f;
                        mVar13.a(caVar2, false);
                        return;
                    }
                    String v = TiebaApplication.v();
                    eVar27 = this.a.g;
                    v.a(v, String.valueOf(eVar27.d()), 60000L, new l(this, caVar2));
                }
            }
        } else if (sVar.v() == 103110) {
            if (sVar instanceof ak) {
                ak akVar = (ak) sVar;
                if (!akVar.l() && (o2 = akVar.o()) != null && (o2 instanceof ah)) {
                    eVar23 = this.a.g;
                    if (((ah) o2).b() == eVar23.d()) {
                        mVar11 = this.a.f;
                        mVar11.y();
                        eVar24 = this.a.g;
                        eVar24.a(true);
                        this.a.c();
                    }
                }
            }
        } else if (sVar.v() == 103102) {
            mVar5 = this.a.f;
            mVar5.r();
            if (!(sVar instanceof cw)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            cw cwVar = (cw) sVar;
            if (cwVar.m() != 0) {
                this.a.showToast(cwVar.n());
            } else if (cwVar.o() instanceof bg) {
                int i2 = ((bg) cwVar.o()).a;
                i = this.a.e;
                switch (i) {
                    case 1:
                        if (i2 == 3) {
                            eVar21 = this.a.g;
                            eVar21.j();
                            mVar10 = this.a.f;
                            eVar22 = this.a.g;
                            mVar10.b(eVar22.g());
                            return;
                        }
                        return;
                    case 2:
                        if (i2 == 3) {
                            eVar19 = this.a.g;
                            eVar19.i();
                            mVar9 = this.a.f;
                            eVar20 = this.a.g;
                            mVar9.b(eVar20.g());
                            return;
                        }
                        return;
                    case 3:
                        if (i2 == 4) {
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
                        GroupData b = eVar9.g().b();
                        aoVar = this.a.h;
                        b.setFlag(aoVar.c());
                        eVar10 = this.a.g;
                        GroupData b2 = eVar10.g().b();
                        aoVar2 = this.a.h;
                        b2.setPosition(aoVar2.a());
                        eVar11 = this.a.g;
                        GroupData b3 = eVar11.g().b();
                        aoVar3 = this.a.h;
                        b3.setBusiness(aoVar3.b());
                        eVar12 = this.a.g;
                        if ((eVar12.g().b().getFlag() & 1) == 1) {
                            mVar7 = this.a.f;
                            eVar16 = this.a.g;
                            mVar7.a(eVar16.g().h());
                        } else {
                            eVar13 = this.a.g;
                            String position = eVar13.g().b().getPosition();
                            eVar14 = this.a.g;
                            String business = eVar14.g().b().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            mVar6 = this.a.f;
                            eVar15 = this.a.g;
                            mVar6.a(eVar15.g().h(), stringBuffer.toString());
                        }
                        this.a.showToast(R.string.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (sVar.v() == 103112) {
            if (sVar instanceof cp) {
                cp cpVar = (cp) sVar;
                if (!cpVar.l() && (o = cpVar.o()) != null && (o instanceof az)) {
                    az azVar = (az) o;
                    long b4 = azVar.b();
                    eVar2 = this.a.g;
                    if (b4 == eVar2.d()) {
                        String c = azVar.c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.y().getID();
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
                                        this.a.c();
                                        return;
                                    }
                                    eVar6 = this.a.g;
                                    if (eVar6.a(str)) {
                                        mVar3 = this.a.f;
                                        mVar3.c(str);
                                        eVar7 = this.a.g;
                                        GroupData b5 = eVar7.g().b();
                                        if (b5 != null && b5.getMemberNum() > 1) {
                                            b5.setMemberNum(b5.getMemberNum() - 1);
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
        } else if (sVar.v() == 103104) {
            if (sVar instanceof bv) {
                bv bvVar = (bv) sVar;
                if (!bvVar.l()) {
                    eVar = this.a.g;
                    if (eVar.d() == bvVar.a()) {
                        this.a.finish();
                    }
                }
            }
        } else if (sVar.v() == 103105) {
            if (sVar instanceof cy) {
                cy cyVar = (cy) sVar;
                if (!cyVar.l() || cyVar.m() == 2230110) {
                    this.a.b();
                }
            }
        } else if (sVar.v() == 103120) {
            if (sVar instanceof bt) {
                this.a.b();
            }
        } else if (sVar.v() == 103121 && (sVar instanceof bu)) {
            this.a.b();
        }
    }
}
