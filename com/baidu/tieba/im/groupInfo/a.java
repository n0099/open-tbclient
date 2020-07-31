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
import com.baidu.tbadk.core.dialog.i;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes17.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int jeP = 0;
    private ScrollView bWv;
    private View huZ;
    private View iQw;
    private boolean isMemGroup;
    private TextView jcK;
    private final GroupInfoActivity jdO;
    private View jdP;
    private ProgressBar jdQ;
    private RelativeLayout jdR;
    private TextView jdS;
    private TextView jdT;
    private TextView jdU;
    private TextView jdV;
    private EllipsizingTextView jdW;
    private TextView jdX;
    private RelativeLayout jdY;
    private PhotoWallView jdZ;
    private ImageView jeA;
    private RelativeLayout jeB;
    private RelativeLayout jeC;
    private ImageView jeD;
    private ImageView jeE;
    private View jeF;
    private TextView jeG;
    private TextView jeH;
    private LinearLayout jeI;
    private View jeJ;
    private TextView jeK;
    private ResponseGroupInfoLocalMessage.a jeL;
    private boolean jeM;
    private boolean jeN;
    private boolean jeO;
    private RelativeLayout jea;
    private RelativeLayout jeb;
    private LinearLayout jec;
    private HeadImageView jed;
    private TextView jee;
    private RelativeLayout jef;
    private com.baidu.tbadk.core.dialog.b jeg;
    private ImageView jeh;
    private final View jei;
    private b.InterfaceC0492b jej;
    private RelativeLayout jek;
    private LinearLayout jel;
    private HeadImageView[] jem;
    private LinearLayout jen;
    private TextView jeo;
    private RelativeLayout jep;
    private LinearLayout jeq;
    private com.baidu.tbadk.core.dialog.b jer;
    private LinearLayout jes;
    private i jet;
    private b jeu;
    private TextView jev;
    private String jew;
    private ImageView jex;
    private RelativeLayout jey;
    private TextView jez;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jeg = null;
        this.jej = null;
        this.jem = new HeadImageView[5];
        this.jew = "";
        this.jeM = true;
        this.isMemGroup = false;
        this.jeN = false;
        this.jeO = false;
        this.jdO = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jei = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bWv.setVisibility(4);
        this.jen.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jez.setText(str);
        HU(str);
    }

    private void HU(String str) {
        if (str != null) {
            this.jeK.setText(str);
        }
    }

    public void HV(String str) {
        this.jdW.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.iQw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jeK = this.mNavigationBar.setTitleText("");
        this.jeJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jev = (TextView) this.jeJ.findViewById(R.id.right_textview);
        this.jev.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ao.setViewTextColor(this.jev, R.color.cp_cont_f, 1);
        this.jev.setOnClickListener(groupInfoActivity);
        this.jeJ.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jdP = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bWv = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bWv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.huZ = groupInfoActivity.findViewById(R.id.group_top_view);
        this.huZ.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jdR = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jdR.setOnClickListener(groupInfoActivity);
        this.jdS = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jdT = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jek = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jek.setOnClickListener(groupInfoActivity);
        this.jes = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jex = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jdU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jdV = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jeD = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jdW = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jdW.setMaxLines(20);
        this.jdW.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void oR(boolean z) {
                if (z) {
                    a.this.jeG.setVisibility(0);
                } else {
                    a.this.jeG.setVisibility(8);
                }
            }
        });
        this.jdY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jdX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jdY.setOnClickListener(groupInfoActivity);
        this.jed = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jed.setAutoChangeStyle(true);
        this.jed.setIsRound(false);
        this.jcK = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jea = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jea.setOnClickListener(groupInfoActivity);
        this.jeh = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jeF = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jec = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jdY.setOnClickListener(groupInfoActivity);
        this.jeb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jeb.setOnClickListener(groupInfoActivity);
        this.jee = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jef = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jef.setOnClickListener(groupInfoActivity);
        this.jel = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jen = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jeI = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jeo = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jeI.setOnClickListener(this.jdO);
        this.jep = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jep.setOnClickListener(groupInfoActivity);
        this.jeq = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jey = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jey.setOnClickListener(groupInfoActivity);
        this.jez = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jeA = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jeE = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jeB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jeB.setOnClickListener(groupInfoActivity);
        this.jeB.setLongClickable(true);
        this.jeB.setOnLongClickListener(groupInfoActivity);
        this.jeG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jeG.setClickable(true);
        this.jeG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jdW.setMaxLines(1000);
            }
        });
        this.jeC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jeC.setOnLongClickListener(groupInfoActivity);
        this.jeH = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jdQ = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jdZ = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jdZ.setPhotoClickListener(groupInfoActivity);
        this.jdZ.setPhotoLongClickListener(groupInfoActivity);
        this.jdZ.setVisibility(8);
    }

    public RelativeLayout cvs() {
        return this.jeC;
    }

    public RelativeLayout cvt() {
        return this.jdY;
    }

    public LinearLayout cvu() {
        return this.jel;
    }

    public RelativeLayout cvv() {
        return this.jep;
    }

    public RelativeLayout cvw() {
        return this.jeB;
    }

    public RelativeLayout cvx() {
        return this.jey;
    }

    public RelativeLayout cvy() {
        return this.jdR;
    }

    public View cvz() {
        return this.jev;
    }

    public LinearLayout cvA() {
        return this.jeI;
    }

    public RelativeLayout cvB() {
        return this.jea;
    }

    public RelativeLayout cvC() {
        return this.jeb;
    }

    public RelativeLayout cvD() {
        return this.jef;
    }

    public View cum() {
        return this.iQw;
    }

    public void cvE() {
        this.jdQ.setVisibility(8);
    }

    public void cvF() {
        this.jdQ.setVisibility(0);
    }

    public void q(boolean z, String str) {
        if (z) {
            this.jdV.setText(str);
            this.jek.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jek.setVisibility(8);
        } else {
            this.jdV.setText(str);
            this.jek.setVisibility(0);
        }
    }

    public void qd(boolean z) {
        if (z) {
            this.jdV.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jek.setVisibility(8);
        }
    }

    public RelativeLayout cvG() {
        return this.jek;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jeN = aVar.cwp();
            this.jeO = aVar.cwq();
            this.jeL = aVar;
            this.jeM = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cwk() != null) {
                jeP = aVar.cwk().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jes.setVisibility(0);
            this.jen.setVisibility(0);
            if (aVar.getGroup() != null) {
                HU(aVar.getGroup().getName());
                this.jdU.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jeh.setVisibility(0);
                } else {
                    this.jeh.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jex.setVisibility(0);
                    this.jed.setVisibility(8);
                    this.jeE.setVisibility(8);
                    this.jeF.setVisibility(8);
                    this.jcK.setText(R.string.group_info_forum_author);
                    this.jea.setEnabled(false);
                    this.jeh.setVisibility(8);
                } else {
                    this.jex.setVisibility(8);
                    this.jed.setVisibility(0);
                    this.jeE.setVisibility(0);
                    this.jeF.setVisibility(0);
                    this.jcK.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jea.setEnabled(true);
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
                this.jew = stringBuffer.toString();
                this.jdV.setText(this.jew);
                this.jdW.setText(aVar.getGroup().getIntro());
                this.jee.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jed.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jdY.setVisibility(0);
                    this.jdX.setText(aVar.getGroup().getForumName() + this.jdO.getPageContext().getString(R.string.forum));
                } else {
                    this.jdY.setVisibility(8);
                }
                this.jec.removeAllViews();
                boolean cwr = aVar.cwr();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ao.setViewTextColor(this.jeK, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jdO.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ao.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ao.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jec.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jdO.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ao.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ao.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jec.addView(imageView2);
                }
                if (cwr) {
                    this.jeH.setVisibility(0);
                } else {
                    this.jeH.setVisibility(8);
                }
            }
            if (aVar.cwk() != null) {
                this.jdR.setVisibility(0);
                this.jdP.setVisibility(0);
                GroupActivityData cwk = aVar.cwk();
                if (!aVar.cwp()) {
                    if (cwk.getIsEnd() != 1) {
                        this.jdS.setVisibility(4);
                        this.jdT.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jdR.setVisibility(8);
                        this.jdP.setVisibility(8);
                    }
                } else {
                    this.jdS.setVisibility(0);
                    this.jdT.setText(cwk.getgActivityTitle());
                    if (cwk.getIsEnd() != 1) {
                        this.jdS.setText(R.string.group_info_activity_doing);
                        ao.setViewTextColor(this.jdS, R.color.common_color_10171, 1);
                    } else {
                        this.jdS.setText(R.string.group_activity_end);
                        ao.setViewTextColor(this.jdS, R.color.common_color_10168, 1);
                    }
                    this.jdT.setText(cwk.getgActivityTitle());
                }
            } else if (aVar.cwq()) {
                this.jdR.setVisibility(0);
                this.jdP.setVisibility(0);
                this.jdS.setVisibility(4);
                this.jdT.setText(R.string.group_info_create_activity);
            } else {
                this.jdR.setVisibility(8);
                this.jdP.setVisibility(8);
            }
            this.jel.removeAllViews();
            if (aVar.cwl() != null && aVar.cwl().size() > 0) {
                List<MemberData> cwl = aVar.cwl();
                int size = cwl.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cwl.get(i3);
                    HeadImageView headImageView = this.jem[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jdO.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jem[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jel.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cwq()) {
                this.jek.setEnabled(true);
                this.jeB.setEnabled(true);
                ao.setBackgroundResource(this.jeB, R.drawable.group_info_item);
                this.jey.setVisibility(0);
                this.jeD.setVisibility(0);
                this.jeA.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jez.setText(aVar.getGroup().getName());
                }
            } else {
                this.jek.setEnabled(false);
                this.jeB.setEnabled(true);
                ao.setBackgroundColor(this.jeB, R.color.cp_bg_line_d);
                this.jeA.setVisibility(8);
                this.jeD.setVisibility(8);
                this.jdW.setPadding(0, 0, 0, 0);
            }
            if (aVar.cwp()) {
                this.jeq.setVisibility(0);
                this.jeJ.setVisibility(0);
                if (this.jef.getParent() != this.jeq) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jes.removeView(this.jef);
                    this.jeq.addView(this.jef, 1);
                }
                cvH();
            } else {
                this.jeq.setVisibility(8);
                this.jeJ.setVisibility(8);
                if (this.jef.getParent() != this.jes) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jeq.removeView(this.jef);
                    this.jes.addView(this.jef, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jeb.setVisibility(8);
            } else {
                this.jeb.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                qd(aVar.cwq());
            } else {
                q(aVar.cwq(), this.jew);
            }
            this.bWv.setVisibility(0);
            this.jen.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (yY(aVar.getGroup().getFlag())) {
                qe(z);
            } else {
                cvI();
            }
        }
    }

    public void cvH() {
        this.jeo.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.jeo, R.color.cp_cont_a, 1);
        this.jeo.setText(this.jdO.getPageContext().getString(R.string.i_want_talk));
        this.jeI.setEnabled(true);
    }

    private void qe(boolean z) {
        this.jeo.setText(this.jdO.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jeo.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.jeo, R.color.cp_cont_a, 1);
        } else {
            this.jeo.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.jeo, R.color.cp_cont_a, 1);
        }
        ao.setBackgroundResource(this.jeI, R.drawable.btn_blue_bg);
        this.jeI.setEnabled(true);
    }

    private boolean yY(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cvI() {
        this.jeo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jeo.setText(this.jdO.getPageContext().getString(R.string.group_info_refuse_join));
        this.jeo.setTextColor(this.jdO.getResources().getColorStateList(R.color.cp_cont_a));
        ao.setBackgroundResource(this.jeI, R.drawable.btn_app_download_d);
        this.jeI.setEnabled(false);
    }

    public void HW(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jel.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jel.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jel.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jdZ.setIsManager(aVar.cwq());
            if (aVar.cwq()) {
                this.jdZ.setVisibility(0);
                if (aVar.cwm() != null && aVar.cwm().size() == 1 && TextUtils.isEmpty(aVar.cwm().get(0).getPicId())) {
                    this.jdZ.setData(null);
                } else {
                    this.jdZ.setData(aVar.cwm());
                }
            } else if (aVar.cwm() != null && aVar.cwm().size() > 0) {
                if (aVar.cwm().size() == 1 && TextUtils.isEmpty(aVar.cwm().get(0).getPicId())) {
                    this.jdZ.setVisibility(8);
                    return;
                }
                this.jdZ.setVisibility(0);
                this.jdZ.setData(aVar.cwm());
            } else {
                this.jdZ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jeu = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jet != null) {
            this.jet.dismiss();
            this.jet = null;
        }
        e(obj, i);
        this.jet.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.jet == null) {
            this.jet = new i(this.jdO.getPageContext());
            this.jet.a(null, new String[]{this.jdO.getResources().getString(R.string.group_info_set_portrait), this.jdO.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jet != null && a.this.jet.isShowing()) {
                        a.this.jeu.a(a.this.jet, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jdZ != null) {
            this.jdZ.onDestory();
        }
        if (this.jed != null) {
            this.jed.stopLoad();
            this.jed.setBackgroundDrawable(null);
            this.jed.setImageDrawable(null);
        }
        if (this.jel != null && this.jem != null) {
            int length = this.jem.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jem[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void HX(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.jdO.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jdO.getPageContext().getPageActivity());
            bVar.xm(this.jdO.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jdO.getSystemService("clipboard")).setText(str);
                        a.this.jdO.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jdO.getPageContext());
            bVar.aYN();
        }
    }

    public void HY(String str) {
        if (this.jer == null) {
            HZ(str);
        }
        this.jer.aYN();
    }

    private void HZ(final String str) {
        if (this.jer == null) {
            this.jer = new com.baidu.tbadk.core.dialog.b(this.jdO.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jdO.getPageContext().getString(R.string.copy_group_number)};
            this.jer.xm(this.jdO.getPageContext().getString(R.string.operation));
            this.jer.a(charSequenceArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jdO.getSystemService("clipboard")).setText(str);
                        a.this.jdO.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jer.d(this.jdO.getPageContext());
        }
    }

    public void cvJ() {
        ColorStateList colorList = ao.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jeo.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jeo.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jdO.getLayoutMode().setNightMode(i == 1);
        this.jdO.getLayoutMode().onModeChanged(this.mContainer);
        this.jdO.getLayoutMode().onModeChanged(this.jei);
        this.jdZ.a(i, this.jdO);
        this.mNavigationBar.onChangeSkinType(this.jdO.getPageContext(), i);
        if (this.isMemGroup) {
            ao.setViewTextColor(this.jeK, R.color.common_color_10009, 1);
        }
        if (!this.jeN) {
            b(this.jeL, this.jeM);
        }
        if (this.jeO) {
            ao.setBackgroundResource(this.jeB, R.drawable.group_info_item);
        } else {
            ao.setBackgroundColor(this.jeB, R.color.cp_bg_line_d);
        }
    }

    public void qf(boolean z) {
        this.jeN = z;
    }
}
