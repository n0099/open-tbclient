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
import com.baidu.android.imsdk.internal.DefaultConfig;
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
import com.baidu.tieba.play.z;
import com.tencent.connect.common.Constants;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<g> implements c {
    public TextView He;
    private Animation ayN;
    private boolean cfz;
    private n dvI;
    public TextView ehc;
    public FrameLayout fAc;
    public FrameLayout fAd;
    public TextView fAe;
    public TextView fAf;
    public FrameLayout fAg;
    public TextView fAh;
    public TextView fAi;
    public HeadImageView fAj;
    public TextView fAk;
    public TextView fAl;
    public ImageView fAm;
    public ImageView fAn;
    public LinearLayout fAo;
    public LinearLayout fAp;
    public com.baidu.tieba.play.c fAq;
    public g fAr;
    private h fAs;
    private z fAt;
    private z fAu;
    private boolean fAv;
    private boolean fAw;
    private Animation fAx;
    private ScaleAnimation fAy;
    private boolean fAz;
    private boolean isFullScreen;
    private TbPageContext<?> mPageContext;
    public int mPosition;
    private int mWidth;

    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        this.fAv = true;
        this.fAz = z;
        View view = getView();
        this.mPageContext = tbPageContext;
        this.fAc = (FrameLayout) view.findViewById(R.id.video_agg_container);
        this.fAd = (FrameLayout) view.findViewById(R.id.video_container);
        this.fAq = new com.baidu.tieba.play.c(tbPageContext, (View) this.fAd, false);
        this.fAe = (TextView) view.findViewById(R.id.title);
        this.fAf = (TextView) view.findViewById(R.id.duration);
        this.fAg = (FrameLayout) view.findViewById(R.id.mobile_network_container);
        this.fAh = (TextView) view.findViewById(R.id.mobile_network_text);
        this.fAi = (TextView) view.findViewById(R.id.mobile_network_play);
        this.fAj = (HeadImageView) view.findViewById(R.id.user_icon);
        this.He = (TextView) view.findViewById(R.id.user_name);
        this.ehc = (TextView) view.findViewById(R.id.attention);
        this.fAo = (LinearLayout) view.findViewById(R.id.thread_info_commont_container);
        this.fAp = (LinearLayout) view.findViewById(R.id.agree_view_container);
        this.fAk = (TextView) view.findViewById(R.id.thread_info_commont_num);
        this.fAl = (TextView) view.findViewById(R.id.thread_info_praise_num);
        this.fAm = (ImageView) view.findViewById(R.id.thread_info_commont_img);
        this.fAn = (ImageView) view.findViewById(R.id.thread_info_praise_img);
        this.fAo.setOnClickListener(this);
        this.fAp.setOnClickListener(this);
        this.fAe.setOnClickListener(this);
        this.fAj.setOnClickListener(this);
        this.He.setOnClickListener(this);
        this.ehc.setOnClickListener(this);
        view.setOnClickListener(this);
        this.fAi.setOnClickListener(this);
        this.mWidth = l.getEquipmentWidth(tbPageContext.getPageActivity());
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fAc.getLayoutParams();
        layoutParams.height = (int) (0.5625f * this.mWidth);
        this.fAc.setLayoutParams(layoutParams);
        this.fAj.setIsRound(true);
        this.dvI = new n(tbPageContext.getPageActivity());
        this.fAs = new h(this.mPageContext, this);
        this.fAx = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_1_to_0_duration_200);
        this.ayN = AnimationUtils.loadAnimation(tbPageContext.getPageActivity(), R.anim.anim_alpha_0_to_1_duration_200_accelerate);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            tbPageContext.getLayoutMode().setNightMode(i == 1);
            tbPageContext.getLayoutMode().onModeChanged(getView());
            am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
            if (this.fAr != null && this.fAr.fAQ != null) {
                if (this.fAr.fAQ.hasFocus) {
                    am.setViewTextColor(this.ehc, (int) R.color.cp_cont_d);
                    this.ehc.setCompoundDrawables(null, null, null, null);
                } else {
                    am.setViewTextColor(this.ehc, (int) R.color.cp_link_tip_a);
                    Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
                    drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
                    this.ehc.setCompoundDrawables(drawable, null, null, null);
                }
            }
            if (this.fAr != null) {
                if (this.fAr.hasAgree) {
                    this.fAn.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                    am.setViewTextColor(this.fAl, (int) R.color.cp_cont_h);
                } else {
                    this.fAn.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                    am.setViewTextColor(this.fAl, (int) R.color.cp_cont_f);
                }
            }
            am.setViewTextColor(this.fAk, (int) R.color.cp_cont_f);
            this.fAm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
        }
        this.mSkinType = i;
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.card_video_aggregation_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(g gVar) {
    }

    public void a(g gVar, int i, a aVar) {
        String format;
        if (gVar != null && gVar.fAR != null) {
            this.fAr = gVar;
            this.cfz = this.fAr.autoPlay;
            this.fAe.setVisibility(0);
            this.fAe.setText(gVar.title);
            this.fAf.setVisibility(0);
            this.fAf.setText(aq.stringForVideoTime(gVar.fAR.videoDuration * 1000));
            if (gVar.fAR.videoSize == 0) {
                format = this.mPageContext.getString(R.string.video_mobile_play_tips);
            } else {
                format = String.format(this.mPageContext.getString(R.string.video_mobile_network_tips), vS(String.format("%.1f", Float.valueOf(((float) gVar.fAR.videoSize) / 1048576.0f))));
            }
            this.fAh.setText(format);
            this.fAg.setVisibility(8);
            b(gVar, i, aVar);
            b(gVar);
            onChangeSkinType(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    private void b(g gVar, final int i, final a aVar) {
        if (gVar != null && gVar.fAR != null) {
            this.fAq.stopPlay();
            this.fAq.setIsNeedRecoveryVideoPlayer(true);
            this.fAq.pN(true);
            this.fAq.pJ(false);
            this.fAq.a(new c.InterfaceC0492c() { // from class: com.baidu.tieba.frs.aggregation.b.1
                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kv() {
                    if (b.this.fAq.kx()) {
                        b.this.fAf.setVisibility(8);
                    }
                }

                @Override // com.baidu.tieba.play.c.InterfaceC0492c
                public void kw() {
                    if (b.this.fAq.kx()) {
                        b.this.fAf.setVisibility(8);
                    }
                    if (b.this.fAw) {
                        b.this.fAq.stopPlay();
                    }
                }
            });
            this.fAq.a(new c.l() { // from class: com.baidu.tieba.frs.aggregation.b.2
                @Override // com.baidu.tieba.play.c.l
                public void bmk() {
                    b.this.fAw = false;
                    b.this.fAf.setVisibility(8);
                    b.this.vR(b.this.cfz ? "1" : "2");
                    b.this.onClick(b.this.fAd);
                }

                @Override // com.baidu.tieba.play.c.l
                public void bml() {
                    b.this.fAf.setVisibility(8);
                    b.this.onClick(b.this.fAc);
                }
            });
            this.fAq.a(new c.f() { // from class: com.baidu.tieba.frs.aggregation.b.3
                @Override // com.baidu.tieba.play.c.f
                public void kh(boolean z) {
                    if (z) {
                        b.this.mPageContext.showToast(b.this.fAh.getText().toString());
                        b.this.fAq.cm(b.this.fAr.fAR.videoUrl, b.this.fAr.threadId);
                        b.this.fAf.setVisibility(8);
                        b.this.vR("2");
                    } else {
                        b.this.fAg.setVisibility(0);
                    }
                    b.this.onClick(b.this.fAd);
                }
            });
            this.fAq.pF(false);
            this.fAt = new z();
            this.fAt.cma = gVar.threadId;
            this.fAt.ePc = gVar.forumId;
            this.fAt.mUid = TbadkCoreApplication.getCurrentAccount();
            this.fAu = new z();
            this.fAu.cma = gVar.threadId;
            this.fAu.ePc = gVar.forumId;
            this.fAu.mUid = TbadkCoreApplication.getCurrentAccount();
            if (this.fAz) {
                an anVar = new an("c12590");
                anVar.bS("tid", gVar.threadId);
                anVar.p("uid", TbadkCoreApplication.getCurrentAccountId());
                anVar.bS("fid", gVar.forumId);
                anVar.O("obj_locate", i);
                anVar.O(TiebaInitialize.Params.OBJ_PARAM2, 1);
                TiebaStatic.log(anVar);
                this.fAt.iyj = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fAt.mLocate = Constants.VIA_REPORT_TYPE_JOININ_GROUP;
                this.fAt.iyl = "1";
                this.fAu.iyj = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fAu.mLocate = ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE;
                this.fAu.iyl = "1";
            } else {
                this.fAt.iyl = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.fAt.mLocate = Constants.VIA_REPORT_TYPE_SET_AVATAR;
                this.fAu.iyl = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
                this.fAu.mLocate = ConstantData.VideoLocationType.VIDEO_AGGREGATION;
            }
            if (gVar.fAR != null) {
                this.fAt.iyn = gVar.fAR.videoMd5;
                this.fAu.iyn = gVar.fAR.videoMd5;
            }
            this.dvI.setVideoStatsData(this.fAt);
            this.fAq.getVideoView().setBusiness(this.dvI);
            this.fAq.bIG();
            this.fAq.b(new c.d() { // from class: com.baidu.tieba.frs.aggregation.b.4
                @Override // com.baidu.tieba.play.c.d
                public void ki(boolean z) {
                    if (!b.this.fAq.kx()) {
                        b.this.fAe.setVisibility(0);
                    } else if (z) {
                        if (b.this.fAe.getVisibility() == 0) {
                            b.this.fAe.setVisibility(8);
                            b.this.fAe.startAnimation(b.this.fAx);
                        }
                    } else if (b.this.fAe.getVisibility() == 8) {
                        b.this.fAe.setVisibility(0);
                        b.this.fAe.startAnimation(b.this.ayN);
                    }
                }

                @Override // com.baidu.tieba.play.c.d
                public void bmm() {
                    if (!b.this.fAq.kx()) {
                        b.this.fAe.setVisibility(0);
                    } else if (b.this.fAe.getVisibility() == 0) {
                        b.this.fAe.setVisibility(8);
                        b.this.fAe.startAnimation(b.this.fAx);
                    }
                }
            });
            this.fAq.a(new g.a() { // from class: com.baidu.tieba.frs.aggregation.b.5
                @Override // com.baidu.tieba.play.g.a
                public void onCompletion(com.baidu.tieba.play.g gVar2) {
                    if (b.this.isFullScreen) {
                        b.this.fAw = true;
                        b.this.fAv = false;
                    }
                    if (aVar != null && !b.this.isFullScreen) {
                        aVar.qN(i);
                        b.this.fAq.bvK();
                    }
                }
            });
            this.fAq.a(new g.b() { // from class: com.baidu.tieba.frs.aggregation.b.6
                @Override // com.baidu.tieba.play.g.b
                public boolean onError(com.baidu.tieba.play.g gVar2, int i2, int i3) {
                    if (b.this.fAr != null && b.this.fAr.fAR != null) {
                        BdStatisticsManager.getInstance().newDebug("videoplay", 0L, null, "verrno", Integer.valueOf(i2), "extra", Integer.valueOf(i3), "url", b.this.fAr.fAR.videoUrl);
                    }
                    if (aVar != null) {
                        aVar.cancel();
                    }
                    return true;
                }
            });
            this.fAq.setThumbnail(gVar.fAR.thumbnailUrl);
            this.fAq.setVideoUrl(gVar.fAR.videoUrl, gVar.threadId);
            this.fAq.BN(gVar.title);
            this.fAq.a(new c.i() { // from class: com.baidu.tieba.frs.aggregation.b.7
                @Override // com.baidu.tieba.play.c.i
                public void bmn() {
                    b.this.fAf.setVisibility(8);
                }
            });
            this.fAq.bvK();
            this.fAq.show();
            if (gVar.autoPlay) {
                onClick(this.fAd);
                this.fAw = false;
                this.fAq.a(gVar.fAR.videoUrl, gVar.threadId, (c.e) null, new Object[0]);
            }
            this.fAw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vR(String str) {
        if (this.fAr != null && this.fAr.fAR != null) {
            if ("1".equals(str) || "2".equals(str)) {
                com.baidu.tieba.play.l.a(this.fAr.fAR.videoMd5, "", str, this.fAu);
            }
        }
    }

    public boolean isPlaying() {
        return this.fAq.kx();
    }

    public void bmg() {
        if (isPlaying()) {
            this.fAq.pausePlay();
        }
    }

    public boolean qO(int i) {
        return this.fAq.xC(i);
    }

    public void bmh() {
        this.fAg.setVisibility(8);
        this.fAq.stopPlay();
        if (this.fAe != null) {
            this.fAe.setVisibility(0);
        }
        if (this.fAf != null) {
            this.fAf.setVisibility(0);
        }
    }

    public void bmi() {
        if (this.fAq != null) {
            this.fAq.destroy();
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onDestroy() {
        bmi();
        if (this.fAs != null) {
            this.fAs.bmt();
        }
    }

    public String vS(String str) {
        if (str.indexOf(DefaultConfig.TOKEN_SEPARATOR) > 0) {
            return str.replaceAll("0+?$", "").replaceAll("[.]$", "");
        }
        return str;
    }

    public void b(g gVar) {
        if (gVar != null && gVar.fAQ != null) {
            this.He.setText(TextUtils.isEmpty(gVar.fAQ.userNickname) ? gVar.fAQ.userName : gVar.fAQ.userNickname);
            this.fAj.startLoad(gVar.fAQ.portrait, 12, false);
            this.fAj.setShowV(gVar.fAQ.isGod);
            this.fAj.setIsBigV(gVar.fAQ.isGod);
            c(gVar);
            d(gVar);
            e(gVar);
        }
    }

    public void c(g gVar) {
        if (gVar != null && gVar.fAQ != null) {
            if (TbadkCoreApplication.isLogin() && !TextUtils.isEmpty(gVar.fAQ.userId) && TbadkCoreApplication.getCurrentAccount().equals(gVar.fAQ.userId)) {
                this.ehc.setVisibility(8);
            } else {
                this.ehc.setVisibility(0);
            }
            if (gVar.fAQ.hasFocus) {
                am.setViewTextColor(this.ehc, (int) R.color.cp_cont_d);
                this.ehc.setCompoundDrawables(null, null, null, null);
                this.ehc.setText(this.mPageContext.getString(R.string.relate_forum_is_followed));
                return;
            }
            am.setViewTextColor(this.ehc, (int) R.color.cp_link_tip_a);
            Drawable drawable = am.getDrawable(R.drawable.video_aggregation_attention_selector);
            drawable.setBounds(0, 0, l.getDimens(this.mContext, R.dimen.ds20), l.getDimens(this.mContext, R.dimen.ds20));
            this.ehc.setCompoundDrawables(drawable, null, null, null);
            this.ehc.setText(this.mPageContext.getString(R.string.attention));
        }
    }

    public void d(g gVar) {
        if (gVar != null) {
            if (gVar.hasAgree) {
                this.fAn.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_s));
                am.setViewTextColor(this.fAl, (int) R.color.cp_cont_h);
            } else {
                this.fAn.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_like_n));
                am.setViewTextColor(this.fAl, (int) R.color.cp_cont_f);
            }
            this.fAl.setText(aq.numFormatOverWan(gVar.agreeNum));
        }
    }

    public void e(g gVar) {
        if (gVar != null) {
            am.setViewTextColor(this.fAk, (int) R.color.cp_cont_f);
            this.fAm.setImageDrawable(am.getDrawable(R.drawable.icon_home_card_comment));
            this.fAk.setText(aq.numFormatOverWan(gVar.postNum));
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (this.fAq != null && this.fAd != null && this.mPageContext != null && this.mPageContext.getPageActivity() != null && this.mPageContext.getPageActivity().getWindow() != null && (this.mPageContext.getPageActivity().getWindow().getDecorView() instanceof FrameLayout)) {
            FrameLayout frameLayout = (FrameLayout) this.mPageContext.getPageActivity().getWindow().getDecorView();
            if (this.fAv) {
                this.fAq.cbK();
            }
            if (configuration.orientation == 2) {
                this.isFullScreen = true;
                if (this.fAd.getParent() != null) {
                    if (this.fAd.getParent() == frameLayout) {
                        frameLayout.removeView(this.fAd);
                    } else if (this.fAd.getParent() == this.fAc) {
                        this.fAc.removeView(this.fAd);
                    }
                }
                if (this.fAd.getParent() == null) {
                    frameLayout.addView(this.fAd);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fAd.getLayoutParams();
                    layoutParams.width = -1;
                    layoutParams.height = -1;
                    this.fAd.setLayoutParams(layoutParams);
                } else {
                    return;
                }
            } else {
                this.isFullScreen = false;
                if (this.fAd.getParent() != null) {
                    if (this.fAd.getParent() == frameLayout) {
                        frameLayout.removeView(this.fAd);
                    } else if (this.fAd.getParent() == this.fAc) {
                        this.fAc.removeView(this.fAd);
                    }
                }
                if (this.fAd.getParent() == null) {
                    this.fAc.addView(this.fAd, 0);
                    this.fAd.setLayoutParams(new FrameLayout.LayoutParams(this.mWidth, (int) (0.5625f * this.mWidth)));
                    this.fAq.bIG();
                    this.fAv = true;
                } else {
                    return;
                }
            }
            this.fAq.a(this.mPageContext, configuration);
            this.fAf.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            view.setTag(this);
            aZV().a(view, this.fAr);
        }
        if (view == this.fAj || view == this.He) {
            boolean z = false;
            if (this.fAr != null && this.fAr.fAQ != null && !TextUtils.isEmpty(this.fAr.fAQ.userId)) {
                if (TbadkCoreApplication.isLogin() && this.fAr.fAQ.userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z = true;
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonPolymericActivityConfig(this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(this.fAr.fAQ.userId, 0L), z, this.fAr.fAQ.isGod)));
            }
        } else if (view == this.fAo || view == this.fAe || view == getView()) {
            if (this.fAr != null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.mContext);
                pbActivityConfig.createNormalCfg(this.fAr.threadId, null, null);
                if (!this.fAz) {
                    pbActivityConfig.setVideo_source("bavideotab");
                } else {
                    pbActivityConfig.setVideo_source(ConstantData.VideoLocationType.VIDEO_MIDDEL_PAGE);
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, pbActivityConfig));
            }
        } else if (view == this.fAi) {
            if (this.fAr != null && this.fAr.fAR != null) {
                this.fAg.setVisibility(8);
                this.fAq.cbN();
                this.fAq.cm(this.fAr.fAR.videoUrl, this.fAr.threadId);
                vR("2");
            }
        } else if (view == this.ehc) {
            if (!this.fAr.fAQ.hasFocus) {
                this.fAs.f(this.fAr);
            }
        } else if (view == this.fAp) {
            this.fAs.g(this.fAr);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void showMsg(String str) {
        this.mPageContext.showToast(str);
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void kg(boolean z) {
        if (this.fAr != null && this.fAr.fAQ != null) {
            this.fAr.fAQ.hasFocus = z;
            c(this.fAr);
        }
    }

    @Override // com.baidu.tieba.frs.aggregation.c
    public void bmj() {
        if (this.fAr != null) {
            this.fAr.hasAgree = !this.fAr.hasAgree;
            if (this.fAr.hasAgree) {
                this.fAr.agreeNum++;
            } else {
                this.fAr.agreeNum--;
            }
            if (this.fAn != null) {
                this.fAn.startAnimation(getScaleAnimation());
            }
            d(this.fAr);
        }
    }

    private Animation getScaleAnimation() {
        if (this.fAy == null) {
            this.fAy = new ScaleAnimation(1.3f, 1.0f, 1.3f, 1.0f, 1, 1.0f, 1, 1.0f);
            this.fAy.setDuration(200L);
        }
        return this.fAy;
    }
}
