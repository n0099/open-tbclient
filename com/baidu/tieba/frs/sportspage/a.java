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
/* loaded from: classes6.dex */
public class a {
    private TbPageContext cQU;
    private TextView dcO;
    private TbImageView ddM;
    private LinearGradientView gDx;
    private BarImageView gDy;
    private String gDz;
    private FrsViewData giA;
    private final View.OnClickListener gle = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ddM) {
                if (!aq.isEmpty(a.this.gDz) && a.this.giA != null && a.this.giA.getForum() != null) {
                    ba.aEa().a(a.this.cQU, new String[]{a.this.gDz}, true);
                    TiebaStatic.log(new an("c13415").cp("fid", a.this.giA.getForum().getId()).Z("obj_type", a.this.gqN ? 2 : 1));
                }
            } else if ((view == a.this.gDy || view == a.this.dcO) && a.this.giA != null && a.this.giA.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.cQU.getPageActivity(), a.this.giA.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").cp("fid", a.this.giA.getForum().getId()));
            }
        }
    };
    private boolean gqN;
    private boolean gqU;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.cQU = frsSportsRecommendFragment.getPageContext();
            this.ddM = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.gDx = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.gDy = (BarImageView) view.findViewById(R.id.frs_image);
            this.dcO = (TextView) view.findViewById(R.id.forum_name);
            this.ddM.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gDy.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.gDy.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.gDy.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.gDy.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.gDy.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.giA = frsViewData;
            this.gqU = false;
            String name = this.giA.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dcO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.gDy.startLoad(this.giA.getForum().getImage_url(), 10, false);
            bHa();
            this.gDy.setOnClickListener(this.gle);
            this.dcO.setOnClickListener(this.gle);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.gDy.refresh();
        if (aq.isEmpty(str)) {
            this.gqU = false;
            bHa();
            return;
        }
        this.gqU = true;
        this.gDz = str2;
        this.gqN = z;
        this.ddM.startLoad(str, 10, false);
        this.ddM.setOnClickListener(this.gle);
    }

    private void bHa() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.giA != null && (forum = this.giA.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.gqU) {
                if (this.gDx != null) {
                    this.gDx.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.gDx.changeSkinType(skinType);
                }
                if (this.ddM != null) {
                    this.ddM.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bHa();
        am.setViewTextColor(this.dcO, (int) R.color.cp_cont_a);
        if (this.gDy != null) {
            this.gDy.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.gDy.setBorderColor(am.getColor(R.color.black_alpha15));
            this.gDy.setStrokeColorResId(R.color.cp_bg_line_d);
            this.gDy.invalidate();
        }
    }
}
