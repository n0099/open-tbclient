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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes9.dex */
public class b {
    private TextView hdL;
    private String heb;
    private ImageView hjA;
    private RoundRelativeLayout hjs;
    private ImageView hjt;
    private ImageView hju;
    private TbImageView hjv;
    private ImageView hjw;
    private TextView hjx;
    private ImageView hjy;
    private HotUserRankImageOverlayView hjz;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.hjs = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.hjt = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.hju = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.hjv = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.hjw = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.hdL = (TextView) this.mView.findViewById(R.id.forum_text);
        this.hjx = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.hjz = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.hjy = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.hjA = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.hjz.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.cp_mask_a, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.hjz.setStrokeStyle(1);
        this.hjz.setLoadImageType(12);
        this.hjz.setFirstImageStrokeColor(R.color.cp_other_h);
        this.hjs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.heb);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                ao aoVar = new ao("c13655");
                aoVar.s("uid", TbadkApplication.getCurrentAccountId());
                aoVar.dk("resource_id", b.this.mTabName);
                TiebaStatic.log(aoVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.hjs.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.heb = cVar.module_name;
            if (TextUtils.isEmpty(this.heb)) {
                this.heb = "";
            }
            this.hdL.setText(this.heb + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.hjx.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.hjz.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.hjv.setVisibility(0);
                    this.hjw.setVisibility(8);
                    this.hjv.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.hjw.setVisibility(0);
                    this.hjv.setVisibility(8);
                    SvgManager.aWQ().a(this.hjw, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            an.setBackgroundColor(this.hjs, R.color.cp_bg_line_g);
            if (this.hjw.getVisibility() == 0) {
                SvgManager.aWQ().a(this.hjw, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.aWQ().a(this.hjt, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            an.setImageResource(this.hju, R.drawable.pic_list_redword);
            SvgManager.aWQ().a(this.hjA, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_other_e, SvgManager.SvgResourceStateType.NORMAL);
            an.setViewTextColor(this.hdL, (int) R.color.cp_other_e);
            an.setViewTextColor(this.hjx, (int) R.color.cp_other_e);
            SvgManager.aWQ().a(this.hjy, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.hjz.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
