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
/* loaded from: classes21.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fLE;
    public OvalActionButton hZW;
    private NoPressedRelativeLayout iAK;
    private l iBi;
    private FrsFragment icq;
    public com.baidu.tieba.write.g ies;
    private com.baidu.tieba.frs.profession.permission.c ieu;
    private c.a iev = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                d.this.xQ(1);
            } else if (z) {
                d.this.xQ(0);
            } else if (i != 502) {
                d.this.xQ(-1);
            } else {
                d.this.cre();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void oD(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.icq.getPageContext().getPageActivity()) && !d.this.fLE.dEu() && !d.this.crg()) {
                if (d.this.iBi != null) {
                    d.this.iBi.cxw();
                }
                if (d.this.icq.cpd().zt(502) == null || d.this.icq.cpd().cxn() == null) {
                    d.this.xQ(-1);
                } else {
                    d.this.ieu.aN(d.this.icq.getForumId(), d.this.icq.cpd().cxn().tabId);
                }
                d.this.cwt();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eku = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cwx();
                return;
            }
            d.this.hZW.setImageDrawable(null);
            aVar.drawImageTo(d.this.hZW);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cre() {
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
        if (this.icq != null && this.icq.cpJ() != null && (forum = this.icq.cpJ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.icq.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.icq = frsFragment;
            this.iAK = noPressedRelativeLayout;
            this.fLE = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.ieu = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.ieu.a(this.iev);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwt() {
        aq aqVar = new aq("c13604");
        if (this.icq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.icq.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xQ(int i) {
        if (this.ies == null) {
            this.ies = new com.baidu.tieba.write.g(this.icq.getPageContext(), this.iAK, "frs");
            this.ies.SY("2");
            ItemInfo itemInfo = this.icq.cpJ().itemInfo;
            this.ies.xk((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.ies.SX(cwz());
        if (this.icq.cpJ().getAnti() != null) {
            this.ies.setCanGoods(this.icq.cpJ().getAnti().getCanGoods());
        }
        ForumWriteData cpN = this.icq.cpN();
        cpN.setDefaultZone(i);
        this.ies.a(cpN);
        this.ies.b(this.icq.cpJ().itemInfo);
        this.ies.JZ(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.icq != null && this.icq.cpJ() != null) {
            this.ies.b(this.icq.cpJ().itemInfo);
        }
        this.ies.a(false, (View) null, (View) this.hZW);
        this.icq.cpG().setAlpha(0);
        if (this.icq != null && this.icq.cpJ() != null && this.icq.cpJ().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dF("fid", this.icq.getForumId()).dF("fname", this.icq.getForumName()).dF("obj_param1", this.icq.cpJ().itemInfo.name));
        }
    }

    public void os(boolean z) {
        FrsViewData cpJ;
        if (this.hZW != null) {
            cwy();
            this.hZW.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cpJ = this.icq.cpJ()) != null && cpJ.postTopic != null && cpJ.getForum() != null && !StringUtils.isNull(cpJ.getForum().getId()) && !StringUtils.isNull(cpJ.postTopic.recom_title) && !StringUtils.isNull(cpJ.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cpX().C(cpJ.getForum().getId(), cpJ.postTopic.uniq_topicid.longValue())) {
                a(this.hZW, cpJ);
            }
        }
    }

    public void cwu() {
        if (this.ies != null) {
            this.ies.onDestroy();
        }
        if (this.iBi != null) {
            this.iBi.cxw();
        }
    }

    public void cwv() {
        if (this.iBi != null) {
            this.iBi.cxw();
        }
    }

    public void cww() {
    }

    public boolean cqq() {
        if (this.ies == null || !this.ies.isShowing()) {
            return false;
        }
        this.ies.xl(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.ies != null) {
            this.ies.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cwx() {
        this.hZW.setImageResource(0);
    }

    public boolean cwy() {
        FrsViewData cpJ;
        ActivityConfig activityConfig;
        if (this.icq == null || (cpJ = this.icq.cpJ()) == null || (activityConfig = cpJ.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Jx(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Jx(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Jx(String str) {
        com.baidu.adp.lib.e.c.mR().a(str, 10, this.eku, this.icq.getUniqueId());
    }

    private String cwz() {
        FrsViewData cpJ;
        if (this.icq == null || (cpJ = this.icq.cpJ()) == null || cpJ.activityConfig == null) {
            return "";
        }
        return cpJ.activityConfig.addthread_text;
    }

    public boolean crg() {
        FrsViewData cpJ;
        String fixedText;
        if (this.icq != null && (cpJ = this.icq.cpJ()) != null) {
            if (bg.checkUpIsLogin(this.icq.getPageContext().getPageActivity())) {
                AntiData anti = cpJ.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.icq.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.big();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.icq.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.icq.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.big();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.icq.getPageContext().getPageActivity());
        aVar.zV(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.icq.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.bkp().b(d.this.icq.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.icq.getPageContext()).bia();
        return true;
    }

    public boolean cwA() {
        if (this.ies == null) {
            return false;
        }
        return this.ies.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.icq != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.iBi == null) {
                this.iBi = new l(this.icq.getActivity(), this);
            }
            this.iBi.cxw();
            this.iBi.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean ctf() {
        return (this.fLE.dEu() || crg()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hZW = ovalActionButton;
            this.hZW.setOnClickListener(this.mOnClickListener);
            if (!cwy()) {
                cwx();
            }
        }
    }

    public boolean cqQ() {
        if (this.ies == null) {
            return false;
        }
        return this.ies.isShowing();
    }
}
