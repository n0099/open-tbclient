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
    private com.baidu.tieba.ueg.d eTE;
    public OvalActionButton gYx;
    private FrsFragment han;
    public com.baidu.tieba.write.f hbZ;
    private com.baidu.tieba.frs.profession.permission.c hcb;
    private l hwM;
    private NoPressedRelativeLayout hwo;
    private c.a hcc = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mF(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void u(boolean z, int i) {
            if (z && i == 502) {
                d.this.tw(1);
            } else if (z) {
                d.this.tw(0);
            } else if (i != 502) {
                d.this.tw(-1);
            } else {
                d.this.bQl();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.han.getPageContext().getPageActivity()) && !d.this.eTE.cZX() && !d.this.bQn()) {
                if (d.this.hwM != null) {
                    d.this.hwM.bVZ();
                }
                if (d.this.han.bOu().uW(502) != null) {
                    d.this.hcb.aL(d.this.han.getForumId(), d.this.han.bOu().bVQ().tabId);
                } else {
                    d.this.tw(-1);
                }
                d.this.bVa();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dyb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bVe();
                return;
            }
            d.this.gYx.setImageDrawable(null);
            aVar.drawImageTo(d.this.gYx);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bQl() {
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
        if (this.han != null && this.han.bOX() != null && (forum = this.han.bOX().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.han.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.han = frsFragment;
            this.hwo = noPressedRelativeLayout;
            this.eTE = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hcb = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hcb.a(this.hcc);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVa() {
        an anVar = new an("c13604");
        if (this.han != null) {
            com.baidu.tbadk.pageInfo.c.a(this.han.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        if (this.hbZ == null) {
            this.hbZ = new com.baidu.tieba.write.f(this.han.getPageContext(), this.hwo, "frs");
            this.hbZ.Mu("2");
        }
        this.hbZ.Mt(bVg());
        ForumWriteData bPb = this.han.bPb();
        bPb.setDefaultZone(i);
        this.hbZ.a(bPb);
        this.hbZ.EM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hbZ.a(false, (View) null, (View) this.gYx);
        this.han.bOU().setAlpha(0);
    }

    public void mv(boolean z) {
        FrsViewData bOX;
        if (this.gYx != null) {
            bVf();
            this.gYx.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bOX = this.han.bOX()) != null && bOX.postTopic != null && bOX.getForum() != null && !StringUtils.isNull(bOX.getForum().getId()) && !StringUtils.isNull(bOX.postTopic.recom_title) && !StringUtils.isNull(bOX.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bPj().D(bOX.getForum().getId(), bOX.postTopic.uniq_topicid.longValue())) {
                a(this.gYx, bOX);
            }
        }
    }

    public void bVb() {
        if (this.hbZ != null) {
            this.hbZ.onDestroy();
        }
        if (this.hwM != null) {
            this.hwM.bVZ();
        }
    }

    public void bVc() {
        if (this.hwM != null) {
            this.hwM.bVZ();
        }
    }

    public void bVd() {
    }

    public boolean bPC() {
        if (this.hbZ == null || !this.hbZ.isShowing()) {
            return false;
        }
        this.hbZ.uP(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hbZ != null) {
            this.hbZ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVe() {
        this.gYx.setImageResource(0);
    }

    public boolean bVf() {
        FrsViewData bOX;
        ActivityConfig activityConfig;
        if (this.han == null || (bOX = this.han.bOX()) == null || (activityConfig = bOX.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            DA(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            DA(activityConfig.addthread_icon);
            return true;
        }
    }

    private void DA(String str) {
        com.baidu.adp.lib.e.c.kV().a(str, 10, this.dyb, this.han.getUniqueId());
    }

    private String bVg() {
        FrsViewData bOX;
        if (this.han == null || (bOX = this.han.bOX()) == null || bOX.activityConfig == null) {
            return "";
        }
        return bOX.activityConfig.addthread_text;
    }

    public boolean bQn() {
        FrsViewData bOX;
        String fixedText;
        if (this.han != null && (bOX = this.han.bOX()) != null) {
            if (bc.checkUpIsLogin(this.han.getPageContext().getPageActivity())) {
                AntiData anti = bOX.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.han.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aMX();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.han.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.han.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aMX();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.han.getPageContext().getPageActivity());
        aVar.ui(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.han.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aOV().b(d.this.han.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.han.getPageContext()).aMS();
        return true;
    }

    public boolean bVh() {
        if (this.hbZ == null) {
            return false;
        }
        return this.hbZ.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.han != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.hwM == null) {
                this.hwM = new l(this.han.getActivity(), this);
            }
            this.hwM.bVZ();
            this.hwM.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bSb() {
        return (this.eTE.cZX() || bQn()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.gYx = ovalActionButton;
            this.gYx.setOnClickListener(this.mOnClickListener);
            if (!bVf()) {
                bVe();
            }
        }
    }

    public boolean bQa() {
        if (this.hbZ == null) {
            return false;
        }
        return this.hbZ.isShowing();
    }
}
