package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.h;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class g {
    private TbImageView fzQ;
    private h fzT;
    private RoundAdapterLinearLayout fzV;
    private TextView fzW;
    private FrsAdCommentScrollView fzX;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.fzV = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.fzV.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.fzV.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.fzV.findViewById(R.id.frs_top_ad_title);
        this.fzW = (TextView) this.fzV.findViewById(R.id.frs_top_person_num);
        this.fzQ = (TbImageView) this.fzV.findViewById(R.id.frs_top_ad_img);
        this.fzQ.setDefaultBgResource(R.color.white_alpha100);
        this.fzX = (FrsAdCommentScrollView) this.fzV.findViewById(R.id.ad_comment_scroll_view);
        this.fzV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fzT != null && !StringUtils.isNull(g.this.fzT.getUrl())) {
                    ba.amO().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.fzT.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.fzT.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.bS("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.bS("obj_isad", "1");
                    String str = "6";
                    if (g.this.fzT.getType() != 1) {
                        if (g.this.fzT.getType() != 2) {
                            if (g.this.fzT.getType() == 3) {
                                str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                            }
                        } else {
                            str = "7";
                        }
                    } else {
                        str = "6";
                    }
                    anVar.bS("obj_adlocate", str);
                    anVar.p("obj_id", g.this.fzT.getId());
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.fzV;
    }

    public void jJ(boolean z) {
        if (this.fzX != null) {
            this.fzX.jJ(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.fzQ.invalidate();
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fzT = hVar;
            this.mTitleView.setText(this.fzT.getTitle());
            this.fzW.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.fzT.cnm())));
            this.fzQ.startLoad(this.fzT.aep(), 10, false);
            if (this.fzX != null) {
                this.fzX.bh(this.fzT.cnn());
            }
        }
    }

    public void onDestroy() {
        if (this.fzX != null) {
            this.fzX.onDestroy();
        }
    }
}
