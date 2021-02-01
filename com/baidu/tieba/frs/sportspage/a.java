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
    private TextView ajt;
    private TbPageContext eUY;
    private TbImageView fkP;
    private LinearGradientView jGM;
    private BarImageView jGN;
    private String jGO;
    private FrsViewData jfG;
    private final View.OnClickListener jiV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fkP) {
                if (!au.isEmpty(a.this.jGO) && a.this.jfG != null && a.this.jfG.getForum() != null) {
                    bf.bsV().a(a.this.eUY, new String[]{a.this.jGO}, true);
                    TiebaStatic.log(new ar("c13415").dR("fid", a.this.jfG.getForum().getId()).ap("obj_type", a.this.jpH ? 2 : 1));
                }
            } else if ((view == a.this.jGN || view == a.this.ajt) && a.this.jfG != null && a.this.jfG.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eUY.getPageActivity(), a.this.jfG.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dR("fid", a.this.jfG.getForum().getId()));
            }
        }
    };
    private boolean jpH;
    private boolean jpO;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eUY = frsSportsRecommendFragment.getPageContext();
            this.fkP = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jGM = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jGN = (BarImageView) view.findViewById(R.id.frs_image);
            this.ajt = (TextView) view.findViewById(R.id.forum_name);
            this.fkP.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jGN.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jGN.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jGN.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jGN.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jGN.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.jfG = frsViewData;
            this.jpO = false;
            String name = this.jfG.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ajt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jGN.startLoad(this.jfG.getForum().getImage_url(), 10, false);
            cKb();
            this.jGN.setOnClickListener(this.jiV);
            this.ajt.setOnClickListener(this.jiV);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jGN.refresh();
        if (au.isEmpty(str)) {
            this.jpO = false;
            cKb();
            return;
        }
        this.jpO = true;
        this.jGO = str2;
        this.jpH = z;
        this.fkP.startLoad(str, 10, false);
        this.fkP.setOnClickListener(this.jiV);
    }

    private void cKb() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jfG != null && (forum = this.jfG.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jpO) {
                if (this.jGM != null) {
                    this.jGM.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jGM.changeSkinType(skinType);
                }
                if (this.fkP != null) {
                    this.fkP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cKb();
        ap.setViewTextColor(this.ajt, R.color.CAM_X0101);
        if (this.jGN != null) {
            this.jGN.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jGN.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jGN.setStrokeColorResId(R.color.CAM_X0201);
            this.jGN.invalidate();
        }
    }
}
