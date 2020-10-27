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
/* loaded from: classes22.dex */
public class b {
    private TextView ieT;
    private String ifj;
    private ImageView ikA;
    private HotUserRankImageOverlayView ikB;
    private ImageView ikC;
    private RoundRelativeLayout iku;
    private ImageView ikv;
    private ImageView ikw;
    private TbImageView ikx;
    private ImageView iky;
    private TextView ikz;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.iku = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.ikv = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.ikw = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.ikx = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.iky = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.ieT = (TextView) this.mView.findViewById(R.id.forum_text);
        this.ikz = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.ikB = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.ikA = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.ikC = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.ikB.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.ikB.setStrokeStyle(1);
        this.ikB.setLoadImageType(12);
        this.ikB.setFirstImageStrokeColor(R.color.cp_other_h);
        this.iku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.ifj);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                aq aqVar = new aq("c13655");
                aqVar.w("uid", TbadkApplication.getCurrentAccountId());
                aqVar.dR("resource_id", b.this.mTabName);
                TiebaStatic.log(aqVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.iku.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.ifj = cVar.module_name;
            if (TextUtils.isEmpty(this.ifj)) {
                this.ifj = "";
            }
            this.ieT.setText(this.ifj + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.ikz.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.ikB.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.ikx.setVisibility(0);
                    this.iky.setVisibility(8);
                    this.ikx.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.iky.setVisibility(0);
                    this.ikx.setVisibility(8);
                    SvgManager.boN().a(this.iky, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.iku, R.color.cp_bg_line_g);
            if (this.iky.getVisibility() == 0) {
                SvgManager.boN().a(this.iky, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.boN().a(this.ikv, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ap.setImageResource(this.ikw, R.drawable.pic_list_redword);
            SvgManager.boN().a(this.ikC, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.ieT, R.color.cp_other_e);
            ap.setViewTextColor(this.ikz, R.color.cp_other_e);
            SvgManager.boN().a(this.ikA, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.ikB.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
