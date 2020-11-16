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
/* loaded from: classes21.dex */
public class g {
    private ForumData fpv;
    private TbImageView iOL;
    private i iON;
    private RoundAdapterLinearLayout iOP;
    private TextView iOQ;
    private FrsAdCommentScrollView iOR;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.iOP = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.iOP.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.iOP.findViewById(R.id.frs_top_ad_title);
        this.iOQ = (TextView) this.iOP.findViewById(R.id.frs_top_person_num);
        this.iOL = (TbImageView) this.iOP.findViewById(R.id.frs_top_ad_img);
        this.iOL.setDefaultBgResource(R.color.white_alpha100);
        this.iOR = (FrsAdCommentScrollView) this.iOP.findViewById(R.id.ad_comment_scroll_view);
        this.iOP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.iON != null && !StringUtils.isNull(g.this.iON.getUrl())) {
                    bf.bqF().a((TbPageContext) com.baidu.adp.base.i.I(g.this.mContext), new String[]{g.this.iON.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.iON.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    ar arVar = new ar("common_click");
                    arVar.dR("page_type", PageStayDurationConstants.PageName.FRS);
                    arVar.dR("obj_isad", "1");
                    if (g.this.iON.getType() == 1) {
                        i = 6;
                    } else if (g.this.iON.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.iON.getType() == 3 ? 8 : 6;
                    }
                    arVar.ak("obj_adlocate", i);
                    arVar.w("obj_id", g.this.iON.getId());
                    arVar.ak("obj_locate", 3);
                    arVar.ak("obj_floor", 1);
                    if (g.this.fpv != null) {
                        arVar.dR("fid", g.this.fpv.getId());
                        arVar.dR("first_dir", g.this.fpv.getFirst_class());
                        arVar.dR("second_dir", g.this.fpv.getSecond_class());
                    }
                    if (g.this.iON.getType() == 1) {
                        arVar.dR("tid", g.this.iON.getThreadId());
                        arVar.ak("thread_type", g.this.iON.getThreadType());
                    }
                    TiebaStatic.log(arVar);
                }
            }
        });
    }

    public View getView() {
        return this.iOP;
    }

    public void bS(boolean z) {
        if (this.iOR != null) {
            this.iOR.bS(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.iOL.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.fpv = forumData;
            this.iON = iVar;
            this.mTitleView.setText(this.iON.getTitle());
            if (iVar.getType() == 3) {
                this.iOQ.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.iON.dIS())));
            } else if (iVar.getType() == 1) {
                this.iOQ.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.iON.dIS())));
            } else if (iVar.getType() == 2) {
                this.iOQ.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.iON.dIS())));
            }
            this.iOL.startLoad(this.iON.getImg(), 10, false);
            if (this.iOR != null) {
                this.iOR.bX(this.iON.dIT());
            }
        }
    }

    public void onDestroy() {
        if (this.iOR != null) {
            this.iOR.onDestroy();
        }
    }
}
