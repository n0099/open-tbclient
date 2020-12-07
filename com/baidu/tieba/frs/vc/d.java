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
    private com.baidu.tieba.ueg.d gvD;
    public OvalActionButton iSW;
    private FrsFragment iVq;
    public com.baidu.tieba.write.g iXm;
    private com.baidu.tieba.frs.profession.permission.c iXo;
    private l jwH;
    private NoPressedRelativeLayout jwj;
    private c.a iXp = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
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
                d.this.cEd();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qj(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bh.checkUpIsLogin(d.this.iVq.getPageContext().getPageActivity()) && !d.this.gvD.dTh() && !d.this.cEf()) {
                if (d.this.jwH != null) {
                    d.this.jwH.cLv();
                }
                if (d.this.iVq.cCc().BR(502) == null || d.this.iVq.cCc().cLm() == null) {
                    d.this.Af(-1);
                } else {
                    d.this.iXo.aR(d.this.iVq.getForumId(), d.this.iVq.cCc().cLm().tabId);
                }
                d.this.cKs();
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
                d.this.cKw();
                return;
            }
            d.this.iSW.setImageDrawable(null);
            aVar.drawImageTo(d.this.iSW);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cEd() {
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
        if (this.iVq != null && this.iVq.cCJ() != null && (forum = this.iVq.cCJ().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iVq.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.iVq = frsFragment;
            this.jwj = noPressedRelativeLayout;
            this.gvD = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.iXo = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.iXo.a(this.iXp);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKs() {
        ar arVar = new ar("c13604");
        if (this.iVq != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iVq.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af(int i) {
        if (this.iXm == null) {
            this.iXm = new com.baidu.tieba.write.g(this.iVq.getPageContext(), this.jwj, "frs");
            this.iXm.VC("2");
            ItemInfo itemInfo = this.iVq.cCJ().itemInfo;
            this.iXm.zd((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.iXm.VB(cKy());
        if (this.iVq.cCJ().getAnti() != null) {
            this.iXm.setCanGoods(this.iVq.cCJ().getAnti().getCanGoods());
        }
        ForumWriteData cCN = this.iVq.cCN();
        cCN.setDefaultZone(i);
        this.iXm.a(cCN);
        this.iXm.b(this.iVq.cCJ().itemInfo);
        this.iXm.MF(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.iVq != null && this.iVq.cCJ() != null) {
            this.iXm.b(this.iVq.cCJ().itemInfo);
        }
        this.iXm.a(false, (View) null, (View) this.iSW);
        this.iVq.cCG().setAlpha(0);
        if (this.iVq != null && this.iVq.cCJ() != null && this.iVq.cCJ().itemInfo != null) {
            TiebaStatic.log(new ar("c13721").dY("fid", this.iVq.getForumId()).dY("fname", this.iVq.getForumName()).dY("obj_param1", this.iVq.cCJ().itemInfo.name));
        }
    }

    public void pY(boolean z) {
        FrsViewData cCJ;
        if (this.iSW != null) {
            cKx();
            this.iSW.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cCJ = this.iVq.cCJ()) != null && cCJ.postTopic != null && cCJ.getForum() != null && !StringUtils.isNull(cCJ.getForum().getId()) && !StringUtils.isNull(cCJ.postTopic.recom_title) && !StringUtils.isNull(cCJ.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cCX().F(cCJ.getForum().getId(), cCJ.postTopic.uniq_topicid.longValue())) {
                a(this.iSW, cCJ);
            }
        }
    }

    public void cKt() {
        if (this.iXm != null) {
            this.iXm.onDestroy();
        }
        if (this.jwH != null) {
            this.jwH.cLv();
        }
    }

    public void cKu() {
        if (this.jwH != null) {
            this.jwH.cLv();
        }
    }

    public void cKv() {
    }

    public boolean cDq() {
        if (this.iXm == null || !this.iXm.isShowing()) {
            return false;
        }
        this.iXm.ze(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.iXm != null) {
            this.iXm.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cKw() {
        this.iSW.setImageResource(0);
    }

    public boolean cKx() {
        FrsViewData cCJ;
        ActivityConfig activityConfig;
        if (this.iVq == null || (cCJ = this.iVq.cCJ()) == null || (activityConfig = cCJ.activityConfig) == null || activityConfig.type.intValue() != 2) {
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
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.eRb, this.iVq.getUniqueId());
    }

    private String cKy() {
        FrsViewData cCJ;
        if (this.iVq == null || (cCJ = this.iVq.cCJ()) == null || cCJ.activityConfig == null) {
            return "";
        }
        return cCJ.activityConfig.addthread_text;
    }

    public boolean cEf() {
        FrsViewData cCJ;
        String fixedText;
        if (this.iVq != null && (cCJ = this.iVq.cCJ()) != null) {
            if (bh.checkUpIsLogin(this.iVq.getPageContext().getPageActivity())) {
                AntiData anti = cCJ.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (au.getRealSize(forbid_info) > 14) {
                            forbid_info = au.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.iVq.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.iVq.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.iVq.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.brB();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iVq.getPageContext().getPageActivity());
        aVar.Bq(au.getFixedText(string, 50, true));
        aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.iVq.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    bf.bua().b(d.this.iVq.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.iVq.getPageContext()).brv();
        return true;
    }

    public boolean cKz() {
        if (this.iXm == null) {
            return false;
        }
        return this.iXm.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.iVq != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jwH == null) {
                this.jwH = new l(this.iVq.getActivity(), this);
            }
            this.jwH.cLv();
            this.jwH.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cGg() {
        return (this.gvD.dTh() || cEf()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.iSW = ovalActionButton;
            this.iSW.setOnClickListener(this.mOnClickListener);
            if (!cKx()) {
                cKw();
            }
        }
    }

    public boolean cDP() {
        if (this.iXm == null) {
            return false;
        }
        return this.iXm.isShowing();
    }
}
