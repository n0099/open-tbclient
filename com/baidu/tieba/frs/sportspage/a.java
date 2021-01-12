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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class a {
    private TextView ajE;
    private TbPageContext eSJ;
    private TbImageView fiy;
    private LinearGradientView jBi;
    private BarImageView jBj;
    private String jBk;
    private FrsViewData jaa;
    private final View.OnClickListener jdo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fiy) {
                if (!at.isEmpty(a.this.jBk) && a.this.jaa != null && a.this.jaa.getForum() != null) {
                    be.bsB().a(a.this.eSJ, new String[]{a.this.jBk}, true);
                    TiebaStatic.log(new aq("c13415").dW("fid", a.this.jaa.getForum().getId()).an("obj_type", a.this.jka ? 2 : 1));
                }
            } else if ((view == a.this.jBj || view == a.this.ajE) && a.this.jaa != null && a.this.jaa.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eSJ.getPageActivity(), a.this.jaa.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dW("fid", a.this.jaa.getForum().getId()));
            }
        }
    };
    private boolean jka;
    private boolean jkh;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eSJ = frsSportsRecommendFragment.getPageContext();
            this.fiy = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jBi = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jBj = (BarImageView) view.findViewById(R.id.frs_image);
            this.ajE = (TextView) view.findViewById(R.id.forum_name);
            this.fiy.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jBj.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jBj.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jBj.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jBj.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jBj.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.jaa = frsViewData;
            this.jkh = false;
            String name = this.jaa.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ajE.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jBj.startLoad(this.jaa.getForum().getImage_url(), 10, false);
            cIO();
            this.jBj.setOnClickListener(this.jdo);
            this.ajE.setOnClickListener(this.jdo);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jBj.refresh();
        if (at.isEmpty(str)) {
            this.jkh = false;
            cIO();
            return;
        }
        this.jkh = true;
        this.jBk = str2;
        this.jka = z;
        this.fiy.startLoad(str, 10, false);
        this.fiy.setOnClickListener(this.jdo);
    }

    private void cIO() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jaa != null && (forum = this.jaa.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jkh) {
                if (this.jBi != null) {
                    this.jBi.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jBi.changeSkinType(skinType);
                }
                if (this.fiy != null) {
                    this.fiy.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cIO();
        ao.setViewTextColor(this.ajE, R.color.CAM_X0101);
        if (this.jBj != null) {
            this.jBj.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jBj.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.jBj.setStrokeColorResId(R.color.CAM_X0201);
            this.jBj.invalidate();
        }
    }
}
