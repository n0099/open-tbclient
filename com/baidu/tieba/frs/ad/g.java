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
    private ForumData dzq;
    private TbImageView gup;
    private i gur;
    private RoundAdapterLinearLayout gut;
    private TextView guu;
    private FrsAdCommentScrollView guv;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.gut = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.gut.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.gut.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.gut.findViewById(R.id.frs_top_ad_title);
        this.guu = (TextView) this.gut.findViewById(R.id.frs_top_person_num);
        this.gup = (TbImageView) this.gut.findViewById(R.id.frs_top_ad_img);
        this.gup.setDefaultBgResource(R.color.white_alpha100);
        this.guv = (FrsAdCommentScrollView) this.gut.findViewById(R.id.ad_comment_scroll_view);
        this.gut.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gur != null && !StringUtils.isNull(g.this.gur.getUrl())) {
                    ba.aGK().a((TbPageContext) com.baidu.adp.base.i.ab(g.this.mContext), new String[]{g.this.gur.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gur.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cx("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cx("obj_isad", "1");
                    if (g.this.gur.getType() == 1) {
                        i = 6;
                    } else if (g.this.gur.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gur.getType() == 3 ? 8 : 6;
                    }
                    anVar.X("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gur.getId());
                    anVar.X("obj_locate", 3);
                    anVar.X("obj_floor", 1);
                    if (g.this.dzq != null) {
                        anVar.cx("fid", g.this.dzq.getId());
                        anVar.cx("first_dir", g.this.dzq.getFirst_class());
                        anVar.cx("second_dir", g.this.dzq.getSecond_class());
                    }
                    if (g.this.gur.getType() == 1) {
                        anVar.cx("tid", g.this.gur.getThreadId());
                        anVar.X("thread_type", g.this.gur.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.gut;
    }

    public void onPrimary(boolean z) {
        if (this.guv != null) {
            this.guv.onPrimary(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.gup.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.dzq = forumData;
            this.gur = iVar;
            this.mTitleView.setText(this.gur.getTitle());
            if (iVar.getType() == 3) {
                this.guu.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gur.cKz())));
            } else if (iVar.getType() == 1) {
                this.guu.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gur.cKz())));
            } else if (iVar.getType() == 2) {
                this.guu.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gur.cKz())));
            }
            this.gup.startLoad(this.gur.getImg(), 10, false);
            if (this.guv != null) {
                this.guv.bf(this.gur.cKA());
            }
        }
    }

    public void onDestroy() {
        if (this.guv != null) {
            this.guv.onDestroy();
        }
    }
}
