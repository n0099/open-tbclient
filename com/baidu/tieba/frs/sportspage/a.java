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
/* loaded from: classes16.dex */
public class a {
    private TextView aib;
    private TbPageContext efr;
    private TbImageView euv;
    private FrsViewData hSt;
    private final View.OnClickListener hVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.euv) {
                if (!at.isEmpty(a.this.iqD) && a.this.hSt != null && a.this.hSt.getForum() != null) {
                    be.bju().a(a.this.efr, new String[]{a.this.iqD}, true);
                    TiebaStatic.log(new aq("c13415").dD("fid", a.this.hSt.getForum().getId()).ai("obj_type", a.this.ico ? 2 : 1));
                }
            } else if ((view == a.this.iqC || view == a.this.aib) && a.this.hSt != null && a.this.hSt.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.efr.getPageActivity(), a.this.hSt.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dD("fid", a.this.hSt.getForum().getId()));
            }
        }
    };
    private boolean ico;
    private boolean icv;
    private LinearGradientView iqB;
    private BarImageView iqC;
    private String iqD;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.efr = frsSportsRecommendFragment.getPageContext();
            this.euv = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.iqB = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.iqC = (BarImageView) view.findViewById(R.id.frs_image);
            this.aib = (TextView) view.findViewById(R.id.forum_name);
            this.euv.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iqC.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iqC.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iqC.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.iqC.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.iqC.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hSt = frsViewData;
            this.icv = false;
            String name = this.hSt.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aib.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.iqC.startLoad(this.hSt.getForum().getImage_url(), 10, false);
            css();
            this.iqC.setOnClickListener(this.hVH);
            this.aib.setOnClickListener(this.hVH);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.iqC.refresh();
        if (at.isEmpty(str)) {
            this.icv = false;
            css();
            return;
        }
        this.icv = true;
        this.iqD = str2;
        this.ico = z;
        this.euv.startLoad(str, 10, false);
        this.euv.setOnClickListener(this.hVH);
    }

    private void css() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hSt != null && (forum = this.hSt.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.icv) {
                if (this.iqB != null) {
                    this.iqB.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.iqB.changeSkinType(skinType);
                }
                if (this.euv != null) {
                    this.euv.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        css();
        ap.setViewTextColor(this.aib, R.color.cp_cont_a);
        if (this.iqC != null) {
            this.iqC.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.iqC.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iqC.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iqC.invalidate();
        }
    }
}
