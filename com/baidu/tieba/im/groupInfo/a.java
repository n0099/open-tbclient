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
    public static int jRw = 0;
    private ScrollView cqA;
    private View ieu;
    private boolean isMemGroup;
    private View jDe;
    private TextView jPr;
    private TextView jQA;
    private TextView jQB;
    private TextView jQC;
    private EllipsizingTextView jQD;
    private TextView jQE;
    private RelativeLayout jQF;
    private PhotoWallView jQG;
    private RelativeLayout jQH;
    private RelativeLayout jQI;
    private LinearLayout jQJ;
    private HeadImageView jQK;
    private TextView jQL;
    private RelativeLayout jQM;
    private com.baidu.tbadk.core.dialog.b jQN;
    private ImageView jQO;
    private final View jQP;
    private b.InterfaceC0550b jQQ;
    private RelativeLayout jQR;
    private LinearLayout jQS;
    private HeadImageView[] jQT;
    private LinearLayout jQU;
    private TextView jQV;
    private RelativeLayout jQW;
    private LinearLayout jQX;
    private com.baidu.tbadk.core.dialog.b jQY;
    private LinearLayout jQZ;
    private final GroupInfoActivity jQv;
    private View jQw;
    private ProgressBar jQx;
    private RelativeLayout jQy;
    private TextView jQz;
    private i jRa;
    private b jRb;
    private TextView jRc;
    private String jRd;
    private ImageView jRe;
    private RelativeLayout jRf;
    private TextView jRg;
    private ImageView jRh;
    private RelativeLayout jRi;
    private RelativeLayout jRj;
    private ImageView jRk;
    private ImageView jRl;
    private View jRm;
    private TextView jRn;
    private TextView jRo;
    private LinearLayout jRp;
    private View jRq;
    private TextView jRr;
    private ResponseGroupInfoLocalMessage.a jRs;
    private boolean jRt;
    private boolean jRu;
    private boolean jRv;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jQN = null;
        this.jQQ = null;
        this.jQT = new HeadImageView[5];
        this.jRd = "";
        this.jRt = true;
        this.isMemGroup = false;
        this.jRu = false;
        this.jRv = false;
        this.jQv = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jQP = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cqA.setVisibility(4);
        this.jQU.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jRg.setText(str);
        Me(str);
    }

    private void Me(String str) {
        if (str != null) {
            this.jRr.setText(str);
        }
    }

    public void Mf(String str) {
        this.jQD.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jDe = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jRr = this.mNavigationBar.setTitleText("");
        this.jRq = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jRc = (TextView) this.jRq.findViewById(R.id.right_textview);
        this.jRc.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.jRc, R.color.cp_cont_f, 1);
        this.jRc.setOnClickListener(groupInfoActivity);
        this.jRq.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jQw = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cqA = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cqA.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.ieu = groupInfoActivity.findViewById(R.id.group_top_view);
        this.ieu.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jQy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jQy.setOnClickListener(groupInfoActivity);
        this.jQz = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jQA = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jQR = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jQR.setOnClickListener(groupInfoActivity);
        this.jQZ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jRe = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jQB = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jQC = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jRk = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jQD = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jQD.setMaxLines(20);
        this.jQD.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void qj(boolean z) {
                if (z) {
                    a.this.jRn.setVisibility(0);
                } else {
                    a.this.jRn.setVisibility(8);
                }
            }
        });
        this.jQF = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jQE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jQF.setOnClickListener(groupInfoActivity);
        this.jQK = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jQK.setAutoChangeStyle(true);
        this.jQK.setIsRound(false);
        this.jPr = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jQH = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jQH.setOnClickListener(groupInfoActivity);
        this.jQO = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jRm = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jQJ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jQF.setOnClickListener(groupInfoActivity);
        this.jQI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jQI.setOnClickListener(groupInfoActivity);
        this.jQL = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jQM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jQM.setOnClickListener(groupInfoActivity);
        this.jQS = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jQU = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jRp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jQV = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jRp.setOnClickListener(this.jQv);
        this.jQW = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jQW.setOnClickListener(groupInfoActivity);
        this.jQX = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jRf = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jRf.setOnClickListener(groupInfoActivity);
        this.jRg = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jRh = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jRl = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jRi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jRi.setOnClickListener(groupInfoActivity);
        this.jRi.setLongClickable(true);
        this.jRi.setOnLongClickListener(groupInfoActivity);
        this.jRn = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jRn.setClickable(true);
        this.jRn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jQD.setMaxLines(1000);
            }
        });
        this.jRj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jRj.setOnLongClickListener(groupInfoActivity);
        this.jRo = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jQx = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jQG = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jQG.setPhotoClickListener(groupInfoActivity);
        this.jQG.setPhotoLongClickListener(groupInfoActivity);
        this.jQG.setVisibility(8);
    }

    public RelativeLayout cNz() {
        return this.jRj;
    }

    public RelativeLayout cNA() {
        return this.jQF;
    }

    public LinearLayout cNB() {
        return this.jQS;
    }

    public RelativeLayout cNC() {
        return this.jQW;
    }

    public RelativeLayout cND() {
        return this.jRi;
    }

    public RelativeLayout cNE() {
        return this.jRf;
    }

    public RelativeLayout cNF() {
        return this.jQy;
    }

    public View cNG() {
        return this.jRc;
    }

    public LinearLayout cNH() {
        return this.jRp;
    }

    public RelativeLayout cNI() {
        return this.jQH;
    }

    public RelativeLayout cNJ() {
        return this.jQI;
    }

    public RelativeLayout cNK() {
        return this.jQM;
    }

    public View cMt() {
        return this.jDe;
    }

    public void cNL() {
        this.jQx.setVisibility(8);
    }

    public void cNM() {
        this.jQx.setVisibility(0);
    }

    public void r(boolean z, String str) {
        if (z) {
            this.jQC.setText(str);
            this.jQR.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jQR.setVisibility(8);
        } else {
            this.jQC.setText(str);
            this.jQR.setVisibility(0);
        }
    }

    public void rz(boolean z) {
        if (z) {
            this.jQC.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jQR.setVisibility(8);
        }
    }

    public RelativeLayout cNN() {
        return this.jQR;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jRu = aVar.cOw();
            this.jRv = aVar.cOx();
            this.jRs = aVar;
            this.jRt = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cOr() != null) {
                jRw = aVar.cOr().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jQZ.setVisibility(0);
            this.jQU.setVisibility(0);
            if (aVar.getGroup() != null) {
                Me(aVar.getGroup().getName());
                this.jQB.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jQO.setVisibility(0);
                } else {
                    this.jQO.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jRe.setVisibility(0);
                    this.jQK.setVisibility(8);
                    this.jRl.setVisibility(8);
                    this.jRm.setVisibility(8);
                    this.jPr.setText(R.string.group_info_forum_author);
                    this.jQH.setEnabled(false);
                    this.jQO.setVisibility(8);
                } else {
                    this.jRe.setVisibility(8);
                    this.jQK.setVisibility(0);
                    this.jRl.setVisibility(0);
                    this.jRm.setVisibility(0);
                    this.jPr.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jQH.setEnabled(true);
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
                this.jRd = stringBuffer.toString();
                this.jQC.setText(this.jRd);
                this.jQD.setText(aVar.getGroup().getIntro());
                this.jQL.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jQK.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jQF.setVisibility(0);
                    this.jQE.setText(aVar.getGroup().getForumName() + this.jQv.getPageContext().getString(R.string.forum));
                } else {
                    this.jQF.setVisibility(8);
                }
                this.jQJ.removeAllViews();
                boolean cOy = aVar.cOy();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.jRr, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jQv.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jQJ.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jQv.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jQJ.addView(imageView2);
                }
                if (cOy) {
                    this.jRo.setVisibility(0);
                } else {
                    this.jRo.setVisibility(8);
                }
            }
            if (aVar.cOr() != null) {
                this.jQy.setVisibility(0);
                this.jQw.setVisibility(0);
                GroupActivityData cOr = aVar.cOr();
                if (!aVar.cOw()) {
                    if (cOr.getIsEnd() != 1) {
                        this.jQz.setVisibility(4);
                        this.jQA.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jQy.setVisibility(8);
                        this.jQw.setVisibility(8);
                    }
                } else {
                    this.jQz.setVisibility(0);
                    this.jQA.setText(cOr.getgActivityTitle());
                    if (cOr.getIsEnd() != 1) {
                        this.jQz.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.jQz, R.color.common_color_10171, 1);
                    } else {
                        this.jQz.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.jQz, R.color.common_color_10168, 1);
                    }
                    this.jQA.setText(cOr.getgActivityTitle());
                }
            } else if (aVar.cOx()) {
                this.jQy.setVisibility(0);
                this.jQw.setVisibility(0);
                this.jQz.setVisibility(4);
                this.jQA.setText(R.string.group_info_create_activity);
            } else {
                this.jQy.setVisibility(8);
                this.jQw.setVisibility(8);
            }
            this.jQS.removeAllViews();
            if (aVar.cOs() != null && aVar.cOs().size() > 0) {
                List<MemberData> cOs = aVar.cOs();
                int size = cOs.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cOs.get(i3);
                    HeadImageView headImageView = this.jQT[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jQv.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jQT[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jQS.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cOx()) {
                this.jQR.setEnabled(true);
                this.jRi.setEnabled(true);
                ap.setBackgroundResource(this.jRi, R.drawable.group_info_item);
                this.jRf.setVisibility(0);
                this.jRk.setVisibility(0);
                this.jRh.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jRg.setText(aVar.getGroup().getName());
                }
            } else {
                this.jQR.setEnabled(false);
                this.jRi.setEnabled(true);
                ap.setBackgroundColor(this.jRi, R.color.cp_bg_line_d);
                this.jRh.setVisibility(8);
                this.jRk.setVisibility(8);
                this.jQD.setPadding(0, 0, 0, 0);
            }
            if (aVar.cOw()) {
                this.jQX.setVisibility(0);
                this.jRq.setVisibility(0);
                if (this.jQM.getParent() != this.jQX) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jQZ.removeView(this.jQM);
                    this.jQX.addView(this.jQM, 1);
                }
                cNO();
            } else {
                this.jQX.setVisibility(8);
                this.jRq.setVisibility(8);
                if (this.jQM.getParent() != this.jQZ) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jQX.removeView(this.jQM);
                    this.jQZ.addView(this.jQM, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jQI.setVisibility(8);
            } else {
                this.jQI.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                rz(aVar.cOx());
            } else {
                r(aVar.cOx(), this.jRd);
            }
            this.cqA.setVisibility(0);
            this.jQU.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (Cy(aVar.getGroup().getFlag())) {
                rA(z);
            } else {
                cNP();
            }
        }
    }

    public void cNO() {
        this.jQV.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.jQV, R.color.cp_cont_a, 1);
        this.jQV.setText(this.jQv.getPageContext().getString(R.string.i_want_talk));
        this.jRp.setEnabled(true);
    }

    private void rA(boolean z) {
        this.jQV.setText(this.jQv.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jQV.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jQV, R.color.cp_cont_a, 1);
        } else {
            this.jQV.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jQV, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.jRp, R.drawable.btn_blue_bg);
        this.jRp.setEnabled(true);
    }

    private boolean Cy(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cNP() {
        this.jQV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jQV.setText(this.jQv.getPageContext().getString(R.string.group_info_refuse_join));
        this.jQV.setTextColor(this.jQv.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.jRp, R.drawable.btn_app_download_d);
        this.jRp.setEnabled(false);
    }

    public void Mg(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jQS.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jQS.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jQS.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jQG.setIsManager(aVar.cOx());
            if (aVar.cOx()) {
                this.jQG.setVisibility(0);
                if (aVar.cOt() != null && aVar.cOt().size() == 1 && TextUtils.isEmpty(aVar.cOt().get(0).getPicId())) {
                    this.jQG.setData(null);
                } else {
                    this.jQG.setData(aVar.cOt());
                }
            } else if (aVar.cOt() != null && aVar.cOt().size() > 0) {
                if (aVar.cOt().size() == 1 && TextUtils.isEmpty(aVar.cOt().get(0).getPicId())) {
                    this.jQG.setVisibility(8);
                    return;
                }
                this.jQG.setVisibility(0);
                this.jQG.setData(aVar.cOt());
            } else {
                this.jQG.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jRb = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jRa != null) {
            this.jRa.dismiss();
            this.jRa = null;
        }
        e(obj, i);
        this.jRa.Pd();
    }

    private void e(final Object obj, final int i) {
        if (this.jRa == null) {
            this.jRa = new i(this.jQv.getPageContext());
            this.jRa.a(null, new String[]{this.jQv.getResources().getString(R.string.group_info_set_portrait), this.jQv.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jRa != null && a.this.jRa.isShowing()) {
                        a.this.jRb.a(a.this.jRa, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jQG != null) {
            this.jQG.onDestory();
        }
        if (this.jQK != null) {
            this.jQK.stopLoad();
            this.jQK.setBackgroundDrawable(null);
            this.jQK.setImageDrawable(null);
        }
        if (this.jQS != null && this.jQT != null) {
            int length = this.jQT.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jQT[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Mh(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.jQv.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jQv.getPageContext().getPageActivity());
            bVar.AI(this.jQv.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0550b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jQv.getSystemService("clipboard")).setText(str);
                        a.this.jQv.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jQv.getPageContext());
            bVar.bkL();
        }
    }

    public void Mi(String str) {
        if (this.jQY == null) {
            Mj(str);
        }
        this.jQY.bkL();
    }

    private void Mj(final String str) {
        if (this.jQY == null) {
            this.jQY = new com.baidu.tbadk.core.dialog.b(this.jQv.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jQv.getPageContext().getString(R.string.copy_group_number)};
            this.jQY.AI(this.jQv.getPageContext().getString(R.string.operation));
            this.jQY.a(charSequenceArr, new b.InterfaceC0550b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0550b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jQv.getSystemService("clipboard")).setText(str);
                        a.this.jQv.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jQY.d(this.jQv.getPageContext());
        }
    }

    public void cNQ() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jQV.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jQV.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jQv.getLayoutMode().setNightMode(i == 1);
        this.jQv.getLayoutMode().onModeChanged(this.mContainer);
        this.jQv.getLayoutMode().onModeChanged(this.jQP);
        this.jQG.a(i, this.jQv);
        this.mNavigationBar.onChangeSkinType(this.jQv.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.jRr, R.color.common_color_10009, 1);
        }
        if (!this.jRu) {
            b(this.jRs, this.jRt);
        }
        if (this.jRv) {
            ap.setBackgroundResource(this.jRi, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.jRi, R.color.cp_bg_line_d);
        }
    }

    public void rB(boolean z) {
        this.jRu = z;
    }
}
