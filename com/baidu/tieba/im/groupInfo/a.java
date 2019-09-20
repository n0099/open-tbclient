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
    private ScrollView bcE;
    private RelativeLayout cXd;
    private View fio;
    private boolean fnH;
    private View gBq;
    private TextView gLF;
    private final GroupInfoActivity gMI;
    private View gMJ;
    private ProgressBar gMK;
    private RelativeLayout gML;
    private TextView gMM;
    private TextView gMN;
    private TextView gMO;
    private TextView gMP;
    private EllipsizingTextView gMQ;
    private TextView gMR;
    private RelativeLayout gMS;
    private PhotoWallView gMT;
    private RelativeLayout gMU;
    private RelativeLayout gMV;
    private LinearLayout gMW;
    private HeadImageView gMX;
    private TextView gMY;
    private RelativeLayout gMZ;
    private TextView gNA;
    private TextView gNB;
    private LinearLayout gNC;
    private View gND;
    private TextView gNE;
    private ResponseGroupInfoLocalMessage.a gNF;
    private boolean gNG;
    private boolean gNH;
    private com.baidu.tbadk.core.dialog.b gNa;
    private ImageView gNb;
    private final View gNc;
    private b.a gNd;
    private RelativeLayout gNe;
    private LinearLayout gNf;
    private HeadImageView[] gNg;
    private LinearLayout gNh;
    private TextView gNi;
    private RelativeLayout gNj;
    private LinearLayout gNk;
    private com.baidu.tbadk.core.dialog.b gNl;
    private LinearLayout gNm;
    private i gNn;
    private b gNo;
    private TextView gNp;
    private String gNq;
    private ImageView gNr;
    private RelativeLayout gNs;
    private TextView gNt;
    private ImageView gNu;
    private RelativeLayout gNv;
    private RelativeLayout gNw;
    private ImageView gNx;
    private ImageView gNy;
    private View gNz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gNI = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gNa = null;
        this.gNd = null;
        this.gNg = new HeadImageView[5];
        this.gNq = "";
        this.gNG = true;
        this.isMemGroup = false;
        this.fnH = false;
        this.gNH = false;
        this.gMI = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gNc = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bcE.setVisibility(4);
        this.gNh.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gNt.setText(str);
        zH(str);
    }

    private void zH(String str) {
        if (str != null) {
            this.gNE.setText(str);
        }
    }

    public void zI(String str) {
        this.gMQ.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gBq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gNE = this.mNavigationBar.setTitleText("");
        this.gND = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gNp = (TextView) this.gND.findViewById(R.id.right_textview);
        this.gNp.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.f(this.gNp, R.color.cp_cont_f, 1);
        this.gNp.setOnClickListener(groupInfoActivity);
        this.gND.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gMJ = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cXd = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bcE = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bcE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.fio = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fio.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gML = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gML.setOnClickListener(groupInfoActivity);
        this.gMM = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gMN = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gNe = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gNe.setOnClickListener(groupInfoActivity);
        this.gNm = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gNr = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gMO = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gMP = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gNx = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gMQ = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gMQ.setMaxLines(20);
        this.gMQ.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void lg(boolean z) {
                if (z) {
                    a.this.gNA.setVisibility(0);
                } else {
                    a.this.gNA.setVisibility(8);
                }
            }
        });
        this.gMS = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gMR = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gMS.setOnClickListener(groupInfoActivity);
        this.gMX = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gMX.setAutoChangeStyle(true);
        this.gMX.setIsRound(false);
        this.gLF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gMU = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gMU.setOnClickListener(groupInfoActivity);
        this.gNb = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gNz = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gMW = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gMS.setOnClickListener(groupInfoActivity);
        this.gMV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gMV.setOnClickListener(groupInfoActivity);
        this.gMY = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gMZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gMZ.setOnClickListener(groupInfoActivity);
        this.gNf = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gNh = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gNC = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gNi = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gNC.setOnClickListener(this.gMI);
        this.gNj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gNj.setOnClickListener(groupInfoActivity);
        this.gNk = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gNs = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gNs.setOnClickListener(groupInfoActivity);
        this.gNt = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gNu = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gNy = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gNv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gNv.setOnClickListener(groupInfoActivity);
        this.gNv.setLongClickable(true);
        this.gNv.setOnLongClickListener(groupInfoActivity);
        this.gNA = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gNA.setClickable(true);
        this.gNA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gMQ.setMaxLines(1000);
            }
        });
        this.gNw = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gNw.setOnLongClickListener(groupInfoActivity);
        this.gNB = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gMK = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gMT = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gMT.setPhotoClickListener(groupInfoActivity);
        this.gMT.setPhotoLongClickListener(groupInfoActivity);
        this.gMT.setVisibility(8);
    }

    public RelativeLayout bFx() {
        return this.gNw;
    }

    public RelativeLayout bFy() {
        return this.gMS;
    }

    public LinearLayout bFz() {
        return this.gNf;
    }

    public RelativeLayout bFA() {
        return this.gNj;
    }

    public RelativeLayout bFB() {
        return this.gNv;
    }

    public RelativeLayout bFC() {
        return this.gNs;
    }

    public RelativeLayout bFD() {
        return this.gML;
    }

    public View bFE() {
        return this.gNp;
    }

    public LinearLayout bFF() {
        return this.gNC;
    }

    public RelativeLayout bFG() {
        return this.gMU;
    }

    public RelativeLayout bFH() {
        return this.gMV;
    }

    public RelativeLayout bFI() {
        return this.gMZ;
    }

    public View bEs() {
        return this.gBq;
    }

    public void bFJ() {
        this.gMK.setVisibility(8);
    }

    public void bFK() {
        this.gMK.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gMP.setText(str);
            this.gNe.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gNe.setVisibility(8);
        } else {
            this.gMP.setText(str);
            this.gNe.setVisibility(0);
        }
    }

    public void mr(boolean z) {
        if (z) {
            this.gMP.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gNe.setVisibility(8);
        }
    }

    public RelativeLayout bFL() {
        return this.gNe;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.fnH = aVar.bGv();
            this.gNH = aVar.bGw();
            this.gNF = aVar;
            this.gNG = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bGq() != null) {
                gNI = aVar.bGq().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gNm.setVisibility(0);
            this.gNh.setVisibility(0);
            if (aVar.getGroup() != null) {
                zH(aVar.getGroup().getName());
                this.gMO.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gNb.setVisibility(0);
                } else {
                    this.gNb.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gNr.setVisibility(0);
                    this.gMX.setVisibility(8);
                    this.gNy.setVisibility(8);
                    this.gNz.setVisibility(8);
                    this.gLF.setText(R.string.group_info_forum_author);
                    this.gMU.setEnabled(false);
                    this.gNb.setVisibility(8);
                } else {
                    this.gNr.setVisibility(8);
                    this.gMX.setVisibility(0);
                    this.gNy.setVisibility(0);
                    this.gNz.setVisibility(0);
                    this.gLF.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gMU.setEnabled(true);
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
                this.gNq = stringBuffer.toString();
                this.gMP.setText(this.gNq);
                this.gMQ.setText(aVar.getGroup().getIntro());
                this.gMY.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gMX.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gMS.setVisibility(0);
                    this.gMR.setText(aVar.getGroup().getForumName() + this.gMI.getPageContext().getString(R.string.forum));
                } else {
                    this.gMS.setVisibility(8);
                }
                this.gMW.removeAllViews();
                boolean bGx = aVar.bGx();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.f(this.gNE, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gMI.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gMW.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gMI.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gMW.addView(imageView2);
                }
                if (bGx) {
                    this.gNB.setVisibility(0);
                } else {
                    this.gNB.setVisibility(8);
                }
            }
            if (aVar.bGq() != null) {
                this.gML.setVisibility(0);
                this.gMJ.setVisibility(0);
                GroupActivityData bGq = aVar.bGq();
                if (!aVar.bGv()) {
                    if (bGq.getIsEnd() != 1) {
                        this.gMM.setVisibility(4);
                        this.gMN.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gML.setVisibility(8);
                        this.gMJ.setVisibility(8);
                    }
                } else {
                    this.gMM.setVisibility(0);
                    this.gMN.setText(bGq.getgActivityTitle());
                    if (bGq.getIsEnd() != 1) {
                        this.gMM.setText(R.string.group_info_activity_doing);
                        am.f(this.gMM, R.color.common_color_10171, 1);
                    } else {
                        this.gMM.setText(R.string.group_activity_end);
                        am.f(this.gMM, R.color.common_color_10168, 1);
                    }
                    this.gMN.setText(bGq.getgActivityTitle());
                }
            } else if (aVar.bGw()) {
                this.gML.setVisibility(0);
                this.gMJ.setVisibility(0);
                this.gMM.setVisibility(4);
                this.gMN.setText(R.string.group_info_create_activity);
            } else {
                this.gML.setVisibility(8);
                this.gMJ.setVisibility(8);
            }
            this.gNf.removeAllViews();
            if (aVar.bGr() != null && aVar.bGr().size() > 0) {
                List<MemberData> bGr = aVar.bGr();
                int size = bGr.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bGr.get(i3);
                    HeadImageView headImageView = this.gNg[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gMI.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gNg[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gNf.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bGw()) {
                this.gNe.setEnabled(true);
                this.gNv.setEnabled(true);
                am.k(this.gNv, R.drawable.group_info_item);
                this.gNs.setVisibility(0);
                this.gNx.setVisibility(0);
                this.gNu.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gNt.setText(aVar.getGroup().getName());
                }
            } else {
                this.gNe.setEnabled(false);
                this.gNv.setEnabled(true);
                am.l(this.gNv, R.color.cp_bg_line_d);
                this.gNu.setVisibility(8);
                this.gNx.setVisibility(8);
                this.gMQ.setPadding(0, 0, 0, 0);
            }
            if (aVar.bGv()) {
                this.gNk.setVisibility(0);
                this.gND.setVisibility(0);
                if (this.gMZ.getParent() != this.gNk) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gNm.removeView(this.gMZ);
                    this.gNk.addView(this.gMZ, 1);
                }
                bFM();
            } else {
                this.gNk.setVisibility(8);
                this.gND.setVisibility(8);
                if (this.gMZ.getParent() != this.gNm) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gNk.removeView(this.gMZ);
                    this.gNm.addView(this.gMZ, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gMV.setVisibility(8);
            } else {
                this.gMV.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                mr(aVar.bGw());
            } else {
                m(aVar.bGw(), this.gNq);
            }
            this.bcE.setVisibility(0);
            this.gNh.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vK(aVar.getGroup().getFlag())) {
                ms(z);
            } else {
                bFN();
            }
        }
    }

    public void bFM() {
        this.gNi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.gNi, R.color.cp_cont_a, 1);
        this.gNi.setText(this.gMI.getPageContext().getString(R.string.i_want_talk));
        this.gNC.setEnabled(true);
    }

    private void ms(boolean z) {
        this.gNi.setText(this.gMI.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gNi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gNi, R.color.cp_cont_a, 1);
        } else {
            this.gNi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gNi, R.color.cp_cont_a, 1);
        }
        am.k(this.gNC, R.drawable.btn_blue_bg);
        this.gNC.setEnabled(true);
    }

    private boolean vK(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bFN() {
        this.gNi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gNi.setText(this.gMI.getPageContext().getString(R.string.group_info_refuse_join));
        this.gNi.setTextColor(this.gMI.getResources().getColorStateList(R.color.cp_cont_a));
        am.k(this.gNC, R.drawable.btn_app_download_d);
        this.gNC.setEnabled(false);
    }

    public void zJ(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gNf.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gNf.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gNf.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gMT.setIsManager(aVar.bGw());
            if (aVar.bGw()) {
                this.gMT.setVisibility(0);
                if (aVar.bGs() != null && aVar.bGs().size() == 1 && TextUtils.isEmpty(aVar.bGs().get(0).getPicId())) {
                    this.gMT.setData(null);
                } else {
                    this.gMT.setData(aVar.bGs());
                }
            } else if (aVar.bGs() != null && aVar.bGs().size() > 0) {
                if (aVar.bGs().size() == 1 && TextUtils.isEmpty(aVar.bGs().get(0).getPicId())) {
                    this.gMT.setVisibility(8);
                    return;
                }
                this.gMT.setVisibility(0);
                this.gMT.setData(aVar.bGs());
            } else {
                this.gMT.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gNo = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gNn != null) {
            this.gNn.dismiss();
            this.gNn = null;
        }
        e(obj, i);
        this.gNn.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gNn == null) {
            this.gNn = new i(this.gMI.getPageContext());
            this.gNn.a(null, new String[]{this.gMI.getResources().getString(R.string.group_info_set_portrait), this.gMI.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gNn != null && a.this.gNn.isShowing()) {
                        a.this.gNo.a(a.this.gNn, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gMT != null) {
            this.gMT.onDestory();
        }
        if (this.gMX != null) {
            this.gMX.stopLoad();
            this.gMX.setBackgroundDrawable(null);
            this.gMX.setImageDrawable(null);
        }
        if (this.gNf != null && this.gNg != null) {
            int length = this.gNg.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gNg[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void zK(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gMI.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gMI.getPageContext().getPageActivity());
            bVar.mR(this.gMI.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gMI.getSystemService("clipboard")).setText(str);
                        a.this.gMI.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gMI.getPageContext());
            bVar.agR();
        }
    }

    public void zL(String str) {
        if (this.gNl == null) {
            zM(str);
        }
        this.gNl.agR();
    }

    private void zM(final String str) {
        if (this.gNl == null) {
            this.gNl = new com.baidu.tbadk.core.dialog.b(this.gMI.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gMI.getPageContext().getString(R.string.copy_group_number)};
            this.gNl.mR(this.gMI.getPageContext().getString(R.string.operation));
            this.gNl.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gMI.getSystemService("clipboard")).setText(str);
                        a.this.gMI.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gNl.d(this.gMI.getPageContext());
        }
    }

    public void bFO() {
        ColorStateList ii = am.ii(R.color.cp_cont_a);
        if (ii != null) {
            this.gNi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gNi.setTextColor(ii);
    }

    public void changeSkinType(int i) {
        this.gMI.getLayoutMode().setNightMode(i == 1);
        this.gMI.getLayoutMode().onModeChanged(this.cXd);
        this.gMI.getLayoutMode().onModeChanged(this.gNc);
        this.gMT.a(i, this.gMI);
        this.mNavigationBar.onChangeSkinType(this.gMI.getPageContext(), i);
        if (this.isMemGroup) {
            am.f(this.gNE, R.color.common_color_10009, 1);
        }
        if (!this.fnH) {
            b(this.gNF, this.gNG);
        }
        if (this.gNH) {
            am.k(this.gNv, R.drawable.group_info_item);
        } else {
            am.l(this.gNv, R.color.cp_bg_line_d);
        }
    }

    public void mt(boolean z) {
        this.fnH = z;
    }
}
