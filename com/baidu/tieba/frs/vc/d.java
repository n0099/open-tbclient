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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
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
    private com.baidu.tieba.ueg.d frL;
    private FrsFragment hBW;
    public com.baidu.tieba.write.g hDL;
    private com.baidu.tieba.frs.profession.permission.c hDN;
    private NoPressedRelativeLayout hZa;
    private l hZy;
    public OvalActionButton hzL;
    private c.a hDO = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nl(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                d.this.uI(1);
            } else if (z) {
                d.this.uI(0);
            } else if (i != 502) {
                d.this.uI(-1);
            } else {
                d.this.bZU();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nm(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (be.checkUpIsLogin(d.this.hBW.getPageContext().getPageActivity()) && !d.this.frL.dlM() && !d.this.bZW()) {
                if (d.this.hZy != null) {
                    d.this.hZy.cfZ();
                }
                if (d.this.hBW.bXY().wj(502) != null) {
                    d.this.hDN.aL(d.this.hBW.getForumId(), d.this.hBW.bXY().cfQ().tabId);
                } else {
                    d.this.uI(-1);
                }
                d.this.ceY();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dSd = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cfc();
                return;
            }
            d.this.hzL.setImageDrawable(null);
            aVar.drawImageTo(d.this.hzL);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void bZU() {
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
        if (this.hBW != null && this.hBW.bYC() != null && (forum = this.hBW.bYC().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hBW.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hBW = frsFragment;
            this.hZa = noPressedRelativeLayout;
            this.frL = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hDN = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hDN.a(this.hDO);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ceY() {
        ao aoVar = new ao("c13604");
        if (this.hBW != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hBW.getContext(), aoVar);
        }
        TiebaStatic.log(aoVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uI(int i) {
        if (this.hDL == null) {
            this.hDL = new com.baidu.tieba.write.g(this.hBW.getPageContext(), this.hZa, "frs");
            this.hDL.OP("2");
            ItemInfo itemInfo = this.hBW.bYC().itemInfo;
            this.hDL.vG((itemInfo == null || itemInfo.id.intValue() <= 0 || ar.isEmpty(itemInfo.name)) ? false : true);
        }
        this.hDL.OO(cfe());
        ForumWriteData bYG = this.hBW.bYG();
        bYG.setDefaultZone(i);
        this.hDL.a(bYG);
        this.hDL.b(this.hBW.bYC().itemInfo);
        this.hDL.GD(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.hBW != null && this.hBW.bYC() != null) {
            this.hDL.b(this.hBW.bYC().itemInfo);
        }
        this.hDL.a(false, (View) null, (View) this.hzL);
        this.hBW.bYz().setAlpha(0);
        if (this.hBW != null && this.hBW.bYC() != null && this.hBW.bYC().itemInfo != null) {
            TiebaStatic.log(new ao("c13721").dk("fid", this.hBW.getForumId()).dk("fname", this.hBW.getForumName()).dk("obj_param1", this.hBW.bYC().itemInfo.name));
        }
    }

    public void nb(boolean z) {
        FrsViewData bYC;
        if (this.hzL != null) {
            cfd();
            this.hzL.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (bYC = this.hBW.bYC()) != null && bYC.postTopic != null && bYC.getForum() != null && !StringUtils.isNull(bYC.getForum().getId()) && !StringUtils.isNull(bYC.postTopic.recom_title) && !StringUtils.isNull(bYC.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.bYQ().C(bYC.getForum().getId(), bYC.postTopic.uniq_topicid.longValue())) {
                a(this.hzL, bYC);
            }
        }
    }

    public void ceZ() {
        if (this.hDL != null) {
            this.hDL.onDestroy();
        }
        if (this.hZy != null) {
            this.hZy.cfZ();
        }
    }

    public void cfa() {
        if (this.hZy != null) {
            this.hZy.cfZ();
        }
    }

    public void cfb() {
    }

    public boolean bZj() {
        if (this.hDL == null || !this.hDL.isShowing()) {
            return false;
        }
        this.hDL.vH(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hDL != null) {
            this.hDL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfc() {
        this.hzL.setImageResource(0);
    }

    public boolean cfd() {
        FrsViewData bYC;
        ActivityConfig activityConfig;
        if (this.hBW == null || (bYC = this.hBW.bYC()) == null || (activityConfig = bYC.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            FK(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            FK(activityConfig.addthread_icon);
            return true;
        }
    }

    private void FK(String str) {
        com.baidu.adp.lib.e.c.ln().a(str, 10, this.dSd, this.hBW.getUniqueId());
    }

    private String cfe() {
        FrsViewData bYC;
        if (this.hBW == null || (bYC = this.hBW.bYC()) == null || bYC.activityConfig == null) {
            return "";
        }
        return bYC.activityConfig.addthread_text;
    }

    public boolean bZW() {
        FrsViewData bYC;
        String fixedText;
        if (this.hBW != null && (bYC = this.hBW.bYC()) != null) {
            if (be.checkUpIsLogin(this.hBW.getPageContext().getPageActivity())) {
                AntiData anti = bYC.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (ar.getRealSize(forbid_info) > 14) {
                            forbid_info = ar.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hBW.getPageContext().getPageActivity(), (CharSequence) forbid_info, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aUS();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hBW.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hBW.getPageContext().getPageActivity(), (CharSequence) string, (int) R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aUS();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hBW.getPageContext().getPageActivity());
        aVar.we(ar.getFixedText(string, 50, true));
        aVar.b(ar.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hBW.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ar.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    bc.aWU().b(d.this.hBW.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hBW.getPageContext()).aUN();
        return true;
    }

    public boolean cff() {
        if (this.hDL == null) {
            return false;
        }
        return this.hDL.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hBW != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.hZy == null) {
                this.hZy = new l(this.hBW.getActivity(), this);
            }
            this.hZy.cfZ();
            this.hZy.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cbO() {
        return (this.frL.dlM() || bZW()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hzL = ovalActionButton;
            this.hzL.setOnClickListener(this.mOnClickListener);
            if (!cfd()) {
                cfc();
            }
        }
    }

    public boolean bZJ() {
        if (this.hDL == null) {
            return false;
        }
        return this.hDL.isShowing();
    }
}
