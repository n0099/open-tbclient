package com.baidu.tieba.frs.entelechy.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.t;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ah extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.aq> {
    private TbPageContext<?> GM;
    private CustomMessageListener aZB;
    private int aqA;
    private int aqB;
    private int aqC;
    private int aqD;
    private int aqE;
    private int aqi;
    private ArrayList<Integer> aqj;
    private int aqu;
    private int aqv;
    private int aqw;
    private int aqx;
    private int aqy;
    private int aqz;
    private com.baidu.tbadk.core.data.aq bXu;
    public a bXv;
    private View.OnClickListener bai;
    private View.OnClickListener baj;

    public ah(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aqj = new ArrayList<>();
        this.aqi = 0;
        this.bai = new ai(this);
        this.baj = new aj(this);
        this.aZB = new ak(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GM = tbPageContext;
        this.aqu = (int) tbPageContext.getResources().getDimension(t.e.ds80);
        this.aqv = (int) tbPageContext.getResources().getDimension(t.e.ds280);
        this.aqw = (int) tbPageContext.getResources().getDimension(t.e.ds170);
        this.aqx = (int) tbPageContext.getResources().getDimension(t.e.ds320);
        this.aqy = (int) tbPageContext.getResources().getDimension(t.e.ds200);
        this.aqz = (int) tbPageContext.getResources().getDimension(t.e.ds60);
        this.aqA = (int) tbPageContext.getResources().getDimension(t.e.ds120);
        this.aqB = (int) tbPageContext.getResources().getDimension(t.e.ds160);
        this.aqC = (int) tbPageContext.getResources().getDimension(t.e.ds220);
        this.aqD = (int) tbPageContext.getResources().getDimension(t.e.ds240);
        this.aqE = (int) tbPageContext.getResources().getDimension(t.e.ds180);
        R(getView());
        initUI();
    }

    private void R(View view) {
        this.bXv = new a();
        this.bXv.mRootView = view.findViewById(t.g.card_root_view);
        this.bXv.bam = view.findViewById(t.g.top_line);
        this.bXv.bXk = (RelativeLayout) view.findViewById(t.g.live_card_content_root);
        this.bXv.aZc = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.bXv.bXh = (HeadPendantClickableView) view.findViewById(t.g.pendant_avatar);
        this.bXv.aYe = (ViewStub) view.findViewById(t.g.viewstub_headimage_mask);
        this.bXv.aZg = (LinearLayout) view.findViewById(t.g.live_card_content_layout);
        this.bXv.aZT = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.bXv.ban = (TextView) view.findViewById(t.g.thread_title);
        this.bXv.bXx = (TextView) view.findViewById(t.g.thread_context);
        this.bXv.bao = (TextView) view.findViewById(t.g.fans_num);
        this.bXv.bap = (TbImageView) view.findViewById(t.g.thread_image);
        this.bXv.baq = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.bXv.bXy = (TextView) view.findViewById(t.g.first_style_first_expression);
        this.bXv.bXz = (TextView) view.findViewById(t.g.first_style_second_expression);
        this.bXv.bXA = (TextView) view.findViewById(t.g.first_style_third_expression);
        this.bXv.bSm = (TbImageView) view.findViewById(t.g.frs_live_item_theme_card);
        this.bXv.bSD = (ThreadSkinView) view.findViewById(t.g.frs_live_skin);
        this.bXv.baq.setCommentNumClickListener(this);
        this.bXv.bXB = (GuessYourLikeHeaderView) view.findViewById(t.g.guess_your_like_header);
        this.bXv.bXC = view.findViewById(t.g.guess_your_like_bottom_line);
    }

    private void initUI() {
        this.bXv.aZc.setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.bXv.aZc.setDefaultResource(17170445);
        this.bXv.aZc.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bXv.aZc.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bXv.bXh.vW();
        this.bXv.bXh.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds70));
        this.bXv.bXh.getHeadView().setDefaultResource(17170445);
        this.bXv.bXh.getHeadView().setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bXv.bXh.getHeadView().setDefaultBgResource(t.d.cp_bg_line_e);
        this.bXv.bXh.getHeadView().setIsRound(true);
        this.bXv.bXh.getHeadView().setDrawBorder(false);
        this.bXv.bXh.getPendantView().setIsRound(true);
        this.bXv.bXh.getPendantView().setDrawBorder(false);
        this.bXv.baq.setShowPraiseNum(false);
        this.bXv.bap.setDrawBorder(true);
        this.bXv.bap.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return t.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.aq aqVar) {
        this.bXu = aqVar;
        Ny();
    }

    private void Ny() {
        String string;
        boolean z;
        if (this.bXu == null) {
            this.bXv.mRootView.setVisibility(8);
            return;
        }
        if (this.bXu.getAuthor() == null || this.bXu.getAuthor().getPendantData() == null || StringUtils.isNull(this.bXu.getAuthor().getPendantData().rc())) {
            if (this.bXu.getAuthor() != null && this.bXu.getAuthor().getGodUserData() != null && this.bXu.getAuthor().getGodUserData().getType() == 2) {
                this.bXv.aZc.setGodIconMargin(0);
            } else {
                this.bXv.aZc.setIsGod(false);
            }
            UserTbVipInfoData rC = this.bXu.rC();
            if (rC != null && rC.getvipV_url() != null) {
                if (this.bXv.aYe != null) {
                    if (this.bXv.aYf == null) {
                        this.bXv.aYe.inflate();
                        this.bXv.aYf = (TbImageView) getView().findViewById(t.g.user_head_mask);
                    }
                    this.bXv.aYf.setVisibility(0);
                    this.bXv.aYf.c(rC.getvipV_url(), 10, false);
                    this.bXv.aZc.setIsBigV(true);
                }
            } else {
                this.bXv.aZc.setIsBigV(false);
                if (this.bXv.aYf != null) {
                    this.bXv.aYf.setVisibility(8);
                }
            }
            this.bXv.aZc.setData(this.bXu);
            this.bXv.aZc.setAfterClickListener(this.bai);
            this.bXv.aZc.setVisibility(0);
            this.bXv.bXh.setVisibility(8);
        } else {
            this.bXv.aZc.setIsGod(false);
            this.bXv.aZc.setIsBigV(false);
            if (this.bXv.aYf != null) {
                this.bXv.aYf.setVisibility(8);
            }
            this.bXv.aZc.setVisibility(4);
            this.bXv.bXh.setVisibility(0);
            this.bXv.bXh.setData(this.bXu);
        }
        this.bXv.aZT.setData(this.bXu);
        this.bXv.aZT.setUserNameTextSizeRid(t.e.fontsize24);
        this.bXv.aZT.setUserAfterClickListener(this.bai);
        this.bXv.aZT.setPageName(1);
        Resources resources = this.GM.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.bXu.getTitle()).setSpan(new ForegroundColorSpan(av.getColor(t.d.cp_link_tip_a)), 0, resources.getString(t.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.bXu.getTitle())) {
            int length = this.bXu.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bXu.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bXv.ban.setSingleLine(true);
        } else {
            this.bXv.ban.setMaxLines(2);
        }
        this.bXv.ban.setText(e(this.bXu.getTitle()));
        String fansNickName = this.bXu.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(t.j.fans_default_name);
        }
        this.bXv.bao.setText(String.valueOf(fansNickName) + ": " + ba.w(this.bXu.getAuthor().getFansNum()));
        this.bXv.baq.setData(this.bXu);
        this.bXv.baq.setForumAfterClickListener(this.baj);
        this.bXv.baq.setStType(com.baidu.tieba.card.ap.ND());
        j(this.bXu);
        onChangeSkinType(this.GM, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oG().oM() && this.bXu.getPhotoLiveCover() != null && this.bXu.getPhotoLiveCover().length() != 0) {
            this.bXv.bap.setVisibility(0);
            this.bXv.bXx.setVisibility(8);
            this.bXv.bap.c(this.bXu.getPhotoLiveCover(), 10, false);
            b(this.bXu);
        } else {
            this.bXv.bap.setVisibility(8);
            this.bXv.bXy.setVisibility(8);
            this.bXv.bXz.setVisibility(8);
            this.bXv.bXA.setVisibility(8);
            String rI = this.bXu.rI();
            this.bXv.bXx.setText(rI);
            this.bXv.bXx.setVisibility(StringUtils.isNull(rI) ? 8 : 0);
        }
        if (this.bXv.bXB != null) {
            if ((this.bXu.rY() || this.bXu.rZ()) && com.baidu.tieba.tbadkCore.util.t.bke()) {
                this.bXv.bXB.setTitleText(StringUtils.isNull(this.bXu.rX()) ? getContext().getResources().getString(t.j.group_fourm_recommend_title) : this.bXu.rX());
                this.bXv.bXB.show();
                this.bXv.bam.setVisibility(8);
                if (this.bXv.bXC != null) {
                    this.bXv.bXC.setVisibility(0);
                }
                if (this.bXu.bbt) {
                    this.bXv.bXB.bqo();
                } else {
                    this.bXv.bXB.bqn();
                    if (this.bXu.bbu) {
                        this.bXv.bam.setVisibility(0);
                    }
                }
            } else {
                this.bXv.bXB.hide();
                this.bXv.bam.setVisibility(0);
                if (this.bXv.bXC != null) {
                    this.bXv.bXC.setVisibility(8);
                }
            }
        }
        av.c(this.bXv.bao, t.d.cp_cont_d, 1);
        if (com.baidu.tieba.card.ap.hH(this.bXu.getTid())) {
            av.c(this.bXv.ban, t.d.cp_cont_d, 1);
            av.c(this.bXv.bXx, t.d.cp_cont_d, 1);
            return;
        }
        av.c(this.bXv.ban, t.d.cp_cont_b, 1);
        av.c(this.bXv.bXx, t.d.cp_cont_j, 1);
    }

    private void j(bg bgVar) {
        MetaData author;
        if (bgVar != null && (author = bgVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo rU = bgVar.rU();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.bXv.aZc.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bXv.aZg.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.bXv.bSm.setVisibility(8);
                if (this.bXv.bSD != null) {
                    if (rU != null) {
                        this.bXv.bSD.a(this.GM, rU, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bgVar.getFid()), bgVar.getForum_name(), bgVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds16);
                    } else {
                        this.bXv.bSD.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds30);
                    }
                }
            } else {
                this.bXv.bSm.setVisibility(0);
                this.bXv.bSm.setImageBitmap(null);
                this.bXv.bSm.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.bXv.bSm.setOnClickListener(new al(this, themeCard));
                this.bXv.bSD.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GM.getPageActivity(), t.e.ds30);
            }
            this.bXv.aZc.setLayoutParams(layoutParams);
            this.bXv.aZg.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bXv.mRootView || view == this.bXv.baq.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.bXv.mRootView, this.bXu);
            }
            NG();
        }
    }

    private void NG() {
        PhotoLiveActivityConfig oW;
        if (this.bXu != null) {
            com.baidu.tieba.card.ap.hG(this.bXu.getTid());
            if (!NH()) {
                UtilHelper.showToast(this.GM.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            if (this.bXu.rV() > 0 && com.baidu.tieba.tbadkCore.util.t.bke()) {
                oW = new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bXu.getTid()).ck("from_frs").bF(18003).ci(String.valueOf(this.bXu.rV())).oW();
            } else {
                oW = new PhotoLiveActivityConfig.a(this.GM.getPageActivity(), this.bXu.getTid()).ck("from_frs").bF(18003).oW();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oW));
            hI(this.bXu.getTid());
        }
    }

    public void hI(String str) {
        new Handler().postDelayed(new am(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.j.a.a(tbPageContext, this.bXv.mRootView);
            this.bXv.aZT.ti();
            this.bXv.baq.ti();
            av.l(this.bXv.bam, t.d.cp_bg_line_c);
            av.k(this.bXv.mRootView, t.f.addresslist_item_bg);
            if (this.bXv.bXB != null) {
                this.bXv.bXB.ti();
            }
            av.l(this.bXv.bXC, t.d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    private boolean NH() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aZB != null) {
            this.aZB.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aZB);
        }
    }

    private void b(com.baidu.tbadk.core.data.aq aqVar) {
        this.aqj.clear();
        Bb();
        if (aqVar != null && aqVar.rS() != null) {
            int size = aqVar.rS().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = aqVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, aqVar.rS(), i);
                }
            }
            Ba();
        }
    }

    private void Bb() {
        this.bXv.bXy.setText("");
        this.bXv.bXz.setText("");
        this.bXv.bXA.setText("");
        if (this.bXv.bXy.getVisibility() == 8) {
            this.bXv.bXy.setVisibility(0);
        }
        if (this.bXv.bXz.getVisibility() == 8) {
            this.bXv.bXz.setVisibility(0);
        }
        if (this.bXv.bXA.getVisibility() == 8) {
            this.bXv.bXA.setVisibility(0);
        }
        this.aqj.add(Integer.valueOf(this.bXv.bXy.getId()));
        this.aqj.add(Integer.valueOf(this.bXv.bXz.getId()));
        this.aqj.add(Integer.valueOf(this.bXv.bXA.getId()));
    }

    private void Ba() {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i = 0; i < size; i++) {
                if (this.aqj.get(i).intValue() == this.bXv.bXy.getId()) {
                    this.bXv.bXy.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.bXv.bXz.getId()) {
                    this.bXv.bXz.setVisibility(8);
                } else if (this.aqj.get(i).intValue() == this.bXv.bXA.getId()) {
                    this.bXv.bXA.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqi) {
                case 0:
                    a(this.aqu, this.aqv, this.bXv.bXy);
                    a(this.aqw, this.aqx, this.bXv.bXz);
                    a(this.aqy, this.aqz, this.bXv.bXA);
                    break;
                case 1:
                    a(this.aqz, this.aqA, this.bXv.bXy);
                    a(this.aqB, this.aqz, this.bXv.bXz);
                    a(this.aqC, this.aqx, this.bXv.bXA);
                    break;
                case 2:
                    a(this.aqz, this.aqD, this.bXv.bXy);
                    a(this.aqE, this.aqz, this.bXv.bXz);
                    a(this.aqC, this.aqx, this.bXv.bXA);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bXv.bXy);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bXv.bXz);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bXv.bXA);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.n nVar, TextView textView) {
        if (nVar != null && textView != null) {
            if (!a(nVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(nVar.aj(nVar.getLabelName(), String.valueOf(nVar.AM())));
            eg(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.n nVar) {
        return (nVar == null || StringUtils.isNull(nVar.getLabelName())) ? false : true;
    }

    private void eg(int i) {
        if (this.aqj.size() != 0) {
            int size = this.aqj.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqj.get(i2).intValue() == i) {
                    this.aqj.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GM.getResources().getString(t.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(av.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        Bitmap cN = av.cN(t.f.pic_dot_title);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cN);
        if (cN != null) {
            bitmapDrawable.setBounds(0, 0, cN.getWidth(), cN.getHeight());
        }
        spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.ai(bitmapDrawable), string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public ViewStub aYe;
        public TbImageView aYf;
        public UserIconLayout aZT;
        public ClickableHeaderImageView aZc;
        public LinearLayout aZg;
        public ThreadSkinView bSD;
        public TbImageView bSm;
        public TextView bXA;
        public GuessYourLikeHeaderView bXB;
        public View bXC;
        public HeadPendantClickableView bXh;
        public RelativeLayout bXk;
        public TextView bXx;
        public TextView bXy;
        public TextView bXz;
        public View bam;
        public TextView ban;
        public TextView bao;
        public TbImageView bap;
        public ThreadCommentAndPraiseInfoLayout baq;
        public View mRootView;

        public a() {
        }
    }
}
