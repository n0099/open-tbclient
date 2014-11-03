package com.baidu.tieba.im.groupInfo;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.view.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import java.util.List;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.base.f {
    private RelativeLayout KP;
    private PopupWindow aFv;
    private View aOT;
    private TextView aZx;
    private DialogInterface.OnClickListener baA;
    private final GroupInfoActivity baF;
    private View baG;
    private ProgressBar baH;
    private RelativeLayout baI;
    private TextView baJ;
    private TextView baK;
    private TextView baL;
    private TextView baM;
    private TextView baN;
    private EllipsizingTextView baO;
    private TextView baP;
    private RelativeLayout baQ;
    private PhotoWallView baR;
    private Dialog baS;
    private RelativeLayout baT;
    private RelativeLayout baU;
    private LinearLayout baV;
    private HeadImageView baW;
    private TextView baX;
    private RelativeLayout baY;
    private AlertDialog baZ;
    private TextView bbA;
    private final boolean bbB;
    private LinearLayout bbC;
    private TextView bbD;
    private com.baidu.tieba.im.message.i bbE;
    private final Handler bbF;
    private ImageView bba;
    private final View bbb;
    private DialogInterface.OnClickListener bbc;
    private RelativeLayout bbd;
    private LinearLayout bbe;
    private LinearLayout bbf;
    private TextView bbg;
    private RelativeLayout bbh;
    private RelativeLayout bbi;
    private LinearLayout bbj;
    private Dialog bbk;
    private LinearLayout bbl;
    private Dialog bbm;
    private ae bbn;
    private TextView bbo;
    private String bbp;
    private ImageView bbq;
    private RelativeLayout bbr;
    private TextView bbs;
    private ImageView bbt;
    private RelativeLayout bbu;
    private RelativeLayout bbv;
    private ImageView bbw;
    private ImageView bbx;
    private View bby;
    private TextView bbz;
    private NavigationBar mNavigationBar;
    public static int gid = 0;
    public static int bbG = 0;

    public t(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.baA = null;
        this.baS = null;
        this.baZ = null;
        this.bbc = null;
        this.bbp = "";
        this.bbB = true;
        this.bbF = new u(this);
        this.baF = groupInfoActivity;
        groupInfoActivity.setContentView(com.baidu.tieba.w.im_group_info_activity);
        this.bbb = com.baidu.adp.lib.g.b.ek().inflate(groupInfoActivity, com.baidu.tieba.w.group_activity_guide_toast, null);
        i(groupInfoActivity);
        j(groupInfoActivity);
        k(groupInfoActivity);
    }

    public void onPause() {
        this.bbF.removeMessages(0);
        OI();
    }

    private boolean OF() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("has_shown_activity_guide_toast", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OG() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("has_shown_activity_guide_toast", true);
    }

    public void setGroupName(String str) {
        this.bbs.setText(str);
        gi(str);
    }

    private void gi(String str) {
        if (str != null) {
            this.bbD.setText(str);
        }
    }

    public void gj(String str) {
        this.baO.setText(str);
    }

    private void i(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aOT = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bbD = this.mNavigationBar.setTitleText("");
        this.bbo = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(com.baidu.tieba.y.setup));
        this.bbo.setOnClickListener(groupInfoActivity);
        this.bbo.setVisibility(8);
    }

    private void j(GroupInfoActivity groupInfoActivity) {
        this.baG = groupInfoActivity.findViewById(com.baidu.tieba.v.line_activity_name_down);
        this.KP = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.group_info_container);
        this.baI = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_activity);
        this.baI.setOnClickListener(groupInfoActivity);
        this.baJ = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.tv_activity_name);
        this.baK = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_status);
        this.baL = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_name);
        this.bbd = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.address_layout);
        this.bbd.setOnClickListener(groupInfoActivity);
        this.bbl = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_body);
        this.bbq = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_type_icon);
        this.baM = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_number);
        this.baN = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_place);
        this.bbw = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_place);
        this.baO = (EllipsizingTextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro);
        this.baO.setMaxLines(20);
        this.baO.a(new v(this));
        this.baQ = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_forum);
        this.baP = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_forum);
        this.baQ.setOnClickListener(groupInfoActivity);
        this.baW = (HeadImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author);
        this.baW.setAutoChangeStyle(true);
        this.baW.setIsRound(false);
        this.aZx = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_author);
        this.baT = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_author);
        this.baT.setOnClickListener(groupInfoActivity);
        this.bba = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.meizhi_icon);
        this.bby = groupInfoActivity.findViewById(com.baidu.tieba.v.line_group_author_down);
        this.baV = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade_star);
        this.baQ.setOnClickListener(groupInfoActivity);
        this.baU = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade);
        this.baU.setOnClickListener(groupInfoActivity);
        this.baX = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_member_count);
        this.baY = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member);
        this.baY.setOnClickListener(groupInfoActivity);
        this.bbe = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member_photo);
        this.bbf = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.bottom_bar);
        this.bbC = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_bottom_button);
        this.bbg = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_join);
        this.bbC.setOnClickListener(this.baF);
        this.bbh = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_share);
        this.bbh.setOnClickListener(groupInfoActivity);
        this.bbi = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_invite);
        this.bbi.setOnClickListener(groupInfoActivity);
        this.bbj = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_notice_share);
        this.bbr = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_name);
        this.bbr.setOnClickListener(groupInfoActivity);
        this.bbs = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_name);
        this.bbt = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_intro_arrow);
        this.bbx = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author_arrow);
        this.bbu = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_intro);
        this.bbu.setOnClickListener(groupInfoActivity);
        this.bbu.setLongClickable(true);
        this.bbu.setOnLongClickListener(groupInfoActivity);
        this.bbz = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro_more);
        this.bbz.setClickable(true);
        this.bbz.setOnClickListener(new w(this));
        this.bbv = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_number);
        this.bbv.setOnLongClickListener(groupInfoActivity);
        this.bbA = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.can_create_mem_group);
        this.baH = (ProgressBar) groupInfoActivity.findViewById(com.baidu.tieba.v.progress_loading);
    }

    private void k(GroupInfoActivity groupInfoActivity) {
        this.baR = (PhotoWallView) groupInfoActivity.findViewById(com.baidu.tieba.v.photo_wall);
        this.baR.setPhotoClickListener(groupInfoActivity);
        this.baR.setPhotoLongClickListener(groupInfoActivity);
        this.baR.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OH() {
        try {
            if (this.aFv == null) {
                this.aFv = new PopupWindow(this.baF);
                this.aFv.setContentView(this.bbb);
                this.aFv.setWidth(this.baF.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds504));
                this.aFv.setHeight(this.baF.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds128));
                this.aFv.setBackgroundDrawable(new BitmapDrawable());
                this.aFv.setOutsideTouchable(true);
                this.aFv.setFocusable(true);
            }
            if (this.aFv.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.aFv, this.baF);
            } else {
                com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.aFv, this.baJ);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OI() {
        if (this.aFv != null && this.aFv.isShowing()) {
            try {
                this.aFv.dismiss();
                this.aFv = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RelativeLayout OJ() {
        return this.bbv;
    }

    public RelativeLayout OK() {
        return this.baQ;
    }

    public LinearLayout OL() {
        return this.bbe;
    }

    public RelativeLayout OM() {
        return this.bbh;
    }

    public RelativeLayout ON() {
        return this.bbi;
    }

    public RelativeLayout OO() {
        return this.bbu;
    }

    public RelativeLayout OP() {
        return this.bbr;
    }

    public RelativeLayout OQ() {
        return this.baI;
    }

    public TextView OR() {
        return this.bbo;
    }

    public LinearLayout OS() {
        return this.bbC;
    }

    public RelativeLayout OT() {
        return this.baT;
    }

    public RelativeLayout OU() {
        return this.baU;
    }

    public RelativeLayout OV() {
        return this.baY;
    }

    public View NA() {
        return this.aOT;
    }

    public void OW() {
        this.baH.setVisibility(8);
    }

    public void OX() {
        this.baH.setVisibility(0);
    }

    public void e(boolean z, String str) {
        if (z) {
            this.baN.setText(str);
            this.bbd.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.bbd.setVisibility(8);
        } else {
            this.baN.setText(str);
            this.bbd.setVisibility(0);
        }
    }

    public void dd(boolean z) {
        if (z) {
            this.baN.setText(this.mContext.getString(com.baidu.tieba.y.group_info_address_hide));
        } else {
            this.bbd.setVisibility(8);
        }
    }

    public RelativeLayout OY() {
        return this.bbd;
    }

    public void setData(com.baidu.tieba.im.message.i iVar) {
        a(iVar, false);
    }

    public void a(com.baidu.tieba.im.message.i iVar, boolean z) {
        if (iVar != null) {
            this.bbE = iVar;
            if (iVar.getGroup() != null) {
                gid = iVar.getGroup().getGroupId();
            }
            if (iVar.Qa() != null) {
                bbG = iVar.Qa().getActivityId();
            }
            TbadkApplication.m251getInst().getSkinType();
            this.bbl.setVisibility(0);
            this.bbf.setVisibility(0);
            if (iVar.getGroup() != null) {
                gi(iVar.getGroup().getName());
                this.baM.setText(String.valueOf(iVar.getGroup().getGroupId()));
                if (iVar.getGroup().isMeizhi()) {
                    this.bba.setVisibility(0);
                } else {
                    this.bba.setVisibility(8);
                }
                if (iVar.getGroup().getGroupType() == 4) {
                    this.bbq.setVisibility(0);
                    this.baW.setVisibility(8);
                    this.bbx.setVisibility(8);
                    this.bby.setVisibility(8);
                    this.aZx.setText(com.baidu.tieba.y.group_info_forum_author);
                    this.baT.setEnabled(false);
                    this.bba.setVisibility(8);
                } else {
                    this.bbq.setVisibility(8);
                    this.baW.setVisibility(0);
                    this.bbx.setVisibility(0);
                    this.bby.setVisibility(0);
                    this.aZx.setText(iVar.getGroup().getAuthorName());
                    this.baT.setEnabled(true);
                }
                String position = iVar.getGroup().getPosition();
                String business = iVar.getGroup().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.bbp = stringBuffer.toString();
                this.baN.setText(this.bbp);
                this.baO.setText(iVar.getGroup().getIntro());
                this.baX.setText("(" + iVar.getGroup().getMemberNum() + "/" + iVar.getGroup().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(iVar.getGroup().getAuthorPortrait())) {
                    this.baW.c(iVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (iVar.getGroup().getForumName() != null && iVar.getGroup().getForumName().length() > 0) {
                    this.baQ.setVisibility(0);
                    this.baP.setText(String.valueOf(iVar.getGroup().getForumName()) + this.baF.getString(com.baidu.tieba.y.bar));
                } else {
                    this.baQ.setVisibility(8);
                }
                this.baV.removeAllViews();
                boolean Qi = iVar.Qi();
                boolean isMemGroup = iVar.isMemGroup();
                if (isMemGroup) {
                    aw.b(this.bbD, com.baidu.tieba.s.im_group_vip_text, 1);
                }
                if (iVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < iVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.baF);
                        if (isMemGroup) {
                            aw.c(imageView, com.baidu.tieba.u.icon_vip_grade_big_middle_s);
                        } else {
                            aw.c(imageView, com.baidu.tieba.u.icon_grade_middle_star_s);
                        }
                        this.baV.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.baF);
                    if (isMemGroup) {
                        aw.c(imageView2, com.baidu.tieba.u.icon_vip_grade_big_middle_n);
                    } else {
                        aw.c(imageView2, com.baidu.tieba.u.icon_grade_middle_star_n);
                    }
                    this.baV.addView(imageView2);
                }
                if (Qi) {
                    this.bbA.setVisibility(0);
                } else {
                    this.bbA.setVisibility(8);
                }
            }
            if (iVar.Qg() && !OF()) {
                this.bbF.removeMessages(0);
                this.bbF.sendEmptyMessageDelayed(0, 600L);
            }
            if (iVar.Qa() != null) {
                this.baI.setVisibility(0);
                this.baG.setVisibility(0);
                GroupActivityData Qa = iVar.Qa();
                if (!iVar.Qf()) {
                    if (Qa.getIsEnd() != 1) {
                        this.baK.setVisibility(4);
                        this.baL.setText(com.baidu.tieba.y.group_info_activity_not_join_tip);
                    }
                } else {
                    this.baK.setVisibility(0);
                    this.baL.setText(Qa.getgActivityTitle());
                    if (Qa.getIsEnd() != 1) {
                        this.baK.setText(com.baidu.tieba.y.group_info_activity_doing);
                        aw.b(this.baK, com.baidu.tieba.s.group_info_activity_doing, 1);
                    } else {
                        this.baK.setText(com.baidu.tieba.y.group_info_activity_finish);
                        aw.b(this.baK, com.baidu.tieba.s.group_info_activity_finish, 1);
                    }
                    this.baL.setText(Qa.getgActivityTitle());
                }
            } else if (iVar.Qg()) {
                this.baI.setVisibility(0);
                this.baG.setVisibility(0);
                this.baK.setVisibility(4);
                this.baL.setText(com.baidu.tieba.y.group_info_create_activity);
            } else {
                this.baI.setVisibility(8);
                this.baG.setVisibility(8);
            }
            this.bbe.removeAllViews();
            if (iVar.Qb() != null && iVar.Qb().size() > 0) {
                List<MemberData> Qb = iVar.Qb();
                int size = Qb.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = Qb.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.baF);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(false);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_margin);
                    this.bbe.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.c(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (iVar.Qg()) {
                this.bbd.setEnabled(true);
                this.bbu.setEnabled(true);
                this.bbr.setVisibility(0);
                this.bbw.setVisibility(0);
                this.bbt.setVisibility(0);
                if (iVar.getGroup() != null) {
                    this.bbs.setText(iVar.getGroup().getName());
                }
            } else {
                this.bbd.setEnabled(false);
                this.bbu.setEnabled(true);
                this.bbt.setVisibility(8);
                this.bbw.setVisibility(8);
                this.baO.setPadding(0, 0, 0, 0);
            }
            if (iVar.Qf()) {
                this.bbj.setVisibility(0);
                this.bbo.setVisibility(0);
                if (this.baY.getParent() != this.bbj) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                    this.baY.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.bbl.removeView(this.baY);
                    this.bbj.addView(this.baY, 1, layoutParams2);
                }
                OZ();
            } else {
                this.bbj.setVisibility(8);
                this.bbo.setVisibility(8);
                if (this.baY.getParent() != this.bbl) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_bigside_paddinglr);
                    this.baY.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.bbj.removeView(this.baY);
                    this.bbl.addView(this.baY, 3, layoutParams3);
                }
                if (fR(iVar.getGroup().getFlag())) {
                    de(z);
                } else {
                    Pa();
                }
            }
            if (iVar.getGroup().getGroupType() == 4 || iVar.getGroup().getGroupType() == 5) {
                this.baU.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                this.baT.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.baT.setLayoutParams(layoutParams4);
            } else {
                this.baU.setVisibility(0);
            }
            a(iVar);
            if (iVar.getGroup().getIsHidePosition() == 1) {
                dd(iVar.Qg());
            } else {
                e(iVar.Qg(), this.bbp);
            }
        }
    }

    public void OZ() {
        this.bbg.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(this.bbg, com.baidu.tieba.s.group_info_bottom_text, 1);
        aw.h(this.bbC, com.baidu.tieba.u.group_info_foot_selector);
        this.bbg.setText(this.baF.getString(com.baidu.tieba.y.group_info_enter_chat));
        this.bbC.setEnabled(true);
    }

    private void de(boolean z) {
        this.bbg.setText(this.baF.getString(com.baidu.tieba.y.group_info_join));
        if (z) {
            this.bbg.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            aw.b(this.bbg, com.baidu.tieba.s.group_info_bottom_text, 1);
        } else {
            this.bbg.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            aw.b(this.bbg, com.baidu.tieba.s.group_info_join_disable_color, 1);
        }
        aw.h(this.bbC, com.baidu.tieba.u.group_info_foot_selector);
        this.bbC.setEnabled(true);
    }

    private boolean fR(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void Pa() {
        this.bbg.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.bbg.setText(this.baF.getString(com.baidu.tieba.y.group_info_refuse_join));
        this.bbg.setTextColor(this.baF.getResources().getColorStateList(com.baidu.tieba.s.group_info_join_resuse_color));
        this.bbC.setBackgroundColor(0);
        this.bbC.setEnabled(false);
    }

    public void gk(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.bbe.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.bbe.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.bbe.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(com.baidu.tieba.im.message.i iVar) {
        if (iVar != null) {
            this.baR.setIsManager(iVar.Qg());
            if (iVar.Qg()) {
                this.baR.setVisibility(0);
                if (iVar.Qc() != null && iVar.Qc().size() == 1 && TextUtils.isEmpty(iVar.Qc().get(0).getPicId())) {
                    this.baR.setData(null);
                } else {
                    this.baR.setData(iVar.Qc());
                }
            } else if (iVar.Qc() != null && iVar.Qc().size() > 0) {
                if (iVar.Qc().size() == 1 && TextUtils.isEmpty(iVar.Qc().get(0).getPicId())) {
                    this.baR.setVisibility(8);
                    return;
                }
                this.baR.setVisibility(0);
                this.baR.setData(iVar.Qc());
            } else {
                this.baR.setVisibility(8);
            }
        }
    }

    public void e(DialogInterface.OnClickListener onClickListener) {
        this.baA = onClickListener;
    }

    public void a(ae aeVar) {
        this.bbn = aeVar;
    }

    public void Pb() {
        if (this.baS == null) {
            GB();
        }
        com.baidu.adp.lib.g.j.a(this.baS, this.baF);
    }

    private void GB() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.baF);
        builder.setTitle(this.baF.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.baF.getResources().getString(com.baidu.tieba.y.take_photo), this.baF.getResources().getString(com.baidu.tieba.y.album)}, this.baA);
        this.baS = builder.create();
        this.baS.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.bbm != null) {
            this.bbm.dismiss();
            this.bbm = null;
        }
        b(obj, i);
        com.baidu.adp.lib.g.j.a(this.bbm, this.baF);
    }

    public void Pc() {
        this.bbm.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.baF);
        builder.setTitle(this.baF.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.baF.getResources().getString(com.baidu.tieba.y.group_info_set_portrait), this.baF.getResources().getString(com.baidu.tieba.y.delete), this.baF.getResources().getString(com.baidu.tieba.y.cancel)}, new x(this, obj, i));
        this.bbm = builder.create();
        this.bbm.setCanceledOnTouchOutside(true);
    }

    public void onDestory() {
        if (this.baR != null) {
            this.baR.onDestory();
        }
    }

    public void gl(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.baF.getString(com.baidu.tieba.y.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.baF);
            builder.setTitle(this.baF.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new y(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.g.j.a(create, this.baF);
        }
    }

    public void gm(String str) {
        if (this.bbk == null) {
            gn(str);
        }
        com.baidu.adp.lib.g.j.a(this.bbk, this.baF);
    }

    private void gn(String str) {
        if (this.bbk == null) {
            CharSequence[] charSequenceArr = {this.baF.getString(com.baidu.tieba.y.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.baF);
            builder.setTitle(this.baF.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new z(this, str));
            this.bbk = builder.create();
            this.bbk.setCanceledOnTouchOutside(true);
        }
    }

    public void Pd() {
        ColorStateList bz = aw.bz(com.baidu.tieba.s.group_info_join_disable_color);
        if (bz != null) {
            this.bbg.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.bbg.setTextColor(bz);
    }

    public void changeSkinType(int i) {
        this.baF.getLayoutMode().L(i == 1);
        this.baF.getLayoutMode().h(this.KP);
        this.baF.getLayoutMode().h(this.bbb);
        this.baR.a(i, this.baF);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.bbE != null && this.bbE.isMemGroup()) {
            aw.b(this.bbD, com.baidu.tieba.s.im_group_vip_text, 1);
        }
    }
}
