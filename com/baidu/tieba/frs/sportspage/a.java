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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes4.dex */
public class a {
    private TbPageContext cfl;
    private TextView cqm;
    private TbImageView crk;
    private boolean fDA;
    private boolean fDt;
    private LinearGradientView fQb;
    private BarImageView fQc;
    private String fQd;
    private FrsViewData fuR;
    private final View.OnClickListener fxy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.crk) {
                if (!aq.isEmpty(a.this.fQd) && a.this.fuR != null && a.this.fuR.getForum() != null) {
                    ba.amQ().a(a.this.cfl, new String[]{a.this.fQd}, true);
                    TiebaStatic.log(new an("c13415").bS("fid", a.this.fuR.getForum().getId()).O("obj_type", a.this.fDt ? 2 : 1));
                }
            } else if ((view == a.this.fQc || view == a.this.cqm) && a.this.fuR != null && a.this.fuR.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cfl.getPageActivity(), a.this.fuR.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").bS("fid", a.this.fuR.getForum().getId()));
            }
        }
    };

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cfl = frsSportsRecommendFragment.getPageContext();
            this.crk = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fQb = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fQc = (BarImageView) view.findViewById(R.id.frs_image);
            this.cqm = (TextView) view.findViewById(R.id.forum_name);
            this.crk.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fQc.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fQc.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fQc.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fQc.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fQc.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fuR = frsViewData;
            this.fDA = false;
            String name = this.fuR.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.cqm.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fQc.startLoad(this.fuR.getForum().getImage_url(), 10, false);
            bpG();
            this.fQc.setOnClickListener(this.fxy);
            this.cqm.setOnClickListener(this.fxy);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.fQc.refresh();
        if (aq.isEmpty(str)) {
            this.fDA = false;
            bpG();
            return;
        }
        this.fDA = true;
        this.fQd = str2;
        this.fDt = z;
        this.crk.startLoad(str, 10, false);
        this.crk.setOnClickListener(this.fxy);
    }

    private void bpG() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fuR != null && this.fuR.getForum() != null && (themeColorInfo = this.fuR.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fDA) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fQb != null) {
                    this.fQb.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fQb.changeSkinType(skinType);
                }
                if (this.crk != null) {
                    this.crk.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bpG();
        am.setViewTextColor(this.cqm, (int) R.color.cp_cont_a);
        if (this.fQc != null) {
            this.fQc.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fQc.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fQc.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fQc.invalidate();
        }
    }
}
