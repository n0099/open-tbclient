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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes7.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int hyW = 0;
    private ScrollView bes;
    private View fYJ;
    private View hmG;
    private TextView hwR;
    private final GroupInfoActivity hxV;
    private View hxW;
    private ProgressBar hxX;
    private RelativeLayout hxY;
    private TextView hxZ;
    private i hyA;
    private b hyB;
    private TextView hyC;
    private String hyD;
    private ImageView hyE;
    private RelativeLayout hyF;
    private TextView hyG;
    private ImageView hyH;
    private RelativeLayout hyI;
    private RelativeLayout hyJ;
    private ImageView hyK;
    private ImageView hyL;
    private View hyM;
    private TextView hyN;
    private TextView hyO;
    private LinearLayout hyP;
    private View hyQ;
    private TextView hyR;
    private ResponseGroupInfoLocalMessage.a hyS;
    private boolean hyT;
    private boolean hyU;
    private boolean hyV;
    private TextView hya;
    private TextView hyb;
    private TextView hyc;
    private EllipsizingTextView hyd;
    private TextView hye;
    private RelativeLayout hyf;
    private PhotoWallView hyg;
    private RelativeLayout hyh;
    private RelativeLayout hyi;
    private LinearLayout hyj;
    private HeadImageView hyk;
    private TextView hyl;
    private RelativeLayout hym;
    private com.baidu.tbadk.core.dialog.b hyn;
    private ImageView hyo;
    private final View hyp;
    private b.a hyq;
    private RelativeLayout hyr;
    private LinearLayout hys;
    private HeadImageView[] hyt;
    private LinearLayout hyu;
    private TextView hyv;
    private RelativeLayout hyw;
    private LinearLayout hyx;
    private com.baidu.tbadk.core.dialog.b hyy;
    private LinearLayout hyz;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hyn = null;
        this.hyq = null;
        this.hyt = new HeadImageView[5];
        this.hyD = "";
        this.hyT = true;
        this.isMemGroup = false;
        this.hyU = false;
        this.hyV = false;
        this.hxV = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hyp = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bes.setVisibility(4);
        this.hyu.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hyG.setText(str);
        CI(str);
    }

    private void CI(String str) {
        if (str != null) {
            this.hyR.setText(str);
        }
    }

    public void CJ(String str) {
        this.hyd.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.hmG = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hyR = this.mNavigationBar.setTitleText("");
        this.hyQ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hyC = (TextView) this.hyQ.findViewById(R.id.right_textview);
        this.hyC.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hyC, R.color.cp_cont_f, 1);
        this.hyC.setOnClickListener(groupInfoActivity);
        this.hyQ.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hxW = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bes = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bes.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.fYJ = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fYJ.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hxY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hxY.setOnClickListener(groupInfoActivity);
        this.hxZ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hya = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hyr = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hyr.setOnClickListener(groupInfoActivity);
        this.hyz = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hyE = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hyb = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hyc = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hyK = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hyd = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hyd.setMaxLines(20);
        this.hyd.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mi(boolean z) {
                if (z) {
                    a.this.hyN.setVisibility(0);
                } else {
                    a.this.hyN.setVisibility(8);
                }
            }
        });
        this.hyf = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hye = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hyf.setOnClickListener(groupInfoActivity);
        this.hyk = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hyk.setAutoChangeStyle(true);
        this.hyk.setIsRound(false);
        this.hwR = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hyh = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hyh.setOnClickListener(groupInfoActivity);
        this.hyo = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hyM = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hyj = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hyf.setOnClickListener(groupInfoActivity);
        this.hyi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hyi.setOnClickListener(groupInfoActivity);
        this.hyl = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hym = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hym.setOnClickListener(groupInfoActivity);
        this.hys = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hyu = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hyP = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hyv = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hyP.setOnClickListener(this.hxV);
        this.hyw = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hyw.setOnClickListener(groupInfoActivity);
        this.hyx = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hyF = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hyF.setOnClickListener(groupInfoActivity);
        this.hyG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hyH = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hyL = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hyI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hyI.setOnClickListener(groupInfoActivity);
        this.hyI.setLongClickable(true);
        this.hyI.setOnLongClickListener(groupInfoActivity);
        this.hyN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hyN.setClickable(true);
        this.hyN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hyd.setMaxLines(1000);
            }
        });
        this.hyJ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hyJ.setOnLongClickListener(groupInfoActivity);
        this.hyO = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hxX = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hyg = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hyg.setPhotoClickListener(groupInfoActivity);
        this.hyg.setPhotoLongClickListener(groupInfoActivity);
        this.hyg.setVisibility(8);
    }

    public RelativeLayout bTt() {
        return this.hyJ;
    }

    public RelativeLayout bTu() {
        return this.hyf;
    }

    public LinearLayout bTv() {
        return this.hys;
    }

    public RelativeLayout bTw() {
        return this.hyw;
    }

    public RelativeLayout bTx() {
        return this.hyI;
    }

    public RelativeLayout bTy() {
        return this.hyF;
    }

    public RelativeLayout bTz() {
        return this.hxY;
    }

    public View bTA() {
        return this.hyC;
    }

    public LinearLayout bTB() {
        return this.hyP;
    }

    public RelativeLayout bTC() {
        return this.hyh;
    }

    public RelativeLayout bTD() {
        return this.hyi;
    }

    public RelativeLayout bTE() {
        return this.hym;
    }

    public View bSn() {
        return this.hmG;
    }

    public void bTF() {
        this.hxX.setVisibility(8);
    }

    public void bTG() {
        this.hxX.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.hyc.setText(str);
            this.hyr.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hyr.setVisibility(8);
        } else {
            this.hyc.setText(str);
            this.hyr.setVisibility(0);
        }
    }

    public void ns(boolean z) {
        if (z) {
            this.hyc.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hyr.setVisibility(8);
        }
    }

    public RelativeLayout bTH() {
        return this.hyr;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hyU = aVar.bUq();
            this.hyV = aVar.bUr();
            this.hyS = aVar;
            this.hyT = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bUl() != null) {
                hyW = aVar.bUl().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hyz.setVisibility(0);
            this.hyu.setVisibility(0);
            if (aVar.getGroup() != null) {
                CI(aVar.getGroup().getName());
                this.hyb.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hyo.setVisibility(0);
                } else {
                    this.hyo.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hyE.setVisibility(0);
                    this.hyk.setVisibility(8);
                    this.hyL.setVisibility(8);
                    this.hyM.setVisibility(8);
                    this.hwR.setText(R.string.group_info_forum_author);
                    this.hyh.setEnabled(false);
                    this.hyo.setVisibility(8);
                } else {
                    this.hyE.setVisibility(8);
                    this.hyk.setVisibility(0);
                    this.hyL.setVisibility(0);
                    this.hyM.setVisibility(0);
                    this.hwR.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hyh.setEnabled(true);
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
                this.hyD = stringBuffer.toString();
                this.hyc.setText(this.hyD);
                this.hyd.setText(aVar.getGroup().getIntro());
                this.hyl.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hyk.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hyf.setVisibility(0);
                    this.hye.setText(aVar.getGroup().getForumName() + this.hxV.getPageContext().getString(R.string.forum));
                } else {
                    this.hyf.setVisibility(8);
                }
                this.hyj.removeAllViews();
                boolean bUs = aVar.bUs();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hyR, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hxV.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hyj.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hxV.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hyj.addView(imageView2);
                }
                if (bUs) {
                    this.hyO.setVisibility(0);
                } else {
                    this.hyO.setVisibility(8);
                }
            }
            if (aVar.bUl() != null) {
                this.hxY.setVisibility(0);
                this.hxW.setVisibility(0);
                GroupActivityData bUl = aVar.bUl();
                if (!aVar.bUq()) {
                    if (bUl.getIsEnd() != 1) {
                        this.hxZ.setVisibility(4);
                        this.hya.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hxY.setVisibility(8);
                        this.hxW.setVisibility(8);
                    }
                } else {
                    this.hxZ.setVisibility(0);
                    this.hya.setText(bUl.getgActivityTitle());
                    if (bUl.getIsEnd() != 1) {
                        this.hxZ.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hxZ, R.color.common_color_10171, 1);
                    } else {
                        this.hxZ.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hxZ, R.color.common_color_10168, 1);
                    }
                    this.hya.setText(bUl.getgActivityTitle());
                }
            } else if (aVar.bUr()) {
                this.hxY.setVisibility(0);
                this.hxW.setVisibility(0);
                this.hxZ.setVisibility(4);
                this.hya.setText(R.string.group_info_create_activity);
            } else {
                this.hxY.setVisibility(8);
                this.hxW.setVisibility(8);
            }
            this.hys.removeAllViews();
            if (aVar.bUm() != null && aVar.bUm().size() > 0) {
                List<MemberData> bUm = aVar.bUm();
                int size = bUm.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bUm.get(i3);
                    HeadImageView headImageView = this.hyt[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hxV.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hyt[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hys.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bUr()) {
                this.hyr.setEnabled(true);
                this.hyI.setEnabled(true);
                am.setBackgroundResource(this.hyI, R.drawable.group_info_item);
                this.hyF.setVisibility(0);
                this.hyK.setVisibility(0);
                this.hyH.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hyG.setText(aVar.getGroup().getName());
                }
            } else {
                this.hyr.setEnabled(false);
                this.hyI.setEnabled(true);
                am.setBackgroundColor(this.hyI, R.color.cp_bg_line_d);
                this.hyH.setVisibility(8);
                this.hyK.setVisibility(8);
                this.hyd.setPadding(0, 0, 0, 0);
            }
            if (aVar.bUq()) {
                this.hyx.setVisibility(0);
                this.hyQ.setVisibility(0);
                if (this.hym.getParent() != this.hyx) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hyz.removeView(this.hym);
                    this.hyx.addView(this.hym, 1);
                }
                bTI();
            } else {
                this.hyx.setVisibility(8);
                this.hyQ.setVisibility(8);
                if (this.hym.getParent() != this.hyz) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hyx.removeView(this.hym);
                    this.hyz.addView(this.hym, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hyi.setVisibility(8);
            } else {
                this.hyi.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                ns(aVar.bUr());
            } else {
                m(aVar.bUr(), this.hyD);
            }
            this.bes.setVisibility(0);
            this.hyu.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (wr(aVar.getGroup().getFlag())) {
                nt(z);
            } else {
                bTJ();
            }
        }
    }

    public void bTI() {
        this.hyv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hyv, R.color.cp_cont_a, 1);
        this.hyv.setText(this.hxV.getPageContext().getString(R.string.i_want_talk));
        this.hyP.setEnabled(true);
    }

    private void nt(boolean z) {
        this.hyv.setText(this.hxV.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hyv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hyv, R.color.cp_cont_a, 1);
        } else {
            this.hyv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hyv, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hyP, R.drawable.btn_blue_bg);
        this.hyP.setEnabled(true);
    }

    private boolean wr(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bTJ() {
        this.hyv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hyv.setText(this.hxV.getPageContext().getString(R.string.group_info_refuse_join));
        this.hyv.setTextColor(this.hxV.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hyP, R.drawable.btn_app_download_d);
        this.hyP.setEnabled(false);
    }

    public void CK(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hys.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hys.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hys.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hyg.setIsManager(aVar.bUr());
            if (aVar.bUr()) {
                this.hyg.setVisibility(0);
                if (aVar.bUn() != null && aVar.bUn().size() == 1 && TextUtils.isEmpty(aVar.bUn().get(0).getPicId())) {
                    this.hyg.setData(null);
                } else {
                    this.hyg.setData(aVar.bUn());
                }
            } else if (aVar.bUn() != null && aVar.bUn().size() > 0) {
                if (aVar.bUn().size() == 1 && TextUtils.isEmpty(aVar.bUn().get(0).getPicId())) {
                    this.hyg.setVisibility(8);
                    return;
                }
                this.hyg.setVisibility(0);
                this.hyg.setData(aVar.bUn());
            } else {
                this.hyg.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hyB = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hyA != null) {
            this.hyA.dismiss();
            this.hyA = null;
        }
        d(obj, i);
        this.hyA.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hyA == null) {
            this.hyA = new i(this.hxV.getPageContext());
            this.hyA.a(null, new String[]{this.hxV.getResources().getString(R.string.group_info_set_portrait), this.hxV.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hyA != null && a.this.hyA.isShowing()) {
                        a.this.hyB.a(a.this.hyA, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hyg != null) {
            this.hyg.onDestory();
        }
        if (this.hyk != null) {
            this.hyk.stopLoad();
            this.hyk.setBackgroundDrawable(null);
            this.hyk.setImageDrawable(null);
        }
        if (this.hys != null && this.hyt != null) {
            int length = this.hyt.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hyt[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void CL(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.hxV.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hxV.getPageContext().getPageActivity());
            bVar.sA(this.hxV.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hxV.getSystemService("clipboard")).setText(str);
                        a.this.hxV.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hxV.getPageContext());
            bVar.aBX();
        }
    }

    public void CM(String str) {
        if (this.hyy == null) {
            CN(str);
        }
        this.hyy.aBX();
    }

    private void CN(final String str) {
        if (this.hyy == null) {
            this.hyy = new com.baidu.tbadk.core.dialog.b(this.hxV.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hxV.getPageContext().getString(R.string.copy_group_number)};
            this.hyy.sA(this.hxV.getPageContext().getString(R.string.operation));
            this.hyy.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hxV.getSystemService("clipboard")).setText(str);
                        a.this.hxV.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hyy.d(this.hxV.getPageContext());
        }
    }

    public void bTK() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hyv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hyv.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hxV.getLayoutMode().setNightMode(i == 1);
        this.hxV.getLayoutMode().onModeChanged(this.mContainer);
        this.hxV.getLayoutMode().onModeChanged(this.hyp);
        this.hyg.a(i, this.hxV);
        this.mNavigationBar.onChangeSkinType(this.hxV.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hyR, R.color.common_color_10009, 1);
        }
        if (!this.hyU) {
            b(this.hyS, this.hyT);
        }
        if (this.hyV) {
            am.setBackgroundResource(this.hyI, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hyI, R.color.cp_bg_line_d);
        }
    }

    public void nu(boolean z) {
        this.hyU = z;
    }
}
