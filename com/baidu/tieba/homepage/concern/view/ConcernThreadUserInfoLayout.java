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
    private bl aiQ;
    private boolean anC;
    private View.OnClickListener anD;
    private View.OnClickListener anE;
    private UserIconBox anT;
    private LinearLayout anY;
    private View.OnClickListener anZ;
    public ClickableHeaderImageView any;
    public TextView anz;
    private TextView cPB;
    private TextView cPC;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Z(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) i.Z(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiQ.sz() == null || ConcernThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.sz().channelId, ConcernThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anD != null) {
                        ConcernThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Z(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) i.Z(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiQ.sz() == null || ConcernThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.sz().channelId, ConcernThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anD != null) {
                        ConcernThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.anZ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aN(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.Z(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.vV().c((TbPageContext) i.Z(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.anE = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.aiQ != null && ConcernThreadUserInfoLayout.this.aiQ.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.aiQ.rA() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aN(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.aiQ.sz() == null || ConcernThreadUserInfoLayout.this.aiQ.sz().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.aiQ.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.aiQ.rA(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.aiQ.sz().channelId, ConcernThreadUserInfoLayout.this.aiQ.sz().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.anD != null) {
                        ConcernThreadUserInfoLayout.this.anD.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.any = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.anT = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.anY = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.anz = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cPB = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cPC = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        xb();
        this.anT.setOnClickListener(this.anZ);
        this.anz.setOnClickListener(this.anE);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.aiQ = blVar;
        this.cPB.setText(blVar.rT());
        l(blVar);
        k(blVar);
        R(blVar);
        p(blVar);
        setVisibility(0);
        return true;
    }

    private void xb() {
        if (this.any != null) {
            this.any.setDefaultResource(17170445);
            this.any.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.any.setDefaultBgResource(d.e.cp_bg_line_e);
            this.any.setIsRound(true);
            this.any.setAfterClickListener(this.anD);
        }
    }

    private void l(bl blVar) {
        if (this.anT != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.anT.setVisibility(0);
                this.anT.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.anT.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.anz != null && blVar != null) {
            if (!StringUtils.isNull(this.aiQ.getAuthor().getName_show())) {
                this.anz.setText(al.d(this.aiQ.getAuthor().getName_show(), 14, "..."));
            }
            xd();
            if (this.mFrom == 3) {
                String name_show = this.aiQ.getAuthor().getName_show();
                String userName = this.aiQ.getAuthor().getUserName();
                if (ab.fS() && name_show != null && !name_show.equals(userName)) {
                    this.anz.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.anz.getText().toString()));
                    this.anz.setGravity(16);
                    this.anz.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aOz());
                    ai.c(this.anz, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void R(bl blVar) {
        if (this.cPC != null && blVar != null) {
            this.cPC.setVisibility(0);
            this.cPC.setText(al.r(blVar.getCreateTime()));
        }
    }

    private void p(bl blVar) {
        if (this.any != null && blVar != null && this.aiQ.getAuthor() != null) {
            this.any.setShowV(this.aiQ.getAuthor().isBigV());
        }
    }

    private void xd() {
        if (this.aiQ != null && this.aiQ.getAuthor() != null) {
            if (!u.v(this.aiQ.getAuthor().getTShowInfoNew()) || this.aiQ.getAuthor().isBigV()) {
                ai.i(this.anz, d.e.cp_cont_r);
            } else {
                ai.i(this.anz, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xd();
        ai.i(this.cPC, d.e.cp_cont_f);
        ai.i(this.cPB, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.anC = z;
    }

    public boolean getIsSimpleThread() {
        return this.anC;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.anD = onClickListener;
        if (this.any != null) {
            this.any.setAfterClickListener(this.anD);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.any != null) {
            this.any.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.any;
    }
}
