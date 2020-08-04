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
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class d extends a {
    private TbImageView hRZ;
    private TextView hSa;
    private TextView hSb;
    private TextView hSc;
    private TextView hSd;
    private TextView hSe;
    private TextView hSf;
    private TextView hSg;
    private TextView hSh;
    private EditText hSi;
    private EditText hSj;
    private ImageView hSk;
    private View hSl;
    private View hSm;
    private RankStarView hSn;
    private RankStarView hSo;
    private Editable hSp;
    private Editable hSq;
    private TextView hSr;
    private TextView hSs;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hjZ).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hRZ = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.hSa = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.hSb = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.hSc = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.hSd = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.hSe = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.hSk = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.hSf = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.hSg = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.hSh = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.hSi = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.hSi.setLineSpacing(l.getDimens(this.hjZ, R.dimen.tbds16), 1.0f);
        this.hSj = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.hSj.setLineSpacing(l.getDimens(this.hjZ, R.dimen.tbds16), 1.0f);
        this.hSr = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.hSs = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.hSm = this.mRoot.findViewById(R.id.select_subject_layout);
        this.hSn = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.hSn.setClickable(true);
        this.hSn.setStarSpacing(l.getDimens(this.hjZ, R.dimen.tbds24));
        this.hSo = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.hSo.setClickable(true);
        this.hSo.setStarSpacing(l.getDimens(this.hjZ, R.dimen.tbds24));
        this.hSl = this.mRoot.findViewById(R.id.divider);
        if (this.hRJ != null) {
            this.hSb.setText(cF(this.hRJ.getTags()));
            this.hSa.setText(this.hRJ.getName());
            this.hRZ.startLoad(this.hRJ.icon_url, 10, false);
        }
        this.hRZ.setPlaceHolder(2);
        this.hRZ.setPageId(this.hjZ.getUniqueId());
        this.hRZ.setConrers(15);
        this.hRZ.setRadius(l.getDimens(this.hjZ, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hjZ, view);
                    return false;
                }
                return false;
            }
        });
        this.hRK.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hjZ.HidenSoftKeyPad(inputMethodManager, d.this.hSi);
                    d.this.hjZ.HidenSoftKeyPad(inputMethodManager, d.this.hSj);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cfu() {
        this.hHY.setOnClickListener(this);
        this.hRI.setOnClickListener(this);
        this.hSm.setOnClickListener(this);
        this.hSi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hSp = editable;
                if (d.this.hSp.length() > 500) {
                    d.this.hSr.setText((500 - d.this.hSp.length()) + "/500");
                    d.this.hSr.setVisibility(0);
                } else {
                    d.this.hSr.setVisibility(4);
                }
                d.this.cfy();
            }
        });
        this.hSj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hSq = editable;
                if (d.this.hSq.length() > 500) {
                    d.this.hSs.setText((500 - d.this.hSq.length()) + "/500");
                    d.this.hSs.setVisibility(0);
                } else {
                    d.this.hSs.setVisibility(4);
                }
                d.this.cfy();
            }
        });
        this.hSi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.hSi)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.hSj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.hSj)) {
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
    public void cfy() {
        if (!TextUtils.isEmpty(this.hSp) && this.hSp.length() >= 20 && !TextUtils.isEmpty(this.hSq) && this.hSq.length() >= 20 && !this.hjZ.getString(R.string.select_subject).equals(this.hSe.getText()) && this.hSp.length() <= 500 && this.hSq.length() <= 500) {
            this.hRI.setAlpha(1.0f);
        } else {
            this.hRI.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.hSl, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.hSa, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSb, R.color.cp_cont_d);
        ao.setViewTextColor(this.hSc, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSd, R.color.cp_cont_b);
        if (this.hjZ.getString(R.string.select_subject).equals(this.hSe.getText())) {
            ao.setViewTextColor(this.hSe, R.color.cp_cont_d);
            SvgManager.baR().a(this.hSk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ao.setViewTextColor(this.hSe, R.color.cp_cont_b);
            SvgManager.baR().a(this.hSk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ao.setViewTextColor(this.hSf, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSg, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSh, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSi, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSj, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSr, R.color.cp_cont_h);
        ao.setViewTextColor(this.hSs, R.color.cp_cont_h);
        this.hSi.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        this.hSj.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        if (this.hRZ != null) {
            this.hRZ.setPlaceHolder(2);
            this.hRZ.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHY) {
            cfv();
        } else if (view == this.hSm) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hjZ, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.hRI) {
            if (TextUtils.isEmpty(this.hSp) || TextUtils.isEmpty(this.hSq) || this.hjZ.getString(R.string.select_subject).equals(this.hSe.getText())) {
                l.showToast(this.hjZ, R.string.university_comment_must_write_tip);
            } else if (this.hSp.length() < 20) {
                l.showToast(this.hjZ, R.string.university_comment_size_error_tip);
            } else if (this.hSq.length() < 20) {
                l.showToast(this.hjZ, R.string.subject_comment_size_error_tip);
            } else if (this.hSp.length() > 500) {
                l.showToast(this.hjZ, R.string.university_comment_lenght_error_tip);
            } else if (this.hSq.length() > 500) {
                l.showToast(this.hjZ, R.string.subject_comment_lenght_error_tip);
            } else {
                this.hRK.a("学校评价：" + ((Object) this.hSp) + "\n专业评价：" + ((Object) this.hSq), cfz(), this.hRH);
            }
        }
    }

    private String cfz() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.hSo.getStarCount();
        int starCount2 = this.hSn.getStarCount();
        if (starCount != 0) {
            arrayList.add(new r("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new r("专业", this.hSe.getText().toString(), 1));
        if (starCount2 != 0) {
            arrayList.add(new r("专业评分", String.valueOf(starCount), 2));
        }
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1 && intent != null && i == 25047) {
            String stringExtra = intent.getStringExtra(IntentConfig.SEARCH_MAJOR_NAME);
            if (!TextUtils.isEmpty(stringExtra)) {
                this.hSe.setText(stringExtra);
                ao.setViewTextColor(this.hSe, R.color.cp_cont_b);
                SvgManager.baR().a(this.hSk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cfy();
            }
        }
    }

    private String cF(List<String> list) {
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
    public void bjJ() {
        if (this.hRH != null) {
            WriteData writeData = new WriteData();
            int starCount = this.hSo.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.hSn.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.hSe.getText().toString());
            writeData.setmUniversityComment(this.hSi.getText().toString());
            writeData.setmUniversitySubjectComment(this.hSj.getText().toString());
            w.c(String.valueOf(this.hRH.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cfw() {
        if (this.hRH != null) {
            w.f(String.valueOf(this.hRH.forumId), new w.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.hSo.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.hSo.setStarCount(0);
                        }
                        try {
                            d.this.hSn.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.hSn.setStarCount(0);
                        }
                        d.this.hSe.setText(writeData.getmUniversitySubjectContent());
                        d.this.hSi.setText(writeData.getmUniversityComment());
                        d.this.hSj.setText(writeData.getmUniversitySubjectComment());
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
