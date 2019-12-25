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
/* loaded from: classes6.dex */
public class g {
    private ForumData duz;
    private TbImageView gom;
    private h gop;
    private RoundAdapterLinearLayout gor;
    private TextView gos;
    private FrsAdCommentScrollView got;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.gor = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.gor.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.gor.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.gor.findViewById(R.id.frs_top_ad_title);
        this.gos = (TextView) this.gor.findViewById(R.id.frs_top_person_num);
        this.gom = (TbImageView) this.gor.findViewById(R.id.frs_top_ad_img);
        this.gom.setDefaultBgResource(R.color.white_alpha100);
        this.got = (FrsAdCommentScrollView) this.gor.findViewById(R.id.ad_comment_scroll_view);
        this.gor.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gop != null && !StringUtils.isNull(g.this.gop.getUrl())) {
                    ba.aEa().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.gop.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gop.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cp("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cp("obj_isad", "1");
                    if (g.this.gop.getType() == 1) {
                        i = 6;
                    } else if (g.this.gop.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gop.getType() == 3 ? 8 : 6;
                    }
                    anVar.Z("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gop.getId());
                    anVar.Z("obj_locate", 3);
                    anVar.Z("obj_floor", 1);
                    if (g.this.duz != null) {
                        anVar.cp("fid", g.this.duz.getId());
                        anVar.cp("first_dir", g.this.duz.getFirst_class());
                        anVar.cp("second_dir", g.this.duz.getSecond_class());
                    }
                    if (g.this.gop.getType() == 1) {
                        anVar.cp("tid", g.this.gop.getThreadId());
                        anVar.Z("thread_type", g.this.gop.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.gor;
    }

    public void kV(boolean z) {
        if (this.got != null) {
            this.got.kV(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.gom.invalidate();
    }

    public void a(ForumData forumData, h hVar) {
        if (hVar != null) {
            this.duz = forumData;
            this.gop = hVar;
            this.mTitleView.setText(this.gop.getTitle());
            if (hVar.getType() == 3) {
                this.gos.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gop.cHs())));
            } else if (hVar.getType() == 1) {
                this.gos.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gop.cHs())));
            } else if (hVar.getType() == 2) {
                this.gos.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gop.cHs())));
            }
            this.gom.startLoad(this.gop.avi(), 10, false);
            if (this.got != null) {
                this.got.bg(this.gop.cHt());
            }
        }
    }

    public void onDestroy() {
        if (this.got != null) {
            this.got.onDestroy();
        }
    }
}
