package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.a.d {
    private com.baidu.tieba.ueg.d gEI;
    private NoPressedRelativeLayout jJE;
    private l jKc;
    public OvalActionButton jgi;
    private FrsFragment jiE;
    public com.baidu.tieba.write.g jkA;
    private com.baidu.tieba.frs.profession.permission.c jkC;
    private c.a jkD = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qM(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                d.this.yV(1);
            } else if (z) {
                d.this.yV(0);
            } else if (i != 502) {
                d.this.yV(-1);
            } else {
                d.this.cEu();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qN(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.tbadk.core.util.h.a(new ar(d.this.jiE.getPageContext().getPageActivity(), "frs_fabu")) && bh.checkUpIsLogin(d.this.jiE.getPageContext().getPageActivity()) && !d.this.gEI.dRt() && !d.this.cEw() && !WriteActivityConfig.isAsyncWriting()) {
                if (d.this.jKc != null) {
                    d.this.jKc.cLW();
                }
                if (d.this.jiE.cCs().AH(502) == null || d.this.jiE.cCs().cLN() == null) {
                    d.this.yV(-1);
                } else {
                    d.this.jkC.aZ(d.this.jiE.getForumId(), d.this.jiE.cCs().cLN().tabId);
                }
                d.this.cKP();
            }
        }
    };
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eYI = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cKT();
                return;
            }
            d.this.jgi.setImageDrawable(null);
            aVar.drawImageTo(d.this.jgi);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (this.jiE != null && this.jiE.cCZ() != null && (forum = this.jiE.cCZ().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    String str11 = themeColorInfo.day.light_color;
                    str8 = themeColorInfo.day.dark_color;
                    if (skinType == 0) {
                        str9 = themeColorInfo.day.pattern_image;
                        str6 = str11;
                    } else {
                        str6 = str11;
                        str9 = null;
                    }
                } else {
                    str8 = null;
                    str6 = null;
                    str9 = null;
                }
                if (themeColorInfo.night != null) {
                    str4 = themeColorInfo.night.light_color;
                    String str12 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str3 = str12;
                        str10 = themeColorInfo.night.pattern_image;
                    } else {
                        str3 = str12;
                        str10 = str9;
                    }
                } else {
                    str3 = null;
                    str4 = null;
                    str10 = str9;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str13 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str13;
                        str5 = str8;
                        str7 = themeColorInfo.dark.pattern_image;
                    } else {
                        str = str13;
                        str5 = str8;
                        str7 = str10;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str5 = str8;
                    str7 = str10;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jiE.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.jiE = frsFragment;
            this.jJE = noPressedRelativeLayout;
            this.gEI = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.jkC = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.jkC.a(this.jkD);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKP() {
        com.baidu.tbadk.core.util.ar arVar = new com.baidu.tbadk.core.util.ar("c13604");
        if (this.jiE != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jiE.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yV(int i) {
        if (this.jkA == null) {
            this.jkA = new com.baidu.tieba.write.g(this.jiE.getPageContext(), this.jJE, "frs");
            this.jkA.UX("2");
            ItemInfo itemInfo = this.jiE.cCZ().itemInfo;
            this.jkA.zv((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.jkA.UW(cKV());
        if (this.jiE.cCZ().getAnti() != null) {
            this.jkA.zx(this.jiE.cCZ().getAnti().getCanGoods());
        }
        ForumWriteData cDd = this.jiE.cDd();
        cDd.setDefaultZone(i);
        this.jkA.a(cDd);
        this.jkA.b(this.jiE.cCZ().itemInfo);
        this.jkA.Lg(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.jiE != null && this.jiE.cCZ() != null) {
            this.jkA.b(this.jiE.cCZ().itemInfo);
        }
        this.jkA.a(false, (View) null, (View) this.jgi);
        this.jiE.cCW().setAlpha(0);
        if (this.jiE != null && this.jiE.cCZ() != null && this.jiE.cCZ().itemInfo != null) {
            TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13721").dR("fid", this.jiE.getForumId()).dR("fname", this.jiE.getForumName()).dR("obj_param1", this.jiE.cCZ().itemInfo.name));
        }
    }

    public void qC(boolean z) {
        FrsViewData cCZ;
        if (this.jgi != null) {
            cKU();
            this.jgi.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cCZ = this.jiE.cCZ()) != null && cCZ.postTopic != null && cCZ.getForum() != null && !StringUtils.isNull(cCZ.getForum().getId()) && !StringUtils.isNull(cCZ.postTopic.recom_title) && !StringUtils.isNull(cCZ.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cDn().E(cCZ.getForum().getId(), cCZ.postTopic.uniq_topicid.longValue())) {
                a(this.jgi, cCZ);
            }
        }
    }

    public void cKQ() {
        if (this.jkA != null) {
            this.jkA.onDestroy();
        }
        if (this.jKc != null) {
            this.jKc.cLW();
        }
    }

    public void cKR() {
        if (this.jKc != null) {
            this.jKc.cLW();
        }
    }

    public void cKS() {
    }

    public boolean cDG() {
        if (this.jkA == null || !this.jkA.isShowing()) {
            return false;
        }
        this.jkA.zw(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.jkA != null) {
            this.jkA.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKT() {
        this.jgi.setImageResource(0);
    }

    public boolean cKU() {
        FrsViewData cCZ;
        ActivityConfig activityConfig;
        if (this.jiE == null || (cCZ = this.jiE.cCZ()) == null || (activityConfig = cCZ.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Li(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Li(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Li(String str) {
        com.baidu.adp.lib.e.d.mw().a(str, 10, this.eYI, this.jiE.getUniqueId());
    }

    private String cKV() {
        FrsViewData cCZ;
        if (this.jiE == null || (cCZ = this.jiE.cCZ()) == null || cCZ.activityConfig == null) {
            return "";
        }
        return cCZ.activityConfig.addthread_text;
    }

    public boolean cEw() {
        FrsViewData cCZ;
        if (this.jiE == null || (cCZ = this.jiE.cCZ()) == null) {
            return false;
        }
        if (bh.checkUpIsLogin(this.jiE.getPageContext().getPageActivity())) {
            AntiData anti = cCZ.getAnti();
            return anti != null && a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo);
        }
        return true;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.jiE.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i == 1 || i == 2) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jiE.getPageContext().getPageActivity());
            aVar.Au(au.getFixedText(string, 50, true));
            aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.jiE.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
            if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
                aVar.a(au.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.baidu.tbadk.core.dialog.a.b
                    public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                        bf.bsV().b(d.this.jiE.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                        if (aVar2 != null) {
                            aVar2.dismiss();
                        }
                    }
                });
            }
            aVar.b(this.jiE.getPageContext()).bqx();
            return true;
        }
        return false;
    }

    public boolean cKW() {
        if (this.jkA == null) {
            return false;
        }
        return this.jkA.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.jiE != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jKc == null) {
                this.jKc = new l(this.jiE.getActivity(), this);
            }
            this.jKc.cLW();
            this.jKc.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.d
    public boolean cGC() {
        return (this.gEI.dRt() || cEw()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.jgi = ovalActionButton;
            this.jgi.setOnClickListener(this.mOnClickListener);
            if (!cKU()) {
                cKT();
            }
        }
    }

    public boolean cEf() {
        if (this.jkA == null) {
            return false;
        }
        return this.jkA.isShowing();
    }

    public void cKX() {
        if (this.jgi != null) {
            this.jgi.performClick();
        }
    }
}
