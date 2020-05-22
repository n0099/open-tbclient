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
    private ForumData enm;
    private FrsAdCommentScrollView hsA;
    private TbImageView hsu;
    private i hsw;
    private RoundAdapterLinearLayout hsy;
    private TextView hsz;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hsy = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hsy.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hsy.findViewById(R.id.frs_top_ad_title);
        this.hsz = (TextView) this.hsy.findViewById(R.id.frs_top_person_num);
        this.hsu = (TbImageView) this.hsy.findViewById(R.id.frs_top_ad_img);
        this.hsu.setDefaultBgResource(R.color.white_alpha100);
        this.hsA = (FrsAdCommentScrollView) this.hsy.findViewById(R.id.ad_comment_scroll_view);
        this.hsy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hsw != null && !StringUtils.isNull(g.this.hsw.getUrl())) {
                    ba.aUZ().a((TbPageContext) com.baidu.adp.base.i.G(g.this.mContext), new String[]{g.this.hsw.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hsw.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.dh("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.dh("obj_isad", "1");
                    if (g.this.hsw.getType() == 1) {
                        i = 6;
                    } else if (g.this.hsw.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hsw.getType() == 3 ? 8 : 6;
                    }
                    anVar.ag("obj_adlocate", i);
                    anVar.s("obj_id", g.this.hsw.getId());
                    anVar.ag("obj_locate", 3);
                    anVar.ag("obj_floor", 1);
                    if (g.this.enm != null) {
                        anVar.dh("fid", g.this.enm.getId());
                        anVar.dh("first_dir", g.this.enm.getFirst_class());
                        anVar.dh("second_dir", g.this.enm.getSecond_class());
                    }
                    if (g.this.hsw.getType() == 1) {
                        anVar.dh("tid", g.this.hsw.getThreadId());
                        anVar.ag("thread_type", g.this.hsw.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.hsy;
    }

    public void bB(boolean z) {
        if (this.hsA != null) {
            this.hsA.bB(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hsu.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.enm = forumData;
            this.hsw = iVar;
            this.mTitleView.setText(this.hsw.getTitle());
            if (iVar.getType() == 3) {
                this.hsz.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hsw.dcx())));
            } else if (iVar.getType() == 1) {
                this.hsz.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hsw.dcx())));
            } else if (iVar.getType() == 2) {
                this.hsz.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hsw.dcx())));
            }
            this.hsu.startLoad(this.hsw.getImg(), 10, false);
            if (this.hsA != null) {
                this.hsA.bk(this.hsw.dcy());
            }
        }
    }

    public void onDestroy() {
        if (this.hsA != null) {
            this.hsA.onDestroy();
        }
    }
}
