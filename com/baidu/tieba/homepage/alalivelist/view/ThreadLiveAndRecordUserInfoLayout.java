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
    private View.OnClickListener beD;
    public ClickableHeaderImageView bgA;
    public ViewStub bgB;
    public TextView bgC;
    public TextView bgD;
    public TextView bgE;
    public TextView bgF;
    private bl bgG;
    private View.OnClickListener bgH;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.beD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
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
        this.beD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
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
        this.beD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId())) {
                    long d = com.baidu.adp.lib.g.b.d(ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(d, d == com.baidu.adp.lib.g.b.d(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bgG.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.aoX != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        this.bgH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bgG != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bgG.rL(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
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
        this.bgA = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bgB = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bgC = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.bgD = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bgF = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bgE = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bgA.setDefaultResource(17170445);
        this.bgA.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bgA.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bgA.setRadius(k.g(this.mContext, d.f.ds70));
    }

    public void x(bl blVar) {
        if (blVar != null) {
            this.bgG = blVar;
            if (!StringUtils.isNull(blVar.rL())) {
                this.bgD.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(blVar.rL(), 5, true));
                this.bgD.setText(string);
                this.bgD.setContentDescription(string);
                this.bgD.setOnClickListener(this.bgH);
                this.bgD.setClickable(this.aoy);
            } else {
                this.bgD.setVisibility(8);
            }
            this.bgA.setVisibility(0);
            this.bgA.setData(this.bgG);
            this.bgA.setAfterClickListener(this.aoX);
            UserTbVipInfoData rG = this.bgG.rG();
            if (rG != null && rG.getvipV_url() != null && this.bgB != null) {
                if (this.aoV == null) {
                    this.bgB.inflate();
                    this.aoV = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.aoV.c(rG.getvipV_url(), 10, false);
                this.bgA.setIsBigV(true);
            }
            this.bgC.setVisibility(0);
            this.bgC.setOnClickListener(this.beD);
            if (this.bgG.getAuthor() != null) {
                this.bgC.setText(this.bgG.getAuthor().getName_show());
            }
            if (this.bgG.getThreadType() == 49) {
                this.bgE.setText(al.u(this.bgG.rY().audience_count));
                this.bgE.setMaxEms(9);
                this.bgF.setText(d.l.recommend_ala_live_comment_label);
                ai.i(this.bgE, d.e.cp_other_e);
            } else if (this.bgG.getThreadType() == 50) {
                this.bgE.setText(al.u(this.bgG.rX().play_count.intValue()));
                this.bgF.setText(d.l.recommend_ala_record_comment_label);
                ai.i(this.bgE, d.e.cp_cont_c);
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
        ai.i(this.bgD, d.e.cp_cont_c);
        ai.j(this.rootView, d.e.cp_bg_line_d);
        ai.i(this.bgC, d.e.cp_cont_f);
        if (this.bgG != null && this.bgG.getThreadType() == 49) {
            ai.i(this.bgE, d.e.cp_other_e);
        } else if (this.bgG != null && this.bgG.getThreadType() == 50) {
            ai.i(this.bgE, d.e.cp_cont_c);
        }
        ai.i(this.bgF, d.e.cp_cont_c);
    }
}
