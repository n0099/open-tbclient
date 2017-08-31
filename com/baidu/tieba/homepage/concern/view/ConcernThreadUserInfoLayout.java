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
    private bj ajF;
    private UserIconBox aoS;
    private LinearLayout aoX;
    private View.OnClickListener aoY;
    public ClickableHeaderImageView aor;
    public TextView aos;
    private boolean aov;
    private View.OnClickListener aow;
    private View.OnClickListener aoy;
    private TextView cZw;
    private TextView cZx;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.X(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.X(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajF.sF() == null || ConcernThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.sF().channelId, ConcernThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aow != null) {
                        ConcernThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.X(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.X(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajF.sF() == null || ConcernThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.sF().channelId, ConcernThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aow != null) {
                        ConcernThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajF.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.X(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    au.wd().c((TbPageContext) i.X(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoy = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajF != null && ConcernThreadUserInfoLayout.this.ajF.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajF.rG() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajF.sF() == null || ConcernThreadUserInfoLayout.this.ajF.sF().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajF.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajF.rG(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajF.sF().channelId, ConcernThreadUserInfoLayout.this.ajF.sF().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aow != null) {
                        ConcernThreadUserInfoLayout.this.aow.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.aor = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.aoS = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.aoX = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.aos = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cZw = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cZx = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        xl();
        this.aoS.setOnClickListener(this.aoY);
        this.aos.setOnClickListener(this.aoy);
    }

    public boolean c(bj bjVar) {
        if (bjVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajF = bjVar;
        this.cZw.setText(bjVar.rZ());
        o(bjVar);
        n(bjVar);
        W(bjVar);
        s(bjVar);
        setVisibility(0);
        return true;
    }

    private void xl() {
        if (this.aor != null) {
            this.aor.setDefaultResource(17170445);
            this.aor.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aor.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aor.setIsRound(true);
            this.aor.setAfterClickListener(this.aow);
        }
    }

    private void o(bj bjVar) {
        if (this.aoS != null && bjVar != null && bjVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bjVar.getAuthor().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoS.setVisibility(0);
                this.aoS.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoS.setVisibility(8);
        }
    }

    private void n(bj bjVar) {
        if (this.aos != null && bjVar != null) {
            if (!StringUtils.isNull(this.ajF.getAuthor().getName_show())) {
                this.aos.setText(am.e(this.ajF.getAuthor().getName_show(), 14, "..."));
            }
            xn();
            if (this.mFrom == 3) {
                String name_show = this.ajF.getAuthor().getName_show();
                String userName = this.ajF.getAuthor().getUserName();
                if (ac.fT() && name_show != null && !name_show.equals(userName)) {
                    this.aos.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aos.getText().toString()));
                    this.aos.setGravity(16);
                    this.aos.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOy());
                    aj.c(this.aos, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void W(bj bjVar) {
        if (this.cZx != null && bjVar != null) {
            this.cZx.setVisibility(0);
            this.cZx.setText(am.r(bjVar.getCreateTime()));
        }
    }

    private void s(bj bjVar) {
        if (this.aor != null && bjVar != null && this.ajF.getAuthor() != null) {
            this.aor.setShowV(this.ajF.getAuthor().isBigV());
        }
    }

    private void xn() {
        if (this.ajF != null && this.ajF.getAuthor() != null) {
            if (!v.v(this.ajF.getAuthor().getTShowInfoNew()) || this.ajF.getAuthor().isBigV()) {
                aj.i(this.aos, d.e.cp_cont_r);
            } else {
                aj.i(this.aos, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xn();
        aj.i(this.cZx, d.e.cp_cont_f);
        aj.i(this.cZw, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.aov = z;
    }

    public boolean getIsSimpleThread() {
        return this.aov;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aow = onClickListener;
        if (this.aor != null) {
            this.aor.setAfterClickListener(this.aow);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aor != null) {
            this.aor.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aor;
    }
}
