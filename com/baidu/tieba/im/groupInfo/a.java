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
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int iFB = 0;
    private ScrollView bQQ;
    private View hdc;
    private TextView iDw;
    private final GroupInfoActivity iEA;
    private View iEB;
    private ProgressBar iEC;
    private RelativeLayout iED;
    private TextView iEE;
    private TextView iEF;
    private TextView iEG;
    private TextView iEH;
    private EllipsizingTextView iEI;
    private TextView iEJ;
    private RelativeLayout iEK;
    private PhotoWallView iEL;
    private RelativeLayout iEM;
    private RelativeLayout iEN;
    private LinearLayout iEO;
    private HeadImageView iEP;
    private TextView iEQ;
    private RelativeLayout iER;
    private com.baidu.tbadk.core.dialog.b iES;
    private ImageView iET;
    private final View iEU;
    private b.a iEV;
    private RelativeLayout iEW;
    private LinearLayout iEX;
    private HeadImageView[] iEY;
    private LinearLayout iEZ;
    private boolean iFA;
    private TextView iFa;
    private RelativeLayout iFb;
    private LinearLayout iFc;
    private com.baidu.tbadk.core.dialog.b iFd;
    private LinearLayout iFe;
    private i iFf;
    private b iFg;
    private TextView iFh;
    private String iFi;
    private ImageView iFj;
    private RelativeLayout iFk;
    private TextView iFl;
    private ImageView iFm;
    private RelativeLayout iFn;
    private RelativeLayout iFo;
    private ImageView iFp;
    private ImageView iFq;
    private View iFr;
    private TextView iFs;
    private TextView iFt;
    private LinearLayout iFu;
    private View iFv;
    private TextView iFw;
    private ResponseGroupInfoLocalMessage.a iFx;
    private boolean iFy;
    private boolean iFz;
    private boolean isMemGroup;
    private View itl;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.iES = null;
        this.iEV = null;
        this.iEY = new HeadImageView[5];
        this.iFi = "";
        this.iFy = true;
        this.isMemGroup = false;
        this.iFz = false;
        this.iFA = false;
        this.iEA = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.iEU = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bQQ.setVisibility(4);
        this.iEZ.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.iFl.setText(str);
        GD(str);
    }

    private void GD(String str) {
        if (str != null) {
            this.iFw.setText(str);
        }
    }

    public void GE(String str) {
        this.iEI.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.itl = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iFw = this.mNavigationBar.setTitleText("");
        this.iFv = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iFh = (TextView) this.iFv.findViewById(R.id.right_textview);
        this.iFh.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.iFh, R.color.cp_cont_f, 1);
        this.iFh.setOnClickListener(groupInfoActivity);
        this.iFv.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.iEB = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bQQ = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bQQ.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.hdc = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hdc.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.iED = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.iED.setOnClickListener(groupInfoActivity);
        this.iEE = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.iEF = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.iEW = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.iEW.setOnClickListener(groupInfoActivity);
        this.iFe = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.iFj = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.iEG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.iEH = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.iFp = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.iEI = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.iEI.setMaxLines(20);
        this.iEI.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void oa(boolean z) {
                if (z) {
                    a.this.iFs.setVisibility(0);
                } else {
                    a.this.iFs.setVisibility(8);
                }
            }
        });
        this.iEK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.iEJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.iEK.setOnClickListener(groupInfoActivity);
        this.iEP = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.iEP.setAutoChangeStyle(true);
        this.iEP.setIsRound(false);
        this.iDw = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.iEM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.iEM.setOnClickListener(groupInfoActivity);
        this.iET = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.iFr = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.iEO = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.iEK.setOnClickListener(groupInfoActivity);
        this.iEN = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.iEN.setOnClickListener(groupInfoActivity);
        this.iEQ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.iER = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.iER.setOnClickListener(groupInfoActivity);
        this.iEX = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.iEZ = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.iFu = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.iFa = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.iFu.setOnClickListener(this.iEA);
        this.iFb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.iFb.setOnClickListener(groupInfoActivity);
        this.iFc = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.iFk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.iFk.setOnClickListener(groupInfoActivity);
        this.iFl = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.iFm = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.iFq = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.iFn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.iFn.setOnClickListener(groupInfoActivity);
        this.iFn.setLongClickable(true);
        this.iFn.setOnLongClickListener(groupInfoActivity);
        this.iFs = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.iFs.setClickable(true);
        this.iFs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iEI.setMaxLines(1000);
            }
        });
        this.iFo = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.iFo.setOnLongClickListener(groupInfoActivity);
        this.iFt = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.iEC = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.iEL = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.iEL.setPhotoClickListener(groupInfoActivity);
        this.iEL.setPhotoLongClickListener(groupInfoActivity);
        this.iEL.setVisibility(8);
    }

    public RelativeLayout cnE() {
        return this.iFo;
    }

    public RelativeLayout cnF() {
        return this.iEK;
    }

    public LinearLayout cnG() {
        return this.iEX;
    }

    public RelativeLayout cnH() {
        return this.iFb;
    }

    public RelativeLayout cnI() {
        return this.iFn;
    }

    public RelativeLayout cnJ() {
        return this.iFk;
    }

    public RelativeLayout cnK() {
        return this.iED;
    }

    public View cnL() {
        return this.iFh;
    }

    public LinearLayout cnM() {
        return this.iFu;
    }

    public RelativeLayout cnN() {
        return this.iEM;
    }

    public RelativeLayout cnO() {
        return this.iEN;
    }

    public RelativeLayout cnP() {
        return this.iER;
    }

    public View cmy() {
        return this.itl;
    }

    public void cnQ() {
        this.iEC.setVisibility(8);
    }

    public void cnR() {
        this.iEC.setVisibility(0);
    }

    public void o(boolean z, String str) {
        if (z) {
            this.iEH.setText(str);
            this.iEW.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.iEW.setVisibility(8);
        } else {
            this.iEH.setText(str);
            this.iEW.setVisibility(0);
        }
    }

    public void pm(boolean z) {
        if (z) {
            this.iEH.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.iEW.setVisibility(8);
        }
    }

    public RelativeLayout cnS() {
        return this.iEW;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.iFz = aVar.coB();
            this.iFA = aVar.coC();
            this.iFx = aVar;
            this.iFy = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cow() != null) {
                iFB = aVar.cow().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.iFe.setVisibility(0);
            this.iEZ.setVisibility(0);
            if (aVar.getGroup() != null) {
                GD(aVar.getGroup().getName());
                this.iEG.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.iET.setVisibility(0);
                } else {
                    this.iET.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.iFj.setVisibility(0);
                    this.iEP.setVisibility(8);
                    this.iFq.setVisibility(8);
                    this.iFr.setVisibility(8);
                    this.iDw.setText(R.string.group_info_forum_author);
                    this.iEM.setEnabled(false);
                    this.iET.setVisibility(8);
                } else {
                    this.iFj.setVisibility(8);
                    this.iEP.setVisibility(0);
                    this.iFq.setVisibility(0);
                    this.iFr.setVisibility(0);
                    this.iDw.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.iEM.setEnabled(true);
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
                this.iFi = stringBuffer.toString();
                this.iEH.setText(this.iFi);
                this.iEI.setText(aVar.getGroup().getIntro());
                this.iEQ.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.iEP.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.iEK.setVisibility(0);
                    this.iEJ.setText(aVar.getGroup().getForumName() + this.iEA.getPageContext().getString(R.string.forum));
                } else {
                    this.iEK.setVisibility(8);
                }
                this.iEO.removeAllViews();
                boolean coD = aVar.coD();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.iFw, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.iEA.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.iEO.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.iEA.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.iEO.addView(imageView2);
                }
                if (coD) {
                    this.iFt.setVisibility(0);
                } else {
                    this.iFt.setVisibility(8);
                }
            }
            if (aVar.cow() != null) {
                this.iED.setVisibility(0);
                this.iEB.setVisibility(0);
                GroupActivityData cow = aVar.cow();
                if (!aVar.coB()) {
                    if (cow.getIsEnd() != 1) {
                        this.iEE.setVisibility(4);
                        this.iEF.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.iED.setVisibility(8);
                        this.iEB.setVisibility(8);
                    }
                } else {
                    this.iEE.setVisibility(0);
                    this.iEF.setText(cow.getgActivityTitle());
                    if (cow.getIsEnd() != 1) {
                        this.iEE.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.iEE, R.color.common_color_10171, 1);
                    } else {
                        this.iEE.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.iEE, R.color.common_color_10168, 1);
                    }
                    this.iEF.setText(cow.getgActivityTitle());
                }
            } else if (aVar.coC()) {
                this.iED.setVisibility(0);
                this.iEB.setVisibility(0);
                this.iEE.setVisibility(4);
                this.iEF.setText(R.string.group_info_create_activity);
            } else {
                this.iED.setVisibility(8);
                this.iEB.setVisibility(8);
            }
            this.iEX.removeAllViews();
            if (aVar.cox() != null && aVar.cox().size() > 0) {
                List<MemberData> cox = aVar.cox();
                int size = cox.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cox.get(i3);
                    HeadImageView headImageView = this.iEY[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.iEA.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.iEY[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.iEX.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.coC()) {
                this.iEW.setEnabled(true);
                this.iFn.setEnabled(true);
                am.setBackgroundResource(this.iFn, R.drawable.group_info_item);
                this.iFk.setVisibility(0);
                this.iFp.setVisibility(0);
                this.iFm.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.iFl.setText(aVar.getGroup().getName());
                }
            } else {
                this.iEW.setEnabled(false);
                this.iFn.setEnabled(true);
                am.setBackgroundColor(this.iFn, R.color.cp_bg_line_d);
                this.iFm.setVisibility(8);
                this.iFp.setVisibility(8);
                this.iEI.setPadding(0, 0, 0, 0);
            }
            if (aVar.coB()) {
                this.iFc.setVisibility(0);
                this.iFv.setVisibility(0);
                if (this.iER.getParent() != this.iFc) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.iFe.removeView(this.iER);
                    this.iFc.addView(this.iER, 1);
                }
                cnT();
            } else {
                this.iFc.setVisibility(8);
                this.iFv.setVisibility(8);
                if (this.iER.getParent() != this.iFe) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.iFc.removeView(this.iER);
                    this.iFe.addView(this.iER, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.iEN.setVisibility(8);
            } else {
                this.iEN.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                pm(aVar.coC());
            } else {
                o(aVar.coC(), this.iFi);
            }
            this.bQQ.setVisibility(0);
            this.iEZ.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (xQ(aVar.getGroup().getFlag())) {
                pn(z);
            } else {
                cnU();
            }
        }
    }

    public void cnT() {
        this.iFa.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.iFa, R.color.cp_cont_a, 1);
        this.iFa.setText(this.iEA.getPageContext().getString(R.string.i_want_talk));
        this.iFu.setEnabled(true);
    }

    private void pn(boolean z) {
        this.iFa.setText(this.iEA.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.iFa.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.iFa, R.color.cp_cont_a, 1);
        } else {
            this.iFa.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.iFa, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.iFu, R.drawable.btn_blue_bg);
        this.iFu.setEnabled(true);
    }

    private boolean xQ(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cnU() {
        this.iFa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.iFa.setText(this.iEA.getPageContext().getString(R.string.group_info_refuse_join));
        this.iFa.setTextColor(this.iEA.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.iFu, R.drawable.btn_app_download_d);
        this.iFu.setEnabled(false);
    }

    public void GF(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.iEX.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.iEX.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.iEX.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.iEL.setIsManager(aVar.coC());
            if (aVar.coC()) {
                this.iEL.setVisibility(0);
                if (aVar.coy() != null && aVar.coy().size() == 1 && TextUtils.isEmpty(aVar.coy().get(0).getPicId())) {
                    this.iEL.setData(null);
                } else {
                    this.iEL.setData(aVar.coy());
                }
            } else if (aVar.coy() != null && aVar.coy().size() > 0) {
                if (aVar.coy().size() == 1 && TextUtils.isEmpty(aVar.coy().get(0).getPicId())) {
                    this.iEL.setVisibility(8);
                    return;
                }
                this.iEL.setVisibility(0);
                this.iEL.setData(aVar.coy());
            } else {
                this.iEL.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.iFg = bVar;
    }

    public void d(Object obj, int i) {
        if (this.iFf != null) {
            this.iFf.dismiss();
            this.iFf = null;
        }
        e(obj, i);
        this.iFf.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.iFf == null) {
            this.iFf = new i(this.iEA.getPageContext());
            this.iFf.a(null, new String[]{this.iEA.getResources().getString(R.string.group_info_set_portrait), this.iEA.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.iFf != null && a.this.iFf.isShowing()) {
                        a.this.iFg.a(a.this.iFf, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.iEL != null) {
            this.iEL.onDestory();
        }
        if (this.iEP != null) {
            this.iEP.stopLoad();
            this.iEP.setBackgroundDrawable(null);
            this.iEP.setImageDrawable(null);
        }
        if (this.iEX != null && this.iEY != null) {
            int length = this.iEY.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.iEY[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void GG(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.iEA.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iEA.getPageContext().getPageActivity());
            bVar.vP(this.iEA.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.iEA.getSystemService("clipboard")).setText(str);
                        a.this.iEA.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.iEA.getPageContext());
            bVar.aSU();
        }
    }

    public void GH(String str) {
        if (this.iFd == null) {
            GI(str);
        }
        this.iFd.aSU();
    }

    private void GI(final String str) {
        if (this.iFd == null) {
            this.iFd = new com.baidu.tbadk.core.dialog.b(this.iEA.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.iEA.getPageContext().getString(R.string.copy_group_number)};
            this.iFd.vP(this.iEA.getPageContext().getString(R.string.operation));
            this.iFd.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.iEA.getSystemService("clipboard")).setText(str);
                        a.this.iEA.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.iFd.d(this.iEA.getPageContext());
        }
    }

    public void cnV() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.iFa.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.iFa.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.iEA.getLayoutMode().setNightMode(i == 1);
        this.iEA.getLayoutMode().onModeChanged(this.mContainer);
        this.iEA.getLayoutMode().onModeChanged(this.iEU);
        this.iEL.a(i, this.iEA);
        this.mNavigationBar.onChangeSkinType(this.iEA.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.iFw, R.color.common_color_10009, 1);
        }
        if (!this.iFz) {
            b(this.iFx, this.iFy);
        }
        if (this.iFA) {
            am.setBackgroundResource(this.iFn, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.iFn, R.color.cp_bg_line_d);
        }
    }

    public void po(boolean z) {
        this.iFz = z;
    }
}
