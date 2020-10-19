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
/* loaded from: classes22.dex */
public class g {
    private ForumData fbW;
    private TbImageView ivF;
    private i ivH;
    private RoundAdapterLinearLayout ivJ;
    private TextView ivK;
    private FrsAdCommentScrollView ivL;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.ivJ = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.ivJ.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.ivJ.findViewById(R.id.frs_top_ad_title);
        this.ivK = (TextView) this.ivJ.findViewById(R.id.frs_top_person_num);
        this.ivF = (TbImageView) this.ivJ.findViewById(R.id.frs_top_ad_img);
        this.ivF.setDefaultBgResource(R.color.white_alpha100);
        this.ivL = (FrsAdCommentScrollView) this.ivJ.findViewById(R.id.ad_comment_scroll_view);
        this.ivJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.ivH != null && !StringUtils.isNull(g.this.ivH.getUrl())) {
                    be.bmY().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.ivH.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.ivH.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dK("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dK("obj_isad", "1");
                    if (g.this.ivH.getType() == 1) {
                        i = 6;
                    } else if (g.this.ivH.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.ivH.getType() == 3 ? 8 : 6;
                    }
                    aqVar.aj("obj_adlocate", i);
                    aqVar.u("obj_id", g.this.ivH.getId());
                    aqVar.aj("obj_locate", 3);
                    aqVar.aj("obj_floor", 1);
                    if (g.this.fbW != null) {
                        aqVar.dK("fid", g.this.fbW.getId());
                        aqVar.dK("first_dir", g.this.fbW.getFirst_class());
                        aqVar.dK("second_dir", g.this.fbW.getSecond_class());
                    }
                    if (g.this.ivH.getType() == 1) {
                        aqVar.dK("tid", g.this.ivH.getThreadId());
                        aqVar.aj("thread_type", g.this.ivH.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.ivJ;
    }

    public void bO(boolean z) {
        if (this.ivL != null) {
            this.ivL.bO(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.ivF.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fbW = forumData;
            this.ivH = iVar;
            this.mTitleView.setText(this.ivH.getTitle());
            if (iVar.getType() == 3) {
                this.ivK.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.ivH.dDr())));
            } else if (iVar.getType() == 1) {
                this.ivK.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.ivH.dDr())));
            } else if (iVar.getType() == 2) {
                this.ivK.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.ivH.dDr())));
            }
            this.ivF.startLoad(this.ivH.getImg(), 10, false);
            if (this.ivL != null) {
                this.ivL.bG(this.ivH.dDs());
            }
        }
    }

    public void onDestroy() {
        if (this.ivL != null) {
            this.ivL.onDestroy();
        }
    }
}
