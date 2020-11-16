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
/* loaded from: classes21.dex */
public class b {
    private TextView ilE;
    private String ilU;
    private RoundRelativeLayout irg;
    private ImageView irh;
    private ImageView iri;
    private TbImageView irj;
    private ImageView irk;
    private TextView irl;
    private ImageView irm;
    private HotUserRankImageOverlayView irn;
    private ImageView iro;
    private TbPageContext<?> mPageContext;
    private int mSkinType = 3;
    private String mTabName;
    private View mView;
    private int tbds90;

    public b(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(R.layout.card_tabfeed_hot_user_rank_header_view, (ViewGroup) null);
        this.irg = (RoundRelativeLayout) this.mView.findViewById(R.id.view_container);
        this.irh = (ImageView) this.mView.findViewById(R.id.ic_red_background);
        this.iri = (ImageView) this.mView.findViewById(R.id.ic_red_pic);
        this.irj = (TbImageView) this.mView.findViewById(R.id.rank_icon);
        this.irk = (ImageView) this.mView.findViewById(R.id.rank_icon_default);
        this.ilE = (TextView) this.mView.findViewById(R.id.forum_text);
        this.irl = (TextView) this.mView.findViewById(R.id.no_1_user);
        this.irn = (HotUserRankImageOverlayView) this.mView.findViewById(R.id.image_overlay_view);
        this.irm = (ImageView) this.mView.findViewById(R.id.iv_crown);
        this.iro = (ImageView) this.mView.findViewById(R.id.icon_arrow);
        int dimensionPixelOffset = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds114);
        this.irn.j(3, dimensionPixelOffset, dimensionPixelOffset, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds2_6), R.color.CAM_X0501, TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds62));
        this.irn.setStrokeStyle(1);
        this.irn.setLoadImageType(12);
        this.irn.setFirstImageStrokeColor(R.color.CAM_X0314);
        this.irg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.enterForum.tabfeed.view.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HotUserRankActivityConfig hotUserRankActivityConfig = new HotUserRankActivityConfig(b.this.mPageContext.getPageActivity());
                hotUserRankActivityConfig.setCategory(b.this.ilU);
                b.this.mPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, hotUserRankActivityConfig));
                ar arVar = new ar("c13655");
                arVar.w("uid", TbadkApplication.getCurrentAccountId());
                arVar.dR("resource_id", b.this.mTabName);
                TiebaStatic.log(arVar);
            }
        });
        this.tbds90 = l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds90);
        this.irg.setRoundLayoutRadius(new float[]{this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90, this.tbds90});
    }

    public View getView() {
        return this.mView;
    }

    public void a(c cVar) {
        if (cVar != null) {
            this.ilU = cVar.module_name;
            if (TextUtils.isEmpty(this.ilU)) {
                this.ilU = "";
            }
            this.ilE.setText(this.ilU + "榜");
            if (cVar.hot_user != null && cVar.hot_user.size() > 0) {
                this.irl.setText("NO.1 " + cVar.hot_user.get(0).user_name);
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (ShortUserInfo shortUserInfo : cVar.hot_user) {
                    if (i > 2) {
                        break;
                    }
                    i++;
                    arrayList.add(shortUserInfo.portrait);
                }
                this.irn.setData(arrayList);
                if (!TextUtils.isEmpty(cVar.module_icon)) {
                    this.irj.setVisibility(0);
                    this.irk.setVisibility(8);
                    this.irj.startLoad(cVar.module_icon, 12, false);
                } else {
                    this.irk.setVisibility(0);
                    this.irj.setVisibility(8);
                    SvgManager.bqB().a(this.irk, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
                }
            }
            onChangeSkinType();
        }
    }

    public void onChangeSkinType() {
        if (this.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
            this.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            ap.setBackgroundColor(this.irg, R.color.CAM_X0206);
            if (this.irk.getVisibility() == 0) {
                SvgManager.bqB().a(this.irk, R.drawable.ic_icon_mask_red_default_crown24, SvgManager.SvgResourceStateType.NORMAL);
            }
            SvgManager.bqB().a(this.irh, R.drawable.ic_pic_mask_list_red, SvgManager.SvgResourceStateType.NORMAL);
            ap.setImageResource(this.iri, R.drawable.pic_list_redword);
            SvgManager.bqB().a(this.iro, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0311, SvgManager.SvgResourceStateType.NORMAL);
            ap.setViewTextColor(this.ilE, R.color.CAM_X0311);
            ap.setViewTextColor(this.irl, R.color.CAM_X0311);
            SvgManager.bqB().a(this.irm, R.drawable.ic_icon_mask_first24, (SvgManager.SvgResourceStateType) null);
            this.irn.onChangeSkinType();
        }
    }

    public void setTabName(String str) {
        this.mTabName = str;
    }
}
