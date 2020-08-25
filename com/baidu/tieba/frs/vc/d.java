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
/* loaded from: classes16.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d fIl;
    public OvalActionButton hSQ;
    private FrsFragment hVk;
    public com.baidu.tieba.write.g hXi;
    private com.baidu.tieba.frs.profession.permission.c hXk;
    private l itG;
    private NoPressedRelativeLayout iti;
    private c.a hXl = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ou(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void z(boolean z, int i) {
            if (z && i == 502) {
                d.this.xr(1);
            } else if (z) {
                d.this.xr(0);
            } else if (i != 502) {
                d.this.xr(-1);
            } else {
                d.this.cnQ();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ov(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.hVk.getPageContext().getPageActivity()) && !d.this.fIl.dAr() && !d.this.cnS()) {
                if (d.this.itG != null) {
                    d.this.itG.cuc();
                }
                if (d.this.hVk.clQ().yV(502) == null || d.this.hVk.clQ().ctT() == null) {
                    d.this.xr(-1);
                } else {
                    d.this.hXk.aN(d.this.hVk.getForumId(), d.this.hVk.clQ().ctT().tabId);
                }
                d.this.ctb();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eib = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.ctf();
                return;
            }
            d.this.hSQ.setImageDrawable(null);
            aVar.drawImageTo(d.this.hSQ);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cnQ() {
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
        if (this.hVk != null && this.hVk.cmw() != null && (forum = this.hVk.cmw().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.hVk.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.hVk = frsFragment;
            this.iti = noPressedRelativeLayout;
            this.fIl = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.hXk = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.hXk.a(this.hXl);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctb() {
        aq aqVar = new aq("c13604");
        if (this.hVk != null) {
            com.baidu.tbadk.pageInfo.c.a(this.hVk.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xr(int i) {
        if (this.hXi == null) {
            this.hXi = new com.baidu.tieba.write.g(this.hVk.getPageContext(), this.iti, "frs");
            this.hXi.Sy("2");
            ItemInfo itemInfo = this.hVk.cmw().itemInfo;
            this.hXi.wZ((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.hXi.Sx(cth());
        if (this.hVk.cmw().getAnti() != null) {
            this.hXi.setCanGoods(this.hVk.cmw().getAnti().getCanGoods());
        }
        ForumWriteData cmA = this.hVk.cmA();
        cmA.setDefaultZone(i);
        this.hXi.a(cmA);
        this.hXi.b(this.hVk.cmw().itemInfo);
        this.hXi.Jv(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.hVk != null && this.hVk.cmw() != null) {
            this.hXi.b(this.hVk.cmw().itemInfo);
        }
        this.hXi.a(false, (View) null, (View) this.hSQ);
        this.hVk.cmt().setAlpha(0);
        if (this.hVk != null && this.hVk.cmw() != null && this.hVk.cmw().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dD("fid", this.hVk.getForumId()).dD("fname", this.hVk.getForumName()).dD("obj_param1", this.hVk.cmw().itemInfo.name));
        }
    }

    public void ok(boolean z) {
        FrsViewData cmw;
        if (this.hSQ != null) {
            ctg();
            this.hSQ.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cmw = this.hVk.cmw()) != null && cmw.postTopic != null && cmw.getForum() != null && !StringUtils.isNull(cmw.getForum().getId()) && !StringUtils.isNull(cmw.postTopic.recom_title) && !StringUtils.isNull(cmw.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cmK().B(cmw.getForum().getId(), cmw.postTopic.uniq_topicid.longValue())) {
                a(this.hSQ, cmw);
            }
        }
    }

    public void ctc() {
        if (this.hXi != null) {
            this.hXi.onDestroy();
        }
        if (this.itG != null) {
            this.itG.cuc();
        }
    }

    public void ctd() {
        if (this.itG != null) {
            this.itG.cuc();
        }
    }

    public void cte() {
    }

    public boolean cnd() {
        if (this.hXi == null || !this.hXi.isShowing()) {
            return false;
        }
        this.hXi.xa(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.hXi != null) {
            this.hXi.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctf() {
        this.hSQ.setImageResource(0);
    }

    public boolean ctg() {
        FrsViewData cmw;
        ActivityConfig activityConfig;
        if (this.hVk == null || (cmw = this.hVk.cmw()) == null || (activityConfig = cmw.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            IY(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            IY(activityConfig.addthread_icon);
            return true;
        }
    }

    private void IY(String str) {
        com.baidu.adp.lib.e.c.mM().a(str, 10, this.eib, this.hVk.getUniqueId());
    }

    private String cth() {
        FrsViewData cmw;
        if (this.hVk == null || (cmw = this.hVk.cmw()) == null || cmw.activityConfig == null) {
            return "";
        }
        return cmw.activityConfig.addthread_text;
    }

    public boolean cnS() {
        FrsViewData cmw;
        String fixedText;
        if (this.hVk != null && (cmw = this.hVk.cmw()) != null) {
            if (bg.checkUpIsLogin(this.hVk.getPageContext().getPageActivity())) {
                AntiData anti = cmw.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a = BdToast.a((Context) this.hVk.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a.setExtraTextLineSpacing(1.25f);
                        a.bhm();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.hVk.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a = BdToast.a((Context) this.hVk.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a.setExtraTextLineSpacing(1.25f);
            a.bhm();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.hVk.getPageContext().getPageActivity());
        aVar.zz(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.hVk.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.bju().b(d.this.hVk.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.hVk.getPageContext()).bhg();
        return true;
    }

    public boolean cti() {
        if (this.hXi == null) {
            return false;
        }
        return this.hXi.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.hVk != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.itG == null) {
                this.itG = new l(this.hVk.getActivity(), this);
            }
            this.itG.cuc();
            this.itG.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cpR() {
        return (this.fIl.dAr() || cnS()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.hSQ = ovalActionButton;
            this.hSQ.setOnClickListener(this.mOnClickListener);
            if (!ctg()) {
                ctf();
            }
        }
    }

    public boolean cnD() {
        if (this.hXi == null) {
            return false;
        }
        return this.hXi.isShowing();
    }
}
