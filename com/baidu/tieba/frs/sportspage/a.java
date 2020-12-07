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
/* loaded from: classes22.dex */
public class a {
    private TextView ajT;
    private TbPageContext eNx;
    private TbImageView fdy;
    private FrsViewData iSt;
    private final View.OnClickListener iVH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fdy) {
                if (!au.isEmpty(a.this.jtt) && a.this.iSt != null && a.this.iSt.getForum() != null) {
                    bf.bua().a(a.this.eNx, new String[]{a.this.jtt}, true);
                    TiebaStatic.log(new ar("c13415").dY("fid", a.this.iSt.getForum().getId()).al("obj_type", a.this.jcn ? 2 : 1));
                }
            } else if ((view == a.this.jts || view == a.this.ajT) && a.this.iSt != null && a.this.iSt.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eNx.getPageActivity(), a.this.iSt.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dY("fid", a.this.iSt.getForum().getId()));
            }
        }
    };
    private boolean jcn;
    private boolean jcu;
    private LinearGradientView jtr;
    private BarImageView jts;
    private String jtt;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eNx = frsSportsRecommendFragment.getPageContext();
            this.fdy = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jtr = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jts = (BarImageView) view.findViewById(R.id.frs_image);
            this.ajT = (TextView) view.findViewById(R.id.forum_name);
            this.fdy.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jts.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jts.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jts.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jts.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jts.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iSt = frsViewData;
            this.jcu = false;
            String name = this.iSt.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ajT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jts.startLoad(this.iSt.getForum().getImage_url(), 10, false);
            cJE();
            this.jts.setOnClickListener(this.iVH);
            this.ajT.setOnClickListener(this.iVH);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jts.refresh();
        if (au.isEmpty(str)) {
            this.jcu = false;
            cJE();
            return;
        }
        this.jcu = true;
        this.jtt = str2;
        this.jcn = z;
        this.fdy.startLoad(str, 10, false);
        this.fdy.setOnClickListener(this.iVH);
    }

    private void cJE() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iSt != null && (forum = this.iSt.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jcu) {
                if (this.jtr != null) {
                    this.jtr.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jtr.changeSkinType(skinType);
                }
                if (this.fdy != null) {
                    this.fdy.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cJE();
        ap.setViewTextColor(this.ajT, R.color.CAM_X0101);
        if (this.jts != null) {
            this.jts.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jts.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jts.setStrokeColorResId(R.color.CAM_X0201);
            this.jts.invalidate();
        }
    }
}
