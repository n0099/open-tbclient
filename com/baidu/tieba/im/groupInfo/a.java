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
    public static int eIj = 0;
    public static int eIk = 0;
    private RelativeLayout bRU;
    private ScrollView dCB;
    private View duX;
    private TextView eGf;
    private com.baidu.tbadk.core.dialog.b eHA;
    private ImageView eHB;
    private final View eHC;
    private b.InterfaceC0097b eHD;
    private RelativeLayout eHE;
    private LinearLayout eHF;
    private HeadImageView[] eHG;
    private LinearLayout eHH;
    private TextView eHI;
    private RelativeLayout eHJ;
    private LinearLayout eHK;
    private com.baidu.tbadk.core.dialog.b eHL;
    private LinearLayout eHM;
    private com.baidu.tbadk.core.dialog.b eHN;
    private b eHO;
    private TextView eHP;
    private String eHQ;
    private ImageView eHR;
    private RelativeLayout eHS;
    private TextView eHT;
    private ImageView eHU;
    private RelativeLayout eHV;
    private RelativeLayout eHW;
    private ImageView eHX;
    private ImageView eHY;
    private View eHZ;
    private final GroupInfoActivity eHi;
    private View eHj;
    private ProgressBar eHk;
    private RelativeLayout eHl;
    private TextView eHm;
    private TextView eHn;
    private TextView eHo;
    private TextView eHp;
    private EllipsizingTextView eHq;
    private TextView eHr;
    private RelativeLayout eHs;
    private PhotoWallView eHt;
    private RelativeLayout eHu;
    private RelativeLayout eHv;
    private LinearLayout eHw;
    private HeadImageView eHx;
    private TextView eHy;
    private RelativeLayout eHz;
    private TextView eIa;
    private TextView eIb;
    private LinearLayout eIc;
    private View eId;
    private TextView eIe;
    private ResponseGroupInfoLocalMessage.a eIf;
    private boolean eIg;
    private boolean eIh;
    private boolean eIi;
    private View evO;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eHA = null;
        this.eHD = null;
        this.eHG = new HeadImageView[5];
        this.eHQ = "";
        this.eIg = true;
        this.isMemGroup = false;
        this.eIh = false;
        this.eIi = false;
        this.eHi = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.eHC = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dCB.setVisibility(4);
        this.eHH.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eHT.setText(str);
        nz(str);
    }

    private void nz(String str) {
        if (str != null) {
            this.eIe.setText(str);
        }
    }

    public void nA(String str) {
        this.eHq.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.evO = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eIe = this.mNavigationBar.setTitleText("");
        this.eId = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eHP = (TextView) this.eId.findViewById(d.g.right_textview);
        this.eHP.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        aj.e(this.eHP, d.C0141d.cp_cont_f, 1);
        this.eHP.setOnClickListener(groupInfoActivity);
        this.eId.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eHj = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bRU = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dCB = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dCB.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.duX = groupInfoActivity.findViewById(d.g.group_top_view);
        this.duX.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eHl = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.eHl.setOnClickListener(groupInfoActivity);
        this.eHm = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.eHn = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.eHE = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.eHE.setOnClickListener(groupInfoActivity);
        this.eHM = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.eHR = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.eHo = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.eHp = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.eHX = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.eHq = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.eHq.setMaxLines(20);
        this.eHq.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gL(boolean z) {
                if (z) {
                    a.this.eIa.setVisibility(0);
                } else {
                    a.this.eIa.setVisibility(8);
                }
            }
        });
        this.eHs = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.eHr = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.eHs.setOnClickListener(groupInfoActivity);
        this.eHx = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.eHx.setAutoChangeStyle(true);
        this.eHx.setIsRound(false);
        this.eGf = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.eHu = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.eHu.setOnClickListener(groupInfoActivity);
        this.eHB = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.eHZ = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.eHw = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.eHs.setOnClickListener(groupInfoActivity);
        this.eHv = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.eHv.setOnClickListener(groupInfoActivity);
        this.eHy = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.eHz = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.eHz.setOnClickListener(groupInfoActivity);
        this.eHF = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.eHH = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.eIc = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eHI = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.eIc.setOnClickListener(this.eHi);
        this.eHJ = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.eHJ.setOnClickListener(groupInfoActivity);
        this.eHK = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.eHS = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.eHS.setOnClickListener(groupInfoActivity);
        this.eHT = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.eHU = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.eHY = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.eHV = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.eHV.setOnClickListener(groupInfoActivity);
        this.eHV.setLongClickable(true);
        this.eHV.setOnLongClickListener(groupInfoActivity);
        this.eIa = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.eIa.setClickable(true);
        this.eIa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eHq.setMaxLines(1000);
            }
        });
        this.eHW = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.eHW.setOnLongClickListener(groupInfoActivity);
        this.eIb = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.eHk = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eHt = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.eHt.setPhotoClickListener(groupInfoActivity);
        this.eHt.setPhotoLongClickListener(groupInfoActivity);
        this.eHt.setVisibility(8);
    }

    public RelativeLayout aJV() {
        return this.eHW;
    }

    public RelativeLayout aJW() {
        return this.eHs;
    }

    public LinearLayout aJX() {
        return this.eHF;
    }

    public RelativeLayout aJY() {
        return this.eHJ;
    }

    public RelativeLayout aJZ() {
        return this.eHV;
    }

    public RelativeLayout aKa() {
        return this.eHS;
    }

    public RelativeLayout aKb() {
        return this.eHl;
    }

    public View aKc() {
        return this.eHP;
    }

    public LinearLayout aKd() {
        return this.eIc;
    }

    public RelativeLayout aKe() {
        return this.eHu;
    }

    public RelativeLayout aKf() {
        return this.eHv;
    }

    public RelativeLayout aKg() {
        return this.eHz;
    }

    public View aIQ() {
        return this.evO;
    }

    public void aKh() {
        this.eHk.setVisibility(8);
    }

    public void aKi() {
        this.eHk.setVisibility(0);
    }

    public void g(boolean z, String str) {
        if (z) {
            this.eHp.setText(str);
            this.eHE.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eHE.setVisibility(8);
        } else {
            this.eHp.setText(str);
            this.eHE.setVisibility(0);
        }
    }

    public void hL(boolean z) {
        if (z) {
            this.eHp.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.eHE.setVisibility(8);
        }
    }

    public RelativeLayout aKj() {
        return this.eHE;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eIh = aVar.aKV();
            this.eIi = aVar.aKW();
            this.eIf = aVar;
            this.eIg = z;
            if (aVar.getGroup() != null) {
                eIj = aVar.getGroup().getGroupId();
            }
            if (aVar.aKQ() != null) {
                eIk = aVar.aKQ().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eHM.setVisibility(0);
            this.eHH.setVisibility(0);
            if (aVar.getGroup() != null) {
                nz(aVar.getGroup().getName());
                this.eHo.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eHB.setVisibility(0);
                } else {
                    this.eHB.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eHR.setVisibility(0);
                    this.eHx.setVisibility(8);
                    this.eHY.setVisibility(8);
                    this.eHZ.setVisibility(8);
                    this.eGf.setText(d.j.group_info_forum_author);
                    this.eHu.setEnabled(false);
                    this.eHB.setVisibility(8);
                } else {
                    this.eHR.setVisibility(8);
                    this.eHx.setVisibility(0);
                    this.eHY.setVisibility(0);
                    this.eHZ.setVisibility(0);
                    this.eGf.setText(aVar.getGroup().getAuthorName());
                    this.eHu.setEnabled(true);
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
                this.eHQ = stringBuffer.toString();
                this.eHp.setText(this.eHQ);
                this.eHq.setText(aVar.getGroup().getIntro());
                this.eHy.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eHx.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eHs.setVisibility(0);
                    this.eHr.setText(aVar.getGroup().getForumName() + this.eHi.getPageContext().getString(d.j.forum));
                } else {
                    this.eHs.setVisibility(8);
                }
                this.eHw.removeAllViews();
                boolean aKX = aVar.aKX();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    aj.e(this.eIe, d.C0141d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eHi.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            aj.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            aj.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.eHw.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eHi.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        aj.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        aj.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.eHw.addView(imageView2);
                }
                if (aKX) {
                    this.eIb.setVisibility(0);
                } else {
                    this.eIb.setVisibility(8);
                }
            }
            if (aVar.aKQ() != null) {
                this.eHl.setVisibility(0);
                this.eHj.setVisibility(0);
                GroupActivityData aKQ = aVar.aKQ();
                if (!aVar.aKV()) {
                    if (aKQ.getIsEnd() != 1) {
                        this.eHm.setVisibility(4);
                        this.eHn.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.eHl.setVisibility(8);
                        this.eHj.setVisibility(8);
                    }
                } else {
                    this.eHm.setVisibility(0);
                    this.eHn.setText(aKQ.getgActivityTitle());
                    if (aKQ.getIsEnd() != 1) {
                        this.eHm.setText(d.j.group_info_activity_doing);
                        aj.e(this.eHm, d.C0141d.common_color_10171, 1);
                    } else {
                        this.eHm.setText(d.j.group_activity_end);
                        aj.e(this.eHm, d.C0141d.common_color_10168, 1);
                    }
                    this.eHn.setText(aKQ.getgActivityTitle());
                }
            } else if (aVar.aKW()) {
                this.eHl.setVisibility(0);
                this.eHj.setVisibility(0);
                this.eHm.setVisibility(4);
                this.eHn.setText(d.j.group_info_create_activity);
            } else {
                this.eHl.setVisibility(8);
                this.eHj.setVisibility(8);
            }
            this.eHF.removeAllViews();
            if (aVar.aKR() != null && aVar.aKR().size() > 0) {
                List<MemberData> aKR = aVar.aKR();
                int size = aKR.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aKR.get(i3);
                    HeadImageView headImageView = this.eHG[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eHi.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eHG[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.eHF.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aKW()) {
                this.eHE.setEnabled(true);
                this.eHV.setEnabled(true);
                aj.s(this.eHV, d.f.group_info_item);
                this.eHS.setVisibility(0);
                this.eHX.setVisibility(0);
                this.eHU.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eHT.setText(aVar.getGroup().getName());
                }
            } else {
                this.eHE.setEnabled(false);
                this.eHV.setEnabled(true);
                aj.t(this.eHV, d.C0141d.cp_bg_line_d);
                this.eHU.setVisibility(8);
                this.eHX.setVisibility(8);
                this.eHq.setPadding(0, 0, 0, 0);
            }
            if (aVar.aKV()) {
                this.eHK.setVisibility(0);
                this.eId.setVisibility(0);
                if (this.eHz.getParent() != this.eHK) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.eHM.removeView(this.eHz);
                    this.eHK.addView(this.eHz, 1);
                }
                aKk();
            } else {
                this.eHK.setVisibility(8);
                this.eId.setVisibility(8);
                if (this.eHz.getParent() != this.eHM) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.eHK.removeView(this.eHz);
                    this.eHM.addView(this.eHz, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eHv.setVisibility(8);
            } else {
                this.eHv.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hL(aVar.aKW());
            } else {
                g(aVar.aKW(), this.eHQ);
            }
            this.dCB.setVisibility(0);
            this.eHH.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qk(aVar.getGroup().getFlag())) {
                hM(z);
            } else {
                aKl();
            }
        }
    }

    public void aKk() {
        this.eHI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.eHI, d.C0141d.cp_cont_i, 1);
        this.eHI.setText(this.eHi.getPageContext().getString(d.j.i_want_talk));
        this.eIc.setEnabled(true);
    }

    private void hM(boolean z) {
        this.eHI.setText(this.eHi.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.eHI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHI, d.C0141d.cp_cont_i, 1);
        } else {
            this.eHI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHI, d.C0141d.cp_cont_i, 1);
        }
        aj.s(this.eIc, d.f.btn_blue_bg);
        this.eIc.setEnabled(true);
    }

    private boolean qk(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aKl() {
        this.eHI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eHI.setText(this.eHi.getPageContext().getString(d.j.group_info_refuse_join));
        this.eHI.setTextColor(this.eHi.getResources().getColorStateList(d.C0141d.cp_cont_i));
        aj.s(this.eIc, d.f.btn_app_download_d);
        this.eIc.setEnabled(false);
    }

    public void nB(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eHF.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHF.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eHF.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eHt.setIsManager(aVar.aKW());
            if (aVar.aKW()) {
                this.eHt.setVisibility(0);
                if (aVar.aKS() != null && aVar.aKS().size() == 1 && TextUtils.isEmpty(aVar.aKS().get(0).getPicId())) {
                    this.eHt.setData(null);
                } else {
                    this.eHt.setData(aVar.aKS());
                }
            } else if (aVar.aKS() != null && aVar.aKS().size() > 0) {
                if (aVar.aKS().size() == 1 && TextUtils.isEmpty(aVar.aKS().get(0).getPicId())) {
                    this.eHt.setVisibility(8);
                    return;
                }
                this.eHt.setVisibility(0);
                this.eHt.setData(aVar.aKS());
            } else {
                this.eHt.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eHO = bVar;
    }

    public void j(Object obj, int i) {
        if (this.eHN != null) {
            this.eHN.dismiss();
            this.eHN = null;
        }
        k(obj, i);
        this.eHN.AY();
    }

    public void aKm() {
        this.eHN.dismiss();
    }

    private void k(final Object obj, final int i) {
        if (this.eHN == null) {
            this.eHN = new com.baidu.tbadk.core.dialog.b(this.eHi.getPageContext().getPageActivity());
            this.eHN.dl(this.eHi.getResources().getString(d.j.operation));
            this.eHN.a(new String[]{this.eHi.getResources().getString(d.j.group_info_set_portrait), this.eHi.getResources().getString(d.j.delete), this.eHi.getResources().getString(d.j.cancel)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eHO.a(bVar, i2, obj, i);
                }
            });
        }
        this.eHN.d(this.eHi.getPageContext());
    }

    public void onDestory() {
        if (this.eHt != null) {
            this.eHt.onDestory();
        }
        if (this.eHx != null) {
            this.eHx.stopLoad();
            this.eHx.setBackgroundDrawable(null);
            this.eHx.setImageDrawable(null);
        }
        if (this.eHF != null && this.eHG != null) {
            int length = this.eHG.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eHG[i];
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
            CharSequence[] charSequenceArr = {this.eHi.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eHi.getPageContext().getPageActivity());
            bVar.dl(this.eHi.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eHi.getSystemService("clipboard")).setText(str);
                        a.this.eHi.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eHi.getPageContext());
            bVar.AY();
        }
    }

    public void nD(String str) {
        if (this.eHL == null) {
            nE(str);
        }
        this.eHL.AY();
    }

    private void nE(final String str) {
        if (this.eHL == null) {
            this.eHL = new com.baidu.tbadk.core.dialog.b(this.eHi.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eHi.getPageContext().getString(d.j.copy_group_number)};
            this.eHL.dl(this.eHi.getPageContext().getString(d.j.operation));
            this.eHL.a(charSequenceArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eHi.getSystemService("clipboard")).setText(str);
                        a.this.eHi.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eHL.d(this.eHi.getPageContext());
        }
    }

    public void aKn() {
        ColorStateList fN = aj.fN(d.C0141d.cp_cont_i);
        if (fN != null) {
            this.eHI.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eHI.setTextColor(fN);
    }

    public void changeSkinType(int i) {
        this.eHi.getLayoutMode().aQ(i == 1);
        this.eHi.getLayoutMode().aM(this.bRU);
        this.eHi.getLayoutMode().aM(this.eHC);
        this.eHt.a(i, this.eHi);
        this.mNavigationBar.onChangeSkinType(this.eHi.getPageContext(), i);
        if (this.isMemGroup) {
            aj.e(this.eIe, d.C0141d.common_color_10009, 1);
        }
        if (!this.eIh) {
            b(this.eIf, this.eIg);
        }
        if (this.eIi) {
            aj.s(this.eHV, d.f.group_info_item);
        } else {
            aj.t(this.eHV, d.C0141d.cp_bg_line_d);
        }
    }

    public void hN(boolean z) {
        this.eIh = z;
    }
}
