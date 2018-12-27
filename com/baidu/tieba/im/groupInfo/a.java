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
    private RelativeLayout bAz;
    private ScrollView bHx;
    private boolean dCz;
    private View dxd;
    private View eKB;
    private TextView eUM;
    private final GroupInfoActivity eVQ;
    private View eVR;
    private ProgressBar eVS;
    private RelativeLayout eVT;
    private TextView eVU;
    private TextView eVV;
    private TextView eVW;
    private TextView eVX;
    private EllipsizingTextView eVY;
    private TextView eVZ;
    private RelativeLayout eWA;
    private TextView eWB;
    private ImageView eWC;
    private RelativeLayout eWD;
    private RelativeLayout eWE;
    private ImageView eWF;
    private ImageView eWG;
    private View eWH;
    private TextView eWI;
    private TextView eWJ;
    private LinearLayout eWK;
    private View eWL;
    private TextView eWM;
    private ResponseGroupInfoLocalMessage.a eWN;
    private boolean eWO;
    private boolean eWP;
    private RelativeLayout eWa;
    private PhotoWallView eWb;
    private RelativeLayout eWc;
    private RelativeLayout eWd;
    private LinearLayout eWe;
    private HeadImageView eWf;
    private TextView eWg;
    private RelativeLayout eWh;
    private com.baidu.tbadk.core.dialog.b eWi;
    private ImageView eWj;
    private final View eWk;
    private b.InterfaceC0158b eWl;
    private RelativeLayout eWm;
    private LinearLayout eWn;
    private HeadImageView[] eWo;
    private LinearLayout eWp;
    private TextView eWq;
    private RelativeLayout eWr;
    private LinearLayout eWs;
    private com.baidu.tbadk.core.dialog.b eWt;
    private LinearLayout eWu;
    private com.baidu.tbadk.core.dialog.b eWv;
    private b eWw;
    private TextView eWx;
    private String eWy;
    private ImageView eWz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eWQ = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eWi = null;
        this.eWl = null;
        this.eWo = new HeadImageView[5];
        this.eWy = "";
        this.eWO = true;
        this.isMemGroup = false;
        this.dCz = false;
        this.eWP = false;
        this.eVQ = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eWk = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bHx.setVisibility(4);
        this.eWp.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eWB.setText(str);
        qm(str);
    }

    private void qm(String str) {
        if (str != null) {
            this.eWM.setText(str);
        }
    }

    public void qn(String str) {
        this.eVY.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.eKB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eWM = this.mNavigationBar.setTitleText("");
        this.eWL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eWx = (TextView) this.eWL.findViewById(e.g.right_textview);
        this.eWx.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eWx, e.d.cp_cont_f, 1);
        this.eWx.setOnClickListener(groupInfoActivity);
        this.eWL.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eVR = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bAz = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bHx = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bHx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.dxd = groupInfoActivity.findViewById(e.g.group_top_view);
        this.dxd.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eVT = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eVT.setOnClickListener(groupInfoActivity);
        this.eVU = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eVV = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eWm = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eWm.setOnClickListener(groupInfoActivity);
        this.eWu = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eWz = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eVW = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eVX = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eWF = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eVY = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eVY.setMaxLines(20);
        this.eVY.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hJ(boolean z) {
                if (z) {
                    a.this.eWI.setVisibility(0);
                } else {
                    a.this.eWI.setVisibility(8);
                }
            }
        });
        this.eWa = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eVZ = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eWa.setOnClickListener(groupInfoActivity);
        this.eWf = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eWf.setAutoChangeStyle(true);
        this.eWf.setIsRound(false);
        this.eUM = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eWc = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eWc.setOnClickListener(groupInfoActivity);
        this.eWj = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eWH = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eWe = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eWa.setOnClickListener(groupInfoActivity);
        this.eWd = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eWd.setOnClickListener(groupInfoActivity);
        this.eWg = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eWh = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eWh.setOnClickListener(groupInfoActivity);
        this.eWn = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eWp = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eWK = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eWq = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eWK.setOnClickListener(this.eVQ);
        this.eWr = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eWr.setOnClickListener(groupInfoActivity);
        this.eWs = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eWA = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eWA.setOnClickListener(groupInfoActivity);
        this.eWB = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eWC = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eWG = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eWD = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eWD.setOnClickListener(groupInfoActivity);
        this.eWD.setLongClickable(true);
        this.eWD.setOnLongClickListener(groupInfoActivity);
        this.eWI = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eWI.setClickable(true);
        this.eWI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eVY.setMaxLines(1000);
            }
        });
        this.eWE = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eWE.setOnLongClickListener(groupInfoActivity);
        this.eWJ = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eVS = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eWb = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eWb.setPhotoClickListener(groupInfoActivity);
        this.eWb.setPhotoLongClickListener(groupInfoActivity);
        this.eWb.setVisibility(8);
    }

    public RelativeLayout aSW() {
        return this.eWE;
    }

    public RelativeLayout aSX() {
        return this.eWa;
    }

    public LinearLayout aSY() {
        return this.eWn;
    }

    public RelativeLayout aSZ() {
        return this.eWr;
    }

    public RelativeLayout aTa() {
        return this.eWD;
    }

    public RelativeLayout aTb() {
        return this.eWA;
    }

    public RelativeLayout aTc() {
        return this.eVT;
    }

    public View aTd() {
        return this.eWx;
    }

    public LinearLayout aTe() {
        return this.eWK;
    }

    public RelativeLayout aTf() {
        return this.eWc;
    }

    public RelativeLayout aTg() {
        return this.eWd;
    }

    public RelativeLayout aTh() {
        return this.eWh;
    }

    public View aRR() {
        return this.eKB;
    }

    public void aTi() {
        this.eVS.setVisibility(8);
    }

    public void aTj() {
        this.eVS.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.eVX.setText(str);
            this.eWm.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eWm.setVisibility(8);
        } else {
            this.eVX.setText(str);
            this.eWm.setVisibility(0);
        }
    }

    public void iK(boolean z) {
        if (z) {
            this.eVX.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eWm.setVisibility(8);
        }
    }

    public RelativeLayout aTk() {
        return this.eWm;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dCz = aVar.aTU();
            this.eWP = aVar.aTV();
            this.eWN = aVar;
            this.eWO = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aTP() != null) {
                eWQ = aVar.aTP().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eWu.setVisibility(0);
            this.eWp.setVisibility(0);
            if (aVar.getGroup() != null) {
                qm(aVar.getGroup().getName());
                this.eVW.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eWj.setVisibility(0);
                } else {
                    this.eWj.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eWz.setVisibility(0);
                    this.eWf.setVisibility(8);
                    this.eWG.setVisibility(8);
                    this.eWH.setVisibility(8);
                    this.eUM.setText(e.j.group_info_forum_author);
                    this.eWc.setEnabled(false);
                    this.eWj.setVisibility(8);
                } else {
                    this.eWz.setVisibility(8);
                    this.eWf.setVisibility(0);
                    this.eWG.setVisibility(0);
                    this.eWH.setVisibility(0);
                    this.eUM.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eWc.setEnabled(true);
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
                this.eWy = stringBuffer.toString();
                this.eVX.setText(this.eWy);
                this.eVY.setText(aVar.getGroup().getIntro());
                this.eWg.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eWf.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eWa.setVisibility(0);
                    this.eVZ.setText(aVar.getGroup().getForumName() + this.eVQ.getPageContext().getString(e.j.forum));
                } else {
                    this.eWa.setVisibility(8);
                }
                this.eWe.removeAllViews();
                boolean aTW = aVar.aTW();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eWM, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eVQ.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eWe.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eVQ.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eWe.addView(imageView2);
                }
                if (aTW) {
                    this.eWJ.setVisibility(0);
                } else {
                    this.eWJ.setVisibility(8);
                }
            }
            if (aVar.aTP() != null) {
                this.eVT.setVisibility(0);
                this.eVR.setVisibility(0);
                GroupActivityData aTP = aVar.aTP();
                if (!aVar.aTU()) {
                    if (aTP.getIsEnd() != 1) {
                        this.eVU.setVisibility(4);
                        this.eVV.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eVT.setVisibility(8);
                        this.eVR.setVisibility(8);
                    }
                } else {
                    this.eVU.setVisibility(0);
                    this.eVV.setText(aTP.getgActivityTitle());
                    if (aTP.getIsEnd() != 1) {
                        this.eVU.setText(e.j.group_info_activity_doing);
                        al.c(this.eVU, e.d.common_color_10171, 1);
                    } else {
                        this.eVU.setText(e.j.group_activity_end);
                        al.c(this.eVU, e.d.common_color_10168, 1);
                    }
                    this.eVV.setText(aTP.getgActivityTitle());
                }
            } else if (aVar.aTV()) {
                this.eVT.setVisibility(0);
                this.eVR.setVisibility(0);
                this.eVU.setVisibility(4);
                this.eVV.setText(e.j.group_info_create_activity);
            } else {
                this.eVT.setVisibility(8);
                this.eVR.setVisibility(8);
            }
            this.eWn.removeAllViews();
            if (aVar.aTQ() != null && aVar.aTQ().size() > 0) {
                List<MemberData> aTQ = aVar.aTQ();
                int size = aTQ.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aTQ.get(i3);
                    HeadImageView headImageView = this.eWo[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eVQ.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eWo[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                    this.eWn.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aTV()) {
                this.eWm.setEnabled(true);
                this.eWD.setEnabled(true);
                al.i(this.eWD, e.f.group_info_item);
                this.eWA.setVisibility(0);
                this.eWF.setVisibility(0);
                this.eWC.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eWB.setText(aVar.getGroup().getName());
                }
            } else {
                this.eWm.setEnabled(false);
                this.eWD.setEnabled(true);
                al.j(this.eWD, e.d.cp_bg_line_d);
                this.eWC.setVisibility(8);
                this.eWF.setVisibility(8);
                this.eVY.setPadding(0, 0, 0, 0);
            }
            if (aVar.aTU()) {
                this.eWs.setVisibility(0);
                this.eWL.setVisibility(0);
                if (this.eWh.getParent() != this.eWs) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds18);
                    this.eWu.removeView(this.eWh);
                    this.eWs.addView(this.eWh, 1);
                }
                aTl();
            } else {
                this.eWs.setVisibility(8);
                this.eWL.setVisibility(8);
                if (this.eWh.getParent() != this.eWu) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28);
                    this.eWs.removeView(this.eWh);
                    this.eWu.addView(this.eWh, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eWd.setVisibility(8);
            } else {
                this.eWd.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iK(aVar.aTV());
            } else {
                i(aVar.aTV(), this.eWy);
            }
            this.bHx.setVisibility(0);
            this.eWp.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qp(aVar.getGroup().getFlag())) {
                iL(z);
            } else {
                aTm();
            }
        }
    }

    public void aTl() {
        this.eWq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eWq, e.d.cp_cont_i, 1);
        this.eWq.setText(this.eVQ.getPageContext().getString(e.j.i_want_talk));
        this.eWK.setEnabled(true);
    }

    private void iL(boolean z) {
        this.eWq.setText(this.eVQ.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eWq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eWq, e.d.cp_cont_i, 1);
        } else {
            this.eWq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eWq, e.d.cp_cont_i, 1);
        }
        al.i(this.eWK, e.f.btn_blue_bg);
        this.eWK.setEnabled(true);
    }

    private boolean qp(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aTm() {
        this.eWq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eWq.setText(this.eVQ.getPageContext().getString(e.j.group_info_refuse_join));
        this.eWq.setTextColor(this.eVQ.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eWK, e.f.btn_app_download_d);
        this.eWK.setEnabled(false);
    }

    public void qo(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eWn.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eWn.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eWn.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eWb.setIsManager(aVar.aTV());
            if (aVar.aTV()) {
                this.eWb.setVisibility(0);
                if (aVar.aTR() != null && aVar.aTR().size() == 1 && TextUtils.isEmpty(aVar.aTR().get(0).getPicId())) {
                    this.eWb.setData(null);
                } else {
                    this.eWb.setData(aVar.aTR());
                }
            } else if (aVar.aTR() != null && aVar.aTR().size() > 0) {
                if (aVar.aTR().size() == 1 && TextUtils.isEmpty(aVar.aTR().get(0).getPicId())) {
                    this.eWb.setVisibility(8);
                    return;
                }
                this.eWb.setVisibility(0);
                this.eWb.setData(aVar.aTR());
            } else {
                this.eWb.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eWw = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eWv != null) {
            this.eWv.dismiss();
            this.eWv = null;
        }
        e(obj, i);
        this.eWv.BI();
    }

    public void aTn() {
        this.eWv.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eWv == null) {
            this.eWv = new com.baidu.tbadk.core.dialog.b(this.eVQ.getPageContext().getPageActivity());
            this.eWv.eC(this.eVQ.getResources().getString(e.j.operation));
            this.eWv.a(new String[]{this.eVQ.getResources().getString(e.j.group_info_set_portrait), this.eVQ.getResources().getString(e.j.delete), this.eVQ.getResources().getString(e.j.cancel)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eWw.a(bVar, i2, obj, i);
                }
            });
        }
        this.eWv.d(this.eVQ.getPageContext());
    }

    public void onDestory() {
        if (this.eWb != null) {
            this.eWb.onDestory();
        }
        if (this.eWf != null) {
            this.eWf.stopLoad();
            this.eWf.setBackgroundDrawable(null);
            this.eWf.setImageDrawable(null);
        }
        if (this.eWn != null && this.eWo != null) {
            int length = this.eWo.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eWo[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void qp(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eVQ.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eVQ.getPageContext().getPageActivity());
            bVar.eC(this.eVQ.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eVQ.getSystemService("clipboard")).setText(str);
                        a.this.eVQ.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eVQ.getPageContext());
            bVar.BI();
        }
    }

    public void qq(String str) {
        if (this.eWt == null) {
            qr(str);
        }
        this.eWt.BI();
    }

    private void qr(final String str) {
        if (this.eWt == null) {
            this.eWt = new com.baidu.tbadk.core.dialog.b(this.eVQ.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eVQ.getPageContext().getString(e.j.copy_group_number)};
            this.eWt.eC(this.eVQ.getPageContext().getString(e.j.operation));
            this.eWt.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eVQ.getSystemService("clipboard")).setText(str);
                        a.this.eVQ.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eWt.d(this.eVQ.getPageContext());
        }
    }

    public void aTo() {
        ColorStateList dN = al.dN(e.d.cp_cont_i);
        if (dN != null) {
            this.eWq.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eWq.setTextColor(dN);
    }

    public void changeSkinType(int i) {
        this.eVQ.getLayoutMode().setNightMode(i == 1);
        this.eVQ.getLayoutMode().onModeChanged(this.bAz);
        this.eVQ.getLayoutMode().onModeChanged(this.eWk);
        this.eWb.a(i, this.eVQ);
        this.mNavigationBar.onChangeSkinType(this.eVQ.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eWM, e.d.common_color_10009, 1);
        }
        if (!this.dCz) {
            b(this.eWN, this.eWO);
        }
        if (this.eWP) {
            al.i(this.eWD, e.f.group_info_item);
        } else {
            al.j(this.eWD, e.d.cp_bg_line_d);
        }
    }

    public void iM(boolean z) {
        this.dCz = z;
    }
}
