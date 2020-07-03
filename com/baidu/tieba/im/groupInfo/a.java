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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.group.EllipsizingTextView;
import com.baidu.tieba.im.data.GroupActivityData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import java.util.List;
/* loaded from: classes10.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int iWF = 0;
    private ScrollView bVE;
    private View hpn;
    private View iKr;
    private TextView iUA;
    private final GroupInfoActivity iVE;
    private View iVF;
    private ProgressBar iVG;
    private RelativeLayout iVH;
    private TextView iVI;
    private TextView iVJ;
    private TextView iVK;
    private TextView iVL;
    private EllipsizingTextView iVM;
    private TextView iVN;
    private RelativeLayout iVO;
    private PhotoWallView iVP;
    private RelativeLayout iVQ;
    private RelativeLayout iVR;
    private LinearLayout iVS;
    private HeadImageView iVT;
    private TextView iVU;
    private RelativeLayout iVV;
    private com.baidu.tbadk.core.dialog.b iVW;
    private ImageView iVX;
    private final View iVY;
    private b.a iVZ;
    private TextView iWA;
    private ResponseGroupInfoLocalMessage.a iWB;
    private boolean iWC;
    private boolean iWD;
    private boolean iWE;
    private RelativeLayout iWa;
    private LinearLayout iWb;
    private HeadImageView[] iWc;
    private LinearLayout iWd;
    private TextView iWe;
    private RelativeLayout iWf;
    private LinearLayout iWg;
    private com.baidu.tbadk.core.dialog.b iWh;
    private LinearLayout iWi;
    private i iWj;
    private b iWk;
    private TextView iWl;
    private String iWm;
    private ImageView iWn;
    private RelativeLayout iWo;
    private TextView iWp;
    private ImageView iWq;
    private RelativeLayout iWr;
    private RelativeLayout iWs;
    private ImageView iWt;
    private ImageView iWu;
    private View iWv;
    private TextView iWw;
    private TextView iWx;
    private LinearLayout iWy;
    private View iWz;
    private boolean isMemGroup;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.iVW = null;
        this.iVZ = null;
        this.iWc = new HeadImageView[5];
        this.iWm = "";
        this.iWC = true;
        this.isMemGroup = false;
        this.iWD = false;
        this.iWE = false;
        this.iVE = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.iVY = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.bVE.setVisibility(4);
        this.iWd.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.iWp.setText(str);
        Hf(str);
    }

    private void Hf(String str) {
        if (str != null) {
            this.iWA.setText(str);
        }
    }

    public void Hg(String str) {
        this.iVM.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.iKr = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.iWA = this.mNavigationBar.setTitleText("");
        this.iWz = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.iWl = (TextView) this.iWz.findViewById(R.id.right_textview);
        this.iWl.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        an.setViewTextColor(this.iWl, R.color.cp_cont_f, 1);
        this.iWl.setOnClickListener(groupInfoActivity);
        this.iWz.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.iVF = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.bVE = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.bVE.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.hpn = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hpn.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.iVH = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.iVH.setOnClickListener(groupInfoActivity);
        this.iVI = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.iVJ = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.iWa = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.iWa.setOnClickListener(groupInfoActivity);
        this.iWi = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.iWn = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.iVK = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.iVL = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.iWt = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.iVM = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.iVM.setMaxLines(20);
        this.iVM.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void om(boolean z) {
                if (z) {
                    a.this.iWw.setVisibility(0);
                } else {
                    a.this.iWw.setVisibility(8);
                }
            }
        });
        this.iVO = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.iVN = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.iVO.setOnClickListener(groupInfoActivity);
        this.iVT = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.iVT.setAutoChangeStyle(true);
        this.iVT.setIsRound(false);
        this.iUA = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.iVQ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.iVQ.setOnClickListener(groupInfoActivity);
        this.iVX = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.iWv = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.iVS = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.iVO.setOnClickListener(groupInfoActivity);
        this.iVR = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.iVR.setOnClickListener(groupInfoActivity);
        this.iVU = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.iVV = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.iVV.setOnClickListener(groupInfoActivity);
        this.iWb = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.iWd = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.iWy = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.iWe = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.iWy.setOnClickListener(this.iVE);
        this.iWf = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.iWf.setOnClickListener(groupInfoActivity);
        this.iWg = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.iWo = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.iWo.setOnClickListener(groupInfoActivity);
        this.iWp = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.iWq = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.iWu = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.iWr = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.iWr.setOnClickListener(groupInfoActivity);
        this.iWr.setLongClickable(true);
        this.iWr.setOnLongClickListener(groupInfoActivity);
        this.iWw = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.iWw.setClickable(true);
        this.iWw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.iVM.setMaxLines(1000);
            }
        });
        this.iWs = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.iWs.setOnLongClickListener(groupInfoActivity);
        this.iWx = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.iVG = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.iVP = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.iVP.setPhotoClickListener(groupInfoActivity);
        this.iVP.setPhotoLongClickListener(groupInfoActivity);
        this.iVP.setVisibility(8);
    }

    public RelativeLayout crt() {
        return this.iWs;
    }

    public RelativeLayout cru() {
        return this.iVO;
    }

    public LinearLayout crv() {
        return this.iWb;
    }

    public RelativeLayout crw() {
        return this.iWf;
    }

    public RelativeLayout crx() {
        return this.iWr;
    }

    public RelativeLayout cry() {
        return this.iWo;
    }

    public RelativeLayout crz() {
        return this.iVH;
    }

    public View crA() {
        return this.iWl;
    }

    public LinearLayout crB() {
        return this.iWy;
    }

    public RelativeLayout crC() {
        return this.iVQ;
    }

    public RelativeLayout crD() {
        return this.iVR;
    }

    public RelativeLayout crE() {
        return this.iVV;
    }

    public View cqn() {
        return this.iKr;
    }

    public void crF() {
        this.iVG.setVisibility(8);
    }

    public void crG() {
        this.iVG.setVisibility(0);
    }

    public void q(boolean z, String str) {
        if (z) {
            this.iVL.setText(str);
            this.iWa.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.iWa.setVisibility(8);
        } else {
            this.iVL.setText(str);
            this.iWa.setVisibility(0);
        }
    }

    public void pw(boolean z) {
        if (z) {
            this.iVL.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.iWa.setVisibility(8);
        }
    }

    public RelativeLayout crH() {
        return this.iWa;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.iWD = aVar.csq();
            this.iWE = aVar.csr();
            this.iWB = aVar;
            this.iWC = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.csl() != null) {
                iWF = aVar.csl().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.iWi.setVisibility(0);
            this.iWd.setVisibility(0);
            if (aVar.getGroup() != null) {
                Hf(aVar.getGroup().getName());
                this.iVK.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.iVX.setVisibility(0);
                } else {
                    this.iVX.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.iWn.setVisibility(0);
                    this.iVT.setVisibility(8);
                    this.iWu.setVisibility(8);
                    this.iWv.setVisibility(8);
                    this.iUA.setText(R.string.group_info_forum_author);
                    this.iVQ.setEnabled(false);
                    this.iVX.setVisibility(8);
                } else {
                    this.iWn.setVisibility(8);
                    this.iVT.setVisibility(0);
                    this.iWu.setVisibility(0);
                    this.iWv.setVisibility(0);
                    this.iUA.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.iVQ.setEnabled(true);
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
                this.iWm = stringBuffer.toString();
                this.iVL.setText(this.iWm);
                this.iVM.setText(aVar.getGroup().getIntro());
                this.iVU.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.iVT.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.iVO.setVisibility(0);
                    this.iVN.setText(aVar.getGroup().getForumName() + this.iVE.getPageContext().getString(R.string.forum));
                } else {
                    this.iVO.setVisibility(8);
                }
                this.iVS.removeAllViews();
                boolean css = aVar.css();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    an.setViewTextColor(this.iWA, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.iVE.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            an.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            an.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.iVS.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.iVE.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        an.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        an.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.iVS.addView(imageView2);
                }
                if (css) {
                    this.iWx.setVisibility(0);
                } else {
                    this.iWx.setVisibility(8);
                }
            }
            if (aVar.csl() != null) {
                this.iVH.setVisibility(0);
                this.iVF.setVisibility(0);
                GroupActivityData csl = aVar.csl();
                if (!aVar.csq()) {
                    if (csl.getIsEnd() != 1) {
                        this.iVI.setVisibility(4);
                        this.iVJ.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.iVH.setVisibility(8);
                        this.iVF.setVisibility(8);
                    }
                } else {
                    this.iVI.setVisibility(0);
                    this.iVJ.setText(csl.getgActivityTitle());
                    if (csl.getIsEnd() != 1) {
                        this.iVI.setText(R.string.group_info_activity_doing);
                        an.setViewTextColor(this.iVI, R.color.common_color_10171, 1);
                    } else {
                        this.iVI.setText(R.string.group_activity_end);
                        an.setViewTextColor(this.iVI, R.color.common_color_10168, 1);
                    }
                    this.iVJ.setText(csl.getgActivityTitle());
                }
            } else if (aVar.csr()) {
                this.iVH.setVisibility(0);
                this.iVF.setVisibility(0);
                this.iVI.setVisibility(4);
                this.iVJ.setText(R.string.group_info_create_activity);
            } else {
                this.iVH.setVisibility(8);
                this.iVF.setVisibility(8);
            }
            this.iWb.removeAllViews();
            if (aVar.csm() != null && aVar.csm().size() > 0) {
                List<MemberData> csm = aVar.csm();
                int size = csm.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = csm.get(i3);
                    HeadImageView headImageView = this.iWc[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.iVE.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.iWc[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.iWb.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.csr()) {
                this.iWa.setEnabled(true);
                this.iWr.setEnabled(true);
                an.setBackgroundResource(this.iWr, R.drawable.group_info_item);
                this.iWo.setVisibility(0);
                this.iWt.setVisibility(0);
                this.iWq.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.iWp.setText(aVar.getGroup().getName());
                }
            } else {
                this.iWa.setEnabled(false);
                this.iWr.setEnabled(true);
                an.setBackgroundColor(this.iWr, R.color.cp_bg_line_d);
                this.iWq.setVisibility(8);
                this.iWt.setVisibility(8);
                this.iVM.setPadding(0, 0, 0, 0);
            }
            if (aVar.csq()) {
                this.iWg.setVisibility(0);
                this.iWz.setVisibility(0);
                if (this.iVV.getParent() != this.iWg) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.iWi.removeView(this.iVV);
                    this.iWg.addView(this.iVV, 1);
                }
                crI();
            } else {
                this.iWg.setVisibility(8);
                this.iWz.setVisibility(8);
                if (this.iVV.getParent() != this.iWi) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.iWg.removeView(this.iVV);
                    this.iWi.addView(this.iVV, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.iVR.setVisibility(8);
            } else {
                this.iVR.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                pw(aVar.csr());
            } else {
                q(aVar.csr(), this.iWm);
            }
            this.bVE.setVisibility(0);
            this.iWd.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (yA(aVar.getGroup().getFlag())) {
                px(z);
            } else {
                crJ();
            }
        }
    }

    public void crI() {
        this.iWe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        an.setViewTextColor(this.iWe, R.color.cp_cont_a, 1);
        this.iWe.setText(this.iVE.getPageContext().getString(R.string.i_want_talk));
        this.iWy.setEnabled(true);
    }

    private void px(boolean z) {
        this.iWe.setText(this.iVE.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.iWe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(this.iWe, R.color.cp_cont_a, 1);
        } else {
            this.iWe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            an.setViewTextColor(this.iWe, R.color.cp_cont_a, 1);
        }
        an.setBackgroundResource(this.iWy, R.drawable.btn_blue_bg);
        this.iWy.setEnabled(true);
    }

    private boolean yA(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void crJ() {
        this.iWe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.iWe.setText(this.iVE.getPageContext().getString(R.string.group_info_refuse_join));
        this.iWe.setTextColor(this.iVE.getResources().getColorStateList(R.color.cp_cont_a));
        an.setBackgroundResource(this.iWy, R.drawable.btn_app_download_d);
        this.iWy.setEnabled(false);
    }

    public void Hh(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.iWb.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.iWb.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.iWb.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.iVP.setIsManager(aVar.csr());
            if (aVar.csr()) {
                this.iVP.setVisibility(0);
                if (aVar.csn() != null && aVar.csn().size() == 1 && TextUtils.isEmpty(aVar.csn().get(0).getPicId())) {
                    this.iVP.setData(null);
                } else {
                    this.iVP.setData(aVar.csn());
                }
            } else if (aVar.csn() != null && aVar.csn().size() > 0) {
                if (aVar.csn().size() == 1 && TextUtils.isEmpty(aVar.csn().get(0).getPicId())) {
                    this.iVP.setVisibility(8);
                    return;
                }
                this.iVP.setVisibility(0);
                this.iVP.setData(aVar.csn());
            } else {
                this.iVP.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.iWk = bVar;
    }

    public void d(Object obj, int i) {
        if (this.iWj != null) {
            this.iWj.dismiss();
            this.iWj = null;
        }
        e(obj, i);
        this.iWj.showDialog();
    }

    private void e(final Object obj, final int i) {
        if (this.iWj == null) {
            this.iWj = new i(this.iVE.getPageContext());
            this.iWj.a(null, new String[]{this.iVE.getResources().getString(R.string.group_info_set_portrait), this.iVE.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.iWj != null && a.this.iWj.isShowing()) {
                        a.this.iWk.a(a.this.iWj, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.iVP != null) {
            this.iVP.onDestory();
        }
        if (this.iVT != null) {
            this.iVT.stopLoad();
            this.iVT.setBackgroundDrawable(null);
            this.iVT.setImageDrawable(null);
        }
        if (this.iWb != null && this.iWc != null) {
            int length = this.iWc.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.iWc[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void Hi(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.iVE.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.iVE.getPageContext().getPageActivity());
            bVar.wf(this.iVE.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.iVE.getSystemService("clipboard")).setText(str);
                        a.this.iVE.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.iVE.getPageContext());
            bVar.aUO();
        }
    }

    public void Hj(String str) {
        if (this.iWh == null) {
            Hk(str);
        }
        this.iWh.aUO();
    }

    private void Hk(final String str) {
        if (this.iWh == null) {
            this.iWh = new com.baidu.tbadk.core.dialog.b(this.iVE.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.iVE.getPageContext().getString(R.string.copy_group_number)};
            this.iWh.wf(this.iVE.getPageContext().getString(R.string.operation));
            this.iWh.a(charSequenceArr, new b.a() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.a
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.iVE.getSystemService("clipboard")).setText(str);
                        a.this.iVE.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.iWh.d(this.iVE.getPageContext());
        }
    }

    public void crK() {
        ColorStateList colorList = an.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.iWe.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.iWe.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.iVE.getLayoutMode().setNightMode(i == 1);
        this.iVE.getLayoutMode().onModeChanged(this.mContainer);
        this.iVE.getLayoutMode().onModeChanged(this.iVY);
        this.iVP.a(i, this.iVE);
        this.mNavigationBar.onChangeSkinType(this.iVE.getPageContext(), i);
        if (this.isMemGroup) {
            an.setViewTextColor(this.iWA, R.color.common_color_10009, 1);
        }
        if (!this.iWD) {
            b(this.iWB, this.iWC);
        }
        if (this.iWE) {
            an.setBackgroundResource(this.iWr, R.drawable.group_info_item);
        } else {
            an.setBackgroundColor(this.iWr, R.color.cp_bg_line_d);
        }
    }

    public void py(boolean z) {
        this.iWD = z;
    }
}
