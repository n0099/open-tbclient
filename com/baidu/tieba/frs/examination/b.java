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
import com.baidu.tbadk.core.util.ao;
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
/* loaded from: classes16.dex */
public class b extends a {
    private static final int egN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int egQ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egR = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int egS = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int egT = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView egI;
    private TextView gYQ;
    private TbImageView hRO;
    private TextView hRP;
    private EditText hRQ;
    private TextView hRR;
    private Editable hRS;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.hjZ).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.hRO = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.gYQ = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.hRP = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.egI = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.hRQ = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.hRR = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.hRO.setPlaceHolder(2);
        this.hRO.setConrers(15);
        this.hRO.setRadius(l.getDimens(this.hjZ, R.dimen.tbds10));
        this.egI.setStarSpacing(l.getDimens(this.hjZ, R.dimen.tbds24));
        this.egI.setClickable(true);
        this.hRQ.setLineSpacing(l.getDimens(this.hjZ, R.dimen.tbds16), 1.0f);
        if (this.hRJ != null) {
            setTag(this.hRJ.getTags());
            this.gYQ.setText(this.hRJ.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hRO.getLayoutParams();
            if (this.hRJ.getIconSize() == 1.0d) {
                layoutParams.width = egN;
                layoutParams.height = egO;
            } else if (this.hRJ.getIconSize() == 0.67d) {
                layoutParams.width = egP;
                layoutParams.height = egQ;
            } else {
                layoutParams.width = egR;
                layoutParams.height = egS;
            }
            this.hRO.setLayoutParams(layoutParams);
            this.hRO.startLoad(this.hRJ.icon_url, 10, false);
            if (this.hRJ.getScore() != null && this.hRJ.getScore().isCommented == 1) {
                this.egI.setStarCount(this.hRJ.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.hjZ, view);
                    return false;
                }
                return false;
            }
        });
        this.hRK.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.hjZ.HidenSoftKeyPad(inputMethodManager, b.this.hRQ);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cfu() {
        this.hHY.setOnClickListener(this);
        this.hRI.setOnClickListener(this);
        this.hRQ.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.hRS = editable;
                if (b.this.hRS.length() > 500) {
                    b.this.hRR.setText(String.format(b.this.hjZ.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.hRS.length())));
                    b.this.hRR.setVisibility(0);
                } else {
                    b.this.hRR.setVisibility(8);
                }
                b.this.cfy();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bjJ() {
        if (this.hRH != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.egI.getStarCount());
            writeData.setOtherComment(this.hRQ.getText().toString());
            w.c(String.valueOf(this.hRH.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cfw() {
        if (this.hRH != null) {
            w.f(String.valueOf(this.hRH.forumId), new w.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.w.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.egI.setStarCount(writeData.getOtherGrade());
                        b.this.hRQ.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hHY) {
            cfv();
        } else if (view == this.hRI) {
            if (TextUtils.isEmpty(this.hRS) || this.hRS.length() < 20) {
                l.showToast(this.hjZ, R.string.other_comment_size_short_tip);
            } else if (this.hRS.length() > 500) {
                l.showToast(this.hjZ, R.string.other_comment_size_long_tip);
            } else {
                this.hRK.a(this.hRS.toString(), cfz(), this.hRH);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.hRP.setVisibility(8);
            return;
        }
        this.hRP.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(egT), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.hRP.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cfy() {
        if (!TextUtils.isEmpty(this.hRS) && this.hRS.length() >= 20 && this.hRS.length() <= 500) {
            this.hRI.setAlpha(1.0f);
        } else {
            this.hRI.setAlpha(0.5f);
        }
    }

    private String cfz() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new r("", String.valueOf(this.egI.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ao.setViewTextColor(this.gYQ, R.color.cp_cont_b);
        ao.setViewTextColor(this.hRP, R.color.cp_cont_d);
        this.egI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ao.setViewTextColor(this.hRQ, R.color.cp_cont_b);
        this.hRQ.setHintTextColor(ao.getColor(R.color.cp_cont_d));
        ao.setViewTextColor(this.hRR, R.color.cp_cont_h);
        if (this.hRO != null) {
            this.hRO.setPlaceHolder(2);
            this.hRO.invalidate();
        }
    }
}
