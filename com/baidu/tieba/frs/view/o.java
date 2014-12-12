package com.baidu.tieba.frs.view;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.aa;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a implements com.baidu.tbadk.imageManager.d {
    private static final int[] aHt = {com.baidu.tieba.v.label_green, com.baidu.tieba.v.label_blue, com.baidu.tieba.v.label_orange, com.baidu.tieba.v.label_red, com.baidu.tieba.v.label_purple};
    private com.baidu.tbadk.coreExtra.view.b Tl;
    private int aEJ;
    private FrsOfficalBanner aES;
    private FrameLayout aGH;
    private Button aGI;
    private FrameLayout aGJ;
    private Button aGK;
    private TextView aGL;
    private ProgressBar aGM;
    private FrameLayout aGN;
    private TextView aGO;
    private RelativeLayout aGP;
    private TextView aGQ;
    private TextView aGR;
    private ImageView aGS;
    private LinearLayout aGU;
    private TextView aGV;
    private LinearLayout aGW;
    private TextView aGX;
    private LinearLayout aGY;
    private z aGZ;
    private UserIconBox aHB;
    private boolean aHD;
    private U9InfoView aHE;
    private boolean aHF;
    private final TbImageView aHO;
    private final BarImageView aHP;
    private final ImageView aHQ;
    private View aHb;
    private TextView aHk;
    private d aHm;
    private String aHn;
    private int aHo;
    private int aHp;
    private String aHs;
    private boolean aHu;
    private int aHv;
    private final bb aHw;
    private ImageView aHx;
    private int aHy;
    private TbPageContext<FrsActivity> mContext;
    private String mForumId;
    private String mForumName;
    private View mParent;
    private TextView mTitleText;
    private aa news_info;
    private com.baidu.tbadk.core.data.x top_code;
    private TextView zg;
    private TextView zh;
    private TextView zi;
    private com.baidu.tieba.tbadkCore.e aDH = null;
    private int aHe = 0;
    private int aHf = 0;
    private com.baidu.tieba.tbadkCore.t aHM = null;
    com.baidu.tbadk.core.data.w aHN = null;
    private PopupWindow aHa = null;
    private TextView aHc = null;
    private TextView aHd = null;
    private int aHg = -1;
    private String aHh = null;
    private String aHi = null;
    private float aHq = 0.0f;
    private boolean aHr = false;
    private boolean aHj = false;
    private String aHC = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.e> mBadgeData = null;
    final Runnable aHG = new p(this);
    private View.OnClickListener aHH = new r(this);
    View.OnClickListener aHI = new s(this);
    private Handler handler = new Handler();

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.Tl = bVar;
        this.aES.setBannerViewClickListener(bVar);
    }

    public void Hk() {
        this.aES.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.zg = null;
        this.zh = null;
        this.mTitleText = null;
        this.aGH = null;
        this.aGI = null;
        this.zi = null;
        this.aGJ = null;
        this.aGK = null;
        this.aGL = null;
        this.aGM = null;
        this.aGN = null;
        this.aGO = null;
        this.aGP = null;
        this.aGQ = null;
        this.aGR = null;
        this.aGS = null;
        this.mParent = null;
        this.aGU = null;
        this.aGV = null;
        this.aGW = null;
        this.aGX = null;
        this.aGY = null;
        this.mContext = null;
        this.mForumName = null;
        this.mForumId = null;
        this.aHm = null;
        this.aHb = null;
        this.aHk = null;
        this.aHy = 0;
        this.aHB = null;
        this.aHy = i;
        this.mContext = tbPageContext;
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = com.baidu.adp.lib.g.b.ek().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_star_title, null);
        this.aHb = com.baidu.adp.lib.g.b.ek().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.mParent.setVisibility(8);
        }
        this.aES = (FrsOfficalBanner) this.mParent.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aES.setVisibility(8);
        this.aGP = (RelativeLayout) this.mParent.findViewById(com.baidu.tieba.w.btn_love_content);
        this.aHx = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.speed_icon);
        this.aGQ = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level_name);
        this.aGR = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level);
        this.aGS = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.love_level_top);
        this.aHk = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_tag_text);
        this.aHm = new d(this.mParent, this.mContext.getPageActivity());
        this.aGH = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.love);
        this.aGI = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_love);
        this.zi = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_love);
        this.aGJ = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign);
        this.aGK = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_sign);
        this.aGL = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_sign);
        this.aGM = (ProgressBar) this.mParent.findViewById(com.baidu.tieba.w.sign_progress);
        this.aGN = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign_done);
        this.aGO = (TextView) this.mParent.findViewById(com.baidu.tieba.w.sign_done_text);
        this.zg = (TextView) this.mParent.findViewById(com.baidu.tieba.w.member_num_text);
        this.zh = (TextView) this.mParent.findViewById(com.baidu.tieba.w.post_num_text);
        this.mTitleText = (TextView) this.mParent.findViewById(com.baidu.tieba.w.title_text);
        this.aHO = (TbImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_top_pic);
        this.aHO.setOnClickListener(new t(this));
        this.aHP = (BarImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_bottom_photo);
        this.aHP.setGifIconSupport(false);
        this.aHQ = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_enter_detail);
        if (com.baidu.adp.lib.b.f.dc().Z("frs_to_bar_detail") == 0) {
            this.aHQ.setVisibility(0);
        } else {
            this.aHQ.setVisibility(8);
        }
        this.aHB = (UserIconBox) this.mParent.findViewById(com.baidu.tieba.w.frs_badge_box);
        this.aHw = new bb(this.mContext);
        this.aGU = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups);
        this.aGV = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups_text);
        this.aGW = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games);
        this.aGX = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games_text);
        this.aGY = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_root);
        this.aGZ = new z(this.mParent);
        this.aHE = (U9InfoView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_u9);
        if (this.aGA) {
            this.aGU.setVisibility(0);
        } else {
            this.aGU.setVisibility(8);
        }
    }

    public boolean Hb() {
        int[] iArr = new int[2];
        try {
            this.aHx.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.aHP.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aGU.setOnClickListener(onClickListener);
        if (this.aGW != null) {
            this.aGW.setOnClickListener(onClickListener);
        }
        this.aGP.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.dc().Z("frs_to_bar_detail") == 0) {
            this.mParent.setOnClickListener(new u(this));
        }
        this.aHm.setOnClickListener(onClickListener);
        this.aGI.setOnClickListener(onClickListener);
        this.aGK.setOnClickListener(onClickListener);
        this.aHk.setOnClickListener(new v(this));
    }

    public BarImageView He() {
        return this.aHP;
    }

    public TextView Hf() {
        return this.mTitleText;
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ab(i == 1);
        this.mContext.getLayoutMode().h(this.mParent);
        this.mContext.getLayoutMode().h(this.aHb);
        if (this.aHj) {
            eW(1);
        } else {
            eW(0);
        }
        ax.i((View) this.aGR, com.baidu.tbadk.core.util.d.bK(this.aHo));
        this.aHP.invalidate();
        this.aHO.invalidate();
        if (this.aHg >= 0 && this.aHg < aHt.length) {
            ax.i((View) this.aHk, aHt[this.aHg]);
        }
        ax.c(this.aHQ, com.baidu.tieba.v.icon_arrow_right);
        this.zi.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aGL.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.zi.setShadowLayer(1.0f, 0.0f, 1.0f, ax.getColor(com.baidu.tieba.t.frs_like_shadow));
        this.aGL.setShadowLayer(1.0f, 0.0f, 1.0f, ax.getColor(com.baidu.tieba.t.frs_sign_shadow));
        ax.i(this.aGU, com.baidu.tieba.v.frs_top_item_bg);
        if (this.aGW != null) {
            ax.i(this.aGW, com.baidu.tieba.v.frs_top_item_bg);
        }
        if (this.aHy != 0) {
            ax.c(this.aHx, com.baidu.tieba.v.icon_speed_orange);
        } else {
            ax.c(this.aHx, com.baidu.tieba.v.icon_speed_gray);
        }
        if (this.aGZ != null) {
            this.aGZ.changeSkinType(i);
        }
        if (this.aHE != null) {
            this.aHE.c(this.mContext, i);
        }
        if (this.aHB != null) {
            this.aHB.cm(i);
        }
    }

    public void Hc() {
        if (this.aHy != 0) {
            ax.c(this.aHx, com.baidu.tieba.v.icon_speed_orange);
        } else {
            ax.c(this.aHx, com.baidu.tieba.v.icon_speed_gray);
        }
    }

    public View getView() {
        return this.mParent;
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aHe = forumData.getMember_num();
            this.aHf = forumData.getPost_num();
            this.aHh = forumData.getTag_name();
            this.aHi = forumData.getTag_color();
            this.aHv = forumData.getSignData().getCountSignNum();
            this.aHp = forumData.getCurScore();
            this.aHs = forumData.getAccelerateContent();
            this.aEJ = forumData.getLevelupScore();
            this.aDH = eVar;
            this.aHM = eVar.ael();
            this.mBadgeData = forumData.getBadgeData();
            this.aHN = new com.baidu.tbadk.core.data.w();
            this.top_code = forumData.getTopCode();
            this.news_info = forumData.getNewsInfo();
            if (this.aHM != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aHM.aer());
                this.aHN.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aHM.aes());
                this.aHN.getMedias().add(mediaData2);
            }
            this.mParent.setVisibility(0);
            this.aHm.setForumName(forumData.getName());
            Hd();
        }
    }

    private void Hd() {
        if (this.zg != null) {
            this.zg.setText(String.valueOf(this.aHe));
        }
        if (this.zh != null) {
            this.zh.setText(String.valueOf(this.aHf));
        }
        if (this.mTitleText != null) {
            if (this.mBadgeData != null && this.mBadgeData.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.mContext.getString(com.baidu.tieba.z.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aHh != null && this.aHh.length() > 0 && z) {
            if (this.aHk != null) {
                this.aHk.setText(this.aHh);
            }
            if (this.aHk != null && this.aHi != null && this.aHi.length() > 0) {
                this.aHg = Integer.parseInt(this.aHi);
                if (this.aHg >= 0 && this.aHg < aHt.length) {
                    ax.i((View) this.aHk, aHt[this.aHg]);
                }
            }
            if (this.aHk != null) {
                this.aHk.setVisibility(0);
            }
        } else if (this.aHk != null) {
            this.aHk.setVisibility(8);
        }
        if (this.aDH != null && this.aDH.mP() != null && this.aDH.mP().getIfpost() == 0) {
            if (this.aDH.aek().isEmpty()) {
                this.aGU.setVisibility(8);
            } else {
                this.aGU.setVisibility(0);
                if (this.aDH.aem().aeb() > 0) {
                    this.aGV.setText(" (" + this.aDH.aem().aeb() + ")");
                } else {
                    this.aGV.setText("");
                }
            }
        } else {
            this.aGU.setVisibility(0);
            if (this.aDH != null && this.aDH.aem().aeb() > 0) {
                this.aGV.setText(" (" + this.aDH.aem().aeb() + ")");
            } else {
                this.aGV.setText("");
            }
        }
        if (this.aGA) {
            this.aGU.setVisibility(0);
        } else {
            this.aGU.setVisibility(8);
        }
        if (this.aGW != null && this.aGX != null) {
            if (this.aDH != null && this.aDH.aee()) {
                this.aGW.setVisibility(0);
                if (!TextUtils.isEmpty(this.aDH.getGameName()) && !TextUtils.isEmpty(this.aDH.getGameName().trim())) {
                    this.aGX.setText(UtilHelper.getFixedText(this.aDH.getGameName(), 10));
                    String in = com.baidu.tieba.tbadkCore.util.k.in(this.aDH.aeg());
                    if (!StringUtils.isNull(in)) {
                        TiebaStatic.eventStat(this.mContext.getPageActivity(), "frs_ourgame", "show", 1, "dev_id", in, "ref_id", "1000601");
                    }
                } else {
                    this.aGX.setText("");
                }
                TiebaStatic.eventStat(this.mContext.getPageActivity(), "frs_ourgame", "show", 1, new Object[0]);
            } else {
                this.aGW.setVisibility(8);
            }
        }
        if (this.aDH != null && this.aDH.aef() != null && this.aDH.aef().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> aef = this.aDH.aef();
            P(aef);
            int size = aef.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aGY.setVisibility(0);
                this.aGY.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setSupportNoImage(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.l.d(this.mContext.getPageActivity(), com.baidu.tieba.u.ds6));
                    tbImageView.d(aef.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_text)).setText(UtilHelper.getFixedText(aef.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(aef.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aHH);
                    this.aGY.addView(linearLayout);
                }
            } else {
                this.aGY.setVisibility(8);
            }
        } else {
            this.aGY.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aHO.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.M(this.mContext.getContext());
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds300);
        this.aHO.setLayoutParams(layoutParams);
        this.aHO.setDefaultResource(com.baidu.tieba.v.def_star_top_pic);
        this.aHO.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aHP.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int aet = this.aHM.aet();
        int aeu = this.aHM.aeu();
        if (aet == 0 || aeu == 0) {
            aet = layoutParams.width;
            aeu = layoutParams.height;
        }
        this.aHO.a(this.aHM.aer(), 16, aet, aeu, false);
        this.aHP.d(this.aHM.aes(), 16, false);
        if (this.aHB != null && this.mBadgeData != null && this.mBadgeData.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.mBadgeData.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.mBadgeData.get(i3).my());
                iconData.setIcon(this.mBadgeData.get(i3).mx());
                this.aHC = this.mBadgeData.get(i3).mz();
                linkedList.add(iconData);
            }
            this.aHB.setOnClickListener(this.aHI);
            this.aHB.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_margin));
        }
        if (this.aDH != null) {
            this.aGZ.a(this.aDH.ael(), this.aDH.aej());
        } else {
            this.aGZ.a(null, null);
        }
        this.aHE.a(this.top_code, this.news_info);
    }

    private void applyNightMode(View view) {
        this.mContext.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().h(view);
    }

    private void P(List<com.baidu.tieba.tbadkCore.o> list) {
        if (list != null && list.size() != 0) {
            Iterator<com.baidu.tieba.tbadkCore.o> it = list.iterator();
            while (it.hasNext()) {
                com.baidu.tieba.tbadkCore.o next = it.next();
                if (next == null || StringUtils.isNull(next.getIcon()) || StringUtils.isNull(next.getTitle()) || StringUtils.isNull(next.getUrl())) {
                    it.remove();
                }
            }
        }
    }

    public void setIsMem(int i) {
        this.aHy = i;
    }

    public void Gg() {
        PopupWindow popupWindow = new PopupWindow(this.mContext.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getContext(), com.baidu.tieba.x.speed_tip, null);
        this.mContext.getLayoutMode().h(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new w(this, popupWindow));
        popupWindow.setWidth(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds300));
        popupWindow.setHeight(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new x(this, popupWindow));
        int[] iArr = new int[2];
        this.aHx.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.mParent, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aHx.getWidth() / 2), iArr[1] + this.aHx.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aHr = z;
        Bitmap bI = com.baidu.tbadk.core.util.d.bI(com.baidu.tieba.v.bg_frs_signin_bar_down);
        if (bI != null && bI.getWidth() > 0) {
            if (this.aHr) {
                this.aGQ.setText(com.baidu.tieba.z.star_bar_level_up);
                this.aGR.setText(String.valueOf(this.aHo + 1));
            } else {
                this.aGQ.setText(this.aHn);
                this.aGR.setText(String.valueOf(this.aHo));
                ax.i((View) this.aGR, com.baidu.tbadk.core.util.d.bK(this.aHo));
            }
            if (this.aHr) {
                b(this.mContext.getOrignalPage(), this.aGS, this.aHq, f);
            } else {
                a(this.mContext.getOrignalPage(), this.aGS, this.aHq, f);
            }
            this.aHq = f;
        }
    }

    public void c(View view, boolean z) {
        if (this.aHy != 0 || TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aHa == null) {
                this.aHa = new PopupWindow(this.mContext.getPageActivity());
                this.aHa.setContentView(this.aHb);
                this.aHa.setBackgroundDrawable(new BitmapDrawable());
                this.aHa.setOutsideTouchable(true);
                this.aHa.setFocusable(true);
                this.aHa.setWidth(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_btn_width));
                this.aHa.setHeight(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_exp_height));
                this.aHc = (TextView) this.aHb.findViewById(com.baidu.tieba.w.cur_experience);
                this.aHd = (TextView) this.aHb.findViewById(com.baidu.tieba.w.levelup_experience);
                a(this.aHc, this.aHd);
            }
            if (this.aHa.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aHa, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aHc, this.aHd);
            int height = iArr[1] - this.aHa.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aHa, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aHa, this.mParent, 0, iArr[0], height);
            this.aHa.update();
            this.handler.postDelayed(this.aHG, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.w.speed_tip);
            ax.b((TextView) inflate.findViewById(com.baidu.tieba.w.experience), com.baidu.tieba.t.cp_cont_b, 1);
            ax.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            ax.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
            ax.b(textView3, com.baidu.tieba.t.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aHs) && !TextUtils.isEmpty(this.aHs.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aHs);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(com.baidu.tieba.z.cancel_text, new y(this));
            aVar.a(com.baidu.tieba.z.open_now, new q(this));
            aVar.b(this.mContext).nU();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aHp));
        if (this.aEJ >= 10000) {
            if (this.aEJ % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aEJ / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aEJ / 10000.0f) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aEJ));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aHn = str;
        this.aHo = i2;
        if (i == 0) {
            this.aGz = false;
            this.aGH.setVisibility(0);
            this.aGP.setVisibility(8);
            return;
        }
        this.aGz = true;
        this.aGH.setVisibility(8);
        if (z) {
            this.aHw.v(this.aGH);
        }
        a(false, f);
        this.aGP.setVisibility(0);
    }

    public void eV(int i) {
        if (i == 0) {
            this.aGz = false;
            this.aGH.setVisibility(0);
            this.aGP.setVisibility(8);
            return;
        }
        this.aGz = true;
        this.aGH.setVisibility(8);
        this.aGP.setVisibility(0);
    }

    public void eW(int i) {
        if (i == 0) {
            this.aHj = false;
            this.aGN.setVisibility(8);
            this.aGJ.setVisibility(0);
            ax.i((View) this.aGK, com.baidu.tieba.v.frs_btn_sign);
            return;
        }
        this.aHj = true;
        this.aGJ.setVisibility(8);
        this.aGO.setCompoundDrawablesWithIntrinsicBounds(ax.getDrawable(com.baidu.tieba.v.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aHv <= 1) {
            this.aGO.setText(this.mContext.getString(com.baidu.tieba.z.signed));
        } else {
            this.aGO.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.signed_less)) + String.valueOf(this.aHv) + this.mContext.getString(com.baidu.tieba.z.day));
        }
        this.aGN.setVisibility(0);
    }

    public boolean GE() {
        return this.aHj;
    }

    public void bV(boolean z) {
        this.aHu = z;
        if (this.aHu) {
            this.aGJ.setVisibility(0);
        } else {
            this.aGJ.setVisibility(4);
        }
    }

    public View Hg() {
        return this.aGP;
    }

    public boolean Gn() {
        return this.aHr;
    }

    public boolean z(View view) {
        return this.aHm.y(view);
    }

    public void Hi() {
        this.aHm.hide();
    }

    public void Hj() {
        this.aHm.show();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.mParent.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar Hh() {
        return this.aGM;
    }

    public void onDestory() {
        this.aHD = true;
    }

    public void bW(boolean z) {
        this.aHF = z;
    }
}
