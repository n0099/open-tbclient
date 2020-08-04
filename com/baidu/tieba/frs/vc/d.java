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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fwT;
    public OvalActionButton hFA;
    private FrsFragment hHU;
    public com.baidu.tieba.write.g hJJ;
    private com.baidu.tieba.frs.profession.permission.c hJL;
    private l ifC;
    private NoPressedRelativeLayout ife;
    private c.a hJM = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nQ(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                d.this.va(1);
            } else if (z) {
                d.this.va(0);
            } else if (i != 502) {
                d.this.va(-1);
            } else {
                d.this.cdr();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void nR(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bf.checkUpIsLogin(d.this.hHU.getPageContext().getPageActivity()) && !d.this.fwT.doW() && !d.this.cdt()) {
                if (d.this.ifC != null) {
                    d.this.ifC.cjy();
                }
                if (d.this.hHU.cbu().wB(502) != null) {
                    d.this.hJL.aK(d.this.hHU.getForumId(), d.this.hHU.cbu().cjp().tabId);
                } else {
                    d.this.va(-1);
                }
                d.this.cix();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> dYv = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.ciB();
                return;
            }
            d.this.hFA.setImageDrawable(null);
            aVar.drawImageTo(d.this.hFA);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cdr() {
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
        if (this.hHU != null && this.hHU.cbZ() != null && (forum = this.hHU.cbZ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hHU.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hHU = frsFragment;
            this.ife = noPressedRelativeLayout;
            this.fwT = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hJL = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hJL.a(this.hJM);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cix() {
        ap apVar = new ap("c13604");
        if (this.hHU != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hHU.getContext(), apVar);
        }
        TiebaStatic.log(apVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void va(int i) {
        if (this.hJJ == null) {
            this.hJJ = new com.baidu.tieba.write.g(this.hHU.getPageContext(), this.ife, "frs");
            this.hJJ.PA("2");
            ItemInfo itemInfo = this.hHU.cbZ().itemInfo;
            this.hJJ.wk((itemInfo == null || itemInfo.id.intValue() <= 0 || as.isEmpty(itemInfo.name)) ? false : true);
        }
        this.hJJ.Pz(ciD());
        ForumWriteData ccd = this.hHU.ccd();
        ccd.setDefaultZone(i);
        this.hJJ.a(ccd);
        this.hJJ.b(this.hHU.cbZ().itemInfo);
        this.hJJ.GZ(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.hHU != null && this.hHU.cbZ() != null) {
            this.hJJ.b(this.hHU.cbZ().itemInfo);
        }
        this.hJJ.a(false, (View) null, (View) this.hFA);
        this.hHU.cbW().setAlpha(0);
        if (this.hHU != null && this.hHU.cbZ() != null && this.hHU.cbZ().itemInfo != null) {
            TiebaStatic.log(new ap("c13721").dn("fid", this.hHU.getForumId()).dn("fname", this.hHU.getForumName()).dn("obj_param1", this.hHU.cbZ().itemInfo.name));
        }
    }

    public void nG(boolean z) {
        FrsViewData cbZ;
        if (this.hFA != null) {
            ciC();
            this.hFA.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cbZ = this.hHU.cbZ()) != null && cbZ.postTopic != null && cbZ.getForum() != null && !StringUtils.isNull(cbZ.getForum().getId()) && !StringUtils.isNull(cbZ.postTopic.recom_title) && !StringUtils.isNull(cbZ.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.ccn().A(cbZ.getForum().getId(), cbZ.postTopic.uniq_topicid.longValue())) {
                a(this.hFA, cbZ);
            }
        }
    }

    public void ciy() {
        if (this.hJJ != null) {
            this.hJJ.onDestroy();
        }
        if (this.ifC != null) {
            this.ifC.cjy();
        }
    }

    public void ciz() {
        if (this.ifC != null) {
            this.ifC.cjy();
        }
    }

    public void ciA() {
    }

    public boolean ccG() {
        if (this.hJJ == null || !this.hJJ.isShowing()) {
            return false;
        }
        this.hJJ.wl(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hJJ != null) {
            this.hJJ.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ciB() {
        this.hFA.setImageResource(0);
    }

    public boolean ciC() {
        FrsViewData cbZ;
        ActivityConfig activityConfig;
        if (this.hHU == null || (cbZ = this.hHU.cbZ()) == null || (activityConfig = cbZ.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Gw(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Gw(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Gw(String str) {
        com.baidu.adp.lib.e.c.ln().a(str, 10, this.dYv, this.hHU.getUniqueId());
    }

    private String ciD() {
        FrsViewData cbZ;
        if (this.hHU == null || (cbZ = this.hHU.cbZ()) == null || cbZ.activityConfig == null) {
            return "";
        }
        return cbZ.activityConfig.addthread_text;
    }

    public boolean cdt() {
        FrsViewData cbZ;
        String fixedText;
        if (this.hHU != null && (cbZ = this.hHU.cbZ()) != null) {
            if (bf.checkUpIsLogin(this.hHU.getPageContext().getPageActivity())) {
                AntiData anti = cbZ.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (as.getRealSize(forbid_info) > 14) {
                            forbid_info = as.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hHU.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.aYR();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hHU.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hHU.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.aYR();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hHU.getPageContext().getPageActivity());
        aVar.xl(as.getFixedText(string, 50, true));
        aVar.b(as.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hHU.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(as.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    bd.baV().b(d.this.hHU.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hHU.getPageContext()).aYL();
        return true;
    }

    public boolean ciE() {
        if (this.hJJ == null) {
            return false;
        }
        return this.hJJ.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hHU != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.ifC == null) {
                this.ifC = new l(this.hHU.getActivity(), this);
            }
            this.ifC.cjy();
            this.ifC.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cfm() {
        return (this.fwT.doW() || cdt()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hFA = ovalActionButton;
            this.hFA.setOnClickListener(this.mOnClickListener);
            if (!ciC()) {
                ciB();
            }
        }
    }

    public boolean cdg() {
        if (this.hJJ == null) {
            return false;
        }
        return this.hJJ.isShowing();
    }
}
