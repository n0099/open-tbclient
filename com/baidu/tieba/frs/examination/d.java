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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends a {
    private View igA;
    private RankStarView igB;
    private RankStarView igC;
    private Editable igD;
    private Editable igE;
    private TextView igF;
    private TextView igG;
    private TbImageView ign;
    private TextView igo;
    private TextView igp;
    private TextView igq;
    private TextView igr;
    private TextView igs;
    private TextView igt;
    private TextView igu;
    private TextView igv;
    private EditText igw;
    private EditText igx;
    private ImageView igy;
    private View igz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hwW).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ign = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.igo = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.igp = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.igq = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.igr = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.igs = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.igy = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.igt = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.igu = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.igv = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.igw = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.igw.setLineSpacing(l.getDimens(this.hwW, R.dimen.tbds16), 1.0f);
        this.igx = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.igx.setLineSpacing(l.getDimens(this.hwW, R.dimen.tbds16), 1.0f);
        this.igF = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.igG = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.igA = this.mRoot.findViewById(R.id.select_subject_layout);
        this.igB = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.igB.setClickable(true);
        this.igB.setStarSpacing(l.getDimens(this.hwW, R.dimen.tbds24));
        this.igC = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.igC.setClickable(true);
        this.igC.setStarSpacing(l.getDimens(this.hwW, R.dimen.tbds24));
        this.igz = this.mRoot.findViewById(R.id.divider);
        if (this.ifX != null) {
            this.igp.setText(cH(this.ifX.getTags()));
            this.igo.setText(this.ifX.getName());
            this.ign.startLoad(this.ifX.icon_url, 10, false);
        }
        this.ign.setPlaceHolder(2);
        this.ign.setPageId(this.hwW.getUniqueId());
        this.ign.setConrers(15);
        this.ign.setRadius(l.getDimens(this.hwW, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hwW, view);
                    return false;
                }
                return false;
            }
        });
        this.ifY.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hwW.HidenSoftKeyPad(inputMethodManager, d.this.igw);
                    d.this.hwW.HidenSoftKeyPad(inputMethodManager, d.this.igx);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cqa() {
        this.hVu.setOnClickListener(this);
        this.ifW.setOnClickListener(this);
        this.igA.setOnClickListener(this);
        this.igw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.igD = editable;
                if (d.this.igD.length() > 500) {
                    d.this.igF.setText((500 - d.this.igD.length()) + "/500");
                    d.this.igF.setVisibility(0);
                } else {
                    d.this.igF.setVisibility(4);
                }
                d.this.cqe();
            }
        });
        this.igx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.igE = editable;
                if (d.this.igE.length() > 500) {
                    d.this.igG.setText((500 - d.this.igE.length()) + "/500");
                    d.this.igG.setVisibility(0);
                } else {
                    d.this.igG.setVisibility(4);
                }
                d.this.cqe();
            }
        });
        this.igw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.d(d.this.igw)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.igx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.d(d.this.igx)) {
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
    public void cqe() {
        if (!TextUtils.isEmpty(this.igD) && this.igD.length() >= 20 && !TextUtils.isEmpty(this.igE) && this.igE.length() >= 20 && !this.hwW.getString(R.string.select_subject).equals(this.igs.getText()) && this.igD.length() <= 500 && this.igE.length() <= 500) {
            this.ifW.setAlpha(1.0f);
        } else {
            this.ifW.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.igz, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.igo, R.color.cp_cont_b);
        ap.setViewTextColor(this.igp, R.color.cp_cont_d);
        ap.setViewTextColor(this.igq, R.color.cp_cont_b);
        ap.setViewTextColor(this.igr, R.color.cp_cont_b);
        if (this.hwW.getString(R.string.select_subject).equals(this.igs.getText())) {
            ap.setViewTextColor(this.igs, R.color.cp_cont_d);
            SvgManager.bjq().a(this.igy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.igs, R.color.cp_cont_b);
            SvgManager.bjq().a(this.igy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.igt, R.color.cp_cont_b);
        ap.setViewTextColor(this.igu, R.color.cp_cont_b);
        ap.setViewTextColor(this.igv, R.color.cp_cont_b);
        ap.setViewTextColor(this.igw, R.color.cp_cont_b);
        ap.setViewTextColor(this.igx, R.color.cp_cont_b);
        ap.setViewTextColor(this.igF, R.color.cp_cont_h);
        ap.setViewTextColor(this.igG, R.color.cp_cont_h);
        this.igw.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.igx.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.ign != null) {
            this.ign.setPlaceHolder(2);
            this.ign.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVu) {
            cqb();
        } else if (view == this.igA) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hwW, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.ifW) {
            if (TextUtils.isEmpty(this.igD) || TextUtils.isEmpty(this.igE) || this.hwW.getString(R.string.select_subject).equals(this.igs.getText())) {
                l.showToast(this.hwW, R.string.university_comment_must_write_tip);
            } else if (this.igD.length() < 20) {
                l.showToast(this.hwW, R.string.university_comment_size_error_tip);
            } else if (this.igE.length() < 20) {
                l.showToast(this.hwW, R.string.subject_comment_size_error_tip);
            } else if (this.igD.length() > 500) {
                l.showToast(this.hwW, R.string.university_comment_lenght_error_tip);
            } else if (this.igE.length() > 500) {
                l.showToast(this.hwW, R.string.subject_comment_lenght_error_tip);
            } else {
                this.ifY.a("学校评价：" + ((Object) this.igD) + "\n专业评价：" + ((Object) this.igE), cqf(), this.ifV);
            }
        }
    }

    private String cqf() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.igC.getStarCount();
        int starCount2 = this.igB.getStarCount();
        if (starCount != 0) {
            arrayList.add(new u("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new u("专业", this.igs.getText().toString(), 1));
        if (starCount2 != 0) {
            arrayList.add(new u("专业评分", String.valueOf(starCount), 2));
        }
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.igs.setText(stringExtra);
                ap.setViewTextColor(this.igs, R.color.cp_cont_b);
                SvgManager.bjq().a(this.igy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cqe();
            }
        }
    }

    private String cH(List<String> list) {
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
    public void bsw() {
        if (this.ifV != null) {
            WriteData writeData = new WriteData();
            int starCount = this.igC.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.igB.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.igs.getText().toString());
            writeData.setmUniversityComment(this.igw.getText().toString());
            writeData.setmUniversitySubjectComment(this.igx.getText().toString());
            x.c(String.valueOf(this.ifV.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cqc() {
        if (this.ifV != null) {
            x.f(String.valueOf(this.ifV.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.igC.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.igC.setStarCount(0);
                        }
                        try {
                            d.this.igB.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.igB.setStarCount(0);
                        }
                        d.this.igs.setText(writeData.getmUniversitySubjectContent());
                        d.this.igw.setText(writeData.getmUniversityComment());
                        d.this.igx.setText(writeData.getmUniversitySubjectComment());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height + (-1);
    }
}
