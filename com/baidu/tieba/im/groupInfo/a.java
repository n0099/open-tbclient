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
    public static int gny = 0;
    private ScrollView aYH;
    private RelativeLayout cMu;
    private View eKQ;
    private boolean eQk;
    private View gbd;
    private TextView glv;
    private ProgressBar gmA;
    private RelativeLayout gmB;
    private TextView gmC;
    private TextView gmD;
    private TextView gmE;
    private TextView gmF;
    private EllipsizingTextView gmG;
    private TextView gmH;
    private RelativeLayout gmI;
    private PhotoWallView gmJ;
    private RelativeLayout gmK;
    private RelativeLayout gmL;
    private LinearLayout gmM;
    private HeadImageView gmN;
    private TextView gmO;
    private RelativeLayout gmP;
    private com.baidu.tbadk.core.dialog.b gmQ;
    private ImageView gmR;
    private final View gmS;
    private b.InterfaceC0225b gmT;
    private RelativeLayout gmU;
    private LinearLayout gmV;
    private HeadImageView[] gmW;
    private LinearLayout gmX;
    private TextView gmY;
    private RelativeLayout gmZ;
    private final GroupInfoActivity gmy;
    private View gmz;
    private LinearLayout gna;
    private com.baidu.tbadk.core.dialog.b gnb;
    private LinearLayout gnc;
    private g gnd;
    private b gne;
    private TextView gnf;
    private String gng;
    private ImageView gnh;
    private RelativeLayout gni;
    private TextView gnj;
    private ImageView gnk;
    private RelativeLayout gnl;
    private RelativeLayout gnm;
    private ImageView gnn;
    private ImageView gno;
    private View gnp;
    private TextView gnq;
    private TextView gnr;
    private LinearLayout gns;
    private View gnt;
    private TextView gnu;
    private ResponseGroupInfoLocalMessage.a gnv;
    private boolean gnw;
    private boolean gnx;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gmQ = null;
        this.gmT = null;
        this.gmW = new HeadImageView[5];
        this.gng = "";
        this.gnw = true;
        this.isMemGroup = false;
        this.eQk = false;
        this.gnx = false;
        this.gmy = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.gmS = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.aYH.setVisibility(4);
        this.gmX.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gnj.setText(str);
        xf(str);
    }

    private void xf(String str) {
        if (str != null) {
            this.gnu.setText(str);
        }
    }

    public void xg(String str) {
        this.gmG.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.gbd = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gnu = this.mNavigationBar.setTitleText("");
        this.gnt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.gnf = (TextView) this.gnt.findViewById(d.g.right_textview);
        this.gnf.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        al.d(this.gnf, d.C0277d.cp_cont_f, 1);
        this.gnf.setOnClickListener(groupInfoActivity);
        this.gnt.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gmz = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.cMu = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.aYH = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.aYH.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.eKQ = groupInfoActivity.findViewById(d.g.group_top_view);
        this.eKQ.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gmB = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.gmB.setOnClickListener(groupInfoActivity);
        this.gmC = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.gmD = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.gmU = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.gmU.setOnClickListener(groupInfoActivity);
        this.gnc = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.gnh = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.gmE = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.gmF = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.gnn = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.gmG = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.gmG.setMaxLines(20);
        this.gmG.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kd(boolean z) {
                if (z) {
                    a.this.gnq.setVisibility(0);
                } else {
                    a.this.gnq.setVisibility(8);
                }
            }
        });
        this.gmI = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.gmH = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.gmI.setOnClickListener(groupInfoActivity);
        this.gmN = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.gmN.setAutoChangeStyle(true);
        this.gmN.setIsRound(false);
        this.glv = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.gmK = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.gmK.setOnClickListener(groupInfoActivity);
        this.gmR = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.gnp = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.gmM = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.gmI.setOnClickListener(groupInfoActivity);
        this.gmL = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.gmL.setOnClickListener(groupInfoActivity);
        this.gmO = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.gmP = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.gmP.setOnClickListener(groupInfoActivity);
        this.gmV = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.gmX = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.gns = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.gmY = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.gns.setOnClickListener(this.gmy);
        this.gmZ = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.gmZ.setOnClickListener(groupInfoActivity);
        this.gna = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.gni = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.gni.setOnClickListener(groupInfoActivity);
        this.gnj = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.gnk = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.gno = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.gnl = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.gnl.setOnClickListener(groupInfoActivity);
        this.gnl.setLongClickable(true);
        this.gnl.setOnLongClickListener(groupInfoActivity);
        this.gnq = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.gnq.setClickable(true);
        this.gnq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gmG.setMaxLines(1000);
            }
        });
        this.gnm = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.gnm.setOnLongClickListener(groupInfoActivity);
        this.gnr = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.gmA = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gmJ = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.gmJ.setPhotoClickListener(groupInfoActivity);
        this.gmJ.setPhotoLongClickListener(groupInfoActivity);
        this.gmJ.setVisibility(8);
    }

    public RelativeLayout btY() {
        return this.gnm;
    }

    public RelativeLayout btZ() {
        return this.gmI;
    }

    public LinearLayout bua() {
        return this.gmV;
    }

    public RelativeLayout bub() {
        return this.gmZ;
    }

    public RelativeLayout buc() {
        return this.gnl;
    }

    public RelativeLayout bud() {
        return this.gni;
    }

    public RelativeLayout bue() {
        return this.gmB;
    }

    public View buf() {
        return this.gnf;
    }

    public LinearLayout bug() {
        return this.gns;
    }

    public RelativeLayout buh() {
        return this.gmK;
    }

    public RelativeLayout bui() {
        return this.gmL;
    }

    public RelativeLayout buj() {
        return this.gmP;
    }

    public View bsT() {
        return this.gbd;
    }

    public void buk() {
        this.gmA.setVisibility(8);
    }

    public void bul() {
        this.gmA.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gmF.setText(str);
            this.gmU.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gmU.setVisibility(8);
        } else {
            this.gmF.setText(str);
            this.gmU.setVisibility(0);
        }
    }

    public void lk(boolean z) {
        if (z) {
            this.gmF.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.gmU.setVisibility(8);
        }
    }

    public RelativeLayout bum() {
        return this.gmU;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eQk = aVar.buW();
            this.gnx = aVar.buX();
            this.gnv = aVar;
            this.gnw = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.buR() != null) {
                gny = aVar.buR().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gnc.setVisibility(0);
            this.gmX.setVisibility(0);
            if (aVar.getGroup() != null) {
                xf(aVar.getGroup().getName());
                this.gmE.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gmR.setVisibility(0);
                } else {
                    this.gmR.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gnh.setVisibility(0);
                    this.gmN.setVisibility(8);
                    this.gno.setVisibility(8);
                    this.gnp.setVisibility(8);
                    this.glv.setText(d.j.group_info_forum_author);
                    this.gmK.setEnabled(false);
                    this.gmR.setVisibility(8);
                } else {
                    this.gnh.setVisibility(8);
                    this.gmN.setVisibility(0);
                    this.gno.setVisibility(0);
                    this.gnp.setVisibility(0);
                    this.glv.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gmK.setEnabled(true);
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
                this.gng = stringBuffer.toString();
                this.gmF.setText(this.gng);
                this.gmG.setText(aVar.getGroup().getIntro());
                this.gmO.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gmN.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gmI.setVisibility(0);
                    this.gmH.setText(aVar.getGroup().getForumName() + this.gmy.getPageContext().getString(d.j.forum));
                } else {
                    this.gmI.setVisibility(8);
                }
                this.gmM.removeAllViews();
                boolean buY = aVar.buY();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.d(this.gnu, d.C0277d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gmy.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.gmM.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gmy.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.gmM.addView(imageView2);
                }
                if (buY) {
                    this.gnr.setVisibility(0);
                } else {
                    this.gnr.setVisibility(8);
                }
            }
            if (aVar.buR() != null) {
                this.gmB.setVisibility(0);
                this.gmz.setVisibility(0);
                GroupActivityData buR = aVar.buR();
                if (!aVar.buW()) {
                    if (buR.getIsEnd() != 1) {
                        this.gmC.setVisibility(4);
                        this.gmD.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.gmB.setVisibility(8);
                        this.gmz.setVisibility(8);
                    }
                } else {
                    this.gmC.setVisibility(0);
                    this.gmD.setText(buR.getgActivityTitle());
                    if (buR.getIsEnd() != 1) {
                        this.gmC.setText(d.j.group_info_activity_doing);
                        al.d(this.gmC, d.C0277d.common_color_10171, 1);
                    } else {
                        this.gmC.setText(d.j.group_activity_end);
                        al.d(this.gmC, d.C0277d.common_color_10168, 1);
                    }
                    this.gmD.setText(buR.getgActivityTitle());
                }
            } else if (aVar.buX()) {
                this.gmB.setVisibility(0);
                this.gmz.setVisibility(0);
                this.gmC.setVisibility(4);
                this.gmD.setText(d.j.group_info_create_activity);
            } else {
                this.gmB.setVisibility(8);
                this.gmz.setVisibility(8);
            }
            this.gmV.removeAllViews();
            if (aVar.buS() != null && aVar.buS().size() > 0) {
                List<MemberData> buS = aVar.buS();
                int size = buS.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = buS.get(i3);
                    HeadImageView headImageView = this.gmW[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gmy.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gmW[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.gmV.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.buX()) {
                this.gmU.setEnabled(true);
                this.gnl.setEnabled(true);
                al.k(this.gnl, d.f.group_info_item);
                this.gni.setVisibility(0);
                this.gnn.setVisibility(0);
                this.gnk.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gnj.setText(aVar.getGroup().getName());
                }
            } else {
                this.gmU.setEnabled(false);
                this.gnl.setEnabled(true);
                al.l(this.gnl, d.C0277d.cp_bg_line_d);
                this.gnk.setVisibility(8);
                this.gnn.setVisibility(8);
                this.gmG.setPadding(0, 0, 0, 0);
            }
            if (aVar.buW()) {
                this.gna.setVisibility(0);
                this.gnt.setVisibility(0);
                if (this.gmP.getParent() != this.gna) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.gnc.removeView(this.gmP);
                    this.gna.addView(this.gmP, 1);
                }
                bun();
            } else {
                this.gna.setVisibility(8);
                this.gnt.setVisibility(8);
                if (this.gmP.getParent() != this.gnc) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.gna.removeView(this.gmP);
                    this.gnc.addView(this.gmP, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gmL.setVisibility(8);
            } else {
                this.gmL.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                lk(aVar.buX());
            } else {
                m(aVar.buX(), this.gng);
            }
            this.aYH.setVisibility(0);
            this.gmX.setVisibility(0);
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
        this.gmY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.d(this.gmY, d.C0277d.cp_btn_a, 1);
        this.gmY.setText(this.gmy.getPageContext().getString(d.j.i_want_talk));
        this.gns.setEnabled(true);
    }

    private void ll(boolean z) {
        this.gmY.setText(this.gmy.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.gmY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gmY, d.C0277d.cp_btn_a, 1);
        } else {
            this.gmY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.d(this.gmY, d.C0277d.cp_btn_a, 1);
        }
        al.k(this.gns, d.f.btn_blue_bg);
        this.gns.setEnabled(true);
    }

    private boolean tW(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void buo() {
        this.gmY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gmY.setText(this.gmy.getPageContext().getString(d.j.group_info_refuse_join));
        this.gmY.setTextColor(this.gmy.getResources().getColorStateList(d.C0277d.cp_btn_a));
        al.k(this.gns, d.f.btn_app_download_d);
        this.gns.setEnabled(false);
    }

    public void xh(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gmV.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gmV.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gmV.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gmJ.setIsManager(aVar.buX());
            if (aVar.buX()) {
                this.gmJ.setVisibility(0);
                if (aVar.buT() != null && aVar.buT().size() == 1 && TextUtils.isEmpty(aVar.buT().get(0).getPicId())) {
                    this.gmJ.setData(null);
                } else {
                    this.gmJ.setData(aVar.buT());
                }
            } else if (aVar.buT() != null && aVar.buT().size() > 0) {
                if (aVar.buT().size() == 1 && TextUtils.isEmpty(aVar.buT().get(0).getPicId())) {
                    this.gmJ.setVisibility(8);
                    return;
                }
                this.gmJ.setVisibility(0);
                this.gmJ.setData(aVar.buT());
            } else {
                this.gmJ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gne = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gnd != null) {
            this.gnd.dismiss();
            this.gnd = null;
        }
        e(obj, i);
        this.gnd.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gnd == null) {
            this.gnd = new g(this.gmy.getPageContext());
            this.gnd.a(null, new String[]{this.gmy.getResources().getString(d.j.group_info_set_portrait), this.gmy.getResources().getString(d.j.delete)}, new i.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.i.c
                public void a(i iVar, int i2, View view) {
                    if (a.this.gnd != null && a.this.gnd.isShowing()) {
                        a.this.gne.a(a.this.gnd, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gmJ != null) {
            this.gmJ.onDestory();
        }
        if (this.gmN != null) {
            this.gmN.stopLoad();
            this.gmN.setBackgroundDrawable(null);
            this.gmN.setImageDrawable(null);
        }
        if (this.gmV != null && this.gmW != null) {
            int length = this.gmW.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gmW[i];
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
            CharSequence[] charSequenceArr = {this.gmy.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gmy.getPageContext().getPageActivity());
            bVar.lA(this.gmy.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmy.getSystemService("clipboard")).setText(str);
                        a.this.gmy.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gmy.getPageContext());
            bVar.aaZ();
        }
    }

    public void xj(String str) {
        if (this.gnb == null) {
            xk(str);
        }
        this.gnb.aaZ();
    }

    private void xk(final String str) {
        if (this.gnb == null) {
            this.gnb = new com.baidu.tbadk.core.dialog.b(this.gmy.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gmy.getPageContext().getString(d.j.copy_group_number)};
            this.gnb.lA(this.gmy.getPageContext().getString(d.j.operation));
            this.gnb.a(charSequenceArr, new b.InterfaceC0225b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0225b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gmy.getSystemService("clipboard")).setText(str);
                        a.this.gmy.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gnb.d(this.gmy.getPageContext());
        }
    }

    public void bup() {
        ColorStateList ho = al.ho(d.C0277d.cp_btn_a);
        if (ho != null) {
            this.gmY.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gmY.setTextColor(ho);
    }

    public void changeSkinType(int i) {
        this.gmy.getLayoutMode().setNightMode(i == 1);
        this.gmy.getLayoutMode().onModeChanged(this.cMu);
        this.gmy.getLayoutMode().onModeChanged(this.gmS);
        this.gmJ.a(i, this.gmy);
        this.mNavigationBar.onChangeSkinType(this.gmy.getPageContext(), i);
        if (this.isMemGroup) {
            al.d(this.gnu, d.C0277d.common_color_10009, 1);
        }
        if (!this.eQk) {
            b(this.gnv, this.gnw);
        }
        if (this.gnx) {
            al.k(this.gnl, d.f.group_info_item);
        } else {
            al.l(this.gnl, d.C0277d.cp_bg_line_d);
        }
    }

    public void lm(boolean z) {
        this.eQk = z;
    }
}
