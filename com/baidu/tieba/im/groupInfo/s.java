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
public class s extends com.baidu.adp.base.f {
    private RelativeLayout KO;
    private PopupWindow aFl;
    private View aOF;
    private TextView aZk;
    private EllipsizingTextView baA;
    private TextView baB;
    private RelativeLayout baC;
    private PhotoWallView baD;
    private Dialog baE;
    private RelativeLayout baF;
    private RelativeLayout baG;
    private LinearLayout baH;
    private HeadImageView baI;
    private TextView baJ;
    private RelativeLayout baK;
    private AlertDialog baL;
    private ImageView baM;
    private final View baN;
    private DialogInterface.OnClickListener baO;
    private RelativeLayout baP;
    private LinearLayout baQ;
    private LinearLayout baR;
    private TextView baS;
    private RelativeLayout baT;
    private RelativeLayout baU;
    private LinearLayout baV;
    private Dialog baW;
    private LinearLayout baX;
    private Dialog baY;
    private ad baZ;
    private DialogInterface.OnClickListener bal;
    private final GroupInfoActivity baq;
    private View bas;
    private ProgressBar bat;
    private RelativeLayout bau;
    private TextView bav;
    private TextView baw;
    private TextView bax;
    private TextView bay;
    private TextView baz;
    private TextView bba;
    private String bbb;
    private ImageView bbc;
    private RelativeLayout bbd;
    private TextView bbe;
    private ImageView bbf;
    private RelativeLayout bbg;
    private RelativeLayout bbh;
    private ImageView bbi;
    private ImageView bbj;
    private View bbk;
    private TextView bbl;
    private TextView bbm;
    private final boolean bbn;
    private LinearLayout bbo;
    private TextView bbp;
    private com.baidu.tieba.im.message.i bbq;
    private final Handler bbr;
    private NavigationBar mNavigationBar;
    public static int gid = 0;
    public static int bbs = 0;

