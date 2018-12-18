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
    private RelativeLayout bAw;
    private ScrollView bHu;
    private View duq;
    private boolean dzM;
    private View eHK;
    private TextView eRV;
    private final GroupInfoActivity eSZ;
    private RelativeLayout eTA;
    private LinearLayout eTB;
    private com.baidu.tbadk.core.dialog.b eTC;
    private LinearLayout eTD;
    private com.baidu.tbadk.core.dialog.b eTE;
    private b eTF;
    private TextView eTG;
    private String eTH;
    private ImageView eTI;
    private RelativeLayout eTJ;
    private TextView eTK;
    private ImageView eTL;
    private RelativeLayout eTM;
    private RelativeLayout eTN;
    private ImageView eTO;
    private ImageView eTP;
    private View eTQ;
    private TextView eTR;
    private TextView eTS;
    private LinearLayout eTT;
    private View eTU;
    private TextView eTV;
    private ResponseGroupInfoLocalMessage.a eTW;
    private boolean eTX;
    private boolean eTY;
    private View eTa;
    private ProgressBar eTb;
    private RelativeLayout eTc;
    private TextView eTd;
    private TextView eTe;
    private TextView eTf;
    private TextView eTg;
    private EllipsizingTextView eTh;
    private TextView eTi;
    private RelativeLayout eTj;
    private PhotoWallView eTk;
    private RelativeLayout eTl;
    private RelativeLayout eTm;
    private LinearLayout eTn;
    private HeadImageView eTo;
    private TextView eTp;
    private RelativeLayout eTq;
    private com.baidu.tbadk.core.dialog.b eTr;
    private ImageView eTs;
    private final View eTt;
    private b.InterfaceC0158b eTu;
    private RelativeLayout eTv;
    private LinearLayout eTw;
    private HeadImageView[] eTx;
    private LinearLayout eTy;
    private TextView eTz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eTZ = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eTr = null;
        this.eTu = null;
        this.eTx = new HeadImageView[5];
        this.eTH = "";
        this.eTX = true;
        this.isMemGroup = false;
        this.dzM = false;
        this.eTY = false;
        this.eSZ = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eTt = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bHu.setVisibility(4);
        this.eTy.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eTK.setText(str);
        qj(str);
    }

    private void qj(String str) {
        if (str != null) {
            this.eTV.setText(str);
        }
    }

    public void qk(String str) {
        this.eTh.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.eHK = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eTV = this.mNavigationBar.setTitleText("");
        this.eTU = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eTG = (TextView) this.eTU.findViewById(e.g.right_textview);
        this.eTG.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eTG, e.d.cp_cont_f, 1);
        this.eTG.setOnClickListener(groupInfoActivity);
        this.eTU.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eTa = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bAw = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.bHu = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.bHu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.duq = groupInfoActivity.findViewById(e.g.group_top_view);
        this.duq.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eTc = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eTc.setOnClickListener(groupInfoActivity);
        this.eTd = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eTe = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eTv = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eTv.setOnClickListener(groupInfoActivity);
        this.eTD = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eTI = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eTf = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eTg = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eTO = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eTh = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eTh.setMaxLines(20);
        this.eTh.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hG(boolean z) {
                if (z) {
                    a.this.eTR.setVisibility(0);
                } else {
                    a.this.eTR.setVisibility(8);
                }
            }
        });
        this.eTj = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eTi = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eTj.setOnClickListener(groupInfoActivity);
        this.eTo = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eTo.setAutoChangeStyle(true);
        this.eTo.setIsRound(false);
        this.eRV = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eTl = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eTl.setOnClickListener(groupInfoActivity);
        this.eTs = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eTQ = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eTn = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eTj.setOnClickListener(groupInfoActivity);
        this.eTm = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eTm.setOnClickListener(groupInfoActivity);
        this.eTp = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eTq = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eTq.setOnClickListener(groupInfoActivity);
        this.eTw = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eTy = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eTT = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eTz = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eTT.setOnClickListener(this.eSZ);
        this.eTA = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eTA.setOnClickListener(groupInfoActivity);
        this.eTB = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eTJ = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eTJ.setOnClickListener(groupInfoActivity);
        this.eTK = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eTL = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eTP = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eTM = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eTM.setOnClickListener(groupInfoActivity);
        this.eTM.setLongClickable(true);
        this.eTM.setOnLongClickListener(groupInfoActivity);
        this.eTR = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eTR.setClickable(true);
        this.eTR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eTh.setMaxLines(1000);
            }
        });
        this.eTN = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eTN.setOnLongClickListener(groupInfoActivity);
        this.eTS = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eTb = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eTk = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eTk.setPhotoClickListener(groupInfoActivity);
        this.eTk.setPhotoLongClickListener(groupInfoActivity);
        this.eTk.setVisibility(8);
    }

    public RelativeLayout aSi() {
        return this.eTN;
    }

    public RelativeLayout aSj() {
        return this.eTj;
    }

    public LinearLayout aSk() {
        return this.eTw;
    }

    public RelativeLayout aSl() {
        return this.eTA;
    }

    public RelativeLayout aSm() {
        return this.eTM;
    }

    public RelativeLayout aSn() {
        return this.eTJ;
    }

    public RelativeLayout aSo() {
        return this.eTc;
    }

    public View aSp() {
        return this.eTG;
    }

    public LinearLayout aSq() {
        return this.eTT;
    }

    public RelativeLayout aSr() {
        return this.eTl;
    }

    public RelativeLayout aSs() {
        return this.eTm;
    }

    public RelativeLayout aSt() {
        return this.eTq;
    }

    public View aRd() {
        return this.eHK;
    }

    public void aSu() {
        this.eTb.setVisibility(8);
    }

    public void aSv() {
        this.eTb.setVisibility(0);
    }

    public void h(boolean z, String str) {
        if (z) {
            this.eTg.setText(str);
            this.eTv.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eTv.setVisibility(8);
        } else {
            this.eTg.setText(str);
            this.eTv.setVisibility(0);
        }
    }

    public void iH(boolean z) {
        if (z) {
            this.eTg.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eTv.setVisibility(8);
        }
    }

    public RelativeLayout aSw() {
        return this.eTv;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dzM = aVar.aTg();
            this.eTY = aVar.aTh();
            this.eTW = aVar;
            this.eTX = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aTb() != null) {
                eTZ = aVar.aTb().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eTD.setVisibility(0);
            this.eTy.setVisibility(0);
            if (aVar.getGroup() != null) {
                qj(aVar.getGroup().getName());
                this.eTf.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eTs.setVisibility(0);
                } else {
                    this.eTs.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eTI.setVisibility(0);
                    this.eTo.setVisibility(8);
                    this.eTP.setVisibility(8);
                    this.eTQ.setVisibility(8);
                    this.eRV.setText(e.j.group_info_forum_author);
                    this.eTl.setEnabled(false);
                    this.eTs.setVisibility(8);
                } else {
                    this.eTI.setVisibility(8);
                    this.eTo.setVisibility(0);
                    this.eTP.setVisibility(0);
                    this.eTQ.setVisibility(0);
                    this.eRV.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eTl.setEnabled(true);
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
                this.eTH = stringBuffer.toString();
                this.eTg.setText(this.eTH);
                this.eTh.setText(aVar.getGroup().getIntro());
                this.eTp.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eTo.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eTj.setVisibility(0);
                    this.eTi.setText(aVar.getGroup().getForumName() + this.eSZ.getPageContext().getString(e.j.forum));
                } else {
                    this.eTj.setVisibility(8);
                }
                this.eTn.removeAllViews();
                boolean aTi = aVar.aTi();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eTV, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eSZ.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eTn.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eSZ.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eTn.addView(imageView2);
                }
                if (aTi) {
                    this.eTS.setVisibility(0);
                } else {
                    this.eTS.setVisibility(8);
                }
            }
            if (aVar.aTb() != null) {
                this.eTc.setVisibility(0);
                this.eTa.setVisibility(0);
                GroupActivityData aTb = aVar.aTb();
                if (!aVar.aTg()) {
                    if (aTb.getIsEnd() != 1) {
                        this.eTd.setVisibility(4);
                        this.eTe.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eTc.setVisibility(8);
                        this.eTa.setVisibility(8);
                    }
                } else {
                    this.eTd.setVisibility(0);
                    this.eTe.setText(aTb.getgActivityTitle());
                    if (aTb.getIsEnd() != 1) {
                        this.eTd.setText(e.j.group_info_activity_doing);
                        al.c(this.eTd, e.d.common_color_10171, 1);
                    } else {
                        this.eTd.setText(e.j.group_activity_end);
                        al.c(this.eTd, e.d.common_color_10168, 1);
                    }
                    this.eTe.setText(aTb.getgActivityTitle());
                }
            } else if (aVar.aTh()) {
                this.eTc.setVisibility(0);
                this.eTa.setVisibility(0);
                this.eTd.setVisibility(4);
                this.eTe.setText(e.j.group_info_create_activity);
            } else {
                this.eTc.setVisibility(8);
                this.eTa.setVisibility(8);
            }
            this.eTw.removeAllViews();
            if (aVar.aTc() != null && aVar.aTc().size() > 0) {
                List<MemberData> aTc = aVar.aTc();
                int size = aTc.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aTc.get(i3);
                    HeadImageView headImageView = this.eTx[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eSZ.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eTx[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds10);
                    this.eTw.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aTh()) {
                this.eTv.setEnabled(true);
                this.eTM.setEnabled(true);
                al.i(this.eTM, e.f.group_info_item);
                this.eTJ.setVisibility(0);
                this.eTO.setVisibility(0);
                this.eTL.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eTK.setText(aVar.getGroup().getName());
                }
            } else {
                this.eTv.setEnabled(false);
                this.eTM.setEnabled(true);
                al.j(this.eTM, e.d.cp_bg_line_d);
                this.eTL.setVisibility(8);
                this.eTO.setVisibility(8);
                this.eTh.setPadding(0, 0, 0, 0);
            }
            if (aVar.aTg()) {
                this.eTB.setVisibility(0);
                this.eTU.setVisibility(0);
                if (this.eTq.getParent() != this.eTB) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds18);
                    this.eTD.removeView(this.eTq);
                    this.eTB.addView(this.eTq, 1);
                }
                aSx();
            } else {
                this.eTB.setVisibility(8);
                this.eTU.setVisibility(8);
                if (this.eTq.getParent() != this.eTD) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0210e.ds28);
                    this.eTB.removeView(this.eTq);
                    this.eTD.addView(this.eTq, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eTm.setVisibility(8);
            } else {
                this.eTm.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                iH(aVar.aTh());
            } else {
                h(aVar.aTh(), this.eTH);
            }
            this.bHu.setVisibility(0);
            this.eTy.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (qc(aVar.getGroup().getFlag())) {
                iI(z);
            } else {
                aSy();
            }
        }
    }

    public void aSx() {
        this.eTz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eTz, e.d.cp_cont_i, 1);
        this.eTz.setText(this.eSZ.getPageContext().getString(e.j.i_want_talk));
        this.eTT.setEnabled(true);
    }

    private void iI(boolean z) {
        this.eTz.setText(this.eSZ.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eTz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eTz, e.d.cp_cont_i, 1);
        } else {
            this.eTz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eTz, e.d.cp_cont_i, 1);
        }
        al.i(this.eTT, e.f.btn_blue_bg);
        this.eTT.setEnabled(true);
    }

    private boolean qc(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aSy() {
        this.eTz.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eTz.setText(this.eSZ.getPageContext().getString(e.j.group_info_refuse_join));
        this.eTz.setTextColor(this.eSZ.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eTT, e.f.btn_app_download_d);
        this.eTT.setEnabled(false);
    }

    public void ql(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eTw.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eTw.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eTw.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eTk.setIsManager(aVar.aTh());
            if (aVar.aTh()) {
                this.eTk.setVisibility(0);
                if (aVar.aTd() != null && aVar.aTd().size() == 1 && TextUtils.isEmpty(aVar.aTd().get(0).getPicId())) {
                    this.eTk.setData(null);
                } else {
                    this.eTk.setData(aVar.aTd());
                }
            } else if (aVar.aTd() != null && aVar.aTd().size() > 0) {
                if (aVar.aTd().size() == 1 && TextUtils.isEmpty(aVar.aTd().get(0).getPicId())) {
                    this.eTk.setVisibility(8);
                    return;
                }
                this.eTk.setVisibility(0);
                this.eTk.setData(aVar.aTd());
            } else {
                this.eTk.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eTF = bVar;
    }

    public void d(Object obj, int i) {
        if (this.eTE != null) {
            this.eTE.dismiss();
            this.eTE = null;
        }
        e(obj, i);
        this.eTE.BI();
    }

    public void aSz() {
        this.eTE.dismiss();
    }

    private void e(final Object obj, final int i) {
        if (this.eTE == null) {
            this.eTE = new com.baidu.tbadk.core.dialog.b(this.eSZ.getPageContext().getPageActivity());
            this.eTE.eC(this.eSZ.getResources().getString(e.j.operation));
            this.eTE.a(new String[]{this.eSZ.getResources().getString(e.j.group_info_set_portrait), this.eSZ.getResources().getString(e.j.delete), this.eSZ.getResources().getString(e.j.cancel)}, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eTF.a(bVar, i2, obj, i);
                }
            });
        }
        this.eTE.d(this.eSZ.getPageContext());
    }

    public void onDestory() {
        if (this.eTk != null) {
            this.eTk.onDestory();
        }
        if (this.eTo != null) {
            this.eTo.stopLoad();
            this.eTo.setBackgroundDrawable(null);
            this.eTo.setImageDrawable(null);
        }
        if (this.eTw != null && this.eTx != null) {
            int length = this.eTx.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eTx[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void qm(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eSZ.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eSZ.getPageContext().getPageActivity());
            bVar.eC(this.eSZ.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eSZ.getSystemService("clipboard")).setText(str);
                        a.this.eSZ.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eSZ.getPageContext());
            bVar.BI();
        }
    }

    public void qn(String str) {
        if (this.eTC == null) {
            qo(str);
        }
        this.eTC.BI();
    }

    private void qo(final String str) {
        if (this.eTC == null) {
            this.eTC = new com.baidu.tbadk.core.dialog.b(this.eSZ.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eSZ.getPageContext().getString(e.j.copy_group_number)};
            this.eTC.eC(this.eSZ.getPageContext().getString(e.j.operation));
            this.eTC.a(charSequenceArr, new b.InterfaceC0158b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0158b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eSZ.getSystemService("clipboard")).setText(str);
                        a.this.eSZ.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eTC.d(this.eSZ.getPageContext());
        }
    }

    public void aSA() {
        ColorStateList dN = al.dN(e.d.cp_cont_i);
        if (dN != null) {
            this.eTz.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eTz.setTextColor(dN);
    }

    public void changeSkinType(int i) {
        this.eSZ.getLayoutMode().setNightMode(i == 1);
        this.eSZ.getLayoutMode().onModeChanged(this.bAw);
        this.eSZ.getLayoutMode().onModeChanged(this.eTt);
        this.eTk.a(i, this.eSZ);
        this.mNavigationBar.onChangeSkinType(this.eSZ.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eTV, e.d.common_color_10009, 1);
        }
        if (!this.dzM) {
            b(this.eTW, this.eTX);
        }
        if (this.eTY) {
            al.i(this.eTM, e.f.group_info_item);
        } else {
            al.j(this.eTM, e.d.cp_bg_line_d);
        }
    }

    public void iJ(boolean z) {
        this.dzM = z;
    }
}
