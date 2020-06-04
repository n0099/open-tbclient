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
    private TbImageView hsF;
    private i hsH;
    private RoundAdapterLinearLayout hsJ;
    private TextView hsK;
    private FrsAdCommentScrollView hsL;
    private Context mContext;
    private TextView mTitleView;

    public g(Context context) {
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.hsJ = (RoundAdapterLinearLayout) LayoutInflater.from(this.mContext).inflate(R.layout.frs_top_ad_view, (ViewGroup) null);
        this.hsJ.setRadius(this.mContext.getResources().getDimension(R.dimen.tbds20));
        this.mTitleView = (TextView) this.hsJ.findViewById(R.id.frs_top_ad_title);
        this.hsK = (TextView) this.hsJ.findViewById(R.id.frs_top_person_num);
        this.hsF = (TbImageView) this.hsJ.findViewById(R.id.frs_top_ad_img);
        this.hsF.setDefaultBgResource(R.color.white_alpha100);
        this.hsL = (FrsAdCommentScrollView) this.hsJ.findViewById(R.id.ad_comment_scroll_view);
        this.hsJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.ad.g.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i;
                if (g.this.hsH != null && !StringUtils.isNull(g.this.hsH.getUrl())) {
                    ba.aVa().a((TbPageContext) com.baidu.adp.base.i.G(g.this.mContext), new String[]{g.this.hsH.getUrl()}, true);
                    HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_BUSSINESS_PROMOT_CLICK);
                    httpMessage.addParam("id", g.this.hsH.getId());
                    MessageManager.getInstance().sendMessage(httpMessage);
                    an anVar = new an("common_click");
                    anVar.dh("page_type", PageStayDurationConstants.PageName.FRS);
                    anVar.dh("obj_isad", "1");
                    if (g.this.hsH.getType() == 1) {
                        i = 6;
                    } else if (g.this.hsH.getType() == 2) {
                        i = 7;
                    } else {
                        i = g.this.hsH.getType() == 3 ? 8 : 6;
                    }
                    anVar.ag("obj_adlocate", i);
                    anVar.s("obj_id", g.this.hsH.getId());
                    anVar.ag("obj_locate", 3);
                    anVar.ag("obj_floor", 1);
                    if (g.this.enm != null) {
                        anVar.dh("fid", g.this.enm.getId());
                        anVar.dh("first_dir", g.this.enm.getFirst_class());
                        anVar.dh("second_dir", g.this.enm.getSecond_class());
                    }
                    if (g.this.hsH.getType() == 1) {
                        anVar.dh("tid", g.this.hsH.getThreadId());
                        anVar.ag("thread_type", g.this.hsH.getThreadType());
                    }
                    TiebaStatic.log(anVar);
                }
            }
        });
    }

    public View getView() {
        return this.hsJ;
    }

    public void bB(boolean z) {
        if (this.hsL != null) {
            this.hsL.bB(z);
        }
    }

    public void onChangeSkinType(int i) {
        this.hsF.invalidate();
    }

    public void a(ForumData forumData, i iVar) {
        if (iVar != null) {
            this.enm = forumData;
            this.hsH = iVar;
            this.mTitleView.setText(this.hsH.getTitle());
            if (iVar.getType() == 3) {
                this.hsK.setText(this.mContext.getString(R.string.frs_top_ad_download_num, Integer.valueOf(this.hsH.dcM())));
            } else if (iVar.getType() == 1) {
                this.hsK.setText(this.mContext.getString(R.string.frs_top_ad_person_num, Integer.valueOf(this.hsH.dcM())));
            } else if (iVar.getType() == 2) {
                this.hsK.setText(this.mContext.getString(R.string.frs_top_ad_appointment_num, Integer.valueOf(this.hsH.dcM())));
            }
            this.hsF.startLoad(this.hsH.getImg(), 10, false);
            if (this.hsL != null) {
                this.hsL.bk(this.hsH.dcN());
            }
        }
    }

    public void onDestroy() {
        if (this.hsL != null) {
            this.hsL.onDestroy();
        }
    }
}
