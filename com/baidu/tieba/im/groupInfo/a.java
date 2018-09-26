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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.e;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes3.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    private RelativeLayout bsh;
    private View deF;
    private boolean dkf;
    private ScrollView dqb;
    private TextView eCe;
    private com.baidu.tbadk.core.dialog.b eDA;
    private ImageView eDB;
    private final View eDC;
    private b.InterfaceC0100b eDD;
    private RelativeLayout eDE;
    private LinearLayout eDF;
    private HeadImageView[] eDG;
    private LinearLayout eDH;
    private TextView eDI;
    private RelativeLayout eDJ;
    private LinearLayout eDK;
    private com.baidu.tbadk.core.dialog.b eDL;
    private LinearLayout eDM;
    private com.baidu.tbadk.core.dialog.b eDN;
    private b eDO;
    private TextView eDP;
    private String eDQ;
    private ImageView eDR;
    private RelativeLayout eDS;
    private TextView eDT;
    private ImageView eDU;
    private RelativeLayout eDV;
    private RelativeLayout eDW;
    private ImageView eDX;
    private ImageView eDY;
    private View eDZ;
    private final GroupInfoActivity eDi;
    private View eDj;
    private ProgressBar eDk;
    private RelativeLayout eDl;
    private TextView eDm;
    private TextView eDn;
    private TextView eDo;
    private TextView eDp;
    private EllipsizingTextView eDq;
    private TextView eDr;
    private RelativeLayout eDs;
    private PhotoWallView eDt;
    private RelativeLayout eDu;
    private RelativeLayout eDv;
    private LinearLayout eDw;
    private HeadImageView eDx;
    private TextView eDy;
    private RelativeLayout eDz;
    private TextView eEa;
    private TextView eEb;
    private LinearLayout eEc;
    private View eEd;
    private TextView eEe;
    private ResponseGroupInfoLocalMessage.a eEf;
    private boolean eEg;
    private boolean eEh;
    private View erL;
    private boolean isMemGroup;
    private View mBottomLine;
    private NavigationBar mNavigationBar;
    public static long gid = 0;
    public static int eEi = 0;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.eDA = null;
        this.eDD = null;
        this.eDG = new HeadImageView[5];
        this.eDQ = "";
        this.eEg = true;
        this.isMemGroup = false;
        this.dkf = false;
        this.eEh = false;
        this.eDi = groupInfoActivity;
        groupInfoActivity.setContentView(e.h.im_group_info_activity);
        this.eDC = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(e.h.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.dqb.setVisibility(4);
        this.eDH.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.eDT.setText(str);
        pe(str);
    }

    private void pe(String str) {
        if (str != null) {
            this.eEe.setText(str);
        }
    }

    public void pf(String str) {
        this.eDq.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(e.g.view_navigation_bar);
        this.erL = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.eEe = this.mNavigationBar.setTitleText("");
        this.eEd = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.navigation_right_button_layout, (View.OnClickListener) null);
        this.eDP = (TextView) this.eEd.findViewById(e.g.right_textview);
        this.eDP.setText(groupInfoActivity.getPageContext().getString(e.j.setup));
        al.c(this.eDP, e.d.cp_cont_f, 1);
        this.eDP.setOnClickListener(groupInfoActivity);
        this.eEd.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.eDj = groupInfoActivity.findViewById(e.g.line_activity_name_down);
        this.bsh = (RelativeLayout) groupInfoActivity.findViewById(e.g.group_info_container);
        this.dqb = (ScrollView) groupInfoActivity.findViewById(e.g.group_scrollview);
        this.dqb.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.deF = groupInfoActivity.findViewById(e.g.group_top_view);
        this.deF.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.eDl = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_activity);
        this.eDl.setOnClickListener(groupInfoActivity);
        this.eDm = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_status);
        this.eDn = (TextView) groupInfoActivity.findViewById(e.g.txt_activity_name);
        this.eDE = (RelativeLayout) groupInfoActivity.findViewById(e.g.address_layout);
        this.eDE.setOnClickListener(groupInfoActivity);
        this.eDM = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_body);
        this.eDR = (ImageView) groupInfoActivity.findViewById(e.g.img_group_type_icon);
        this.eDo = (TextView) groupInfoActivity.findViewById(e.g.txt_group_number);
        this.eDp = (TextView) groupInfoActivity.findViewById(e.g.txt_group_place);
        this.eDX = (ImageView) groupInfoActivity.findViewById(e.g.img_group_place);
        this.eDq = (EllipsizingTextView) groupInfoActivity.findViewById(e.g.txt_group_intro);
        this.eDq.setMaxLines(20);
        this.eDq.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void hc(boolean z) {
                if (z) {
                    a.this.eEa.setVisibility(0);
                } else {
                    a.this.eEa.setVisibility(8);
                }
            }
        });
        this.eDs = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_forum);
        this.eDr = (TextView) groupInfoActivity.findViewById(e.g.txt_group_forum);
        this.eDs.setOnClickListener(groupInfoActivity);
        this.eDx = (HeadImageView) groupInfoActivity.findViewById(e.g.img_group_author);
        this.eDx.setAutoChangeStyle(true);
        this.eDx.setIsRound(false);
        this.eCe = (TextView) groupInfoActivity.findViewById(e.g.txt_group_author);
        this.eDu = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_author);
        this.eDu.setOnClickListener(groupInfoActivity);
        this.eDB = (ImageView) groupInfoActivity.findViewById(e.g.meizhi_icon);
        this.eDZ = groupInfoActivity.findViewById(e.g.line_group_author_down);
        this.eDw = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_grade_star);
        this.eDs.setOnClickListener(groupInfoActivity);
        this.eDv = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_grade);
        this.eDv.setOnClickListener(groupInfoActivity);
        this.eDy = (TextView) groupInfoActivity.findViewById(e.g.txt_group_member_count);
        this.eDz = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_member);
        this.eDz.setOnClickListener(groupInfoActivity);
        this.eDF = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_member_photo);
        this.eDH = (LinearLayout) groupInfoActivity.findViewById(e.g.bottom_bar);
        this.eEc = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_bottom_button);
        this.eDI = (TextView) groupInfoActivity.findViewById(e.g.txt_join);
        this.eEc.setOnClickListener(this.eDi);
        this.eDJ = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_invite);
        this.eDJ.setOnClickListener(groupInfoActivity);
        this.eDK = (LinearLayout) groupInfoActivity.findViewById(e.g.lay_group_notice_share);
        this.eDS = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_name);
        this.eDS.setOnClickListener(groupInfoActivity);
        this.eDT = (TextView) groupInfoActivity.findViewById(e.g.txt_group_name);
        this.eDU = (ImageView) groupInfoActivity.findViewById(e.g.img_group_intro_arrow);
        this.eDY = (ImageView) groupInfoActivity.findViewById(e.g.img_group_author_arrow);
        this.eDV = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_intro);
        this.eDV.setOnClickListener(groupInfoActivity);
        this.eDV.setLongClickable(true);
        this.eDV.setOnLongClickListener(groupInfoActivity);
        this.eEa = (TextView) groupInfoActivity.findViewById(e.g.txt_group_intro_more);
        this.eEa.setClickable(true);
        this.eEa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.eDq.setMaxLines(1000);
            }
        });
        this.eDW = (RelativeLayout) groupInfoActivity.findViewById(e.g.lay_group_number);
        this.eDW.setOnLongClickListener(groupInfoActivity);
        this.eEb = (TextView) groupInfoActivity.findViewById(e.g.can_create_mem_group);
        this.eDk = (ProgressBar) groupInfoActivity.findViewById(e.g.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(e.g.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.eDt = (PhotoWallView) groupInfoActivity.findViewById(e.g.photo_wall);
        this.eDt.setPhotoClickListener(groupInfoActivity);
        this.eDt.setPhotoLongClickListener(groupInfoActivity);
        this.eDt.setVisibility(8);
    }

    public RelativeLayout aNF() {
        return this.eDW;
    }

    public RelativeLayout aNG() {
        return this.eDs;
    }

    public LinearLayout aNH() {
        return this.eDF;
    }

    public RelativeLayout aNI() {
        return this.eDJ;
    }

    public RelativeLayout aNJ() {
        return this.eDV;
    }

    public RelativeLayout aNK() {
        return this.eDS;
    }

    public RelativeLayout aNL() {
        return this.eDl;
    }

    public View aNM() {
        return this.eDP;
    }

    public LinearLayout aNN() {
        return this.eEc;
    }

    public RelativeLayout aNO() {
        return this.eDu;
    }

    public RelativeLayout aNP() {
        return this.eDv;
    }

    public RelativeLayout aNQ() {
        return this.eDz;
    }

    public View aMA() {
        return this.erL;
    }

    public void aNR() {
        this.eDk.setVisibility(8);
    }

    public void aNS() {
        this.eDk.setVisibility(0);
    }

    public void i(boolean z, String str) {
        if (z) {
            this.eDp.setText(str);
            this.eDE.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.eDE.setVisibility(8);
        } else {
            this.eDp.setText(str);
            this.eDE.setVisibility(0);
        }
    }

    public void id(boolean z) {
        if (z) {
            this.eDp.setText(this.mContext.getString(e.j.live_card_hide));
        } else {
            this.eDE.setVisibility(8);
        }
    }

    public RelativeLayout aNT() {
        return this.eDE;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.dkf = aVar.aOE();
            this.eEh = aVar.aOF();
            this.eEf = aVar;
            this.eEg = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.aOz() != null) {
                eEi = aVar.aOz().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.eDM.setVisibility(0);
            this.eDH.setVisibility(0);
            if (aVar.getGroup() != null) {
                pe(aVar.getGroup().getName());
                this.eDo.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.eDB.setVisibility(0);
                } else {
                    this.eDB.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.eDR.setVisibility(0);
                    this.eDx.setVisibility(8);
                    this.eDY.setVisibility(8);
                    this.eDZ.setVisibility(8);
                    this.eCe.setText(e.j.group_info_forum_author);
                    this.eDu.setEnabled(false);
                    this.eDB.setVisibility(8);
                } else {
                    this.eDR.setVisibility(8);
                    this.eDx.setVisibility(0);
                    this.eDY.setVisibility(0);
                    this.eDZ.setVisibility(0);
                    this.eCe.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.eDu.setEnabled(true);
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
                this.eDQ = stringBuffer.toString();
                this.eDp.setText(this.eDQ);
                this.eDq.setText(aVar.getGroup().getIntro());
                this.eDy.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.eDx.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.eDs.setVisibility(0);
                    this.eDr.setText(aVar.getGroup().getForumName() + this.eDi.getPageContext().getString(e.j.forum));
                } else {
                    this.eDs.setVisibility(8);
                }
                this.eDw.removeAllViews();
                boolean aOG = aVar.aOG();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    al.c(this.eEe, e.d.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.eDi.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            al.c(imageView, e.f.icon_vip_grade_big_middle_s);
                        } else {
                            al.c(imageView, e.f.icon_grade_middle_star_s);
                        }
                        this.eDw.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.eDi.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        al.c(imageView2, e.f.icon_vip_grade_big_middle_n);
                    } else {
                        al.c(imageView2, e.f.icon_grade_middle_star_n);
                    }
                    this.eDw.addView(imageView2);
                }
                if (aOG) {
                    this.eEb.setVisibility(0);
                } else {
                    this.eEb.setVisibility(8);
                }
            }
            if (aVar.aOz() != null) {
                this.eDl.setVisibility(0);
                this.eDj.setVisibility(0);
                GroupActivityData aOz = aVar.aOz();
                if (!aVar.aOE()) {
                    if (aOz.getIsEnd() != 1) {
                        this.eDm.setVisibility(4);
                        this.eDn.setText(e.j.group_info_activity_not_join_tip);
                    } else {
                        this.eDl.setVisibility(8);
                        this.eDj.setVisibility(8);
                    }
                } else {
                    this.eDm.setVisibility(0);
                    this.eDn.setText(aOz.getgActivityTitle());
                    if (aOz.getIsEnd() != 1) {
                        this.eDm.setText(e.j.group_info_activity_doing);
                        al.c(this.eDm, e.d.common_color_10171, 1);
                    } else {
                        this.eDm.setText(e.j.group_activity_end);
                        al.c(this.eDm, e.d.common_color_10168, 1);
                    }
                    this.eDn.setText(aOz.getgActivityTitle());
                }
            } else if (aVar.aOF()) {
                this.eDl.setVisibility(0);
                this.eDj.setVisibility(0);
                this.eDm.setVisibility(4);
                this.eDn.setText(e.j.group_info_create_activity);
            } else {
                this.eDl.setVisibility(8);
                this.eDj.setVisibility(8);
            }
            this.eDF.removeAllViews();
            if (aVar.aOA() != null && aVar.aOA().size() > 0) {
                List<MemberData> aOA = aVar.aOA();
                int size = aOA.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = aOA.get(i3);
                    HeadImageView headImageView = this.eDG[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.eDi.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.eDG[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds10);
                    this.eDF.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.aOF()) {
                this.eDE.setEnabled(true);
                this.eDV.setEnabled(true);
                al.i(this.eDV, e.f.group_info_item);
                this.eDS.setVisibility(0);
                this.eDX.setVisibility(0);
                this.eDU.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.eDT.setText(aVar.getGroup().getName());
                }
            } else {
                this.eDE.setEnabled(false);
                this.eDV.setEnabled(true);
                al.j(this.eDV, e.d.cp_bg_line_d);
                this.eDU.setVisibility(8);
                this.eDX.setVisibility(8);
                this.eDq.setPadding(0, 0, 0, 0);
            }
            if (aVar.aOE()) {
                this.eDK.setVisibility(0);
                this.eEd.setVisibility(0);
                if (this.eDz.getParent() != this.eDK) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds30);
                    this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds18);
                    this.eDM.removeView(this.eDz);
                    this.eDK.addView(this.eDz, 1);
                }
                aNU();
            } else {
                this.eDK.setVisibility(8);
                this.eEd.setVisibility(8);
                if (this.eDz.getParent() != this.eDM) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(e.C0141e.ds28);
                    this.eDK.removeView(this.eDz);
                    this.eDM.addView(this.eDz, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.eDv.setVisibility(8);
            } else {
                this.eDv.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                id(aVar.aOF());
            } else {
                i(aVar.aOF(), this.eDQ);
            }
            this.dqb.setVisibility(0);
            this.eDH.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (oR(aVar.getGroup().getFlag())) {
                ie(z);
            } else {
                aNV();
            }
        }
    }

    public void aNU() {
        this.eDI.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        al.c(this.eDI, e.d.cp_cont_i, 1);
        this.eDI.setText(this.eDi.getPageContext().getString(e.j.i_want_talk));
        this.eEc.setEnabled(true);
    }

    private void ie(boolean z) {
        this.eDI.setText(this.eDi.getPageContext().getString(e.j.i_want_attent));
        if (z) {
            this.eDI.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eDI, e.d.cp_cont_i, 1);
        } else {
            this.eDI.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            al.c(this.eDI, e.d.cp_cont_i, 1);
        }
        al.i(this.eEc, e.f.btn_blue_bg);
        this.eEc.setEnabled(true);
    }

    private boolean oR(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void aNV() {
        this.eDI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.eDI.setText(this.eDi.getPageContext().getString(e.j.group_info_refuse_join));
        this.eDI.setTextColor(this.eDi.getResources().getColorStateList(e.d.cp_cont_i));
        al.i(this.eEc, e.f.btn_app_download_d);
        this.eEc.setEnabled(false);
    }

    public void pg(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.eDF.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.eDF.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.eDF.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.eDt.setIsManager(aVar.aOF());
            if (aVar.aOF()) {
                this.eDt.setVisibility(0);
                if (aVar.aOB() != null && aVar.aOB().size() == 1 && TextUtils.isEmpty(aVar.aOB().get(0).getPicId())) {
                    this.eDt.setData(null);
                } else {
                    this.eDt.setData(aVar.aOB());
                }
            } else if (aVar.aOB() != null && aVar.aOB().size() > 0) {
                if (aVar.aOB().size() == 1 && TextUtils.isEmpty(aVar.aOB().get(0).getPicId())) {
                    this.eDt.setVisibility(8);
                    return;
                }
                this.eDt.setVisibility(0);
                this.eDt.setData(aVar.aOB());
            } else {
                this.eDt.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.eDO = bVar;
    }

    public void c(Object obj, int i) {
        if (this.eDN != null) {
            this.eDN.dismiss();
            this.eDN = null;
        }
        d(obj, i);
        this.eDN.yo();
    }

    public void aNW() {
        this.eDN.dismiss();
    }

    private void d(final Object obj, final int i) {
        if (this.eDN == null) {
            this.eDN = new com.baidu.tbadk.core.dialog.b(this.eDi.getPageContext().getPageActivity());
            this.eDN.dU(this.eDi.getResources().getString(e.j.operation));
            this.eDN.a(new String[]{this.eDi.getResources().getString(e.j.group_info_set_portrait), this.eDi.getResources().getString(e.j.delete), this.eDi.getResources().getString(e.j.cancel)}, new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i2, View view) {
                    a.this.eDO.a(bVar, i2, obj, i);
                }
            });
        }
        this.eDN.d(this.eDi.getPageContext());
    }

    public void onDestory() {
        if (this.eDt != null) {
            this.eDt.onDestory();
        }
        if (this.eDx != null) {
            this.eDx.stopLoad();
            this.eDx.setBackgroundDrawable(null);
            this.eDx.setImageDrawable(null);
        }
        if (this.eDF != null && this.eDG != null) {
            int length = this.eDG.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.eDG[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void ph(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.eDi.getPageContext().getString(e.j.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.eDi.getPageContext().getPageActivity());
            bVar.dU(this.eDi.getPageContext().getString(e.j.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.eDi.getSystemService("clipboard")).setText(str);
                        a.this.eDi.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.eDi.getPageContext());
            bVar.yo();
        }
    }

    public void pi(String str) {
        if (this.eDL == null) {
            pj(str);
        }
        this.eDL.yo();
    }

    private void pj(final String str) {
        if (this.eDL == null) {
            this.eDL = new com.baidu.tbadk.core.dialog.b(this.eDi.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.eDi.getPageContext().getString(e.j.copy_group_number)};
            this.eDL.dU(this.eDi.getPageContext().getString(e.j.operation));
            this.eDL.a(charSequenceArr, new b.InterfaceC0100b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0100b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.eDi.getSystemService("clipboard")).setText(str);
                        a.this.eDi.showToast(e.j.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.eDL.d(this.eDi.getPageContext());
        }
    }

    public void aNX() {
        ColorStateList db = al.db(e.d.cp_cont_i);
        if (db != null) {
            this.eDI.setCompoundDrawablesWithIntrinsicBounds(al.getDrawable(e.f.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.eDI.setTextColor(db);
    }

    public void changeSkinType(int i) {
        this.eDi.getLayoutMode().setNightMode(i == 1);
        this.eDi.getLayoutMode().onModeChanged(this.bsh);
        this.eDi.getLayoutMode().onModeChanged(this.eDC);
        this.eDt.a(i, this.eDi);
        this.mNavigationBar.onChangeSkinType(this.eDi.getPageContext(), i);
        if (this.isMemGroup) {
            al.c(this.eEe, e.d.common_color_10009, 1);
        }
        if (!this.dkf) {
            b(this.eEf, this.eEg);
        }
        if (this.eEh) {
            al.i(this.eDV, e.f.group_info_item);
        } else {
            al.j(this.eDV, e.d.cp_bg_line_d);
        }
    }

    /* renamed from: if  reason: not valid java name */
    public void m18if(boolean z) {
        this.dkf = z;
    }
}
