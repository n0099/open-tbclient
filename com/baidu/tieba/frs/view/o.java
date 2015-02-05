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
import com.baidu.tbadk.core.data.ab;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.ba;
import com.baidu.tieba.tbadkCore.FrsOfficalBanner;
import com.baidu.tieba.tbadkCore.U9InfoView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class o extends a implements com.baidu.tbadk.imageManager.d {
    private static final int[] aIA = {com.baidu.tieba.v.label_green, com.baidu.tieba.v.label_blue, com.baidu.tieba.v.label_orange, com.baidu.tieba.v.label_red, com.baidu.tieba.v.label_purple};
    private com.baidu.tbadk.coreExtra.view.b TM;
    private int aFJ;
    private FrsOfficalBanner aFS;
    private FrameLayout aHO;
    private Button aHP;
    private FrameLayout aHQ;
    private Button aHR;
    private TextView aHS;
    private ProgressBar aHT;
    private FrameLayout aHU;
    private TextView aHV;
    private RelativeLayout aHW;
    private TextView aHX;
    private TextView aHY;
    private ImageView aHZ;
    private boolean aIB;
    private int aIC;
    private final ba aID;
    private ImageView aIE;
    private int aIF;
    private UserIconBox aII;
    private boolean aIK;
    private U9InfoView aIL;
    private boolean aIM;
    private final TbImageView aIV;
    private final BarImageView aIW;
    private final ImageView aIX;
    private LinearLayout aIb;
    private TextView aIc;
    private LinearLayout aId;
    private TextView aIe;
    private LinearLayout aIf;
    private z aIg;
    private View aIi;
    private TextView aIr;
    private d aIt;
    private String aIu;
    private int aIv;
    private int aIw;
    private String aIz;
    private TbPageContext<FrsActivity> mContext;
    private String mForumId;
    private String mForumName;
    private View mParent;
    private TextView mTitleText;
    private ab news_info;
    private com.baidu.tbadk.core.data.y top_code;
    private TextView zd;
    private TextView ze;
    private TextView zf;
    private com.baidu.tieba.tbadkCore.e aEF = null;
    private int aIl = 0;
    private int aIm = 0;
    private com.baidu.tieba.tbadkCore.t aIT = null;
    com.baidu.tbadk.core.data.x aIU = null;
    private PopupWindow aIh = null;
    private TextView aIj = null;
    private TextView aIk = null;
    private int aIn = -1;
    private String aIo = null;
    private String aIp = null;
    private float aIx = 0.0f;
    private boolean aIy = false;
    private boolean aIq = false;
    private String aIJ = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.e> mBadgeData = null;
    final Runnable aIN = new p(this);
    private View.OnClickListener aIO = new r(this);
    View.OnClickListener aIP = new s(this);
    private Handler handler = new Handler();

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.TM = bVar;
        this.aFS.setBannerViewClickListener(bVar);
    }

    public void HC() {
        this.aFS.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.zd = null;
        this.ze = null;
        this.mTitleText = null;
        this.aHO = null;
        this.aHP = null;
        this.zf = null;
        this.aHQ = null;
        this.aHR = null;
        this.aHS = null;
        this.aHT = null;
        this.aHU = null;
        this.aHV = null;
        this.aHW = null;
        this.aHX = null;
        this.aHY = null;
        this.aHZ = null;
        this.mParent = null;
        this.aIb = null;
        this.aIc = null;
        this.aId = null;
        this.aIe = null;
        this.aIf = null;
        this.mContext = null;
        this.mForumName = null;
        this.mForumId = null;
        this.aIt = null;
        this.aIi = null;
        this.aIr = null;
        this.aIF = 0;
        this.aII = null;
        this.aIF = i;
        this.mContext = tbPageContext;
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_star_title, null);
        this.aIi = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.mParent.setVisibility(8);
        }
        this.aFS = (FrsOfficalBanner) this.mParent.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aFS.setVisibility(8);
        this.aHW = (RelativeLayout) this.mParent.findViewById(com.baidu.tieba.w.btn_love_content);
        this.aIE = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.speed_icon);
        this.aHX = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level_name);
        this.aHY = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level);
        this.aHZ = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.love_level_top);
        this.aIr = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_tag_text);
        this.aIt = new d(this.mParent, this.mContext.getPageActivity());
        this.aHO = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.love);
        this.aHP = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_love);
        this.zf = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_love);
        this.aHQ = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign);
        this.aHR = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_sign);
        this.aHS = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_sign);
        this.aHT = (ProgressBar) this.mParent.findViewById(com.baidu.tieba.w.sign_progress);
        this.aHU = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign_done);
        this.aHV = (TextView) this.mParent.findViewById(com.baidu.tieba.w.sign_done_text);
        this.zd = (TextView) this.mParent.findViewById(com.baidu.tieba.w.member_num_text);
        this.ze = (TextView) this.mParent.findViewById(com.baidu.tieba.w.post_num_text);
        this.mTitleText = (TextView) this.mParent.findViewById(com.baidu.tieba.w.title_text);
        this.aIV = (TbImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_top_pic);
        this.aIV.setOnClickListener(new t(this));
        this.aIW = (BarImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_bottom_photo);
        this.aIW.setGifIconSupport(false);
        this.aIX = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_enter_detail);
        if (com.baidu.adp.lib.b.f.da().Z("frs_to_bar_detail") == 0) {
            this.aIX.setVisibility(0);
        } else {
            this.aIX.setVisibility(8);
        }
        this.aII = (UserIconBox) this.mParent.findViewById(com.baidu.tieba.w.frs_badge_box);
        this.aID = new ba(this.mContext);
        this.aIb = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups);
        this.aIc = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups_text);
        this.aId = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games);
        this.aIe = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games_text);
        this.aIf = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_root);
        this.aIg = new z(this.mParent);
        this.aIL = (U9InfoView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_u9);
        if (this.aHH) {
            this.aIb.setVisibility(0);
        } else {
            this.aIb.setVisibility(8);
        }
    }

    public boolean Ht() {
        int[] iArr = new int[2];
        try {
            this.aIE.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aIW.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aIb.setOnClickListener(onClickListener);
        if (this.aId != null) {
            this.aId.setOnClickListener(onClickListener);
        }
        this.aHW.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.da().Z("frs_to_bar_detail") == 0) {
            this.mParent.setOnClickListener(new u(this));
        }
        this.aIt.setOnClickListener(onClickListener);
        this.aHP.setOnClickListener(onClickListener);
        this.aHR.setOnClickListener(onClickListener);
        this.aIr.setOnClickListener(new v(this));
    }

    public BarImageView Hw() {
        return this.aIW;
    }

    public TextView Hx() {
        return this.mTitleText;
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ab(i == 1);
        this.mContext.getLayoutMode().h(this.mParent);
        this.mContext.getLayoutMode().h(this.aIi);
        if (this.aIq) {
            fc(1);
        } else {
            fc(0);
        }
        bc.i((View) this.aHY, com.baidu.tbadk.core.util.d.bP(this.aIv));
        this.aIW.invalidate();
        this.aIV.invalidate();
        if (this.aIn >= 0 && this.aIn < aIA.length) {
            bc.i((View) this.aIr, aIA[this.aIn]);
        }
        bc.c(this.aIX, com.baidu.tieba.v.icon_arrow_right);
        this.zf.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aHS.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.zf.setShadowLayer(1.0f, 0.0f, 1.0f, bc.getColor(com.baidu.tieba.t.frs_like_shadow));
        this.aHS.setShadowLayer(1.0f, 0.0f, 1.0f, bc.getColor(com.baidu.tieba.t.frs_sign_shadow));
        bc.i(this.aIb, com.baidu.tieba.v.frs_top_item_bg);
        if (this.aId != null) {
            bc.i(this.aId, com.baidu.tieba.v.frs_top_item_bg);
        }
        if (this.aIF != 0) {
            bc.c(this.aIE, com.baidu.tieba.v.icon_speed_orange);
        } else {
            bc.c(this.aIE, com.baidu.tieba.v.icon_speed_gray);
        }
        if (this.aIg != null) {
            this.aIg.changeSkinType(i);
        }
        if (this.aIL != null) {
            this.aIL.c(this.mContext, i);
        }
        if (this.aII != null) {
            this.aII.ct(i);
        }
    }

    public void Hu() {
        if (this.aIF != 0) {
            bc.c(this.aIE, com.baidu.tieba.v.icon_speed_orange);
        } else {
            bc.c(this.aIE, com.baidu.tieba.v.icon_speed_gray);
        }
    }

    public View getView() {
        return this.mParent;
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aIl = forumData.getMember_num();
            this.aIm = forumData.getPost_num();
            this.aIo = forumData.getTag_name();
            this.aIp = forumData.getTag_color();
            this.aIC = forumData.getSignData().getCountSignNum();
            this.aIw = forumData.getCurScore();
            this.aIz = forumData.getAccelerateContent();
            this.aFJ = forumData.getLevelupScore();
            this.aEF = eVar;
            this.aIT = eVar.aeK();
            this.mBadgeData = forumData.getBadgeData();
            this.aIU = new com.baidu.tbadk.core.data.x();
            this.top_code = forumData.getTopCode();
            this.news_info = forumData.getNewsInfo();
            if (this.aIT != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aIT.aeQ());
                this.aIU.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aIT.aeR());
                this.aIU.getMedias().add(mediaData2);
            }
            this.mParent.setVisibility(0);
            this.aIt.setForumName(forumData.getName());
            Hv();
        }
    }

    private void Hv() {
        if (this.zd != null) {
            this.zd.setText(String.valueOf(this.aIl));
        }
        if (this.ze != null) {
            this.ze.setText(String.valueOf(this.aIm));
        }
        if (this.mTitleText != null) {
            if (this.mBadgeData != null && this.mBadgeData.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.mContext.getString(com.baidu.tieba.z.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aIo != null && this.aIo.length() > 0 && z) {
            if (this.aIr != null) {
                this.aIr.setText(this.aIo);
            }
            if (this.aIr != null && this.aIp != null && this.aIp.length() > 0) {
                this.aIn = Integer.parseInt(this.aIp);
                if (this.aIn >= 0 && this.aIn < aIA.length) {
                    bc.i((View) this.aIr, aIA[this.aIn]);
                }
            }
            if (this.aIr != null) {
                this.aIr.setVisibility(0);
            }
        } else if (this.aIr != null) {
            this.aIr.setVisibility(8);
        }
        if (this.aEF != null && this.aEF.mK() != null && this.aEF.mK().getIfpost() == 0) {
            if (this.aEF.aeJ().isEmpty()) {
                this.aIb.setVisibility(8);
            } else {
                this.aIb.setVisibility(0);
                if (this.aEF.aeL().aeA() > 0) {
                    this.aIc.setText(" (" + this.aEF.aeL().aeA() + ")");
                } else {
                    this.aIc.setText("");
                }
            }
        } else {
            this.aIb.setVisibility(0);
            if (this.aEF != null && this.aEF.aeL().aeA() > 0) {
                this.aIc.setText(" (" + this.aEF.aeL().aeA() + ")");
            } else {
                this.aIc.setText("");
            }
        }
        if (this.aHH) {
            this.aIb.setVisibility(0);
        } else {
            this.aIb.setVisibility(8);
        }
        if (this.aId != null && this.aIe != null) {
            if (this.aEF != null && this.aEF.aeD()) {
                this.aId.setVisibility(0);
                if (!TextUtils.isEmpty(this.aEF.getGameName()) && !TextUtils.isEmpty(this.aEF.getGameName().trim())) {
                    this.aIe.setText(UtilHelper.getFixedText(this.aEF.getGameName(), 10));
                    String is = com.baidu.tieba.tbadkCore.util.k.is(this.aEF.aeF());
                    if (!StringUtils.isNull(is)) {
                        TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", is, "ref_id", "1000601");
                    }
                } else {
                    this.aIe.setText("");
                }
            } else {
                this.aId.setVisibility(8);
            }
        }
        if (this.aEF != null && this.aEF.aeE() != null && this.aEF.aeE().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> aeE = this.aEF.aeE();
            R(aeE);
            int size = aeE.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aIf.setVisibility(0);
                this.aIf.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setSupportNoImage(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.l.d(this.mContext.getPageActivity(), com.baidu.tieba.u.ds6));
                    tbImageView.d(aeE.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_text)).setText(UtilHelper.getFixedText(aeE.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(aeE.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aIO);
                    this.aIf.addView(linearLayout);
                }
            } else {
                this.aIf.setVisibility(8);
            }
        } else {
            this.aIf.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIV.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.M(this.mContext.getContext());
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds300);
        this.aIV.setLayoutParams(layoutParams);
        this.aIV.setDefaultResource(com.baidu.tieba.v.def_star_top_pic);
        this.aIV.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIW.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int aeS = this.aIT.aeS();
        int aeT = this.aIT.aeT();
        if (aeS == 0 || aeT == 0) {
            aeS = layoutParams.width;
            aeT = layoutParams.height;
        }
        this.aIV.a(this.aIT.aeQ(), 16, aeS, aeT, false);
        this.aIW.d(this.aIT.aeR(), 16, false);
        if (this.aII != null && this.mBadgeData != null && this.mBadgeData.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.mBadgeData.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.mBadgeData.get(i3).mr());
                iconData.setIcon(this.mBadgeData.get(i3).mq());
                this.aIJ = this.mBadgeData.get(i3).ms();
                linkedList.add(iconData);
            }
            this.aII.setOnClickListener(this.aIP);
            this.aII.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_margin));
        }
        if (this.aEF != null) {
            this.aIg.a(this.aEF.aeK(), this.aEF.aeI());
        } else {
            this.aIg.a(null, null);
        }
        this.aIL.a(this.top_code, this.news_info);
    }

    private void applyNightMode(View view) {
        this.mContext.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.mContext.getLayoutMode().h(view);
    }

    private void R(List<com.baidu.tieba.tbadkCore.o> list) {
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
        this.aIF = i;
    }

    public void Gx() {
        PopupWindow popupWindow = new PopupWindow(this.mContext.getPageActivity());
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getContext(), com.baidu.tieba.x.speed_tip, null);
        this.mContext.getLayoutMode().h(inflate);
        popupWindow.setContentView(inflate);
        inflate.setOnClickListener(new w(this, popupWindow));
        popupWindow.setWidth(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds300));
        popupWindow.setHeight(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds88));
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new x(this, popupWindow));
        int[] iArr = new int[2];
        this.aIE.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.mParent, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aIE.getWidth() / 2), iArr[1] + this.aIE.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aIy = z;
        Bitmap bN = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_frs_signin_bar_down);
        if (bN != null && bN.getWidth() > 0) {
            if (this.aIy) {
                this.aHX.setText(com.baidu.tieba.z.star_bar_level_up);
                this.aHY.setText(String.valueOf(this.aIv + 1));
            } else {
                this.aHX.setText(this.aIu);
                this.aHY.setText(String.valueOf(this.aIv));
                bc.i((View) this.aHY, com.baidu.tbadk.core.util.d.bP(this.aIv));
            }
            if (this.aIy) {
                b(this.mContext.getOrignalPage(), this.aHZ, this.aIx, f);
            } else {
                a(this.mContext.getOrignalPage(), this.aHZ, this.aIx, f);
            }
            this.aIx = f;
        }
    }

    public void c(View view, boolean z) {
        if (this.aIF != 0 || TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aIh == null) {
                this.aIh = new PopupWindow(this.mContext.getPageActivity());
                this.aIh.setContentView(this.aIi);
                this.aIh.setBackgroundDrawable(new BitmapDrawable());
                this.aIh.setOutsideTouchable(true);
                this.aIh.setFocusable(true);
                this.aIh.setWidth(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_btn_width));
                this.aIh.setHeight(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_exp_height));
                this.aIj = (TextView) this.aIi.findViewById(com.baidu.tieba.w.cur_experience);
                this.aIk = (TextView) this.aIi.findViewById(com.baidu.tieba.w.levelup_experience);
                a(this.aIj, this.aIk);
            }
            if (this.aIh.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aIh, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aIj, this.aIk);
            int height = iArr[1] - this.aIh.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aIh, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aIh, this.mParent, 0, iArr[0], height);
            this.aIh.update();
            this.handler.postDelayed(this.aIN, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.w.speed_tip);
            bc.b((TextView) inflate.findViewById(com.baidu.tieba.w.experience), com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView3, com.baidu.tieba.t.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aIz) && !TextUtils.isEmpty(this.aIz.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aIz);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(com.baidu.tieba.z.cancel_text, new y(this));
            aVar.a(com.baidu.tieba.z.open_now, new q(this));
            aVar.b(this.mContext).nQ();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aIw));
        if (this.aFJ >= 10000) {
            if (this.aFJ % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFJ / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFJ / 10000.0f) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFJ));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aIu = str;
        this.aIv = i2;
        if (i == 0) {
            this.aHG = false;
            this.aHO.setVisibility(0);
            this.aHW.setVisibility(8);
            return;
        }
        this.aHG = true;
        this.aHO.setVisibility(8);
        if (z) {
            this.aID.v(this.aHO);
        }
        a(false, f);
        this.aHW.setVisibility(0);
    }

    public void fb(int i) {
        if (i == 0) {
            this.aHG = false;
            this.aHO.setVisibility(0);
            this.aHW.setVisibility(8);
            return;
        }
        this.aHG = true;
        this.aHO.setVisibility(8);
        this.aHW.setVisibility(0);
    }

    public void fc(int i) {
        if (i == 0) {
            this.aIq = false;
            this.aHU.setVisibility(8);
            this.aHQ.setVisibility(0);
            bc.i((View) this.aHR, com.baidu.tieba.v.frs_btn_sign);
            return;
        }
        this.aIq = true;
        this.aHQ.setVisibility(8);
        this.aHV.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aIC <= 1) {
            this.aHV.setText(this.mContext.getString(com.baidu.tieba.z.signed));
        } else {
            this.aHV.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.signed_less)) + String.valueOf(this.aIC) + this.mContext.getString(com.baidu.tieba.z.day));
        }
        this.aHU.setVisibility(0);
    }

    public boolean GV() {
        return this.aIq;
    }

    public void bY(boolean z) {
        this.aIB = z;
        if (this.aIB) {
            this.aHQ.setVisibility(0);
        } else {
            this.aHQ.setVisibility(4);
        }
    }

    public View Hy() {
        return this.aHW;
    }

    public boolean GE() {
        return this.aIy;
    }

    public boolean z(View view) {
        return this.aIt.y(view);
    }

    public void HA() {
        this.aIt.hide();
    }

    public void HB() {
        this.aIt.show();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.mParent.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar Hz() {
        return this.aHT;
    }

    public void onDestory() {
        this.aIK = true;
    }

    public void bZ(boolean z) {
        this.aIM = z;
    }
}
