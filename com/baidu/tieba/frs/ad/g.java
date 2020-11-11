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
    private ForumData fqn;
    private TbImageView iNY;
    private i iOa;
    private RoundAdapterLinearLayout iOc;
    private TextView iOd;
    private FrsAdCommentScrollView iOe;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.iOc = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.iOc.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.iOc.findViewById(R.id.frs_top_ad_title);
        this.iOd = (TextView) this.iOc.findViewById(R.id.frs_top_person_num);
        this.iNY = (TbImageView) this.iOc.findViewById(R.id.frs_top_ad_img);
        this.iNY.setDefaultBgResource(R.color.white_alpha100);
        this.iOe = (FrsAdCommentScrollView) this.iOc.findViewById(R.id.ad_comment_scroll_view);
        this.iOc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.iOa != null && !StringUtils.isNull(g.this.iOa.getUrl())) {
                    be.brr().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.iOa.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.iOa.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dR("obj_isad", "1");
                    if (g.this.iOa.getType() == 1) {
                        i = 6;
                    } else if (g.this.iOa.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.iOa.getType() == 3 ? 8 : 6;
                    }
                    aqVar.al("obj_adlocate", i);
                    aqVar.w("obj_id", g.this.iOa.getId());
                    aqVar.al("obj_locate", 3);
                    aqVar.al("obj_floor", 1);
                    if (g.this.fqn != null) {
                        aqVar.dR("fid", g.this.fqn.getId());
                        aqVar.dR("first_dir", g.this.fqn.getFirst_class());
                        aqVar.dR("second_dir", g.this.fqn.getSecond_class());
                    }
                    if (g.this.iOa.getType() == 1) {
                        aqVar.dR("tid", g.this.iOa.getThreadId());
                        aqVar.al("thread_type", g.this.iOa.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.iOc;
    }

    public void bQ(boolean z) {
        if (this.iOe != null) {
            this.iOe.bQ(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.iNY.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fqn = forumData;
            this.iOa = iVar;
            this.mTitleView.setText(this.iOa.getTitle());
            if (iVar.getType() == 3) {
                this.iOd.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.iOa.dJb())));
            } else if (iVar.getType() == 1) {
                this.iOd.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.iOa.dJb())));
            } else if (iVar.getType() == 2) {
                this.iOd.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.iOa.dJb())));
            }
            this.iNY.startLoad(this.iOa.getImg(), 10, false);
            if (this.iOe != null) {
                this.iOe.bX(this.iOa.dJc());
            }
        }
    }

    public void onDestroy() {
        if (this.iOe != null) {
            this.iOe.onDestroy();
        }
    }
}
