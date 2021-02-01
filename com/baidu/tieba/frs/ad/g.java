package com.baidu.tieba.frs.ad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.j;
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
/* loaded from: classes2.dex */
public class g {
    private ForumData fEm;
    private TbImageView jmR;
    private i jmT;
    private RoundAdapterLinearLayout jmV;
    private TextView jmW;
    private FrsAdCommentScrollView jmX;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.jmV = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.jmV.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.jmV.findViewById(R.id.frs_top_ad_title);
        this.jmW = (TextView) this.jmV.findViewById(R.id.frs_top_person_num);
        this.jmR = (TbImageView) this.jmV.findViewById(R.id.frs_top_ad_img);
        this.jmR.setDefaultBgResource(R.color.white_alpha100);
        this.jmX = (FrsAdCommentScrollView) this.jmV.findViewById(R.id.ad_comment_scroll_view);
        this.jmV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.jmT != null && !StringUtils.isNull(g.this.jmT.getUrl())) {
                    bf.bsV().a((TbPageContext) j.K(g.this.mContext), new String[]{g.this.jmT.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.jmT.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ar arVar = new ar("common_click");
                    arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                    arVar.dR("obj_isad", "1");
                    if (g.this.jmT.getType() == 1) {
                        i = 6;
                    } else if (g.this.jmT.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.jmT.getType() == 3 ? 8 : 6;
                    }
                    arVar.ap("obj_adlocate", i);
                    arVar.v("obj_id", g.this.jmT.getId());
                    arVar.ap("obj_locate", 3);
                    arVar.ap("obj_floor", 1);
                    if (g.this.fEm != null) {
                        arVar.dR("fid", g.this.fEm.getId());
                        arVar.dR("first_dir", g.this.fEm.getFirst_class());
                        arVar.dR("second_dir", g.this.fEm.getSecond_class());
                    }
                    if (g.this.jmT.getType() == 1) {
                        arVar.dR("tid", g.this.jmT.getThreadId());
                        arVar.ap("thread_type", g.this.jmT.getThreadType());
                    }
                    TiebaStatic.log(arVar);
                }
            }
        });
    }

    public View getView() {
        return this.jmV;
    }

    public void cb(boolean z) {
        if (this.jmX != null) {
            this.jmX.cb(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.jmR.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fEm = forumData;
            this.jmT = iVar;
            this.mTitleView.setText(this.jmT.getTitle());
            if (iVar.getType() == 3) {
                this.jmW.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.jmT.dMv())));
            } else if (iVar.getType() == 1) {
                this.jmW.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.jmT.dMv())));
            } else if (iVar.getType() == 2) {
                this.jmW.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.jmT.dMv())));
            }
            this.jmR.startLoad(this.jmT.getImg(), 10, false);
            if (this.jmX != null) {
                this.jmX.cd(this.jmT.dMw());
            }
        }
    }

    public void onDestroy() {
        if (this.jmX != null) {
            this.jmX.onDestroy();
        }
    }
}
