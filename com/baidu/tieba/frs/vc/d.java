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
    private com.baidu.tieba.ueg.d gnN;
    public OvalActionButton iHq;
    private FrsFragment iJK;
    public com.baidu.tieba.write.g iLI;
    private com.baidu.tieba.frs.profession.permission.c iLK;
    private NoPressedRelativeLayout jhV;
    private l jiu;
    private c.a iLL = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pI(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                d.this.zc(1);
            } else if (z) {
                d.this.zc(0);
            } else if (i != 502) {
                d.this.zc(-1);
            } else {
                d.this.cAk();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pJ(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.iJK.getPageContext().getPageActivity()) && !d.this.gnN.dNQ() && !d.this.cAm()) {
                if (d.this.jiu != null) {
                    d.this.jiu.cGB();
                }
                if (d.this.iJK.cyj().AF(502) == null || d.this.iJK.cyj().cGs() == null) {
                    d.this.zc(-1);
                } else {
                    d.this.iLK.aR(d.this.iJK.getForumId(), d.this.iJK.cyj().cGs().tabId);
                }
                d.this.cFy();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eKQ = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cFC();
                return;
            }
            d.this.iHq.setImageDrawable(null);
            aVar.drawImageTo(d.this.iHq);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cAk() {
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
        if (this.iJK != null && this.iJK.cyP() != null && (forum = this.iJK.cyP().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iJK.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.iJK = frsFragment;
            this.jhV = noPressedRelativeLayout;
            this.gnN = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.iLK = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.iLK.a(this.iLL);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFy() {
        aq aqVar = new aq("c13604");
        if (this.iJK != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iJK.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zc(int i) {
        if (this.iLI == null) {
            this.iLI = new com.baidu.tieba.write.g(this.iJK.getPageContext(), this.jhV, "frs");
            this.iLI.UC("2");
            ItemInfo itemInfo = this.iJK.cyP().itemInfo;
            this.iLI.yr((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.iLI.UB(cFE());
        if (this.iJK.cyP().getAnti() != null) {
            this.iLI.setCanGoods(this.iJK.cyP().getAnti().getCanGoods());
        }
        ForumWriteData cyT = this.iJK.cyT();
        cyT.setDefaultZone(i);
        this.iLI.a(cyT);
        this.iLI.b(this.iJK.cyP().itemInfo);
        this.iLI.Lk(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.iJK != null && this.iJK.cyP() != null) {
            this.iLI.b(this.iJK.cyP().itemInfo);
        }
        this.iLI.a(false, (View) null, (View) this.iHq);
        this.iJK.cyM().setAlpha(0);
        if (this.iJK != null && this.iJK.cyP() != null && this.iJK.cyP().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dR("fid", this.iJK.getForumId()).dR("fname", this.iJK.getForumName()).dR("obj_param1", this.iJK.cyP().itemInfo.name));
        }
    }

    public void py(boolean z) {
        FrsViewData cyP;
        if (this.iHq != null) {
            cFD();
            this.iHq.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cyP = this.iJK.cyP()) != null && cyP.postTopic != null && cyP.getForum() != null && !StringUtils.isNull(cyP.getForum().getId()) && !StringUtils.isNull(cyP.postTopic.recom_title) && !StringUtils.isNull(cyP.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.czd().F(cyP.getForum().getId(), cyP.postTopic.uniq_topicid.longValue())) {
                a(this.iHq, cyP);
            }
        }
    }

    public void cFz() {
        if (this.iLI != null) {
            this.iLI.onDestroy();
        }
        if (this.jiu != null) {
            this.jiu.cGB();
        }
    }

    public void cFA() {
        if (this.jiu != null) {
            this.jiu.cGB();
        }
    }

    public void cFB() {
    }

    public boolean czw() {
        if (this.iLI == null || !this.iLI.isShowing()) {
            return false;
        }
        this.iLI.ys(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.iLI != null) {
            this.iLI.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFC() {
        this.iHq.setImageResource(0);
    }

    public boolean cFD() {
        FrsViewData cyP;
        ActivityConfig activityConfig;
        if (this.iJK == null || (cyP = this.iJK.cyP()) == null || (activityConfig = cyP.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            La(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            La(activityConfig.addthread_icon);
            return true;
        }
    }

    private void La(String str) {
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.eKQ, this.iJK.getUniqueId());
    }

    private String cFE() {
        FrsViewData cyP;
        if (this.iJK == null || (cyP = this.iJK.cyP()) == null || cyP.activityConfig == null) {
            return "";
        }
        return cyP.activityConfig.addthread_text;
    }

    public boolean cAm() {
        FrsViewData cyP;
        String fixedText;
        if (this.iJK != null && (cyP = this.iJK.cyP()) != null) {
            if (bg.checkUpIsLogin(this.iJK.getPageContext().getPageActivity())) {
                AntiData anti = cyP.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.iJK.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a2.setExtraTextLineSpacing(1.25f);
                        a2.bpi();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.iJK.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.iJK.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.bpi();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iJK.getPageContext().getPageActivity());
        aVar.Bo(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.iJK.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.brr().b(d.this.iJK.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.iJK.getPageContext()).bpc();
        return true;
    }

    public boolean cFF() {
        if (this.iLI == null) {
            return false;
        }
        return this.iLI.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.iJK != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jiu == null) {
                this.jiu = new l(this.iJK.getActivity(), this);
            }
            this.jiu.cGB();
            this.jiu.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cCk() {
        return (this.gnN.dNQ() || cAm()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.iHq = ovalActionButton;
            this.iHq.setOnClickListener(this.mOnClickListener);
            if (!cFD()) {
                cFC();
            }
        }
    }

    public boolean czW() {
        if (this.iLI == null) {
            return false;
        }
        return this.iLI.isShowing();
    }
}
