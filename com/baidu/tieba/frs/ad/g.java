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
    private ForumData eMY;
    private TbImageView hZE;
    private i hZG;
    private RoundAdapterLinearLayout hZI;
    private TextView hZJ;
    private FrsAdCommentScrollView hZK;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hZI = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hZI.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hZI.findViewById(R.id.frs_top_ad_title);
        this.hZJ = (TextView) this.hZI.findViewById(R.id.frs_top_person_num);
        this.hZE = (TbImageView) this.hZI.findViewById(R.id.frs_top_ad_img);
        this.hZE.setDefaultBgResource(R.color.white_alpha100);
        this.hZK = (FrsAdCommentScrollView) this.hZI.findViewById(R.id.ad_comment_scroll_view);
        this.hZI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hZG != null && !StringUtils.isNull(g.this.hZG.getUrl())) {
                    be.bju().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.hZG.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hZG.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dD("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dD("obj_isad", "1");
                    if (g.this.hZG.getType() == 1) {
                        i = 6;
                    } else if (g.this.hZG.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hZG.getType() == 3 ? 8 : 6;
                    }
                    aqVar.ai("obj_adlocate", i);
                    aqVar.u("obj_id", g.this.hZG.getId());
                    aqVar.ai("obj_locate", 3);
                    aqVar.ai("obj_floor", 1);
                    if (g.this.eMY != null) {
                        aqVar.dD("fid", g.this.eMY.getId());
                        aqVar.dD("first_dir", g.this.eMY.getFirst_class());
                        aqVar.dD("second_dir", g.this.eMY.getSecond_class());
                    }
                    if (g.this.hZG.getType() == 1) {
                        aqVar.dD("tid", g.this.hZG.getThreadId());
                        aqVar.ai("thread_type", g.this.hZG.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.hZI;
    }

    public void bJ(boolean z) {
        if (this.hZK != null) {
            this.hZK.bJ(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hZE.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.eMY = forumData;
            this.hZG = iVar;
            this.mTitleView.setText(this.hZG.getTitle());
            if (iVar.getType() == 3) {
                this.hZJ.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hZG.dvN())));
            } else if (iVar.getType() == 1) {
                this.hZJ.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hZG.dvN())));
            } else if (iVar.getType() == 2) {
                this.hZJ.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hZG.dvN())));
            }
            this.hZE.startLoad(this.hZG.getImg(), 10, false);
            if (this.hZK != null) {
                this.hZK.by(this.hZG.dvO());
            }
        }
    }

    public void onDestroy() {
        if (this.hZK != null) {
            this.hZK.onDestroy();
        }
    }
}
