package com.baidu.tieba.frs.vc;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
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
/* loaded from: classes2.dex */
public class d implements com.baidu.tieba.frs.entelechy.a.d {
    private com.baidu.tieba.ueg.d gGE;
    private NoPressedRelativeLayout jIG;
    private l jJe;
    public OvalActionButton jfj;
    private FrsFragment jhE;
    public com.baidu.tieba.write.g jjB;
    private com.baidu.tieba.frs.profession.permission.c jjD;
    private c.a jjE = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qG(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                d.this.Ar(1);
            } else if (z) {
                d.this.Ar(0);
            } else if (i != 502) {
                d.this.Ar(-1);
            } else {
                d.this.cHa();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qH(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.jhE.getPageContext().getPageActivity()) && !d.this.gGE.dTa() && !d.this.cHc() && !WriteActivityConfig.isAsyncWriting()) {
                if (d.this.jJe != null) {
                    d.this.jJe.cOA();
                }
                if (d.this.jhE.cEY().Cd(502) == null || d.this.jhE.cEY().cOr() == null) {
                    d.this.Ar(-1);
                } else {
                    d.this.jjD.aZ(d.this.jhE.getForumId(), d.this.jhE.cEY().cOr().tabId);
                }
                d.this.cNu();
            }
        }
    };
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> fba = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cNy();
                return;
            }
            d.this.jfj.setImageDrawable(null);
            aVar.drawImageTo(d.this.jfj);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cHa() {
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
        if (this.jhE != null && this.jhE.cFF() != null && (forum = this.jhE.cFF().getForum()) != null) {
            ThemeColorInfo themeColorInfo = forum.getThemeColorInfo();
            if (themeColorInfo != null) {
                int skinType = TbadkCoreApplication.getInst().getSkinType();
                if (themeColorInfo.day != null) {
                    String str11 = themeColorInfo.day.light_color;
                    str8 = themeColorInfo.day.dark_color;
                    if (skinType == 0) {
                        str9 = themeColorInfo.day.pattern_image;
                        str6 = str11;
                    } else {
                        str6 = str11;
                        str9 = null;
                    }
                } else {
                    str8 = null;
                    str6 = null;
                    str9 = null;
                }
                if (themeColorInfo.night != null) {
                    str4 = themeColorInfo.night.light_color;
                    String str12 = themeColorInfo.night.dark_color;
                    if (skinType == 1) {
                        str3 = str12;
                        str10 = themeColorInfo.night.pattern_image;
                    } else {
                        str3 = str12;
                        str10 = str9;
                    }
                } else {
                    str3 = null;
                    str4 = null;
                    str10 = str9;
                }
                if (themeColorInfo.dark != null) {
                    str2 = themeColorInfo.dark.light_color;
                    String str13 = themeColorInfo.dark.dark_color;
                    if (skinType == 4) {
                        str = str13;
                        str5 = str8;
                        str7 = themeColorInfo.dark.pattern_image;
                    } else {
                        str = str13;
                        str5 = str8;
                        str7 = str10;
                    }
                } else {
                    str = null;
                    str2 = null;
                    str5 = str8;
                    str7 = str10;
                }
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
            }
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jhE.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.jhE = frsFragment;
            this.jIG = noPressedRelativeLayout;
            this.gGE = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.jjD = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.jjD.a(this.jjE);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNu() {
        aq aqVar = new aq("c13604");
        if (this.jhE != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jhE.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar(int i) {
        if (this.jjB == null) {
            this.jjB = new com.baidu.tieba.write.g(this.jhE.getPageContext(), this.jIG, "frs");
            this.jjB.Vg("2");
            ItemInfo itemInfo = this.jhE.cFF().itemInfo;
            this.jjB.zd((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.jjB.Vf(cNA());
        if (this.jhE.cFF().getAnti() != null) {
            this.jjB.zf(this.jhE.cFF().getAnti().getCanGoods());
        }
        ForumWriteData cFJ = this.jhE.cFJ();
        cFJ.setDefaultZone(i);
        this.jjB.a(cFJ);
        this.jjB.b(this.jhE.cFF().itemInfo);
        this.jjB.Ms(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.jhE != null && this.jhE.cFF() != null) {
            this.jjB.b(this.jhE.cFF().itemInfo);
        }
        this.jjB.a(false, (View) null, (View) this.jfj);
        this.jhE.cFC().setAlpha(0);
        if (this.jhE != null && this.jhE.cFF() != null && this.jhE.cFF().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dX("fid", this.jhE.getForumId()).dX("fname", this.jhE.getForumName()).dX("obj_param1", this.jhE.cFF().itemInfo.name));
        }
    }

    public void qw(boolean z) {
        FrsViewData cFF;
        if (this.jfj != null) {
            cNz();
            this.jfj.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cFF = this.jhE.cFF()) != null && cFF.postTopic != null && cFF.getForum() != null && !StringUtils.isNull(cFF.getForum().getId()) && !StringUtils.isNull(cFF.postTopic.recom_title) && !StringUtils.isNull(cFF.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cFT().F(cFF.getForum().getId(), cFF.postTopic.uniq_topicid.longValue())) {
                a(this.jfj, cFF);
            }
        }
    }

    public void cNv() {
        if (this.jjB != null) {
            this.jjB.onDestroy();
        }
        if (this.jJe != null) {
            this.jJe.cOA();
        }
    }

    public void cNw() {
        if (this.jJe != null) {
            this.jJe.cOA();
        }
    }

    public void cNx() {
    }

    public boolean cGm() {
        if (this.jjB == null || !this.jjB.isShowing()) {
            return false;
        }
        this.jjB.ze(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.jjB != null) {
            this.jjB.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cNy() {
        this.jfj.setImageResource(0);
    }

    public boolean cNz() {
        FrsViewData cFF;
        ActivityConfig activityConfig;
        if (this.jhE == null || (cFF = this.jhE.cFF()) == null || (activityConfig = cFF.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            LH(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            LH(activityConfig.addthread_icon);
            return true;
        }
    }

    private void LH(String str) {
        com.baidu.adp.lib.e.d.mx().a(str, 10, this.fba, this.jhE.getUniqueId());
    }

    private String cNA() {
        FrsViewData cFF;
        if (this.jhE == null || (cFF = this.jhE.cFF()) == null || cFF.activityConfig == null) {
            return "";
        }
        return cFF.activityConfig.addthread_text;
    }

    public boolean cHc() {
        FrsViewData cFF;
        String fixedText;
        if (this.jhE != null && (cFF = this.jhE.cFF()) != null) {
            if (bg.checkUpIsLogin(this.jhE.getPageContext().getPageActivity())) {
                AntiData anti = cFF.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b2 = BdToast.b(this.jhE.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        b2.setExtraTextLineSpacing(1.25f);
                        b2.bue();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.jhE.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b2 = BdToast.b(this.jhE.getPageContext().getPageActivity(), string, R.drawable.icon_pure_toast_mistake40_svg, true);
            b2.setExtraTextLineSpacing(1.25f);
            b2.bue();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jhE.getPageContext().getPageActivity());
        aVar.Bo(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.jhE.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.bwv().b(d.this.jhE.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.jhE.getPageContext()).btY();
        return true;
    }

    public boolean cNB() {
        if (this.jjB == null) {
            return false;
        }
        return this.jjB.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.jhE != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jJe == null) {
                this.jJe = new l(this.jhE.getActivity(), this);
            }
            this.jJe.cOA();
            this.jJe.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.d
    public boolean cJh() {
        return (this.gGE.dTa() || cHc()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.jfj = ovalActionButton;
            this.jfj.setOnClickListener(this.mOnClickListener);
            if (!cNz()) {
                cNy();
            }
        }
    }

    public boolean cGL() {
        if (this.jjB == null) {
            return false;
        }
        return this.jjB.isShowing();
    }
}
