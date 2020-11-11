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
/* loaded from: classes22.dex */
public class a {
    private TextView aiP;
    private TbPageContext eIc;
    private TbImageView eWU;
    private FrsViewData iGN;
    private final View.OnClickListener iKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eWU) {
                if (!at.isEmpty(a.this.jff) && a.this.iGN != null && a.this.iGN.getForum() != null) {
                    be.brr().a(a.this.eIc, new String[]{a.this.jff}, true);
                    TiebaStatic.log(new aq("c13415").dR("fid", a.this.iGN.getForum().getId()).al("obj_type", a.this.iQI ? 2 : 1));
                }
            } else if ((view == a.this.jfe || view == a.this.aiP) && a.this.iGN != null && a.this.iGN.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eIc.getPageActivity(), a.this.iGN.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dR("fid", a.this.iGN.getForum().getId()));
            }
        }
    };
    private boolean iQI;
    private boolean iQP;
    private LinearGradientView jfd;
    private BarImageView jfe;
    private String jff;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eIc = frsSportsRecommendFragment.getPageContext();
            this.eWU = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jfd = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jfe = (BarImageView) view.findViewById(R.id.frs_image);
            this.aiP = (TextView) view.findViewById(R.id.forum_name);
            this.eWU.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jfe.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jfe.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jfe.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jfe.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jfe.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iGN = frsViewData;
            this.iQP = false;
            String name = this.iGN.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aiP.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jfe.startLoad(this.iGN.getForum().getImage_url(), 10, false);
            cEM();
            this.jfe.setOnClickListener(this.iKb);
            this.aiP.setOnClickListener(this.iKb);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jfe.refresh();
        if (at.isEmpty(str)) {
            this.iQP = false;
            cEM();
            return;
        }
        this.iQP = true;
        this.jff = str2;
        this.iQI = z;
        this.eWU.startLoad(str, 10, false);
        this.eWU.setOnClickListener(this.iKb);
    }

    private void cEM() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iGN != null && (forum = this.iGN.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iQP) {
                if (this.jfd != null) {
                    this.jfd.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jfd.changeSkinType(skinType);
                }
                if (this.eWU != null) {
                    this.eWU.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cEM();
        ap.setViewTextColor(this.aiP, R.color.cp_cont_a);
        if (this.jfe != null) {
            this.jfe.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jfe.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jfe.setStrokeColorResId(R.color.cp_bg_line_d);
            this.jfe.invalidate();
        }
    }
}
