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
    public static int hEA = 0;
    private ScrollView bjx;
    private View gdV;
    private TextView hCv;
    private View hDA;
    private ProgressBar hDB;
    private RelativeLayout hDC;
    private TextView hDD;
    private TextView hDE;
    private TextView hDF;
    private TextView hDG;
    private EllipsizingTextView hDH;
    private TextView hDI;
    private RelativeLayout hDJ;
    private PhotoWallView hDK;
    private RelativeLayout hDL;
    private RelativeLayout hDM;
    private LinearLayout hDN;
    private HeadImageView hDO;
    private TextView hDP;
    private RelativeLayout hDQ;
    private com.baidu.tbadk.core.dialog.b hDR;
    private ImageView hDS;
    private final View hDT;
    private b.a hDU;
    private RelativeLayout hDV;
    private LinearLayout hDW;
    private HeadImageView[] hDX;
    private LinearLayout hDY;
    private TextView hDZ;
    private final GroupInfoActivity hDz;
    private RelativeLayout hEa;
    private LinearLayout hEb;
    private com.baidu.tbadk.core.dialog.b hEc;
    private LinearLayout hEd;
    private i hEe;
    private b hEf;
    private TextView hEg;
    private String hEh;
    private ImageView hEi;
    private RelativeLayout hEj;
    private TextView hEk;
    private ImageView hEl;
    private RelativeLayout hEm;
    private RelativeLayout hEn;
    private ImageView hEo;
    private ImageView hEp;
    private View hEq;
    private TextView hEr;
    private TextView hEs;
    private LinearLayout hEt;
    private View hEu;
    private TextView hEv;
    private ResponseGroupInfoLocalMessage.a hEw;
    private boolean hEx;
    private boolean hEy;
    private boolean hEz;
    private View hsk;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hDR = null;
        this.hDU = null;
        this.hDX = new HeadImageView[5];
        this.hEh = "";
        this.hEx = true;
        this.isMemGroup = false;
        this.hEy = false;
        this.hEz = false;
        this.hDz = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hDT = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bjx.setVisibility(4);
        this.hDY.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hEk.setText(str);
        Di(str);
    }

    private void Di(String str) {
        if (str != null) {
            this.hEv.setText(str);
        }
    }

    public void Dj(String str) {
        this.hDH.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.hsk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEv = this.mNavigationBar.setTitleText("");
        this.hEu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hEg = (TextView) this.hEu.findViewById(R.id.right_textview);
        this.hEg.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hEg, R.color.cp_cont_f, 1);
        this.hEg.setOnClickListener(groupInfoActivity);
        this.hEu.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hDA = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bjx = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bjx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gdV = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gdV.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hDC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hDC.setOnClickListener(groupInfoActivity);
        this.hDD = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hDE = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hDV = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hDV.setOnClickListener(groupInfoActivity);
        this.hEd = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hEi = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hDF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hDG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hEo = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hDH = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hDH.setMaxLines(20);
        this.hDH.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mv(boolean z) {
                if (z) {
                    a.this.hEr.setVisibility(0);
                } else {
                    a.this.hEr.setVisibility(8);
                }
            }
        });
        this.hDJ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hDI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hDJ.setOnClickListener(groupInfoActivity);
        this.hDO = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hDO.setAutoChangeStyle(true);
        this.hDO.setIsRound(false);
        this.hCv = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hDL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hDL.setOnClickListener(groupInfoActivity);
        this.hDS = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hEq = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hDN = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hDJ.setOnClickListener(groupInfoActivity);
        this.hDM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hDM.setOnClickListener(groupInfoActivity);
        this.hDP = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hDQ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hDQ.setOnClickListener(groupInfoActivity);
        this.hDW = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hDY = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hEt = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hDZ = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hEt.setOnClickListener(this.hDz);
        this.hEa = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hEa.setOnClickListener(groupInfoActivity);
        this.hEb = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hEj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hEj.setOnClickListener(groupInfoActivity);
        this.hEk = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hEl = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hEp = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hEm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hEm.setOnClickListener(groupInfoActivity);
        this.hEm.setLongClickable(true);
        this.hEm.setOnLongClickListener(groupInfoActivity);
        this.hEr = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hEr.setClickable(true);
        this.hEr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hDH.setMaxLines(1000);
            }
        });
        this.hEn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hEn.setOnLongClickListener(groupInfoActivity);
        this.hEs = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hDB = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hDK = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hDK.setPhotoClickListener(groupInfoActivity);
        this.hDK.setPhotoLongClickListener(groupInfoActivity);
        this.hDK.setVisibility(8);
    }

    public RelativeLayout bWf() {
        return this.hEn;
    }

    public RelativeLayout bWg() {
        return this.hDJ;
    }

    public LinearLayout bWh() {
        return this.hDW;
    }

    public RelativeLayout bWi() {
        return this.hEa;
    }

    public RelativeLayout bWj() {
        return this.hEm;
    }

    public RelativeLayout bWk() {
        return this.hEj;
    }

    public RelativeLayout bWl() {
        return this.hDC;
    }

    public View bWm() {
        return this.hEg;
    }

    public LinearLayout bWn() {
        return this.hEt;
    }

    public RelativeLayout bWo() {
        return this.hDL;
    }

    public RelativeLayout bWp() {
        return this.hDM;
    }

    public RelativeLayout bWq() {
        return this.hDQ;
    }

    public View bUZ() {
        return this.hsk;
    }

    public void bWr() {
        this.hDB.setVisibility(8);
    }

    public void bWs() {
        this.hDB.setVisibility(0);
    }

    public void n(boolean z, String str) {
        if (z) {
            this.hDG.setText(str);
            this.hDV.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hDV.setVisibility(8);
        } else {
            this.hDG.setText(str);
            this.hDV.setVisibility(0);
        }
    }

    public void nG(boolean z) {
        if (z) {
            this.hDG.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hDV.setVisibility(8);
        }
    }

    public RelativeLayout bWt() {
        return this.hDV;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hEy = aVar.bXc();
            this.hEz = aVar.bXd();
            this.hEw = aVar;
            this.hEx = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bWX() != null) {
                hEA = aVar.bWX().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hEd.setVisibility(0);
            this.hDY.setVisibility(0);
            if (aVar.getGroup() != null) {
                Di(aVar.getGroup().getName());
                this.hDF.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hDS.setVisibility(0);
                } else {
                    this.hDS.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hEi.setVisibility(0);
                    this.hDO.setVisibility(8);
                    this.hEp.setVisibility(8);
                    this.hEq.setVisibility(8);
                    this.hCv.setText(R.string.group_info_forum_author);
                    this.hDL.setEnabled(false);
                    this.hDS.setVisibility(8);
                } else {
                    this.hEi.setVisibility(8);
                    this.hDO.setVisibility(0);
                    this.hEp.setVisibility(0);
                    this.hEq.setVisibility(0);
                    this.hCv.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hDL.setEnabled(true);
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
                this.hEh = stringBuffer.toString();
                this.hDG.setText(this.hEh);
                this.hDH.setText(aVar.getGroup().getIntro());
                this.hDP.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hDO.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hDJ.setVisibility(0);
                    this.hDI.setText(aVar.getGroup().getForumName() + this.hDz.getPageContext().getString(R.string.forum));
                } else {
                    this.hDJ.setVisibility(8);
                }
                this.hDN.removeAllViews();
                boolean bXe = aVar.bXe();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hEv, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hDz.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hDN.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hDz.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hDN.addView(imageView2);
                }
                if (bXe) {
                    this.hEs.setVisibility(0);
                } else {
                    this.hEs.setVisibility(8);
                }
            }
            if (aVar.bWX() != null) {
                this.hDC.setVisibility(0);
                this.hDA.setVisibility(0);
                GroupActivityData bWX = aVar.bWX();
                if (!aVar.bXc()) {
                    if (bWX.getIsEnd() != 1) {
                        this.hDD.setVisibility(4);
                        this.hDE.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hDC.setVisibility(8);
                        this.hDA.setVisibility(8);
                    }
                } else {
                    this.hDD.setVisibility(0);
                    this.hDE.setText(bWX.getgActivityTitle());
                    if (bWX.getIsEnd() != 1) {
                        this.hDD.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hDD, R.color.common_color_10171, 1);
                    } else {
                        this.hDD.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hDD, R.color.common_color_10168, 1);
                    }
                    this.hDE.setText(bWX.getgActivityTitle());
                }
            } else if (aVar.bXd()) {
                this.hDC.setVisibility(0);
                this.hDA.setVisibility(0);
                this.hDD.setVisibility(4);
                this.hDE.setText(R.string.group_info_create_activity);
            } else {
                this.hDC.setVisibility(8);
                this.hDA.setVisibility(8);
            }
            this.hDW.removeAllViews();
            if (aVar.bWY() != null && aVar.bWY().size() > 0) {
                List<MemberData> bWY = aVar.bWY();
                int size = bWY.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bWY.get(i3);
                    HeadImageView headImageView = this.hDX[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hDz.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hDX[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hDW.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bXd()) {
                this.hDV.setEnabled(true);
                this.hEm.setEnabled(true);
                am.setBackgroundResource(this.hEm, R.drawable.group_info_item);
                this.hEj.setVisibility(0);
                this.hEo.setVisibility(0);
                this.hEl.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hEk.setText(aVar.getGroup().getName());
                }
            } else {
                this.hDV.setEnabled(false);
                this.hEm.setEnabled(true);
                am.setBackgroundColor(this.hEm, R.color.cp_bg_line_d);
                this.hEl.setVisibility(8);
                this.hEo.setVisibility(8);
                this.hDH.setPadding(0, 0, 0, 0);
            }
            if (aVar.bXc()) {
                this.hEb.setVisibility(0);
                this.hEu.setVisibility(0);
                if (this.hDQ.getParent() != this.hEb) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hEd.removeView(this.hDQ);
                    this.hEb.addView(this.hDQ, 1);
                }
                bWu();
            } else {
                this.hEb.setVisibility(8);
                this.hEu.setVisibility(8);
                if (this.hDQ.getParent() != this.hEd) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hEb.removeView(this.hDQ);
                    this.hEd.addView(this.hDQ, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hDM.setVisibility(8);
            } else {
                this.hDM.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                nG(aVar.bXd());
            } else {
                n(aVar.bXd(), this.hEh);
            }
            this.bjx.setVisibility(0);
            this.hDY.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (wC(aVar.getGroup().getFlag())) {
                nH(z);
            } else {
                bWv();
            }
        }
    }

    public void bWu() {
        this.hDZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hDZ, R.color.cp_cont_a, 1);
        this.hDZ.setText(this.hDz.getPageContext().getString(R.string.i_want_talk));
        this.hEt.setEnabled(true);
    }

    private void nH(boolean z) {
        this.hDZ.setText(this.hDz.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hDZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hDZ, R.color.cp_cont_a, 1);
        } else {
            this.hDZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hDZ, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hEt, R.drawable.btn_blue_bg);
        this.hEt.setEnabled(true);
    }

    private boolean wC(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bWv() {
        this.hDZ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hDZ.setText(this.hDz.getPageContext().getString(R.string.group_info_refuse_join));
        this.hDZ.setTextColor(this.hDz.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hEt, R.drawable.btn_app_download_d);
        this.hEt.setEnabled(false);
    }

    public void Dk(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hDW.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hDW.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hDW.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hDK.setIsManager(aVar.bXd());
            if (aVar.bXd()) {
                this.hDK.setVisibility(0);
                if (aVar.bWZ() != null && aVar.bWZ().size() == 1 && TextUtils.isEmpty(aVar.bWZ().get(0).getPicId())) {
                    this.hDK.setData(null);
                } else {
                    this.hDK.setData(aVar.bWZ());
                }
            } else if (aVar.bWZ() != null && aVar.bWZ().size() > 0) {
                if (aVar.bWZ().size() == 1 && TextUtils.isEmpty(aVar.bWZ().get(0).getPicId())) {
                    this.hDK.setVisibility(8);
                    return;
                }
                this.hDK.setVisibility(0);
                this.hDK.setData(aVar.bWZ());
            } else {
                this.hDK.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hEf = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hEe != null) {
            this.hEe.dismiss();
            this.hEe = null;
        }
        d(obj, i);
        this.hEe.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hEe == null) {
            this.hEe = new i(this.hDz.getPageContext());
            this.hEe.a(null, new String[]{this.hDz.getResources().getString(R.string.group_info_set_portrait), this.hDz.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hEe != null && a.this.hEe.isShowing()) {
                        a.this.hEf.a(a.this.hEe, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hDK != null) {
            this.hDK.onDestory();
        }
        if (this.hDO != null) {
            this.hDO.stopLoad();
            this.hDO.setBackgroundDrawable(null);
            this.hDO.setImageDrawable(null);
        }
        if (this.hDW != null && this.hDX != null) {
            int length = this.hDX.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hDX[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Dl(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.hDz.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hDz.getPageContext().getPageActivity());
            bVar.sT(this.hDz.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDz.getSystemService("clipboard")).setText(str);
                        a.this.hDz.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hDz.getPageContext());
            bVar.aED();
        }
    }

    public void Dm(String str) {
        if (this.hEc == null) {
            Dn(str);
        }
        this.hEc.aED();
    }

    private void Dn(final String str) {
        if (this.hEc == null) {
            this.hEc = new com.baidu.tbadk.core.dialog.b(this.hDz.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hDz.getPageContext().getString(R.string.copy_group_number)};
            this.hEc.sT(this.hDz.getPageContext().getString(R.string.operation));
            this.hEc.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDz.getSystemService("clipboard")).setText(str);
                        a.this.hDz.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hEc.d(this.hDz.getPageContext());
        }
    }

    public void bWw() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hDZ.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hDZ.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hDz.getLayoutMode().setNightMode(i == 1);
        this.hDz.getLayoutMode().onModeChanged(this.mContainer);
        this.hDz.getLayoutMode().onModeChanged(this.hDT);
        this.hDK.a(i, this.hDz);
        this.mNavigationBar.onChangeSkinType(this.hDz.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hEv, R.color.common_color_10009, 1);
        }
        if (!this.hEy) {
            b(this.hEw, this.hEx);
        }
        if (this.hEz) {
            am.setBackgroundResource(this.hEm, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hEm, R.color.cp_bg_line_d);
        }
    }

    public void nI(boolean z) {
        this.hEy = z;
    }
}
