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
    private LinearGradientView jHa;
    private BarImageView jHb;
    private String jHc;
    private FrsViewData jfU;
    private final View.OnClickListener jjj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fkP) {
                if (!au.isEmpty(a.this.jHc) && a.this.jfU != null && a.this.jfU.getForum() != null) {
                    bf.bsV().a(a.this.eUY, new String[]{a.this.jHc}, true);
                    TiebaStatic.log(new ar("c13415").dR("fid", a.this.jfU.getForum().getId()).ap("obj_type", a.this.jpV ? 2 : 1));
                }
            } else if ((view == a.this.jHb || view == a.this.ajt) && a.this.jfU != null && a.this.jfU.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eUY.getPageActivity(), a.this.jfU.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dR("fid", a.this.jfU.getForum().getId()));
            }
        }
    };
    private boolean jpV;
    private boolean jqc;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eUY = frsSportsRecommendFragment.getPageContext();
            this.fkP = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jHa = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jHb = (BarImageView) view.findViewById(R.id.frs_image);
            this.ajt = (TextView) view.findViewById(R.id.forum_name);
            this.fkP.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jHb.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jHb.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jHb.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jHb.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jHb.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.jfU = frsViewData;
            this.jqc = false;
            String name = this.jfU.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ajt.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jHb.startLoad(this.jfU.getForum().getImage_url(), 10, false);
            cKi();
            this.jHb.setOnClickListener(this.jjj);
            this.ajt.setOnClickListener(this.jjj);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jHb.refresh();
        if (au.isEmpty(str)) {
            this.jqc = false;
            cKi();
            return;
        }
        this.jqc = true;
        this.jHc = str2;
        this.jpV = z;
        this.fkP.startLoad(str, 10, false);
        this.fkP.setOnClickListener(this.jjj);
    }

    private void cKi() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.jfU != null && (forum = this.jfU.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jqc) {
                if (this.jHa != null) {
                    this.jHa.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jHa.changeSkinType(skinType);
                }
                if (this.fkP != null) {
                    this.fkP.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cKi();
        ap.setViewTextColor(this.ajt, R.color.CAM_X0101);
        if (this.jHb != null) {
            this.jHb.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jHb.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jHb.setStrokeColorResId(R.color.CAM_X0201);
            this.jHb.invalidate();
        }
    }
}
