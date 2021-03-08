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
    private TbImageView jvI;
    private TextView jvJ;
    private TextView jvK;
    private TextView jvL;
    private TextView jvM;
    private TextView jvN;
    private TextView jvO;
    private TextView jvP;
    private TextView jvQ;
    private EditText jvR;
    private EditText jvS;
    private ImageView jvT;
    private View jvU;
    private View jvV;
    private RankStarView jvW;
    private RankStarView jvX;
    private Editable jvY;
    private Editable jvZ;
    private TextView jwa;
    private TextView jwb;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iMq).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jvI = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jvJ = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jvK = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.jvL = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jvM = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jvN = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.jvT = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jvO = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jvP = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jvQ = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jvR = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jvR.setLineSpacing(l.getDimens(this.iMq, R.dimen.tbds16), 1.0f);
        this.jvS = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jvS.setLineSpacing(l.getDimens(this.iMq, R.dimen.tbds16), 1.0f);
        this.jwa = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jwb = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jvV = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jvW = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jvW.setClickable(true);
        this.jvW.setStarSpacing(l.getDimens(this.iMq, R.dimen.tbds24));
        this.jvX = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jvX.setClickable(true);
        this.jvX.setStarSpacing(l.getDimens(this.iMq, R.dimen.tbds24));
        this.jvU = this.mRoot.findViewById(R.id.divider);
        if (this.jvs != null) {
            this.jvK.setText(m34do(this.jvs.getTags()));
            this.jvJ.setText(this.jvs.getName());
            this.jvI.startLoad(this.jvs.icon_url, 10, false);
        }
        this.jvI.setPlaceHolder(2);
        this.jvI.setPageId(this.iMq.getUniqueId());
        this.jvI.setConrers(15);
        this.jvI.setRadius(l.getDimens(this.iMq, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.iMq, view);
                    return false;
                }
                return false;
            }
        });
        this.jvt.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.iMq.HidenSoftKeyPad(inputMethodManager, d.this.jvR);
                    d.this.iMq.HidenSoftKeyPad(inputMethodManager, d.this.jvS);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGY() {
        this.jkF.setOnClickListener(this);
        this.jvr.setOnClickListener(this);
        this.jvV.setOnClickListener(this);
        this.jvR.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jvY = editable;
                if (d.this.jvY.length() > 500) {
                    d.this.jwa.setText((500 - d.this.jvY.length()) + "/500");
                    d.this.jwa.setVisibility(0);
                } else {
                    d.this.jwa.setVisibility(4);
                }
                d.this.cHc();
            }
        });
        this.jvS.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jvZ = editable;
                if (d.this.jvZ.length() > 500) {
                    d.this.jwb.setText((500 - d.this.jvZ.length()) + "/500");
                    d.this.jwb.setVisibility(0);
                } else {
                    d.this.jwb.setVisibility(4);
                }
                d.this.cHc();
            }
        });
        this.jvR.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.e(d.this.jvR)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jvS.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.e(d.this.jvS)) {
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
    public void cHc() {
        if (!TextUtils.isEmpty(this.jvY) && this.jvY.length() >= 20 && !TextUtils.isEmpty(this.jvZ) && this.jvZ.length() >= 20 && !this.iMq.getString(R.string.select_subject).equals(this.jvN.getText()) && this.jvY.length() <= 500 && this.jvZ.length() <= 500) {
            this.jvr.setAlpha(1.0f);
        } else {
            this.jvr.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.jvU, R.color.CAM_X0204);
        ap.setViewTextColor(this.jvJ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvK, R.color.CAM_X0109);
        ap.setViewTextColor(this.jvL, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvM, R.color.CAM_X0105);
        if (this.iMq.getString(R.string.select_subject).equals(this.jvN.getText())) {
            ap.setViewTextColor(this.jvN, R.color.CAM_X0109);
            SvgManager.bsU().a(this.jvT, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.jvN, R.color.CAM_X0105);
            SvgManager.bsU().a(this.jvT, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.jvO, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvP, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvQ, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvR, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvS, R.color.CAM_X0105);
        ap.setViewTextColor(this.jwa, R.color.CAM_X0301);
        ap.setViewTextColor(this.jwb, R.color.CAM_X0301);
        this.jvR.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.jvS.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.jvI != null) {
            this.jvI.setPlaceHolder(2);
            this.jvI.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jkF) {
            cGZ();
        } else if (view == this.jvV) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.iMq, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jvr) {
            if (TextUtils.isEmpty(this.jvY) || TextUtils.isEmpty(this.jvZ) || this.iMq.getString(R.string.select_subject).equals(this.jvN.getText())) {
                l.showToast(this.iMq, R.string.university_comment_must_write_tip);
            } else if (this.jvY.length() < 20) {
                l.showToast(this.iMq, R.string.university_comment_size_error_tip);
            } else if (this.jvZ.length() < 20) {
                l.showToast(this.iMq, R.string.subject_comment_size_error_tip);
            } else if (this.jvY.length() > 500) {
                l.showToast(this.iMq, R.string.university_comment_lenght_error_tip);
            } else if (this.jvZ.length() > 500) {
                l.showToast(this.iMq, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jvt.a("学校评价：" + ((Object) this.jvY) + "\n专业评价：" + ((Object) this.jvZ), cHd(), this.jvq);
            }
        }
    }

    private String cHd() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jvX.getStarCount();
        int starCount2 = this.jvW.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jvN.getText().toString(), 1));
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
                this.jvN.setText(stringExtra);
                ap.setViewTextColor(this.jvN, R.color.CAM_X0105);
                SvgManager.bsU().a(this.jvT, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cHc();
            }
        }
    }

    /* renamed from: do  reason: not valid java name */
    private String m34do(List<String> list) {
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
    public void bCq() {
        if (this.jvq != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jvX.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jvW.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jvN.getText().toString());
            writeData.setmUniversityComment(this.jvR.getText().toString());
            writeData.setmUniversitySubjectComment(this.jvS.getText().toString());
            y.g(String.valueOf(this.jvq.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cHa() {
        if (this.jvq != null) {
            y.f(String.valueOf(this.jvq.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jvX.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jvX.setStarCount(0.0f);
                        }
                        try {
                            d.this.jvW.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jvW.setStarCount(0.0f);
                        }
                        d.this.jvN.setText(writeData.getmUniversitySubjectContent());
                        d.this.jvR.setText(writeData.getmUniversityComment());
                        d.this.jvS.setText(writeData.getmUniversitySubjectComment());
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
