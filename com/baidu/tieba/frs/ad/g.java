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
/* loaded from: classes21.dex */
public class g {
    private ForumData ePP;
    private TbImageView igI;
    private i igK;
    private RoundAdapterLinearLayout igM;
    private TextView igN;
    private FrsAdCommentScrollView igO;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.igM = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.igM.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.igM.findViewById(R.id.frs_top_ad_title);
        this.igN = (TextView) this.igM.findViewById(R.id.frs_top_person_num);
        this.igI = (TbImageView) this.igM.findViewById(R.id.frs_top_ad_img);
        this.igI.setDefaultBgResource(R.color.white_alpha100);
        this.igO = (FrsAdCommentScrollView) this.igM.findViewById(R.id.ad_comment_scroll_view);
        this.igM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.igK != null && !StringUtils.isNull(g.this.igK.getUrl())) {
                    be.bkp().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.igK.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.igK.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dF("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dF("obj_isad", "1");
                    if (g.this.igK.getType() == 1) {
                        i = 6;
                    } else if (g.this.igK.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.igK.getType() == 3 ? 8 : 6;
                    }
                    aqVar.ai("obj_adlocate", i);
                    aqVar.u("obj_id", g.this.igK.getId());
                    aqVar.ai("obj_locate", 3);
                    aqVar.ai("obj_floor", 1);
                    if (g.this.ePP != null) {
                        aqVar.dF("fid", g.this.ePP.getId());
                        aqVar.dF("first_dir", g.this.ePP.getFirst_class());
                        aqVar.dF("second_dir", g.this.ePP.getSecond_class());
                    }
                    if (g.this.igK.getType() == 1) {
                        aqVar.dF("tid", g.this.igK.getThreadId());
                        aqVar.ai("thread_type", g.this.igK.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.igM;
    }

    public void bL(boolean z) {
        if (this.igO != null) {
            this.igO.bL(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.igI.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.ePP = forumData;
            this.igK = iVar;
            this.mTitleView.setText(this.igK.getTitle());
            if (iVar.getType() == 3) {
                this.igN.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.igK.dzG())));
            } else if (iVar.getType() == 1) {
                this.igN.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.igK.dzG())));
            } else if (iVar.getType() == 2) {
                this.igN.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.igK.dzG())));
            }
            this.igI.startLoad(this.igK.getImg(), 10, false);
            if (this.igO != null) {
                this.igO.bD(this.igK.dzH());
            }
        }
    }

    public void onDestroy() {
        if (this.igO != null) {
            this.igO.onDestroy();
        }
    }
}
