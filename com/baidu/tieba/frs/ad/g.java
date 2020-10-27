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
    private ForumData fkv;
    private TbImageView iIb;
    private i iId;
    private RoundAdapterLinearLayout iIf;
    private TextView iIg;
    private FrsAdCommentScrollView iIh;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.iIf = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.iIf.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.iIf.findViewById(R.id.frs_top_ad_title);
        this.iIg = (TextView) this.iIf.findViewById(R.id.frs_top_person_num);
        this.iIb = (TbImageView) this.iIf.findViewById(R.id.frs_top_ad_img);
        this.iIb.setDefaultBgResource(R.color.white_alpha100);
        this.iIh = (FrsAdCommentScrollView) this.iIf.findViewById(R.id.ad_comment_scroll_view);
        this.iIf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.iId != null && !StringUtils.isNull(g.this.iId.getUrl())) {
                    be.boR().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.iId.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.iId.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    aq aqVar = new aq("common_click");
                    aqVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                    aqVar.dR("obj_isad", "1");
                    if (g.this.iId.getType() == 1) {
                        i = 6;
                    } else if (g.this.iId.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.iId.getType() == 3 ? 8 : 6;
                    }
                    aqVar.aj("obj_adlocate", i);
                    aqVar.w("obj_id", g.this.iId.getId());
                    aqVar.aj("obj_locate", 3);
                    aqVar.aj("obj_floor", 1);
                    if (g.this.fkv != null) {
                        aqVar.dR("fid", g.this.fkv.getId());
                        aqVar.dR("first_dir", g.this.fkv.getFirst_class());
                        aqVar.dR("second_dir", g.this.fkv.getSecond_class());
                    }
                    if (g.this.iId.getType() == 1) {
                        aqVar.dR("tid", g.this.iId.getThreadId());
                        aqVar.aj("thread_type", g.this.iId.getThreadType());
                    }
                    TiebaStatic.log(aqVar);
                }
            }
        });
    }

    public View getView() {
        return this.iIf;
    }

    public void bP(boolean z) {
        if (this.iIh != null) {
            this.iIh.bP(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.iIb.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fkv = forumData;
            this.iId = iVar;
            this.mTitleView.setText(this.iId.getTitle());
            if (iVar.getType() == 3) {
                this.iIg.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.iId.dGz())));
            } else if (iVar.getType() == 1) {
                this.iIg.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.iId.dGz())));
            } else if (iVar.getType() == 2) {
                this.iIg.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.iId.dGz())));
            }
            this.iIb.startLoad(this.iId.getImg(), 10, false);
            if (this.iIh != null) {
                this.iIh.bQ(this.iId.dGA());
            }
        }
    }

    public void onDestroy() {
        if (this.iIh != null) {
            this.iIh.onDestroy();
        }
    }
}
