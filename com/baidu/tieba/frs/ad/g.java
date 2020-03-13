package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes9.dex */
public class g {
    private ForumData dzd;
    private TbImageView gtL;
    private h gtN;
    private RoundAdapterLinearLayout gtP;
    private TextView gtQ;
    private FrsAdCommentScrollView gtR;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.gtP = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.gtP.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.gtP.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.gtP.findViewById(R.id.frs_top_ad_title);
        this.gtQ = (TextView) this.gtP.findViewById(R.id.frs_top_person_num);
        this.gtL = (TbImageView) this.gtP.findViewById(R.id.frs_top_ad_img);
        this.gtL.setDefaultBgResource(R.color.white_alpha100);
        this.gtR = (FrsAdCommentScrollView) this.gtP.findViewById(R.id.ad_comment_scroll_view);
        this.gtP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gtN != null && !StringUtils.isNull(g.this.gtN.getUrl())) {
                    ba.aGG().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.gtN.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gtN.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cy("obj_isad", "1");
                    if (g.this.gtN.getType() == 1) {
                        i = 6;
                    } else if (g.this.gtN.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gtN.getType() == 3 ? 8 : 6;
                    }
                    anVar.X("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gtN.getId());
                    anVar.X("obj_locate", 3);
                    anVar.X("obj_floor", 1);
                    if (g.this.dzd != null) {
                        anVar.cy("fid", g.this.dzd.getId());
                        anVar.cy("first_dir", g.this.dzd.getFirst_class());
                        anVar.cy("second_dir", g.this.dzd.getSecond_class());
                    }
                    if (g.this.gtN.getType() == 1) {
                        anVar.cy("tid", g.this.gtN.getThreadId());
                        anVar.X("thread_type", g.this.gtN.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.gtP;
    }

    public void onPrimary(boolean z) {
        if (this.gtR != null) {
            this.gtR.onPrimary(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.gtL.invalidate();
    }

    public void a(ForumData forumData, h hVar) {
        if (hVar != null) {
            this.dzd = forumData;
            this.gtN = hVar;
            this.mTitleView.setText(this.gtN.getTitle());
            if (hVar.getType() == 3) {
                this.gtQ.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gtN.cKf())));
            } else if (hVar.getType() == 1) {
                this.gtQ.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gtN.cKf())));
            } else if (hVar.getType() == 2) {
                this.gtQ.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gtN.cKf())));
            }
            this.gtL.startLoad(this.gtN.getImg(), 10, false);
            if (this.gtR != null) {
                this.gtR.bf(this.gtN.cKg());
            }
        }
    }

    public void onDestroy() {
        if (this.gtR != null) {
            this.gtR.onDestroy();
        }
    }
}
