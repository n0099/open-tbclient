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
    public static int iEO = 0;
    private ScrollView bQQ;
    private View hcR;
    private TextView iCJ;
    private final GroupInfoActivity iDN;
    private View iDO;
    private ProgressBar iDP;
    private RelativeLayout iDQ;
    private TextView iDR;
    private TextView iDS;
    private TextView iDT;
    private TextView iDU;
    private EllipsizingTextView iDV;
    private TextView iDW;
    private RelativeLayout iDX;
    private PhotoWallView iDY;
    private RelativeLayout iDZ;
    private RelativeLayout iEA;
    private RelativeLayout iEB;
    private ImageView iEC;
    private ImageView iED;
    private View iEE;
    private TextView iEF;
    private TextView iEG;
    private LinearLayout iEH;
    private View iEI;
    private TextView iEJ;
    private ResponseGroupInfoLocalMessage.a iEK;
    private boolean iEL;
    private boolean iEM;
    private boolean iEN;
    private RelativeLayout iEa;
    private LinearLayout iEb;
    private HeadImageView iEc;
    private TextView iEd;
    private RelativeLayout iEe;
    private com.baidu.tbadk.core.dialog.b iEf;
    private ImageView iEg;
    private final View iEh;
    private b.a iEi;
    private RelativeLayout iEj;
    private LinearLayout iEk;
    private HeadImageView[] iEl;
    private LinearLayout iEm;
    private TextView iEn;
    private RelativeLayout iEo;
    private LinearLayout iEp;
    private com.baidu.tbadk.core.dialog.b iEq;
    private LinearLayout iEr;
    private i iEs;
    private b iEt;
    private TextView iEu;
    private String iEv;
    private ImageView iEw;
    private RelativeLayout iEx;
    private TextView iEy;
    private ImageView iEz;
    private boolean isMemGroup;
    private View isy;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.iEf = null;
        this.iEi = null;
        this.iEl = new HeadImageView[5];
        this.iEv = "";
        this.iEL = true;
        this.isMemGroup = false;
        this.iEM = false;
        this.iEN = false;
        this.iDN = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.iEh = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bQQ.setVisibility(4);
        this.iEm.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.iEy.setText(str);
        GD(str);
    }

    private void GD(String str) {
        if (str != null) {
            this.iEJ.setText(str);
        }
    }

    public void GE(String str) {
        this.iDV.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.isy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iEJ = this.mNavigationBar.setTitleText("");
        this.iEI = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iEu = (TextView) this.iEI.findViewById(R.id.right_textview);
        this.iEu.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.iEu, R.color.cp_cont_f, 1);
        this.iEu.setOnClickListener(groupInfoActivity);
        this.iEI.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.iDO = groupInfoActivity.findViewById(R.id.line_activity_name_down);
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
        this.hcR = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hcR.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.iDQ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.iDQ.setOnClickListener(groupInfoActivity);
        this.iDR = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.iDS = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.iEj = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.iEj.setOnClickListener(groupInfoActivity);
        this.iEr = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.iEw = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.iDT = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.iDU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.iEC = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.iDV = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.iDV.setMaxLines(20);
        this.iDV.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void oa(boolean z) {
                if (z) {
                    a.this.iEF.setVisibility(0);
                } else {
                    a.this.iEF.setVisibility(8);
                }
            }
        });
        this.iDX = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.iDW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.iDX.setOnClickListener(groupInfoActivity);
        this.iEc = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.iEc.setAutoChangeStyle(true);
        this.iEc.setIsRound(false);
        this.iCJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.iDZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.iDZ.setOnClickListener(groupInfoActivity);
        this.iEg = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.iEE = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.iEb = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.iDX.setOnClickListener(groupInfoActivity);
        this.iEa = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.iEa.setOnClickListener(groupInfoActivity);
        this.iEd = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.iEe = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.iEe.setOnClickListener(groupInfoActivity);
        this.iEk = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.iEm = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.iEH = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.iEn = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.iEH.setOnClickListener(this.iDN);
        this.iEo = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.iEo.setOnClickListener(groupInfoActivity);
        this.iEp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.iEx = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.iEx.setOnClickListener(groupInfoActivity);
        this.iEy = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.iEz = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.iED = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.iEA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.iEA.setOnClickListener(groupInfoActivity);
        this.iEA.setLongClickable(true);
        this.iEA.setOnLongClickListener(groupInfoActivity);
        this.iEF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.iEF.setClickable(true);
        this.iEF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iDV.setMaxLines(1000);
            }
        });
        this.iEB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.iEB.setOnLongClickListener(groupInfoActivity);
        this.iEG = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.iDP = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.iDY = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.iDY.setPhotoClickListener(groupInfoActivity);
        this.iDY.setPhotoLongClickListener(groupInfoActivity);
        this.iDY.setVisibility(8);
    }

    public RelativeLayout cnv() {
        return this.iEB;
    }

    public RelativeLayout cnw() {
        return this.iDX;
    }

    public LinearLayout cnx() {
        return this.iEk;
    }

    public RelativeLayout cny() {
        return this.iEo;
    }

    public RelativeLayout cnz() {
        return this.iEA;
    }

    public RelativeLayout cnA() {
        return this.iEx;
    }

    public RelativeLayout cnB() {
        return this.iDQ;
    }

    public View cnC() {
        return this.iEu;
    }

    public LinearLayout cnD() {
        return this.iEH;
    }

    public RelativeLayout cnE() {
        return this.iDZ;
    }

    public RelativeLayout cnF() {
        return this.iEa;
    }

    public RelativeLayout cnG() {
        return this.iEe;
    }

    public View cmp() {
        return this.isy;
    }

    public void cnH() {
        this.iDP.setVisibility(8);
    }

    public void cnI() {
        this.iDP.setVisibility(0);
    }

    public void o(boolean z, String str) {
        if (z) {
            this.iDU.setText(str);
            this.iEj.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.iEj.setVisibility(8);
        } else {
            this.iDU.setText(str);
            this.iEj.setVisibility(0);
        }
    }

    public void pm(boolean z) {
        if (z) {
            this.iDU.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.iEj.setVisibility(8);
        }
    }

    public RelativeLayout cnJ() {
        return this.iEj;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.iEM = aVar.cos();
            this.iEN = aVar.cot();
            this.iEK = aVar;
            this.iEL = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.con() != null) {
                iEO = aVar.con().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.iEr.setVisibility(0);
            this.iEm.setVisibility(0);
            if (aVar.getGroup() != null) {
                GD(aVar.getGroup().getName());
                this.iDT.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.iEg.setVisibility(0);
                } else {
                    this.iEg.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.iEw.setVisibility(0);
                    this.iEc.setVisibility(8);
                    this.iED.setVisibility(8);
                    this.iEE.setVisibility(8);
                    this.iCJ.setText(R.string.group_info_forum_author);
                    this.iDZ.setEnabled(false);
                    this.iEg.setVisibility(8);
                } else {
                    this.iEw.setVisibility(8);
                    this.iEc.setVisibility(0);
                    this.iED.setVisibility(0);
                    this.iEE.setVisibility(0);
                    this.iCJ.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.iDZ.setEnabled(true);
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
                this.iEv = stringBuffer.toString();
                this.iDU.setText(this.iEv);
                this.iDV.setText(aVar.getGroup().getIntro());
                this.iEd.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.iEc.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.iDX.setVisibility(0);
                    this.iDW.setText(aVar.getGroup().getForumName() + this.iDN.getPageContext().getString(R.string.forum));
                } else {
                    this.iDX.setVisibility(8);
                }
                this.iEb.removeAllViews();
                boolean cou = aVar.cou();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.iEJ, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.iDN.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.iEb.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.iDN.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.iEb.addView(imageView2);
                }
                if (cou) {
                    this.iEG.setVisibility(0);
                } else {
                    this.iEG.setVisibility(8);
                }
            }
            if (aVar.con() != null) {
                this.iDQ.setVisibility(0);
                this.iDO.setVisibility(0);
                GroupActivityData con = aVar.con();
                if (!aVar.cos()) {
                    if (con.getIsEnd() != 1) {
                        this.iDR.setVisibility(4);
                        this.iDS.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.iDQ.setVisibility(8);
                        this.iDO.setVisibility(8);
                    }
                } else {
                    this.iDR.setVisibility(0);
                    this.iDS.setText(con.getgActivityTitle());
                    if (con.getIsEnd() != 1) {
                        this.iDR.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.iDR, R.color.common_color_10171, 1);
                    } else {
                        this.iDR.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.iDR, R.color.common_color_10168, 1);
                    }
                    this.iDS.setText(con.getgActivityTitle());
                }
            } else if (aVar.cot()) {
                this.iDQ.setVisibility(0);
                this.iDO.setVisibility(0);
                this.iDR.setVisibility(4);
                this.iDS.setText(R.string.group_info_create_activity);
            } else {
                this.iDQ.setVisibility(8);
                this.iDO.setVisibility(8);
            }
            this.iEk.removeAllViews();
            if (aVar.coo() != null && aVar.coo().size() > 0) {
                List<MemberData> coo = aVar.coo();
                int size = coo.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = coo.get(i3);
                    HeadImageView headImageView = this.iEl[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.iDN.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.iEl[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.iEk.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cot()) {
                this.iEj.setEnabled(true);
                this.iEA.setEnabled(true);
                am.setBackgroundResource(this.iEA, R.drawable.group_info_item);
                this.iEx.setVisibility(0);
                this.iEC.setVisibility(0);
                this.iEz.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.iEy.setText(aVar.getGroup().getName());
                }
            } else {
                this.iEj.setEnabled(false);
                this.iEA.setEnabled(true);
                am.setBackgroundColor(this.iEA, R.color.cp_bg_line_d);
                this.iEz.setVisibility(8);
                this.iEC.setVisibility(8);
                this.iDV.setPadding(0, 0, 0, 0);
            }
            if (aVar.cos()) {
                this.iEp.setVisibility(0);
                this.iEI.setVisibility(0);
                if (this.iEe.getParent() != this.iEp) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.iEr.removeView(this.iEe);
                    this.iEp.addView(this.iEe, 1);
                }
                cnK();
            } else {
                this.iEp.setVisibility(8);
                this.iEI.setVisibility(8);
                if (this.iEe.getParent() != this.iEr) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.iEp.removeView(this.iEe);
                    this.iEr.addView(this.iEe, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.iEa.setVisibility(8);
            } else {
                this.iEa.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                pm(aVar.cot());
            } else {
                o(aVar.cot(), this.iEv);
            }
            this.bQQ.setVisibility(0);
            this.iEm.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (xO(aVar.getGroup().getFlag())) {
                pn(z);
            } else {
                cnL();
            }
        }
    }

    public void cnK() {
        this.iEn.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.iEn, R.color.cp_cont_a, 1);
        this.iEn.setText(this.iDN.getPageContext().getString(R.string.i_want_talk));
        this.iEH.setEnabled(true);
    }

    private void pn(boolean z) {
        this.iEn.setText(this.iDN.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.iEn.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.iEn, R.color.cp_cont_a, 1);
        } else {
            this.iEn.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.iEn, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.iEH, R.drawable.btn_blue_bg);
        this.iEH.setEnabled(true);
    }

    private boolean xO(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cnL() {
        this.iEn.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.iEn.setText(this.iDN.getPageContext().getString(R.string.group_info_refuse_join));
        this.iEn.setTextColor(this.iDN.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.iEH, R.drawable.btn_app_download_d);
        this.iEH.setEnabled(false);
    }

    public void GF(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.iEk.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.iEk.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.iEk.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.iDY.setIsManager(aVar.cot());
            if (aVar.cot()) {
                this.iDY.setVisibility(0);
                if (aVar.cop() != null && aVar.cop().size() == 1 && TextUtils.isEmpty(aVar.cop().get(0).getPicId())) {
                    this.iDY.setData(null);
                } else {
                    this.iDY.setData(aVar.cop());
                }
            } else if (aVar.cop() != null && aVar.cop().size() > 0) {
                if (aVar.cop().size() == 1 && TextUtils.isEmpty(aVar.cop().get(0).getPicId())) {
                    this.iDY.setVisibility(8);
                    return;
                }
                this.iDY.setVisibility(0);
                this.iDY.setData(aVar.cop());
            } else {
                this.iDY.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.iEt = bVar;
    }

    public void d(Object obj, int i) {
        if (this.iEs != null) {
            this.iEs.dismiss();
            this.iEs = null;
        }
        e(obj, i);
        this.iEs.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.iEs == null) {
            this.iEs = new i(this.iDN.getPageContext());
            this.iEs.a(null, new String[]{this.iDN.getResources().getString(R.string.group_info_set_portrait), this.iDN.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.iEs != null && a.this.iEs.isShowing()) {
                        a.this.iEt.a(a.this.iEs, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.iDY != null) {
            this.iDY.onDestory();
        }
        if (this.iEc != null) {
            this.iEc.stopLoad();
            this.iEc.setBackgroundDrawable(null);
            this.iEc.setImageDrawable(null);
        }
        if (this.iEk != null && this.iEl != null) {
            int length = this.iEl.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.iEl[i];
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
            CharSequence[] charSequenceArr = {this.iDN.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iDN.getPageContext().getPageActivity());
            bVar.vP(this.iDN.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.iDN.getSystemService("clipboard")).setText(str);
                        a.this.iDN.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.iDN.getPageContext());
            bVar.aSU();
        }
    }

    public void GH(String str) {
        if (this.iEq == null) {
            GI(str);
        }
        this.iEq.aSU();
    }

    private void GI(final String str) {
        if (this.iEq == null) {
            this.iEq = new com.baidu.tbadk.core.dialog.b(this.iDN.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.iDN.getPageContext().getString(R.string.copy_group_number)};
            this.iEq.vP(this.iDN.getPageContext().getString(R.string.operation));
            this.iEq.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.iDN.getSystemService("clipboard")).setText(str);
                        a.this.iDN.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.iEq.d(this.iDN.getPageContext());
        }
    }

    public void cnM() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.iEn.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.iEn.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.iDN.getLayoutMode().setNightMode(i == 1);
        this.iDN.getLayoutMode().onModeChanged(this.mContainer);
        this.iDN.getLayoutMode().onModeChanged(this.iEh);
        this.iDY.a(i, this.iDN);
        this.mNavigationBar.onChangeSkinType(this.iDN.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.iEJ, R.color.common_color_10009, 1);
        }
        if (!this.iEM) {
            b(this.iEK, this.iEL);
        }
        if (this.iEN) {
            am.setBackgroundResource(this.iEA, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.iEA, R.color.cp_bg_line_d);
        }
    }

    public void po(boolean z) {
        this.iEM = z;
    }
}
