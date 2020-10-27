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
    public static int kdV = 0;
    private ScrollView czb;
    private View iqS;
    private boolean isMemGroup;
    private View jPD;
    private TextView kbQ;
    private final GroupInfoActivity kcU;
    private View kcV;
    private ProgressBar kcW;
    private RelativeLayout kcX;
    private TextView kcY;
    private TextView kcZ;
    private b kdA;
    private TextView kdB;
    private String kdC;
    private ImageView kdD;
    private RelativeLayout kdE;
    private TextView kdF;
    private ImageView kdG;
    private RelativeLayout kdH;
    private RelativeLayout kdI;
    private ImageView kdJ;
    private ImageView kdK;
    private View kdL;
    private TextView kdM;
    private TextView kdN;
    private LinearLayout kdO;
    private View kdP;
    private TextView kdQ;
    private ResponseGroupInfoLocalMessage.a kdR;
    private boolean kdS;
    private boolean kdT;
    private boolean kdU;
    private TextView kda;
    private TextView kdb;
    private EllipsizingTextView kdc;
    private TextView kdd;
    private RelativeLayout kde;
    private PhotoWallView kdf;
    private RelativeLayout kdg;
    private RelativeLayout kdh;
    private LinearLayout kdi;
    private HeadImageView kdj;
    private TextView kdk;
    private RelativeLayout kdl;
    private com.baidu.tbadk.core.dialog.b kdm;
    private ImageView kdn;
    private final View kdo;
    private b.InterfaceC0564b kdp;
    private RelativeLayout kdq;
    private LinearLayout kdr;
    private HeadImageView[] kds;
    private LinearLayout kdt;
    private TextView kdu;
    private RelativeLayout kdv;
    private LinearLayout kdw;
    private com.baidu.tbadk.core.dialog.b kdx;
    private LinearLayout kdy;
    private i kdz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.kdm = null;
        this.kdp = null;
        this.kds = new HeadImageView[5];
        this.kdC = "";
        this.kdS = true;
        this.isMemGroup = false;
        this.kdT = false;
        this.kdU = false;
        this.kcU = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.kdo = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.czb.setVisibility(4);
        this.kdt.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.kdF.setText(str);
        MC(str);
    }

    private void MC(String str) {
        if (str != null) {
            this.kdQ.setText(str);
        }
    }

    public void MD(String str) {
        this.kdc.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jPD = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kdQ = this.mNavigationBar.setTitleText("");
        this.kdP = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kdB = (TextView) this.kdP.findViewById(R.id.right_textview);
        this.kdB.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.kdB, R.color.cp_cont_f, 1);
        this.kdB.setOnClickListener(groupInfoActivity);
        this.kdP.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.kcV = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.czb = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.czb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.iqS = groupInfoActivity.findViewById(R.id.group_top_view);
        this.iqS.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kcX = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.kcX.setOnClickListener(groupInfoActivity);
        this.kcY = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.kcZ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.kdq = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.kdq.setOnClickListener(groupInfoActivity);
        this.kdy = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.kdD = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.kda = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.kdb = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.kdJ = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.kdc = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.kdc.setMaxLines(20);
        this.kdc.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void qB(boolean z) {
                if (z) {
                    a.this.kdM.setVisibility(0);
                } else {
                    a.this.kdM.setVisibility(8);
                }
            }
        });
        this.kde = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.kdd = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.kde.setOnClickListener(groupInfoActivity);
        this.kdj = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.kdj.setAutoChangeStyle(true);
        this.kdj.setIsRound(false);
        this.kbQ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.kdg = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.kdg.setOnClickListener(groupInfoActivity);
        this.kdn = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.kdL = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.kdi = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.kde.setOnClickListener(groupInfoActivity);
        this.kdh = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.kdh.setOnClickListener(groupInfoActivity);
        this.kdk = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.kdl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.kdl.setOnClickListener(groupInfoActivity);
        this.kdr = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.kdt = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.kdO = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.kdu = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.kdO.setOnClickListener(this.kcU);
        this.kdv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.kdv.setOnClickListener(groupInfoActivity);
        this.kdw = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.kdE = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.kdE.setOnClickListener(groupInfoActivity);
        this.kdF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.kdG = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.kdK = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.kdH = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.kdH.setOnClickListener(groupInfoActivity);
        this.kdH.setLongClickable(true);
        this.kdH.setOnLongClickListener(groupInfoActivity);
        this.kdM = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.kdM.setClickable(true);
        this.kdM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kdc.setMaxLines(1000);
            }
        });
        this.kdI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.kdI.setOnLongClickListener(groupInfoActivity);
        this.kdN = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.kcW = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.kdf = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.kdf.setPhotoClickListener(groupInfoActivity);
        this.kdf.setPhotoLongClickListener(groupInfoActivity);
        this.kdf.setVisibility(8);
    }

    public RelativeLayout cQG() {
        return this.kdI;
    }

    public RelativeLayout cQH() {
        return this.kde;
    }

    public LinearLayout cQI() {
        return this.kdr;
    }

    public RelativeLayout cQJ() {
        return this.kdv;
    }

    public RelativeLayout cQK() {
        return this.kdH;
    }

    public RelativeLayout cQL() {
        return this.kdE;
    }

    public RelativeLayout cQM() {
        return this.kcX;
    }

    public View cQN() {
        return this.kdB;
    }

    public LinearLayout cQO() {
        return this.kdO;
    }

    public RelativeLayout cQP() {
        return this.kdg;
    }

    public RelativeLayout cQQ() {
        return this.kdh;
    }

    public RelativeLayout cQR() {
        return this.kdl;
    }

    public View cPA() {
        return this.jPD;
    }

    public void cQS() {
        this.kcW.setVisibility(8);
    }

    public void cQT() {
        this.kcW.setVisibility(0);
    }

    public void t(boolean z, String str) {
        if (z) {
            this.kdb.setText(str);
            this.kdq.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.kdq.setVisibility(8);
        } else {
            this.kdb.setText(str);
            this.kdq.setVisibility(0);
        }
    }

    public void rR(boolean z) {
        if (z) {
            this.kdb.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.kdq.setVisibility(8);
        }
    }

    public RelativeLayout cQU() {
        return this.kdq;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.kdT = aVar.cRD();
            this.kdU = aVar.cRE();
            this.kdR = aVar;
            this.kdS = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cRy() != null) {
                kdV = aVar.cRy().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.kdy.setVisibility(0);
            this.kdt.setVisibility(0);
            if (aVar.getGroup() != null) {
                MC(aVar.getGroup().getName());
                this.kda.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.kdn.setVisibility(0);
                } else {
                    this.kdn.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.kdD.setVisibility(0);
                    this.kdj.setVisibility(8);
                    this.kdK.setVisibility(8);
                    this.kdL.setVisibility(8);
                    this.kbQ.setText(R.string.group_info_forum_author);
                    this.kdg.setEnabled(false);
                    this.kdn.setVisibility(8);
                } else {
                    this.kdD.setVisibility(8);
                    this.kdj.setVisibility(0);
                    this.kdK.setVisibility(0);
                    this.kdL.setVisibility(0);
                    this.kbQ.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.kdg.setEnabled(true);
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
                this.kdC = stringBuffer.toString();
                this.kdb.setText(this.kdC);
                this.kdc.setText(aVar.getGroup().getIntro());
                this.kdk.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.kdj.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.kde.setVisibility(0);
                    this.kdd.setText(aVar.getGroup().getForumName() + this.kcU.getPageContext().getString(R.string.forum));
                } else {
                    this.kde.setVisibility(8);
                }
                this.kdi.removeAllViews();
                boolean cRF = aVar.cRF();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.kdQ, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.kcU.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.kdi.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.kcU.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.kdi.addView(imageView2);
                }
                if (cRF) {
                    this.kdN.setVisibility(0);
                } else {
                    this.kdN.setVisibility(8);
                }
            }
            if (aVar.cRy() != null) {
                this.kcX.setVisibility(0);
                this.kcV.setVisibility(0);
                GroupActivityData cRy = aVar.cRy();
                if (!aVar.cRD()) {
                    if (cRy.getIsEnd() != 1) {
                        this.kcY.setVisibility(4);
                        this.kcZ.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.kcX.setVisibility(8);
                        this.kcV.setVisibility(8);
                    }
                } else {
                    this.kcY.setVisibility(0);
                    this.kcZ.setText(cRy.getgActivityTitle());
                    if (cRy.getIsEnd() != 1) {
                        this.kcY.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.kcY, R.color.common_color_10171, 1);
                    } else {
                        this.kcY.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.kcY, R.color.common_color_10168, 1);
                    }
                    this.kcZ.setText(cRy.getgActivityTitle());
                }
            } else if (aVar.cRE()) {
                this.kcX.setVisibility(0);
                this.kcV.setVisibility(0);
                this.kcY.setVisibility(4);
                this.kcZ.setText(R.string.group_info_create_activity);
            } else {
                this.kcX.setVisibility(8);
                this.kcV.setVisibility(8);
            }
            this.kdr.removeAllViews();
            if (aVar.cRz() != null && aVar.cRz().size() > 0) {
                List<MemberData> cRz = aVar.cRz();
                int size = cRz.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cRz.get(i3);
                    HeadImageView headImageView = this.kds[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.kcU.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.kds[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.kdr.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cRE()) {
                this.kdq.setEnabled(true);
                this.kdH.setEnabled(true);
                ap.setBackgroundResource(this.kdH, R.drawable.group_info_item);
                this.kdE.setVisibility(0);
                this.kdJ.setVisibility(0);
                this.kdG.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.kdF.setText(aVar.getGroup().getName());
                }
            } else {
                this.kdq.setEnabled(false);
                this.kdH.setEnabled(true);
                ap.setBackgroundColor(this.kdH, R.color.cp_bg_line_d);
                this.kdG.setVisibility(8);
                this.kdJ.setVisibility(8);
                this.kdc.setPadding(0, 0, 0, 0);
            }
            if (aVar.cRD()) {
                this.kdw.setVisibility(0);
                this.kdP.setVisibility(0);
                if (this.kdl.getParent() != this.kdw) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.kdy.removeView(this.kdl);
                    this.kdw.addView(this.kdl, 1);
                }
                cQV();
            } else {
                this.kdw.setVisibility(8);
                this.kdP.setVisibility(8);
                if (this.kdl.getParent() != this.kdy) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.kdw.removeView(this.kdl);
                    this.kdy.addView(this.kdl, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.kdh.setVisibility(8);
            } else {
                this.kdh.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                rR(aVar.cRE());
            } else {
                t(aVar.cRE(), this.kdC);
            }
            this.czb.setVisibility(0);
            this.kdt.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (CR(aVar.getGroup().getFlag())) {
                rS(z);
            } else {
                cQW();
            }
        }
    }

    public void cQV() {
        this.kdu.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.kdu, R.color.cp_cont_a, 1);
        this.kdu.setText(this.kcU.getPageContext().getString(R.string.i_want_talk));
        this.kdO.setEnabled(true);
    }

    private void rS(boolean z) {
        this.kdu.setText(this.kcU.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.kdu.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kdu, R.color.cp_cont_a, 1);
        } else {
            this.kdu.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kdu, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.kdO, R.drawable.btn_blue_bg);
        this.kdO.setEnabled(true);
    }

    private boolean CR(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cQW() {
        this.kdu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.kdu.setText(this.kcU.getPageContext().getString(R.string.group_info_refuse_join));
        this.kdu.setTextColor(this.kcU.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.kdO, R.drawable.btn_app_download_d);
        this.kdO.setEnabled(false);
    }

    public void ME(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.kdr.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.kdr.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.kdr.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.kdf.setIsManager(aVar.cRE());
            if (aVar.cRE()) {
                this.kdf.setVisibility(0);
                if (aVar.cRA() != null && aVar.cRA().size() == 1 && TextUtils.isEmpty(aVar.cRA().get(0).getPicId())) {
                    this.kdf.setData(null);
                } else {
                    this.kdf.setData(aVar.cRA());
                }
            } else if (aVar.cRA() != null && aVar.cRA().size() > 0) {
                if (aVar.cRA().size() == 1 && TextUtils.isEmpty(aVar.cRA().get(0).getPicId())) {
                    this.kdf.setVisibility(8);
                    return;
                }
                this.kdf.setVisibility(0);
                this.kdf.setData(aVar.cRA());
            } else {
                this.kdf.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.kdA = bVar;
    }

    public void d(Object obj, int i) {
        if (this.kdz != null) {
            this.kdz.dismiss();
            this.kdz = null;
        }
        e(obj, i);
        this.kdz.PJ();
    }

    private void e(final Object obj, final int i) {
        if (this.kdz == null) {
            this.kdz = new i(this.kcU.getPageContext());
            this.kdz.a(null, new String[]{this.kcU.getResources().getString(R.string.group_info_set_portrait), this.kcU.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.kdz != null && a.this.kdz.isShowing()) {
                        a.this.kdA.a(a.this.kdz, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.kdf != null) {
            this.kdf.onDestory();
        }
        if (this.kdj != null) {
            this.kdj.stopLoad();
            this.kdj.setBackgroundDrawable(null);
            this.kdj.setImageDrawable(null);
        }
        if (this.kdr != null && this.kds != null) {
            int length = this.kds.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.kds[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void MF(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.kcU.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.kcU.getPageContext().getPageActivity());
            bVar.Bb(this.kcU.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.kcU.getSystemService("clipboard")).setText(str);
                        a.this.kcU.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.kcU.getPageContext());
            bVar.bmE();
        }
    }

    public void MG(String str) {
        if (this.kdx == null) {
            MH(str);
        }
        this.kdx.bmE();
    }

    private void MH(final String str) {
        if (this.kdx == null) {
            this.kdx = new com.baidu.tbadk.core.dialog.b(this.kcU.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.kcU.getPageContext().getString(R.string.copy_group_number)};
            this.kdx.Bb(this.kcU.getPageContext().getString(R.string.operation));
            this.kdx.a(charSequenceArr, new b.InterfaceC0564b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0564b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.kcU.getSystemService("clipboard")).setText(str);
                        a.this.kcU.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.kdx.d(this.kcU.getPageContext());
        }
    }

    public void cQX() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.kdu.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.kdu.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.kcU.getLayoutMode().setNightMode(i == 1);
        this.kcU.getLayoutMode().onModeChanged(this.mContainer);
        this.kcU.getLayoutMode().onModeChanged(this.kdo);
        this.kdf.a(i, this.kcU);
        this.mNavigationBar.onChangeSkinType(this.kcU.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.kdQ, R.color.common_color_10009, 1);
        }
        if (!this.kdT) {
            b(this.kdR, this.kdS);
        }
        if (this.kdU) {
            ap.setBackgroundResource(this.kdH, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.kdH, R.color.cp_bg_line_d);
        }
    }

    public void rT(boolean z) {
        this.kdT = z;
    }
}
