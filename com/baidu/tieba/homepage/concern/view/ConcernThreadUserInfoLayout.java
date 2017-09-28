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
import com.baidu.tbadk.o.ac;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConcernThreadUserInfoLayout extends LinearLayout {
    private bh ajg;
    public ClickableHeaderImageView anE;
    public TextView anF;
    private boolean anI;
    private View.OnClickListener anJ;
    private View.OnClickListener anL;
    private UserIconBox aoa;
    private LinearLayout aog;
    private View.OnClickListener aoh;
    private TextView cWW;
    private TextView cWX;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajg.sz() == null || ConcernThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.sz().channelId, ConcernThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anJ != null) {
                        ConcernThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajg.sz() == null || ConcernThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.sz().channelId, ConcernThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anJ != null) {
                        ConcernThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.aoh = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aU(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.ajg.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vH().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anL = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.ajg != null && ConcernThreadUserInfoLayout.this.ajg.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.ajg.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aU(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.ajg.sz() == null || ConcernThreadUserInfoLayout.this.ajg.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.ajg.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.ajg.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.ajg.sz().channelId, ConcernThreadUserInfoLayout.this.ajg.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anJ != null) {
                        ConcernThreadUserInfoLayout.this.anJ.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.anE = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.aoa = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.aog = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.anF = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cWW = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cWX = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        wJ();
        this.aoa.setOnClickListener(this.aoh);
        this.anF.setOnClickListener(this.anL);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.ajg = bhVar;
        this.cWW.setText(bhVar.rT());
        l(bhVar);
        k(bhVar);
        R(bhVar);
        p(bhVar);
        setVisibility(0);
        return true;
    }

    private void wJ() {
        if (this.anE != null) {
            this.anE.setDefaultResource(17170445);
            this.anE.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.anE.setDefaultBgResource(d.e.cp_bg_line_e);
            this.anE.setIsRound(true);
            this.anE.setAfterClickListener(this.anJ);
        }
    }

    private void l(bh bhVar) {
        if (this.aoa != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.aoa.setVisibility(0);
                this.aoa.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.aoa.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.anF != null && bhVar != null) {
            if (!StringUtils.isNull(this.ajg.getAuthor().getName_show())) {
                this.anF.setText(am.e(this.ajg.getAuthor().getName_show(), 14, "..."));
            }
            wL();
            if (this.mFrom == 3) {
                String name_show = this.ajg.getAuthor().getName_show();
                String userName = this.ajg.getAuthor().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anF.setText(com.baidu.tieba.pb.c.aq(this.mContext, this.anF.getText().toString()));
                    this.anF.setGravity(16);
                    this.anF.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMD());
                    aj.c(this.anF, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void R(bh bhVar) {
        if (this.cWX != null && bhVar != null) {
            this.cWX.setVisibility(0);
            this.cWX.setText(am.q(bhVar.getCreateTime()));
        }
    }

    private void p(bh bhVar) {
        if (this.anE != null && bhVar != null && this.ajg.getAuthor() != null) {
            this.anE.setShowV(this.ajg.getAuthor().isBigV());
        }
    }

    private void wL() {
        if (this.ajg != null && this.ajg.getAuthor() != null) {
            if (!v.u(this.ajg.getAuthor().getTShowInfoNew()) || this.ajg.getAuthor().isBigV()) {
                aj.i(this.anF, d.e.cp_cont_h);
            } else {
                aj.i(this.anF, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wL();
        aj.i(this.cWX, d.e.cp_cont_d);
        aj.i(this.cWW, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.anI = z;
    }

    public boolean getIsSimpleThread() {
        return this.anI;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anJ = onClickListener;
        if (this.anE != null) {
            this.anE.setAfterClickListener(this.anJ);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.anE != null) {
            this.anE.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.anE;
    }
}
