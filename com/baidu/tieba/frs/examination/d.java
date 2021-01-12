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
    private TbImageView jof;
    private TextView jog;
    private TextView joh;
    private TextView joi;
    private TextView joj;
    private TextView jok;
    private TextView jol;
    private TextView jom;
    private TextView jon;
    private EditText joo;
    private EditText jop;
    private ImageView joq;
    private View jor;
    private View jos;
    private RankStarView jot;
    private RankStarView jou;
    private Editable jov;
    private Editable jow;
    private TextView jox;
    private TextView joy;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iEK).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jof = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jog = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.joh = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.joi = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.joj = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jok = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.joq = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jol = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jom = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jon = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.joo = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.joo.setLineSpacing(l.getDimens(this.iEK, R.dimen.tbds16), 1.0f);
        this.jop = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jop.setLineSpacing(l.getDimens(this.iEK, R.dimen.tbds16), 1.0f);
        this.jox = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.joy = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jos = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jot = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jot.setClickable(true);
        this.jot.setStarSpacing(l.getDimens(this.iEK, R.dimen.tbds24));
        this.jou = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jou.setClickable(true);
        this.jou.setStarSpacing(l.getDimens(this.iEK, R.dimen.tbds24));
        this.jor = this.mRoot.findViewById(R.id.divider);
        if (this.jnP != null) {
            this.joh.setText(dt(this.jnP.getTags()));
            this.jog.setText(this.jnP.getName());
            this.jof.startLoad(this.jnP.icon_url, 10, false);
        }
        this.jof.setPlaceHolder(2);
        this.jof.setPageId(this.iEK.getUniqueId());
        this.jof.setConrers(15);
        this.jof.setRadius(l.getDimens(this.iEK, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.iEK, view);
                    return false;
                }
                return false;
            }
        });
        this.jnQ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.iEK.HidenSoftKeyPad(inputMethodManager, d.this.joo);
                    d.this.iEK.HidenSoftKeyPad(inputMethodManager, d.this.jop);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cFy() {
        this.jdb.setOnClickListener(this);
        this.jnO.setOnClickListener(this);
        this.jos.setOnClickListener(this);
        this.joo.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jov = editable;
                if (d.this.jov.length() > 500) {
                    d.this.jox.setText((500 - d.this.jov.length()) + "/500");
                    d.this.jox.setVisibility(0);
                } else {
                    d.this.jox.setVisibility(4);
                }
                d.this.cFC();
            }
        });
        this.jop.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jow = editable;
                if (d.this.jow.length() > 500) {
                    d.this.joy.setText((500 - d.this.jow.length()) + "/500");
                    d.this.joy.setVisibility(0);
                } else {
                    d.this.joy.setVisibility(4);
                }
                d.this.cFC();
            }
        });
        this.joo.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.e(d.this.joo)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jop.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.e(d.this.jop)) {
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
    public void cFC() {
        if (!TextUtils.isEmpty(this.jov) && this.jov.length() >= 20 && !TextUtils.isEmpty(this.jow) && this.jow.length() >= 20 && !this.iEK.getString(R.string.select_subject).equals(this.jok.getText()) && this.jov.length() <= 500 && this.jow.length() <= 500) {
            this.jnO.setAlpha(1.0f);
        } else {
            this.jnO.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.jor, R.color.CAM_X0204);
        ao.setViewTextColor(this.jog, R.color.CAM_X0105);
        ao.setViewTextColor(this.joh, R.color.CAM_X0109);
        ao.setViewTextColor(this.joi, R.color.CAM_X0105);
        ao.setViewTextColor(this.joj, R.color.CAM_X0105);
        if (this.iEK.getString(R.string.select_subject).equals(this.jok.getText())) {
            ao.setViewTextColor(this.jok, R.color.CAM_X0109);
            SvgManager.bsx().a(this.joq, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ao.setViewTextColor(this.jok, R.color.CAM_X0105);
            SvgManager.bsx().a(this.joq, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ao.setViewTextColor(this.jol, R.color.CAM_X0105);
        ao.setViewTextColor(this.jom, R.color.CAM_X0105);
        ao.setViewTextColor(this.jon, R.color.CAM_X0105);
        ao.setViewTextColor(this.joo, R.color.CAM_X0105);
        ao.setViewTextColor(this.jop, R.color.CAM_X0105);
        ao.setViewTextColor(this.jox, R.color.CAM_X0301);
        ao.setViewTextColor(this.joy, R.color.CAM_X0301);
        this.joo.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        this.jop.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        if (this.jof != null) {
            this.jof.setPlaceHolder(2);
            this.jof.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jdb) {
            cFz();
        } else if (view == this.jos) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.iEK, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jnO) {
            if (TextUtils.isEmpty(this.jov) || TextUtils.isEmpty(this.jow) || this.iEK.getString(R.string.select_subject).equals(this.jok.getText())) {
                l.showToast(this.iEK, R.string.university_comment_must_write_tip);
            } else if (this.jov.length() < 20) {
                l.showToast(this.iEK, R.string.university_comment_size_error_tip);
            } else if (this.jow.length() < 20) {
                l.showToast(this.iEK, R.string.subject_comment_size_error_tip);
            } else if (this.jov.length() > 500) {
                l.showToast(this.iEK, R.string.university_comment_lenght_error_tip);
            } else if (this.jow.length() > 500) {
                l.showToast(this.iEK, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jnQ.a("学校评价：" + ((Object) this.jov) + "\n专业评价：" + ((Object) this.jow), cFD(), this.jnN);
            }
        }
    }

    private String cFD() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jou.getStarCount();
        int starCount2 = this.jot.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jok.getText().toString(), 1));
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
                this.jok.setText(stringExtra);
                ao.setViewTextColor(this.jok, R.color.CAM_X0105);
                SvgManager.bsx().a(this.joq, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cFC();
            }
        }
    }

    private String dt(List<String> list) {
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
    public void bBV() {
        if (this.jnN != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jou.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jot.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jok.getText().toString());
            writeData.setmUniversityComment(this.joo.getText().toString());
            writeData.setmUniversitySubjectComment(this.jop.getText().toString());
            y.g(String.valueOf(this.jnN.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cFA() {
        if (this.jnN != null) {
            y.f(String.valueOf(this.jnN.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jou.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jou.setStarCount(0.0f);
                        }
                        try {
                            d.this.jot.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jot.setStarCount(0.0f);
                        }
                        d.this.jok.setText(writeData.getmUniversitySubjectContent());
                        d.this.joo.setText(writeData.getmUniversityComment());
                        d.this.jop.setText(writeData.getmUniversitySubjectComment());
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
