package com.baidu.tieba.im.groupInfo;

import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.message.an;
import com.baidu.tieba.im.message.at;
import com.baidu.tieba.im.message.be;
import com.baidu.tieba.im.message.bh;
import com.baidu.tieba.im.message.bu;
import com.baidu.tieba.im.message.bz;
import com.baidu.tieba.im.model.am;
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
    public void a(com.baidu.tieba.im.message.o oVar) {
        com.baidu.tieba.im.model.d dVar;
        com.baidu.tieba.im.message.o l;
        com.baidu.tieba.im.model.d dVar2;
        String[] split;
        com.baidu.tieba.im.model.d dVar3;
        com.baidu.tieba.im.model.d dVar4;
        m mVar;
        com.baidu.tieba.im.model.d dVar5;
        m mVar2;
        com.baidu.tieba.im.model.d dVar6;
        m mVar3;
        com.baidu.tieba.im.model.d dVar7;
        m mVar4;
        com.baidu.tieba.im.model.d dVar8;
        m mVar5;
        int i;
        com.baidu.tieba.im.model.d dVar9;
        am amVar;
        com.baidu.tieba.im.model.d dVar10;
        am amVar2;
        com.baidu.tieba.im.model.d dVar11;
        am amVar3;
        com.baidu.tieba.im.model.d dVar12;
        com.baidu.tieba.im.model.d dVar13;
        com.baidu.tieba.im.model.d dVar14;
        m mVar6;
        com.baidu.tieba.im.model.d dVar15;
        m mVar7;
        com.baidu.tieba.im.model.d dVar16;
        com.baidu.tieba.im.model.d dVar17;
        m mVar8;
        com.baidu.tieba.im.model.d dVar18;
        com.baidu.tieba.im.model.d dVar19;
        m mVar9;
        com.baidu.tieba.im.model.d dVar20;
        com.baidu.tieba.im.model.d dVar21;
        m mVar10;
        com.baidu.tieba.im.model.d dVar22;
        com.baidu.tieba.im.message.o l2;
        com.baidu.tieba.im.model.d dVar23;
        m mVar11;
        com.baidu.tieba.im.model.d dVar24;
        m mVar12;
        com.baidu.tieba.im.model.d dVar25;
        com.baidu.tieba.im.model.d dVar26;
        m mVar13;
        com.baidu.tieba.im.model.d dVar27;
        com.baidu.tieba.im.model.d dVar28;
        com.baidu.tieba.im.model.d dVar29;
        m mVar14;
        com.baidu.tieba.im.model.d dVar30;
        com.baidu.tieba.im.model.d dVar31;
        com.baidu.tieba.im.model.d dVar32;
        com.baidu.tieba.im.model.d dVar33;
        com.baidu.tieba.im.model.d dVar34;
        com.baidu.tieba.im.model.d dVar35;
        com.baidu.tieba.im.model.d dVar36;
        com.baidu.tieba.im.model.d dVar37;
        com.baidu.tieba.im.model.d dVar38;
        m mVar15;
        if (oVar == null) {
            mVar15 = this.a.f;
            mVar15.q();
            this.a.showToast(R.string.neterror);
        } else if (oVar.u() == -102) {
            if (!(oVar instanceof bh)) {
                dVar36 = this.a.g;
                dVar37 = this.a.g;
                long d = dVar37.d();
                dVar38 = this.a.g;
                dVar36.a(d, dVar38.e());
                return;
            }
            bh bhVar = (bh) oVar;
            dVar28 = this.a.g;
            if (dVar28.l() == bhVar.l()) {
                if (bhVar.i()) {
                    dVar33 = this.a.g;
                    dVar34 = this.a.g;
                    long d2 = dVar34.d();
                    dVar35 = this.a.g;
                    dVar33.a(d2, dVar35.e());
                    return;
                }
                this.a.d();
                dVar29 = this.a.g;
                dVar29.a(bhVar);
                mVar14 = this.a.f;
                mVar14.a(bhVar);
                dVar30 = this.a.g;
                dVar31 = this.a.g;
                long d3 = dVar31.d();
                dVar32 = this.a.g;
                dVar30.a(d3, dVar32.e());
            }
        } else if (oVar.u() == 103004) {
            mVar12 = this.a.f;
            mVar12.q();
            if (!(oVar instanceof bh)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bh bhVar2 = (bh) oVar;
            dVar25 = this.a.g;
            if (dVar25.m() == bhVar2.l()) {
                if (bhVar2.j() == 2230101) {
                    this.a.showToast(bhVar2.k(), false);
                    this.a.finish();
                } else if (!bhVar2.i()) {
                    this.a.d();
                    dVar26 = this.a.g;
                    dVar26.a(bhVar2);
                    if (bhVar2 == null || bhVar2.f()) {
                        mVar13 = this.a.f;
                        mVar13.a(bhVar2, false);
                        return;
                    }
                    String A = TiebaApplication.A();
                    dVar27 = this.a.g;
                    u.a(A, String.valueOf(dVar27.d()), 60000L, new l(this, bhVar2));
                } else {
                    this.a.showToast(R.string.neterror);
                }
            }
        } else if (oVar.u() == 103110) {
            if (oVar instanceof aj) {
                aj ajVar = (aj) oVar;
                if (!ajVar.i() && (l2 = ajVar.l()) != null && (l2 instanceof ag)) {
                    dVar23 = this.a.g;
                    if (((ag) l2).d() == dVar23.d()) {
                        mVar11 = this.a.f;
                        mVar11.x();
                        dVar24 = this.a.g;
                        dVar24.a(true);
                        this.a.e();
                    }
                }
            }
        } else if (oVar.u() == 103102) {
            mVar5 = this.a.f;
            mVar5.q();
            if (!(oVar instanceof bz)) {
                this.a.showToast(R.string.neterror);
                return;
            }
            bz bzVar = (bz) oVar;
            if (bzVar.j() != 0) {
                this.a.showToast(bzVar.k());
            } else if (bzVar.l() instanceof at) {
                int e = ((at) bzVar.l()).e();
                i = this.a.e;
                switch (i) {
                    case 1:
                        if (e == 3) {
                            dVar21 = this.a.g;
                            dVar21.j();
                            mVar10 = this.a.f;
                            dVar22 = this.a.g;
                            mVar10.b(dVar22.g());
                            return;
                        }
                        return;
                    case 2:
                        if (e == 3) {
                            dVar19 = this.a.g;
                            dVar19.i();
                            mVar9 = this.a.f;
                            dVar20 = this.a.g;
                            mVar9.b(dVar20.g());
                            return;
                        }
                        return;
                    case 3:
                        if (e == 4) {
                            dVar17 = this.a.g;
                            dVar17.k();
                            mVar8 = this.a.f;
                            dVar18 = this.a.g;
                            mVar8.b(dVar18.g());
                            return;
                        }
                        return;
                    case 4:
                        dVar9 = this.a.g;
                        GroupData a = dVar9.g().a();
                        amVar = this.a.h;
                        a.setFlag(amVar.h());
                        dVar10 = this.a.g;
                        GroupData a2 = dVar10.g().a();
                        amVar2 = this.a.h;
                        a2.setPosition(amVar2.e());
                        dVar11 = this.a.g;
                        GroupData a3 = dVar11.g().a();
                        amVar3 = this.a.h;
                        a3.setBusiness(amVar3.f());
                        dVar12 = this.a.g;
                        if ((dVar12.g().a().getFlag() & 1) == 1) {
                            mVar7 = this.a.f;
                            dVar16 = this.a.g;
                            mVar7.a(dVar16.g().g());
                        } else {
                            dVar13 = this.a.g;
                            String position = dVar13.g().a().getPosition();
                            dVar14 = this.a.g;
                            String business = dVar14.g().a().getBusiness();
                            StringBuffer stringBuffer = new StringBuffer();
                            if (position != null) {
                                stringBuffer.append(position);
                            }
                            if (business != null) {
                                stringBuffer.append(business);
                            }
                            mVar6 = this.a.f;
                            dVar15 = this.a.g;
                            mVar6.a(dVar15.g().g(), stringBuffer.toString());
                        }
                        this.a.showToast(R.string.group_address_success);
                        return;
                    default:
                        return;
                }
            }
        } else if (oVar.u() == 103112) {
            if (oVar instanceof bu) {
                bu buVar = (bu) oVar;
                if (!buVar.i() && (l = buVar.l()) != null && (l instanceof an)) {
                    an anVar = (an) l;
                    long b = anVar.b();
                    dVar2 = this.a.g;
                    if (b == dVar2.d()) {
                        String c = anVar.c();
                        if (!TextUtils.isEmpty(c) && (split = c.split(",")) != null && split.length != 0) {
                            String id = TiebaApplication.F().getID();
                            if (!TextUtils.isEmpty(id)) {
                                for (String str : split) {
                                    if (id.equals(str)) {
                                        dVar3 = this.a.g;
                                        dVar3.g().a(false);
                                        dVar4 = this.a.g;
                                        dVar4.a(false);
                                        mVar = this.a.f;
                                        dVar5 = this.a.g;
                                        mVar.a(dVar5.g(), true);
                                        mVar2 = this.a.f;
                                        mVar2.c(str);
                                        this.a.e();
                                        return;
                                    }
                                    dVar6 = this.a.g;
                                    if (dVar6.a(str)) {
                                        mVar3 = this.a.f;
                                        mVar3.c(str);
                                        dVar7 = this.a.g;
                                        GroupData a4 = dVar7.g().a();
                                        if (a4 != null && a4.getMemberNum() > 1) {
                                            a4.setMemberNum(a4.getMemberNum() - 1);
                                        }
                                        mVar4 = this.a.f;
                                        dVar8 = this.a.g;
                                        mVar4.a(dVar8.g());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (oVar.u() == 103104 && (oVar instanceof be)) {
            be beVar = (be) oVar;
            if (!beVar.i()) {
                dVar = this.a.g;
                if (dVar.d() == beVar.a()) {
                    this.a.finish();
                }
            }
        }
    }
}
