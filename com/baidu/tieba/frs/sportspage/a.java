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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
import tbclient.ThemeColorInfo;
import tbclient.ThemeElement;
/* loaded from: classes2.dex */
public class a {
    private TextView akL;
    private TbPageContext eWx;
    private TbImageView fmo;
    private LinearGradientView jIJ;
    private BarImageView jIK;
    private String jIL;
    private FrsViewData jhD;
    private final View.OnClickListener jkS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fmo) {
                if (!au.isEmpty(a.this.jIL) && a.this.jhD != null && a.this.jhD.getForum() != null) {
                    bf.bsY().a(a.this.eWx, new String[]{a.this.jIL}, true);
                    TiebaStatic.log(new ar("c13415").dR("fid", a.this.jhD.getForum().getId()).aq("obj_type", a.this.jrE ? 2 : 1));
                }
            } else if ((view == a.this.jIK || view == a.this.akL) && a.this.jhD != null && a.this.jhD.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eWx.getPageActivity(), a.this.jhD.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dR("fid", a.this.jhD.getForum().getId()));
            }
        }
    };
    private boolean jrE;
    private boolean jrL;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eWx = frsSportsRecommendFragment.getPageContext();
            this.fmo = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jIJ = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jIK = (BarImageView) view.findViewById(R.id.frs_image);
            this.akL = (TextView) view.findViewById(R.id.forum_name);
            this.fmo.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jIK.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jIK.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jIK.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jIK.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jIK.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.jhD = frsViewData;
            this.jrL = false;
            String name = this.jhD.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.akL.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jIK.startLoad(this.jhD.getForum().getImage_url(), 10, false);
            cKo();
            this.jIK.setOnClickListener(this.jkS);
            this.akL.setOnClickListener(this.jkS);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jIK.refresh();
        if (au.isEmpty(str)) {
            this.jrL = false;
            cKo();
            return;
        }
        this.jrL = true;
        this.jIL = str2;
        this.jrE = z;
        this.fmo.startLoad(str, 10, false);
        this.fmo.setOnClickListener(this.jkS);
    }

    private void cKo() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jhD != null && (forum = this.jhD.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jrL) {
                if (this.jIJ != null) {
                    this.jIJ.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jIJ.changeSkinType(skinType);
                }
                if (this.fmo != null) {
                    this.fmo.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cKo();
        ap.setViewTextColor(this.akL, R.color.CAM_X0101);
        if (this.jIK != null) {
            this.jIK.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jIK.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jIK.setStrokeColorResId(R.color.CAM_X0201);
            this.jIK.invalidate();
        }
    }
}
