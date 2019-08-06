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
    private RelativeLayout cWk;
    private View fgA;
    private boolean flU;
    private TextView gJN;
    private final GroupInfoActivity gKQ;
    private View gKR;
    private ProgressBar gKS;
    private RelativeLayout gKT;
    private TextView gKU;
    private TextView gKV;
    private TextView gKW;
    private TextView gKX;
    private EllipsizingTextView gKY;
    private TextView gKZ;
    private RelativeLayout gLA;
    private TextView gLB;
    private ImageView gLC;
    private RelativeLayout gLD;
    private RelativeLayout gLE;
    private ImageView gLF;
    private ImageView gLG;
    private View gLH;
    private TextView gLI;
    private TextView gLJ;
    private LinearLayout gLK;
    private View gLL;
    private TextView gLM;
    private ResponseGroupInfoLocalMessage.a gLN;
    private boolean gLO;
    private boolean gLP;
    private RelativeLayout gLa;
    private PhotoWallView gLb;
    private RelativeLayout gLc;
    private RelativeLayout gLd;
    private LinearLayout gLe;
    private HeadImageView gLf;
    private TextView gLg;
    private RelativeLayout gLh;
    private com.baidu.tbadk.core.dialog.b gLi;
    private ImageView gLj;
    private final View gLk;
    private b.a gLl;
    private RelativeLayout gLm;
    private LinearLayout gLn;
    private HeadImageView[] gLo;
    private LinearLayout gLp;
    private TextView gLq;
    private RelativeLayout gLr;
    private LinearLayout gLs;
    private com.baidu.tbadk.core.dialog.b gLt;
    private LinearLayout gLu;
    private i gLv;
    private b gLw;
    private TextView gLx;
    private String gLy;
    private ImageView gLz;
    private View gzz;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gLQ = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gLi = null;
        this.gLl = null;
        this.gLo = new HeadImageView[5];
        this.gLy = "";
        this.gLO = true;
        this.isMemGroup = false;
        this.flU = false;
        this.gLP = false;
        this.gKQ = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gLk = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bcg.setVisibility(4);
        this.gLp.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gLB.setText(str);
        zi(str);
    }

    private void zi(String str) {
        if (str != null) {
            this.gLM.setText(str);
        }
    }

    public void zj(String str) {
        this.gKY.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gzz = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gLM = this.mNavigationBar.setTitleText("");
        this.gLL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gLx = (TextView) this.gLL.findViewById(R.id.right_textview);
        this.gLx.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.f(this.gLx, R.color.cp_cont_f, 1);
        this.gLx.setOnClickListener(groupInfoActivity);
        this.gLL.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gKR = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cWk = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
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
        this.fgA = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fgA.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gKT = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gKT.setOnClickListener(groupInfoActivity);
        this.gKU = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gKV = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gLm = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gLm.setOnClickListener(groupInfoActivity);
        this.gLu = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gLz = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gKW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gKX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gLF = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gKY = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gKY.setMaxLines(20);
        this.gKY.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void ld(boolean z) {
                if (z) {
                    a.this.gLI.setVisibility(0);
                } else {
                    a.this.gLI.setVisibility(8);
                }
            }
        });
        this.gLa = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gKZ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gLa.setOnClickListener(groupInfoActivity);
        this.gLf = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gLf.setAutoChangeStyle(true);
        this.gLf.setIsRound(false);
        this.gJN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gLc = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gLc.setOnClickListener(groupInfoActivity);
        this.gLj = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gLH = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gLe = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gLa.setOnClickListener(groupInfoActivity);
        this.gLd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gLd.setOnClickListener(groupInfoActivity);
        this.gLg = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gLh = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gLh.setOnClickListener(groupInfoActivity);
        this.gLn = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gLp = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gLK = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gLq = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gLK.setOnClickListener(this.gKQ);
        this.gLr = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gLr.setOnClickListener(groupInfoActivity);
        this.gLs = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gLA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gLA.setOnClickListener(groupInfoActivity);
        this.gLB = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gLC = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gLG = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gLD = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gLD.setOnClickListener(groupInfoActivity);
        this.gLD.setLongClickable(true);
        this.gLD.setOnLongClickListener(groupInfoActivity);
        this.gLI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gLI.setClickable(true);
        this.gLI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gKY.setMaxLines(1000);
            }
        });
        this.gLE = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gLE.setOnLongClickListener(groupInfoActivity);
        this.gLJ = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gKS = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gLb = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gLb.setPhotoClickListener(groupInfoActivity);
        this.gLb.setPhotoLongClickListener(groupInfoActivity);
        this.gLb.setVisibility(8);
    }

    public RelativeLayout bEJ() {
        return this.gLE;
    }

    public RelativeLayout bEK() {
        return this.gLa;
    }

    public LinearLayout bEL() {
        return this.gLn;
    }

    public RelativeLayout bEM() {
        return this.gLr;
    }

    public RelativeLayout bEN() {
        return this.gLD;
    }

    public RelativeLayout bEO() {
        return this.gLA;
    }

    public RelativeLayout bEP() {
        return this.gKT;
    }

    public View bEQ() {
        return this.gLx;
    }

    public LinearLayout bER() {
        return this.gLK;
    }

    public RelativeLayout bES() {
        return this.gLc;
    }

    public RelativeLayout bET() {
        return this.gLd;
    }

    public RelativeLayout bEU() {
        return this.gLh;
    }

    public View bDE() {
        return this.gzz;
    }

    public void bEV() {
        this.gKS.setVisibility(8);
    }

    public void bEW() {
        this.gKS.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gKX.setText(str);
            this.gLm.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gLm.setVisibility(8);
        } else {
            this.gKX.setText(str);
            this.gLm.setVisibility(0);
        }
    }

    public void mo(boolean z) {
        if (z) {
            this.gKX.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gLm.setVisibility(8);
        }
    }

    public RelativeLayout bEX() {
        return this.gLm;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.flU = aVar.bFH();
            this.gLP = aVar.bFI();
            this.gLN = aVar;
            this.gLO = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bFC() != null) {
                gLQ = aVar.bFC().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gLu.setVisibility(0);
            this.gLp.setVisibility(0);
            if (aVar.getGroup() != null) {
                zi(aVar.getGroup().getName());
                this.gKW.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gLj.setVisibility(0);
                } else {
                    this.gLj.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gLz.setVisibility(0);
                    this.gLf.setVisibility(8);
                    this.gLG.setVisibility(8);
                    this.gLH.setVisibility(8);
                    this.gJN.setText(R.string.group_info_forum_author);
                    this.gLc.setEnabled(false);
                    this.gLj.setVisibility(8);
                } else {
                    this.gLz.setVisibility(8);
                    this.gLf.setVisibility(0);
                    this.gLG.setVisibility(0);
                    this.gLH.setVisibility(0);
                    this.gJN.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gLc.setEnabled(true);
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
                this.gLy = stringBuffer.toString();
                this.gKX.setText(this.gLy);
                this.gKY.setText(aVar.getGroup().getIntro());
                this.gLg.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gLf.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gLa.setVisibility(0);
                    this.gKZ.setText(aVar.getGroup().getForumName() + this.gKQ.getPageContext().getString(R.string.forum));
                } else {
                    this.gLa.setVisibility(8);
                }
                this.gLe.removeAllViews();
                boolean bFJ = aVar.bFJ();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.f(this.gLM, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gKQ.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gLe.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gKQ.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gLe.addView(imageView2);
                }
                if (bFJ) {
                    this.gLJ.setVisibility(0);
                } else {
                    this.gLJ.setVisibility(8);
                }
            }
            if (aVar.bFC() != null) {
                this.gKT.setVisibility(0);
                this.gKR.setVisibility(0);
                GroupActivityData bFC = aVar.bFC();
                if (!aVar.bFH()) {
                    if (bFC.getIsEnd() != 1) {
                        this.gKU.setVisibility(4);
                        this.gKV.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gKT.setVisibility(8);
                        this.gKR.setVisibility(8);
                    }
                } else {
                    this.gKU.setVisibility(0);
                    this.gKV.setText(bFC.getgActivityTitle());
                    if (bFC.getIsEnd() != 1) {
                        this.gKU.setText(R.string.group_info_activity_doing);
                        am.f(this.gKU, R.color.common_color_10171, 1);
                    } else {
                        this.gKU.setText(R.string.group_activity_end);
                        am.f(this.gKU, R.color.common_color_10168, 1);
                    }
                    this.gKV.setText(bFC.getgActivityTitle());
                }
            } else if (aVar.bFI()) {
                this.gKT.setVisibility(0);
                this.gKR.setVisibility(0);
                this.gKU.setVisibility(4);
                this.gKV.setText(R.string.group_info_create_activity);
            } else {
                this.gKT.setVisibility(8);
                this.gKR.setVisibility(8);
            }
            this.gLn.removeAllViews();
            if (aVar.bFD() != null && aVar.bFD().size() > 0) {
                List<MemberData> bFD = aVar.bFD();
                int size = bFD.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bFD.get(i3);
                    HeadImageView headImageView = this.gLo[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gKQ.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gLo[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gLn.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bFI()) {
                this.gLm.setEnabled(true);
                this.gLD.setEnabled(true);
                am.k(this.gLD, R.drawable.group_info_item);
                this.gLA.setVisibility(0);
                this.gLF.setVisibility(0);
                this.gLC.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gLB.setText(aVar.getGroup().getName());
                }
            } else {
                this.gLm.setEnabled(false);
                this.gLD.setEnabled(true);
                am.l(this.gLD, R.color.cp_bg_line_d);
                this.gLC.setVisibility(8);
                this.gLF.setVisibility(8);
                this.gKY.setPadding(0, 0, 0, 0);
            }
            if (aVar.bFH()) {
                this.gLs.setVisibility(0);
                this.gLL.setVisibility(0);
                if (this.gLh.getParent() != this.gLs) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gLu.removeView(this.gLh);
                    this.gLs.addView(this.gLh, 1);
                }
                bEY();
            } else {
                this.gLs.setVisibility(8);
                this.gLL.setVisibility(8);
                if (this.gLh.getParent() != this.gLu) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gLs.removeView(this.gLh);
                    this.gLu.addView(this.gLh, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gLd.setVisibility(8);
            } else {
                this.gLd.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                mo(aVar.bFI());
            } else {
                m(aVar.bFI(), this.gLy);
            }
            this.bcg.setVisibility(0);
            this.gLp.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vG(aVar.getGroup().getFlag())) {
                mp(z);
            } else {
                bEZ();
            }
        }
    }

    public void bEY() {
        this.gLq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.f(this.gLq, R.color.cp_btn_a, 1);
        this.gLq.setText(this.gKQ.getPageContext().getString(R.string.i_want_talk));
        this.gLK.setEnabled(true);
    }

    private void mp(boolean z) {
        this.gLq.setText(this.gKQ.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gLq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gLq, R.color.cp_btn_a, 1);
        } else {
            this.gLq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.f(this.gLq, R.color.cp_btn_a, 1);
        }
        am.k(this.gLK, R.drawable.btn_blue_bg);
        this.gLK.setEnabled(true);
    }

    private boolean vG(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bEZ() {
        this.gLq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gLq.setText(this.gKQ.getPageContext().getString(R.string.group_info_refuse_join));
        this.gLq.setTextColor(this.gKQ.getResources().getColorStateList(R.color.cp_btn_a));
        am.k(this.gLK, R.drawable.btn_app_download_d);
        this.gLK.setEnabled(false);
    }

    public void zk(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gLn.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gLn.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gLn.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gLb.setIsManager(aVar.bFI());
            if (aVar.bFI()) {
                this.gLb.setVisibility(0);
                if (aVar.bFE() != null && aVar.bFE().size() == 1 && TextUtils.isEmpty(aVar.bFE().get(0).getPicId())) {
                    this.gLb.setData(null);
                } else {
                    this.gLb.setData(aVar.bFE());
                }
            } else if (aVar.bFE() != null && aVar.bFE().size() > 0) {
                if (aVar.bFE().size() == 1 && TextUtils.isEmpty(aVar.bFE().get(0).getPicId())) {
                    this.gLb.setVisibility(8);
                    return;
                }
                this.gLb.setVisibility(0);
                this.gLb.setData(aVar.bFE());
            } else {
                this.gLb.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gLw = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gLv != null) {
            this.gLv.dismiss();
            this.gLv = null;
        }
        e(obj, i);
        this.gLv.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gLv == null) {
            this.gLv = new i(this.gKQ.getPageContext());
            this.gLv.a(null, new String[]{this.gKQ.getResources().getString(R.string.group_info_set_portrait), this.gKQ.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gLv != null && a.this.gLv.isShowing()) {
                        a.this.gLw.a(a.this.gLv, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gLb != null) {
            this.gLb.onDestory();
        }
        if (this.gLf != null) {
            this.gLf.stopLoad();
            this.gLf.setBackgroundDrawable(null);
            this.gLf.setImageDrawable(null);
        }
        if (this.gLn != null && this.gLo != null) {
            int length = this.gLo.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gLo[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void zl(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gKQ.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gKQ.getPageContext().getPageActivity());
            bVar.mP(this.gKQ.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gKQ.getSystemService("clipboard")).setText(str);
                        a.this.gKQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gKQ.getPageContext());
            bVar.agN();
        }
    }

    public void zm(String str) {
        if (this.gLt == null) {
            zn(str);
        }
        this.gLt.agN();
    }

    private void zn(final String str) {
        if (this.gLt == null) {
            this.gLt = new com.baidu.tbadk.core.dialog.b(this.gKQ.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gKQ.getPageContext().getString(R.string.copy_group_number)};
            this.gLt.mP(this.gKQ.getPageContext().getString(R.string.operation));
            this.gLt.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gKQ.getSystemService("clipboard")).setText(str);
                        a.this.gKQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gLt.d(this.gKQ.getPageContext());
        }
    }

    public void bFa() {
        ColorStateList ii = am.ii(R.color.cp_btn_a);
        if (ii != null) {
            this.gLq.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gLq.setTextColor(ii);
    }

    public void changeSkinType(int i) {
        this.gKQ.getLayoutMode().setNightMode(i == 1);
        this.gKQ.getLayoutMode().onModeChanged(this.cWk);
        this.gKQ.getLayoutMode().onModeChanged(this.gLk);
        this.gLb.a(i, this.gKQ);
        this.mNavigationBar.onChangeSkinType(this.gKQ.getPageContext(), i);
        if (this.isMemGroup) {
            am.f(this.gLM, R.color.common_color_10009, 1);
        }
        if (!this.flU) {
            b(this.gLN, this.gLO);
        }
        if (this.gLP) {
            am.k(this.gLD, R.drawable.group_info_item);
        } else {
            am.l(this.gLD, R.color.cp_bg_line_d);
        }
    }

    public void mq(boolean z) {
        this.flU = z;
    }
}
