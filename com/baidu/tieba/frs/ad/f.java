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
public class f {
    private ForumData eCv;
    private i hLt;
    private RoundAdapterLinearLayout hLu;
    private TbImageView hLv;
    private TextView hLw;
    private FrsAdCommentScrollView hLx;
    private Context mContext;
    private TextView mTitleView;

    public f(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hLu = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hLu.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hLu.findViewById(R.id.frs_top_ad_title);
        this.hLw = (TextView) this.hLu.findViewById(R.id.frs_top_person_num);
        this.hLv = (TbImageView) this.hLu.findViewById(R.id.frs_top_ad_img);
        this.hLv.setDefaultBgResource(R.color.white_alpha100);
        this.hLx = (FrsAdCommentScrollView) this.hLu.findViewById(R.id.ad_comment_scroll_view);
        this.hLu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.f.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (f.this.hLt != null && !StringUtils.isNull(f.this.hLt.getUrl())) {
                    bd.baV().a((TbPageContext) com.baidu.adp.base.i.G(f.this.mContext), new String[]{f.this.hLt.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", f.this.hLt.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ap apVar = new ap("common_click");
                    apVar.dn("page_type", PageStayDurationConstants.PageName.FRS);
                    apVar.dn("obj_isad", "1");
                    if (f.this.hLt.getType() == 1) {
                        i = 6;
                    } else if (f.this.hLt.getType() == 2) {
                        i = 7;
                    } else {
                        i = f.this.hLt.getType() == 3 ? 8 : 6;
                    }
                    apVar.ah("obj_adlocate", i);
                    apVar.t("obj_id", f.this.hLt.getId());
                    apVar.ah("obj_locate", 3);
                    apVar.ah("obj_floor", 1);
                    if (f.this.eCv != null) {
                        apVar.dn("fid", f.this.eCv.getId());
                        apVar.dn("first_dir", f.this.eCv.getFirst_class());
                        apVar.dn("second_dir", f.this.eCv.getSecond_class());
                    }
                    if (f.this.hLt.getType() == 1) {
                        apVar.dn("tid", f.this.hLt.getThreadId());
                        apVar.ah("thread_type", f.this.hLt.getThreadType());
                    }
                    TiebaStatic.log(apVar);
                }
            }
        });
    }

    public View getView() {
        return this.hLu;
    }

    public void bE(boolean z) {
        if (this.hLx != null) {
            this.hLx.bE(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hLv.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.eCv = forumData;
            this.hLt = iVar;
            this.mTitleView.setText(this.hLt.getTitle());
            if (iVar.getType() == 3) {
                this.hLw.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hLt.dkk())));
            } else if (iVar.getType() == 1) {
                this.hLw.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hLt.dkk())));
            } else if (iVar.getType() == 2) {
                this.hLw.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hLt.dkk())));
            }
            this.hLv.startLoad(this.hLt.getImg(), 10, false);
            if (this.hLx != null) {
                this.hLx.aV(this.hLt.dkl());
            }
        }
    }

    public void onDestroy() {
        if (this.hLx != null) {
            this.hLx.onDestroy();
        }
    }
}
