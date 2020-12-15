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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
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
    private com.baidu.tieba.ueg.d gvF;
    public OvalActionButton iSY;
    private FrsFragment iVs;
    public com.baidu.tieba.write.g iXo;
    private com.baidu.tieba.frs.profession.permission.c iXq;
    private l jwJ;
    private NoPressedRelativeLayout jwl;
    private c.a iXr = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qi(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                d.this.Af(1);
            } else if (z) {
                d.this.Af(0);
            } else if (i != 502) {
                d.this.Af(-1);
            } else {
                d.this.cEe();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qj(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bh.checkUpIsLogin(d.this.iVs.getPageContext().getPageActivity()) && !d.this.gvF.dTi() && !d.this.cEg()) {
                if (d.this.jwJ != null) {
                    d.this.jwJ.cLw();
                }
                if (d.this.iVs.cCd().BR(502) == null || d.this.iVs.cCd().cLn() == null) {
                    d.this.Af(-1);
                } else {
                    d.this.iXq.aR(d.this.iVs.getForumId(), d.this.iVs.cCd().cLn().tabId);
                }
                d.this.cKt();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eRb = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cKx();
                return;
            }
            d.this.iSY.setImageDrawable(null);
            aVar.drawImageTo(d.this.iSY);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cEe() {
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
        if (this.iVs != null && this.iVs.cCK() != null && (forum = this.iVs.cCK().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iVs.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.iVs = frsFragment;
            this.jwl = noPressedRelativeLayout;
            this.gvF = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.iXq = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.iXq.a(this.iXr);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKt() {
        ar arVar = new ar("c13604");
        if (this.iVs != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iVs.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af(int i) {
        if (this.iXo == null) {
            this.iXo = new com.baidu.tieba.write.g(this.iVs.getPageContext(), this.jwl, "frs");
            this.iXo.VC("2");
            ItemInfo itemInfo = this.iVs.cCK().itemInfo;
            this.iXo.zd((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.iXo.VB(cKz());
        if (this.iVs.cCK().getAnti() != null) {
            this.iXo.setCanGoods(this.iVs.cCK().getAnti().getCanGoods());
        }
        ForumWriteData cCO = this.iVs.cCO();
        cCO.setDefaultZone(i);
        this.iXo.a(cCO);
        this.iXo.b(this.iVs.cCK().itemInfo);
        this.iXo.MF(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.iVs != null && this.iVs.cCK() != null) {
            this.iXo.b(this.iVs.cCK().itemInfo);
        }
        this.iXo.a(false, (View) null, (View) this.iSY);
        this.iVs.cCH().setAlpha(0);
        if (this.iVs != null && this.iVs.cCK() != null && this.iVs.cCK().itemInfo != null) {
            TiebaStatic.log(new ar("c13721").dY("fid", this.iVs.getForumId()).dY("fname", this.iVs.getForumName()).dY("obj_param1", this.iVs.cCK().itemInfo.name));
        }
    }

    public void pY(boolean z) {
        FrsViewData cCK;
        if (this.iSY != null) {
            cKy();
            this.iSY.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cCK = this.iVs.cCK()) != null && cCK.postTopic != null && cCK.getForum() != null && !StringUtils.isNull(cCK.getForum().getId()) && !StringUtils.isNull(cCK.postTopic.recom_title) && !StringUtils.isNull(cCK.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cCY().F(cCK.getForum().getId(), cCK.postTopic.uniq_topicid.longValue())) {
                a(this.iSY, cCK);
            }
        }
    }

    public void cKu() {
        if (this.iXo != null) {
            this.iXo.onDestroy();
        }
        if (this.jwJ != null) {
            this.jwJ.cLw();
        }
    }

    public void cKv() {
        if (this.jwJ != null) {
            this.jwJ.cLw();
        }
    }

    public void cKw() {
    }

    public boolean cDr() {
        if (this.iXo == null || !this.iXo.isShowing()) {
            return false;
        }
        this.iXo.ze(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.iXo != null) {
            this.iXo.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKx() {
        this.iSY.setImageResource(0);
    }

    public boolean cKy() {
        FrsViewData cCK;
        ActivityConfig activityConfig;
        if (this.iVs == null || (cCK = this.iVs.cCK()) == null || (activityConfig = cCK.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            LI(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            LI(activityConfig.addthread_icon);
            return true;
        }
    }

    private void LI(String str) {
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.eRb, this.iVs.getUniqueId());
    }

    private String cKz() {
        FrsViewData cCK;
        if (this.iVs == null || (cCK = this.iVs.cCK()) == null || cCK.activityConfig == null) {
            return "";
        }
        return cCK.activityConfig.addthread_text;
    }

    public boolean cEg() {
        FrsViewData cCK;
        String fixedText;
        if (this.iVs != null && (cCK = this.iVs.cCK()) != null) {
            if (bh.checkUpIsLogin(this.iVs.getPageContext().getPageActivity())) {
                AntiData anti = cCK.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (au.getRealSize(forbid_info) > 14) {
                            forbid_info = au.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.iVs.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a2.setExtraTextLineSpacing(1.25f);
                        a2.brB();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.iVs.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.iVs.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.brB();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iVs.getPageContext().getPageActivity());
        aVar.Bq(au.getFixedText(string, 50, true));
        aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.iVs.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(au.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.5
                /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.frs.FrsFragment */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    bf.bua().b(d.this.iVs.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.iVs.getPageContext()).brv();
        return true;
    }

    public boolean cKA() {
        if (this.iXo == null) {
            return false;
        }
        return this.iXo.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.iVs != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jwJ == null) {
                this.jwJ = new l(this.iVs.getActivity(), this);
            }
            this.jwJ.cLw();
            this.jwJ.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cGh() {
        return (this.gvF.dTi() || cEg()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.iSY = ovalActionButton;
            this.iSY.setOnClickListener(this.mOnClickListener);
            if (!cKy()) {
                cKx();
            }
        }
    }

    public boolean cDQ() {
        if (this.iXo == null) {
            return false;
        }
        return this.iXo.isShowing();
    }
}
