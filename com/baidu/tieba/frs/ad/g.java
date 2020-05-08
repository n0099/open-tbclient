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
    private ForumData dZc;
    private TbImageView hdG;
    private i hdI;
    private RoundAdapterLinearLayout hdK;
    private TextView hdL;
    private FrsAdCommentScrollView hdM;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hdK = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hdK.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hdK.findViewById(R.id.frs_top_ad_title);
        this.hdL = (TextView) this.hdK.findViewById(R.id.frs_top_person_num);
        this.hdG = (TbImageView) this.hdK.findViewById(R.id.frs_top_ad_img);
        this.hdG.setDefaultBgResource(R.color.white_alpha100);
        this.hdM = (FrsAdCommentScrollView) this.hdK.findViewById(R.id.ad_comment_scroll_view);
        this.hdK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hdI != null && !StringUtils.isNull(g.this.hdI.getUrl())) {
                    ba.aOV().a((TbPageContext) com.baidu.adp.base.i.G(g.this.mContext), new String[]{g.this.hdI.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hdI.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cI("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cI("obj_isad", "1");
                    if (g.this.hdI.getType() == 1) {
                        i = 6;
                    } else if (g.this.hdI.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hdI.getType() == 3 ? 8 : 6;
                    }
                    anVar.af("obj_adlocate", i);
                    anVar.t("obj_id", g.this.hdI.getId());
                    anVar.af("obj_locate", 3);
                    anVar.af("obj_floor", 1);
                    if (g.this.dZc != null) {
                        anVar.cI("fid", g.this.dZc.getId());
                        anVar.cI("first_dir", g.this.dZc.getFirst_class());
                        anVar.cI("second_dir", g.this.dZc.getSecond_class());
                    }
                    if (g.this.hdI.getType() == 1) {
                        anVar.cI("tid", g.this.hdI.getThreadId());
                        anVar.af("thread_type", g.this.hdI.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.hdK;
    }

    public void jb(boolean z) {
        if (this.hdM != null) {
            this.hdM.jb(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hdG.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.dZc = forumData;
            this.hdI = iVar;
            this.mTitleView.setText(this.hdI.getTitle());
            if (iVar.getType() == 3) {
                this.hdL.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hdI.cVs())));
            } else if (iVar.getType() == 1) {
                this.hdL.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hdI.cVs())));
            } else if (iVar.getType() == 2) {
                this.hdL.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hdI.cVs())));
            }
            this.hdG.startLoad(this.hdI.getImg(), 10, false);
            if (this.hdM != null) {
                this.hdM.bp(this.hdI.cVt());
            }
        }
    }

    public void onDestroy() {
        if (this.hdM != null) {
            this.hdM.onDestroy();
        }
    }
}
