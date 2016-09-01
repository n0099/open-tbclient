package com.baidu.tieba.frs.entelechy.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.ap;
import com.baidu.tieba.t;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ap extends com.baidu.tieba.card.a<bg> implements az {
    protected TbPageContext<?> GM;
    protected TextView VM;
    public ViewStub aYe;
    public TbImageView aYf;
    public ThreadCommentAndPraiseInfoLayout aYp;
    private CustomMessageListener aZB;
    public UserIconLayout aZT;
    protected bg adL;
    private final View.OnClickListener ahR;
    private final View.OnClickListener ahu;
    public TbImageView bSm;
    public HeadPendantClickableView bXI;
    public ClickableHeaderImageView bXJ;
    protected TextView bXK;
    protected TextView bXL;
    private GuessYourLikeHeaderView bXi;
    private View bXj;
    public RelativeLayout bXq;
    protected View bam;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ig(int i);

    protected abstract void l(bg bgVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public ap(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.aZB = new aq(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahR = new ar(this);
        this.ahu = new as(this);
        this.GM = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.bam = this.mRootView.findViewById(t.g.card_vote_top_line);
        this.bXJ = (ClickableHeaderImageView) this.mRootView.findViewById(t.g.card_vote_header_image);
        this.bXI = (HeadPendantClickableView) this.mRootView.findViewById(t.g.card_vote_pendant_header_image);
        this.aYe = (ViewStub) this.mRootView.findViewById(t.g.viewstub_headimage_mask);
        this.bXJ.setDefaultResource(17170445);
        this.bXJ.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bXJ.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bXJ.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        if (this.bXI.getHeadView() != null) {
            this.bXI.getHeadView().setDefaultResource(17170445);
            this.bXI.getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
            this.bXI.getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
            this.bXI.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
            this.bXI.getHeadView().setIsRound(true);
            this.bXI.getHeadView().setDrawBorder(false);
        }
        this.bXI.vW();
        if (this.bXI.getPendantView() != null) {
            this.bXI.getPendantView().setIsRound(true);
            this.bXI.getPendantView().setDrawBorder(false);
        }
        this.aZT = (UserIconLayout) this.mRootView.findViewById(t.g.user_icon);
        this.aZT.ahQ = true;
        this.aZT.setEntelechyEnabled(true);
        this.aZT.setPageName(1);
        this.bSm = (TbImageView) this.mRootView.findViewById(t.g.theme_card_view);
        this.VM = (TextView) this.mRootView.findViewById(t.g.vote_thread_title);
        this.bXK = (TextView) this.mRootView.findViewById(t.g.vote_total_option_num);
        this.bXL = (TextView) this.mRootView.findViewById(t.g.vote_now_state);
        this.aYp = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(t.g.thread_more_info);
        this.bXq = (RelativeLayout) this.mRootView.findViewById(t.g.card_home_page_normal_thread_root_content);
        this.bXi = (GuessYourLikeHeaderView) this.mRootView.findViewById(t.g.guess_your_like_header);
        this.bXj = this.mRootView.findViewById(t.g.guess_your_like_bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            av.k(getView(), t.f.addresslist_item_bg);
            av.l(this.bam, t.d.cp_bg_line_b);
            this.aZT.ti();
            this.aYp.ti();
            av.c(this.bXK, t.d.cp_cont_c, 1);
            av.c(this.bXL, t.d.cp_cont_d, 1);
            ig(i);
            if (this.bXi != null) {
                this.bXi.ti();
            }
            av.l(this.bXj, t.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: i */
    public final void onBindDataToView(bg bgVar) {
        if (bgVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.adL = bgVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.adL.getAuthor() == null || this.adL.getAuthor().getPendantData() == null || StringUtils.isNull(this.adL.getAuthor().getPendantData().rc())) {
            UserTbVipInfoData rC = this.adL.rC();
            if (rC != null && rC.getvipV_url() != null) {
                if (this.aYe != null) {
                    if (this.aYf == null) {
                        this.aYe.inflate();
                        this.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                    }
                    this.aYf.setVisibility(0);
                    this.aYf.c(rC.getvipV_url(), 10, false);
                    this.bXJ.setIsBigV(true);
                }
            } else {
                this.bXJ.setIsBigV(false);
                if (this.aYf != null) {
                    this.aYf.setVisibility(8);
                }
            }
            this.bXI.setVisibility(8);
            this.bXJ.setVisibility(0);
            this.bXJ.setData(bgVar);
        } else {
            this.bXJ.setIsBigV(false);
            if (this.aYf != null) {
                this.aYf.setVisibility(8);
            }
            this.bXI.setVisibility(0);
            this.bXJ.setVisibility(4);
            this.bXI.setData(bgVar);
        }
        this.bXJ.setAfterClickListener(this.ahR);
        this.aZT.setVisibility(0);
        this.aZT.setData(bgVar);
        this.aZT.setUserAfterClickListener(this.ahR);
        this.aYp.setData(bgVar);
        ArrayList arrayList = new ArrayList();
        if (bgVar.ry() == 1) {
            arrayList.add(new ap.a(t.j.good));
        }
        arrayList.add(new ap.a(t.j.vote));
        SpannableStringBuilder a = com.baidu.tieba.card.ap.a((Context) TbadkCoreApplication.m9getInst(), bgVar.getTitle(), (ArrayList<ap.a>) arrayList, false);
        int length = 31 - a.length();
        String str = String.valueOf(bgVar.g(bgVar.getTitle(), false)) + " ";
        if (length < str.length()) {
            str = str.substring(0, length - 1);
        }
        a.append((CharSequence) bgVar.a(new SpannableString(str), false));
        this.VM.setLinkTextColor(getContext().getResources().getColor(t.d.cp_link_tip_c));
        this.VM.setOnTouchListener(new com.baidu.tieba.view.y(a));
        this.VM.setText(a);
        com.baidu.tieba.card.ap.a(this.VM, bgVar.getId(), t.d.cp_cont_b, t.d.cp_cont_d);
        if (bgVar.rs() == null || bgVar.rs().options_count.intValue() == 0) {
            this.bXK.setVisibility(8);
            this.bXL.setVisibility(8);
        } else {
            String string = this.GM.getResources().getString(t.j.total_x_vote_option);
            this.bXK.setVisibility(0);
            this.bXK.setText(String.format(string, bgVar.rs().options_count));
            if (StringUtils.isNull(bgVar.rs().tips, true)) {
                this.bXL.setVisibility(8);
            } else {
                this.bXL.setVisibility(0);
                this.bXL.setText("(" + bgVar.rs().tips + ")");
            }
        }
        this.aYp.setData(this.adL);
        this.aYp.setForumAfterClickListener(this.ahu);
        this.aYp.setStType(com.baidu.tieba.card.ap.ND());
        l(bgVar);
        if (this.bXi != null) {
            if ((this.adL.rY() || this.adL.rZ()) && com.baidu.tieba.tbadkCore.util.t.bke()) {
                this.bXi.setTitleText(StringUtils.isNull(this.adL.rX()) ? getContext().getResources().getString(t.j.group_fourm_recommend_title) : this.adL.rX());
                this.bXi.show();
                this.bam.setVisibility(8);
                if (this.bXj != null) {
                    this.bXj.setVisibility(0);
                }
                if (this.adL.bbt) {
                    this.bXi.bqo();
                } else {
                    this.bXi.bqn();
                    if (this.adL.bbu) {
                        this.bam.setVisibility(0);
                    }
                }
            } else {
                this.bXi.hide();
                this.bam.setVisibility(0);
                if (this.bXj != null) {
                    this.bXj.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.aYp.getCommentNumView()) && this.adL != null) {
            if (this.adL.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createHistoryCfg(this.adL.getTid(), String.valueOf(this.adL.rV()), false, true, null)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GM.getPageActivity()).createFromThreadCfg(this.adL, this.mForumName, null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.aYp != null && this.aZB != null) {
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.az
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
