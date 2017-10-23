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
    private bh aiU;
    private UserIconBox anO;
    private LinearLayout anU;
    private View.OnClickListener anV;
    public ClickableHeaderImageView ans;
    public TextView ant;
    private boolean anw;
    private View.OnClickListener anx;
    private View.OnClickListener anz;
    private TextView cWK;
    private TextView cWL;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.anV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiU.ss() == null || ConcernThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.ss().channelId, ConcernThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anx != null) {
                        ConcernThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.anV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiU.ss() == null || ConcernThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.ss().channelId, ConcernThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anx != null) {
                        ConcernThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.anV = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (ax.aT(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew() != null && v.c(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiU.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Y(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    av.vA().c((TbPageContext) i.Y(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anz = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiU != null && ConcernThreadUserInfoLayout.this.aiU.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiU.rt() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && ax.aT(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiU.ss() == null || ConcernThreadUserInfoLayout.this.aiU.ss().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiU.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiU.rt(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiU.ss().channelId, ConcernThreadUserInfoLayout.this.aiU.ss().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anx != null) {
                        ConcernThreadUserInfoLayout.this.anx.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.ans = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.anO = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.anU = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.ant = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cWK = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cWL = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        wC();
        this.anO.setOnClickListener(this.anV);
        this.ant.setOnClickListener(this.anz);
    }

    public boolean setData(bh bhVar) {
        if (bhVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiU = bhVar;
        this.cWK.setText(bhVar.rM());
        l(bhVar);
        k(bhVar);
        R(bhVar);
        p(bhVar);
        setVisibility(0);
        return true;
    }

    private void wC() {
        if (this.ans != null) {
            this.ans.setDefaultResource(17170445);
            this.ans.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.ans.setDefaultBgResource(d.e.cp_bg_line_e);
            this.ans.setIsRound(true);
            this.ans.setAfterClickListener(this.anx);
        }
    }

    private void l(bh bhVar) {
        if (this.anO != null && bhVar != null && bhVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = bhVar.getAuthor().getTShowInfoNew();
            if (v.t(tShowInfoNew) != 0) {
                this.anO.setVisibility(0);
                this.anO.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anO.setVisibility(8);
        }
    }

    private void k(bh bhVar) {
        if (this.ant != null && bhVar != null) {
            if (!StringUtils.isNull(this.aiU.getAuthor().getName_show())) {
                this.ant.setText(am.e(this.aiU.getAuthor().getName_show(), 14, "..."));
            }
            wE();
            if (this.mFrom == 3) {
                String name_show = this.aiU.getAuthor().getName_show();
                String userName = this.aiU.getAuthor().getUserName();
                if (ac.fS() && name_show != null && !name_show.equals(userName)) {
                    this.ant.setText(com.baidu.tieba.pb.c.al(this.mContext, this.ant.getText().toString()));
                    this.ant.setGravity(16);
                    this.ant.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aMy());
                    aj.c(this.ant, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void R(bh bhVar) {
        if (this.cWL != null && bhVar != null) {
            this.cWL.setVisibility(0);
            this.cWL.setText(am.r(bhVar.getCreateTime()));
        }
    }

    private void p(bh bhVar) {
        if (this.ans != null && bhVar != null && this.aiU.getAuthor() != null) {
            this.ans.setShowV(this.aiU.getAuthor().isBigV());
        }
    }

    private void wE() {
        if (this.aiU != null && this.aiU.getAuthor() != null) {
            if (!v.u(this.aiU.getAuthor().getTShowInfoNew()) || this.aiU.getAuthor().isBigV()) {
                aj.i(this.ant, d.e.cp_cont_h);
            } else {
                aj.i(this.ant, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        wE();
        aj.i(this.cWL, d.e.cp_cont_d);
        aj.i(this.cWK, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.anw = z;
    }

    public boolean getIsSimpleThread() {
        return this.anw;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anx = onClickListener;
        if (this.ans != null) {
            this.ans.setAfterClickListener(this.anx);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.ans != null) {
            this.ans.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.ans;
    }
}
