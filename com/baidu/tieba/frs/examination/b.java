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
    private static final int fja = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjb = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjc = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fjd = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fje = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fjf = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fjh = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private View dDI;
    private RankStarView fiS;
    private TextView ixY;
    private TbImageView jsA;
    private TextView jsB;
    private EditText jsC;
    private TextView jsD;
    private Editable jsE;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iJr).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jsA = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.ixY = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jsB = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.dDI = this.mRoot.findViewById(R.id.divider);
        this.fiS = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jsC = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jsD = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jsA.setPlaceHolder(2);
        this.jsA.setConrers(15);
        this.jsA.setRadius(l.getDimens(this.iJr, R.dimen.tbds10));
        this.fiS.setStarSpacing(l.getDimens(this.iJr, R.dimen.tbds24));
        this.fiS.setClickable(true);
        this.jsC.setLineSpacing(l.getDimens(this.iJr, R.dimen.tbds16), 1.0f);
        if (this.jsv != null) {
            setTag(this.jsv.getTags());
            this.ixY.setText(this.jsv.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jsA.getLayoutParams();
            if (this.jsv.getIconSize() == 1.0d) {
                layoutParams.width = fja;
                layoutParams.height = fjb;
            } else if (this.jsv.getIconSize() == 0.67d) {
                layoutParams.width = fjc;
                layoutParams.height = fjd;
            } else {
                layoutParams.width = fje;
                layoutParams.height = fjf;
            }
            this.jsA.setLayoutParams(layoutParams);
            this.jsA.startLoad(this.jsv.icon_url, 10, false);
            if (this.jsv.getScore() != null && this.jsv.getScore().isCommented == 1) {
                this.fiS.setStarCount(this.jsv.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.iJr, view);
                    return false;
                }
                return false;
            }
        });
        this.jsw.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.iJr.HidenSoftKeyPad(inputMethodManager, b.this.jsC);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cJp() {
        this.jhI.setOnClickListener(this);
        this.jsu.setOnClickListener(this);
        this.jsC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jsE = editable;
                if (b.this.jsE.length() > 500) {
                    b.this.jsD.setText(String.format(b.this.iJr.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jsE.length())));
                    b.this.jsD.setVisibility(0);
                } else {
                    b.this.jsD.setVisibility(8);
                }
                b.this.cJt();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bFN() {
        if (this.jst != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.fiS.getStarCount());
            writeData.setOtherComment(this.jsC.getText().toString());
            y.g(String.valueOf(this.jst.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cJr() {
        if (this.jst != null) {
            y.f(String.valueOf(this.jst.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        b.this.fiS.setStarCount(writeData.getOtherGrade());
                        b.this.jsC.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jhI) {
            cJq();
        } else if (view == this.jsu) {
            if (TextUtils.isEmpty(this.jsE) || this.jsE.length() < 20) {
                l.showToast(this.iJr, R.string.other_comment_size_short_tip);
            } else if (this.jsE.length() > 500) {
                l.showToast(this.iJr, R.string.other_comment_size_long_tip);
            } else {
                this.jsw.a(this.jsE.toString(), cJu(), this.jst);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jsB.setVisibility(8);
            return;
        }
        this.jsB.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fjh), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jsB.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJt() {
        if (!TextUtils.isEmpty(this.jsE) && this.jsE.length() >= 20 && this.jsE.length() <= 500) {
            this.jsu.setAlpha(1.0f);
        } else {
            this.jsu.setAlpha(0.5f);
        }
    }

    private String cJu() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.fiS.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
        ao.setViewTextColor(this.ixY, R.color.CAM_X0105);
        ao.setViewTextColor(this.jsB, R.color.CAM_X0109);
        this.fiS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ao.setViewTextColor(this.jsC, R.color.CAM_X0105);
        this.jsC.setHintTextColor(ao.getColor(R.color.CAM_X0109));
        ao.setViewTextColor(this.jsD, R.color.CAM_X0301);
        if (this.jsA != null) {
            this.jsA.setPlaceHolder(2);
            this.jsA.invalidate();
        }
    }
}
