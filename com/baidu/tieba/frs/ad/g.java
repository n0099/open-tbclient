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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes16.dex */
public class g {
    private ForumData eCv;
    private TbImageView hLt;
    private i hLv;
    private RoundAdapterLinearLayout hLx;
    private TextView hLy;
    private FrsAdCommentScrollView hLz;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hLx = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hLx.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hLx.findViewById(R.id.frs_top_ad_title);
        this.hLy = (TextView) this.hLx.findViewById(R.id.frs_top_person_num);
        this.hLt = (TbImageView) this.hLx.findViewById(R.id.frs_top_ad_img);
        this.hLt.setDefaultBgResource(R.color.white_alpha100);
        this.hLz = (FrsAdCommentScrollView) this.hLx.findViewById(R.id.ad_comment_scroll_view);
        this.hLx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hLv != null && !StringUtils.isNull(g.this.hLv.getUrl())) {
                    bd.baV().a((TbPageContext) com.baidu.adp.base.i.G(g.this.mContext), new String[]{g.this.hLv.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hLv.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ap apVar = new ap("common_click");
                    apVar.dn("page_type", PageStayDurationConstants.PageName.FRS);
                    apVar.dn("obj_isad", "1");
                    if (g.this.hLv.getType() == 1) {
                        i = 6;
                    } else if (g.this.hLv.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hLv.getType() == 3 ? 8 : 6;
                    }
                    apVar.ah("obj_adlocate", i);
                    apVar.t("obj_id", g.this.hLv.getId());
                    apVar.ah("obj_locate", 3);
                    apVar.ah("obj_floor", 1);
                    if (g.this.eCv != null) {
                        apVar.dn("fid", g.this.eCv.getId());
                        apVar.dn("first_dir", g.this.eCv.getFirst_class());
                        apVar.dn("second_dir", g.this.eCv.getSecond_class());
                    }
                    if (g.this.hLv.getType() == 1) {
                        apVar.dn("tid", g.this.hLv.getThreadId());
                        apVar.ah("thread_type", g.this.hLv.getThreadType());
                    }
                    TiebaStatic.log(apVar);
                }
            }
        });
    }

    public View getView() {
        return this.hLx;
    }

    public void bE(boolean z) {
        if (this.hLz != null) {
            this.hLz.bE(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hLt.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.eCv = forumData;
            this.hLv = iVar;
            this.mTitleView.setText(this.hLv.getTitle());
            if (iVar.getType() == 3) {
                this.hLy.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hLv.dkl())));
            } else if (iVar.getType() == 1) {
                this.hLy.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hLv.dkl())));
            } else if (iVar.getType() == 2) {
                this.hLy.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hLv.dkl())));
            }
            this.hLt.startLoad(this.hLv.getImg(), 10, false);
            if (this.hLz != null) {
                this.hLz.aV(this.hLv.dkm());
            }
        }
    }

    public void onDestroy() {
        if (this.hLz != null) {
            this.hLz.onDestroy();
        }
    }
}
