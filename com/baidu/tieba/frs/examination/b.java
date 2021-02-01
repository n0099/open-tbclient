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
    private static final int fgF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds234);
    private static final int fgI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds156);
    private static final int fgK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds208);
    private static final int fgM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds32);
    private View dBb;
    private RankStarView fgw;
    private TextView izb;
    private TbImageView jtA;
    private TextView jtB;
    private EditText jtC;
    private TextView jtD;
    private Editable jtE;

    public b(BaseFragmentActivity baseFragmentActivity, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        super(baseFragmentActivity, forumWriteData, serializableItemInfo);
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void initUI() {
        this.mRoot = LayoutInflater.from(this.iKt).inflate(R.layout.activity_other_evaluation, (ViewGroup) null);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.navigation_bar);
        this.jtA = (TbImageView) this.mRoot.findViewById(R.id.item_icon);
        this.izb = (TextView) this.mRoot.findViewById(R.id.item_title);
        this.jtB = (TextView) this.mRoot.findViewById(R.id.item_tag);
        this.dBb = this.mRoot.findViewById(R.id.divider);
        this.fgw = (RankStarView) this.mRoot.findViewById(R.id.item_star);
        this.jtC = (EditText) this.mRoot.findViewById(R.id.other_comment);
        this.jtD = (TextView) this.mRoot.findViewById(R.id.word_counter);
        this.jtA.setPlaceHolder(2);
        this.jtA.setConrers(15);
        this.jtA.setRadius(l.getDimens(this.iKt, R.dimen.tbds10));
        this.fgw.setStarSpacing(l.getDimens(this.iKt, R.dimen.tbds24));
        this.fgw.setClickable(true);
        this.jtC.setLineSpacing(l.getDimens(this.iKt, R.dimen.tbds16), 1.0f);
        if (this.jtv != null) {
            setTag(this.jtv.getTags());
            this.izb.setText(this.jtv.getName());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jtA.getLayoutParams();
            if (this.jtv.getIconSize() == 1.0d) {
                layoutParams.width = fgF;
                layoutParams.height = fgG;
            } else if (this.jtv.getIconSize() == 0.67d) {
                layoutParams.width = fgH;
                layoutParams.height = fgI;
            } else {
                layoutParams.width = fgJ;
                layoutParams.height = fgK;
            }
            this.jtA.setLayoutParams(layoutParams);
            this.jtA.startLoad(this.jtv.icon_url, 10, false);
            if (this.jtv.getScore() != null && this.jtv.getScore().isCommented == 1) {
                this.fgw.setStarCount(this.jtv.getScore().getCommentStar());
            }
        }
        this.mRoot.findViewById(R.id.scroll_view).setOnTouchListener(new View.OnTouchListener() { // from class: com.baidu.tieba.frs.examination.b.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent != null && motionEvent.getAction() == 2) {
                    l.hideSoftKeyPad(b.this.iKt, view);
                    return false;
                }
                return false;
            }
        });
        this.jtw.a(new c.a() { // from class: com.baidu.tieba.frs.examination.b.2
            @Override // com.baidu.tieba.frs.examination.c.a
            public void a(InputMethodManager inputMethodManager) {
                if (inputMethodManager != null) {
                    b.this.iKt.HidenSoftKeyPad(inputMethodManager, b.this.jtC);
                }
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    protected void cGL() {
        this.jiI.setOnClickListener(this);
        this.jtu.setOnClickListener(this);
        this.jtC.addTextChangedListener(new TextWatcher() { // from class: com.baidu.tieba.frs.examination.b.3
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                b.this.jtE = editable;
                if (b.this.jtE.length() > 500) {
                    b.this.jtD.setText(String.format(b.this.iKt.getResources().getString(R.string.frs_item_word_conter), Integer.valueOf(500 - b.this.jtE.length())));
                    b.this.jtD.setVisibility(0);
                } else {
                    b.this.jtD.setVisibility(8);
                }
                b.this.cGP();
            }
        });
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void bCn() {
        if (this.jtt != null) {
            WriteData writeData = new WriteData();
            writeData.setOtherGrade(this.fgw.getStarCount());
            writeData.setOtherComment(this.jtC.getText().toString());
            y.g(String.valueOf(this.jtt.forumId), writeData);
        }
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void cGN() {
        if (this.jtt != null) {
            y.f(String.valueOf(this.jtt.forumId), new y.a() { // from class: com.baidu.tieba.frs.examination.b.4
                @Override // com.baidu.tieba.tbadkCore.y.a
                public void b(WriteData writeData) {
                    if (writeData != null) {
                        b.this.fgw.setStarCount(writeData.getOtherGrade());
                        b.this.jtC.setText(writeData.getOtherComment());
                    }
                }
            });
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.jiI) {
            cGM();
        } else if (view == this.jtu) {
            if (TextUtils.isEmpty(this.jtE) || this.jtE.length() < 20) {
                l.showToast(this.iKt, R.string.other_comment_size_short_tip);
            } else if (this.jtE.length() > 500) {
                l.showToast(this.iKt, R.string.other_comment_size_long_tip);
            } else {
                this.jtw.a(this.jtE.toString(), cGQ(), this.jtt);
            }
        }
    }

    private void setTag(List<String> list) {
        if (list == null || list.isEmpty()) {
            this.jtB.setVisibility(8);
            return;
        }
        this.jtB.setVisibility(0);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        for (int i = 0; i < list.size(); i++) {
            spannableStringBuilder.append((CharSequence) list.get(i));
            if (i != list.size() - 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(" ");
                spannableStringBuilder2.setSpan(new com.baidu.tbadk.core.view.a.b(fgM), 0, spannableStringBuilder2.length(), 33);
                spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
            }
        }
        this.jtB.setText(spannableStringBuilder, TextView.BufferType.SPANNABLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cGP() {
        if (!TextUtils.isEmpty(this.jtE) && this.jtE.length() >= 20 && this.jtE.length() <= 500) {
            this.jtu.setAlpha(1.0f);
        } else {
            this.jtu.setAlpha(0.5f);
        }
    }

    private String cGQ() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new v("", String.valueOf(this.fgw.getStarCount()), 2));
        return this.gson.toJson(arrayList);
    }

    @Override // com.baidu.tieba.frs.examination.a
    public void onChangeSkinType() {
        super.onChangeSkinType();
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        ap.setViewTextColor(this.izb, R.color.CAM_X0105);
        ap.setViewTextColor(this.jtB, R.color.CAM_X0109);
        this.fgw.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        ap.setViewTextColor(this.jtC, R.color.CAM_X0105);
        this.jtC.setHintTextColor(ap.getColor(R.color.CAM_X0109));
        ap.setViewTextColor(this.jtD, R.color.CAM_X0301);
        if (this.jtA != null) {
            this.jtA.setPlaceHolder(2);
            this.jtA.invalidate();
        }
    }
}
