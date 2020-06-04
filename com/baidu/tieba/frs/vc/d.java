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
import tbclient.ItemInfo;
import tbclient.ThemeColorInfo;
/* loaded from: classes9.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fgx;
    private NoPressedRelativeLayout hLO;
    private l hMm;
    public OvalActionButton hnu;
    private FrsFragment hpm;
    public com.baidu.tieba.write.g hqY;
    private com.baidu.tieba.frs.profession.permission.c hra;
    private c.a hrb = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void na(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void x(boolean z, int i) {
            if (z && i == 502) {
                d.this.ud(1);
            } else if (z) {
                d.this.ud(0);
            } else if (i != 502) {
                d.this.ud(-1);
            } else {
                d.this.bWJ();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nb(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.hpm.getPageContext().getPageActivity()) && !d.this.fgx.dhA() && !d.this.bWL()) {
                if (d.this.hMm != null) {
                    d.this.hMm.ccF();
                }
                if (d.this.hpm.bUR().vE(502) != null) {
                    d.this.hra.aM(d.this.hpm.getForumId(), d.this.hpm.bUR().ccw().tabId);
                } else {
                    d.this.ud(-1);
                }
                d.this.cbF();
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
                d.this.cbJ();
                return;
            }
            d.this.hnu.setImageDrawable(null);
            aVar.drawImageTo(d.this.hnu);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bWJ() {
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
        if (this.hpm != null && this.hpm.bVu() != null && (forum = this.hpm.bVu().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hpm.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hpm = frsFragment;
            this.hLO = noPressedRelativeLayout;
            this.fgx = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hra = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hra.a(this.hrb);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbF() {
        an anVar = new an("c13604");
        if (this.hpm != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hpm.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ud(int i) {
        if (this.hqY == null) {
            this.hqY = new com.baidu.tieba.write.g(this.hpm.getPageContext(), this.hLO, "frs");
            this.hqY.Oi("2");
            ItemInfo itemInfo = this.hpm.bVu().itemInfo;
            this.hqY.vo((itemInfo == null || itemInfo.id.intValue() <= 0 || aq.isEmpty(itemInfo.name)) ? false : true);
        }
        this.hqY.Oh(cbL());
        ForumWriteData bVy = this.hpm.bVy();
        bVy.setDefaultZone(i);
        this.hqY.a(bVy);
        this.hqY.a(this.hpm.bVu().itemInfo);
        this.hqY.Fz(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.hpm != null && this.hpm.bVu() != null) {
            this.hqY.a(this.hpm.bVu().itemInfo);
        }
        this.hqY.a(false, (View) null, (View) this.hnu);
        this.hpm.bVr().setAlpha(0);
        if (this.hpm != null && this.hpm.bVu() != null && this.hpm.bVu().itemInfo != null) {
            TiebaStatic.log(new an("c13721").dh("fid", this.hpm.getForumId()).dh("fname", this.hpm.getForumName()).dh("obj_param1", this.hpm.bVu().itemInfo.name));
        }
    }

    public void mQ(boolean z) {
        FrsViewData bVu;
        if (this.hnu != null) {
            cbK();
            this.hnu.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bVu = this.hpm.bVu()) != null && bVu.postTopic != null && bVu.getForum() != null && !StringUtils.isNull(bVu.getForum().getId()) && !StringUtils.isNull(bVu.postTopic.recom_title) && !StringUtils.isNull(bVu.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bVH().C(bVu.getForum().getId(), bVu.postTopic.uniq_topicid.longValue())) {
                a(this.hnu, bVu);
            }
        }
    }

    public void cbG() {
        if (this.hqY != null) {
            this.hqY.onDestroy();
        }
        if (this.hMm != null) {
            this.hMm.ccF();
        }
    }

    public void cbH() {
        if (this.hMm != null) {
            this.hMm.ccF();
        }
    }

    public void cbI() {
    }

    public boolean bWa() {
        if (this.hqY == null || !this.hqY.isShowing()) {
            return false;
        }
        this.hqY.vp(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hqY != null) {
            this.hqY.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cbJ() {
        this.hnu.setImageResource(0);
    }

    public boolean cbK() {
        FrsViewData bVu;
        ActivityConfig activityConfig;
        if (this.hpm == null || (bVu = this.hpm.bVu()) == null || (activityConfig = bVu.activityConfig) == null || activityConfig.type.intValue() != 2) {
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
        com.baidu.adp.lib.e.c.kX().a(str, 10, this.dLn, this.hpm.getUniqueId());
    }

    private String cbL() {
        FrsViewData bVu;
        if (this.hpm == null || (bVu = this.hpm.bVu()) == null || bVu.activityConfig == null) {
            return "";
        }
        return bVu.activityConfig.addthread_text;
    }

    public boolean bWL() {
        FrsViewData bVu;
        String fixedText;
        if (this.hpm != null && (bVu = this.hpm.bVu()) != null) {
            if (bc.checkUpIsLogin(this.hpm.getPageContext().getPageActivity())) {
                AntiData anti = bVu.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hpm.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hpm.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hpm.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aSY();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hpm.getPageContext().getPageActivity());
        aVar.vO(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hpm.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aVa().b(d.this.hpm.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hpm.getPageContext()).aST();
        return true;
    }

    public boolean cbM() {
        if (this.hqY == null) {
            return false;
        }
        return this.hqY.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hpm != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.hMm == null) {
                this.hMm = new l(this.hpm.getActivity(), this);
            }
            this.hMm.ccF();
            this.hMm.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bYz() {
        return (this.fgx.dhA() || bWL()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hnu = ovalActionButton;
            this.hnu.setOnClickListener(this.mOnClickListener);
            if (!cbK()) {
                cbJ();
            }
        }
    }

    public boolean bWy() {
        if (this.hqY == null) {
            return false;
        }
        return this.hqY.isShowing();
    }
}
