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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class ThreadLiveAndRecordUserInfoLayout extends LinearLayout {
    public TbImageView anB;
    private View.OnClickListener anD;
    private boolean ane;
    private View.OnClickListener ann;
    private View.OnClickListener bdr;
    public ClickableHeaderImageView bfo;
    public ViewStub bfp;
    public TextView bfq;
    public TextView bfr;
    public TextView bfs;
    public TextView bft;
    private bl bfu;
    private View.OnClickListener bfv;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anD != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.bfv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.ann != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.ann.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anD != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.bfv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.ann != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.ann.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bdr = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bfu.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anD != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        this.bfv = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bfu != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bfu.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.ann != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.ann.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(d.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bfo = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bfp = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bfq = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.bfr = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bft = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bfs = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bfo.setDefaultResource(17170445);
        this.bfo.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bfo.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bfo.setRadius(k.g(this.mContext, d.f.ds70));
    }

    public void x(bl blVar) {
        if (blVar != null) {
            this.bfu = blVar;
            if (!StringUtils.isNull(blVar.rA())) {
                this.bfr.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rA(), 5, true));
                this.bfr.setText(string);
                this.bfr.setContentDescription(string);
                this.bfr.setOnClickListener(this.bfv);
                this.bfr.setClickable(this.ane);
            } else {
                this.bfr.setVisibility(8);
            }
            this.bfo.setVisibility(0);
            this.bfo.setData(this.bfu);
            this.bfo.setAfterClickListener(this.anD);
            UserTbVipInfoData rv = this.bfu.rv();
            if (rv != null && rv.getvipV_url() != null && this.bfp != null) {
                if (this.anB == null) {
                    this.bfp.inflate();
                    this.anB = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.anB.c(rv.getvipV_url(), 10, false);
                this.bfo.setIsBigV(true);
            }
            this.bfq.setVisibility(0);
            this.bfq.setOnClickListener(this.bdr);
            if (this.bfu.getAuthor() != null) {
                this.bfq.setText(this.bfu.getAuthor().getName_show());
            }
            if (this.bfu.getThreadType() == 49) {
                this.bfs.setText(al.u(this.bfu.rN().audience_count));
                this.bfs.setMaxEms(9);
                this.bft.setText(d.l.recommend_ala_live_comment_label);
                ai.i(this.bfs, d.e.cp_other_e);
            } else if (this.bfu.getThreadType() == 50) {
                this.bfs.setText(al.u(this.bfu.rM().play_count.intValue()));
                this.bft.setText(d.l.recommend_ala_record_comment_label);
                ai.i(this.bfs, d.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.ann = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.ane = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anD = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.i(this.bfr, d.e.cp_cont_c);
        ai.j(this.rootView, d.e.cp_bg_line_d);
        ai.i(this.bfq, d.e.cp_cont_f);
        if (this.bfu != null && this.bfu.getThreadType() == 49) {
            ai.i(this.bfs, d.e.cp_other_e);
        } else if (this.bfu != null && this.bfu.getThreadType() == 50) {
            ai.i(this.bfs, d.e.cp_cont_c);
        }
        ai.i(this.bft, d.e.cp_cont_c);
    }
}
