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
    private RelativeLayout bBm;
    private ScrollView bIk;
    private boolean dDi;
    private View dxM;
    private View eLn;
    private TextView eVz;
    private final GroupInfoActivity eWD;
    private View eWE;
    private ProgressBar eWF;
    private RelativeLayout eWG;
    private TextView eWH;
    private TextView eWI;
    private TextView eWJ;
    private TextView eWK;
    private EllipsizingTextView eWL;
    private TextView eWM;
    private RelativeLayout eWN;
    private PhotoWallView eWO;
    private RelativeLayout eWP;
    private RelativeLayout eWQ;
    private LinearLayout eWR;
    private HeadImageView eWS;
    private TextView eWT;
    private RelativeLayout eWU;
    private com.baidu.tbadk.core.dialog.b eWV;
    private ImageView eWW;
    private final View eWX;
    private b.InterfaceC0158b eWY;
    private RelativeLayout eWZ;
    private ResponseGroupInfoLocalMessage.a eXA;
    private boolean eXB;
    private boolean eXC;
    private LinearLayout eXa;
    private HeadImageView[] eXb;
    private LinearLayout eXc;
    private TextView eXd;
    private RelativeLayout eXe;
    private LinearLayout eXf;
    private com.baidu.tbadk.core.dialog.b eXg;
    private LinearLayout eXh;
    private com.baidu.tbadk.core.dialog.b eXi;
    private b eXj;
    private TextView eXk;
    private String eXl;
    private ImageView eXm;
    private RelativeLayout eXn;
    private TextView eXo;
    private ImageView eXp;
    private RelativeLayout eXq;
    private RelativeLayout eXr;
    private ImageView eXs;
    private ImageView eXt;
    private View eXu;
    private TextView eXv;
    private TextView eXw;
    private LinearLayout eXx;
    private View eXy;
    private TextView eXz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eXD = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eWV = null;
        this.eWY = null;
        this.eXb = new HeadImageView[5];
        this.eXl = "";
        this.eXB = true;
        this.isMemGroup = false;
        this.dDi = false;
        this.eXC = false;
        this.eWD = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eWX = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bIk.setVisibility(4);
        this.eXc.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eXo.setText(str);
        qC(str);
    }

    private void qC(String str) {
        if (str != null) {
            this.eXz.setText(str);
        }
    }

    public void qD(String str) {
        this.eWL.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.eLn = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eXz = this.mNavigationBar.setTitleText("");
        this.eXy = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eXk = (TextView) this.eXy.findViewById(e.g.right_textview);
        this.eXk.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eXk, e.d.cp_cont_f, 1);
        this.eXk.setOnClickListener(groupInfoActivity);
        this.eXy.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eWE = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bBm = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bIk = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bIk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.dxM = groupInfoActivity.findViewById(e.g.group_top_view);
        this.dxM.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eWG = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eWG.setOnClickListener(groupInfoActivity);
        this.eWH = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eWI = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eWZ = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eWZ.setOnClickListener(groupInfoActivity);
        this.eXh = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eXm = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eWJ = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eWK = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eXs = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eWL = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eWL.setMaxLines(20);
        this.eWL.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hJ(boolean z) {
                if (z) {
                    a.this.eXv.setVisibility(0);
                } else {
                    a.this.eXv.setVisibility(8);
                }
            }
        });
        this.eWN = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eWM = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eWN.setOnClickListener(groupInfoActivity);
        this.eWS = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eWS.setAutoChangeStyle(true);
        this.eWS.setIsRound(false);
        this.eVz = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eWP = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eWP.setOnClickListener(groupInfoActivity);
        this.eWW = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eXu = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eWR = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eWN.setOnClickListener(groupInfoActivity);
        this.eWQ = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eWQ.setOnClickListener(groupInfoActivity);
        this.eWT = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eWU = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eWU.setOnClickListener(groupInfoActivity);
        this.eXa = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eXc = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eXx = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eXd = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eXx.setOnClickListener(this.eWD);
        this.eXe = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eXe.setOnClickListener(groupInfoActivity);
        this.eXf = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eXn = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eXn.setOnClickListener(groupInfoActivity);
        this.eXo = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eXp = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eXt = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eXq = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eXq.setOnClickListener(groupInfoActivity);
        this.eXq.setLongClickable(true);
        this.eXq.setOnLongClickListener(groupInfoActivity);
        this.eXv = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eXv.setClickable(true);
        this.eXv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eWL.setMaxLines(1000);
            }
        });
        this.eXr = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eXr.setOnLongClickListener(groupInfoActivity);
        this.eXw = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eWF = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eWO = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eWO.setPhotoClickListener(groupInfoActivity);
        this.eWO.setPhotoLongClickListener(groupInfoActivity);
        this.eWO.setVisibility(8);
    }

    public RelativeLayout aTw() {
        return this.eXr;
    }

    public RelativeLayout aTx() {
        return this.eWN;
    }

    public LinearLayout aTy() {
        return this.eXa;
    }

    public RelativeLayout aTz() {
        return this.eXe;
    }

    public RelativeLayout aTA() {
        return this.eXq;
    }

    public RelativeLayout aTB() {
        return this.eXn;
    }

    public RelativeLayout aTC() {
        return this.eWG;
    }

    public View aTD() {
        return this.eXk;
    }

    public LinearLayout aTE() {
        return this.eXx;
    }

    public RelativeLayout aTF() {
        return this.eWP;
    }

    public RelativeLayout aTG() {
        return this.eWQ;
    }

    public RelativeLayout aTH() {
        return this.eWU;
    }

    public View aSr() {
        return this.eLn;
    }

    public void aTI() {
        this.eWF.setVisibility(8);
    }

    public void aTJ() {
        this.eWF.setVisibility(0);
    }

    public void h(boolean z, String str) {
        if (z) {
            this.eWK.setText(str);
            this.eWZ.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eWZ.setVisibility(8);
        } else {
            this.eWK.setText(str);
            this.eWZ.setVisibility(0);
        }
    }

    public void iK(boolean z) {
        if (z) {
            this.eWK.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eWZ.setVisibility(8);
        }
    }

    public RelativeLayout aTK() {
        return this.eWZ;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dDi = aVar.aUu();
            this.eXC = aVar.aUv();
            this.eXA = aVar;
            this.eXB = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aUp() != null) {
                eXD = aVar.aUp().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eXh.setVisibility(0);
            this.eXc.setVisibility(0);
            if (aVar.getGroup() != null) {
                qC(aVar.getGroup().getName());
                this.eWJ.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eWW.setVisibility(0);
                } else {
                    this.eWW.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eXm.setVisibility(0);
                    this.eWS.setVisibility(8);
                    this.eXt.setVisibility(8);
                    this.eXu.setVisibility(8);
                    this.eVz.setText(e.j.group_info_forum_author);
                    this.eWP.setEnabled(false);
                    this.eWW.setVisibility(8);
                } else {
                    this.eXm.setVisibility(8);
                    this.eWS.setVisibility(0);
                    this.eXt.setVisibility(0);
                    this.eXu.setVisibility(0);
                    this.eVz.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eWP.setEnabled(true);
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
                this.eXl = stringBuffer.toString();
                this.eWK.setText(this.eXl);
                this.eWL.setText(aVar.getGroup().getIntro());
                this.eWT.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eWS.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eWN.setVisibility(0);
                    this.eWM.setText(aVar.getGroup().getForumName() + this.eWD.getPageContext().getString(e.j.forum));
                } else {
                    this.eWN.setVisibility(8);
                }
                this.eWR.removeAllViews();
                boolean aUw = aVar.aUw();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eXz, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eWD.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eWR.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eWD.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eWR.addView(imageView2);
                }
                if (aUw) {
                    this.eXw.setVisibility(0);
                } else {
                    this.eXw.setVisibility(8);
                }
            }
            if (aVar.aUp() != null) {
                this.eWG.setVisibility(0);
                this.eWE.setVisibility(0);
                GroupActivityData aUp = aVar.aUp();
                if (!aVar.aUu()) {
                    if (aUp.getIsEnd() != 1) {
                        this.eWH.setVisibility(4);
                        this.eWI.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eWG.setVisibility(8);
                        this.eWE.setVisibility(8);
                    }
                } else {
                    this.eWH.setVisibility(0);
                    this.eWI.setText(aUp.getgActivityTitle());
                    if (aUp.getIsEnd() != 1) {
                        this.eWH.setText(e.j.group_info_activity_doing);
                        al.c(this.eWH, e.d.common_color_10171, 1);
                    } else {
                        this.eWH.setText(e.j.group_activity_end);
                        al.c(this.eWH, e.d.common_color_10168, 1);
                    }
                    this.eWI.setText(aUp.getgActivityTitle());
                }
            } else if (aVar.aUv()) {
                this.eWG.setVisibility(0);
                this.eWE.setVisibility(0);
                this.eWH.setVisibility(4);
                this.eWI.setText(e.j.group_info_create_activity);
            } else {
                this.eWG.setVisibility(8);
                this.eWE.setVisibility(8);
            }
            this.eXa.removeAllViews();
            if (aVar.aUq() != null && aVar.aUq().size() > 0) {
                List<MemberData> aUq = aVar.aUq();
                int size = aUq.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aUq.get(i3);
                    HeadImageView headImageView = this.eXb[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eWD.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eXb[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                    this.eXa.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aUv()) {
                this.eWZ.setEnabled(true);
                this.eXq.setEnabled(true);
                al.i(this.eXq, e.f.group_info_item);
                this.eXn.setVisibility(0);
                this.eXs.setVisibility(0);
                this.eXp.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eXo.setText(aVar.getGroup().getName());
                }
            } else {
                this.eWZ.setEnabled(false);
                this.eXq.setEnabled(true);
                al.j(this.eXq, e.d.cp_bg_line_d);
                this.eXp.setVisibility(8);
                this.eXs.setVisibility(8);
                this.eWL.setPadding(0, 0, 0, 0);
            }
            if (aVar.aUu()) {
                this.eXf.setVisibility(0);
                this.eXy.setVisibility(0);
                if (this.eWU.getParent() != this.eXf) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds18);
                    this.eXh.removeView(this.eWU);
                    this.eXf.addView(this.eWU, 1);
                }
                aTL();
            } else {
                this.eXf.setVisibility(8);
                this.eXy.setVisibility(8);
                if (this.eWU.getParent() != this.eXh) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28);
                    this.eXf.removeView(this.eWU);
                    this.eXh.addView(this.eWU, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eWQ.setVisibility(8);
            } else {
                this.eWQ.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iK(aVar.aUv());
            } else {
                h(aVar.aUv(), this.eXl);
            }
            this.bIk.setVisibility(0);
            this.eXc.setVisibility(0);
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
        this.eXd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eXd, e.d.cp_cont_i, 1);
        this.eXd.setText(this.eWD.getPageContext().getString(e.j.i_want_talk));
        this.eXx.setEnabled(true);
    }

    private void iL(boolean z) {
        this.eXd.setText(this.eWD.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eXd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eXd, e.d.cp_cont_i, 1);
        } else {
            this.eXd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eXd, e.d.cp_cont_i, 1);
        }
        al.i(this.eXx, e.f.btn_blue_bg);
        this.eXx.setEnabled(true);
    }

    private boolean qq(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aTM() {
        this.eXd.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eXd.setText(this.eWD.getPageContext().getString(e.j.group_info_refuse_join));
        this.eXd.setTextColor(this.eWD.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eXx, e.f.btn_app_download_d);
        this.eXx.setEnabled(false);
    }

    public void qE(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eXa.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eXa.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eXa.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eWO.setIsManager(aVar.aUv());
            if (aVar.aUv()) {
                this.eWO.setVisibility(0);
                if (aVar.aUr() != null && aVar.aUr().size() == 1 && TextUtils.isEmpty(aVar.aUr().get(0).getPicId())) {
                    this.eWO.setData(null);
                } else {
                    this.eWO.setData(aVar.aUr());
                }
            } else if (aVar.aUr() != null && aVar.aUr().size() > 0) {
                if (aVar.aUr().size() == 1 && TextUtils.isEmpty(aVar.aUr().get(0).getPicId())) {
                    this.eWO.setVisibility(8);
                    return;
                }
                this.eWO.setVisibility(0);
                this.eWO.setData(aVar.aUr());
            } else {
                this.eWO.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eXj = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eXi != null) {
            this.eXi.dismiss();
            this.eXi = null;
        }
        e(obj, i);
        this.eXi.BV();
    }

    public void aTN() {
        this.eXi.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eXi == null) {
            this.eXi = new com.baidu.tbadk.core.dialog.b(this.eWD.getPageContext().getPageActivity());
            this.eXi.eL(this.eWD.getResources().getString(e.j.operation));
            this.eXi.a(new String[]{this.eWD.getResources().getString(e.j.group_info_set_portrait), this.eWD.getResources().getString(e.j.delete), this.eWD.getResources().getString(e.j.cancel)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eXj.a(bVar, i2, obj, i);
                }
            });
        }
        this.eXi.d(this.eWD.getPageContext());
    }

    public void onDestory() {
        if (this.eWO != null) {
            this.eWO.onDestory();
        }
        if (this.eWS != null) {
            this.eWS.stopLoad();
            this.eWS.setBackgroundDrawable(null);
            this.eWS.setImageDrawable(null);
        }
        if (this.eXa != null && this.eXb != null) {
            int length = this.eXb.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eXb[i];
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
            CharSequence[] charSequenceArr = {this.eWD.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eWD.getPageContext().getPageActivity());
            bVar.eL(this.eWD.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eWD.getSystemService("clipboard")).setText(str);
                        a.this.eWD.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eWD.getPageContext());
            bVar.BV();
        }
    }

    public void qG(String str) {
        if (this.eXg == null) {
            qH(str);
        }
        this.eXg.BV();
    }

    private void qH(final String str) {
        if (this.eXg == null) {
            this.eXg = new com.baidu.tbadk.core.dialog.b(this.eWD.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eWD.getPageContext().getString(e.j.copy_group_number)};
            this.eXg.eL(this.eWD.getPageContext().getString(e.j.operation));
            this.eXg.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eWD.getSystemService("clipboard")).setText(str);
                        a.this.eWD.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eXg.d(this.eWD.getPageContext());
        }
    }

    public void aTO() {
        ColorStateList dN = al.dN(e.d.cp_cont_i);
        if (dN != null) {
            this.eXd.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eXd.setTextColor(dN);
    }

    public void changeSkinType(int i) {
        this.eWD.getLayoutMode().setNightMode(i == 1);
        this.eWD.getLayoutMode().onModeChanged(this.bBm);
        this.eWD.getLayoutMode().onModeChanged(this.eWX);
        this.eWO.a(i, this.eWD);
        this.mNavigationBar.onChangeSkinType(this.eWD.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eXz, e.d.common_color_10009, 1);
        }
        if (!this.dDi) {
            b(this.eXA, this.eXB);
        }
        if (this.eXC) {
            al.i(this.eXq, e.f.group_info_item);
        } else {
            al.j(this.eXq, e.d.cp_bg_line_d);
        }
    }

    public void iM(boolean z) {
        this.dDi = z;
    }
}
