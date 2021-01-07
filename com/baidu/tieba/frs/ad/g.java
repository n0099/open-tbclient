package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.j;
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
/* loaded from: classes2.dex */
public class g {
    private ForumData fGG;
    private TbImageView jlQ;
    private i jlS;
    private RoundAdapterLinearLayout jlU;
    private TextView jlV;
    private FrsAdCommentScrollView jlW;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.jlU = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.jlU.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.jlU.findViewById(R.id.frs_top_ad_title);
        this.jlV = (TextView) this.jlU.findViewById(R.id.frs_top_person_num);
        this.jlQ = (TbImageView) this.jlU.findViewById(R.id.frs_top_ad_img);
        this.jlQ.setDefaultBgResource(R.color.white_alpha100);
        this.jlW = (FrsAdCommentScrollView) this.jlU.findViewById(R.id.ad_comment_scroll_view);
        this.jlU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.jlS != null && !StringUtils.isNull(g.this.jlS.getUrl())) {
                    be.bwv().a((TbPageContext) j.K(g.this.mContext), new String[]{g.this.jlS.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.jlS.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dX("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dX("obj_isad", "1");
                    if (g.this.jlS.getType() == 1) {
                        i = 6;
                    } else if (g.this.jlS.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.jlS.getType() == 3 ? 8 : 6;
                    }
                    aqVar.an("obj_adlocate", i);
                    aqVar.w("obj_id", g.this.jlS.getId());
                    aqVar.an("obj_locate", 3);
                    aqVar.an("obj_floor", 1);
                    if (g.this.fGG != null) {
                        aqVar.dX("fid", g.this.fGG.getId());
                        aqVar.dX("first_dir", g.this.fGG.getFirst_class());
                        aqVar.dX("second_dir", g.this.fGG.getSecond_class());
                    }
                    if (g.this.jlS.getType() == 1) {
                        aqVar.dX("tid", g.this.jlS.getThreadId());
                        aqVar.an("thread_type", g.this.jlS.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.jlU;
    }

    public void ca(boolean z) {
        if (this.jlW != null) {
            this.jlW.ca(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.jlQ.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fGG = forumData;
            this.jlS = iVar;
            this.mTitleView.setText(this.jlS.getTitle());
            if (iVar.getType() == 3) {
                this.jlV.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.jlS.dOc())));
            } else if (iVar.getType() == 1) {
                this.jlV.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.jlS.dOc())));
            } else if (iVar.getType() == 2) {
                this.jlV.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.jlS.dOc())));
            }
            this.jlQ.startLoad(this.jlS.getImg(), 10, false);
            if (this.jlW != null) {
                this.jlW.ci(this.jlS.dOd());
            }
        }
    }

    public void onDestroy() {
        if (this.jlW != null) {
            this.jlW.onDestroy();
        }
    }
}
