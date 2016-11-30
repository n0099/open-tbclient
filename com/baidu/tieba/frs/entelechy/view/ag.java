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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.ThreadSkinView;
import com.baidu.tieba.r;
import com.baidu.tieba.view.GuessYourLikeHeaderView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.au> {
    private TbPageContext<?> GO;
    private int aqK;
    private ArrayList<Integer> aqL;
    private int aqW;
    private int aqX;
    private int aqY;
    private int aqZ;
    private int ara;
    private int arb;
    private int arc;
    private int ard;
    private int are;
    private int arf;
    private int arg;
    private View.OnClickListener bdJ;
    private View.OnClickListener bdK;
    private CustomMessageListener bdb;
    private com.baidu.tbadk.core.data.au caF;
    public a caG;

    public ag(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aqL = new ArrayList<>();
        this.aqK = 0;
        this.bdJ = new ah(this);
        this.bdK = new ai(this);
        this.bdb = new aj(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.GO = tbPageContext;
        this.aqW = (int) tbPageContext.getResources().getDimension(r.e.ds80);
        this.aqX = (int) tbPageContext.getResources().getDimension(r.e.ds280);
        this.aqY = (int) tbPageContext.getResources().getDimension(r.e.ds170);
        this.aqZ = (int) tbPageContext.getResources().getDimension(r.e.ds320);
        this.ara = (int) tbPageContext.getResources().getDimension(r.e.ds200);
        this.arb = (int) tbPageContext.getResources().getDimension(r.e.ds60);
        this.arc = (int) tbPageContext.getResources().getDimension(r.e.ds120);
        this.ard = (int) tbPageContext.getResources().getDimension(r.e.ds160);
        this.are = (int) tbPageContext.getResources().getDimension(r.e.ds220);
        this.arf = (int) tbPageContext.getResources().getDimension(r.e.ds240);
        this.arg = (int) tbPageContext.getResources().getDimension(r.e.ds180);
        S(getView());
        initUI();
    }

    private void S(View view) {
        this.caG = new a();
        this.caG.mRootView = view.findViewById(r.g.card_root_view);
        this.caG.bdN = view.findViewById(r.g.top_line);
        this.caG.cav = (RelativeLayout) view.findViewById(r.g.live_card_content_root);
        this.caG.bcF = (ClickableHeaderImageView) view.findViewById(r.g.avatar);
        this.caG.cas = (HeadPendantClickableView) view.findViewById(r.g.pendant_avatar);
        this.caG.bbQ = (ViewStub) view.findViewById(r.g.viewstub_headimage_mask);
        this.caG.bcK = (LinearLayout) view.findViewById(r.g.live_card_content_layout);
        this.caG.bdu = (UserIconLayout) view.findViewById(r.g.user_icon);
        this.caG.aNz = (TextView) view.findViewById(r.g.thread_title);
        this.caG.caI = (TextView) view.findViewById(r.g.thread_context);
        this.caG.bdO = (TextView) view.findViewById(r.g.fans_num);
        this.caG.bdP = (TbImageView) view.findViewById(r.g.thread_image);
        this.caG.bdQ = (ThreadCommentAndPraiseInfoLayout) view.findViewById(r.g.thread_more_info);
        this.caG.bdR = view.findViewById(r.g.divider_below_reply_number_layout);
        this.caG.caJ = (TextView) view.findViewById(r.g.first_style_first_expression);
        this.caG.caK = (TextView) view.findViewById(r.g.first_style_second_expression);
        this.caG.caL = (TextView) view.findViewById(r.g.first_style_third_expression);
        this.caG.bUs = (TbImageView) view.findViewById(r.g.frs_live_item_theme_card);
        this.caG.bUJ = (ThreadSkinView) view.findViewById(r.g.frs_live_skin);
        this.caG.bdQ.setCommentNumClickListener(this);
        this.caG.caM = (GuessYourLikeHeaderView) view.findViewById(r.g.guess_your_like_header);
        this.caG.caN = view.findViewById(r.g.guess_your_like_bottom_line);
    }

    private void initUI() {
        this.caG.bcF.setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.caG.bcF.setDefaultResource(17170445);
        this.caG.bcF.setDefaultErrorResource(r.f.icon_default_avatar100);
        this.caG.bcF.setDefaultBgResource(r.d.cp_bg_line_e);
        this.caG.cas.wo();
        this.caG.cas.getHeadView().setRadius(com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds70));
        this.caG.cas.getHeadView().setDefaultResource(17170445);
        this.caG.cas.getHeadView().setDefaultErrorResource(r.f.icon_default_avatar100);
        this.caG.cas.getHeadView().setDefaultBgResource(r.d.cp_bg_line_e);
        this.caG.cas.getHeadView().setIsRound(true);
        this.caG.cas.getHeadView().setDrawBorder(false);
        this.caG.cas.getPendantView().setIsRound(true);
        this.caG.cas.getPendantView().setDrawBorder(false);
        this.caG.bdQ.setShowPraiseNum(false);
        this.caG.bdP.setDrawBorder(true);
        this.caG.bdP.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tbadk.core.data.au auVar) {
        this.caF = auVar;
        Pb();
    }

    private void Pb() {
        String string;
        boolean z;
        if (this.caF == null) {
            this.caG.mRootView.setVisibility(8);
            return;
        }
        if (this.caF.getAuthor() == null || this.caF.getAuthor().getPendantData() == null || StringUtils.isNull(this.caF.getAuthor().getPendantData().pR())) {
            if (this.caF.getAuthor() != null && this.caF.getAuthor().getGodUserData() != null && this.caF.getAuthor().getGodUserData().getType() == 2) {
                this.caG.bcF.setGodIconMargin(0);
            } else {
                this.caG.bcF.setIsGod(false);
            }
            UserTbVipInfoData rQ = this.caF.rQ();
            if (rQ != null && rQ.getvipV_url() != null) {
                if (this.caG.bbQ != null) {
                    if (this.caG.bbR == null) {
                        this.caG.bbQ.inflate();
                        this.caG.bbR = (TbImageView) getView().findViewById(r.g.user_head_mask);
                    }
                    this.caG.bbR.setVisibility(0);
                    this.caG.bbR.c(rQ.getvipV_url(), 10, false);
                    this.caG.bcF.setIsBigV(true);
                }
            } else {
                this.caG.bcF.setIsBigV(false);
                if (this.caG.bbR != null) {
                    this.caG.bbR.setVisibility(8);
                }
            }
            this.caG.bcF.setData(this.caF);
            this.caG.bcF.setAfterClickListener(this.bdJ);
            this.caG.bcF.setVisibility(0);
            this.caG.cas.setVisibility(8);
        } else {
            this.caG.bcF.setIsGod(false);
            this.caG.bcF.setIsBigV(false);
            if (this.caG.bbR != null) {
                this.caG.bbR.setVisibility(8);
            }
            this.caG.bcF.setVisibility(4);
            this.caG.cas.setVisibility(0);
            this.caG.cas.setData(this.caF);
        }
        if (this.caF.getAuthor() != null && !StringUtils.isNull(this.caF.getAuthor().getSealPrefix())) {
            this.caG.bdu.aN(true);
        }
        this.caG.bdu.setData(this.caF);
        this.caG.bdu.setUserNameTextSizeRid(r.e.fontsize24);
        this.caG.bdu.setUserAfterClickListener(this.bdJ);
        this.caG.bdu.setPageName(1);
        Resources resources = this.GO.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.caF.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_a)), 0, resources.getString(r.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.caF.getTitle())) {
            int length = this.caF.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.caF.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.caG.aNz.setSingleLine(true);
        } else {
            this.caG.aNz.setMaxLines(2);
        }
        this.caG.aNz.setText(e(this.caF.getTitle()));
        String fansNickName = this.caF.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(r.j.fans_default_name);
        }
        this.caG.bdO.setText(String.valueOf(fansNickName) + ": " + ax.v(this.caF.getAuthor().getFansNum()));
        if (this.caG.bdQ.a(this.caF)) {
            this.caG.bdR.setVisibility(8);
        } else {
            this.caG.bdR.setVisibility(0);
        }
        this.caG.bdQ.setForumAfterClickListener(this.bdK);
        this.caG.bdQ.setStType(com.baidu.tieba.card.an.Pf());
        k(this.caF);
        onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        if (com.baidu.tbadk.core.l.oJ().oP() && this.caF.getPhotoLiveCover() != null && this.caF.getPhotoLiveCover().length() != 0) {
            this.caG.bdP.setVisibility(0);
            this.caG.caI.setVisibility(8);
            this.caG.bdP.c(this.caF.getPhotoLiveCover(), 10, false);
            b(this.caF);
        } else {
            this.caG.bdP.setVisibility(8);
            this.caG.caJ.setVisibility(8);
            this.caG.caK.setVisibility(8);
            this.caG.caL.setVisibility(8);
            String rW = this.caF.rW();
            this.caG.caI.setText(rW);
            this.caG.caI.setVisibility(StringUtils.isNull(rW) ? 8 : 0);
        }
        if (this.caG.caM != null) {
            if ((this.caF.sm() || this.caF.sn()) && com.baidu.tieba.tbadkCore.util.s.bng()) {
                this.caG.caM.setTitleText(StringUtils.isNull(this.caF.sl()) ? getContext().getResources().getString(r.j.group_fourm_recommend_title) : this.caF.sl());
                this.caG.caM.show();
                this.caG.bdN.setVisibility(8);
                if (this.caG.caN != null) {
                    this.caG.caN.setVisibility(0);
                }
                if (this.caF.needTopMargin) {
                    this.caG.caM.btl();
                } else {
                    this.caG.caM.btk();
                    if (this.caF.isFirstFloor) {
                        this.caG.bdN.setVisibility(0);
                    }
                }
            } else {
                this.caG.caM.hide();
                this.caG.bdN.setVisibility(0);
                if (this.caG.caN != null) {
                    this.caG.caN.setVisibility(8);
                }
            }
        }
        com.baidu.tbadk.core.util.at.c(this.caG.bdO, r.d.cp_cont_d, 1);
        if (com.baidu.tieba.card.an.hS(this.caF.getTid())) {
            com.baidu.tbadk.core.util.at.c(this.caG.aNz, r.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.caG.caI, r.d.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.c(this.caG.aNz, r.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.c(this.caG.caI, r.d.cp_cont_j, 1);
    }

    private void k(bk bkVar) {
        MetaData author;
        if (bkVar != null && (author = bkVar.getAuthor()) != null) {
            ThemeCardInUserData themeCard = author.getThemeCard();
            SkinInfo si = bkVar.si();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.caG.bcF.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.caG.bcK.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.caG.bUs.setVisibility(8);
                if (this.caG.bUJ != null) {
                    if (si != null) {
                        this.caG.bUJ.a(this.GO, si, com.baidu.tieba.tbadkCore.d.a.b("FRS", "c0131", String.valueOf(bkVar.getFid()), bkVar.getForum_name(), bkVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds16);
                    } else {
                        this.caG.bUJ.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
                    }
                }
            } else {
                this.caG.bUs.setVisibility(0);
                this.caG.bUs.setImageBitmap(null);
                this.caG.bUs.c(themeCard.getCardImageUrlAndroid(), 10, false);
                this.caG.bUs.setOnClickListener(new ak(this, themeCard));
                this.caG.bUJ.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds30);
            }
            this.caG.bcF.setLayoutParams(layoutParams);
            this.caG.bcK.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.caG.mRootView || view == this.caG.bdQ.getCommentNumView()) {
            if (getOnSubCardOnClickListenner() != null) {
                getOnSubCardOnClickListenner().a(this.caG.mRootView, this.caF);
            }
            Pj();
        }
    }

    private void Pj() {
        PhotoLiveActivityConfig oZ;
        if (this.caF != null) {
            com.baidu.tieba.card.an.hR(this.caF.getTid());
            if (!Pk()) {
                UtilHelper.showToast(this.GO.getPageActivity(), r.j.plugin_config_not_found);
                return;
            }
            if (this.caF.sj() > 0 && com.baidu.tieba.tbadkCore.util.s.bng()) {
                oZ = new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.caF.getTid()).cl("from_frs").bF(18003).cj(String.valueOf(this.caF.sj())).oZ();
            } else {
                oZ = new PhotoLiveActivityConfig.a(this.GO.getPageActivity(), this.caF.getTid()).cl("from_frs").bF(18003).oZ();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, oZ));
            hT(this.caF.getTid());
        }
    }

    public void hT(String str) {
        new Handler().postDelayed(new al(this, str), 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.caG.mRootView);
            this.caG.bdu.tB();
            this.caG.bdQ.tB();
            com.baidu.tbadk.core.util.at.l(this.caG.bdN, r.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.caG.mRootView, r.f.addresslist_item_bg);
            if (this.caG.caM != null) {
                this.caG.caM.tB();
            }
            com.baidu.tbadk.core.util.at.l(this.caG.caN, r.d.cp_bg_line_c);
            this.mSkinType = i;
        }
    }

    private boolean Pk() {
        return TbadkCoreApplication.m9getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.bdb != null) {
            this.bdb.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.bdb);
        }
    }

    private void b(com.baidu.tbadk.core.data.au auVar) {
        this.aqL.clear();
        Bl();
        if (auVar != null && auVar.sg() != null) {
            int size = auVar.sg().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = auVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, auVar.sg(), i);
                }
            }
            Bk();
        }
    }

    private void Bl() {
        this.caG.caJ.setText("");
        this.caG.caK.setText("");
        this.caG.caL.setText("");
        if (this.caG.caJ.getVisibility() == 8) {
            this.caG.caJ.setVisibility(0);
        }
        if (this.caG.caK.getVisibility() == 8) {
            this.caG.caK.setVisibility(0);
        }
        if (this.caG.caL.getVisibility() == 8) {
            this.caG.caL.setVisibility(0);
        }
        this.aqL.add(Integer.valueOf(this.caG.caJ.getId()));
        this.aqL.add(Integer.valueOf(this.caG.caK.getId()));
        this.aqL.add(Integer.valueOf(this.caG.caL.getId()));
    }

    private void Bk() {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i = 0; i < size; i++) {
                if (this.aqL.get(i).intValue() == this.caG.caJ.getId()) {
                    this.caG.caJ.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.caG.caK.getId()) {
                    this.caG.caK.setVisibility(8);
                } else if (this.aqL.get(i).intValue() == this.caG.caL.getId()) {
                    this.caG.caL.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.aqK) {
                case 0:
                    a(this.aqW, this.aqX, this.caG.caJ);
                    a(this.aqY, this.aqZ, this.caG.caK);
                    a(this.ara, this.arb, this.caG.caL);
                    break;
                case 1:
                    a(this.arb, this.arc, this.caG.caJ);
                    a(this.ard, this.arb, this.caG.caK);
                    a(this.are, this.aqZ, this.caG.caL);
                    break;
                case 2:
                    a(this.arb, this.arf, this.caG.caJ);
                    a(this.arg, this.arb, this.caG.caK);
                    a(this.are, this.aqZ, this.caG.caL);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.caG.caJ);
            } else if (i == 1) {
                a(arrayList.get(i2), this.caG.caK);
            } else if (i == 2) {
                a(arrayList.get(i2), this.caG.caL);
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
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.AW())));
            ei(textView.getId());
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

    private void ei(int i) {
        if (this.aqL.size() != 0) {
            int size = this.aqL.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.aqL.get(i2).intValue() == i) {
                    this.aqL.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.GO.getResources().getString(r.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(r.d.cp_link_tip_a)), 0, string.length(), 17);
        Bitmap cO = com.baidu.tbadk.core.util.at.cO(r.f.pic_dot_title);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cO);
        if (cO != null) {
            bitmapDrawable.setBounds(0, 0, cO.getWidth(), cO.getHeight());
        }
        spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.ah(bitmapDrawable), string.length(), string.length() + 1, 33);
        return spannableStringBuilder;
    }

    /* loaded from: classes.dex */
    public class a {
        public TextView aNz;
        public ThreadSkinView bUJ;
        public TbImageView bUs;
        public ViewStub bbQ;
        public TbImageView bbR;
        public ClickableHeaderImageView bcF;
        public LinearLayout bcK;
        public View bdN;
        public TextView bdO;
        public TbImageView bdP;
        public ThreadCommentAndPraiseInfoLayout bdQ;
        public View bdR;
        public UserIconLayout bdu;
        public TextView caI;
        public TextView caJ;
        public TextView caK;
        public TextView caL;
        public GuessYourLikeHeaderView caM;
        public View caN;
        public HeadPendantClickableView cas;
        public RelativeLayout cav;
        public View mRootView;

        public a() {
        }
    }
}
