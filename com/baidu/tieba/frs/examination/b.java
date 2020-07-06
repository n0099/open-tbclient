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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.r;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.frs.examination.c;
import com.baidu.tieba.tbadkCore.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class b extends a {
    private static final int eaC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eaF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eaH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eaI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView eax;
    private TextView gTl;
    private TbImageView hLN;
    private TextView hLO;
    private EditText hLP;
    private TextView hLQ;
    private Editable hLR;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hep).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hLN = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.gTl = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.hLO = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eax = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.hLP = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.hLQ = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.hLN.setPlaceHolder(2);
        this.hLN.setConrers(15);
        this.hLN.setRadius(l.getDimens(this.hep, R.dimen.tbds10));
        this.eax.setStarSpacing(l.getDimens(this.hep, R.dimen.tbds24));
        this.eax.setClickable(true);
        this.hLP.setLineSpacing(l.getDimens(this.hep, R.dimen.tbds16), 1.0f);
        if (this.hLI != null) {
            setTag(this.hLI.getTags());
            this.gTl.setText(this.hLI.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hLN.getLayoutParams();
            if (this.hLI.getIconSize() == 1.0d) {
                layoutParams.width = eaC;
                layoutParams.height = eaD;
            } else if (this.hLI.getIconSize() == 0.67d) {
                layoutParams.width = eaE;
                layoutParams.height = eaF;
            } else {
                layoutParams.width = eaG;
                layoutParams.height = eaH;
            }
            this.hLN.setLayoutParams(layoutParams);
            this.hLN.startLoad(this.hLI.icon_url, 10, false);
            if (this.hLI.getScore() != null && this.hLI.getScore().isCommented == 1) {
                this.eax.setStarCount(this.hLI.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hep, view);
                    return false;
                }
                return false;
            }
        });
        this.hLJ.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hep.HidenSoftKeyPad(inputMethodManager, b.this.hLP);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cbW() {
        this.hCa.setOnClickListener(this);
        this.hLH.setOnClickListener(this);
        this.hLP.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.hLR = editable;
                if (b.this.hLR.length() > 500) {
                    b.this.hLQ.setText(String.format(b.this.hep.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.hLR.length())));
                    b.this.hLQ.setVisibility(0);
                } else {
                    b.this.hLQ.setVisibility(8);
                }
                b.this.cca();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bfY() {
        if (this.hLG != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eax.getStarCount());
            writeData.setOtherComment(this.hLP.getText().toString());
            w.c(String.valueOf(this.hLG.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cbY() {
        if (this.hLG != null) {
            w.f(String.valueOf(this.hLG.forumId), new w.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eax.setStarCount(writeData.getOtherGrade());
                        b.this.hLP.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hCa) {
            cbX();
        } else if (view == this.hLH) {
            if (TextUtils.isEmpty(this.hLR) || this.hLR.length() < 20) {
                l.showToast(this.hep, (int) R.string.other_comment_size_short_tip);
            } else if (this.hLR.length() > 500) {
                l.showToast(this.hep, (int) R.string.other_comment_size_long_tip);
            } else {
                this.hLJ.a(this.hLR.toString(), ccb(), this.hLG);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.hLO.setVisibility(8);
            return;
        }
        this.hLO.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eaI), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.hLO.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cca() {
        if (!TextUtils.isEmpty(this.hLR) && this.hLR.length() >= 20 && this.hLR.length() <= 500) {
            this.hLH.setAlpha(1.0f);
        } else {
            this.hLH.setAlpha(0.5f);
        }
    }

    private String ccb() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r("", String.valueOf(this.eax.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        an.setViewTextColor(this.gTl, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hLO, (int) R.color.cp_cont_d);
        this.eax.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        an.setViewTextColor(this.hLP, (int) R.color.cp_cont_b);
        this.hLP.setHintTextColor(an.getColor(R.color.cp_cont_d));
        an.setViewTextColor(this.hLQ, (int) R.color.cp_cont_h);
        if (this.hLN != null) {
            this.hLN.setPlaceHolder(2);
            this.hLN.invalidate();
        }
    }
}
