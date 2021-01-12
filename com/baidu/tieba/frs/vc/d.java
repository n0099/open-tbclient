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
    private com.baidu.tieba.ueg.d gBY;
    private NoPressedRelativeLayout jEa;
    private l jEy;
    public OvalActionButton jaC;
    private FrsFragment jcX;
    public com.baidu.tieba.write.g jeT;
    private com.baidu.tieba.frs.profession.permission.c jeV;
    private c.a jeW = new c.a() { // from class: com.baidu.tieba.frs.vc.d.1
        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qC(boolean z) {
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void B(boolean z, int i) {
            if (z && i == 502) {
                d.this.yL(1);
            } else if (z) {
                d.this.yL(0);
            } else if (i != 502) {
                d.this.yL(-1);
            } else {
                d.this.cDi();
            }
        }

        @Override // com.baidu.tieba.frs.profession.permission.c.a
        public void qD(boolean z) {
        }
    };
    private final View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.vc.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (bg.checkUpIsLogin(d.this.jcX.getPageContext().getPageActivity()) && !d.this.gBY.dPi() && !d.this.cDk() && !WriteActivityConfig.isAsyncWriting()) {
                if (d.this.jEy != null) {
                    d.this.jEy.cKI();
                }
                if (d.this.jcX.cBg().Ax(502) == null || d.this.jcX.cBg().cKz() == null) {
                    d.this.yL(-1);
                } else {
                    d.this.jeV.aZ(d.this.jcX.getForumId(), d.this.jcX.cBg().cKz().tabId);
                }
                d.this.cJC();
            }
        }
    };
    private final com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a> eWs = new com.baidu.adp.lib.e.c<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.frs.vc.d.3
        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.lib.e.c
        public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str, int i) {
            super.onLoaded((AnonymousClass3) aVar, str, i);
            if (aVar == null || !aVar.isValidNow()) {
                d.this.cJG();
                return;
            }
            d.this.jaC.setImageDrawable(null);
            aVar.drawImageTo(d.this.jaC);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cDi() {
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
        if (this.jcX != null && this.jcX.cBN() != null && (forum = this.jcX.cBN().getForum()) != null) {
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
            FrsProfessionIntroActivityConfig frsProfessionIntroActivityConfig = new FrsProfessionIntroActivityConfig(this.jcX.getContext());
            frsProfessionIntroActivityConfig.putColor(str7, str6, str5, str4, str3, str2, str);
            frsProfessionIntroActivityConfig.start();
        }
    }

    public d(FrsFragment frsFragment, NoPressedRelativeLayout noPressedRelativeLayout) {
        if (frsFragment != null && noPressedRelativeLayout != null) {
            this.jcX = frsFragment;
            this.jEa = noPressedRelativeLayout;
            this.gBY = new com.baidu.tieba.ueg.d(frsFragment.getPageContext());
            this.jeV = new com.baidu.tieba.frs.profession.permission.c(frsFragment.getPageContext());
            this.jeV.a(this.jeW);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJC() {
        aq aqVar = new aq("c13604");
        if (this.jcX != null) {
            com.baidu.tbadk.pageInfo.c.a(this.jcX.getContext(), aqVar);
        }
        TiebaStatic.log(aqVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yL(int i) {
        if (this.jeT == null) {
            this.jeT = new com.baidu.tieba.write.g(this.jcX.getPageContext(), this.jEa, "frs");
            this.jeT.TY("2");
            ItemInfo itemInfo = this.jcX.cBN().itemInfo;
            this.jeT.yZ((itemInfo == null || itemInfo.id.intValue() <= 0 || at.isEmpty(itemInfo.name)) ? false : true);
        }
        this.jeT.TX(cJI());
        if (this.jcX.cBN().getAnti() != null) {
            this.jeT.zb(this.jcX.cBN().getAnti().getCanGoods());
        }
        ForumWriteData cBR = this.jcX.cBR();
        cBR.setDefaultZone(i);
        this.jeT.a(cBR);
        this.jeT.b(this.jcX.cBN().itemInfo);
        this.jeT.KL(i == 1 ? R.drawable.btn_frs_professional_edit_n : 0);
        if (this.jcX != null && this.jcX.cBN() != null) {
            this.jeT.b(this.jcX.cBN().itemInfo);
        }
        this.jeT.a(false, (View) null, (View) this.jaC);
        this.jcX.cBK().setAlpha(0);
        if (this.jcX != null && this.jcX.cBN() != null && this.jcX.cBN().itemInfo != null) {
            TiebaStatic.log(new aq("c13721").dW("fid", this.jcX.getForumId()).dW("fname", this.jcX.getForumName()).dW("obj_param1", this.jcX.cBN().itemInfo.name));
        }
    }

    public void qs(boolean z) {
        FrsViewData cBN;
        if (this.jaC != null) {
            cJH();
            this.jaC.setVisibility(z ? 0 : 8);
            if (z && TbadkCoreApplication.isLogin() && (cBN = this.jcX.cBN()) != null && cBN.postTopic != null && cBN.getForum() != null && !StringUtils.isNull(cBN.getForum().getId()) && !StringUtils.isNull(cBN.postTopic.recom_title) && !StringUtils.isNull(cBN.postTopic.recom_topic) && com.baidu.tieba.frs.FrsHotTopic.a.cCb().F(cBN.getForum().getId(), cBN.postTopic.uniq_topicid.longValue())) {
                a(this.jaC, cBN);
            }
        }
    }

    public void cJD() {
        if (this.jeT != null) {
            this.jeT.onDestroy();
        }
        if (this.jEy != null) {
            this.jEy.cKI();
        }
    }

    public void cJE() {
        if (this.jEy != null) {
            this.jEy.cKI();
        }
    }

    public void cJF() {
    }

    public boolean cCu() {
        if (this.jeT == null || !this.jeT.isShowing()) {
            return false;
        }
        this.jeT.za(true);
        return true;
    }

    public void onChangeSkinType(int i) {
        if (this.jeT != null) {
            this.jeT.onChangeSkinType(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJG() {
        this.jaC.setImageResource(0);
    }

    public boolean cJH() {
        FrsViewData cBN;
        ActivityConfig activityConfig;
        if (this.jcX == null || (cBN = this.jcX.cBN()) == null || (activityConfig = cBN.activityConfig) == null || activityConfig.type.intValue() != 2) {
            return false;
        }
        if ((TbadkCoreApplication.getInst().getSkinType() == 1) && !TextUtils.isEmpty(activityConfig.night_addthread_icon)) {
            Kx(activityConfig.night_addthread_icon);
            return true;
        } else if (TextUtils.isEmpty(activityConfig.addthread_icon)) {
            return false;
        } else {
            Kx(activityConfig.addthread_icon);
            return true;
        }
    }

    private void Kx(String str) {
        com.baidu.adp.lib.e.d.mx().a(str, 10, this.eWs, this.jcX.getUniqueId());
    }

    private String cJI() {
        FrsViewData cBN;
        if (this.jcX == null || (cBN = this.jcX.cBN()) == null || cBN.activityConfig == null) {
            return "";
        }
        return cBN.activityConfig.addthread_text;
    }

    public boolean cDk() {
        FrsViewData cBN;
        String fixedText;
        if (this.jcX != null && (cBN = this.jcX.cBN()) != null) {
            if (bg.checkUpIsLogin(this.jcX.getPageContext().getPageActivity())) {
                AntiData anti = cBN.getAnti();
                if (anti != null) {
                    if (a(anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                        return true;
                    }
                    if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                        String forbid_info = anti.getForbid_info();
                        if (at.getRealSize(forbid_info) > 14) {
                            forbid_info = at.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                        }
                        BdToast b2 = BdToast.b(this.jcX.getPageContext().getPageActivity(), forbid_info, R.drawable.icon_pure_toast_mistake40_svg, true);
                        b2.setExtraTextLineSpacing(1.25f);
                        b2.bqk();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? this.jcX.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b2 = BdToast.b(this.jcX.getPageContext().getPageActivity(), string, R.drawable.icon_pure_toast_mistake40_svg, true);
            b2.setExtraTextLineSpacing(1.25f);
            b2.bqk();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.jcX.getPageContext().getPageActivity());
        aVar.Ad(at.getFixedText(string, 50, true));
        aVar.b(at.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? this.jcX.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.vc.d.4
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
                    be.bsB().b(d.this.jcX.getPageContext(), new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(this.jcX.getPageContext()).bqe();
        return true;
    }

    public boolean cJJ() {
        if (this.jeT == null) {
            return false;
        }
        return this.jeT.isShowing();
    }

    public void a(View view, FrsViewData frsViewData) {
        if (this.jcX != null && frsViewData != null && frsViewData.getForum() != null && frsViewData.postTopic != null) {
            if (this.jEy == null) {
                this.jEy = new l(this.jcX.getActivity(), this);
            }
            this.jEy.cKI();
            this.jEy.b(view, frsViewData);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.a.d
    public boolean cFp() {
        return (this.gBY.dPi() || cDk()) ? false : true;
    }

    public void b(OvalActionButton ovalActionButton) {
        if (ovalActionButton != null) {
            this.jaC = ovalActionButton;
            this.jaC.setOnClickListener(this.mOnClickListener);
            if (!cJH()) {
                cJG();
            }
        }
    }

    public boolean cCT() {
        if (this.jeT == null) {
            return false;
        }
        return this.jeT.isShowing();
    }
}
