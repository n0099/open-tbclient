package com.baidu.tieba.homepage.concern.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConcernThreadUserInfoLayout extends LinearLayout {
    private bj ajE;
    private UserIconBox aoQ;
    private LinearLayout aoV;
    private View.OnClickListener aoW;
    public ClickableHeaderImageView aop;
    public TextView aoq;
    private boolean aot;
    private View.OnClickListener aou;
    private View.OnClickListener aow;
    private TextView daq;
    private TextView dar;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajE.sF() == null || ConcernThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.sF().channelId, ConcernThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aou != null) {
                        ConcernThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajE.sF() == null || ConcernThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.sF().channelId, ConcernThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aou != null) {
                        ConcernThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.aoW = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajE.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aow = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajE != null && ConcernThreadUserInfoLayout.this.ajE.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajE.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajE.sF() == null || ConcernThreadUserInfoLayout.this.ajE.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajE.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajE.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajE.sF().channelId, ConcernThreadUserInfoLayout.this.ajE.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aou != null) {
                        ConcernThreadUserInfoLayout.this.aou.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.aop = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.aoQ = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.aoV = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.aoq = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.daq = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.dar = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        xl();
        this.aoQ.setOnClickListener(this.aoW);
        this.aoq.setOnClickListener(this.aow);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajE = bjVar;
        this.daq.setText(bjVar.rZ());
        o(bjVar);
        n(bjVar);
        W(bjVar);
        s(bjVar);
        setVisibility(0);
        return true;
    }

    private void xl() {
        if (this.aop != null) {
            this.aop.setDefaultResource(17170445);
            this.aop.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aop.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aop.setIsRound(true);
            this.aop.setAfterClickListener(this.aou);
        }
    }

    private void o(bj bjVar) {
        if (this.aoQ != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoQ.setVisibility(0);
                this.aoQ.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoQ.setVisibility(8);
        }
    }

    private void n(bj bjVar) {
        if (this.aoq != null && bjVar != null) {
            if (!StringUtils.isNull(this.ajE.getAuthor().getName_show())) {
                this.aoq.setText(am.e(this.ajE.getAuthor().getName_show(), 14, "..."));
            }
            xn();
            if (this.mFrom == 3) {
                String name_show = this.ajE.getAuthor().getName_show();
                String userName = this.ajE.getAuthor().getUserName();
                if (ac.fT() && name_show != null && !name_show.equals(userName)) {
                    this.aoq.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aoq.getText().toString()));
                    this.aoq.setGravity(16);
                    this.aoq.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOJ());
                    aj.c(this.aoq, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void W(bj bjVar) {
        if (this.dar != null && bjVar != null) {
            this.dar.setVisibility(0);
            this.dar.setText(am.r(bjVar.getCreateTime()));
        }
    }

    private void s(bj bjVar) {
        if (this.aop != null && bjVar != null && this.ajE.getAuthor() != null) {
            this.aop.setShowV(this.ajE.getAuthor().isBigV());
        }
    }

    private void xn() {
        if (this.ajE != null && this.ajE.getAuthor() != null) {
            if (!v.v(this.ajE.getAuthor().getTShowInfoNew()) || this.ajE.getAuthor().isBigV()) {
                aj.i(this.aoq, d.e.cp_cont_r);
            } else {
                aj.i(this.aoq, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xn();
        aj.i(this.dar, d.e.cp_cont_f);
        aj.i(this.daq, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.aot = z;
    }

    public boolean getIsSimpleThread() {
        return this.aot;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aou = onClickListener;
        if (this.aop != null) {
            this.aop.setAfterClickListener(this.aou);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aop != null) {
            this.aop.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aop;
    }
}
