package com.baidu.tieba.frs.sportspage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes21.dex */
public class a {
    private TextView aiU;
    private TbPageContext eGu;
    private TbImageView eWb;
    private FrsViewData iHB;
    private final View.OnClickListener iKO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eWb) {
                if (!au.isEmpty(a.this.jfQ) && a.this.iHB != null && a.this.iHB.getForum() != null) {
                    bf.bqF().a(a.this.eGu, new String[]{a.this.jfQ}, true);
                    TiebaStatic.log(new ar("c13415").dR("fid", a.this.iHB.getForum().getId()).ak("obj_type", a.this.iRv ? 2 : 1));
                }
            } else if ((view == a.this.jfP || view == a.this.aiU) && a.this.iHB != null && a.this.iHB.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eGu.getPageActivity(), a.this.iHB.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dR("fid", a.this.iHB.getForum().getId()));
            }
        }
    };
    private boolean iRC;
    private boolean iRv;
    private LinearGradientView jfO;
    private BarImageView jfP;
    private String jfQ;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eGu = frsSportsRecommendFragment.getPageContext();
            this.eWb = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jfO = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jfP = (BarImageView) view.findViewById(R.id.frs_image);
            this.aiU = (TextView) view.findViewById(R.id.forum_name);
            this.eWb.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jfP.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jfP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jfP.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jfP.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jfP.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iHB = frsViewData;
            this.iRC = false;
            String name = this.iHB.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aiU.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jfP.startLoad(this.iHB.getForum().getImage_url(), 10, false);
            cEr();
            this.jfP.setOnClickListener(this.iKO);
            this.aiU.setOnClickListener(this.iKO);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jfP.refresh();
        if (au.isEmpty(str)) {
            this.iRC = false;
            cEr();
            return;
        }
        this.iRC = true;
        this.jfQ = str2;
        this.iRv = z;
        this.eWb.startLoad(str, 10, false);
        this.eWb.setOnClickListener(this.iKO);
    }

    private void cEr() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iHB != null && (forum = this.iHB.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iRC) {
                if (this.jfO != null) {
                    this.jfO.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jfO.changeSkinType(skinType);
                }
                if (this.eWb != null) {
                    this.eWb.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cEr();
        ap.setViewTextColor(this.aiU, R.color.CAM_X0101);
        if (this.jfP != null) {
            this.jfP.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jfP.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jfP.setStrokeColorResId(R.color.CAM_X0201);
            this.jfP.invalidate();
        }
    }
}
