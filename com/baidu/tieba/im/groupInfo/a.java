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
    public static int eHT = 0;
    public static int eHU = 0;
    private RelativeLayout bRR;
    private ScrollView dCy;
    private View duU;
    private TextView eFP;
    private final GroupInfoActivity eGS;
    private View eGT;
    private ProgressBar eGU;
    private RelativeLayout eGV;
    private TextView eGW;
    private TextView eGX;
    private TextView eGY;
    private TextView eGZ;
    private String eHA;
    private ImageView eHB;
    private RelativeLayout eHC;
    private TextView eHD;
    private ImageView eHE;
    private RelativeLayout eHF;
    private RelativeLayout eHG;
    private ImageView eHH;
    private ImageView eHI;
    private View eHJ;
    private TextView eHK;
    private TextView eHL;
    private LinearLayout eHM;
    private View eHN;
    private TextView eHO;
    private ResponseGroupInfoLocalMessage.a eHP;
    private boolean eHQ;
    private boolean eHR;
    private boolean eHS;
    private EllipsizingTextView eHa;
    private TextView eHb;
    private RelativeLayout eHc;
    private PhotoWallView eHd;
    private RelativeLayout eHe;
    private RelativeLayout eHf;
    private LinearLayout eHg;
    private HeadImageView eHh;
    private TextView eHi;
    private RelativeLayout eHj;
    private com.baidu.tbadk.core.dialog.b eHk;
    private ImageView eHl;
    private final View eHm;
    private b.InterfaceC0097b eHn;
    private RelativeLayout eHo;
    private LinearLayout eHp;
    private HeadImageView[] eHq;
    private LinearLayout eHr;
    private TextView eHs;
    private RelativeLayout eHt;
    private LinearLayout eHu;
    private com.baidu.tbadk.core.dialog.b eHv;
    private LinearLayout eHw;
    private com.baidu.tbadk.core.dialog.b eHx;
    private b eHy;
    private TextView eHz;
    private View evy;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eHk = null;
        this.eHn = null;
        this.eHq = new HeadImageView[5];
        this.eHA = "";
        this.eHQ = true;
        this.isMemGroup = false;
        this.eHR = false;
        this.eHS = false;
        this.eGS = groupInfoActivity;
        groupInfoActivity.setContentView(d.h.im_group_info_activity);
        this.eHm = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dCy.setVisibility(4);
        this.eHr.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eHD.setText(str);
        nz(str);
    }

    private void nz(String str) {
        if (str != null) {
            this.eHO.setText(str);
        }
    }

    public void nA(String str) {
        this.eHa.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.evy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eHO = this.mNavigationBar.setTitleText("");
        this.eHN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eHz = (TextView) this.eHN.findViewById(d.g.right_textview);
        this.eHz.setText(groupInfoActivity.getPageContext().getString(d.j.setup));
        aj.e(this.eHz, d.C0141d.cp_cont_f, 1);
        this.eHz.setOnClickListener(groupInfoActivity);
        this.eHN.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eGT = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bRR = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dCy = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dCy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.duU = groupInfoActivity.findViewById(d.g.group_top_view);
        this.duU.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eGV = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.eGV.setOnClickListener(groupInfoActivity);
        this.eGW = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.eGX = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.eHo = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.eHo.setOnClickListener(groupInfoActivity);
        this.eHw = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.eHB = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.eGY = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.eGZ = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.eHH = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.eHa = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.eHa.setMaxLines(20);
        this.eHa.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gG(boolean z) {
                if (z) {
                    a.this.eHK.setVisibility(0);
                } else {
                    a.this.eHK.setVisibility(8);
                }
            }
        });
        this.eHc = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.eHb = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.eHc.setOnClickListener(groupInfoActivity);
        this.eHh = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.eHh.setAutoChangeStyle(true);
        this.eHh.setIsRound(false);
        this.eFP = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.eHe = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.eHe.setOnClickListener(groupInfoActivity);
        this.eHl = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.eHJ = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.eHg = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.eHc.setOnClickListener(groupInfoActivity);
        this.eHf = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.eHf.setOnClickListener(groupInfoActivity);
        this.eHi = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.eHj = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.eHj.setOnClickListener(groupInfoActivity);
        this.eHp = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.eHr = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.eHM = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eHs = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.eHM.setOnClickListener(this.eGS);
        this.eHt = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.eHt.setOnClickListener(groupInfoActivity);
        this.eHu = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.eHC = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.eHC.setOnClickListener(groupInfoActivity);
        this.eHD = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.eHE = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.eHI = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.eHF = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.eHF.setOnClickListener(groupInfoActivity);
        this.eHF.setLongClickable(true);
        this.eHF.setOnLongClickListener(groupInfoActivity);
        this.eHK = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.eHK.setClickable(true);
        this.eHK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eHa.setMaxLines(1000);
            }
        });
        this.eHG = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.eHG.setOnLongClickListener(groupInfoActivity);
        this.eHL = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.eGU = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eHd = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.eHd.setPhotoClickListener(groupInfoActivity);
        this.eHd.setPhotoLongClickListener(groupInfoActivity);
        this.eHd.setVisibility(8);
    }

    public RelativeLayout aJU() {
        return this.eHG;
    }

    public RelativeLayout aJV() {
        return this.eHc;
    }

    public LinearLayout aJW() {
        return this.eHp;
    }

    public RelativeLayout aJX() {
        return this.eHt;
    }

    public RelativeLayout aJY() {
        return this.eHF;
    }

    public RelativeLayout aJZ() {
        return this.eHC;
    }

    public RelativeLayout aKa() {
        return this.eGV;
    }

    public View aKb() {
        return this.eHz;
    }

    public LinearLayout aKc() {
        return this.eHM;
    }

    public RelativeLayout aKd() {
        return this.eHe;
    }

    public RelativeLayout aKe() {
        return this.eHf;
    }

    public RelativeLayout aKf() {
        return this.eHj;
    }

    public View aIP() {
        return this.evy;
    }

    public void aKg() {
        this.eGU.setVisibility(8);
    }

    public void aKh() {
        this.eGU.setVisibility(0);
    }

    public void g(boolean z, String str) {
        if (z) {
            this.eGZ.setText(str);
            this.eHo.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eHo.setVisibility(8);
        } else {
            this.eGZ.setText(str);
            this.eHo.setVisibility(0);
        }
    }

    public void hG(boolean z) {
        if (z) {
            this.eGZ.setText(this.mContext.getString(d.j.live_card_hide));
        } else {
            this.eHo.setVisibility(8);
        }
    }

    public RelativeLayout aKi() {
        return this.eHo;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.eHR = aVar.aKU();
            this.eHS = aVar.aKV();
            this.eHP = aVar;
            this.eHQ = z;
            if (aVar.getGroup() != null) {
                eHT = aVar.getGroup().getGroupId();
            }
            if (aVar.aKP() != null) {
                eHU = aVar.aKP().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eHw.setVisibility(0);
            this.eHr.setVisibility(0);
            if (aVar.getGroup() != null) {
                nz(aVar.getGroup().getName());
                this.eGY.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eHl.setVisibility(0);
                } else {
                    this.eHl.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eHB.setVisibility(0);
                    this.eHh.setVisibility(8);
                    this.eHI.setVisibility(8);
                    this.eHJ.setVisibility(8);
                    this.eFP.setText(d.j.group_info_forum_author);
                    this.eHe.setEnabled(false);
                    this.eHl.setVisibility(8);
                } else {
                    this.eHB.setVisibility(8);
                    this.eHh.setVisibility(0);
                    this.eHI.setVisibility(0);
                    this.eHJ.setVisibility(0);
                    this.eFP.setText(aVar.getGroup().getAuthorName());
                    this.eHe.setEnabled(true);
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
                this.eHA = stringBuffer.toString();
                this.eGZ.setText(this.eHA);
                this.eHa.setText(aVar.getGroup().getIntro());
                this.eHi.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eHh.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eHc.setVisibility(0);
                    this.eHb.setText(aVar.getGroup().getForumName() + this.eGS.getPageContext().getString(d.j.forum));
                } else {
                    this.eHc.setVisibility(8);
                }
                this.eHg.removeAllViews();
                boolean aKW = aVar.aKW();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    aj.e(this.eHO, d.C0141d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eGS.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            aj.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            aj.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.eHg.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eGS.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        aj.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        aj.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.eHg.addView(imageView2);
                }
                if (aKW) {
                    this.eHL.setVisibility(0);
                } else {
                    this.eHL.setVisibility(8);
                }
            }
            if (aVar.aKP() != null) {
                this.eGV.setVisibility(0);
                this.eGT.setVisibility(0);
                GroupActivityData aKP = aVar.aKP();
                if (!aVar.aKU()) {
                    if (aKP.getIsEnd() != 1) {
                        this.eGW.setVisibility(4);
                        this.eGX.setText(d.j.group_info_activity_not_join_tip);
                    } else {
                        this.eGV.setVisibility(8);
                        this.eGT.setVisibility(8);
                    }
                } else {
                    this.eGW.setVisibility(0);
                    this.eGX.setText(aKP.getgActivityTitle());
                    if (aKP.getIsEnd() != 1) {
                        this.eGW.setText(d.j.group_info_activity_doing);
                        aj.e(this.eGW, d.C0141d.common_color_10171, 1);
                    } else {
                        this.eGW.setText(d.j.group_activity_end);
                        aj.e(this.eGW, d.C0141d.common_color_10168, 1);
                    }
                    this.eGX.setText(aKP.getgActivityTitle());
                }
            } else if (aVar.aKV()) {
                this.eGV.setVisibility(0);
                this.eGT.setVisibility(0);
                this.eGW.setVisibility(4);
                this.eGX.setText(d.j.group_info_create_activity);
            } else {
                this.eGV.setVisibility(8);
                this.eGT.setVisibility(8);
            }
            this.eHp.removeAllViews();
            if (aVar.aKQ() != null && aVar.aKQ().size() > 0) {
                List<MemberData> aKQ = aVar.aKQ();
                int size = aKQ.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aKQ.get(i3);
                    HeadImageView headImageView = this.eHq[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eGS.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eHq[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.eHp.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aKV()) {
                this.eHo.setEnabled(true);
                this.eHF.setEnabled(true);
                aj.s(this.eHF, d.f.group_info_item);
                this.eHC.setVisibility(0);
                this.eHH.setVisibility(0);
                this.eHE.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eHD.setText(aVar.getGroup().getName());
                }
            } else {
                this.eHo.setEnabled(false);
                this.eHF.setEnabled(true);
                aj.t(this.eHF, d.C0141d.cp_bg_line_d);
                this.eHE.setVisibility(8);
                this.eHH.setVisibility(8);
                this.eHa.setPadding(0, 0, 0, 0);
            }
            if (aVar.aKU()) {
                this.eHu.setVisibility(0);
                this.eHN.setVisibility(0);
                if (this.eHj.getParent() != this.eHu) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.eHw.removeView(this.eHj);
                    this.eHu.addView(this.eHj, 1);
                }
                aKj();
            } else {
                this.eHu.setVisibility(8);
                this.eHN.setVisibility(8);
                if (this.eHj.getParent() != this.eHw) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.eHu.removeView(this.eHj);
                    this.eHw.addView(this.eHj, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eHf.setVisibility(8);
            } else {
                this.eHf.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hG(aVar.aKV());
            } else {
                g(aVar.aKV(), this.eHA);
            }
            this.dCy.setVisibility(0);
            this.eHr.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qj(aVar.getGroup().getFlag())) {
                hH(z);
            } else {
                aKk();
            }
        }
    }

    public void aKj() {
        this.eHs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        aj.e(this.eHs, d.C0141d.cp_cont_i, 1);
        this.eHs.setText(this.eGS.getPageContext().getString(d.j.i_want_talk));
        this.eHM.setEnabled(true);
    }

    private void hH(boolean z) {
        this.eHs.setText(this.eGS.getPageContext().getString(d.j.i_want_attent));
        if (z) {
            this.eHs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHs, d.C0141d.cp_cont_i, 1);
        } else {
            this.eHs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            aj.e(this.eHs, d.C0141d.cp_cont_i, 1);
        }
        aj.s(this.eHM, d.f.btn_blue_bg);
        this.eHM.setEnabled(true);
    }

    private boolean qj(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aKk() {
        this.eHs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eHs.setText(this.eGS.getPageContext().getString(d.j.group_info_refuse_join));
        this.eHs.setTextColor(this.eGS.getResources().getColorStateList(d.C0141d.cp_cont_i));
        aj.s(this.eHM, d.f.btn_app_download_d);
        this.eHM.setEnabled(false);
    }

    public void nB(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eHp.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eHp.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eHp.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eHd.setIsManager(aVar.aKV());
            if (aVar.aKV()) {
                this.eHd.setVisibility(0);
                if (aVar.aKR() != null && aVar.aKR().size() == 1 && TextUtils.isEmpty(aVar.aKR().get(0).getPicId())) {
                    this.eHd.setData(null);
                } else {
                    this.eHd.setData(aVar.aKR());
                }
            } else if (aVar.aKR() != null && aVar.aKR().size() > 0) {
                if (aVar.aKR().size() == 1 && TextUtils.isEmpty(aVar.aKR().get(0).getPicId())) {
                    this.eHd.setVisibility(8);
                    return;
                }
                this.eHd.setVisibility(0);
                this.eHd.setData(aVar.aKR());
            } else {
                this.eHd.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eHy = bVar;
    }

    public void j(Object obj, int i) {
        if (this.eHx != null) {
            this.eHx.dismiss();
            this.eHx = null;
        }
        k(obj, i);
        this.eHx.AX();
    }

    public void aKl() {
        this.eHx.dismiss();
    }

    private void k(final Object obj, final int i) {
        if (this.eHx == null) {
            this.eHx = new com.baidu.tbadk.core.dialog.b(this.eGS.getPageContext().getPageActivity());
            this.eHx.dl(this.eGS.getResources().getString(d.j.operation));
            this.eHx.a(new String[]{this.eGS.getResources().getString(d.j.group_info_set_portrait), this.eGS.getResources().getString(d.j.delete), this.eGS.getResources().getString(d.j.cancel)}, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eHy.a(bVar, i2, obj, i);
                }
            });
        }
        this.eHx.d(this.eGS.getPageContext());
    }

    public void onDestory() {
        if (this.eHd != null) {
            this.eHd.onDestory();
        }
        if (this.eHh != null) {
            this.eHh.stopLoad();
            this.eHh.setBackgroundDrawable(null);
            this.eHh.setImageDrawable(null);
        }
        if (this.eHp != null && this.eHq != null) {
            int length = this.eHq.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eHq[i];
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
            CharSequence[] charSequenceArr = {this.eGS.getPageContext().getString(d.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eGS.getPageContext().getPageActivity());
            bVar.dl(this.eGS.getPageContext().getString(d.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eGS.getSystemService("clipboard")).setText(str);
                        a.this.eGS.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eGS.getPageContext());
            bVar.AX();
        }
    }

    public void nD(String str) {
        if (this.eHv == null) {
            nE(str);
        }
        this.eHv.AX();
    }

    private void nE(final String str) {
        if (this.eHv == null) {
            this.eHv = new com.baidu.tbadk.core.dialog.b(this.eGS.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eGS.getPageContext().getString(d.j.copy_group_number)};
            this.eHv.dl(this.eGS.getPageContext().getString(d.j.operation));
            this.eHv.a(charSequenceArr, new b.InterfaceC0097b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0097b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eGS.getSystemService("clipboard")).setText(str);
                        a.this.eGS.showToast(d.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eHv.d(this.eGS.getPageContext());
        }
    }

    public void aKm() {
        ColorStateList fN = aj.fN(d.C0141d.cp_cont_i);
        if (fN != null) {
            this.eHs.setCompoundDrawablesWithIntrinsicBounds(aj.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eHs.setTextColor(fN);
    }

    public void changeSkinType(int i) {
        this.eGS.getLayoutMode().aQ(i == 1);
        this.eGS.getLayoutMode().aM(this.bRR);
        this.eGS.getLayoutMode().aM(this.eHm);
        this.eHd.a(i, this.eGS);
        this.mNavigationBar.onChangeSkinType(this.eGS.getPageContext(), i);
        if (this.isMemGroup) {
            aj.e(this.eHO, d.C0141d.common_color_10009, 1);
        }
        if (!this.eHR) {
            b(this.eHP, this.eHQ);
        }
        if (this.eHS) {
            aj.s(this.eHF, d.f.group_info_item);
        } else {
            aj.t(this.eHF, d.C0141d.cp_bg_line_d);
        }
    }

    public void hI(boolean z) {
        this.eHR = z;
    }
}
