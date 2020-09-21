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
/* loaded from: classes21.dex */
public class d extends a {
    private ImageView inA;
    private View inB;
    private View inC;
    private RankStarView inD;
    private RankStarView inE;
    private Editable inF;
    private Editable inG;
    private TextView inH;
    private TextView inI;
    private TbImageView ino;
    private TextView inp;
    private TextView inq;
    private TextView inr;

    /* renamed from: int  reason: not valid java name */
    private TextView f3int;
    private TextView inu;
    private TextView inv;
    private TextView inw;
    private TextView inx;
    private EditText iny;
    private EditText inz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hEa).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ino = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.inp = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.inq = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.inr = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.f3int = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.inu = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.inA = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.inv = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.inw = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.inx = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.iny = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.iny.setLineSpacing(l.getDimens(this.hEa, R.dimen.tbds16), 1.0f);
        this.inz = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.inz.setLineSpacing(l.getDimens(this.hEa, R.dimen.tbds16), 1.0f);
        this.inH = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.inI = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.inC = this.mRoot.findViewById(R.id.select_subject_layout);
        this.inD = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.inD.setClickable(true);
        this.inD.setStarSpacing(l.getDimens(this.hEa, R.dimen.tbds24));
        this.inE = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.inE.setClickable(true);
        this.inE.setStarSpacing(l.getDimens(this.hEa, R.dimen.tbds24));
        this.inB = this.mRoot.findViewById(R.id.divider);
        if (this.imY != null) {
            this.inq.setText(cN(this.imY.getTags()));
            this.inp.setText(this.imY.getName());
            this.ino.startLoad(this.imY.icon_url, 10, false);
        }
        this.ino.setPlaceHolder(2);
        this.ino.setPageId(this.hEa.getUniqueId());
        this.ino.setConrers(15);
        this.ino.setRadius(l.getDimens(this.hEa, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hEa, view);
                    return false;
                }
                return false;
            }
        });
        this.imZ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hEa.HidenSoftKeyPad(inputMethodManager, d.this.iny);
                    d.this.hEa.HidenSoftKeyPad(inputMethodManager, d.this.inz);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void ctn() {
        this.icu.setOnClickListener(this);
        this.imX.setOnClickListener(this);
        this.inC.setOnClickListener(this);
        this.iny.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.inF = editable;
                if (d.this.inF.length() > 500) {
                    d.this.inH.setText((500 - d.this.inF.length()) + "/500");
                    d.this.inH.setVisibility(0);
                } else {
                    d.this.inH.setVisibility(4);
                }
                d.this.ctr();
            }
        });
        this.inz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.inG = editable;
                if (d.this.inG.length() > 500) {
                    d.this.inI.setText((500 - d.this.inG.length()) + "/500");
                    d.this.inI.setVisibility(0);
                } else {
                    d.this.inI.setVisibility(4);
                }
                d.this.ctr();
            }
        });
        this.iny.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.iny)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.inz.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.inz)) {
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
    public void ctr() {
        if (!TextUtils.isEmpty(this.inF) && this.inF.length() >= 20 && !TextUtils.isEmpty(this.inG) && this.inG.length() >= 20 && !this.hEa.getString(R.string.select_subject).equals(this.inu.getText()) && this.inF.length() <= 500 && this.inG.length() <= 500) {
            this.imX.setAlpha(1.0f);
        } else {
            this.imX.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.inB, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.inp, R.color.cp_cont_b);
        ap.setViewTextColor(this.inq, R.color.cp_cont_d);
        ap.setViewTextColor(this.inr, R.color.cp_cont_b);
        ap.setViewTextColor(this.f3int, R.color.cp_cont_b);
        if (this.hEa.getString(R.string.select_subject).equals(this.inu.getText())) {
            ap.setViewTextColor(this.inu, R.color.cp_cont_d);
            SvgManager.bkl().a(this.inA, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.inu, R.color.cp_cont_b);
            SvgManager.bkl().a(this.inA, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.inv, R.color.cp_cont_b);
        ap.setViewTextColor(this.inw, R.color.cp_cont_b);
        ap.setViewTextColor(this.inx, R.color.cp_cont_b);
        ap.setViewTextColor(this.iny, R.color.cp_cont_b);
        ap.setViewTextColor(this.inz, R.color.cp_cont_b);
        ap.setViewTextColor(this.inH, R.color.cp_cont_h);
        ap.setViewTextColor(this.inI, R.color.cp_cont_h);
        this.iny.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.inz.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.ino != null) {
            this.ino.setPlaceHolder(2);
            this.ino.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.icu) {
            cto();
        } else if (view == this.inC) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hEa, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.imX) {
            if (TextUtils.isEmpty(this.inF) || TextUtils.isEmpty(this.inG) || this.hEa.getString(R.string.select_subject).equals(this.inu.getText())) {
                l.showToast(this.hEa, R.string.university_comment_must_write_tip);
            } else if (this.inF.length() < 20) {
                l.showToast(this.hEa, R.string.university_comment_size_error_tip);
            } else if (this.inG.length() < 20) {
                l.showToast(this.hEa, R.string.subject_comment_size_error_tip);
            } else if (this.inF.length() > 500) {
                l.showToast(this.hEa, R.string.university_comment_lenght_error_tip);
            } else if (this.inG.length() > 500) {
                l.showToast(this.hEa, R.string.subject_comment_lenght_error_tip);
            } else {
                this.imZ.a("学校评价：" + ((Object) this.inF) + "\n专业评价：" + ((Object) this.inG), cts(), this.imW);
            }
        }
    }

    private String cts() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.inE.getStarCount();
        int starCount2 = this.inD.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.inu.getText().toString(), 1));
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
                this.inu.setText(stringExtra);
                ap.setViewTextColor(this.inu, R.color.cp_cont_b);
                SvgManager.bkl().a(this.inA, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                ctr();
            }
        }
    }

    private String cN(List<String> list) {
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
    public void btA() {
        if (this.imW != null) {
            WriteData writeData = new WriteData();
            int starCount = this.inE.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.inD.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.inu.getText().toString());
            writeData.setmUniversityComment(this.iny.getText().toString());
            writeData.setmUniversitySubjectComment(this.inz.getText().toString());
            x.c(String.valueOf(this.imW.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void ctp() {
        if (this.imW != null) {
            x.f(String.valueOf(this.imW.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.inE.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.inE.setStarCount(0);
                        }
                        try {
                            d.this.inD.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.inD.setStarCount(0);
                        }
                        d.this.inu.setText(writeData.getmUniversitySubjectContent());
                        d.this.iny.setText(writeData.getmUniversityComment());
                        d.this.inz.setText(writeData.getmUniversitySubjectComment());
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
