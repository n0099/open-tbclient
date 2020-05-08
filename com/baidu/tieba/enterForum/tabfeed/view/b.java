package com.baidu.tieba.enterForum.tabfeed.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotUserRankActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class b {
    private TextView gCi;
    private String gCy;
    private RoundRelativeLayout gHG;
    private ImageView gHH;
    private ImageView gHI;
    private TbImageView gHJ;
    private ImageView gHK;
    private TextView gHL;
    private ImageView gHM;
    private HotUserRankImageOverlayView gHN;
    private ImageView gHO;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.gHG = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.gHH = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.gHI = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.gHJ = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.gHK = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.gCi = (TextView) this.mView.findViewById(R.id.forum_text);
        this.gHL = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.gHN = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.gHM = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.gHO = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.gHN.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.gHN.setStrokeStyle(1);
        this.gHN.setLoadImageType(12);
        this.gHN.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gHG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.gCy);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                an anVar = new an("c13655");
                anVar.t("uid", TbadkApplication.getCurrentAccountId());
                anVar.cI("resource_id", b.this.mTabName);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.gHG.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gCy = cVar.module_name;
            if (TextUtils.isEmpty(this.gCy)) {
                this.gCy = "";
            }
            this.gCi.setText(this.gCy + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.gHL.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.gHN.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.gHJ.setVisibility(0);
                    this.gHK.setVisibility(8);
                    this.gHJ.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.gHK.setVisibility(0);
                    this.gHJ.setVisibility(8);
                    SvgManager.aOR().a(this.gHK, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.gHG, R.color.cp_bg_line_g);
            if (this.gHK.getVisibility() == 0) {
                SvgManager.aOR().a(this.gHK, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.aOR().a(this.gHH, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gHI, R.drawable.pic_list_redword);
            SvgManager.aOR().a(this.gHO, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gCi, (int) R.color.cp_other_e);
            am.setViewTextColor(this.gHL, (int) R.color.cp_other_e);
            SvgManager.aOR().a(this.gHM, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.gHN.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
