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
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.p.ab;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ConcernThreadUserInfoLayout extends LinearLayout {
    private bl akj;
    public ClickableHeaderImageView aoR;
    public TextView aoS;
    private boolean aoV;
    private View.OnClickListener aoW;
    private View.OnClickListener aoX;
    private UserIconBox apm;
    private LinearLayout aps;
    private View.OnClickListener apt;
    private TextView cQU;
    private TextView cQV;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akj.sJ() == null || ConcernThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.sJ().channelId, ConcernThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoW != null) {
                        ConcernThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akj.sJ() == null || ConcernThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.sJ().channelId, ConcernThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoW != null) {
                        ConcernThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.apt = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akj.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoX = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akj != null && ConcernThreadUserInfoLayout.this.akj.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akj.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akj.sJ() == null || ConcernThreadUserInfoLayout.this.akj.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akj.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akj.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akj.sJ().channelId, ConcernThreadUserInfoLayout.this.akj.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoW != null) {
                        ConcernThreadUserInfoLayout.this.aoW.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.aoR = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.apm = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.aps = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.aoS = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cQU = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cQV = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        xj();
        this.apm.setOnClickListener(this.apt);
        this.aoS.setOnClickListener(this.aoX);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akj = blVar;
        this.cQU.setText(blVar.sd());
        l(blVar);
        k(blVar);
        R(blVar);
        p(blVar);
        setVisibility(0);
        return true;
    }

    private void xj() {
        if (this.aoR != null) {
            this.aoR.setDefaultResource(17170445);
            this.aoR.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoR.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoR.setIsRound(true);
            this.aoR.setAfterClickListener(this.aoW);
        }
    }

    private void l(bl blVar) {
        if (this.apm != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apm.setVisibility(0);
                this.apm.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apm.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.aoS != null && blVar != null) {
            if (!StringUtils.isNull(this.akj.getAuthor().getName_show())) {
                this.aoS.setText(al.d(this.akj.getAuthor().getName_show(), 14, "..."));
            }
            xl();
            if (this.mFrom == 3) {
                String name_show = this.akj.getAuthor().getName_show();
                String userName = this.akj.getAuthor().getUserName();
                if (ab.ge() && name_show != null && !name_show.equals(userName)) {
                    this.aoS.setText(com.baidu.tieba.pb.c.ao(this.mContext, this.aoS.getText().toString()));
                    this.aoS.setGravity(16);
                    this.aoS.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.c.aOK());
                    ai.c(this.aoS, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void R(bl blVar) {
        if (this.cQV != null && blVar != null) {
            this.cQV.setVisibility(0);
            this.cQV.setText(al.r(blVar.getCreateTime()));
        }
    }

    private void p(bl blVar) {
        if (this.aoR != null && blVar != null && this.akj.getAuthor() != null) {
            this.aoR.setShowV(this.akj.getAuthor().isBigV());
        }
    }

    private void xl() {
        if (this.akj != null && this.akj.getAuthor() != null) {
            if (!u.v(this.akj.getAuthor().getTShowInfoNew()) || this.akj.getAuthor().isBigV()) {
                ai.i(this.aoS, d.e.cp_cont_r);
            } else {
                ai.i(this.aoS, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xl();
        ai.i(this.cQV, d.e.cp_cont_f);
        ai.i(this.cQU, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoV = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoV;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoW = onClickListener;
        if (this.aoR != null) {
            this.aoR.setAfterClickListener(this.aoW);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoR != null) {
            this.aoR.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aoR;
    }
}
