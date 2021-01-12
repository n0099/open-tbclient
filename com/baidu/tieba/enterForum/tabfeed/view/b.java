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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes2.dex */
public class b {
    private TextView iEg;
    private String iEw;
    private RoundRelativeLayout iJF;
    private ImageView iJG;
    private ImageView iJH;
    private TbImageView iJI;
    private ImageView iJJ;
    private TextView iJK;
    private ImageView iJL;
    private HotUserRankImageOverlayView iJM;
    private ImageView iJN;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.iJF = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.iJG = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.iJH = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.iJI = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.iJJ = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.iEg = (TextView) this.mView.findViewById(R.id.forum_text);
        this.iJK = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.iJM = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.iJL = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.iJN = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.iJM.l(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.iJM.setStrokeStyle(1);
        this.iJM.setLoadImageType(12);
        this.iJM.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iJF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.iEw);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                aq aqVar = new aq("c13655");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dW("resource_id", b.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.iJF.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.iEw = cVar.module_name;
            if (TextUtils.isEmpty(this.iEw)) {
                this.iEw = "";
            }
            this.iEg.setText(this.iEw + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.iJK.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.iJM.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.iJI.setVisibility(0);
                    this.iJJ.setVisibility(8);
                    this.iJI.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.iJJ.setVisibility(0);
                    this.iJI.setVisibility(8);
                    SvgManager.bsx().a(this.iJJ, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.iJF, R.color.CAM_X0206);
            if (this.iJJ.getVisibility() == 0) {
                SvgManager.bsx().a(this.iJJ, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.bsx().a(this.iJG, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ao.setImageResource(this.iJH, R.drawable.pic_list_redword);
            SvgManager.bsx().a(this.iJN, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.iEg, R.color.CAM_X0311);
            ao.setViewTextColor(this.iJK, R.color.CAM_X0311);
            SvgManager.bsx().a(this.iJL, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.iJM.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
