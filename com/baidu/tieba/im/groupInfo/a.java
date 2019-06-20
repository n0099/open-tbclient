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
    private RelativeLayout cUH;
    private View fba;
    private boolean fgt;
    private TextView gCL;
    private final GroupInfoActivity gDO;
    private View gDP;
    private ProgressBar gDQ;
    private RelativeLayout gDR;
    private TextView gDS;
    private TextView gDT;
    private TextView gDU;
    private TextView gDV;
    private EllipsizingTextView gDW;
    private TextView gDX;
    private RelativeLayout gDY;
    private PhotoWallView gDZ;
    private ImageView gEA;
    private RelativeLayout gEB;
    private RelativeLayout gEC;
    private ImageView gED;
    private ImageView gEE;
    private View gEF;
    private TextView gEG;
    private TextView gEH;
    private LinearLayout gEI;
    private View gEJ;
    private TextView gEK;
    private ResponseGroupInfoLocalMessage.a gEL;
    private boolean gEM;
    private boolean gEN;
    private RelativeLayout gEa;
    private RelativeLayout gEb;
    private LinearLayout gEc;
    private HeadImageView gEd;
    private TextView gEe;
    private RelativeLayout gEf;
    private com.baidu.tbadk.core.dialog.b gEg;
    private ImageView gEh;
    private final View gEi;
    private b.a gEj;
    private RelativeLayout gEk;
    private LinearLayout gEl;
    private HeadImageView[] gEm;
    private LinearLayout gEn;
    private TextView gEo;
    private RelativeLayout gEp;
    private LinearLayout gEq;
    private com.baidu.tbadk.core.dialog.b gEr;
    private LinearLayout gEs;
    private i gEt;
    private b gEu;
    private TextView gEv;
    private String gEw;
    private ImageView gEx;
    private RelativeLayout gEy;
    private TextView gEz;
    private View gsw;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int gEO = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.gEg = null;
        this.gEj = null;
        this.gEm = new HeadImageView[5];
        this.gEw = "";
        this.gEM = true;
        this.isMemGroup = false;
        this.fgt = false;
        this.gEN = false;
        this.gDO = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.gEi = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bbv.setVisibility(4);
        this.gEn.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.gEz.setText(str);
        yw(str);
    }

    private void yw(String str) {
        if (str != null) {
            this.gEK.setText(str);
        }
    }

    public void yx(String str) {
        this.gDW.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.gsw = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.gEK = this.mNavigationBar.setTitleText("");
        this.gEJ = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.gEv = (TextView) this.gEJ.findViewById(R.id.right_textview);
        this.gEv.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        al.f(this.gEv, R.color.cp_cont_f, 1);
        this.gEv.setOnClickListener(groupInfoActivity);
        this.gEJ.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.gDP = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.cUH = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
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
        this.gDR = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.gDR.setOnClickListener(groupInfoActivity);
        this.gDS = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.gDT = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.gEk = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.gEk.setOnClickListener(groupInfoActivity);
        this.gEs = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.gEx = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.gDU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.gDV = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.gED = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.gDW = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.gDW.setMaxLines(20);
        this.gDW.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void kT(boolean z) {
                if (z) {
                    a.this.gEG.setVisibility(0);
                } else {
                    a.this.gEG.setVisibility(8);
                }
            }
        });
        this.gDY = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.gDX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.gDY.setOnClickListener(groupInfoActivity);
        this.gEd = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.gEd.setAutoChangeStyle(true);
        this.gEd.setIsRound(false);
        this.gCL = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.gEa = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.gEa.setOnClickListener(groupInfoActivity);
        this.gEh = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.gEF = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.gEc = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.gDY.setOnClickListener(groupInfoActivity);
        this.gEb = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.gEb.setOnClickListener(groupInfoActivity);
        this.gEe = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.gEf = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.gEf.setOnClickListener(groupInfoActivity);
        this.gEl = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.gEn = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.gEI = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.gEo = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.gEI.setOnClickListener(this.gDO);
        this.gEp = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.gEp.setOnClickListener(groupInfoActivity);
        this.gEq = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.gEy = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.gEy.setOnClickListener(groupInfoActivity);
        this.gEz = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.gEA = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.gEE = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.gEB = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.gEB.setOnClickListener(groupInfoActivity);
        this.gEB.setLongClickable(true);
        this.gEB.setOnLongClickListener(groupInfoActivity);
        this.gEG = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.gEG.setClickable(true);
        this.gEG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.gDW.setMaxLines(1000);
            }
        });
        this.gEC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.gEC.setOnLongClickListener(groupInfoActivity);
        this.gEH = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.gDQ = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.gDZ = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.gDZ.setPhotoClickListener(groupInfoActivity);
        this.gDZ.setPhotoLongClickListener(groupInfoActivity);
        this.gDZ.setVisibility(8);
    }

    public RelativeLayout bBO() {
        return this.gEC;
    }

    public RelativeLayout bBP() {
        return this.gDY;
    }

    public LinearLayout bBQ() {
        return this.gEl;
    }

    public RelativeLayout bBR() {
        return this.gEp;
    }

    public RelativeLayout bBS() {
        return this.gEB;
    }

    public RelativeLayout bBT() {
        return this.gEy;
    }

    public RelativeLayout bBU() {
        return this.gDR;
    }

    public View bBV() {
        return this.gEv;
    }

    public LinearLayout bBW() {
        return this.gEI;
    }

    public RelativeLayout bBX() {
        return this.gEa;
    }

    public RelativeLayout bBY() {
        return this.gEb;
    }

    public RelativeLayout bBZ() {
        return this.gEf;
    }

    public View bAJ() {
        return this.gsw;
    }

    public void bCa() {
        this.gDQ.setVisibility(8);
    }

    public void bCb() {
        this.gDQ.setVisibility(0);
    }

    public void l(boolean z, String str) {
        if (z) {
            this.gDV.setText(str);
            this.gEk.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.gEk.setVisibility(8);
        } else {
            this.gDV.setText(str);
            this.gEk.setVisibility(0);
        }
    }

    public void ma(boolean z) {
        if (z) {
            this.gDV.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.gEk.setVisibility(8);
        }
    }

    public RelativeLayout bCc() {
        return this.gEk;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.fgt = aVar.bCM();
            this.gEN = aVar.bCN();
            this.gEL = aVar;
            this.gEM = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.bCH() != null) {
                gEO = aVar.bCH().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.gEs.setVisibility(0);
            this.gEn.setVisibility(0);
            if (aVar.getGroup() != null) {
                yw(aVar.getGroup().getName());
                this.gDU.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.gEh.setVisibility(0);
                } else {
                    this.gEh.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.gEx.setVisibility(0);
                    this.gEd.setVisibility(8);
                    this.gEE.setVisibility(8);
                    this.gEF.setVisibility(8);
                    this.gCL.setText(R.string.group_info_forum_author);
                    this.gEa.setEnabled(false);
                    this.gEh.setVisibility(8);
                } else {
                    this.gEx.setVisibility(8);
                    this.gEd.setVisibility(0);
                    this.gEE.setVisibility(0);
                    this.gEF.setVisibility(0);
                    this.gCL.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.gEa.setEnabled(true);
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
                this.gEw = stringBuffer.toString();
                this.gDV.setText(this.gEw);
                this.gDW.setText(aVar.getGroup().getIntro());
                this.gEe.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.gEd.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.gDY.setVisibility(0);
                    this.gDX.setText(aVar.getGroup().getForumName() + this.gDO.getPageContext().getString(R.string.forum));
                } else {
                    this.gDY.setVisibility(8);
                }
                this.gEc.removeAllViews();
                boolean bCO = aVar.bCO();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.f(this.gEK, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.gDO.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, (int) R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, (int) R.drawable.icon_grade_middle_star_s);
                        }
                        this.gEc.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.gDO.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, (int) R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, (int) R.drawable.icon_grade_middle_star_n);
                    }
                    this.gEc.addView(imageView2);
                }
                if (bCO) {
                    this.gEH.setVisibility(0);
                } else {
                    this.gEH.setVisibility(8);
                }
            }
            if (aVar.bCH() != null) {
                this.gDR.setVisibility(0);
                this.gDP.setVisibility(0);
                GroupActivityData bCH = aVar.bCH();
                if (!aVar.bCM()) {
                    if (bCH.getIsEnd() != 1) {
                        this.gDS.setVisibility(4);
                        this.gDT.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.gDR.setVisibility(8);
                        this.gDP.setVisibility(8);
                    }
                } else {
                    this.gDS.setVisibility(0);
                    this.gDT.setText(bCH.getgActivityTitle());
                    if (bCH.getIsEnd() != 1) {
                        this.gDS.setText(R.string.group_info_activity_doing);
                        al.f(this.gDS, R.color.common_color_10171, 1);
                    } else {
                        this.gDS.setText(R.string.group_activity_end);
                        al.f(this.gDS, R.color.common_color_10168, 1);
                    }
                    this.gDT.setText(bCH.getgActivityTitle());
                }
            } else if (aVar.bCN()) {
                this.gDR.setVisibility(0);
                this.gDP.setVisibility(0);
                this.gDS.setVisibility(4);
                this.gDT.setText(R.string.group_info_create_activity);
            } else {
                this.gDR.setVisibility(8);
                this.gDP.setVisibility(8);
            }
            this.gEl.removeAllViews();
            if (aVar.bCI() != null && aVar.bCI().size() > 0) {
                List<MemberData> bCI = aVar.bCI();
                int size = bCI.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = bCI.get(i3);
                    HeadImageView headImageView = this.gEm[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.gDO.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.gEm[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.gEl.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.bCN()) {
                this.gEk.setEnabled(true);
                this.gEB.setEnabled(true);
                al.k(this.gEB, R.drawable.group_info_item);
                this.gEy.setVisibility(0);
                this.gED.setVisibility(0);
                this.gEA.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.gEz.setText(aVar.getGroup().getName());
                }
            } else {
                this.gEk.setEnabled(false);
                this.gEB.setEnabled(true);
                al.l(this.gEB, R.color.cp_bg_line_d);
                this.gEA.setVisibility(8);
                this.gED.setVisibility(8);
                this.gDW.setPadding(0, 0, 0, 0);
            }
            if (aVar.bCM()) {
                this.gEq.setVisibility(0);
                this.gEJ.setVisibility(0);
                if (this.gEf.getParent() != this.gEq) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.gEs.removeView(this.gEf);
                    this.gEq.addView(this.gEf, 1);
                }
                bCd();
            } else {
                this.gEq.setVisibility(8);
                this.gEJ.setVisibility(8);
                if (this.gEf.getParent() != this.gEs) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.gEq.removeView(this.gEf);
                    this.gEs.addView(this.gEf, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.gEb.setVisibility(8);
            } else {
                this.gEb.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                ma(aVar.bCN());
            } else {
                l(aVar.bCN(), this.gEw);
            }
            this.bbv.setVisibility(0);
            this.gEn.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (vd(aVar.getGroup().getFlag())) {
                mb(z);
            } else {
                bCe();
            }
        }
    }

    public void bCd() {
        this.gEo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.f(this.gEo, R.color.cp_btn_a, 1);
        this.gEo.setText(this.gDO.getPageContext().getString(R.string.i_want_talk));
        this.gEI.setEnabled(true);
    }

    private void mb(boolean z) {
        this.gEo.setText(this.gDO.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.gEo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEo, R.color.cp_btn_a, 1);
        } else {
            this.gEo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.f(this.gEo, R.color.cp_btn_a, 1);
        }
        al.k(this.gEI, R.drawable.btn_blue_bg);
        this.gEI.setEnabled(true);
    }

    private boolean vd(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void bCe() {
        this.gEo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gEo.setText(this.gDO.getPageContext().getString(R.string.group_info_refuse_join));
        this.gEo.setTextColor(this.gDO.getResources().getColorStateList(R.color.cp_btn_a));
        al.k(this.gEI, R.drawable.btn_app_download_d);
        this.gEI.setEnabled(false);
    }

    public void yy(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.gEl.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.gEl.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.gEl.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.gDZ.setIsManager(aVar.bCN());
            if (aVar.bCN()) {
                this.gDZ.setVisibility(0);
                if (aVar.bCJ() != null && aVar.bCJ().size() == 1 && TextUtils.isEmpty(aVar.bCJ().get(0).getPicId())) {
                    this.gDZ.setData(null);
                } else {
                    this.gDZ.setData(aVar.bCJ());
                }
            } else if (aVar.bCJ() != null && aVar.bCJ().size() > 0) {
                if (aVar.bCJ().size() == 1 && TextUtils.isEmpty(aVar.bCJ().get(0).getPicId())) {
                    this.gDZ.setVisibility(8);
                    return;
                }
                this.gDZ.setVisibility(0);
                this.gDZ.setData(aVar.bCJ());
            } else {
                this.gDZ.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.gEu = bVar;
    }

    public void d(Object obj, int i) {
        if (this.gEt != null) {
            this.gEt.dismiss();
            this.gEt = null;
        }
        e(obj, i);
        this.gEt.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.gEt == null) {
            this.gEt = new i(this.gDO.getPageContext());
            this.gEt.a(null, new String[]{this.gDO.getResources().getString(R.string.group_info_set_portrait), this.gDO.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.gEt != null && a.this.gEt.isShowing()) {
                        a.this.gEu.a(a.this.gEt, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.gDZ != null) {
            this.gDZ.onDestory();
        }
        if (this.gEd != null) {
            this.gEd.stopLoad();
            this.gEd.setBackgroundDrawable(null);
            this.gEd.setImageDrawable(null);
        }
        if (this.gEl != null && this.gEm != null) {
            int length = this.gEm.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.gEm[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void yz(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.gDO.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.gDO.getPageContext().getPageActivity());
            bVar.mE(this.gDO.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDO.getSystemService("clipboard")).setText(str);
                        a.this.gDO.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.gDO.getPageContext());
            bVar.afJ();
        }
    }

    public void yA(String str) {
        if (this.gEr == null) {
            yB(str);
        }
        this.gEr.afJ();
    }

    private void yB(final String str) {
        if (this.gEr == null) {
            this.gEr = new com.baidu.tbadk.core.dialog.b(this.gDO.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.gDO.getPageContext().getString(R.string.copy_group_number)};
            this.gEr.mE(this.gDO.getPageContext().getString(R.string.operation));
            this.gEr.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.gDO.getSystemService("clipboard")).setText(str);
                        a.this.gDO.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.gEr.d(this.gDO.getPageContext());
        }
    }

    public void bCf() {
        ColorStateList ic = al.ic(R.color.cp_btn_a);
        if (ic != null) {
            this.gEo.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.gEo.setTextColor(ic);
    }

    public void changeSkinType(int i) {
        this.gDO.getLayoutMode().setNightMode(i == 1);
        this.gDO.getLayoutMode().onModeChanged(this.cUH);
        this.gDO.getLayoutMode().onModeChanged(this.gEi);
        this.gDZ.a(i, this.gDO);
        this.mNavigationBar.onChangeSkinType(this.gDO.getPageContext(), i);
        if (this.isMemGroup) {
            al.f(this.gEK, R.color.common_color_10009, 1);
        }
        if (!this.fgt) {
            b(this.gEL, this.gEM);
        }
        if (this.gEN) {
            al.k(this.gEB, R.drawable.group_info_item);
        } else {
            al.l(this.gEB, R.color.cp_bg_line_d);
        }
    }

    public void mc(boolean z) {
        this.fgt = z;
    }
}
