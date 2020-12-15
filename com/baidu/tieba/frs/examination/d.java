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
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends a {
    private RankStarView jgA;
    private Editable jgB;
    private Editable jgC;
    private TextView jgD;
    private TextView jgE;
    private TbImageView jgl;
    private TextView jgm;
    private TextView jgn;
    private TextView jgo;
    private TextView jgp;
    private TextView jgq;
    private TextView jgr;
    private TextView jgs;
    private TextView jgt;
    private EditText jgu;
    private EditText jgv;
    private ImageView jgw;
    private View jgx;
    private View jgy;
    private RankStarView jgz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ixe).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jgl = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jgm = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jgn = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.jgo = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jgp = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jgq = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.jgw = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jgr = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jgs = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jgt = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jgu = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jgu.setLineSpacing(l.getDimens(this.ixe, R.dimen.tbds16), 1.0f);
        this.jgv = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jgv.setLineSpacing(l.getDimens(this.ixe, R.dimen.tbds16), 1.0f);
        this.jgD = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jgE = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jgy = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jgz = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jgz.setClickable(true);
        this.jgz.setStarSpacing(l.getDimens(this.ixe, R.dimen.tbds24));
        this.jgA = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jgA.setClickable(true);
        this.jgA.setStarSpacing(l.getDimens(this.ixe, R.dimen.tbds24));
        this.jgx = this.mRoot.findViewById(R.id.divider);
        if (this.jfV != null) {
            this.jgn.setText(dl(this.jfV.getTags()));
            this.jgm.setText(this.jfV.getName());
            this.jgl.startLoad(this.jfV.icon_url, 10, false);
        }
        this.jgl.setPlaceHolder(2);
        this.jgl.setPageId(this.ixe.getUniqueId());
        this.jgl.setConrers(15);
        this.jgl.setRadius(l.getDimens(this.ixe, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.ixe, view);
                    return false;
                }
                return false;
            }
        });
        this.jfW.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.ixe.HidenSoftKeyPad(inputMethodManager, d.this.jgu);
                    d.this.ixe.HidenSoftKeyPad(inputMethodManager, d.this.jgv);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGq() {
        this.iVw.setOnClickListener(this);
        this.jfU.setOnClickListener(this);
        this.jgy.setOnClickListener(this);
        this.jgu.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jgB = editable;
                if (d.this.jgB.length() > 500) {
                    d.this.jgD.setText((500 - d.this.jgB.length()) + "/500");
                    d.this.jgD.setVisibility(0);
                } else {
                    d.this.jgD.setVisibility(4);
                }
                d.this.cGu();
            }
        });
        this.jgv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jgC = editable;
                if (d.this.jgC.length() > 500) {
                    d.this.jgE.setText((500 - d.this.jgC.length()) + "/500");
                    d.this.jgE.setVisibility(0);
                } else {
                    d.this.jgE.setVisibility(4);
                }
                d.this.cGu();
            }
        });
        this.jgu.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.jgu)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jgv.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.jgv)) {
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
    public void cGu() {
        if (!TextUtils.isEmpty(this.jgB) && this.jgB.length() >= 20 && !TextUtils.isEmpty(this.jgC) && this.jgC.length() >= 20 && !this.ixe.getString(R.string.select_subject).equals(this.jgq.getText()) && this.jgB.length() <= 500 && this.jgC.length() <= 500) {
            this.jfU.setAlpha(1.0f);
        } else {
            this.jfU.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.jgx, R.color.CAM_X0204);
        ap.setViewTextColor(this.jgm, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgn, R.color.CAM_X0109);
        ap.setViewTextColor(this.jgo, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgp, R.color.CAM_X0105);
        if (this.ixe.getString(R.string.select_subject).equals(this.jgq.getText())) {
            ap.setViewTextColor(this.jgq, R.color.CAM_X0109);
            SvgManager.btW().a(this.jgw, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.jgq, R.color.CAM_X0105);
            SvgManager.btW().a(this.jgw, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.jgr, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgs, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgu, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgv, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgD, R.color.CAM_X0301);
        ap.setViewTextColor(this.jgE, R.color.CAM_X0301);
        this.jgu.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.jgv.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.jgl != null) {
            this.jgl.setPlaceHolder(2);
            this.jgl.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVw) {
            cGr();
        } else if (view == this.jgy) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.ixe, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jfU) {
            if (TextUtils.isEmpty(this.jgB) || TextUtils.isEmpty(this.jgC) || this.ixe.getString(R.string.select_subject).equals(this.jgq.getText())) {
                l.showToast(this.ixe, R.string.university_comment_must_write_tip);
            } else if (this.jgB.length() < 20) {
                l.showToast(this.ixe, R.string.university_comment_size_error_tip);
            } else if (this.jgC.length() < 20) {
                l.showToast(this.ixe, R.string.subject_comment_size_error_tip);
            } else if (this.jgB.length() > 500) {
                l.showToast(this.ixe, R.string.university_comment_lenght_error_tip);
            } else if (this.jgC.length() > 500) {
                l.showToast(this.ixe, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jfW.a("学校评价：" + ((Object) this.jgB) + "\n专业评价：" + ((Object) this.jgC), cGv(), this.jfT);
            }
        }
    }

    private String cGv() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jgA.getStarCount();
        int starCount2 = this.jgz.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jgq.getText().toString(), 1));
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
                this.jgq.setText(stringExtra);
                ap.setViewTextColor(this.jgq, R.color.CAM_X0105);
                SvgManager.btW().a(this.jgw, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cGu();
            }
        }
    }

    private String dl(List<String> list) {
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
    public void bDs() {
        if (this.jfT != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jgA.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jgz.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jgq.getText().toString());
            writeData.setmUniversityComment(this.jgu.getText().toString());
            writeData.setmUniversitySubjectComment(this.jgv.getText().toString());
            y.c(String.valueOf(this.jfT.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGs() {
        if (this.jfT != null) {
            y.f(String.valueOf(this.jfT.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jgA.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jgA.setStarCount(0.0f);
                        }
                        try {
                            d.this.jgz.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jgz.setStarCount(0.0f);
                        }
                        d.this.jgq.setText(writeData.getmUniversitySubjectContent());
                        d.this.jgu.setText(writeData.getmUniversityComment());
                        d.this.jgv.setText(writeData.getmUniversitySubjectComment());
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
