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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes23.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int kxZ = 0;
    private ScrollView cKf;
    private View iIw;
    private boolean isMemGroup;
    private View kjP;
    private TextView kvU;
    private final GroupInfoActivity kwY;
    private View kwZ;
    private LinearLayout kxA;
    private com.baidu.tbadk.core.dialog.b kxB;
    private LinearLayout kxC;
    private i kxD;
    private b kxE;
    private TextView kxF;
    private String kxG;
    private ImageView kxH;
    private RelativeLayout kxI;
    private TextView kxJ;
    private ImageView kxK;
    private RelativeLayout kxL;
    private RelativeLayout kxM;
    private ImageView kxN;
    private ImageView kxO;
    private View kxP;
    private TextView kxQ;
    private TextView kxR;
    private LinearLayout kxS;
    private View kxT;
    private TextView kxU;
    private ResponseGroupInfoLocalMessage.a kxV;
    private boolean kxW;
    private boolean kxX;
    private boolean kxY;
    private ProgressBar kxa;
    private RelativeLayout kxb;
    private TextView kxc;
    private TextView kxd;
    private TextView kxe;
    private TextView kxf;
    private EllipsizingTextView kxg;
    private TextView kxh;
    private RelativeLayout kxi;
    private PhotoWallView kxj;
    private RelativeLayout kxk;
    private RelativeLayout kxl;
    private LinearLayout kxm;
    private HeadImageView kxn;
    private TextView kxo;
    private RelativeLayout kxp;
    private com.baidu.tbadk.core.dialog.b kxq;
    private ImageView kxr;
    private final View kxs;
    private b.InterfaceC0586b kxt;
    private RelativeLayout kxu;
    private LinearLayout kxv;
    private HeadImageView[] kxw;
    private LinearLayout kxx;
    private TextView kxy;
    private RelativeLayout kxz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.kxq = null;
        this.kxt = null;
        this.kxw = new HeadImageView[5];
        this.kxG = "";
        this.kxW = true;
        this.isMemGroup = false;
        this.kxX = false;
        this.kxY = false;
        this.kwY = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.kxs = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cKf.setVisibility(4);
        this.kxx.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.kxJ.setText(str);
        NC(str);
    }

    private void NC(String str) {
        if (str != null) {
            this.kxU.setText(str);
        }
    }

    public void ND(String str) {
        this.kxg.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.kjP = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kxU = this.mNavigationBar.setTitleText("");
        this.kxT = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kxF = (TextView) this.kxT.findViewById(R.id.right_textview);
        this.kxF.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.kxF, R.color.CAM_X0106, 1);
        this.kxF.setOnClickListener(groupInfoActivity);
        this.kxT.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.kwZ = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cKf = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cKf.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.iIw = groupInfoActivity.findViewById(R.id.group_top_view);
        this.iIw.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kxb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.kxb.setOnClickListener(groupInfoActivity);
        this.kxc = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.kxd = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.kxu = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.kxu.setOnClickListener(groupInfoActivity);
        this.kxC = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.kxH = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.kxe = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.kxf = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.kxN = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.kxg = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.kxg.setMaxLines(20);
        this.kxg.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void ro(boolean z) {
                if (z) {
                    a.this.kxQ.setVisibility(0);
                } else {
                    a.this.kxQ.setVisibility(8);
                }
            }
        });
        this.kxi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.kxh = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.kxi.setOnClickListener(groupInfoActivity);
        this.kxn = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.kxn.setAutoChangeStyle(true);
        this.kxn.setIsRound(false);
        this.kvU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.kxk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.kxk.setOnClickListener(groupInfoActivity);
        this.kxr = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.kxP = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.kxm = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.kxi.setOnClickListener(groupInfoActivity);
        this.kxl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.kxl.setOnClickListener(groupInfoActivity);
        this.kxo = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.kxp = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.kxp.setOnClickListener(groupInfoActivity);
        this.kxv = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.kxx = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.kxS = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.kxy = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.kxS.setOnClickListener(this.kwY);
        this.kxz = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.kxz.setOnClickListener(groupInfoActivity);
        this.kxA = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.kxI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.kxI.setOnClickListener(groupInfoActivity);
        this.kxJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.kxK = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.kxO = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.kxL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.kxL.setOnClickListener(groupInfoActivity);
        this.kxL.setLongClickable(true);
        this.kxL.setOnLongClickListener(groupInfoActivity);
        this.kxQ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.kxQ.setClickable(true);
        this.kxQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kxg.setMaxLines(1000);
            }
        });
        this.kxM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.kxM.setOnLongClickListener(groupInfoActivity);
        this.kxR = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.kxa = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.kxj = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.kxj.setPhotoClickListener(groupInfoActivity);
        this.kxj.setPhotoLongClickListener(groupInfoActivity);
        this.kxj.setVisibility(8);
    }

    public RelativeLayout cXZ() {
        return this.kxM;
    }

    public RelativeLayout cYa() {
        return this.kxi;
    }

    public LinearLayout cYb() {
        return this.kxv;
    }

    public RelativeLayout cYc() {
        return this.kxz;
    }

    public RelativeLayout cYd() {
        return this.kxL;
    }

    public RelativeLayout cYe() {
        return this.kxI;
    }

    public RelativeLayout cYf() {
        return this.kxb;
    }

    public View cYg() {
        return this.kxF;
    }

    public LinearLayout cYh() {
        return this.kxS;
    }

    public RelativeLayout cYi() {
        return this.kxk;
    }

    public RelativeLayout cYj() {
        return this.kxl;
    }

    public RelativeLayout cYk() {
        return this.kxp;
    }

    public View cWT() {
        return this.kjP;
    }

    public void cYl() {
        this.kxa.setVisibility(8);
    }

    public void cYm() {
        this.kxa.setVisibility(0);
    }

    public void u(boolean z, String str) {
        if (z) {
            this.kxf.setText(str);
            this.kxu.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.kxu.setVisibility(8);
        } else {
            this.kxf.setText(str);
            this.kxu.setVisibility(0);
        }
    }

    public void sF(boolean z) {
        if (z) {
            this.kxf.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.kxu.setVisibility(8);
        }
    }

    public RelativeLayout cYn() {
        return this.kxu;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.kxX = aVar.cYW();
            this.kxY = aVar.cYX();
            this.kxV = aVar;
            this.kxW = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cYR() != null) {
                kxZ = aVar.cYR().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.kxC.setVisibility(0);
            this.kxx.setVisibility(0);
            if (aVar.getGroup() != null) {
                NC(aVar.getGroup().getName());
                this.kxe.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.kxr.setVisibility(0);
                } else {
                    this.kxr.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.kxH.setVisibility(0);
                    this.kxn.setVisibility(8);
                    this.kxO.setVisibility(8);
                    this.kxP.setVisibility(8);
                    this.kvU.setText(R.string.group_info_forum_author);
                    this.kxk.setEnabled(false);
                    this.kxr.setVisibility(8);
                } else {
                    this.kxH.setVisibility(8);
                    this.kxn.setVisibility(0);
                    this.kxO.setVisibility(0);
                    this.kxP.setVisibility(0);
                    this.kvU.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.kxk.setEnabled(true);
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
                this.kxG = stringBuffer.toString();
                this.kxf.setText(this.kxG);
                this.kxg.setText(aVar.getGroup().getIntro());
                this.kxo.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.kxn.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.kxi.setVisibility(0);
                    this.kxh.setText(aVar.getGroup().getForumName() + this.kwY.getPageContext().getString(R.string.forum));
                } else {
                    this.kxi.setVisibility(8);
                }
                this.kxm.removeAllViews();
                boolean cYY = aVar.cYY();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.kxU, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.kwY.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.kxm.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.kwY.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.kxm.addView(imageView2);
                }
                if (cYY) {
                    this.kxR.setVisibility(0);
                } else {
                    this.kxR.setVisibility(8);
                }
            }
            if (aVar.cYR() != null) {
                this.kxb.setVisibility(0);
                this.kwZ.setVisibility(0);
                GroupActivityData cYR = aVar.cYR();
                if (!aVar.cYW()) {
                    if (cYR.getIsEnd() != 1) {
                        this.kxc.setVisibility(4);
                        this.kxd.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.kxb.setVisibility(8);
                        this.kwZ.setVisibility(8);
                    }
                } else {
                    this.kxc.setVisibility(0);
                    this.kxd.setText(cYR.getgActivityTitle());
                    if (cYR.getIsEnd() != 1) {
                        this.kxc.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.kxc, R.color.common_color_10171, 1);
                    } else {
                        this.kxc.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.kxc, R.color.common_color_10168, 1);
                    }
                    this.kxd.setText(cYR.getgActivityTitle());
                }
            } else if (aVar.cYX()) {
                this.kxb.setVisibility(0);
                this.kwZ.setVisibility(0);
                this.kxc.setVisibility(4);
                this.kxd.setText(R.string.group_info_create_activity);
            } else {
                this.kxb.setVisibility(8);
                this.kwZ.setVisibility(8);
            }
            this.kxv.removeAllViews();
            if (aVar.cYS() != null && aVar.cYS().size() > 0) {
                List<MemberData> cYS = aVar.cYS();
                int size = cYS.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cYS.get(i3);
                    HeadImageView headImageView = this.kxw[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.kwY.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.kxw[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.kxv.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cYX()) {
                this.kxu.setEnabled(true);
                this.kxL.setEnabled(true);
                ap.setBackgroundResource(this.kxL, R.drawable.group_info_item);
                this.kxI.setVisibility(0);
                this.kxN.setVisibility(0);
                this.kxK.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.kxJ.setText(aVar.getGroup().getName());
                }
            } else {
                this.kxu.setEnabled(false);
                this.kxL.setEnabled(true);
                ap.setBackgroundColor(this.kxL, R.color.CAM_X0201);
                this.kxK.setVisibility(8);
                this.kxN.setVisibility(8);
                this.kxg.setPadding(0, 0, 0, 0);
            }
            if (aVar.cYW()) {
                this.kxA.setVisibility(0);
                this.kxT.setVisibility(0);
                if (this.kxp.getParent() != this.kxA) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.kxC.removeView(this.kxp);
                    this.kxA.addView(this.kxp, 1);
                }
                cYo();
            } else {
                this.kxA.setVisibility(8);
                this.kxT.setVisibility(8);
                if (this.kxp.getParent() != this.kxC) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.kxA.removeView(this.kxp);
                    this.kxC.addView(this.kxp, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.kxl.setVisibility(8);
            } else {
                this.kxl.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                sF(aVar.cYX());
            } else {
                u(aVar.cYX(), this.kxG);
            }
            this.cKf.setVisibility(0);
            this.kxx.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (Er(aVar.getGroup().getFlag())) {
                sG(z);
            } else {
                cYp();
            }
        }
    }

    public void cYo() {
        this.kxy.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.kxy, R.color.CAM_X0101, 1);
        this.kxy.setText(this.kwY.getPageContext().getString(R.string.i_want_talk));
        this.kxS.setEnabled(true);
    }

    private void sG(boolean z) {
        this.kxy.setText(this.kwY.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.kxy.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kxy, R.color.CAM_X0101, 1);
        } else {
            this.kxy.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kxy, R.color.CAM_X0101, 1);
        }
        ap.setBackgroundResource(this.kxS, R.drawable.btn_blue_bg);
        this.kxS.setEnabled(true);
    }

    private boolean Er(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cYp() {
        this.kxy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.kxy.setText(this.kwY.getPageContext().getString(R.string.group_info_refuse_join));
        this.kxy.setTextColor(this.kwY.getResources().getColorStateList(R.color.CAM_X0101));
        ap.setBackgroundResource(this.kxS, R.drawable.btn_app_download_d);
        this.kxS.setEnabled(false);
    }

    public void NE(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.kxv.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.kxv.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.kxv.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.kxj.setIsManager(aVar.cYX());
            if (aVar.cYX()) {
                this.kxj.setVisibility(0);
                if (aVar.cYT() != null && aVar.cYT().size() == 1 && TextUtils.isEmpty(aVar.cYT().get(0).getPicId())) {
                    this.kxj.setData(null);
                } else {
                    this.kxj.setData(aVar.cYT());
                }
            } else if (aVar.cYT() != null && aVar.cYT().size() > 0) {
                if (aVar.cYT().size() == 1 && TextUtils.isEmpty(aVar.cYT().get(0).getPicId())) {
                    this.kxj.setVisibility(8);
                    return;
                }
                this.kxj.setVisibility(0);
                this.kxj.setData(aVar.cYT());
            } else {
                this.kxj.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.kxE = bVar;
    }

    public void d(Object obj, int i) {
        if (this.kxD != null) {
            this.kxD.dismiss();
            this.kxD = null;
        }
        e(obj, i);
        this.kxD.RU();
    }

    private void e(final Object obj, final int i) {
        if (this.kxD == null) {
            this.kxD = new i(this.kwY.getPageContext());
            this.kxD.a(null, new String[]{this.kwY.getResources().getString(R.string.group_info_set_portrait), this.kwY.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.kxD != null && a.this.kxD.isShowing()) {
                        a.this.kxE.a(a.this.kxD, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.kxj != null) {
            this.kxj.onDestory();
        }
        if (this.kxn != null) {
            this.kxn.stopLoad();
            this.kxn.setBackgroundDrawable(null);
            this.kxn.setImageDrawable(null);
        }
        if (this.kxv != null && this.kxw != null) {
            int length = this.kxw.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.kxw[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void NF(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.kwY.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.kwY.getPageContext().getPageActivity());
            bVar.Br(this.kwY.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.kwY.getSystemService("clipboard")).setText(str);
                        a.this.kwY.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.kwY.getPageContext());
            bVar.brx();
        }
    }

    public void NG(String str) {
        if (this.kxB == null) {
            NH(str);
        }
        this.kxB.brx();
    }

    private void NH(final String str) {
        if (this.kxB == null) {
            this.kxB = new com.baidu.tbadk.core.dialog.b(this.kwY.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.kwY.getPageContext().getString(R.string.copy_group_number)};
            this.kxB.Br(this.kwY.getPageContext().getString(R.string.operation));
            this.kxB.a(charSequenceArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.kwY.getSystemService("clipboard")).setText(str);
                        a.this.kwY.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.kxB.d(this.kwY.getPageContext());
        }
    }

    public void cYq() {
        ColorStateList colorList = ap.getColorList(R.color.CAM_X0101);
        if (colorList != null) {
            this.kxy.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.kxy.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.kwY.getLayoutMode().setNightMode(i == 1);
        this.kwY.getLayoutMode().onModeChanged(this.mContainer);
        this.kwY.getLayoutMode().onModeChanged(this.kxs);
        this.kxj.a(i, this.kwY);
        this.mNavigationBar.onChangeSkinType(this.kwY.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.kxU, R.color.common_color_10009, 1);
        }
        if (!this.kxX) {
            b(this.kxV, this.kxW);
        }
        if (this.kxY) {
            ap.setBackgroundResource(this.kxL, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.kxL, R.color.CAM_X0201);
        }
    }

    public void sH(boolean z) {
        this.kxX = z;
    }
}
