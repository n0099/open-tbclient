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
    private TextView iIN;
    private String iJd;
    private RoundRelativeLayout iOm;
    private ImageView iOn;
    private ImageView iOo;
    private TbImageView iOp;
    private ImageView iOq;
    private TextView iOr;
    private ImageView iOs;
    private HotUserRankImageOverlayView iOt;
    private ImageView iOu;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.iOm = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.iOn = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.iOo = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.iOp = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.iOq = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.iIN = (TextView) this.mView.findViewById(R.id.forum_text);
        this.iOr = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.iOt = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.iOs = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.iOu = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.iOt.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.iOt.setStrokeStyle(1);
        this.iOt.setLoadImageType(12);
        this.iOt.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iOm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.iJd);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                aq aqVar = new aq("c13655");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dX("resource_id", b.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.iOm.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.iJd = cVar.module_name;
            if (TextUtils.isEmpty(this.iJd)) {
                this.iJd = "";
            }
            this.iIN.setText(this.iJd + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.iOr.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.iOt.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.iOp.setVisibility(0);
                    this.iOq.setVisibility(8);
                    this.iOp.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.iOq.setVisibility(0);
                    this.iOp.setVisibility(8);
                    SvgManager.bwq().a(this.iOq, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.iOm, R.color.CAM_X0206);
            if (this.iOq.getVisibility() == 0) {
                SvgManager.bwq().a(this.iOq, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.bwq().a(this.iOn, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ao.setImageResource(this.iOo, R.drawable.pic_list_redword);
            SvgManager.bwq().a(this.iOu, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.iIN, R.color.CAM_X0311);
            ao.setViewTextColor(this.iOr, R.color.CAM_X0311);
            SvgManager.bwq().a(this.iOs, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.iOt.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
