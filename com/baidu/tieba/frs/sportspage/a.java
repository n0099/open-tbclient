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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes9.dex */
public class a {
    private TextView agZ;
    private TbPageContext dPv;
    private TbImageView eem;
    private final View.OnClickListener hCn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eem) {
                if (!ar.isEmpty(a.this.hWq) && a.this.hzi != null && a.this.hzi.getForum() != null) {
                    bc.aWU().a(a.this.dPv, new String[]{a.this.hWq}, true);
                    TiebaStatic.log(new ao("c13415").dk("fid", a.this.hzi.getForum().getId()).ag("obj_type", a.this.hIb ? 2 : 1));
                }
            } else if ((view == a.this.hWp || view == a.this.agZ) && a.this.hzi != null && a.this.hzi.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.dPv.getPageActivity(), a.this.hzi.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ao("c13416").dk("fid", a.this.hzi.getForum().getId()));
            }
        }
    };
    private boolean hIb;
    private boolean hIi;
    private LinearGradientView hWo;
    private BarImageView hWp;
    private String hWq;
    private FrsViewData hzi;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dPv = frsSportsRecommendFragment.getPageContext();
            this.eem = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.hWo = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.hWp = (BarImageView) view.findViewById(R.id.frs_image);
            this.agZ = (TextView) view.findViewById(R.id.forum_name);
            this.eem.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hWp.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hWp.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hWp.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.hWp.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hWp.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hzi = frsViewData;
            this.hIi = false;
            String name = this.hzi.getForum().getName();
            if (ar.getChineseAndEnglishLength(name) > 20) {
                name = ar.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.agZ.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.hWp.startLoad(this.hzi.getForum().getImage_url(), 10, false);
            cen();
            this.hWp.setOnClickListener(this.hCn);
            this.agZ.setOnClickListener(this.hCn);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.hWp.refresh();
        if (ar.isEmpty(str)) {
            this.hIi = false;
            cen();
            return;
        }
        this.hIi = true;
        this.hWq = str2;
        this.hIb = z;
        this.eem.startLoad(str, 10, false);
        this.eem.setOnClickListener(this.hCn);
    }

    private void cen() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hzi != null && (forum = this.hzi.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hIi) {
                if (this.hWo != null) {
                    this.hWo.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.hWo.changeSkinType(skinType);
                }
                if (this.eem != null) {
                    this.eem.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cen();
        an.setViewTextColor(this.agZ, (int) R.color.cp_cont_a);
        if (this.hWp != null) {
            this.hWp.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.hWp.setBorderColor(an.getColor(R.color.black_alpha15));
            this.hWp.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hWp.invalidate();
        }
    }
}
