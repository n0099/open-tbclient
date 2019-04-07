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
    public static int gnx = 0;
    private ScrollView aYG;
    private RelativeLayout cMt;
    private View eKP;
    private boolean eQj;
    private View gbd;
    private TextView glu;
    private RelativeLayout gmA;
    private TextView gmB;
    private TextView gmC;
    private TextView gmD;
    private TextView gmE;
    private EllipsizingTextView gmF;
    private TextView gmG;
    private RelativeLayout gmH;
    private PhotoWallView gmI;
    private RelativeLayout gmJ;
    private RelativeLayout gmK;
    private LinearLayout gmL;
    private HeadImageView gmM;
    private TextView gmN;
    private RelativeLayout gmO;
    private com.baidu.tbadk.core.dialog.b gmP;
    private ImageView gmQ;
    private final View gmR;
    private b.InterfaceC0225b gmS;
    private RelativeLayout gmT;
    private LinearLayout gmU;
    private HeadImageView[] gmV;
    private LinearLayout gmW;
    private TextView gmX;
    private RelativeLayout gmY;
    private LinearLayout gmZ;
    private final GroupInfoActivity gmx;
    private View gmy;
    private ProgressBar gmz;
    private com.baidu.tbadk.core.dialog.b gna;
    private LinearLayout gnb;
    private g gnc;
    private b gnd;
    private TextView gne;
    private String gnf;
    private ImageView gng;
    private RelativeLayout gnh;
    private TextView gni;
    private ImageView gnj;
    private RelativeLayout gnk;
    private RelativeLayout gnl;
    private ImageView gnm;
    private ImageView gnn;
    private View gno;
    private TextView gnp;
    private TextView gnq;
    private LinearLayout gnr;
    private View gns;
    private TextView gnt;
    private ResponseGroupInfoLocalMessage.a gnu;
    private boolean gnv;
    private boolean gnw;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gmP = null;
        this.gmS = null;
        this.gmV = new HeadImageView[5];
        this.gnf = "";
        this.gnv = true;
        this.isMemGroup = false;
        this.eQj = false;
        this.gnw = false;
        this.gmx = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.gmR = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.aYG.setVisibility(4);
        this.gmW.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gni.setText(str);
        xf(str);
    }

    private void xf(String str) {
        if (str != null) {
            this.gnt.setText(str);
        }
    }

    public void xg(String str) {
        this.gmF.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gnt = this.mNavigationBar.setTitleText("");
        this.gns = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gne = (TextView) this.gns.findViewById(d.g.right_textview);
        this.gne.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        al.d(this.gne, d.C0277d.cp_cont_f, 1);
        this.gne.setOnClickListener(groupInfoActivity);
        this.gns.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gmy = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.cMt = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.aYG = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.aYG.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.eKP = groupInfoActivity.findViewById(d.g.group_top_view);
        this.eKP.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gmA = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.gmA.setOnClickListener(groupInfoActivity);
        this.gmB = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.gmC = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.gmT = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.gmT.setOnClickListener(groupInfoActivity);
        this.gnb = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.gng = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.gmD = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.gmE = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.gnm = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.gmF = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.gmF.setMaxLines(20);
        this.gmF.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kd(boolean z) {
                if (z) {
                    a.this.gnp.setVisibility(0);
                } else {
                    a.this.gnp.setVisibility(8);
                }
            }
        });
        this.gmH = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.gmG = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.gmH.setOnClickListener(groupInfoActivity);
        this.gmM = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.gmM.setAutoChangeStyle(true);
        this.gmM.setIsRound(false);
        this.glu = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.gmJ = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.gmJ.setOnClickListener(groupInfoActivity);
        this.gmQ = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.gno = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.gmL = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.gmH.setOnClickListener(groupInfoActivity);
        this.gmK = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.gmK.setOnClickListener(groupInfoActivity);
        this.gmN = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.gmO = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.gmO.setOnClickListener(groupInfoActivity);
        this.gmU = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.gmW = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.gnr = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.gmX = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.gnr.setOnClickListener(this.gmx);
        this.gmY = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.gmY.setOnClickListener(groupInfoActivity);
        this.gmZ = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.gnh = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.gnh.setOnClickListener(groupInfoActivity);
        this.gni = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.gnj = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.gnn = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.gnk = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.gnk.setOnClickListener(groupInfoActivity);
        this.gnk.setLongClickable(true);
        this.gnk.setOnLongClickListener(groupInfoActivity);
        this.gnp = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.gnp.setClickable(true);
        this.gnp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gmF.setMaxLines(1000);
            }
        });
        this.gnl = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.gnl.setOnLongClickListener(groupInfoActivity);
        this.gnq = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.gmz = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gmI = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.gmI.setPhotoClickListener(groupInfoActivity);
        this.gmI.setPhotoLongClickListener(groupInfoActivity);
        this.gmI.setVisibility(8);
    }

    public RelativeLayout btY() {
        return this.gnl;
    }

    public RelativeLayout btZ() {
        return this.gmH;
    }

    public LinearLayout bua() {
        return this.gmU;
    }

    public RelativeLayout bub() {
        return this.gmY;
    }

    public RelativeLayout buc() {
        return this.gnk;
    }

    public RelativeLayout bud() {
        return this.gnh;
    }

    public RelativeLayout bue() {
        return this.gmA;
    }

    public View buf() {
        return this.gne;
    }

    public LinearLayout bug() {
        return this.gnr;
    }

    public RelativeLayout buh() {
        return this.gmJ;
    }

    public RelativeLayout bui() {
        return this.gmK;
    }

    public RelativeLayout buj() {
        return this.gmO;
    }

    public View bsT() {
        return this.gbd;
    }

    public void buk() {
        this.gmz.setVisibility(8);
    }

    public void bul() {
        this.gmz.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gmE.setText(str);
            this.gmT.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gmT.setVisibility(8);
        } else {
            this.gmE.setText(str);
            this.gmT.setVisibility(0);
        }
    }

    public void lk(boolean z) {
        if (z) {
            this.gmE.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.gmT.setVisibility(8);
        }
    }

    public RelativeLayout bum() {
        return this.gmT;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eQj = aVar.buW();
            this.gnw = aVar.buX();
            this.gnu = aVar;
            this.gnv = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.buR() != null) {
                gnx = aVar.buR().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gnb.setVisibility(0);
            this.gmW.setVisibility(0);
            if (aVar.getGroup() != null) {
                xf(aVar.getGroup().getName());
                this.gmD.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gmQ.setVisibility(0);
                } else {
                    this.gmQ.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gng.setVisibility(0);
                    this.gmM.setVisibility(8);
                    this.gnn.setVisibility(8);
                    this.gno.setVisibility(8);
                    this.glu.setText(d.j.group_info_forum_author);
                    this.gmJ.setEnabled(false);
                    this.gmQ.setVisibility(8);
                } else {
                    this.gng.setVisibility(8);
                    this.gmM.setVisibility(0);
                    this.gnn.setVisibility(0);
                    this.gno.setVisibility(0);
                    this.glu.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gmJ.setEnabled(true);
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
                this.gnf = stringBuffer.toString();
                this.gmE.setText(this.gnf);
                this.gmF.setText(aVar.getGroup().getIntro());
                this.gmN.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gmM.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gmH.setVisibility(0);
                    this.gmG.setText(aVar.getGroup().getForumName() + this.gmx.getPageContext().getString(d.j.forum));
                } else {
                    this.gmH.setVisibility(8);
                }
                this.gmL.removeAllViews();
                boolean buY = aVar.buY();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.d(this.gnt, d.C0277d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gmx.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.gmL.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gmx.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.gmL.addView(imageView2);
                }
                if (buY) {
                    this.gnq.setVisibility(0);
                } else {
                    this.gnq.setVisibility(8);
                }
            }
            if (aVar.buR() != null) {
                this.gmA.setVisibility(0);
                this.gmy.setVisibility(0);
                GroupActivityData buR = aVar.buR();
                if (!aVar.buW()) {
                    if (buR.getIsEnd() != 1) {
                        this.gmB.setVisibility(4);
                        this.gmC.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.gmA.setVisibility(8);
                        this.gmy.setVisibility(8);
                    }
                } else {
                    this.gmB.setVisibility(0);
                    this.gmC.setText(buR.getgActivityTitle());
                    if (buR.getIsEnd() != 1) {
                        this.gmB.setText(d.j.group_info_activity_doing);
                        al.d(this.gmB, d.C0277d.common_color_10171, 1);
                    } else {
                        this.gmB.setText(d.j.group_activity_end);
                        al.d(this.gmB, d.C0277d.common_color_10168, 1);
                    }
                    this.gmC.setText(buR.getgActivityTitle());
                }
            } else if (aVar.buX()) {
                this.gmA.setVisibility(0);
                this.gmy.setVisibility(0);
                this.gmB.setVisibility(4);
                this.gmC.setText(d.j.group_info_create_activity);
            } else {
                this.gmA.setVisibility(8);
                this.gmy.setVisibility(8);
            }
            this.gmU.removeAllViews();
            if (aVar.buS() != null && aVar.buS().size() > 0) {
                List<MemberData> buS = aVar.buS();
                int size = buS.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = buS.get(i3);
                    HeadImageView headImageView = this.gmV[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gmx.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gmV[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.gmU.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.buX()) {
                this.gmT.setEnabled(true);
                this.gnk.setEnabled(true);
                al.k(this.gnk, d.f.group_info_item);
                this.gnh.setVisibility(0);
                this.gnm.setVisibility(0);
                this.gnj.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gni.setText(aVar.getGroup().getName());
                }
            } else {
                this.gmT.setEnabled(false);
                this.gnk.setEnabled(true);
                al.l(this.gnk, d.C0277d.cp_bg_line_d);
                this.gnj.setVisibility(8);
                this.gnm.setVisibility(8);
                this.gmF.setPadding(0, 0, 0, 0);
            }
            if (aVar.buW()) {
                this.gmZ.setVisibility(0);
                this.gns.setVisibility(0);
                if (this.gmO.getParent() != this.gmZ) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.gnb.removeView(this.gmO);
                    this.gmZ.addView(this.gmO, 1);
                }
                bun();
            } else {
                this.gmZ.setVisibility(8);
                this.gns.setVisibility(8);
                if (this.gmO.getParent() != this.gnb) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.gmZ.removeView(this.gmO);
                    this.gnb.addView(this.gmO, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gmK.setVisibility(8);
            } else {
                this.gmK.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                lk(aVar.buX());
            } else {
                m(aVar.buX(), this.gnf);
            }
            this.aYG.setVisibility(0);
            this.gmW.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (tW(aVar.getGroup().getFlag())) {
                ll(z);
            } else {
                buo();
            }
        }
    }

    public void bun() {
        this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.gmX, d.C0277d.cp_btn_a, 1);
        this.gmX.setText(this.gmx.getPageContext().getString(d.j.i_want_talk));
        this.gnr.setEnabled(true);
    }

    private void ll(boolean z) {
        this.gmX.setText(this.gmx.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gmX, d.C0277d.cp_btn_a, 1);
        } else {
            this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gmX, d.C0277d.cp_btn_a, 1);
        }
        al.k(this.gnr, d.f.btn_blue_bg);
        this.gnr.setEnabled(true);
    }

    private boolean tW(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void buo() {
        this.gmX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gmX.setText(this.gmx.getPageContext().getString(d.j.group_info_refuse_join));
        this.gmX.setTextColor(this.gmx.getResources().getColorStateList(d.C0277d.cp_btn_a));
        al.k(this.gnr, d.f.btn_app_download_d);
        this.gnr.setEnabled(false);
    }

    public void xh(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gmU.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gmU.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gmU.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gmI.setIsManager(aVar.buX());
            if (aVar.buX()) {
                this.gmI.setVisibility(0);
                if (aVar.buT() != null && aVar.buT().size() == 1 && TextUtils.isEmpty(aVar.buT().get(0).getPicId())) {
                    this.gmI.setData(null);
                } else {
                    this.gmI.setData(aVar.buT());
                }
            } else if (aVar.buT() != null && aVar.buT().size() > 0) {
                if (aVar.buT().size() == 1 && TextUtils.isEmpty(aVar.buT().get(0).getPicId())) {
                    this.gmI.setVisibility(8);
                    return;
                }
                this.gmI.setVisibility(0);
                this.gmI.setData(aVar.buT());
            } else {
                this.gmI.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gnd = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gnc != null) {
            this.gnc.dismiss();
            this.gnc = null;
        }
        e(obj, i);
        this.gnc.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gnc == null) {
            this.gnc = new g(this.gmx.getPageContext());
            this.gnc.a(null, new String[]{this.gmx.getResources().getString(d.j.group_info_set_portrait), this.gmx.getResources().getString(d.j.delete)}, new i.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i2, View view) {
                    if (a.this.gnc != null && a.this.gnc.isShowing()) {
                        a.this.gnd.a(a.this.gnc, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gmI != null) {
            this.gmI.onDestory();
        }
        if (this.gmM != null) {
            this.gmM.stopLoad();
            this.gmM.setBackgroundDrawable(null);
            this.gmM.setImageDrawable(null);
        }
        if (this.gmU != null && this.gmV != null) {
            int length = this.gmV.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gmV[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void xi(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gmx.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gmx.getPageContext().getPageActivity());
            bVar.lA(this.gmx.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmx.getSystemService("clipboard")).setText(str);
                        a.this.gmx.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gmx.getPageContext());
            bVar.aaZ();
        }
    }

    public void xj(String str) {
        if (this.gna == null) {
            xk(str);
        }
        this.gna.aaZ();
    }

    private void xk(final String str) {
        if (this.gna == null) {
            this.gna = new com.baidu.tbadk.core.dialog.b(this.gmx.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gmx.getPageContext().getString(d.j.copy_group_number)};
            this.gna.lA(this.gmx.getPageContext().getString(d.j.operation));
            this.gna.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmx.getSystemService("clipboard")).setText(str);
                        a.this.gmx.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gna.d(this.gmx.getPageContext());
        }
    }

    public void bup() {
        ColorStateList ho = al.ho(d.C0277d.cp_btn_a);
        if (ho != null) {
            this.gmX.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gmX.setTextColor(ho);
    }

    public void changeSkinType(int i) {
        this.gmx.getLayoutMode().setNightMode(i == 1);
        this.gmx.getLayoutMode().onModeChanged(this.cMt);
        this.gmx.getLayoutMode().onModeChanged(this.gmR);
        this.gmI.a(i, this.gmx);
        this.mNavigationBar.onChangeSkinType(this.gmx.getPageContext(), i);
        if (this.isMemGroup) {
            al.d(this.gnt, d.C0277d.common_color_10009, 1);
        }
        if (!this.eQj) {
            b(this.gnu, this.gnv);
        }
        if (this.gnw) {
            al.k(this.gnk, d.f.group_info_item);
        } else {
            al.l(this.gnk, d.C0277d.cp_bg_line_d);
        }
    }

    public void lm(boolean z) {
        this.eQj = z;
    }
}
