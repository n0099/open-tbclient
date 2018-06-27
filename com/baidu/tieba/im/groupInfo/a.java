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
import com.baidu.tbadk.core.util.am;
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
    private RelativeLayout blJ;
    private View cVX;
    private boolean dbw;
    private ScrollView dhv;
    private View egF;
    private TextView eqW;
    private LinearLayout esA;
    private TextView esB;
    private RelativeLayout esC;
    private LinearLayout esD;
    private com.baidu.tbadk.core.dialog.b esE;
    private LinearLayout esF;
    private com.baidu.tbadk.core.dialog.b esG;
    private b esH;
    private TextView esI;
    private String esJ;
    private ImageView esK;
    private RelativeLayout esL;
    private TextView esM;
    private ImageView esN;
    private RelativeLayout esO;
    private RelativeLayout esP;
    private ImageView esQ;
    private ImageView esR;
    private View esS;
    private TextView esT;
    private TextView esU;
    private LinearLayout esV;
    private View esW;
    private TextView esX;
    private ResponseGroupInfoLocalMessage.a esY;
    private boolean esZ;
    private final GroupInfoActivity esb;
    private View esc;
    private ProgressBar esd;
    private RelativeLayout ese;
    private TextView esf;
    private TextView esg;
    private TextView esh;
    private TextView esi;
    private EllipsizingTextView esj;
    private TextView esk;
    private RelativeLayout esl;
    private PhotoWallView esm;
    private RelativeLayout esn;
    private RelativeLayout eso;
    private LinearLayout esp;
    private HeadImageView esq;
    private TextView esr;
    private RelativeLayout ess;
    private com.baidu.tbadk.core.dialog.b est;
    private ImageView esu;
    private final View esv;
    private b.InterfaceC0104b esw;
    private RelativeLayout esx;
    private LinearLayout esy;
    private HeadImageView[] esz;
    private boolean eta;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int etb = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.est = null;
        this.esw = null;
        this.esz = new HeadImageView[5];
        this.esJ = "";
        this.esZ = true;
        this.isMemGroup = false;
        this.dbw = false;
        this.eta = false;
        this.esb = groupInfoActivity;
        groupInfoActivity.setContentView(d.i.im_group_info_activity);
        this.esv = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(d.i.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dhv.setVisibility(4);
        this.esA.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.esM.setText(str);
        ov(str);
    }

    private void ov(String str) {
        if (str != null) {
            this.esX.setText(str);
        }
    }

    public void ow(String str) {
        this.esj.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(d.g.view_navigation_bar);
        this.egF = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.esX = this.mNavigationBar.setTitleText("");
        this.esW = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.navigation_right_button_layout, (View.OnClickListener) null);
        this.esI = (TextView) this.esW.findViewById(d.g.right_textview);
        this.esI.setText(groupInfoActivity.getPageContext().getString(d.k.setup));
        am.c(this.esI, d.C0142d.cp_cont_f, 1);
        this.esI.setOnClickListener(groupInfoActivity);
        this.esW.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.esc = groupInfoActivity.findViewById(d.g.line_activity_name_down);
        this.blJ = (RelativeLayout) groupInfoActivity.findViewById(d.g.group_info_container);
        this.dhv = (ScrollView) groupInfoActivity.findViewById(d.g.group_scrollview);
        this.dhv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.cVX = groupInfoActivity.findViewById(d.g.group_top_view);
        this.cVX.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.ese = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_activity);
        this.ese.setOnClickListener(groupInfoActivity);
        this.esf = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_status);
        this.esg = (TextView) groupInfoActivity.findViewById(d.g.txt_activity_name);
        this.esx = (RelativeLayout) groupInfoActivity.findViewById(d.g.address_layout);
        this.esx.setOnClickListener(groupInfoActivity);
        this.esF = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_body);
        this.esK = (ImageView) groupInfoActivity.findViewById(d.g.img_group_type_icon);
        this.esh = (TextView) groupInfoActivity.findViewById(d.g.txt_group_number);
        this.esi = (TextView) groupInfoActivity.findViewById(d.g.txt_group_place);
        this.esQ = (ImageView) groupInfoActivity.findViewById(d.g.img_group_place);
        this.esj = (EllipsizingTextView) groupInfoActivity.findViewById(d.g.txt_group_intro);
        this.esj.setMaxLines(20);
        this.esj.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void gC(boolean z) {
                if (z) {
                    a.this.esT.setVisibility(0);
                } else {
                    a.this.esT.setVisibility(8);
                }
            }
        });
        this.esl = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_forum);
        this.esk = (TextView) groupInfoActivity.findViewById(d.g.txt_group_forum);
        this.esl.setOnClickListener(groupInfoActivity);
        this.esq = (HeadImageView) groupInfoActivity.findViewById(d.g.img_group_author);
        this.esq.setAutoChangeStyle(true);
        this.esq.setIsRound(false);
        this.eqW = (TextView) groupInfoActivity.findViewById(d.g.txt_group_author);
        this.esn = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_author);
        this.esn.setOnClickListener(groupInfoActivity);
        this.esu = (ImageView) groupInfoActivity.findViewById(d.g.meizhi_icon);
        this.esS = groupInfoActivity.findViewById(d.g.line_group_author_down);
        this.esp = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_grade_star);
        this.esl.setOnClickListener(groupInfoActivity);
        this.eso = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_grade);
        this.eso.setOnClickListener(groupInfoActivity);
        this.esr = (TextView) groupInfoActivity.findViewById(d.g.txt_group_member_count);
        this.ess = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_member);
        this.ess.setOnClickListener(groupInfoActivity);
        this.esy = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_member_photo);
        this.esA = (LinearLayout) groupInfoActivity.findViewById(d.g.bottom_bar);
        this.esV = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_bottom_button);
        this.esB = (TextView) groupInfoActivity.findViewById(d.g.txt_join);
        this.esV.setOnClickListener(this.esb);
        this.esC = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_invite);
        this.esC.setOnClickListener(groupInfoActivity);
        this.esD = (LinearLayout) groupInfoActivity.findViewById(d.g.lay_group_notice_share);
        this.esL = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_name);
        this.esL.setOnClickListener(groupInfoActivity);
        this.esM = (TextView) groupInfoActivity.findViewById(d.g.txt_group_name);
        this.esN = (ImageView) groupInfoActivity.findViewById(d.g.img_group_intro_arrow);
        this.esR = (ImageView) groupInfoActivity.findViewById(d.g.img_group_author_arrow);
        this.esO = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_intro);
        this.esO.setOnClickListener(groupInfoActivity);
        this.esO.setLongClickable(true);
        this.esO.setOnLongClickListener(groupInfoActivity);
        this.esT = (TextView) groupInfoActivity.findViewById(d.g.txt_group_intro_more);
        this.esT.setClickable(true);
        this.esT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.esj.setMaxLines(1000);
            }
        });
        this.esP = (RelativeLayout) groupInfoActivity.findViewById(d.g.lay_group_number);
        this.esP.setOnLongClickListener(groupInfoActivity);
        this.esU = (TextView) groupInfoActivity.findViewById(d.g.can_create_mem_group);
        this.esd = (ProgressBar) groupInfoActivity.findViewById(d.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(d.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.esm = (PhotoWallView) groupInfoActivity.findViewById(d.g.photo_wall);
        this.esm.setPhotoClickListener(groupInfoActivity);
        this.esm.setPhotoLongClickListener(groupInfoActivity);
        this.esm.setVisibility(8);
    }

    public RelativeLayout aKs() {
        return this.esP;
    }

    public RelativeLayout aKt() {
        return this.esl;
    }

    public LinearLayout aKu() {
        return this.esy;
    }

    public RelativeLayout aKv() {
        return this.esC;
    }

    public RelativeLayout aKw() {
        return this.esO;
    }

    public RelativeLayout aKx() {
        return this.esL;
    }

    public RelativeLayout aKy() {
        return this.ese;
    }

    public View aKz() {
        return this.esI;
    }

    public LinearLayout aKA() {
        return this.esV;
    }

    public RelativeLayout aKB() {
        return this.esn;
    }

    public RelativeLayout aKC() {
        return this.eso;
    }

    public RelativeLayout aKD() {
        return this.ess;
    }

    public View aJn() {
        return this.egF;
    }

    public void aKE() {
        this.esd.setVisibility(8);
    }

    public void aKF() {
        this.esd.setVisibility(0);
    }

    public void j(boolean z, String str) {
        if (z) {
            this.esi.setText(str);
            this.esx.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.esx.setVisibility(8);
        } else {
            this.esi.setText(str);
            this.esx.setVisibility(0);
        }
    }

    public void hC(boolean z) {
        if (z) {
            this.esi.setText(this.mContext.getString(d.k.live_card_hide));
        } else {
            this.esx.setVisibility(8);
        }
    }

    public RelativeLayout aKG() {
        return this.esx;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dbw = aVar.aLr();
            this.eta = aVar.aLs();
            this.esY = aVar;
            this.esZ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aLm() != null) {
                etb = aVar.aLm().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.esF.setVisibility(0);
            this.esA.setVisibility(0);
            if (aVar.getGroup() != null) {
                ov(aVar.getGroup().getName());
                this.esh.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.esu.setVisibility(0);
                } else {
                    this.esu.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.esK.setVisibility(0);
                    this.esq.setVisibility(8);
                    this.esR.setVisibility(8);
                    this.esS.setVisibility(8);
                    this.eqW.setText(d.k.group_info_forum_author);
                    this.esn.setEnabled(false);
                    this.esu.setVisibility(8);
                } else {
                    this.esK.setVisibility(8);
                    this.esq.setVisibility(0);
                    this.esR.setVisibility(0);
                    this.esS.setVisibility(0);
                    this.eqW.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.esn.setEnabled(true);
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
                this.esJ = stringBuffer.toString();
                this.esi.setText(this.esJ);
                this.esj.setText(aVar.getGroup().getIntro());
                this.esr.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.esq.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.esl.setVisibility(0);
                    this.esk.setText(aVar.getGroup().getForumName() + this.esb.getPageContext().getString(d.k.forum));
                } else {
                    this.esl.setVisibility(8);
                }
                this.esp.removeAllViews();
                boolean aLt = aVar.aLt();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.c(this.esX, d.C0142d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.esb.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, d.f.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, d.f.icon_grade_middle_star_s);
                        }
                        this.esp.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.esb.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, d.f.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, d.f.icon_grade_middle_star_n);
                    }
                    this.esp.addView(imageView2);
                }
                if (aLt) {
                    this.esU.setVisibility(0);
                } else {
                    this.esU.setVisibility(8);
                }
            }
            if (aVar.aLm() != null) {
                this.ese.setVisibility(0);
                this.esc.setVisibility(0);
                GroupActivityData aLm = aVar.aLm();
                if (!aVar.aLr()) {
                    if (aLm.getIsEnd() != 1) {
                        this.esf.setVisibility(4);
                        this.esg.setText(d.k.group_info_activity_not_join_tip);
                    } else {
                        this.ese.setVisibility(8);
                        this.esc.setVisibility(8);
                    }
                } else {
                    this.esf.setVisibility(0);
                    this.esg.setText(aLm.getgActivityTitle());
                    if (aLm.getIsEnd() != 1) {
                        this.esf.setText(d.k.group_info_activity_doing);
                        am.c(this.esf, d.C0142d.common_color_10171, 1);
                    } else {
                        this.esf.setText(d.k.group_activity_end);
                        am.c(this.esf, d.C0142d.common_color_10168, 1);
                    }
                    this.esg.setText(aLm.getgActivityTitle());
                }
            } else if (aVar.aLs()) {
                this.ese.setVisibility(0);
                this.esc.setVisibility(0);
                this.esf.setVisibility(4);
                this.esg.setText(d.k.group_info_create_activity);
            } else {
                this.ese.setVisibility(8);
                this.esc.setVisibility(8);
            }
            this.esy.removeAllViews();
            if (aVar.aLn() != null && aVar.aLn().size() > 0) {
                List<MemberData> aLn = aVar.aLn();
                int size = aLn.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aLn.get(i3);
                    HeadImageView headImageView = this.esz[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.esb.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.esz[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(d.e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(d.e.ds10);
                    this.esy.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aLs()) {
                this.esx.setEnabled(true);
                this.esO.setEnabled(true);
                am.i(this.esO, d.f.group_info_item);
                this.esL.setVisibility(0);
                this.esQ.setVisibility(0);
                this.esN.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.esM.setText(aVar.getGroup().getName());
                }
            } else {
                this.esx.setEnabled(false);
                this.esO.setEnabled(true);
                am.j(this.esO, d.C0142d.cp_bg_line_d);
                this.esN.setVisibility(8);
                this.esQ.setVisibility(8);
                this.esj.setPadding(0, 0, 0, 0);
            }
            if (aVar.aLr()) {
                this.esD.setVisibility(0);
                this.esW.setVisibility(0);
                if (this.ess.getParent() != this.esD) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds18);
                    this.esF.removeView(this.ess);
                    this.esD.addView(this.ess, 1);
                }
                aKH();
            } else {
                this.esD.setVisibility(8);
                this.esW.setVisibility(8);
                if (this.ess.getParent() != this.esF) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(d.e.ds28);
                    this.esD.removeView(this.ess);
                    this.esF.addView(this.ess, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eso.setVisibility(8);
            } else {
                this.eso.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                hC(aVar.aLs());
            } else {
                j(aVar.aLs(), this.esJ);
            }
            this.dhv.setVisibility(0);
            this.esA.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (nZ(aVar.getGroup().getFlag())) {
                hD(z);
            } else {
                aKI();
            }
        }
    }

    public void aKH() {
        this.esB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.c(this.esB, d.C0142d.cp_cont_i, 1);
        this.esB.setText(this.esb.getPageContext().getString(d.k.i_want_talk));
        this.esV.setEnabled(true);
    }

    private void hD(boolean z) {
        this.esB.setText(this.esb.getPageContext().getString(d.k.i_want_attent));
        if (z) {
            this.esB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.esB, d.C0142d.cp_cont_i, 1);
        } else {
            this.esB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.c(this.esB, d.C0142d.cp_cont_i, 1);
        }
        am.i(this.esV, d.f.btn_blue_bg);
        this.esV.setEnabled(true);
    }

    private boolean nZ(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aKI() {
        this.esB.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.esB.setText(this.esb.getPageContext().getString(d.k.group_info_refuse_join));
        this.esB.setTextColor(this.esb.getResources().getColorStateList(d.C0142d.cp_cont_i));
        am.i(this.esV, d.f.btn_app_download_d);
        this.esV.setEnabled(false);
    }

    public void ox(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.esy.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.esy.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.esy.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.esm.setIsManager(aVar.aLs());
            if (aVar.aLs()) {
                this.esm.setVisibility(0);
                if (aVar.aLo() != null && aVar.aLo().size() == 1 && TextUtils.isEmpty(aVar.aLo().get(0).getPicId())) {
                    this.esm.setData(null);
                } else {
                    this.esm.setData(aVar.aLo());
                }
            } else if (aVar.aLo() != null && aVar.aLo().size() > 0) {
                if (aVar.aLo().size() == 1 && TextUtils.isEmpty(aVar.aLo().get(0).getPicId())) {
                    this.esm.setVisibility(8);
                    return;
                }
                this.esm.setVisibility(0);
                this.esm.setData(aVar.aLo());
            } else {
                this.esm.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.esH = bVar;
    }

    public void d(Object obj, int i) {
        if (this.esG != null) {
            this.esG.dismiss();
            this.esG = null;
        }
        e(obj, i);
        this.esG.xq();
    }

    public void aKJ() {
        this.esG.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.esG == null) {
            this.esG = new com.baidu.tbadk.core.dialog.b(this.esb.getPageContext().getPageActivity());
            this.esG.dF(this.esb.getResources().getString(d.k.operation));
            this.esG.a(new String[]{this.esb.getResources().getString(d.k.group_info_set_portrait), this.esb.getResources().getString(d.k.delete), this.esb.getResources().getString(d.k.cancel)}, new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.esH.a(bVar, i2, obj, i);
                }
            });
        }
        this.esG.d(this.esb.getPageContext());
    }

    public void onDestory() {
        if (this.esm != null) {
            this.esm.onDestory();
        }
        if (this.esq != null) {
            this.esq.stopLoad();
            this.esq.setBackgroundDrawable(null);
            this.esq.setImageDrawable(null);
        }
        if (this.esy != null && this.esz != null) {
            int length = this.esz.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.esz[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void oy(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.esb.getPageContext().getString(d.k.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.esb.getPageContext().getPageActivity());
            bVar.dF(this.esb.getPageContext().getString(d.k.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.esb.getSystemService("clipboard")).setText(str);
                        a.this.esb.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.esb.getPageContext());
            bVar.xq();
        }
    }

    public void oz(String str) {
        if (this.esE == null) {
            oA(str);
        }
        this.esE.xq();
    }

    private void oA(final String str) {
        if (this.esE == null) {
            this.esE = new com.baidu.tbadk.core.dialog.b(this.esb.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.esb.getPageContext().getString(d.k.copy_group_number)};
            this.esE.dF(this.esb.getPageContext().getString(d.k.operation));
            this.esE.a(charSequenceArr, new b.InterfaceC0104b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0104b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.esb.getSystemService("clipboard")).setText(str);
                        a.this.esb.showToast(d.k.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.esE.d(this.esb.getPageContext());
        }
    }

    public void aKK() {
        ColorStateList cQ = am.cQ(d.C0142d.cp_cont_i);
        if (cQ != null) {
            this.esB.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(d.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.esB.setTextColor(cQ);
    }

    public void changeSkinType(int i) {
        this.esb.getLayoutMode().setNightMode(i == 1);
        this.esb.getLayoutMode().onModeChanged(this.blJ);
        this.esb.getLayoutMode().onModeChanged(this.esv);
        this.esm.a(i, this.esb);
        this.mNavigationBar.onChangeSkinType(this.esb.getPageContext(), i);
        if (this.isMemGroup) {
            am.c(this.esX, d.C0142d.common_color_10009, 1);
        }
        if (!this.dbw) {
            b(this.esY, this.esZ);
        }
        if (this.eta) {
            am.i(this.esO, d.f.group_info_item);
        } else {
            am.j(this.esO, d.C0142d.cp_bg_line_d);
        }
    }

    public void hE(boolean z) {
        this.dbw = z;
    }
}
