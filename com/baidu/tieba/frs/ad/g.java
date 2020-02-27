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
    private ForumData dyP;
    private RoundAdapterLinearLayout gtB;
    private TextView gtC;
    private FrsAdCommentScrollView gtD;
    private TbImageView gtw;
    private h gtz;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.gtB = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.gtB.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.gtB.setPadding(0, 0, 0, this.mContext.getResources().getDimensionPixelSize(R.dimen.tbds26));
        this.mTitleView = (TextView) this.gtB.findViewById(R.id.frs_top_ad_title);
        this.gtC = (TextView) this.gtB.findViewById(R.id.frs_top_person_num);
        this.gtw = (TbImageView) this.gtB.findViewById(R.id.frs_top_ad_img);
        this.gtw.setDefaultBgResource(R.color.white_alpha100);
        this.gtD = (FrsAdCommentScrollView) this.gtB.findViewById(R.id.ad_comment_scroll_view);
        this.gtB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.gtz != null && !StringUtils.isNull(g.this.gtz.getUrl())) {
                    ba.aGE().a((TbPageContext) i.ab(g.this.mContext), new String[]{g.this.gtz.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.gtz.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.cy("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.cy("obj_isad", "1");
                    if (g.this.gtz.getType() == 1) {
                        i = 6;
                    } else if (g.this.gtz.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.gtz.getType() == 3 ? 8 : 6;
                    }
                    anVar.X("obj_adlocate", i);
                    anVar.s("obj_id", g.this.gtz.getId());
                    anVar.X("obj_locate", 3);
                    anVar.X("obj_floor", 1);
                    if (g.this.dyP != null) {
                        anVar.cy("fid", g.this.dyP.getId());
                        anVar.cy("first_dir", g.this.dyP.getFirst_class());
                        anVar.cy("second_dir", g.this.dyP.getSecond_class());
                    }
                    if (g.this.gtz.getType() == 1) {
                        anVar.cy("tid", g.this.gtz.getThreadId());
                        anVar.X("thread_type", g.this.gtz.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.gtB;
    }

    public void onPrimary(boolean z) {
        if (this.gtD != null) {
            this.gtD.onPrimary(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.gtw.invalidate();
    }

    public void a(ForumData forumData, h hVar) {
        if (hVar != null) {
            this.dyP = forumData;
            this.gtz = hVar;
            this.mTitleView.setText(this.gtz.getTitle());
            if (hVar.getType() == 3) {
                this.gtC.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.gtz.cKc())));
            } else if (hVar.getType() == 1) {
                this.gtC.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.gtz.cKc())));
            } else if (hVar.getType() == 2) {
                this.gtC.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.gtz.cKc())));
            }
            this.gtw.startLoad(this.gtz.getImg(), 10, false);
            if (this.gtD != null) {
                this.gtD.bf(this.gtz.cKd());
            }
        }
    }

    public void onDestroy() {
        if (this.gtD != null) {
            this.gtD.onDestroy();
        }
    }
}
