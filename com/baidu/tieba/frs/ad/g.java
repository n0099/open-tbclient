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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.h;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class g {
    private TbImageView fBq;
    private h fBt;
    private RoundAdapterLinearLayout fBv;
    private TextView fBw;
    private FrsAdCommentScrollView fBx;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.fBv = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.fBv.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.fBv.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.fBv.findViewById(R.id.frs_top_ad_title);
        this.fBw = (TextView) this.fBv.findViewById(R.id.frs_top_person_num);
        this.fBq = (TbImageView) this.fBv.findViewById(R.id.frs_top_ad_img);
        this.fBq.setDefaultBgResource(R.color.white_alpha100);
        this.fBx = (FrsAdCommentScrollView) this.fBv.findViewById(R.id.ad_comment_scroll_view);
        this.fBv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (g.this.fBt != null && !StringUtils.isNull(g.this.fBt.getUrl())) {
                    ba.ajK().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.fBt.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.fBt.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.bT("page_type", "a006");
                    anVar.bT("obj_isad", "1");
                    String str = Constants.VIA_SHARE_TYPE_INFO;
                    if (g.this.fBt.getType() != 1) {
                        if (g.this.fBt.getType() != 2) {
                            if (g.this.fBt.getType() == 3) {
                                str = Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                            }
                        } else {
                            str = "7";
                        }
                    } else {
                        str = Constants.VIA_SHARE_TYPE_INFO;
                    }
                    anVar.bT("obj_adlocate", str);
                    anVar.n(VideoPlayActivityConfig.OBJ_ID, g.this.fBt.getId());
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.fBv;
    }

    public void jV(boolean z) {
        if (this.fBx != null) {
            this.fBx.jV(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.fBq.invalidate();
    }

    public void a(h hVar) {
        if (hVar != null) {
            this.fBt = hVar;
            this.mTitleView.setText(this.fBt.getTitle());
            this.fBw.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.fBt.cpx())));
            this.fBq.startLoad(this.fBt.ZC(), 10, false);
            if (this.fBx != null) {
                this.fBx.aU(this.fBt.cpy());
            }
        }
    }

    public void onDestroy() {
        if (this.fBx != null) {
            this.fBx.onDestroy();
        }
    }
}
