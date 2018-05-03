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
    private View cNI;
    private ScrollView cVk;
    private View dQr;
    private TextView eaH;
    private final GroupInfoActivity ebL;
    private View ebM;
    private ProgressBar ebN;
    private RelativeLayout ebO;
    private TextView ebP;
    private TextView ebQ;
    private TextView ebR;
    private TextView ebS;
    private EllipsizingTextView ebT;
    private TextView ebU;
    private RelativeLayout ebV;
    private PhotoWallView ebW;
    private RelativeLayout ebX;
    private RelativeLayout ebY;
    private LinearLayout ebZ;
    private ImageView ecA;
    private ImageView ecB;
    private View ecC;
    private TextView ecD;
    private TextView ecE;
    private LinearLayout ecF;
    private View ecG;
    private TextView ecH;
    private ResponseGroupInfoLocalMessage.a ecI;
    private boolean ecJ;
    private boolean ecK;
    private boolean ecL;
    private HeadImageView eca;
    private TextView ecb;
    private RelativeLayout ecc;
    private com.baidu.tbadk.core.dialog.b ecd;
    private ImageView ece;
    private final View ecf;
    private b.InterfaceC0086b ecg;
    private RelativeLayout ech;
    private LinearLayout eci;
    private HeadImageView[] ecj;
    private LinearLayout eck;
    private TextView ecl;
    private RelativeLayout ecm;
    private LinearLayout ecn;
    private com.baidu.tbadk.core.dialog.b eco;
    private LinearLayout ecp;
    private com.baidu.tbadk.core.dialog.b ecq;
    private b ecr;
    private TextView ecs;
    private String ect;
    private ImageView ecu;
    private RelativeLayout ecv;
    private TextView ecw;
    private ImageView ecx;
    private RelativeLayout ecy;
    private RelativeLayout ecz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int ecM = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.ecd = null;
        this.ecg = null;
        this.ecj = new HeadImageView[5];
        this.ect = "";
        this.ecJ = true;
        this.isMemGroup = false;
        this.ecK = false;
        this.ecL = false;
        this.ebL = groupInfoActivity;
        groupInfoActivity.setContentView(d.i.im_group_info_activity);
        this.ecf = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.i.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cVk.setVisibility(4);
        this.eck.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.ecw.setText(str);
        nD(str);
    }

    private void nD(String str) {
        if (str != null) {
            this.ecH.setText(str);
        }
    }

    public void nE(String str) {
        this.ebT.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.dQr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ecH = this.mNavigationBar.setTitleText("");
        this.ecG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.ecs = (TextView) this.ecG.findViewById(d.g.right_textview);
        this.ecs.setText(groupInfoActivity.getPageContext().getString(d.k.setup));
        ak.c(this.ecs, d.C0126d.cp_cont_f, 1);
        this.ecs.setOnClickListener(groupInfoActivity);
        this.ecG.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.ebM = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.bbY = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.cVk = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.cVk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.cNI = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cNI.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ebO = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.ebO.setOnClickListener(groupInfoActivity);
        this.ebP = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.ebQ = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.ech = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.ech.setOnClickListener(groupInfoActivity);
        this.ecp = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.ecu = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.ebR = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.ebS = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.ecA = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.ebT = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.ebT.setMaxLines(20);
        this.ebT.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gl(boolean z) {
                if (z) {
                    a.this.ecD.setVisibility(0);
                } else {
                    a.this.ecD.setVisibility(8);
                }
            }
        });
        this.ebV = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.ebU = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.ebV.setOnClickListener(groupInfoActivity);
        this.eca = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.eca.setAutoChangeStyle(true);
        this.eca.setIsRound(false);
        this.eaH = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.ebX = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.ebX.setOnClickListener(groupInfoActivity);
        this.ece = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.ecC = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.ebZ = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.ebV.setOnClickListener(groupInfoActivity);
        this.ebY = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.ebY.setOnClickListener(groupInfoActivity);
        this.ecb = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.ecc = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.ecc.setOnClickListener(groupInfoActivity);
        this.eci = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.eck = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.ecF = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.ecl = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.ecF.setOnClickListener(this.ebL);
        this.ecm = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.ecm.setOnClickListener(groupInfoActivity);
        this.ecn = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.ecv = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.ecv.setOnClickListener(groupInfoActivity);
        this.ecw = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.ecx = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.ecB = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.ecy = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.ecy.setOnClickListener(groupInfoActivity);
        this.ecy.setLongClickable(true);
        this.ecy.setOnLongClickListener(groupInfoActivity);
        this.ecD = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.ecD.setClickable(true);
        this.ecD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                a.this.ebT.setMaxLines(1000);
            }
        });
        this.ecz = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.ecz.setOnLongClickListener(groupInfoActivity);
        this.ecE = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.ebN = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.ebW = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.ebW.setPhotoClickListener(groupInfoActivity);
        this.ebW.setPhotoLongClickListener(groupInfoActivity);
        this.ebW.setVisibility(8);
    }

    public RelativeLayout aES() {
        return this.ecz;
    }

    public RelativeLayout aET() {
        return this.ebV;
    }

    public LinearLayout aEU() {
        return this.eci;
    }

    public RelativeLayout aEV() {
        return this.ecm;
    }

    public RelativeLayout aEW() {
        return this.ecy;
    }

    public RelativeLayout aEX() {
        return this.ecv;
    }

    public RelativeLayout aEY() {
        return this.ebO;
    }

    public View aEZ() {
        return this.ecs;
    }

    public LinearLayout aFa() {
        return this.ecF;
    }

    public RelativeLayout aFb() {
        return this.ebX;
    }

    public RelativeLayout aFc() {
        return this.ebY;
    }

    public RelativeLayout aFd() {
        return this.ecc;
    }

    public View aDN() {
        return this.dQr;
    }

    public void aFe() {
        this.ebN.setVisibility(8);
    }

    public void aFf() {
        this.ebN.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.ebS.setText(str);
            this.ech.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.ech.setVisibility(8);
        } else {
            this.ebS.setText(str);
            this.ech.setVisibility(0);
        }
    }

    public void hl(boolean z) {
        if (z) {
            this.ebS.setText(this.mContext.getString(d.k.live_card_hide));
        } else {
            this.ech.setVisibility(8);
        }
    }

    public RelativeLayout aFg() {
        return this.ech;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.ecK = aVar.aFS();
            this.ecL = aVar.aFT();
            this.ecI = aVar;
            this.ecJ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aFN() != null) {
                ecM = aVar.aFN().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.ecp.setVisibility(0);
            this.eck.setVisibility(0);
            if (aVar.getGroup() != null) {
                nD(aVar.getGroup().getName());
                this.ebR.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.ece.setVisibility(0);
                } else {
                    this.ece.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.ecu.setVisibility(0);
                    this.eca.setVisibility(8);
                    this.ecB.setVisibility(8);
                    this.ecC.setVisibility(8);
                    this.eaH.setText(d.k.group_info_forum_author);
                    this.ebX.setEnabled(false);
                    this.ece.setVisibility(8);
                } else {
                    this.ecu.setVisibility(8);
                    this.eca.setVisibility(0);
                    this.ecB.setVisibility(0);
                    this.ecC.setVisibility(0);
                    this.eaH.setText(aVar.getGroup().getAuthorName());
                    this.ebX.setEnabled(true);
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
                this.ect = stringBuffer.toString();
                this.ebS.setText(this.ect);
                this.ebT.setText(aVar.getGroup().getIntro());
                this.ecb.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eca.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.ebV.setVisibility(0);
                    this.ebU.setText(aVar.getGroup().getForumName() + this.ebL.getPageContext().getString(d.k.forum));
                } else {
                    this.ebV.setVisibility(8);
                }
                this.ebZ.removeAllViews();
                boolean aFU = aVar.aFU();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ak.c(this.ecH, d.C0126d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.ebL.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ak.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            ak.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.ebZ.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.ebL.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ak.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        ak.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.ebZ.addView(imageView2);
                }
                if (aFU) {
                    this.ecE.setVisibility(0);
                } else {
                    this.ecE.setVisibility(8);
                }
            }
            if (aVar.aFN() != null) {
                this.ebO.setVisibility(0);
                this.ebM.setVisibility(0);
                GroupActivityData aFN = aVar.aFN();
                if (!aVar.aFS()) {
                    if (aFN.getIsEnd() != 1) {
                        this.ebP.setVisibility(4);
                        this.ebQ.setText(d.k.group_info_activity_not_join_tip);
                    } else {
                        this.ebO.setVisibility(8);
                        this.ebM.setVisibility(8);
                    }
                } else {
                    this.ebP.setVisibility(0);
                    this.ebQ.setText(aFN.getgActivityTitle());
                    if (aFN.getIsEnd() != 1) {
                        this.ebP.setText(d.k.group_info_activity_doing);
                        ak.c(this.ebP, d.C0126d.common_color_10171, 1);
                    } else {
                        this.ebP.setText(d.k.group_activity_end);
                        ak.c(this.ebP, d.C0126d.common_color_10168, 1);
                    }
                    this.ebQ.setText(aFN.getgActivityTitle());
                }
            } else if (aVar.aFT()) {
                this.ebO.setVisibility(0);
                this.ebM.setVisibility(0);
                this.ebP.setVisibility(4);
                this.ebQ.setText(d.k.group_info_create_activity);
            } else {
                this.ebO.setVisibility(8);
                this.ebM.setVisibility(8);
            }
            this.eci.removeAllViews();
            if (aVar.aFO() != null && aVar.aFO().size() > 0) {
                List<MemberData> aFO = aVar.aFO();
                int size = aFO.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aFO.get(i3);
                    HeadImageView headImageView = this.ecj[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.ebL.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.ecj[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.eci.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aFT()) {
                this.ech.setEnabled(true);
                this.ecy.setEnabled(true);
                ak.i(this.ecy, d.f.group_info_item);
                this.ecv.setVisibility(0);
                this.ecA.setVisibility(0);
                this.ecx.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.ecw.setText(aVar.getGroup().getName());
                }
            } else {
                this.ech.setEnabled(false);
                this.ecy.setEnabled(true);
                ak.j(this.ecy, d.C0126d.cp_bg_line_d);
                this.ecx.setVisibility(8);
                this.ecA.setVisibility(8);
                this.ebT.setPadding(0, 0, 0, 0);
            }
            if (aVar.aFS()) {
                this.ecn.setVisibility(0);
                this.ecG.setVisibility(0);
                if (this.ecc.getParent() != this.ecn) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.ecp.removeView(this.ecc);
                    this.ecn.addView(this.ecc, 1);
                }
                aFh();
            } else {
                this.ecn.setVisibility(8);
                this.ecG.setVisibility(8);
                if (this.ecc.getParent() != this.ecp) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.ecn.removeView(this.ecc);
                    this.ecp.addView(this.ecc, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.ebY.setVisibility(8);
            } else {
                this.ebY.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hl(aVar.aFT());
            } else {
                i(aVar.aFT(), this.ect);
            }
            this.cVk.setVisibility(0);
            this.eck.setVisibility(0);
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
        this.ecl.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ak.c(this.ecl, d.C0126d.cp_cont_i, 1);
        this.ecl.setText(this.ebL.getPageContext().getString(d.k.i_want_talk));
        this.ecF.setEnabled(true);
    }

    private void hm(boolean z) {
        this.ecl.setText(this.ebL.getPageContext().getString(d.k.i_want_attent));
        if (z) {
            this.ecl.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.ecl, d.C0126d.cp_cont_i, 1);
        } else {
            this.ecl.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ak.c(this.ecl, d.C0126d.cp_cont_i, 1);
        }
        ak.i(this.ecF, d.f.btn_blue_bg);
        this.ecF.setEnabled(true);
    }

    private boolean nH(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aFi() {
        this.ecl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.ecl.setText(this.ebL.getPageContext().getString(d.k.group_info_refuse_join));
        this.ecl.setTextColor(this.ebL.getResources().getColorStateList(d.C0126d.cp_cont_i));
        ak.i(this.ecF, d.f.btn_app_download_d);
        this.ecF.setEnabled(false);
    }

    public void nF(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eci.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eci.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eci.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.ebW.setIsManager(aVar.aFT());
            if (aVar.aFT()) {
                this.ebW.setVisibility(0);
                if (aVar.aFP() != null && aVar.aFP().size() == 1 && TextUtils.isEmpty(aVar.aFP().get(0).getPicId())) {
                    this.ebW.setData(null);
                } else {
                    this.ebW.setData(aVar.aFP());
                }
            } else if (aVar.aFP() != null && aVar.aFP().size() > 0) {
                if (aVar.aFP().size() == 1 && TextUtils.isEmpty(aVar.aFP().get(0).getPicId())) {
                    this.ebW.setVisibility(8);
                    return;
                }
                this.ebW.setVisibility(0);
                this.ebW.setData(aVar.aFP());
            } else {
                this.ebW.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.ecr = bVar;
    }

    public void d(Object obj, int i) {
        if (this.ecq != null) {
            this.ecq.dismiss();
            this.ecq = null;
        }
        e(obj, i);
        this.ecq.tG();
    }

    public void aFj() {
        this.ecq.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.ecq == null) {
            this.ecq = new com.baidu.tbadk.core.dialog.b(this.ebL.getPageContext().getPageActivity());
            this.ecq.dd(this.ebL.getResources().getString(d.k.operation));
            this.ecq.a(new String[]{this.ebL.getResources().getString(d.k.group_info_set_portrait), this.ebL.getResources().getString(d.k.delete), this.ebL.getResources().getString(d.k.cancel)}, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view2) {
                    a.this.ecr.a(bVar, i2, obj, i);
                }
            });
        }
        this.ecq.d(this.ebL.getPageContext());
    }

    public void onDestory() {
        if (this.ebW != null) {
            this.ebW.onDestory();
        }
        if (this.eca != null) {
            this.eca.stopLoad();
            this.eca.setBackgroundDrawable(null);
            this.eca.setImageDrawable(null);
        }
        if (this.eci != null && this.ecj != null) {
            int length = this.ecj.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.ecj[i];
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
            CharSequence[] charSequenceArr = {this.ebL.getPageContext().getString(d.k.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.ebL.getPageContext().getPageActivity());
            bVar.dd(this.ebL.getPageContext().getString(d.k.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view2) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.ebL.getSystemService("clipboard")).setText(str);
                        a.this.ebL.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.ebL.getPageContext());
            bVar.tG();
        }
    }

    public void nH(String str) {
        if (this.eco == null) {
            nI(str);
        }
        this.eco.tG();
    }

    private void nI(final String str) {
        if (this.eco == null) {
            this.eco = new com.baidu.tbadk.core.dialog.b(this.ebL.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.ebL.getPageContext().getString(d.k.copy_group_number)};
            this.eco.dd(this.ebL.getPageContext().getString(d.k.operation));
            this.eco.a(charSequenceArr, new b.InterfaceC0086b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0086b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view2) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.ebL.getSystemService("clipboard")).setText(str);
                        a.this.ebL.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eco.d(this.ebL.getPageContext());
        }
    }

    public void aFk() {
        ColorStateList cM = ak.cM(d.C0126d.cp_cont_i);
        if (cM != null) {
            this.ecl.setCompoundDrawablesWithIntrinsicBounds(ak.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.ecl.setTextColor(cM);
    }

    public void changeSkinType(int i) {
        this.ebL.getLayoutMode().setNightMode(i == 1);
        this.ebL.getLayoutMode().u(this.bbY);
        this.ebL.getLayoutMode().u(this.ecf);
        this.ebW.a(i, this.ebL);
        this.mNavigationBar.onChangeSkinType(this.ebL.getPageContext(), i);
        if (this.isMemGroup) {
            ak.c(this.ecH, d.C0126d.common_color_10009, 1);
        }
        if (!this.ecK) {
            b(this.ecI, this.ecJ);
        }
        if (this.ecL) {
            ak.i(this.ecy, d.f.group_info_item);
        } else {
            ak.j(this.ecy, d.C0126d.cp_bg_line_d);
        }
    }

    public void hn(boolean z) {
        this.ecK = z;
    }
}
