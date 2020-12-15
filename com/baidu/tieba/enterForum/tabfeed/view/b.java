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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.tabfeed.b.c;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.ArrayList;
import tbclient.ShortUserInfo;
/* loaded from: classes22.dex */
public class b {
    private RoundRelativeLayout iCa;
    private ImageView iCb;
    private ImageView iCc;
    private TbImageView iCd;
    private ImageView iCe;
    private TextView iCf;
    private ImageView iCg;
    private HotUserRankImageOverlayView iCh;
    private ImageView iCi;
    private TextView iwA;
    private String iwQ;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.iCa = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.iCb = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.iCc = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.iCd = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.iCe = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.iwA = (TextView) this.mView.findViewById(R.id.forum_text);
        this.iCf = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.iCh = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.iCg = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.iCi = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.iCh.k(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.iCh.setStrokeStyle(1);
        this.iCh.setLoadImageType(12);
        this.iCh.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.iCa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.iwQ);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                ar arVar = new ar("c13655");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dY("resource_id", b.this.mTabName);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.iCa.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.iwQ = cVar.module_name;
            if (TextUtils.isEmpty(this.iwQ)) {
                this.iwQ = "";
            }
            this.iwA.setText(this.iwQ + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.iCf.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.iCh.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.iCd.setVisibility(0);
                    this.iCe.setVisibility(8);
                    this.iCd.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.iCe.setVisibility(0);
                    this.iCd.setVisibility(8);
                    SvgManager.btW().a(this.iCe, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.iCa, R.color.CAM_X0206);
            if (this.iCe.getVisibility() == 0) {
                SvgManager.btW().a(this.iCe, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.btW().a(this.iCb, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ap.setImageResource(this.iCc, R.drawable.pic_list_redword);
            SvgManager.btW().a(this.iCi, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.iwA, R.color.CAM_X0311);
            ap.setViewTextColor(this.iCf, R.color.CAM_X0311);
            SvgManager.btW().a(this.iCg, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.iCh.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
