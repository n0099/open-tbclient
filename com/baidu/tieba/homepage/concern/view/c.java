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
    private TbPageContext<?> aca;
    private final View.OnClickListener anT;
    private HeadPendantClickableView bZi;
    private ThreadGodReplyLayout bZj;
    private ImageView blb;
    private View bqw;
    public ThreadCommentAndPraiseInfoLayout bvM;
    private RelativeLayout bvz;
    private TbImageView.a caD;
    private final View.OnClickListener caG;
    private final View.OnClickListener caH;
    private TbImageView caf;
    private TextView cag;
    public FrameLayout cam;
    private TextView cao;
    private LinearLayout cap;
    private n cau;
    public ConcernThreadUserInfoLayout doR;
    private TextView mTextTitle;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.caD = new TbImageView.a() { // from class: com.baidu.tieba.homepage.concern.view.c.1
            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void r(String str, boolean z) {
                if (z && c.this.caf != null) {
                    c.this.caf.setDefaultBgResource(0);
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        };
        this.caG = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.cau);
                }
            }
        };
        this.caH = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.abt() != null) {
                    c.this.abt().a(view, c.this.cau);
                }
            }
        };
        this.anT = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.concern.view.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (c.this.cau != null && c.this.abt() != null) {
                    c.this.abt().a(view, c.this.cau);
                }
            }
        };
        this.aca = tbPageContext;
        this.currentPageType = 1;
        View view = getView();
        this.bvz = (RelativeLayout) view.findViewById(d.g.layout_root);
        this.bZi = (HeadPendantClickableView) this.bvz.findViewById(d.g.card_home_page_video_user_pendant_header);
        if (this.bZi.getHeadView() != null) {
            this.bZi.getHeadView().setIsRound(true);
            this.bZi.getHeadView().setDrawBorder(false);
            this.bZi.getHeadView().setDefaultResource(17170445);
            this.bZi.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
            this.bZi.getHeadView().setDefaultBgResource(d.C0095d.cp_bg_line_e);
            this.bZi.getHeadView().setRadius(l.f(this.aca.getPageActivity(), d.e.ds70));
        }
        if (this.bZi.getPendantView() != null) {
            this.bZi.getPendantView().setIsRound(true);
            this.bZi.getPendantView().setDrawBorder(false);
        }
        this.mTextTitle = (TextView) view.findViewById(d.g.text_title);
        this.doR = (ConcernThreadUserInfoLayout) view.findViewById(d.g.card_concern_video_user_info_layout);
        this.bvM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.text_bottom);
        if (this.bvM.getLayoutParams() instanceof LinearLayout.LayoutParams) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.bvM.getLayoutParams();
            layoutParams.rightMargin = 0;
            this.bvM.setLayoutParams(layoutParams);
        }
        this.bvM.setOnClickListener(this);
        this.bvM.setReplyTimeVisible(false);
        this.bvM.setShowPraiseNum(true);
        this.bvM.setIsBarViewVisible(false);
        this.bvM.setNeedAddPraiseIcon(true);
        this.bvM.setNeedAddReplyIcon(true);
        this.bvM.setShareVisible(true);
        this.bvM.setShareReportFrom(4);
        this.bvM.setForumAfterClickListener(this.anT);
        this.bvM.anR = this.currentPageType;
        this.bvz.setOnClickListener(this);
        this.cam = (FrameLayout) view.findViewById(d.g.frame_video);
        this.cam.setOnClickListener(this);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.cam.getLayoutParams();
        layoutParams2.width = l.ac(this.aca.getPageActivity()) - l.f(this.aca.getPageActivity(), d.e.tbds88);
        layoutParams2.height = (int) (0.5625d * layoutParams2.width);
        this.cam.setLayoutParams(layoutParams2);
        this.caf = (TbImageView) view.findViewById(d.g.image_video);
        this.caf.setDefaultErrorResource(0);
        this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
        this.caf.setGifIconSupport(false);
        this.caf.setEvent(this.caD);
        this.blb = (ImageView) view.findViewById(d.g.image_video_play);
        this.cao = (TextView) view.findViewById(d.g.text_video_duration);
        this.cap = (LinearLayout) view.findViewById(d.g.duration_container);
        this.cag = (TextView) view.findViewById(d.g.text_video_play_count);
        this.bqw = view.findViewById(d.g.divider_line);
        this.bZj = (ThreadGodReplyLayout) view.findViewById(d.g.card_god_reply_layout);
        this.bZj.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.j(this.bvz, d.f.addresslist_item_bg);
            aj.c(this.blb, d.f.btn_icon_play_video_n);
            this.doR.onChangeSkinType();
            this.bvM.onChangeSkinType();
            aj.j(this.bqw, d.C0095d.cp_bg_line_e);
            aj.i(this.cao, d.C0095d.cp_cont_i);
            aj.i(this.cag, d.C0095d.cp_cont_i);
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
        this.cau = nVar;
        refreshView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bvz || view == this.bZj) {
            aj(view);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.HOT_TOPIC_CUSTOM, null));
        }
        if (view == this.cam) {
            if (UtilHelper.isGotoVideoMiddlePage()) {
                aA(getView());
            } else {
                aj(getView());
            }
        }
    }

    private void aA(View view) {
        if (abt() != null) {
            abt().a(view, this.cau);
        }
        if (!j.hh()) {
            l.showToast(this.aca.getPageActivity(), d.j.no_network_guide);
        } else if (!j.hi()) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.aca.getPageActivity());
            aVar.cS(this.aca.getString(d.j.enter_video_center_page_no_wifi_tip));
            aVar.a(d.j.continue_forward, new a.b() { // from class: com.baidu.tieba.homepage.concern.view.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar2.dismiss();
                    c.this.abC();
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
            abC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        if (this.cau != null && this.cau.bjI != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new VideoMiddlePageActivityConfig(this.aca.getPageActivity(), VideoMiddlePageActivityConfig.FROM_CONCERN_TAB, this.cau.bjI.getTid(), k.rl(), this.cau.acf())));
        }
    }

    private boolean abx() {
        return this.cau.cdX && !this.cau.cel;
    }

    private void aj(View view) {
        if (abt() != null) {
            abt().a(view, this.cau);
        }
        if (this.cau != null && this.cau.bjI != null) {
            if (!abx()) {
                k.jO(this.cau.bjI.getId());
                k.a(this.mTextTitle, this.cau.bjI.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            }
            PbActivityConfig addLocateParam = new PbActivityConfig(this.aca.getPageActivity()).createFromThreadCfg(this.cau.bjI, null, k.rl(), 18003, true, false, false).addLocateParam(this.cau.acf());
            addLocateParam.setVideo_source(VideoMiddlePageActivityConfig.FROM_CONCERN_TAB);
            addLocateParam.setForumId(String.valueOf(this.cau.bjI.getFid()));
            addLocateParam.setForumName(this.cau.bjI.rB());
            addLocateParam.setStartFrom(this.currentPageType);
            if (view == this.bZj) {
                addLocateParam.setJumpGodReply(true);
            }
            this.aca.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, addLocateParam));
        }
    }

    private void refreshView() {
        if (this.cau == null || this.cau.bjI == null || this.cau.bjI.rv() == null || this.cau.bjI.rN() == null) {
            this.bvz.setVisibility(8);
            return;
        }
        this.bvz.setVisibility(0);
        abH();
        if (!abx() && k.jP(this.cau.bjI.getId())) {
            k.a(this.mTextTitle, this.cau.bjI.getId(), d.C0095d.cp_cont_b, d.C0095d.cp_cont_d);
            k.a(this.bZj.getGodReplyContent(), this.cau.Ox().getId(), d.C0095d.cp_cont_f, d.C0095d.cp_cont_d);
        }
        this.cau.Ox().sd();
        this.mTextTitle.setText(this.cau.Ox().rV());
        this.doR.setData(this.cau.Ox());
        this.doR.setUserAfterClickListener(this.caG);
        if (this.doR.getHeaderImg() != null) {
            this.doR.getHeaderImg().setAfterClickListener(this.caH);
            if (this.doR.getIsSimpleThread()) {
                this.doR.getHeaderImg().setVisibility(8);
                this.bZi.setVisibility(8);
            } else if (this.cau.Ox() == null || this.cau.Ox().rv() == null || this.cau.Ox().rv().getPendantData() == null || StringUtils.isNull(this.cau.Ox().rv().getPendantData().pR())) {
                this.bZi.setVisibility(8);
                this.doR.getHeaderImg().setVisibility(0);
                this.doR.getHeaderImg().setData(this.cau.Ox());
            } else {
                this.doR.getHeaderImg().setVisibility(4);
                this.bZi.setVisibility(0);
                this.bZi.setData(this.cau.Ox());
            }
        }
        this.cao.setText(am.cY(this.cau.bjI.rN().video_duration.intValue() * 1000));
        this.cag.setText(String.format(this.aca.getResources().getString(d.j.play_count), am.A(this.cau.bjI.rN().play_count.intValue())));
        this.bvM.setData(this.cau.bjI);
        this.bZj.setData(this.cau.Ox().sM());
        this.bZj.onChangeSkinType();
        d(this.aca, TbadkCoreApplication.getInst().getSkinType());
        if (k.jP(this.cau.bjI.getId())) {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_d, 1);
        } else {
            aj.c(this.mTextTitle, d.C0095d.cp_cont_b, 1);
        }
    }

    private void abH() {
        if (this.caf != null && this.cam != null) {
            if (h.oY().pe() && this.cau != null && this.cau.bjI != null && this.cau.bjI.rN() != null) {
                this.caf.setDefaultBgResource(d.f.pic_bg_video_frs);
                this.caf.startLoad(this.cau.bjI.rN().thumbnail_url, 10, false);
                this.cam.setVisibility(0);
                return;
            }
            this.cam.setVisibility(8);
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null) {
            setPageUniqueId(bdUniqueId);
        }
    }

    private void setPageUniqueId(BdUniqueId bdUniqueId) {
        if (this.doR != null) {
            this.doR.setPageUniqueId(bdUniqueId);
        }
        if (this.caf != null) {
            this.caf.setPageId(bdUniqueId);
        }
    }

    public ClickableHeaderImageView getHeaderImg() {
        if (this.doR != null) {
            return this.doR.getHeaderImg();
        }
        return null;
    }

    public View abw() {
        if (this.doR != null) {
            return this.doR.aoc;
        }
        return null;
    }
}
