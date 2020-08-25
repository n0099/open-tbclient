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
    private TextView igA;
    private TbImageView igh;
    private TextView igi;
    private TextView igj;
    private TextView igk;
    private TextView igl;
    private TextView igm;
    private TextView ign;
    private TextView igo;
    private TextView igp;
    private EditText igq;
    private EditText igr;
    private ImageView igs;
    private View igt;
    private View igu;
    private RankStarView igv;
    private RankStarView igw;
    private Editable igx;
    private Editable igy;
    private TextView igz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hwQ).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.igh = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.igi = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.igj = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.igk = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.igl = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.igm = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.igs = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.ign = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.igo = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.igp = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.igq = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.igq.setLineSpacing(l.getDimens(this.hwQ, R.dimen.tbds16), 1.0f);
        this.igr = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.igr.setLineSpacing(l.getDimens(this.hwQ, R.dimen.tbds16), 1.0f);
        this.igz = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.igA = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.igu = this.mRoot.findViewById(R.id.select_subject_layout);
        this.igv = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.igv.setClickable(true);
        this.igv.setStarSpacing(l.getDimens(this.hwQ, R.dimen.tbds24));
        this.igw = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.igw.setClickable(true);
        this.igw.setStarSpacing(l.getDimens(this.hwQ, R.dimen.tbds24));
        this.igt = this.mRoot.findViewById(R.id.divider);
        if (this.ifR != null) {
            this.igj.setText(cH(this.ifR.getTags()));
            this.igi.setText(this.ifR.getName());
            this.igh.startLoad(this.ifR.icon_url, 10, false);
        }
        this.igh.setPlaceHolder(2);
        this.igh.setPageId(this.hwQ.getUniqueId());
        this.igh.setConrers(15);
        this.igh.setRadius(l.getDimens(this.hwQ, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hwQ, view);
                    return false;
                }
                return false;
            }
        });
        this.ifS.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hwQ.HidenSoftKeyPad(inputMethodManager, d.this.igq);
                    d.this.hwQ.HidenSoftKeyPad(inputMethodManager, d.this.igr);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cpZ() {
        this.hVo.setOnClickListener(this);
        this.ifQ.setOnClickListener(this);
        this.igu.setOnClickListener(this);
        this.igq.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.igx = editable;
                if (d.this.igx.length() > 500) {
                    d.this.igz.setText((500 - d.this.igx.length()) + "/500");
                    d.this.igz.setVisibility(0);
                } else {
                    d.this.igz.setVisibility(4);
                }
                d.this.cqd();
            }
        });
        this.igr.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.igy = editable;
                if (d.this.igy.length() > 500) {
                    d.this.igA.setText((500 - d.this.igy.length()) + "/500");
                    d.this.igA.setVisibility(0);
                } else {
                    d.this.igA.setVisibility(4);
                }
                d.this.cqd();
            }
        });
        this.igq.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.d(d.this.igq)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.igr.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.d(d.this.igr)) {
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
    public void cqd() {
        if (!TextUtils.isEmpty(this.igx) && this.igx.length() >= 20 && !TextUtils.isEmpty(this.igy) && this.igy.length() >= 20 && !this.hwQ.getString(R.string.select_subject).equals(this.igm.getText()) && this.igx.length() <= 500 && this.igy.length() <= 500) {
            this.ifQ.setAlpha(1.0f);
        } else {
            this.ifQ.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.igt, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.igi, R.color.cp_cont_b);
        ap.setViewTextColor(this.igj, R.color.cp_cont_d);
        ap.setViewTextColor(this.igk, R.color.cp_cont_b);
        ap.setViewTextColor(this.igl, R.color.cp_cont_b);
        if (this.hwQ.getString(R.string.select_subject).equals(this.igm.getText())) {
            ap.setViewTextColor(this.igm, R.color.cp_cont_d);
            SvgManager.bjq().a(this.igs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.igm, R.color.cp_cont_b);
            SvgManager.bjq().a(this.igs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.ign, R.color.cp_cont_b);
        ap.setViewTextColor(this.igo, R.color.cp_cont_b);
        ap.setViewTextColor(this.igp, R.color.cp_cont_b);
        ap.setViewTextColor(this.igq, R.color.cp_cont_b);
        ap.setViewTextColor(this.igr, R.color.cp_cont_b);
        ap.setViewTextColor(this.igz, R.color.cp_cont_h);
        ap.setViewTextColor(this.igA, R.color.cp_cont_h);
        this.igq.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.igr.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.igh != null) {
            this.igh.setPlaceHolder(2);
            this.igh.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVo) {
            cqa();
        } else if (view == this.igu) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hwQ, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.ifQ) {
            if (TextUtils.isEmpty(this.igx) || TextUtils.isEmpty(this.igy) || this.hwQ.getString(R.string.select_subject).equals(this.igm.getText())) {
                l.showToast(this.hwQ, R.string.university_comment_must_write_tip);
            } else if (this.igx.length() < 20) {
                l.showToast(this.hwQ, R.string.university_comment_size_error_tip);
            } else if (this.igy.length() < 20) {
                l.showToast(this.hwQ, R.string.subject_comment_size_error_tip);
            } else if (this.igx.length() > 500) {
                l.showToast(this.hwQ, R.string.university_comment_lenght_error_tip);
            } else if (this.igy.length() > 500) {
                l.showToast(this.hwQ, R.string.subject_comment_lenght_error_tip);
            } else {
                this.ifS.a("学校评价：" + ((Object) this.igx) + "\n专业评价：" + ((Object) this.igy), cqe(), this.ifP);
            }
        }
    }

    private String cqe() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.igw.getStarCount();
        int starCount2 = this.igv.getStarCount();
        if (starCount != 0) {
            arrayList.add(new u("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new u("专业", this.igm.getText().toString(), 1));
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
                this.igm.setText(stringExtra);
                ap.setViewTextColor(this.igm, R.color.cp_cont_b);
                SvgManager.bjq().a(this.igs, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cqd();
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
    public void bsv() {
        if (this.ifP != null) {
            WriteData writeData = new WriteData();
            int starCount = this.igw.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.igv.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.igm.getText().toString());
            writeData.setmUniversityComment(this.igq.getText().toString());
            writeData.setmUniversitySubjectComment(this.igr.getText().toString());
            x.c(String.valueOf(this.ifP.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cqb() {
        if (this.ifP != null) {
            x.f(String.valueOf(this.ifP.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.igw.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.igw.setStarCount(0);
                        }
                        try {
                            d.this.igv.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.igv.setStarCount(0);
                        }
                        d.this.igm.setText(writeData.getmUniversitySubjectContent());
                        d.this.igq.setText(writeData.getmUniversityComment());
                        d.this.igr.setText(writeData.getmUniversitySubjectComment());
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
