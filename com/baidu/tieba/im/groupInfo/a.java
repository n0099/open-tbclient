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
    private ScrollView bvD;
    private View flb;
    private TextView gJE;
    private final GroupInfoActivity gKI;
    private View gKJ;
    private ProgressBar gKK;
    private RelativeLayout gKL;
    private TextView gKM;
    private TextView gKN;
    private TextView gKO;
    private TextView gKP;
    private EllipsizingTextView gKQ;
    private TextView gKR;
    private RelativeLayout gKS;
    private PhotoWallView gKT;
    private RelativeLayout gKU;
    private RelativeLayout gKV;
    private LinearLayout gKW;
    private HeadImageView gKX;
    private TextView gKY;
    private RelativeLayout gKZ;
    private TextView gLA;
    private TextView gLB;
    private LinearLayout gLC;
    private View gLD;
    private TextView gLE;
    private ResponseGroupInfoLocalMessage.a gLF;
    private boolean gLG;
    private boolean gLH;
    private boolean gLI;
    private com.baidu.tbadk.core.dialog.b gLa;
    private ImageView gLb;
    private final View gLc;
    private b.a gLd;
    private RelativeLayout gLe;
    private LinearLayout gLf;
    private HeadImageView[] gLg;
    private LinearLayout gLh;
    private TextView gLi;
    private RelativeLayout gLj;
    private LinearLayout gLk;
    private com.baidu.tbadk.core.dialog.b gLl;
    private LinearLayout gLm;
    private i gLn;
    private b gLo;
    private TextView gLp;
    private String gLq;
    private ImageView gLr;
    private RelativeLayout gLs;
    private TextView gLt;
    private ImageView gLu;
    private RelativeLayout gLv;
    private RelativeLayout gLw;
    private ImageView gLx;
    private ImageView gLy;
    private View gLz;
    private View gzp;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gLJ = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gLa = null;
        this.gLd = null;
        this.gLg = new HeadImageView[5];
        this.gLq = "";
        this.gLG = true;
        this.isMemGroup = false;
        this.gLH = false;
        this.gLI = false;
        this.gKI = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gLc = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bvD.setVisibility(4);
        this.gLh.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gLt.setText(str);
        xZ(str);
    }

    private void xZ(String str) {
        if (str != null) {
            this.gLE.setText(str);
        }
    }

    public void ya(String str) {
        this.gKQ.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gzp = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gLE = this.mNavigationBar.setTitleText("");
        this.gLD = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gLp = (TextView) this.gLD.findViewById(R.id.right_textview);
        this.gLp.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.gLp, R.color.cp_cont_f, 1);
        this.gLp.setOnClickListener(groupInfoActivity);
        this.gLD.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gKJ = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bvD = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bvD.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.flb = groupInfoActivity.findViewById(R.id.group_top_view);
        this.flb.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gKL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gKL.setOnClickListener(groupInfoActivity);
        this.gKM = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gKN = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gLe = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gLe.setOnClickListener(groupInfoActivity);
        this.gLm = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gLr = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gKO = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gKP = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gLx = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gKQ = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gKQ.setMaxLines(20);
        this.gKQ.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kU(boolean z) {
                if (z) {
                    a.this.gLA.setVisibility(0);
                } else {
                    a.this.gLA.setVisibility(8);
                }
            }
        });
        this.gKS = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gKR = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gKS.setOnClickListener(groupInfoActivity);
        this.gKX = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gKX.setAutoChangeStyle(true);
        this.gKX.setIsRound(false);
        this.gJE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gKU = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gKU.setOnClickListener(groupInfoActivity);
        this.gLb = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gLz = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gKW = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gKS.setOnClickListener(groupInfoActivity);
        this.gKV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gKV.setOnClickListener(groupInfoActivity);
        this.gKY = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gKZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gKZ.setOnClickListener(groupInfoActivity);
        this.gLf = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gLh = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gLC = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gLi = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gLC.setOnClickListener(this.gKI);
        this.gLj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gLj.setOnClickListener(groupInfoActivity);
        this.gLk = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gLs = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gLs.setOnClickListener(groupInfoActivity);
        this.gLt = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gLu = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gLy = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gLv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gLv.setOnClickListener(groupInfoActivity);
        this.gLv.setLongClickable(true);
        this.gLv.setOnLongClickListener(groupInfoActivity);
        this.gLA = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gLA.setClickable(true);
        this.gLA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gKQ.setMaxLines(1000);
            }
        });
        this.gLw = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gLw.setOnLongClickListener(groupInfoActivity);
        this.gLB = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gKK = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gKT = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gKT.setPhotoClickListener(groupInfoActivity);
        this.gKT.setPhotoLongClickListener(groupInfoActivity);
        this.gKT.setVisibility(8);
    }

    public RelativeLayout bCi() {
        return this.gLw;
    }

    public RelativeLayout bCj() {
        return this.gKS;
    }

    public LinearLayout bCk() {
        return this.gLf;
    }

    public RelativeLayout bCl() {
        return this.gLj;
    }

    public RelativeLayout bCm() {
        return this.gLv;
    }

    public RelativeLayout bCn() {
        return this.gLs;
    }

    public RelativeLayout bCo() {
        return this.gKL;
    }

    public View bCp() {
        return this.gLp;
    }

    public LinearLayout bCq() {
        return this.gLC;
    }

    public RelativeLayout bCr() {
        return this.gKU;
    }

    public RelativeLayout bCs() {
        return this.gKV;
    }

    public RelativeLayout bCt() {
        return this.gKZ;
    }

    public View bBd() {
        return this.gzp;
    }

    public void bCu() {
        this.gKK.setVisibility(8);
    }

    public void bCv() {
        this.gKK.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.gKP.setText(str);
            this.gLe.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gLe.setVisibility(8);
        } else {
            this.gKP.setText(str);
            this.gLe.setVisibility(0);
        }
    }

    public void mf(boolean z) {
        if (z) {
            this.gKP.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gLe.setVisibility(8);
        }
    }

    public RelativeLayout bCw() {
        return this.gLe;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.gLH = aVar.bDg();
            this.gLI = aVar.bDh();
            this.gLF = aVar;
            this.gLG = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bDb() != null) {
                gLJ = aVar.bDb().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gLm.setVisibility(0);
            this.gLh.setVisibility(0);
            if (aVar.getGroup() != null) {
                xZ(aVar.getGroup().getName());
                this.gKO.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gLb.setVisibility(0);
                } else {
                    this.gLb.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gLr.setVisibility(0);
                    this.gKX.setVisibility(8);
                    this.gLy.setVisibility(8);
                    this.gLz.setVisibility(8);
                    this.gJE.setText(R.string.group_info_forum_author);
                    this.gKU.setEnabled(false);
                    this.gLb.setVisibility(8);
                } else {
                    this.gLr.setVisibility(8);
                    this.gKX.setVisibility(0);
                    this.gLy.setVisibility(0);
                    this.gLz.setVisibility(0);
                    this.gJE.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gKU.setEnabled(true);
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
                this.gLq = stringBuffer.toString();
                this.gKP.setText(this.gLq);
                this.gKQ.setText(aVar.getGroup().getIntro());
                this.gKY.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gKX.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gKS.setVisibility(0);
                    this.gKR.setText(aVar.getGroup().getForumName() + this.gKI.getPageContext().getString(R.string.forum));
                } else {
                    this.gKS.setVisibility(8);
                }
                this.gKW.removeAllViews();
                boolean bDi = aVar.bDi();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.gLE, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gKI.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.gKW.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gKI.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.gKW.addView(imageView2);
                }
                if (bDi) {
                    this.gLB.setVisibility(0);
                } else {
                    this.gLB.setVisibility(8);
                }
            }
            if (aVar.bDb() != null) {
                this.gKL.setVisibility(0);
                this.gKJ.setVisibility(0);
                GroupActivityData bDb = aVar.bDb();
                if (!aVar.bDg()) {
                    if (bDb.getIsEnd() != 1) {
                        this.gKM.setVisibility(4);
                        this.gKN.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gKL.setVisibility(8);
                        this.gKJ.setVisibility(8);
                    }
                } else {
                    this.gKM.setVisibility(0);
                    this.gKN.setText(bDb.getgActivityTitle());
                    if (bDb.getIsEnd() != 1) {
                        this.gKM.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.gKM, R.color.common_color_10171, 1);
                    } else {
                        this.gKM.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.gKM, R.color.common_color_10168, 1);
                    }
                    this.gKN.setText(bDb.getgActivityTitle());
                }
            } else if (aVar.bDh()) {
                this.gKL.setVisibility(0);
                this.gKJ.setVisibility(0);
                this.gKM.setVisibility(4);
                this.gKN.setText(R.string.group_info_create_activity);
            } else {
                this.gKL.setVisibility(8);
                this.gKJ.setVisibility(8);
            }
            this.gLf.removeAllViews();
            if (aVar.bDc() != null && aVar.bDc().size() > 0) {
                List<MemberData> bDc = aVar.bDc();
                int size = bDc.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bDc.get(i3);
                    HeadImageView headImageView = this.gLg[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gKI.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gLg[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gLf.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bDh()) {
                this.gLe.setEnabled(true);
                this.gLv.setEnabled(true);
                am.setBackgroundResource(this.gLv, R.drawable.group_info_item);
                this.gLs.setVisibility(0);
                this.gLx.setVisibility(0);
                this.gLu.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gLt.setText(aVar.getGroup().getName());
                }
            } else {
                this.gLe.setEnabled(false);
                this.gLv.setEnabled(true);
                am.setBackgroundColor(this.gLv, R.color.cp_bg_line_d);
                this.gLu.setVisibility(8);
                this.gLx.setVisibility(8);
                this.gKQ.setPadding(0, 0, 0, 0);
            }
            if (aVar.bDg()) {
                this.gLk.setVisibility(0);
                this.gLD.setVisibility(0);
                if (this.gKZ.getParent() != this.gLk) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gLm.removeView(this.gKZ);
                    this.gLk.addView(this.gKZ, 1);
                }
                bCx();
            } else {
                this.gLk.setVisibility(8);
                this.gLD.setVisibility(8);
                if (this.gKZ.getParent() != this.gLm) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gLk.removeView(this.gKZ);
                    this.gLm.addView(this.gKZ, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gKV.setVisibility(8);
            } else {
                this.gKV.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                mf(aVar.bDh());
            } else {
                m(aVar.bDh(), this.gLq);
            }
            this.bvD.setVisibility(0);
            this.gLh.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (uq(aVar.getGroup().getFlag())) {
                mg(z);
            } else {
                bCy();
            }
        }
    }

    public void bCx() {
        this.gLi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.gLi, R.color.cp_cont_a, 1);
        this.gLi.setText(this.gKI.getPageContext().getString(R.string.i_want_talk));
        this.gLC.setEnabled(true);
    }

    private void mg(boolean z) {
        this.gLi.setText(this.gKI.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gLi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.gLi, R.color.cp_cont_a, 1);
        } else {
            this.gLi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.gLi, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.gLC, R.drawable.btn_blue_bg);
        this.gLC.setEnabled(true);
    }

    private boolean uq(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bCy() {
        this.gLi.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gLi.setText(this.gKI.getPageContext().getString(R.string.group_info_refuse_join));
        this.gLi.setTextColor(this.gKI.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.gLC, R.drawable.btn_app_download_d);
        this.gLC.setEnabled(false);
    }

    public void yb(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gLf.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gLf.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gLf.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gKT.setIsManager(aVar.bDh());
            if (aVar.bDh()) {
                this.gKT.setVisibility(0);
                if (aVar.bDd() != null && aVar.bDd().size() == 1 && TextUtils.isEmpty(aVar.bDd().get(0).getPicId())) {
                    this.gKT.setData(null);
                } else {
                    this.gKT.setData(aVar.bDd());
                }
            } else if (aVar.bDd() != null && aVar.bDd().size() > 0) {
                if (aVar.bDd().size() == 1 && TextUtils.isEmpty(aVar.bDd().get(0).getPicId())) {
                    this.gKT.setVisibility(8);
                    return;
                }
                this.gKT.setVisibility(0);
                this.gKT.setData(aVar.bDd());
            } else {
                this.gKT.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gLo = bVar;
    }

    public void c(Object obj, int i) {
        if (this.gLn != null) {
            this.gLn.dismiss();
            this.gLn = null;
        }
        d(obj, i);
        this.gLn.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.gLn == null) {
            this.gLn = new i(this.gKI.getPageContext());
            this.gLn.a(null, new String[]{this.gKI.getResources().getString(R.string.group_info_set_portrait), this.gKI.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gLn != null && a.this.gLn.isShowing()) {
                        a.this.gLo.a(a.this.gLn, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gKT != null) {
            this.gKT.onDestory();
        }
        if (this.gKX != null) {
            this.gKX.stopLoad();
            this.gKX.setBackgroundDrawable(null);
            this.gKX.setImageDrawable(null);
        }
        if (this.gLf != null && this.gLg != null) {
            int length = this.gLg.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gLg[i];
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
            CharSequence[] charSequenceArr = {this.gKI.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gKI.getPageContext().getPageActivity());
            bVar.no(this.gKI.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gKI.getSystemService("clipboard")).setText(str);
                        a.this.gKI.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gKI.getPageContext());
            bVar.akP();
        }
    }

    public void yd(String str) {
        if (this.gLl == null) {
            ye(str);
        }
        this.gLl.akP();
    }

    private void ye(final String str) {
        if (this.gLl == null) {
            this.gLl = new com.baidu.tbadk.core.dialog.b(this.gKI.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gKI.getPageContext().getString(R.string.copy_group_number)};
            this.gLl.no(this.gKI.getPageContext().getString(R.string.operation));
            this.gLl.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gKI.getSystemService("clipboard")).setText(str);
                        a.this.gKI.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gLl.d(this.gKI.getPageContext());
        }
    }

    public void bCz() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.gLi.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gLi.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.gKI.getLayoutMode().setNightMode(i == 1);
        this.gKI.getLayoutMode().onModeChanged(this.mContainer);
        this.gKI.getLayoutMode().onModeChanged(this.gLc);
        this.gKT.a(i, this.gKI);
        this.mNavigationBar.onChangeSkinType(this.gKI.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.gLE, R.color.common_color_10009, 1);
        }
        if (!this.gLH) {
            b(this.gLF, this.gLG);
        }
        if (this.gLI) {
            am.setBackgroundResource(this.gLv, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.gLv, R.color.cp_bg_line_d);
        }
    }

    public void mh(boolean z) {
        this.gLH = z;
    }
}
