package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    private boolean amT;
    private View.OnClickListener anf;
    public TbImageView anv;
    private View.OnClickListener anx;
    private View.OnClickListener bfW;
    public ClickableHeaderImageView bhX;
    public ViewStub bhY;
    public TextView bhZ;
    public TextView bia;
    public TextView bib;
    public TextView bic;
    private bh bie;
    private View.OnClickListener bif;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bfW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anx != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.bif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.rt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bie.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anf != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anf.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bfW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anx != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.bif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.rt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bie.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anf != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anf.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bfW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bie.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anx != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        this.bif = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bie != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bie.rt())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bie.rt(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anf != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anf.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(d.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bhX = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bhY = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bhZ = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.bia = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bic = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bib = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bhX.setDefaultResource(17170445);
        this.bhX.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bhX.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bhX.setRadius(l.f(this.mContext, d.f.ds70));
    }

    public void w(bh bhVar) {
        if (bhVar != null) {
            this.bie = bhVar;
            if (!StringUtils.isNull(bhVar.rt())) {
                this.bia.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rt(), 5, true));
                this.bia.setText(string);
                this.bia.setContentDescription(string);
                this.bia.setOnClickListener(this.bif);
                this.bia.setClickable(this.amT);
            } else {
                this.bia.setVisibility(8);
            }
            this.bhX.setVisibility(0);
            this.bhX.setData(this.bie);
            this.bhX.setAfterClickListener(this.anx);
            UserTbVipInfoData ro = this.bie.ro();
            if (ro != null && ro.getvipV_url() != null && this.bhY != null) {
                if (this.anv == null) {
                    this.bhY.inflate();
                    this.anv = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.anv.c(ro.getvipV_url(), 10, false);
                this.bhX.setIsBigV(true);
            }
            this.bhZ.setVisibility(0);
            this.bhZ.setOnClickListener(this.bfW);
            if (this.bie.getAuthor() != null) {
                this.bhZ.setText(this.bie.getAuthor().getName_show());
            }
            if (this.bie.getThreadType() == 49) {
                this.bib.setText(am.u(this.bie.rG().audience_count));
                this.bib.setMaxEms(9);
                this.bic.setText(d.l.recommend_ala_live_comment_label);
                aj.i(this.bib, d.e.cp_other_e);
            } else if (this.bie.getThreadType() == 50) {
                this.bib.setText(am.u(this.bie.rF().play_count.intValue()));
                this.bic.setText(d.l.recommend_ala_record_comment_label);
                aj.i(this.bib, d.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anf = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.amT = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.i(this.bia, d.e.cp_cont_c);
        aj.j(this.rootView, d.e.cp_bg_line_d);
        aj.i(this.bhZ, d.e.cp_cont_f);
        if (this.bie != null && this.bie.getThreadType() == 49) {
            aj.i(this.bib, d.e.cp_other_e);
        } else if (this.bie != null && this.bie.getThreadType() == 50) {
            aj.i(this.bib, d.e.cp_cont_c);
        }
        aj.i(this.bic, d.e.cp_cont_c);
    }
}
