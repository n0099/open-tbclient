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
    public TbImageView anH;
    private View.OnClickListener anJ;
    private boolean anf;
    private View.OnClickListener anr;
    private View.OnClickListener bgk;
    public ClickableHeaderImageView bin;
    public ViewStub bio;
    public TextView bip;
    public TextView biq;
    public TextView bir;
    public TextView bis;
    private bh bit;
    private View.OnClickListener biu;
    private Context mContext;
    private View rootView;

    public ThreadLiveAndRecordUserInfoLayout(Context context) {
        super(context);
        this.bgk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anJ != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.biu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bit.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anr != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bgk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anJ != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.biu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bit.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anr != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ThreadLiveAndRecordUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bgk = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor() != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getName_show()) && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId())) {
                    long c = com.baidu.adp.lib.g.b.c(ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().getUserId(), 0L);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createNormalConfig(c, c == com.baidu.adp.lib.g.b.c(TbadkCoreApplication.getCurrentAccount(), 0L), ThreadLiveAndRecordUserInfoLayout.this.bit.getAuthor().isBigV())));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anJ != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        this.biu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.ThreadLiveAndRecordUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ThreadLiveAndRecordUserInfoLayout.this.bit != null && !StringUtils.isNull(ThreadLiveAndRecordUserInfoLayout.this.bit.rA())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, new FrsActivityConfig(ThreadLiveAndRecordUserInfoLayout.this.mContext).createJumpLiveTabCfg(ThreadLiveAndRecordUserInfoLayout.this.bit.rA(), FrsActivityConfig.FRS_FROM_RECOMMEND, true)));
                    if (ThreadLiveAndRecordUserInfoLayout.this.anr != null) {
                        ThreadLiveAndRecordUserInfoLayout.this.anr.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        this.rootView = LayoutInflater.from(context).inflate(d.j.card_ala_live_user_layout, (ViewGroup) this, true);
        this.bin = (ClickableHeaderImageView) this.rootView.findViewById(d.h.imgAlaUserCover);
        this.bio = (ViewStub) this.rootView.findViewById(d.h.vsHeadImageMask);
        this.bip = (TextView) this.rootView.findViewById(d.h.tvAlaUserName);
        this.biq = (TextView) this.rootView.findViewById(d.h.tvBarName);
        this.bis = (TextView) this.rootView.findViewById(d.h.tvCommentLabel);
        this.bir = (TextView) this.rootView.findViewById(d.h.tvCommentNum);
        this.bin.setDefaultResource(17170445);
        this.bin.setDefaultErrorResource(d.g.icon_default_avatar100);
        this.bin.setDefaultBgResource(d.e.cp_bg_line_e);
        this.bin.setRadius(l.f(this.mContext, d.f.ds70));
    }

    public void w(bh bhVar) {
        if (bhVar != null) {
            this.bit = bhVar;
            if (!StringUtils.isNull(bhVar.rA())) {
                this.biq.setVisibility(0);
                String string = getContext().getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(bhVar.rA(), 5, true));
                this.biq.setText(string);
                this.biq.setContentDescription(string);
                this.biq.setOnClickListener(this.biu);
                this.biq.setClickable(this.anf);
            } else {
                this.biq.setVisibility(8);
            }
            this.bin.setVisibility(0);
            this.bin.setData(this.bit);
            this.bin.setAfterClickListener(this.anJ);
            UserTbVipInfoData rv = this.bit.rv();
            if (rv != null && rv.getvipV_url() != null && this.bio != null) {
                if (this.anH == null) {
                    this.bio.inflate();
                    this.anH = (TbImageView) this.rootView.findViewById(d.h.user_head_mask);
                }
                this.anH.c(rv.getvipV_url(), 10, false);
                this.bin.setIsBigV(true);
            }
            this.bip.setVisibility(0);
            this.bip.setOnClickListener(this.bgk);
            if (this.bit.getAuthor() != null) {
                this.bip.setText(this.bit.getAuthor().getName_show());
            }
            if (this.bit.getThreadType() == 49) {
                this.bir.setText(am.t(this.bit.rN().audience_count));
                this.bir.setMaxEms(9);
                this.bis.setText(d.l.recommend_ala_live_comment_label);
                aj.i(this.bir, d.e.cp_other_e);
            } else if (this.bit.getThreadType() == 50) {
                this.bir.setText(am.t(this.bit.rM().play_count.intValue()));
                this.bis.setText(d.l.recommend_ala_record_comment_label);
                aj.i(this.bir, d.e.cp_cont_c);
            }
        }
    }

    public void setForumAfterClickListener(View.OnClickListener onClickListener) {
        this.anr = onClickListener;
    }

    public void setBarNameClickEnabled(boolean z) {
        this.anf = z;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anJ = onClickListener;
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        aj.i(this.biq, d.e.cp_cont_c);
        aj.j(this.rootView, d.e.cp_bg_line_d);
        aj.i(this.bip, d.e.cp_cont_f);
        if (this.bit != null && this.bit.getThreadType() == 49) {
            aj.i(this.bir, d.e.cp_other_e);
        } else if (this.bit != null && this.bit.getThreadType() == 50) {
            aj.i(this.bir, d.e.cp_cont_c);
        }
        aj.i(this.bis, d.e.cp_cont_c);
    }
}
