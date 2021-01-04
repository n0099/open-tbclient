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
    private TextView akv;
    private TbPageContext eXu;
    private TbImageView fnh;
    private LinearGradientView jFO;
    private BarImageView jFP;
    private String jFQ;
    private FrsViewData jeH;
    private final View.OnClickListener jhV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fnh) {
                if (!at.isEmpty(a.this.jFQ) && a.this.jeH != null && a.this.jeH.getForum() != null) {
                    be.bwu().a(a.this.eXu, new String[]{a.this.jFQ}, true);
                    TiebaStatic.log(new aq("c13415").dX("fid", a.this.jeH.getForum().getId()).an("obj_type", a.this.joH ? 2 : 1));
                }
            } else if ((view == a.this.jFP || view == a.this.akv) && a.this.jeH != null && a.this.jeH.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eXu.getPageActivity(), a.this.jeH.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dX("fid", a.this.jeH.getForum().getId()));
            }
        }
    };
    private boolean joH;
    private boolean joO;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eXu = frsSportsRecommendFragment.getPageContext();
            this.fnh = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jFO = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jFP = (BarImageView) view.findViewById(R.id.frs_image);
            this.akv = (TextView) view.findViewById(R.id.forum_name);
            this.fnh.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jFP.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jFP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jFP.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jFP.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jFP.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.jeH = frsViewData;
            this.joO = false;
            String name = this.jeH.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.akv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jFP.startLoad(this.jeH.getForum().getImage_url(), 10, false);
            cMF();
            this.jFP.setOnClickListener(this.jhV);
            this.akv.setOnClickListener(this.jhV);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jFP.refresh();
        if (at.isEmpty(str)) {
            this.joO = false;
            cMF();
            return;
        }
        this.joO = true;
        this.jFQ = str2;
        this.joH = z;
        this.fnh.startLoad(str, 10, false);
        this.fnh.setOnClickListener(this.jhV);
    }

    private void cMF() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jeH != null && (forum = this.jeH.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.joO) {
                if (this.jFO != null) {
                    this.jFO.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jFO.changeSkinType(skinType);
                }
                if (this.fnh != null) {
                    this.fnh.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cMF();
        ao.setViewTextColor(this.akv, R.color.CAM_X0101);
        if (this.jFP != null) {
            this.jFP.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jFP.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.jFP.setStrokeColorResId(R.color.CAM_X0201);
            this.jFP.invalidate();
        }
    }
}
