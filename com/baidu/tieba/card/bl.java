package com.baidu.tieba.card;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class bl extends com.baidu.tieba.card.a<com.baidu.tieba.card.a.m> {
    private TbPageContext<?> DV;
    private com.baidu.tieba.card.a.m aQC;
    public a aQD;
    private View.OnClickListener aQE;
    private View.OnClickListener aQF;
    private CustomMessageListener aQc;

    public bl(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aQE = new bm(this);
        this.aQF = new bn(this);
        this.aQc = new bo(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.DV = tbPageContext;
        w(getView());
        nq();
    }

    private void w(View view) {
        this.aQD = new a();
        this.aQD.mRootView = view.findViewById(t.g.card_root_view);
        this.aQD.aQI = view.findViewById(t.g.top_line);
        this.aQD.aPC = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.aQD.aQp = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.aQD.aQJ = (TextView) view.findViewById(t.g.thread_title);
        this.aQD.aQK = (TextView) view.findViewById(t.g.fans_num);
        this.aQD.aQL = (TbImageView) view.findViewById(t.g.thread_image);
        this.aQD.aQM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.aQD.mRootView.setOnClickListener(this);
        this.aQD.aQM.setOnClickListener(this);
    }

    private void nq() {
        this.aQD.aPC.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.aQD.aPC.setDefaultResource(17170445);
        this.aQD.aPC.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.aQD.aPC.setDefaultBgResource(t.d.cp_bg_line_e);
        this.aQD.aQM.setShowPraiseNum(false);
        this.aQD.aQL.setDrawBorder(true);
        this.aQD.aQL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int JP() {
        return t.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tieba.card.a.m mVar) {
        this.aQC = mVar;
        JY();
    }

    private void JY() {
        if (this.aQC == null || this.aQC.aRZ == null) {
            this.aQD.mRootView.setVisibility(8);
            return;
        }
        this.aQD.aPC.setData(this.aQC.aRZ);
        this.aQD.aPC.setAfterClickListener(this.aQE);
        this.aQD.aQp.setData(this.aQC.aRZ);
        this.aQD.aQp.setUserNameTextSizeRid(t.e.fontsize24);
        this.aQD.aQp.setUserAfterClickListener(this.aQE);
        Resources resources = this.DV.getResources();
        String string = resources.getString(t.j.recommend_live_title_prefix);
        new SpannableStringBuilder(String.valueOf(string) + this.aQC.aRZ.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        this.aQD.aQJ.setText(e(this.aQC.aRZ.getTitle()));
        String fansNickName = this.aQC.aRZ.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(t.j.fans_default_name);
        }
        this.aQD.aQK.setText(String.valueOf(fansNickName) + ": " + com.baidu.tbadk.core.util.ay.A(this.aQC.aRZ.getAuthor().getFansNum()));
        this.aQD.aQM.setData(this.aQC.aRZ);
        this.aQD.aQM.setForumAfterClickListener(this.aQF);
        this.aQD.aQM.setStType(au.Kd());
        this.aQD.aQM.setYuelaouLocate("feed#" + this.aQC.Kj());
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        if (com.baidu.tbadk.core.l.ob().oh() && this.aQC.aRZ.getPhotoLiveCover() != null && this.aQC.aRZ.getPhotoLiveCover().length() != 0) {
            this.aQD.aQL.setVisibility(0);
            this.aQD.aQL.c(this.aQC.aRZ.getPhotoLiveCover(), 10, false);
        } else {
            this.aQD.aQL.setVisibility(8);
        }
        com.baidu.tbadk.core.util.at.c(this.aQD.aQK, t.d.cp_cont_d, 1);
        if (au.hc(this.aQC.aRZ.getId())) {
            com.baidu.tbadk.core.util.at.c(this.aQD.aQJ, t.d.cp_cont_d, 1);
        } else {
            com.baidu.tbadk.core.util.at.c(this.aQD.aQJ, t.d.cp_cont_b, 1);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.aQD.mRootView || view == this.aQD.aQM.getCommentNumView()) {
            if (JO() != null) {
                JO().a(this.aQD.mRootView, this.aQC);
            }
            Kg();
        }
    }

    private void Kg() {
        if (this.aQC != null && this.aQC.aRZ != null) {
            au.hb(this.aQC.aRZ.getId());
            if (!Kh()) {
                UtilHelper.showToast(this.DV.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.DV.getPageActivity(), this.aQC.aRZ.getTid()).ch(this.aQC.aRZ.ra()).ck(this.aQC.Kk()).ci(au.Kd()).oq()));
            hd(this.aQC.aRZ.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new bp(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.aQD.mRootView);
            this.aQD.aQp.sg();
            this.aQD.aQM.sg();
            com.baidu.tbadk.core.util.at.l(this.aQD.aQI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.aQD.mRootView, t.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Kh() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aQc != null) {
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.DV.getResources().getString(t.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        com.baidu.adp.widget.d dVar = new com.baidu.adp.widget.d(this.DV.getPageActivity(), com.baidu.tbadk.core.util.at.cz(t.f.pic_dot_title), 1);
        dVar.setOffset(3);
        spannableStringBuilder.setSpan(dVar, string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ClickableHeaderImageView aPC;
        public View aQI;
        public TextView aQJ;
        public TextView aQK;
        public TbImageView aQL;
        public ThreadCommentAndPraiseInfoLayout aQM;
        public UserIconLayout aQp;
        public View mRootView;

        public a() {
        }
    }
}
