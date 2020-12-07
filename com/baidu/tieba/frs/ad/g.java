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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.view.RoundAdapterLinearLayout;
import com.baidu.tieba.tbadkCore.i;
/* loaded from: classes22.dex */
public class g {
    private ForumData fxa;
    private TbImageView iZC;
    private i iZE;
    private RoundAdapterLinearLayout iZG;
    private TextView iZH;
    private FrsAdCommentScrollView iZI;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.iZG = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.iZG.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.iZG.findViewById(R.id.frs_top_ad_title);
        this.iZH = (TextView) this.iZG.findViewById(R.id.frs_top_person_num);
        this.iZC = (TbImageView) this.iZG.findViewById(R.id.frs_top_ad_img);
        this.iZC.setDefaultBgResource(R.color.white_alpha100);
        this.iZI = (FrsAdCommentScrollView) this.iZG.findViewById(R.id.ad_comment_scroll_view);
        this.iZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.iZE != null && !StringUtils.isNull(g.this.iZE.getUrl())) {
                    bf.bua().a((TbPageContext) com.baidu.adp.base.i.J(g.this.mContext), new String[]{g.this.iZE.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.iZE.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ar arVar = new ar("common_click");
                    arVar.dY("page_type", PageStayDurationConstants.PageName.FRS);
                    arVar.dY("obj_isad", "1");
                    if (g.this.iZE.getType() == 1) {
                        i = 6;
                    } else if (g.this.iZE.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.iZE.getType() == 3 ? 8 : 6;
                    }
                    arVar.al("obj_adlocate", i);
                    arVar.w("obj_id", g.this.iZE.getId());
                    arVar.al("obj_locate", 3);
                    arVar.al("obj_floor", 1);
                    if (g.this.fxa != null) {
                        arVar.dY("fid", g.this.fxa.getId());
                        arVar.dY("first_dir", g.this.fxa.getFirst_class());
                        arVar.dY("second_dir", g.this.fxa.getSecond_class());
                    }
                    if (g.this.iZE.getType() == 1) {
                        arVar.dY("tid", g.this.iZE.getThreadId());
                        arVar.al("thread_type", g.this.iZE.getThreadType());
                    }
                    TiebaStatic.log(arVar);
                }
            }
        });
    }

    public View getView() {
        return this.iZG;
    }

    public void cb(boolean z) {
        if (this.iZI != null) {
            this.iZI.cb(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.iZC.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fxa = forumData;
            this.iZE = iVar;
            this.mTitleView.setText(this.iZE.getTitle());
            if (iVar.getType() == 3) {
                this.iZH.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.iZE.dOi())));
            } else if (iVar.getType() == 1) {
                this.iZH.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.iZE.dOi())));
            } else if (iVar.getType() == 2) {
                this.iZH.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.iZE.dOi())));
            }
            this.iZC.startLoad(this.iZE.getImg(), 10, false);
            if (this.iZI != null) {
                this.iZI.cb(this.iZE.dOj());
            }
        }
    }

    public void onDestroy() {
        if (this.iZI != null) {
            this.iZI.onDestroy();
        }
    }
}
