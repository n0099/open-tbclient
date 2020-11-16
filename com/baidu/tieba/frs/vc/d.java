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
/* loaded from: classes21.dex */
public class d implements com.baidu.tieba.frs.entelechy.b.d {
    private com.baidu.tieba.ueg.d gnu;
    public OvalActionButton iIe;
    private FrsFragment iKx;
    public com.baidu.tieba.write.g iMv;
    private com.baidu.tieba.frs.profession.permission.c iMx;
    private NoPressedRelativeLayout jiH;
    private l jjf;
    private c.a iMy = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pL(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                d.this.zA(1);
            } else if (z) {
                d.this.zA(0);
            } else if (i != 502) {
                d.this.zA(-1);
            } else {
                d.this.czN();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pM(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bh.checkUpIsLogin(d.this.iKx.getPageContext().getPageActivity()) && !d.this.gnu.dNP() && !d.this.czP()) {
                if (d.this.jjf != null) {
                    d.this.jjf.cGg();
                }
                if (d.this.iKx.cxM().Bd(502) == null || d.this.iKx.cxM().cFX() == null) {
                    d.this.zA(-1);
                } else {
                    d.this.iMx.aQ(d.this.iKx.getForumId(), d.this.iKx.cxM().cFX().tabId);
                }
                d.this.cFd();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> eJP = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cFh();
                return;
            }
            d.this.iIe.setImageDrawable(null);
            aVar.drawImageTo(d.this.iIe);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void czN() {
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
        if (this.iKx != null && this.iKx.cys() != null && (forum = this.iKx.cys().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.iKx.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.iKx = frsFragment;
            this.jiH = noPressedRelativeLayout;
            this.gnu = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.iMx = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.iMx.a(this.iMy);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFd() {
        ar arVar = new ar("c13604");
        if (this.iKx != null) {
            com.baidu.tbadk.pageInfo.c.a(this.iKx.getContext(), arVar);
        }
        TiebaStatic.log(arVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zA(int i) {
        if (this.iMv == null) {
            this.iMv = new com.baidu.tieba.write.g(this.iKx.getPageContext(), this.jiH, "frs");
            this.iMv.Un("2");
            ItemInfo itemInfo = this.iKx.cys().itemInfo;
            this.iMv.yy((itemInfo == null || itemInfo.id.intValue() <= 0 || au.isEmpty(itemInfo.name)) ? false : true);
        }
        this.iMv.Um(cFj());
        if (this.iKx.cys().getAnti() != null) {
            this.iMv.setCanGoods(this.iKx.cys().getAnti().getCanGoods());
        }
        ForumWriteData cyw = this.iKx.cyw();
        cyw.setDefaultZone(i);
        this.iMv.a(cyw);
        this.iMv.b(this.iKx.cys().itemInfo);
        this.iMv.LN(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.iKx != null && this.iKx.cys() != null) {
            this.iMv.b(this.iKx.cys().itemInfo);
        }
        this.iMv.a(false, (View) null, (View) this.iIe);
        this.iKx.cyp().setAlpha(0);
        if (this.iKx != null && this.iKx.cys() != null && this.iKx.cys().itemInfo != null) {
            TiebaStatic.log(new ar("c13721").dR("fid", this.iKx.getForumId()).dR("fname", this.iKx.getForumName()).dR("obj_param1", this.iKx.cys().itemInfo.name));
        }
    }

    public void pB(boolean z) {
        FrsViewData cys;
        if (this.iIe != null) {
            cFi();
            this.iIe.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cys = this.iKx.cys()) != null && cys.postTopic != null && cys.getForum() != null && !StringUtils.isNull(cys.getForum().getId()) && !StringUtils.isNull(cys.postTopic.recom_title) && !StringUtils.isNull(cys.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cyG().F(cys.getForum().getId(), cys.postTopic.uniq_topicid.longValue())) {
                a(this.iIe, cys);
            }
        }
    }

    public void cFe() {
        if (this.iMv != null) {
            this.iMv.onDestroy();
        }
        if (this.jjf != null) {
            this.jjf.cGg();
        }
    }

    public void cFf() {
        if (this.jjf != null) {
            this.jjf.cGg();
        }
    }

    public void cFg() {
    }

    public boolean cyZ() {
        if (this.iMv == null || !this.iMv.isShowing()) {
            return false;
        }
        this.iMv.yz(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.iMv != null) {
            this.iMv.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cFh() {
        this.iIe.setImageResource(0);
    }

    public boolean cFi() {
        FrsViewData cys;
        ActivityConfig activityConfig;
        if (this.iKx == null || (cys = this.iKx.cys()) == null || (activityConfig = cys.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            KB(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            KB(activityConfig.addthread_icon);
            return true;
        }
    }

    private void KB(String str) {
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.eJP, this.iKx.getUniqueId());
    }

    private String cFj() {
        FrsViewData cys;
        if (this.iKx == null || (cys = this.iKx.cys()) == null || cys.activityConfig == null) {
            return "";
        }
        return cys.activityConfig.addthread_text;
    }

    public boolean czP() {
        FrsViewData cys;
        String fixedText;
        if (this.iKx != null && (cys = this.iKx.cys()) != null) {
            if (bh.checkUpIsLogin(this.iKx.getPageContext().getPageActivity())) {
                AntiData anti = cys.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (au.getRealSize(forbid_info) > 14) {
                            forbid_info = au.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.iKx.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a2.setExtraTextLineSpacing(1.25f);
                        a2.bom();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.iKx.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.iKx.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.bom();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.iKx.getPageContext().getPageActivity());
        aVar.AJ(au.getFixedText(string, 50, true));
        aVar.b(au.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.iKx.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    bf.bqF().b(d.this.iKx.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.iKx.getPageContext()).bog();
        return true;
    }

    public boolean cFk() {
        if (this.iMv == null) {
            return false;
        }
        return this.iMv.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.iKx != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jjf == null) {
                this.jjf = new l(this.iKx.getActivity(), this);
            }
            this.jjf.cGg();
            this.jjf.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cBN() {
        return (this.gnu.dNP() || czP()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.iIe = ovalActionButton;
            this.iIe.setOnClickListener(this.mOnClickListener);
            if (!cFi()) {
                cFh();
            }
        }
    }

    public boolean czz() {
        if (this.iMv == null) {
            return false;
        }
        return this.iMv.isShowing();
    }
}
