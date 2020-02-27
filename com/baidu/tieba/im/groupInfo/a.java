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
    public static int hEy = 0;
    private ScrollView bjw;
    private View gdT;
    private TextView hCt;
    private RelativeLayout hDA;
    private TextView hDB;
    private TextView hDC;
    private TextView hDD;
    private TextView hDE;
    private EllipsizingTextView hDF;
    private TextView hDG;
    private RelativeLayout hDH;
    private PhotoWallView hDI;
    private RelativeLayout hDJ;
    private RelativeLayout hDK;
    private LinearLayout hDL;
    private HeadImageView hDM;
    private TextView hDN;
    private RelativeLayout hDO;
    private com.baidu.tbadk.core.dialog.b hDP;
    private ImageView hDQ;
    private final View hDR;
    private b.a hDS;
    private RelativeLayout hDT;
    private LinearLayout hDU;
    private HeadImageView[] hDV;
    private LinearLayout hDW;
    private TextView hDX;
    private RelativeLayout hDY;
    private LinearLayout hDZ;
    private final GroupInfoActivity hDx;
    private View hDy;
    private ProgressBar hDz;
    private com.baidu.tbadk.core.dialog.b hEa;
    private LinearLayout hEb;
    private i hEc;
    private b hEd;
    private TextView hEe;
    private String hEf;
    private ImageView hEg;
    private RelativeLayout hEh;
    private TextView hEi;
    private ImageView hEj;
    private RelativeLayout hEk;
    private RelativeLayout hEl;
    private ImageView hEm;
    private ImageView hEn;
    private View hEo;
    private TextView hEp;
    private TextView hEq;
    private LinearLayout hEr;
    private View hEs;
    private TextView hEt;
    private ResponseGroupInfoLocalMessage.a hEu;
    private boolean hEv;
    private boolean hEw;
    private boolean hEx;
    private View hsi;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hDP = null;
        this.hDS = null;
        this.hDV = new HeadImageView[5];
        this.hEf = "";
        this.hEv = true;
        this.isMemGroup = false;
        this.hEw = false;
        this.hEx = false;
        this.hDx = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hDR = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bjw.setVisibility(4);
        this.hDW.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hEi.setText(str);
        Di(str);
    }

    private void Di(String str) {
        if (str != null) {
            this.hEt.setText(str);
        }
    }

    public void Dj(String str) {
        this.hDF.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.hsi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hEt = this.mNavigationBar.setTitleText("");
        this.hEs = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hEe = (TextView) this.hEs.findViewById(R.id.right_textview);
        this.hEe.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hEe, R.color.cp_cont_f, 1);
        this.hEe.setOnClickListener(groupInfoActivity);
        this.hEs.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hDy = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bjw = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bjw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gdT = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gdT.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hDA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hDA.setOnClickListener(groupInfoActivity);
        this.hDB = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hDC = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hDT = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hDT.setOnClickListener(groupInfoActivity);
        this.hEb = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hEg = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hDD = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hDE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hEm = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hDF = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hDF.setMaxLines(20);
        this.hDF.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mv(boolean z) {
                if (z) {
                    a.this.hEp.setVisibility(0);
                } else {
                    a.this.hEp.setVisibility(8);
                }
            }
        });
        this.hDH = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hDG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hDH.setOnClickListener(groupInfoActivity);
        this.hDM = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hDM.setAutoChangeStyle(true);
        this.hDM.setIsRound(false);
        this.hCt = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hDJ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hDJ.setOnClickListener(groupInfoActivity);
        this.hDQ = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hEo = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hDL = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hDH.setOnClickListener(groupInfoActivity);
        this.hDK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hDK.setOnClickListener(groupInfoActivity);
        this.hDN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hDO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hDO.setOnClickListener(groupInfoActivity);
        this.hDU = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hDW = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hEr = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hDX = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hEr.setOnClickListener(this.hDx);
        this.hDY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hDY.setOnClickListener(groupInfoActivity);
        this.hDZ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hEh = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hEh.setOnClickListener(groupInfoActivity);
        this.hEi = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hEj = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hEn = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hEk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hEk.setOnClickListener(groupInfoActivity);
        this.hEk.setLongClickable(true);
        this.hEk.setOnLongClickListener(groupInfoActivity);
        this.hEp = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hEp.setClickable(true);
        this.hEp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hDF.setMaxLines(1000);
            }
        });
        this.hEl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hEl.setOnLongClickListener(groupInfoActivity);
        this.hEq = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hDz = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hDI = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hDI.setPhotoClickListener(groupInfoActivity);
        this.hDI.setPhotoLongClickListener(groupInfoActivity);
        this.hDI.setVisibility(8);
    }

    public RelativeLayout bWd() {
        return this.hEl;
    }

    public RelativeLayout bWe() {
        return this.hDH;
    }

    public LinearLayout bWf() {
        return this.hDU;
    }

    public RelativeLayout bWg() {
        return this.hDY;
    }

    public RelativeLayout bWh() {
        return this.hEk;
    }

    public RelativeLayout bWi() {
        return this.hEh;
    }

    public RelativeLayout bWj() {
        return this.hDA;
    }

    public View bWk() {
        return this.hEe;
    }

    public LinearLayout bWl() {
        return this.hEr;
    }

    public RelativeLayout bWm() {
        return this.hDJ;
    }

    public RelativeLayout bWn() {
        return this.hDK;
    }

    public RelativeLayout bWo() {
        return this.hDO;
    }

    public View bUX() {
        return this.hsi;
    }

    public void bWp() {
        this.hDz.setVisibility(8);
    }

    public void bWq() {
        this.hDz.setVisibility(0);
    }

    public void n(boolean z, String str) {
        if (z) {
            this.hDE.setText(str);
            this.hDT.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hDT.setVisibility(8);
        } else {
            this.hDE.setText(str);
            this.hDT.setVisibility(0);
        }
    }

    public void nG(boolean z) {
        if (z) {
            this.hDE.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hDT.setVisibility(8);
        }
    }

    public RelativeLayout bWr() {
        return this.hDT;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hEw = aVar.bXa();
            this.hEx = aVar.bXb();
            this.hEu = aVar;
            this.hEv = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bWV() != null) {
                hEy = aVar.bWV().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hEb.setVisibility(0);
            this.hDW.setVisibility(0);
            if (aVar.getGroup() != null) {
                Di(aVar.getGroup().getName());
                this.hDD.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hDQ.setVisibility(0);
                } else {
                    this.hDQ.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hEg.setVisibility(0);
                    this.hDM.setVisibility(8);
                    this.hEn.setVisibility(8);
                    this.hEo.setVisibility(8);
                    this.hCt.setText(R.string.group_info_forum_author);
                    this.hDJ.setEnabled(false);
                    this.hDQ.setVisibility(8);
                } else {
                    this.hEg.setVisibility(8);
                    this.hDM.setVisibility(0);
                    this.hEn.setVisibility(0);
                    this.hEo.setVisibility(0);
                    this.hCt.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hDJ.setEnabled(true);
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
                this.hEf = stringBuffer.toString();
                this.hDE.setText(this.hEf);
                this.hDF.setText(aVar.getGroup().getIntro());
                this.hDN.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hDM.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hDH.setVisibility(0);
                    this.hDG.setText(aVar.getGroup().getForumName() + this.hDx.getPageContext().getString(R.string.forum));
                } else {
                    this.hDH.setVisibility(8);
                }
                this.hDL.removeAllViews();
                boolean bXc = aVar.bXc();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hEt, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hDx.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hDL.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hDx.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hDL.addView(imageView2);
                }
                if (bXc) {
                    this.hEq.setVisibility(0);
                } else {
                    this.hEq.setVisibility(8);
                }
            }
            if (aVar.bWV() != null) {
                this.hDA.setVisibility(0);
                this.hDy.setVisibility(0);
                GroupActivityData bWV = aVar.bWV();
                if (!aVar.bXa()) {
                    if (bWV.getIsEnd() != 1) {
                        this.hDB.setVisibility(4);
                        this.hDC.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hDA.setVisibility(8);
                        this.hDy.setVisibility(8);
                    }
                } else {
                    this.hDB.setVisibility(0);
                    this.hDC.setText(bWV.getgActivityTitle());
                    if (bWV.getIsEnd() != 1) {
                        this.hDB.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hDB, R.color.common_color_10171, 1);
                    } else {
                        this.hDB.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hDB, R.color.common_color_10168, 1);
                    }
                    this.hDC.setText(bWV.getgActivityTitle());
                }
            } else if (aVar.bXb()) {
                this.hDA.setVisibility(0);
                this.hDy.setVisibility(0);
                this.hDB.setVisibility(4);
                this.hDC.setText(R.string.group_info_create_activity);
            } else {
                this.hDA.setVisibility(8);
                this.hDy.setVisibility(8);
            }
            this.hDU.removeAllViews();
            if (aVar.bWW() != null && aVar.bWW().size() > 0) {
                List<MemberData> bWW = aVar.bWW();
                int size = bWW.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bWW.get(i3);
                    HeadImageView headImageView = this.hDV[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hDx.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hDV[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hDU.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bXb()) {
                this.hDT.setEnabled(true);
                this.hEk.setEnabled(true);
                am.setBackgroundResource(this.hEk, R.drawable.group_info_item);
                this.hEh.setVisibility(0);
                this.hEm.setVisibility(0);
                this.hEj.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hEi.setText(aVar.getGroup().getName());
                }
            } else {
                this.hDT.setEnabled(false);
                this.hEk.setEnabled(true);
                am.setBackgroundColor(this.hEk, R.color.cp_bg_line_d);
                this.hEj.setVisibility(8);
                this.hEm.setVisibility(8);
                this.hDF.setPadding(0, 0, 0, 0);
            }
            if (aVar.bXa()) {
                this.hDZ.setVisibility(0);
                this.hEs.setVisibility(0);
                if (this.hDO.getParent() != this.hDZ) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hEb.removeView(this.hDO);
                    this.hDZ.addView(this.hDO, 1);
                }
                bWs();
            } else {
                this.hDZ.setVisibility(8);
                this.hEs.setVisibility(8);
                if (this.hDO.getParent() != this.hEb) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hDZ.removeView(this.hDO);
                    this.hEb.addView(this.hDO, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hDK.setVisibility(8);
            } else {
                this.hDK.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                nG(aVar.bXb());
            } else {
                n(aVar.bXb(), this.hEf);
            }
            this.bjw.setVisibility(0);
            this.hDW.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (wC(aVar.getGroup().getFlag())) {
                nH(z);
            } else {
                bWt();
            }
        }
    }

    public void bWs() {
        this.hDX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hDX, R.color.cp_cont_a, 1);
        this.hDX.setText(this.hDx.getPageContext().getString(R.string.i_want_talk));
        this.hEr.setEnabled(true);
    }

    private void nH(boolean z) {
        this.hDX.setText(this.hDx.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hDX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hDX, R.color.cp_cont_a, 1);
        } else {
            this.hDX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hDX, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hEr, R.drawable.btn_blue_bg);
        this.hEr.setEnabled(true);
    }

    private boolean wC(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bWt() {
        this.hDX.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hDX.setText(this.hDx.getPageContext().getString(R.string.group_info_refuse_join));
        this.hDX.setTextColor(this.hDx.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hEr, R.drawable.btn_app_download_d);
        this.hEr.setEnabled(false);
    }

    public void Dk(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hDU.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hDU.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hDU.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hDI.setIsManager(aVar.bXb());
            if (aVar.bXb()) {
                this.hDI.setVisibility(0);
                if (aVar.bWX() != null && aVar.bWX().size() == 1 && TextUtils.isEmpty(aVar.bWX().get(0).getPicId())) {
                    this.hDI.setData(null);
                } else {
                    this.hDI.setData(aVar.bWX());
                }
            } else if (aVar.bWX() != null && aVar.bWX().size() > 0) {
                if (aVar.bWX().size() == 1 && TextUtils.isEmpty(aVar.bWX().get(0).getPicId())) {
                    this.hDI.setVisibility(8);
                    return;
                }
                this.hDI.setVisibility(0);
                this.hDI.setData(aVar.bWX());
            } else {
                this.hDI.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hEd = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hEc != null) {
            this.hEc.dismiss();
            this.hEc = null;
        }
        d(obj, i);
        this.hEc.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hEc == null) {
            this.hEc = new i(this.hDx.getPageContext());
            this.hEc.a(null, new String[]{this.hDx.getResources().getString(R.string.group_info_set_portrait), this.hDx.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hEc != null && a.this.hEc.isShowing()) {
                        a.this.hEd.a(a.this.hEc, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hDI != null) {
            this.hDI.onDestory();
        }
        if (this.hDM != null) {
            this.hDM.stopLoad();
            this.hDM.setBackgroundDrawable(null);
            this.hDM.setImageDrawable(null);
        }
        if (this.hDU != null && this.hDV != null) {
            int length = this.hDV.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hDV[i];
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
            CharSequence[] charSequenceArr = {this.hDx.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hDx.getPageContext().getPageActivity());
            bVar.sT(this.hDx.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDx.getSystemService("clipboard")).setText(str);
                        a.this.hDx.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hDx.getPageContext());
            bVar.aEB();
        }
    }

    public void Dm(String str) {
        if (this.hEa == null) {
            Dn(str);
        }
        this.hEa.aEB();
    }

    private void Dn(final String str) {
        if (this.hEa == null) {
            this.hEa = new com.baidu.tbadk.core.dialog.b(this.hDx.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hDx.getPageContext().getString(R.string.copy_group_number)};
            this.hEa.sT(this.hDx.getPageContext().getString(R.string.operation));
            this.hEa.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hDx.getSystemService("clipboard")).setText(str);
                        a.this.hDx.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hEa.d(this.hDx.getPageContext());
        }
    }

    public void bWu() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hDX.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hDX.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hDx.getLayoutMode().setNightMode(i == 1);
        this.hDx.getLayoutMode().onModeChanged(this.mContainer);
        this.hDx.getLayoutMode().onModeChanged(this.hDR);
        this.hDI.a(i, this.hDx);
        this.mNavigationBar.onChangeSkinType(this.hDx.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hEt, R.color.common_color_10009, 1);
        }
        if (!this.hEw) {
            b(this.hEu, this.hEv);
        }
        if (this.hEx) {
            am.setBackgroundResource(this.hEk, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hEk, R.color.cp_bg_line_d);
        }
    }

    public void nI(boolean z) {
        this.hEw = z;
    }
}
