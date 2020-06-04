package com.baidu.tieba.frs.aggregation;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.ConstantData;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.play.c;
import com.baidu.tieba.play.g;
import com.baidu.tieba.play.n;
import com.baidu.tieba.play.y;
import com.tencent.connect.common.Constants;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<g> implements c {
    public TextView agw;
    private Animation boW;
    private boolean dJS;
    public TextView fWi;
    private n fbZ;
    public FrameLayout hsQ;
    public FrameLayout hsR;
    public TextView hsS;
    public TextView hsT;
    public FrameLayout hsU;
    public TextView hsV;
    public TextView hsW;
    public HeadImageView hsX;
    public TextView hsY;
    public TextView hsZ;
    public ImageView hta;
    public ImageView htb;
    public LinearLayout htc;
    public LinearLayout htd;
    public com.baidu.tieba.play.c hte;
    public g htf;
    private h htg;
    private y hth;
    private y hti;
    private boolean htj;
    private boolean htk;
    private Animation htl;
    private ScaleAnimation htm;
    private boolean htn;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.htj = true;
        this.htn = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.hsQ = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.hsR = (FrameLayout) view.findViewById(R.id.video_container);
        this.hte = new com.baidu.tieba.play.c(tbPageContext, this.hsR, false);
        this.hsS = (TextView) view.findViewById(R.id.title);
        this.hsT = (TextView) view.findViewById(R.id.duration);
        this.hsU = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.hsV = (TextView) view.findViewById(R.id.mobile_network_text);
        this.hsW = (TextView) view.findViewById(R.id.mobile_network_play);
        this.hsX = (HeadImageView) view.findViewById(R.id.user_icon);
        this.agw = (TextView) view.findViewById(R.id.user_name);
        this.fWi = (TextView) view.findViewById(R.id.attention);
        this.htc = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.htd = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.hsY = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.hsZ = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.hta = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.htb = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.htc.setOnClickListener(this);
        this.htd.setOnClickListener(this);
        this.hsS.setOnClickListener(this);
        this.hsX.setOnClickListener(this);
        this.agw.setOnClickListener(this);
        this.fWi.setOnClickListener(this);
        view.setOnClickListener(this);
        this.hsW.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hsQ.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.hsQ.setLayoutParams(layoutParams);
        this.hsX.setIsRound(true);
        this.fbZ = new n(tbPageContext.getPageActivity());
        this.htg = new h(this.mPageContext, this);
        this.htl = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.boW = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.htf != null && this.htf.htE != null) {
                if (this.htf.htE.hasFocus) {
                    am.setViewTextColor(this.fWi, (int) R.color.cp_cont_d);
                    this.fWi.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.fWi, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.fWi.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.htf != null) {
                if (this.htf.hasAgree) {
                    this.htb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.hsZ, (int) R.color.cp_cont_h);
                } else {
                    this.htb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.hsZ, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.hsY, (int) R.color.cp_cont_f);
            this.hta.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.htF != null) {
            this.htf = gVar;
            this.dJS = this.htf.autoPlay;
            this.hsS.setVisibility(0);
            this.hsS.setText(gVar.title);
            this.hsT.setVisibility(0);
            this.hsT.setText(aq.stringForVideoTime(gVar.htF.videoDuration * 1000));
            if (gVar.htF.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), EH(String.format("%.1f", Float.valueOf(((float) gVar.htF.videoSize) / 1048576.0f))));
            }
            this.hsV.setText(format);
            this.hsU.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.htF != null) {
            this.hte.stopPlay();
            this.hte.setIsNeedRecoveryVideoPlayer(true);
            this.hte.tt(true);
            this.hte.tp(false);
            this.hte.a(new c.InterfaceC0704c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pM() {
                    if (b.this.hte.pO()) {
                        b.this.hsT.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0704c
                public void pN() {
                    if (b.this.hte.pO()) {
                        b.this.hsT.setVisibility(8);
                    }
                    if (b.this.htk) {
                        b.this.hte.stopPlay();
                    }
                }
            });
            this.hte.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bXy() {
                    b.this.htk = false;
                    b.this.hsT.setVisibility(8);
                    b.this.EG(b.this.dJS ? "1" : "2");
                    b.this.onClick(b.this.hsR);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bXz() {
                    b.this.hsT.setVisibility(8);
                    b.this.onClick(b.this.hsQ);
                }
            });
            this.hte.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void nl(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.hsV.getText().toString());
                        b.this.hte.eW(b.this.htf.htF.videoUrl, b.this.htf.threadId);
                        b.this.hsT.setVisibility(8);
                        b.this.EG("2");
                    } else {
                        b.this.hsU.setVisibility(0);
                    }
                    b.this.onClick(b.this.hsR);
                }
            });
            this.hte.tl(false);
            this.hth = new y();
            this.hth.ais = gVar.threadId;
            this.hth.evm = gVar.forumId;
            this.hth.mUid = TbadkCoreApplication.getCurrentAccount();
            this.hti = new y();
            this.hti.ais = gVar.threadId;
            this.hti.evm = gVar.forumId;
            this.hti.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.htn) {
                an anVar = new an("c12590");
                anVar.dh("tid", gVar.threadId);
                anVar.dh("nid", gVar.nid);
                anVar.ag("obj_param5", gVar.getVideoType());
                anVar.s("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.dh("fid", gVar.forumId);
                anVar.ag("obj_locate", i);
                anVar.ag(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.hth.kBr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hth.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.hth.kBt = "1";
                this.hti.kBr = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hti.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.hti.kBt = "1";
            } else {
                this.hth.kBt = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hth.mLocate = "12";
                this.hti.kBt = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.hti.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.htF != null) {
                this.hth.kBw = gVar.htF.videoMd5;
                this.hti.kBw = gVar.htF.videoMd5;
            }
            this.fbZ.setVideoStatsData(this.hth);
            this.hte.getVideoView().setBusiness(this.fbZ);
            this.hte.cuk();
            this.hte.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void nm(boolean z) {
                    if (!b.this.hte.pO()) {
                        b.this.hsS.setVisibility(0);
                    } else if (z) {
                        if (b.this.hsS.getVisibility() == 0) {
                            b.this.hsS.setVisibility(8);
                            b.this.hsS.startAnimation(b.this.htl);
                        }
                    } else if (b.this.hsS.getVisibility() == 8) {
                        b.this.hsS.setVisibility(0);
                        b.this.hsS.startAnimation(b.this.boW);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bXA() {
                    if (!b.this.hte.pO()) {
                        b.this.hsS.setVisibility(0);
                    } else if (b.this.hsS.getVisibility() == 0) {
                        b.this.hsS.setVisibility(8);
                        b.this.hsS.startAnimation(b.this.htl);
                    }
                }
            });
            this.hte.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.htk = true;
                        b.this.htj = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.ul(i);
                        b.this.hte.cho();
                    }
                }
            });
            this.hte.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.htf != null && b.this.htf.htF != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.htf.htF.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.hte.setThumbnail(gVar.htF.thumbnailUrl);
            this.hte.setVideoUrl(gVar.htF.videoUrl, gVar.threadId);
            this.hte.Kv(gVar.title);
            this.hte.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bXB() {
                    b.this.hsT.setVisibility(8);
                }
            });
            this.hte.cho();
            this.hte.show();
            if (gVar.autoPlay) {
                onClick(this.hsR);
                this.htk = false;
                this.hte.a(gVar.htF.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.htk = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EG(String str) {
        if (this.htf != null && this.htf.htF != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.htf.htF.videoMd5, "", str, this.hti, this.hte.cQm().getPcdnState());
            }
        }
    }

    public boolean isPlaying() {
        return this.hte.pO();
    }

    public void bXu() {
        if (isPlaying()) {
            this.hte.avT();
        }
    }

    public boolean um(int i) {
        return this.hte.BG(i);
    }

    public void bXv() {
        this.hsU.setVisibility(8);
        this.hte.stopPlay();
        if (this.hsS != null) {
            this.hsS.setVisibility(0);
        }
        if (this.hsT != null) {
            this.hsT.setVisibility(0);
        }
    }

    public void bXw() {
        if (this.hte != null) {
            this.hte.destroy();
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onDestroy() {
        bXw();
        if (this.htg != null) {
            this.htg.bXG();
        }
    }

    public String EH(String str) {
        if (str.indexOf(".") > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.htE != null) {
            this.agw.setText(TextUtils.isEmpty(gVar.htE.userNickname) ? gVar.htE.userName : gVar.htE.userNickname);
            this.hsX.startLoad(gVar.htE.portrait, 12, false);
            this.hsX.setShowV(gVar.htE.isGod);
            this.hsX.setIsBigV(gVar.htE.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.htE != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.htE.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.htE.userId)) {
                this.fWi.setVisibility(8);
            } else {
                this.fWi.setVisibility(0);
            }
            if (gVar.htE.hasFocus) {
                am.setViewTextColor(this.fWi, (int) R.color.cp_cont_d);
                this.fWi.setCompoundDrawables(null, null, null, null);
                this.fWi.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.fWi, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.fWi.setCompoundDrawables(drawable, null, null, null);
            this.fWi.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.htb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.hsZ, (int) R.color.cp_cont_h);
            } else {
                this.htb.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.hsZ, (int) R.color.cp_cont_f);
            }
            this.hsZ.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.hsY, (int) R.color.cp_cont_f);
            this.hta.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.hsY.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.hte != null && this.hsR != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.htj) {
                this.hte.cQs();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.hsR.getParent() != null) {
                    if (this.hsR.getParent() == frameLayout) {
                        frameLayout.removeView(this.hsR);
                    } else if (this.hsR.getParent() == this.hsQ) {
                        this.hsQ.removeView(this.hsR);
                    }
                }
                if (this.hsR.getParent() == null) {
                    frameLayout.addView(this.hsR);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hsR.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.hsR.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.hsR.getParent() != null) {
                    if (this.hsR.getParent() == frameLayout) {
                        frameLayout.removeView(this.hsR);
                    } else if (this.hsR.getParent() == this.hsQ) {
                        this.hsQ.removeView(this.hsR);
                    }
                }
                if (this.hsR.getParent() == null) {
                    this.hsQ.addView(this.hsR, 0);
                    this.hsR.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.hte.cuk();
                    this.htj = true;
                } else {
                    return;
                }
            }
            this.hte.a(this.mPageContext, configuration);
            this.hsT.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            view.setTag(this);
            bKU().a(view, this.htf);
        }
        if (view == this.hsX || view == this.agw) {
            boolean z = false;
            if (this.htf != null && this.htf.htE != null && !TextUtils.isEmpty(this.htf.htE.userId)) {
                if (TbadkCoreApplication.isLogin() && this.htf.htE.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(this.htf.htE.userId, 0L), z, this.htf.htE.isGod)));
            }
        } else if (view == this.htc || view == this.hsS || view == getView()) {
            if (this.htf != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.htf.threadId, null, null);
                if (!this.htn) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.hsW) {
            if (this.htf != null && this.htf.htF != null) {
                this.hsU.setVisibility(8);
                this.hte.cQv();
                this.hte.eW(this.htf.htF.videoUrl, this.htf.threadId);
                EG("2");
            }
        } else if (view == this.fWi) {
            if (!this.htf.htE.hasFocus) {
                this.htg.f(this.htf);
            }
        } else if (view == this.htd) {
            this.htg.g(this.htf);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void nk(boolean z) {
        if (this.htf != null && this.htf.htE != null) {
            this.htf.htE.hasFocus = z;
            c(this.htf);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bXx() {
        if (this.htf != null) {
            this.htf.hasAgree = !this.htf.hasAgree;
            if (this.htf.hasAgree) {
                this.htf.agreeNum++;
            } else {
                this.htf.agreeNum--;
            }
            if (this.htb != null) {
                this.htb.startAnimation(getScaleAnimation());
            }
            d(this.htf);
        }
    }

    private Animation getScaleAnimation() {
        if (this.htm == null) {
            this.htm = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.htm.setDuration(200L);
        }
        return this.htm;
    }
}
