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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.an;
import com.baidu.tieba.r;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public abstract class ao extends com.baidu.tieba.card.a<bk> implements ba {
    protected TbPageContext<?> GO;
    protected TextView Wu;
    public ClickableHeaderImageView aNx;
    protected bk aeu;
    private final View.OnClickListener ahD;
    private final View.OnClickListener ahZ;
    public TbImageView bUs;
    public ViewStub bbQ;
    public TbImageView bbR;
    public ThreadCommentAndPraiseInfoLayout bca;
    protected View bdN;
    private CustomMessageListener bdb;
    public View bdt;
    public UserIconLayout bdu;
    public RelativeLayout caB;
    public HeadPendantClickableView caT;
    protected TextView caU;
    protected TextView caV;
    private GuessYourLikeHeaderView cat;
    private View cau;
    private String mForumName;
    protected boolean mIsFromCDN;
    protected View mRootView;
    private int mSkinType;

    protected abstract void ik(int i);

    protected abstract void l(bk bkVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSkinType() {
        return this.mSkinType;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public ao(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mIsFromCDN = true;
        this.bdb = new ap(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahZ = new aq(this);
        this.ahD = new ar(this);
        this.GO = tbPageContext;
        initView();
    }

    public void initView() {
        this.mRootView = getView();
        this.bdN = this.mRootView.findViewById(r.g.card_vote_top_line);
        this.aNx = (ClickableHeaderImageView) this.mRootView.findViewById(r.g.card_vote_header_image);
        this.caT = (HeadPendantClickableView) this.mRootView.findViewById(r.g.card_vote_pendant_header_image);
        this.bbQ = (ViewStub) this.mRootView.findViewById(r.g.viewstub_headimage_mask);
        this.aNx.setDefaultResource(17170445);
        this.aNx.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.aNx.setDefaultBgResource(r.d.cp_bg_line_e);
        this.aNx.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        if (this.caT.getHeadView() != null) {
            this.caT.getHeadView().setDefaultResource(17170445);
            this.caT.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
            this.caT.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
            this.caT.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
            this.caT.getHeadView().setIsRound(true);
            this.caT.getHeadView().setDrawBorder(false);
        }
        this.caT.wo();
        if (this.caT.getPendantView() != null) {
            this.caT.getPendantView().setIsRound(true);
            this.caT.getPendantView().setDrawBorder(false);
        }
        this.bdu = (UserIconLayout) this.mRootView.findViewById(r.g.user_icon);
        this.bdu.ahY = true;
        this.bdu.setEntelechyEnabled(true);
        this.bdu.setPageName(1);
        this.bUs = (TbImageView) this.mRootView.findViewById(r.g.theme_card_view);
        this.Wu = (TextView) this.mRootView.findViewById(r.g.vote_thread_title);
        this.caU = (TextView) this.mRootView.findViewById(r.g.vote_total_option_num);
        this.caV = (TextView) this.mRootView.findViewById(r.g.vote_now_state);
        this.bca = (ThreadCommentAndPraiseInfoLayout) this.mRootView.findViewById(r.g.thread_more_info);
        this.bdt = this.mRootView.findViewById(r.g.divider_below_reply_number_layout);
        this.caB = (RelativeLayout) this.mRootView.findViewById(r.g.card_home_page_normal_thread_root_content);
        this.cat = (GuessYourLikeHeaderView) this.mRootView.findViewById(r.g.guess_your_like_header);
        this.cau = this.mRootView.findViewById(r.g.guess_your_like_bottom_line);
    }

    @Override // com.baidu.tieba.card.a
    public final void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.at.k(getView(), r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.at.l(this.bdN, r.d.cp_bg_line_b);
            this.bdu.tB();
            this.bca.tB();
            com.baidu.tbadk.core.util.at.c(this.caU, r.d.cp_cont_c, 1);
            com.baidu.tbadk.core.util.at.c(this.caV, r.d.cp_cont_d, 1);
            ik(i);
            if (this.cat != null) {
                this.cat.tB();
            }
            com.baidu.tbadk.core.util.at.l(this.cau, r.d.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_vote_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: j */
    public final void onBindDataToView(bk bkVar) {
        if (bkVar == null) {
            if (getView() != null) {
                getView().setVisibility(8);
                return;
            }
            return;
        }
        this.aeu = bkVar;
        if (getView() != null) {
            getView().setVisibility(0);
        }
        if (this.aeu.getAuthor() == null || this.aeu.getAuthor().getPendantData() == null || StringUtils.isNull(this.aeu.getAuthor().getPendantData().pR())) {
            UserTbVipInfoData rQ = this.aeu.rQ();
            if (rQ != null && rQ.getvipV_url() != null) {
                if (this.bbQ != null) {
                    if (this.bbR == null) {
                        this.bbQ.inflate();
                        this.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.bbR.setVisibility(0);
                    this.bbR.c(rQ.getvipV_url(), 10, false);
                    this.aNx.setIsBigV(true);
                }
            } else {
                this.aNx.setIsBigV(false);
                if (this.bbR != null) {
                    this.bbR.setVisibility(8);
                }
            }
            this.caT.setVisibility(8);
            this.aNx.setVisibility(0);
            this.aNx.setData(bkVar);
        } else {
            this.aNx.setIsBigV(false);
            if (this.bbR != null) {
                this.bbR.setVisibility(8);
            }
            this.caT.setVisibility(0);
            this.aNx.setVisibility(4);
            this.caT.setData(bkVar);
        }
        this.aNx.setAfterClickListener(this.ahZ);
        this.bdu.setVisibility(0);
        if (bkVar.getAuthor() != null && !StringUtils.isNull(bkVar.getAuthor().getSealPrefix())) {
            this.bdu.aN(true);
        }
        this.bdu.setData(bkVar);
        this.bdu.setUserAfterClickListener(this.ahZ);
        ArrayList arrayList = new ArrayList();
        if (bkVar.rM() == 1) {
            arrayList.add(new an.a(r.j.good));
        }
        SpannableStringBuilder a = com.baidu.tieba.card.an.a((Context) TbadkCoreApplication.m9getInst(), bkVar.getTitle(), (ArrayList<an.a>) arrayList, false);
        a.append((CharSequence) bkVar.a(new SpannableString(String.valueOf(bkVar.g(bkVar.getTitle(), false)) + " "), false));
        this.Wu.setLinkTextColor(getContext().getResources().getColor(r.d.cp_link_tip_c));
        this.Wu.setOnTouchListener(new com.baidu.tieba.view.x(a));
        this.Wu.setText(a);
        com.baidu.tieba.card.an.a(this.Wu, bkVar.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        if (bkVar.rG() == null || bkVar.rG().options_count.intValue() == 0) {
            this.caU.setVisibility(8);
            this.caV.setVisibility(8);
        } else {
            String string = this.GO.getResources().getString(r.j.total_x_vote_option);
            this.caU.setVisibility(0);
            this.caU.setText(String.format(string, bkVar.rG().options_count));
            if (StringUtils.isNull(bkVar.rG().tips, true)) {
                this.caV.setVisibility(8);
            } else {
                this.caV.setVisibility(0);
                this.caV.setText("(" + bkVar.rG().tips + ")");
            }
        }
        if (this.bca.a(bkVar)) {
            this.bdt.setVisibility(8);
        } else {
            this.bdt.setVisibility(0);
        }
        this.bca.setForumAfterClickListener(this.ahD);
        this.bca.setStType(com.baidu.tieba.card.an.Pf());
        l(bkVar);
        if (this.cat != null) {
            if ((this.aeu.sm() || this.aeu.sn()) && com.baidu.tieba.tbadkCore.util.s.bng()) {
                this.cat.setTitleText(StringUtils.isNull(this.aeu.sl()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.aeu.sl());
                this.cat.show();
                this.bdN.setVisibility(8);
                if (this.cau != null) {
                    this.cau.setVisibility(0);
                }
                if (this.aeu.needTopMargin) {
                    this.cat.btl();
                } else {
                    this.cat.btk();
                    if (this.aeu.isFirstFloor) {
                        this.bdN.setVisibility(0);
                    }
                }
            } else {
                this.cat.hide();
                this.bdN.setVisibility(0);
                if (this.cau != null) {
                    this.cau.setVisibility(8);
                }
            }
        }
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if ((view == this.mRootView || view == this.bca.getCommentNumView()) && this.aeu != null) {
            if (this.aeu.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createHistoryCfg(this.aeu.getTid(), String.valueOf(this.aeu.sj()), false, true, null)));
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.GO.getPageActivity()).createFromThreadCfg(this.aeu, this.mForumName, null, 18003, true, false, false)));
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.bca != null && this.bdb != null) {
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    @Override // com.baidu.tieba.frs.entelechy.view.ba
    public void setForumName(String str) {
        this.mForumName = str;
    }
}
