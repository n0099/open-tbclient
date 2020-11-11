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
    public static int kjT = 0;
    private ScrollView cEU;
    private boolean isMemGroup;
    private View iwP;
    private View jVA;
    private TextView khN;
    private final GroupInfoActivity kiS;
    private View kiT;
    private ProgressBar kiU;
    private RelativeLayout kiV;
    private TextView kiW;
    private TextView kiX;
    private TextView kiY;
    private TextView kiZ;
    private String kjA;
    private ImageView kjB;
    private RelativeLayout kjC;
    private TextView kjD;
    private ImageView kjE;
    private RelativeLayout kjF;
    private RelativeLayout kjG;
    private ImageView kjH;
    private ImageView kjI;
    private View kjJ;
    private TextView kjK;
    private TextView kjL;
    private LinearLayout kjM;
    private View kjN;
    private TextView kjO;
    private ResponseGroupInfoLocalMessage.a kjP;
    private boolean kjQ;
    private boolean kjR;
    private boolean kjS;
    private EllipsizingTextView kja;
    private TextView kjb;
    private RelativeLayout kjc;
    private PhotoWallView kjd;
    private RelativeLayout kje;
    private RelativeLayout kjf;
    private LinearLayout kjg;
    private HeadImageView kjh;
    private TextView kji;
    private RelativeLayout kjj;
    private com.baidu.tbadk.core.dialog.b kjk;
    private ImageView kjl;
    private final View kjm;
    private b.InterfaceC0576b kjn;
    private RelativeLayout kjo;
    private LinearLayout kjp;
    private HeadImageView[] kjq;
    private LinearLayout kjr;
    private TextView kjs;
    private RelativeLayout kjt;
    private LinearLayout kju;
    private com.baidu.tbadk.core.dialog.b kjv;
    private LinearLayout kjw;
    private i kjx;
    private b kjy;
    private TextView kjz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.kjk = null;
        this.kjn = null;
        this.kjq = new HeadImageView[5];
        this.kjA = "";
        this.kjQ = true;
        this.isMemGroup = false;
        this.kjR = false;
        this.kjS = false;
        this.kiS = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.kjm = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cEU.setVisibility(4);
        this.kjr.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.kjD.setText(str);
        MT(str);
    }

    private void MT(String str) {
        if (str != null) {
            this.kjO.setText(str);
        }
    }

    public void MU(String str) {
        this.kja.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jVA = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.kjO = this.mNavigationBar.setTitleText("");
        this.kjN = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.kjz = (TextView) this.kjN.findViewById(R.id.right_textview);
        this.kjz.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.kjz, R.color.cp_cont_f, 1);
        this.kjz.setOnClickListener(groupInfoActivity);
        this.kjN.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.kiT = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cEU = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cEU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.iwP = groupInfoActivity.findViewById(R.id.group_top_view);
        this.iwP.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.kiV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.kiV.setOnClickListener(groupInfoActivity);
        this.kiW = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.kiX = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.kjo = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.kjo.setOnClickListener(groupInfoActivity);
        this.kjw = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.kjB = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.kiY = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.kiZ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.kjH = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.kja = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.kja.setMaxLines(20);
        this.kja.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void qK(boolean z) {
                if (z) {
                    a.this.kjK.setVisibility(0);
                } else {
                    a.this.kjK.setVisibility(8);
                }
            }
        });
        this.kjc = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.kjb = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.kjc.setOnClickListener(groupInfoActivity);
        this.kjh = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.kjh.setAutoChangeStyle(true);
        this.kjh.setIsRound(false);
        this.khN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.kje = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.kje.setOnClickListener(groupInfoActivity);
        this.kjl = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.kjJ = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.kjg = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.kjc.setOnClickListener(groupInfoActivity);
        this.kjf = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.kjf.setOnClickListener(groupInfoActivity);
        this.kji = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.kjj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.kjj.setOnClickListener(groupInfoActivity);
        this.kjp = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.kjr = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.kjM = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.kjs = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.kjM.setOnClickListener(this.kiS);
        this.kjt = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.kjt.setOnClickListener(groupInfoActivity);
        this.kju = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.kjC = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.kjC.setOnClickListener(groupInfoActivity);
        this.kjD = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.kjE = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.kjI = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.kjF = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.kjF.setOnClickListener(groupInfoActivity);
        this.kjF.setLongClickable(true);
        this.kjF.setOnLongClickListener(groupInfoActivity);
        this.kjK = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.kjK.setClickable(true);
        this.kjK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.kja.setMaxLines(1000);
            }
        });
        this.kjG = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.kjG.setOnLongClickListener(groupInfoActivity);
        this.kjL = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.kiU = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.kjd = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.kjd.setPhotoClickListener(groupInfoActivity);
        this.kjd.setPhotoLongClickListener(groupInfoActivity);
        this.kjd.setVisibility(8);
    }

    public RelativeLayout cTh() {
        return this.kjG;
    }

    public RelativeLayout cTi() {
        return this.kjc;
    }

    public LinearLayout cTj() {
        return this.kjp;
    }

    public RelativeLayout cTk() {
        return this.kjt;
    }

    public RelativeLayout cTl() {
        return this.kjF;
    }

    public RelativeLayout cTm() {
        return this.kjC;
    }

    public RelativeLayout cTn() {
        return this.kiV;
    }

    public View cTo() {
        return this.kjz;
    }

    public LinearLayout cTp() {
        return this.kjM;
    }

    public RelativeLayout cTq() {
        return this.kje;
    }

    public RelativeLayout cTr() {
        return this.kjf;
    }

    public RelativeLayout cTs() {
        return this.kjj;
    }

    public View cSb() {
        return this.jVA;
    }

    public void cTt() {
        this.kiU.setVisibility(8);
    }

    public void cTu() {
        this.kiU.setVisibility(0);
    }

    public void t(boolean z, String str) {
        if (z) {
            this.kiZ.setText(str);
            this.kjo.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.kjo.setVisibility(8);
        } else {
            this.kiZ.setText(str);
            this.kjo.setVisibility(0);
        }
    }

    public void sa(boolean z) {
        if (z) {
            this.kiZ.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.kjo.setVisibility(8);
        }
    }

    public RelativeLayout cTv() {
        return this.kjo;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.kjR = aVar.cUe();
            this.kjS = aVar.cUf();
            this.kjP = aVar;
            this.kjQ = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cTZ() != null) {
                kjT = aVar.cTZ().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.kjw.setVisibility(0);
            this.kjr.setVisibility(0);
            if (aVar.getGroup() != null) {
                MT(aVar.getGroup().getName());
                this.kiY.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.kjl.setVisibility(0);
                } else {
                    this.kjl.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.kjB.setVisibility(0);
                    this.kjh.setVisibility(8);
                    this.kjI.setVisibility(8);
                    this.kjJ.setVisibility(8);
                    this.khN.setText(R.string.group_info_forum_author);
                    this.kje.setEnabled(false);
                    this.kjl.setVisibility(8);
                } else {
                    this.kjB.setVisibility(8);
                    this.kjh.setVisibility(0);
                    this.kjI.setVisibility(0);
                    this.kjJ.setVisibility(0);
                    this.khN.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.kje.setEnabled(true);
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
                this.kjA = stringBuffer.toString();
                this.kiZ.setText(this.kjA);
                this.kja.setText(aVar.getGroup().getIntro());
                this.kji.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.kjh.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.kjc.setVisibility(0);
                    this.kjb.setText(aVar.getGroup().getForumName() + this.kiS.getPageContext().getString(R.string.forum));
                } else {
                    this.kjc.setVisibility(8);
                }
                this.kjg.removeAllViews();
                boolean cUg = aVar.cUg();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.kjO, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.kiS.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.kjg.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.kiS.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.kjg.addView(imageView2);
                }
                if (cUg) {
                    this.kjL.setVisibility(0);
                } else {
                    this.kjL.setVisibility(8);
                }
            }
            if (aVar.cTZ() != null) {
                this.kiV.setVisibility(0);
                this.kiT.setVisibility(0);
                GroupActivityData cTZ = aVar.cTZ();
                if (!aVar.cUe()) {
                    if (cTZ.getIsEnd() != 1) {
                        this.kiW.setVisibility(4);
                        this.kiX.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.kiV.setVisibility(8);
                        this.kiT.setVisibility(8);
                    }
                } else {
                    this.kiW.setVisibility(0);
                    this.kiX.setText(cTZ.getgActivityTitle());
                    if (cTZ.getIsEnd() != 1) {
                        this.kiW.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.kiW, R.color.common_color_10171, 1);
                    } else {
                        this.kiW.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.kiW, R.color.common_color_10168, 1);
                    }
                    this.kiX.setText(cTZ.getgActivityTitle());
                }
            } else if (aVar.cUf()) {
                this.kiV.setVisibility(0);
                this.kiT.setVisibility(0);
                this.kiW.setVisibility(4);
                this.kiX.setText(R.string.group_info_create_activity);
            } else {
                this.kiV.setVisibility(8);
                this.kiT.setVisibility(8);
            }
            this.kjp.removeAllViews();
            if (aVar.cUa() != null && aVar.cUa().size() > 0) {
                List<MemberData> cUa = aVar.cUa();
                int size = cUa.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cUa.get(i3);
                    HeadImageView headImageView = this.kjq[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.kiS.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.kjq[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.kjp.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cUf()) {
                this.kjo.setEnabled(true);
                this.kjF.setEnabled(true);
                ap.setBackgroundResource(this.kjF, R.drawable.group_info_item);
                this.kjC.setVisibility(0);
                this.kjH.setVisibility(0);
                this.kjE.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.kjD.setText(aVar.getGroup().getName());
                }
            } else {
                this.kjo.setEnabled(false);
                this.kjF.setEnabled(true);
                ap.setBackgroundColor(this.kjF, R.color.cp_bg_line_d);
                this.kjE.setVisibility(8);
                this.kjH.setVisibility(8);
                this.kja.setPadding(0, 0, 0, 0);
            }
            if (aVar.cUe()) {
                this.kju.setVisibility(0);
                this.kjN.setVisibility(0);
                if (this.kjj.getParent() != this.kju) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.kjw.removeView(this.kjj);
                    this.kju.addView(this.kjj, 1);
                }
                cTw();
            } else {
                this.kju.setVisibility(8);
                this.kjN.setVisibility(8);
                if (this.kjj.getParent() != this.kjw) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.kju.removeView(this.kjj);
                    this.kjw.addView(this.kjj, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.kjf.setVisibility(8);
            } else {
                this.kjf.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                sa(aVar.cUf());
            } else {
                t(aVar.cUf(), this.kjA);
            }
            this.cEU.setVisibility(0);
            this.kjr.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (De(aVar.getGroup().getFlag())) {
                sb(z);
            } else {
                cTx();
            }
        }
    }

    public void cTw() {
        this.kjs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.kjs, R.color.cp_cont_a, 1);
        this.kjs.setText(this.kiS.getPageContext().getString(R.string.i_want_talk));
        this.kjM.setEnabled(true);
    }

    private void sb(boolean z) {
        this.kjs.setText(this.kiS.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.kjs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kjs, R.color.cp_cont_a, 1);
        } else {
            this.kjs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.kjs, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.kjM, R.drawable.btn_blue_bg);
        this.kjM.setEnabled(true);
    }

    private boolean De(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cTx() {
        this.kjs.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.kjs.setText(this.kiS.getPageContext().getString(R.string.group_info_refuse_join));
        this.kjs.setTextColor(this.kiS.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.kjM, R.drawable.btn_app_download_d);
        this.kjM.setEnabled(false);
    }

    public void MV(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.kjp.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.kjp.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.kjp.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.kjd.setIsManager(aVar.cUf());
            if (aVar.cUf()) {
                this.kjd.setVisibility(0);
                if (aVar.cUb() != null && aVar.cUb().size() == 1 && TextUtils.isEmpty(aVar.cUb().get(0).getPicId())) {
                    this.kjd.setData(null);
                } else {
                    this.kjd.setData(aVar.cUb());
                }
            } else if (aVar.cUb() != null && aVar.cUb().size() > 0) {
                if (aVar.cUb().size() == 1 && TextUtils.isEmpty(aVar.cUb().get(0).getPicId())) {
                    this.kjd.setVisibility(8);
                    return;
                }
                this.kjd.setVisibility(0);
                this.kjd.setData(aVar.cUb());
            } else {
                this.kjd.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.kjy = bVar;
    }

    public void d(Object obj, int i) {
        if (this.kjx != null) {
            this.kjx.dismiss();
            this.kjx = null;
        }
        e(obj, i);
        this.kjx.Qj();
    }

    private void e(final Object obj, final int i) {
        if (this.kjx == null) {
            this.kjx = new i(this.kiS.getPageContext());
            this.kjx.a(null, new String[]{this.kiS.getResources().getString(R.string.group_info_set_portrait), this.kiS.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.kjx != null && a.this.kjx.isShowing()) {
                        a.this.kjy.a(a.this.kjx, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.kjd != null) {
            this.kjd.onDestory();
        }
        if (this.kjh != null) {
            this.kjh.stopLoad();
            this.kjh.setBackgroundDrawable(null);
            this.kjh.setImageDrawable(null);
        }
        if (this.kjp != null && this.kjq != null) {
            int length = this.kjq.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.kjq[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void MW(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.kiS.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.kiS.getPageContext().getPageActivity());
            bVar.Bp(this.kiS.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0576b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.kiS.getSystemService("clipboard")).setText(str);
                        a.this.kiS.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.kiS.getPageContext());
            bVar.bpe();
        }
    }

    public void MX(String str) {
        if (this.kjv == null) {
            MY(str);
        }
        this.kjv.bpe();
    }

    private void MY(final String str) {
        if (this.kjv == null) {
            this.kjv = new com.baidu.tbadk.core.dialog.b(this.kiS.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.kiS.getPageContext().getString(R.string.copy_group_number)};
            this.kjv.Bp(this.kiS.getPageContext().getString(R.string.operation));
            this.kjv.a(charSequenceArr, new b.InterfaceC0576b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0576b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.kiS.getSystemService("clipboard")).setText(str);
                        a.this.kiS.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.kjv.d(this.kiS.getPageContext());
        }
    }

    public void cTy() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.kjs.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.kjs.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.kiS.getLayoutMode().setNightMode(i == 1);
        this.kiS.getLayoutMode().onModeChanged(this.mContainer);
        this.kiS.getLayoutMode().onModeChanged(this.kjm);
        this.kjd.a(i, this.kiS);
        this.mNavigationBar.onChangeSkinType(this.kiS.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.kjO, R.color.common_color_10009, 1);
        }
        if (!this.kjR) {
            b(this.kjP, this.kjQ);
        }
        if (this.kjS) {
            ap.setBackgroundResource(this.kjF, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.kjF, R.color.cp_bg_line_d);
        }
    }

    public void sc(boolean z) {
        this.kjR = z;
    }
}
