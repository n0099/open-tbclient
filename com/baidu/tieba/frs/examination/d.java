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
    private TbImageView hRX;
    private TextView hRY;
    private TextView hRZ;
    private TextView hSa;
    private TextView hSb;
    private TextView hSc;
    private TextView hSd;
    private TextView hSe;
    private TextView hSf;
    private EditText hSg;
    private EditText hSh;
    private ImageView hSi;
    private View hSj;
    private View hSk;
    private RankStarView hSl;
    private RankStarView hSm;
    private Editable hSn;
    private Editable hSo;
    private TextView hSp;
    private TextView hSq;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hjZ).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hRX = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.hRY = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.hRZ = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.hSa = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.hSb = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.hSc = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.hSi = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.hSd = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.hSe = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.hSf = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.hSg = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.hSg.setLineSpacing(l.getDimens(this.hjZ, R.dimen.tbds16), 1.0f);
        this.hSh = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.hSh.setLineSpacing(l.getDimens(this.hjZ, R.dimen.tbds16), 1.0f);
        this.hSp = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.hSq = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.hSk = this.mRoot.findViewById(R.id.select_subject_layout);
        this.hSl = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.hSl.setClickable(true);
        this.hSl.setStarSpacing(l.getDimens(this.hjZ, R.dimen.tbds24));
        this.hSm = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.hSm.setClickable(true);
        this.hSm.setStarSpacing(l.getDimens(this.hjZ, R.dimen.tbds24));
        this.hSj = this.mRoot.findViewById(R.id.divider);
        if (this.hRH != null) {
            this.hRZ.setText(cF(this.hRH.getTags()));
            this.hRY.setText(this.hRH.getName());
            this.hRX.startLoad(this.hRH.icon_url, 10, false);
        }
        this.hRX.setPlaceHolder(2);
        this.hRX.setPageId(this.hjZ.getUniqueId());
        this.hRX.setConrers(15);
        this.hRX.setRadius(l.getDimens(this.hjZ, R.dimen.tbds10));
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
        this.hRI.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hjZ.HidenSoftKeyPad(inputMethodManager, d.this.hSg);
                    d.this.hjZ.HidenSoftKeyPad(inputMethodManager, d.this.hSh);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cfu() {
        this.hHY.setOnClickListener(this);
        this.hRG.setOnClickListener(this);
        this.hSk.setOnClickListener(this);
        this.hSg.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hSn = editable;
                if (d.this.hSn.length() > 500) {
                    d.this.hSp.setText((500 - d.this.hSn.length()) + "/500");
                    d.this.hSp.setVisibility(0);
                } else {
                    d.this.hSp.setVisibility(4);
                }
                d.this.cfy();
            }
        });
        this.hSh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hSo = editable;
                if (d.this.hSo.length() > 500) {
                    d.this.hSq.setText((500 - d.this.hSo.length()) + "/500");
                    d.this.hSq.setVisibility(0);
                } else {
                    d.this.hSq.setVisibility(4);
                }
                d.this.cfy();
            }
        });
        this.hSg.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.hSg)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.hSh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.hSh)) {
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
        if (!TextUtils.isEmpty(this.hSn) && this.hSn.length() >= 20 && !TextUtils.isEmpty(this.hSo) && this.hSo.length() >= 20 && !this.hjZ.getString(R.string.select_subject).equals(this.hSc.getText()) && this.hSn.length() <= 500 && this.hSo.length() <= 500) {
            this.hRG.setAlpha(1.0f);
        } else {
            this.hRG.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.hSj, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.hRY, R.color.cp_cont_b);
        ao.setViewTextColor(this.hRZ, R.color.cp_cont_d);
        ao.setViewTextColor(this.hSa, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSb, R.color.cp_cont_b);
        if (this.hjZ.getString(R.string.select_subject).equals(this.hSc.getText())) {
            ao.setViewTextColor(this.hSc, R.color.cp_cont_d);
            SvgManager.baR().a(this.hSi, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ao.setViewTextColor(this.hSc, R.color.cp_cont_b);
            SvgManager.baR().a(this.hSi, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ao.setViewTextColor(this.hSd, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSe, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSf, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSg, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSh, R.color.cp_cont_b);
        ao.setViewTextColor(this.hSp, R.color.cp_cont_h);
        ao.setViewTextColor(this.hSq, R.color.cp_cont_h);
        this.hSg.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        this.hSh.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        if (this.hRX != null) {
            this.hRX.setPlaceHolder(2);
            this.hRX.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHY) {
            cfv();
        } else if (view == this.hSk) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hjZ, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.hRG) {
            if (TextUtils.isEmpty(this.hSn) || TextUtils.isEmpty(this.hSo) || this.hjZ.getString(R.string.select_subject).equals(this.hSc.getText())) {
                l.showToast(this.hjZ, R.string.university_comment_must_write_tip);
            } else if (this.hSn.length() < 20) {
                l.showToast(this.hjZ, R.string.university_comment_size_error_tip);
            } else if (this.hSo.length() < 20) {
                l.showToast(this.hjZ, R.string.subject_comment_size_error_tip);
            } else if (this.hSn.length() > 500) {
                l.showToast(this.hjZ, R.string.university_comment_lenght_error_tip);
            } else if (this.hSo.length() > 500) {
                l.showToast(this.hjZ, R.string.subject_comment_lenght_error_tip);
            } else {
                this.hRI.a("学校评价：" + ((Object) this.hSn) + "\n专业评价：" + ((Object) this.hSo), cfz(), this.hRF);
            }
        }
    }

    private String cfz() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.hSm.getStarCount();
        int starCount2 = this.hSl.getStarCount();
        if (starCount != 0) {
            arrayList.add(new r("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new r("专业", this.hSc.getText().toString(), 1));
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
                this.hSc.setText(stringExtra);
                ao.setViewTextColor(this.hSc, R.color.cp_cont_b);
                SvgManager.baR().a(this.hSi, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        if (this.hRF != null) {
            WriteData writeData = new WriteData();
            int starCount = this.hSm.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.hSl.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.hSc.getText().toString());
            writeData.setmUniversityComment(this.hSg.getText().toString());
            writeData.setmUniversitySubjectComment(this.hSh.getText().toString());
            w.c(String.valueOf(this.hRF.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cfw() {
        if (this.hRF != null) {
            w.f(String.valueOf(this.hRF.forumId), new w.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.hSm.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.hSm.setStarCount(0);
                        }
                        try {
                            d.this.hSl.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.hSl.setStarCount(0);
                        }
                        d.this.hSc.setText(writeData.getmUniversitySubjectContent());
                        d.this.hSg.setText(writeData.getmUniversityComment());
                        d.this.hSh.setText(writeData.getmUniversitySubjectComment());
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
