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
/* loaded from: classes8.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int hCz = 0;
    private ScrollView bfi;
    private View gbS;
    private TextView hAu;
    private ProgressBar hBA;
    private RelativeLayout hBB;
    private TextView hBC;
    private TextView hBD;
    private TextView hBE;
    private TextView hBF;
    private EllipsizingTextView hBG;
    private TextView hBH;
    private RelativeLayout hBI;
    private PhotoWallView hBJ;
    private RelativeLayout hBK;
    private RelativeLayout hBL;
    private LinearLayout hBM;
    private HeadImageView hBN;
    private TextView hBO;
    private RelativeLayout hBP;
    private com.baidu.tbadk.core.dialog.b hBQ;
    private ImageView hBR;
    private final View hBS;
    private b.a hBT;
    private RelativeLayout hBU;
    private LinearLayout hBV;
    private HeadImageView[] hBW;
    private LinearLayout hBX;
    private TextView hBY;
    private RelativeLayout hBZ;
    private final GroupInfoActivity hBy;
    private View hBz;
    private LinearLayout hCa;
    private com.baidu.tbadk.core.dialog.b hCb;
    private LinearLayout hCc;
    private i hCd;
    private b hCe;
    private TextView hCf;
    private String hCg;
    private ImageView hCh;
    private RelativeLayout hCi;
    private TextView hCj;
    private ImageView hCk;
    private RelativeLayout hCl;
    private RelativeLayout hCm;
    private ImageView hCn;
    private ImageView hCo;
    private View hCp;
    private TextView hCq;
    private TextView hCr;
    private LinearLayout hCs;
    private View hCt;
    private TextView hCu;
    private ResponseGroupInfoLocalMessage.a hCv;
    private boolean hCw;
    private boolean hCx;
    private boolean hCy;
    private View hqj;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.hBQ = null;
        this.hBT = null;
        this.hBW = new HeadImageView[5];
        this.hCg = "";
        this.hCw = true;
        this.isMemGroup = false;
        this.hCx = false;
        this.hCy = false;
        this.hBy = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.hBS = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bfi.setVisibility(4);
        this.hBX.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.hCj.setText(str);
        CS(str);
    }

    private void CS(String str) {
        if (str != null) {
            this.hCu.setText(str);
        }
    }

    public void CT(String str) {
        this.hBG.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.hqj = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hCu = this.mNavigationBar.setTitleText("");
        this.hCt = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.hCf = (TextView) this.hCt.findViewById(R.id.right_textview);
        this.hCf.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        am.setViewTextColor(this.hCf, R.color.cp_cont_f, 1);
        this.hCf.setOnClickListener(groupInfoActivity);
        this.hCt.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.hBz = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bfi = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bfi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.gbS = groupInfoActivity.findViewById(R.id.group_top_view);
        this.gbS.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.hBB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.hBB.setOnClickListener(groupInfoActivity);
        this.hBC = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.hBD = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.hBU = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.hBU.setOnClickListener(groupInfoActivity);
        this.hCc = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.hCh = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.hBE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.hBF = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.hCn = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.hBG = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.hBG.setMaxLines(20);
        this.hBG.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void mt(boolean z) {
                if (z) {
                    a.this.hCq.setVisibility(0);
                } else {
                    a.this.hCq.setVisibility(8);
                }
            }
        });
        this.hBI = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.hBH = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.hBI.setOnClickListener(groupInfoActivity);
        this.hBN = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.hBN.setAutoChangeStyle(true);
        this.hBN.setIsRound(false);
        this.hAu = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.hBK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.hBK.setOnClickListener(groupInfoActivity);
        this.hBR = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.hCp = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.hBM = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.hBI.setOnClickListener(groupInfoActivity);
        this.hBL = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.hBL.setOnClickListener(groupInfoActivity);
        this.hBO = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.hBP = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.hBP.setOnClickListener(groupInfoActivity);
        this.hBV = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.hBX = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.hCs = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.hBY = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.hCs.setOnClickListener(this.hBy);
        this.hBZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.hBZ.setOnClickListener(groupInfoActivity);
        this.hCa = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.hCi = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.hCi.setOnClickListener(groupInfoActivity);
        this.hCj = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.hCk = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.hCo = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.hCl = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.hCl.setOnClickListener(groupInfoActivity);
        this.hCl.setLongClickable(true);
        this.hCl.setOnLongClickListener(groupInfoActivity);
        this.hCq = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.hCq.setClickable(true);
        this.hCq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.hBG.setMaxLines(1000);
            }
        });
        this.hCm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.hCm.setOnLongClickListener(groupInfoActivity);
        this.hCr = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.hBA = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.hBJ = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.hBJ.setPhotoClickListener(groupInfoActivity);
        this.hBJ.setPhotoLongClickListener(groupInfoActivity);
        this.hBJ.setVisibility(8);
    }

    public RelativeLayout bUC() {
        return this.hCm;
    }

    public RelativeLayout bUD() {
        return this.hBI;
    }

    public LinearLayout bUE() {
        return this.hBV;
    }

    public RelativeLayout bUF() {
        return this.hBZ;
    }

    public RelativeLayout bUG() {
        return this.hCl;
    }

    public RelativeLayout bUH() {
        return this.hCi;
    }

    public RelativeLayout bUI() {
        return this.hBB;
    }

    public View bUJ() {
        return this.hCf;
    }

    public LinearLayout bUK() {
        return this.hCs;
    }

    public RelativeLayout bUL() {
        return this.hBK;
    }

    public RelativeLayout bUM() {
        return this.hBL;
    }

    public RelativeLayout bUN() {
        return this.hBP;
    }

    public View bTw() {
        return this.hqj;
    }

    public void bUO() {
        this.hBA.setVisibility(8);
    }

    public void bUP() {
        this.hBA.setVisibility(0);
    }

    public void m(boolean z, String str) {
        if (z) {
            this.hBF.setText(str);
            this.hBU.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.hBU.setVisibility(8);
        } else {
            this.hBF.setText(str);
            this.hBU.setVisibility(0);
        }
    }

    public void nE(boolean z) {
        if (z) {
            this.hBF.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.hBU.setVisibility(8);
        }
    }

    public RelativeLayout bUQ() {
        return this.hBU;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.hCx = aVar.bVz();
            this.hCy = aVar.bVA();
            this.hCv = aVar;
            this.hCw = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bVu() != null) {
                hCz = aVar.bVu().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.hCc.setVisibility(0);
            this.hBX.setVisibility(0);
            if (aVar.getGroup() != null) {
                CS(aVar.getGroup().getName());
                this.hBE.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.hBR.setVisibility(0);
                } else {
                    this.hBR.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.hCh.setVisibility(0);
                    this.hBN.setVisibility(8);
                    this.hCo.setVisibility(8);
                    this.hCp.setVisibility(8);
                    this.hAu.setText(R.string.group_info_forum_author);
                    this.hBK.setEnabled(false);
                    this.hBR.setVisibility(8);
                } else {
                    this.hCh.setVisibility(8);
                    this.hBN.setVisibility(0);
                    this.hCo.setVisibility(0);
                    this.hCp.setVisibility(0);
                    this.hAu.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.hBK.setEnabled(true);
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
                this.hCg = stringBuffer.toString();
                this.hBF.setText(this.hCg);
                this.hBG.setText(aVar.getGroup().getIntro());
                this.hBO.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.hBN.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.hBI.setVisibility(0);
                    this.hBH.setText(aVar.getGroup().getForumName() + this.hBy.getPageContext().getString(R.string.forum));
                } else {
                    this.hBI.setVisibility(8);
                }
                this.hBM.removeAllViews();
                boolean bVB = aVar.bVB();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    am.setViewTextColor(this.hCu, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.hBy.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            am.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            am.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.hBM.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.hBy.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        am.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        am.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.hBM.addView(imageView2);
                }
                if (bVB) {
                    this.hCr.setVisibility(0);
                } else {
                    this.hCr.setVisibility(8);
                }
            }
            if (aVar.bVu() != null) {
                this.hBB.setVisibility(0);
                this.hBz.setVisibility(0);
                GroupActivityData bVu = aVar.bVu();
                if (!aVar.bVz()) {
                    if (bVu.getIsEnd() != 1) {
                        this.hBC.setVisibility(4);
                        this.hBD.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.hBB.setVisibility(8);
                        this.hBz.setVisibility(8);
                    }
                } else {
                    this.hBC.setVisibility(0);
                    this.hBD.setText(bVu.getgActivityTitle());
                    if (bVu.getIsEnd() != 1) {
                        this.hBC.setText(R.string.group_info_activity_doing);
                        am.setViewTextColor(this.hBC, R.color.common_color_10171, 1);
                    } else {
                        this.hBC.setText(R.string.group_activity_end);
                        am.setViewTextColor(this.hBC, R.color.common_color_10168, 1);
                    }
                    this.hBD.setText(bVu.getgActivityTitle());
                }
            } else if (aVar.bVA()) {
                this.hBB.setVisibility(0);
                this.hBz.setVisibility(0);
                this.hBC.setVisibility(4);
                this.hBD.setText(R.string.group_info_create_activity);
            } else {
                this.hBB.setVisibility(8);
                this.hBz.setVisibility(8);
            }
            this.hBV.removeAllViews();
            if (aVar.bVv() != null && aVar.bVv().size() > 0) {
                List<MemberData> bVv = aVar.bVv();
                int size = bVv.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bVv.get(i3);
                    HeadImageView headImageView = this.hBW[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.hBy.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.hBW[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.hBV.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bVA()) {
                this.hBU.setEnabled(true);
                this.hCl.setEnabled(true);
                am.setBackgroundResource(this.hCl, R.drawable.group_info_item);
                this.hCi.setVisibility(0);
                this.hCn.setVisibility(0);
                this.hCk.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.hCj.setText(aVar.getGroup().getName());
                }
            } else {
                this.hBU.setEnabled(false);
                this.hCl.setEnabled(true);
                am.setBackgroundColor(this.hCl, R.color.cp_bg_line_d);
                this.hCk.setVisibility(8);
                this.hCn.setVisibility(8);
                this.hBG.setPadding(0, 0, 0, 0);
            }
            if (aVar.bVz()) {
                this.hCa.setVisibility(0);
                this.hCt.setVisibility(0);
                if (this.hBP.getParent() != this.hCa) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.hCc.removeView(this.hBP);
                    this.hCa.addView(this.hBP, 1);
                }
                bUR();
            } else {
                this.hCa.setVisibility(8);
                this.hCt.setVisibility(8);
                if (this.hBP.getParent() != this.hCc) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.hCa.removeView(this.hBP);
                    this.hCc.addView(this.hBP, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.hBL.setVisibility(8);
            } else {
                this.hBL.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                nE(aVar.bVA());
            } else {
                m(aVar.bVA(), this.hCg);
            }
            this.bfi.setVisibility(0);
            this.hBX.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (ww(aVar.getGroup().getFlag())) {
                nF(z);
            } else {
                bUS();
            }
        }
    }

    public void bUR() {
        this.hBY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        am.setViewTextColor(this.hBY, R.color.cp_cont_a, 1);
        this.hBY.setText(this.hBy.getPageContext().getString(R.string.i_want_talk));
        this.hCs.setEnabled(true);
    }

    private void nF(boolean z) {
        this.hBY.setText(this.hBy.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.hBY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hBY, R.color.cp_cont_a, 1);
        } else {
            this.hBY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            am.setViewTextColor(this.hBY, R.color.cp_cont_a, 1);
        }
        am.setBackgroundResource(this.hCs, R.drawable.btn_blue_bg);
        this.hCs.setEnabled(true);
    }

    private boolean ww(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bUS() {
        this.hBY.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.hBY.setText(this.hBy.getPageContext().getString(R.string.group_info_refuse_join));
        this.hBY.setTextColor(this.hBy.getResources().getColorStateList(R.color.cp_cont_a));
        am.setBackgroundResource(this.hCs, R.drawable.btn_app_download_d);
        this.hCs.setEnabled(false);
    }

    public void CU(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.hBV.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.hBV.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.hBV.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.hBJ.setIsManager(aVar.bVA());
            if (aVar.bVA()) {
                this.hBJ.setVisibility(0);
                if (aVar.bVw() != null && aVar.bVw().size() == 1 && TextUtils.isEmpty(aVar.bVw().get(0).getPicId())) {
                    this.hBJ.setData(null);
                } else {
                    this.hBJ.setData(aVar.bVw());
                }
            } else if (aVar.bVw() != null && aVar.bVw().size() > 0) {
                if (aVar.bVw().size() == 1 && TextUtils.isEmpty(aVar.bVw().get(0).getPicId())) {
                    this.hBJ.setVisibility(8);
                    return;
                }
                this.hBJ.setVisibility(0);
                this.hBJ.setData(aVar.bVw());
            } else {
                this.hBJ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.hCe = bVar;
    }

    public void c(Object obj, int i) {
        if (this.hCd != null) {
            this.hCd.dismiss();
            this.hCd = null;
        }
        d(obj, i);
        this.hCd.showDialog();
    }

    private void d(final Object obj, final int i) {
        if (this.hCd == null) {
            this.hCd = new i(this.hBy.getPageContext());
            this.hCd.a(null, new String[]{this.hBy.getResources().getString(R.string.group_info_set_portrait), this.hBy.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.hCd != null && a.this.hCd.isShowing()) {
                        a.this.hCe.a(a.this.hCd, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.hBJ != null) {
            this.hBJ.onDestory();
        }
        if (this.hBN != null) {
            this.hBN.stopLoad();
            this.hBN.setBackgroundDrawable(null);
            this.hBN.setImageDrawable(null);
        }
        if (this.hBV != null && this.hBW != null) {
            int length = this.hBW.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.hBW[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void CV(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.hBy.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.hBy.getPageContext().getPageActivity());
            bVar.sD(this.hBy.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.hBy.getSystemService("clipboard")).setText(str);
                        a.this.hBy.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.hBy.getPageContext());
            bVar.aCq();
        }
    }

    public void CW(String str) {
        if (this.hCb == null) {
            CX(str);
        }
        this.hCb.aCq();
    }

    private void CX(final String str) {
        if (this.hCb == null) {
            this.hCb = new com.baidu.tbadk.core.dialog.b(this.hBy.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.hBy.getPageContext().getString(R.string.copy_group_number)};
            this.hCb.sD(this.hBy.getPageContext().getString(R.string.operation));
            this.hCb.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.hBy.getSystemService("clipboard")).setText(str);
                        a.this.hBy.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.hCb.d(this.hBy.getPageContext());
        }
    }

    public void bUT() {
        ColorStateList colorList = am.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.hBY.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.hBY.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.hBy.getLayoutMode().setNightMode(i == 1);
        this.hBy.getLayoutMode().onModeChanged(this.mContainer);
        this.hBy.getLayoutMode().onModeChanged(this.hBS);
        this.hBJ.a(i, this.hBy);
        this.mNavigationBar.onChangeSkinType(this.hBy.getPageContext(), i);
        if (this.isMemGroup) {
            am.setViewTextColor(this.hCu, R.color.common_color_10009, 1);
        }
        if (!this.hCx) {
            b(this.hCv, this.hCw);
        }
        if (this.hCy) {
            am.setBackgroundResource(this.hCl, R.drawable.group_info_item);
        } else {
            am.setBackgroundColor(this.hCl, R.color.cp_bg_line_d);
        }
    }

    public void nG(boolean z) {
        this.hCx = z;
    }
}
