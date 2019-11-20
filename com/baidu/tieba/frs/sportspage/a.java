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
    private TbPageContext ceu;
    private TextView cpv;
    private TbImageView cqs;
    private boolean fCC;
    private boolean fCJ;
    private LinearGradientView fPk;
    private BarImageView fPl;
    private String fPm;
    private FrsViewData fua;
    private final View.OnClickListener fwH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.cqs) {
                if (!aq.isEmpty(a.this.fPm) && a.this.fua != null && a.this.fua.getForum() != null) {
                    ba.amO().a(a.this.ceu, new String[]{a.this.fPm}, true);
                    TiebaStatic.log(new an("c13415").bS("fid", a.this.fua.getForum().getId()).O("obj_type", a.this.fCC ? 2 : 1));
                }
            } else if ((view == a.this.fPl || view == a.this.cpv) && a.this.fua != null && a.this.fua.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.ceu.getPageActivity(), a.this.fua.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").bS("fid", a.this.fua.getForum().getId()));
            }
        }
    };

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.ceu = frsSportsRecommendFragment.getPageContext();
            this.cqs = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.fPk = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.fPl = (BarImageView) view.findViewById(R.id.frs_image);
            this.cpv = (TextView) view.findViewById(R.id.forum_name);
            this.cqs.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fPl.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.fPl.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.fPl.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.fPl.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.fPl.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.fua = frsViewData;
            this.fCJ = false;
            String name = this.fua.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.cpv.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.fPl.startLoad(this.fua.getForum().getImage_url(), 10, false);
            bpE();
            this.fPl.setOnClickListener(this.fwH);
            this.cpv.setOnClickListener(this.fwH);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.fPl.refresh();
        if (aq.isEmpty(str)) {
            this.fCJ = false;
            bpE();
            return;
        }
        this.fCJ = true;
        this.fPm = str2;
        this.fCC = z;
        this.cqs.startLoad(str, 10, false);
        this.cqs.setOnClickListener(this.fwH);
    }

    private void bpE() {
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.fua != null && this.fua.getForum() != null && (themeColorInfo = this.fua.getForum().getThemeColorInfo()) != null && themeColorInfo.night != null && themeColorInfo.day != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 1 || skinType == 4) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.fCJ) {
                ThemeElement themeElement2 = themeColorInfo.night;
                ThemeElement themeElement3 = themeColorInfo.day;
                if (this.fPk != null) {
                    this.fPk.setGradientColor(themeElement3.light_color, themeElement3.dark_color, themeElement2.light_color, themeElement2.dark_color);
                    this.fPk.changeSkinType(skinType);
                }
                if (this.cqs != null) {
                    this.cqs.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        bpE();
        am.setViewTextColor(this.cpv, (int) R.color.cp_cont_a);
        if (this.fPl != null) {
            this.fPl.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.fPl.setBorderColor(am.getColor(R.color.black_alpha15));
            this.fPl.setStrokeColorResId(R.color.cp_bg_line_d);
            this.fPl.invalidate();
        }
    }
}
