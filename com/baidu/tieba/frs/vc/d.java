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
    private com.baidu.tieba.ueg.d fVc;
    private k gLM;
    private NoPressedRelativeLayout gLx;
    public OvalActionButton gon;
    private FrsFragment gpZ;
    public com.baidu.tieba.write.f grK;
    private com.baidu.tieba.frs.profession.permission.c grM;
    private c.a grN = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lw(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void t(boolean z, int i) {
            if (z && i == 502) {
                d.this.sW(1);
            } else if (z) {
                d.this.sW(0);
            } else if (i != 502) {
                d.this.sW(-1);
            } else {
                d.this.bFz();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void lx(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bc.checkUpIsLogin(d.this.gpZ.getPageContext().getPageActivity()) && !d.this.fVc.cOH() && !d.this.bFB()) {
                if (d.this.gLM != null) {
                    d.this.gLM.bLf();
                }
                if (d.this.gpZ.bDN().ur(502) != null) {
                    d.this.grM.aB(d.this.gpZ.getForumId(), d.this.gpZ.bDN().bKY().tabId);
                } else {
                    d.this.sW(-1);
                }
                d.this.bKn();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> cYz = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.bKr();
                return;
            }
            d.this.gon.setImageDrawable(null);
            aVar.drawImageTo(d.this.gon);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bFz() {
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
        if (this.gpZ != null && this.gpZ.bEp() != null && (forum = this.gpZ.bEp().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.gpZ.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.gpZ = frsFragment;
            this.gLx = noPressedRelativeLayout;
            this.fVc = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.grM = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.grM.a(this.grN);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKn() {
        an anVar = new an("c13604");
        if (this.gpZ != null) {
            com.baidu.tbadk.pageInfo.c.a(this.gpZ.getContext(), anVar);
        }
        TiebaStatic.log(anVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sW(int i) {
        if (this.grK == null) {
            this.grK = new com.baidu.tieba.write.f(this.gpZ.getPageContext(), this.gLx, "frs");
            this.grK.KM("2");
        }
        this.grK.KL(bKt());
        ForumWriteData bEt = this.gpZ.bEt();
        bEt.setDefaultZone(i);
        this.grK.a(bEt);
        this.grK.Ed(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        this.grK.a(false, (View) null, (View) this.gon);
        this.gpZ.bEm().setAlpha(0);
    }

    public void ll(boolean z) {
        FrsViewData bEp;
        if (this.gon != null) {
            bKs();
            this.gon.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bEp = this.gpZ.bEp()) != null && bEp.postTopic != null && bEp.getForum() != null && !StringUtils.isNull(bEp.getForum().getId()) && !StringUtils.isNull(bEp.postTopic.recom_title) && !StringUtils.isNull(bEp.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bEz().B(bEp.getForum().getId(), bEp.postTopic.uniq_topicid.longValue())) {
                a(this.gon, bEp);
            }
        }
    }

    public void bKo() {
        if (this.grK != null) {
            this.grK.onDestroy();
        }
        if (this.gLM != null) {
            this.gLM.bLf();
        }
    }

    public void bKp() {
        if (this.gLM != null) {
            this.gLM.bLf();
        }
    }

    public void bKq() {
    }

    public boolean bES() {
        if (this.grK == null || !this.grK.isShowing()) {
            return false;
        }
        this.grK.tI(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.grK != null) {
            this.grK.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bKr() {
        this.gon.setImageResource(0);
    }

    public boolean bKs() {
        FrsViewData bEp;
        ActivityConfig activityConfig;
        if (this.gpZ == null || (bEp = this.gpZ.bEp()) == null || (activityConfig = bEp.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            BO(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            BO(activityConfig.addthread_icon);
            return true;
        }
    }

    private void BO(String str) {
        com.baidu.adp.lib.e.c.gr().a(str, 10, this.cYz, this.gpZ.getUniqueId());
    }

    private String bKt() {
        FrsViewData bEp;
        if (this.gpZ == null || (bEp = this.gpZ.bEp()) == null || bEp.activityConfig == null) {
            return "";
        }
        return bEp.activityConfig.addthread_text;
    }

    public boolean bFB() {
        FrsViewData bEp;
        String fixedText;
        if (this.gpZ != null && (bEp = this.gpZ.bEp()) != null) {
            if (bc.checkUpIsLogin(this.gpZ.getPageContext().getPageActivity())) {
                AntiData anti = bEp.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (aq.getRealSize(forbid_info) > 14) {
                            forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.gpZ.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aEH();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.gpZ.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.gpZ.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aEH();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gpZ.getPageContext().getPageActivity());
        aVar.sS(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.gpZ.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    ba.aGG().b(d.this.gpZ.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.gpZ.getPageContext()).aEC();
        return true;
    }

    public boolean bKu() {
        if (this.grK == null) {
            return false;
        }
        return this.grK.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.gpZ != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.gLM == null) {
                this.gLM = new k(this.gpZ.getActivity(), this);
            }
            this.gLM.bLf();
            this.gLM.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean bHn() {
        return (this.fVc.cOH() || bFB()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.gon = ovalActionButton;
            this.gon.setOnClickListener(this.mOnClickListener);
            if (!bKs()) {
                bKr();
            }
        }
    }

    public boolean bFp() {
        if (this.grK == null) {
            return false;
        }
        return this.grK.isShowing();
    }
}
