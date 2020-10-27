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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
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
/* loaded from: classes22.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d ghZ;
    public OvalActionButton iBt;
    private FrsFragment iDN;
    public com.baidu.tieba.write.g iFL;
    private com.baidu.tieba.frs.profession.permission.c iFN;
    private NoPressedRelativeLayout jbY;
    private l jcw;
    private c.a iFO = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pz(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                d.this.yP(1);
            } else if (z) {
                d.this.yP(0);
            } else if (i != 502) {
                d.this.yP(-1);
            } else {
                d.this.cxJ();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pA(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.iDN.getPageContext().getPageActivity()) && !d.this.ghZ.dLo() && !d.this.cxL()) {
                if (d.this.jcw != null) {
                    d.this.jcw.cEa();
                }
                if (d.this.iDN.cvI().As(502) == null || d.this.iDN.cvI().cDR() == null) {
                    d.this.yP(-1);
                } else {
                    d.this.iFN.aP(d.this.iDN.getForumId(), d.this.iDN.cvI().cDR().tabId);
                }
                d.this.cCX();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eFb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cDb();
                return;
            }
            d.this.iBt.setImageDrawable(null);
            aVar.drawImageTo(d.this.iBt);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cxJ() {
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
        if (this.iDN != null && this.iDN.cwo() != null && (forum = this.iDN.cwo().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iDN.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.iDN = frsFragment;
            this.jbY = noPressedRelativeLayout;
            this.ghZ = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.iFN = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.iFN.a(this.iFO);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCX() {
        aq aqVar = new aq("c13604");
        if (this.iDN != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iDN.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yP(int i) {
        if (this.iFL == null) {
            this.iFL = new com.baidu.tieba.write.g(this.iDN.getPageContext(), this.jbY, "frs");
            this.iFL.Ul("2");
            ItemInfo itemInfo = this.iDN.cwo().itemInfo;
            this.iFL.yi((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.iFL.Uk(cDd());
        if (this.iDN.cwo().getAnti() != null) {
            this.iFL.setCanGoods(this.iDN.cwo().getAnti().getCanGoods());
        }
        ForumWriteData cws = this.iDN.cws();
        cws.setDefaultZone(i);
        this.iFL.a(cws);
        this.iFL.b(this.iDN.cwo().itemInfo);
        this.iFL.KX(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.iDN != null && this.iDN.cwo() != null) {
            this.iFL.b(this.iDN.cwo().itemInfo);
        }
        this.iFL.a(false, (View) null, (View) this.iBt);
        this.iDN.cwl().setAlpha(0);
        if (this.iDN != null && this.iDN.cwo() != null && this.iDN.cwo().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dR("fid", this.iDN.getForumId()).dR("fname", this.iDN.getForumName()).dR("obj_param1", this.iDN.cwo().itemInfo.name));
        }
    }

    public void pp(boolean z) {
        FrsViewData cwo;
        if (this.iBt != null) {
            cDc();
            this.iBt.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cwo = this.iDN.cwo()) != null && cwo.postTopic != null && cwo.getForum() != null && !StringUtils.isNull(cwo.getForum().getId()) && !StringUtils.isNull(cwo.postTopic.recom_title) && !StringUtils.isNull(cwo.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cwC().F(cwo.getForum().getId(), cwo.postTopic.uniq_topicid.longValue())) {
                a(this.iBt, cwo);
            }
        }
    }

    public void cCY() {
        if (this.iFL != null) {
            this.iFL.onDestroy();
        }
        if (this.jcw != null) {
            this.jcw.cEa();
        }
    }

    public void cCZ() {
        if (this.jcw != null) {
            this.jcw.cEa();
        }
    }

    public void cDa() {
    }

    public boolean cwV() {
        if (this.iFL == null || !this.iFL.isShowing()) {
            return false;
        }
        this.iFL.yj(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.iFL != null) {
            this.iFL.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cDb() {
        this.iBt.setImageResource(0);
    }

    public boolean cDc() {
        FrsViewData cwo;
        ActivityConfig activityConfig;
        if (this.iDN == null || (cwo = this.iDN.cwo()) == null || (activityConfig = cwo.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            KJ(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            KJ(activityConfig.addthread_icon);
            return true;
        }
    }

    private void KJ(String str) {
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.eFb, this.iDN.getUniqueId());
    }

    private String cDd() {
        FrsViewData cwo;
        if (this.iDN == null || (cwo = this.iDN.cwo()) == null || cwo.activityConfig == null) {
            return "";
        }
        return cwo.activityConfig.addthread_text;
    }

    public boolean cxL() {
        FrsViewData cwo;
        String fixedText;
        if (this.iDN != null && (cwo = this.iDN.cwo()) != null) {
            if (bg.checkUpIsLogin(this.iDN.getPageContext().getPageActivity())) {
                AntiData anti = cwo.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.iDN.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a2.setExtraTextLineSpacing(1.25f);
                        a2.bmI();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.iDN.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.iDN.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.bmI();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iDN.getPageContext().getPageActivity());
        aVar.Ba(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.iDN.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(at.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    be.boR().b(d.this.iDN.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.iDN.getPageContext()).bmC();
        return true;
    }

    public boolean cDe() {
        if (this.iFL == null) {
            return false;
        }
        return this.iFL.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.iDN != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jcw == null) {
                this.jcw = new l(this.iDN.getActivity(), this);
            }
            this.jcw.cEa();
            this.jcw.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean czJ() {
        return (this.ghZ.dLo() || cxL()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.iBt = ovalActionButton;
            this.iBt.setOnClickListener(this.mOnClickListener);
            if (!cDc()) {
                cDb();
            }
        }
    }

    public boolean cxv() {
        if (this.iFL == null) {
            return false;
        }
        return this.iFL.isShowing();
    }
}
