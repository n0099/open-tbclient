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
/* loaded from: classes21.dex */
public class d extends a {
    private View iVA;
    private RankStarView iVB;
    private RankStarView iVC;
    private Editable iVD;
    private Editable iVE;
    private TextView iVF;
    private TextView iVG;
    private TbImageView iVn;
    private TextView iVo;
    private TextView iVp;
    private TextView iVq;
    private TextView iVr;
    private TextView iVs;
    private TextView iVt;
    private TextView iVu;
    private TextView iVv;
    private EditText iVw;
    private EditText iVx;
    private ImageView iVy;
    private View iVz;

    public d(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.imj).inflate(R.layout.activity_university_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iVn = (TbImageView) this.mRoot.findViewById(R.id.university_icon);
        this.iVo = (TextView) this.mRoot.findViewById(R.id.university_name);
        this.iVp = (TextView) this.mRoot.findViewById(R.id.university_desc);
        this.iVq = (TextView) this.mRoot.findViewById(R.id.university_grade);
        this.iVr = (TextView) this.mRoot.findViewById(R.id.university_subject);
        this.iVs = (TextView) this.mRoot.findViewById(R.id.university_subject_content);
        this.iVy = (ImageView) this.mRoot.findViewById(R.id.subject_right_arrow);
        this.iVt = (TextView) this.mRoot.findViewById(R.id.university_subject_grade);
        this.iVu = (TextView) this.mRoot.findViewById(R.id.university_comment_title);
        this.iVv = (TextView) this.mRoot.findViewById(R.id.subject_comment_title);
        this.iVw = (EditText) this.mRoot.findViewById(R.id.university_comment);
        this.iVw.setLineSpacing(l.getDimens(this.imj, R.dimen.tbds16), 1.0f);
        this.iVx = (EditText) this.mRoot.findViewById(R.id.university_subject_comment);
        this.iVx.setLineSpacing(l.getDimens(this.imj, R.dimen.tbds16), 1.0f);
        this.iVF = (TextView) this.mRoot.findViewById(R.id.university_comment_counter);
        this.iVG = (TextView) this.mRoot.findViewById(R.id.university_subject_comment_counter);
        this.iVA = this.mRoot.findViewById(R.id.select_subject_layout);
        this.iVB = (RankStarView) this.mRoot.findViewById(R.id.university_grade_star);
        this.iVB.setClickable(true);
        this.iVB.setStarSpacing(l.getDimens(this.imj, R.dimen.tbds24));
        this.iVC = (RankStarView) this.mRoot.findViewById(R.id.university_subject_grade_star);
        this.iVC.setClickable(true);
        this.iVC.setStarSpacing(l.getDimens(this.imj, R.dimen.tbds24));
        this.iVz = this.mRoot.findViewById(R.id.divider);
        if (this.iUX != null) {
            this.iVp.setText(dh(this.iUX.getTags()));
            this.iVo.setText(this.iUX.getName());
            this.iVn.startLoad(this.iUX.icon_url, 10, false);
        }
        this.iVn.setPlaceHolder(2);
        this.iVn.setPageId(this.imj.getUniqueId());
        this.iVn.setConrers(15);
        this.iVn.setRadius(l.getDimens(this.imj, R.dimen.tbds10));
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(d.this.imj, view);
                    return false;
                }
                return false;
            }
        });
        this.iUY.a(new c.a() { // from class: com.baidu.tieba.frs.examination.d.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    d.this.imj.HidenSoftKeyPad(inputMethodManager, d.this.iVw);
                    d.this.imj.HidenSoftKeyPad(inputMethodManager, d.this.iVx);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cBW() {
        this.iKB.setOnClickListener(this);
        this.iUW.setOnClickListener(this);
        this.iVA.setOnClickListener(this);
        this.iVw.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iVD = editable;
                if (d.this.iVD.length() > 500) {
                    d.this.iVF.setText((500 - d.this.iVD.length()) + "/500");
                    d.this.iVF.setVisibility(0);
                } else {
                    d.this.iVF.setVisibility(4);
                }
                d.this.cCa();
            }
        });
        this.iVx.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.d.4
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                d.this.iVE = editable;
                if (d.this.iVE.length() > 500) {
                    d.this.iVG.setText((500 - d.this.iVE.length()) + "/500");
                    d.this.iVG.setVisibility(0);
                } else {
                    d.this.iVG.setVisibility(4);
                }
                d.this.cCa();
            }
        });
        this.iVw.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.5
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_comment && d.this.c(d.this.iVw)) {
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    if (motionEvent.getAction() == 1) {
                        view.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });
        this.iVx.setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.d.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (view.getId() == R.id.university_subject_comment && d.this.c(d.this.iVx)) {
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
    public void cCa() {
        if (!TextUtils.isEmpty(this.iVD) && this.iVD.length() >= 20 && !TextUtils.isEmpty(this.iVE) && this.iVE.length() >= 20 && !this.imj.getString(R.string.select_subject).equals(this.iVs.getText()) && this.iVD.length() <= 500 && this.iVE.length() <= 500) {
            this.iUW.setAlpha(1.0f);
        } else {
            this.iUW.setAlpha(0.5f);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.iVz, R.color.CAM_X0204);
        ap.setViewTextColor(this.iVo, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVp, R.color.CAM_X0109);
        ap.setViewTextColor(this.iVq, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVr, R.color.CAM_X0105);
        if (this.imj.getString(R.string.select_subject).equals(this.iVs.getText())) {
            ap.setViewTextColor(this.iVs, R.color.CAM_X0109);
            SvgManager.bqB().a(this.iVy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        } else {
            ap.setViewTextColor(this.iVs, R.color.CAM_X0105);
            SvgManager.bqB().a(this.iVy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        ap.setViewTextColor(this.iVt, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVu, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVv, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVw, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVx, R.color.CAM_X0105);
        ap.setViewTextColor(this.iVF, R.color.CAM_X0301);
        ap.setViewTextColor(this.iVG, R.color.CAM_X0301);
        this.iVw.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        this.iVx.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        if (this.iVn != null) {
            this.iVn.setPlaceHolder(2);
            this.iVn.invalidate();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iKB) {
            cBX();
        } else if (view == this.iVA) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new SearchMajorActivityConfig(this.imj, RequestResponseCode.REQUEST_REAL_AUTHEN)));
        } else if (view == this.iUW) {
            if (TextUtils.isEmpty(this.iVD) || TextUtils.isEmpty(this.iVE) || this.imj.getString(R.string.select_subject).equals(this.iVs.getText())) {
                l.showToast(this.imj, R.string.university_comment_must_write_tip);
            } else if (this.iVD.length() < 20) {
                l.showToast(this.imj, R.string.university_comment_size_error_tip);
            } else if (this.iVE.length() < 20) {
                l.showToast(this.imj, R.string.subject_comment_size_error_tip);
            } else if (this.iVD.length() > 500) {
                l.showToast(this.imj, R.string.university_comment_lenght_error_tip);
            } else if (this.iVE.length() > 500) {
                l.showToast(this.imj, R.string.subject_comment_lenght_error_tip);
            } else {
                this.iUY.a("学校评价：" + ((Object) this.iVD) + "\n专业评价：" + ((Object) this.iVE), cCb(), this.iUV);
            }
        }
    }

    private String cCb() {
        ArrayList arrayList = new ArrayList();
        int starCount = this.iVC.getStarCount();
        int starCount2 = this.iVB.getStarCount();
        if (starCount != 0) {
            arrayList.add(new v("学校评分", String.valueOf(starCount2), 2));
        }
        arrayList.add(new v("专业", this.iVs.getText().toString(), 1));
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
                this.iVs.setText(stringExtra);
                ap.setViewTextColor(this.iVs, R.color.CAM_X0105);
                SvgManager.bqB().a(this.iVy, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
                cCa();
            }
        }
    }

    private String dh(List<String> list) {
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
    public void bzS() {
        if (this.iUV != null) {
            WriteData writeData = new WriteData();
            int starCount = this.iVC.getStarCount();
            writeData.setmUniversityGrade(String.valueOf(this.iVB.getStarCount()));
            writeData.setmUniversitySubjectGrade(String.valueOf(starCount));
            writeData.setmUniversitySubjectContent(this.iVs.getText().toString());
            writeData.setmUniversityComment(this.iVw.getText().toString());
            writeData.setmUniversitySubjectComment(this.iVx.getText().toString());
            x.c(String.valueOf(this.iUV.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cBY() {
        if (this.iUV != null) {
            x.f(String.valueOf(this.iUV.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.d.7
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        try {
                            d.this.iVC.setStarCount(Integer.parseInt(writeData.getmUniversitySubjectGrade()));
                        } catch (NumberFormatException e) {
                            d.this.iVC.setStarCount(0.0f);
                        }
                        try {
                            d.this.iVB.setStarCount(Integer.parseInt(writeData.getmUniversityGrade()));
                        } catch (NumberFormatException e2) {
                            d.this.iVB.setStarCount(0.0f);
                        }
                        d.this.iVs.setText(writeData.getmUniversitySubjectContent());
                        d.this.iVw.setText(writeData.getmUniversityComment());
                        d.this.iVx.setText(writeData.getmUniversitySubjectComment());
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
