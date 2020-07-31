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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes16.dex */
public class a {
    private TextView agQ;
    private TbPageContext dVN;
    private TbImageView ekw;
    private FrsViewData hEX;
    private final View.OnClickListener hIl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.ekw) {
                if (!as.isEmpty(a.this.ico) && a.this.hEX != null && a.this.hEX.getForum() != null) {
                    bd.baV().a(a.this.dVN, new String[]{a.this.ico}, true);
                    TiebaStatic.log(new ap("c13415").dn("fid", a.this.hEX.getForum().getId()).ah("obj_type", a.this.hOb ? 2 : 1));
                }
            } else if ((view == a.this.icn || view == a.this.agQ) && a.this.hEX != null && a.this.hEX.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.dVN.getPageActivity(), a.this.hEX.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ap("c13416").dn("fid", a.this.hEX.getForum().getId()));
            }
        }
    };
    private boolean hOb;
    private boolean hOi;
    private LinearGradientView icm;
    private BarImageView icn;
    private String ico;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dVN = frsSportsRecommendFragment.getPageContext();
            this.ekw = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.icm = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.icn = (BarImageView) view.findViewById(R.id.frs_image);
            this.agQ = (TextView) view.findViewById(R.id.forum_name);
            this.ekw.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.icn.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.icn.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.icn.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.icn.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.icn.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hEX = frsViewData;
            this.hOi = false;
            String name = this.hEX.getForum().getName();
            if (as.getChineseAndEnglishLength(name) > 20) {
                name = as.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.agQ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.icn.startLoad(this.hEX.getForum().getImage_url(), 10, false);
            chN();
            this.icn.setOnClickListener(this.hIl);
            this.agQ.setOnClickListener(this.hIl);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.icn.refresh();
        if (as.isEmpty(str)) {
            this.hOi = false;
            chN();
            return;
        }
        this.hOi = true;
        this.ico = str2;
        this.hOb = z;
        this.ekw.startLoad(str, 10, false);
        this.ekw.setOnClickListener(this.hIl);
    }

    private void chN() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hEX != null && (forum = this.hEX.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hOi) {
                if (this.icm != null) {
                    this.icm.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.icm.changeSkinType(skinType);
                }
                if (this.ekw != null) {
                    this.ekw.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        chN();
        ao.setViewTextColor(this.agQ, R.color.cp_cont_a);
        if (this.icn != null) {
            this.icn.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.icn.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.icn.setStrokeColorResId(R.color.cp_bg_line_d);
            this.icn.invalidate();
        }
    }
}
