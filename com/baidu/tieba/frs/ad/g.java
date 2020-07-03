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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes9.dex */
public class g {
    private ForumData ewc;
    private TextView hFA;
    private FrsAdCommentScrollView hFB;
    private TbImageView hFv;
    private i hFx;
    private RoundAdapterLinearLayout hFz;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hFz = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hFz.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hFz.findViewById(R.id.frs_top_ad_title);
        this.hFA = (TextView) this.hFz.findViewById(R.id.frs_top_person_num);
        this.hFv = (TbImageView) this.hFz.findViewById(R.id.frs_top_ad_img);
        this.hFv.setDefaultBgResource(R.color.white_alpha100);
        this.hFB = (FrsAdCommentScrollView) this.hFz.findViewById(R.id.ad_comment_scroll_view);
        this.hFz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hFx != null && !StringUtils.isNull(g.this.hFx.getUrl())) {
                    bc.aWU().a((TbPageContext) com.baidu.adp.base.i.G(g.this.mContext), new String[]{g.this.hFx.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hFx.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ao aoVar = new ao("common_click");
                    aoVar.dk("page_type", PageStayDurationConstants.PageName.FRS);
                    aoVar.dk("obj_isad", "1");
                    if (g.this.hFx.getType() == 1) {
                        i = 6;
                    } else if (g.this.hFx.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hFx.getType() == 3 ? 8 : 6;
                    }
                    aoVar.ag("obj_adlocate", i);
                    aoVar.s("obj_id", g.this.hFx.getId());
                    aoVar.ag("obj_locate", 3);
                    aoVar.ag("obj_floor", 1);
                    if (g.this.ewc != null) {
                        aoVar.dk("fid", g.this.ewc.getId());
                        aoVar.dk("first_dir", g.this.ewc.getFirst_class());
                        aoVar.dk("second_dir", g.this.ewc.getSecond_class());
                    }
                    if (g.this.hFx.getType() == 1) {
                        aoVar.dk("tid", g.this.hFx.getThreadId());
                        aoVar.ag("thread_type", g.this.hFx.getThreadType());
                    }
                    TiebaStatic.log(aoVar);
                }
            }
        });
    }

    public View getView() {
        return this.hFz;
    }

    public void bB(boolean z) {
        if (this.hFB != null) {
            this.hFB.bB(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hFv.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.ewc = forumData;
            this.hFx = iVar;
            this.mTitleView.setText(this.hFx.getTitle());
            if (iVar.getType() == 3) {
                this.hFA.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hFx.dhb())));
            } else if (iVar.getType() == 1) {
                this.hFA.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hFx.dhb())));
            } else if (iVar.getType() == 2) {
                this.hFA.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hFx.dhb())));
            }
            this.hFv.startLoad(this.hFx.getImg(), 10, false);
            if (this.hFB != null) {
                this.hFB.aP(this.hFx.dhc());
            }
        }
    }

    public void onDestroy() {
        if (this.hFB != null) {
            this.hFB.onDestroy();
        }
    }
}
