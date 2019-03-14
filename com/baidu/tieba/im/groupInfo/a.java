package com.baidu.tieba.im.groupInfo;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int gnK = 0;
    private ScrollView aYD;
    private RelativeLayout cMr;
    private View eLd;
    private boolean eQx;
    private View gbp;
    private TextView glH;
    private final GroupInfoActivity gmK;
    private View gmL;
    private ProgressBar gmM;
    private RelativeLayout gmN;
    private TextView gmO;
    private TextView gmP;
    private TextView gmQ;
    private TextView gmR;
    private EllipsizingTextView gmS;
    private TextView gmT;
    private RelativeLayout gmU;
    private PhotoWallView gmV;
    private RelativeLayout gmW;
    private RelativeLayout gmX;
    private LinearLayout gmY;
    private HeadImageView gmZ;
    private ImageView gnA;
    private View gnB;
    private TextView gnC;
    private TextView gnD;
    private LinearLayout gnE;
    private View gnF;
    private TextView gnG;
    private ResponseGroupInfoLocalMessage.a gnH;
    private boolean gnI;
    private boolean gnJ;
    private TextView gna;
    private RelativeLayout gnb;
    private com.baidu.tbadk.core.dialog.b gnc;
    private ImageView gnd;
    private final View gne;
    private b.InterfaceC0225b gnf;
    private RelativeLayout gng;
    private LinearLayout gnh;
    private HeadImageView[] gni;
    private LinearLayout gnj;
    private TextView gnk;
    private RelativeLayout gnl;
    private LinearLayout gnm;
    private com.baidu.tbadk.core.dialog.b gnn;
    private LinearLayout gno;
    private g gnp;
    private b gnq;
    private TextView gnr;
    private String gns;
    private ImageView gnt;
    private RelativeLayout gnu;
    private TextView gnv;
    private ImageView gnw;
    private RelativeLayout gnx;
    private RelativeLayout gny;
    private ImageView gnz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gnc = null;
        this.gnf = null;
        this.gni = new HeadImageView[5];
        this.gns = "";
        this.gnI = true;
        this.isMemGroup = false;
        this.eQx = false;
        this.gnJ = false;
        this.gmK = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.gne = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.aYD.setVisibility(4);
        this.gnj.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gnv.setText(str);
        xg(str);
    }

    private void xg(String str) {
        if (str != null) {
            this.gnG.setText(str);
        }
    }

    public void xh(String str) {
        this.gmS.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.gbp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gnG = this.mNavigationBar.setTitleText("");
        this.gnF = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gnr = (TextView) this.gnF.findViewById(d.g.right_textview);
        this.gnr.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        al.d(this.gnr, d.C0277d.cp_cont_f, 1);
        this.gnr.setOnClickListener(groupInfoActivity);
        this.gnF.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gmL = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.cMr = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.aYD = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.aYD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()) {
                    case 0:
                        a.this.mBottomLine.setVisibility(0);
                        break;
                    case 1:
                        a.this.mBottomLine.setVisibility(0);
                        break;
                    case 2:
                        a.this.mBottomLine.setVisibility(8);
                        break;
                }
                return false;
            }
        });
        this.eLd = groupInfoActivity.findViewById(d.g.group_top_view);
        this.eLd.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gmN = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.gmN.setOnClickListener(groupInfoActivity);
        this.gmO = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.gmP = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.gng = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.gng.setOnClickListener(groupInfoActivity);
        this.gno = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.gnt = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.gmQ = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.gmR = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.gnz = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.gmS = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.gmS.setMaxLines(20);
        this.gmS.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kd(boolean z) {
                if (z) {
                    a.this.gnC.setVisibility(0);
                } else {
                    a.this.gnC.setVisibility(8);
                }
            }
        });
        this.gmU = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.gmT = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.gmU.setOnClickListener(groupInfoActivity);
        this.gmZ = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.gmZ.setAutoChangeStyle(true);
        this.gmZ.setIsRound(false);
        this.glH = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.gmW = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.gmW.setOnClickListener(groupInfoActivity);
        this.gnd = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.gnB = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.gmY = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.gmU.setOnClickListener(groupInfoActivity);
        this.gmX = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.gmX.setOnClickListener(groupInfoActivity);
        this.gna = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.gnb = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.gnb.setOnClickListener(groupInfoActivity);
        this.gnh = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.gnj = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.gnE = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.gnk = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.gnE.setOnClickListener(this.gmK);
        this.gnl = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.gnl.setOnClickListener(groupInfoActivity);
        this.gnm = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.gnu = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.gnu.setOnClickListener(groupInfoActivity);
        this.gnv = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.gnw = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.gnA = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.gnx = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.gnx.setOnClickListener(groupInfoActivity);
        this.gnx.setLongClickable(true);
        this.gnx.setOnLongClickListener(groupInfoActivity);
        this.gnC = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.gnC.setClickable(true);
        this.gnC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gmS.setMaxLines(1000);
            }
        });
        this.gny = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.gny.setOnLongClickListener(groupInfoActivity);
        this.gnD = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.gmM = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gmV = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.gmV.setPhotoClickListener(groupInfoActivity);
        this.gmV.setPhotoLongClickListener(groupInfoActivity);
        this.gmV.setVisibility(8);
    }

    public RelativeLayout bub() {
        return this.gny;
    }

    public RelativeLayout buc() {
        return this.gmU;
    }

    public LinearLayout bud() {
        return this.gnh;
    }

    public RelativeLayout bue() {
        return this.gnl;
    }

    public RelativeLayout buf() {
        return this.gnx;
    }

    public RelativeLayout bug() {
        return this.gnu;
    }

    public RelativeLayout buh() {
        return this.gmN;
    }

    public View bui() {
        return this.gnr;
    }

    public LinearLayout buj() {
        return this.gnE;
    }

    public RelativeLayout buk() {
        return this.gmW;
    }

    public RelativeLayout bul() {
        return this.gmX;
    }

    public RelativeLayout bum() {
        return this.gnb;
    }

    public View bsW() {
        return this.gbp;
    }

    public void bun() {
        this.gmM.setVisibility(8);
    }

    public void buo() {
        this.gmM.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gmR.setText(str);
            this.gng.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gng.setVisibility(8);
        } else {
            this.gmR.setText(str);
            this.gng.setVisibility(0);
        }
    }

    public void lk(boolean z) {
        if (z) {
            this.gmR.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.gng.setVisibility(8);
        }
    }

    public RelativeLayout bup() {
        return this.gng;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eQx = aVar.buZ();
            this.gnJ = aVar.bva();
            this.gnH = aVar;
            this.gnI = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.buU() != null) {
                gnK = aVar.buU().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gno.setVisibility(0);
            this.gnj.setVisibility(0);
            if (aVar.getGroup() != null) {
                xg(aVar.getGroup().getName());
                this.gmQ.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gnd.setVisibility(0);
                } else {
                    this.gnd.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gnt.setVisibility(0);
                    this.gmZ.setVisibility(8);
                    this.gnA.setVisibility(8);
                    this.gnB.setVisibility(8);
                    this.glH.setText(d.j.group_info_forum_author);
                    this.gmW.setEnabled(false);
                    this.gnd.setVisibility(8);
                } else {
                    this.gnt.setVisibility(8);
                    this.gmZ.setVisibility(0);
                    this.gnA.setVisibility(0);
                    this.gnB.setVisibility(0);
                    this.glH.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gmW.setEnabled(true);
                }
                String position = aVar.getGroup().getPosition();
                String business = aVar.getGroup().getBusiness();
                StringBuffer stringBuffer = new StringBuffer();
                if (position != null) {
                    stringBuffer.append(position);
                }
                if (business != null) {
                    stringBuffer.append(business);
                }
                this.gns = stringBuffer.toString();
                this.gmR.setText(this.gns);
                this.gmS.setText(aVar.getGroup().getIntro());
                this.gna.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gmZ.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gmU.setVisibility(0);
                    this.gmT.setText(aVar.getGroup().getForumName() + this.gmK.getPageContext().getString(d.j.forum));
                } else {
                    this.gmU.setVisibility(8);
                }
                this.gmY.removeAllViews();
                boolean bvb = aVar.bvb();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.d(this.gnG, d.C0277d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gmK.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.gmY.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gmK.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.gmY.addView(imageView2);
                }
                if (bvb) {
                    this.gnD.setVisibility(0);
                } else {
                    this.gnD.setVisibility(8);
                }
            }
            if (aVar.buU() != null) {
                this.gmN.setVisibility(0);
                this.gmL.setVisibility(0);
                GroupActivityData buU = aVar.buU();
                if (!aVar.buZ()) {
                    if (buU.getIsEnd() != 1) {
                        this.gmO.setVisibility(4);
                        this.gmP.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.gmN.setVisibility(8);
                        this.gmL.setVisibility(8);
                    }
                } else {
                    this.gmO.setVisibility(0);
                    this.gmP.setText(buU.getgActivityTitle());
                    if (buU.getIsEnd() != 1) {
                        this.gmO.setText(d.j.group_info_activity_doing);
                        al.d(this.gmO, d.C0277d.common_color_10171, 1);
                    } else {
                        this.gmO.setText(d.j.group_activity_end);
                        al.d(this.gmO, d.C0277d.common_color_10168, 1);
                    }
                    this.gmP.setText(buU.getgActivityTitle());
                }
            } else if (aVar.bva()) {
                this.gmN.setVisibility(0);
                this.gmL.setVisibility(0);
                this.gmO.setVisibility(4);
                this.gmP.setText(d.j.group_info_create_activity);
            } else {
                this.gmN.setVisibility(8);
                this.gmL.setVisibility(8);
            }
            this.gnh.removeAllViews();
            if (aVar.buV() != null && aVar.buV().size() > 0) {
                List<MemberData> buV = aVar.buV();
                int size = buV.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = buV.get(i3);
                    HeadImageView headImageView = this.gni[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gmK.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gni[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.gnh.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bva()) {
                this.gng.setEnabled(true);
                this.gnx.setEnabled(true);
                al.k(this.gnx, d.f.group_info_item);
                this.gnu.setVisibility(0);
                this.gnz.setVisibility(0);
                this.gnw.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gnv.setText(aVar.getGroup().getName());
                }
            } else {
                this.gng.setEnabled(false);
                this.gnx.setEnabled(true);
                al.l(this.gnx, d.C0277d.cp_bg_line_d);
                this.gnw.setVisibility(8);
                this.gnz.setVisibility(8);
                this.gmS.setPadding(0, 0, 0, 0);
            }
            if (aVar.buZ()) {
                this.gnm.setVisibility(0);
                this.gnF.setVisibility(0);
                if (this.gnb.getParent() != this.gnm) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.gno.removeView(this.gnb);
                    this.gnm.addView(this.gnb, 1);
                }
                buq();
            } else {
                this.gnm.setVisibility(8);
                this.gnF.setVisibility(8);
                if (this.gnb.getParent() != this.gno) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.gnm.removeView(this.gnb);
                    this.gno.addView(this.gnb, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gmX.setVisibility(8);
            } else {
                this.gmX.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                lk(aVar.bva());
            } else {
                m(aVar.bva(), this.gns);
            }
            this.aYD.setVisibility(0);
            this.gnj.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (ua(aVar.getGroup().getFlag())) {
                ll(z);
            } else {
                bur();
            }
        }
    }

    public void buq() {
        this.gnk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.gnk, d.C0277d.cp_btn_a, 1);
        this.gnk.setText(this.gmK.getPageContext().getString(d.j.i_want_talk));
        this.gnE.setEnabled(true);
    }

    private void ll(boolean z) {
        this.gnk.setText(this.gmK.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.gnk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gnk, d.C0277d.cp_btn_a, 1);
        } else {
            this.gnk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gnk, d.C0277d.cp_btn_a, 1);
        }
        al.k(this.gnE, d.f.btn_blue_bg);
        this.gnE.setEnabled(true);
    }

    private boolean ua(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bur() {
        this.gnk.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gnk.setText(this.gmK.getPageContext().getString(d.j.group_info_refuse_join));
        this.gnk.setTextColor(this.gmK.getResources().getColorStateList(d.C0277d.cp_btn_a));
        al.k(this.gnE, d.f.btn_app_download_d);
        this.gnE.setEnabled(false);
    }

    public void xi(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gnh.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gnh.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gnh.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gmV.setIsManager(aVar.bva());
            if (aVar.bva()) {
                this.gmV.setVisibility(0);
                if (aVar.buW() != null && aVar.buW().size() == 1 && TextUtils.isEmpty(aVar.buW().get(0).getPicId())) {
                    this.gmV.setData(null);
                } else {
                    this.gmV.setData(aVar.buW());
                }
            } else if (aVar.buW() != null && aVar.buW().size() > 0) {
                if (aVar.buW().size() == 1 && TextUtils.isEmpty(aVar.buW().get(0).getPicId())) {
                    this.gmV.setVisibility(8);
                    return;
                }
                this.gmV.setVisibility(0);
                this.gmV.setData(aVar.buW());
            } else {
                this.gmV.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gnq = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gnp != null) {
            this.gnp.dismiss();
            this.gnp = null;
        }
        e(obj, i);
        this.gnp.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gnp == null) {
            this.gnp = new g(this.gmK.getPageContext());
            this.gnp.a(null, new String[]{this.gmK.getResources().getString(d.j.group_info_set_portrait), this.gmK.getResources().getString(d.j.delete)}, new i.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i2, View view) {
                    if (a.this.gnp != null && a.this.gnp.isShowing()) {
                        a.this.gnq.a(a.this.gnp, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gmV != null) {
            this.gmV.onDestory();
        }
        if (this.gmZ != null) {
            this.gmZ.stopLoad();
            this.gmZ.setBackgroundDrawable(null);
            this.gmZ.setImageDrawable(null);
        }
        if (this.gnh != null && this.gni != null) {
            int length = this.gni.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gni[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void xj(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gmK.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gmK.getPageContext().getPageActivity());
            bVar.lz(this.gmK.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmK.getSystemService("clipboard")).setText(str);
                        a.this.gmK.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gmK.getPageContext());
            bVar.abc();
        }
    }

    public void xk(String str) {
        if (this.gnn == null) {
            xl(str);
        }
        this.gnn.abc();
    }

    private void xl(final String str) {
        if (this.gnn == null) {
            this.gnn = new com.baidu.tbadk.core.dialog.b(this.gmK.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gmK.getPageContext().getString(d.j.copy_group_number)};
            this.gnn.lz(this.gmK.getPageContext().getString(d.j.operation));
            this.gnn.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmK.getSystemService("clipboard")).setText(str);
                        a.this.gmK.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gnn.d(this.gmK.getPageContext());
        }
    }

    public void bus() {
        ColorStateList hp = al.hp(d.C0277d.cp_btn_a);
        if (hp != null) {
            this.gnk.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gnk.setTextColor(hp);
    }

    public void changeSkinType(int i) {
        this.gmK.getLayoutMode().setNightMode(i == 1);
        this.gmK.getLayoutMode().onModeChanged(this.cMr);
        this.gmK.getLayoutMode().onModeChanged(this.gne);
        this.gmV.a(i, this.gmK);
        this.mNavigationBar.onChangeSkinType(this.gmK.getPageContext(), i);
        if (this.isMemGroup) {
            al.d(this.gnG, d.C0277d.common_color_10009, 1);
        }
        if (!this.eQx) {
            b(this.gnH, this.gnI);
        }
        if (this.gnJ) {
            al.k(this.gnx, d.f.group_info_item);
        } else {
            al.l(this.gnx, d.C0277d.cp_bg_line_d);
        }
    }

    public void lm(boolean z) {
        this.eQx = z;
    }
}
