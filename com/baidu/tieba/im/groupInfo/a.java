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
/* loaded from: classes17.dex */
public class a extends com.baidu.adp.base.c<GroupInfoActivity> {
    public static long gid = 0;
    public static int jtX = 0;
    private ScrollView cch;
    private View hIu;
    private boolean isMemGroup;
    private View jfB;
    private TextView jrS;
    private final GroupInfoActivity jsW;
    private View jsX;
    private ProgressBar jsY;
    private RelativeLayout jsZ;
    private LinearLayout jtA;
    private i jtB;
    private b jtC;
    private TextView jtD;
    private String jtE;
    private ImageView jtF;
    private RelativeLayout jtG;
    private TextView jtH;
    private ImageView jtI;
    private RelativeLayout jtJ;
    private RelativeLayout jtK;
    private ImageView jtL;
    private ImageView jtM;
    private View jtN;
    private TextView jtO;
    private TextView jtP;
    private LinearLayout jtQ;
    private View jtR;
    private TextView jtS;
    private ResponseGroupInfoLocalMessage.a jtT;
    private boolean jtU;
    private boolean jtV;
    private boolean jtW;
    private TextView jta;
    private TextView jtb;
    private TextView jtc;
    private TextView jtd;
    private EllipsizingTextView jte;
    private TextView jtf;
    private RelativeLayout jtg;
    private PhotoWallView jth;
    private RelativeLayout jti;
    private RelativeLayout jtj;
    private LinearLayout jtk;
    private HeadImageView jtl;
    private TextView jtm;
    private RelativeLayout jtn;
    private com.baidu.tbadk.core.dialog.b jto;
    private ImageView jtp;
    private final View jtq;
    private b.InterfaceC0538b jtr;
    private RelativeLayout jts;
    private LinearLayout jtt;
    private HeadImageView[] jtu;
    private LinearLayout jtv;
    private TextView jtw;
    private RelativeLayout jtx;
    private LinearLayout jty;
    private com.baidu.tbadk.core.dialog.b jtz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jto = null;
        this.jtr = null;
        this.jtu = new HeadImageView[5];
        this.jtE = "";
        this.jtU = true;
        this.isMemGroup = false;
        this.jtV = false;
        this.jtW = false;
        this.jsW = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jtq = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.cch.setVisibility(4);
        this.jtv.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jtH.setText(str);
        KN(str);
    }

    private void KN(String str) {
        if (str != null) {
            this.jtS.setText(str);
        }
    }

    public void KO(String str) {
        this.jte.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jfB = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jtS = this.mNavigationBar.setTitleText("");
        this.jtR = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jtD = (TextView) this.jtR.findViewById(R.id.right_textview);
        this.jtD.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.jtD, R.color.cp_cont_f, 1);
        this.jtD.setOnClickListener(groupInfoActivity);
        this.jtR.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jsX = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.cch = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.cch.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.hIu = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hIu.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jsZ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jsZ.setOnClickListener(groupInfoActivity);
        this.jta = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jtb = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jts = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jts.setOnClickListener(groupInfoActivity);
        this.jtA = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jtF = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jtc = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jtd = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jtL = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jte = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jte.setMaxLines(20);
        this.jte.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void py(boolean z) {
                if (z) {
                    a.this.jtO.setVisibility(0);
                } else {
                    a.this.jtO.setVisibility(8);
                }
            }
        });
        this.jtg = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jtf = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jtg.setOnClickListener(groupInfoActivity);
        this.jtl = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jtl.setAutoChangeStyle(true);
        this.jtl.setIsRound(false);
        this.jrS = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jti = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jti.setOnClickListener(groupInfoActivity);
        this.jtp = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jtN = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jtk = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jtg.setOnClickListener(groupInfoActivity);
        this.jtj = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jtj.setOnClickListener(groupInfoActivity);
        this.jtm = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jtn = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jtn.setOnClickListener(groupInfoActivity);
        this.jtt = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jtv = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jtQ = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jtw = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jtQ.setOnClickListener(this.jsW);
        this.jtx = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jtx.setOnClickListener(groupInfoActivity);
        this.jty = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jtG = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jtG.setOnClickListener(groupInfoActivity);
        this.jtH = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jtI = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jtM = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jtJ = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jtJ.setOnClickListener(groupInfoActivity);
        this.jtJ.setLongClickable(true);
        this.jtJ.setOnLongClickListener(groupInfoActivity);
        this.jtO = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jtO.setClickable(true);
        this.jtO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jte.setMaxLines(1000);
            }
        });
        this.jtK = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jtK.setOnLongClickListener(groupInfoActivity);
        this.jtP = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jsY = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jth = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jth.setPhotoClickListener(groupInfoActivity);
        this.jth.setPhotoLongClickListener(groupInfoActivity);
        this.jth.setVisibility(8);
    }

    public RelativeLayout cGk() {
        return this.jtK;
    }

    public RelativeLayout cGl() {
        return this.jtg;
    }

    public LinearLayout cGm() {
        return this.jtt;
    }

    public RelativeLayout cGn() {
        return this.jtx;
    }

    public RelativeLayout cGo() {
        return this.jtJ;
    }

    public RelativeLayout cGp() {
        return this.jtG;
    }

    public RelativeLayout cGq() {
        return this.jsZ;
    }

    public View cGr() {
        return this.jtD;
    }

    public LinearLayout cGs() {
        return this.jtQ;
    }

    public RelativeLayout cGt() {
        return this.jti;
    }

    public RelativeLayout cGu() {
        return this.jtj;
    }

    public RelativeLayout cGv() {
        return this.jtn;
    }

    public View cFe() {
        return this.jfB;
    }

    public void cGw() {
        this.jsY.setVisibility(8);
    }

    public void cGx() {
        this.jsY.setVisibility(0);
    }

    public void r(boolean z, String str) {
        if (z) {
            this.jtd.setText(str);
            this.jts.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jts.setVisibility(8);
        } else {
            this.jtd.setText(str);
            this.jts.setVisibility(0);
        }
    }

    public void qL(boolean z) {
        if (z) {
            this.jtd.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jts.setVisibility(8);
        }
    }

    public RelativeLayout cGy() {
        return this.jts;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jtV = aVar.cHh();
            this.jtW = aVar.cHi();
            this.jtT = aVar;
            this.jtU = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cHc() != null) {
                jtX = aVar.cHc().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jtA.setVisibility(0);
            this.jtv.setVisibility(0);
            if (aVar.getGroup() != null) {
                KN(aVar.getGroup().getName());
                this.jtc.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jtp.setVisibility(0);
                } else {
                    this.jtp.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jtF.setVisibility(0);
                    this.jtl.setVisibility(8);
                    this.jtM.setVisibility(8);
                    this.jtN.setVisibility(8);
                    this.jrS.setText(R.string.group_info_forum_author);
                    this.jti.setEnabled(false);
                    this.jtp.setVisibility(8);
                } else {
                    this.jtF.setVisibility(8);
                    this.jtl.setVisibility(0);
                    this.jtM.setVisibility(0);
                    this.jtN.setVisibility(0);
                    this.jrS.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jti.setEnabled(true);
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
                this.jtE = stringBuffer.toString();
                this.jtd.setText(this.jtE);
                this.jte.setText(aVar.getGroup().getIntro());
                this.jtm.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jtl.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jtg.setVisibility(0);
                    this.jtf.setText(aVar.getGroup().getForumName() + this.jsW.getPageContext().getString(R.string.forum));
                } else {
                    this.jtg.setVisibility(8);
                }
                this.jtk.removeAllViews();
                boolean cHj = aVar.cHj();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.jtS, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jsW.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jtk.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jsW.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jtk.addView(imageView2);
                }
                if (cHj) {
                    this.jtP.setVisibility(0);
                } else {
                    this.jtP.setVisibility(8);
                }
            }
            if (aVar.cHc() != null) {
                this.jsZ.setVisibility(0);
                this.jsX.setVisibility(0);
                GroupActivityData cHc = aVar.cHc();
                if (!aVar.cHh()) {
                    if (cHc.getIsEnd() != 1) {
                        this.jta.setVisibility(4);
                        this.jtb.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jsZ.setVisibility(8);
                        this.jsX.setVisibility(8);
                    }
                } else {
                    this.jta.setVisibility(0);
                    this.jtb.setText(cHc.getgActivityTitle());
                    if (cHc.getIsEnd() != 1) {
                        this.jta.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.jta, R.color.common_color_10171, 1);
                    } else {
                        this.jta.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.jta, R.color.common_color_10168, 1);
                    }
                    this.jtb.setText(cHc.getgActivityTitle());
                }
            } else if (aVar.cHi()) {
                this.jsZ.setVisibility(0);
                this.jsX.setVisibility(0);
                this.jta.setVisibility(4);
                this.jtb.setText(R.string.group_info_create_activity);
            } else {
                this.jsZ.setVisibility(8);
                this.jsX.setVisibility(8);
            }
            this.jtt.removeAllViews();
            if (aVar.cHd() != null && aVar.cHd().size() > 0) {
                List<MemberData> cHd = aVar.cHd();
                int size = cHd.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cHd.get(i3);
                    HeadImageView headImageView = this.jtu[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jsW.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jtu[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jtt.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cHi()) {
                this.jts.setEnabled(true);
                this.jtJ.setEnabled(true);
                ap.setBackgroundResource(this.jtJ, R.drawable.group_info_item);
                this.jtG.setVisibility(0);
                this.jtL.setVisibility(0);
                this.jtI.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jtH.setText(aVar.getGroup().getName());
                }
            } else {
                this.jts.setEnabled(false);
                this.jtJ.setEnabled(true);
                ap.setBackgroundColor(this.jtJ, R.color.cp_bg_line_d);
                this.jtI.setVisibility(8);
                this.jtL.setVisibility(8);
                this.jte.setPadding(0, 0, 0, 0);
            }
            if (aVar.cHh()) {
                this.jty.setVisibility(0);
                this.jtR.setVisibility(0);
                if (this.jtn.getParent() != this.jty) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jtA.removeView(this.jtn);
                    this.jty.addView(this.jtn, 1);
                }
                cGz();
            } else {
                this.jty.setVisibility(8);
                this.jtR.setVisibility(8);
                if (this.jtn.getParent() != this.jtA) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jty.removeView(this.jtn);
                    this.jtA.addView(this.jtn, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jtj.setVisibility(8);
            } else {
                this.jtj.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                qL(aVar.cHi());
            } else {
                r(aVar.cHi(), this.jtE);
            }
            this.cch.setVisibility(0);
            this.jtv.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (Br(aVar.getGroup().getFlag())) {
                qM(z);
            } else {
                cGA();
            }
        }
    }

    public void cGz() {
        this.jtw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.jtw, R.color.cp_cont_a, 1);
        this.jtw.setText(this.jsW.getPageContext().getString(R.string.i_want_talk));
        this.jtQ.setEnabled(true);
    }

    private void qM(boolean z) {
        this.jtw.setText(this.jsW.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jtw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jtw, R.color.cp_cont_a, 1);
        } else {
            this.jtw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jtw, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.jtQ, R.drawable.btn_blue_bg);
        this.jtQ.setEnabled(true);
    }

    private boolean Br(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cGA() {
        this.jtw.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jtw.setText(this.jsW.getPageContext().getString(R.string.group_info_refuse_join));
        this.jtw.setTextColor(this.jsW.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.jtQ, R.drawable.btn_app_download_d);
        this.jtQ.setEnabled(false);
    }

    public void KP(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jtt.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jtt.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jtt.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jth.setIsManager(aVar.cHi());
            if (aVar.cHi()) {
                this.jth.setVisibility(0);
                if (aVar.cHe() != null && aVar.cHe().size() == 1 && TextUtils.isEmpty(aVar.cHe().get(0).getPicId())) {
                    this.jth.setData(null);
                } else {
                    this.jth.setData(aVar.cHe());
                }
            } else if (aVar.cHe() != null && aVar.cHe().size() > 0) {
                if (aVar.cHe().size() == 1 && TextUtils.isEmpty(aVar.cHe().get(0).getPicId())) {
                    this.jth.setVisibility(8);
                    return;
                }
                this.jth.setVisibility(0);
                this.jth.setData(aVar.cHe());
            } else {
                this.jth.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jtC = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jtB != null) {
            this.jtB.dismiss();
            this.jtB = null;
        }
        e(obj, i);
        this.jtB.Nv();
    }

    private void e(final Object obj, final int i) {
        if (this.jtB == null) {
            this.jtB = new i(this.jsW.getPageContext());
            this.jtB.a(null, new String[]{this.jsW.getResources().getString(R.string.group_info_set_portrait), this.jsW.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jtB != null && a.this.jtB.isShowing()) {
                        a.this.jtC.a(a.this.jtB, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jth != null) {
            this.jth.onDestory();
        }
        if (this.jtl != null) {
            this.jtl.stopLoad();
            this.jtl.setBackgroundDrawable(null);
            this.jtl.setImageDrawable(null);
        }
        if (this.jtt != null && this.jtu != null) {
            int length = this.jtu.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jtu[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void KQ(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.jsW.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jsW.getPageContext().getPageActivity());
            bVar.zB(this.jsW.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jsW.getSystemService("clipboard")).setText(str);
                        a.this.jsW.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jsW.getPageContext());
            bVar.bhi();
        }
    }

    public void KR(String str) {
        if (this.jtz == null) {
            KS(str);
        }
        this.jtz.bhi();
    }

    private void KS(final String str) {
        if (this.jtz == null) {
            this.jtz = new com.baidu.tbadk.core.dialog.b(this.jsW.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jsW.getPageContext().getString(R.string.copy_group_number)};
            this.jtz.zB(this.jsW.getPageContext().getString(R.string.operation));
            this.jtz.a(charSequenceArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jsW.getSystemService("clipboard")).setText(str);
                        a.this.jsW.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jtz.d(this.jsW.getPageContext());
        }
    }

    public void cGB() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jtw.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jtw.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jsW.getLayoutMode().setNightMode(i == 1);
        this.jsW.getLayoutMode().onModeChanged(this.mContainer);
        this.jsW.getLayoutMode().onModeChanged(this.jtq);
        this.jth.a(i, this.jsW);
        this.mNavigationBar.onChangeSkinType(this.jsW.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.jtS, R.color.common_color_10009, 1);
        }
        if (!this.jtV) {
            b(this.jtT, this.jtU);
        }
        if (this.jtW) {
            ap.setBackgroundResource(this.jtJ, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.jtJ, R.color.cp_bg_line_d);
        }
    }

    public void qN(boolean z) {
        this.jtV = z;
    }
}
