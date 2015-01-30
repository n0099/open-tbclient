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
    private static final int[] aID = {com.baidu.tieba.v.label_green, com.baidu.tieba.v.label_blue, com.baidu.tieba.v.label_orange, com.baidu.tieba.v.label_red, com.baidu.tieba.v.label_purple};
    private com.baidu.tbadk.coreExtra.view.b TP;
    private int aFM;
    private FrsOfficalBanner aFV;
    private FrameLayout aHR;
    private Button aHS;
    private FrameLayout aHT;
    private Button aHU;
    private TextView aHV;
    private ProgressBar aHW;
    private FrameLayout aHX;
    private TextView aHY;
    private RelativeLayout aHZ;
    private String aIC;
    private boolean aIE;
    private int aIF;
    private final ba aIG;
    private ImageView aIH;
    private int aII;
    private UserIconBox aIL;
    private boolean aIN;
    private U9InfoView aIO;
    private boolean aIP;
    private final TbImageView aIY;
    private final BarImageView aIZ;
    private TextView aIa;
    private TextView aIb;
    private ImageView aIc;
    private LinearLayout aIe;
    private TextView aIf;
    private LinearLayout aIg;
    private TextView aIh;
    private LinearLayout aIi;
    private z aIj;
    private View aIl;
    private TextView aIu;
    private d aIw;
    private String aIx;
    private int aIy;
    private int aIz;
    private final ImageView aJa;
    private TbPageContext<FrsActivity> mContext;
    private String mForumId;
    private String mForumName;
    private View mParent;
    private TextView mTitleText;
    private ab news_info;
    private com.baidu.tbadk.core.data.y top_code;
    private TextView zg;
    private TextView zh;
    private TextView zi;
    private com.baidu.tieba.tbadkCore.e aEI = null;
    private int aIo = 0;
    private int aIp = 0;
    private com.baidu.tieba.tbadkCore.t aIW = null;
    com.baidu.tbadk.core.data.x aIX = null;
    private PopupWindow aIk = null;
    private TextView aIm = null;
    private TextView aIn = null;
    private int aIq = -1;
    private String aIr = null;
    private String aIs = null;
    private float aIA = 0.0f;
    private boolean aIB = false;
    private boolean aIt = false;
    private String aIM = String.valueOf(com.baidu.tbadk.data.b.SERVER_ADDRESS_WEB_VIEW) + "mo/q/topic_page/133_1";
    private ArrayList<com.baidu.tbadk.core.data.e> mBadgeData = null;
    final Runnable aIQ = new p(this);
    private View.OnClickListener aIR = new r(this);
    View.OnClickListener aIS = new s(this);
    private Handler handler = new Handler();

    public void setBannerViewClickListener(com.baidu.tbadk.coreExtra.view.b bVar) {
        this.TP = bVar;
        this.aFV.setBannerViewClickListener(bVar);
    }

    public void HI() {
        this.aFV.setVisibility(8);
    }

    public o(TbPageContext<FrsActivity> tbPageContext, String str, String str2, int i) {
        this.zg = null;
        this.zh = null;
        this.mTitleText = null;
        this.aHR = null;
        this.aHS = null;
        this.zi = null;
        this.aHT = null;
        this.aHU = null;
        this.aHV = null;
        this.aHW = null;
        this.aHX = null;
        this.aHY = null;
        this.aHZ = null;
        this.aIa = null;
        this.aIb = null;
        this.aIc = null;
        this.mParent = null;
        this.aIe = null;
        this.aIf = null;
        this.aIg = null;
        this.aIh = null;
        this.aIi = null;
        this.mContext = null;
        this.mForumName = null;
        this.mForumId = null;
        this.aIw = null;
        this.aIl = null;
        this.aIu = null;
        this.aII = 0;
        this.aIL = null;
        this.aII = i;
        this.mContext = tbPageContext;
        this.mForumName = str;
        this.mForumId = str2;
        this.mParent = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_star_title, null);
        this.aIl = com.baidu.adp.lib.g.b.ei().inflate(tbPageContext.getContext(), com.baidu.tieba.x.frs_show_experience, null);
        if (this.mForumName == null || this.mForumId == null) {
            this.mParent.setVisibility(8);
        }
        this.aFV = (FrsOfficalBanner) this.mParent.findViewById(com.baidu.tieba.w.frs_offical_banner);
        this.aFV.setVisibility(8);
        this.aHZ = (RelativeLayout) this.mParent.findViewById(com.baidu.tieba.w.btn_love_content);
        this.aIH = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.speed_icon);
        this.aIa = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level_name);
        this.aIb = (TextView) this.mParent.findViewById(com.baidu.tieba.w.level);
        this.aIc = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.love_level_top);
        this.aIu = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_tag_text);
        this.aIw = new d(this.mParent, this.mContext.getPageActivity());
        this.aHR = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.love);
        this.aHS = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_love);
        this.zi = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_love);
        this.aHT = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign);
        this.aHU = (Button) this.mParent.findViewById(com.baidu.tieba.w.btn_sign);
        this.aHV = (TextView) this.mParent.findViewById(com.baidu.tieba.w.tv_sign);
        this.aHW = (ProgressBar) this.mParent.findViewById(com.baidu.tieba.w.sign_progress);
        this.aHX = (FrameLayout) this.mParent.findViewById(com.baidu.tieba.w.sign_done);
        this.aHY = (TextView) this.mParent.findViewById(com.baidu.tieba.w.sign_done_text);
        this.zg = (TextView) this.mParent.findViewById(com.baidu.tieba.w.member_num_text);
        this.zh = (TextView) this.mParent.findViewById(com.baidu.tieba.w.post_num_text);
        this.mTitleText = (TextView) this.mParent.findViewById(com.baidu.tieba.w.title_text);
        this.aIY = (TbImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_top_pic);
        this.aIY.setOnClickListener(new t(this));
        this.aIZ = (BarImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_star_bottom_photo);
        this.aIZ.setGifIconSupport(false);
        this.aJa = (ImageView) this.mParent.findViewById(com.baidu.tieba.w.frs_enter_detail);
        if (com.baidu.adp.lib.b.f.da().Z("frs_to_bar_detail") == 0) {
            this.aJa.setVisibility(0);
        } else {
            this.aJa.setVisibility(8);
        }
        this.aIL = (UserIconBox) this.mParent.findViewById(com.baidu.tieba.w.frs_badge_box);
        this.aIG = new ba(this.mContext);
        this.aIe = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups);
        this.aIf = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_groups_text);
        this.aIg = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games);
        this.aIh = (TextView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_games_text);
        this.aIi = (LinearLayout) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_root);
        this.aIj = new z(this.mParent);
        this.aIO = (U9InfoView) this.mParent.findViewById(com.baidu.tieba.w.frs_header_enter_u9);
        if (this.aHK) {
            this.aIe.setVisibility(0);
        } else {
            this.aIe.setVisibility(8);
        }
    }

    public boolean Hz() {
        int[] iArr = new int[2];
        try {
            this.aIH.getLocationOnScreen(iArr);
            return iArr[0] >= 160 && iArr[1] >= 105;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public void o(View.OnClickListener onClickListener) {
        this.aIZ.setOnClickListener(onClickListener);
        this.mTitleText.setOnClickListener(onClickListener);
        this.aIe.setOnClickListener(onClickListener);
        if (this.aIg != null) {
            this.aIg.setOnClickListener(onClickListener);
        }
        this.aHZ.setOnClickListener(onClickListener);
        if (com.baidu.adp.lib.b.f.da().Z("frs_to_bar_detail") == 0) {
            this.mParent.setOnClickListener(new u(this));
        }
        this.aIw.setOnClickListener(onClickListener);
        this.aHS.setOnClickListener(onClickListener);
        this.aHU.setOnClickListener(onClickListener);
        this.aIu.setOnClickListener(new v(this));
    }

    public BarImageView HC() {
        return this.aIZ;
    }

    public TextView HD() {
        return this.mTitleText;
    }

    public void changeSkinType(int i) {
        this.mContext.getLayoutMode().ab(i == 1);
        this.mContext.getLayoutMode().h(this.mParent);
        this.mContext.getLayoutMode().h(this.aIl);
        if (this.aIt) {
            fc(1);
        } else {
            fc(0);
        }
        bc.i((View) this.aIb, com.baidu.tbadk.core.util.d.bP(this.aIy));
        this.aIZ.invalidate();
        this.aIY.invalidate();
        if (this.aIq >= 0 && this.aIq < aID.length) {
            bc.i((View) this.aIu, aID[this.aIq]);
        }
        bc.c(this.aJa, com.baidu.tieba.v.icon_arrow_right);
        this.zi.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_like), (Drawable) null, (Drawable) null, (Drawable) null);
        this.aHV.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_sign), (Drawable) null, (Drawable) null, (Drawable) null);
        this.zi.setShadowLayer(1.0f, 0.0f, 1.0f, bc.getColor(com.baidu.tieba.t.frs_like_shadow));
        this.aHV.setShadowLayer(1.0f, 0.0f, 1.0f, bc.getColor(com.baidu.tieba.t.frs_sign_shadow));
        bc.i(this.aIe, com.baidu.tieba.v.frs_top_item_bg);
        if (this.aIg != null) {
            bc.i(this.aIg, com.baidu.tieba.v.frs_top_item_bg);
        }
        if (this.aII != 0) {
            bc.c(this.aIH, com.baidu.tieba.v.icon_speed_orange);
        } else {
            bc.c(this.aIH, com.baidu.tieba.v.icon_speed_gray);
        }
        if (this.aIj != null) {
            this.aIj.changeSkinType(i);
        }
        if (this.aIO != null) {
            this.aIO.c(this.mContext, i);
        }
        if (this.aIL != null) {
            this.aIL.ct(i);
        }
    }

    public void HA() {
        if (this.aII != 0) {
            bc.c(this.aIH, com.baidu.tieba.v.icon_speed_orange);
        } else {
            bc.c(this.aIH, com.baidu.tieba.v.icon_speed_gray);
        }
    }

    public View getView() {
        return this.mParent;
    }

    public void c(ForumData forumData, com.baidu.tieba.tbadkCore.e eVar) {
        if (eVar != null) {
            this.mForumName = forumData.getName();
            this.mForumId = forumData.getId();
            this.aIo = forumData.getMember_num();
            this.aIp = forumData.getPost_num();
            this.aIr = forumData.getTag_name();
            this.aIs = forumData.getTag_color();
            this.aIF = forumData.getSignData().getCountSignNum();
            this.aIz = forumData.getCurScore();
            this.aIC = forumData.getAccelerateContent();
            this.aFM = forumData.getLevelupScore();
            this.aEI = eVar;
            this.aIW = eVar.aeP();
            this.mBadgeData = forumData.getBadgeData();
            this.aIX = new com.baidu.tbadk.core.data.x();
            this.top_code = forumData.getTopCode();
            this.news_info = forumData.getNewsInfo();
            if (this.aIW != null) {
                MediaData mediaData = new MediaData();
                mediaData.setType(3);
                mediaData.setPic(this.aIW.aeV());
                this.aIX.getMedias().add(mediaData);
                MediaData mediaData2 = new MediaData();
                mediaData2.setType(3);
                mediaData2.setPic(this.aIW.aeW());
                this.aIX.getMedias().add(mediaData2);
            }
            this.mParent.setVisibility(0);
            this.aIw.setForumName(forumData.getName());
            HB();
        }
    }

    private void HB() {
        if (this.zg != null) {
            this.zg.setText(String.valueOf(this.aIo));
        }
        if (this.zh != null) {
            this.zh.setText(String.valueOf(this.aIp));
        }
        if (this.mTitleText != null) {
            if (this.mBadgeData != null && this.mBadgeData.size() > 0) {
                this.mForumName = UtilHelper.getFixedText(this.mForumName, 7);
            }
            this.mTitleText.setText(String.valueOf(this.mForumName) + this.mContext.getString(com.baidu.tieba.z.forum));
        }
        boolean z = MessageManager.getInstance().findTask(2902025) != null;
        if (this.aIr != null && this.aIr.length() > 0 && z) {
            if (this.aIu != null) {
                this.aIu.setText(this.aIr);
            }
            if (this.aIu != null && this.aIs != null && this.aIs.length() > 0) {
                this.aIq = Integer.parseInt(this.aIs);
                if (this.aIq >= 0 && this.aIq < aID.length) {
                    bc.i((View) this.aIu, aID[this.aIq]);
                }
            }
            if (this.aIu != null) {
                this.aIu.setVisibility(0);
            }
        } else if (this.aIu != null) {
            this.aIu.setVisibility(8);
        }
        if (this.aEI != null && this.aEI.mR() != null && this.aEI.mR().getIfpost() == 0) {
            if (this.aEI.aeO().isEmpty()) {
                this.aIe.setVisibility(8);
            } else {
                this.aIe.setVisibility(0);
                if (this.aEI.aeQ().aeF() > 0) {
                    this.aIf.setText(" (" + this.aEI.aeQ().aeF() + ")");
                } else {
                    this.aIf.setText("");
                }
            }
        } else {
            this.aIe.setVisibility(0);
            if (this.aEI != null && this.aEI.aeQ().aeF() > 0) {
                this.aIf.setText(" (" + this.aEI.aeQ().aeF() + ")");
            } else {
                this.aIf.setText("");
            }
        }
        if (this.aHK) {
            this.aIe.setVisibility(0);
        } else {
            this.aIe.setVisibility(8);
        }
        if (this.aIg != null && this.aIh != null) {
            if (this.aEI != null && this.aEI.aeI()) {
                this.aIg.setVisibility(0);
                if (!TextUtils.isEmpty(this.aEI.getGameName()) && !TextUtils.isEmpty(this.aEI.getGameName().trim())) {
                    this.aIh.setText(UtilHelper.getFixedText(this.aEI.getGameName(), 10));
                    String iu = com.baidu.tieba.tbadkCore.util.k.iu(this.aEI.aeK());
                    if (!StringUtils.isNull(iu)) {
                        TiebaStatic.eventStat(this.mContext.getPageActivity(), "game_show", "show", 1, "dev_id", iu, "ref_id", "1000601");
                    }
                } else {
                    this.aIh.setText("");
                }
            } else {
                this.aIg.setVisibility(8);
            }
        }
        if (this.aEI != null && this.aEI.aeJ() != null && this.aEI.aeJ().size() > 0) {
            List<com.baidu.tieba.tbadkCore.o> aeJ = this.aEI.aeJ();
            R(aeJ);
            int size = aeJ.size();
            int i = size > 5 ? 5 : size;
            if (i > 0) {
                this.aIi.setVisibility(0);
                this.aIi.removeAllViews();
                for (int i2 = 0; i2 < i; i2++) {
                    LinearLayout linearLayout = (LinearLayout) com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.frs_header_enter_lay, null);
                    TbImageView tbImageView = (TbImageView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_icon);
                    tbImageView.setGifIconSupport(false);
                    tbImageView.setSupportNoImage(false);
                    tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    tbImageView.setDrawerType(1);
                    tbImageView.setRadius(com.baidu.adp.lib.util.l.d(this.mContext.getPageActivity(), com.baidu.tieba.u.ds6));
                    tbImageView.d(aeJ.get(i2).getIcon(), 21, false);
                    ((TextView) linearLayout.findViewById(com.baidu.tieba.w.frs_header_enters_text)).setText(UtilHelper.getFixedText(aeJ.get(i2).getTitle(), 10));
                    applyNightMode(linearLayout);
                    linearLayout.setTag(aeJ.get(i2).getUrl());
                    linearLayout.setOnClickListener(this.aIR);
                    this.aIi.addView(linearLayout);
                }
            } else {
                this.aIi.setVisibility(8);
            }
        } else {
            this.aIi.setVisibility(8);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.aIY.getLayoutParams();
        layoutParams.width = com.baidu.adp.lib.util.l.M(this.mContext.getContext());
        layoutParams.height = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.ds300);
        this.aIY.setLayoutParams(layoutParams);
        this.aIY.setDefaultResource(com.baidu.tieba.v.def_star_top_pic);
        this.aIY.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.aIZ.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        int aeX = this.aIW.aeX();
        int aeY = this.aIW.aeY();
        if (aeX == 0 || aeY == 0) {
            aeX = layoutParams.width;
            aeY = layoutParams.height;
        }
        this.aIY.a(this.aIW.aeV(), 16, aeX, aeY, false);
        this.aIZ.d(this.aIW.aeW(), 16, false);
        if (this.aIL != null && this.mBadgeData != null && this.mBadgeData.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (int i3 = 0; i3 < this.mBadgeData.size(); i3++) {
                IconData iconData = new IconData();
                iconData.setIconName(this.mBadgeData.get(i3).my());
                iconData.setIcon(this.mBadgeData.get(i3).mx());
                this.aIM = this.mBadgeData.get(i3).mz();
                linkedList.add(iconData);
            }
            this.aIL.setOnClickListener(this.aIS);
            this.aIL.a(linkedList, 2, this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_width), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_height), this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_starheader_badge_margin));
        }
        if (this.aEI != null) {
            this.aIj.a(this.aEI.aeP(), this.aEI.aeN());
        } else {
            this.aIj.a(null, null);
        }
        this.aIO.a(this.top_code, this.news_info);
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
        this.aII = i;
    }

    public void GD() {
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
        this.aIH.getLocationOnScreen(iArr);
        com.baidu.adp.lib.g.k.showPopupWindowAtLocation(popupWindow, this.mParent, 0, (iArr[0] - (popupWindow.getWidth() / 2)) + (this.aIH.getWidth() / 2), iArr[1] + this.aIH.getWidth());
        popupWindow.update();
    }

    @Override // com.baidu.tieba.frs.view.a
    public void a(boolean z, float f) {
        this.aIB = z;
        Bitmap bN = com.baidu.tbadk.core.util.d.bN(com.baidu.tieba.v.bg_frs_signin_bar_down);
        if (bN != null && bN.getWidth() > 0) {
            if (this.aIB) {
                this.aIa.setText(com.baidu.tieba.z.star_bar_level_up);
                this.aIb.setText(String.valueOf(this.aIy + 1));
            } else {
                this.aIa.setText(this.aIx);
                this.aIb.setText(String.valueOf(this.aIy));
                bc.i((View) this.aIb, com.baidu.tbadk.core.util.d.bP(this.aIy));
            }
            if (this.aIB) {
                b(this.mContext.getOrignalPage(), this.aIc, this.aIA, f);
            } else {
                a(this.mContext.getOrignalPage(), this.aIc, this.aIA, f);
            }
            this.aIA = f;
        }
    }

    public void c(View view, boolean z) {
        if (this.aII != 0 || TbadkCoreApplication.m255getInst().getIntentClass(MemberPrivilegeActivityConfig.class) == null) {
            if (this.aIk == null) {
                this.aIk = new PopupWindow(this.mContext.getPageActivity());
                this.aIk.setContentView(this.aIl);
                this.aIk.setBackgroundDrawable(new BitmapDrawable());
                this.aIk.setOutsideTouchable(true);
                this.aIk.setFocusable(true);
                this.aIk.setWidth(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_btn_width));
                this.aIk.setHeight(this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.u.frs_header_exp_height));
                this.aIm = (TextView) this.aIl.findViewById(com.baidu.tieba.w.cur_experience);
                this.aIn = (TextView) this.aIl.findViewById(com.baidu.tieba.w.levelup_experience);
                a(this.aIm, this.aIn);
            }
            if (this.aIk.isShowing()) {
                com.baidu.adp.lib.g.k.a(this.aIk, this.mContext.getPageActivity());
                return;
            }
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            a(this.aIm, this.aIn);
            int height = iArr[1] - this.aIk.getHeight();
            if (height <= 50) {
                com.baidu.adp.lib.g.k.a(this.aIk, this.mContext.getPageActivity());
                return;
            }
            com.baidu.adp.lib.g.k.showPopupWindowAtLocation(this.aIk, this.mParent, 0, iArr[0], height);
            this.aIk.update();
            this.handler.postDelayed(this.aIQ, 2000L);
        } else if (!z) {
            View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext.getPageActivity(), com.baidu.tieba.x.no_mem_dialog, null);
            TextView textView = (TextView) inflate.findViewById(com.baidu.tieba.w.cur_experience_mem);
            TextView textView2 = (TextView) inflate.findViewById(com.baidu.tieba.w.levelup_experience_mem);
            TextView textView3 = (TextView) inflate.findViewById(com.baidu.tieba.w.speed_tip);
            bc.b((TextView) inflate.findViewById(com.baidu.tieba.w.experience), com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView2, com.baidu.tieba.t.cp_cont_b, 1);
            bc.b(textView3, com.baidu.tieba.t.cp_cont_b, 1);
            if (!TextUtils.isEmpty(this.aIC) && !TextUtils.isEmpty(this.aIC.trim())) {
                textView3.setVisibility(0);
                textView3.setText(this.aIC);
            } else {
                textView3.setVisibility(8);
            }
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.mContext.getPageActivity());
            aVar.j(inflate);
            a(textView, textView2);
            aVar.b(com.baidu.tieba.z.cancel_text, new y(this));
            aVar.a(com.baidu.tieba.z.open_now, new q(this));
            aVar.b(this.mContext).nX();
        }
    }

    private void a(TextView textView, TextView textView2) {
        textView.setText(String.valueOf(this.aIz));
        if (this.aFM >= 10000) {
            if (this.aFM % TbConfig.BIG_IMAGE_MIN_CAPACITY == 0) {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFM / TbConfig.BIG_IMAGE_MIN_CAPACITY) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            } else {
                textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFM / 10000.0f) + this.mContext.getString(com.baidu.tieba.z.member_count_unit));
                return;
            }
        }
        textView2.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.experience_divider)) + String.valueOf(this.aFM));
    }

    public void a(int i, String str, int i2, float f, boolean z) {
        this.aIx = str;
        this.aIy = i2;
        if (i == 0) {
            this.aHJ = false;
            this.aHR.setVisibility(0);
            this.aHZ.setVisibility(8);
            return;
        }
        this.aHJ = true;
        this.aHR.setVisibility(8);
        if (z) {
            this.aIG.v(this.aHR);
        }
        a(false, f);
        this.aHZ.setVisibility(0);
    }

    public void fb(int i) {
        if (i == 0) {
            this.aHJ = false;
            this.aHR.setVisibility(0);
            this.aHZ.setVisibility(8);
            return;
        }
        this.aHJ = true;
        this.aHR.setVisibility(8);
        this.aHZ.setVisibility(0);
    }

    public void fc(int i) {
        if (i == 0) {
            this.aIt = false;
            this.aHX.setVisibility(8);
            this.aHT.setVisibility(0);
            bc.i((View) this.aHU, com.baidu.tieba.v.frs_btn_sign);
            return;
        }
        this.aIt = true;
        this.aHT.setVisibility(8);
        this.aHY.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(com.baidu.tieba.v.icon_sign_d), (Drawable) null, (Drawable) null, (Drawable) null);
        if (this.aIF <= 1) {
            this.aHY.setText(this.mContext.getString(com.baidu.tieba.z.signed));
        } else {
            this.aHY.setText(String.valueOf(this.mContext.getString(com.baidu.tieba.z.signed_less)) + String.valueOf(this.aIF) + this.mContext.getString(com.baidu.tieba.z.day));
        }
        this.aHX.setVisibility(0);
    }

    public boolean Hb() {
        return this.aIt;
    }

    public void bY(boolean z) {
        this.aIE = z;
        if (this.aIE) {
            this.aHT.setVisibility(0);
        } else {
            this.aHT.setVisibility(4);
        }
    }

    public View HE() {
        return this.aHZ;
    }

    public boolean GK() {
        return this.aIB;
    }

    public boolean z(View view) {
        return this.aIw.y(view);
    }

    public void HG() {
        this.aIw.hide();
    }

    public void HH() {
        this.aIw.show();
    }

    @Override // com.baidu.tbadk.imageManager.d
    public void a(com.baidu.adp.widget.a.a aVar, String str, boolean z) {
        ImageView imageView;
        if (aVar != null && (imageView = (ImageView) this.mParent.findViewWithTag(str)) != null) {
            aVar.a(imageView);
            imageView.invalidate();
        }
    }

    public ProgressBar HF() {
        return this.aHW;
    }

    public void onDestory() {
        this.aIN = true;
    }

    public void bZ(boolean z) {
        this.aIP = z;
    }
}
