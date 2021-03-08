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
import com.baidu.tieba.tbadkCore.y;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class b extends a {
    private static final int fif = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fig = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fih = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fii = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fij = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fik = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fim = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private View dCC;
    private RankStarView fhV;
    private TextView iAY;
    private TextView jvA;
    private Editable jvB;
    private TbImageView jvx;
    private TextView jvy;
    private EditText jvz;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iMq).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jvx = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.iAY = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jvy = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.dCC = this.mRoot.findViewById(R.id.divider);
        this.fhV = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jvz = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jvA = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jvx.setPlaceHolder(2);
        this.jvx.setConrers(15);
        this.jvx.setRadius(l.getDimens(this.iMq, R.dimen.tbds10));
        this.fhV.setStarSpacing(l.getDimens(this.iMq, R.dimen.tbds24));
        this.fhV.setClickable(true);
        this.jvz.setLineSpacing(l.getDimens(this.iMq, R.dimen.tbds16), 1.0f);
        if (this.jvs != null) {
            setTag(this.jvs.getTags());
            this.iAY.setText(this.jvs.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jvx.getLayoutParams();
            if (this.jvs.getIconSize() == 1.0d) {
                layoutParams.width = fif;
                layoutParams.height = fig;
            } else if (this.jvs.getIconSize() == 0.67d) {
                layoutParams.width = fih;
                layoutParams.height = fii;
            } else {
                layoutParams.width = fij;
                layoutParams.height = fik;
            }
            this.jvx.setLayoutParams(layoutParams);
            this.jvx.startLoad(this.jvs.icon_url, 10, false);
            if (this.jvs.getScore() != null && this.jvs.getScore().isCommented == 1) {
                this.fhV.setStarCount(this.jvs.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.iMq, view);
                    return false;
                }
                return false;
            }
        });
        this.jvt.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.iMq.HidenSoftKeyPad(inputMethodManager, b.this.jvz);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGY() {
        this.jkF.setOnClickListener(this);
        this.jvr.setOnClickListener(this);
        this.jvz.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jvB = editable;
                if (b.this.jvB.length() > 500) {
                    b.this.jvA.setText(String.format(b.this.iMq.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jvB.length())));
                    b.this.jvA.setVisibility(0);
                } else {
                    b.this.jvA.setVisibility(8);
                }
                b.this.cHc();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bCq() {
        if (this.jvq != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.fhV.getStarCount());
            writeData.setOtherComment(this.jvz.getText().toString());
            y.g(String.valueOf(this.jvq.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cHa() {
        if (this.jvq != null) {
            y.f(String.valueOf(this.jvq.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        b.this.fhV.setStarCount(writeData.getOtherGrade());
                        b.this.jvz.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jkF) {
            cGZ();
        } else if (view == this.jvr) {
            if (TextUtils.isEmpty(this.jvB) || this.jvB.length() < 20) {
                l.showToast(this.iMq, R.string.other_comment_size_short_tip);
            } else if (this.jvB.length() > 500) {
                l.showToast(this.iMq, R.string.other_comment_size_long_tip);
            } else {
                this.jvt.a(this.jvB.toString(), cHd(), this.jvq);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jvy.setVisibility(8);
            return;
        }
        this.jvy.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fim), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jvy.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHc() {
        if (!TextUtils.isEmpty(this.jvB) && this.jvB.length() >= 20 && this.jvB.length() <= 500) {
            this.jvr.setAlpha(1.0f);
        } else {
            this.jvr.setAlpha(0.5f);
        }
    }

    private String cHd() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.fhV.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
        ap.setViewTextColor(this.iAY, R.color.CAM_X0105);
        ap.setViewTextColor(this.jvy, R.color.CAM_X0109);
        this.fhV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.jvz, R.color.CAM_X0105);
        this.jvz.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        ap.setViewTextColor(this.jvA, R.color.CAM_X0301);
        if (this.jvx != null) {
            this.jvx.setPlaceHolder(2);
            this.jvx.invalidate();
        }
    }
}
