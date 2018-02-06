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
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.dialog.b;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.d;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static int eIf = 0;
    public static int eIg = 0;
    private RelativeLayout bSe;
    private ScrollView dCK;
    private View dvg;
    private TextView eGb;
    private RelativeLayout eHA;
    private LinearLayout eHB;
    private HeadImageView[] eHC;
    private LinearLayout eHD;
    private TextView eHE;
    private RelativeLayout eHF;
    private LinearLayout eHG;
    private com.baidu.tbadk.core.dialog.b eHH;
    private LinearLayout eHI;
    private com.baidu.tbadk.core.dialog.b eHJ;
    private b eHK;
    private TextView eHL;
    private String eHM;
    private ImageView eHN;
    private RelativeLayout eHO;
    private TextView eHP;
    private ImageView eHQ;
    private RelativeLayout eHR;
    private RelativeLayout eHS;
    private ImageView eHT;
    private ImageView eHU;
    private View eHV;
    private TextView eHW;
    private TextView eHX;
    private LinearLayout eHY;
    private View eHZ;
    private final GroupInfoActivity eHe;
    private View eHf;
    private ProgressBar eHg;
    private RelativeLayout eHh;
    private TextView eHi;
    private TextView eHj;
    private TextView eHk;
    private TextView eHl;
    private EllipsizingTextView eHm;
    private TextView eHn;
    private RelativeLayout eHo;
    private PhotoWallView eHp;
    private RelativeLayout eHq;
    private RelativeLayout eHr;
    private LinearLayout eHs;
    private HeadImageView eHt;
    private TextView eHu;
    private RelativeLayout eHv;
    private com.baidu.tbadk.core.dialog.b eHw;
    private ImageView eHx;
    private final View eHy;
    private b.InterfaceC0096b eHz;
    private TextView eIa;
    private ResponseGroupInfoLocalMessage.a eIb;
    private boolean eIc;
    private boolean eId;
    private boolean eIe;
    private View evK;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eHw = null;
        this.eHz = null;
        this.eHC = new HeadImageView[5];
        this.eHM = "";
        this.eIc = true;
        this.isMemGroup = false;
        this.eId = false;
        this.eIe = false;
        this.eHe = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.eHy = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dCK.setVisibility(4);
        this.eHD.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eHP.setText(str);
        nz(str);
    }

    private void nz(String str) {
        if (str != null) {
            this.eIa.setText(str);
        }
    }

    public void nA(String str) {
        this.eHm.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.evK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eIa = this.mNavigationBar.setTitleText("");
        this.eHZ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eHL = (TextView) this.eHZ.findViewById(d.g.right_textview);
        this.eHL.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        aj.e(this.eHL, d.C0140d.cp_cont_f, 1);
        this.eHL.setOnClickListener(groupInfoActivity);
        this.eHZ.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eHf = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bSe = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dCK = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dCK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.dvg = groupInfoActivity.findViewById(d.g.group_top_view);
        this.dvg.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eHh = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.eHh.setOnClickListener(groupInfoActivity);
        this.eHi = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.eHj = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.eHA = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.eHA.setOnClickListener(groupInfoActivity);
        this.eHI = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.eHN = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.eHk = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.eHl = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.eHT = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.eHm = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.eHm.setMaxLines(20);
        this.eHm.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gG(boolean z) {
                if (z) {
                    a.this.eHW.setVisibility(0);
                } else {
                    a.this.eHW.setVisibility(8);
                }
            }
        });
        this.eHo = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.eHn = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.eHo.setOnClickListener(groupInfoActivity);
        this.eHt = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.eHt.setAutoChangeStyle(true);
        this.eHt.setIsRound(false);
        this.eGb = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.eHq = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.eHq.setOnClickListener(groupInfoActivity);
        this.eHx = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.eHV = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.eHs = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.eHo.setOnClickListener(groupInfoActivity);
        this.eHr = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.eHr.setOnClickListener(groupInfoActivity);
        this.eHu = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.eHv = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.eHv.setOnClickListener(groupInfoActivity);
        this.eHB = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.eHD = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.eHY = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eHE = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.eHY.setOnClickListener(this.eHe);
        this.eHF = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.eHF.setOnClickListener(groupInfoActivity);
        this.eHG = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.eHO = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.eHO.setOnClickListener(groupInfoActivity);
        this.eHP = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.eHQ = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.eHU = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.eHR = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.eHR.setOnClickListener(groupInfoActivity);
        this.eHR.setLongClickable(true);
        this.eHR.setOnLongClickListener(groupInfoActivity);
        this.eHW = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.eHW.setClickable(true);
        this.eHW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eHm.setMaxLines(1000);
            }
        });
        this.eHS = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.eHS.setOnLongClickListener(groupInfoActivity);
        this.eHX = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.eHg = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eHp = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.eHp.setPhotoClickListener(groupInfoActivity);
        this.eHp.setPhotoLongClickListener(groupInfoActivity);
        this.eHp.setVisibility(8);
    }

    public RelativeLayout aJV() {
        return this.eHS;
    }

    public RelativeLayout aJW() {
        return this.eHo;
    }

    public LinearLayout aJX() {
        return this.eHB;
    }

    public RelativeLayout aJY() {
        return this.eHF;
    }

    public RelativeLayout aJZ() {
        return this.eHR;
    }

    public RelativeLayout aKa() {
        return this.eHO;
    }

    public RelativeLayout aKb() {
        return this.eHh;
    }

    public View aKc() {
        return this.eHL;
    }

    public LinearLayout aKd() {
        return this.eHY;
    }

    public RelativeLayout aKe() {
        return this.eHq;
    }

    public RelativeLayout aKf() {
        return this.eHr;
    }

    public RelativeLayout aKg() {
        return this.eHv;
    }

    public View aIQ() {
        return this.evK;
    }

    public void aKh() {
        this.eHg.setVisibility(8);
    }

    public void aKi() {
        this.eHg.setVisibility(0);
    }

    public void g(boolean z, String str) {
        if (z) {
            this.eHl.setText(str);
            this.eHA.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eHA.setVisibility(8);
        } else {
            this.eHl.setText(str);
            this.eHA.setVisibility(0);
        }
    }

    public void hG(boolean z) {
        if (z) {
            this.eHl.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.eHA.setVisibility(8);
        }
    }

    public RelativeLayout aKj() {
        return this.eHA;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eId = aVar.aKV();
            this.eIe = aVar.aKW();
            this.eIb = aVar;
            this.eIc = z;
            if (aVar.getGroup() != null) {
                eIf = aVar.getGroup().getGroupId();
            }
            if (aVar.aKQ() != null) {
                eIg = aVar.aKQ().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eHI.setVisibility(0);
            this.eHD.setVisibility(0);
            if (aVar.getGroup() != null) {
                nz(aVar.getGroup().getName());
                this.eHk.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eHx.setVisibility(0);
                } else {
                    this.eHx.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eHN.setVisibility(0);
                    this.eHt.setVisibility(8);
                    this.eHU.setVisibility(8);
                    this.eHV.setVisibility(8);
                    this.eGb.setText(d.j.group_info_forum_author);
                    this.eHq.setEnabled(false);
                    this.eHx.setVisibility(8);
                } else {
                    this.eHN.setVisibility(8);
                    this.eHt.setVisibility(0);
                    this.eHU.setVisibility(0);
                    this.eHV.setVisibility(0);
                    this.eGb.setText(aVar.getGroup().getAuthorName());
                    this.eHq.setEnabled(true);
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
                this.eHM = stringBuffer.toString();
                this.eHl.setText(this.eHM);
                this.eHm.setText(aVar.getGroup().getIntro());
                this.eHu.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eHt.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eHo.setVisibility(0);
                    this.eHn.setText(aVar.getGroup().getForumName() + this.eHe.getPageContext().getString(d.j.forum));
                } else {
                    this.eHo.setVisibility(8);
                }
                this.eHs.removeAllViews();
                boolean aKX = aVar.aKX();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    aj.e(this.eIa, d.C0140d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eHe.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            aj.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            aj.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.eHs.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eHe.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        aj.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        aj.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.eHs.addView(imageView2);
                }
                if (aKX) {
                    this.eHX.setVisibility(0);
                } else {
                    this.eHX.setVisibility(8);
                }
            }
            if (aVar.aKQ() != null) {
                this.eHh.setVisibility(0);
                this.eHf.setVisibility(0);
                GroupActivityData aKQ = aVar.aKQ();
                if (!aVar.aKV()) {
                    if (aKQ.getIsEnd() != 1) {
                        this.eHi.setVisibility(4);
                        this.eHj.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.eHh.setVisibility(8);
                        this.eHf.setVisibility(8);
                    }
                } else {
                    this.eHi.setVisibility(0);
                    this.eHj.setText(aKQ.getgActivityTitle());
                    if (aKQ.getIsEnd() != 1) {
                        this.eHi.setText(d.j.group_info_activity_doing);
                        aj.e(this.eHi, d.C0140d.common_color_10171, 1);
                    } else {
                        this.eHi.setText(d.j.group_activity_end);
                        aj.e(this.eHi, d.C0140d.common_color_10168, 1);
                    }
                    this.eHj.setText(aKQ.getgActivityTitle());
                }
            } else if (aVar.aKW()) {
                this.eHh.setVisibility(0);
                this.eHf.setVisibility(0);
                this.eHi.setVisibility(4);
                this.eHj.setText(d.j.group_info_create_activity);
            } else {
                this.eHh.setVisibility(8);
                this.eHf.setVisibility(8);
            }
            this.eHB.removeAllViews();
            if (aVar.aKR() != null && aVar.aKR().size() > 0) {
                List<MemberData> aKR = aVar.aKR();
                int size = aKR.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aKR.get(i3);
                    HeadImageView headImageView = this.eHC[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eHe.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eHC[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.eHB.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aKW()) {
                this.eHA.setEnabled(true);
                this.eHR.setEnabled(true);
                aj.s(this.eHR, d.f.group_info_item);
                this.eHO.setVisibility(0);
                this.eHT.setVisibility(0);
                this.eHQ.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eHP.setText(aVar.getGroup().getName());
                }
            } else {
                this.eHA.setEnabled(false);
                this.eHR.setEnabled(true);
                aj.t(this.eHR, d.C0140d.cp_bg_line_d);
                this.eHQ.setVisibility(8);
                this.eHT.setVisibility(8);
                this.eHm.setPadding(0, 0, 0, 0);
            }
            if (aVar.aKV()) {
                this.eHG.setVisibility(0);
                this.eHZ.setVisibility(0);
                if (this.eHv.getParent() != this.eHG) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.eHI.removeView(this.eHv);
                    this.eHG.addView(this.eHv, 1);
                }
                aKk();
            } else {
                this.eHG.setVisibility(8);
                this.eHZ.setVisibility(8);
                if (this.eHv.getParent() != this.eHI) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.eHG.removeView(this.eHv);
                    this.eHI.addView(this.eHv, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eHr.setVisibility(8);
            } else {
                this.eHr.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hG(aVar.aKW());
            } else {
                g(aVar.aKW(), this.eHM);
            }
            this.dCK.setVisibility(0);
            this.eHD.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qj(aVar.getGroup().getFlag())) {
                hH(z);
            } else {
                aKl();
            }
        }
    }

    public void aKk() {
        this.eHE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.eHE, d.C0140d.cp_cont_i, 1);
        this.eHE.setText(this.eHe.getPageContext().getString(d.j.i_want_talk));
        this.eHY.setEnabled(true);
    }

    private void hH(boolean z) {
        this.eHE.setText(this.eHe.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.eHE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHE, d.C0140d.cp_cont_i, 1);
        } else {
            this.eHE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHE, d.C0140d.cp_cont_i, 1);
        }
        aj.s(this.eHY, d.f.btn_blue_bg);
        this.eHY.setEnabled(true);
    }

    private boolean qj(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aKl() {
        this.eHE.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eHE.setText(this.eHe.getPageContext().getString(d.j.group_info_refuse_join));
        this.eHE.setTextColor(this.eHe.getResources().getColorStateList(d.C0140d.cp_cont_i));
        aj.s(this.eHY, d.f.btn_app_download_d);
        this.eHY.setEnabled(false);
    }

    public void nB(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eHB.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHB.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eHB.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eHp.setIsManager(aVar.aKW());
            if (aVar.aKW()) {
                this.eHp.setVisibility(0);
                if (aVar.aKS() != null && aVar.aKS().size() == 1 && TextUtils.isEmpty(aVar.aKS().get(0).getPicId())) {
                    this.eHp.setData(null);
                } else {
                    this.eHp.setData(aVar.aKS());
                }
            } else if (aVar.aKS() != null && aVar.aKS().size() > 0) {
                if (aVar.aKS().size() == 1 && TextUtils.isEmpty(aVar.aKS().get(0).getPicId())) {
                    this.eHp.setVisibility(8);
                    return;
                }
                this.eHp.setVisibility(0);
                this.eHp.setData(aVar.aKS());
            } else {
                this.eHp.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eHK = bVar;
    }

    public void j(Object obj, int i) {
        if (this.eHJ != null) {
            this.eHJ.dismiss();
            this.eHJ = null;
        }
        k(obj, i);
        this.eHJ.AX();
    }

    public void aKm() {
        this.eHJ.dismiss();
    }

    private void k(final Object obj, final int i) {
        if (this.eHJ == null) {
            this.eHJ = new com.baidu.tbadk.core.dialog.b(this.eHe.getPageContext().getPageActivity());
            this.eHJ.dl(this.eHe.getResources().getString(d.j.operation));
            this.eHJ.a(new String[]{this.eHe.getResources().getString(d.j.group_info_set_portrait), this.eHe.getResources().getString(d.j.delete), this.eHe.getResources().getString(d.j.cancel)}, new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eHK.a(bVar, i2, obj, i);
                }
            });
        }
        this.eHJ.d(this.eHe.getPageContext());
    }

    public void onDestory() {
        if (this.eHp != null) {
            this.eHp.onDestory();
        }
        if (this.eHt != null) {
            this.eHt.stopLoad();
            this.eHt.setBackgroundDrawable(null);
            this.eHt.setImageDrawable(null);
        }
        if (this.eHB != null && this.eHC != null) {
            int length = this.eHC.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eHC[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void nC(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eHe.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eHe.getPageContext().getPageActivity());
            bVar.dl(this.eHe.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eHe.getSystemService("clipboard")).setText(str);
                        a.this.eHe.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eHe.getPageContext());
            bVar.AX();
        }
    }

    public void nD(String str) {
        if (this.eHH == null) {
            nE(str);
        }
        this.eHH.AX();
    }

    private void nE(final String str) {
        if (this.eHH == null) {
            this.eHH = new com.baidu.tbadk.core.dialog.b(this.eHe.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eHe.getPageContext().getString(d.j.copy_group_number)};
            this.eHH.dl(this.eHe.getPageContext().getString(d.j.operation));
            this.eHH.a(charSequenceArr, new b.InterfaceC0096b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0096b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eHe.getSystemService("clipboard")).setText(str);
                        a.this.eHe.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eHH.d(this.eHe.getPageContext());
        }
    }

    public void aKn() {
        ColorStateList fN = aj.fN(d.C0140d.cp_cont_i);
        if (fN != null) {
            this.eHE.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eHE.setTextColor(fN);
    }

    public void changeSkinType(int i) {
        this.eHe.getLayoutMode().aQ(i == 1);
        this.eHe.getLayoutMode().aM(this.bSe);
        this.eHe.getLayoutMode().aM(this.eHy);
        this.eHp.a(i, this.eHe);
        this.mNavigationBar.onChangeSkinType(this.eHe.getPageContext(), i);
        if (this.isMemGroup) {
            aj.e(this.eIa, d.C0140d.common_color_10009, 1);
        }
        if (!this.eId) {
            b(this.eIb, this.eIc);
        }
        if (this.eIe) {
            aj.s(this.eHR, d.f.group_info_item);
        } else {
            aj.t(this.eHR, d.C0140d.cp_bg_line_d);
        }
    }

    public void hI(boolean z) {
        this.eId = z;
    }
}
