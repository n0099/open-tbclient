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
import com.baidu.tbadk.coreExtra.data.u;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.x;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class b extends a {
    private RankStarView eqt;
    private TextView hlN;
    private TbImageView igc;
    private TextView igd;
    private EditText ige;
    private TextView igf;
    private Editable igg;
    private View mDivider;
    private static final int eqy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eqB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eqD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eqE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hwW).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.igc = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.hlN = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.igd = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eqt = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.ige = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.igf = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.igc.setPlaceHolder(2);
        this.igc.setConrers(15);
        this.igc.setRadius(l.getDimens(this.hwW, R.dimen.tbds10));
        this.eqt.setStarSpacing(l.getDimens(this.hwW, R.dimen.tbds24));
        this.eqt.setClickable(true);
        this.ige.setLineSpacing(l.getDimens(this.hwW, R.dimen.tbds16), 1.0f);
        if (this.ifX != null) {
            setTag(this.ifX.getTags());
            this.hlN.setText(this.ifX.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.igc.getLayoutParams();
            if (this.ifX.getIconSize() == 1.0d) {
                layoutParams.width = eqy;
                layoutParams.height = eqz;
            } else if (this.ifX.getIconSize() == 0.67d) {
                layoutParams.width = eqA;
                layoutParams.height = eqB;
            } else {
                layoutParams.width = eqC;
                layoutParams.height = eqD;
            }
            this.igc.setLayoutParams(layoutParams);
            this.igc.startLoad(this.ifX.icon_url, 10, false);
            if (this.ifX.getScore() != null && this.ifX.getScore().isCommented == 1) {
                this.eqt.setStarCount(this.ifX.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hwW, view);
                    return false;
                }
                return false;
            }
        });
        this.ifY.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hwW.HidenSoftKeyPad(inputMethodManager, b.this.ige);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cqa() {
        this.hVu.setOnClickListener(this);
        this.ifW.setOnClickListener(this);
        this.ige.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.igg = editable;
                if (b.this.igg.length() > 500) {
                    b.this.igf.setText(String.format(b.this.hwW.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.igg.length())));
                    b.this.igf.setVisibility(0);
                } else {
                    b.this.igf.setVisibility(8);
                }
                b.this.cqe();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bsw() {
        if (this.ifV != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eqt.getStarCount());
            writeData.setOtherComment(this.ige.getText().toString());
            x.c(String.valueOf(this.ifV.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cqc() {
        if (this.ifV != null) {
            x.f(String.valueOf(this.ifV.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eqt.setStarCount(writeData.getOtherGrade());
                        b.this.ige.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hVu) {
            cqb();
        } else if (view == this.ifW) {
            if (TextUtils.isEmpty(this.igg) || this.igg.length() < 20) {
                l.showToast(this.hwW, R.string.other_comment_size_short_tip);
            } else if (this.igg.length() > 500) {
                l.showToast(this.hwW, R.string.other_comment_size_long_tip);
            } else {
                this.ifY.a(this.igg.toString(), cqf(), this.ifV);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.igd.setVisibility(8);
            return;
        }
        this.igd.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eqE), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.igd.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqe() {
        if (!TextUtils.isEmpty(this.igg) && this.igg.length() >= 20 && this.igg.length() <= 500) {
            this.ifW.setAlpha(1.0f);
        } else {
            this.ifW.setAlpha(0.5f);
        }
    }

    private String cqf() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new u("", String.valueOf(this.eqt.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hlN, R.color.cp_cont_b);
        ap.setViewTextColor(this.igd, R.color.cp_cont_d);
        this.eqt.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.ige, R.color.cp_cont_b);
        this.ige.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.igf, R.color.cp_cont_h);
        if (this.igc != null) {
            this.igc.setPlaceHolder(2);
            this.igc.invalidate();
        }
    }
}
