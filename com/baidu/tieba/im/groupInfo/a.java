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
import com.baidu.tbadk.core.util.ak;
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
    private RelativeLayout bbY;
    private View cNL;
    private ScrollView cVn;
    private View dQu;
    private TextView eaK;
    private final GroupInfoActivity ebO;
    private View ebP;
    private ProgressBar ebQ;
    private RelativeLayout ebR;
    private TextView ebS;
    private TextView ebT;
    private TextView ebU;
    private TextView ebV;
    private EllipsizingTextView ebW;
    private TextView ebX;
    private RelativeLayout ebY;
    private PhotoWallView ebZ;
    private ImageView ecA;
    private RelativeLayout ecB;
    private RelativeLayout ecC;
    private ImageView ecD;
    private ImageView ecE;
    private View ecF;
    private TextView ecG;
    private TextView ecH;
    private LinearLayout ecI;
    private View ecJ;
    private TextView ecK;
    private ResponseGroupInfoLocalMessage.a ecL;
    private boolean ecM;
    private boolean ecN;
    private boolean ecO;
    private RelativeLayout eca;
    private RelativeLayout ecb;
    private LinearLayout ecc;
    private HeadImageView ecd;
    private TextView ece;
    private RelativeLayout ecf;
    private com.baidu.tbadk.core.dialog.b ecg;
    private ImageView ech;
    private final View eci;
    private b.InterfaceC0086b ecj;
    private RelativeLayout eck;
    private LinearLayout ecl;
    private HeadImageView[] ecm;
    private LinearLayout ecn;
    private TextView eco;
    private RelativeLayout ecp;
    private LinearLayout ecq;
    private com.baidu.tbadk.core.dialog.b ecr;
    private LinearLayout ecs;
    private com.baidu.tbadk.core.dialog.b ect;
    private b ecu;
    private TextView ecv;
    private String ecw;
    private ImageView ecx;
    private RelativeLayout ecy;
    private TextView ecz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int ecP = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ecg = null;
        this.ecj = null;
        this.ecm = new HeadImageView[5];
        this.ecw = "";
        this.ecM = true;
        this.isMemGroup = false;
        this.ecN = false;
        this.ecO = false;
        this.ebO = groupInfoActivity;
        groupInfoActivity.setContentView(d.i.im_group_info_activity);
        this.eci = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.i.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cVn.setVisibility(4);
        this.ecn.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ecz.setText(str);
        nD(str);
    }

    private void nD(String str) {
        if (str != null) {
            this.ecK.setText(str);
        }
    }

    public void nE(String str) {
        this.ebW.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.dQu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecK = this.mNavigationBar.setTitleText("");
        this.ecJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.ecv = (TextView) this.ecJ.findViewById(d.g.right_textview);
        this.ecv.setText(groupInfoActivity.getPageContext().getString(d.k.setup));
        ak.c(this.ecv, d.C0126d.cp_cont_f, 1);
        this.ecv.setOnClickListener(groupInfoActivity);
        this.ecJ.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.ebP = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bbY = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.cVn = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.cVn.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
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
        this.cNL = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cNL.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ebR = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.ebR.setOnClickListener(groupInfoActivity);
        this.ebS = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.ebT = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.eck = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.eck.setOnClickListener(groupInfoActivity);
        this.ecs = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.ecx = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.ebU = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.ebV = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.ecD = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.ebW = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.ebW.setMaxLines(20);
        this.ebW.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gl(boolean z) {
                if (z) {
                    a.this.ecG.setVisibility(0);
                } else {
                    a.this.ecG.setVisibility(8);
                }
            }
        });
        this.ebY = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.ebX = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.ebY.setOnClickListener(groupInfoActivity);
        this.ecd = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.ecd.setAutoChangeStyle(true);
        this.ecd.setIsRound(false);
        this.eaK = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.eca = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.eca.setOnClickListener(groupInfoActivity);
        this.ech = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.ecF = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.ecc = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.ebY.setOnClickListener(groupInfoActivity);
        this.ecb = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.ecb.setOnClickListener(groupInfoActivity);
        this.ece = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.ecf = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.ecf.setOnClickListener(groupInfoActivity);
        this.ecl = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.ecn = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.ecI = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.eco = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.ecI.setOnClickListener(this.ebO);
        this.ecp = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.ecp.setOnClickListener(groupInfoActivity);
        this.ecq = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.ecy = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.ecy.setOnClickListener(groupInfoActivity);
        this.ecz = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.ecA = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.ecE = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.ecB = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.ecB.setOnClickListener(groupInfoActivity);
        this.ecB.setLongClickable(true);
        this.ecB.setOnLongClickListener(groupInfoActivity);
        this.ecG = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.ecG.setClickable(true);
        this.ecG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ebW.setMaxLines(1000);
            }
        });
        this.ecC = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.ecC.setOnLongClickListener(groupInfoActivity);
        this.ecH = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.ebQ = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ebZ = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.ebZ.setPhotoClickListener(groupInfoActivity);
        this.ebZ.setPhotoLongClickListener(groupInfoActivity);
        this.ebZ.setVisibility(8);
    }

    public RelativeLayout aES() {
        return this.ecC;
    }

    public RelativeLayout aET() {
        return this.ebY;
    }

    public LinearLayout aEU() {
        return this.ecl;
    }

    public RelativeLayout aEV() {
        return this.ecp;
    }

    public RelativeLayout aEW() {
        return this.ecB;
    }

    public RelativeLayout aEX() {
        return this.ecy;
    }

    public RelativeLayout aEY() {
        return this.ebR;
    }

    public View aEZ() {
        return this.ecv;
    }

    public LinearLayout aFa() {
        return this.ecI;
    }

    public RelativeLayout aFb() {
        return this.eca;
    }

    public RelativeLayout aFc() {
        return this.ecb;
    }

    public RelativeLayout aFd() {
        return this.ecf;
    }

    public View aDN() {
        return this.dQu;
    }

    public void aFe() {
        this.ebQ.setVisibility(8);
    }

    public void aFf() {
        this.ebQ.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.ebV.setText(str);
            this.eck.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eck.setVisibility(8);
        } else {
            this.ebV.setText(str);
            this.eck.setVisibility(0);
        }
    }

    public void hl(boolean z) {
        if (z) {
            this.ebV.setText(this.mContext.getString(d.k.live_card_hide));
        } else {
            this.eck.setVisibility(8);
        }
    }

    public RelativeLayout aFg() {
        return this.eck;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.ecN = aVar.aFS();
            this.ecO = aVar.aFT();
            this.ecL = aVar;
            this.ecM = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aFN() != null) {
                ecP = aVar.aFN().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ecs.setVisibility(0);
            this.ecn.setVisibility(0);
            if (aVar.getGroup() != null) {
                nD(aVar.getGroup().getName());
                this.ebU.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ech.setVisibility(0);
                } else {
                    this.ech.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ecx.setVisibility(0);
                    this.ecd.setVisibility(8);
                    this.ecE.setVisibility(8);
                    this.ecF.setVisibility(8);
                    this.eaK.setText(d.k.group_info_forum_author);
                    this.eca.setEnabled(false);
                    this.ech.setVisibility(8);
                } else {
                    this.ecx.setVisibility(8);
                    this.ecd.setVisibility(0);
                    this.ecE.setVisibility(0);
                    this.ecF.setVisibility(0);
                    this.eaK.setText(aVar.getGroup().getAuthorName());
                    this.eca.setEnabled(true);
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
                this.ecw = stringBuffer.toString();
                this.ebV.setText(this.ecw);
                this.ebW.setText(aVar.getGroup().getIntro());
                this.ece.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.ecd.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.ebY.setVisibility(0);
                    this.ebX.setText(aVar.getGroup().getForumName() + this.ebO.getPageContext().getString(d.k.forum));
                } else {
                    this.ebY.setVisibility(8);
                }
                this.ecc.removeAllViews();
                boolean aFU = aVar.aFU();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ak.c(this.ecK, d.C0126d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.ebO.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ak.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            ak.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.ecc.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.ebO.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ak.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        ak.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.ecc.addView(imageView2);
                }
                if (aFU) {
                    this.ecH.setVisibility(0);
                } else {
                    this.ecH.setVisibility(8);
                }
            }
            if (aVar.aFN() != null) {
                this.ebR.setVisibility(0);
                this.ebP.setVisibility(0);
                GroupActivityData aFN = aVar.aFN();
                if (!aVar.aFS()) {
                    if (aFN.getIsEnd() != 1) {
                        this.ebS.setVisibility(4);
                        this.ebT.setText(d.k.group_info_activity_not_join_tip);
                    } else {
                        this.ebR.setVisibility(8);
                        this.ebP.setVisibility(8);
                    }
                } else {
                    this.ebS.setVisibility(0);
                    this.ebT.setText(aFN.getgActivityTitle());
                    if (aFN.getIsEnd() != 1) {
                        this.ebS.setText(d.k.group_info_activity_doing);
                        ak.c(this.ebS, d.C0126d.common_color_10171, 1);
                    } else {
                        this.ebS.setText(d.k.group_activity_end);
                        ak.c(this.ebS, d.C0126d.common_color_10168, 1);
                    }
                    this.ebT.setText(aFN.getgActivityTitle());
                }
            } else if (aVar.aFT()) {
                this.ebR.setVisibility(0);
                this.ebP.setVisibility(0);
                this.ebS.setVisibility(4);
                this.ebT.setText(d.k.group_info_create_activity);
            } else {
                this.ebR.setVisibility(8);
                this.ebP.setVisibility(8);
            }
            this.ecl.removeAllViews();
            if (aVar.aFO() != null && aVar.aFO().size() > 0) {
                List<MemberData> aFO = aVar.aFO();
                int size = aFO.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aFO.get(i3);
                    HeadImageView headImageView = this.ecm[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.ebO.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ecm[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.ecl.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aFT()) {
                this.eck.setEnabled(true);
                this.ecB.setEnabled(true);
                ak.i(this.ecB, d.f.group_info_item);
                this.ecy.setVisibility(0);
                this.ecD.setVisibility(0);
                this.ecA.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ecz.setText(aVar.getGroup().getName());
                }
            } else {
                this.eck.setEnabled(false);
                this.ecB.setEnabled(true);
                ak.j(this.ecB, d.C0126d.cp_bg_line_d);
                this.ecA.setVisibility(8);
                this.ecD.setVisibility(8);
                this.ebW.setPadding(0, 0, 0, 0);
            }
            if (aVar.aFS()) {
                this.ecq.setVisibility(0);
                this.ecJ.setVisibility(0);
                if (this.ecf.getParent() != this.ecq) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.ecs.removeView(this.ecf);
                    this.ecq.addView(this.ecf, 1);
                }
                aFh();
            } else {
                this.ecq.setVisibility(8);
                this.ecJ.setVisibility(8);
                if (this.ecf.getParent() != this.ecs) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.ecq.removeView(this.ecf);
                    this.ecs.addView(this.ecf, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ecb.setVisibility(8);
            } else {
                this.ecb.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hl(aVar.aFT());
            } else {
                i(aVar.aFT(), this.ecw);
            }
            this.cVn.setVisibility(0);
            this.ecn.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (nH(aVar.getGroup().getFlag())) {
                hm(z);
            } else {
                aFi();
            }
        }
    }

    public void aFh() {
        this.eco.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.c(this.eco, d.C0126d.cp_cont_i, 1);
        this.eco.setText(this.ebO.getPageContext().getString(d.k.i_want_talk));
        this.ecI.setEnabled(true);
    }

    private void hm(boolean z) {
        this.eco.setText(this.ebO.getPageContext().getString(d.k.i_want_attent));
        if (z) {
            this.eco.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.eco, d.C0126d.cp_cont_i, 1);
        } else {
            this.eco.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.eco, d.C0126d.cp_cont_i, 1);
        }
        ak.i(this.ecI, d.f.btn_blue_bg);
        this.ecI.setEnabled(true);
    }

    private boolean nH(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aFi() {
        this.eco.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eco.setText(this.ebO.getPageContext().getString(d.k.group_info_refuse_join));
        this.eco.setTextColor(this.ebO.getResources().getColorStateList(d.C0126d.cp_cont_i));
        ak.i(this.ecI, d.f.btn_app_download_d);
        this.ecI.setEnabled(false);
    }

    public void nF(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.ecl.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.ecl.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.ecl.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ebZ.setIsManager(aVar.aFT());
            if (aVar.aFT()) {
                this.ebZ.setVisibility(0);
                if (aVar.aFP() != null && aVar.aFP().size() == 1 && TextUtils.isEmpty(aVar.aFP().get(0).getPicId())) {
                    this.ebZ.setData(null);
                } else {
                    this.ebZ.setData(aVar.aFP());
                }
            } else if (aVar.aFP() != null && aVar.aFP().size() > 0) {
                if (aVar.aFP().size() == 1 && TextUtils.isEmpty(aVar.aFP().get(0).getPicId())) {
                    this.ebZ.setVisibility(8);
                    return;
                }
                this.ebZ.setVisibility(0);
                this.ebZ.setData(aVar.aFP());
            } else {
                this.ebZ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ecu = bVar;
    }

    public void d(Object obj, int i) {
        if (this.ect != null) {
            this.ect.dismiss();
            this.ect = null;
        }
        e(obj, i);
        this.ect.tG();
    }

    public void aFj() {
        this.ect.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.ect == null) {
            this.ect = new com.baidu.tbadk.core.dialog.b(this.ebO.getPageContext().getPageActivity());
            this.ect.dd(this.ebO.getResources().getString(d.k.operation));
            this.ect.a(new String[]{this.ebO.getResources().getString(d.k.group_info_set_portrait), this.ebO.getResources().getString(d.k.delete), this.ebO.getResources().getString(d.k.cancel)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                    a.this.ecu.a(bVar, i2, obj, i);
                }
            });
        }
        this.ect.d(this.ebO.getPageContext());
    }

    public void onDestory() {
        if (this.ebZ != null) {
            this.ebZ.onDestory();
        }
        if (this.ecd != null) {
            this.ecd.stopLoad();
            this.ecd.setBackgroundDrawable(null);
            this.ecd.setImageDrawable(null);
        }
        if (this.ecl != null && this.ecm != null) {
            int length = this.ecm.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ecm[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void nG(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.ebO.getPageContext().getString(d.k.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ebO.getPageContext().getPageActivity());
            bVar.dd(this.ebO.getPageContext().getString(d.k.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.ebO.getSystemService("clipboard")).setText(str);
                        a.this.ebO.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.ebO.getPageContext());
            bVar.tG();
        }
    }

    public void nH(String str) {
        if (this.ecr == null) {
            nI(str);
        }
        this.ecr.tG();
    }

    private void nI(final String str) {
        if (this.ecr == null) {
            this.ecr = new com.baidu.tbadk.core.dialog.b(this.ebO.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.ebO.getPageContext().getString(d.k.copy_group_number)};
            this.ecr.dd(this.ebO.getPageContext().getString(d.k.operation));
            this.ecr.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.ebO.getSystemService("clipboard")).setText(str);
                        a.this.ebO.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.ecr.d(this.ebO.getPageContext());
        }
    }

    public void aFk() {
        ColorStateList cM = ak.cM(d.C0126d.cp_cont_i);
        if (cM != null) {
            this.eco.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eco.setTextColor(cM);
    }

    public void changeSkinType(int i) {
        this.ebO.getLayoutMode().setNightMode(i == 1);
        this.ebO.getLayoutMode().u(this.bbY);
        this.ebO.getLayoutMode().u(this.eci);
        this.ebZ.a(i, this.ebO);
        this.mNavigationBar.onChangeSkinType(this.ebO.getPageContext(), i);
        if (this.isMemGroup) {
            ak.c(this.ecK, d.C0126d.common_color_10009, 1);
        }
        if (!this.ecN) {
            b(this.ecL, this.ecM);
        }
        if (this.ecO) {
            ak.i(this.ecB, d.f.group_info_item);
        } else {
            ak.j(this.ecB, d.C0126d.cp_bg_line_d);
        }
    }

    public void hn(boolean z) {
        this.ecN = z;
    }
}
