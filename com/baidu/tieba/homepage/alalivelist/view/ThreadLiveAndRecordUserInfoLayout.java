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
import com.baidu.tbadk.core.data.bj;
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
    private boolean anT;
    private View.OnClickListener aoe;
    public TbImageView aou;
    private View.OnClickListener aow;
    private View.OnClickListener beA;
    public ClickableHeaderImageView bgC;
    public ViewStub bgD;
    public TextView bgE;
    public TextView bgF;
    public TextView bgG;
    public TextView bgH;
    private bj bgI;
    private View.OnClickListener bgJ;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.beA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aow != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.bgJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoe != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoe.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aow != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.bgJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoe != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoe.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beA = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgI.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aow != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        this.bgJ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgI != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgI.rG(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoe != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoe.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(d.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bgC = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bgD = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bgE = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.bgF = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bgH = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bgG = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bgC.setDefaultResource(17170445);
        this.bgC.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bgC.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bgC.setRadius(k.g(this.mContext, d.f.ds70));
    }

    public void A(bj bjVar) {
        if (bjVar != null) {
            this.bgI = bjVar;
            if (!StringUtils.isNull(bjVar.rG())) {
                this.bgF.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bjVar.rG(), 5, true));
                this.bgF.setText(string);
                this.bgF.setContentDescription(string);
                this.bgF.setOnClickListener(this.bgJ);
                this.bgF.setClickable(this.anT);
            } else {
                this.bgF.setVisibility(8);
            }
            this.bgC.setVisibility(0);
            this.bgC.setData(this.bgI);
            this.bgC.setAfterClickListener(this.aow);
            UserTbVipInfoData rB = this.bgI.rB();
            if (rB != null && rB.getvipV_url() != null && this.bgD != null) {
                if (this.aou == null) {
                    this.bgD.inflate();
                    this.aou = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.aou.c(rB.getvipV_url(), 10, false);
                this.bgC.setIsBigV(true);
            }
            this.bgE.setVisibility(0);
            this.bgE.setOnClickListener(this.beA);
            if (this.bgI.getAuthor() != null) {
                this.bgE.setText(this.bgI.getAuthor().getName_show());
            }
            if (this.bgI.getThreadType() == 49) {
                this.bgG.setText(am.u(this.bgI.rT().audience_count));
                this.bgG.setMaxEms(9);
                this.bgH.setText(d.l.recommend_ala_live_comment_label);
                aj.i(this.bgG, d.e.cp_other_e);
            } else if (this.bgI.getThreadType() == 50) {
                this.bgG.setText(am.u(this.bgI.rS().play_count.intValue()));
                this.bgH.setText(d.l.recommend_ala_record_comment_label);
                aj.i(this.bgG, d.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoe = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anT = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aow = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.i(this.bgF, d.e.cp_cont_c);
        aj.j(this.rootView, d.e.cp_bg_line_d);
        aj.i(this.bgE, d.e.cp_cont_f);
        if (this.bgI != null && this.bgI.getThreadType() == 49) {
            aj.i(this.bgG, d.e.cp_other_e);
        } else if (this.bgI != null && this.bgI.getThreadType() == 50) {
            aj.i(this.bgG, d.e.cp_cont_c);
        }
        aj.i(this.bgH, d.e.cp_cont_c);
    }
}
