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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.v;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends a {
    private TbImageView iUB;
    private TextView iUC;
    private TextView iUD;
    private TextView iUE;
    private TextView iUF;
    private TextView iUG;
    private TextView iUH;
    private TextView iUI;
    private TextView iUJ;
    private EditText iUK;
    private EditText iUL;
    private ImageView iUM;
    private View iUN;
    private View iUO;
    private RankStarView iUP;
    private RankStarView iUQ;
    private Editable iUR;
    private Editable iUS;
    private TextView iUT;
    private TextView iUU;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ilu).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iUB = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.iUC = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.iUD = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.iUE = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.iUF = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.iUG = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.iUM = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.iUH = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.iUI = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.iUJ = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.iUK = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.iUK.setLineSpacing(l.getDimens(this.ilu, R.dimen.tbds16), 1.0f);
        this.iUL = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.iUL.setLineSpacing(l.getDimens(this.ilu, R.dimen.tbds16), 1.0f);
        this.iUT = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.iUU = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.iUO = this.mRoot.findViewById(R.id.select_subject_layout);
        this.iUP = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.iUP.setClickable(true);
        this.iUP.setStarSpacing(l.getDimens(this.ilu, R.dimen.tbds24));
        this.iUQ = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.iUQ.setClickable(true);
        this.iUQ.setStarSpacing(l.getDimens(this.ilu, R.dimen.tbds24));
        this.iUN = this.mRoot.findViewById(R.id.divider);
        if (this.iUl != null) {
            this.iUD.setText(dh(this.iUl.getTags()));
            this.iUC.setText(this.iUl.getName());
            this.iUB.startLoad(this.iUl.icon_url, 10, false);
        }
        this.iUB.setPlaceHolder(2);
        this.iUB.setPageId(this.ilu.getUniqueId());
        this.iUB.setConrers(15);
        this.iUB.setRadius(l.getDimens(this.ilu, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.ilu, view);
                    return false;
                }
                return false;
            }
        });
        this.iUm.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.ilu.HidenSoftKeyPad(inputMethodManager, d.this.iUK);
                    d.this.ilu.HidenSoftKeyPad(inputMethodManager, d.this.iUL);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cCs() {
        this.iJO.setOnClickListener(this);
        this.iUk.setOnClickListener(this);
        this.iUO.setOnClickListener(this);
        this.iUK.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iUR = editable;
                if (d.this.iUR.length() > 500) {
                    d.this.iUT.setText((500 - d.this.iUR.length()) + "/500");
                    d.this.iUT.setVisibility(0);
                } else {
                    d.this.iUT.setVisibility(4);
                }
                d.this.cCw();
            }
        });
        this.iUL.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iUS = editable;
                if (d.this.iUS.length() > 500) {
                    d.this.iUU.setText((500 - d.this.iUS.length()) + "/500");
                    d.this.iUU.setVisibility(0);
                } else {
                    d.this.iUU.setVisibility(4);
                }
                d.this.cCw();
            }
        });
        this.iUK.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.iUK)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.iUL.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.iUL)) {
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
    public void cCw() {
        if (!TextUtils.isEmpty(this.iUR) && this.iUR.length() >= 20 && !TextUtils.isEmpty(this.iUS) && this.iUS.length() >= 20 && !this.ilu.getString(R.string.select_subject).equals(this.iUG.getText()) && this.iUR.length() <= 500 && this.iUS.length() <= 500) {
            this.iUk.setAlpha(1.0f);
        } else {
            this.iUk.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.iUN, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iUC, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUD, R.color.cp_cont_d);
        ap.setViewTextColor(this.iUE, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUF, R.color.cp_cont_b);
        if (this.ilu.getString(R.string.select_subject).equals(this.iUG.getText())) {
            ap.setViewTextColor(this.iUG, R.color.cp_cont_d);
            SvgManager.brn().a(this.iUM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.iUG, R.color.cp_cont_b);
            SvgManager.brn().a(this.iUM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.iUH, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUI, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUJ, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUK, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUL, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUT, R.color.cp_cont_h);
        ap.setViewTextColor(this.iUU, R.color.cp_cont_h);
        this.iUK.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.iUL.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.iUB != null) {
            this.iUB.setPlaceHolder(2);
            this.iUB.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iJO) {
            cCt();
        } else if (view == this.iUO) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.ilu, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.iUk) {
            if (TextUtils.isEmpty(this.iUR) || TextUtils.isEmpty(this.iUS) || this.ilu.getString(R.string.select_subject).equals(this.iUG.getText())) {
                l.showToast(this.ilu, R.string.university_comment_must_write_tip);
            } else if (this.iUR.length() < 20) {
                l.showToast(this.ilu, R.string.university_comment_size_error_tip);
            } else if (this.iUS.length() < 20) {
                l.showToast(this.ilu, R.string.subject_comment_size_error_tip);
            } else if (this.iUR.length() > 500) {
                l.showToast(this.ilu, R.string.university_comment_lenght_error_tip);
            } else if (this.iUS.length() > 500) {
                l.showToast(this.ilu, R.string.subject_comment_lenght_error_tip);
            } else {
                this.iUm.a("学校评价：" + ((Object) this.iUR) + "\n专业评价：" + ((Object) this.iUS), cCx(), this.iUj);
            }
        }
    }

    private String cCx() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.iUQ.getStarCount();
        int starCount2 = this.iUP.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.iUG.getText().toString(), 1));
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
                this.iUG.setText(stringExtra);
                ap.setViewTextColor(this.iUG, R.color.cp_cont_b);
                SvgManager.brn().a(this.iUM, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cCw();
            }
        }
    }

    private String dh(List<String> list) {
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
    public void bAC() {
        if (this.iUj != null) {
            WriteData writeData = new WriteData();
            int starCount = this.iUQ.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.iUP.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.iUG.getText().toString());
            writeData.setmUniversityComment(this.iUK.getText().toString());
            writeData.setmUniversitySubjectComment(this.iUL.getText().toString());
            x.c(String.valueOf(this.iUj.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cCu() {
        if (this.iUj != null) {
            x.f(String.valueOf(this.iUj.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.iUQ.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.iUQ.setStarCount(0);
                        }
                        try {
                            d.this.iUP.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.iUP.setStarCount(0);
                        }
                        d.this.iUG.setText(writeData.getmUniversitySubjectContent());
                        d.this.iUK.setText(writeData.getmUniversityComment());
                        d.this.iUL.setText(writeData.getmUniversitySubjectComment());
                    }
                }
            });
        }
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
