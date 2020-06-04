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
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dIF;
    private TextView dVS;
    private TbImageView dWQ;
    private LinearGradientView hJc;
    private BarImageView hJd;
    private String hJe;
    private FrsViewData hmR;
    private final View.OnClickListener hpF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dWQ) {
                if (!aq.isEmpty(a.this.hJe) && a.this.hmR != null && a.this.hmR.getForum() != null) {
                    ba.aVa().a(a.this.dIF, new String[]{a.this.hJe}, true);
                    TiebaStatic.log(new an("c13415").dh("fid", a.this.hmR.getForum().getId()).ag("obj_type", a.this.hvj ? 2 : 1));
                }
            } else if ((view == a.this.hJd || view == a.this.dVS) && a.this.hmR != null && a.this.hmR.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.dIF.getPageActivity(), a.this.hmR.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").dh("fid", a.this.hmR.getForum().getId()));
            }
        }
    };
    private boolean hvj;
    private boolean hvq;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dIF = frsSportsRecommendFragment.getPageContext();
            this.dWQ = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.hJc = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.hJd = (BarImageView) view.findViewById(R.id.frs_image);
            this.dVS = (TextView) view.findViewById(R.id.forum_name);
            this.dWQ.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hJd.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hJd.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hJd.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.hJd.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hJd.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hmR = frsViewData;
            this.hvq = false;
            String name = this.hmR.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dVS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.hJd.startLoad(this.hmR.getForum().getImage_url(), 10, false);
            caV();
            this.hJd.setOnClickListener(this.hpF);
            this.dVS.setOnClickListener(this.hpF);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.hJd.refresh();
        if (aq.isEmpty(str)) {
            this.hvq = false;
            caV();
            return;
        }
        this.hvq = true;
        this.hJe = str2;
        this.hvj = z;
        this.dWQ.startLoad(str, 10, false);
        this.dWQ.setOnClickListener(this.hpF);
    }

    private void caV() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hmR != null && (forum = this.hmR.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hvq) {
                if (this.hJc != null) {
                    this.hJc.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.hJc.changeSkinType(skinType);
                }
                if (this.dWQ != null) {
                    this.dWQ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        caV();
        am.setViewTextColor(this.dVS, (int) R.color.cp_cont_a);
        if (this.hJd != null) {
            this.hJd.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.hJd.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hJd.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hJd.invalidate();
        }
    }
}
