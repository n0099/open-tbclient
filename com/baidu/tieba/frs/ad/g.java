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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes2.dex */
public class g {
    private ForumData fFL;
    private TbImageView joO;
    private i joQ;
    private RoundAdapterLinearLayout joS;
    private TextView joT;
    private FrsAdCommentScrollView joU;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.joS = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.joS.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.joS.findViewById(R.id.frs_top_ad_title);
        this.joT = (TextView) this.joS.findViewById(R.id.frs_top_person_num);
        this.joO = (TbImageView) this.joS.findViewById(R.id.frs_top_ad_img);
        this.joO.setDefaultBgResource(R.color.white_alpha100);
        this.joU = (FrsAdCommentScrollView) this.joS.findViewById(R.id.ad_comment_scroll_view);
        this.joS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.joQ != null && !StringUtils.isNull(g.this.joQ.getUrl())) {
                    bf.bsY().a((TbPageContext) j.J(g.this.mContext), new String[]{g.this.joQ.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.joQ.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ar arVar = new ar("common_click");
                    arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                    arVar.dR("obj_isad", "1");
                    if (g.this.joQ.getType() == 1) {
                        i = 6;
                    } else if (g.this.joQ.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.joQ.getType() == 3 ? 8 : 6;
                    }
                    arVar.aq("obj_adlocate", i);
                    arVar.v("obj_id", g.this.joQ.getId());
                    arVar.aq("obj_locate", 3);
                    arVar.aq("obj_floor", 1);
                    if (g.this.fFL != null) {
                        arVar.dR("fid", g.this.fFL.getId());
                        arVar.dR("first_dir", g.this.fFL.getFirst_class());
                        arVar.dR("second_dir", g.this.fFL.getSecond_class());
                    }
                    if (g.this.joQ.getType() == 1) {
                        arVar.dR("tid", g.this.joQ.getThreadId());
                        arVar.aq("thread_type", g.this.joQ.getThreadType());
                    }
                    TiebaStatic.log(arVar);
                }
            }
        });
    }

    public View getView() {
        return this.joS;
    }

    public void cb(boolean z) {
        if (this.joU != null) {
            this.joU.cb(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.joO.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fFL = forumData;
            this.joQ = iVar;
            this.mTitleView.setText(this.joQ.getTitle());
            if (iVar.getType() == 3) {
                this.joT.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.joQ.dML())));
            } else if (iVar.getType() == 1) {
                this.joT.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.joQ.dML())));
            } else if (iVar.getType() == 2) {
                this.joT.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.joQ.dML())));
            }
            this.joO.startLoad(this.joQ.getImg(), 10, false);
            if (this.joU != null) {
                this.joU.cd(this.joQ.dMM());
            }
        }
    }

    public void onDestroy() {
        if (this.joU != null) {
            this.joU.onDestroy();
        }
    }
}
