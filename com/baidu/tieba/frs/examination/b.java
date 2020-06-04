package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    private final BaseFragmentActivity gRG;
    private Gson gson = new Gson();
    private View hpq;
    private final ForumWriteData hyK;
    private SerializableItemInfo hyL;
    private EditText hyM;
    private EditText hyN;
    private final a hyQ;
    private TbImageView hyR;
    private TextView hyS;
    private TextView hyT;
    private TextView hyU;
    private TextView hyV;
    private TextView hyW;
    private TextView hyX;
    private TextView hyY;
    private TextView hyZ;
    private TextView hza;
    private ImageView hzb;
    private View hzc;
    private View hzd;
    private RankStarView hze;
    private RankStarView hzf;
    private Editable hzg;
    private Editable hzh;
    private TextView hzi;
    private TextView hzj;
    private TextView mCenterText;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.gRG = baseFragmentActivity;
        this.hyK = forumWriteData;
        this.hyL = serializableItemInfo;
        initUI();
        bYI();
        this.hyQ = new a(this.gRG, this.gRG.getUniqueId(), this.hyK, this.hyL, this.hyM, this.hyN);
    }

    private void initUI() {
        this.mRoot = LayoutInflater.from(this.gRG).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hyR = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.hyT = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.hyU = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.hyV = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.hyW = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.hyX = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.hzb = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.hyY = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.hyZ = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.hza = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.hyM = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.hyM.setLineSpacing(l.getDimens(this.gRG, R.dimen.tbds16), 1.0f);
        this.hyN = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.hyN.setLineSpacing(l.getDimens(this.gRG, R.dimen.tbds16), 1.0f);
        this.hzi = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.hzj = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.hzd = this.mRoot.findViewById(R.id.select_subject_layout);
        this.hze = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.hze.setClickable(true);
        this.hze.setStarSpacing(l.getDimens(this.gRG, R.dimen.tbds24));
        this.hzf = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.hzf.setClickable(true);
        this.hzf.setStarSpacing(l.getDimens(this.gRG, R.dimen.tbds24));
        this.hzc = this.mRoot.findViewById(R.id.divider);
        this.hyS = new TextView(this.gRG);
        this.hyS.setEnabled(false);
        this.hyS.setClickable(false);
        this.hyS.setAlpha(0.5f);
        this.hyS.setText(this.gRG.getString(R.string.send_post));
        this.hyS.setTextSize(0, l.getDimens(this.gRG, R.dimen.tbds44));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        layoutParams.rightMargin = l.getDimens(this.gRG, R.dimen.tbds44);
        this.hyS.setLayoutParams(layoutParams);
        this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.hyS, this);
        this.mCenterText = this.mNavigationBar.setCenterTextTitle(this.gRG.getString(R.string.publish_comment));
        this.mCenterText.setTextSize(0, l.getDimens(this.gRG, R.dimen.tbds44));
        if (this.hyL != null) {
            this.hyU.setText(cq(this.hyL.getTags()));
            this.hyT.setText(this.hyL.getName());
            this.hyR.startLoad(this.hyL.icon_url, 10, false);
        }
        this.hpq = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.hyR.setPlaceHolder(2);
        this.hyR.setPageId(this.gRG.getUniqueId());
        this.hyR.setConrers(15);
        this.hyR.setRadius(l.getDimens(this.gRG, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.gRG, view);
                    return false;
                }
                return false;
            }
        });
    }

    private void bYI() {
        this.hpq.setOnClickListener(this);
        this.hyS.setOnClickListener(this);
        this.hzd.setOnClickListener(this);
        this.hyM.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.hzg = editable;
                if (b.this.hzg.length() > 500) {
                    b.this.hzi.setText((500 - b.this.hzg.length()) + "/500");
                    b.this.hzi.setVisibility(0);
                } else {
                    b.this.hzi.setVisibility(4);
                }
                b.this.bYJ();
            }
        });
        this.hyN.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.hzh = editable;
                if (b.this.hzh.length() > 500) {
                    b.this.hzj.setText((500 - b.this.hzh.length()) + "/500");
                    b.this.hzj.setVisibility(0);
                } else {
                    b.this.hzj.setVisibility(4);
                }
                b.this.bYJ();
            }
        });
        this.hyM.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.4
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && b.this.c(b.this.hyM)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.hyN.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && b.this.c(b.this.hyN)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYJ() {
        if (!TextUtils.isEmpty(this.hzg) && this.hzg.length() >= 20 && !TextUtils.isEmpty(this.hzh) && this.hzh.length() >= 20 && !this.gRG.getString(R.string.select_subject).equals(this.hyX.getText())) {
            this.hyS.setEnabled(true);
            this.hyS.setClickable(true);
            this.hyS.setAlpha(1.0f);
            return;
        }
        this.hyS.setEnabled(false);
        this.hyS.setClickable(false);
        this.hyS.setAlpha(0.5f);
    }

    public View getView() {
        return this.mRoot;
    }

    public void onChangeSkinType() {
        am.setBackgroundColor(this.mRoot, R.color.cp_bg_line_d);
        am.setBackgroundColor(this.hzc, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mCenterText, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyS, (int) R.color.cp_link_tip_c);
        am.setViewTextColor(this.hyT, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyU, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.hyV, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyW, (int) R.color.cp_cont_b);
        if (this.gRG.getString(R.string.select_subject).equals(this.hyX.getText())) {
            am.setViewTextColor(this.hyX, (int) R.color.cp_cont_d);
            SvgManager.aUW().a(this.hzb, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            am.setViewTextColor(this.hyX, (int) R.color.cp_cont_b);
            SvgManager.aUW().a(this.hzb, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        am.setViewTextColor(this.hyY, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hza, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyM, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hyN, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hzi, (int) R.color.cp_cont_h);
        am.setViewTextColor(this.hzj, (int) R.color.cp_cont_h);
        this.hyM.setHintTextColor(am.getColor(R.color.cp_cont_d));
        this.hyN.setHintTextColor(am.getColor(R.color.cp_cont_d));
        if (this.hyR != null) {
            this.hyR.setPlaceHolder(2);
            this.hyR.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hpq) {
            bYL();
        } else if (view == this.hzd) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.gRG, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.hyS && !TextUtils.isEmpty(this.hzg) && !TextUtils.isEmpty(this.hzh)) {
            if (this.hzg.length() > 500) {
                l.showToast(this.gRG, (int) R.string.university_comment_lenght_error_tip);
            } else if (this.hzh.length() > 500) {
                l.showToast(this.gRG, (int) R.string.subject_comment_lenght_error_tip);
            } else {
                this.hyQ.a("学校评价：" + ((Object) this.hzg) + "\n专业评价：" + ((Object) this.hzh), bYK(), this.hyK);
            }
        }
    }

    private String bYK() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.hzf.getStarCount();
        int starCount2 = this.hze.getStarCount();
        if (starCount != 0) {
            arrayList.add(new r("学校评分", String.valueOf(starCount), 2));
        }
        arrayList.add(new r("专业", this.hyX.getText().toString(), 1));
        if (starCount2 != 0) {
            arrayList.add(new r("专业评分", String.valueOf(starCount2), 2));
        }
        return this.gson.toJson(arrayList);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.hyX.setText(stringExtra);
                am.setViewTextColor(this.hyX, (int) R.color.cp_cont_b);
                SvgManager.aUW().a(this.hzb, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                bYJ();
            }
        }
    }

    private String cq(List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str).append(" ");
            }
            return sb.toString();
        }
        return null;
    }

    public void bYL() {
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(this.gRG);
        aVar.kF(R.string.give_up_edit_confirm);
        aVar.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.frs.examination.b.6
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                b.this.gRG.finish();
            }
        });
        aVar.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.frs.examination.b.7
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                aVar2.dismiss();
            }
        });
        aVar.b(this.gRG.getPageContext()).aST();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height + (-1);
    }
}
