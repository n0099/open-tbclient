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
/* loaded from: classes7.dex */
public class g {
    private ForumData duJ;
    private RoundAdapterLinearLayout grA;
    private TextView grB;
    private FrsAdCommentScrollView grC;
    private TbImageView grv;
    private h gry;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.grA = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.grA.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.grA.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.grA.findViewById(R.id.frs_top_ad_title);
        this.grB = (TextView) this.grA.findViewById(R.id.frs_top_person_num);
        this.grv = (TbImageView) this.grA.findViewById(R.id.frs_top_ad_img);
        this.grv.setDefaultBgResource(R.color.white_alpha100);
        this.grC = (FrsAdCommentScrollView) this.grA.findViewById(R.id.ad_comment_scroll_view);
        this.grA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gry != null && !StringUtils.isNull(g.this.gry.getUrl())) {
                    ba.aEt().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.gry.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gry.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cp("obj_isad", "1");
                    if (g.this.gry.getType() == 1) {
                        i = 6;
                    } else if (g.this.gry.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gry.getType() == 3 ? 8 : 6;
                    }
                    anVar.Z("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gry.getId());
                    anVar.Z("obj_locate", 3);
                    anVar.Z("obj_floor", 1);
                    if (g.this.duJ != null) {
                        anVar.cp("fid", g.this.duJ.getId());
                        anVar.cp("first_dir", g.this.duJ.getFirst_class());
                        anVar.cp("second_dir", g.this.duJ.getSecond_class());
                    }
                    if (g.this.gry.getType() == 1) {
                        anVar.cp("tid", g.this.gry.getThreadId());
                        anVar.Z("thread_type", g.this.gry.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.grA;
    }

    public void lg(boolean z) {
        if (this.grC != null) {
            this.grC.lg(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.grv.invalidate();
    }

    public void a(ForumData forumData, h hVar) {
        if (hVar != null) {
            this.duJ = forumData;
            this.gry = hVar;
            this.mTitleView.setText(this.gry.getTitle());
            if (hVar.getType() == 3) {
                this.grB.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gry.cIw())));
            } else if (hVar.getType() == 1) {
                this.grB.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gry.cIw())));
            } else if (hVar.getType() == 2) {
                this.grB.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gry.cIw())));
            }
            this.grv.startLoad(this.gry.avB(), 10, false);
            if (this.grC != null) {
                this.grC.bf(this.gry.cIx());
            }
        }
    }

    public void onDestroy() {
        if (this.grC != null) {
            this.grC.onDestroy();
        }
    }
}
