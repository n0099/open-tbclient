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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes16.dex */
public class b {
    private String hjL;
    private TextView hjv;
    private RoundRelativeLayout hpa;
    private ImageView hpb;
    private ImageView hpc;
    private TbImageView hpd;
    private ImageView hpe;
    private TextView hpf;
    private ImageView hpg;
    private HotUserRankImageOverlayView hph;
    private ImageView hpi;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.hpa = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.hpb = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.hpc = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.hpd = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.hpe = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.hjv = (TextView) this.mView.findViewById(R.id.forum_text);
        this.hpf = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.hph = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.hpg = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.hpi = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.hph.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.hph.setStrokeStyle(1);
        this.hph.setLoadImageType(12);
        this.hph.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hpa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.hjL);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                ap apVar = new ap("c13655");
                apVar.t("uid", TbadkApplication.getCurrentAccountId());
                apVar.dn("resource_id", b.this.mTabName);
                TiebaStatic.log(apVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.hpa.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.hjL = cVar.module_name;
            if (TextUtils.isEmpty(this.hjL)) {
                this.hjL = "";
            }
            this.hjv.setText(this.hjL + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.hpf.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.hph.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.hpd.setVisibility(0);
                    this.hpe.setVisibility(8);
                    this.hpd.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.hpe.setVisibility(0);
                    this.hpd.setVisibility(8);
                    SvgManager.baR().a(this.hpe, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ao.setBackgroundColor(this.hpa, R.color.cp_bg_line_g);
            if (this.hpe.getVisibility() == 0) {
                SvgManager.baR().a(this.hpe, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.baR().a(this.hpb, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ao.setImageResource(this.hpc, R.drawable.pic_list_redword);
            SvgManager.baR().a(this.hpi, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            ao.setViewTextColor(this.hjv, R.color.cp_other_e);
            ao.setViewTextColor(this.hpf, R.color.cp_other_e);
            SvgManager.baR().a(this.hpg, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.hph.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
