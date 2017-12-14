package com.baidu.tieba.homepage.concern.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.h;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.n;
import com.baidu.tieba.card.k;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class c extends com.baidu.tieba.card.a<n> {
    private TbPageContext<?> abX;
    private final View.OnClickListener anQ;
    private HeadPendantClickableView bZe;
    private ThreadGodReplyLayout bZf;
    private ImageView bkX;
    private View bqs;
    public ThreadCommentAndPraiseInfoLayout bvI;
    private RelativeLayout bvv;
    private final View.OnClickListener caC;
    private final View.OnClickListener caD;
    private TbImageView cab;
    private TextView cac;
    public FrameLayout cai;
    private TextView cak;
    private LinearLayout cal;
    private n caq;
    private TbImageView.a caz;
    public ConcernThreadUserInfoLayout doN;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caz = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.cab != null) {
                    c.this.cab.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caC = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.caq);
                }
            }
        };
        this.caD = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.caq);
                }
            }
        };
        this.anQ = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.caq != null && c.this.abt() != null) {
                    c.this.abt().a(view, c.this.caq);
                }
            }
        };
        this.abX = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bvv = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bZe = (HeadPendantClickableView) this.bvv.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZe.getHeadView() != null) {
            this.bZe.getHeadView().setIsRound(true);
            this.bZe.getHeadView().setDrawBorder(false);
            this.bZe.getHeadView().setDefaultResource(17170445);
            this.bZe.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZe.getHeadView().setDefaultBgResource(d.C0096d.cp_bg_line_e);
            this.bZe.getHeadView().setRadius(l.f(this.abX.getPageActivity(), d.e.ds70));
        }
        if (this.bZe.getPendantView() != null) {
            this.bZe.getPendantView().setIsRound(true);
            this.bZe.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.doN = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.bvI = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bvI.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvI.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvI.setLayoutParams(layoutParams);
        }
        this.bvI.setOnClickListener(this);
        this.bvI.setReplyTimeVisible(false);
        this.bvI.setShowPraiseNum(true);
        this.bvI.setIsBarViewVisible(false);
        this.bvI.setNeedAddPraiseIcon(true);
        this.bvI.setNeedAddReplyIcon(true);
        this.bvI.setShareVisible(true);
        this.bvI.setShareReportFrom(4);
        this.bvI.setForumAfterClickListener(this.anQ);
        this.bvI.anO = this.currentPageType;
        this.bvv.setOnClickListener(this);
        this.cai = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cai.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cai.getLayoutParams();
        layoutParams2.width = l.ac(this.abX.getPageActivity()) - l.f(this.abX.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cai.setLayoutParams(layoutParams2);
        this.cab = (TbImageView) view.findViewById(d.g.image_video);
        this.cab.setDefaultErrorResource(0);
        this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.cab.setGifIconSupport(false);
        this.cab.setEvent(this.caz);
        this.bkX = (ImageView) view.findViewById(d.g.image_video_play);
        this.cak = (TextView) view.findViewById(d.g.text_video_duration);
        this.cal = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cac = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bqs = view.findViewById(d.g.divider_line);
        this.bZf = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZf.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvv, d.f.addresslist_item_bg);
            aj.c(this.bkX, d.f.btn_icon_play_video_n);
            this.doN.onChangeSkinType();
            this.bvI.onChangeSkinType();
            aj.j(this.bqs, d.C0096d.cp_bg_line_e);
            aj.i(this.cak, d.C0096d.cp_cont_i);
            aj.i(this.cac, d.C0096d.cp_cont_i);
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_concern_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(n nVar) {
        this.caq = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvv || view == this.bZf) {
            ai(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cai) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                az(this.cai);
            } else {
                ai(this.cai);
            }
        }
    }

    private void az(View view) {
        if (!j.hh()) {
            l.showToast(this.abX.getPageActivity(), d.j.no_network_guide);
        } else if (!j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.abX.getPageActivity());
            aVar.cS(this.abX.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.abD();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                }
            });
            aVar.ao(true);
            aVar.b(this.mTbPageContext).th();
        } else {
            abD();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abD() {
        if (this.caq != null && this.caq.bjE != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.abX.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.caq.bjE.getTid(), k.rl(), this.caq.acg())));
        }
    }

    private boolean abx() {
        return this.caq.cdT && !this.caq.ceh;
    }

    private void ai(View view) {
        if (abt() != null) {
            abt().a(view, this.caq);
        }
        if (this.caq != null && this.caq.bjE != null) {
            if (!abx()) {
                k.jO(this.caq.bjE.getId());
                k.a(this.mTextTitle, this.caq.bjE.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.abX.getPageActivity()).createFromThreadCfg(this.caq.bjE, null, k.rl(), 18003, true, false, false).addLocateParam(this.caq.acg());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.caq.bjE.getFid()));
            addLocateParam.setForumName(this.caq.bjE.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZf) {
                addLocateParam.setJumpGodReply(true);
            }
            this.abX.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.caq == null || this.caq.bjE == null || this.caq.bjE.rv() == null || this.caq.bjE.rN() == null) {
            this.bvv.setVisibility(8);
            return;
        }
        this.bvv.setVisibility(0);
        abI();
        if (!abx() && k.jP(this.caq.bjE.getId())) {
            k.a(this.mTextTitle, this.caq.bjE.getId(), d.C0096d.cp_cont_b, d.C0096d.cp_cont_d);
            k.a(this.bZf.getGodReplyContent(), this.caq.Ox().getId(), d.C0096d.cp_cont_f, d.C0096d.cp_cont_d);
        }
        this.caq.Ox().sd();
        this.mTextTitle.setText(this.caq.Ox().rV());
        this.doN.setData(this.caq.Ox());
        this.doN.setUserAfterClickListener(this.caC);
        if (this.doN.getHeaderImg() != null) {
            this.doN.getHeaderImg().setAfterClickListener(this.caD);
            if (this.doN.getIsSimpleThread()) {
                this.doN.getHeaderImg().setVisibility(8);
                this.bZe.setVisibility(8);
            } else if (this.caq.Ox() == null || this.caq.Ox().rv() == null || this.caq.Ox().rv().getPendantData() == null || StringUtils.isNull(this.caq.Ox().rv().getPendantData().pR())) {
                this.bZe.setVisibility(8);
                this.doN.getHeaderImg().setVisibility(0);
                this.doN.getHeaderImg().setData(this.caq.Ox());
            } else {
                this.doN.getHeaderImg().setVisibility(4);
                this.bZe.setVisibility(0);
                this.bZe.setData(this.caq.Ox());
            }
        }
        this.cak.setText(am.cY(this.caq.bjE.rN().video_duration.intValue() * 1000));
        this.cac.setText(String.format(this.abX.getResources().getString(d.j.play_count), am.A(this.caq.bjE.rN().play_count.intValue())));
        this.bvI.setData(this.caq.bjE);
        this.bZf.setData(this.caq.Ox().sM());
        this.bZf.onChangeSkinType();
        d(this.abX, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.caq.bjE.getId())) {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0096d.cp_cont_b, 1);
        }
    }

    private void abI() {
        if (this.cab != null && this.cai != null) {
            if (h.oY().pe() && this.caq != null && this.caq.bjE != null && this.caq.bjE.rN() != null) {
                this.cab.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.cab.startLoad(this.caq.bjE.rN().thumbnail_url, 10, false);
                this.cai.setVisibility(0);
                return;
            }
            this.cai.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.doN != null) {
            this.doN.setPageUniqueId(bdUniqueId);
        }
        if (this.cab != null) {
            this.cab.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doN != null) {
            return this.doN.getHeaderImg();
        }
        return null;
    }

    public View abw() {
        if (this.doN != null) {
            return this.doN.anZ;
        }
        return null;
    }
}
