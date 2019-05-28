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
    private RelativeLayout cUG;
    private View fba;
    private boolean fgt;
    private TextView gCJ;
    private final GroupInfoActivity gDM;
    private View gDN;
    private ProgressBar gDO;
    private RelativeLayout gDP;
    private TextView gDQ;
    private TextView gDR;
    private TextView gDS;
    private TextView gDT;
    private EllipsizingTextView gDU;
    private TextView gDV;
    private RelativeLayout gDW;
    private PhotoWallView gDX;
    private RelativeLayout gDY;
    private RelativeLayout gDZ;
    private RelativeLayout gEA;
    private ImageView gEB;
    private ImageView gEC;
    private View gED;
    private TextView gEE;
    private TextView gEF;
    private LinearLayout gEG;
    private View gEH;
    private TextView gEI;
    private ResponseGroupInfoLocalMessage.a gEJ;
    private boolean gEK;
    private boolean gEL;
    private LinearLayout gEa;
    private HeadImageView gEb;
    private TextView gEc;
    private RelativeLayout gEd;
    private com.baidu.tbadk.core.dialog.b gEe;
    private ImageView gEf;
    private final View gEg;
    private b.a gEh;
    private RelativeLayout gEi;
    private LinearLayout gEj;
    private HeadImageView[] gEk;
    private LinearLayout gEl;
    private TextView gEm;
    private RelativeLayout gEn;
    private LinearLayout gEo;
    private com.baidu.tbadk.core.dialog.b gEp;
    private LinearLayout gEq;
    private i gEr;
    private b gEs;
    private TextView gEt;
    private String gEu;
    private ImageView gEv;
    private RelativeLayout gEw;
    private TextView gEx;
    private ImageView gEy;
    private RelativeLayout gEz;
    private View gsu;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gEM = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gEe = null;
        this.gEh = null;
        this.gEk = new HeadImageView[5];
        this.gEu = "";
        this.gEK = true;
        this.isMemGroup = false;
        this.fgt = false;
        this.gEL = false;
        this.gDM = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gEg = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bbv.setVisibility(4);
        this.gEl.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gEx.setText(str);
        yu(str);
    }

    private void yu(String str) {
        if (str != null) {
            this.gEI.setText(str);
        }
    }

    public void yv(String str) {
        this.gDU.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gsu = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gEI = this.mNavigationBar.setTitleText("");
        this.gEH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gEt = (TextView) this.gEH.findViewById(R.id.right_textview);
        this.gEt.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        al.f(this.gEt, R.color.cp_cont_f, 1);
        this.gEt.setOnClickListener(groupInfoActivity);
        this.gEH.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gDN = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cUG = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
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
        this.fba = groupInfoActivity.findViewById(R.id.group_top_view);
        this.fba.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.gDP = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gDP.setOnClickListener(groupInfoActivity);
        this.gDQ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gDR = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gEi = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gEi.setOnClickListener(groupInfoActivity);
        this.gEq = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gEv = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gDS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gDT = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gEB = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gDU = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gDU.setMaxLines(20);
        this.gDU.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kS(boolean z) {
                if (z) {
                    a.this.gEE.setVisibility(0);
                } else {
                    a.this.gEE.setVisibility(8);
                }
            }
        });
        this.gDW = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gDV = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gDW.setOnClickListener(groupInfoActivity);
        this.gEb = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gEb.setAutoChangeStyle(true);
        this.gEb.setIsRound(false);
        this.gCJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gDY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gDY.setOnClickListener(groupInfoActivity);
        this.gEf = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gED = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gEa = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gDW.setOnClickListener(groupInfoActivity);
        this.gDZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gDZ.setOnClickListener(groupInfoActivity);
        this.gEc = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gEd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gEd.setOnClickListener(groupInfoActivity);
        this.gEj = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gEl = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gEG = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gEm = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gEG.setOnClickListener(this.gDM);
        this.gEn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gEn.setOnClickListener(groupInfoActivity);
        this.gEo = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gEw = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gEw.setOnClickListener(groupInfoActivity);
        this.gEx = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gEy = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gEC = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gEz = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gEz.setOnClickListener(groupInfoActivity);
        this.gEz.setLongClickable(true);
        this.gEz.setOnLongClickListener(groupInfoActivity);
        this.gEE = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gEE.setClickable(true);
        this.gEE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gDU.setMaxLines(1000);
            }
        });
        this.gEA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gEA.setOnLongClickListener(groupInfoActivity);
        this.gEF = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gDO = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gDX = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gDX.setPhotoClickListener(groupInfoActivity);
        this.gDX.setPhotoLongClickListener(groupInfoActivity);
        this.gDX.setVisibility(8);
    }

    public RelativeLayout bBN() {
        return this.gEA;
    }

    public RelativeLayout bBO() {
        return this.gDW;
    }

    public LinearLayout bBP() {
        return this.gEj;
    }

    public RelativeLayout bBQ() {
        return this.gEn;
    }

    public RelativeLayout bBR() {
        return this.gEz;
    }

    public RelativeLayout bBS() {
        return this.gEw;
    }

    public RelativeLayout bBT() {
        return this.gDP;
    }

    public View bBU() {
        return this.gEt;
    }

    public LinearLayout bBV() {
        return this.gEG;
    }

    public RelativeLayout bBW() {
        return this.gDY;
    }

    public RelativeLayout bBX() {
        return this.gDZ;
    }

    public RelativeLayout bBY() {
        return this.gEd;
    }

    public View bAI() {
        return this.gsu;
    }

    public void bBZ() {
        this.gDO.setVisibility(8);
    }

    public void bCa() {
        this.gDO.setVisibility(0);
    }

    public void l(boolean z, String str) {
        if (z) {
            this.gDT.setText(str);
            this.gEi.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gEi.setVisibility(8);
        } else {
            this.gDT.setText(str);
            this.gEi.setVisibility(0);
        }
    }

    public void lZ(boolean z) {
        if (z) {
            this.gDT.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gEi.setVisibility(8);
        }
    }

    public RelativeLayout bCb() {
        return this.gEi;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.fgt = aVar.bCL();
            this.gEL = aVar.bCM();
            this.gEJ = aVar;
            this.gEK = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bCG() != null) {
                gEM = aVar.bCG().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gEq.setVisibility(0);
            this.gEl.setVisibility(0);
            if (aVar.getGroup() != null) {
                yu(aVar.getGroup().getName());
                this.gDS.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gEf.setVisibility(0);
                } else {
                    this.gEf.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gEv.setVisibility(0);
                    this.gEb.setVisibility(8);
                    this.gEC.setVisibility(8);
                    this.gED.setVisibility(8);
                    this.gCJ.setText(R.string.group_info_forum_author);
                    this.gDY.setEnabled(false);
                    this.gEf.setVisibility(8);
                } else {
                    this.gEv.setVisibility(8);
                    this.gEb.setVisibility(0);
                    this.gEC.setVisibility(0);
                    this.gED.setVisibility(0);
                    this.gCJ.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gDY.setEnabled(true);
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
                this.gEu = stringBuffer.toString();
                this.gDT.setText(this.gEu);
                this.gDU.setText(aVar.getGroup().getIntro());
                this.gEc.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gEb.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gDW.setVisibility(0);
                    this.gDV.setText(aVar.getGroup().getForumName() + this.gDM.getPageContext().getString(R.string.forum));
                } else {
                    this.gDW.setVisibility(8);
                }
                this.gEa.removeAllViews();
                boolean bCN = aVar.bCN();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.f(this.gEI, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gDM.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gEa.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gDM.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gEa.addView(imageView2);
                }
                if (bCN) {
                    this.gEF.setVisibility(0);
                } else {
                    this.gEF.setVisibility(8);
                }
            }
            if (aVar.bCG() != null) {
                this.gDP.setVisibility(0);
                this.gDN.setVisibility(0);
                GroupActivityData bCG = aVar.bCG();
                if (!aVar.bCL()) {
                    if (bCG.getIsEnd() != 1) {
                        this.gDQ.setVisibility(4);
                        this.gDR.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gDP.setVisibility(8);
                        this.gDN.setVisibility(8);
                    }
                } else {
                    this.gDQ.setVisibility(0);
                    this.gDR.setText(bCG.getgActivityTitle());
                    if (bCG.getIsEnd() != 1) {
                        this.gDQ.setText(R.string.group_info_activity_doing);
                        al.f(this.gDQ, R.color.common_color_10171, 1);
                    } else {
                        this.gDQ.setText(R.string.group_activity_end);
                        al.f(this.gDQ, R.color.common_color_10168, 1);
                    }
                    this.gDR.setText(bCG.getgActivityTitle());
                }
            } else if (aVar.bCM()) {
                this.gDP.setVisibility(0);
                this.gDN.setVisibility(0);
                this.gDQ.setVisibility(4);
                this.gDR.setText(R.string.group_info_create_activity);
            } else {
                this.gDP.setVisibility(8);
                this.gDN.setVisibility(8);
            }
            this.gEj.removeAllViews();
            if (aVar.bCH() != null && aVar.bCH().size() > 0) {
                List<MemberData> bCH = aVar.bCH();
                int size = bCH.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bCH.get(i3);
                    HeadImageView headImageView = this.gEk[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gDM.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gEk[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gEj.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bCM()) {
                this.gEi.setEnabled(true);
                this.gEz.setEnabled(true);
                al.k(this.gEz, R.drawable.group_info_item);
                this.gEw.setVisibility(0);
                this.gEB.setVisibility(0);
                this.gEy.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gEx.setText(aVar.getGroup().getName());
                }
            } else {
                this.gEi.setEnabled(false);
                this.gEz.setEnabled(true);
                al.l(this.gEz, R.color.cp_bg_line_d);
                this.gEy.setVisibility(8);
                this.gEB.setVisibility(8);
                this.gDU.setPadding(0, 0, 0, 0);
            }
            if (aVar.bCL()) {
                this.gEo.setVisibility(0);
                this.gEH.setVisibility(0);
                if (this.gEd.getParent() != this.gEo) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gEq.removeView(this.gEd);
                    this.gEo.addView(this.gEd, 1);
                }
                bCc();
            } else {
                this.gEo.setVisibility(8);
                this.gEH.setVisibility(8);
                if (this.gEd.getParent() != this.gEq) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gEo.removeView(this.gEd);
                    this.gEq.addView(this.gEd, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gDZ.setVisibility(8);
            } else {
                this.gDZ.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                lZ(aVar.bCM());
            } else {
                l(aVar.bCM(), this.gEu);
            }
            this.bbv.setVisibility(0);
            this.gEl.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vd(aVar.getGroup().getFlag())) {
                ma(z);
            } else {
                bCd();
            }
        }
    }

    public void bCc() {
        this.gEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.gEm, R.color.cp_btn_a, 1);
        this.gEm.setText(this.gDM.getPageContext().getString(R.string.i_want_talk));
        this.gEG.setEnabled(true);
    }

    private void ma(boolean z) {
        this.gEm.setText(this.gDM.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEm, R.color.cp_btn_a, 1);
        } else {
            this.gEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEm, R.color.cp_btn_a, 1);
        }
        al.k(this.gEG, R.drawable.btn_blue_bg);
        this.gEG.setEnabled(true);
    }

    private boolean vd(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bCd() {
        this.gEm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gEm.setText(this.gDM.getPageContext().getString(R.string.group_info_refuse_join));
        this.gEm.setTextColor(this.gDM.getResources().getColorStateList(R.color.cp_btn_a));
        al.k(this.gEG, R.drawable.btn_app_download_d);
        this.gEG.setEnabled(false);
    }

    public void yw(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gEj.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gEj.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gEj.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gDX.setIsManager(aVar.bCM());
            if (aVar.bCM()) {
                this.gDX.setVisibility(0);
                if (aVar.bCI() != null && aVar.bCI().size() == 1 && TextUtils.isEmpty(aVar.bCI().get(0).getPicId())) {
                    this.gDX.setData(null);
                } else {
                    this.gDX.setData(aVar.bCI());
                }
            } else if (aVar.bCI() != null && aVar.bCI().size() > 0) {
                if (aVar.bCI().size() == 1 && TextUtils.isEmpty(aVar.bCI().get(0).getPicId())) {
                    this.gDX.setVisibility(8);
                    return;
                }
                this.gDX.setVisibility(0);
                this.gDX.setData(aVar.bCI());
            } else {
                this.gDX.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gEs = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gEr != null) {
            this.gEr.dismiss();
            this.gEr = null;
        }
        e(obj, i);
        this.gEr.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gEr == null) {
            this.gEr = new i(this.gDM.getPageContext());
            this.gEr.a(null, new String[]{this.gDM.getResources().getString(R.string.group_info_set_portrait), this.gDM.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gEr != null && a.this.gEr.isShowing()) {
                        a.this.gEs.a(a.this.gEr, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gDX != null) {
            this.gDX.onDestory();
        }
        if (this.gEb != null) {
            this.gEb.stopLoad();
            this.gEb.setBackgroundDrawable(null);
            this.gEb.setImageDrawable(null);
        }
        if (this.gEj != null && this.gEk != null) {
            int length = this.gEk.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gEk[i];
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
            CharSequence[] charSequenceArr = {this.gDM.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gDM.getPageContext().getPageActivity());
            bVar.mF(this.gDM.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDM.getSystemService("clipboard")).setText(str);
                        a.this.gDM.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gDM.getPageContext());
            bVar.afJ();
        }
    }

    public void yy(String str) {
        if (this.gEp == null) {
            yz(str);
        }
        this.gEp.afJ();
    }

    private void yz(final String str) {
        if (this.gEp == null) {
            this.gEp = new com.baidu.tbadk.core.dialog.b(this.gDM.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gDM.getPageContext().getString(R.string.copy_group_number)};
            this.gEp.mF(this.gDM.getPageContext().getString(R.string.operation));
            this.gEp.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDM.getSystemService("clipboard")).setText(str);
                        a.this.gDM.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gEp.d(this.gDM.getPageContext());
        }
    }

    public void bCe() {
        ColorStateList ic = al.ic(R.color.cp_btn_a);
        if (ic != null) {
            this.gEm.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gEm.setTextColor(ic);
    }

    public void changeSkinType(int i) {
        this.gDM.getLayoutMode().setNightMode(i == 1);
        this.gDM.getLayoutMode().onModeChanged(this.cUG);
        this.gDM.getLayoutMode().onModeChanged(this.gEg);
        this.gDX.a(i, this.gDM);
        this.mNavigationBar.onChangeSkinType(this.gDM.getPageContext(), i);
        if (this.isMemGroup) {
            al.f(this.gEI, R.color.common_color_10009, 1);
        }
        if (!this.fgt) {
            b(this.gEJ, this.gEK);
        }
        if (this.gEL) {
            al.k(this.gEz, R.drawable.group_info_item);
        } else {
            al.l(this.gEz, R.color.cp_bg_line_d);
        }
    }

    public void mb(boolean z) {
        this.fgt = z;
    }
}
