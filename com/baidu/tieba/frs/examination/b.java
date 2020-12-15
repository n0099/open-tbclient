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
/* loaded from: classes22.dex */
public class b extends a {
    private RankStarView eZo;
    private TextView ilD;
    private TbImageView jga;
    private TextView jgb;
    private EditText jgc;
    private TextView jgd;
    private Editable jge;
    private View mDivider;
    private static final int eZw = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZx = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int eZz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int eZB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int eZC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.ixe).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jga = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.ilD = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jgb = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.mDivider = this.mRoot.findViewById(R.id.divider);
        this.eZo = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jgc = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jgd = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jga.setPlaceHolder(2);
        this.jga.setConrers(15);
        this.jga.setRadius(l.getDimens(this.ixe, R.dimen.tbds10));
        this.eZo.setStarSpacing(l.getDimens(this.ixe, R.dimen.tbds24));
        this.eZo.setClickable(true);
        this.jgc.setLineSpacing(l.getDimens(this.ixe, R.dimen.tbds16), 1.0f);
        if (this.jfV != null) {
            setTag(this.jfV.getTags());
            this.ilD.setText(this.jfV.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jga.getLayoutParams();
            if (this.jfV.getIconSize() == 1.0d) {
                layoutParams.width = eZw;
                layoutParams.height = eZx;
            } else if (this.jfV.getIconSize() == 0.67d) {
                layoutParams.width = eZy;
                layoutParams.height = eZz;
            } else {
                layoutParams.width = eZA;
                layoutParams.height = eZB;
            }
            this.jga.setLayoutParams(layoutParams);
            this.jga.startLoad(this.jfV.icon_url, 10, false);
            if (this.jfV.getScore() != null && this.jfV.getScore().isCommented == 1) {
                this.eZo.setStarCount(this.jfV.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.ixe, view);
                    return false;
                }
                return false;
            }
        });
        this.jfW.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.ixe.HidenSoftKeyPad(inputMethodManager, b.this.jgc);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGq() {
        this.iVw.setOnClickListener(this);
        this.jfU.setOnClickListener(this);
        this.jgc.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jge = editable;
                if (b.this.jge.length() > 500) {
                    b.this.jgd.setText(String.format(b.this.ixe.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jge.length())));
                    b.this.jgd.setVisibility(0);
                } else {
                    b.this.jgd.setVisibility(8);
                }
                b.this.cGu();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bDs() {
        if (this.jfT != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.eZo.getStarCount());
            writeData.setOtherComment(this.jgc.getText().toString());
            y.c(String.valueOf(this.jfT.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGs() {
        if (this.jfT != null) {
            y.f(String.valueOf(this.jfT.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void a(WriteData writeData) {
                    if (writeData != null) {
                        b.this.eZo.setStarCount(writeData.getOtherGrade());
                        b.this.jgc.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.iVw) {
            cGr();
        } else if (view == this.jfU) {
            if (TextUtils.isEmpty(this.jge) || this.jge.length() < 20) {
                l.showToast(this.ixe, R.string.other_comment_size_short_tip);
            } else if (this.jge.length() > 500) {
                l.showToast(this.ixe, R.string.other_comment_size_long_tip);
            } else {
                this.jfW.a(this.jge.toString(), cGv(), this.jfT);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jgb.setVisibility(8);
            return;
        }
        this.jgb.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(eZC), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jgb.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGu() {
        if (!TextUtils.isEmpty(this.jge) && this.jge.length() >= 20 && this.jge.length() <= 500) {
            this.jfU.setAlpha(1.0f);
        } else {
            this.jfU.setAlpha(0.5f);
        }
    }

    private String cGv() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.eZo.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
        ap.setViewTextColor(this.ilD, R.color.CAM_X0105);
        ap.setViewTextColor(this.jgb, R.color.CAM_X0109);
        this.eZo.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.jgc, R.color.CAM_X0105);
        this.jgc.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        ap.setViewTextColor(this.jgd, R.color.CAM_X0301);
        if (this.jga != null) {
            this.jga.setPlaceHolder(2);
            this.jga.invalidate();
        }
    }
}
