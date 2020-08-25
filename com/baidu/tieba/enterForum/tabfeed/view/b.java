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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes16.dex */
public class b {
    private RoundRelativeLayout hBR;
    private ImageView hBS;
    private ImageView hBT;
    private TbImageView hBU;
    private ImageView hBV;
    private TextView hBW;
    private ImageView hBX;
    private HotUserRankImageOverlayView hBY;
    private ImageView hBZ;
    private String hwC;
    private TextView hwm;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.hBR = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.hBS = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.hBT = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.hBU = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.hBV = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.hwm = (TextView) this.mView.findViewById(R.id.forum_text);
        this.hBW = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.hBY = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.hBX = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.hBZ = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.hBY.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.hBY.setStrokeStyle(1);
        this.hBY.setLoadImageType(12);
        this.hBY.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hBR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.hwC);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                aq aqVar = new aq("c13655");
                aqVar.u("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dD("resource_id", b.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.hBR.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hwC = cVar.module_name;
            if (TextUtils.isEmpty(this.hwC)) {
                this.hwC = "";
            }
            this.hwm.setText(this.hwC + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.hBW.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.hBY.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.hBU.setVisibility(0);
                    this.hBV.setVisibility(8);
                    this.hBU.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.hBV.setVisibility(0);
                    this.hBU.setVisibility(8);
                    SvgManager.bjq().a(this.hBV, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.hBR, R.color.cp_bg_line_g);
            if (this.hBV.getVisibility() == 0) {
                SvgManager.bjq().a(this.hBV, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.bjq().a(this.hBS, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ap.setImageResource(this.hBT, R.drawable.pic_list_redword);
            SvgManager.bjq().a(this.hBZ, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.hwm, R.color.cp_other_e);
            ap.setViewTextColor(this.hBW, R.color.cp_other_e);
            SvgManager.bjq().a(this.hBX, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.hBY.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
