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
import com.baidu.tbadk.core.util.al;
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
    private ScrollView bbv;
    private RelativeLayout cUF;
    private View faZ;
    private boolean fgs;
    private TextView gCI;
    private final GroupInfoActivity gDL;
    private View gDM;
    private ProgressBar gDN;
    private RelativeLayout gDO;
    private TextView gDP;
    private TextView gDQ;
    private TextView gDR;
    private TextView gDS;
    private EllipsizingTextView gDT;
    private TextView gDU;
    private RelativeLayout gDV;
    private PhotoWallView gDW;
    private RelativeLayout gDX;
    private RelativeLayout gDY;
    private LinearLayout gDZ;
    private ImageView gEA;
    private ImageView gEB;
    private View gEC;
    private TextView gED;
    private TextView gEE;
    private LinearLayout gEF;
    private View gEG;
    private TextView gEH;
    private ResponseGroupInfoLocalMessage.a gEI;
    private boolean gEJ;
    private boolean gEK;
    private HeadImageView gEa;
    private TextView gEb;
    private RelativeLayout gEc;
    private com.baidu.tbadk.core.dialog.b gEd;
    private ImageView gEe;
    private final View gEf;
    private b.a gEg;
    private RelativeLayout gEh;
    private LinearLayout gEi;
    private HeadImageView[] gEj;
    private LinearLayout gEk;
    private TextView gEl;
    private RelativeLayout gEm;
    private LinearLayout gEn;
    private com.baidu.tbadk.core.dialog.b gEo;
    private LinearLayout gEp;
    private i gEq;
    private b gEr;
    private TextView gEs;
    private String gEt;
    private ImageView gEu;
    private RelativeLayout gEv;
    private TextView gEw;
    private ImageView gEx;
    private RelativeLayout gEy;
    private RelativeLayout gEz;
    private View gst;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gEL = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gEd = null;
        this.gEg = null;
        this.gEj = new HeadImageView[5];
        this.gEt = "";
        this.gEJ = true;
        this.isMemGroup = false;
        this.fgs = false;
        this.gEK = false;
        this.gDL = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gEf = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bbv.setVisibility(4);
        this.gEk.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gEw.setText(str);
        yu(str);
    }

    private void yu(String str) {
        if (str != null) {
            this.gEH.setText(str);
        }
    }

    public void yv(String str) {
        this.gDT.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gst = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gEH = this.mNavigationBar.setTitleText("");
        this.gEG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gEs = (TextView) this.gEG.findViewById(R.id.right_textview);
        this.gEs.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        al.f(this.gEs, R.color.cp_cont_f, 1);
        this.gEs.setOnClickListener(groupInfoActivity);
        this.gEG.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gDM = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cUF = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bbv = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bbv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.faZ = groupInfoActivity.findViewById(R.id.group_top_view);
        this.faZ.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gDO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gDO.setOnClickListener(groupInfoActivity);
        this.gDP = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gDQ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gEh = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gEh.setOnClickListener(groupInfoActivity);
        this.gEp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gEu = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gDR = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gDS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gEA = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gDT = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gDT.setMaxLines(20);
        this.gDT.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kS(boolean z) {
                if (z) {
                    a.this.gED.setVisibility(0);
                } else {
                    a.this.gED.setVisibility(8);
                }
            }
        });
        this.gDV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gDU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gDV.setOnClickListener(groupInfoActivity);
        this.gEa = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gEa.setAutoChangeStyle(true);
        this.gEa.setIsRound(false);
        this.gCI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gDX = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gDX.setOnClickListener(groupInfoActivity);
        this.gEe = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gEC = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gDZ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gDV.setOnClickListener(groupInfoActivity);
        this.gDY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gDY.setOnClickListener(groupInfoActivity);
        this.gEb = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gEc = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gEc.setOnClickListener(groupInfoActivity);
        this.gEi = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gEk = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gEF = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gEl = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gEF.setOnClickListener(this.gDL);
        this.gEm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gEm.setOnClickListener(groupInfoActivity);
        this.gEn = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gEv = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gEv.setOnClickListener(groupInfoActivity);
        this.gEw = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gEx = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gEB = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gEy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gEy.setOnClickListener(groupInfoActivity);
        this.gEy.setLongClickable(true);
        this.gEy.setOnLongClickListener(groupInfoActivity);
        this.gED = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gED.setClickable(true);
        this.gED.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gDT.setMaxLines(1000);
            }
        });
        this.gEz = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gEz.setOnLongClickListener(groupInfoActivity);
        this.gEE = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gDN = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gDW = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gDW.setPhotoClickListener(groupInfoActivity);
        this.gDW.setPhotoLongClickListener(groupInfoActivity);
        this.gDW.setVisibility(8);
    }

    public RelativeLayout bBK() {
        return this.gEz;
    }

    public RelativeLayout bBL() {
        return this.gDV;
    }

    public LinearLayout bBM() {
        return this.gEi;
    }

    public RelativeLayout bBN() {
        return this.gEm;
    }

    public RelativeLayout bBO() {
        return this.gEy;
    }

    public RelativeLayout bBP() {
        return this.gEv;
    }

    public RelativeLayout bBQ() {
        return this.gDO;
    }

    public View bBR() {
        return this.gEs;
    }

    public LinearLayout bBS() {
        return this.gEF;
    }

    public RelativeLayout bBT() {
        return this.gDX;
    }

    public RelativeLayout bBU() {
        return this.gDY;
    }

    public RelativeLayout bBV() {
        return this.gEc;
    }

    public View bAF() {
        return this.gst;
    }

    public void bBW() {
        this.gDN.setVisibility(8);
    }

    public void bBX() {
        this.gDN.setVisibility(0);
    }

    public void l(boolean z, String str) {
        if (z) {
            this.gDS.setText(str);
            this.gEh.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gEh.setVisibility(8);
        } else {
            this.gDS.setText(str);
            this.gEh.setVisibility(0);
        }
    }

    public void lZ(boolean z) {
        if (z) {
            this.gDS.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gEh.setVisibility(8);
        }
    }

    public RelativeLayout bBY() {
        return this.gEh;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.fgs = aVar.bCI();
            this.gEK = aVar.bCJ();
            this.gEI = aVar;
            this.gEJ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bCD() != null) {
                gEL = aVar.bCD().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gEp.setVisibility(0);
            this.gEk.setVisibility(0);
            if (aVar.getGroup() != null) {
                yu(aVar.getGroup().getName());
                this.gDR.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gEe.setVisibility(0);
                } else {
                    this.gEe.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gEu.setVisibility(0);
                    this.gEa.setVisibility(8);
                    this.gEB.setVisibility(8);
                    this.gEC.setVisibility(8);
                    this.gCI.setText(R.string.group_info_forum_author);
                    this.gDX.setEnabled(false);
                    this.gEe.setVisibility(8);
                } else {
                    this.gEu.setVisibility(8);
                    this.gEa.setVisibility(0);
                    this.gEB.setVisibility(0);
                    this.gEC.setVisibility(0);
                    this.gCI.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gDX.setEnabled(true);
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
                this.gEt = stringBuffer.toString();
                this.gDS.setText(this.gEt);
                this.gDT.setText(aVar.getGroup().getIntro());
                this.gEb.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gEa.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gDV.setVisibility(0);
                    this.gDU.setText(aVar.getGroup().getForumName() + this.gDL.getPageContext().getString(R.string.forum));
                } else {
                    this.gDV.setVisibility(8);
                }
                this.gDZ.removeAllViews();
                boolean bCK = aVar.bCK();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.f(this.gEH, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gDL.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gDZ.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gDL.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gDZ.addView(imageView2);
                }
                if (bCK) {
                    this.gEE.setVisibility(0);
                } else {
                    this.gEE.setVisibility(8);
                }
            }
            if (aVar.bCD() != null) {
                this.gDO.setVisibility(0);
                this.gDM.setVisibility(0);
                GroupActivityData bCD = aVar.bCD();
                if (!aVar.bCI()) {
                    if (bCD.getIsEnd() != 1) {
                        this.gDP.setVisibility(4);
                        this.gDQ.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gDO.setVisibility(8);
                        this.gDM.setVisibility(8);
                    }
                } else {
                    this.gDP.setVisibility(0);
                    this.gDQ.setText(bCD.getgActivityTitle());
                    if (bCD.getIsEnd() != 1) {
                        this.gDP.setText(R.string.group_info_activity_doing);
                        al.f(this.gDP, R.color.common_color_10171, 1);
                    } else {
                        this.gDP.setText(R.string.group_activity_end);
                        al.f(this.gDP, R.color.common_color_10168, 1);
                    }
                    this.gDQ.setText(bCD.getgActivityTitle());
                }
            } else if (aVar.bCJ()) {
                this.gDO.setVisibility(0);
                this.gDM.setVisibility(0);
                this.gDP.setVisibility(4);
                this.gDQ.setText(R.string.group_info_create_activity);
            } else {
                this.gDO.setVisibility(8);
                this.gDM.setVisibility(8);
            }
            this.gEi.removeAllViews();
            if (aVar.bCE() != null && aVar.bCE().size() > 0) {
                List<MemberData> bCE = aVar.bCE();
                int size = bCE.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bCE.get(i3);
                    HeadImageView headImageView = this.gEj[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gDL.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gEj[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gEi.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bCJ()) {
                this.gEh.setEnabled(true);
                this.gEy.setEnabled(true);
                al.k(this.gEy, R.drawable.group_info_item);
                this.gEv.setVisibility(0);
                this.gEA.setVisibility(0);
                this.gEx.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gEw.setText(aVar.getGroup().getName());
                }
            } else {
                this.gEh.setEnabled(false);
                this.gEy.setEnabled(true);
                al.l(this.gEy, R.color.cp_bg_line_d);
                this.gEx.setVisibility(8);
                this.gEA.setVisibility(8);
                this.gDT.setPadding(0, 0, 0, 0);
            }
            if (aVar.bCI()) {
                this.gEn.setVisibility(0);
                this.gEG.setVisibility(0);
                if (this.gEc.getParent() != this.gEn) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gEp.removeView(this.gEc);
                    this.gEn.addView(this.gEc, 1);
                }
                bBZ();
            } else {
                this.gEn.setVisibility(8);
                this.gEG.setVisibility(8);
                if (this.gEc.getParent() != this.gEp) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gEn.removeView(this.gEc);
                    this.gEp.addView(this.gEc, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gDY.setVisibility(8);
            } else {
                this.gDY.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                lZ(aVar.bCJ());
            } else {
                l(aVar.bCJ(), this.gEt);
            }
            this.bbv.setVisibility(0);
            this.gEk.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vd(aVar.getGroup().getFlag())) {
                ma(z);
            } else {
                bCa();
            }
        }
    }

    public void bBZ() {
        this.gEl.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.gEl, R.color.cp_btn_a, 1);
        this.gEl.setText(this.gDL.getPageContext().getString(R.string.i_want_talk));
        this.gEF.setEnabled(true);
    }

    private void ma(boolean z) {
        this.gEl.setText(this.gDL.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gEl.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEl, R.color.cp_btn_a, 1);
        } else {
            this.gEl.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEl, R.color.cp_btn_a, 1);
        }
        al.k(this.gEF, R.drawable.btn_blue_bg);
        this.gEF.setEnabled(true);
    }

    private boolean vd(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bCa() {
        this.gEl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gEl.setText(this.gDL.getPageContext().getString(R.string.group_info_refuse_join));
        this.gEl.setTextColor(this.gDL.getResources().getColorStateList(R.color.cp_btn_a));
        al.k(this.gEF, R.drawable.btn_app_download_d);
        this.gEF.setEnabled(false);
    }

    public void yw(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gEi.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gEi.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gEi.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gDW.setIsManager(aVar.bCJ());
            if (aVar.bCJ()) {
                this.gDW.setVisibility(0);
                if (aVar.bCF() != null && aVar.bCF().size() == 1 && TextUtils.isEmpty(aVar.bCF().get(0).getPicId())) {
                    this.gDW.setData(null);
                } else {
                    this.gDW.setData(aVar.bCF());
                }
            } else if (aVar.bCF() != null && aVar.bCF().size() > 0) {
                if (aVar.bCF().size() == 1 && TextUtils.isEmpty(aVar.bCF().get(0).getPicId())) {
                    this.gDW.setVisibility(8);
                    return;
                }
                this.gDW.setVisibility(0);
                this.gDW.setData(aVar.bCF());
            } else {
                this.gDW.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gEr = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gEq != null) {
            this.gEq.dismiss();
            this.gEq = null;
        }
        e(obj, i);
        this.gEq.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gEq == null) {
            this.gEq = new i(this.gDL.getPageContext());
            this.gEq.a(null, new String[]{this.gDL.getResources().getString(R.string.group_info_set_portrait), this.gDL.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gEq != null && a.this.gEq.isShowing()) {
                        a.this.gEr.a(a.this.gEq, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gDW != null) {
            this.gDW.onDestory();
        }
        if (this.gEa != null) {
            this.gEa.stopLoad();
            this.gEa.setBackgroundDrawable(null);
            this.gEa.setImageDrawable(null);
        }
        if (this.gEi != null && this.gEj != null) {
            int length = this.gEj.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gEj[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void yx(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gDL.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gDL.getPageContext().getPageActivity());
            bVar.mF(this.gDL.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDL.getSystemService("clipboard")).setText(str);
                        a.this.gDL.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gDL.getPageContext());
            bVar.afJ();
        }
    }

    public void yy(String str) {
        if (this.gEo == null) {
            yz(str);
        }
        this.gEo.afJ();
    }

    private void yz(final String str) {
        if (this.gEo == null) {
            this.gEo = new com.baidu.tbadk.core.dialog.b(this.gDL.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gDL.getPageContext().getString(R.string.copy_group_number)};
            this.gEo.mF(this.gDL.getPageContext().getString(R.string.operation));
            this.gEo.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDL.getSystemService("clipboard")).setText(str);
                        a.this.gDL.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gEo.d(this.gDL.getPageContext());
        }
    }

    public void bCb() {
        ColorStateList ic = al.ic(R.color.cp_btn_a);
        if (ic != null) {
            this.gEl.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gEl.setTextColor(ic);
    }

    public void changeSkinType(int i) {
        this.gDL.getLayoutMode().setNightMode(i == 1);
        this.gDL.getLayoutMode().onModeChanged(this.cUF);
        this.gDL.getLayoutMode().onModeChanged(this.gEf);
        this.gDW.a(i, this.gDL);
        this.mNavigationBar.onChangeSkinType(this.gDL.getPageContext(), i);
        if (this.isMemGroup) {
            al.f(this.gEH, R.color.common_color_10009, 1);
        }
        if (!this.fgs) {
            b(this.gEI, this.gEJ);
        }
        if (this.gEK) {
            al.k(this.gEy, R.drawable.group_info_item);
        } else {
            al.l(this.gEy, R.color.cp_bg_line_d);
        }
    }

    public void mb(boolean z) {
        this.fgs = z;
    }
}
