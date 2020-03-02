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
    private ForumData dyQ;
    private h gtB;
    private RoundAdapterLinearLayout gtD;
    private TextView gtE;
    private FrsAdCommentScrollView gtF;
    private TbImageView gty;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.gtD = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.gtD.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.gtD.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.gtD.findViewById(R.id.frs_top_ad_title);
        this.gtE = (TextView) this.gtD.findViewById(R.id.frs_top_person_num);
        this.gty = (TbImageView) this.gtD.findViewById(R.id.frs_top_ad_img);
        this.gty.setDefaultBgResource(R.color.white_alpha100);
        this.gtF = (FrsAdCommentScrollView) this.gtD.findViewById(R.id.ad_comment_scroll_view);
        this.gtD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gtB != null && !StringUtils.isNull(g.this.gtB.getUrl())) {
                    ba.aGG().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.gtB.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gtB.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cy("obj_isad", "1");
                    if (g.this.gtB.getType() == 1) {
                        i = 6;
                    } else if (g.this.gtB.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gtB.getType() == 3 ? 8 : 6;
                    }
                    anVar.X("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gtB.getId());
                    anVar.X("obj_locate", 3);
                    anVar.X("obj_floor", 1);
                    if (g.this.dyQ != null) {
                        anVar.cy("fid", g.this.dyQ.getId());
                        anVar.cy("first_dir", g.this.dyQ.getFirst_class());
                        anVar.cy("second_dir", g.this.dyQ.getSecond_class());
                    }
                    if (g.this.gtB.getType() == 1) {
                        anVar.cy("tid", g.this.gtB.getThreadId());
                        anVar.X("thread_type", g.this.gtB.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.gtD;
    }

    public void onPrimary(boolean z) {
        if (this.gtF != null) {
            this.gtF.onPrimary(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.gty.invalidate();
    }

    public void a(ForumData forumData, h hVar) {
        if (hVar != null) {
            this.dyQ = forumData;
            this.gtB = hVar;
            this.mTitleView.setText(this.gtB.getTitle());
            if (hVar.getType() == 3) {
                this.gtE.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gtB.cKe())));
            } else if (hVar.getType() == 1) {
                this.gtE.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gtB.cKe())));
            } else if (hVar.getType() == 2) {
                this.gtE.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gtB.cKe())));
            }
            this.gty.startLoad(this.gtB.getImg(), 10, false);
            if (this.gtF != null) {
                this.gtF.bf(this.gtB.cKf());
            }
        }
    }

    public void onDestroy() {
        if (this.gtF != null) {
            this.gtF.onDestroy();
        }
    }
}
