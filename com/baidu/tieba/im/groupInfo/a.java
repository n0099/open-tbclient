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
    public static int jtR = 0;
    private ScrollView ccd;
    private View hIo;
    private boolean isMemGroup;
    private View jfv;
    private TextView jrM;
    private final GroupInfoActivity jsQ;
    private View jsR;
    private ProgressBar jsS;
    private RelativeLayout jsT;
    private TextView jsU;
    private TextView jsV;
    private TextView jsW;
    private TextView jsX;
    private EllipsizingTextView jsY;
    private TextView jsZ;
    private RelativeLayout jtA;
    private TextView jtB;
    private ImageView jtC;
    private RelativeLayout jtD;
    private RelativeLayout jtE;
    private ImageView jtF;
    private ImageView jtG;
    private View jtH;
    private TextView jtI;
    private TextView jtJ;
    private LinearLayout jtK;
    private View jtL;
    private TextView jtM;
    private ResponseGroupInfoLocalMessage.a jtN;
    private boolean jtO;
    private boolean jtP;
    private boolean jtQ;
    private RelativeLayout jta;
    private PhotoWallView jtb;
    private RelativeLayout jtc;
    private RelativeLayout jtd;
    private LinearLayout jte;
    private HeadImageView jtf;
    private TextView jtg;
    private RelativeLayout jth;
    private com.baidu.tbadk.core.dialog.b jti;
    private ImageView jtj;
    private final View jtk;
    private b.InterfaceC0538b jtl;
    private RelativeLayout jtm;
    private LinearLayout jtn;
    private HeadImageView[] jto;
    private LinearLayout jtp;
    private TextView jtq;
    private RelativeLayout jtr;
    private LinearLayout jts;
    private com.baidu.tbadk.core.dialog.b jtt;
    private LinearLayout jtu;
    private i jtv;
    private b jtw;
    private TextView jtx;
    private String jty;
    private ImageView jtz;
    private View mBottomLine;
    private RelativeLayout mContainer;
    private NavigationBar mNavigationBar;

    public a(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
        this.jti = null;
        this.jtl = null;
        this.jto = new HeadImageView[5];
        this.jty = "";
        this.jtO = true;
        this.isMemGroup = false;
        this.jtP = false;
        this.jtQ = false;
        this.jsQ = groupInfoActivity;
        groupInfoActivity.setContentView(R.layout.im_group_info_activity);
        this.jtk = LayoutInflater.from(groupInfoActivity.getPageContext().getPageActivity()).inflate(R.layout.group_activity_guide_toast, (ViewGroup) null);
        l(groupInfoActivity);
        m(groupInfoActivity);
        n(groupInfoActivity);
        this.ccd.setVisibility(4);
        this.jtp.setVisibility(4);
    }

    public void setGroupName(String str) {
        this.jtB.setText(str);
        KM(str);
    }

    private void KM(String str) {
        if (str != null) {
            this.jtM.setText(str);
        }
    }

    public void KN(String str) {
        this.jsY.setText(str);
    }

    private void l(GroupInfoActivity groupInfoActivity) {
        this.mNavigationBar = (NavigationBar) groupInfoActivity.findViewById(R.id.view_navigation_bar);
        this.jfv = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.jtM = this.mNavigationBar.setTitleText("");
        this.jtL = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null);
        this.jtx = (TextView) this.jtL.findViewById(R.id.right_textview);
        this.jtx.setText(groupInfoActivity.getPageContext().getString(R.string.setup));
        ap.setViewTextColor(this.jtx, R.color.cp_cont_f, 1);
        this.jtx.setOnClickListener(groupInfoActivity);
        this.jtL.setVisibility(8);
    }

    private void m(GroupInfoActivity groupInfoActivity) {
        this.jsR = groupInfoActivity.findViewById(R.id.line_activity_name_down);
        this.mContainer = (RelativeLayout) groupInfoActivity.findViewById(R.id.group_info_container);
        this.ccd = (ScrollView) groupInfoActivity.findViewById(R.id.group_scrollview);
        this.ccd.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.im.groupInfo.a.1
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
        this.hIo = groupInfoActivity.findViewById(R.id.group_top_view);
        this.hIo.getLayoutParams().height = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
        this.jsT = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_activity);
        this.jsT.setOnClickListener(groupInfoActivity);
        this.jsU = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_status);
        this.jsV = (TextView) groupInfoActivity.findViewById(R.id.txt_activity_name);
        this.jtm = (RelativeLayout) groupInfoActivity.findViewById(R.id.address_layout);
        this.jtm.setOnClickListener(groupInfoActivity);
        this.jtu = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_body);
        this.jtz = (ImageView) groupInfoActivity.findViewById(R.id.img_group_type_icon);
        this.jsW = (TextView) groupInfoActivity.findViewById(R.id.txt_group_number);
        this.jsX = (TextView) groupInfoActivity.findViewById(R.id.txt_group_place);
        this.jtF = (ImageView) groupInfoActivity.findViewById(R.id.img_group_place);
        this.jsY = (EllipsizingTextView) groupInfoActivity.findViewById(R.id.txt_group_intro);
        this.jsY.setMaxLines(20);
        this.jsY.a(new EllipsizingTextView.a() { // from class: com.baidu.tieba.im.groupInfo.a.2
            @Override // com.baidu.tieba.group.EllipsizingTextView.a
            public void pw(boolean z) {
                if (z) {
                    a.this.jtI.setVisibility(0);
                } else {
                    a.this.jtI.setVisibility(8);
                }
            }
        });
        this.jta = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_forum);
        this.jsZ = (TextView) groupInfoActivity.findViewById(R.id.txt_group_forum);
        this.jta.setOnClickListener(groupInfoActivity);
        this.jtf = (HeadImageView) groupInfoActivity.findViewById(R.id.img_group_author);
        this.jtf.setAutoChangeStyle(true);
        this.jtf.setIsRound(false);
        this.jrM = (TextView) groupInfoActivity.findViewById(R.id.txt_group_author);
        this.jtc = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_author);
        this.jtc.setOnClickListener(groupInfoActivity);
        this.jtj = (ImageView) groupInfoActivity.findViewById(R.id.meizhi_icon);
        this.jtH = groupInfoActivity.findViewById(R.id.line_group_author_down);
        this.jte = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_grade_star);
        this.jta.setOnClickListener(groupInfoActivity);
        this.jtd = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_grade);
        this.jtd.setOnClickListener(groupInfoActivity);
        this.jtg = (TextView) groupInfoActivity.findViewById(R.id.txt_group_member_count);
        this.jth = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_member);
        this.jth.setOnClickListener(groupInfoActivity);
        this.jtn = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_member_photo);
        this.jtp = (LinearLayout) groupInfoActivity.findViewById(R.id.bottom_bar);
        this.jtK = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_bottom_button);
        this.jtq = (TextView) groupInfoActivity.findViewById(R.id.txt_join);
        this.jtK.setOnClickListener(this.jsQ);
        this.jtr = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_invite);
        this.jtr.setOnClickListener(groupInfoActivity);
        this.jts = (LinearLayout) groupInfoActivity.findViewById(R.id.lay_group_notice_share);
        this.jtA = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_name);
        this.jtA.setOnClickListener(groupInfoActivity);
        this.jtB = (TextView) groupInfoActivity.findViewById(R.id.txt_group_name);
        this.jtC = (ImageView) groupInfoActivity.findViewById(R.id.img_group_intro_arrow);
        this.jtG = (ImageView) groupInfoActivity.findViewById(R.id.img_group_author_arrow);
        this.jtD = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_intro);
        this.jtD.setOnClickListener(groupInfoActivity);
        this.jtD.setLongClickable(true);
        this.jtD.setOnLongClickListener(groupInfoActivity);
        this.jtI = (TextView) groupInfoActivity.findViewById(R.id.txt_group_intro_more);
        this.jtI.setClickable(true);
        this.jtI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.im.groupInfo.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.jsY.setMaxLines(1000);
            }
        });
        this.jtE = (RelativeLayout) groupInfoActivity.findViewById(R.id.lay_group_number);
        this.jtE.setOnLongClickListener(groupInfoActivity);
        this.jtJ = (TextView) groupInfoActivity.findViewById(R.id.can_create_mem_group);
        this.jsS = (ProgressBar) groupInfoActivity.findViewById(R.id.progress_loading);
        this.mBottomLine = groupInfoActivity.findViewById(R.id.bottom_divider_line);
    }

    private void n(GroupInfoActivity groupInfoActivity) {
        this.jtb = (PhotoWallView) groupInfoActivity.findViewById(R.id.photo_wall);
        this.jtb.setPhotoClickListener(groupInfoActivity);
        this.jtb.setPhotoLongClickListener(groupInfoActivity);
        this.jtb.setVisibility(8);
    }

    public RelativeLayout cGj() {
        return this.jtE;
    }

    public RelativeLayout cGk() {
        return this.jta;
    }

    public LinearLayout cGl() {
        return this.jtn;
    }

    public RelativeLayout cGm() {
        return this.jtr;
    }

    public RelativeLayout cGn() {
        return this.jtD;
    }

    public RelativeLayout cGo() {
        return this.jtA;
    }

    public RelativeLayout cGp() {
        return this.jsT;
    }

    public View cGq() {
        return this.jtx;
    }

    public LinearLayout cGr() {
        return this.jtK;
    }

    public RelativeLayout cGs() {
        return this.jtc;
    }

    public RelativeLayout cGt() {
        return this.jtd;
    }

    public RelativeLayout cGu() {
        return this.jth;
    }

    public View cFd() {
        return this.jfv;
    }

    public void cGv() {
        this.jsS.setVisibility(8);
    }

    public void cGw() {
        this.jsS.setVisibility(0);
    }

    public void r(boolean z, String str) {
        if (z) {
            this.jsX.setText(str);
            this.jtm.setVisibility(0);
        } else if (TextUtils.isEmpty(str)) {
            this.jtm.setVisibility(8);
        } else {
            this.jsX.setText(str);
            this.jtm.setVisibility(0);
        }
    }

    public void qJ(boolean z) {
        if (z) {
            this.jsX.setText(this.mContext.getString(R.string.live_card_hide));
        } else {
            this.jtm.setVisibility(8);
        }
    }

    public RelativeLayout cGx() {
        return this.jtm;
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        a(aVar, false);
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null) {
            this.isMemGroup = aVar.isMemGroup();
            this.jtP = aVar.cHg();
            this.jtQ = aVar.cHh();
            this.jtN = aVar;
            this.jtO = z;
            if (aVar.getGroup() != null) {
                gid = aVar.getGroup().getGroupId();
            }
            if (aVar.cHb() != null) {
                jtR = aVar.cHb().getActivityId();
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
            }
            this.jtu.setVisibility(0);
            this.jtp.setVisibility(0);
            if (aVar.getGroup() != null) {
                KM(aVar.getGroup().getName());
                this.jsW.setText(String.valueOf(aVar.getGroup().getGroupId()));
                if (aVar.getGroup().isMeizhi()) {
                    this.jtj.setVisibility(0);
                } else {
                    this.jtj.setVisibility(8);
                }
                if (aVar.getGroup().getGroupType() == 4) {
                    this.jtz.setVisibility(0);
                    this.jtf.setVisibility(8);
                    this.jtG.setVisibility(8);
                    this.jtH.setVisibility(8);
                    this.jrM.setText(R.string.group_info_forum_author);
                    this.jtc.setEnabled(false);
                    this.jtj.setVisibility(8);
                } else {
                    this.jtz.setVisibility(8);
                    this.jtf.setVisibility(0);
                    this.jtG.setVisibility(0);
                    this.jtH.setVisibility(0);
                    this.jrM.setText(StringUtils.isNull(aVar.getGroup().getAuthorNameShow()) ? aVar.getGroup().getAuthorName() : aVar.getGroup().getAuthorNameShow());
                    this.jtc.setEnabled(true);
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
                this.jty = stringBuffer.toString();
                this.jsX.setText(this.jty);
                this.jsY.setText(aVar.getGroup().getIntro());
                this.jtg.setText(aVar.getGroup().getMemberNum() + "/" + aVar.getGroup().getMaxMemberNum());
                if (!TextUtils.isEmpty(aVar.getGroup().getAuthorPortrait())) {
                    this.jtf.startLoad(aVar.getGroup().getAuthorPortrait(), 12, false);
                }
                if (aVar.getGroup().getForumName() != null && aVar.getGroup().getForumName().length() > 0) {
                    this.jta.setVisibility(0);
                    this.jsZ.setText(aVar.getGroup().getForumName() + this.jsQ.getPageContext().getString(R.string.forum));
                } else {
                    this.jta.setVisibility(8);
                }
                this.jte.removeAllViews();
                boolean cHi = aVar.cHi();
                boolean isMemGroup = aVar.isMemGroup();
                if (isMemGroup) {
                    ap.setViewTextColor(this.jtM, R.color.common_color_10009, 1);
                }
                if (aVar.getGroup().getGrade() > 0) {
                    for (int i = 0; i < aVar.getGroup().getGrade(); i++) {
                        ImageView imageView = new ImageView(this.jsQ.getPageContext().getPageActivity());
                        if (isMemGroup) {
                            ap.setImageResource(imageView, R.drawable.icon_vip_grade_big_middle_s);
                        } else {
                            ap.setImageResource(imageView, R.drawable.icon_grade_middle_star_s);
                        }
                        this.jte.addView(imageView);
                    }
                } else {
                    ImageView imageView2 = new ImageView(this.jsQ.getPageContext().getPageActivity());
                    if (isMemGroup) {
                        ap.setImageResource(imageView2, R.drawable.icon_vip_grade_big_middle_n);
                    } else {
                        ap.setImageResource(imageView2, R.drawable.icon_grade_middle_star_n);
                    }
                    this.jte.addView(imageView2);
                }
                if (cHi) {
                    this.jtJ.setVisibility(0);
                } else {
                    this.jtJ.setVisibility(8);
                }
            }
            if (aVar.cHb() != null) {
                this.jsT.setVisibility(0);
                this.jsR.setVisibility(0);
                GroupActivityData cHb = aVar.cHb();
                if (!aVar.cHg()) {
                    if (cHb.getIsEnd() != 1) {
                        this.jsU.setVisibility(4);
                        this.jsV.setText(R.string.group_info_activity_not_join_tip);
                    } else {
                        this.jsT.setVisibility(8);
                        this.jsR.setVisibility(8);
                    }
                } else {
                    this.jsU.setVisibility(0);
                    this.jsV.setText(cHb.getgActivityTitle());
                    if (cHb.getIsEnd() != 1) {
                        this.jsU.setText(R.string.group_info_activity_doing);
                        ap.setViewTextColor(this.jsU, R.color.common_color_10171, 1);
                    } else {
                        this.jsU.setText(R.string.group_activity_end);
                        ap.setViewTextColor(this.jsU, R.color.common_color_10168, 1);
                    }
                    this.jsV.setText(cHb.getgActivityTitle());
                }
            } else if (aVar.cHh()) {
                this.jsT.setVisibility(0);
                this.jsR.setVisibility(0);
                this.jsU.setVisibility(4);
                this.jsV.setText(R.string.group_info_create_activity);
            } else {
                this.jsT.setVisibility(8);
                this.jsR.setVisibility(8);
            }
            this.jtn.removeAllViews();
            if (aVar.cHc() != null && aVar.cHc().size() > 0) {
                List<MemberData> cHc = aVar.cHc();
                int size = cHc.size();
                int i2 = size > 5 ? 5 : size;
                for (int i3 = 0; i3 < i2; i3++) {
                    MemberData memberData = cHc.get(i3);
                    HeadImageView headImageView = this.jto[i3];
                    if (headImageView == null) {
                        headImageView = new HeadImageView(this.jsQ.getPageContext().getPageActivity());
                        headImageView.setAutoChangeStyle(true);
                        headImageView.setIsRound(false);
                        this.jto[i3] = headImageView;
                    }
                    int dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds72);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dimensionPixelSize, dimensionPixelSize);
                    layoutParams.rightMargin = this.mContext.getResources().getDimensionPixelSize(R.dimen.ds10);
                    this.jtn.addView(headImageView, layoutParams);
                    if (!TextUtils.isEmpty(memberData.getPortrait())) {
                        headImageView.startLoad(memberData.getPortrait(), 12, false);
                    }
                }
            }
            if (aVar.cHh()) {
                this.jtm.setEnabled(true);
                this.jtD.setEnabled(true);
                ap.setBackgroundResource(this.jtD, R.drawable.group_info_item);
                this.jtA.setVisibility(0);
                this.jtF.setVisibility(0);
                this.jtC.setVisibility(0);
                if (aVar.getGroup() != null) {
                    this.jtB.setText(aVar.getGroup().getName());
                }
            } else {
                this.jtm.setEnabled(false);
                this.jtD.setEnabled(true);
                ap.setBackgroundColor(this.jtD, R.color.cp_bg_line_d);
                this.jtC.setVisibility(8);
                this.jtF.setVisibility(8);
                this.jsY.setPadding(0, 0, 0, 0);
            }
            if (aVar.cHg()) {
                this.jts.setVisibility(0);
                this.jtL.setVisibility(0);
                if (this.jth.getParent() != this.jts) {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams2.rightMargin = 0;
                    layoutParams2.leftMargin = 0;
                    layoutParams2.bottomMargin = 0;
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds30);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds18);
                    this.jtu.removeView(this.jth);
                    this.jts.addView(this.jth, 1);
                }
                cGy();
            } else {
                this.jts.setVisibility(8);
                this.jtL.setVisibility(8);
                if (this.jth.getParent() != this.jtu) {
                    new LinearLayout.LayoutParams(-1, -2);
                    this.mContext.getResources().getDimensionPixelSize(R.dimen.ds28);
                    this.jts.removeView(this.jth);
                    this.jtu.addView(this.jth, 3);
                }
                b(aVar, z);
            }
            if (aVar.getGroup().getGroupType() == 4 || aVar.getGroup().getGroupType() == 5) {
                this.jtd.setVisibility(8);
            } else {
                this.jtd.setVisibility(0);
            }
            a(aVar);
            if (aVar.getGroup().getIsHidePosition() == 1) {
                qJ(aVar.cHh());
            } else {
                r(aVar.cHh(), this.jty);
            }
            this.ccd.setVisibility(0);
            this.jtp.setVisibility(0);
        }
    }

    private void b(ResponseGroupInfoLocalMessage.a aVar, boolean z) {
        if (aVar != null && aVar.getGroup() != null) {
            if (Br(aVar.getGroup().getFlag())) {
                qK(z);
            } else {
                cGz();
            }
        }
    }

    public void cGy() {
        this.jtq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_jinba), (Drawable) null, (Drawable) null, (Drawable) null);
        ap.setViewTextColor(this.jtq, R.color.cp_cont_a, 1);
        this.jtq.setText(this.jsQ.getPageContext().getString(R.string.i_want_talk));
        this.jtK.setEnabled(true);
    }

    private void qK(boolean z) {
        this.jtq.setText(this.jsQ.getPageContext().getString(R.string.i_want_attent));
        if (z) {
            this.jtq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jtq, R.color.cp_cont_a, 1);
        } else {
            this.jtq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
            ap.setViewTextColor(this.jtq, R.color.cp_cont_a, 1);
        }
        ap.setBackgroundResource(this.jtK, R.drawable.btn_blue_bg);
        this.jtK.setEnabled(true);
    }

    private boolean Br(int i) {
        return ((i & 2) >> 1) != 1;
    }

    private void cGz() {
        this.jtq.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
        this.jtq.setText(this.jsQ.getPageContext().getString(R.string.group_info_refuse_join));
        this.jtq.setTextColor(this.jsQ.getResources().getColorStateList(R.color.cp_cont_a));
        ap.setBackgroundResource(this.jtK, R.drawable.btn_app_download_d);
        this.jtK.setEnabled(false);
    }

    public void KO(String str) {
        int childCount;
        if (!TextUtils.isEmpty(str) && (childCount = this.jtn.getChildCount()) != 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = this.jtn.getChildAt(i);
                if (childAt != null && (childAt instanceof HeadImageView) && childAt.getTag() != null && str.equals(childAt.getTag())) {
                    this.jtn.removeViewAt(i);
                    return;
                }
            }
        }
    }

    public void a(ResponseGroupInfoLocalMessage.a aVar) {
        if (aVar != null) {
            this.jtb.setIsManager(aVar.cHh());
            if (aVar.cHh()) {
                this.jtb.setVisibility(0);
                if (aVar.cHd() != null && aVar.cHd().size() == 1 && TextUtils.isEmpty(aVar.cHd().get(0).getPicId())) {
                    this.jtb.setData(null);
                } else {
                    this.jtb.setData(aVar.cHd());
                }
            } else if (aVar.cHd() != null && aVar.cHd().size() > 0) {
                if (aVar.cHd().size() == 1 && TextUtils.isEmpty(aVar.cHd().get(0).getPicId())) {
                    this.jtb.setVisibility(8);
                    return;
                }
                this.jtb.setVisibility(0);
                this.jtb.setData(aVar.cHd());
            } else {
                this.jtb.setVisibility(8);
            }
        }
    }

    public void a(b bVar) {
        this.jtw = bVar;
    }

    public void d(Object obj, int i) {
        if (this.jtv != null) {
            this.jtv.dismiss();
            this.jtv = null;
        }
        e(obj, i);
        this.jtv.Nv();
    }

    private void e(final Object obj, final int i) {
        if (this.jtv == null) {
            this.jtv = new i(this.jsQ.getPageContext());
            this.jtv.a(null, new String[]{this.jsQ.getResources().getString(R.string.group_info_set_portrait), this.jsQ.getResources().getString(R.string.delete)}, new k.c() { // from class: com.baidu.tieba.im.groupInfo.a.4
                @Override // com.baidu.tbadk.core.dialog.k.c
                public void a(k kVar, int i2, View view) {
                    if (a.this.jtv != null && a.this.jtv.isShowing()) {
                        a.this.jtw.a(a.this.jtv, i2, obj, i);
                    }
                }
            });
        }
    }

    public void onDestory() {
        if (this.jtb != null) {
            this.jtb.onDestory();
        }
        if (this.jtf != null) {
            this.jtf.stopLoad();
            this.jtf.setBackgroundDrawable(null);
            this.jtf.setImageDrawable(null);
        }
        if (this.jtn != null && this.jto != null) {
            int length = this.jto.length;
            for (int i = 0; i < length; i++) {
                HeadImageView headImageView = this.jto[i];
                if (headImageView != null) {
                    headImageView.stopLoad();
                    headImageView.setBackgroundDrawable(null);
                    headImageView.setImageDrawable(null);
                }
            }
        }
    }

    public void KP(final String str) {
        if (!TextUtils.isEmpty(str)) {
            CharSequence[] charSequenceArr = {this.jsQ.getPageContext().getString(R.string.copy_group_introduction)};
            com.baidu.tbadk.core.dialog.b bVar = new com.baidu.tbadk.core.dialog.b(this.jsQ.getPageContext().getPageActivity());
            bVar.zA(this.jsQ.getPageContext().getString(R.string.operation));
            bVar.a(charSequenceArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.groupInfo.a.5
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar2, int i, View view) {
                    bVar2.dismiss();
                    try {
                        ((ClipboardManager) a.this.jsQ.getSystemService("clipboard")).setText(str);
                        a.this.jsQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            bVar.d(this.jsQ.getPageContext());
            bVar.bhi();
        }
    }

    public void KQ(String str) {
        if (this.jtt == null) {
            KR(str);
        }
        this.jtt.bhi();
    }

    private void KR(final String str) {
        if (this.jtt == null) {
            this.jtt = new com.baidu.tbadk.core.dialog.b(this.jsQ.getPageContext().getPageActivity());
            CharSequence[] charSequenceArr = {this.jsQ.getPageContext().getString(R.string.copy_group_number)};
            this.jtt.zA(this.jsQ.getPageContext().getString(R.string.operation));
            this.jtt.a(charSequenceArr, new b.InterfaceC0538b() { // from class: com.baidu.tieba.im.groupInfo.a.6
                @Override // com.baidu.tbadk.core.dialog.b.InterfaceC0538b
                public void a(com.baidu.tbadk.core.dialog.b bVar, int i, View view) {
                    bVar.dismiss();
                    try {
                        ((ClipboardManager) a.this.jsQ.getSystemService("clipboard")).setText(str);
                        a.this.jsQ.showToast(R.string.copy_pb_url_success);
                    } catch (Exception e) {
                    }
                }
            });
            this.jtt.d(this.jsQ.getPageContext());
        }
    }

    public void cGA() {
        ColorStateList colorList = ap.getColorList(R.color.cp_cont_a);
        if (colorList != null) {
            this.jtq.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(R.drawable.icon_brief_attention_disable), (Drawable) null, (Drawable) null, (Drawable) null);
        }
        this.jtq.setTextColor(colorList);
    }

    public void changeSkinType(int i) {
        this.jsQ.getLayoutMode().setNightMode(i == 1);
        this.jsQ.getLayoutMode().onModeChanged(this.mContainer);
        this.jsQ.getLayoutMode().onModeChanged(this.jtk);
        this.jtb.a(i, this.jsQ);
        this.mNavigationBar.onChangeSkinType(this.jsQ.getPageContext(), i);
        if (this.isMemGroup) {
            ap.setViewTextColor(this.jtM, R.color.common_color_10009, 1);
        }
        if (!this.jtP) {
            b(this.jtN, this.jtO);
        }
        if (this.jtQ) {
            ap.setBackgroundResource(this.jtD, R.drawable.group_info_item);
        } else {
            ap.setBackgroundColor(this.jtD, R.color.cp_bg_line_d);
        }
    }

    public void qL(boolean z) {
        this.jtP = z;
    }
}
