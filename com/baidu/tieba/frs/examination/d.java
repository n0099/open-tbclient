package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.SearchMajorActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class d extends a {
    private TbImageView jsL;
    private TextView jsM;
    private TextView jsN;
    private TextView jsO;
    private TextView jsP;
    private TextView jsQ;
    private TextView jsR;
    private TextView jsS;
    private TextView jsT;
    private EditText jsU;
    private EditText jsV;
    private ImageView jsW;
    private View jsX;
    private View jsY;
    private RankStarView jsZ;
    private RankStarView jta;
    private Editable jtb;
    private Editable jtc;
    private TextView jtd;
    private TextView jte;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iJr).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jsL = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jsM = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jsN = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.jsO = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jsP = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jsQ = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.jsW = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jsR = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jsS = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jsT = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jsU = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jsU.setLineSpacing(l.getDimens(this.iJr, R.dimen.tbds16), 1.0f);
        this.jsV = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jsV.setLineSpacing(l.getDimens(this.iJr, R.dimen.tbds16), 1.0f);
        this.jtd = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jte = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jsY = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jsZ = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jsZ.setClickable(true);
        this.jsZ.setStarSpacing(l.getDimens(this.iJr, R.dimen.tbds24));
        this.jta = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jta.setClickable(true);
        this.jta.setStarSpacing(l.getDimens(this.iJr, R.dimen.tbds24));
        this.jsX = this.mRoot.findViewById(R.id.divider);
        if (this.jsv != null) {
            this.jsN.setText(dt(this.jsv.getTags()));
            this.jsM.setText(this.jsv.getName());
            this.jsL.startLoad(this.jsv.icon_url, 10, false);
        }
        this.jsL.setPlaceHolder(2);
        this.jsL.setPageId(this.iJr.getUniqueId());
        this.jsL.setConrers(15);
        this.jsL.setRadius(l.getDimens(this.iJr, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.iJr, view);
                    return false;
                }
                return false;
            }
        });
        this.jsw.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.iJr.HidenSoftKeyPad(inputMethodManager, d.this.jsU);
                    d.this.iJr.HidenSoftKeyPad(inputMethodManager, d.this.jsV);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cJp() {
        this.jhI.setOnClickListener(this);
        this.jsu.setOnClickListener(this);
        this.jsY.setOnClickListener(this);
        this.jsU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jtb = editable;
                if (d.this.jtb.length() > 500) {
                    d.this.jtd.setText((500 - d.this.jtb.length()) + "/500");
                    d.this.jtd.setVisibility(0);
                } else {
                    d.this.jtd.setVisibility(4);
                }
                d.this.cJt();
            }
        });
        this.jsV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jtc = editable;
                if (d.this.jtc.length() > 500) {
                    d.this.jte.setText((500 - d.this.jtc.length()) + "/500");
                    d.this.jte.setVisibility(0);
                } else {
                    d.this.jte.setVisibility(4);
                }
                d.this.cJt();
            }
        });
        this.jsU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.e(d.this.jsU)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jsV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.e(d.this.jsV)) {
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
    public void cJt() {
        if (!TextUtils.isEmpty(this.jtb) && this.jtb.length() >= 20 && !TextUtils.isEmpty(this.jtc) && this.jtc.length() >= 20 && !this.iJr.getString(R.string.select_subject).equals(this.jsQ.getText()) && this.jtb.length() <= 500 && this.jtc.length() <= 500) {
            this.jsu.setAlpha(1.0f);
        } else {
            this.jsu.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.jsX, R.color.CAM_X0204);
        ao.setViewTextColor(this.jsM, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsN, R.color.CAM_X0109);
        ao.setViewTextColor(this.jsO, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsP, R.color.CAM_X0105);
        if (this.iJr.getString(R.string.select_subject).equals(this.jsQ.getText())) {
            ao.setViewTextColor(this.jsQ, R.color.CAM_X0109);
            SvgManager.bwq().a(this.jsW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ao.setViewTextColor(this.jsQ, R.color.CAM_X0105);
            SvgManager.bwq().a(this.jsW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ao.setViewTextColor(this.jsR, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsS, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsT, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsU, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsV, R.color.CAM_X0105);
        ao.setViewTextColor(this.jtd, R.color.CAM_X0301);
        ao.setViewTextColor(this.jte, R.color.CAM_X0301);
        this.jsU.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.jsV.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        if (this.jsL != null) {
            this.jsL.setPlaceHolder(2);
            this.jsL.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jhI) {
            cJq();
        } else if (view == this.jsY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.iJr, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jsu) {
            if (TextUtils.isEmpty(this.jtb) || TextUtils.isEmpty(this.jtc) || this.iJr.getString(R.string.select_subject).equals(this.jsQ.getText())) {
                l.showToast(this.iJr, R.string.university_comment_must_write_tip);
            } else if (this.jtb.length() < 20) {
                l.showToast(this.iJr, R.string.university_comment_size_error_tip);
            } else if (this.jtc.length() < 20) {
                l.showToast(this.iJr, R.string.subject_comment_size_error_tip);
            } else if (this.jtb.length() > 500) {
                l.showToast(this.iJr, R.string.university_comment_lenght_error_tip);
            } else if (this.jtc.length() > 500) {
                l.showToast(this.iJr, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jsw.a("学校评价：" + ((Object) this.jtb) + "\n专业评价：" + ((Object) this.jtc), cJu(), this.jst);
            }
        }
    }

    private String cJu() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jta.getStarCount();
        int starCount2 = this.jsZ.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jsQ.getText().toString(), 1));
        if (starCount2 != 0) {
            arrayList.add(new v("专业评分", String.valueOf(starCount), 2));
        }
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.jsQ.setText(stringExtra);
                ao.setViewTextColor(this.jsQ, R.color.CAM_X0105);
                SvgManager.bwq().a(this.jsW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cJt();
            }
        }
    }

    private String dt(List<String> list) {
        if (list != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str).append(" ");
            }
            return sb.toString();
        }
        return null;
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bFN() {
        if (this.jst != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jta.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jsZ.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jsQ.getText().toString());
            writeData.setmUniversityComment(this.jsU.getText().toString());
            writeData.setmUniversitySubjectComment(this.jsV.getText().toString());
            y.g(String.valueOf(this.jst.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cJr() {
        if (this.jst != null) {
            y.f(String.valueOf(this.jst.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jta.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jta.setStarCount(0.0f);
                        }
                        try {
                            d.this.jsZ.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jsZ.setStarCount(0.0f);
                        }
                        d.this.jsQ.setText(writeData.getmUniversitySubjectContent());
                        d.this.jsU.setText(writeData.getmUniversityComment());
                        d.this.jsV.setText(writeData.getmUniversitySubjectComment());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height + (-1);
    }
}
