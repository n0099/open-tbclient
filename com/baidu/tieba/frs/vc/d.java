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
    private com.baidu.tieba.ueg.d fgm;
    private NoPressedRelativeLayout hLb;
    private l hLz;
    public OvalActionButton hnj;
    private FrsFragment hpb;
    public com.baidu.tieba.write.g hqN;
    private com.baidu.tieba.frs.profession.permission.c hqP;
    private c.a hqQ = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
            if (z && i == 502) {
                d.this.ub(1);
            } else if (z) {
                d.this.ub(0);
            } else if (i != 502) {
                d.this.ub(-1);
            } else {
                d.this.bWH();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.hpb.getPageContext().getPageActivity()) && !d.this.fgm.dhl() && !d.this.bWJ()) {
                if (d.this.hLz != null) {
                    d.this.hLz.ccx();
                }
                if (d.this.hpb.bUP().vC(502) != null) {
                    d.this.hqP.aM(d.this.hpb.getForumId(), d.this.hpb.bUP().cco().tabId);
                } else {
                    d.this.ub(-1);
                }
                d.this.cbx();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dLn = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cbB();
                return;
            }
            d.this.hnj.setImageDrawable(null);
            aVar.drawImageTo(d.this.hnj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bWH() {
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
        if (this.hpb != null && this.hpb.bVs() != null && (forum = this.hpb.bVs().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hpb.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hpb = frsFragment;
            this.hLb = noPressedRelativeLayout;
            this.fgm = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hqP = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hqP.a(this.hqQ);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbx() {
        an anVar = new an("c13604");
        if (this.hpb != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hpb.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ub(int i) {
        if (this.hqN == null) {
            this.hqN = new com.baidu.tieba.write.g(this.hpb.getPageContext(), this.hLb, "frs");
            this.hqN.Oh("2");
        }
        this.hqN.Og(cbD());
        ForumWriteData bVw = this.hpb.bVw();
        bVw.setDefaultZone(i);
        this.hqN.a(bVw);
        this.hqN.Fx(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hqN.a(false, (View) null, (View) this.hnj);
        this.hpb.bVp().setAlpha(0);
    }

    public void mQ(boolean z) {
        FrsViewData bVs;
        if (this.hnj != null) {
            cbC();
            this.hnj.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bVs = this.hpb.bVs()) != null && bVs.postTopic != null && bVs.getForum() != null && !StringUtils.isNull(bVs.getForum().getId()) && !StringUtils.isNull(bVs.postTopic.recom_title) && !StringUtils.isNull(bVs.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bVF().C(bVs.getForum().getId(), bVs.postTopic.uniq_topicid.longValue())) {
                a(this.hnj, bVs);
            }
        }
    }

    public void cby() {
        if (this.hqN != null) {
            this.hqN.onDestroy();
        }
        if (this.hLz != null) {
            this.hLz.ccx();
        }
    }

    public void cbz() {
        if (this.hLz != null) {
            this.hLz.ccx();
        }
    }

    public void cbA() {
    }

    public boolean bVY() {
        if (this.hqN == null || !this.hqN.isShowing()) {
            return false;
        }
        this.hqN.vn(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hqN != null) {
            this.hqN.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbB() {
        this.hnj.setImageResource(0);
    }

    public boolean cbC() {
        FrsViewData bVs;
        ActivityConfig activityConfig;
        if (this.hpb == null || (bVs = this.hpb.bVs()) == null || (activityConfig = bVs.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Fj(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Fj(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Fj(String str) {
        com.baidu.adp.lib.e.c.kX().a(str, 10, this.dLn, this.hpb.getUniqueId());
    }

    private String cbD() {
        FrsViewData bVs;
        if (this.hpb == null || (bVs = this.hpb.bVs()) == null || bVs.activityConfig == null) {
            return "";
        }
        return bVs.activityConfig.addthread_text;
    }

    public boolean bWJ() {
        FrsViewData bVs;
        String fixedText;
        if (this.hpb != null && (bVs = this.hpb.bVs()) != null) {
            if (bc.checkUpIsLogin(this.hpb.getPageContext().getPageActivity())) {
                AntiData anti = bVs.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hpb.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aSY();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hpb.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hpb.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aSY();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpb.getPageContext().getPageActivity());
        aVar.vO(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hpb.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aUZ().b(d.this.hpb.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hpb.getPageContext()).aST();
        return true;
    }

    public boolean cbE() {
        if (this.hqN == null) {
            return false;
        }
        return this.hqN.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hpb != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.hLz == null) {
                this.hLz = new l(this.hpb.getActivity(), this);
            }
            this.hLz.ccx();
            this.hLz.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bYw() {
        return (this.fgm.dhl() || bWJ()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hnj = ovalActionButton;
            this.hnj.setOnClickListener(this.mOnClickListener);
            if (!cbC()) {
                cbB();
            }
        }
    }

    public boolean bWw() {
        if (this.hqN == null) {
            return false;
        }
        return this.hqN.isShowing();
    }
}
