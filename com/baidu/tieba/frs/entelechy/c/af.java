package com.baidu.tieba.frs.entelechy.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PhotoLiveActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.UserIconLayout;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.card.a<com.baidu.tbadk.core.data.ag> {
    private TbPageContext<?> DV;
    private View.OnClickListener aQE;
    private View.OnClickListener aQF;
    private CustomMessageListener aQc;
    private int alG;
    private ArrayList<Integer> alH;
    private int alS;
    private int alT;
    private int alU;
    private int alV;
    private int alW;
    private int alX;
    private int alY;
    private int alZ;
    private int ama;
    private int amb;
    private int amc;
    private com.baidu.tbadk.core.data.ag bpN;
    public a bpO;

    public af(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.alH = new ArrayList<>();
        this.alG = 0;
        this.aQE = new ag(this);
        this.aQF = new ah(this);
        this.aQc = new ai(this, CmdConfigCustom.CMD_CHANGE_CARD_TITILE_COLOR);
        this.DV = tbPageContext;
        this.alS = (int) tbPageContext.getResources().getDimension(t.e.ds80);
        this.alT = (int) tbPageContext.getResources().getDimension(t.e.ds280);
        this.alU = (int) tbPageContext.getResources().getDimension(t.e.ds170);
        this.alV = (int) tbPageContext.getResources().getDimension(t.e.ds320);
        this.alW = (int) tbPageContext.getResources().getDimension(t.e.ds200);
        this.alX = (int) tbPageContext.getResources().getDimension(t.e.ds60);
        this.alY = (int) tbPageContext.getResources().getDimension(t.e.ds120);
        this.alZ = (int) tbPageContext.getResources().getDimension(t.e.ds160);
        this.ama = (int) tbPageContext.getResources().getDimension(t.e.ds220);
        this.amb = (int) tbPageContext.getResources().getDimension(t.e.ds240);
        this.amc = (int) tbPageContext.getResources().getDimension(t.e.ds180);
        w(getView());
        nq();
    }

    private void w(View view) {
        this.bpO = new a();
        this.bpO.mRootView = view.findViewById(t.g.card_root_view);
        this.bpO.aQI = view.findViewById(t.g.top_line);
        this.bpO.aPC = (ClickableHeaderImageView) view.findViewById(t.g.avatar);
        this.bpO.aQp = (UserIconLayout) view.findViewById(t.g.user_icon);
        this.bpO.aQJ = (TextView) view.findViewById(t.g.thread_title);
        this.bpO.bpQ = (TextView) view.findViewById(t.g.thread_context);
        this.bpO.aQK = (TextView) view.findViewById(t.g.fans_num);
        this.bpO.aQL = (TbImageView) view.findViewById(t.g.thread_image);
        this.bpO.aQM = (ThreadCommentAndPraiseInfoLayout) view.findViewById(t.g.thread_more_info);
        this.bpO.bpR = (TextView) view.findViewById(t.g.first_style_first_expression);
        this.bpO.bpS = (TextView) view.findViewById(t.g.first_style_second_expression);
        this.bpO.bpT = (TextView) view.findViewById(t.g.first_style_third_expression);
        this.bpO.aQM.setCommentNumClickListener(this);
    }

    private void nq() {
        this.bpO.aPC.setRadius(com.baidu.adp.lib.util.k.c(this.DV.getPageActivity(), t.e.ds70));
        this.bpO.aPC.setDefaultResource(17170445);
        this.bpO.aPC.setDefaultErrorResource(t.f.icon_default_avatar100);
        this.bpO.aPC.setDefaultBgResource(t.d.cp_bg_line_e);
        this.bpO.aQM.setShowPraiseNum(false);
        this.bpO.aQL.setDrawBorder(true);
        this.bpO.aQL.setBorderWidth(1);
    }

    @Override // com.baidu.tieba.card.a
    public int JN() {
        return t.h.card_home_page_zhibo_item;
    }

    public void a(com.baidu.tbadk.core.data.ag agVar) {
        this.bpN = agVar;
        JW();
    }

    private void JW() {
        String string;
        boolean z;
        if (this.bpN == null) {
            this.bpO.mRootView.setVisibility(8);
            return;
        }
        if (this.bpN.getAuthor() != null && this.bpN.getAuthor().getGodUserData() != null && this.bpN.getAuthor().getGodUserData().getType() == 2) {
            this.bpO.aPC.setGodIconMargin(0);
        }
        this.bpO.aPC.setData(this.bpN);
        this.bpO.aPC.setAfterClickListener(this.aQE);
        this.bpO.aQp.setData(this.bpN);
        this.bpO.aQp.setUserNameTextSizeRid(t.e.fontsize24);
        this.bpO.aQp.setUserAfterClickListener(this.aQE);
        this.bpO.aQp.setPageName(1);
        Resources resources = this.DV.getResources();
        new SpannableStringBuilder(String.valueOf(string) + this.bpN.getTitle()).setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, resources.getString(t.j.recommend_live_title_prefix).length(), 17);
        if (!StringUtils.isNull(this.bpN.getTitle())) {
            int length = this.bpN.getTitle().length();
            for (int i = 0; i < length; i++) {
                if (StringUtils.isChinese(this.bpN.getTitle().charAt(i))) {
                    z = false;
                    break;
                }
            }
        }
        z = true;
        if (z) {
            this.bpO.aQJ.setSingleLine(true);
        } else {
            this.bpO.aQJ.setMaxLines(2);
        }
        this.bpO.aQJ.setText(e(this.bpN.getTitle()));
        String fansNickName = this.bpN.getAuthor().getFansNickName();
        if (TextUtils.isEmpty(fansNickName)) {
            fansNickName = resources.getString(t.j.fans_default_name);
        }
        this.bpO.aQK.setText(String.valueOf(fansNickName) + ": " + ay.A(this.bpN.getAuthor().getFansNum()));
        this.bpO.aQM.setData(this.bpN);
        this.bpO.aQM.setForumAfterClickListener(this.aQF);
        this.bpO.aQM.setStType(com.baidu.tieba.card.au.Kb());
        d(this.DV, TbadkCoreApplication.m11getInst().getSkinType());
        if (com.baidu.tbadk.core.l.ob().oh() && this.bpN.getPhotoLiveCover() != null && this.bpN.getPhotoLiveCover().length() != 0) {
            this.bpO.aQL.setVisibility(0);
            this.bpO.bpQ.setVisibility(8);
            this.bpO.aQL.c(this.bpN.getPhotoLiveCover(), 10, false);
            b(this.bpN);
        } else {
            this.bpO.aQL.setVisibility(8);
            this.bpO.bpR.setVisibility(8);
            this.bpO.bpS.setVisibility(8);
            this.bpO.bpT.setVisibility(8);
            String qS = this.bpN.qS();
            this.bpO.bpQ.setText(qS);
            this.bpO.bpQ.setVisibility(StringUtils.isNull(qS) ? 8 : 0);
        }
        com.baidu.tbadk.core.util.at.c(this.bpO.aQK, t.d.cp_cont_d, 1);
        if (com.baidu.tieba.card.au.hc(this.bpN.getTid())) {
            com.baidu.tbadk.core.util.at.c(this.bpO.aQJ, t.d.cp_cont_d, 1);
            com.baidu.tbadk.core.util.at.c(this.bpO.bpQ, t.d.cp_cont_d, 1);
            return;
        }
        com.baidu.tbadk.core.util.at.c(this.bpO.aQJ, t.d.cp_cont_b, 1);
        com.baidu.tbadk.core.util.at.c(this.bpO.bpQ, t.d.cp_cont_j, 1);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.bpO.mRootView || view == this.bpO.aQM.getCommentNumView()) {
            if (JM() != null) {
                JM().a(this.bpO.mRootView, this.bpN);
            }
            Ke();
        }
    }

    private void Ke() {
        if (this.bpN != null) {
            com.baidu.tieba.card.au.hb(this.bpN.getTid());
            if (!Kf()) {
                UtilHelper.showToast(this.DV.getPageActivity(), t.j.plugin_config_not_found);
                return;
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PhotoLiveActivityConfig.a(this.DV.getPageActivity(), this.bpN.getTid()).cj("from_frs").bp(18003).oq()));
            hd(this.bpN.getTid());
        }
    }

    public void hd(String str) {
        new Handler().postDelayed(new aj(this, str), 600L);
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.i.a.a(tbPageContext, this.bpO.mRootView);
            this.bpO.aQp.sf();
            this.bpO.aQM.sf();
            com.baidu.tbadk.core.util.at.l(this.bpO.aQI, t.d.cp_bg_line_c);
            com.baidu.tbadk.core.util.at.k(this.bpO.mRootView, t.f.addresslist_item_bg);
            this.mSkinType = i;
        }
    }

    private boolean Kf() {
        return TbadkCoreApplication.m11getInst().appResponseToIntentClass(PhotoLiveActivityConfig.class);
    }

    public void i(BdUniqueId bdUniqueId) {
        if (this.aQc != null) {
            this.aQc.setTag(bdUniqueId);
            MessageManager.getInstance().registerListener(this.aQc);
        }
    }

    private void b(com.baidu.tbadk.core.data.ag agVar) {
        this.alH.clear();
        zG();
        if (agVar != null && agVar.rb() != null) {
            int size = agVar.rb().size();
            for (int i = 0; i < size && i < 3; i++) {
                int intValue = agVar.getShowExpressionViewIndex().get(i).intValue();
                if (intValue >= 0) {
                    a(intValue, agVar.rb(), i);
                }
            }
            zF();
        }
    }

    private void zG() {
        this.bpO.bpR.setText("");
        this.bpO.bpS.setText("");
        this.bpO.bpT.setText("");
        if (this.bpO.bpR.getVisibility() == 8) {
            this.bpO.bpR.setVisibility(0);
        }
        if (this.bpO.bpS.getVisibility() == 8) {
            this.bpO.bpS.setVisibility(0);
        }
        if (this.bpO.bpT.getVisibility() == 8) {
            this.bpO.bpT.setVisibility(0);
        }
        this.alH.add(Integer.valueOf(this.bpO.bpR.getId()));
        this.alH.add(Integer.valueOf(this.bpO.bpS.getId()));
        this.alH.add(Integer.valueOf(this.bpO.bpT.getId()));
    }

    private void zF() {
        if (this.alH.size() != 0) {
            int size = this.alH.size();
            for (int i = 0; i < size; i++) {
                if (this.alH.get(i).intValue() == this.bpO.bpR.getId()) {
                    this.bpO.bpR.setVisibility(8);
                } else if (this.alH.get(i).intValue() == this.bpO.bpS.getId()) {
                    this.bpO.bpS.setVisibility(8);
                } else if (this.alH.get(i).intValue() == this.bpO.bpT.getId()) {
                    this.bpO.bpT.setVisibility(8);
                }
            }
        }
    }

    private void a(int i, ArrayList<com.baidu.tbadk.coreExtra.view.n> arrayList, int i2) {
        if (i >= 0 && i < 3) {
            switch (this.alG) {
                case 0:
                    a(this.alS, this.alT, this.bpO.bpR);
                    a(this.alU, this.alV, this.bpO.bpS);
                    a(this.alW, this.alX, this.bpO.bpT);
                    break;
                case 1:
                    a(this.alX, this.alY, this.bpO.bpR);
                    a(this.alZ, this.alX, this.bpO.bpS);
                    a(this.ama, this.alV, this.bpO.bpT);
                    break;
                case 2:
                    a(this.alX, this.amb, this.bpO.bpR);
                    a(this.amc, this.alX, this.bpO.bpS);
                    a(this.ama, this.alV, this.bpO.bpT);
                    break;
            }
            if (i == 0) {
                a(arrayList.get(i2), this.bpO.bpR);
            } else if (i == 1) {
                a(arrayList.get(i2), this.bpO.bpS);
            } else if (i == 2) {
                a(arrayList.get(i2), this.bpO.bpT);
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
            textView.setText(nVar.ak(nVar.getLabelName(), String.valueOf(nVar.zr())));
            dR(textView.getId());
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

    private void dR(int i) {
        if (this.alH.size() != 0) {
            int size = this.alH.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.alH.get(i2).intValue() == i) {
                    this.alH.remove(i2);
                    return;
                }
            }
        }
    }

    private SpannableStringBuilder e(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return null;
        }
        String string = this.DV.getResources().getString(t.j.recommend_live_title_prefix);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(String.valueOf(string) + " " + ((Object) charSequence));
        spannableStringBuilder.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.at.getColor(t.d.cp_link_tip_a)), 0, string.length(), 17);
        Bitmap cA = com.baidu.tbadk.core.util.at.cA(t.f.pic_dot_title);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(cA);
        if (cA != null) {
            bitmapDrawable.setBounds(0, 0, cA.getWidth(), cA.getHeight());
        }
        spannableStringBuilder.setSpan(new com.baidu.tbadk.core.view.ah(bitmapDrawable), string.length(), string.length() + 1, 33);
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
        public TextView bpQ;
        public TextView bpR;
        public TextView bpS;
        public TextView bpT;
        public View mRootView;

        public a() {
        }
    }
}
