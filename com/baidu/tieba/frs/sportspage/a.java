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
/* loaded from: classes21.dex */
public class a {
    private TextView aiw;
    private TbPageContext ehG;
    private TbImageView ewz;
    private FrsViewData hZt;
    private final View.OnClickListener icH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ewz) {
                if (!at.isEmpty(a.this.ixT) && a.this.hZt != null && a.this.hZt.getForum() != null) {
                    be.bkp().a(a.this.ehG, new String[]{a.this.ixT}, true);
                    TiebaStatic.log(new aq("c13415").dF("fid", a.this.hZt.getForum().getId()).ai("obj_type", a.this.ijs ? 2 : 1));
                }
            } else if ((view == a.this.ixS || view == a.this.aiw) && a.this.hZt != null && a.this.hZt.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.ehG.getPageActivity(), a.this.hZt.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dF("fid", a.this.hZt.getForum().getId()));
            }
        }
    };
    private boolean ijs;
    private boolean ijz;
    private LinearGradientView ixR;
    private BarImageView ixS;
    private String ixT;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.ehG = frsSportsRecommendFragment.getPageContext();
            this.ewz = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.ixR = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.ixS = (BarImageView) view.findViewById(R.id.frs_image);
            this.aiw = (TextView) view.findViewById(R.id.forum_name);
            this.ewz.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.ixS.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.ixS.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.ixS.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.ixS.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.ixS.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hZt = frsViewData;
            this.ijz = false;
            String name = this.hZt.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aiw.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.ixS.startLoad(this.hZt.getForum().getImage_url(), 10, false);
            cvH();
            this.ixS.setOnClickListener(this.icH);
            this.aiw.setOnClickListener(this.icH);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.ixS.refresh();
        if (at.isEmpty(str)) {
            this.ijz = false;
            cvH();
            return;
        }
        this.ijz = true;
        this.ixT = str2;
        this.ijs = z;
        this.ewz.startLoad(str, 10, false);
        this.ewz.setOnClickListener(this.icH);
    }

    private void cvH() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hZt != null && (forum = this.hZt.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.ijz) {
                if (this.ixR != null) {
                    this.ixR.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.ixR.changeSkinType(skinType);
                }
                if (this.ewz != null) {
                    this.ewz.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cvH();
        ap.setViewTextColor(this.aiw, R.color.cp_cont_a);
        if (this.ixS != null) {
            this.ixS.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.ixS.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.ixS.setStrokeColorResId(R.color.cp_bg_line_d);
            this.ixS.invalidate();
        }
    }
}
