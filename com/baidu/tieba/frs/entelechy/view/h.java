package com.baidu.tieba.frs.entelechy.view;

import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
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
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonalCardDetailActivityConfig;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThemeCardInUserData;
import com.baidu.tbadk.core.data.ar;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.data.UserTbVipInfoData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.ThreadSkinView;
import java.util.ArrayList;
import tbclient.SkinInfo;
/* loaded from: classes2.dex */
public class h extends com.baidu.tieba.card.a<ar> {
    private int blX;
    private ArrayList<Integer> blY;
    private int bmj;
    private int bmk;
    private int bml;
    private int bmm;
    private int bmn;
    private int bmo;
    private int bmp;
    private int bmq;
    private int bmr;
    private int bms;
    private int bmt;
    private CustomMessageListener cTK;
    private View.OnClickListener cUF;
    private View.OnClickListener cUG;
    private com.baidu.tieba.frs.f.g dII;
    private ar dJe;
    public a dJf;
    private TbPageContext<?> mPageContext;

    public h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        this.blY = new ArrayList<>();
        this.blX = 0;
        this.cUF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akg() != null) {
                    h.this.akg().a(view, h.this.dJe);
                }
            }
        };
        this.cUG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (h.this.akg() != null) {
                    h.this.akg().a(view, h.this.dJe);
                }
            }
        };
        this.cTK = new CustomMessageListener(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR) { // from class: com.baidu.tieba.frs.entelechy.view.h.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String) && h.this.dJe != null && h.this.dJe != null && h.this.dJe.getTid() != null && h.this.dJf != null && h.this.dJf.cTz != null && h.this.dJf.dJm != null && ((String) customResponsedMessage.getData()).equals(h.this.dJe.getTid())) {
                    com.baidu.tieba.card.k.a(h.this.dJf.cTz, h.this.dJe.getId(), d.C0108d.cp_cont_b, d.C0108d.cp_cont_d);
                    com.baidu.tieba.card.k.a(h.this.dJf.dJm, h.this.dJe.getId(), d.C0108d.cp_cont_j, d.C0108d.cp_cont_d);
                }
            }
        };
        setTag(bdUniqueId);
        this.currentPageType = 3;
        this.mPageContext = tbPageContext;
        this.bmj = (int) tbPageContext.getResources().getDimension(d.e.ds80);
        this.bmk = (int) tbPageContext.getResources().getDimension(d.e.ds280);
        this.bml = (int) tbPageContext.getResources().getDimension(d.e.ds170);
        this.bmm = (int) tbPageContext.getResources().getDimension(d.e.ds320);
        this.bmn = (int) tbPageContext.getResources().getDimension(d.e.ds200);
        this.bmo = (int) tbPageContext.getResources().getDimension(d.e.ds60);
        this.bmp = (int) tbPageContext.getResources().getDimension(d.e.ds120);
        this.bmq = (int) tbPageContext.getResources().getDimension(d.e.ds160);
        this.bmr = (int) tbPageContext.getResources().getDimension(d.e.ds220);
        this.bms = (int) tbPageContext.getResources().getDimension(d.e.ds240);
        this.bmt = (int) tbPageContext.getResources().getDimension(d.e.ds180);
        bv(getView());
        initUI();
    }

    private void bv(View view) {
        this.dJf = new a();
        this.dJf.mRootView = (ViewGroup) view.findViewById(d.g.card_root_view);
        this.dJf.dJh = view.findViewById(d.g.top_line);
        this.dJf.dJi = (RelativeLayout) view.findViewById(d.g.live_card_content_root);
        this.dJf.dJk = (ClickableHeaderImageView) view.findViewById(d.g.avatar);
        this.dJf.dJj = (HeadPendantClickableView) view.findViewById(d.g.pendant_avatar);
        this.dJf.bcj = (ViewStub) view.findViewById(d.g.viewstub_headimage_mask);
        this.dJf.cjQ = (LinearLayout) view.findViewById(d.g.live_card_content_layout);
        this.dJf.dIT = (UserIconLayout) view.findViewById(d.g.user_icon);
        this.dJf.cTz = (TextView) view.findViewById(d.g.thread_title);
        this.dJf.dJl = (TextView) view.findViewById(d.g.thread_context);
        this.dJf.dJm = (TextView) view.findViewById(d.g.fans_num);
        this.dJf.cUJ = (TbImageView) view.findViewById(d.g.thread_image);
        this.dJf.cUJ.setPageId(getTag());
        this.dJf.dJn = (ThreadCommentAndPraiseInfoLayout) view.findViewById(d.g.thread_more_info);
        this.dJf.cUL = view.findViewById(d.g.divider_below_reply_number_layout);
        this.dJf.dJo = (TextView) view.findViewById(d.g.first_style_first_expression);
        this.dJf.dJp = (TextView) view.findViewById(d.g.first_style_second_expression);
        this.dJf.dJq = (TextView) view.findViewById(d.g.first_style_third_expression);
        this.dJf.cWl = (TbImageView) view.findViewById(d.g.frs_live_item_theme_card);
        this.dJf.cWl.setPageId(getTag());
        this.dJf.cjR = (ThreadSkinView) view.findViewById(d.g.frs_live_skin);
        this.dJf.cTs = (CardGroupDividerView) view.findViewById(d.g.header_divider);
        this.dJf.cTs.setTitleClickListener(this);
        this.dII = new com.baidu.tieba.frs.f.g(this.mPageContext, this.dJf.mRootView);
        this.dII.setUniqueId(getTag());
    }

    private void initUI() {
        this.dJf.dJk.setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dJf.dJk.setDefaultResource(17170445);
        this.dJf.dJk.setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJf.dJk.setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dJf.dJj.Dz();
        this.dJf.dJj.getHeadView().setRadius(com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds70));
        this.dJf.dJj.getHeadView().setDefaultResource(17170445);
        this.dJf.dJj.getHeadView().setDefaultErrorResource(d.f.icon_default_avatar100);
        this.dJf.dJj.getHeadView().setDefaultBgResource(d.C0108d.cp_bg_line_e);
        this.dJf.dJj.getHeadView().setIsRound(true);
        this.dJf.dJj.getHeadView().setDrawBorder(false);
        this.dJf.dJj.getPendantView().setIsRound(true);
        this.dJf.dJj.getPendantView().setDrawBorder(false);
        this.dJf.dJn.setShowPraiseNum(false);
        this.dJf.dJn.setFrom(2);
        this.dJf.cUJ.setDrawBorder(true);
        this.dJf.cUJ.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_home_page_zhibo_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(ar arVar) {
        this.dJe = arVar;
        refreshView();
    }

    private void refreshView() {
        boolean z;
        if (this.dJe == null) {
            this.dJf.mRootView.setVisibility(8);
            return;
        }
        if (this.dJe.yT() == null || this.dJe.yT().getPendantData() == null || StringUtils.isNull(this.dJe.yT().getPendantData().xu())) {
            if (this.dJe.yT() != null && this.dJe.yT().getGodUserData() != null && this.dJe.yT().getGodUserData().getType() == 2) {
                this.dJf.dJk.setGodIconMargin(0);
            } else {
                this.dJf.dJk.setIsGod(false);
            }
            UserTbVipInfoData yU = this.dJe.yU();
            if (yU != null && yU.getvipV_url() != null) {
                if (this.dJf.bcj != null) {
                    if (this.dJf.bck == null) {
                        this.dJf.bcj.inflate();
                        this.dJf.bck = (TbImageView) getView().findViewById(d.g.user_head_mask);
                    }
                    this.dJf.bck.setPageId(getTag());
                    this.dJf.bck.setVisibility(0);
                    this.dJf.bck.startLoad(yU.getvipV_url(), 10, false);
                    this.dJf.dJk.setIsBigV(true);
                }
            } else {
                this.dJf.dJk.setIsBigV(false);
                if (this.dJf.bck != null) {
                    this.dJf.bck.setVisibility(8);
                }
            }
            this.dJf.dJk.setData(this.dJe);
            this.dJf.dJk.setAfterClickListener(this.cUF);
            this.dJf.dJk.setVisibility(0);
            this.dJf.dJj.setVisibility(8);
        } else {
            this.dJf.dJk.setIsGod(false);
            this.dJf.dJk.setIsBigV(false);
            if (this.dJf.bck != null) {
                this.dJf.bck.setVisibility(8);
            }
            this.dJf.dJk.setVisibility(4);
            this.dJf.dJj.setVisibility(0);
            this.dJf.dJj.setData(this.dJe);
        }
        if (this.dJe.yT() != null && !StringUtils.isNull(this.dJe.yT().getSealPrefix())) {
            this.dJf.dIT.bt(true);
        }
        this.dJf.dIT.setData(this.dJe);
        this.dJf.dIT.setUserNameTextSizeRid(d.e.fontsize24);
        this.dJf.dIT.setUserAfterClickListener(this.cUF);
        this.dJf.dIT.setPageName(1);
        Resources resources = this.mPageContext.getResources();
        if (!StringUtils.isNull(this.dJe.getTitle())) {
            int length = this.dJe.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.dJe.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.dJf.cTz.setSingleLine(true);
        } else {
            this.dJf.cTz.setMaxLines(2);
        }
        this.dJe.h(false, true);
        this.dJf.cTz.setText(this.dJe.zt());
        String fansNickName = this.dJe.yT().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(d.j.fans_default_name);
        }
        this.dJf.dJm.setText(fansNickName + ": " + am.C(this.dJe.yT().getFansNum()));
        if (this.dJf.dJn.setData(this.dJe)) {
            this.dJf.cUL.setVisibility(8);
        } else {
            this.dJf.cUL.setVisibility(0);
        }
        this.dJf.dJn.setForumAfterClickListener(this.cUG);
        this.dJf.dJn.setStType("frs_page");
        H(this.dJe);
        this.dII.T(this.dJe);
        d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (com.baidu.tbadk.core.i.wB().wH() && this.dJe.getPhotoLiveCover() != null && this.dJe.getPhotoLiveCover().length() != 0) {
            this.dJf.cUJ.setVisibility(0);
            this.dJf.dJl.setVisibility(8);
            this.dJf.cUJ.startLoad(this.dJe.getPhotoLiveCover(), 10, false);
            b(this.dJe);
        } else {
            this.dJf.cUJ.setVisibility(8);
            this.dJf.dJo.setVisibility(8);
            this.dJf.dJp.setVisibility(8);
            this.dJf.dJq.setVisibility(8);
            String str = this.dJe.getAbstract();
            this.dJf.dJl.setText(str);
            this.dJf.dJl.setVisibility(StringUtils.isNull(str) ? 8 : 0);
        }
        b.a(this.dJe, this.dJf.cTs);
        aj.e(this.dJf.dJm, d.C0108d.cp_cont_d, 1);
        if (com.baidu.tieba.card.k.kk(this.dJe.getTid())) {
            aj.e(this.dJf.cTz, d.C0108d.cp_cont_d, 1);
            aj.e(this.dJf.dJl, d.C0108d.cp_cont_d, 1);
            return;
        }
        aj.e(this.dJf.cTz, d.C0108d.cp_cont_b, 1);
        aj.e(this.dJf.dJl, d.C0108d.cp_cont_j, 1);
    }

    private void H(bd bdVar) {
        MetaData yT;
        if (bdVar != null && (yT = bdVar.yT()) != null) {
            final ThemeCardInUserData themeCard = yT.getThemeCard();
            SkinInfo zp = bdVar.zp();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.dJf.dJk.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dJf.cjQ.getLayoutParams();
            if (themeCard == null || StringUtils.isNull(themeCard.getCardImageUrlAndroid())) {
                this.dJf.cWl.setVisibility(8);
                if (this.dJf.cjR != null) {
                    if (zp != null) {
                        this.dJf.cjR.a(this.mPageContext, zp, com.baidu.tieba.tbadkCore.d.a.d("FRS", "c0131", String.valueOf(bdVar.getFid()), bdVar.yZ(), bdVar.getTid(), null));
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds16);
                    } else {
                        this.dJf.cjR.setVisibility(8);
                        layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                        layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
                    }
                }
            } else {
                this.dJf.cWl.setVisibility(0);
                this.dJf.cWl.setImageBitmap(null);
                this.dJf.cWl.startLoad(themeCard.getCardImageUrlAndroid(), 10, false);
                this.dJf.cWl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.entelechy.view.h.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PersonalCardDetailActivityConfig(h.this.mPageContext.getPageActivity(), themeCard.getCardId())));
                    }
                });
                this.dJf.cjR.setVisibility(8);
                layoutParams.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds32);
                layoutParams2.topMargin = com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds30);
            }
            this.dJf.dJk.setLayoutParams(layoutParams);
            this.dJf.cjQ.setLayoutParams(layoutParams2);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dJf != null) {
            if (view == this.dJf.mRootView || view == this.dJf.dJn.getCommentNumView() || view == this.dJf.cTs) {
                if (akg() != null) {
                    akg().a(this.dJf.mRootView, this.dJe);
                }
                akC();
            }
        }
    }

    private void akC() {
        PhotoLiveActivityConfig wQ;
        if (this.dJe != null) {
            com.baidu.tieba.card.k.kj(this.dJe.getTid());
            if (!akD()) {
                UtilHelper.showToast(this.mPageContext.getPageActivity(), d.j.plugin_config_not_found);
                return;
            }
            if (this.dJe.zq() > 0 && com.baidu.tieba.tbadkCore.util.f.bwK()) {
                wQ = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dJe.getTid()).cG("from_frs").eC(18003).cE(String.valueOf(this.dJe.zq())).wQ();
            } else {
                wQ = new PhotoLiveActivityConfig.a(this.mPageContext.getPageActivity(), this.dJe.getTid()).cG("from_frs").eC(18003).wQ();
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, wQ));
            kl(this.dJe.getTid());
        }
    }

    public void kl(final String str) {
        new Handler().postDelayed(new Runnable() { // from class: com.baidu.tieba.frs.entelechy.view.h.2
            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR, str));
            }
        }, 600L);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.n.a.a(tbPageContext, this.dJf.mRootView);
            this.dJf.dIT.onChangeSkinType();
            this.dJf.dJn.onChangeSkinType();
            aj.t(this.dJf.dJh, d.C0108d.cp_bg_line_c);
            aj.s(this.dJf.mRootView, d.f.addresslist_item_bg);
            if (this.dJf.cTs != null) {
                this.dJf.cTs.onChangeSkinType();
            }
            this.dII.onChangeSkinType();
            this.mSkinType = i;
        }
    }

    private boolean akD() {
        return TbadkCoreApplication.getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void h(BdUniqueId bdUniqueId) {
        if (this.cTK != null) {
            this.cTK.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.cTK);
        }
    }

    private void b(ar arVar) {
        this.blY.clear();
        IO();
        if (arVar != null && arVar.zn() != null) {
            int size = arVar.zn().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = arVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, arVar.zn(), i);
                }
            }
            IN();
        }
    }

    private void IO() {
        this.dJf.dJo.setText("");
        this.dJf.dJp.setText("");
        this.dJf.dJq.setText("");
        if (this.dJf.dJo.getVisibility() == 8) {
            this.dJf.dJo.setVisibility(0);
        }
        if (this.dJf.dJp.getVisibility() == 8) {
            this.dJf.dJp.setVisibility(0);
        }
        if (this.dJf.dJq.getVisibility() == 8) {
            this.dJf.dJq.setVisibility(0);
        }
        this.blY.add(Integer.valueOf(this.dJf.dJo.getId()));
        this.blY.add(Integer.valueOf(this.dJf.dJp.getId()));
        this.blY.add(Integer.valueOf(this.dJf.dJq.getId()));
    }

    private void IN() {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i = 0; i < size; i++) {
                if (this.blY.get(i).intValue() == this.dJf.dJo.getId()) {
                    this.dJf.dJo.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.dJf.dJp.getId()) {
                    this.dJf.dJp.setVisibility(8);
                } else if (this.blY.get(i).intValue() == this.dJf.dJq.getId()) {
                    this.dJf.dJq.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.e> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.blX) {
                case 0:
                    a(this.bmj, this.bmk, this.dJf.dJo);
                    a(this.bml, this.bmm, this.dJf.dJp);
                    a(this.bmn, this.bmo, this.dJf.dJq);
                    break;
                case 1:
                    a(this.bmo, this.bmp, this.dJf.dJo);
                    a(this.bmq, this.bmo, this.dJf.dJp);
                    a(this.bmr, this.bmm, this.dJf.dJq);
                    break;
                case 2:
                    a(this.bmo, this.bms, this.dJf.dJo);
                    a(this.bmt, this.bmo, this.dJf.dJp);
                    a(this.bmr, this.bmm, this.dJf.dJq);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.dJf.dJo);
            } else if (i == 1) {
                a(arrayList.get(i2), this.dJf.dJp);
            } else if (i == 2) {
                a(arrayList.get(i2), this.dJf.dJq);
            }
        }
    }

    private void a(com.baidu.tbadk.coreExtra.view.e eVar, TextView textView) {
        if (eVar != null && textView != null) {
            if (!a(eVar)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(eVar.aj(eVar.getLabelName(), String.valueOf(eVar.IE())));
            hr(textView.getId());
        }
    }

    private void a(int i, int i2, TextView textView) {
        if (textView != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
            marginLayoutParams.topMargin = i;
            marginLayoutParams.rightMargin = i2;
        }
    }

    private boolean a(com.baidu.tbadk.coreExtra.view.e eVar) {
        return (eVar == null || StringUtils.isNull(eVar.getLabelName())) ? false : true;
    }

    private void hr(int i) {
        if (this.blY.size() != 0) {
            int size = this.blY.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.blY.get(i2).intValue() == i) {
                    this.blY.remove(i2);
                    return;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class a {
        public ViewStub bcj;
        public TbImageView bck;
        public CardGroupDividerView cTs;
        public TextView cTz;
        public TbImageView cUJ;
        public View cUL;
        public TbImageView cWl;
        public LinearLayout cjQ;
        public ThreadSkinView cjR;
        public UserIconLayout dIT;
        public View dJh;
        public RelativeLayout dJi;
        public HeadPendantClickableView dJj;
        public ClickableHeaderImageView dJk;
        public TextView dJl;
        public TextView dJm;
        public ThreadCommentAndPraiseInfoLayout dJn;
        public TextView dJo;
        public TextView dJp;
        public TextView dJq;
        public ViewGroup mRootView;

        public a() {
        }
    }
}
