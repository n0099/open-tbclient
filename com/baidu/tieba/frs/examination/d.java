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
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes22.dex */
public class d extends a {
    private TbImageView iOE;
    private TextView iOF;
    private TextView iOG;
    private TextView iOH;
    private TextView iOI;
    private TextView iOJ;
    private TextView iOK;
    private TextView iOL;
    private TextView iOM;
    private EditText iON;
    private EditText iOO;
    private ImageView iOP;
    private View iOQ;
    private View iOR;
    private RankStarView iOS;
    private RankStarView iOT;
    private Editable iOU;
    private Editable iOV;
    private TextView iOW;
    private TextView iOX;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ifx).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iOE = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.iOF = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.iOG = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.iOH = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.iOI = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.iOJ = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.iOP = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.iOK = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.iOL = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.iOM = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.iON = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.iON.setLineSpacing(l.getDimens(this.ifx, R.dimen.tbds16), 1.0f);
        this.iOO = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.iOO.setLineSpacing(l.getDimens(this.ifx, R.dimen.tbds16), 1.0f);
        this.iOW = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.iOX = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.iOR = this.mRoot.findViewById(R.id.select_subject_layout);
        this.iOS = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.iOS.setClickable(true);
        this.iOS.setStarSpacing(l.getDimens(this.ifx, R.dimen.tbds24));
        this.iOT = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.iOT.setClickable(true);
        this.iOT.setStarSpacing(l.getDimens(this.ifx, R.dimen.tbds24));
        this.iOQ = this.mRoot.findViewById(R.id.divider);
        if (this.iOo != null) {
            this.iOG.setText(cZ(this.iOo.getTags()));
            this.iOF.setText(this.iOo.getName());
            this.iOE.startLoad(this.iOo.icon_url, 10, false);
        }
        this.iOE.setPlaceHolder(2);
        this.iOE.setPageId(this.ifx.getUniqueId());
        this.iOE.setConrers(15);
        this.iOE.setRadius(l.getDimens(this.ifx, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.ifx, view);
                    return false;
                }
                return false;
            }
        });
        this.iOp.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.ifx.HidenSoftKeyPad(inputMethodManager, d.this.iON);
                    d.this.ifx.HidenSoftKeyPad(inputMethodManager, d.this.iOO);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void czR() {
        this.iDR.setOnClickListener(this);
        this.iOn.setOnClickListener(this);
        this.iOR.setOnClickListener(this);
        this.iON.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iOU = editable;
                if (d.this.iOU.length() > 500) {
                    d.this.iOW.setText((500 - d.this.iOU.length()) + "/500");
                    d.this.iOW.setVisibility(0);
                } else {
                    d.this.iOW.setVisibility(4);
                }
                d.this.czV();
            }
        });
        this.iOO.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iOV = editable;
                if (d.this.iOV.length() > 500) {
                    d.this.iOX.setText((500 - d.this.iOV.length()) + "/500");
                    d.this.iOX.setVisibility(0);
                } else {
                    d.this.iOX.setVisibility(4);
                }
                d.this.czV();
            }
        });
        this.iON.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.iON)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.iOO.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.iOO)) {
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
    public void czV() {
        if (!TextUtils.isEmpty(this.iOU) && this.iOU.length() >= 20 && !TextUtils.isEmpty(this.iOV) && this.iOV.length() >= 20 && !this.ifx.getString(R.string.select_subject).equals(this.iOJ.getText()) && this.iOU.length() <= 500 && this.iOV.length() <= 500) {
            this.iOn.setAlpha(1.0f);
        } else {
            this.iOn.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.iOQ, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iOF, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOG, R.color.cp_cont_d);
        ap.setViewTextColor(this.iOH, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOI, R.color.cp_cont_b);
        if (this.ifx.getString(R.string.select_subject).equals(this.iOJ.getText())) {
            ap.setViewTextColor(this.iOJ, R.color.cp_cont_d);
            SvgManager.boN().a(this.iOP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.iOJ, R.color.cp_cont_b);
            SvgManager.boN().a(this.iOP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.iOK, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOL, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOM, R.color.cp_cont_b);
        ap.setViewTextColor(this.iON, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOO, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOW, R.color.cp_cont_h);
        ap.setViewTextColor(this.iOX, R.color.cp_cont_h);
        this.iON.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        this.iOO.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        if (this.iOE != null) {
            this.iOE.setPlaceHolder(2);
            this.iOE.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDR) {
            czS();
        } else if (view == this.iOR) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.ifx, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.iOn) {
            if (TextUtils.isEmpty(this.iOU) || TextUtils.isEmpty(this.iOV) || this.ifx.getString(R.string.select_subject).equals(this.iOJ.getText())) {
                l.showToast(this.ifx, R.string.university_comment_must_write_tip);
            } else if (this.iOU.length() < 20) {
                l.showToast(this.ifx, R.string.university_comment_size_error_tip);
            } else if (this.iOV.length() < 20) {
                l.showToast(this.ifx, R.string.subject_comment_size_error_tip);
            } else if (this.iOU.length() > 500) {
                l.showToast(this.ifx, R.string.university_comment_lenght_error_tip);
            } else if (this.iOV.length() > 500) {
                l.showToast(this.ifx, R.string.subject_comment_lenght_error_tip);
            } else {
                this.iOp.a("学校评价：" + ((Object) this.iOU) + "\n专业评价：" + ((Object) this.iOV), czW(), this.iOm);
            }
        }
    }

    private String czW() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.iOT.getStarCount();
        int starCount2 = this.iOS.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.iOJ.getText().toString(), 1));
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
                this.iOJ.setText(stringExtra);
                ap.setViewTextColor(this.iOJ, R.color.cp_cont_b);
                SvgManager.boN().a(this.iOP, R.drawable.icon_pure_list_arrow16_right_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                czV();
            }
        }
    }

    private String cZ(List<String> list) {
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
    public void byd() {
        if (this.iOm != null) {
            WriteData writeData = new WriteData();
            int starCount = this.iOT.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.iOS.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.iOJ.getText().toString());
            writeData.setmUniversityComment(this.iON.getText().toString());
            writeData.setmUniversitySubjectComment(this.iOO.getText().toString());
            x.c(String.valueOf(this.iOm.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void czT() {
        if (this.iOm != null) {
            x.f(String.valueOf(this.iOm.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.iOT.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.iOT.setStarCount(0);
                        }
                        try {
                            d.this.iOS.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.iOS.setStarCount(0);
                        }
                        d.this.iOJ.setText(writeData.getmUniversitySubjectContent());
                        d.this.iON.setText(writeData.getmUniversityComment());
                        d.this.iOO.setText(writeData.getmUniversitySubjectComment());
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
