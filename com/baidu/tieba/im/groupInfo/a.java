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
    public static int hEM = 0;
    private ScrollView bjy;
    private View gei;
    private TextView hCH;
    private final GroupInfoActivity hDL;
    private View hDM;
    private ProgressBar hDN;
    private RelativeLayout hDO;
    private TextView hDP;
    private TextView hDQ;
    private TextView hDR;
    private TextView hDS;
    private EllipsizingTextView hDT;
    private TextView hDU;
    private RelativeLayout hDV;
    private PhotoWallView hDW;
    private RelativeLayout hDX;
    private RelativeLayout hDY;
    private LinearLayout hDZ;
    private ImageView hEA;
    private ImageView hEB;
    private View hEC;
    private TextView hED;
    private TextView hEE;
    private LinearLayout hEF;
    private View hEG;
    private TextView hEH;
    private ResponseGroupInfoLocalMessage.a hEI;
    private boolean hEJ;
    private boolean hEK;
    private boolean hEL;
    private HeadImageView hEa;
    private TextView hEb;
    private RelativeLayout hEc;
    private com.baidu.tbadk.core.dialog.b hEd;
    private ImageView hEe;
    private final View hEf;
    private b.a hEg;
    private RelativeLayout hEh;
    private LinearLayout hEi;
    private HeadImageView[] hEj;
    private LinearLayout hEk;
    private TextView hEl;
    private RelativeLayout hEm;
    private LinearLayout hEn;
    private com.baidu.tbadk.core.dialog.b hEo;
    private LinearLayout hEp;
    private i hEq;
    private b hEr;
    private TextView hEs;
    private String hEt;
    private ImageView hEu;
    private RelativeLayout hEv;
    private TextView hEw;
    private ImageView hEx;
    private RelativeLayout hEy;
    private RelativeLayout hEz;
    private View hsw;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hEd = null;
        this.hEg = null;
        this.hEj = new HeadImageView[5];
        this.hEt = "";
        this.hEJ = true;
        this.isMemGroup = false;
        this.hEK = false;
        this.hEL = false;
        this.hDL = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hEf = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bjy.setVisibility(4);
        this.hEk.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hEw.setText(str);
        Dj(str);
    }

    private void Dj(String str) {
        if (str != null) {
            this.hEH.setText(str);
        }
    }

    public void Dk(String str) {
        this.hDT.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.hsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEH = this.mNavigationBar.setTitleText("");
        this.hEG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hEs = (TextView) this.hEG.findViewById(R.id.right_textview);
        this.hEs.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hEs, R.color.cp_cont_f, 1);
        this.hEs.setOnClickListener(groupInfoActivity);
        this.hEG.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hDM = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bjy = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bjy.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gei = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gei.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hDO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hDO.setOnClickListener(groupInfoActivity);
        this.hDP = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hDQ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hEh = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hEh.setOnClickListener(groupInfoActivity);
        this.hEp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hEu = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hDR = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hDS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hEA = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hDT = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hDT.setMaxLines(20);
        this.hDT.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mv(boolean z) {
                if (z) {
                    a.this.hED.setVisibility(0);
                } else {
                    a.this.hED.setVisibility(8);
                }
            }
        });
        this.hDV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hDU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hDV.setOnClickListener(groupInfoActivity);
        this.hEa = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hEa.setAutoChangeStyle(true);
        this.hEa.setIsRound(false);
        this.hCH = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hDX = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hDX.setOnClickListener(groupInfoActivity);
        this.hEe = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hEC = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hDZ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hDV.setOnClickListener(groupInfoActivity);
        this.hDY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hDY.setOnClickListener(groupInfoActivity);
        this.hEb = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hEc = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hEc.setOnClickListener(groupInfoActivity);
        this.hEi = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hEk = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hEF = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hEl = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hEF.setOnClickListener(this.hDL);
        this.hEm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hEm.setOnClickListener(groupInfoActivity);
        this.hEn = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hEv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hEv.setOnClickListener(groupInfoActivity);
        this.hEw = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hEx = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hEB = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hEy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hEy.setOnClickListener(groupInfoActivity);
        this.hEy.setLongClickable(true);
        this.hEy.setOnLongClickListener(groupInfoActivity);
        this.hED = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hED.setClickable(true);
        this.hED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hDT.setMaxLines(1000);
            }
        });
        this.hEz = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hEz.setOnLongClickListener(groupInfoActivity);
        this.hEE = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hDN = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hDW = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hDW.setPhotoClickListener(groupInfoActivity);
        this.hDW.setPhotoLongClickListener(groupInfoActivity);
        this.hDW.setVisibility(8);
    }

    public RelativeLayout bWg() {
        return this.hEz;
    }

    public RelativeLayout bWh() {
        return this.hDV;
    }

    public LinearLayout bWi() {
        return this.hEi;
    }

    public RelativeLayout bWj() {
        return this.hEm;
    }

    public RelativeLayout bWk() {
        return this.hEy;
    }

    public RelativeLayout bWl() {
        return this.hEv;
    }

    public RelativeLayout bWm() {
        return this.hDO;
    }

    public View bWn() {
        return this.hEs;
    }

    public LinearLayout bWo() {
        return this.hEF;
    }

    public RelativeLayout bWp() {
        return this.hDX;
    }

    public RelativeLayout bWq() {
        return this.hDY;
    }

    public RelativeLayout bWr() {
        return this.hEc;
    }

    public View bVa() {
        return this.hsw;
    }

    public void bWs() {
        this.hDN.setVisibility(8);
    }

    public void bWt() {
        this.hDN.setVisibility(0);
    }

    public void n(boolean z, String str) {
        if (z) {
            this.hDS.setText(str);
            this.hEh.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hEh.setVisibility(8);
        } else {
            this.hDS.setText(str);
            this.hEh.setVisibility(0);
        }
    }

    public void nG(boolean z) {
        if (z) {
            this.hDS.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hEh.setVisibility(8);
        }
    }

    public RelativeLayout bWu() {
        return this.hEh;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hEK = aVar.bXd();
            this.hEL = aVar.bXe();
            this.hEI = aVar;
            this.hEJ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bWY() != null) {
                hEM = aVar.bWY().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hEp.setVisibility(0);
            this.hEk.setVisibility(0);
            if (aVar.getGroup() != null) {
                Dj(aVar.getGroup().getName());
                this.hDR.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hEe.setVisibility(0);
                } else {
                    this.hEe.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hEu.setVisibility(0);
                    this.hEa.setVisibility(8);
                    this.hEB.setVisibility(8);
                    this.hEC.setVisibility(8);
                    this.hCH.setText(R.string.group_info_forum_author);
                    this.hDX.setEnabled(false);
                    this.hEe.setVisibility(8);
                } else {
                    this.hEu.setVisibility(8);
                    this.hEa.setVisibility(0);
                    this.hEB.setVisibility(0);
                    this.hEC.setVisibility(0);
                    this.hCH.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hDX.setEnabled(true);
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
                this.hEt = stringBuffer.toString();
                this.hDS.setText(this.hEt);
                this.hDT.setText(aVar.getGroup().getIntro());
                this.hEb.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hEa.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hDV.setVisibility(0);
                    this.hDU.setText(aVar.getGroup().getForumName() + this.hDL.getPageContext().getString(R.string.forum));
                } else {
                    this.hDV.setVisibility(8);
                }
                this.hDZ.removeAllViews();
                boolean bXf = aVar.bXf();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hEH, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hDL.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hDZ.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hDL.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hDZ.addView(imageView2);
                }
                if (bXf) {
                    this.hEE.setVisibility(0);
                } else {
                    this.hEE.setVisibility(8);
                }
            }
            if (aVar.bWY() != null) {
                this.hDO.setVisibility(0);
                this.hDM.setVisibility(0);
                GroupActivityData bWY = aVar.bWY();
                if (!aVar.bXd()) {
                    if (bWY.getIsEnd() != 1) {
                        this.hDP.setVisibility(4);
                        this.hDQ.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hDO.setVisibility(8);
                        this.hDM.setVisibility(8);
                    }
                } else {
                    this.hDP.setVisibility(0);
                    this.hDQ.setText(bWY.getgActivityTitle());
                    if (bWY.getIsEnd() != 1) {
                        this.hDP.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hDP, R.color.common_color_10171, 1);
                    } else {
                        this.hDP.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hDP, R.color.common_color_10168, 1);
                    }
                    this.hDQ.setText(bWY.getgActivityTitle());
                }
            } else if (aVar.bXe()) {
                this.hDO.setVisibility(0);
                this.hDM.setVisibility(0);
                this.hDP.setVisibility(4);
                this.hDQ.setText(R.string.group_info_create_activity);
            } else {
                this.hDO.setVisibility(8);
                this.hDM.setVisibility(8);
            }
            this.hEi.removeAllViews();
            if (aVar.bWZ() != null && aVar.bWZ().size() > 0) {
                List<MemberData> bWZ = aVar.bWZ();
                int size = bWZ.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bWZ.get(i3);
                    HeadImageView headImageView = this.hEj[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hDL.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hEj[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hEi.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bXe()) {
                this.hEh.setEnabled(true);
                this.hEy.setEnabled(true);
                am.setBackgroundResource(this.hEy, R.drawable.group_info_item);
                this.hEv.setVisibility(0);
                this.hEA.setVisibility(0);
                this.hEx.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hEw.setText(aVar.getGroup().getName());
                }
            } else {
                this.hEh.setEnabled(false);
                this.hEy.setEnabled(true);
                am.setBackgroundColor(this.hEy, R.color.cp_bg_line_d);
                this.hEx.setVisibility(8);
                this.hEA.setVisibility(8);
                this.hDT.setPadding(0, 0, 0, 0);
            }
            if (aVar.bXd()) {
                this.hEn.setVisibility(0);
                this.hEG.setVisibility(0);
                if (this.hEc.getParent() != this.hEn) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hEp.removeView(this.hEc);
                    this.hEn.addView(this.hEc, 1);
                }
                bWv();
            } else {
                this.hEn.setVisibility(8);
                this.hEG.setVisibility(8);
                if (this.hEc.getParent() != this.hEp) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hEn.removeView(this.hEc);
                    this.hEp.addView(this.hEc, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hDY.setVisibility(8);
            } else {
                this.hDY.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                nG(aVar.bXe());
            } else {
                n(aVar.bXe(), this.hEt);
            }
            this.bjy.setVisibility(0);
            this.hEk.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (wC(aVar.getGroup().getFlag())) {
                nH(z);
            } else {
                bWw();
            }
        }
    }

    public void bWv() {
        this.hEl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hEl, R.color.cp_cont_a, 1);
        this.hEl.setText(this.hDL.getPageContext().getString(R.string.i_want_talk));
        this.hEF.setEnabled(true);
    }

    private void nH(boolean z) {
        this.hEl.setText(this.hDL.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hEl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hEl, R.color.cp_cont_a, 1);
        } else {
            this.hEl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hEl, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hEF, R.drawable.btn_blue_bg);
        this.hEF.setEnabled(true);
    }

    private boolean wC(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bWw() {
        this.hEl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hEl.setText(this.hDL.getPageContext().getString(R.string.group_info_refuse_join));
        this.hEl.setTextColor(this.hDL.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hEF, R.drawable.btn_app_download_d);
        this.hEF.setEnabled(false);
    }

    public void Dl(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hEi.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hEi.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hEi.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hDW.setIsManager(aVar.bXe());
            if (aVar.bXe()) {
                this.hDW.setVisibility(0);
                if (aVar.bXa() != null && aVar.bXa().size() == 1 && TextUtils.isEmpty(aVar.bXa().get(0).getPicId())) {
                    this.hDW.setData(null);
                } else {
                    this.hDW.setData(aVar.bXa());
                }
            } else if (aVar.bXa() != null && aVar.bXa().size() > 0) {
                if (aVar.bXa().size() == 1 && TextUtils.isEmpty(aVar.bXa().get(0).getPicId())) {
                    this.hDW.setVisibility(8);
                    return;
                }
                this.hDW.setVisibility(0);
                this.hDW.setData(aVar.bXa());
            } else {
                this.hDW.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hEr = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hEq != null) {
            this.hEq.dismiss();
            this.hEq = null;
        }
        d(obj, i);
        this.hEq.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hEq == null) {
            this.hEq = new i(this.hDL.getPageContext());
            this.hEq.a(null, new String[]{this.hDL.getResources().getString(R.string.group_info_set_portrait), this.hDL.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hEq != null && a.this.hEq.isShowing()) {
                        a.this.hEr.a(a.this.hEq, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hDW != null) {
            this.hDW.onDestory();
        }
        if (this.hEa != null) {
            this.hEa.stopLoad();
            this.hEa.setBackgroundDrawable(null);
            this.hEa.setImageDrawable(null);
        }
        if (this.hEi != null && this.hEj != null) {
            int length = this.hEj.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hEj[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Dm(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.hDL.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hDL.getPageContext().getPageActivity());
            bVar.sT(this.hDL.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDL.getSystemService("clipboard")).setText(str);
                        a.this.hDL.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hDL.getPageContext());
            bVar.aED();
        }
    }

    public void Dn(String str) {
        if (this.hEo == null) {
            Do(str);
        }
        this.hEo.aED();
    }

    private void Do(final String str) {
        if (this.hEo == null) {
            this.hEo = new com.baidu.tbadk.core.dialog.b(this.hDL.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hDL.getPageContext().getString(R.string.copy_group_number)};
            this.hEo.sT(this.hDL.getPageContext().getString(R.string.operation));
            this.hEo.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDL.getSystemService("clipboard")).setText(str);
                        a.this.hDL.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hEo.d(this.hDL.getPageContext());
        }
    }

    public void bWx() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hEl.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hEl.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hDL.getLayoutMode().setNightMode(i == 1);
        this.hDL.getLayoutMode().onModeChanged(this.mContainer);
        this.hDL.getLayoutMode().onModeChanged(this.hEf);
        this.hDW.a(i, this.hDL);
        this.mNavigationBar.onChangeSkinType(this.hDL.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hEH, R.color.common_color_10009, 1);
        }
        if (!this.hEK) {
            b(this.hEI, this.hEJ);
        }
        if (this.hEL) {
            am.setBackgroundResource(this.hEy, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hEy, R.color.cp_bg_line_d);
        }
    }

    public void nI(boolean z) {
        this.hEK = z;
    }
}
