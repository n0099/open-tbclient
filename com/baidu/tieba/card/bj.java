package com.baidu.tieba.card;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.plugins.XiaoyingUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class bj extends com.baidu.tieba.card.a<com.baidu.tieba.card.data.o> {
    private TbPageContext<?> Gd;
    private com.baidu.tieba.card.data.o aZM;
    private CustomMessageListener aZT;
    private final View.OnClickListener ahd;
    private final View.OnClickListener ahz;
    private final String baJ;
    public a baK;
    private int mSkinType;

    /* JADX DEBUG: Marked for inline */
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Failed to check method usage
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1631)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
    	at java.base/java.util.stream.ReduceOps$ReduceOp.evaluateSequential(ReduceOps.java:921)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.collect(ReferencePipeline.java:682)
    	at jadx.core.codegen.ClassGen.skipMethod(ClassGen.java:332)
    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:298)
    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:272)
    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
     */
    public static /* synthetic */ com.baidu.tieba.card.data.o a(bj bjVar) {
        return bjVar.aZM;
    }

    public bj(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.baJ = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        this.mSkinType = 3;
        this.ahz = new bk(this);
        this.aZT = new bl(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.ahd = new bm(this);
        this.Gd = tbPageContext;
        this.baK = new a();
        R(getView());
    }

    private void R(View view) {
        this.baK.baM = view.findViewById(r.g.layout_root);
        this.baK.aZD = view.findViewById(r.g.divider);
        this.baK.aZw = (ClickableHeaderImageView) view.findViewById(r.g.image_user);
        this.baK.aYH = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.baK.aZw.setDefaultResource(17170445);
        this.baK.aZw.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.baK.aZw.setDefaultBgResource(r.d.cp_bg_line_e);
        this.baK.aZw.setRadius(com.baidu.adp.lib.util.k.e(this.Gd.getPageActivity(), r.e.ds70));
        this.baK.aZz = (UserIconLayout) view.findViewById(r.g.text_user_name);
        this.baK.mTextTitle = (TextView) view.findViewById(r.g.text_title);
        this.baK.aZx = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.text_bottom);
        this.baK.aZy = (FrameLayout) view.findViewById(r.g.frame_video);
        this.baK.aZE = (TbImageView) view.findViewById(r.g.image_video);
        this.baK.aZE.setDefaultBgResource(r.f.pic_bg_video_frs);
        this.baK.aZE.setDefaultResource(0);
        this.baK.aZE.setDefaultErrorResource(0);
        this.baK.aZF = (ImageView) view.findViewById(r.g.image_video_play);
        this.baK.baM.setOnClickListener(this);
        this.baK.aZy.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.baK.baM) {
            T(view);
        } else if (view == this.baK.aZy) {
            U(view);
        }
    }

    public void setBarNameClickEnabled(boolean z) {
        if (this.baK != null && this.baK.aZx != null) {
            this.baK.aZx.setBarNameClickEnabled(z);
        }
    }

    private void T(View view) {
        if (getOnSubCardOnClickListenner() != null) {
            getOnSubCardOnClickListenner().a(view, this.aZM);
        }
        if (this.aZM != null && this.aZM.bbU != null) {
            if (!NW()) {
                an.hN(this.aZM.bbU.getId());
            }
            this.Gd.sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.Gd.getPageActivity()).createFromThreadCfg(this.aZM.bbU, null, an.Od(), 18003, true, false, false).addLocateParam(this.aZM.Ol())));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean NW() {
        return this.aZM.bcm && !this.aZM.bcy;
    }

    private void U(View view) {
        if (this.aZM != null && this.aZM.bbU != null && this.aZM.bbU.sd() != null) {
            cd<com.baidu.tieba.card.data.o> onSubCardOnClickListenner = getOnSubCardOnClickListenner();
            if (onSubCardOnClickListenner != null) {
                view.setTag(TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE);
                onSubCardOnClickListenner.a(view, this.aZM);
            }
            if (!com.baidu.adp.lib.util.i.gm()) {
                com.baidu.adp.lib.util.k.m(getContext(), getContext().getString(r.j.neterror));
            } else {
                XiaoyingUtil.startPlayXiaoyingVideo(this.Gd.getPageActivity(), this.aZM.bbU.sd().video_url, this.aZM.bbU.sd().video_width.intValue(), this.aZM.bbU.sd().video_height.intValue(), this.aZM.bbU.sd().thumbnail_url);
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_video_thread;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.card.data.o oVar) {
        this.aZM = oVar;
        NZ();
    }

    private void NZ() {
        if (this.aZM == null || this.aZM.bbU == null || this.aZM.bbU.getAuthor() == null) {
            this.baK.baM.setVisibility(8);
            return;
        }
        this.baK.baM.setVisibility(0);
        if (this.aZM.bcm) {
            this.baK.aZw.setVisibility(8);
            this.baK.aZz.setVisibility(8);
        } else {
            this.baK.aZz.setVisibility(0);
            this.baK.aZw.setVisibility(0);
            this.baK.aZw.setData(this.aZM.bbU);
            this.baK.aZw.setAfterClickListener(this.ahz);
            UserTbVipInfoData rO = this.aZM.Jv().rO();
            if (rO != null && rO.getvipV_url() != null && this.baK.aYH != null) {
                if (this.baK.aYI == null) {
                    this.baK.aYH.inflate();
                    this.baK.aYI = (TbImageView) getView().findViewById(r.g.user_head_mask);
                }
                this.baK.aYI.c(rO.getvipV_url(), 10, false);
                this.baK.aZw.setIsBigV(true);
            }
        }
        this.baK.aZz.setData(this.aZM.bbU);
        this.baK.aZz.setUserAfterClickListener(this.ahz);
        an.a(this.aZM.bbU, this.baK.mTextTitle);
        this.baK.aZx.setData(this.aZM.bbU);
        this.baK.aZx.setStType(an.Od());
        this.baK.aZx.setYuelaouLocate("feed#" + this.aZM.Ok());
        this.baK.aZx.setForumAfterClickListener(this.ahd);
        onChangeSkinType(this.Gd, TbadkCoreApplication.m9getInst().getSkinType());
        if (!NW()) {
            an.a(this.baK.mTextTitle, this.aZM.bbU.getId(), r.d.cp_cont_b, r.d.cp_cont_d);
        } else {
            com.baidu.tbadk.core.util.av.j((View) this.baK.mTextTitle, r.d.cp_cont_b);
        }
        if (com.baidu.tbadk.core.l.oH().oN() && this.aZM.bbU.sd() != null && !StringUtils.isNull(this.aZM.bbU.sd().video_url)) {
            this.baK.aZE.c(this.aZM.bbU.sd().thumbnail_url, 10, true);
            this.baK.aZy.setVisibility(0);
        } else {
            this.baK.aZy.setVisibility(8);
        }
        if (this.aZM.bcy) {
            setBarNameClickEnabled(true);
        } else {
            setBarNameClickEnabled(false);
        }
        this.baK.aZy.setClickable(false);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.av.k(this.baK.baM, r.f.addresslist_item_bg);
            com.baidu.tbadk.core.util.av.l(this.baK.aZD, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.av.j((View) this.baK.mTextTitle, r.d.cp_cont_b);
            com.baidu.tbadk.core.util.av.c(this.baK.aZF, r.f.btn_icon_play_video_n);
            this.baK.aZz.tx();
            this.baK.aZx.tx();
            this.mSkinType = i;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        if (bdUniqueId != null && this.baK != null && this.baK.aZx != null && this.aZT != null) {
            this.baK.aZx.h(bdUniqueId);
            this.aZT.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZT);
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYH;
        public TbImageView aYI;
        public View aZD;
        public TbImageView aZE;
        public ImageView aZF;
        public ClickableHeaderImageView aZw;
        public ThreadCommentAndPraiseInfoLayout aZx;
        public FrameLayout aZy;
        public UserIconLayout aZz;
        public View baM;
        public TextView mTextTitle;

        public a() {
        }
    }
}
