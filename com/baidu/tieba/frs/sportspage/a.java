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
/* loaded from: classes9.dex */
public class a {
    private TbPageContext dIF;
    private TextView dVS;
    private TbImageView dWQ;
    private LinearGradientView hIp;
    private BarImageView hIq;
    private String hIr;
    private FrsViewData hmG;
    private final View.OnClickListener hpu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.sportspage.a.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == a.this.dWQ) {
                if (!aq.isEmpty(a.this.hIr) && a.this.hmG != null && a.this.hmG.getForum() != null) {
                    ba.aUZ().a(a.this.dIF, new String[]{a.this.hIr}, true);
                    TiebaStatic.log(new an("c13415").dh("fid", a.this.hmG.getForum().getId()).ag("obj_type", a.this.huY ? 2 : 1));
                }
            } else if ((view == a.this.hIq || view == a.this.dVS) && a.this.hmG != null && a.this.hmG.getForum() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumDetailActivityConfig(a.this.dIF.getPageActivity(), a.this.hmG.getForum().getId(), ForumDetailActivityConfig.FromType.FRS)));
                TiebaStatic.log(new an("c13416").dh("fid", a.this.hmG.getForum().getId()));
            }
        }
    };
    private boolean huY;
    private boolean hvf;

    public a(FrsSportsRecommendFragment frsSportsRecommendFragment, View view) {
        if (frsSportsRecommendFragment != null && view != null) {
            this.dIF = frsSportsRecommendFragment.getPageContext();
            this.dWQ = (TbImageView) view.findViewById(R.id.head_top_bg_mask);
            this.hIp = (LinearGradientView) view.findViewById(R.id.head_top_gradient_bg);
            this.hIq = (BarImageView) view.findViewById(R.id.frs_image);
            this.dVS = (TextView) view.findViewById(R.id.forum_name);
            this.dWQ.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hIq.setPageId(frsSportsRecommendFragment.getUniqueId());
            this.hIq.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
            this.hIq.setContentDescription(TbadkCoreApplication.getInst().getResources().getString(R.string.bar_header));
            this.hIq.setStrokeWith(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds4));
            this.hIq.setShowOval(true);
        }
    }

    public void g(FrsViewData frsViewData) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            this.hmG = frsViewData;
            this.hvf = false;
            String name = this.hmG.getForum().getName();
            if (aq.getChineseAndEnglishLength(name) > 20) {
                name = aq.cutForumNameWithSuffix(name, 20, StringHelper.STRING_MORE);
            }
            this.dVS.setText(String.format(TbadkCoreApplication.getInst().getString(R.string.frs_sports_recommend_bar_name), name));
            this.hIq.startLoad(this.hmG.getForum().getImage_url(), 10, false);
            caN();
            this.hIq.setOnClickListener(this.hpu);
            this.dVS.setOnClickListener(this.hpu);
        }
    }

    public void setData(String str, String str2, boolean z) {
        this.hIq.refresh();
        if (aq.isEmpty(str)) {
            this.hvf = false;
            caN();
            return;
        }
        this.hvf = true;
        this.hIr = str2;
        this.huY = z;
        this.dWQ.startLoad(str, 10, false);
        this.dWQ.setOnClickListener(this.hpu);
    }

    private void caN() {
        ForumData forum;
        ThemeColorInfo themeColorInfo;
        ThemeElement themeElement;
        if (this.hmG != null && (forum = this.hmG.getForum()) != null && (themeColorInfo = forum.getThemeColorInfo()) != null && themeColorInfo.day != null && themeColorInfo.night != null && themeColorInfo.dark != null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (skinType == 4) {
                themeElement = themeColorInfo.dark;
            } else if (skinType == 1) {
                themeElement = themeColorInfo.night;
            } else {
                themeElement = themeColorInfo.day;
            }
            if (!this.hvf) {
                if (this.hIp != null) {
                    this.hIp.setGradientColor(themeColorInfo.day.light_color, themeColorInfo.day.dark_color, themeColorInfo.night.light_color, themeColorInfo.night.dark_color, themeColorInfo.dark.light_color, themeColorInfo.dark.dark_color);
                    this.hIp.changeSkinType(skinType);
                }
                if (this.dWQ != null) {
                    this.dWQ.startLoad(themeElement.pattern_image, 10, false);
                }
            }
        }
    }

    public void onChangeSkinType() {
        caN();
        am.setViewTextColor(this.dVS, (int) R.color.cp_cont_a);
        if (this.hIq != null) {
            this.hIq.setBorderWidth(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds1));
            this.hIq.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hIq.setStrokeColorResId(R.color.cp_bg_line_d);
            this.hIq.invalidate();
        }
    }
}
