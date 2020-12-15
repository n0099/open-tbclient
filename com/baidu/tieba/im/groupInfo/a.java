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
    public static int kyb = 0;
    private ScrollView cKf;
    private View iIy;
    private boolean isMemGroup;
    private View kjR;
    private TextView kvW;
    private TextView kxA;
    private RelativeLayout kxB;
    private LinearLayout kxC;
    private com.baidu.tbadk.core.dialog.b kxD;
    private LinearLayout kxE;
    private i kxF;
    private b kxG;
    private TextView kxH;
    private String kxI;
    private ImageView kxJ;
    private RelativeLayout kxK;
    private TextView kxL;
    private ImageView kxM;
    private RelativeLayout kxN;
    private RelativeLayout kxO;
    private ImageView kxP;
    private ImageView kxQ;
    private View kxR;
    private TextView kxS;
    private TextView kxT;
    private LinearLayout kxU;
    private View kxV;
    private TextView kxW;
    private ResponseGroupInfoLocalMessage.a kxX;
    private boolean kxY;
    private boolean kxZ;
    private final GroupInfoActivity kxa;
    private View kxb;
    private ProgressBar kxc;
    private RelativeLayout kxd;
    private TextView kxe;
    private TextView kxf;
    private TextView kxg;
    private TextView kxh;
    private EllipsizingTextView kxi;
    private TextView kxj;
    private RelativeLayout kxk;
    private PhotoWallView kxl;
    private RelativeLayout kxm;
    private RelativeLayout kxn;
    private LinearLayout kxo;
    private HeadImageView kxp;
    private TextView kxq;
    private RelativeLayout kxr;
    private com.baidu.tbadk.core.dialog.b kxs;
    private ImageView kxt;
    private final View kxu;
    private b.InterfaceC0586b kxv;
    private RelativeLayout kxw;
    private LinearLayout kxx;
    private HeadImageView[] kxy;
    private LinearLayout kxz;
    private boolean kya;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.kxs = null;
        this.kxv = null;
        this.kxy = new HeadImageView[5];
        this.kxI = "";
        this.kxY = true;
        this.isMemGroup = false;
        this.kxZ = false;
        this.kya = false;
        this.kxa = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.kxu = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cKf.setVisibility(4);
        this.kxz.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.kxL.setText(str);
        NC(str);
    }

    private void NC(String str) {
        if (str != null) {
            this.kxW.setText(str);
        }
    }

    public void ND(String str) {
        this.kxi.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.kjR = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kxW = this.mNavigationBar.setTitleText("");
        this.kxV = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kxH = (TextView) this.kxV.findViewById(R.id.right_textview);
        this.kxH.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.kxH, R.color.CAM_X0106, 1);
        this.kxH.setOnClickListener(groupInfoActivity);
        this.kxV.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.kxb = groupInfoActivity.findViewById(R.id.line_activity_name_down);
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
        this.iIy = groupInfoActivity.findViewById(R.id.group_top_view);
        this.iIy.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kxd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.kxd.setOnClickListener(groupInfoActivity);
        this.kxe = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.kxf = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.kxw = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.kxw.setOnClickListener(groupInfoActivity);
        this.kxE = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.kxJ = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.kxg = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.kxh = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.kxP = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.kxi = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.kxi.setMaxLines(20);
        this.kxi.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void ro(boolean z) {
                if (z) {
                    a.this.kxS.setVisibility(0);
                } else {
                    a.this.kxS.setVisibility(8);
                }
            }
        });
        this.kxk = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.kxj = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.kxk.setOnClickListener(groupInfoActivity);
        this.kxp = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.kxp.setAutoChangeStyle(true);
        this.kxp.setIsRound(false);
        this.kvW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.kxm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.kxm.setOnClickListener(groupInfoActivity);
        this.kxt = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.kxR = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.kxo = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.kxk.setOnClickListener(groupInfoActivity);
        this.kxn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.kxn.setOnClickListener(groupInfoActivity);
        this.kxq = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.kxr = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.kxr.setOnClickListener(groupInfoActivity);
        this.kxx = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.kxz = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.kxU = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.kxA = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.kxU.setOnClickListener(this.kxa);
        this.kxB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.kxB.setOnClickListener(groupInfoActivity);
        this.kxC = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.kxK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.kxK.setOnClickListener(groupInfoActivity);
        this.kxL = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.kxM = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.kxQ = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.kxN = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.kxN.setOnClickListener(groupInfoActivity);
        this.kxN.setLongClickable(true);
        this.kxN.setOnLongClickListener(groupInfoActivity);
        this.kxS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.kxS.setClickable(true);
        this.kxS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kxi.setMaxLines(1000);
            }
        });
        this.kxO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.kxO.setOnLongClickListener(groupInfoActivity);
        this.kxT = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.kxc = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.kxl = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.kxl.setPhotoClickListener(groupInfoActivity);
        this.kxl.setPhotoLongClickListener(groupInfoActivity);
        this.kxl.setVisibility(8);
    }

    public RelativeLayout cYa() {
        return this.kxO;
    }

    public RelativeLayout cYb() {
        return this.kxk;
    }

    public LinearLayout cYc() {
        return this.kxx;
    }

    public RelativeLayout cYd() {
        return this.kxB;
    }

    public RelativeLayout cYe() {
        return this.kxN;
    }

    public RelativeLayout cYf() {
        return this.kxK;
    }

    public RelativeLayout cYg() {
        return this.kxd;
    }

    public View cYh() {
        return this.kxH;
    }

    public LinearLayout cYi() {
        return this.kxU;
    }

    public RelativeLayout cYj() {
        return this.kxm;
    }

    public RelativeLayout cYk() {
        return this.kxn;
    }

    public RelativeLayout cYl() {
        return this.kxr;
    }

    public View cWU() {
        return this.kjR;
    }

    public void cYm() {
        this.kxc.setVisibility(8);
    }

    public void cYn() {
        this.kxc.setVisibility(0);
    }

    public void u(boolean z, String str) {
        if (z) {
            this.kxh.setText(str);
            this.kxw.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.kxw.setVisibility(8);
        } else {
            this.kxh.setText(str);
            this.kxw.setVisibility(0);
        }
    }

    public void sF(boolean z) {
        if (z) {
            this.kxh.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.kxw.setVisibility(8);
        }
    }

    public RelativeLayout cYo() {
        return this.kxw;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.kxZ = aVar.cYX();
            this.kya = aVar.cYY();
            this.kxX = aVar;
            this.kxY = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cYS() != null) {
                kyb = aVar.cYS().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.kxE.setVisibility(0);
            this.kxz.setVisibility(0);
            if (aVar.getGroup() != null) {
                NC(aVar.getGroup().getName());
                this.kxg.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.kxt.setVisibility(0);
                } else {
                    this.kxt.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.kxJ.setVisibility(0);
                    this.kxp.setVisibility(8);
                    this.kxQ.setVisibility(8);
                    this.kxR.setVisibility(8);
                    this.kvW.setText(R.string.group_info_forum_author);
                    this.kxm.setEnabled(false);
                    this.kxt.setVisibility(8);
                } else {
                    this.kxJ.setVisibility(8);
                    this.kxp.setVisibility(0);
                    this.kxQ.setVisibility(0);
                    this.kxR.setVisibility(0);
                    this.kvW.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.kxm.setEnabled(true);
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
                this.kxI = stringBuffer.toString();
                this.kxh.setText(this.kxI);
                this.kxi.setText(aVar.getGroup().getIntro());
                this.kxq.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.kxp.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.kxk.setVisibility(0);
                    this.kxj.setText(aVar.getGroup().getForumName() + this.kxa.getPageContext().getString(R.string.forum));
                } else {
                    this.kxk.setVisibility(8);
                }
                this.kxo.removeAllViews();
                boolean cYZ = aVar.cYZ();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.kxW, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.kxa.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.kxo.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.kxa.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.kxo.addView(imageView2);
                }
                if (cYZ) {
                    this.kxT.setVisibility(0);
                } else {
                    this.kxT.setVisibility(8);
                }
            }
            if (aVar.cYS() != null) {
                this.kxd.setVisibility(0);
                this.kxb.setVisibility(0);
                GroupActivityData cYS = aVar.cYS();
                if (!aVar.cYX()) {
                    if (cYS.getIsEnd() != 1) {
                        this.kxe.setVisibility(4);
                        this.kxf.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.kxd.setVisibility(8);
                        this.kxb.setVisibility(8);
                    }
                } else {
                    this.kxe.setVisibility(0);
                    this.kxf.setText(cYS.getgActivityTitle());
                    if (cYS.getIsEnd() != 1) {
                        this.kxe.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.kxe, R.color.common_color_10171, 1);
                    } else {
                        this.kxe.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.kxe, R.color.common_color_10168, 1);
                    }
                    this.kxf.setText(cYS.getgActivityTitle());
                }
            } else if (aVar.cYY()) {
                this.kxd.setVisibility(0);
                this.kxb.setVisibility(0);
                this.kxe.setVisibility(4);
                this.kxf.setText(R.string.group_info_create_activity);
            } else {
                this.kxd.setVisibility(8);
                this.kxb.setVisibility(8);
            }
            this.kxx.removeAllViews();
            if (aVar.cYT() != null && aVar.cYT().size() > 0) {
                List<MemberData> cYT = aVar.cYT();
                int size = cYT.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cYT.get(i3);
                    HeadImageView headImageView = this.kxy[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.kxa.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.kxy[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.kxx.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cYY()) {
                this.kxw.setEnabled(true);
                this.kxN.setEnabled(true);
                ap.setBackgroundResource(this.kxN, R.drawable.group_info_item);
                this.kxK.setVisibility(0);
                this.kxP.setVisibility(0);
                this.kxM.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.kxL.setText(aVar.getGroup().getName());
                }
            } else {
                this.kxw.setEnabled(false);
                this.kxN.setEnabled(true);
                ap.setBackgroundColor(this.kxN, R.color.CAM_X0201);
                this.kxM.setVisibility(8);
                this.kxP.setVisibility(8);
                this.kxi.setPadding(0, 0, 0, 0);
            }
            if (aVar.cYX()) {
                this.kxC.setVisibility(0);
                this.kxV.setVisibility(0);
                if (this.kxr.getParent() != this.kxC) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.kxE.removeView(this.kxr);
                    this.kxC.addView(this.kxr, 1);
                }
                cYp();
            } else {
                this.kxC.setVisibility(8);
                this.kxV.setVisibility(8);
                if (this.kxr.getParent() != this.kxE) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.kxC.removeView(this.kxr);
                    this.kxE.addView(this.kxr, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.kxn.setVisibility(8);
            } else {
                this.kxn.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                sF(aVar.cYY());
            } else {
                u(aVar.cYY(), this.kxI);
            }
            this.cKf.setVisibility(0);
            this.kxz.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (Er(aVar.getGroup().getFlag())) {
                sG(z);
            } else {
                cYq();
            }
        }
    }

    public void cYp() {
        this.kxA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.kxA, R.color.CAM_X0101, 1);
        this.kxA.setText(this.kxa.getPageContext().getString(R.string.i_want_talk));
        this.kxU.setEnabled(true);
    }

    private void sG(boolean z) {
        this.kxA.setText(this.kxa.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.kxA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kxA, R.color.CAM_X0101, 1);
        } else {
            this.kxA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kxA, R.color.CAM_X0101, 1);
        }
        ap.setBackgroundResource(this.kxU, R.drawable.btn_blue_bg);
        this.kxU.setEnabled(true);
    }

    private boolean Er(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cYq() {
        this.kxA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.kxA.setText(this.kxa.getPageContext().getString(R.string.group_info_refuse_join));
        this.kxA.setTextColor(this.kxa.getResources().getColorStateList(R.color.CAM_X0101));
        ap.setBackgroundResource(this.kxU, R.drawable.btn_app_download_d);
        this.kxU.setEnabled(false);
    }

    public void NE(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.kxx.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.kxx.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.kxx.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.kxl.setIsManager(aVar.cYY());
            if (aVar.cYY()) {
                this.kxl.setVisibility(0);
                if (aVar.cYU() != null && aVar.cYU().size() == 1 && TextUtils.isEmpty(aVar.cYU().get(0).getPicId())) {
                    this.kxl.setData(null);
                } else {
                    this.kxl.setData(aVar.cYU());
                }
            } else if (aVar.cYU() != null && aVar.cYU().size() > 0) {
                if (aVar.cYU().size() == 1 && TextUtils.isEmpty(aVar.cYU().get(0).getPicId())) {
                    this.kxl.setVisibility(8);
                    return;
                }
                this.kxl.setVisibility(0);
                this.kxl.setData(aVar.cYU());
            } else {
                this.kxl.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.kxG = bVar;
    }

    public void d(Object obj, int i) {
        if (this.kxF != null) {
            this.kxF.dismiss();
            this.kxF = null;
        }
        e(obj, i);
        this.kxF.RU();
    }

    private void e(final Object obj, final int i) {
        if (this.kxF == null) {
            this.kxF = new i(this.kxa.getPageContext());
            this.kxF.a(null, new String[]{this.kxa.getResources().getString(R.string.group_info_set_portrait), this.kxa.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.kxF != null && a.this.kxF.isShowing()) {
                        a.this.kxG.a(a.this.kxF, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.kxl != null) {
            this.kxl.onDestory();
        }
        if (this.kxp != null) {
            this.kxp.stopLoad();
            this.kxp.setBackgroundDrawable(null);
            this.kxp.setImageDrawable(null);
        }
        if (this.kxx != null && this.kxy != null) {
            int length = this.kxy.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.kxy[i];
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
            CharSequence[] charSequenceArr = {this.kxa.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.kxa.getPageContext().getPageActivity());
            bVar.Br(this.kxa.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.kxa.getSystemService("clipboard")).setText(str);
                        a.this.kxa.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.kxa.getPageContext());
            bVar.brx();
        }
    }

    public void NG(String str) {
        if (this.kxD == null) {
            NH(str);
        }
        this.kxD.brx();
    }

    private void NH(final String str) {
        if (this.kxD == null) {
            this.kxD = new com.baidu.tbadk.core.dialog.b(this.kxa.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.kxa.getPageContext().getString(R.string.copy_group_number)};
            this.kxD.Br(this.kxa.getPageContext().getString(R.string.operation));
            this.kxD.a(charSequenceArr, new b.InterfaceC0586b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0586b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.kxa.getSystemService("clipboard")).setText(str);
                        a.this.kxa.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.kxD.d(this.kxa.getPageContext());
        }
    }

    public void cYr() {
        ColorStateList colorList = ap.getColorList(R.color.CAM_X0101);
        if (colorList != null) {
            this.kxA.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.kxA.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.kxa.getLayoutMode().setNightMode(i == 1);
        this.kxa.getLayoutMode().onModeChanged(this.mContainer);
        this.kxa.getLayoutMode().onModeChanged(this.kxu);
        this.kxl.a(i, this.kxa);
        this.mNavigationBar.onChangeSkinType(this.kxa.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.kxW, R.color.common_color_10009, 1);
        }
        if (!this.kxZ) {
            b(this.kxX, this.kxY);
        }
        if (this.kya) {
            ap.setBackgroundResource(this.kxN, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.kxN, R.color.CAM_X0201);
        }
    }

    public void sH(boolean z) {
        this.kxZ = z;
    }
}
