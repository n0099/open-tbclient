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
    private static final int eNk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eNn = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNo = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eNp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eNq = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private RankStarView eNf;
    private TextView hUh;
    private TbImageView iOt;
    private TextView iOu;
    private EditText iOv;
    private TextView iOw;
    private Editable iOx;
    private View mDivider;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ifx).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.iOt = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.hUh = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.iOu = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eNf = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.iOv = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.iOw = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.iOt.setPlaceHolder(2);
        this.iOt.setConrers(15);
        this.iOt.setRadius(l.getDimens(this.ifx, R.dimen.tbds10));
        this.eNf.setStarSpacing(l.getDimens(this.ifx, R.dimen.tbds24));
        this.eNf.setClickable(true);
        this.iOv.setLineSpacing(l.getDimens(this.ifx, R.dimen.tbds16), 1.0f);
        if (this.iOo != null) {
            setTag(this.iOo.getTags());
            this.hUh.setText(this.iOo.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iOt.getLayoutParams();
            if (this.iOo.getIconSize() == 1.0d) {
                layoutParams.width = eNk;
                layoutParams.height = eNl;
            } else if (this.iOo.getIconSize() == 0.67d) {
                layoutParams.width = eNm;
                layoutParams.height = eNn;
            } else {
                layoutParams.width = eNo;
                layoutParams.height = eNp;
            }
            this.iOt.setLayoutParams(layoutParams);
            this.iOt.startLoad(this.iOo.icon_url, 10, false);
            if (this.iOo.getScore() != null && this.iOo.getScore().isCommented == 1) {
                this.eNf.setStarCount(this.iOo.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.ifx, view);
                    return false;
                }
                return false;
            }
        });
        this.iOp.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.ifx.HidenSoftKeyPad(inputMethodManager, b.this.iOv);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void czR() {
        this.iDR.setOnClickListener(this);
        this.iOn.setOnClickListener(this);
        this.iOv.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.iOx = editable;
                if (b.this.iOx.length() > 500) {
                    b.this.iOw.setText(String.format(b.this.ifx.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.iOx.length())));
                    b.this.iOw.setVisibility(0);
                } else {
                    b.this.iOw.setVisibility(8);
                }
                b.this.czV();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void byd() {
        if (this.iOm != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eNf.getStarCount());
            writeData.setOtherComment(this.iOv.getText().toString());
            x.c(String.valueOf(this.iOm.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void czT() {
        if (this.iOm != null) {
            x.f(String.valueOf(this.iOm.forumId), new x.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.x.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eNf.setStarCount(writeData.getOtherGrade());
                        b.this.iOv.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iDR) {
            czS();
        } else if (view == this.iOn) {
            if (TextUtils.isEmpty(this.iOx) || this.iOx.length() < 20) {
                l.showToast(this.ifx, R.string.other_comment_size_short_tip);
            } else if (this.iOx.length() > 500) {
                l.showToast(this.ifx, R.string.other_comment_size_long_tip);
            } else {
                this.iOp.a(this.iOx.toString(), czW(), this.iOm);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.iOu.setVisibility(8);
            return;
        }
        this.iOu.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eNq), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.iOu.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czV() {
        if (!TextUtils.isEmpty(this.iOx) && this.iOx.length() >= 20 && this.iOx.length() <= 500) {
            this.iOn.setAlpha(1.0f);
        } else {
            this.iOn.setAlpha(0.5f);
        }
    }

    private String czW() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.eNf.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        ap.setViewTextColor(this.hUh, R.color.cp_cont_b);
        ap.setViewTextColor(this.iOu, R.color.cp_cont_d);
        this.eNf.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.iOv, R.color.cp_cont_b);
        this.iOv.setHintTextColor(ap.getColor(R.color.cp_cont_d));
        ap.setViewTextColor(this.iOw, R.color.cp_cont_h);
        if (this.iOt != null) {
            this.iOt.setPlaceHolder(2);
            this.iOt.invalidate();
        }
    }
}
