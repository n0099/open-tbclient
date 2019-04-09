package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ThemeColorInfo;
/* loaded from: classes4.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.c eCs;
    public OvalActionButton eYG;
    private FrsFragment fat;
    public com.baidu.tieba.write.e fcg;
    private com.baidu.tieba.frs.profession.permission.c fci;
    private NoPressedRelativeLayout fuU;
    private i fvj;
    private c.a fcj = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void n(boolean z, int i) {
            if (z && i == 502) {
                d.this.qj(1);
            } else if (z) {
                d.this.qj(0);
            } else if (i != 502) {
                d.this.qj(-1);
            } else {
                d.this.bec();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void jm(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.cZ(d.this.fat.getPageContext().getPageActivity()) && !d.this.eCs.cio() && !d.this.bee()) {
                if (d.this.fvj != null) {
                    d.this.fvj.bjz();
                }
                if (d.this.fat.bcq().rz(502) != null) {
                    d.this.fci.az(d.this.fat.getForumId(), d.this.fat.bcq().bjs().tabId);
                } else {
                    d.this.qj(-1);
                }
            }
        }
    };
    private final com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a> mCallback = new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.f.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.oz()) {
                d.this.biQ();
                return;
            }
            d.this.eYG.setImageDrawable(null);
            aVar.a(d.this.eYG);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bec() {
        ForumData forum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7 = null;
        if (this.fat != null && this.fat.bcP() != null && (forum = this.fat.bcP().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str5 = themeColorInfo.day.dark_color;
                    str = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str = null;
                    str5 = null;
                    str6 = null;
                }
                if (themeColorInfo.night != null) {
                    String str8 = themeColorInfo.night.light_color;
                    str7 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str = themeColorInfo.night.pattern_image;
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    } else {
                        str4 = str6;
                        str3 = str5;
                        str2 = str8;
                    }
                } else {
                    str4 = str6;
                    str3 = str5;
                    str2 = null;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.fat.getContext(), str);
            frsProfessionIntroActivityConfig.putColor(str4, str3, str2, str7);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.fat = frsFragment;
            this.fuU = noPressedRelativeLayout;
            this.eCs = new com.baidu.tieba.ueg.c(frsFragment.getPageContext());
            this.fci = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.fci.a(this.fcj);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj(int i) {
        if (this.fcg == null) {
            this.fcg = new com.baidu.tieba.write.e(this.fat.getPageContext(), this.fuU, "frs", 1);
            this.fcg.Ek("2");
        }
        this.fcg.b(this.fat.bcM());
        this.fcg.Ej(biS());
        ForumWriteData bcS = this.fat.bcS();
        bcS.setDefaultZone(i);
        this.fcg.a(bcS);
        this.fcg.AW(i == 1 ? d.f.btn_frs_professional_edit_n : 0);
        this.fcg.a(false, null, this.eYG);
        this.fat.bcM().setAlpha(0);
    }

    public void ja(boolean z) {
        FrsViewData bcP;
        if (this.eYG != null) {
            biR();
            this.eYG.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bcP = this.fat.bcP()) != null && bcP.postTopic != null && bcP.getForum() != null && !StringUtils.isNull(bcP.getForum().getId()) && !StringUtils.isNull(bcP.postTopic.recom_title) && !StringUtils.isNull(bcP.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bcY().p(bcP.getForum().getId(), bcP.postTopic.uniq_topicid.longValue())) {
                a(this.eYG, bcP);
            }
        }
    }

    public void biN() {
        if (this.fcg != null) {
            this.fcg.onDestroy();
        }
        if (this.fvj != null) {
            this.fvj.bjz();
        }
    }

    public void biO() {
        if (this.fvj != null) {
            this.fvj.bjz();
        }
    }

    public void biP() {
    }

    public boolean bdu() {
        if (this.fcg == null || !this.fcg.isShowing()) {
            return false;
        }
        this.fcg.qW(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.fcg != null) {
            this.fcg.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void biQ() {
        this.eYG.setImageResource(0);
    }

    public boolean biR() {
        FrsViewData bcP;
        ActivityConfig activityConfig;
        if (this.fat == null || (bcP = this.fat.bcP()) == null || (activityConfig = bcP.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            vL(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            vL(activityConfig.addthread_icon);
            return true;
        }
    }

    private void vL(String str) {
        com.baidu.adp.lib.f.c.jB().a(str, 10, this.mCallback, this.fat.getUniqueId());
    }

    private String biS() {
        FrsViewData bcP;
        if (this.fat == null || (bcP = this.fat.bcP()) == null || bcP.activityConfig == null) {
            return "";
        }
        return bcP.activityConfig.addthread_text;
    }

    public boolean bee() {
        FrsViewData bcP;
        String fixedText;
        if (this.fat != null && (bcP = this.fat.bcP()) != null) {
            if (bc.cZ(this.fat.getPageContext().getPageActivity())) {
                AntiData anti = bcP.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ap.mI(forbid_info) > 14) {
                            forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast c = BdToast.c(this.fat.getPageContext().getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                        c.ak(1.25f);
                        c.abe();
                        return false;
                    }
                }
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean a(int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.fat.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(this.fat.getPageContext().getPageActivity(), string, d.f.icon_toast_game_error);
            c.ak(1.25f);
            c.abe();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.fat.getPageContext().getPageActivity());
        aVar.lz(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.fat.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ap.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ba.adA().c(d.this.fat.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.fat.getPageContext()).aaW();
        return true;
    }

    public boolean biT() {
        if (this.fcg == null) {
            return false;
        }
        return this.fcg.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.fat != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.fvj == null) {
                this.fvj = new i(this.fat.getActivity(), this);
            }
            this.fvj.bjz();
            this.fvj.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bfL() {
        return (this.eCs.cio() || bee()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.eYG = ovalActionButton;
            this.eYG.setOnClickListener(this.mOnClickListener);
            if (!biR()) {
                biQ();
            }
        }
    }
}
