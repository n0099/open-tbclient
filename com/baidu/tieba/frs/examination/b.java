package com.baidu.tieba.frs.examination;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
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
public class b extends a {
    private static final int esD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int esE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int esF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int esG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int esH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int esI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int esJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView esy;
    private TextView hsQ;
    private TbImageView ind;
    private TextView ine;
    private EditText inf;
    private TextView ing;
    private Editable inh;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hEa).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.ind = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.hsQ = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.ine = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.esy = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.inf = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.ing = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.ind.setPlaceHolder(2);
        this.ind.setConrers(15);
        this.ind.setRadius(l.getDimens(this.hEa, R.dimen.tbds10));
        this.esy.setStarSpacing(l.getDimens(this.hEa, R.dimen.tbds24));
        this.esy.setClickable(true);
        this.inf.setLineSpacing(l.getDimens(this.hEa, R.dimen.tbds16), 1.0f);
        if (this.imY != null) {
            setTag(this.imY.getTags());
            this.hsQ.setText(this.imY.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ind.getLayoutParams();
            if (this.imY.getIconSize() == 1.0d) {
                layoutParams.width = esD;
                layoutParams.height = esE;
            } else if (this.imY.getIconSize() == 0.67d) {
                layoutParams.width = esF;
                layoutParams.height = esG;
            } else {
                layoutParams.width = esH;
                layoutParams.height = esI;
            }
            this.ind.setLayoutParams(layoutParams);
            this.ind.startLoad(this.imY.icon_url, 10, false);
            if (this.imY.getScore() != null && this.imY.getScore().isCommented == 1) {
                this.esy.setStarCount(this.imY.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hEa, view);
                    return false;
                }
                return false;
            }
        });
        this.imZ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hEa.HidenSoftKeyPad(inputMethodManager, b.this.inf);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void ctn() {
        this.icu.setOnClickListener(this);
        this.imX.setOnClickListener(this);
        this.inf.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.inh = editable;
                if (b.this.inh.length() > 500) {
                    b.this.ing.setText(String.format(b.this.hEa.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.inh.length())));
                    b.this.ing.setVisibility(0);
                } else {
                    b.this.ing.setVisibility(8);
                }
                b.this.ctr();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void btA() {
        if (this.imW != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.esy.getStarCount());
            writeData.setOtherComment(this.inf.getText().toString());
            x.c(String.valueOf(this.imW.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void ctp() {
        if (this.imW != null) {
            x.f(String.valueOf(this.imW.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.esy.setStarCount(writeData.getOtherGrade());
                        b.this.inf.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.icu) {
            cto();
        } else if (view == this.imX) {
            if (TextUtils.isEmpty(this.inh) || this.inh.length() < 20) {
                l.showToast(this.hEa, R.string.other_comment_size_short_tip);
            } else if (this.inh.length() > 500) {
                l.showToast(this.hEa, R.string.other_comment_size_long_tip);
            } else {
                this.imZ.a(this.inh.toString(), cts(), this.imW);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.ine.setVisibility(8);
            return;
        }
        this.ine.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(esJ), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.ine.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctr() {
        if (!TextUtils.isEmpty(this.inh) && this.inh.length() >= 20 && this.inh.length() <= 500) {
            this.imX.setAlpha(1.0f);
        } else {
            this.imX.setAlpha(0.5f);
        }
    }

    private String cts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.esy.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hsQ, R.color.cp_cont_b);
        ap.setViewTextColor(this.ine, R.color.cp_cont_d);
        this.esy.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.inf, R.color.cp_cont_b);
        this.inf.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.ing, R.color.cp_cont_h);
        if (this.ind != null) {
            this.ind.setPlaceHolder(2);
            this.ind.invalidate();
        }
    }
}
