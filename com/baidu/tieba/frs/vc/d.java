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
    private com.baidu.tieba.ueg.d eTz;
    public OvalActionButton gYr;
    private FrsFragment hah;
    public com.baidu.tieba.write.f hbT;
    private com.baidu.tieba.frs.profession.permission.c hbV;
    private l hwG;
    private NoPressedRelativeLayout hwi;
    private c.a hbW = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
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
                d.this.bQm();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void mG(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.hah.getPageContext().getPageActivity()) && !d.this.eTz.cZZ() && !d.this.bQo()) {
                if (d.this.hwG != null) {
                    d.this.hwG.bWa();
                }
                if (d.this.hah.bOv().uW(502) != null) {
                    d.this.hbV.aL(d.this.hah.getForumId(), d.this.hah.bOv().bVR().tabId);
                } else {
                    d.this.tw(-1);
                }
                d.this.bVb();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dxX = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bVf();
                return;
            }
            d.this.gYr.setImageDrawable(null);
            aVar.drawImageTo(d.this.gYr);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bQm() {
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
        if (this.hah != null && this.hah.bOY() != null && (forum = this.hah.bOY().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hah.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hah = frsFragment;
            this.hwi = noPressedRelativeLayout;
            this.eTz = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hbV = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hbV.a(this.hbW);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVb() {
        an anVar = new an("c13604");
        if (this.hah != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hah.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tw(int i) {
        if (this.hbT == null) {
            this.hbT = new com.baidu.tieba.write.f(this.hah.getPageContext(), this.hwi, "frs");
            this.hbT.Mr("2");
        }
        this.hbT.Mq(bVh());
        ForumWriteData bPc = this.hah.bPc();
        bPc.setDefaultZone(i);
        this.hbT.a(bPc);
        this.hbT.EM(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.hbT.a(false, (View) null, (View) this.gYr);
        this.hah.bOV().setAlpha(0);
    }

    public void mv(boolean z) {
        FrsViewData bOY;
        if (this.gYr != null) {
            bVg();
            this.gYr.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bOY = this.hah.bOY()) != null && bOY.postTopic != null && bOY.getForum() != null && !StringUtils.isNull(bOY.getForum().getId()) && !StringUtils.isNull(bOY.postTopic.recom_title) && !StringUtils.isNull(bOY.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bPk().D(bOY.getForum().getId(), bOY.postTopic.uniq_topicid.longValue())) {
                a(this.gYr, bOY);
            }
        }
    }

    public void bVc() {
        if (this.hbT != null) {
            this.hbT.onDestroy();
        }
        if (this.hwG != null) {
            this.hwG.bWa();
        }
    }

    public void bVd() {
        if (this.hwG != null) {
            this.hwG.bWa();
        }
    }

    public void bVe() {
    }

    public boolean bPD() {
        if (this.hbT == null || !this.hbT.isShowing()) {
            return false;
        }
        this.hbT.uP(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hbT != null) {
            this.hbT.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bVf() {
        this.gYr.setImageResource(0);
    }

    public boolean bVg() {
        FrsViewData bOY;
        ActivityConfig activityConfig;
        if (this.hah == null || (bOY = this.hah.bOY()) == null || (activityConfig = bOY.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Dx(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Dx(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Dx(String str) {
        com.baidu.adp.lib.e.c.kV().a(str, 10, this.dxX, this.hah.getUniqueId());
    }

    private String bVh() {
        FrsViewData bOY;
        if (this.hah == null || (bOY = this.hah.bOY()) == null || bOY.activityConfig == null) {
            return "";
        }
        return bOY.activityConfig.addthread_text;
    }

    public boolean bQo() {
        FrsViewData bOY;
        String fixedText;
        if (this.hah != null && (bOY = this.hah.bOY()) != null) {
            if (bc.checkUpIsLogin(this.hah.getPageContext().getPageActivity())) {
                AntiData anti = bOY.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hah.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aMZ();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hah.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hah.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aMZ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hah.getPageContext().getPageActivity());
        aVar.uf(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hah.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aOY().b(d.this.hah.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hah.getPageContext()).aMU();
        return true;
    }

    public boolean bVi() {
        if (this.hbT == null) {
            return false;
        }
        return this.hbT.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hah != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.hwG == null) {
                this.hwG = new l(this.hah.getActivity(), this);
            }
            this.hwG.bWa();
            this.hwG.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bSc() {
        return (this.eTz.cZZ() || bQo()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.gYr = ovalActionButton;
            this.gYr.setOnClickListener(this.mOnClickListener);
            if (!bVg()) {
                bVf();
            }
        }
    }

    public boolean bQb() {
        if (this.hbT == null) {
            return false;
        }
        return this.hbT.isShowing();
    }
}
