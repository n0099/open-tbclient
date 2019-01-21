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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private RelativeLayout bBn;
    private ScrollView bIl;
    private boolean dDj;
    private View dxN;
    private View eLo;
    private TextView eVA;
    private final GroupInfoActivity eWE;
    private View eWF;
    private ProgressBar eWG;
    private RelativeLayout eWH;
    private TextView eWI;
    private TextView eWJ;
    private TextView eWK;
    private TextView eWL;
    private EllipsizingTextView eWM;
    private TextView eWN;
    private RelativeLayout eWO;
    private PhotoWallView eWP;
    private RelativeLayout eWQ;
    private RelativeLayout eWR;
    private LinearLayout eWS;
    private HeadImageView eWT;
    private TextView eWU;
    private RelativeLayout eWV;
    private com.baidu.tbadk.core.dialog.b eWW;
    private ImageView eWX;
    private final View eWY;
    private b.InterfaceC0158b eWZ;
    private TextView eXA;
    private ResponseGroupInfoLocalMessage.a eXB;
    private boolean eXC;
    private boolean eXD;
    private RelativeLayout eXa;
    private LinearLayout eXb;
    private HeadImageView[] eXc;
    private LinearLayout eXd;
    private TextView eXe;
    private RelativeLayout eXf;
    private LinearLayout eXg;
    private com.baidu.tbadk.core.dialog.b eXh;
    private LinearLayout eXi;
    private com.baidu.tbadk.core.dialog.b eXj;
    private b eXk;
    private TextView eXl;
    private String eXm;
    private ImageView eXn;
    private RelativeLayout eXo;
    private TextView eXp;
    private ImageView eXq;
    private RelativeLayout eXr;
    private RelativeLayout eXs;
    private ImageView eXt;
    private ImageView eXu;
    private View eXv;
    private TextView eXw;
    private TextView eXx;
    private LinearLayout eXy;
    private View eXz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eXE = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eWW = null;
        this.eWZ = null;
        this.eXc = new HeadImageView[5];
        this.eXm = "";
        this.eXC = true;
        this.isMemGroup = false;
        this.dDj = false;
        this.eXD = false;
        this.eWE = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eWY = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bIl.setVisibility(4);
        this.eXd.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eXp.setText(str);
        qC(str);
    }

    private void qC(String str) {
        if (str != null) {
            this.eXA.setText(str);
        }
    }

    public void qD(String str) {
        this.eWM.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.eLo = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXA = this.mNavigationBar.setTitleText("");
        this.eXz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eXl = (TextView) this.eXz.findViewById(e.g.right_textview);
        this.eXl.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eXl, e.d.cp_cont_f, 1);
        this.eXl.setOnClickListener(groupInfoActivity);
        this.eXz.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eWF = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bBn = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bIl = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bIl.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.dxN = groupInfoActivity.findViewById(e.g.group_top_view);
        this.dxN.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eWH = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eWH.setOnClickListener(groupInfoActivity);
        this.eWI = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eWJ = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eXa = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eXa.setOnClickListener(groupInfoActivity);
        this.eXi = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eXn = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eWK = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eWL = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eXt = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eWM = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eWM.setMaxLines(20);
        this.eWM.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hJ(boolean z) {
                if (z) {
                    a.this.eXw.setVisibility(0);
                } else {
                    a.this.eXw.setVisibility(8);
                }
            }
        });
        this.eWO = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eWN = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eWO.setOnClickListener(groupInfoActivity);
        this.eWT = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eWT.setAutoChangeStyle(true);
        this.eWT.setIsRound(false);
        this.eVA = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eWQ = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eWQ.setOnClickListener(groupInfoActivity);
        this.eWX = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eXv = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eWS = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eWO.setOnClickListener(groupInfoActivity);
        this.eWR = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eWR.setOnClickListener(groupInfoActivity);
        this.eWU = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eWV = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eWV.setOnClickListener(groupInfoActivity);
        this.eXb = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eXd = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eXy = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eXe = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eXy.setOnClickListener(this.eWE);
        this.eXf = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eXf.setOnClickListener(groupInfoActivity);
        this.eXg = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eXo = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eXo.setOnClickListener(groupInfoActivity);
        this.eXp = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eXq = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eXu = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eXr = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eXr.setOnClickListener(groupInfoActivity);
        this.eXr.setLongClickable(true);
        this.eXr.setOnLongClickListener(groupInfoActivity);
        this.eXw = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eXw.setClickable(true);
        this.eXw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eWM.setMaxLines(1000);
            }
        });
        this.eXs = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eXs.setOnLongClickListener(groupInfoActivity);
        this.eXx = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eWG = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eWP = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eWP.setPhotoClickListener(groupInfoActivity);
        this.eWP.setPhotoLongClickListener(groupInfoActivity);
        this.eWP.setVisibility(8);
    }

    public RelativeLayout aTw() {
        return this.eXs;
    }

    public RelativeLayout aTx() {
        return this.eWO;
    }

    public LinearLayout aTy() {
        return this.eXb;
    }

    public RelativeLayout aTz() {
        return this.eXf;
    }

    public RelativeLayout aTA() {
        return this.eXr;
    }

    public RelativeLayout aTB() {
        return this.eXo;
    }

    public RelativeLayout aTC() {
        return this.eWH;
    }

    public View aTD() {
        return this.eXl;
    }

    public LinearLayout aTE() {
        return this.eXy;
    }

    public RelativeLayout aTF() {
        return this.eWQ;
    }

    public RelativeLayout aTG() {
        return this.eWR;
    }

    public RelativeLayout aTH() {
        return this.eWV;
    }

    public View aSr() {
        return this.eLo;
    }

    public void aTI() {
        this.eWG.setVisibility(8);
    }

    public void aTJ() {
        this.eWG.setVisibility(0);
    }

    public void h(boolean z, String str) {
        if (z) {
            this.eWL.setText(str);
            this.eXa.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eXa.setVisibility(8);
        } else {
            this.eWL.setText(str);
            this.eXa.setVisibility(0);
        }
    }

    public void iK(boolean z) {
        if (z) {
            this.eWL.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eXa.setVisibility(8);
        }
    }

    public RelativeLayout aTK() {
        return this.eXa;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dDj = aVar.aUu();
            this.eXD = aVar.aUv();
            this.eXB = aVar;
            this.eXC = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aUp() != null) {
                eXE = aVar.aUp().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eXi.setVisibility(0);
            this.eXd.setVisibility(0);
            if (aVar.getGroup() != null) {
                qC(aVar.getGroup().getName());
                this.eWK.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eWX.setVisibility(0);
                } else {
                    this.eWX.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eXn.setVisibility(0);
                    this.eWT.setVisibility(8);
                    this.eXu.setVisibility(8);
                    this.eXv.setVisibility(8);
                    this.eVA.setText(e.j.group_info_forum_author);
                    this.eWQ.setEnabled(false);
                    this.eWX.setVisibility(8);
                } else {
                    this.eXn.setVisibility(8);
                    this.eWT.setVisibility(0);
                    this.eXu.setVisibility(0);
                    this.eXv.setVisibility(0);
                    this.eVA.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eWQ.setEnabled(true);
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
                this.eXm = stringBuffer.toString();
                this.eWL.setText(this.eXm);
                this.eWM.setText(aVar.getGroup().getIntro());
                this.eWU.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eWT.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eWO.setVisibility(0);
                    this.eWN.setText(aVar.getGroup().getForumName() + this.eWE.getPageContext().getString(e.j.forum));
                } else {
                    this.eWO.setVisibility(8);
                }
                this.eWS.removeAllViews();
                boolean aUw = aVar.aUw();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eXA, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eWE.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eWS.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eWE.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eWS.addView(imageView2);
                }
                if (aUw) {
                    this.eXx.setVisibility(0);
                } else {
                    this.eXx.setVisibility(8);
                }
            }
            if (aVar.aUp() != null) {
                this.eWH.setVisibility(0);
                this.eWF.setVisibility(0);
                GroupActivityData aUp = aVar.aUp();
                if (!aVar.aUu()) {
                    if (aUp.getIsEnd() != 1) {
                        this.eWI.setVisibility(4);
                        this.eWJ.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eWH.setVisibility(8);
                        this.eWF.setVisibility(8);
                    }
                } else {
                    this.eWI.setVisibility(0);
                    this.eWJ.setText(aUp.getgActivityTitle());
                    if (aUp.getIsEnd() != 1) {
                        this.eWI.setText(e.j.group_info_activity_doing);
                        al.c(this.eWI, e.d.common_color_10171, 1);
                    } else {
                        this.eWI.setText(e.j.group_activity_end);
                        al.c(this.eWI, e.d.common_color_10168, 1);
                    }
                    this.eWJ.setText(aUp.getgActivityTitle());
                }
            } else if (aVar.aUv()) {
                this.eWH.setVisibility(0);
                this.eWF.setVisibility(0);
                this.eWI.setVisibility(4);
                this.eWJ.setText(e.j.group_info_create_activity);
            } else {
                this.eWH.setVisibility(8);
                this.eWF.setVisibility(8);
            }
            this.eXb.removeAllViews();
            if (aVar.aUq() != null && aVar.aUq().size() > 0) {
                List<MemberData> aUq = aVar.aUq();
                int size = aUq.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aUq.get(i3);
                    HeadImageView headImageView = this.eXc[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eWE.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eXc[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                    this.eXb.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aUv()) {
                this.eXa.setEnabled(true);
                this.eXr.setEnabled(true);
                al.i(this.eXr, e.f.group_info_item);
                this.eXo.setVisibility(0);
                this.eXt.setVisibility(0);
                this.eXq.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eXp.setText(aVar.getGroup().getName());
                }
            } else {
                this.eXa.setEnabled(false);
                this.eXr.setEnabled(true);
                al.j(this.eXr, e.d.cp_bg_line_d);
                this.eXq.setVisibility(8);
                this.eXt.setVisibility(8);
                this.eWM.setPadding(0, 0, 0, 0);
            }
            if (aVar.aUu()) {
                this.eXg.setVisibility(0);
                this.eXz.setVisibility(0);
                if (this.eWV.getParent() != this.eXg) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds18);
                    this.eXi.removeView(this.eWV);
                    this.eXg.addView(this.eWV, 1);
                }
                aTL();
            } else {
                this.eXg.setVisibility(8);
                this.eXz.setVisibility(8);
                if (this.eWV.getParent() != this.eXi) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28);
                    this.eXg.removeView(this.eWV);
                    this.eXi.addView(this.eWV, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eWR.setVisibility(8);
            } else {
                this.eWR.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iK(aVar.aUv());
            } else {
                h(aVar.aUv(), this.eXm);
            }
            this.bIl.setVisibility(0);
            this.eXd.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qq(aVar.getGroup().getFlag())) {
                iL(z);
            } else {
                aTM();
            }
        }
    }

    public void aTL() {
        this.eXe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eXe, e.d.cp_cont_i, 1);
        this.eXe.setText(this.eWE.getPageContext().getString(e.j.i_want_talk));
        this.eXy.setEnabled(true);
    }

    private void iL(boolean z) {
        this.eXe.setText(this.eWE.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eXe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eXe, e.d.cp_cont_i, 1);
        } else {
            this.eXe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eXe, e.d.cp_cont_i, 1);
        }
        al.i(this.eXy, e.f.btn_blue_bg);
        this.eXy.setEnabled(true);
    }

    private boolean qq(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aTM() {
        this.eXe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eXe.setText(this.eWE.getPageContext().getString(e.j.group_info_refuse_join));
        this.eXe.setTextColor(this.eWE.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eXy, e.f.btn_app_download_d);
        this.eXy.setEnabled(false);
    }

    public void qE(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eXb.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eXb.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eXb.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eWP.setIsManager(aVar.aUv());
            if (aVar.aUv()) {
                this.eWP.setVisibility(0);
                if (aVar.aUr() != null && aVar.aUr().size() == 1 && TextUtils.isEmpty(aVar.aUr().get(0).getPicId())) {
                    this.eWP.setData(null);
                } else {
                    this.eWP.setData(aVar.aUr());
                }
            } else if (aVar.aUr() != null && aVar.aUr().size() > 0) {
                if (aVar.aUr().size() == 1 && TextUtils.isEmpty(aVar.aUr().get(0).getPicId())) {
                    this.eWP.setVisibility(8);
                    return;
                }
                this.eWP.setVisibility(0);
                this.eWP.setData(aVar.aUr());
            } else {
                this.eWP.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eXk = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eXj != null) {
            this.eXj.dismiss();
            this.eXj = null;
        }
        e(obj, i);
        this.eXj.BV();
    }

    public void aTN() {
        this.eXj.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eXj == null) {
            this.eXj = new com.baidu.tbadk.core.dialog.b(this.eWE.getPageContext().getPageActivity());
            this.eXj.eL(this.eWE.getResources().getString(e.j.operation));
            this.eXj.a(new String[]{this.eWE.getResources().getString(e.j.group_info_set_portrait), this.eWE.getResources().getString(e.j.delete), this.eWE.getResources().getString(e.j.cancel)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eXk.a(bVar, i2, obj, i);
                }
            });
        }
        this.eXj.d(this.eWE.getPageContext());
    }

    public void onDestory() {
        if (this.eWP != null) {
            this.eWP.onDestory();
        }
        if (this.eWT != null) {
            this.eWT.stopLoad();
            this.eWT.setBackgroundDrawable(null);
            this.eWT.setImageDrawable(null);
        }
        if (this.eXb != null && this.eXc != null) {
            int length = this.eXc.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eXc[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void qF(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eWE.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eWE.getPageContext().getPageActivity());
            bVar.eL(this.eWE.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eWE.getSystemService("clipboard")).setText(str);
                        a.this.eWE.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eWE.getPageContext());
            bVar.BV();
        }
    }

    public void qG(String str) {
        if (this.eXh == null) {
            qH(str);
        }
        this.eXh.BV();
    }

    private void qH(final String str) {
        if (this.eXh == null) {
            this.eXh = new com.baidu.tbadk.core.dialog.b(this.eWE.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eWE.getPageContext().getString(e.j.copy_group_number)};
            this.eXh.eL(this.eWE.getPageContext().getString(e.j.operation));
            this.eXh.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eWE.getSystemService("clipboard")).setText(str);
                        a.this.eWE.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eXh.d(this.eWE.getPageContext());
        }
    }

    public void aTO() {
        ColorStateList dN = al.dN(e.d.cp_cont_i);
        if (dN != null) {
            this.eXe.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eXe.setTextColor(dN);
    }

    public void changeSkinType(int i) {
        this.eWE.getLayoutMode().setNightMode(i == 1);
        this.eWE.getLayoutMode().onModeChanged(this.bBn);
        this.eWE.getLayoutMode().onModeChanged(this.eWY);
        this.eWP.a(i, this.eWE);
        this.mNavigationBar.onChangeSkinType(this.eWE.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eXA, e.d.common_color_10009, 1);
        }
        if (!this.dDj) {
            b(this.eXB, this.eXC);
        }
        if (this.eXD) {
            al.i(this.eXr, e.f.group_info_item);
        } else {
            al.j(this.eXr, e.d.cp_bg_line_d);
        }
    }

    public void iM(boolean z) {
        this.dDj = z;
    }
}
