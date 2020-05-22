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
    private TextView gQR;
    private String gRh;
    private RoundRelativeLayout gWr;
    private ImageView gWs;
    private ImageView gWt;
    private TbImageView gWu;
    private ImageView gWv;
    private TextView gWw;
    private ImageView gWx;
    private HotUserRankImageOverlayView gWy;
    private ImageView gWz;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.gWr = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.gWs = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.gWt = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.gWu = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.gWv = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.gQR = (TextView) this.mView.findViewById(R.id.forum_text);
        this.gWw = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.gWy = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.gWx = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.gWz = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.gWy.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.gWy.setStrokeStyle(1);
        this.gWy.setLoadImageType(12);
        this.gWy.setFirstImageStrokeColor(R.color.cp_other_h);
        this.gWr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.gRh);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                an anVar = new an("c13655");
                anVar.s("uid", TbadkApplication.getCurrentAccountId());
                anVar.dh("resource_id", b.this.mTabName);
                TiebaStatic.log(anVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.gWr.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.gRh = cVar.module_name;
            if (TextUtils.isEmpty(this.gRh)) {
                this.gRh = "";
            }
            this.gQR.setText(this.gRh + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.gWw.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.gWy.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.gWu.setVisibility(0);
                    this.gWv.setVisibility(8);
                    this.gWu.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.gWv.setVisibility(0);
                    this.gWu.setVisibility(8);
                    SvgManager.aUV().a(this.gWv, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            am.setBackgroundColor(this.gWr, R.color.cp_bg_line_g);
            if (this.gWv.getVisibility() == 0) {
                SvgManager.aUV().a(this.gWv, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.aUV().a(this.gWs, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            am.setImageResource(this.gWt, R.drawable.pic_list_redword);
            SvgManager.aUV().a(this.gWz, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            am.setViewTextColor(this.gQR, (int) R.color.cp_other_e);
            am.setViewTextColor(this.gWw, (int) R.color.cp_other_e);
            SvgManager.aUV().a(this.gWx, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.gWy.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
