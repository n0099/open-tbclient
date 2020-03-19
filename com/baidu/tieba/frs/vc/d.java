package com.baidu.tieba.frs.vc;

import android.content.Context;
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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.NoPressedRelativeLayout;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.profession.permission.c;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.FrsPage.ActivityConfig;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d eqc;
    private NoPressedRelativeLayout gMO;
    private k gNd;
    public OvalActionButton gpk;
    private FrsFragment gqW;
    public com.baidu.tieba.write.f gsH;
    private com.baidu.tieba.frs.profession.permission.c gsJ;
    private c.a gsK = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
            if (z && i == 502) {
                d.this.sY(1);
            } else if (z) {
                d.this.sY(0);
            } else if (i != 502) {
                d.this.sY(-1);
            } else {
                d.this.bFK();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lD(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.gqW.getPageContext().getPageActivity()) && !d.this.eqc.cPc() && !d.this.bFM()) {
                if (d.this.gNd != null) {
                    d.this.gNd.bLu();
                }
                if (d.this.gqW.bDW().uy(502) != null) {
                    d.this.gsJ.aB(d.this.gqW.getForumId(), d.this.gqW.bDW().bLn().tabId);
                } else {
                    d.this.sY(-1);
                }
                d.this.bKB();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> cYN = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bKF();
                return;
            }
            d.this.gpk.setImageDrawable(null);
            aVar.drawImageTo(d.this.gpk);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bFK() {
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
        String str11 = null;
        if (this.gqW != null && this.gqW.bEz() != null && (forum = this.gqW.bEz().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    str6 = themeColorInfo.day.light_color;
                    str7 = themeColorInfo.day.dark_color;
                    str8 = skinType == 0 ? themeColorInfo.day.pattern_image : null;
                } else {
                    str7 = null;
                    str6 = null;
                    str8 = null;
                }
                if (themeColorInfo.night != null) {
                    String str12 = themeColorInfo.night.light_color;
                    String str13 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str4 = str12;
                        str9 = themeColorInfo.night.pattern_image;
                        str10 = str13;
                    } else {
                        str4 = str12;
                        str9 = str8;
                        str10 = str13;
                    }
                } else {
                    str4 = null;
                    str9 = str8;
                    str10 = null;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str14 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str14;
                        str11 = themeColorInfo.dark.pattern_image;
                        str3 = str10;
                        str5 = str7;
                    } else {
                        str = str14;
                        str11 = str9;
                        str3 = str10;
                        str5 = str7;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str11 = str9;
                    str3 = str10;
                    str5 = str7;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gqW.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.gqW = frsFragment;
            this.gMO = noPressedRelativeLayout;
            this.eqc = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.gsJ = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.gsJ.a(this.gsK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKB() {
        an anVar = new an("c13604");
        if (this.gqW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gqW.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sY(int i) {
        if (this.gsH == null) {
            this.gsH = new com.baidu.tieba.write.f(this.gqW.getPageContext(), this.gMO, "frs");
            this.gsH.KN("2");
        }
        this.gsH.KM(bKH());
        ForumWriteData bED = this.gqW.bED();
        bED.setDefaultZone(i);
        this.gsH.a(bED);
        this.gsH.El(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.gsH.a(false, (View) null, (View) this.gpk);
        this.gqW.bEw().setAlpha(0);
    }

    public void lr(boolean z) {
        FrsViewData bEz;
        if (this.gpk != null) {
            bKG();
            this.gpk.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bEz = this.gqW.bEz()) != null && bEz.postTopic != null && bEz.getForum() != null && !StringUtils.isNull(bEz.getForum().getId()) && !StringUtils.isNull(bEz.postTopic.recom_title) && !StringUtils.isNull(bEz.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bEK().B(bEz.getForum().getId(), bEz.postTopic.uniq_topicid.longValue())) {
                a(this.gpk, bEz);
            }
        }
    }

    public void bKC() {
        if (this.gsH != null) {
            this.gsH.onDestroy();
        }
        if (this.gNd != null) {
            this.gNd.bLu();
        }
    }

    public void bKD() {
        if (this.gNd != null) {
            this.gNd.bLu();
        }
    }

    public void bKE() {
    }

    public boolean bFd() {
        if (this.gsH == null || !this.gsH.isShowing()) {
            return false;
        }
        this.gsH.tP(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.gsH != null) {
            this.gsH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKF() {
        this.gpk.setImageResource(0);
    }

    public boolean bKG() {
        FrsViewData bEz;
        ActivityConfig activityConfig;
        if (this.gqW == null || (bEz = this.gqW.bEz()) == null || (activityConfig = bEz.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            BP(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            BP(activityConfig.addthread_icon);
            return true;
        }
    }

    private void BP(String str) {
        com.baidu.adp.lib.e.c.gr().a(str, 10, this.cYN, this.gqW.getUniqueId());
    }

    private String bKH() {
        FrsViewData bEz;
        if (this.gqW == null || (bEz = this.gqW.bEz()) == null || bEz.activityConfig == null) {
            return "";
        }
        return bEz.activityConfig.addthread_text;
    }

    public boolean bFM() {
        FrsViewData bEz;
        String fixedText;
        if (this.gqW != null && (bEz = this.gqW.bEz()) != null) {
            if (bc.checkUpIsLogin(this.gqW.getPageContext().getPageActivity())) {
                AntiData anti = bEz.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.gqW.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aEL();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.gqW.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.gqW.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aEL();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gqW.getPageContext().getPageActivity());
        aVar.sS(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.gqW.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(aq.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ba.aGK().b(d.this.gqW.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.gqW.getPageContext()).aEG();
        return true;
    }

    public boolean bKI() {
        if (this.gsH == null) {
            return false;
        }
        return this.gsH.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.gqW != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.gNd == null) {
                this.gNd = new k(this.gqW.getActivity(), this);
            }
            this.gNd.bLu();
            this.gNd.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bHD() {
        return (this.eqc.cPc() || bFM()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.gpk = ovalActionButton;
            this.gpk.setOnClickListener(this.mOnClickListener);
            if (!bKG()) {
                bKF();
            }
        }
    }

    public boolean bFA() {
        if (this.gsH == null) {
            return false;
        }
        return this.gsH.isShowing();
    }
}
