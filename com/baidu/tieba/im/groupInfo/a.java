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
    public static int jeR = 0;
    private ScrollView bWv;
    private View huZ;
    private View iQy;
    private boolean isMemGroup;
    private TextView jcM;
    private final GroupInfoActivity jdQ;
    private View jdR;
    private ProgressBar jdS;
    private RelativeLayout jdT;
    private TextView jdU;
    private TextView jdV;
    private TextView jdW;
    private TextView jdX;
    private EllipsizingTextView jdY;
    private TextView jdZ;
    private RelativeLayout jeA;
    private TextView jeB;
    private ImageView jeC;
    private RelativeLayout jeD;
    private RelativeLayout jeE;
    private ImageView jeF;
    private ImageView jeG;
    private View jeH;
    private TextView jeI;
    private TextView jeJ;
    private LinearLayout jeK;
    private View jeL;
    private TextView jeM;
    private ResponseGroupInfoLocalMessage.a jeN;
    private boolean jeO;
    private boolean jeP;
    private boolean jeQ;
    private RelativeLayout jea;
    private PhotoWallView jeb;
    private RelativeLayout jec;
    private RelativeLayout jed;
    private LinearLayout jee;
    private HeadImageView jef;
    private TextView jeg;
    private RelativeLayout jeh;
    private com.baidu.tbadk.core.dialog.b jei;
    private ImageView jej;
    private final View jek;
    private b.InterfaceC0492b jel;
    private RelativeLayout jem;
    private LinearLayout jen;
    private HeadImageView[] jeo;
    private LinearLayout jep;
    private TextView jeq;
    private RelativeLayout jer;
    private LinearLayout jes;
    private com.baidu.tbadk.core.dialog.b jet;
    private LinearLayout jeu;
    private i jev;
    private b jew;
    private TextView jex;
    private String jey;
    private ImageView jez;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jei = null;
        this.jel = null;
        this.jeo = new HeadImageView[5];
        this.jey = "";
        this.jeO = true;
        this.isMemGroup = false;
        this.jeP = false;
        this.jeQ = false;
        this.jdQ = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jek = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bWv.setVisibility(4);
        this.jep.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jeB.setText(str);
        HU(str);
    }

    private void HU(String str) {
        if (str != null) {
            this.jeM.setText(str);
        }
    }

    public void HV(String str) {
        this.jdY.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.iQy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jeM = this.mNavigationBar.setTitleText("");
        this.jeL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jex = (TextView) this.jeL.findViewById(R.id.right_textview);
        this.jex.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ao.setViewTextColor(this.jex, R.color.cp_cont_f, 1);
        this.jex.setOnClickListener(groupInfoActivity);
        this.jeL.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jdR = groupInfoActivity.findViewById(R.id.line_activity_name_down);
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
        this.jdT = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jdT.setOnClickListener(groupInfoActivity);
        this.jdU = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jdV = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jem = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jem.setOnClickListener(groupInfoActivity);
        this.jeu = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jez = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jdW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jdX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jeF = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jdY = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jdY.setMaxLines(20);
        this.jdY.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void oR(boolean z) {
                if (z) {
                    a.this.jeI.setVisibility(0);
                } else {
                    a.this.jeI.setVisibility(8);
                }
            }
        });
        this.jea = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jdZ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jea.setOnClickListener(groupInfoActivity);
        this.jef = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jef.setAutoChangeStyle(true);
        this.jef.setIsRound(false);
        this.jcM = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jec = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jec.setOnClickListener(groupInfoActivity);
        this.jej = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jeH = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jee = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jea.setOnClickListener(groupInfoActivity);
        this.jed = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jed.setOnClickListener(groupInfoActivity);
        this.jeg = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jeh = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jeh.setOnClickListener(groupInfoActivity);
        this.jen = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jep = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jeK = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jeq = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jeK.setOnClickListener(this.jdQ);
        this.jer = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jer.setOnClickListener(groupInfoActivity);
        this.jes = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jeA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jeA.setOnClickListener(groupInfoActivity);
        this.jeB = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jeC = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jeG = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jeD = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jeD.setOnClickListener(groupInfoActivity);
        this.jeD.setLongClickable(true);
        this.jeD.setOnLongClickListener(groupInfoActivity);
        this.jeI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jeI.setClickable(true);
        this.jeI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jdY.setMaxLines(1000);
            }
        });
        this.jeE = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jeE.setOnLongClickListener(groupInfoActivity);
        this.jeJ = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jdS = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jeb = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jeb.setPhotoClickListener(groupInfoActivity);
        this.jeb.setPhotoLongClickListener(groupInfoActivity);
        this.jeb.setVisibility(8);
    }

    public RelativeLayout cvs() {
        return this.jeE;
    }

    public RelativeLayout cvt() {
        return this.jea;
    }

    public LinearLayout cvu() {
        return this.jen;
    }

    public RelativeLayout cvv() {
        return this.jer;
    }

    public RelativeLayout cvw() {
        return this.jeD;
    }

    public RelativeLayout cvx() {
        return this.jeA;
    }

    public RelativeLayout cvy() {
        return this.jdT;
    }

    public View cvz() {
        return this.jex;
    }

    public LinearLayout cvA() {
        return this.jeK;
    }

    public RelativeLayout cvB() {
        return this.jec;
    }

    public RelativeLayout cvC() {
        return this.jed;
    }

    public RelativeLayout cvD() {
        return this.jeh;
    }

    public View cum() {
        return this.iQy;
    }

    public void cvE() {
        this.jdS.setVisibility(8);
    }

    public void cvF() {
        this.jdS.setVisibility(0);
    }

    public void q(boolean z, String str) {
        if (z) {
            this.jdX.setText(str);
            this.jem.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jem.setVisibility(8);
        } else {
            this.jdX.setText(str);
            this.jem.setVisibility(0);
        }
    }

    public void qd(boolean z) {
        if (z) {
            this.jdX.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jem.setVisibility(8);
        }
    }

    public RelativeLayout cvG() {
        return this.jem;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jeP = aVar.cwp();
            this.jeQ = aVar.cwq();
            this.jeN = aVar;
            this.jeO = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cwk() != null) {
                jeR = aVar.cwk().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jeu.setVisibility(0);
            this.jep.setVisibility(0);
            if (aVar.getGroup() != null) {
                HU(aVar.getGroup().getName());
                this.jdW.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jej.setVisibility(0);
                } else {
                    this.jej.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jez.setVisibility(0);
                    this.jef.setVisibility(8);
                    this.jeG.setVisibility(8);
                    this.jeH.setVisibility(8);
                    this.jcM.setText(R.string.group_info_forum_author);
                    this.jec.setEnabled(false);
                    this.jej.setVisibility(8);
                } else {
                    this.jez.setVisibility(8);
                    this.jef.setVisibility(0);
                    this.jeG.setVisibility(0);
                    this.jeH.setVisibility(0);
                    this.jcM.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jec.setEnabled(true);
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
                this.jey = stringBuffer.toString();
                this.jdX.setText(this.jey);
                this.jdY.setText(aVar.getGroup().getIntro());
                this.jeg.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jef.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jea.setVisibility(0);
                    this.jdZ.setText(aVar.getGroup().getForumName() + this.jdQ.getPageContext().getString(R.string.forum));
                } else {
                    this.jea.setVisibility(8);
                }
                this.jee.removeAllViews();
                boolean cwr = aVar.cwr();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ao.setViewTextColor(this.jeM, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jdQ.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ao.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ao.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jee.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jdQ.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ao.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ao.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jee.addView(imageView2);
                }
                if (cwr) {
                    this.jeJ.setVisibility(0);
                } else {
                    this.jeJ.setVisibility(8);
                }
            }
            if (aVar.cwk() != null) {
                this.jdT.setVisibility(0);
                this.jdR.setVisibility(0);
                GroupActivityData cwk = aVar.cwk();
                if (!aVar.cwp()) {
                    if (cwk.getIsEnd() != 1) {
                        this.jdU.setVisibility(4);
                        this.jdV.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jdT.setVisibility(8);
                        this.jdR.setVisibility(8);
                    }
                } else {
                    this.jdU.setVisibility(0);
                    this.jdV.setText(cwk.getgActivityTitle());
                    if (cwk.getIsEnd() != 1) {
                        this.jdU.setText(R.string.group_info_activity_doing);
                        ao.setViewTextColor(this.jdU, R.color.common_color_10171, 1);
                    } else {
                        this.jdU.setText(R.string.group_activity_end);
                        ao.setViewTextColor(this.jdU, R.color.common_color_10168, 1);
                    }
                    this.jdV.setText(cwk.getgActivityTitle());
                }
            } else if (aVar.cwq()) {
                this.jdT.setVisibility(0);
                this.jdR.setVisibility(0);
                this.jdU.setVisibility(4);
                this.jdV.setText(R.string.group_info_create_activity);
            } else {
                this.jdT.setVisibility(8);
                this.jdR.setVisibility(8);
            }
            this.jen.removeAllViews();
            if (aVar.cwl() != null && aVar.cwl().size() > 0) {
                List<MemberData> cwl = aVar.cwl();
                int size = cwl.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cwl.get(i3);
                    HeadImageView headImageView = this.jeo[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jdQ.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jeo[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jen.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cwq()) {
                this.jem.setEnabled(true);
                this.jeD.setEnabled(true);
                ao.setBackgroundResource(this.jeD, R.drawable.group_info_item);
                this.jeA.setVisibility(0);
                this.jeF.setVisibility(0);
                this.jeC.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jeB.setText(aVar.getGroup().getName());
                }
            } else {
                this.jem.setEnabled(false);
                this.jeD.setEnabled(true);
                ao.setBackgroundColor(this.jeD, R.color.cp_bg_line_d);
                this.jeC.setVisibility(8);
                this.jeF.setVisibility(8);
                this.jdY.setPadding(0, 0, 0, 0);
            }
            if (aVar.cwp()) {
                this.jes.setVisibility(0);
                this.jeL.setVisibility(0);
                if (this.jeh.getParent() != this.jes) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jeu.removeView(this.jeh);
                    this.jes.addView(this.jeh, 1);
                }
                cvH();
            } else {
                this.jes.setVisibility(8);
                this.jeL.setVisibility(8);
                if (this.jeh.getParent() != this.jeu) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jes.removeView(this.jeh);
                    this.jeu.addView(this.jeh, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jed.setVisibility(8);
            } else {
                this.jed.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                qd(aVar.cwq());
            } else {
                q(aVar.cwq(), this.jey);
            }
            this.bWv.setVisibility(0);
            this.jep.setVisibility(0);
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
        this.jeq.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ao.setViewTextColor(this.jeq, R.color.cp_cont_a, 1);
        this.jeq.setText(this.jdQ.getPageContext().getString(R.string.i_want_talk));
        this.jeK.setEnabled(true);
    }

    private void qe(boolean z) {
        this.jeq.setText(this.jdQ.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jeq.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.jeq, R.color.cp_cont_a, 1);
        } else {
            this.jeq.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ao.setViewTextColor(this.jeq, R.color.cp_cont_a, 1);
        }
        ao.setBackgroundResource(this.jeK, R.drawable.btn_blue_bg);
        this.jeK.setEnabled(true);
    }

    private boolean yY(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cvI() {
        this.jeq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jeq.setText(this.jdQ.getPageContext().getString(R.string.group_info_refuse_join));
        this.jeq.setTextColor(this.jdQ.getResources().getColorStateList(R.color.cp_cont_a));
        ao.setBackgroundResource(this.jeK, R.drawable.btn_app_download_d);
        this.jeK.setEnabled(false);
    }

    public void HW(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jen.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jen.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jen.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jeb.setIsManager(aVar.cwq());
            if (aVar.cwq()) {
                this.jeb.setVisibility(0);
                if (aVar.cwm() != null && aVar.cwm().size() == 1 && TextUtils.isEmpty(aVar.cwm().get(0).getPicId())) {
                    this.jeb.setData(null);
                } else {
                    this.jeb.setData(aVar.cwm());
                }
            } else if (aVar.cwm() != null && aVar.cwm().size() > 0) {
                if (aVar.cwm().size() == 1 && TextUtils.isEmpty(aVar.cwm().get(0).getPicId())) {
                    this.jeb.setVisibility(8);
                    return;
                }
                this.jeb.setVisibility(0);
                this.jeb.setData(aVar.cwm());
            } else {
                this.jeb.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jew = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jev != null) {
            this.jev.dismiss();
            this.jev = null;
        }
        e(obj, i);
        this.jev.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.jev == null) {
            this.jev = new i(this.jdQ.getPageContext());
            this.jev.a(null, new String[]{this.jdQ.getResources().getString(R.string.group_info_set_portrait), this.jdQ.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jev != null && a.this.jev.isShowing()) {
                        a.this.jew.a(a.this.jev, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jeb != null) {
            this.jeb.onDestory();
        }
        if (this.jef != null) {
            this.jef.stopLoad();
            this.jef.setBackgroundDrawable(null);
            this.jef.setImageDrawable(null);
        }
        if (this.jen != null && this.jeo != null) {
            int length = this.jeo.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jeo[i];
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
            CharSequence[] charSequenceArr = {this.jdQ.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jdQ.getPageContext().getPageActivity());
            bVar.xm(this.jdQ.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jdQ.getSystemService("clipboard")).setText(str);
                        a.this.jdQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jdQ.getPageContext());
            bVar.aYN();
        }
    }

    public void HY(String str) {
        if (this.jet == null) {
            HZ(str);
        }
        this.jet.aYN();
    }

    private void HZ(final String str) {
        if (this.jet == null) {
            this.jet = new com.baidu.tbadk.core.dialog.b(this.jdQ.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jdQ.getPageContext().getString(R.string.copy_group_number)};
            this.jet.xm(this.jdQ.getPageContext().getString(R.string.operation));
            this.jet.a(charSequenceArr, new b.InterfaceC0492b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0492b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jdQ.getSystemService("clipboard")).setText(str);
                        a.this.jdQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jet.d(this.jdQ.getPageContext());
        }
    }

    public void cvJ() {
        ColorStateList colorList = ao.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jeq.setCompoundDrawablesWithIntrinsicBounds(ao.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jeq.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jdQ.getLayoutMode().setNightMode(i == 1);
        this.jdQ.getLayoutMode().onModeChanged(this.mContainer);
        this.jdQ.getLayoutMode().onModeChanged(this.jek);
        this.jeb.a(i, this.jdQ);
        this.mNavigationBar.onChangeSkinType(this.jdQ.getPageContext(), i);
        if (this.isMemGroup) {
            ao.setViewTextColor(this.jeM, R.color.common_color_10009, 1);
        }
        if (!this.jeP) {
            b(this.jeN, this.jeO);
        }
        if (this.jeQ) {
            ao.setBackgroundResource(this.jeD, R.drawable.group_info_item);
        } else {
            ao.setBackgroundColor(this.jeD, R.color.cp_bg_line_d);
        }
    }

    public void qf(boolean z) {
        this.jeP = z;
    }
}
