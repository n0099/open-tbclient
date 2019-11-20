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
/* loaded from: classes5.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private ScrollView buM;
    private View fkk;
    private TextView gIN;
    private final GroupInfoActivity gJR;
    private View gJS;
    private ProgressBar gJT;
    private RelativeLayout gJU;
    private TextView gJV;
    private TextView gJW;
    private TextView gJX;
    private TextView gJY;
    private EllipsizingTextView gJZ;
    private ImageView gKA;
    private RelativeLayout gKB;
    private TextView gKC;
    private ImageView gKD;
    private RelativeLayout gKE;
    private RelativeLayout gKF;
    private ImageView gKG;
    private ImageView gKH;
    private View gKI;
    private TextView gKJ;
    private TextView gKK;
    private LinearLayout gKL;
    private View gKM;
    private TextView gKN;
    private ResponseGroupInfoLocalMessage.a gKO;
    private boolean gKP;
    private boolean gKQ;
    private boolean gKR;
    private TextView gKa;
    private RelativeLayout gKb;
    private PhotoWallView gKc;
    private RelativeLayout gKd;
    private RelativeLayout gKe;
    private LinearLayout gKf;
    private HeadImageView gKg;
    private TextView gKh;
    private RelativeLayout gKi;
    private com.baidu.tbadk.core.dialog.b gKj;
    private ImageView gKk;
    private final View gKl;
    private b.a gKm;
    private RelativeLayout gKn;
    private LinearLayout gKo;
    private HeadImageView[] gKp;
    private LinearLayout gKq;
    private TextView gKr;
    private RelativeLayout gKs;
    private LinearLayout gKt;
    private com.baidu.tbadk.core.dialog.b gKu;
    private LinearLayout gKv;
    private i gKw;
    private b gKx;
    private TextView gKy;
    private String gKz;
    private View gyy;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gKS = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gKj = null;
        this.gKm = null;
        this.gKp = new HeadImageView[5];
        this.gKz = "";
        this.gKP = true;
        this.isMemGroup = false;
        this.gKQ = false;
        this.gKR = false;
        this.gJR = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gKl = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.buM.setVisibility(4);
        this.gKq.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gKC.setText(str);
        xZ(str);
    }

    private void xZ(String str) {
        if (str != null) {
            this.gKN.setText(str);
        }
    }

    public void ya(String str) {
        this.gJZ.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gyy = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gKN = this.mNavigationBar.setTitleText("");
        this.gKM = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gKy = (TextView) this.gKM.findViewById(R.id.right_textview);
        this.gKy.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.gKy, R.color.cp_cont_f, 1);
        this.gKy.setOnClickListener(groupInfoActivity);
        this.gKM.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gJS = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.buM = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.buM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.fkk = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fkk.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gJU = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gJU.setOnClickListener(groupInfoActivity);
        this.gJV = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gJW = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gKn = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gKn.setOnClickListener(groupInfoActivity);
        this.gKv = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gKA = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gJX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gJY = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gKG = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gJZ = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gJZ.setMaxLines(20);
        this.gJZ.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kU(boolean z) {
                if (z) {
                    a.this.gKJ.setVisibility(0);
                } else {
                    a.this.gKJ.setVisibility(8);
                }
            }
        });
        this.gKb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gKa = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gKb.setOnClickListener(groupInfoActivity);
        this.gKg = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gKg.setAutoChangeStyle(true);
        this.gKg.setIsRound(false);
        this.gIN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gKd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gKd.setOnClickListener(groupInfoActivity);
        this.gKk = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gKI = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gKf = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gKb.setOnClickListener(groupInfoActivity);
        this.gKe = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gKe.setOnClickListener(groupInfoActivity);
        this.gKh = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gKi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gKi.setOnClickListener(groupInfoActivity);
        this.gKo = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gKq = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gKL = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gKr = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gKL.setOnClickListener(this.gJR);
        this.gKs = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gKs.setOnClickListener(groupInfoActivity);
        this.gKt = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gKB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gKB.setOnClickListener(groupInfoActivity);
        this.gKC = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gKD = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gKH = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gKE = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gKE.setOnClickListener(groupInfoActivity);
        this.gKE.setLongClickable(true);
        this.gKE.setOnLongClickListener(groupInfoActivity);
        this.gKJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gKJ.setClickable(true);
        this.gKJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gJZ.setMaxLines(1000);
            }
        });
        this.gKF = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gKF.setOnLongClickListener(groupInfoActivity);
        this.gKK = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gJT = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gKc = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gKc.setPhotoClickListener(groupInfoActivity);
        this.gKc.setPhotoLongClickListener(groupInfoActivity);
        this.gKc.setVisibility(8);
    }

    public RelativeLayout bCg() {
        return this.gKF;
    }

    public RelativeLayout bCh() {
        return this.gKb;
    }

    public LinearLayout bCi() {
        return this.gKo;
    }

    public RelativeLayout bCj() {
        return this.gKs;
    }

    public RelativeLayout bCk() {
        return this.gKE;
    }

    public RelativeLayout bCl() {
        return this.gKB;
    }

    public RelativeLayout bCm() {
        return this.gJU;
    }

    public View bCn() {
        return this.gKy;
    }

    public LinearLayout bCo() {
        return this.gKL;
    }

    public RelativeLayout bCp() {
        return this.gKd;
    }

    public RelativeLayout bCq() {
        return this.gKe;
    }

    public RelativeLayout bCr() {
        return this.gKi;
    }

    public View bBb() {
        return this.gyy;
    }

    public void bCs() {
        this.gJT.setVisibility(8);
    }

    public void bCt() {
        this.gJT.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gJY.setText(str);
            this.gKn.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gKn.setVisibility(8);
        } else {
            this.gJY.setText(str);
            this.gKn.setVisibility(0);
        }
    }

    public void mf(boolean z) {
        if (z) {
            this.gJY.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gKn.setVisibility(8);
        }
    }

    public RelativeLayout bCu() {
        return this.gKn;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.gKQ = aVar.bDe();
            this.gKR = aVar.bDf();
            this.gKO = aVar;
            this.gKP = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bCZ() != null) {
                gKS = aVar.bCZ().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gKv.setVisibility(0);
            this.gKq.setVisibility(0);
            if (aVar.getGroup() != null) {
                xZ(aVar.getGroup().getName());
                this.gJX.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gKk.setVisibility(0);
                } else {
                    this.gKk.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gKA.setVisibility(0);
                    this.gKg.setVisibility(8);
                    this.gKH.setVisibility(8);
                    this.gKI.setVisibility(8);
                    this.gIN.setText(R.string.group_info_forum_author);
                    this.gKd.setEnabled(false);
                    this.gKk.setVisibility(8);
                } else {
                    this.gKA.setVisibility(8);
                    this.gKg.setVisibility(0);
                    this.gKH.setVisibility(0);
                    this.gKI.setVisibility(0);
                    this.gIN.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gKd.setEnabled(true);
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
                this.gKz = stringBuffer.toString();
                this.gJY.setText(this.gKz);
                this.gJZ.setText(aVar.getGroup().getIntro());
                this.gKh.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gKg.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gKb.setVisibility(0);
                    this.gKa.setText(aVar.getGroup().getForumName() + this.gJR.getPageContext().getString(R.string.forum));
                } else {
                    this.gKb.setVisibility(8);
                }
                this.gKf.removeAllViews();
                boolean bDg = aVar.bDg();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.gKN, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gJR.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.gKf.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gJR.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.gKf.addView(imageView2);
                }
                if (bDg) {
                    this.gKK.setVisibility(0);
                } else {
                    this.gKK.setVisibility(8);
                }
            }
            if (aVar.bCZ() != null) {
                this.gJU.setVisibility(0);
                this.gJS.setVisibility(0);
                GroupActivityData bCZ = aVar.bCZ();
                if (!aVar.bDe()) {
                    if (bCZ.getIsEnd() != 1) {
                        this.gJV.setVisibility(4);
                        this.gJW.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gJU.setVisibility(8);
                        this.gJS.setVisibility(8);
                    }
                } else {
                    this.gJV.setVisibility(0);
                    this.gJW.setText(bCZ.getgActivityTitle());
                    if (bCZ.getIsEnd() != 1) {
                        this.gJV.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.gJV, R.color.common_color_10171, 1);
                    } else {
                        this.gJV.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.gJV, R.color.common_color_10168, 1);
                    }
                    this.gJW.setText(bCZ.getgActivityTitle());
                }
            } else if (aVar.bDf()) {
                this.gJU.setVisibility(0);
                this.gJS.setVisibility(0);
                this.gJV.setVisibility(4);
                this.gJW.setText(R.string.group_info_create_activity);
            } else {
                this.gJU.setVisibility(8);
                this.gJS.setVisibility(8);
            }
            this.gKo.removeAllViews();
            if (aVar.bDa() != null && aVar.bDa().size() > 0) {
                List<MemberData> bDa = aVar.bDa();
                int size = bDa.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bDa.get(i3);
                    HeadImageView headImageView = this.gKp[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gJR.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gKp[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gKo.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bDf()) {
                this.gKn.setEnabled(true);
                this.gKE.setEnabled(true);
                am.setBackgroundResource(this.gKE, R.drawable.group_info_item);
                this.gKB.setVisibility(0);
                this.gKG.setVisibility(0);
                this.gKD.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gKC.setText(aVar.getGroup().getName());
                }
            } else {
                this.gKn.setEnabled(false);
                this.gKE.setEnabled(true);
                am.setBackgroundColor(this.gKE, R.color.cp_bg_line_d);
                this.gKD.setVisibility(8);
                this.gKG.setVisibility(8);
                this.gJZ.setPadding(0, 0, 0, 0);
            }
            if (aVar.bDe()) {
                this.gKt.setVisibility(0);
                this.gKM.setVisibility(0);
                if (this.gKi.getParent() != this.gKt) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gKv.removeView(this.gKi);
                    this.gKt.addView(this.gKi, 1);
                }
                bCv();
            } else {
                this.gKt.setVisibility(8);
                this.gKM.setVisibility(8);
                if (this.gKi.getParent() != this.gKv) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gKt.removeView(this.gKi);
                    this.gKv.addView(this.gKi, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gKe.setVisibility(8);
            } else {
                this.gKe.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                mf(aVar.bDf());
            } else {
                m(aVar.bDf(), this.gKz);
            }
            this.buM.setVisibility(0);
            this.gKq.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (up(aVar.getGroup().getFlag())) {
                mg(z);
            } else {
                bCw();
            }
        }
    }

    public void bCv() {
        this.gKr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.gKr, R.color.cp_cont_a, 1);
        this.gKr.setText(this.gJR.getPageContext().getString(R.string.i_want_talk));
        this.gKL.setEnabled(true);
    }

    private void mg(boolean z) {
        this.gKr.setText(this.gJR.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gKr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.gKr, R.color.cp_cont_a, 1);
        } else {
            this.gKr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.gKr, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.gKL, R.drawable.btn_blue_bg);
        this.gKL.setEnabled(true);
    }

    private boolean up(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bCw() {
        this.gKr.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gKr.setText(this.gJR.getPageContext().getString(R.string.group_info_refuse_join));
        this.gKr.setTextColor(this.gJR.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.gKL, R.drawable.btn_app_download_d);
        this.gKL.setEnabled(false);
    }

    public void yb(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gKo.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gKo.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gKo.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gKc.setIsManager(aVar.bDf());
            if (aVar.bDf()) {
                this.gKc.setVisibility(0);
                if (aVar.bDb() != null && aVar.bDb().size() == 1 && TextUtils.isEmpty(aVar.bDb().get(0).getPicId())) {
                    this.gKc.setData(null);
                } else {
                    this.gKc.setData(aVar.bDb());
                }
            } else if (aVar.bDb() != null && aVar.bDb().size() > 0) {
                if (aVar.bDb().size() == 1 && TextUtils.isEmpty(aVar.bDb().get(0).getPicId())) {
                    this.gKc.setVisibility(8);
                    return;
                }
                this.gKc.setVisibility(0);
                this.gKc.setData(aVar.bDb());
            } else {
                this.gKc.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gKx = bVar;
    }

    public void c(Object obj, int i) {
        if (this.gKw != null) {
            this.gKw.dismiss();
            this.gKw = null;
        }
        d(obj, i);
        this.gKw.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.gKw == null) {
            this.gKw = new i(this.gJR.getPageContext());
            this.gKw.a(null, new String[]{this.gJR.getResources().getString(R.string.group_info_set_portrait), this.gJR.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gKw != null && a.this.gKw.isShowing()) {
                        a.this.gKx.a(a.this.gKw, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gKc != null) {
            this.gKc.onDestory();
        }
        if (this.gKg != null) {
            this.gKg.stopLoad();
            this.gKg.setBackgroundDrawable(null);
            this.gKg.setImageDrawable(null);
        }
        if (this.gKo != null && this.gKp != null) {
            int length = this.gKp.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gKp[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void yc(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gJR.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gJR.getPageContext().getPageActivity());
            bVar.no(this.gJR.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gJR.getSystemService("clipboard")).setText(str);
                        a.this.gJR.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gJR.getPageContext());
            bVar.akN();
        }
    }

    public void yd(String str) {
        if (this.gKu == null) {
            ye(str);
        }
        this.gKu.akN();
    }

    private void ye(final String str) {
        if (this.gKu == null) {
            this.gKu = new com.baidu.tbadk.core.dialog.b(this.gJR.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gJR.getPageContext().getString(R.string.copy_group_number)};
            this.gKu.no(this.gJR.getPageContext().getString(R.string.operation));
            this.gKu.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gJR.getSystemService("clipboard")).setText(str);
                        a.this.gJR.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gKu.d(this.gJR.getPageContext());
        }
    }

    public void bCx() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.gKr.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gKr.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.gJR.getLayoutMode().setNightMode(i == 1);
        this.gJR.getLayoutMode().onModeChanged(this.mContainer);
        this.gJR.getLayoutMode().onModeChanged(this.gKl);
        this.gKc.a(i, this.gJR);
        this.mNavigationBar.onChangeSkinType(this.gJR.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.gKN, R.color.common_color_10009, 1);
        }
        if (!this.gKQ) {
            b(this.gKO, this.gKP);
        }
        if (this.gKR) {
            am.setBackgroundResource(this.gKE, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.gKE, R.color.cp_bg_line_d);
        }
    }

    public void mh(boolean z) {
        this.gKQ = z;
    }
}
