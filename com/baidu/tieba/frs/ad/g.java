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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.h;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class g {
    private TbImageView fzD;
    private h fzG;
    private RoundAdapterLinearLayout fzI;
    private TextView fzJ;
    private FrsAdCommentScrollView fzK;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.fzI = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.fzI.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.fzI.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.fzI.findViewById(R.id.frs_top_ad_title);
        this.fzJ = (TextView) this.fzI.findViewById(R.id.frs_top_person_num);
        this.fzD = (TbImageView) this.fzI.findViewById(R.id.frs_top_ad_img);
        this.fzD.setDefaultBgResource(R.color.white_alpha100);
        this.fzK = (FrsAdCommentScrollView) this.fzI.findViewById(R.id.ad_comment_scroll_view);
        this.fzI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fzG != null && !StringUtils.isNull(g.this.fzG.getUrl())) {
                    bb.ajE().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.fzG.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.fzG.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.bT("page_type", "a006");
                    anVar.bT("obj_isad", "1");
                    String str = Constants.VIA_SHARE_TYPE_INFO;
                    if (g.this.fzG.getType() != 1) {
                        if (g.this.fzG.getType() != 2) {
                            if (g.this.fzG.getType() == 3) {
                                str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                            }
                        } else {
                            str = "7";
                        }
                    } else {
                        str = Constants.VIA_SHARE_TYPE_INFO;
                    }
                    anVar.bT("obj_adlocate", str);
                    anVar.l(VideoPlayActivityConfig.OBJ_ID, g.this.fzG.getId());
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.fzI;
    }

    public void jS(boolean z) {
        if (this.fzK != null) {
            this.fzK.jS(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.fzD.invalidate();
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fzG = hVar;
            this.mTitleView.setText(this.fzG.getTitle());
            this.fzJ.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.fzG.coK())));
            this.fzD.startLoad(this.fzG.Zy(), 10, false);
            if (this.fzK != null) {
                this.fzK.aU(this.fzG.coL());
            }
        }
    }

    public void onDestroy() {
        if (this.fzK != null) {
            this.fzK.onDestroy();
        }
    }
}
