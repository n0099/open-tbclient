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
    private View.OnClickListener aoH;
    public TbImageView aoV;
    private View.OnClickListener aoX;
    private boolean aoy;
    private View.OnClickListener beC;
    public ViewStub bgA;
    public TextView bgB;
    public TextView bgC;
    public TextView bgD;
    public TextView bgE;
    private bl bgF;
    private View.OnClickListener bgG;
    public ClickableHeaderImageView bgz;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.beC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoH != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoH.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.beC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoH != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoH.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.beC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgF.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgF != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgF.rK(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoH != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoH.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(d.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bgz = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bgA = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bgB = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.bgC = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bgE = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bgD = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bgz.setDefaultResource(17170445);
        this.bgz.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bgz.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bgz.setRadius(k.g(this.mContext, d.f.ds70));
    }

    public void x(bl blVar) {
        if (blVar != null) {
            this.bgF = blVar;
            if (!StringUtils.isNull(blVar.rK())) {
                this.bgC.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rK(), 5, true));
                this.bgC.setText(string);
                this.bgC.setContentDescription(string);
                this.bgC.setOnClickListener(this.bgG);
                this.bgC.setClickable(this.aoy);
            } else {
                this.bgC.setVisibility(8);
            }
            this.bgz.setVisibility(0);
            this.bgz.setData(this.bgF);
            this.bgz.setAfterClickListener(this.aoX);
            UserTbVipInfoData rF = this.bgF.rF();
            if (rF != null && rF.getvipV_url() != null && this.bgA != null) {
                if (this.aoV == null) {
                    this.bgA.inflate();
                    this.aoV = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.aoV.c(rF.getvipV_url(), 10, false);
                this.bgz.setIsBigV(true);
            }
            this.bgB.setVisibility(0);
            this.bgB.setOnClickListener(this.beC);
            if (this.bgF.getAuthor() != null) {
                this.bgB.setText(this.bgF.getAuthor().getName_show());
            }
            if (this.bgF.getThreadType() == 49) {
                this.bgD.setText(al.u(this.bgF.rX().audience_count));
                this.bgD.setMaxEms(9);
                this.bgE.setText(d.l.recommend_ala_live_comment_label);
                ai.i(this.bgD, d.e.cp_other_e);
            } else if (this.bgF.getThreadType() == 50) {
                this.bgD.setText(al.u(this.bgF.rW().play_count.intValue()));
                this.bgE.setText(d.l.recommend_ala_record_comment_label);
                ai.i(this.bgD, d.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.aoH = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.aoy = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoX = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        ai.i(this.bgC, d.e.cp_cont_c);
        ai.j(this.rootView, d.e.cp_bg_line_d);
        ai.i(this.bgB, d.e.cp_cont_f);
        if (this.bgF != null && this.bgF.getThreadType() == 49) {
            ai.i(this.bgD, d.e.cp_other_e);
        } else if (this.bgF != null && this.bgF.getThreadType() == 50) {
            ai.i(this.bgD, d.e.cp_cont_c);
        }
        ai.i(this.bgE, d.e.cp_cont_c);
    }
}
