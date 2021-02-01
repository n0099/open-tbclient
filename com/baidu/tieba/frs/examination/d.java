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
    private TbImageView jtL;
    private TextView jtM;
    private TextView jtN;
    private TextView jtO;
    private TextView jtP;
    private TextView jtQ;
    private TextView jtR;
    private TextView jtS;
    private TextView jtT;
    private EditText jtU;
    private EditText jtV;
    private ImageView jtW;
    private View jtX;
    private View jtY;
    private RankStarView jtZ;
    private RankStarView jua;
    private Editable jub;
    private Editable juc;
    private TextView jud;
    private TextView jue;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iKt).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jtL = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.jtM = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.jtN = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.jtO = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.jtP = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.jtQ = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.jtW = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.jtR = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.jtS = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.jtT = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.jtU = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.jtU.setLineSpacing(l.getDimens(this.iKt, R.dimen.tbds16), 1.0f);
        this.jtV = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.jtV.setLineSpacing(l.getDimens(this.iKt, R.dimen.tbds16), 1.0f);
        this.jud = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.jue = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.jtY = this.mRoot.findViewById(R.id.select_subject_layout);
        this.jtZ = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.jtZ.setClickable(true);
        this.jtZ.setStarSpacing(l.getDimens(this.iKt, R.dimen.tbds24));
        this.jua = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.jua.setClickable(true);
        this.jua.setStarSpacing(l.getDimens(this.iKt, R.dimen.tbds24));
        this.jtX = this.mRoot.findViewById(R.id.divider);
        if (this.jtv != null) {
            this.jtN.setText(m33do(this.jtv.getTags()));
            this.jtM.setText(this.jtv.getName());
            this.jtL.startLoad(this.jtv.icon_url, 10, false);
        }
        this.jtL.setPlaceHolder(2);
        this.jtL.setPageId(this.iKt.getUniqueId());
        this.jtL.setConrers(15);
        this.jtL.setRadius(l.getDimens(this.iKt, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.iKt, view);
                    return false;
                }
                return false;
            }
        });
        this.jtw.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.iKt.HidenSoftKeyPad(inputMethodManager, d.this.jtU);
                    d.this.iKt.HidenSoftKeyPad(inputMethodManager, d.this.jtV);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGL() {
        this.jiI.setOnClickListener(this);
        this.jtu.setOnClickListener(this);
        this.jtY.setOnClickListener(this);
        this.jtU.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.jub = editable;
                if (d.this.jub.length() > 500) {
                    d.this.jud.setText((500 - d.this.jub.length()) + "/500");
                    d.this.jud.setVisibility(0);
                } else {
                    d.this.jud.setVisibility(4);
                }
                d.this.cGP();
            }
        });
        this.jtV.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.juc = editable;
                if (d.this.juc.length() > 500) {
                    d.this.jue.setText((500 - d.this.juc.length()) + "/500");
                    d.this.jue.setVisibility(0);
                } else {
                    d.this.jue.setVisibility(4);
                }
                d.this.cGP();
            }
        });
        this.jtU.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.e(d.this.jtU)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.jtV.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.e(d.this.jtV)) {
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
    public void cGP() {
        if (!TextUtils.isEmpty(this.jub) && this.jub.length() >= 20 && !TextUtils.isEmpty(this.juc) && this.juc.length() >= 20 && !this.iKt.getString(R.string.select_subject).equals(this.jtQ.getText()) && this.jub.length() <= 500 && this.juc.length() <= 500) {
            this.jtu.setAlpha(1.0f);
        } else {
            this.jtu.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.jtX, R.color.CAM_X0204);
        ap.setViewTextColor(this.jtM, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtN, R.color.CAM_X0109);
        ap.setViewTextColor(this.jtO, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtP, R.color.CAM_X0105);
        if (this.iKt.getString(R.string.select_subject).equals(this.jtQ.getText())) {
            ap.setViewTextColor(this.jtQ, R.color.CAM_X0109);
            SvgManager.bsR().a(this.jtW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.jtQ, R.color.CAM_X0105);
            SvgManager.bsR().a(this.jtW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.jtR, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtS, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtT, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtU, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtV, R.color.CAM_X0105);
        ap.setViewTextColor(this.jud, R.color.CAM_X0301);
        ap.setViewTextColor(this.jue, R.color.CAM_X0301);
        this.jtU.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.jtV.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.jtL != null) {
            this.jtL.setPlaceHolder(2);
            this.jtL.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiI) {
            cGM();
        } else if (view == this.jtY) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.iKt, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.jtu) {
            if (TextUtils.isEmpty(this.jub) || TextUtils.isEmpty(this.juc) || this.iKt.getString(R.string.select_subject).equals(this.jtQ.getText())) {
                l.showToast(this.iKt, R.string.university_comment_must_write_tip);
            } else if (this.jub.length() < 20) {
                l.showToast(this.iKt, R.string.university_comment_size_error_tip);
            } else if (this.juc.length() < 20) {
                l.showToast(this.iKt, R.string.subject_comment_size_error_tip);
            } else if (this.jub.length() > 500) {
                l.showToast(this.iKt, R.string.university_comment_lenght_error_tip);
            } else if (this.juc.length() > 500) {
                l.showToast(this.iKt, R.string.subject_comment_lenght_error_tip);
            } else {
                this.jtw.a("学校评价：" + ((Object) this.jub) + "\n专业评价：" + ((Object) this.juc), cGQ(), this.jtt);
            }
        }
    }

    private String cGQ() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.jua.getStarCount();
        int starCount2 = this.jtZ.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.jtQ.getText().toString(), 1));
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
                this.jtQ.setText(stringExtra);
                ap.setViewTextColor(this.jtQ, R.color.CAM_X0105);
                SvgManager.bsR().a(this.jtW, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cGP();
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
        if (this.jtt != null) {
            WriteData writeData = new WriteData();
            int starCount = this.jua.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.jtZ.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.jtQ.getText().toString());
            writeData.setmUniversityComment(this.jtU.getText().toString());
            writeData.setmUniversitySubjectComment(this.jtV.getText().toString());
            y.g(String.valueOf(this.jtt.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGN() {
        if (this.jtt != null) {
            y.f(String.valueOf(this.jtt.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.jua.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.jua.setStarCount(0.0f);
                        }
                        try {
                            d.this.jtZ.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.jtZ.setStarCount(0.0f);
                        }
                        d.this.jtQ.setText(writeData.getmUniversitySubjectContent());
                        d.this.jtU.setText(writeData.getmUniversityComment());
                        d.this.jtV.setText(writeData.getmUniversitySubjectComment());
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
