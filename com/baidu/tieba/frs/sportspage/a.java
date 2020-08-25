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
    private TextView ahZ;
    private TbPageContext efn;
    private TbImageView eur;
    private FrsViewData hSn;
    private final View.OnClickListener hVB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eur) {
                if (!at.isEmpty(a.this.iqx) && a.this.hSn != null && a.this.hSn.getForum() != null) {
                    be.bju().a(a.this.efn, new String[]{a.this.iqx}, true);
                    TiebaStatic.log(new aq("c13415").dD("fid", a.this.hSn.getForum().getId()).ai("obj_type", a.this.ici ? 2 : 1));
                }
            } else if ((view == a.this.iqw || view == a.this.ahZ) && a.this.hSn != null && a.this.hSn.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.efn.getPageActivity(), a.this.hSn.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dD("fid", a.this.hSn.getForum().getId()));
            }
        }
    };
    private boolean ici;
    private boolean icp;
    private LinearGradientView iqv;
    private BarImageView iqw;
    private String iqx;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.efn = frsSportsRecommendFragment.getPageContext();
            this.eur = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.iqv = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.iqw = (BarImageView) view.findViewById(R.id.frs_image);
            this.ahZ = (TextView) view.findViewById(R.id.forum_name);
            this.eur.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iqw.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iqw.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iqw.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.iqw.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.iqw.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hSn = frsViewData;
            this.icp = false;
            String name = this.hSn.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ahZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.iqw.startLoad(this.hSn.getForum().getImage_url(), 10, false);
            csr();
            this.iqw.setOnClickListener(this.hVB);
            this.ahZ.setOnClickListener(this.hVB);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.iqw.refresh();
        if (at.isEmpty(str)) {
            this.icp = false;
            csr();
            return;
        }
        this.icp = true;
        this.iqx = str2;
        this.ici = z;
        this.eur.startLoad(str, 10, false);
        this.eur.setOnClickListener(this.hVB);
    }

    private void csr() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hSn != null && (forum = this.hSn.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.icp) {
                if (this.iqv != null) {
                    this.iqv.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.iqv.changeSkinType(skinType);
                }
                if (this.eur != null) {
                    this.eur.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        csr();
        ap.setViewTextColor(this.ahZ, R.color.cp_cont_a);
        if (this.iqw != null) {
            this.iqw.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.iqw.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iqw.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iqw.invalidate();
        }
    }
}
