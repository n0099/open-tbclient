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
    private ScrollView bcg;
    private RelativeLayout cWd;
    private View fga;
    private boolean flv;
    private TextView gIV;
    private final GroupInfoActivity gJY;
    private View gJZ;
    private LinearLayout gKA;
    private com.baidu.tbadk.core.dialog.b gKB;
    private LinearLayout gKC;
    private i gKD;
    private b gKE;
    private TextView gKF;
    private String gKG;
    private ImageView gKH;
    private RelativeLayout gKI;
    private TextView gKJ;
    private ImageView gKK;
    private RelativeLayout gKL;
    private RelativeLayout gKM;
    private ImageView gKN;
    private ImageView gKO;
    private View gKP;
    private TextView gKQ;
    private TextView gKR;
    private LinearLayout gKS;
    private View gKT;
    private TextView gKU;
    private ResponseGroupInfoLocalMessage.a gKV;
    private boolean gKW;
    private boolean gKX;
    private ProgressBar gKa;
    private RelativeLayout gKb;
    private TextView gKc;
    private TextView gKd;
    private TextView gKe;
    private TextView gKf;
    private EllipsizingTextView gKg;
    private TextView gKh;
    private RelativeLayout gKi;
    private PhotoWallView gKj;
    private RelativeLayout gKk;
    private RelativeLayout gKl;
    private LinearLayout gKm;
    private HeadImageView gKn;
    private TextView gKo;
    private RelativeLayout gKp;
    private com.baidu.tbadk.core.dialog.b gKq;
    private ImageView gKr;
    private final View gKs;
    private b.a gKt;
    private RelativeLayout gKu;
    private LinearLayout gKv;
    private HeadImageView[] gKw;
    private LinearLayout gKx;
    private TextView gKy;
    private RelativeLayout gKz;
    private View gyH;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gKY = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gKq = null;
        this.gKt = null;
        this.gKw = new HeadImageView[5];
        this.gKG = "";
        this.gKW = true;
        this.isMemGroup = false;
        this.flv = false;
        this.gKX = false;
        this.gJY = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gKs = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bcg.setVisibility(4);
        this.gKx.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gKJ.setText(str);
        zh(str);
    }

    private void zh(String str) {
        if (str != null) {
            this.gKU.setText(str);
        }
    }

    public void zi(String str) {
        this.gKg.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gyH = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gKU = this.mNavigationBar.setTitleText("");
        this.gKT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gKF = (TextView) this.gKT.findViewById(R.id.right_textview);
        this.gKF.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.f(this.gKF, R.color.cp_cont_f, 1);
        this.gKF.setOnClickListener(groupInfoActivity);
        this.gKT.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gJZ = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cWd = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bcg = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bcg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.fga = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fga.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gKb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gKb.setOnClickListener(groupInfoActivity);
        this.gKc = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gKd = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gKu = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gKu.setOnClickListener(groupInfoActivity);
        this.gKC = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gKH = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gKe = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gKf = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gKN = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gKg = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gKg.setMaxLines(20);
        this.gKg.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void ld(boolean z) {
                if (z) {
                    a.this.gKQ.setVisibility(0);
                } else {
                    a.this.gKQ.setVisibility(8);
                }
            }
        });
        this.gKi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gKh = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gKi.setOnClickListener(groupInfoActivity);
        this.gKn = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gKn.setAutoChangeStyle(true);
        this.gKn.setIsRound(false);
        this.gIV = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gKk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gKk.setOnClickListener(groupInfoActivity);
        this.gKr = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gKP = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gKm = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gKi.setOnClickListener(groupInfoActivity);
        this.gKl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gKl.setOnClickListener(groupInfoActivity);
        this.gKo = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gKp = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gKp.setOnClickListener(groupInfoActivity);
        this.gKv = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gKx = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gKS = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gKy = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gKS.setOnClickListener(this.gJY);
        this.gKz = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gKz.setOnClickListener(groupInfoActivity);
        this.gKA = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gKI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gKI.setOnClickListener(groupInfoActivity);
        this.gKJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gKK = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gKO = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gKL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gKL.setOnClickListener(groupInfoActivity);
        this.gKL.setLongClickable(true);
        this.gKL.setOnLongClickListener(groupInfoActivity);
        this.gKQ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gKQ.setClickable(true);
        this.gKQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gKg.setMaxLines(1000);
            }
        });
        this.gKM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gKM.setOnLongClickListener(groupInfoActivity);
        this.gKR = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gKa = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gKj = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gKj.setPhotoClickListener(groupInfoActivity);
        this.gKj.setPhotoLongClickListener(groupInfoActivity);
        this.gKj.setVisibility(8);
    }

    public RelativeLayout bEv() {
        return this.gKM;
    }

    public RelativeLayout bEw() {
        return this.gKi;
    }

    public LinearLayout bEx() {
        return this.gKv;
    }

    public RelativeLayout bEy() {
        return this.gKz;
    }

    public RelativeLayout bEz() {
        return this.gKL;
    }

    public RelativeLayout bEA() {
        return this.gKI;
    }

    public RelativeLayout bEB() {
        return this.gKb;
    }

    public View bEC() {
        return this.gKF;
    }

    public LinearLayout bED() {
        return this.gKS;
    }

    public RelativeLayout bEE() {
        return this.gKk;
    }

    public RelativeLayout bEF() {
        return this.gKl;
    }

    public RelativeLayout bEG() {
        return this.gKp;
    }

    public View bDq() {
        return this.gyH;
    }

    public void bEH() {
        this.gKa.setVisibility(8);
    }

    public void bEI() {
        this.gKa.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gKf.setText(str);
            this.gKu.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gKu.setVisibility(8);
        } else {
            this.gKf.setText(str);
            this.gKu.setVisibility(0);
        }
    }

    public void mo(boolean z) {
        if (z) {
            this.gKf.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gKu.setVisibility(8);
        }
    }

    public RelativeLayout bEJ() {
        return this.gKu;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.flv = aVar.bFt();
            this.gKX = aVar.bFu();
            this.gKV = aVar;
            this.gKW = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bFo() != null) {
                gKY = aVar.bFo().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gKC.setVisibility(0);
            this.gKx.setVisibility(0);
            if (aVar.getGroup() != null) {
                zh(aVar.getGroup().getName());
                this.gKe.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gKr.setVisibility(0);
                } else {
                    this.gKr.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gKH.setVisibility(0);
                    this.gKn.setVisibility(8);
                    this.gKO.setVisibility(8);
                    this.gKP.setVisibility(8);
                    this.gIV.setText(R.string.group_info_forum_author);
                    this.gKk.setEnabled(false);
                    this.gKr.setVisibility(8);
                } else {
                    this.gKH.setVisibility(8);
                    this.gKn.setVisibility(0);
                    this.gKO.setVisibility(0);
                    this.gKP.setVisibility(0);
                    this.gIV.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gKk.setEnabled(true);
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
                this.gKG = stringBuffer.toString();
                this.gKf.setText(this.gKG);
                this.gKg.setText(aVar.getGroup().getIntro());
                this.gKo.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gKn.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gKi.setVisibility(0);
                    this.gKh.setText(aVar.getGroup().getForumName() + this.gJY.getPageContext().getString(R.string.forum));
                } else {
                    this.gKi.setVisibility(8);
                }
                this.gKm.removeAllViews();
                boolean bFv = aVar.bFv();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.f(this.gKU, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gJY.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gKm.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gJY.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gKm.addView(imageView2);
                }
                if (bFv) {
                    this.gKR.setVisibility(0);
                } else {
                    this.gKR.setVisibility(8);
                }
            }
            if (aVar.bFo() != null) {
                this.gKb.setVisibility(0);
                this.gJZ.setVisibility(0);
                GroupActivityData bFo = aVar.bFo();
                if (!aVar.bFt()) {
                    if (bFo.getIsEnd() != 1) {
                        this.gKc.setVisibility(4);
                        this.gKd.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gKb.setVisibility(8);
                        this.gJZ.setVisibility(8);
                    }
                } else {
                    this.gKc.setVisibility(0);
                    this.gKd.setText(bFo.getgActivityTitle());
                    if (bFo.getIsEnd() != 1) {
                        this.gKc.setText(R.string.group_info_activity_doing);
                        am.f(this.gKc, R.color.common_color_10171, 1);
                    } else {
                        this.gKc.setText(R.string.group_activity_end);
                        am.f(this.gKc, R.color.common_color_10168, 1);
                    }
                    this.gKd.setText(bFo.getgActivityTitle());
                }
            } else if (aVar.bFu()) {
                this.gKb.setVisibility(0);
                this.gJZ.setVisibility(0);
                this.gKc.setVisibility(4);
                this.gKd.setText(R.string.group_info_create_activity);
            } else {
                this.gKb.setVisibility(8);
                this.gJZ.setVisibility(8);
            }
            this.gKv.removeAllViews();
            if (aVar.bFp() != null && aVar.bFp().size() > 0) {
                List<MemberData> bFp = aVar.bFp();
                int size = bFp.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bFp.get(i3);
                    HeadImageView headImageView = this.gKw[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gJY.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gKw[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gKv.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bFu()) {
                this.gKu.setEnabled(true);
                this.gKL.setEnabled(true);
                am.k(this.gKL, R.drawable.group_info_item);
                this.gKI.setVisibility(0);
                this.gKN.setVisibility(0);
                this.gKK.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gKJ.setText(aVar.getGroup().getName());
                }
            } else {
                this.gKu.setEnabled(false);
                this.gKL.setEnabled(true);
                am.l(this.gKL, R.color.cp_bg_line_d);
                this.gKK.setVisibility(8);
                this.gKN.setVisibility(8);
                this.gKg.setPadding(0, 0, 0, 0);
            }
            if (aVar.bFt()) {
                this.gKA.setVisibility(0);
                this.gKT.setVisibility(0);
                if (this.gKp.getParent() != this.gKA) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gKC.removeView(this.gKp);
                    this.gKA.addView(this.gKp, 1);
                }
                bEK();
            } else {
                this.gKA.setVisibility(8);
                this.gKT.setVisibility(8);
                if (this.gKp.getParent() != this.gKC) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gKA.removeView(this.gKp);
                    this.gKC.addView(this.gKp, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gKl.setVisibility(8);
            } else {
                this.gKl.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                mo(aVar.bFu());
            } else {
                m(aVar.bFu(), this.gKG);
            }
            this.bcg.setVisibility(0);
            this.gKx.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vE(aVar.getGroup().getFlag())) {
                mp(z);
            } else {
                bEL();
            }
        }
    }

    public void bEK() {
        this.gKy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.gKy, R.color.cp_btn_a, 1);
        this.gKy.setText(this.gJY.getPageContext().getString(R.string.i_want_talk));
        this.gKS.setEnabled(true);
    }

    private void mp(boolean z) {
        this.gKy.setText(this.gJY.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gKy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gKy, R.color.cp_btn_a, 1);
        } else {
            this.gKy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gKy, R.color.cp_btn_a, 1);
        }
        am.k(this.gKS, R.drawable.btn_blue_bg);
        this.gKS.setEnabled(true);
    }

    private boolean vE(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bEL() {
        this.gKy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gKy.setText(this.gJY.getPageContext().getString(R.string.group_info_refuse_join));
        this.gKy.setTextColor(this.gJY.getResources().getColorStateList(R.color.cp_btn_a));
        am.k(this.gKS, R.drawable.btn_app_download_d);
        this.gKS.setEnabled(false);
    }

    public void zj(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gKv.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gKv.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gKv.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gKj.setIsManager(aVar.bFu());
            if (aVar.bFu()) {
                this.gKj.setVisibility(0);
                if (aVar.bFq() != null && aVar.bFq().size() == 1 && TextUtils.isEmpty(aVar.bFq().get(0).getPicId())) {
                    this.gKj.setData(null);
                } else {
                    this.gKj.setData(aVar.bFq());
                }
            } else if (aVar.bFq() != null && aVar.bFq().size() > 0) {
                if (aVar.bFq().size() == 1 && TextUtils.isEmpty(aVar.bFq().get(0).getPicId())) {
                    this.gKj.setVisibility(8);
                    return;
                }
                this.gKj.setVisibility(0);
                this.gKj.setData(aVar.bFq());
            } else {
                this.gKj.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gKE = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gKD != null) {
            this.gKD.dismiss();
            this.gKD = null;
        }
        e(obj, i);
        this.gKD.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gKD == null) {
            this.gKD = new i(this.gJY.getPageContext());
            this.gKD.a(null, new String[]{this.gJY.getResources().getString(R.string.group_info_set_portrait), this.gJY.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gKD != null && a.this.gKD.isShowing()) {
                        a.this.gKE.a(a.this.gKD, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gKj != null) {
            this.gKj.onDestory();
        }
        if (this.gKn != null) {
            this.gKn.stopLoad();
            this.gKn.setBackgroundDrawable(null);
            this.gKn.setImageDrawable(null);
        }
        if (this.gKv != null && this.gKw != null) {
            int length = this.gKw.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gKw[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void zk(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gJY.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gJY.getPageContext().getPageActivity());
            bVar.mP(this.gJY.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gJY.getSystemService("clipboard")).setText(str);
                        a.this.gJY.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gJY.getPageContext());
            bVar.agL();
        }
    }

    public void zl(String str) {
        if (this.gKB == null) {
            zm(str);
        }
        this.gKB.agL();
    }

    private void zm(final String str) {
        if (this.gKB == null) {
            this.gKB = new com.baidu.tbadk.core.dialog.b(this.gJY.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gJY.getPageContext().getString(R.string.copy_group_number)};
            this.gKB.mP(this.gJY.getPageContext().getString(R.string.operation));
            this.gKB.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gJY.getSystemService("clipboard")).setText(str);
                        a.this.gJY.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gKB.d(this.gJY.getPageContext());
        }
    }

    public void bEM() {
        ColorStateList ii = am.ii(R.color.cp_btn_a);
        if (ii != null) {
            this.gKy.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gKy.setTextColor(ii);
    }

    public void changeSkinType(int i) {
        this.gJY.getLayoutMode().setNightMode(i == 1);
        this.gJY.getLayoutMode().onModeChanged(this.cWd);
        this.gJY.getLayoutMode().onModeChanged(this.gKs);
        this.gKj.a(i, this.gJY);
        this.mNavigationBar.onChangeSkinType(this.gJY.getPageContext(), i);
        if (this.isMemGroup) {
            am.f(this.gKU, R.color.common_color_10009, 1);
        }
        if (!this.flv) {
            b(this.gKV, this.gKW);
        }
        if (this.gKX) {
            am.k(this.gKL, R.drawable.group_info_item);
        } else {
            am.l(this.gKL, R.color.cp_bg_line_d);
        }
    }

    public void mq(boolean z) {
        this.flv = z;
    }
}
