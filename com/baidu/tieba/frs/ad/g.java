package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes16.dex */
public class g {
    private ForumData eMU;
    private i hZA;
    private RoundAdapterLinearLayout hZC;
    private TextView hZD;
    private FrsAdCommentScrollView hZE;
    private TbImageView hZy;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hZC = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hZC.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hZC.findViewById(R.id.frs_top_ad_title);
        this.hZD = (TextView) this.hZC.findViewById(R.id.frs_top_person_num);
        this.hZy = (TbImageView) this.hZC.findViewById(R.id.frs_top_ad_img);
        this.hZy.setDefaultBgResource(R.color.white_alpha100);
        this.hZE = (FrsAdCommentScrollView) this.hZC.findViewById(R.id.ad_comment_scroll_view);
        this.hZC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hZA != null && !StringUtils.isNull(g.this.hZA.getUrl())) {
                    be.bju().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.hZA.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hZA.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dD("obj_isad", "1");
                    if (g.this.hZA.getType() == 1) {
                        i = 6;
                    } else if (g.this.hZA.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hZA.getType() == 3 ? 8 : 6;
                    }
                    aqVar.ai("obj_adlocate", i);
                    aqVar.u("obj_id", g.this.hZA.getId());
                    aqVar.ai("obj_locate", 3);
                    aqVar.ai("obj_floor", 1);
                    if (g.this.eMU != null) {
                        aqVar.dD("fid", g.this.eMU.getId());
                        aqVar.dD("first_dir", g.this.eMU.getFirst_class());
                        aqVar.dD("second_dir", g.this.eMU.getSecond_class());
                    }
                    if (g.this.hZA.getType() == 1) {
                        aqVar.dD("tid", g.this.hZA.getThreadId());
                        aqVar.ai("thread_type", g.this.hZA.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.hZC;
    }

    public void bJ(boolean z) {
        if (this.hZE != null) {
            this.hZE.bJ(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hZy.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.eMU = forumData;
            this.hZA = iVar;
            this.mTitleView.setText(this.hZA.getTitle());
            if (iVar.getType() == 3) {
                this.hZD.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hZA.dvI())));
            } else if (iVar.getType() == 1) {
                this.hZD.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hZA.dvI())));
            } else if (iVar.getType() == 2) {
                this.hZD.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hZA.dvI())));
            }
            this.hZy.startLoad(this.hZA.getImg(), 10, false);
            if (this.hZE != null) {
                this.hZE.by(this.hZA.dvJ());
            }
        }
    }

    public void onDestroy() {
        if (this.hZE != null) {
            this.hZE.onDestroy();
        }
    }
}
