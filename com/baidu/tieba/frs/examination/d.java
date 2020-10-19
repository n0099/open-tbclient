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
    private TextView iCA;
    private TextView iCB;
    private TbImageView iCi;
    private TextView iCj;
    private TextView iCk;
    private TextView iCl;
    private TextView iCm;
    private TextView iCn;
    private TextView iCo;
    private TextView iCp;
    private TextView iCq;
    private EditText iCr;
    private EditText iCs;
    private ImageView iCt;
    private View iCu;
    private View iCv;
    private RankStarView iCw;
    private RankStarView iCx;
    private Editable iCy;
    private Editable iCz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hSW).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iCi = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.iCj = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.iCk = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.iCl = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.iCm = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.iCn = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.iCt = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.iCo = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.iCp = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.iCq = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.iCr = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.iCr.setLineSpacing(l.getDimens(this.hSW, R.dimen.tbds16), 1.0f);
        this.iCs = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.iCs.setLineSpacing(l.getDimens(this.hSW, R.dimen.tbds16), 1.0f);
        this.iCA = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.iCB = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.iCv = this.mRoot.findViewById(R.id.select_subject_layout);
        this.iCw = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.iCw.setClickable(true);
        this.iCw.setStarSpacing(l.getDimens(this.hSW, R.dimen.tbds24));
        this.iCx = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.iCx.setClickable(true);
        this.iCx.setStarSpacing(l.getDimens(this.hSW, R.dimen.tbds24));
        this.iCu = this.mRoot.findViewById(R.id.divider);
        if (this.iBS != null) {
            this.iCk.setText(cQ(this.iBS.getTags()));
            this.iCj.setText(this.iBS.getName());
            this.iCi.startLoad(this.iBS.icon_url, 10, false);
        }
        this.iCi.setPlaceHolder(2);
        this.iCi.setPageId(this.hSW.getUniqueId());
        this.iCi.setConrers(15);
        this.iCi.setRadius(l.getDimens(this.hSW, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hSW, view);
                    return false;
                }
                return false;
            }
        });
        this.iBT.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hSW.HidenSoftKeyPad(inputMethodManager, d.this.iCr);
                    d.this.hSW.HidenSoftKeyPad(inputMethodManager, d.this.iCs);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cwK() {
        this.irv.setOnClickListener(this);
        this.iBR.setOnClickListener(this);
        this.iCv.setOnClickListener(this);
        this.iCr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iCy = editable;
                if (d.this.iCy.length() > 500) {
                    d.this.iCA.setText((500 - d.this.iCy.length()) + "/500");
                    d.this.iCA.setVisibility(0);
                } else {
                    d.this.iCA.setVisibility(4);
                }
                d.this.cwO();
            }
        });
        this.iCs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iCz = editable;
                if (d.this.iCz.length() > 500) {
                    d.this.iCB.setText((500 - d.this.iCz.length()) + "/500");
                    d.this.iCB.setVisibility(0);
                } else {
                    d.this.iCB.setVisibility(4);
                }
                d.this.cwO();
            }
        });
        this.iCr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.iCr)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.iCs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.iCs)) {
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
    public void cwO() {
        if (!TextUtils.isEmpty(this.iCy) && this.iCy.length() >= 20 && !TextUtils.isEmpty(this.iCz) && this.iCz.length() >= 20 && !this.hSW.getString(R.string.select_subject).equals(this.iCn.getText()) && this.iCy.length() <= 500 && this.iCz.length() <= 500) {
            this.iBR.setAlpha(1.0f);
        } else {
            this.iBR.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.iCu, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iCj, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCk, R.color.cp_cont_d);
        ap.setViewTextColor(this.iCl, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCm, R.color.cp_cont_b);
        if (this.hSW.getString(R.string.select_subject).equals(this.iCn.getText())) {
            ap.setViewTextColor(this.iCn, R.color.cp_cont_d);
            SvgManager.bmU().a(this.iCt, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.iCn, R.color.cp_cont_b);
            SvgManager.bmU().a(this.iCt, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.iCo, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCp, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCq, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCr, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCs, R.color.cp_cont_b);
        ap.setViewTextColor(this.iCA, R.color.cp_cont_h);
        ap.setViewTextColor(this.iCB, R.color.cp_cont_h);
        this.iCr.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.iCs.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.iCi != null) {
            this.iCi.setPlaceHolder(2);
            this.iCi.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.irv) {
            cwL();
        } else if (view == this.iCv) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hSW, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.iBR) {
            if (TextUtils.isEmpty(this.iCy) || TextUtils.isEmpty(this.iCz) || this.hSW.getString(R.string.select_subject).equals(this.iCn.getText())) {
                l.showToast(this.hSW, R.string.university_comment_must_write_tip);
            } else if (this.iCy.length() < 20) {
                l.showToast(this.hSW, R.string.university_comment_size_error_tip);
            } else if (this.iCz.length() < 20) {
                l.showToast(this.hSW, R.string.subject_comment_size_error_tip);
            } else if (this.iCy.length() > 500) {
                l.showToast(this.hSW, R.string.university_comment_lenght_error_tip);
            } else if (this.iCz.length() > 500) {
                l.showToast(this.hSW, R.string.subject_comment_lenght_error_tip);
            } else {
                this.iBT.a("学校评价：" + ((Object) this.iCy) + "\n专业评价：" + ((Object) this.iCz), cwP(), this.iBQ);
            }
        }
    }

    private String cwP() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.iCx.getStarCount();
        int starCount2 = this.iCw.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.iCn.getText().toString(), 1));
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
                this.iCn.setText(stringExtra);
                ap.setViewTextColor(this.iCn, R.color.cp_cont_b);
                SvgManager.bmU().a(this.iCt, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cwO();
            }
        }
    }

    private String cQ(List<String> list) {
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
    public void bwk() {
        if (this.iBQ != null) {
            WriteData writeData = new WriteData();
            int starCount = this.iCx.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.iCw.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.iCn.getText().toString());
            writeData.setmUniversityComment(this.iCr.getText().toString());
            writeData.setmUniversitySubjectComment(this.iCs.getText().toString());
            x.c(String.valueOf(this.iBQ.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cwM() {
        if (this.iBQ != null) {
            x.f(String.valueOf(this.iBQ.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.iCx.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.iCx.setStarCount(0);
                        }
                        try {
                            d.this.iCw.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.iCw.setStarCount(0);
                        }
                        d.this.iCn.setText(writeData.getmUniversitySubjectContent());
                        d.this.iCr.setText(writeData.getmUniversityComment());
                        d.this.iCs.setText(writeData.getmUniversitySubjectComment());
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
