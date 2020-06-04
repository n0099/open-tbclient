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
    private TextView gRc;
    private String gRs;
    private RoundRelativeLayout gWC;
    private ImageView gWD;
    private ImageView gWE;
    private TbImageView gWF;
    private ImageView gWG;
    private TextView gWH;
    private ImageView gWI;
    private HotUserRankImageOverlayView gWJ;
    private ImageView gWK;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.gWC = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.gWD = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.gWE = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.gWF = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.gWG = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.gRc = (TextView) this.mView.findViewById(R.id.forum_text);
        this.gWH = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.gWJ = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.gWI = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.gWK = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.gWJ.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.gWJ.setStrokeStyle(1);
        this.gWJ.setLoadImageType(12);
        this.gWJ.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gWC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.gRs);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                an anVar = new an("c13655");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.dh("resource_id", b.this.mTabName);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.gWC.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gRs = cVar.module_name;
            if (TextUtils.isEmpty(this.gRs)) {
                this.gRs = "";
            }
            this.gRc.setText(this.gRs + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.gWH.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.gWJ.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.gWF.setVisibility(0);
                    this.gWG.setVisibility(8);
                    this.gWF.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.gWG.setVisibility(0);
                    this.gWF.setVisibility(8);
                    SvgManager.aUW().a(this.gWG, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.gWC, R.color.cp_bg_line_g);
            if (this.gWG.getVisibility() == 0) {
                SvgManager.aUW().a(this.gWG, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.aUW().a(this.gWD, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gWE, R.drawable.pic_list_redword);
            SvgManager.aUW().a(this.gWK, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gRc, (int) R.color.cp_other_e);
            am.setViewTextColor(this.gWH, (int) R.color.cp_other_e);
            SvgManager.aUW().a(this.gWI, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.gWJ.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
