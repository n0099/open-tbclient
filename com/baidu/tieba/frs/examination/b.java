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
/* loaded from: classes22.dex */
public class b extends a {
    private static final int eSZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTa = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eTc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eTe = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eTf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView eSU;
    private TbImageView iUq;
    private TextView iUr;
    private EditText iUs;
    private TextView iUt;
    private Editable iUu;
    private TextView iae;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ilu).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iUq = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.iae = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.iUr = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eSU = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.iUs = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.iUt = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.iUq.setPlaceHolder(2);
        this.iUq.setConrers(15);
        this.iUq.setRadius(l.getDimens(this.ilu, R.dimen.tbds10));
        this.eSU.setStarSpacing(l.getDimens(this.ilu, R.dimen.tbds24));
        this.eSU.setClickable(true);
        this.iUs.setLineSpacing(l.getDimens(this.ilu, R.dimen.tbds16), 1.0f);
        if (this.iUl != null) {
            setTag(this.iUl.getTags());
            this.iae.setText(this.iUl.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iUq.getLayoutParams();
            if (this.iUl.getIconSize() == 1.0d) {
                layoutParams.width = eSZ;
                layoutParams.height = eTa;
            } else if (this.iUl.getIconSize() == 0.67d) {
                layoutParams.width = eTb;
                layoutParams.height = eTc;
            } else {
                layoutParams.width = eTd;
                layoutParams.height = eTe;
            }
            this.iUq.setLayoutParams(layoutParams);
            this.iUq.startLoad(this.iUl.icon_url, 10, false);
            if (this.iUl.getScore() != null && this.iUl.getScore().isCommented == 1) {
                this.eSU.setStarCount(this.iUl.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.ilu, view);
                    return false;
                }
                return false;
            }
        });
        this.iUm.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.ilu.HidenSoftKeyPad(inputMethodManager, b.this.iUs);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cCs() {
        this.iJO.setOnClickListener(this);
        this.iUk.setOnClickListener(this);
        this.iUs.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.iUu = editable;
                if (b.this.iUu.length() > 500) {
                    b.this.iUt.setText(String.format(b.this.ilu.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.iUu.length())));
                    b.this.iUt.setVisibility(0);
                } else {
                    b.this.iUt.setVisibility(8);
                }
                b.this.cCw();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bAC() {
        if (this.iUj != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eSU.getStarCount());
            writeData.setOtherComment(this.iUs.getText().toString());
            x.c(String.valueOf(this.iUj.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cCu() {
        if (this.iUj != null) {
            x.f(String.valueOf(this.iUj.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eSU.setStarCount(writeData.getOtherGrade());
                        b.this.iUs.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iJO) {
            cCt();
        } else if (view == this.iUk) {
            if (TextUtils.isEmpty(this.iUu) || this.iUu.length() < 20) {
                l.showToast(this.ilu, R.string.other_comment_size_short_tip);
            } else if (this.iUu.length() > 500) {
                l.showToast(this.ilu, R.string.other_comment_size_long_tip);
            } else {
                this.iUm.a(this.iUu.toString(), cCx(), this.iUj);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.iUr.setVisibility(8);
            return;
        }
        this.iUr.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eTf), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.iUr.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cCw() {
        if (!TextUtils.isEmpty(this.iUu) && this.iUu.length() >= 20 && this.iUu.length() <= 500) {
            this.iUk.setAlpha(1.0f);
        } else {
            this.iUk.setAlpha(0.5f);
        }
    }

    private String cCx() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.eSU.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.iae, R.color.cp_cont_b);
        ap.setViewTextColor(this.iUr, R.color.cp_cont_d);
        this.eSU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.iUs, R.color.cp_cont_b);
        this.iUs.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.iUt, R.color.cp_cont_h);
        if (this.iUq != null) {
            this.iUq.setPlaceHolder(2);
            this.iUq.invalidate();
        }
    }
}
