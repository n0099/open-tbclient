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
    private com.baidu.tieba.ueg.d fXV;
    private NoPressedRelativeLayout iPC;
    private l iQa;
    public OvalActionButton ioX;
    private FrsFragment irr;
    public com.baidu.tieba.write.g itp;
    private com.baidu.tieba.frs.profession.permission.c itr;
    private c.a its = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void ph(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void C(boolean z, int i) {
            if (z && i == 502) {
                d.this.yw(1);
            } else if (z) {
                d.this.yw(0);
            } else if (i != 502) {
                d.this.yw(-1);
            } else {
                d.this.cuC();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void pi(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.irr.getPageContext().getPageActivity()) && !d.this.fXV.dIg() && !d.this.cuE()) {
                if (d.this.iQa != null) {
                    d.this.iQa.cAT();
                }
                if (d.this.irr.csB().zZ(502) == null || d.this.irr.csB().cAK() == null) {
                    d.this.yw(-1);
                } else {
                    d.this.itr.aO(d.this.irr.getForumId(), d.this.irr.csB().cAK().tabId);
                }
                d.this.czQ();
            }
        }
    };
    private final com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a> ewC = new com.baidu.adp.lib.e.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.b
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.czU();
                return;
            }
            d.this.ioX.setImageDrawable(null);
            aVar.drawImageTo(d.this.ioX);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cuC() {
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
        if (this.irr != null && this.irr.cth() != null && (forum = this.irr.cth().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.irr.getContext());
            frsProfessionIntroActivityConfig.putColor(str11, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.irr = frsFragment;
            this.iPC = noPressedRelativeLayout;
            this.fXV = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.itr = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.itr.a(this.its);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czQ() {
        aq aqVar = new aq("c13604");
        if (this.irr != null) {
            com.baidu.tbadk.pageInfo.c.a(this.irr.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yw(int i) {
        if (this.itp == null) {
            this.itp = new com.baidu.tieba.write.g(this.irr.getPageContext(), this.iPC, "frs");
            this.itp.TM("2");
            ItemInfo itemInfo = this.irr.cth().itemInfo;
            this.itp.xR((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.itp.TL(czW());
        if (this.irr.cth().getAnti() != null) {
            this.itp.setCanGoods(this.irr.cth().getAnti().getCanGoods());
        }
        ForumWriteData ctl = this.irr.ctl();
        ctl.setDefaultZone(i);
        this.itp.a(ctl);
        this.itp.b(this.irr.cth().itemInfo);
        this.itp.KF(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.irr != null && this.irr.cth() != null) {
            this.itp.b(this.irr.cth().itemInfo);
        }
        this.itp.a(false, (View) null, (View) this.ioX);
        this.irr.cte().setAlpha(0);
        if (this.irr != null && this.irr.cth() != null && this.irr.cth().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dK("fid", this.irr.getForumId()).dK("fname", this.irr.getForumName()).dK("obj_param1", this.irr.cth().itemInfo.name));
        }
    }

    public void oX(boolean z) {
        FrsViewData cth;
        if (this.ioX != null) {
            czV();
            this.ioX.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cth = this.irr.cth()) != null && cth.postTopic != null && cth.getForum() != null && !StringUtils.isNull(cth.getForum().getId()) && !StringUtils.isNull(cth.postTopic.recom_title) && !StringUtils.isNull(cth.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.ctv().C(cth.getForum().getId(), cth.postTopic.uniq_topicid.longValue())) {
                a(this.ioX, cth);
            }
        }
    }

    public void czR() {
        if (this.itp != null) {
            this.itp.onDestroy();
        }
        if (this.iQa != null) {
            this.iQa.cAT();
        }
    }

    public void czS() {
        if (this.iQa != null) {
            this.iQa.cAT();
        }
    }

    public void czT() {
    }

    public boolean ctO() {
        if (this.itp == null || !this.itp.isShowing()) {
            return false;
        }
        this.itp.xS(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.itp != null) {
            this.itp.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czU() {
        this.ioX.setImageResource(0);
    }

    public boolean czV() {
        FrsViewData cth;
        ActivityConfig activityConfig;
        if (this.irr == null || (cth = this.irr.cth()) == null || (activityConfig = cth.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Kk(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Kk(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Kk(String str) {
        com.baidu.adp.lib.e.c.mS().a(str, 10, this.ewC, this.irr.getUniqueId());
    }

    private String czW() {
        FrsViewData cth;
        if (this.irr == null || (cth = this.irr.cth()) == null || cth.activityConfig == null) {
            return "";
        }
        return cth.activityConfig.addthread_text;
    }

    public boolean cuE() {
        FrsViewData cth;
        String fixedText;
        if (this.irr != null && (cth = this.irr.cth()) != null) {
            if (bg.checkUpIsLogin(this.irr.getPageContext().getPageActivity())) {
                AntiData anti = cth.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast a2 = BdToast.a((Context) this.irr.getPageContext().getPageActivity(), (CharSequence) forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        a2.setExtraTextLineSpacing(1.25f);
                        a2.bkP();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.irr.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast a2 = BdToast.a((Context) this.irr.getPageContext().getPageActivity(), (CharSequence) string, R.drawable.icon_pure_toast_mistake40_svg, true);
            a2.setExtraTextLineSpacing(1.25f);
            a2.bkP();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.irr.getPageContext().getPageActivity());
        aVar.AH(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.irr.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.bmY().b(d.this.irr.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.irr.getPageContext()).bkJ();
        return true;
    }

    public boolean czX() {
        if (this.itp == null) {
            return false;
        }
        return this.itp.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.irr != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.iQa == null) {
                this.iQa = new l(this.irr.getActivity(), this);
            }
            this.iQa.cAT();
            this.iQa.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.b.d
    public boolean cwC() {
        return (this.fXV.dIg() || cuE()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.ioX = ovalActionButton;
            this.ioX.setOnClickListener(this.mOnClickListener);
            if (!czV()) {
                czU();
            }
        }
    }

    public boolean cuo() {
        if (this.itp == null) {
            return false;
        }
        return this.itp.isShowing();
    }
}
