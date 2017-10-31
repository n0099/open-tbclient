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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
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
    private bh ajq;
    public ClickableHeaderImageView anN;
    public TextView anO;
    private boolean anR;
    private View.OnClickListener anS;
    private View.OnClickListener anU;
    private UserIconBox aoj;
    private LinearLayout aop;
    private View.OnClickListener aoq;
    private TextView dfb;
    private TextView dfc;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getUserId()) && ConcernThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajq.sz() == null || ConcernThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.rt().getUserId(), ConcernThreadUserInfoLayout.this.ajq.rt().getName_show(), ConcernThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.sz().channelId, ConcernThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anS != null) {
                        ConcernThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getUserId()) && ConcernThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajq.sz() == null || ConcernThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.rt().getUserId(), ConcernThreadUserInfoLayout.this.ajq.rt().getName_show(), ConcernThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.sz().channelId, ConcernThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anS != null) {
                        ConcernThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.aoq = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajq.rt().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vI().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anU = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajq != null && ConcernThreadUserInfoLayout.this.ajq.rt() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajq.rt().getUserId()) && ConcernThreadUserInfoLayout.this.ajq.rz() != null) {
                    if (view.getTag(d.g.tag_nick_name_activity) != null && (view.getTag(d.g.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.g.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajq.sz() == null || ConcernThreadUserInfoLayout.this.ajq.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.rt().getUserId(), ConcernThreadUserInfoLayout.this.ajq.rt().getName_show(), ConcernThreadUserInfoLayout.this.ajq.rz(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajq.sz().channelId, ConcernThreadUserInfoLayout.this.ajq.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anS != null) {
                        ConcernThreadUserInfoLayout.this.anS.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.h.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.anN = (ClickableHeaderImageView) inflate.findViewById(d.g.card_concern_normal_thread_user_header);
        this.aoj = (UserIconBox) inflate.findViewById(d.g.card_concern_normal_thread_tshow_icon);
        this.aop = (LinearLayout) inflate.findViewById(d.g.card_concern_normal_thread_user_info);
        this.anO = (TextView) inflate.findViewById(d.g.card_concern_normal_thread_user_name);
        this.dfb = (TextView) inflate.findViewById(d.g.card_concern_normal_thread_event);
        this.dfc = (TextView) inflate.findViewById(d.g.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        wJ();
        this.aoj.setOnClickListener(this.aoq);
        this.anO.setOnClickListener(this.anU);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajq = bhVar;
        this.dfb.setText(bhVar.rS());
        l(bhVar);
        k(bhVar);
        T(bhVar);
        p(bhVar);
        setVisibility(0);
        return true;
    }

    private void wJ() {
        if (this.anN != null) {
            this.anN.setDefaultResource(17170445);
            this.anN.setDefaultErrorResource(d.f.icon_default_avatar100);
            this.anN.setDefaultBgResource(d.C0080d.cp_bg_line_e);
            this.anN.setIsRound(true);
            this.anN.setAfterClickListener(this.anS);
        }
    }

    private void l(bh bhVar) {
        if (this.aoj != null && bhVar != null && bhVar.rt() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.rt().getTShowInfoNew();
            if (v.u(tShowInfoNew) != 0) {
                this.aoj.setVisibility(0);
                this.aoj.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds36), this.mContext.getResources().getDimensionPixelSize(d.e.ds8), true);
                return;
            }
            this.aoj.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.anO != null && bhVar != null) {
            if (!StringUtils.isNull(this.ajq.rt().getName_show())) {
                this.anO.setText(am.e(this.ajq.rt().getName_show(), 14, "..."));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajq.rt().getName_show();
                String userName = this.ajq.rt().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anO.setText(com.baidu.tieba.pb.c.al(this.mContext, this.anO.getText().toString()));
                    this.anO.setGravity(16);
                    this.anO.setTag(d.g.tag_nick_name_activity, com.baidu.tieba.pb.c.aPq());
                    aj.c(this.anO, d.C0080d.cp_other_e, 1);
                }
            }
        }
    }

    private void T(bh bhVar) {
        if (this.dfc != null && bhVar != null) {
            this.dfc.setVisibility(0);
            this.dfc.setText(am.r(bhVar.getCreateTime()));
        }
    }

    private void p(bh bhVar) {
        if (this.anN != null && bhVar != null && this.ajq.rt() != null) {
            this.anN.setShowV(this.ajq.rt().isBigV());
        }
    }

    private void wL() {
        if (this.ajq != null && this.ajq.rt() != null) {
            if (!v.v(this.ajq.rt().getTShowInfoNew()) || this.ajq.rt().isBigV()) {
                aj.i(this.anO, d.C0080d.cp_cont_h);
            } else {
                aj.i(this.anO, d.C0080d.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.dfc, d.C0080d.cp_cont_d);
        aj.i(this.dfb, d.C0080d.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.anR = z;
    }

    public boolean getIsSimpleThread() {
        return this.anR;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anS = onClickListener;
        if (this.anN != null) {
            this.anN.setAfterClickListener(this.anS);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anN != null) {
            this.anN.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anN;
    }
}
