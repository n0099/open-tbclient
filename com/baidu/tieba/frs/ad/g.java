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
    private ForumData fBZ;
    private TbImageView jhj;
    private i jhl;
    private RoundAdapterLinearLayout jhn;
    private TextView jho;
    private FrsAdCommentScrollView jhp;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.jhn = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.jhn.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.jhn.findViewById(R.id.frs_top_ad_title);
        this.jho = (TextView) this.jhn.findViewById(R.id.frs_top_person_num);
        this.jhj = (TbImageView) this.jhn.findViewById(R.id.frs_top_ad_img);
        this.jhj.setDefaultBgResource(R.color.white_alpha100);
        this.jhp = (FrsAdCommentScrollView) this.jhn.findViewById(R.id.ad_comment_scroll_view);
        this.jhn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.jhl != null && !StringUtils.isNull(g.this.jhl.getUrl())) {
                    be.bsB().a((TbPageContext) j.K(g.this.mContext), new String[]{g.this.jhl.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.jhl.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dW("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dW("obj_isad", "1");
                    if (g.this.jhl.getType() == 1) {
                        i = 6;
                    } else if (g.this.jhl.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.jhl.getType() == 3 ? 8 : 6;
                    }
                    aqVar.an("obj_adlocate", i);
                    aqVar.w("obj_id", g.this.jhl.getId());
                    aqVar.an("obj_locate", 3);
                    aqVar.an("obj_floor", 1);
                    if (g.this.fBZ != null) {
                        aqVar.dW("fid", g.this.fBZ.getId());
                        aqVar.dW("first_dir", g.this.fBZ.getFirst_class());
                        aqVar.dW("second_dir", g.this.fBZ.getSecond_class());
                    }
                    if (g.this.jhl.getType() == 1) {
                        aqVar.dW("tid", g.this.jhl.getThreadId());
                        aqVar.an("thread_type", g.this.jhl.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.jhn;
    }

    public void bW(boolean z) {
        if (this.jhp != null) {
            this.jhp.bW(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.jhj.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fBZ = forumData;
            this.jhl = iVar;
            this.mTitleView.setText(this.jhl.getTitle());
            if (iVar.getType() == 3) {
                this.jho.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.jhl.dKk())));
            } else if (iVar.getType() == 1) {
                this.jho.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.jhl.dKk())));
            } else if (iVar.getType() == 2) {
                this.jho.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.jhl.dKk())));
            }
            this.jhj.startLoad(this.jhl.getImg(), 10, false);
            if (this.jhp != null) {
                this.jhp.ci(this.jhl.dKl());
            }
        }
    }

    public void onDestroy() {
        if (this.jhp != null) {
            this.jhp.onDestroy();
        }
    }
}
