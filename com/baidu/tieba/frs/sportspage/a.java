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
/* loaded from: classes22.dex */
public class a {
    private TextView aiO;
    private TbImageView eIJ;
    private TbPageContext etO;
    private LinearGradientView iMK;
    private BarImageView iML;
    private String iMM;
    private FrsViewData iou;
    private final View.OnClickListener irI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.eIJ) {
                if (!at.isEmpty(a.this.iMM) && a.this.iou != null && a.this.iou.getForum() != null) {
                    be.bmY().a(a.this.etO, new String[]{a.this.iMM}, true);
                    TiebaStatic.log(new aq("c13415").dK("fid", a.this.iou.getForum().getId()).aj("obj_type", a.this.iyp ? 2 : 1));
                }
            } else if ((view == a.this.iML || view == a.this.aiO) && a.this.iou != null && a.this.iou.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.etO.getPageActivity(), a.this.iou.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new aq("c13416").dK("fid", a.this.iou.getForum().getId()));
            }
        }
    };
    private boolean iyp;
    private boolean iyw;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.etO = frsSportsRecommendFragment.getPageContext();
            this.eIJ = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.iMK = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.iML = (BarImageView) view.findViewById(R.id.frs_image);
            this.aiO = (TextView) view.findViewById(R.id.forum_name);
            this.eIJ.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iML.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.iML.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.iML.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.iML.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.iML.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iou = frsViewData;
            this.iyw = false;
            String name = this.iou.getForum().getName();
            if (at.getChineseAndEnglishLength(name) > 20) {
                name = at.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.aiO.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.iML.startLoad(this.iou.getForum().getImage_url(), 10, false);
            cze();
            this.iML.setOnClickListener(this.irI);
            this.aiO.setOnClickListener(this.irI);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.iML.refresh();
        if (at.isEmpty(str)) {
            this.iyw = false;
            cze();
            return;
        }
        this.iyw = true;
        this.iMM = str2;
        this.iyp = z;
        this.eIJ.startLoad(str, 10, false);
        this.eIJ.setOnClickListener(this.irI);
    }

    private void cze() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iou != null && (forum = this.iou.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.iyw) {
                if (this.iMK != null) {
                    this.iMK.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.iMK.changeSkinType(skinType);
                }
                if (this.eIJ != null) {
                    this.eIJ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cze();
        ap.setViewTextColor(this.aiO, R.color.cp_cont_a);
        if (this.iML != null) {
            this.iML.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.iML.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iML.setStrokeColorResId(R.color.cp_bg_line_d);
            this.iML.invalidate();
        }
    }
}
