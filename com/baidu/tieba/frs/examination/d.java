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
/* loaded from: classes2.dex */
public class d extends a {
    private TbImageView jtZ;
    private TextView jua;
    private TextView jub;
    private TextView juc;
    private TextView jud;
    private TextView jue;
    private TextView juf;
    private TextView jug;
    private TextView juh;
    private EditText jui;
    private EditText juj;
    private ImageView juk;
    private View jul;
    private View jum;
    private RankStarView jun;
    private RankStarView juo;
    private Editable jup;
    private Editable juq;
    private TextView jur;
    private TextView jus;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iKH).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jtZ = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jua = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jub = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.juc = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jud = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jue = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.juk = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.juf = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jug = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.juh = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jui = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jui.setLineSpacing(l.getDimens(this.iKH, R.dimen.tbds16), 1.0f);
        this.juj = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.juj.setLineSpacing(l.getDimens(this.iKH, R.dimen.tbds16), 1.0f);
        this.jur = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jus = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jum = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jun = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jun.setClickable(true);
        this.jun.setStarSpacing(l.getDimens(this.iKH, R.dimen.tbds24));
        this.juo = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.juo.setClickable(true);
        this.juo.setStarSpacing(l.getDimens(this.iKH, R.dimen.tbds24));
        this.jul = this.mRoot.findViewById(R.id.divider);
        if (this.jtJ != null) {
            this.jub.setText(m33do(this.jtJ.getTags()));
            this.jua.setText(this.jtJ.getName());
            this.jtZ.startLoad(this.jtJ.icon_url, 10, false);
        }
        this.jtZ.setPlaceHolder(2);
        this.jtZ.setPageId(this.iKH.getUniqueId());
        this.jtZ.setConrers(15);
        this.jtZ.setRadius(l.getDimens(this.iKH, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.iKH, view);
                    return false;
                }
                return false;
            }
        });
        this.jtK.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.iKH.HidenSoftKeyPad(inputMethodManager, d.this.jui);
                    d.this.iKH.HidenSoftKeyPad(inputMethodManager, d.this.juj);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGS() {
        this.jiW.setOnClickListener(this);
        this.jtI.setOnClickListener(this);
        this.jum.setOnClickListener(this);
        this.jui.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jup = editable;
                if (d.this.jup.length() > 500) {
                    d.this.jur.setText((500 - d.this.jup.length()) + "/500");
                    d.this.jur.setVisibility(0);
                } else {
                    d.this.jur.setVisibility(4);
                }
                d.this.cGW();
            }
        });
        this.juj.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.juq = editable;
                if (d.this.juq.length() > 500) {
                    d.this.jus.setText((500 - d.this.juq.length()) + "/500");
                    d.this.jus.setVisibility(0);
                } else {
                    d.this.jus.setVisibility(4);
                }
                d.this.cGW();
            }
        });
        this.jui.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.e(d.this.jui)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.juj.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.e(d.this.juj)) {
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
    public void cGW() {
        if (!TextUtils.isEmpty(this.jup) && this.jup.length() >= 20 && !TextUtils.isEmpty(this.juq) && this.juq.length() >= 20 && !this.iKH.getString(R.string.select_subject).equals(this.jue.getText()) && this.jup.length() <= 500 && this.juq.length() <= 500) {
            this.jtI.setAlpha(1.0f);
        } else {
            this.jtI.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.jul, R.color.CAM_X0204);
        ap.setViewTextColor(this.jua, R.color.CAM_X0105);
        ap.setViewTextColor(this.jub, R.color.CAM_X0109);
        ap.setViewTextColor(this.juc, R.color.CAM_X0105);
        ap.setViewTextColor(this.jud, R.color.CAM_X0105);
        if (this.iKH.getString(R.string.select_subject).equals(this.jue.getText())) {
            ap.setViewTextColor(this.jue, R.color.CAM_X0109);
            SvgManager.bsR().a(this.juk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.jue, R.color.CAM_X0105);
            SvgManager.bsR().a(this.juk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.juf, R.color.CAM_X0105);
        ap.setViewTextColor(this.jug, R.color.CAM_X0105);
        ap.setViewTextColor(this.juh, R.color.CAM_X0105);
        ap.setViewTextColor(this.jui, R.color.CAM_X0105);
        ap.setViewTextColor(this.juj, R.color.CAM_X0105);
        ap.setViewTextColor(this.jur, R.color.CAM_X0301);
        ap.setViewTextColor(this.jus, R.color.CAM_X0301);
        this.jui.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.juj.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.jtZ != null) {
            this.jtZ.setPlaceHolder(2);
            this.jtZ.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiW) {
            cGT();
        } else if (view == this.jum) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.iKH, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jtI) {
            if (TextUtils.isEmpty(this.jup) || TextUtils.isEmpty(this.juq) || this.iKH.getString(R.string.select_subject).equals(this.jue.getText())) {
                l.showToast(this.iKH, R.string.university_comment_must_write_tip);
            } else if (this.jup.length() < 20) {
                l.showToast(this.iKH, R.string.university_comment_size_error_tip);
            } else if (this.juq.length() < 20) {
                l.showToast(this.iKH, R.string.subject_comment_size_error_tip);
            } else if (this.jup.length() > 500) {
                l.showToast(this.iKH, R.string.university_comment_lenght_error_tip);
            } else if (this.juq.length() > 500) {
                l.showToast(this.iKH, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jtK.a("学校评价：" + ((Object) this.jup) + "\n专业评价：" + ((Object) this.juq), cGX(), this.jtH);
            }
        }
    }

    private String cGX() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.juo.getStarCount();
        int starCount2 = this.jun.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jue.getText().toString(), 1));
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
                this.jue.setText(stringExtra);
                ap.setViewTextColor(this.jue, R.color.CAM_X0105);
                SvgManager.bsR().a(this.juk, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cGW();
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private String m33do(List<String> list) {
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
    public void bCn() {
        if (this.jtH != null) {
            WriteData writeData = new WriteData();
            int starCount = this.juo.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jun.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jue.getText().toString());
            writeData.setmUniversityComment(this.jui.getText().toString());
            writeData.setmUniversitySubjectComment(this.juj.getText().toString());
            y.g(String.valueOf(this.jtH.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGU() {
        if (this.jtH != null) {
            y.f(String.valueOf(this.jtH.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.juo.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.juo.setStarCount(0.0f);
                        }
                        try {
                            d.this.jun.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jun.setStarCount(0.0f);
                        }
                        d.this.jue.setText(writeData.getmUniversitySubjectContent());
                        d.this.jui.setText(writeData.getmUniversityComment());
                        d.this.juj.setText(writeData.getmUniversitySubjectComment());
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(EditText editText) {
        int scrollY = editText.getScrollY();
        int height = editText.getLayout().getHeight() - ((editText.getHeight() - editText.getCompoundPaddingTop()) - editText.getCompoundPaddingBottom());
        if (height == 0) {
            return false;
        }
        return scrollY > 0 || scrollY < height + (-1);
    }
}
