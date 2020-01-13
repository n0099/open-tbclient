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
/* loaded from: classes7.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fSG;
    private k gJL;
    private NoPressedRelativeLayout gJw;
    public OvalActionButton gmk;
    private FrsFragment gnW;
    public com.baidu.tieba.write.f gpH;
    private com.baidu.tieba.frs.profession.permission.c gpJ;
    private c.a gpK = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lt(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void s(boolean z, int i) {
            if (z && i == 502) {
                d.this.sQ(1);
            } else if (z) {
                d.this.sQ(0);
            } else if (i != 502) {
                d.this.sQ(-1);
            } else {
                d.this.bDU();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lu(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.gnW.getPageContext().getPageActivity()) && !d.this.fSG.cNi() && !d.this.bDW()) {
                if (d.this.gJL != null) {
                    d.this.gJL.bJC();
                }
                if (d.this.gnW.bCi().ul(502) != null) {
                    d.this.gpJ.aD(d.this.gnW.getForumId(), d.this.gnW.bCi().bJv().tabId);
                } else {
                    d.this.sQ(-1);
                }
                d.this.bIJ();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> cUw = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bIN();
                return;
            }
            d.this.gmk.setImageDrawable(null);
            aVar.drawImageTo(d.this.gmk);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bDU() {
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
        if (this.gnW != null && this.gnW.bCK() != null && (forum = this.gnW.bCK().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gnW.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.gnW = frsFragment;
            this.gJw = noPressedRelativeLayout;
            this.fSG = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.gpJ = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.gpJ.a(this.gpK);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIJ() {
        an anVar = new an("c13604");
        if (this.gnW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gnW.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sQ(int i) {
        if (this.gpH == null) {
            this.gpH = new com.baidu.tieba.write.f(this.gnW.getPageContext(), this.gJw, "frs");
            this.gpH.Kz("2");
        }
        this.gpH.Ky(bIP());
        ForumWriteData bCO = this.gnW.bCO();
        bCO.setDefaultZone(i);
        this.gpH.a(bCO);
        this.gpH.DY(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.gpH.a(false, (View) null, (View) this.gmk);
        this.gnW.bCH().setAlpha(0);
    }

    public void li(boolean z) {
        FrsViewData bCK;
        if (this.gmk != null) {
            bIO();
            this.gmk.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bCK = this.gnW.bCK()) != null && bCK.postTopic != null && bCK.getForum() != null && !StringUtils.isNull(bCK.getForum().getId()) && !StringUtils.isNull(bCK.postTopic.recom_title) && !StringUtils.isNull(bCK.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bCU().B(bCK.getForum().getId(), bCK.postTopic.uniq_topicid.longValue())) {
                a(this.gmk, bCK);
            }
        }
    }

    public void bIK() {
        if (this.gpH != null) {
            this.gpH.onDestroy();
        }
        if (this.gJL != null) {
            this.gJL.bJC();
        }
    }

    public void bIL() {
        if (this.gJL != null) {
            this.gJL.bJC();
        }
    }

    public void bIM() {
    }

    public boolean bDn() {
        if (this.gpH == null || !this.gpH.isShowing()) {
            return false;
        }
        this.gpH.tE(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.gpH != null) {
            this.gpH.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIN() {
        this.gmk.setImageResource(0);
    }

    public boolean bIO() {
        FrsViewData bCK;
        ActivityConfig activityConfig;
        if (this.gnW == null || (bCK = this.gnW.bCK()) == null || (activityConfig = bCK.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            By(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            By(activityConfig.addthread_icon);
            return true;
        }
    }

    private void By(String str) {
        com.baidu.adp.lib.e.c.gr().a(str, 10, this.cUw, this.gnW.getUniqueId());
    }

    private String bIP() {
        FrsViewData bCK;
        if (this.gnW == null || (bCK = this.gnW.bCK()) == null || bCK.activityConfig == null) {
            return "";
        }
        return bCK.activityConfig.addthread_text;
    }

    public boolean bDW() {
        FrsViewData bCK;
        String fixedText;
        if (this.gnW != null && (bCK = this.gnW.bCK()) != null) {
            if (bc.checkUpIsLogin(this.gnW.getPageContext().getPageActivity())) {
                AntiData anti = bCK.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.gnW.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aCu();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.gnW.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.gnW.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aCu();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gnW.getPageContext().getPageActivity());
        aVar.sC(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.gnW.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aEt().b(d.this.gnW.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.gnW.getPageContext()).aCp();
        return true;
    }

    public boolean bIQ() {
        if (this.gpH == null) {
            return false;
        }
        return this.gpH.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.gnW != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.gJL == null) {
                this.gJL = new k(this.gnW.getActivity(), this);
            }
            this.gJL.bJC();
            this.gJL.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bFJ() {
        return (this.fSG.cNi() || bDW()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.gmk = ovalActionButton;
            this.gmk.setOnClickListener(this.mOnClickListener);
            if (!bIO()) {
                bIN();
            }
        }
    }

    public boolean bDK() {
        if (this.gpH == null) {
            return false;
        }
        return this.gpH.isShowing();
    }
}