    public s(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity);
        this.bal = null;
        this.baE = null;
        this.baL = null;
        this.baO = null;
        this.bbb = "";
        this.bbn = true;
        this.bbr = new t(this);
        this.baq = groupInfoActivity;
        groupInfoActivity.setContentView(com.baidu.tieba.w.im_group_info_activity);
        this.baN = com.baidu.adp.lib.g.b.ek().inflate(groupInfoActivity, com.baidu.tieba.w.group_activity_guide_toast, null);
        i(groupInfoActivity);
        j(groupInfoActivity);
        k(groupInfoActivity);
    }

    public void onPause() {
        this.bbr.removeMessages(0);
        OF();
    }

    private boolean OC() {
        return com.baidu.tbadk.core.sharedPref.b.lk().getBoolean("has_shown_activity_guide_toast", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OD() {
        com.baidu.tbadk.core.sharedPref.b.lk().putBoolean("has_shown_activity_guide_toast", true);
    }

    public void setGroupName(String str) {
        this.bbe.setText(str);
        gi(str);
    }

    private void gi(String str) {
        if (str != null) {
            this.bbp.setText(str);
        }
    }

    public void gj(String str) {
        this.baA.setText(str);
    }

    private void i(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.aOF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bbp = this.mNavigationBar.setTitleText("");
        this.bba = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, groupInfoActivity.getString(com.baidu.tieba.y.setup));
        this.bba.setOnClickListener(groupInfoActivity);
        this.bba.setVisibility(8);
    }

    private void j(GroupInfoActivity groupInfoActivity) {
        this.bas = groupInfoActivity.findViewById(com.baidu.tieba.v.line_activity_name_down);
        this.KO = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.group_info_container);
        this.bau = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_activity);
        this.bau.setOnClickListener(groupInfoActivity);
        this.bav = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.tv_activity_name);
        this.baw = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_status);
        this.bax = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_activity_name);
        this.baP = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.address_layout);
        this.baP.setOnClickListener(groupInfoActivity);
        this.baX = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_body);
        this.bbc = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_type_icon);
        this.bay = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_number);
        this.baz = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_place);
        this.bbi = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_place);
        this.baA = (EllipsizingTextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro);
        this.baA.setMaxLines(20);
        this.baA.a(new u(this));
        this.baC = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_forum);
        this.baB = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_forum);
        this.baC.setOnClickListener(groupInfoActivity);
        this.baI = (HeadImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author);
        this.baI.setAutoChangeStyle(true);
        this.baI.setIsRound(false);
        this.aZk = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_author);
        this.baF = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_author);
        this.baF.setOnClickListener(groupInfoActivity);
        this.baM = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.meizhi_icon);
        this.bbk = groupInfoActivity.findViewById(com.baidu.tieba.v.line_group_author_down);
        this.baH = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade_star);
        this.baC.setOnClickListener(groupInfoActivity);
        this.baG = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_grade);
        this.baG.setOnClickListener(groupInfoActivity);
        this.baJ = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_member_count);
        this.baK = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member);
        this.baK.setOnClickListener(groupInfoActivity);
        this.baQ = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_member_photo);
        this.baR = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.bottom_bar);
        this.bbo = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_bottom_button);
        this.baS = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_join);
        this.bbo.setOnClickListener(this.baq);
        this.baT = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_share);
        this.baT.setOnClickListener(groupInfoActivity);
        this.baU = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_invite);
        this.baU.setOnClickListener(groupInfoActivity);
        this.baV = (LinearLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_notice_share);
        this.bbd = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_name);
        this.bbd.setOnClickListener(groupInfoActivity);
        this.bbe = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_name);
        this.bbf = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_intro_arrow);
        this.bbj = (ImageView) groupInfoActivity.findViewById(com.baidu.tieba.v.img_group_author_arrow);
        this.bbg = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_intro);
        this.bbg.setOnClickListener(groupInfoActivity);
        this.bbg.setLongClickable(true);
        this.bbg.setOnLongClickListener(groupInfoActivity);
        this.bbl = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.txt_group_intro_more);
        this.bbl.setClickable(true);
        this.bbl.setOnClickListener(new v(this));
        this.bbh = (RelativeLayout) groupInfoActivity.findViewById(com.baidu.tieba.v.lay_group_number);
        this.bbh.setOnLongClickListener(groupInfoActivity);
        this.bbm = (TextView) groupInfoActivity.findViewById(com.baidu.tieba.v.can_create_mem_group);
        this.bat = (ProgressBar) groupInfoActivity.findViewById(com.baidu.tieba.v.progress_loading);
    }

    private void k(GroupInfoActivity groupInfoActivity) {
        this.baD = (PhotoWallView) groupInfoActivity.findViewById(com.baidu.tieba.v.photo_wall);
        this.baD.setPhotoClickListener(groupInfoActivity);
        this.baD.setPhotoLongClickListener(groupInfoActivity);
        this.baD.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OE() {
        try {
            if (this.aFl == null) {
                this.aFl = new PopupWindow(this.baq);
                this.aFl.setContentView(this.baN);
                this.aFl.setWidth(this.baq.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds504));
                this.aFl.setHeight(this.baq.getResources().getDimensionPixelSize(com.baidu.tieba.t.ds128));
                this.aFl.setBackgroundDrawable(new BitmapDrawable());
                this.aFl.setOutsideTouchable(true);
                this.aFl.setFocusable(true);
            }
            if (this.aFl.isShowing()) {
                com.baidu.adp.lib.g.j.a(this.aFl, this.baq);
            } else {
                com.baidu.adp.lib.g.j.showPopupWindowAsDropDown(this.aFl, this.bav);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void OF() {
        if (this.aFl != null && this.aFl.isShowing()) {
            try {
                this.aFl.dismiss();
                this.aFl = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public RelativeLayout OG() {
        return this.bbh;
    }

    public RelativeLayout OH() {
        return this.baC;
    }

    public LinearLayout OI() {
        return this.baQ;
    }

    public RelativeLayout OJ() {
        return this.baT;
    }

    public RelativeLayout OK() {
        return this.baU;
    }

    public RelativeLayout OL() {
        return this.bbg;
    }

    public RelativeLayout OM() {
        return this.bbd;
    }

    public RelativeLayout ON() {
        return this.bau;
    }

    public TextView OO() {
        return this.bba;
    }

    public LinearLayout OP() {
        return this.bbo;
    }

    public RelativeLayout OQ() {
        return this.baF;
    }

    public RelativeLayout OR() {
        return this.baG;
    }

    public RelativeLayout OS() {
        return this.baK;
    }

    public View Nw() {
        return this.aOF;
    }

    public void OT() {
        this.bat.setVisibility(8);
    }

    public void OU() {
        this.bat.setVisibility(0);
    }

    public void e(boolean z, String str) {
        if (z) {
            this.baz.setText(str);
            this.baP.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.baP.setVisibility(8);
        } else {
            this.baz.setText(str);
            this.baP.setVisibility(0);
        }
    }

    public void dd(boolean z) {
        if (z) {
            this.baz.setText(this.mContext.getString(com.baidu.tieba.y.group_info_address_hide));
        } else {
            this.baP.setVisibility(8);
        }
    }

    public RelativeLayout OV() {
        return this.baP;
    }

    public void setData(com.baidu.tieba.im.message.i iVar) {
        a(iVar, false);
    }

    public void a(com.baidu.tieba.im.message.i iVar, boolean z) {
        if (iVar != null) {
            this.bbq = iVar;
            if (iVar.getGroup() != null) {
                gid = iVar.getGroup().getGroupId();
            }
            if (iVar.PX() != null) {
                bbs = iVar.PX().getActivityId();
            }
            TbadkApplication.m251getInst().getSkinType();
            this.baX.setVisibility(0);
            this.baR.setVisibility(0);
            if (iVar.getGroup() != null) {
                gi(iVar.getGroup().getName());
                this.bay.setText(String.valueOf(iVar.getGroup().getGroupId()));
                if (iVar.getGroup().isMeizhi()) {
                    this.baM.setVisibility(0);
                } else {
                    this.baM.setVisibility(8);
                }
                if (iVar.getGroup().getGroupType() == 4) {
                    this.bbc.setVisibility(0);
                    this.baI.setVisibility(8);
                    this.bbj.setVisibility(8);
                    this.bbk.setVisibility(8);
                    this.aZk.setText(com.baidu.tieba.y.group_info_forum_author);
                    this.baF.setEnabled(false);
                    this.baM.setVisibility(8);
                } else {
                    this.bbc.setVisibility(8);
                    this.baI.setVisibility(0);
                    this.bbj.setVisibility(0);
                    this.bbk.setVisibility(0);
                    this.aZk.setText(iVar.getGroup().getAuthorName());
                    this.baF.setEnabled(true);
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
                this.bbb = stringBuffer.toString();
                this.baz.setText(this.bbb);
                this.baA.setText(iVar.getGroup().getIntro());
                this.baJ.setText("(" + iVar.getGroup().getMemberNum() + "/" + iVar.getGroup().getMaxMemberNum() + ")");
                if (!TextUtils.isEmpty(iVar.getGroup().getAuthorPortrait())) {
                    this.baI.c(iVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (iVar.getGroup().getForumName() != null && iVar.getGroup().getForumName().length() > 0) {
                    this.baC.setVisibility(0);
                    this.baB.setText(String.valueOf(iVar.getGroup().getForumName()) + this.baq.getString(com.baidu.tieba.y.bar));
                } else {
                    this.baC.setVisibility(8);
                }
                this.baH.removeAllViews();
                boolean Qf = iVar.Qf();
                boolean isMemGroup = iVar.isMemGroup();
                if (isMemGroup) {
                    aw.b(this.bbp, com.baidu.tieba.s.im_group_vip_text, 1);
                }
                if (iVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < iVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.baq);
                        if (isMemGroup) {
                            aw.c(imageView, com.baidu.tieba.u.icon_vip_grade_big_middle_s);
                        } else {
                            aw.c(imageView, com.baidu.tieba.u.icon_grade_middle_star_s);
                        }
                        this.baH.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.baq);
                    if (isMemGroup) {
                        aw.c(imageView2, com.baidu.tieba.u.icon_vip_grade_big_middle_n);
                    } else {
                        aw.c(imageView2, com.baidu.tieba.u.icon_grade_middle_star_n);
                    }
                    this.baH.addView(imageView2);
                }
                if (Qf) {
                    this.bbm.setVisibility(0);
                } else {
                    this.bbm.setVisibility(8);
                }
            }
            if (iVar.Qd() && !OC()) {
                this.bbr.removeMessages(0);
                this.bbr.sendEmptyMessageDelayed(0, 600L);
            }
            if (iVar.PX() != null) {
                this.bau.setVisibility(0);
                this.bas.setVisibility(0);
                GroupActivityData PX = iVar.PX();
                if (!iVar.Qc()) {
                    if (PX.getIsEnd() != 1) {
                        this.baw.setVisibility(4);
                        this.bax.setText(com.baidu.tieba.y.group_info_activity_not_join_tip);
                    }
                } else {
                    this.baw.setVisibility(0);
                    this.bax.setText(PX.getgActivityTitle());
                    if (PX.getIsEnd() != 1) {
                        this.baw.setText(com.baidu.tieba.y.group_info_activity_doing);
                        aw.b(this.baw, com.baidu.tieba.s.group_info_activity_doing, 1);
                    } else {
                        this.baw.setText(com.baidu.tieba.y.group_info_activity_finish);
                        aw.b(this.baw, com.baidu.tieba.s.group_info_activity_finish, 1);
                    }
                    this.bax.setText(PX.getgActivityTitle());
                }
            } else if (iVar.Qd()) {
                this.bau.setVisibility(0);
                this.bas.setVisibility(0);
                this.baw.setVisibility(4);
                this.bax.setText(com.baidu.tieba.y.group_info_create_activity);
            } else {
                this.bau.setVisibility(8);
                this.bas.setVisibility(8);
            }
            this.baQ.removeAllViews();
            if (iVar.PY() != null && iVar.PY().size() > 0) {
                List<MemberData> PY = iVar.PY();
                int size = PY.size();
                int i2 = size > 7 ? 7 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = PY.get(i3);
                    HeadImageView headImageView = new HeadImageView(this.baq);
                    headImageView.setAutoChangeStyle(true);
                    headImageView.setIsRound(false);
                    headImageView.setTag(String.valueOf(memberData.getUserId()));
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_width);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_photo_margin);
                    this.baQ.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.c(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (iVar.Qd()) {
                this.baP.setEnabled(true);
                this.bbg.setEnabled(true);
                this.bbd.setVisibility(0);
                this.bbi.setVisibility(0);
                this.bbf.setVisibility(0);
                if (iVar.getGroup() != null) {
                    this.bbe.setText(iVar.getGroup().getName());
                }
            } else {
                this.baP.setEnabled(false);
                this.bbg.setEnabled(true);
                this.bbf.setVisibility(8);
                this.bbi.setVisibility(8);
                this.baA.setPadding(0, 0, 0, 0);
            }
            if (iVar.Qc()) {
                this.baV.setVisibility(0);
                this.bba.setVisibility(0);
                if (this.baK.getParent() != this.baV) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    int dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_paddingtb);
                    int dimensionPixelSize3 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                    this.baK.setPadding(dimensionPixelSize3, dimensionPixelSize2, dimensionPixelSize3, 0);
                    this.baX.removeView(this.baK);
                    this.baV.addView(this.baK, 1, layoutParams2);
                }
                OW();
            } else {
                this.baV.setVisibility(8);
                this.bba.setVisibility(8);
                if (this.baK.getParent() != this.baX) {
                    LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                    int dimensionPixelSize4 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_bigside_paddinglr);
                    this.baK.setPadding(dimensionPixelSize4, 0, dimensionPixelSize4, 0);
                    this.baV.removeView(this.baK);
                    this.baX.addView(this.baK, 3, layoutParams3);
                }
                if (fR(iVar.getGroup().getFlag())) {
                    de(z);
                } else {
                    OX();
                }
            }
            if (iVar.getGroup().getGroupType() == 4 || iVar.getGroup().getGroupType() == 5) {
                this.baG.setVisibility(8);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                int dimensionPixelSize5 = this.mContext.getResources().getDimensionPixelSize(com.baidu.tieba.t.im_group_info_item_side_paddinglr);
                this.baF.setPadding(dimensionPixelSize5, 0, dimensionPixelSize5, 0);
                this.baF.setLayoutParams(layoutParams4);
            } else {
                this.baG.setVisibility(0);
            }
            a(iVar);
            if (iVar.getGroup().getIsHidePosition() == 1) {
                dd(iVar.Qd());
            } else {
                e(iVar.Qd(), this.bbb);
            }
        }
    }

    public void OW() {
        this.baS.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        aw.b(this.baS, com.baidu.tieba.s.group_info_bottom_text, 1);
        aw.h(this.bbo, com.baidu.tieba.u.group_info_foot_selector);
        this.baS.setText(this.baq.getString(com.baidu.tieba.y.group_info_enter_chat));
        this.bbo.setEnabled(true);
    }

    private void de(boolean z) {
        this.baS.setText(this.baq.getString(com.baidu.tieba.y.group_info_join));
        if (z) {
            this.baS.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            aw.b(this.baS, com.baidu.tieba.s.group_info_bottom_text, 1);
        } else {
            this.baS.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            aw.b(this.baS, com.baidu.tieba.s.group_info_join_disable_color, 1);
        }
        aw.h(this.bbo, com.baidu.tieba.u.group_info_foot_selector);
        this.bbo.setEnabled(true);
    }

    private boolean fR(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void OX() {
        this.baS.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.baS.setText(this.baq.getString(com.baidu.tieba.y.group_info_refuse_join));
        this.baS.setTextColor(this.baq.getResources().getColorStateList(com.baidu.tieba.s.group_info_join_resuse_color));
        this.bbo.setBackgroundColor(0);
        this.bbo.setEnabled(false);
    }

    public void gk(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.baQ.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.baQ.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.baQ.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(com.baidu.tieba.im.message.i iVar) {
        if (iVar != null) {
            this.baD.setIsManager(iVar.Qd());
            if (iVar.Qd()) {
                this.baD.setVisibility(0);
                if (iVar.PZ() != null && iVar.PZ().size() == 1 && TextUtils.isEmpty(iVar.PZ().get(0).getPicId())) {
                    this.baD.setData(null);
                } else {
                    this.baD.setData(iVar.PZ());
                }
            } else if (iVar.PZ() != null && iVar.PZ().size() > 0) {
                if (iVar.PZ().size() == 1 && TextUtils.isEmpty(iVar.PZ().get(0).getPicId())) {
                    this.baD.setVisibility(8);
                    return;
                }
                this.baD.setVisibility(0);
                this.baD.setData(iVar.PZ());
            } else {
                this.baD.setVisibility(8);
            }
        }
    }

    public void e(DialogInterface.OnClickListener onClickListener) {
        this.bal = onClickListener;
    }

    public void a(ad adVar) {
        this.baZ = adVar;
    }

    public void OY() {
        if (this.baE == null) {
            Gz();
        }
        com.baidu.adp.lib.g.j.a(this.baE, this.baq);
    }

    private void Gz() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.baq);
        builder.setTitle(this.baq.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.baq.getResources().getString(com.baidu.tieba.y.take_photo), this.baq.getResources().getString(com.baidu.tieba.y.album)}, this.bal);
        this.baE = builder.create();
        this.baE.setCanceledOnTouchOutside(true);
    }

    public void a(Object obj, int i) {
        if (this.baY != null) {
            this.baY.dismiss();
            this.baY = null;
        }
        b(obj, i);
        com.baidu.adp.lib.g.j.a(this.baY, this.baq);
    }

    public void OZ() {
        this.baY.dismiss();
    }

    private void b(Object obj, int i) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.baq);
        builder.setTitle(this.baq.getResources().getString(com.baidu.tieba.y.operation));
        builder.setItems(new String[]{this.baq.getResources().getString(com.baidu.tieba.y.group_info_set_portrait), this.baq.getResources().getString(com.baidu.tieba.y.delete), this.baq.getResources().getString(com.baidu.tieba.y.cancel)}, new w(this, obj, i));
        this.baY = builder.create();
        this.baY.setCanceledOnTouchOutside(true);
    }

    public void onDestory() {
        if (this.baD != null) {
            this.baD.onDestory();
        }
    }

    public void gl(String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.baq.getString(com.baidu.tieba.y.copy_group_introduction)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.baq);
            builder.setTitle(this.baq.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new x(this, str));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            com.baidu.adp.lib.g.j.a(create, this.baq);
        }
    }

    public void gm(String str) {
        if (this.baW == null) {
            gn(str);
        }
        com.baidu.adp.lib.g.j.a(this.baW, this.baq);
    }

    private void gn(String str) {
        if (this.baW == null) {
            CharSequence[] charSequenceArr = {this.baq.getString(com.baidu.tieba.y.copy_group_number)};
            AlertDialog.Builder builder = new AlertDialog.Builder(this.baq);
            builder.setTitle(this.baq.getString(com.baidu.tieba.y.operation));
            builder.setItems(charSequenceArr, new y(this, str));
            this.baW = builder.create();
            this.baW.setCanceledOnTouchOutside(true);
        }
    }

    public void Pa() {
        ColorStateList bz = aw.bz(com.baidu.tieba.s.group_info_join_disable_color);
        if (bz != null) {
            this.baS.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(com.baidu.tieba.u.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.baS.setTextColor(bz);
    }

    public void changeSkinType(int i) {
        this.baq.getLayoutMode().L(i == 1);
        this.baq.getLayoutMode().h(this.KO);
        this.baq.getLayoutMode().h(this.baN);
        this.baD.a(i, this.baq);
        this.mNavigationBar.onChangeSkinType(i);
        if (this.bbq != null && this.bbq.isMemGroup()) {
            aw.b(this.bbp, com.baidu.tieba.s.im_group_vip_text, 1);
        }
    }
}
