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
    private Editable jgA;
    private TextView jgB;
    private TextView jgC;
    private TbImageView jgj;
    private TextView jgk;
    private TextView jgl;
    private TextView jgm;
    private TextView jgn;
    private TextView jgo;
    private TextView jgp;
    private TextView jgq;
    private TextView jgr;
    private EditText jgs;
    private EditText jgt;
    private ImageView jgu;
    private View jgv;
    private View jgw;
    private RankStarView jgx;
    private RankStarView jgy;
    private Editable jgz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ixc).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jgj = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jgk = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jgl = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.jgm = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jgn = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jgo = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.jgu = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jgp = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jgq = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jgr = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jgs = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jgs.setLineSpacing(l.getDimens(this.ixc, R.dimen.tbds16), 1.0f);
        this.jgt = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jgt.setLineSpacing(l.getDimens(this.ixc, R.dimen.tbds16), 1.0f);
        this.jgB = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jgC = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jgw = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jgx = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jgx.setClickable(true);
        this.jgx.setStarSpacing(l.getDimens(this.ixc, R.dimen.tbds24));
        this.jgy = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jgy.setClickable(true);
        this.jgy.setStarSpacing(l.getDimens(this.ixc, R.dimen.tbds24));
        this.jgv = this.mRoot.findViewById(R.id.divider);
        if (this.jfT != null) {
            this.jgl.setText(dl(this.jfT.getTags()));
            this.jgk.setText(this.jfT.getName());
            this.jgj.startLoad(this.jfT.icon_url, 10, false);
        }
        this.jgj.setPlaceHolder(2);
        this.jgj.setPageId(this.ixc.getUniqueId());
        this.jgj.setConrers(15);
        this.jgj.setRadius(l.getDimens(this.ixc, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.ixc, view);
                    return false;
                }
                return false;
            }
        });
        this.jfU.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.ixc.HidenSoftKeyPad(inputMethodManager, d.this.jgs);
                    d.this.ixc.HidenSoftKeyPad(inputMethodManager, d.this.jgt);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGp() {
        this.iVu.setOnClickListener(this);
        this.jfS.setOnClickListener(this);
        this.jgw.setOnClickListener(this);
        this.jgs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jgz = editable;
                if (d.this.jgz.length() > 500) {
                    d.this.jgB.setText((500 - d.this.jgz.length()) + "/500");
                    d.this.jgB.setVisibility(0);
                } else {
                    d.this.jgB.setVisibility(4);
                }
                d.this.cGt();
            }
        });
        this.jgt.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jgA = editable;
                if (d.this.jgA.length() > 500) {
                    d.this.jgC.setText((500 - d.this.jgA.length()) + "/500");
                    d.this.jgC.setVisibility(0);
                } else {
                    d.this.jgC.setVisibility(4);
                }
                d.this.cGt();
            }
        });
        this.jgs.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.jgs)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jgt.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.jgt)) {
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
    public void cGt() {
        if (!TextUtils.isEmpty(this.jgz) && this.jgz.length() >= 20 && !TextUtils.isEmpty(this.jgA) && this.jgA.length() >= 20 && !this.ixc.getString(R.string.select_subject).equals(this.jgo.getText()) && this.jgz.length() <= 500 && this.jgA.length() <= 500) {
            this.jfS.setAlpha(1.0f);
        } else {
            this.jfS.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.jgv, R.color.CAM_X0204);
        ap.setViewTextColor(this.jgk, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgl, R.color.CAM_X0109);
        ap.setViewTextColor(this.jgm, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgn, R.color.CAM_X0105);
        if (this.ixc.getString(R.string.select_subject).equals(this.jgo.getText())) {
            ap.setViewTextColor(this.jgo, R.color.CAM_X0109);
            SvgManager.btW().a(this.jgu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.jgo, R.color.CAM_X0105);
            SvgManager.btW().a(this.jgu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.jgp, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgq, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgr, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgs, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgt, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgB, R.color.CAM_X0301);
        ap.setViewTextColor(this.jgC, R.color.CAM_X0301);
        this.jgs.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.jgt.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.jgj != null) {
            this.jgj.setPlaceHolder(2);
            this.jgj.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVu) {
            cGq();
        } else if (view == this.jgw) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.ixc, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jfS) {
            if (TextUtils.isEmpty(this.jgz) || TextUtils.isEmpty(this.jgA) || this.ixc.getString(R.string.select_subject).equals(this.jgo.getText())) {
                l.showToast(this.ixc, R.string.university_comment_must_write_tip);
            } else if (this.jgz.length() < 20) {
                l.showToast(this.ixc, R.string.university_comment_size_error_tip);
            } else if (this.jgA.length() < 20) {
                l.showToast(this.ixc, R.string.subject_comment_size_error_tip);
            } else if (this.jgz.length() > 500) {
                l.showToast(this.ixc, R.string.university_comment_lenght_error_tip);
            } else if (this.jgA.length() > 500) {
                l.showToast(this.ixc, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jfU.a("学校评价：" + ((Object) this.jgz) + "\n专业评价：" + ((Object) this.jgA), cGu(), this.jfR);
            }
        }
    }

    private String cGu() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jgy.getStarCount();
        int starCount2 = this.jgx.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jgo.getText().toString(), 1));
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
                this.jgo.setText(stringExtra);
                ap.setViewTextColor(this.jgo, R.color.CAM_X0105);
                SvgManager.btW().a(this.jgu, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cGt();
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
        if (this.jfR != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jgy.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jgx.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jgo.getText().toString());
            writeData.setmUniversityComment(this.jgs.getText().toString());
            writeData.setmUniversitySubjectComment(this.jgt.getText().toString());
            y.c(String.valueOf(this.jfR.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGr() {
        if (this.jfR != null) {
            y.f(String.valueOf(this.jfR.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jgy.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jgy.setStarCount(0.0f);
                        }
                        try {
                            d.this.jgx.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jgx.setStarCount(0.0f);
                        }
                        d.this.jgo.setText(writeData.getmUniversitySubjectContent());
                        d.this.jgs.setText(writeData.getmUniversityComment());
                        d.this.jgt.setText(writeData.getmUniversitySubjectComment());
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
