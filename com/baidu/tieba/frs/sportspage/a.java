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
    private FrsViewData iSv;
    private final View.OnClickListener iVJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.fdy) {
                if (!au.isEmpty(a.this.jtv) && a.this.iSv != null && a.this.iSv.getForum() != null) {
                    bf.bua().a(a.this.eNx, new String[]{a.this.jtv}, true);
                    TiebaStatic.log(new ar("c13415").dY("fid", a.this.iSv.getForum().getId()).al("obj_type", a.this.jcp ? 2 : 1));
                }
            } else if ((view == a.this.jtu || view == a.this.ajT) && a.this.iSv != null && a.this.iSv.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.eNx.getPageActivity(), a.this.iSv.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new ar("c13416").dY("fid", a.this.iSv.getForum().getId()));
            }
        }
    };
    private boolean jcp;
    private boolean jcw;
    private LinearGradientView jtt;
    private BarImageView jtu;
    private String jtv;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.eNx = frsSportsRecommendFragment.getPageContext();
            this.fdy = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.jtt = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.jtu = (BarImageView) view.findViewById(R.id.frs_image);
            this.ajT = (TextView) view.findViewById(R.id.forum_name);
            this.fdy.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jtu.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.jtu.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.jtu.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.jtu.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.jtu.setShowOval(true);
        }
    }

    public void h(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.iSv = frsViewData;
            this.jcw = false;
            String name = this.iSv.getForum().getName();
            if (au.getChineseAndEnglishLength(name) > 20) {
                name = au.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.ajT.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.jtu.startLoad(this.iSv.getForum().getImage_url(), 10, false);
            cJF();
            this.jtu.setOnClickListener(this.iVJ);
            this.ajT.setOnClickListener(this.iVJ);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.jtu.refresh();
        if (au.isEmpty(str)) {
            this.jcw = false;
            cJF();
            return;
        }
        this.jcw = true;
        this.jtv = str2;
        this.jcp = z;
        this.fdy.startLoad(str, 10, false);
        this.fdy.setOnClickListener(this.iVJ);
    }

    private void cJF() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.iSv != null && (forum = this.iSv.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.jcw) {
                if (this.jtt != null) {
                    this.jtt.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.jtt.changeSkinType(skinType);
                }
                if (this.fdy != null) {
                    this.fdy.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        cJF();
        ap.setViewTextColor(this.ajT, R.color.CAM_X0101);
        if (this.jtu != null) {
            this.jtu.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.jtu.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jtu.setStrokeColorResId(R.color.CAM_X0201);
            this.jtu.invalidate();
        }
    }
}
