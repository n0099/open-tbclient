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
    private bl akl;
    public ClickableHeaderImageView aoS;
    public TextView aoT;
    private boolean aoW;
    private View.OnClickListener aoX;
    private View.OnClickListener aoY;
    private UserIconBox apn;
    private LinearLayout apt;
    private View.OnClickListener apu;
    private TextView cST;
    private TextView cSU;
    private Context mContext;
    private int mFrom;

    public void setFrom(int i) {
        this.mFrom = i;
    }

    public ConcernThreadUserInfoLayout(Context context) {
        super(context);
        this.mFrom = 1;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akl.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akl.sJ() == null || ConcernThreadUserInfoLayout.this.akl.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.sJ().channelId, ConcernThreadUserInfoLayout.this.akl.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoX != null) {
                        ConcernThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFrom = 1;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akl.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akl.sJ() == null || ConcernThreadUserInfoLayout.this.akl.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.sJ().channelId, ConcernThreadUserInfoLayout.this.akl.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoX != null) {
                        ConcernThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    public ConcernThreadUserInfoLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mFrom = 1;
        this.apu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String url;
                if (aw.aO(ConcernThreadUserInfoLayout.this.mContext) && ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew() != null && u.c(ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew(), 0) != null && (url = ConcernThreadUserInfoLayout.this.akl.getAuthor().getTShowInfoNew().get(0).getUrl()) != null && (i.aa(ConcernThreadUserInfoLayout.this.mContext) instanceof TbPageContext)) {
                    at.wf().c((TbPageContext) i.aa(ConcernThreadUserInfoLayout.this.mContext), new String[]{url});
                }
            }
        };
        this.aoY = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.ConcernThreadUserInfoLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (ConcernThreadUserInfoLayout.this.akl != null && ConcernThreadUserInfoLayout.this.akl.getAuthor() != null && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show()) && !StringUtils.isNull(ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId()) && ConcernThreadUserInfoLayout.this.akl.rK() != null) {
                    if (view.getTag(d.h.tag_nick_name_activity) != null && (view.getTag(d.h.tag_nick_name_activity) instanceof String)) {
                        String str = (String) view.getTag(d.h.tag_nick_name_activity);
                        if (!TextUtils.isEmpty(str) && aw.aO(ConcernThreadUserInfoLayout.this.getContext())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(view.getContext(), null, str, true)));
                            return;
                        }
                    }
                    if (ConcernThreadUserInfoLayout.this.akl.sJ() == null || ConcernThreadUserInfoLayout.this.akl.sJ().channelId <= 0) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSON_INFO, new PersonInfoActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.getAuthor().getUserId(), ConcernThreadUserInfoLayout.this.akl.getAuthor().getName_show(), ConcernThreadUserInfoLayout.this.akl.rK(), AddFriendActivityConfig.TYPE_FRS_HEAD)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ChannelHomeActivityConfig(ConcernThreadUserInfoLayout.this.mContext, ConcernThreadUserInfoLayout.this.akl.sJ().channelId, ConcernThreadUserInfoLayout.this.akl.sJ().mCurrentPage)));
                    }
                    if (ConcernThreadUserInfoLayout.this.aoX != null) {
                        ConcernThreadUserInfoLayout.this.aoX.onClick(view);
                    }
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(d.j.concern_thread_user_info_layout, (ViewGroup) this, true);
        this.aoS = (ClickableHeaderImageView) inflate.findViewById(d.h.card_concern_normal_thread_user_header);
        this.apn = (UserIconBox) inflate.findViewById(d.h.card_concern_normal_thread_tshow_icon);
        this.apt = (LinearLayout) inflate.findViewById(d.h.card_concern_normal_thread_user_info);
        this.aoT = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_user_name);
        this.cST = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_event);
        this.cSU = (TextView) inflate.findViewById(d.h.card_concern_normal_thread_create_time);
        setGravity(16);
        this.mContext = context;
        xj();
        this.apn.setOnClickListener(this.apu);
        this.aoT.setOnClickListener(this.aoY);
    }

    public boolean a(bl blVar) {
        if (blVar == null) {
            setVisibility(8);
            return false;
        }
        this.akl = blVar;
        this.cST.setText(blVar.sd());
        l(blVar);
        k(blVar);
        R(blVar);
        p(blVar);
        setVisibility(0);
        return true;
    }

    private void xj() {
        if (this.aoS != null) {
            this.aoS.setDefaultResource(17170445);
            this.aoS.setDefaultErrorResource(d.g.icon_default_avatar100);
            this.aoS.setDefaultBgResource(d.e.cp_bg_line_e);
            this.aoS.setIsRound(true);
            this.aoS.setAfterClickListener(this.aoX);
        }
    }

    private void l(bl blVar) {
        if (this.apn != null && blVar != null && blVar.getAuthor() != null) {
            ArrayList<IconData> tShowInfoNew = blVar.getAuthor().getTShowInfoNew();
            if (u.u(tShowInfoNew) != 0) {
                this.apn.setVisibility(0);
                this.apn.a(tShowInfoNew, 2, this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds36), this.mContext.getResources().getDimensionPixelSize(d.f.ds8), true);
                return;
            }
            this.apn.setVisibility(8);
        }
    }

    private void k(bl blVar) {
        if (this.aoT != null && blVar != null) {
            if (!StringUtils.isNull(this.akl.getAuthor().getName_show())) {
                this.aoT.setText(al.d(this.akl.getAuthor().getName_show(), 14, "..."));
            }
            xl();
            if (this.mFrom == 3) {
                String name_show = this.akl.getAuthor().getName_show();
                String userName = this.akl.getAuthor().getUserName();
                if (ab.ge() && name_show != null && !name_show.equals(userName)) {
                    this.aoT.setText(com.baidu.tieba.pb.d.ao(this.mContext, this.aoT.getText().toString()));
                    this.aoT.setGravity(16);
                    this.aoT.setTag(d.h.tag_nick_name_activity, com.baidu.tieba.pb.d.aPr());
                    ai.c(this.aoT, d.e.cp_other_e, 1);
                }
            }
        }
    }

    private void R(bl blVar) {
        if (this.cSU != null && blVar != null) {
            this.cSU.setVisibility(0);
            this.cSU.setText(al.r(blVar.getCreateTime()));
        }
    }

    private void p(bl blVar) {
        if (this.aoS != null && blVar != null && this.akl.getAuthor() != null) {
            this.aoS.setShowV(this.akl.getAuthor().isBigV());
        }
    }

    private void xl() {
        if (this.akl != null && this.akl.getAuthor() != null) {
            if (!u.v(this.akl.getAuthor().getTShowInfoNew()) || this.akl.getAuthor().isBigV()) {
                ai.i(this.aoT, d.e.cp_cont_r);
            } else {
                ai.i(this.aoT, d.e.cp_cont_f);
            }
        }
    }

    public void onChangeSkinType() {
        xl();
        ai.i(this.cSU, d.e.cp_cont_f);
        ai.i(this.cST, d.e.cp_cont_f);
    }

    public void setIsSimpleThread(boolean z) {
        this.aoW = z;
    }

    public boolean getIsSimpleThread() {
        return this.aoW;
    }

    public void setUserAfterClickListener(View.OnClickListener onClickListener) {
        this.aoX = onClickListener;
        if (this.aoS != null) {
            this.aoS.setAfterClickListener(this.aoX);
        }
    }

    public void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.aoS != null) {
            this.aoS.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        return this.aoS;
    }
}
