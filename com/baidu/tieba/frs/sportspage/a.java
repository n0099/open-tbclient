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
/* loaded from: classes7.dex */
public class a {
    private TbPageContext cRe;
    private TextView dcY;
    private TbImageView ddW;
    private LinearGradientView gGM;
    private BarImageView gGN;
    private String gGO;
    private FrsViewData glJ;
    private final View.OnClickListener gon = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ddW) {
                if (!aq.isEmpty(a.this.gGO) && a.this.glJ != null && a.this.glJ.getForum() != null) {
                    ba.aEt().a(a.this.cRe, new String[]{a.this.gGO}, true);
                    TiebaStatic.log(new an("c13415").cp("fid", a.this.glJ.getForum().getId()).Z("obj_type", a.this.gtW ? 2 : 1));
                }
            } else if ((view == a.this.gGN || view == a.this.dcY) && a.this.glJ != null && a.this.glJ.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cRe.getPageActivity(), a.this.glJ.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cp("fid", a.this.glJ.getForum().getId()));
            }
        }
    };
    private boolean gtW;
    private boolean gud;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cRe = frsSportsRecommendFragment.getPageContext();
            this.ddW = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gGM = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gGN = (BarImageView) view.findViewById(R.id.frs_image);
            this.dcY = (TextView) view.findViewById(R.id.forum_name);
            this.ddW.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gGN.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gGN.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gGN.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gGN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gGN.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.glJ = frsViewData;
            this.gud = false;
            String name = this.glJ.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dcY.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gGN.startLoad(this.glJ.getForum().getImage_url(), 10, false);
            bIc();
            this.gGN.setOnClickListener(this.gon);
            this.dcY.setOnClickListener(this.gon);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gGN.refresh();
        if (aq.isEmpty(str)) {
            this.gud = false;
            bIc();
            return;
        }
        this.gud = true;
        this.gGO = str2;
        this.gtW = z;
        this.ddW.startLoad(str, 10, false);
        this.ddW.setOnClickListener(this.gon);
    }

    private void bIc() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.glJ != null && (forum = this.glJ.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gud) {
                if (this.gGM != null) {
                    this.gGM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gGM.changeSkinType(skinType);
                }
                if (this.ddW != null) {
                    this.ddW.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bIc();
        am.setViewTextColor(this.dcY, (int) R.color.cp_cont_a);
        if (this.gGN != null) {
            this.gGN.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gGN.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gGN.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gGN.invalidate();
        }
    }
}
