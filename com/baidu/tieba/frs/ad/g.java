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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes9.dex */
public class g {
    private ForumData dYX;
    private TbImageView hdA;
    private i hdC;
    private RoundAdapterLinearLayout hdE;
    private TextView hdF;
    private FrsAdCommentScrollView hdG;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hdE = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hdE.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hdE.findViewById(R.id.frs_top_ad_title);
        this.hdF = (TextView) this.hdE.findViewById(R.id.frs_top_person_num);
        this.hdA = (TbImageView) this.hdE.findViewById(R.id.frs_top_ad_img);
        this.hdA.setDefaultBgResource(R.color.white_alpha100);
        this.hdG = (FrsAdCommentScrollView) this.hdE.findViewById(R.id.ad_comment_scroll_view);
        this.hdE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hdC != null && !StringUtils.isNull(g.this.hdC.getUrl())) {
                    ba.aOY().a((TbPageContext) com.baidu.adp.base.i.T(g.this.mContext), new String[]{g.this.hdC.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hdC.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cI("obj_isad", "1");
                    if (g.this.hdC.getType() == 1) {
                        i = 6;
                    } else if (g.this.hdC.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hdC.getType() == 3 ? 8 : 6;
                    }
                    anVar.af("obj_adlocate", i);
                    anVar.t("obj_id", g.this.hdC.getId());
                    anVar.af("obj_locate", 3);
                    anVar.af("obj_floor", 1);
                    if (g.this.dYX != null) {
                        anVar.cI("fid", g.this.dYX.getId());
                        anVar.cI("first_dir", g.this.dYX.getFirst_class());
                        anVar.cI("second_dir", g.this.dYX.getSecond_class());
                    }
                    if (g.this.hdC.getType() == 1) {
                        anVar.cI("tid", g.this.hdC.getThreadId());
                        anVar.af("thread_type", g.this.hdC.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.hdE;
    }

    public void jb(boolean z) {
        if (this.hdG != null) {
            this.hdG.jb(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hdA.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.dYX = forumData;
            this.hdC = iVar;
            this.mTitleView.setText(this.hdC.getTitle());
            if (iVar.getType() == 3) {
                this.hdF.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hdC.cVv())));
            } else if (iVar.getType() == 1) {
                this.hdF.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hdC.cVv())));
            } else if (iVar.getType() == 2) {
                this.hdF.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hdC.cVv())));
            }
            this.hdA.startLoad(this.hdC.getImg(), 10, false);
            if (this.hdG != null) {
                this.hdG.bp(this.hdC.cVw());
            }
        }
    }

    public void onDestroy() {
        if (this.hdG != null) {
            this.hdG.onDestroy();
        }
    }
}
