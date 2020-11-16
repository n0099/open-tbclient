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
/* loaded from: classes22.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int kkD = 0;
    private ScrollView cDk;
    private boolean isMemGroup;
    private View ixE;
    private View jWk;
    private TextView kiy;
    private final GroupInfoActivity kjC;
    private View kjD;
    private ProgressBar kjE;
    private RelativeLayout kjF;
    private TextView kjG;
    private TextView kjH;
    private TextView kjI;
    private TextView kjJ;
    private EllipsizingTextView kjK;
    private TextView kjL;
    private RelativeLayout kjM;
    private PhotoWallView kjN;
    private RelativeLayout kjO;
    private RelativeLayout kjP;
    private LinearLayout kjQ;
    private HeadImageView kjR;
    private TextView kjS;
    private RelativeLayout kjT;
    private com.baidu.tbadk.core.dialog.b kjU;
    private ImageView kjV;
    private final View kjW;
    private b.InterfaceC0574b kjX;
    private RelativeLayout kjY;
    private LinearLayout kjZ;
    private boolean kkA;
    private boolean kkB;
    private boolean kkC;
    private HeadImageView[] kka;
    private LinearLayout kkb;
    private TextView kkc;
    private RelativeLayout kkd;
    private LinearLayout kke;
    private com.baidu.tbadk.core.dialog.b kkf;
    private LinearLayout kkg;
    private i kkh;
    private b kki;
    private TextView kkj;
    private String kkk;
    private ImageView kkl;
    private RelativeLayout kkm;
    private TextView kkn;
    private ImageView kko;
    private RelativeLayout kkp;
    private RelativeLayout kkq;
    private ImageView kkr;
    private ImageView kks;
    private View kkt;
    private TextView kku;
    private TextView kkv;
    private LinearLayout kkw;
    private View kkx;
    private TextView kky;
    private ResponseGroupInfoLocalMessage.a kkz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.kjU = null;
        this.kjX = null;
        this.kka = new HeadImageView[5];
        this.kkk = "";
        this.kkA = true;
        this.isMemGroup = false;
        this.kkB = false;
        this.kkC = false;
        this.kjC = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.kjW = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cDk.setVisibility(4);
        this.kkb.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.kkn.setText(str);
        Mu(str);
    }

    private void Mu(String str) {
        if (str != null) {
            this.kky.setText(str);
        }
    }

    public void Mv(String str) {
        this.kjK.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jWk = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kky = this.mNavigationBar.setTitleText("");
        this.kkx = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kkj = (TextView) this.kkx.findViewById(R.id.right_textview);
        this.kkj.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.kkj, R.color.CAM_X0106, 1);
        this.kkj.setOnClickListener(groupInfoActivity);
        this.kkx.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.kjD = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cDk = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cDk.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.ixE = groupInfoActivity.findViewById(R.id.group_top_view);
        this.ixE.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kjF = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.kjF.setOnClickListener(groupInfoActivity);
        this.kjG = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.kjH = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.kjY = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.kjY.setOnClickListener(groupInfoActivity);
        this.kkg = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.kkl = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.kjI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.kjJ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.kkr = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.kjK = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.kjK.setMaxLines(20);
        this.kjK.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void qN(boolean z) {
                if (z) {
                    a.this.kku.setVisibility(0);
                } else {
                    a.this.kku.setVisibility(8);
                }
            }
        });
        this.kjM = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.kjL = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.kjM.setOnClickListener(groupInfoActivity);
        this.kjR = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.kjR.setAutoChangeStyle(true);
        this.kjR.setIsRound(false);
        this.kiy = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.kjO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.kjO.setOnClickListener(groupInfoActivity);
        this.kjV = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.kkt = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.kjQ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.kjM.setOnClickListener(groupInfoActivity);
        this.kjP = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.kjP.setOnClickListener(groupInfoActivity);
        this.kjS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.kjT = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.kjT.setOnClickListener(groupInfoActivity);
        this.kjZ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.kkb = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.kkw = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.kkc = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.kkw.setOnClickListener(this.kjC);
        this.kkd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.kkd.setOnClickListener(groupInfoActivity);
        this.kke = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.kkm = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.kkm.setOnClickListener(groupInfoActivity);
        this.kkn = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.kko = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.kks = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.kkp = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.kkp.setOnClickListener(groupInfoActivity);
        this.kkp.setLongClickable(true);
        this.kkp.setOnLongClickListener(groupInfoActivity);
        this.kku = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.kku.setClickable(true);
        this.kku.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kjK.setMaxLines(1000);
            }
        });
        this.kkq = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.kkq.setOnLongClickListener(groupInfoActivity);
        this.kkv = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.kjE = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.kjN = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.kjN.setPhotoClickListener(groupInfoActivity);
        this.kjN.setPhotoLongClickListener(groupInfoActivity);
        this.kjN.setVisibility(8);
    }

    public RelativeLayout cSN() {
        return this.kkq;
    }

    public RelativeLayout cSO() {
        return this.kjM;
    }

    public LinearLayout cSP() {
        return this.kjZ;
    }

    public RelativeLayout cSQ() {
        return this.kkd;
    }

    public RelativeLayout cSR() {
        return this.kkp;
    }

    public RelativeLayout cSS() {
        return this.kkm;
    }

    public RelativeLayout cST() {
        return this.kjF;
    }

    public View cSU() {
        return this.kkj;
    }

    public LinearLayout cSV() {
        return this.kkw;
    }

    public RelativeLayout cSW() {
        return this.kjO;
    }

    public RelativeLayout cSX() {
        return this.kjP;
    }

    public RelativeLayout cSY() {
        return this.kjT;
    }

    public View cRH() {
        return this.jWk;
    }

    public void cSZ() {
        this.kjE.setVisibility(8);
    }

    public void cTa() {
        this.kjE.setVisibility(0);
    }

    public void u(boolean z, String str) {
        if (z) {
            this.kjJ.setText(str);
            this.kjY.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.kjY.setVisibility(8);
        } else {
            this.kjJ.setText(str);
            this.kjY.setVisibility(0);
        }
    }

    public void sd(boolean z) {
        if (z) {
            this.kjJ.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.kjY.setVisibility(8);
        }
    }

    public RelativeLayout cTb() {
        return this.kjY;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.kkB = aVar.cTK();
            this.kkC = aVar.cTL();
            this.kkz = aVar;
            this.kkA = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cTF() != null) {
                kkD = aVar.cTF().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.kkg.setVisibility(0);
            this.kkb.setVisibility(0);
            if (aVar.getGroup() != null) {
                Mu(aVar.getGroup().getName());
                this.kjI.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.kjV.setVisibility(0);
                } else {
                    this.kjV.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.kkl.setVisibility(0);
                    this.kjR.setVisibility(8);
                    this.kks.setVisibility(8);
                    this.kkt.setVisibility(8);
                    this.kiy.setText(R.string.group_info_forum_author);
                    this.kjO.setEnabled(false);
                    this.kjV.setVisibility(8);
                } else {
                    this.kkl.setVisibility(8);
                    this.kjR.setVisibility(0);
                    this.kks.setVisibility(0);
                    this.kkt.setVisibility(0);
                    this.kiy.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.kjO.setEnabled(true);
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
                this.kkk = stringBuffer.toString();
                this.kjJ.setText(this.kkk);
                this.kjK.setText(aVar.getGroup().getIntro());
                this.kjS.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.kjR.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.kjM.setVisibility(0);
                    this.kjL.setText(aVar.getGroup().getForumName() + this.kjC.getPageContext().getString(R.string.forum));
                } else {
                    this.kjM.setVisibility(8);
                }
                this.kjQ.removeAllViews();
                boolean cTM = aVar.cTM();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.kky, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.kjC.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.kjQ.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.kjC.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.kjQ.addView(imageView2);
                }
                if (cTM) {
                    this.kkv.setVisibility(0);
                } else {
                    this.kkv.setVisibility(8);
                }
            }
            if (aVar.cTF() != null) {
                this.kjF.setVisibility(0);
                this.kjD.setVisibility(0);
                GroupActivityData cTF = aVar.cTF();
                if (!aVar.cTK()) {
                    if (cTF.getIsEnd() != 1) {
                        this.kjG.setVisibility(4);
                        this.kjH.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.kjF.setVisibility(8);
                        this.kjD.setVisibility(8);
                    }
                } else {
                    this.kjG.setVisibility(0);
                    this.kjH.setText(cTF.getgActivityTitle());
                    if (cTF.getIsEnd() != 1) {
                        this.kjG.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.kjG, R.color.common_color_10171, 1);
                    } else {
                        this.kjG.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.kjG, R.color.common_color_10168, 1);
                    }
                    this.kjH.setText(cTF.getgActivityTitle());
                }
            } else if (aVar.cTL()) {
                this.kjF.setVisibility(0);
                this.kjD.setVisibility(0);
                this.kjG.setVisibility(4);
                this.kjH.setText(R.string.group_info_create_activity);
            } else {
                this.kjF.setVisibility(8);
                this.kjD.setVisibility(8);
            }
            this.kjZ.removeAllViews();
            if (aVar.cTG() != null && aVar.cTG().size() > 0) {
                List<MemberData> cTG = aVar.cTG();
                int size = cTG.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cTG.get(i3);
                    HeadImageView headImageView = this.kka[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.kjC.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.kka[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.kjZ.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cTL()) {
                this.kjY.setEnabled(true);
                this.kkp.setEnabled(true);
                ap.setBackgroundResource(this.kkp, R.drawable.group_info_item);
                this.kkm.setVisibility(0);
                this.kkr.setVisibility(0);
                this.kko.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.kkn.setText(aVar.getGroup().getName());
                }
            } else {
                this.kjY.setEnabled(false);
                this.kkp.setEnabled(true);
                ap.setBackgroundColor(this.kkp, R.color.CAM_X0201);
                this.kko.setVisibility(8);
                this.kkr.setVisibility(8);
                this.kjK.setPadding(0, 0, 0, 0);
            }
            if (aVar.cTK()) {
                this.kke.setVisibility(0);
                this.kkx.setVisibility(0);
                if (this.kjT.getParent() != this.kke) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.kkg.removeView(this.kjT);
                    this.kke.addView(this.kjT, 1);
                }
                cTc();
            } else {
                this.kke.setVisibility(8);
                this.kkx.setVisibility(8);
                if (this.kjT.getParent() != this.kkg) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.kke.removeView(this.kjT);
                    this.kkg.addView(this.kjT, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.kjP.setVisibility(8);
            } else {
                this.kjP.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                sd(aVar.cTL());
            } else {
                u(aVar.cTL(), this.kkk);
            }
            this.cDk.setVisibility(0);
            this.kkb.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (DC(aVar.getGroup().getFlag())) {
                se(z);
            } else {
                cTd();
            }
        }
    }

    public void cTc() {
        this.kkc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.kkc, R.color.CAM_X0101, 1);
        this.kkc.setText(this.kjC.getPageContext().getString(R.string.i_want_talk));
        this.kkw.setEnabled(true);
    }

    private void se(boolean z) {
        this.kkc.setText(this.kjC.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.kkc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kkc, R.color.CAM_X0101, 1);
        } else {
            this.kkc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kkc, R.color.CAM_X0101, 1);
        }
        ap.setBackgroundResource(this.kkw, R.drawable.btn_blue_bg);
        this.kkw.setEnabled(true);
    }

    private boolean DC(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cTd() {
        this.kkc.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.kkc.setText(this.kjC.getPageContext().getString(R.string.group_info_refuse_join));
        this.kkc.setTextColor(this.kjC.getResources().getColorStateList(R.color.CAM_X0101));
        ap.setBackgroundResource(this.kkw, R.drawable.btn_app_download_d);
        this.kkw.setEnabled(false);
    }

    public void Mw(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.kjZ.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.kjZ.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.kjZ.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.kjN.setIsManager(aVar.cTL());
            if (aVar.cTL()) {
                this.kjN.setVisibility(0);
                if (aVar.cTH() != null && aVar.cTH().size() == 1 && TextUtils.isEmpty(aVar.cTH().get(0).getPicId())) {
                    this.kjN.setData(null);
                } else {
                    this.kjN.setData(aVar.cTH());
                }
            } else if (aVar.cTH() != null && aVar.cTH().size() > 0) {
                if (aVar.cTH().size() == 1 && TextUtils.isEmpty(aVar.cTH().get(0).getPicId())) {
                    this.kjN.setVisibility(8);
                    return;
                }
                this.kjN.setVisibility(0);
                this.kjN.setData(aVar.cTH());
            } else {
                this.kjN.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.kki = bVar;
    }

    public void d(Object obj, int i) {
        if (this.kkh != null) {
            this.kkh.dismiss();
            this.kkh = null;
        }
        e(obj, i);
        this.kkh.PA();
    }

    private void e(final Object obj, final int i) {
        if (this.kkh == null) {
            this.kkh = new i(this.kjC.getPageContext());
            this.kkh.a(null, new String[]{this.kjC.getResources().getString(R.string.group_info_set_portrait), this.kjC.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.kkh != null && a.this.kkh.isShowing()) {
                        a.this.kki.a(a.this.kkh, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.kjN != null) {
            this.kjN.onDestory();
        }
        if (this.kjR != null) {
            this.kjR.stopLoad();
            this.kjR.setBackgroundDrawable(null);
            this.kjR.setImageDrawable(null);
        }
        if (this.kjZ != null && this.kka != null) {
            int length = this.kka.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.kka[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Mx(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.kjC.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.kjC.getPageContext().getPageActivity());
            bVar.AK(this.kjC.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0574b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.kjC.getSystemService("clipboard")).setText(str);
                        a.this.kjC.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.kjC.getPageContext());
            bVar.boi();
        }
    }

    public void My(String str) {
        if (this.kkf == null) {
            Mz(str);
        }
        this.kkf.boi();
    }

    private void Mz(final String str) {
        if (this.kkf == null) {
            this.kkf = new com.baidu.tbadk.core.dialog.b(this.kjC.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.kjC.getPageContext().getString(R.string.copy_group_number)};
            this.kkf.AK(this.kjC.getPageContext().getString(R.string.operation));
            this.kkf.a(charSequenceArr, new b.InterfaceC0574b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0574b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.kjC.getSystemService("clipboard")).setText(str);
                        a.this.kjC.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.kkf.d(this.kjC.getPageContext());
        }
    }

    public void cTe() {
        ColorStateList colorList = ap.getColorList(R.color.CAM_X0101);
        if (colorList != null) {
            this.kkc.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.kkc.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.kjC.getLayoutMode().setNightMode(i == 1);
        this.kjC.getLayoutMode().onModeChanged(this.mContainer);
        this.kjC.getLayoutMode().onModeChanged(this.kjW);
        this.kjN.a(i, this.kjC);
        this.mNavigationBar.onChangeSkinType(this.kjC.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.kky, R.color.common_color_10009, 1);
        }
        if (!this.kkB) {
            b(this.kkz, this.kkA);
        }
        if (this.kkC) {
            ap.setBackgroundResource(this.kkp, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.kkp, R.color.CAM_X0201);
        }
    }

    public void sf(boolean z) {
        this.kkB = z;
    }
}
