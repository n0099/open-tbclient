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
import com.baidu.tbadk.core.util.an;
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
/* loaded from: classes9.dex */
public class d extends a {
    private TbImageView hLY;
    private TextView hLZ;
    private TextView hMa;
    private TextView hMb;
    private TextView hMc;
    private TextView hMd;
    private TextView hMe;
    private TextView hMf;
    private TextView hMg;
    private EditText hMh;
    private EditText hMi;
    private ImageView hMj;
    private View hMk;
    private View hMl;
    private RankStarView hMm;
    private RankStarView hMn;
    private Editable hMo;
    private Editable hMp;
    private TextView hMq;
    private TextView hMr;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hep).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hLY = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.hLZ = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.hMa = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.hMb = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.hMc = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.hMd = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.hMj = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.hMe = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.hMf = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.hMg = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.hMh = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.hMh.setLineSpacing(l.getDimens(this.hep, R.dimen.tbds16), 1.0f);
        this.hMi = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.hMi.setLineSpacing(l.getDimens(this.hep, R.dimen.tbds16), 1.0f);
        this.hMq = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.hMr = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.hMl = this.mRoot.findViewById(R.id.select_subject_layout);
        this.hMm = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.hMm.setClickable(true);
        this.hMm.setStarSpacing(l.getDimens(this.hep, R.dimen.tbds24));
        this.hMn = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.hMn.setClickable(true);
        this.hMn.setStarSpacing(l.getDimens(this.hep, R.dimen.tbds24));
        this.hMk = this.mRoot.findViewById(R.id.divider);
        if (this.hLI != null) {
            this.hMa.setText(cA(this.hLI.getTags()));
            this.hLZ.setText(this.hLI.getName());
            this.hLY.startLoad(this.hLI.icon_url, 10, false);
        }
        this.hLY.setPlaceHolder(2);
        this.hLY.setPageId(this.hep.getUniqueId());
        this.hLY.setConrers(15);
        this.hLY.setRadius(l.getDimens(this.hep, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.hep, view);
                    return false;
                }
                return false;
            }
        });
        this.hLJ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.hep.HidenSoftKeyPad(inputMethodManager, d.this.hMh);
                    d.this.hep.HidenSoftKeyPad(inputMethodManager, d.this.hMi);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cbV() {
        this.hCa.setOnClickListener(this);
        this.hLH.setOnClickListener(this);
        this.hMl.setOnClickListener(this);
        this.hMh.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hMo = editable;
                if (d.this.hMo.length() > 500) {
                    d.this.hMq.setText((500 - d.this.hMo.length()) + "/500");
                    d.this.hMq.setVisibility(0);
                } else {
                    d.this.hMq.setVisibility(4);
                }
                d.this.cbZ();
            }
        });
        this.hMi.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.hMp = editable;
                if (d.this.hMp.length() > 500) {
                    d.this.hMr.setText((500 - d.this.hMp.length()) + "/500");
                    d.this.hMr.setVisibility(0);
                } else {
                    d.this.hMr.setVisibility(4);
                }
                d.this.cbZ();
            }
        });
        this.hMh.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.hMh)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.hMi.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.hMi)) {
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
    public void cbZ() {
        if (!TextUtils.isEmpty(this.hMo) && this.hMo.length() >= 20 && !TextUtils.isEmpty(this.hMp) && this.hMp.length() >= 20 && !this.hep.getString(R.string.select_subject).equals(this.hMd.getText()) && this.hMo.length() <= 500 && this.hMp.length() <= 500) {
            this.hLH.setAlpha(1.0f);
        } else {
            this.hLH.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        an.setBackgroundColor(this.hMk, R.color.cp_bg_line_c);
        an.setViewTextColor(this.hLZ, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMa, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hMb, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMc, (int) R.color.cp_cont_b);
        if (this.hep.getString(R.string.select_subject).equals(this.hMd.getText())) {
            an.setViewTextColor(this.hMd, (int) R.color.cp_cont_d);
            SvgManager.aWQ().a(this.hMj, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            an.setViewTextColor(this.hMd, (int) R.color.cp_cont_b);
            SvgManager.aWQ().a(this.hMj, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        an.setViewTextColor(this.hMe, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMf, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMg, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMh, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMi, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hMq, (int) R.color.cp_cont_h);
        an.setViewTextColor(this.hMr, (int) R.color.cp_cont_h);
        this.hMh.setHintTextColor(an.getColor(R.color.cp_cont_d));
        this.hMi.setHintTextColor(an.getColor(R.color.cp_cont_d));
        if (this.hLY != null) {
            this.hLY.setPlaceHolder(2);
            this.hLY.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCa) {
            cbW();
        } else if (view == this.hMl) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.hep, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.hLH) {
            if (TextUtils.isEmpty(this.hMo) || TextUtils.isEmpty(this.hMp) || this.hep.getString(R.string.select_subject).equals(this.hMd.getText())) {
                l.showToast(this.hep, (int) R.string.university_comment_must_write_tip);
            } else if (this.hMo.length() < 20) {
                l.showToast(this.hep, (int) R.string.university_comment_size_error_tip);
            } else if (this.hMp.length() < 20) {
                l.showToast(this.hep, (int) R.string.subject_comment_size_error_tip);
            } else if (this.hMo.length() > 500) {
                l.showToast(this.hep, (int) R.string.university_comment_lenght_error_tip);
            } else if (this.hMp.length() > 500) {
                l.showToast(this.hep, (int) R.string.subject_comment_lenght_error_tip);
            } else {
                this.hLJ.a("学校评价：" + ((Object) this.hMo) + "\n专业评价：" + ((Object) this.hMp), cca(), this.hLG);
            }
        }
    }

    private String cca() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.hMn.getStarCount();
        int starCount2 = this.hMm.getStarCount();
        if (starCount != 0) {
            arrayList.add(new r("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new r("专业", this.hMd.getText().toString(), 1));
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
                this.hMd.setText(stringExtra);
                an.setViewTextColor(this.hMd, (int) R.color.cp_cont_b);
                SvgManager.aWQ().a(this.hMj, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cbZ();
            }
        }
    }

    private String cA(List<String> list) {
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
    public void bfY() {
        if (this.hLG != null) {
            WriteData writeData = new WriteData();
            int starCount = this.hMn.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.hMm.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.hMd.getText().toString());
            writeData.setmUniversityComment(this.hMh.getText().toString());
            writeData.setmUniversitySubjectComment(this.hMi.getText().toString());
            w.c(String.valueOf(this.hLG.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cbX() {
        if (this.hLG != null) {
            w.f(String.valueOf(this.hLG.forumId), new w.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.hMn.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.hMn.setStarCount(0);
                        }
                        try {
                            d.this.hMm.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.hMm.setStarCount(0);
                        }
                        d.this.hMd.setText(writeData.getmUniversitySubjectContent());
                        d.this.hMh.setText(writeData.getmUniversityComment());
                        d.this.hMi.setText(writeData.getmUniversitySubjectComment());
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
